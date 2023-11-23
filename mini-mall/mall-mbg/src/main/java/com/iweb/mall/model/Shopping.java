package com.iweb.mall.model;

import java.io.Serializable;
import java.util.Date;

public class Shopping implements Serializable {
    private String id;

    private String userid;

    private String orderid;

    private String receivername;

    private String receiverphone;

    private String receivermobile;

    private String receiverprovince;

    private String receivercity;

    private String receiverdistrict;

    private String receiveraddress;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone;
    }

    public String getReceivermobile() {
        return receivermobile;
    }

    public void setReceivermobile(String receivermobile) {
        this.receivermobile = receivermobile;
    }

    public String getReceiverprovince() {
        return receiverprovince;
    }

    public void setReceiverprovince(String receiverprovince) {
        this.receiverprovince = receiverprovince;
    }

    public String getReceivercity() {
        return receivercity;
    }

    public void setReceivercity(String receivercity) {
        this.receivercity = receivercity;
    }

    public String getReceiverdistrict() {
        return receiverdistrict;
    }

    public void setReceiverdistrict(String receiverdistrict) {
        this.receiverdistrict = receiverdistrict;
    }

    public String getReceiveraddress() {
        return receiveraddress;
    }

    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress;
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
        sb.append(", userid=").append(userid);
        sb.append(", orderid=").append(orderid);
        sb.append(", receivername=").append(receivername);
        sb.append(", receiverphone=").append(receiverphone);
        sb.append(", receivermobile=").append(receivermobile);
        sb.append(", receiverprovince=").append(receiverprovince);
        sb.append(", receivercity=").append(receivercity);
        sb.append(", receiverdistrict=").append(receiverdistrict);
        sb.append(", receiveraddress=").append(receiveraddress);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}