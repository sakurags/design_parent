package com.sakura.web.question;

import com.sakura.mapper.MquestionMapper;
import com.sakura.pojo.Mquestion;
import com.sakura.pojo.MquestionExample;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class MquestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private MquestionMapper mquestionMapper;

    @GetMapping("/mque/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        return questionService.gopage(pageNo, pageSize,qname,cname);
    }

    @PostMapping("/mque/add")
    public String addForm(@RequestBody Mquestion mquestion) {
        questionService.addmQustion(mquestion);
        return "1";
    }

    @GetMapping("/mque/getquebyid")
    public Mquestion getquebyid(Long id) {
       return questionService.getquebyid(id);

    }


    @DeleteMapping("/mque/delete")
    public String delete(String ids) {
       return questionService.delete(ids);

    }

    @PostMapping("/mque/addque")
    public String addque(@RequestBody PaperQue<Mquestion> paperQue){
        questionService.addque(paperQue);
        return "1";
    }


}
