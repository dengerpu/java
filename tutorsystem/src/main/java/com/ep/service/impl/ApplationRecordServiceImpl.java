package com.ep.service.impl;

import com.ep.domain.ApplationRecord;
import com.ep.mapper.ApplationMapper;
import com.ep.service.ApplationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplationRecordServiceImpl implements ApplationRecordService {

    @Autowired
    private ApplationMapper applationMapper;

    @Override
    public List<ApplationRecord> findAllRecord(int tid, int pagenum, int pagesize) {
        int start = (pagenum-1)*pagesize;  //pagenum，第几页，pagesize每页的大小
        List<ApplationRecord> allReocrd = applationMapper.findAllReocrd(tid, start, pagesize);
        return allReocrd;
    }

    @Override
    public int findTotal() {
        int allRecordTotal = applationMapper.findAllRecordTotal();
        return allRecordTotal;
    }

    @Override
    public ApplationRecord findRecordBySid(int sid) {
        ApplationRecord recordBySid = applationMapper.findRecordBySid(sid);
        return recordBySid;
    }

    @Override
    public ApplationRecord findRecordBySidAndTid(int tid, int sid) {
        ApplationRecord recordBySidAndTid = applationMapper.findRecordBySidAndTid(tid, sid);
        return recordBySidAndTid;
    }

    @Override
    public void deletRecord(int id) {
        applationMapper.deleteRecordByid(id);
    }

    @Override
    public void SaveRecord(ApplationRecord record) {
        applationMapper.saveRecord(record);
    }

    /*
    * 更新记录
    * */
    @Override
    public void UpdateRecord(ApplationRecord record) {
        applationMapper.UpdateRecord(record);
    }
}
