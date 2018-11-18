package com.service;

import com.cache.CacheInterFace;
import com.mapper.ExcellentMapper;
import com.model.Excellent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExcellentServiceImpl implements ExcellentService {
    @Autowired
    CacheInterFace interFace;
    @Autowired
    ExcellentMapper excellentMapper;

    Logger logger = Logger.getLogger(ExcellentServiceImpl.class);

    @Override
    public List<Excellent> show() {
        return null;
    }

    @Override
    public Boolean add(Excellent excellent) {
        if (excellentMapper.add(excellent)) {
            String id = String.valueOf(excellent.getId());
            return interFace.add(id, excellent);
        } else {
            return false;
        }
    }

    @Override
    public Boolean update(Excellent excellent) {
        if (excellentMapper.update(excellent)) {
            return interFace.update(String.valueOf(excellent.getId()), excellent);
        } else {
            return false;
        }
    }

    /**
     * 查询单条数据
     *
     * @param id
     * @return
     */


    @Override
    public Excellent showOne(long id) {
        Excellent excellent = (Excellent) interFace.selectOne(String.valueOf(id));
        if (excellent != null) {
            return excellent;
        } else {
            System.out.println("从数据库中取值");
            excellent = excellentMapper.showOne(id);
            interFace.add(String.valueOf(id), excellent);
            return excellent;
        }
    }

    @Override
    public Boolean delete(long id) {
        if (excellentMapper.delete(id)) {
            interFace.delete(String.valueOf(id));
            return true;
        } else {
            return false;
        }
    }
}
