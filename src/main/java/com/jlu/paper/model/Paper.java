package com.jlu.paper.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/19.
 */
@Entity
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String guide; //引导语
    private String name;
    private Date newTime;
    private Boolean disable;
    private String conclusionFilePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
        this.newTime = newTime;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public String getConclusionFilePath() {
        return conclusionFilePath;
    }

    public void setConclusionFilePath(String conclusionFilePath) {
        this.conclusionFilePath = conclusionFilePath;
    }
}
