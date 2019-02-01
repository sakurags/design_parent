package com.sakura.service.imp;

import com.sakura.mapper.StudentMapper;
import com.sakura.pojo.Student;
import com.sakura.pojo.StudentExample;
import com.sakura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public String login(String user, String password) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andStudentidEqualTo(user);
        criteria.andPasswordEqualTo(password);
        List<Student> students = studentMapper.selectByExample(example);
        if (students != null && students.size() == 1) {
            return "ok";
        }else {
            return "no";
        }


    }
}
