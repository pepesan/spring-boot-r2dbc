package com.cursosdedesarrolo.demor2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface ProductRepo extends ReactiveCrudRepository<ProductEntity, Long> { }