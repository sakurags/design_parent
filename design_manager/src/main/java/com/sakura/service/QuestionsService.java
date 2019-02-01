package com.sakura.service;

import com.sakura.pojo.Mquestion;
import com.sakura.pojo.Mquestions;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;

public interface QuestionsService {
    EUDataGridResult gopage(Integer pageNo, Integer pageSize, String qname, String cname);

    void addmQustion(Mquestions mquestions);

    Mquestions getquebyid(Long id);

    String delete(String ids);

    void addque(PaperQue<Mquestions> paperQue);
}
