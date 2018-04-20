package com.jlu.paper.model;

import com.jlu.common.utils.JsonUtils;
import com.jlu.paper.bean.OptionBean;
import com.jlu.paper.bean.QuestionBean;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long paperId;
    private String name;
    private Integer orderNumber;
    private Integer optionsNumber;
    /*
    [{
    "index":1,
    "content":"选项A",
    "mark":5
    },
    ...
    ]
     */
    @Lob
    private String options;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return orderNumber.equals(question.orderNumber);

    }

    @Override
    public int hashCode() {
        return orderNumber.hashCode();
    }

    public QuestionBean toQuestionBean(){
        QuestionBean questionBean = new QuestionBean();
        BeanUtils.copyProperties(this,questionBean);
        questionBean.setIndex(orderNumber);
        questionBean.setOptionBeanList(JsonUtils.getObjectByJsonString(options, new TypeReference<List<OptionBean>>() {
            @Override
            public Type getType() {
                return super.getType();
            }

            @Override
            public int compareTo(TypeReference<List<OptionBean>> o) {
                return super.compareTo(o);
            }
        }));
        return questionBean;
    }
}
