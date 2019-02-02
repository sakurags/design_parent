package com.sakura.web.paper;

import com.sakura.pojo.Papers;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.service.PaperService;
import com.sakura.service.StupaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/stupaper")
public class StuPaperController {

    @Autowired
    private StupaperService stupaperService;

    @PostMapping("/add")
    public String add(@RequestBody Map que){
        return stupaperService.adddetails(que);
    }
}
