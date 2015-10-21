package com.wonders.xlab.data.entity.secondary;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * Created by Jeffrey on 15/10/21.
 */
@Entity
public class Doctor extends AbstractPersistable<Long> {

    private String name;
    
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
