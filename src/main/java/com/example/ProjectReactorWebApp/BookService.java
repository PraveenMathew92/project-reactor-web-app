package com.example.ProjectReactorWebApp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Flux<Book> getAll() {
        return repository.findAll();
    }

    public Mono<Book> findById(final String id) {
        return repository.findById(id);
    }

    public Mono<Book> save(final Mono<Book> book) {
        return book.flatMap(repository::save);
    }
}