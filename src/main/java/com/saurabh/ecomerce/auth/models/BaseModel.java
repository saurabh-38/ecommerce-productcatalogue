package com.saurabh.ecomerce.auth.models;

import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    public   Long id;
    private Date createdAt;
    private Date updatedAt;
    private Date status;
}
