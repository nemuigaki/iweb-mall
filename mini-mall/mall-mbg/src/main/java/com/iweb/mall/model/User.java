package com.iweb.mall.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable ,Cloneable  {
    private String id;

    private String username;

    private String password;

    private String phone;

    private Date createtime;

    private Date updatetime;

    private Son son;

    //实现深克隆的子类son
    private class Son implements Cloneable{
        private String id;

        private String username;

        private String password;

        private String phone;

        private Date createtime;

        private Date updatetime;
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

    }

    //重写clone方法实现克隆
    @Override
    public Object clone() throws CloneNotSupportedException {
        //改写clone方法
        User user = (User) super.clone();
        //获取属性对象,再clone一次,让后设置到被克隆的对象中,返回
        user.son = ((Son) user.son.clone());
        return user;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}