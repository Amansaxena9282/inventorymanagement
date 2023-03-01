package com.eleservsoftech.inventory.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    @Id
    private String account_id;



     private String crm;

     private String case_id;

     private String doctor_name;

     private String patient_name;

     private String payment_mode;

     private String payment;

     private String date;

     private String remain_amount;

     private String paid_amount;

     private String submitted_amount;

     private String revoke_amount;

     private String remarks;

     private String user;

     private String created_At;
     private String invoice_number;
     private String invoice_date;

}
