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
public class StockIn {
////
////        @JsonBackReference
////        @JsonIgnore
//        @ManyToOne
//        @JoinColumn(name = "m_id",insertable = false, updatable = false)
//        private Material material;
//
////        @JsonBackReference
////        @JsonIgnore
//        @ManyToOne
//        @JoinColumn(name = "c_id",insertable = false, updatable = false)
//        private Categories categories;
//
////        @JsonBackReference
////        @JsonIgnore
//        @ManyToOne
//        @JoinColumn(name = "Vendor_id",insertable = false, updatable = false)
//        private Vendor vendor;
//
////        @JsonManagedReference
////        @JsonIgnore
//        @OneToMany(mappedBy ="stock_in")
////    @JoinColumn(name = "scrapping_scrapping_id",referencedColumnName ="sin_id")
//        private List<Scrapping> scrapping = new ArrayList<>();
//
////        @JsonManagedReference
//        @JsonIgnore
//        @OneToMany(mappedBy = "stock_in")
////    @JoinColumn(name = "stock_out_sout_id",referencedColumnName ="sin_id")
//        private List<Stock_out> stock_out = new ArrayList<>();;


        //   ******    MAPPING STARTED OF THIS PROJECT
//
//        @OneToMany(mappedBy = "stock_in")
//        private List<Scrapping> scrapping = new ArrayList<>();

//
//        @OneToMany(mappedBy = "stock_in")
//        private List<StockOut> stock_out = new ArrayList<>();


//(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
//        @JsonIgnore
//        @ManyToOne
//        @JoinColumn(name = "Vendor_id",insertable = false, updatable = false)
//        private Vendor vendor;

//
//        @JsonIgnore
//        @ManyToOne
//        @JoinColumn(name = "m_id",insertable = false, updatable = false)
//        private Material material;


//        @JsonIgnore
//        @ManyToOne
//        @JoinColumn(name = "c_id",insertable = false, updatable = false)
//        private Categories categories;
//

//       ******* MAPPING ENDED OF THIS PROJECT

        @Id
        @Column(name="sin_id")
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long sin_id;

        @Transient
        private String categoriesName;

        @Transient
        private String materialName;

        @Transient
        private String vendorName;

        private Long m_id;

        private Long c_id;

        private String quantity;

        private Integer stock_in;

        private String menufacture_lot_no;

        private String vendor_lot_no;

//        @Temporal(TemporalType.TIMESTAMP)
        Timestamp created_at;

//        @Temporal(TemporalType.TIMESTAMP)
        Timestamp modified_date;

        private String created_by;

        private String Last_Modified_by;

        private Boolean isdelete;

    private Long vendor_id;

    private Float price;
}
