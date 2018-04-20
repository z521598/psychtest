package com.jlu.paper.service.impl;

import com.jlu.paper.bean.PaperBean;
import com.jlu.paper.bean.QuestionBean;
import com.jlu.paper.model.Question;
import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/4/20.
 */
public class PaperServiceImplTest {

    PaperServiceImpl paperService = new PaperServiceImpl();

    @Test
    public void testDealPaperInfo() throws Exception {
        Map<String, String[]> parameterMap = new LinkedHashMap<>();
        parameterMap.put("name",new String[]{"标题"});
        parameterMap.put("guide",new String[]{"引导语"});

        parameterMap.put("question2",new String[]{"标题2"});
        parameterMap.put("question2-option0-mark",new String[]{"21"});
        parameterMap.put("question2-option0-content",new String[]{"20c"});

        parameterMap.put("question0-option0-mark",new String[]{"1"});
        parameterMap.put("question0-option0-content",new String[]{"00c"});
        parameterMap.put("question0",new String[]{"标题0"});
        parameterMap.put("question0-option1-mark",new String[]{"2"});
        parameterMap.put("question0-option1-content",new String[]{"01c"});
        parameterMap.put("question0-option2-mark",new String[]{"3"});
        parameterMap.put("question0-option2-content",new String[]{"02c"});
        parameterMap.put("question0-option3-mark",new String[]{"4"});
        parameterMap.put("question0-option3-content",new String[]{"04c"});

        parameterMap.put("question1",new String[]{"标题1"});
        parameterMap.put("question1-option0-mark",new String[]{"1"});
        parameterMap.put("question1-option0-content",new String[]{"10c"});
        parameterMap.put("question1-option1-mark",new String[]{"2"});
        parameterMap.put("question1-option1-content",new String[]{"11c"});
        parameterMap.put("question1-option2-mark",new String[]{"3"});
        parameterMap.put("question1-option2-content",new String[]{"12c"});
        parameterMap.put("question1-option3-mark",new String[]{"4"});
        parameterMap.put("question1-option3-content",new String[]{"14c"});

        PaperBean paperBean = paperService.dealPaperInfo(parameterMap);
        System.out.println(paperBean);
    }

    @Test
    public void testDealPaperInfo2() throws Exception {
        Map<String, String[]> parameterMap = new LinkedHashMap<>();
        parameterMap.put("name",new String[]{"标题"});
        parameterMap.put("guide",new String[]{"引导语"});
        parameterMap.put("question0",new String[]{"标题0"});
        parameterMap.put("question0-option0-mark",new String[]{"1"});
        parameterMap.put("question0-option0-content",new String[]{"00c"});
        parameterMap.put("question0-option1-mark",new String[]{"2"});
        parameterMap.put("question0-option1-content",new String[]{"01c"});
        parameterMap.put("question0-option2-mark",new String[]{"3"});
        parameterMap.put("question0-option2-content",new String[]{"02c"});
        parameterMap.put("question0-option3-mark",new String[]{"4"});
        parameterMap.put("question0-option3-content",new String[]{"04c"});

        parameterMap.put("question1",new String[]{"标题1"});
        parameterMap.put("question1-option0-mark",new String[]{"1"});
        parameterMap.put("question1-option0-content",new String[]{"10c"});
        parameterMap.put("question1-option1-mark",new String[]{"2"});
        parameterMap.put("question1-option1-content",new String[]{"11c"});
        parameterMap.put("question1-option2-mark",new String[]{"3"});
        parameterMap.put("question1-option2-content",new String[]{"12c"});
        parameterMap.put("question1-option3-mark",new String[]{"4"});
        parameterMap.put("question1-option3-content",new String[]{"14c"});

        paperService.dealPaperInfo(parameterMap);


    }
}