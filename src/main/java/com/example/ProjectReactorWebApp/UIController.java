package com.example.ProjectReactorWebApp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
@RequiredArgsConstructor
public class UIController {
    private final BookService service;

    @GetMapping(value = "/event-sourced-html")
    public String eventSourceHTML(Model model) {
        IReactiveDataDriverContextVariable reactiveDataDriverBook =
                new ReactiveDataDriverContextVariable(service.getAll(), 10);
        model.addAttribute("books", reactiveDataDriverBook);
        return "index";
    }
}
