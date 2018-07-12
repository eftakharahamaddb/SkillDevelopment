package com.skill.develoment.skilldevelopment.android_arch;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name="first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    public User(int uid, String firstName, String lastName) {
        this.uid=uid;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public int getUid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
