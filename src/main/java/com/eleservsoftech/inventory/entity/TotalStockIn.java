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
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class TotalStockIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long total_sin_id;

    private Long m_id;

    private Long c_id;

    private String quantity;

    private Integer total_stock_in;

    private Timestamp created_at;

    private Timestamp modified_date;

    private String last_modified_by;

    private String vendor_code;
}
