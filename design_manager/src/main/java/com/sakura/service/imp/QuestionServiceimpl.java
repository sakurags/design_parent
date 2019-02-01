package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.MquestionMapper;
import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.pojo.Mquestion;
import com.sakura.pojo.MquestionExample;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceimpl implements QuestionService {
    @Autowired
    private MquestionMapper mquestionMapper;
    @Autowired
    private PaperdetailsMapper paperdetailsMapper;

    @Override
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        EUDataGridResult result = new EUDataGridResult();
        MquestionExample example = new MquestionExample();
        MquestionExample.Criteria criteria = example.createCriteria();
        if (!"".equals(qname)&&qname!=null)
            criteria.andNameLike("%"+qname+"%");
        if (!"".equals(cname)&&cname!=null)
            criteria.andCnameLike("%"+cname+"%");
        PageHelper.startPage(pageNo,pageSize);
        List<Mquestion> list = mquestionMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo<>(list);
        result.setData(list);
        result.setCount(pageInfo.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addmQustion(Mquestion mquestion) {
        if (mquestion.getId()!=null){
            mquestionMapper.updateByPrimaryKeySelective(mquestion);
        }else {
            mquestion.setAdddate(new Date());
            mquestionMapper.insert(mquestion);
        }
    }

    @Override
    public Mquestion getquebyid(Long id) {
        Mquestion mquestion = mquestionMapper.selectByPrimaryKey(id);

        return mquestion;
    }

    @Override
    public String delete(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            if (!"".equals(s))
            mquestionMapper.deleteByPrimaryKey(Long.parseLong(s));

        }
        return "1";
    }

    @Override
    public void addque(PaperQue<Mquestion> paperQue) {
        List<Mquestion> list = paperQue.getList();
        for (Mquestion mquestion : list) {
            Paperdetails paperdetails = new Paperdetails();
            paperdetails.setQid(mquestion.getId());
            paperdetails.setName(mquestion.getName());
            paperdetails.setTanswer(mquestion.getTanswer());
            paperdetails.setFanswer(mquestion.getFanswer());
            paperdetails.setCid(mquestion.getCid());
            paperdetails.setCname(mquestion.getCname());
            paperdetails.setScore(mquestion.getScore());
            paperdetails.setAdddate(mquestion.getAdddate());
            paperdetails.setState(1);
            paperdetails.setPid(paperQue.getPid());
            paperdetails.setPname(paperQue.getPname());
            paperdetailsMapper.insert(paperdetails);

        }

    }

}
