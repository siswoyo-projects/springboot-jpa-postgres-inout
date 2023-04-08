package com.programmingfromzero.app.service;

import com.programmingfromzero.app.dto.InoutDTO;
import com.programmingfromzero.app.model.Inout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InoutService {

    Inout create(Inout inout);
    Inout update(Long id, Inout inout);
    Boolean delete(Long id);
    List<Inout> findAll();

    Page<Inout> findAll(Pageable pageable);

    Inout findById(Long id);

    InoutDTO mapToDto(Inout inout);
    Inout mapToEntity(InoutDTO inoutDTO);
}
