package com.ming.biz.service;

import com.ming.biz.model.FeedBack;
import net.sf.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: wellfuture
 * @Date: 2018/7/23 17:21
 * Describe:反馈业务操作
 */
public interface FeedBackService {

    /**
     * 保存反馈信息
     * @param feedBack
     * @return
     */
    @Transactional
    JSONObject submitFeedback(FeedBack feedBack);

    /**
     * 获得所有的反馈
     * @return
     */
    JSONObject getAllFeedback(int rows, int pageNum);

}
