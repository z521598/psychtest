package com.jlu.record.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/20.
 */
@Entity
public class PaperRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paperId;
    @Lob
    private String guide; //引导语
    private String name;
    private Date newTime;
    private String conclusionFilePath;

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

    public String getConclusionFilePath() {
        return conclusionFilePath;
    }

    public void setConclusionFilePath(String conclusionFilePath) {
        this.conclusionFilePath = conclusionFilePath;
    }
}
