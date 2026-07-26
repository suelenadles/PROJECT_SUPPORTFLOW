package com.supportflow.helpdesk.repository;

import com.supportflow.helpdesk.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
