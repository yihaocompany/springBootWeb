package com.ming.biz.service;

import com.ming.biz.model.FriendLink;
import com.ming.biz.model.Result;
import net.sf.json.JSONArray;

/**
 * @author: wellfuture
 * @Date: 2019/5/16 17:08
 * Describe:
 */
public interface FriendLinkService {

    Result addFriendLink(FriendLink friendLink);

    JSONArray getAllFriendLink();

    Result updateFriendLink(FriendLink friendLink, int id);

    Result deleteFriendLink(int id);

    Result getFriendLink();
}
