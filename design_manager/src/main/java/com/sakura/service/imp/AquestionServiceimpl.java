package com.sakura.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sakura.mapper.AquestionMapper;
import com.sakura.mapper.PaperdetailsMapper;
import com.sakura.pojo.Aquestion;
import com.sakura.pojo.AquestionExample;
import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.utils.EUDataGridResult;
import com.sakura.pojo.utils.PaperQue;
import com.sakura.service.AquestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AquestionServiceimpl implements AquestionService {
    @Autowired
    private AquestionMapper aquestionMapper;
    @Autowired
    private PaperdetailsMapper paperdetailsMapper;
    @Override
    public EUDataGridResult gopage(Integer pageNo, Integer pageSize,String qname, String cname) {
        EUDataGridResult result = new EUDataGridResult();
        AquestionExample example = new AquestionExample();
        AquestionExample.Criteria criteria = example.createCriteria();
        if (!"".equals(qname)&&qname!=null)
            criteria.andNameLike("%"+qname+"%");
        if (!"".equals(cname)&&cname!=null)
            criteria.andCnameLike("%"+cname+"%");
        PageHelper.startPage(pageNo,pageSize);
        List<Aquestion> list = aquestionMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo<>(list);
        result.setData(list);
        result.setCount(pageInfo.getTotal());
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addmQustion(Aquestion aquestion) {
        if (aquestion.getId()!=null){
            aquestionMapper.updateByPrimaryKeySelective(aquestion);
        }else {
            aquestion.setAdddate(new Date());
            aquestionMapper.insert(aquestion);
        }
    }

    @Override
    public Aquestion getquebyid(Long id) {
        Aquestion aquestion = aquestionMapper.selectByPrimaryKey(id);

        return aquestion;
    }

    @Override
    public String delete(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            if (!"".equals(s))
            aquestionMapper.deleteByPrimaryKey(Long.parseLong(s));

        }
        return "1";
    }


    @Override
    public void addque(PaperQue<Aquestion> paperQue) {
        List<Aquestion> list = paperQue.getList();
        for (Aquestion mquestion : list) {
            Paperdetails paperdetails = new Paperdetails();
            paperdetails.setQid(mquestion.getId());
            paperdetails.setName(mquestion.getName());
            paperdetails.setTanswer(mquestion.getTanswer());
            paperdetails.setCid(mquestion.getCid());
            paperdetails.setCname(mquestion.getCname());
            paperdetails.setScore(mquestion.getScore());
            paperdetails.setAdddate(mquestion.getAdddate());
            paperdetails.setState(6);
            paperdetails.setPid(paperQue.getPid());
            paperdetails.setPname(paperQue.getPname());
            paperdetailsMapper.insert(paperdetails);

        }

    }

}
