package com.example.hctest.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "codes")
public class Code {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private long id;

    //@OneToOne(mappedBy = "id")
    //private Transaction transaction;

    @Column(name = "code")
    private int code;

    public Code(){}
    public Code(int code){
        super();
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
