package com.sistema.encuestas.repository;

import com.sistema.encuestas.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("brandRepo")
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
