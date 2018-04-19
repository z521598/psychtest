package com.jlu.paper.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/4/19.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long paperId;
    private Integer optionsNumber;
    /*
    [{
    "option":"A",
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
}
