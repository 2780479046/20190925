package com.lanxin.bean;

public class Emp {
    private Integer oid;

    private String empname;

    private String esex;

    private Long eage;

    private Integer deptid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Long getEage() {
        return eage;
    }

    public void setEage(Long eage) {
        this.eage = eage;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}