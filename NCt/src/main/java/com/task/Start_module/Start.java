package com.task.Start_module;

import com.task.User_interaction_module.IUser;
import com.task.User_interaction_module.StandartUser;

/**
 * Created by YFJ on 17.04.2017.
 */
public class Start {
    public static void main(String[] args) {
        IUser Radaev_V = new StandartUser();
        Radaev_V.create("jdbc:oracle:thin:@ sql.edu-netcracker.com:1251:XE", "unc17i_vradaev", "BY8mWhEQ");
    }
}
