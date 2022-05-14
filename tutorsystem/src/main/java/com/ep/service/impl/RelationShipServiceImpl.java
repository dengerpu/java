package com.ep.service.impl;

import com.ep.domain.QuotaBean;
import com.ep.domain.Student;
import com.ep.mapper.RelationMapper;
import com.ep.service.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationShipServiceImpl implements RelationShipService {

    @Autowired
    private RelationMapper relationMapper;

    /*
    * 查找是否存在对应的老师和学生
    * */
    @Override
    public QuotaBean findRelationShip(int tid, int sid) {
        QuotaBean relationship = relationMapper.findRelationship(tid, sid);
        return relationship;
    }

    /*
    * 通过学生id删除对应关系
    * */
    @Override
    public void deleteRelationshipBySid(int sid) {
        relationMapper.deleteRelationshipBytid(sid);
    }

    /*
    * 通过sid和tid删除对应关系
    * */
    @Override
    public void deleteRelationshipBySidAndTid(int sid, int tid) {
        relationMapper.deleteRelationshipBytidAndSid(sid, tid);
    }

    /*
    * 查找老师招生名额
    * */
    @Override
    public int findTeacherQuota(int id) {
        int quotaById = relationMapper.findQuotaById(id);
        return quotaById;
    }

    @Override
    public int findAlreadyQuota(int id) {
        int alreadyQuota = relationMapper.findAlreadyQuota(id);
        return alreadyQuota;
    }

    /*
    * 保存学生和老师关系
    * */
    @Override
    public void SaveRelationShip(int tid, int sid) {
        relationMapper.saveStudentAndTutorRelationship(tid, sid);
    }

    /*
    * 查找老师辅导的学生
    * */
    @Override
    public List<Student> findMyStudent(int tid, String query, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<Student> myStudent = relationMapper.findMyStudent(tid, query, start, pagesize);
        return myStudent;
    }




}
