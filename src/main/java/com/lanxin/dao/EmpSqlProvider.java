package com.lanxin.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lanxin.bean.Emp;
import com.lanxin.bean.EmpExample.Criteria;
import com.lanxin.bean.EmpExample.Criterion;
import com.lanxin.bean.EmpExample;
import java.util.List;
import java.util.Map;

public class EmpSqlProvider {

    public String countByExample(EmpExample example) {
        BEGIN();
        SELECT("count (*)");
        FROM("emp");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(EmpExample example) {
        BEGIN();
        DELETE_FROM("emp");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Emp record) {
        BEGIN();
        INSERT_INTO("emp");
        
        if (record.getOid() != null) {
            VALUES("oid", "#{oid,jdbcType=INTEGER}");
        }
        
        if (record.getEmpname() != null) {
            VALUES("empname", "#{empname,jdbcType=VARCHAR}");
        }
        
        if (record.getEsex() != null) {
            VALUES("esex", "#{esex,jdbcType=VARCHAR}");
        }
        
        if (record.getEage() != null) {
            VALUES("eage", "#{eage,jdbcType=BIGINT}");
        }
        
        if (record.getDeptid() != null) {
            VALUES("deptid", "#{deptid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(EmpExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("oid");
        } else {
            SELECT("oid");
        }
        SELECT("empname");
        SELECT("esex");
        SELECT("eage");
        SELECT("deptid");
        FROM("emp");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Emp record = (Emp) parameter.get("record");
        EmpExample example = (EmpExample) parameter.get("example");
        
        BEGIN();
        UPDATE("emp");
        
        if (record.getOid() != null) {
            SET("oid = #{record.oid,jdbcType=INTEGER}");
        }
        
        if (record.getEmpname() != null) {
            SET("empname = #{record.empname,jdbcType=VARCHAR}");
        }
        
        if (record.getEsex() != null) {
            SET("esex = #{record.esex,jdbcType=VARCHAR}");
        }
        
        if (record.getEage() != null) {
            SET("eage = #{record.eage,jdbcType=BIGINT}");
        }
        
        if (record.getDeptid() != null) {
            SET("deptid = #{record.deptid,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("emp");
        
        SET("oid = #{record.oid,jdbcType=INTEGER}");
        SET("empname = #{record.empname,jdbcType=VARCHAR}");
        SET("esex = #{record.esex,jdbcType=VARCHAR}");
        SET("eage = #{record.eage,jdbcType=BIGINT}");
        SET("deptid = #{record.deptid,jdbcType=INTEGER}");
        
        EmpExample example = (EmpExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Emp record) {
        BEGIN();
        UPDATE("emp");
        
        if (record.getEmpname() != null) {
            SET("empname = #{empname,jdbcType=VARCHAR}");
        }
        
        if (record.getEsex() != null) {
            SET("esex = #{esex,jdbcType=VARCHAR}");
        }
        
        if (record.getEage() != null) {
            SET("eage = #{eage,jdbcType=BIGINT}");
        }
        
        if (record.getDeptid() != null) {
            SET("deptid = #{deptid,jdbcType=INTEGER}");
        }
        
        WHERE("oid = #{oid,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(EmpExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}