package com.programmingfromzero.app.controller;

import com.programmingfromzero.app.dto.InoutLineDTO;
import com.programmingfromzero.app.model.InoutLine;
import com.programmingfromzero.app.service.InoutLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/inout_line")
@RestController

public class InoutLineController {

    @Autowired
    InoutLineService inoutLineService;


    @PostMapping("/add/{inoutId}")
    public InoutLineDTO addInoutLineToInout(@PathVariable Long inoutId, @RequestBody InoutLineDTO request){
        final InoutLine inoutLine = inoutLineService.mapToEntity(request);
        final InoutLine result = inoutLineService.addInoutLine(inoutId, inoutLine);
        return inoutLineService.mapToDto(result);
    }
}
