package com.programmingfromzero.app.repository;

import com.programmingfromzero.app.model.InoutLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InoutLineRepository extends JpaRepository<InoutLine, Long> {
}
