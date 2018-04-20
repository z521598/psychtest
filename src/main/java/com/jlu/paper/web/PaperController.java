package com.jlu.paper.web;

import com.jlu.paper.bean.PaperBean;
import com.jlu.paper.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    IPaperService paperService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response, MultipartFile conclusionFilePath) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String conclusionFilePathStr = paperService.uploadFile(request, conclusionFilePath);
        PaperBean paperBean = paperService.dealPaperInfo(parameterMap);
        paperBean.setConclusionFilePath(conclusionFilePathStr);
        paperService.savePaper(paperBean);
        return "/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paper/all");
        return modelAndView;
    }

    @RequestMapping(value = "/{paperId}", method = RequestMethod.GET)
    public ModelAndView all(@PathVariable Long paperId) {
        ModelAndView modelAndView = new ModelAndView();
        PaperBean paperBean = paperService.getPaperBean(paperId);
        modelAndView.setViewName("paper/one");
        modelAndView.addObject("paperBean",paperBean);
        System.out.println(paperBean);
        return modelAndView;
    }


}
