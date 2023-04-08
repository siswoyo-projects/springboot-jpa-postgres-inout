package com.programmingfromzero.app.dto;

import java.math.BigDecimal;
import java.util.Date;

public record InoutLineDTO(Long id, String material_number, String warehouse_code, BigDecimal unit_price, BigDecimal base_qty_uom, BigDecimal qty, String asset_number, String transaction_type, String update_user, Date created_at, Date updated_at) {
}
