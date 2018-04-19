package com.jlu.paper.web;

import com.jlu.common.web.ResponseBean;
import com.jlu.paper.bean.PaperBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/4/19.
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean add(@RequestBody PaperBean paperBean) {

        return ResponseBean.TRUE;
    }
}
