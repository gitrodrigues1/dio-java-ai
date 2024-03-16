package me.dio.diojavaai.controller.exceptions.dto;

import java.util.List;
import static java.util.Optional.ofNullable;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

import me.dio.diojavaai.model.Person;

public record PersonDto(
    Long id, 
    String name,
    AccountDto accountDto,
    CardDto cardDto,
    List<FeatureDto> features,
    List<NewsDto> news

) {
    
    public PersonDto(Person model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getAccount()).map(AccountDto::new).orElse(null),
                ofNullable(model.getCard()).map(CardDto::new).orElse(null),
                ofNullable(model.getFeatures()).orElse(emptyList()).stream().map(FeatureDto::new).collect(toList()),
                ofNullable(model.getNews()).orElse(emptyList()).stream().map(NewsDto::new).collect(toList())
        );
    }
}
