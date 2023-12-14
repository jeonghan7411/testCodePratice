package org.example.password;

public class User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void initPassword(PasswordGeneratePolicy passwordGeneratePolicy){
        String password = passwordGeneratePolicy.generatePassword();
        /*
            비밀번호는 최소 8자 이상 12자 이하여야 한다
         */
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }


    }
}
