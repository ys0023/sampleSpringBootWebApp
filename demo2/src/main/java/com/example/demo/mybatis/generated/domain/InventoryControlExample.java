package com.example.demo.mybatis.generated.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryControlExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public InventoryControlExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
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

        public Criteria andINVENTORY_IDIsNull() {
            addCriterion("INVENTORY_ID is null");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDIsNotNull() {
            addCriterion("INVENTORY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDEqualTo(Integer value) {
            addCriterion("INVENTORY_ID =", value, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDNotEqualTo(Integer value) {
            addCriterion("INVENTORY_ID <>", value, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDGreaterThan(Integer value) {
            addCriterion("INVENTORY_ID >", value, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDGreaterThanOrEqualTo(Integer value) {
            addCriterion("INVENTORY_ID >=", value, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDLessThan(Integer value) {
            addCriterion("INVENTORY_ID <", value, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDLessThanOrEqualTo(Integer value) {
            addCriterion("INVENTORY_ID <=", value, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDIn(List<Integer> values) {
            addCriterion("INVENTORY_ID in", values, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDNotIn(List<Integer> values) {
            addCriterion("INVENTORY_ID not in", values, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDBetween(Integer value1, Integer value2) {
            addCriterion("INVENTORY_ID between", value1, value2, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andINVENTORY_IDNotBetween(Integer value1, Integer value2) {
            addCriterion("INVENTORY_ID not between", value1, value2, "INVENTORY_ID");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMEIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMEIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMEEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMENotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMEGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMEGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMELessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMELessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMELike(String value) {
            addCriterion("PRODUCT_NAME like", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMENotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMEIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMENotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMEBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andPRODUCT_NAMENotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "PRODUCT_NAME");
            return (Criteria) this;
        }

        public Criteria andSTOCKIsNull() {
            addCriterion("STOCK is null");
            return (Criteria) this;
        }

        public Criteria andSTOCKIsNotNull() {
            addCriterion("STOCK is not null");
            return (Criteria) this;
        }

        public Criteria andSTOCKEqualTo(Integer value) {
            addCriterion("STOCK =", value, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKNotEqualTo(Integer value) {
            addCriterion("STOCK <>", value, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKGreaterThan(Integer value) {
            addCriterion("STOCK >", value, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKGreaterThanOrEqualTo(Integer value) {
            addCriterion("STOCK >=", value, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKLessThan(Integer value) {
            addCriterion("STOCK <", value, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKLessThanOrEqualTo(Integer value) {
            addCriterion("STOCK <=", value, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKIn(List<Integer> values) {
            addCriterion("STOCK in", values, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKNotIn(List<Integer> values) {
            addCriterion("STOCK not in", values, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKBetween(Integer value1, Integer value2) {
            addCriterion("STOCK between", value1, value2, "STOCK");
            return (Criteria) this;
        }

        public Criteria andSTOCKNotBetween(Integer value1, Integer value2) {
            addCriterion("STOCK not between", value1, value2, "STOCK");
            return (Criteria) this;
        }

        public Criteria andPRICEIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPRICEIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPRICEEqualTo(Integer value) {
            addCriterion("PRICE =", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICENotEqualTo(Integer value) {
            addCriterion("PRICE <>", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEGreaterThan(Integer value) {
            addCriterion("PRICE >", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE >=", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICELessThan(Integer value) {
            addCriterion("PRICE <", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICELessThanOrEqualTo(Integer value) {
            addCriterion("PRICE <=", value, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEIn(List<Integer> values) {
            addCriterion("PRICE in", values, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICENotIn(List<Integer> values) {
            addCriterion("PRICE not in", values, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICEBetween(Integer value1, Integer value2) {
            addCriterion("PRICE between", value1, value2, "PRICE");
            return (Criteria) this;
        }

        public Criteria andPRICENotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE not between", value1, value2, "PRICE");
            return (Criteria) this;
        }

        public Criteria andORIGINIsNull() {
            addCriterion("ORIGIN is null");
            return (Criteria) this;
        }

        public Criteria andORIGINIsNotNull() {
            addCriterion("ORIGIN is not null");
            return (Criteria) this;
        }

        public Criteria andORIGINEqualTo(String value) {
            addCriterion("ORIGIN =", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINNotEqualTo(String value) {
            addCriterion("ORIGIN <>", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINGreaterThan(String value) {
            addCriterion("ORIGIN >", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGIN >=", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINLessThan(String value) {
            addCriterion("ORIGIN <", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINLessThanOrEqualTo(String value) {
            addCriterion("ORIGIN <=", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINLike(String value) {
            addCriterion("ORIGIN like", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINNotLike(String value) {
            addCriterion("ORIGIN not like", value, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINIn(List<String> values) {
            addCriterion("ORIGIN in", values, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINNotIn(List<String> values) {
            addCriterion("ORIGIN not in", values, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINBetween(String value1, String value2) {
            addCriterion("ORIGIN between", value1, value2, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andORIGINNotBetween(String value1, String value2) {
            addCriterion("ORIGIN not between", value1, value2, "ORIGIN");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPEIsNull() {
            addCriterion("ITEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPEIsNotNull() {
            addCriterion("ITEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPEEqualTo(String value) {
            addCriterion("ITEM_TYPE =", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPENotEqualTo(String value) {
            addCriterion("ITEM_TYPE <>", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPEGreaterThan(String value) {
            addCriterion("ITEM_TYPE >", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPEGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE >=", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPELessThan(String value) {
            addCriterion("ITEM_TYPE <", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPELessThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE <=", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPELike(String value) {
            addCriterion("ITEM_TYPE like", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPENotLike(String value) {
            addCriterion("ITEM_TYPE not like", value, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPEIn(List<String> values) {
            addCriterion("ITEM_TYPE in", values, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPENotIn(List<String> values) {
            addCriterion("ITEM_TYPE not in", values, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPEBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE between", value1, value2, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andITEM_TYPENotBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE not between", value1, value2, "ITEM_TYPE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATENotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATELessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATELessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATENotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATEBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andCREATE_DATENotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "CREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATENotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATELessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATELessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATENotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATEBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "UPDATE_DATE");
            return (Criteria) this;
        }

        public Criteria andUPDATE_DATENotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "UPDATE_DATE");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table inventory_control
     *
     * @mbg.generated do_not_delete_during_merge Sat Feb 13 23:31:40 JST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table inventory_control
     *
     * @mbg.generated Sat Feb 13 23:31:40 JST 2021
     */
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