package com.eleservsoftech.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DynamicInsert
@DynamicUpdate
//@JsonIgnoreProperties({"scrapping","stock_in","stock_out"})
public class Material {

    //    *******  MAPPING STARTED OF ONE-TO-MANY AND MANY-TO-ONE   *****
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="description_id",insertable = false, updatable = false)
//    private Description description;

//
//    @OneToMany(mappedBy = "material")
//    private List<Scrapping> scrapping = new ArrayList<>();
//
//    @OneToMany(mappedBy = "material")
//    private List<StockIn> stock_in = new ArrayList<>();
//
//    @OneToMany(mappedBy = "material")
//    private List<StockOut> stock_out = new ArrayList<>();
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "c_id",insertable = false, updatable = false)
//    private Categories categories;

    //  *******  MAPPING FINISHED HERE OF THIS PROJECT   *******


//    "description_description_id"
//    @JsonIgnore
//    @JsonBackReference

//
//    @ManyToOne
//    @JoinColumn(name = "description_id",insertable = false, updatable = false)
//    private Description description;


//
//
//    @ManyToOne
////    @JoinColumn(name = "description_description_id")
////    @JoinColumn(name = "description_id")
//    private Description description;
//
//
//    @JsonBackReference
////    "categories_c_id"
////    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "c_id",insertable = false, updatable = false)
//    private Categories categories;
//
//
//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "material")
////    name = "scrapping_scrapping_id",
////    @JoinColumn(referencedColumnName ="scrapping_id")
//    private List<Scrapping> scrapping = new ArrayList<>();
//
//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "material")
////    name = "stock_in_sin_id",
////    @JoinColumn(referencedColumnName ="m_id")
//    private List<Stock_in> stock_in = new ArrayList<>();;
//
////    @JsonManagedReference
////    @JsonIgnore
//    @OneToMany(mappedBy = "material")
////    name = "stock_out_sout_id",
////    @JoinColumn(referencedColumnName ="m_id")
//    private List<Stock_out> stock_out = new ArrayList<>();;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long m_id;

    @Transient
    private String descriptionName;

    @Transient
    private String categoriesName;

    private String name;

    private Integer c_id;

//    @Temporal(TemporalType.TIMESTAMP)
    Timestamp created_At;
//    @Temporal(TemporalType.TIMESTAMP)
    Timestamp modified_at;

    private String created_by;

    private String Last_Modified_by;

    private Boolean isdelete;

    private Integer description_id;

    private String dimension;


}
