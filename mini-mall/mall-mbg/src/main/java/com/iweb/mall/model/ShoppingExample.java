package com.iweb.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderid like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderid not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNull() {
            addCriterion("receivername is null");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNotNull() {
            addCriterion("receivername is not null");
            return (Criteria) this;
        }

        public Criteria andReceivernameEqualTo(String value) {
            addCriterion("receivername =", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotEqualTo(String value) {
            addCriterion("receivername <>", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThan(String value) {
            addCriterion("receivername >", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThanOrEqualTo(String value) {
            addCriterion("receivername >=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThan(String value) {
            addCriterion("receivername <", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThanOrEqualTo(String value) {
            addCriterion("receivername <=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLike(String value) {
            addCriterion("receivername like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotLike(String value) {
            addCriterion("receivername not like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameIn(List<String> values) {
            addCriterion("receivername in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotIn(List<String> values) {
            addCriterion("receivername not in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameBetween(String value1, String value2) {
            addCriterion("receivername between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotBetween(String value1, String value2) {
            addCriterion("receivername not between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNull() {
            addCriterion("receiverphone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNotNull() {
            addCriterion("receiverphone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneEqualTo(String value) {
            addCriterion("receiverphone =", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotEqualTo(String value) {
            addCriterion("receiverphone <>", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThan(String value) {
            addCriterion("receiverphone >", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiverphone >=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThan(String value) {
            addCriterion("receiverphone <", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThanOrEqualTo(String value) {
            addCriterion("receiverphone <=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLike(String value) {
            addCriterion("receiverphone like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotLike(String value) {
            addCriterion("receiverphone not like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIn(List<String> values) {
            addCriterion("receiverphone in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotIn(List<String> values) {
            addCriterion("receiverphone not in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneBetween(String value1, String value2) {
            addCriterion("receiverphone between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotBetween(String value1, String value2) {
            addCriterion("receiverphone not between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceivermobileIsNull() {
            addCriterion("receivermobile is null");
            return (Criteria) this;
        }

        public Criteria andReceivermobileIsNotNull() {
            addCriterion("receivermobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceivermobileEqualTo(String value) {
            addCriterion("receivermobile =", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotEqualTo(String value) {
            addCriterion("receivermobile <>", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileGreaterThan(String value) {
            addCriterion("receivermobile >", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileGreaterThanOrEqualTo(String value) {
            addCriterion("receivermobile >=", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileLessThan(String value) {
            addCriterion("receivermobile <", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileLessThanOrEqualTo(String value) {
            addCriterion("receivermobile <=", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileLike(String value) {
            addCriterion("receivermobile like", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotLike(String value) {
            addCriterion("receivermobile not like", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileIn(List<String> values) {
            addCriterion("receivermobile in", values, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotIn(List<String> values) {
            addCriterion("receivermobile not in", values, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileBetween(String value1, String value2) {
            addCriterion("receivermobile between", value1, value2, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotBetween(String value1, String value2) {
            addCriterion("receivermobile not between", value1, value2, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceIsNull() {
            addCriterion("receiverprovince is null");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceIsNotNull() {
            addCriterion("receiverprovince is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceEqualTo(String value) {
            addCriterion("receiverprovince =", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceNotEqualTo(String value) {
            addCriterion("receiverprovince <>", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceGreaterThan(String value) {
            addCriterion("receiverprovince >", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("receiverprovince >=", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceLessThan(String value) {
            addCriterion("receiverprovince <", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceLessThanOrEqualTo(String value) {
            addCriterion("receiverprovince <=", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceLike(String value) {
            addCriterion("receiverprovince like", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceNotLike(String value) {
            addCriterion("receiverprovince not like", value, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceIn(List<String> values) {
            addCriterion("receiverprovince in", values, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceNotIn(List<String> values) {
            addCriterion("receiverprovince not in", values, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceBetween(String value1, String value2) {
            addCriterion("receiverprovince between", value1, value2, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceiverprovinceNotBetween(String value1, String value2) {
            addCriterion("receiverprovince not between", value1, value2, "receiverprovince");
            return (Criteria) this;
        }

        public Criteria andReceivercityIsNull() {
            addCriterion("receivercity is null");
            return (Criteria) this;
        }

        public Criteria andReceivercityIsNotNull() {
            addCriterion("receivercity is not null");
            return (Criteria) this;
        }

        public Criteria andReceivercityEqualTo(String value) {
            addCriterion("receivercity =", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotEqualTo(String value) {
            addCriterion("receivercity <>", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityGreaterThan(String value) {
            addCriterion("receivercity >", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityGreaterThanOrEqualTo(String value) {
            addCriterion("receivercity >=", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityLessThan(String value) {
            addCriterion("receivercity <", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityLessThanOrEqualTo(String value) {
            addCriterion("receivercity <=", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityLike(String value) {
            addCriterion("receivercity like", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotLike(String value) {
            addCriterion("receivercity not like", value, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityIn(List<String> values) {
            addCriterion("receivercity in", values, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotIn(List<String> values) {
            addCriterion("receivercity not in", values, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityBetween(String value1, String value2) {
            addCriterion("receivercity between", value1, value2, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceivercityNotBetween(String value1, String value2) {
            addCriterion("receivercity not between", value1, value2, "receivercity");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictIsNull() {
            addCriterion("receiverdistrict is null");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictIsNotNull() {
            addCriterion("receiverdistrict is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictEqualTo(String value) {
            addCriterion("receiverdistrict =", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotEqualTo(String value) {
            addCriterion("receiverdistrict <>", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictGreaterThan(String value) {
            addCriterion("receiverdistrict >", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictGreaterThanOrEqualTo(String value) {
            addCriterion("receiverdistrict >=", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictLessThan(String value) {
            addCriterion("receiverdistrict <", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictLessThanOrEqualTo(String value) {
            addCriterion("receiverdistrict <=", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictLike(String value) {
            addCriterion("receiverdistrict like", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotLike(String value) {
            addCriterion("receiverdistrict not like", value, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictIn(List<String> values) {
            addCriterion("receiverdistrict in", values, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotIn(List<String> values) {
            addCriterion("receiverdistrict not in", values, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictBetween(String value1, String value2) {
            addCriterion("receiverdistrict between", value1, value2, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverdistrictNotBetween(String value1, String value2) {
            addCriterion("receiverdistrict not between", value1, value2, "receiverdistrict");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNull() {
            addCriterion("receiveraddress is null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNotNull() {
            addCriterion("receiveraddress is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressEqualTo(String value) {
            addCriterion("receiveraddress =", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotEqualTo(String value) {
            addCriterion("receiveraddress <>", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThan(String value) {
            addCriterion("receiveraddress >", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiveraddress >=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThan(String value) {
            addCriterion("receiveraddress <", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThanOrEqualTo(String value) {
            addCriterion("receiveraddress <=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLike(String value) {
            addCriterion("receiveraddress like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotLike(String value) {
            addCriterion("receiveraddress not like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIn(List<String> values) {
            addCriterion("receiveraddress in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotIn(List<String> values) {
            addCriterion("receiveraddress not in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressBetween(String value1, String value2) {
            addCriterion("receiveraddress between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotBetween(String value1, String value2) {
            addCriterion("receiveraddress not between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}