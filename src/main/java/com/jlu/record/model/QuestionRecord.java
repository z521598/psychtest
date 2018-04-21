package com.jlu.record.model;

import com.jlu.common.utils.JsonUtils;
import com.jlu.paper.bean.OptionBean;
import com.jlu.record.bean.QuestionRecordBean;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
@Entity
public class QuestionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Long paperId;
    @Deprecated
    protected Long questionId;
    protected Long paperRecordId;

    protected Integer questionIndex;
    protected String name;
    protected Integer orderNumber;
    protected Integer optionsNumber;
    @Lob
    protected String options;

    protected Integer selectedOption;
    protected Integer mark;

    public Integer getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(Integer questionIndex) {
        this.questionIndex = questionIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getPaperRecordId() {
        return paperRecordId;
    }

    public void setPaperRecordId(Long paperRecordId) {
        this.paperRecordId = paperRecordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(Integer selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionRecord{");
        sb.append("id=").append(id);
        sb.append(", paperId=").append(paperId);
        sb.append(", questionId=").append(questionId);
        sb.append(", paperRecordId=").append(paperRecordId);
        sb.append(", questionIndex=").append(questionIndex);
        sb.append(", name='").append(name).append('\'');
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", optionsNumber=").append(optionsNumber);
        sb.append(", options='").append(options).append('\'');
        sb.append(", selectedOption=").append(selectedOption);
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }

    public QuestionRecordBean toBean(){
        QuestionRecordBean questionRecordBean = new QuestionRecordBean();
        BeanUtils.copyProperties(this,questionRecordBean);
        questionRecordBean.setOptionBeanList(JsonUtils.getObjectByJsonString(options, new TypeReference<List<OptionBean>>() {
            @Override
            public Type getType() {
                return super.getType();
            }

            @Override
            public int compareTo(TypeReference<List<OptionBean>> o) {
                return super.compareTo(o);
            }
        }));
        return questionRecordBean;
    }
}
