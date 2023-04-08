package com.programmingfromzero.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingfromzero.app.dto.InoutDTO;
import com.programmingfromzero.app.model.Inout;
import com.programmingfromzero.app.repository.InoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InoutServiceImpl implements InoutService {

    @Autowired
    InoutRepository inoutRepository;

    @Override
    public Inout create(Inout inout) {
        final Inout result = inoutRepository.save(inout);
        return result;
    }

    @Override
    public Inout update(Long id, Inout inout) {
        Inout result = findById(id);
        if (result != null) {
            result.setTransaction_number(inout.getTransaction_number());
            result.setUpdate_user(inout.getUpdate_user());
            result.setMovement_type(inout.getMovement_type());
            result.setTransaction_type(inout.getTransaction_type());
            result.setDescription(inout.getDescription());
            inoutRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Inout result = findById(id);
        if (result != null) {
            // hard delete
            inoutRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Inout> findAll() {
        return inoutRepository.findAll();
    }

    @Override
    public Page<Inout> findAll(Pageable pageable) {
        return inoutRepository.findAll(pageable);
    }

    @Override
    public Inout findById(Long id) {
        Optional<Inout> result = inoutRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public InoutDTO mapToDto(Inout inout) {
        return mapper.convertValue(inout, InoutDTO.class);
    }

    @Override
    public Inout mapToEntity(InoutDTO inoutDTO) {
        return mapper.convertValue(inoutDTO, Inout.class);
    }
}
