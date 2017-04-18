package com.task.User_interaction_module;

/**
 * Created by YFJ on 18.04.2017.
 */
public interface IUser {
    public void create(String url, String name, String password);
    public String getUrl();
    public String getName();
    public String getPassword();
}
