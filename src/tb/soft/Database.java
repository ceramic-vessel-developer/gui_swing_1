package tb.soft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static HashMap<String,char[]> users = new HashMap<>();

    static void addUser(String username, char[] password){
        users.put(username,password);
        char[]a=users.get(username);
        System.out.println(a);
    }

    static boolean logIn(String username, char[] password){
        boolean answer = true;
        char[] truePassword = users.get(username);
        if (!Arrays.equals(password,truePassword)){
            answer=false;
        }
        Arrays.fill(password,'0');
        return answer;
    }



}
