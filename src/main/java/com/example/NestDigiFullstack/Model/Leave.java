package com.example.NestDigiFullstack.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Leave")
public class Leave {
@Id
@GeneratedValue

    private int id;
    private String reason;
    private int status;
    private int empid;
    private String typeOfleave;
    private String remarks;
    private String from;
    private String to;
    private int days;

    public Leave() {
    }

    public Leave(int id, String reason, int status, int empid, String typeOfleave, String remarks, String from, String to, int days) {
        this.id = id;
        this.reason = reason;
        this.status = status;
        this.empid = empid;
        this.typeOfleave = typeOfleave;
        this.remarks = remarks;
        this.from = from;
        this.to = to;
        this.days = days;
    }

    @Override
    public String toString() {
        return "Leaves{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", empid=" + empid +
                ", typeOfleave='" + typeOfleave + '\'' +
                ", remarks='" + remarks + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", days=" + days +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getTypeOfleave() {
        return typeOfleave;
    }

    public void setTypeOfleave(String typeOfleave) {
        this.typeOfleave = typeOfleave;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
