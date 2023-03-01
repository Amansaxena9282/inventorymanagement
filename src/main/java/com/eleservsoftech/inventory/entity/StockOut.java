package com.eleservsoftech.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class StockOut {
//
////    @JsonBackReference
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "c_id",insertable = false, updatable = false)
//    private Categories categories;
//
////    @JsonBackReference
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "m_id",insertable = false, updatable = false)
//    private Material material;
////
////    @JsonBackReference
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "sin_id",insertable = false, updatable = false)
//    private Stock_in stock_in;


    //    ***** MAPPING STARTED OF THIS PROJECT

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "sin_id",insertable = false, updatable = false)
//    private StockIn stock_in;

//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "m_id",insertable = false, updatable = false)
//    private Material material;

//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "c_id",insertable = false, updatable = false)
//    private Categories categories;

    //   ******  MAPPING ENDED OF THIS PROJECT

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long sout_id;
    @Transient
    private String materialName;

    @Transient
    private String categoriesName;

    private Long sin_id;

    private Long m_id;

    private Long c_id;

    private Long case_id;

    private String quantity;

    private Integer stock_out;

    private String menufacture_lot_no;

    private String vendor_lot_no;

    private String issued_by;

    private String issued_to;
//    @Temporal(TemporalType.TIMESTAMP)
    Timestamp created_at;

//    @Temporal(TemporalType.TIMESTAMP)
    Timestamp modified_date;

    private String created_by;

    private String Last_Modified_by;

    private Boolean isdelete;

    private Float price;
}
