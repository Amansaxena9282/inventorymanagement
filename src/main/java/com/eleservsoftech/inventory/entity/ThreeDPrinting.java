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
public class ThreeDPrinting {

    @Id
    private String printing_id;
    private String crm;
    private String doctor_name;
    private String patient_name;
    private String caseid;
    private String from_type;
    private String to_type;
    private String from_done;
    private String to_done;
    private String mode;
    private String print;
    private String decesion;
    private String remark;
    private String date;
    private String upper_aligner_from;
    private String upper_aligner_to;
    private String lower_aligner_from;
    private String lower_aligner_to;

}
