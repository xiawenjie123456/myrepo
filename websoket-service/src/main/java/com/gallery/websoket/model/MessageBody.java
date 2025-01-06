package com.gallery.websoket.model;


import java.io.Serializable;

/**
 * 消息体类，用于封装 WebSocket 消息的内容。
 */
public class MessageBody implements Serializable {

    /**
     * 发送用户昵称
     */
    private String sendUserNickname;

    /**
     * 发送用户ID
     */
    private Long sendUserId;

    /**
     * 接收用户ID
     */
    private Long receiveUserId;

    /**
     * 消息类型
     * 由 ProjectConstant.MessageType 定义
     */
    private Byte messageType;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息时间
     */
    private String createTime;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息链接
     */
    private String url;

    /**
     * 扩展字段，用户自定义
     */
    private Object extensionField;

    // Getters and Setters

    public String getSendUserNickname() {
        return sendUserNickname;
    }

    public void setSendUserNickname(String sendUserNickname) {
        this.sendUserNickname = sendUserNickname;
    }

    public Long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getExtensionField() {
        return extensionField;
    }

    public void setExtensionField(Object extensionField) {
        this.extensionField = extensionField;
    }

    @Override
    public String toString() {
        return "MessageBody{" +
                "sendUserNickname='" + sendUserNickname + '\'' +
                ", sendUserId=" + sendUserId +
                ", receiveUserId=" + receiveUserId +
                ", messageType=" + messageType +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", extensionField=" + extensionField +
                '}';
    }
}