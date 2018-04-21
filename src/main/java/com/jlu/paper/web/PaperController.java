package com.jlu.paper.web;

import com.jlu.common.permission.annotations.PermissionAdmin;
import com.jlu.common.utils.ExportTextUtil;
import com.jlu.common.utils.JsonUtils;
import com.jlu.common.web.ResponseBean;
import com.jlu.paper.bean.PaperBean;
import com.jlu.paper.model.Paper;
import com.jlu.paper.service.IPaperService;
import com.jlu.record.dao.IPaperRecordDao;
import com.jlu.record.service.IRecordService;
import com.jlu.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private IPaperService paperService;

    @Autowired
    private IRecordService recordService;

    @PermissionAdmin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response, MultipartFile conclusionFilePath) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String conclusionFilePathStr = paperService.uploadFile(request, conclusionFilePath);
        PaperBean paperBean = paperService.dealPaperInfo(parameterMap);
        paperBean.setConclusionFilePath(conclusionFilePathStr);
        paperService.savePaper(paperBean);
        return "redirect:/paper/all";
    }

    @PermissionAdmin
    @RequestMapping(value = "/update/{paperId}/submit", method = RequestMethod.POST)
    public String updateSubmit(@PathVariable Long paperId, HttpServletRequest request, HttpServletResponse response, MultipartFile conclusionFilePath) throws IOException {
        String conclusionFilePathStr = paperService.uploadFile(request, conclusionFilePath);
        PaperBean paperBean = paperService.dealPaperInfo(request.getParameterMap());
        paperBean.setConclusionFilePath(conclusionFilePathStr);
        paperBean.setId(paperId);
        paperService.update(paperBean);
        return "redirect:/paper/all";
    }

    @PermissionAdmin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<Paper> paperList = paperService.getAll();
        modelAndView.addObject("papers", paperList);
        modelAndView.setViewName("paper/papers");
        System.out.println(paperList);
        return modelAndView;
    }

    @RequestMapping(value = "/query/allForUser", method = RequestMethod.GET)
    public ModelAndView allForUser() {
        ModelAndView modelAndView = new ModelAndView();
        List<Paper> paperList = paperService.getAll();
        modelAndView.addObject("papers", paperList);
        modelAndView.setViewName("paper/papersForUser");
        System.out.println(paperList);
        return modelAndView;
    }

    @RequestMapping(value = "/{paperId}", method = RequestMethod.GET)
    public ModelAndView all(@PathVariable Long paperId) {
        ModelAndView modelAndView = new ModelAndView();
        PaperBean paperBean = paperService.getPaperBean(paperId);
        modelAndView.setViewName("paper/one");
        modelAndView.addObject("paperBean", paperBean);
        System.out.println(paperBean);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{paperId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long paperId) {
        ModelAndView modelAndView = new ModelAndView();
        PaperBean paperBean = paperService.getPaperBean(paperId);
        modelAndView.setViewName("paper/update");
        modelAndView.addObject("paperBean", paperBean);
        System.out.println(paperBean);
        return modelAndView;
    }

    @PermissionAdmin
    @RequestMapping(value = "/delete/{paperId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean letele(@PathVariable Long paperId) {
        paperService.delete(paperId);
        paperService.deleteQuestion(paperId);
        recordService.deleteByPaperId(paperId);
        return ResponseBean.TRUE;
    }

    @PermissionAdmin
    @RequestMapping(value = "/disable", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean disable(Long paperId, @RequestParam(defaultValue = "true") Boolean disable) {
        Paper paper = paperService.get(paperId);
        paper.setDisable(disable);
        paperService.save(paper);
        return ResponseBean.TRUE;
    }

    @RequestMapping(value = "/{paperId}/file", method = RequestMethod.GET)
    public void file(@PathVariable Long paperId, HttpServletRequest request, HttpServletResponse response) {
        PaperBean paperBean = paperService.getPaperBean(paperId);
        ExportTextUtil.writeToTxt(response, paperBean.toText(), paperBean.getName());
    }

}
