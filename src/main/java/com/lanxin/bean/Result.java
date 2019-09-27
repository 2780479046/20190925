package com.lanxin.bean;

/**
 * Created by 彭志聪 on 2019/8/19.
 */
public class Result {

    private Integer coe;
    private Object loe;
    private String soe;

    public static Result on() {
        Result result = new Result();
        result.setCoe(500);
        result.setSoe("系统内部出错");

        return result;
    }
    public static Result ok(Object obj){
        Result result = new Result();
        result.setCoe(200);
        result.setSoe("操作成功");
        result.setLoe(obj);

        return result;

    }

    public static Result ok(){
        Result result = new Result();
        result.setCoe(200);
        result.setSoe("操作成功");

        return result;

    }




    public String getSoe() {
        return soe;
    }

    public void setSoe(String soe) {
        this.soe = soe;
    }

    public Object getLoe() {
        return loe;
    }

    public void setLoe(Object loe) {
        this.loe = loe;
    }

    public Integer getCoe() {
        return coe;
    }

    public void setCoe(Integer coe) {
        this.coe = coe;
    }
}
