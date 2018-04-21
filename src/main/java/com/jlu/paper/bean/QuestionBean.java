package com.jlu.paper.bean;

import com.jlu.common.utils.JsonUtils;
import com.jlu.paper.model.Question;

import javax.persistence.Lob;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public class QuestionBean {
    private Long id;
    private Integer index;
    private String name;
    private Integer orderNumber;
    private Integer optionsNumber;
    @Lob
    private String options;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOptionsNumber() {
        return optionsNumber;
    }

    public void setOptionsNumber(Integer optionsNumber) {
        this.optionsNumber = optionsNumber;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
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


    public Question toQuestion(Long paperId) {
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

    public OptionBean getOptionByIndex(Integer selectedIndex) {
        for (OptionBean optionBean : optionBeanList) {
            if (optionBean.getIndex().equals(selectedIndex)) {
                return optionBean;
            }
        }
        return null;
    }

    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (OptionBean optionBean : optionBeanList) {
            sb.append("\t").append(optionBean.toText()).append("\n");
        }
        return sb.toString();
    }
}
