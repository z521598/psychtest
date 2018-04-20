package com.jlu.paper.bean;

import com.jlu.common.utils.JsonUtils;
import com.jlu.paper.model.Question;
import io.swagger.models.auth.In;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public class QuestionBean {
    private Integer index;
    private String name;
    private List<OptionBean> optionBeanList = new LinkedList<>();

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OptionBean> getOptionBeanList() {
        return optionBeanList;
    }

    public void setOptionBeanList(List<OptionBean> optionBeanList) {
        this.optionBeanList = optionBeanList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionBean{");
        sb.append("index=").append(index);
        sb.append(", name='").append(name).append('\'');
        sb.append(", optionBeanList=").append(optionBeanList);
        sb.append('}');
        return sb.toString();
    }

    public Question toQuestion(Long paperId){
        Question question = new Question();
        question.setPaperId(paperId);
        question.setName(name);
        question.setOptionsNumber(optionBeanList.size());
        optionBeanList.sort(new Comparator<OptionBean>() {
            @Override
            public int compare(OptionBean o1, OptionBean o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
        question.setOptions(JsonUtils.getJsonString(optionBeanList));
        return question;
    }
}
