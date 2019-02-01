package com.sakura.service;

import com.sakura.pojo.Saquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;

public interface SaquestionService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String cname);

    void addmQustion(Saquestion saquestion);

    Saquestion getquebyid(Long id);

    String delete(String ids);

    void addque(PaperQue<Saquestion> paperQue);
}
