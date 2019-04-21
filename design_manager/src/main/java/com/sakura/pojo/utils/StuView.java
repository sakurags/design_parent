package com.sakura.pojo.utils;

import java.io.Serializable;
import java.util.Date;

public class StuView implements Serializable {
    private Long id;

    private Long qid;

    private String qname;

    private String tanswer;

    private String sanswer;  //学生的回答

    //    四个选项
    private Answer answer1 = new Answer();
    private Answer answer2 = new Answer();
    private Answer answer3 = new Answer();
    private Answer answer4 = new Answer();


    private Long sid;

    private String sname;

    private Double score;


    private Integer state;

    private Long pid;

    private double allScore;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getTanswer() {
        return tanswer;
    }

    public void setTanswer(String tanswer) {
        this.tanswer = tanswer;
    }

    public String getSanswer() {
        return sanswer;
    }

    public void setSanswer(String sanswer) {
        this.sanswer = sanswer;
    }

    public Answer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String str) {
        this.answer1.setAnswer(str);
        String[] split = this.tanswer.split("&");
        for (String s : split) {
            if (str.equals(s)) {
                this.answer1.setCheck(true);
                break;
            }
        }
    }

    public Answer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String str) {
        this.answer2.setAnswer(str);
        String[] split = this.tanswer.split("&");
        for (String s : split) {
            if (str.equals(s)) {
                this.answer2.setCheck(true);
                break;
            }
        }
    }

    public Answer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String str) {
        this.answer3.setAnswer(str);
        String[] split = this.tanswer.split("&");
        for (String s : split) {
            if (str.equals(s)) {
                this.answer3.setCheck(true);
                break;
            }
        }
    }

    public Answer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String str) {
        this.answer4.setAnswer(str);
        String[] split = this.tanswer.split("&");
        for (String s : split) {
            if (str.equals(s)) {
                this.answer4.setCheck(true);
                break;
            }
        }
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public double getAllScore() {
        return allScore;
    }

    public void setAllScore(double allScore) {
        this.allScore = allScore;
    }
}

