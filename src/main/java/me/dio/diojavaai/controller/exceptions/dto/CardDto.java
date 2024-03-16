package me.dio.diojavaai.controller.exceptions.dto;

import java.math.BigDecimal;

import me.dio.diojavaai.model.Card;

public record CardDto(
    Long id,
    String number,
    BigDecimal limit
) {
    
    public CardDto(Card model) {
        this(model.getId(), model.getNumber(), model.getLimit());
    }

    public Card toModel(CardDto dto) {
        Card card = new Card();
        card.setId(dto.id);
        card.setNumber(dto.number);
        card.setLimit(dto.limit);
        return card;
    }
}
