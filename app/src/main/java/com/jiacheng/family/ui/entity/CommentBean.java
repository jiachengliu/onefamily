package com.jiacheng.family.ui.entity;

import java.io.Serializable;

/**
 * 作者：liujiacheng
 * 日期：2018/1/4 14:41
 * 描述：单条评论实体类
 */

public class CommentBean implements Serializable{

    private String userId;//评论的用户ID
    private String userName;//评论的用户名
    private String userAvatar;//评论的头像
    private String content;//评论的内容

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
