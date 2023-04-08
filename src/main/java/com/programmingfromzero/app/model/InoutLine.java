package com.programmingfromzero.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "inout_line")
public class InoutLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "material_number")
    private String material_number;
    @Column(name = "warehouse_code")
    private String warehouse_code;
    @Column(name="unit_price")
    private BigDecimal unit_price;
    @Column(name="base_qty_uom")
    private BigDecimal base_qty_uom;
    @Column(name="qty")
    private BigDecimal qty;

    @Column(name="asset_number")
    private String asset_number;

    @Column(name="transaction_type")
    private String transaction_type;
    @Column(name="update_user")
    private String update_user;
    @Column(name="created_at")
    private Date created_at;
    @Column(name="updated_at")
    private Date updated_at;
}
