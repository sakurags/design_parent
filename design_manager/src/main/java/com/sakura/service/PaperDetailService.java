package com.sakura.service;

import com.sakura.pojo.Mquestion;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;

import java.util.List;

public interface PaperDetailService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String cname, Long pid);

    void addpaperdetails(Paperdetails paperdetails);

    Paperdetails getquebyid(Long id);

    String delete(String ids);


    List getpaperdetaile(Long paperid);
}
