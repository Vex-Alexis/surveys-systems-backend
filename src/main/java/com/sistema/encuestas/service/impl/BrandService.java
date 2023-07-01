package com.sistema.encuestas.service.impl;

import com.sistema.encuestas.entity.Brand;
import com.sistema.encuestas.entity.Survey;
import com.sistema.encuestas.repository.BrandRepository;
import com.sistema.encuestas.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements IBrandService {

    @Autowired
    private BrandRepository brandRepo;


}
