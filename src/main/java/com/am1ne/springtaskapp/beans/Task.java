package com.am1ne.springtaskapp.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SQLDelete(sql = "UPDATE task SET deleted=true WHERE id=?")

@FilterDef(
        name = "deletedFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedFilter",
        condition = "deleted = :isDeleted"
)

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private Date date;
    private double price;
    private String imageUrl;
    private TaskStatus status;
    private String description;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;


    // here the relation between Models
    @OneToMany(targetEntity = UserTaskDetail.class, mappedBy = "task", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserTaskDetail> userTaskDetails;




    //this attribute will not inserted to database just for rest api use
    @Transient
    private List<User> users;

    //this attribute will control to show detailed json for rest api for page that need it or not like page of list of task.
    @Transient
    public boolean loadDetail = false;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public List<UserTaskDetail> getUserTaskDetails() {
        return userTaskDetails;
    }


    public List<User> getUsers() {
        if (loadDetail) {
            return users;
        }
        return null;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
