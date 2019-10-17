package com.ming.biz.service.impl;

import com.ming.biz.mapper.CommentLikesMapper;
import com.ming.biz.model.CommentLikesRecord;
import com.ming.biz.service.CommentLikesRecordService;
import com.ming.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wellfuture
 * @Date: 2018/7/12 13:47
 * Describe:
 */
@Service
public class CommentLikesRecordServiceImpl implements CommentLikesRecordService {

    @Autowired
    CommentLikesMapper commentLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, long pId, String username) {
        return commentLikesMapper.isLiked(articleId, pId, userService.findIdByUsername(username)) != null;
    }

    @Override
    public void insertCommentLikesRecord(CommentLikesRecord commentLikesRecord) {
        commentLikesMapper.insertCommentLikesRecord(commentLikesRecord);
    }

    @Override
    public void deleteCommentLikesRecordByArticleId(long articleId) {
        commentLikesMapper.deleteCommentLikesRecordByArticleId(articleId);
    }
}
