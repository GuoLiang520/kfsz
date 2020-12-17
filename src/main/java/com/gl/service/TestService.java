package com.gl.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gl.dao.EajDao;
import com.gl.entity.Eaj;
import com.gl.mapper.EajMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author 郭亮
 * @date 2020/9/23 10:00 
 **/
@Service
public class TestService {

    @Autowired
    private EajMapper eajMapper;

    @Autowired
    private EajDao eajDao;

    public Eaj getEaj(String ahdm){
        return eajMapper.getEaj(ahdm);
    }

    @Transactional(transactionManager = "platformTransactionManager",rollbackFor = Exception.class)
    public void insertEaj() {
        Eaj eaj = new Eaj();
        eaj.setAh("1");
        eaj.setAhdm("1");

        Eaj eaj1 = new Eaj();
        eaj1.setAh("2");
        eaj1.setAhdm("2");
        eajMapper.insertEaj(eaj);
        eajMapper.insertEaj(eaj1);
    }

    public void getByNd(){
        Page<Eaj> page = PageHelper.startPage(2, 3);
        eajMapper.getEajByNd();
        List<Eaj> result = page.getResult();
        System.out.println(page.getTotal());
        result.forEach(eaj -> System.out.println(eaj));
    }

    @Transactional(value = "jpaPlatformTransactionManager",rollbackFor = Exception.class)
    public void saveJpa() {
        Eaj eaj = new Eaj();
        eaj.setAh("1");
        eaj.setAhdm("1");
        eaj.setJzxh("1");
        Eaj eaj1 = new Eaj();
        eaj1.setAh("2");
        eaj1.setAhdm("2");
        eaj1.setJzxh("1");
        eajDao.save(eaj);
        eajDao.save(eaj1);
    }

    public Eaj getJpa(String ahdm) {
        Optional<Eaj> byId = eajDao.findById(ahdm);
        return byId.get();
    }

}
