package com.sakura.pojo.utils;

import com.sakura.pojo.Teacher;

import java.util.List;

public class Ctdata {
    private Long value;
    private String label;
    private List<Tech> children;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Tech> getChildren() {
        return children;
    }

    public void setChildren(List<Tech> children) {
        this.children = children;
    }
}
