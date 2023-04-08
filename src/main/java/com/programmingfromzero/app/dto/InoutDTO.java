package com.programmingfromzero.app.dto;

import java.util.Date;
import java.util.List;

public record InoutDTO(Long id, String transaction_number, Date transaction_date, String movement_type, String transaction_type, String from_warehouse, String from_warehouse_name, String to_warehouse, String to_warehouse_name,  String license_plate, String po_number, String pr_number, String description, String update_user, Date created_at, Date updated_at, List<InoutLineDTO> inoutLines) {
}
