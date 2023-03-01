package com.eleservsoftech.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cccrm {
    private String Case_Id;
    private String Patient_Name;
    private String patient_email;
    private String Doctor_Name;
    private String treating_dr_email;
    private String registered_doctor;
    private String clinic_Name;
    private String address;
    private String phone;
    private String phone1;
    private String phone2;
    private String phone3;
    private String phone4;
    private String phone5;
    private String plan_date;
    private String plan_time;
    private String crm_name;
    private String delivery_note_no;
    private String bclinic;
    private String badd;
    private String bgst_no;
    private String category;
    private String upper_aligner;
    private String lower_aligner;
    private String others;
    private String case_type;
    private String scan;
    private String location;
    private String  location2;
    private String location3;
    private String location4;
    private String location5;
    private String city;
    private String city2;
    private String city3;
    private String city4;
    private String city5;
    private String r_Doctor;
    private String crm;
    private String p_graph;
    private String starter_kit;
    private String type_request;
    private String s_shown;
    private String ppf_fill;
    private String t_account;
    private String corporate_account;
    private String kol;
    private String c_pkg;
    private String pkg_name;
    private String dispatch_crpt;
    private String dispatch_address;
    private String bill_address;
    private String c_doctor;
    private String case_stage;
    private String priority;
    private String draft;
    private String remark;
    private String holdflag;
    private String user_id;
    private String CREATED_DATE;
    private String starter_case_stage;
    private String starter_satus;
    private String total_amount;
    private String payment_processing;
    private String payment_mode;
    private String inicor_at;
    private String wfc_at;
    private String precor_at;
    private String pre_at;
    private String plncor_at;
    private String cadbs_at;
    private String pln_at;
    private String uplcor_at;
    private String upl_at;
    private String rev_at;
    private String qa_at;
    private String ntcnt_at;
    private String cnl_at;
    private String stg_at;
    private String mpt_at;

    @Column(name="3dpcor_at")
    private String dpcor;
    @Column(name = "3dp_at")
    private String dpat;
    private String labcor_at;
    private String lab_at;
    private String fqc_at;
    private String pckcor_at;
    private String pck_at;
    private String dispatch;
    private String inistrkit_at;
    private String mtpstrkit_at;
    @Column(name = "3dpstrkit_at")
    private String dpstrkit;
    @Column(name = "3dpstrkitcor_at")
    private String dpstrkitor;
    private String labstrkit_at;
    private String labstrkitcor_at;
    private String fqcstrkit_at;
    private String pckstrkit_at;
    private String pckstrkitcor_at;
    private String dispatchstrkit;
    private String planning_id;
    private String staging_id;
    private  String ini_at;
    private String wfccor_at;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String default_address;
    private String default_starterkit;
    private String pincode1;
    private String pincode2;
    private String pincode3;
    private String pincode4;
    private String pincode5;
    private  String next_batch_date;
    private String created_At;
    private  String modified_At;

}
