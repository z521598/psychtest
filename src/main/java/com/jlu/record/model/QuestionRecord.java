package com.jlu.record.model;

import io.swagger.models.auth.In;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/4/20.
 */
@Entity
public class QuestionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long paperId;
    private Long questionId;
    private Long paperRecordId;
    private String name;
    private Integer orderNumber;
    private Integer optionsNumber;
    @Lob
    private String options;
    private Integer selectedOption;
    private Integer mark;

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
}
