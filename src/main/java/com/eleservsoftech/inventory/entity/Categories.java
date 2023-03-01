package com.eleservsoftech.inventory.entity;

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
public class Categories {


//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "categories")
////    @JoinColumn(name = "scrapping_scrapping_id",referencedColumnName = "c_id")
//    private List<Scrapping> scrapping = new ArrayList<>();


//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "categories")
////    @JoinColumn(name = "material_m_id",referencedColumnName = "c_id")
//    private List<Material> material = new ArrayList<>();

//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "categories")
////    @JoinColumn(name = "stock_in_sin_id",referencedColumnName ="c_id")
//    private List<Stock_in> stock_in = new ArrayList<>();
//
////    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "categories")
////    @JoinColumn(name = "stock_out_sout_id",referencedColumnName ="c_id")
//    private List<Stock_out> stock_out = new ArrayList<>();


    //  **********  mapping stated from here   ************
//    @OneToMany(mappedBy = "categories")
//    private List<Scrapping> scrapping = new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "categories")
//    private List<Material> material = new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "categories")
//    private List<StockIn> stock_in = new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "categories")
//    private List<StockOut> stock_out = new ArrayList<>();

    //  **************  mapping ended here   *******************

    @Id
//    @Column(name="c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long c_id;

    private String name;
//    @Temporal(TemporalType.TIMESTAMP)
//    Date created_At;
//    @Temporal(TemporalType.TIMESTAMP)


    Timestamp created_At;

    Timestamp modified_at;

    private String created_by;

    private String Last_Modified_by;

    private Boolean isdelete;



}
