package com.jlu.common.aop;

import com.jlu.common.aop.utils.AccessLogHelper;
import com.jlu.common.exception.PsychtestRuntimeException;
import com.jlu.common.permission.exception.ForbiddenException;
import com.jlu.common.web.ResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by langshiquan on 18/1/28.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {


    // 403
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView forbiddenExceptionHandler(ForbiddenException fbex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("403");
        modelAndView.addObject("msg", fbex.getMessage());
        return modelAndView;
    }

    // 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseBean httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException hmnr) {
        return ResponseBean.fail("请求参数格式有误");
    }

    // 400
    @ExceptionHandler(PsychtestRuntimeException.class)
    @ResponseBody
    public ModelAndView pipelineRuntimeExceptionHandler(PsychtestRuntimeException pre) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400");
        modelAndView.addObject("msg", pre.getMessage());
        return modelAndView;
    }

    // 500
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        AccessLogHelper.logAccessErrorOut(request, response, e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("500");
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;
    }

}
