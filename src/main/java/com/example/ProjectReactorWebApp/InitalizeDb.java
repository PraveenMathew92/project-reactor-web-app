package com.example.ProjectReactorWebApp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitalizeDb {
    private final BookRepository repository;

    @PostConstruct
    public void init() {

        final Flux<Book> book = Flux.just("12 Rules of Life", "Crime and Punishment", "The subtle art of not giving a f*ck")
                .map(title -> new Book(null, title))
                .flatMap(repository::save);

        repository.deleteAll()
                .thenMany(book)
                .thenMany(repository.findAll())
                .subscribe(savedBook -> System.out.println("The following book was saved " + savedBook));
    }
}