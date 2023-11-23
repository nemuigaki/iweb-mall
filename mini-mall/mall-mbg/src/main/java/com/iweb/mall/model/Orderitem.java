package com.iweb.mall.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Orderitem implements Serializable {
    private String id;

    private String orderid;

    private String userid;

    private String proid;

    private String proname;

    private String proimage;

    private BigDecimal currentunitprice;

    private Integer quantity;

    private BigDecimal totalprice;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProimage() {
        return proimage;
    }

    public void setProimage(String proimage) {
        this.proimage = proimage;
    }

    public BigDecimal getCurrentunitprice() {
        return currentunitprice;
    }

    public void setCurrentunitprice(BigDecimal currentunitprice) {
        this.currentunitprice = currentunitprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
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
        sb.append(", orderid=").append(orderid);
        sb.append(", userid=").append(userid);
        sb.append(", proid=").append(proid);
        sb.append(", proname=").append(proname);
        sb.append(", proimage=").append(proimage);
        sb.append(", currentunitprice=").append(currentunitprice);
        sb.append(", quantity=").append(quantity);
        sb.append(", totalprice=").append(totalprice);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}