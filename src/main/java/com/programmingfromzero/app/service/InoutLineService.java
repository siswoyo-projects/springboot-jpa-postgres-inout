package com.programmingfromzero.app.service;

import com.programmingfromzero.app.dto.InoutLineDTO;
import com.programmingfromzero.app.model.InoutLine;

public interface InoutLineService {

    InoutLine addInoutLine(Long inoutId, InoutLine inoutLine);

    InoutLine mapToEntity(InoutLineDTO inoutLineDTO);
    InoutLineDTO mapToDto(InoutLine inoutLine);
}
