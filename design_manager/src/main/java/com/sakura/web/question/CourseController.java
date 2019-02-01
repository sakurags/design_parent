package com.sakura.web.question;

import com.sakura.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/cour")
public class CourseController {
    @Autowired
    private CourseService courseService;

@GetMapping("/courses")
    public List getCourses(){
    return courseService.getCourses();
}

@GetMapping("/ctdata")
    public List getctdata(){
    return courseService.getctdata();
}
}
