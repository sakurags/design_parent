package com.sakura.service;

import com.sakura.pojo.Aquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;

public interface AquestionService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String cname);

    void addmQustion(Aquestion aquestion);

    Aquestion getquebyid(Long id);

    String delete(String ids);

    void addque(PaperQue<Aquestion> paperQue);
}
