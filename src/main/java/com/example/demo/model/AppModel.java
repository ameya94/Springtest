package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;

@Entity
@Table(name="Employee")
@EntityListeners(AuditingEntityListener.class)
public class AppModel {


    private String firstname,lastname;
   @Id
   private long id;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AppModel() {
    }

    public AppModel(String firstname, String lastname, long id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }
}
