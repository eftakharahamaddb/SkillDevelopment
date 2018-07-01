package com.skill.develoment.skilldevelopment.login_mvp_dagger2;

public class MemoryRepository implements LoginRepository{
    User user;
    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user=user;
    }
}
