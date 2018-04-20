package com.jlu.paper.service.impl;

import com.jlu.paper.bean.OptionBean;
import com.jlu.paper.bean.PaperBean;
import com.jlu.paper.bean.QuestionBean;
import com.jlu.paper.dao.IPaperDao;
import com.jlu.paper.dao.IQuestionDao;
import com.jlu.paper.model.Paper;
import com.jlu.paper.model.Question;
import com.jlu.paper.service.IPaperService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/4/19.
 */
@Service
public class PaperServiceImpl implements IPaperService {
    private final Pattern questionNamePattern = Pattern.compile("^question\\d+$");
    private final Pattern optionMarkPattern = Pattern.compile("^question\\d+-option\\d+-mark$");
    private final Pattern optionContentPattern = Pattern.compile("^question\\d+-option\\d+-content$");
    private final Pattern numberPattern = Pattern.compile("\\d+");
    private final List<Pattern> patterns = new ArrayList<>();

    {
        patterns.add(questionNamePattern);
        patterns.add(optionContentPattern);
        patterns.add(optionContentPattern);
    }

    @Autowired
    private IPaperDao paperDao;

    @Autowired
    private IQuestionDao questionDao;

    @Override
    public PaperBean dealPaperInfo(Map<String, String[]> parameterMap) {

        System.out.println(parameterMap);
        PaperBean paperBean = new PaperBean();
        List<QuestionBean> questionList = new ArrayList<>();
        paperBean.setQuestions(questionList);

        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue()[0];
            switch (key) {
                case "name":
                    paperBean.setName(value);
                    continue;
                case "guide":
                    paperBean.setGuide(value);
                    continue;
                case "conclusionFilePath":
                    continue;
            }

            Matcher matcher = numberPattern.matcher(key);
            int number = 0;
            int questionIndex = -1;
            int optionIndex = -1;
            while (matcher.find()) {
                number++;
                if (number == 1) {
                    questionIndex = Integer.parseInt(matcher.group());
                }
                if (number == 2) {
                    optionIndex = Integer.parseInt(matcher.group());
                }

            }
            switch (number) {
                case 0:
                    // 不匹配
                    continue;
                case 1:
                    QuestionBean questionBean = getQuestionByIndex(questionList,questionIndex);
                    questionBean.setName(value);
                    break;
                case 2:
                    QuestionBean questionBean2 = getQuestionByIndex(questionList,questionIndex);
                    OptionBean optionBean = getOptionByIndex(questionBean2.getOptionBeanList(),optionIndex);
                        if (optionMarkPattern.matcher(key).find()) {
                            optionBean.setMark(Integer.parseInt(value));
                        } else if (optionContentPattern.matcher(key).find()) {
                            optionBean.setContent(value);
                        }
                    break;
            }
        }
        return paperBean;
    }

    private QuestionBean getQuestionByIndex(List<QuestionBean> questionBeanList,Integer index){
        for (QuestionBean q : questionBeanList) {
            if(q.getIndex().equals(index)){
                return q;
            }
        }
        QuestionBean q = new QuestionBean();
        q.setIndex(index);
        questionBeanList.add(q);
        return q;
    }

    private OptionBean getOptionByIndex(List<OptionBean> optionBeanList,Integer index){
        for (OptionBean o : optionBeanList) {
            if(o.getIndex().equals(index)){
                return o;
            }
        }
        OptionBean optionBean = new OptionBean();
        optionBean.setIndex(index);
        optionBeanList.add(optionBean);
        return optionBean;
    }



    @Override
    public void savePaper(PaperBean paperBean) {
        System.out.println(paperBean);
        Paper paper = paperBean.toPaper();
        paperDao.saveOrUpdate(paper);
        Long paperId = paper.getId();
        List<QuestionBean> questionBean = paperBean.getQuestions();
        questionBean.sort(new Comparator<QuestionBean>() {
            @Override
            public int compare(QuestionBean o1, QuestionBean o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
        for (int i = 0 ; i < questionBean.size() ; i++) {
            Question question = questionBean.get(i).toQuestion(paperId);
            question.setOrderNumber(i);
            questionDao.saveOrUpdate(question);
        }

    }

    @Override
    public String uploadFile(HttpServletRequest request, MultipartFile conclusionFilePath) throws IOException {
        String url = request.getSession().getServletContext().getRealPath("words");
        // 如果没有该路径，自动创建
        File floder = new File(url);
        if (!floder.exists()) {
            floder.mkdir();
        }
        if (conclusionFilePath == null) {
            return null;
        }
        // 原始文件名
        String originalFilename = conclusionFilePath.getOriginalFilename();
        // 新文件名
        String fileName = UUID.randomUUID()
                + originalFilename.substring(originalFilename
                .lastIndexOf("."));
        // 保存图片
        conclusionFilePath.transferTo(new File(url, fileName));
        return "words/" + fileName;

    }

    @Override
    public PaperBean getPaperBean(Long paperId) {
        PaperBean paperBean = new PaperBean();
        Paper paper = paperDao.findById(paperId);
        BeanUtils.copyProperties(paper,paperBean);
        List<Question> questions = questionDao.find(paperId);
        for(int i =0 ;i<questions.size() ;i++){
            paperBean.addQuestion(questions.get(i).toQuestionBean());
        }
        return paperBean;
    }
}