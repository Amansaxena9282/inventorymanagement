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
public class Vendor {
//
////    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "vendor")
////    @JoinColumn(name = "stock_in_sin_id",referencedColumnName ="vendor_Code")
//    private List<Stock_in> stock_in = new ArrayList<>();

    //  ***** mapping started from here  ******
//    @OneToMany(mappedBy = "vendor")
//    private List<StockIn> stock_in = new ArrayList<>();

    //   ******** mapping ended at here ******
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Vendor_id;

    private String vendor_Code;

    private String Name;
//    @Temporal(TemporalType.TIMESTAMP)
    Timestamp created_at;

//    @Temporal(TemporalType.TIMESTAMP)
    Timestamp modified_at;

    private String created_by;

    private String Last_Modified_by;

    private Boolean isdelete;
}
