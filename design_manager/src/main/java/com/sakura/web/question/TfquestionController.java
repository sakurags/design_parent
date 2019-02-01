package com.sakura.web.question;

import com.sakura.mapper.MquestionMapper;
import com.sakura.pojo.Tfquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.TfquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
public class TfquestionController {
    @Autowired
    private TfquestionService tfquestionService;
    @Autowired
    private MquestionMapper mquestionMapper;

    @GetMapping("/tfque/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        return tfquestionService.gopage(pageNo, pageSize,qname,cname);
    }

    @PostMapping("/tfque/add")
    public String addForm(@RequestBody Tfquestion tfquestion) {
        tfquestionService.addmQustion(tfquestion);
        return "1";
    }

    @GetMapping("/tfque/getquebyid")
    public Tfquestion getquebyid(Long id) {
       return tfquestionService.getquebyid(id);

    }


    @DeleteMapping("/tfque/delete")
    public String delete(String ids) {
       return tfquestionService.delete(ids);

    }

    @PostMapping("/tfque/addque")
    public String addque(@RequestBody PaperQue<Tfquestion> paperQue){
        tfquestionService.addque(paperQue);
        return "1";
    }
}
