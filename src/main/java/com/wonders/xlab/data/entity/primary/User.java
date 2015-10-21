package com.wonders.xlab.data.entity.primary;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by Jeffrey on 15/10/21.
 */
@Entity
public class User extends AbstractPersistable<Long> {

    private String userName;

    @Temporal(TIMESTAMP)
    private Date birthday;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
