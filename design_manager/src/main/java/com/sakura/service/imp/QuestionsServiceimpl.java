package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.MquestionsMapper;
import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.pojo.Mquestions;
import com.sakura.pojo.MquestionsExample;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.QuestionService;
import com.sakura.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class QuestionsServiceimpl implements QuestionsService {
    @Autowired
    private MquestionsMapper mquestionsMapper;
    @Autowired
    private PaperdetailsMapper paperdetailsMapper;
    @Override
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        EUDataGridResult result = new EUDataGridResult();
        MquestionsExample example = new MquestionsExample();
        MquestionsExample.Criteria criteria = example.createCriteria();
        if (!"".equals(qname)&&qname!=null)
            criteria.andNameLike("%"+qname+"%");
        if (!"".equals(cname)&&cname!=null)
            criteria.andCnameLike("%"+cname+"%");
        PageHelper.startPage(pageNo,pageSize);
        List<Mquestions> list = mquestionsMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo<>(list);
        result.setData(list);
        result.setCount(pageInfo.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addmQustion(Mquestions mquestions) {
        if (mquestions.getId()!=null){
            mquestionsMapper.updateByPrimaryKeySelective(mquestions);
        }else {
            mquestions.setAdddate(new Date());
            mquestionsMapper.insert(mquestions);
        }
    }

    @Override
    public Mquestions getquebyid(Long id) {
        Mquestions mquestions = mquestionsMapper.selectByPrimaryKey(id);

        return mquestions;
    }

    @Override
    public String delete(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            if (!"".equals(s))
            mquestionsMapper.deleteByPrimaryKey(Long.parseLong(s));

        }
        return "1";
    }

    @Override
    public void addque(PaperQue<Mquestions> paperQue) {
        List<Mquestions> list = paperQue.getList();
        for (Mquestions mquestion : list) {
            Paperdetails paperdetails = new Paperdetails();
            paperdetails.setQid(mquestion.getId());
            paperdetails.setName(mquestion.getName());
            paperdetails.setTanswer(mquestion.getTanswer());
            paperdetails.setFanswer(mquestion.getFanswer());
            paperdetails.setCid(mquestion.getCid());
            paperdetails.setCname(mquestion.getCname());
            paperdetails.setScore(mquestion.getScore());
            paperdetails.setAdddate(mquestion.getAdddate());
            paperdetails.setState(2);
            paperdetails.setPid(paperQue.getPid());
            paperdetails.setPname(paperQue.getPname());
            paperdetailsMapper.insert(paperdetails);

        }

    }

}
