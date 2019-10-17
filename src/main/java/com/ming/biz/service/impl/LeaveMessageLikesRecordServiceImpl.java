package com.ming.biz.service.impl;

import com.ming.biz.mapper.LeaveMessageLikesRecordMapper;
import com.ming.biz.model.LeaveMessageLikesRecord;
import com.ming.biz.service.LeaveMessageLikesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wellfuture
 * @Date: 2018/7/16 15:32
 * Describe:
 */
@Service
public class LeaveMessageLikesRecordServiceImpl implements LeaveMessageLikesRecordService {

    @Autowired
    LeaveMessageLikesRecordMapper leaveMessageLikesRecordMapper;


    @Override
    public boolean isLiked(String pageName, int pId, int likeId) {

        return leaveMessageLikesRecordMapper.isLiked(pageName, pId, likeId) != null;
    }

    @Override
    public void insertLeaveMessageLikesRecord(LeaveMessageLikesRecord leaveMessageLikesRecord) {
        leaveMessageLikesRecordMapper.insertLeaveMessageLikesRecord(leaveMessageLikesRecord);
    }
}
