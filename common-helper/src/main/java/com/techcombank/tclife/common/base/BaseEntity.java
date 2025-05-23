package com.techcombank.tclife.common.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name = "created_by", length = 50, nullable = false)
    private String createdBy;

    @Column(name = "created_time", nullable = false, updatable=false)
    @CreationTimestamp
    private Timestamp createdTime;

    @Column(name = "updated_by", length = 50, nullable = false)
    private String updatedBy;

    @Column(name = "updated_time", nullable = false)
    @UpdateTimestamp
    private Timestamp updatedTime;

}
