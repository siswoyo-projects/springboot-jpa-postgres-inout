package com.programmingfromzero.app.controller;

import com.programmingfromzero.app.dto.InoutDTO;
import com.programmingfromzero.app.model.Inout;
import com.programmingfromzero.app.service.InoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inout")

public class InoutController {

    @Autowired
    InoutService inoutService;

    @PostMapping("/create")
    public InoutDTO create(@RequestBody InoutDTO request) {
        final Inout inout = inoutService.mapToEntity(request);
        final Inout result = inoutService.create(inout);
        return inoutService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public InoutDTO update(@PathVariable Long id, @RequestBody InoutDTO request) {
        final Inout inout = inoutService.mapToEntity(request);
        final Inout result = inoutService.update(id, inout);
        return inoutService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<InoutDTO> findAll() {
        return inoutService.findAll().stream().map(inout -> inoutService.mapToDto(inout))
                .collect(Collectors.toList());
    }

    /*
    @GetMapping("/{id}")
    public Optional<InoutDTO> findById(Long id) {
        return inoutService.findById(id);
    }
    */

    @GetMapping("/search")
    public Page<InoutDTO> findAllWithPagination(@PageableDefault Pageable pageable) {
        return inoutService.findAll(pageable).map(inout -> inoutService.mapToDto(inout));
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return inoutService.delete(id);
    }

}
