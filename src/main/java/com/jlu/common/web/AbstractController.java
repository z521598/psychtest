package com.jlu.common.web;

import com.jlu.common.exception.PsychtestRuntimeException;
import com.jlu.common.interceptor.UserLoginHelper;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by langshiquan on 18/1/10.
 */
public abstract class AbstractController {
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(
//                dateFormat, false));
//    }

    protected String getLoginUserName() {
        return UserLoginHelper.getLoginUserName();
    }

    protected void checkBindingResult(BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                sb.append(error.getDefaultMessage() + " ");
            }
            throw new PsychtestRuntimeException(sb.toString());
        }
    }
}
