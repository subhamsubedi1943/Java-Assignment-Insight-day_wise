package com.ig.model;

public class Supplier {
    private Integer id;
    private String sname;

    public Supplier(Integer id, String sname) {
        this.id = id;
        this.sname = sname;
    }

    public Integer getId() { return id; }
    public String getSname() { return sname; }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                '}';
    }
}
