package com.sakura.pojo;

import java.util.ArrayList;
import java.util.List;

public class StupaperdetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StupaperdetailsExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQidIsNull() {
            addCriterion("qid is null");
            return (Criteria) this;
        }

        public Criteria andQidIsNotNull() {
            addCriterion("qid is not null");
            return (Criteria) this;
        }

        public Criteria andQidEqualTo(Long value) {
            addCriterion("qid =", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotEqualTo(Long value) {
            addCriterion("qid <>", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidGreaterThan(Long value) {
            addCriterion("qid >", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidGreaterThanOrEqualTo(Long value) {
            addCriterion("qid >=", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidLessThan(Long value) {
            addCriterion("qid <", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidLessThanOrEqualTo(Long value) {
            addCriterion("qid <=", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidIn(List<Long> values) {
            addCriterion("qid in", values, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotIn(List<Long> values) {
            addCriterion("qid not in", values, "qid");
            return (Criteria) this;
        }

        public Criteria andQidBetween(Long value1, Long value2) {
            addCriterion("qid between", value1, value2, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotBetween(Long value1, Long value2) {
            addCriterion("qid not between", value1, value2, "qid");
            return (Criteria) this;
        }

        public Criteria andQnameIsNull() {
            addCriterion("qname is null");
            return (Criteria) this;
        }

        public Criteria andQnameIsNotNull() {
            addCriterion("qname is not null");
            return (Criteria) this;
        }

        public Criteria andQnameEqualTo(String value) {
            addCriterion("qname =", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotEqualTo(String value) {
            addCriterion("qname <>", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameGreaterThan(String value) {
            addCriterion("qname >", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameGreaterThanOrEqualTo(String value) {
            addCriterion("qname >=", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameLessThan(String value) {
            addCriterion("qname <", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameLessThanOrEqualTo(String value) {
            addCriterion("qname <=", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameLike(String value) {
            addCriterion("qname like", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotLike(String value) {
            addCriterion("qname not like", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameIn(List<String> values) {
            addCriterion("qname in", values, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotIn(List<String> values) {
            addCriterion("qname not in", values, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameBetween(String value1, String value2) {
            addCriterion("qname between", value1, value2, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotBetween(String value1, String value2) {
            addCriterion("qname not between", value1, value2, "qname");
            return (Criteria) this;
        }

        public Criteria andTanswerIsNull() {
            addCriterion("tanswer is null");
            return (Criteria) this;
        }

        public Criteria andTanswerIsNotNull() {
            addCriterion("tanswer is not null");
            return (Criteria) this;
        }

        public Criteria andTanswerEqualTo(String value) {
            addCriterion("tanswer =", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerNotEqualTo(String value) {
            addCriterion("tanswer <>", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerGreaterThan(String value) {
            addCriterion("tanswer >", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerGreaterThanOrEqualTo(String value) {
            addCriterion("tanswer >=", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerLessThan(String value) {
            addCriterion("tanswer <", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerLessThanOrEqualTo(String value) {
            addCriterion("tanswer <=", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerLike(String value) {
            addCriterion("tanswer like", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerNotLike(String value) {
            addCriterion("tanswer not like", value, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerIn(List<String> values) {
            addCriterion("tanswer in", values, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerNotIn(List<String> values) {
            addCriterion("tanswer not in", values, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerBetween(String value1, String value2) {
            addCriterion("tanswer between", value1, value2, "tanswer");
            return (Criteria) this;
        }

        public Criteria andTanswerNotBetween(String value1, String value2) {
            addCriterion("tanswer not between", value1, value2, "tanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerIsNull() {
            addCriterion("fanswer is null");
            return (Criteria) this;
        }

        public Criteria andFanswerIsNotNull() {
            addCriterion("fanswer is not null");
            return (Criteria) this;
        }

        public Criteria andFanswerEqualTo(String value) {
            addCriterion("fanswer =", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerNotEqualTo(String value) {
            addCriterion("fanswer <>", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerGreaterThan(String value) {
            addCriterion("fanswer >", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerGreaterThanOrEqualTo(String value) {
            addCriterion("fanswer >=", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerLessThan(String value) {
            addCriterion("fanswer <", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerLessThanOrEqualTo(String value) {
            addCriterion("fanswer <=", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerLike(String value) {
            addCriterion("fanswer like", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerNotLike(String value) {
            addCriterion("fanswer not like", value, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerIn(List<String> values) {
            addCriterion("fanswer in", values, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerNotIn(List<String> values) {
            addCriterion("fanswer not in", values, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerBetween(String value1, String value2) {
            addCriterion("fanswer between", value1, value2, "fanswer");
            return (Criteria) this;
        }

        public Criteria andFanswerNotBetween(String value1, String value2) {
            addCriterion("fanswer not between", value1, value2, "fanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerIsNull() {
            addCriterion("sanswer is null");
            return (Criteria) this;
        }

        public Criteria andSanswerIsNotNull() {
            addCriterion("sanswer is not null");
            return (Criteria) this;
        }

        public Criteria andSanswerEqualTo(String value) {
            addCriterion("sanswer =", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerNotEqualTo(String value) {
            addCriterion("sanswer <>", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerGreaterThan(String value) {
            addCriterion("sanswer >", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerGreaterThanOrEqualTo(String value) {
            addCriterion("sanswer >=", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerLessThan(String value) {
            addCriterion("sanswer <", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerLessThanOrEqualTo(String value) {
            addCriterion("sanswer <=", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerLike(String value) {
            addCriterion("sanswer like", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerNotLike(String value) {
            addCriterion("sanswer not like", value, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerIn(List<String> values) {
            addCriterion("sanswer in", values, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerNotIn(List<String> values) {
            addCriterion("sanswer not in", values, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerBetween(String value1, String value2) {
            addCriterion("sanswer between", value1, value2, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSanswerNotBetween(String value1, String value2) {
            addCriterion("sanswer not between", value1, value2, "sanswer");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Long value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Long value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Long value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Long value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Long value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Long value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Long> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Long> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Long value1, Long value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Long value1, Long value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
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