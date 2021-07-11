package com.example.ProjectReactorWebApp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin
    public Flux<Book> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> findById(@PathVariable final String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Book> save(@RequestBody final Mono<Book> book) {
        return service.save(book);
    }
}