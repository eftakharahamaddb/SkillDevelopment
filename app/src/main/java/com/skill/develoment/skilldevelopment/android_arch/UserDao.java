package com.skill.develoment.skilldevelopment.android_arch;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> getAllByUid(int []userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND last_name LIKE :lastName LIMIT 1")
    List<User> getByName(String firstName, String lastName);

    @Insert
    void insertUsers(List<User> list);

    @Delete
    void deleteUser(User user);
}
