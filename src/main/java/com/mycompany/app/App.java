package com.mycompany.app;

import com.mycompany.app.model.Account;
import com.mycompany.app.util.KSessionUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Account account = new Account(200);
        account.withdraw(150);
        KSessionUtil.getSession("myrules.drl").execute(account);
//        KSessionUtil.getSession("myrules.dsl", "myrules.dsrl").execute());

    }
}
