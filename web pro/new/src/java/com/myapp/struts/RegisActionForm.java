/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
 import org.apache.struts.validator.ValidatorForm;  
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Suttida Sat
 */
public class RegisActionForm extends org.apache.struts.action.ActionForm {
        
  
    private String name;
    
    private int number;
    
      private String username;
    private String  password;
    private String confirm_pw;
    private String  firstname;
    private String lastname;
    private String phone;
    private String gender;
    private String account_type = "customer";
    
    private String ban;
    private String  soi;
    private String  district;
    private String area;
    private String country;
    private String code;

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param i
     */
    public void setNumber(int i) {
        number = i;
    }

    /**
     *
     */
    public RegisActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
                    try {
              request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException ex) {
            }
        ActionErrors errors = new ActionErrors();
        if (getUsername() == null || getUsername().length() < 5 || getUsername().length() > 20) {
         errors.add("username", new ActionMessage("error.username.required"));
         }
        if (getPassword() == null || getPassword().length() < 8 || getPassword().length() > 26) {
         errors.add("password", new ActionMessage("error.password.required"));
         }
        if (getConfirm_pw() == null || !getConfirm_pw().equals(getPassword())  ) {
         errors.add("confirm_pw", new ActionMessage("error.confirm_pw.required"));
         }
        if (getFirstname() == null ||  getFirstname().length() > 50) {
         errors.add("firstname", new ActionMessage("error.firstname.required"));
         }
        if (getLastname() == null ||  getLastname().length() > 50) {
         errors.add("lastname", new ActionMessage("error.lastname.required"));
         }
         if (getPhone() == null || getPhone().length() != 10) {
         errors.add("phone", new ActionMessage("error.phone.required"));
         }
        if (getGender() == null ) {
         errors.add("gender", new ActionMessage("error.gender.required"));
         }
        if (getBan() == null || getBan().length() < 1) {
         errors.add("ban", new ActionMessage("error.ban.required"));
        
         }
          if (getSoi() == null || getSoi().length() < 1) {
         errors.add("soi", new ActionMessage("error.soi.required"));
         }
        if (getDistrict() == null || getDistrict().length() < 2) {
         errors.add("district", new ActionMessage("error.district.required"));
         }
        if (getArea() == null || getArea().length() < 2) {
         errors.add("area", new ActionMessage("error.area.required"));
         }
         if (getCountry() == null || getCountry().length() < 2) {
         errors.add("country", new ActionMessage("error.county.required"));
         }
        if (getCode() == null || getCode().length() != 5) {
         errors.add("code", new ActionMessage("error.code.required"));
         }
        
       
         return errors;
         }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname= firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConfirm_pw() {
        return confirm_pw;
    }

    public void setConfirm_pw(String confirm_pw) {
        this.confirm_pw = confirm_pw;
    }

    
    
    
}
