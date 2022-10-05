package com.cursosdedesarrolo.demor2dbc;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
interface ProductRepo extends ReactiveSortingRepository<ProductEntity, Long> {
    Flux<ProductEntity> findAllBy(Pageable pageable);
}