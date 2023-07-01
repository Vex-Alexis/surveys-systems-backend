package com.sistema.encuestas.service;

import com.sistema.encuestas.entity.Brand;
import com.sistema.encuestas.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository marcaPCRepository;


}
