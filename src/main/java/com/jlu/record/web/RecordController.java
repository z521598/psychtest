package com.jlu.record.web;

import com.jlu.common.permission.annotations.PermissionAdmin;
import com.jlu.common.utils.ExportTextUtil;
import com.jlu.common.web.ResponseBean;
import com.jlu.paper.bean.PaperBean;
import com.jlu.paper.service.IPaperService;
import com.jlu.record.bean.RecordBean;
import com.jlu.record.model.PaperRecord;
import com.jlu.record.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/20.
 */
@Controller
@RequestMapping("/record")
public class RecordController {


    @Autowired
    private IRecordService recordService;

    @RequestMapping(value = "/submit/{paperId}", method = RequestMethod.POST)
    public String submit(@PathVariable Long paperId, HttpServletRequest request) {
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        Long recordId = recordService.save(paperId, requestParameterMap);
        return "redirect:/record/" + recordId;
    }

    @RequestMapping(value = "/{recordId}", method = RequestMethod.GET)
    public ModelAndView queryOne(@PathVariable Long recordId) {
        ModelAndView modelAndView = new ModelAndView();
        RecordBean recordBean = recordService.get(recordId);
        System.out.println(recordBean);
        modelAndView.addObject("recordBean", recordBean);
        modelAndView.setViewName("/record/one");
        return modelAndView;
    }

    @RequestMapping(value = "/{recordId}/file", method = RequestMethod.GET)
    public void file(@PathVariable Long recordId, HttpServletRequest request, HttpServletResponse response) {
        RecordBean recordBean = recordService.get(recordId);
        ExportTextUtil.writeToTxt(response, recordBean.toText(), recordBean.getName()+"-"+recordBean.getNewTime());
    }

    @PermissionAdmin
    @RequestMapping(value = "/{recordId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseBean deleteOne(@PathVariable Long recordId) {
        recordService.delete(recordId);
        return ResponseBean.TRUE;
    }


    @PermissionAdmin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView queryAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<PaperRecord> recordList = recordService.getAll();
        modelAndView.addObject("records", recordList);
        modelAndView.setViewName("/record/records");
        return modelAndView;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ModelAndView queryAll(String username) {
        ModelAndView modelAndView = new ModelAndView();
        List<PaperRecord> recordList = recordService.get(username);
        modelAndView.addObject("records", recordList);
        modelAndView.setViewName("/record/records");
        return modelAndView;
    }

}
