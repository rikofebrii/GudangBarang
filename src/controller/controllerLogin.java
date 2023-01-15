/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.modelLogin;
import view.viewLogin;

/**
 *
 * @author JAR
 */
public class controllerLogin {
    private modelLogin mL;
    private viewLogin vL;
    
    public controllerLogin(viewLogin vL){
        this.vL= vL;
    }
    
        public void login(){
        mL = new modelLogin();
        mL.setUsernameLoginModel(vL.getUsername().getText());
        mL.setPasswordLoginModel(vL.getPassword().getText());
        
        mL.userLogin();
    }
}
