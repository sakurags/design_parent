package com.sakura.service.imp;

import com.sakura.mapper.CourseMapper;
import com.sakura.mapper.CtmidMapper;
import com.sakura.mapper.TeacherMapper;
import com.sakura.pojo.*;
import com.sakura.pojo.utils.Ctdata;
import com.sakura.pojo.utils.Tech;
import com.sakura.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CtmidMapper ctmidMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List getCourses() {
        CourseExample example = new CourseExample();
        List<Course> courseList = courseMapper.selectByExample(example);
        return courseList;
    }

    @Override
    public List getctdata() {
//先查出所有的课程
        CourseExample example = new CourseExample();
        List<Course> courseList = courseMapper.selectByExample(example);
        List<Ctdata> ctdatalist = new ArrayList<>();
        for (Course course:courseList) {
            Ctdata ctdata = new Ctdata();
            ctdata.setValue(course.getId());
            ctdata.setLabel(course.getName());

            CtmidExample ctmidExample = new CtmidExample();
            ctmidExample.createCriteria().andCidEqualTo(course.getId());
            List<Ctmid> ctmidList = ctmidMapper.selectByExample(ctmidExample);
            List<Tech> list = new ArrayList<>();
            for (Ctmid ctmid : ctmidList) {
                Tech tech = new Tech();
                Teacher teacher = teacherMapper.selectByPrimaryKey(ctmid.getTid());
                tech.setValue(teacher.getId());
                tech.setLabel(teacher.getName());
                list.add(tech);
            }
            ctdata.setChildren(list);
            ctdatalist.add(ctdata);
        }


        return ctdatalist;
    }
}
