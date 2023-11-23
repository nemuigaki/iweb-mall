package com.iweb.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayinfoExample() {
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

        public Criteria andPayplatformIsNull() {
            addCriterion("payplatform is null");
            return (Criteria) this;
        }

        public Criteria andPayplatformIsNotNull() {
            addCriterion("payplatform is not null");
            return (Criteria) this;
        }

        public Criteria andPayplatformEqualTo(Integer value) {
            addCriterion("payplatform =", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformNotEqualTo(Integer value) {
            addCriterion("payplatform <>", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformGreaterThan(Integer value) {
            addCriterion("payplatform >", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("payplatform >=", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformLessThan(Integer value) {
            addCriterion("payplatform <", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformLessThanOrEqualTo(Integer value) {
            addCriterion("payplatform <=", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformIn(List<Integer> values) {
            addCriterion("payplatform in", values, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformNotIn(List<Integer> values) {
            addCriterion("payplatform not in", values, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformBetween(Integer value1, Integer value2) {
            addCriterion("payplatform between", value1, value2, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformNotBetween(Integer value1, Integer value2) {
            addCriterion("payplatform not between", value1, value2, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberIsNull() {
            addCriterion("platformnumber is null");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberIsNotNull() {
            addCriterion("platformnumber is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberEqualTo(String value) {
            addCriterion("platformnumber =", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberNotEqualTo(String value) {
            addCriterion("platformnumber <>", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberGreaterThan(String value) {
            addCriterion("platformnumber >", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberGreaterThanOrEqualTo(String value) {
            addCriterion("platformnumber >=", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberLessThan(String value) {
            addCriterion("platformnumber <", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberLessThanOrEqualTo(String value) {
            addCriterion("platformnumber <=", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberLike(String value) {
            addCriterion("platformnumber like", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberNotLike(String value) {
            addCriterion("platformnumber not like", value, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberIn(List<String> values) {
            addCriterion("platformnumber in", values, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberNotIn(List<String> values) {
            addCriterion("platformnumber not in", values, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberBetween(String value1, String value2) {
            addCriterion("platformnumber between", value1, value2, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformnumberNotBetween(String value1, String value2) {
            addCriterion("platformnumber not between", value1, value2, "platformnumber");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusIsNull() {
            addCriterion("platformstatus is null");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusIsNotNull() {
            addCriterion("platformstatus is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusEqualTo(String value) {
            addCriterion("platformstatus =", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusNotEqualTo(String value) {
            addCriterion("platformstatus <>", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusGreaterThan(String value) {
            addCriterion("platformstatus >", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusGreaterThanOrEqualTo(String value) {
            addCriterion("platformstatus >=", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusLessThan(String value) {
            addCriterion("platformstatus <", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusLessThanOrEqualTo(String value) {
            addCriterion("platformstatus <=", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusLike(String value) {
            addCriterion("platformstatus like", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusNotLike(String value) {
            addCriterion("platformstatus not like", value, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusIn(List<String> values) {
            addCriterion("platformstatus in", values, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusNotIn(List<String> values) {
            addCriterion("platformstatus not in", values, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusBetween(String value1, String value2) {
            addCriterion("platformstatus between", value1, value2, "platformstatus");
            return (Criteria) this;
        }

        public Criteria andPlatformstatusNotBetween(String value1, String value2) {
            addCriterion("platformstatus not between", value1, value2, "platformstatus");
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