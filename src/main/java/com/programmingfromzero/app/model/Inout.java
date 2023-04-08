package com.programmingfromzero.app.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "inout")
public class Inout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transaction_number;
    private Date transaction_date;
    private String movement_type;
    private String transaction_type;
    private String from_warehouse;
    private String from_warehouse_name;
    private String to_warehouse;
    private String to_warehouse_name;

    private String license_plate;
    private String po_number;
    private String pr_number;
    private String description;
    private String update_user;
    private Date created_at;
    private Date updated_at;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "inout_line_id")

    private List<InoutLine> inoutLines;
}
