package com.ep.service;

import com.ep.domain.QuotaBean;
import com.ep.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生老师对应业务层接口
 * */
@Service
public interface RelationShipService {

    /*
    * 保存老师和学生关系
    * */
    public void SaveRelationShip(int tid,int sid);

    /*
    * 查找用户和老师是否存在
    * */
    public QuotaBean findRelationShip(int tid,int sid);

    /*
    *通过学生sid删除关系
    * */
    public void deleteRelationshipBySid(int sid);

    /*
    * 通过sid和tid删除学生和老师关系
    * */
    public void deleteRelationshipBySidAndTid(int sid,int tid);

    /*
    * 查找老师招生名额
    * */
    public int findTeacherQuota(int id);

    /*
    * 查找老师已经招生的人数
    * */
    public int findAlreadyQuota(int id);

    /*
    * 查找老师负责的学生
    * */
    public List<Student> findMyStudent(int tid,String query, int pagenum, int pagesize);
}
