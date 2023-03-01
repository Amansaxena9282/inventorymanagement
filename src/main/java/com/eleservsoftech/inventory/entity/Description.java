package com.eleservsoftech.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DynamicInsert
@DynamicUpdate
//@JsonIgnoreProperties({"material"})
public class Description {

//    @JsonManagedReference
//            (mappedBy = "description_id")
//    @JoinColumn(referencedColumnName ="description_id")
//    @JoinColumn(name="description_id",referencedColumnName ="description_id")


//
//
//    @JsonIgnore
//    @JsonManagedReference
//    @OneToMany (mappedBy = "description")
//    private List<Material> material = new ArrayList<>();

//
//    @OneToMany
//    @JoinColumn(referencedColumnName ="description_id")
//    private List<Material> material = new ArrayList<>();


//    @JoinColumn(referencedColumnName ="description_id")

    // *******  Mapping start from here *********
//
//    @OneToMany(mappedBy = "description")
//    private List<Material> material = new ArrayList<>();
//

    //  ********  mapping ended here   ***************

//    name="description_id",


//    @Column(name="description_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long description_id;

    private String name;
//    @Temporal(TemporalType.DATE)
    Timestamp created_at;
//    @Temporal(TemporalType.TIMESTAMP)
    Timestamp modified_at;

    private String created_by;

    private String last_modified_by;

    private Boolean isdelete;

}
