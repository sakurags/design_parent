package com.sakura.service;

import com.sakura.pojo.Papers;
import com.sakura.pojo.utils.EUDataGridResult;

import java.util.List;

public interface PaperService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String cname);

    void addpapers(Papers papers);

    Papers getquebyid(Long id);

    String delete(String ids);


    List getAllPaper();

    List searchpaper(String user);
}
