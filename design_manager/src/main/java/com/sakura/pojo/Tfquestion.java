package com.sakura.pojo;

import java.io.Serializable;
import java.util.Date;

public class Tfquestion implements Serializable {
    private Long id;

    private String name;

    private String tanswer;

    private Double score;

    private Long cid;

    private String cname;

    private Date adddate;

    private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
    }

    public String getTanswer() {
        return tanswer;
    }

    public void setTanswer(String tanswer) {
        this.tanswer = tanswer == null ? null : tanswer.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }
}