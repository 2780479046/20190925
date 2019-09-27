package com.lanxin.dao;

import com.lanxin.bean.Emp;
import com.lanxin.bean.EmpExample;
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

public interface EmpMapper {
    @SelectProvider(type=EmpSqlProvider.class, method="countByExample")
    int countByExample(EmpExample example);

    @DeleteProvider(type=EmpSqlProvider.class, method="deleteByExample")
    int deleteByExample(EmpExample example);

    @Delete({
        "delete from emp",
        "where oid = #{oid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer oid);

    @Insert({
        "insert into emp (oid, empname, ",
        "esex, eage, deptid)",
        "values (#{oid,jdbcType=INTEGER}, #{empname,jdbcType=VARCHAR}, ",
        "#{esex,jdbcType=VARCHAR}, #{eage,jdbcType=BIGINT}, #{deptid,jdbcType=INTEGER})"
    })
    int insert(Emp record);

    @InsertProvider(type=EmpSqlProvider.class, method="insertSelective")
    int insertSelective(Emp record);

    @SelectProvider(type=EmpSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="oid", property="oid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="empname", property="empname", jdbcType=JdbcType.VARCHAR),
        @Result(column="esex", property="esex", jdbcType=JdbcType.VARCHAR),
        @Result(column="eage", property="eage", jdbcType=JdbcType.BIGINT),
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.INTEGER)
    })
    List<Emp> selectByExample(EmpExample example);

    @Select({
        "select",
        "oid, empname, esex, eage, deptid",
        "from emp",
        "where oid = #{oid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="oid", property="oid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="empname", property="empname", jdbcType=JdbcType.VARCHAR),
        @Result(column="esex", property="esex", jdbcType=JdbcType.VARCHAR),
        @Result(column="eage", property="eage", jdbcType=JdbcType.BIGINT),
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.INTEGER)
    })
    Emp selectByPrimaryKey(Integer oid);

    @UpdateProvider(type=EmpSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    @UpdateProvider(type=EmpSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    @UpdateProvider(type=EmpSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Emp record);

    @Update({
        "update emp",
        "set empname = #{empname,jdbcType=VARCHAR},",
          "esex = #{esex,jdbcType=VARCHAR},",
          "eage = #{eage,jdbcType=BIGINT},",
          "deptid = #{deptid,jdbcType=INTEGER}",
        "where oid = #{oid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Emp record);
}