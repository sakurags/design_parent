package com.sakura.web.question;

import com.sakura.pojo.Saquestion;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.SaquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
public class SaquestionController {
    @Autowired
    private SaquestionService saquestionService;
   
    @GetMapping("/saque/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        return saquestionService.gopage(pageNo, pageSize,qname,cname);
    }

    @PostMapping("/saque/add")
    public String addForm(@RequestBody Saquestion saquestion) {
        saquestionService.addmQustion(saquestion);
        return "1";
    }

    @GetMapping("/saque/getquebyid")
    public Saquestion getquebyid(Long id) {
       return saquestionService.getquebyid(id);

    }


    @DeleteMapping("/saque/delete")
    public String delete(String ids) {
       return saquestionService.delete(ids);

    }

    @PostMapping("/saque/addque")
    public String addque(@RequestBody PaperQue<Saquestion> paperQue){
        saquestionService.addque(paperQue);
        return "1";
    }
}
