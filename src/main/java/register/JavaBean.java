/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "JavaBean")
@SessionScoped
public class JavaBean implements Serializable {

    private String user;
    private String pass;

    public JavaBean() {
        this.user = "";
        this.pass = "";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void signup() {
        if(MySQL.login(user, pass)){
            System.out.println("Signup Successfull");
        }
        else{
            System.out.println("Signup not Successfull");
        }
    }
    
    public void login() {
        if(MySQL.login(user, pass)){
            System.out.println("Login Successfull");
        }
        else{
            System.out.println("Login not Successfull");
        }
    }
}
