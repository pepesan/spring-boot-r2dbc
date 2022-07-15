package com.cursosdedesarrolo.demor2dbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class WebFluxDemoController {
    @Autowired
    private ProductRepo productRepo;
    @GetMapping("/product")
    public Flux<ProductEntity> getTodos() {
        return productRepo.findAll();
    }
    @PostMapping("/product")
    public Mono<ProductEntity> postProduct(@RequestBody ProductEntity productEntity) {
        return productRepo.save(productEntity);
    }
    @GetMapping("/product/{id}")
    public Mono<ProductEntity> findProduct(@PathVariable(name = "id") long id) {
        return productRepo.findById(id);
    }
    @PostMapping("/product/{id}")
    public Mono<ProductEntity> updateProduct(@PathVariable(name = "id") long id, @RequestBody ProductEntity productEntity) {
        Mono<ProductEntity> productEntityGuardada =
                productRepo.findById(id)
                .map(p -> {
                    p.setName(productEntity.getName());
                    p.setDescription(productEntity.getDescription());
                    return p;
                })
                .flatMap(p -> this.productRepo.save(p));;

        return productEntityGuardada;
    }
    @DeleteMapping("/product/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id) {
        return this.productRepo.deleteById(new Long(id));
    }
    @GetMapping("/productsearch")
    public Mono<Page<ProductEntity>> getAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size){
        return this.productRepo.findAllBy(PageRequest.of(page, size))
                .collectList()
                .zipWith(this.productRepo.count())
                .map(t -> new PageImpl<>(t.getT1(), PageRequest.of(page, size), t.getT2()));
    }
}
