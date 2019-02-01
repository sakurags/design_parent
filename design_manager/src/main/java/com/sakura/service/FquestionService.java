package com.sakura.service;

import com.sakura.pojo.Fquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;

public interface FquestionService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String cname);

    void addmQustion(Fquestion fquestion);

    Fquestion getquebyid(Long id);

    String delete(String ids);

    void addque(PaperQue<Fquestion> paperQue);
}
