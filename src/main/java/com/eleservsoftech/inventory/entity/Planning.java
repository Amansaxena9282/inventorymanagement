package com.eleservsoftech.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Planning {

    @Id
    private String planning_id;

    private String crm;

    private String doctor_name;

    private String patient_name;

    private String case_id;

    private String planning_type;

    private String base_segment;

    private String planned;

    private String ipr_sheet;

    private String treat_report;

    private String upload_digiplan;

    private String plan_review;

    private String decesion;

    private String  remark;
    private String from_type;
    private String to_type;
    private String date;
    private String planned_no;
    private String upper_aligner_from;
    private String upper_aligner_to;
    private String lower_aligner_from;
    private String lower_aligner_to;

//    private String created_At;
}
