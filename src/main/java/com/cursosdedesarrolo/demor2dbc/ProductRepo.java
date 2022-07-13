package com.cursosdedesarrolo.demor2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

interface ProductRepo extends ReactiveCrudRepository<ProductEntity, Long> { }