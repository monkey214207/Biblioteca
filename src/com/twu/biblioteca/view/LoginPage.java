package com.twu.biblioteca.view;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginPage {
    Scanner scanner = new Scanner(System.in);
    Map<String,String> userInfo = new HashMap<>();
    public Map<String,String> print(PrintStream printStream) {
        printStream.println("UserId:");
        userInfo.put("id",scanner.nextLine());
        printStream.println("Password:");
        userInfo.put("password",scanner.nextLine());
        return userInfo;
    }
    public void printError(PrintStream printStream){
        printStream.println("UserId or Password is error, Bye!");
    }
}
