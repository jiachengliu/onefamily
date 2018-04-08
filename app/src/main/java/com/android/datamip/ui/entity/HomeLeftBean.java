package com.android.datamip.ui.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 作者：liujiacheng
 * 日期：2018/1/4 14:22
 * 描述：
 */

public class HomeLeftBean implements Serializable {
    private String userId;//用户ID
    private String userName;//用户名
    private String userAvatar;//头像
    private String content;//内容
    private List<String> picList;//图片list
    private List<CommentBean> commentBeanList;//评论list

    public List<CommentBean> getCommentBeanList() {
        return commentBeanList;
    }

    public void setCommentBeanList(List<CommentBean> commentBeanList) {
        this.commentBeanList = commentBeanList;
    }

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

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }
}
