package com.ep.service;

import com.ep.domain.ApplationRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplationRecordService {

    /*
     *
     * 查找所有申请记录
     * */
    public  List<ApplationRecord> findAllRecord(int tid,int pagenum, int pagesize);

    /*
    * 查找总记录数
    * */
    public int findTotal();

    /*
    * 根据sid查找记录
    * */
    public ApplationRecord findRecordBySid(int sid);

    /*
    *根据sid,tid查找记录
    * */
    public ApplationRecord findRecordBySidAndTid(int tid,int sid);

    /*
    * 删除记录
    * */
    public void deletRecord(int id);

    /*
    * 保存记录
    * */
    public void SaveRecord(ApplationRecord record);

    /*
    * 更新记录
    * */
    public void UpdateRecord(ApplationRecord record);


}
