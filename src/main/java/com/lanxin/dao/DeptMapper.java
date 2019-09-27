package com.lanxin.dao;

import com.lanxin.bean.Dept;
import com.lanxin.bean.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DeptMapper {
    @SelectProvider(type=DeptSqlProvider.class, method="countByExample")
    int countByExample(DeptExample example);

    @DeleteProvider(type=DeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(DeptExample example);

    @Delete({
        "delete from dept",
        "where oid = #{oid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer oid);

    @Insert({
        "insert into dept (oid, deptname)",
        "values (#{oid,jdbcType=INTEGER}, #{deptname,jdbcType=VARCHAR})"
    })
    int insert(Dept record);

    @InsertProvider(type=DeptSqlProvider.class, method="insertSelective")
    int insertSelective(Dept record);

    @SelectProvider(type=DeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="oid", property="oid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="deptname", property="deptname", jdbcType=JdbcType.VARCHAR)
    })
    List<Dept> selectByExample(DeptExample example);

    @Select({
        "select",
        "oid, deptname",
        "from dept",
        "where oid = #{oid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="oid", property="oid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="deptname", property="deptname", jdbcType=JdbcType.VARCHAR)
    })
    Dept selectByPrimaryKey(Integer oid);

    @UpdateProvider(type=DeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    @UpdateProvider(type=DeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    @UpdateProvider(type=DeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dept record);

    @Update({
        "update dept",
        "set deptname = #{deptname,jdbcType=VARCHAR}",
        "where oid = #{oid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dept record);
}