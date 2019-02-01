package com.sakura.web.paper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sakura.mapper.MquestionMapper;
import com.sakura.pojo.Mquestion;
import com.sakura.pojo.Papers;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class PaperController {
    @Autowired
    private PaperService paperService;
   
    @GetMapping("/paper/page")
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        return paperService.gopage(pageNo, pageSize,qname,cname);
    }

    @PostMapping("/paper/add")
    public String addForm(@RequestBody Papers papers) {
        paperService.addpapers(papers);
        return "1";
    }

    @GetMapping("/paper/getquebyid")
    public Papers getquebyid(Long id) {
       return paperService.getquebyid(id);

    }


    @DeleteMapping("/paper/delete")
    public String delete(String ids) {
       return paperService.delete(ids);

    }

    @GetMapping("/paper/getallpaper")
    public List getAllPaper() {
        return paperService.getAllPaper();
    }

    @GetMapping("/paper/searchpaper")
    public List searchpaper(String user) {
       return paperService.searchpaper(user);
    }

}
