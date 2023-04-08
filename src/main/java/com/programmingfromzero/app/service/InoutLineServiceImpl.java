package com.programmingfromzero.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingfromzero.app.dto.InoutLineDTO;
import com.programmingfromzero.app.model.Inout;
import com.programmingfromzero.app.model.InoutLine;
import com.programmingfromzero.app.repository.InoutLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InoutLineServiceImpl implements InoutLineService {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    InoutService inoutService;

    @Autowired
    InoutLineRepository inoutLineRepository;

    @Override
    public InoutLine addInoutLine(Long inoutId, InoutLine inoutLine) {
        final Inout inout = inoutService.findById(inoutId);
        if (inout != null) {
            //add store to db
            inoutLine = inoutLineRepository.save(inoutLine);
            if (inout.getInoutLines() != null) {
                List<InoutLine> inoutLines = inout.getInoutLines();
                inoutLines.add(inoutLine);
                inout.setInoutLines(inoutLines);
            } else {
                inout.setInoutLines(Collections.singletonList(inoutLine));
            }
            inoutService.create(inout);
            return inoutLine;
        }
        return null;
    }

    @Override
    public InoutLine mapToEntity(InoutLineDTO inoutLineDTO) {
        return mapper.convertValue(inoutLineDTO, InoutLine.class);
    }

    @Override
    public InoutLineDTO mapToDto(InoutLine inoutLine) {
        return null;
    }
}
