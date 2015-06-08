package org.rebootu.jwarner.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Joseph on 6/1/2015.
 */
@MappedSuperclass
public abstract class AbstractEntity {
    private int uid;

    @Id
    @GeneratedValue
    @Column(name = "uid", unique = true, nullable = false)
    public int getUid() {
        return uid;
    }

    protected void setUid(int uid) {
        this.uid = uid;
    }

}


