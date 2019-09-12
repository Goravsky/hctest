package com.example.hctest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "code_id")
    //@GeneratedValue(generator = "increment")
    //@GenericGenerator(name= "increment", strategy= "increment")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "code_id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Code code;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "contact_number")
    private int cNumber;

    public Transaction(){}

    public Transaction(long id, Code code, Status status, Timestamp time, int cNumber) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.time = time;
        this.cNumber = cNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getCNumber() {
        return cNumber;
    }

    public void setCNumber(int cNumber) {
        this.cNumber = cNumber;
    }
}
