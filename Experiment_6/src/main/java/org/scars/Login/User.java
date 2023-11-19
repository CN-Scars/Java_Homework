package org.scars.Login;

import java.util.Date;
import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private Date birthday;
    private String telNumber;
    private String email;

    public User(String userName, String password, Date birthday, String telNumber, String email) {
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
        this.telNumber = telNumber;
        this.email = email;
    }

    // Getters and Setters for each field (省略)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(telNumber, user.telNumber) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, telNumber, email);
    }

    // toString方法用于打印用户信息

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
