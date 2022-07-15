package com.cursosdedesarrolo.demor2dbc;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;


interface ProductRepo extends ReactiveSortingRepository<ProductEntity, Long> {
    Flux<ProductEntity> findAllBy(Pageable pageable);
}