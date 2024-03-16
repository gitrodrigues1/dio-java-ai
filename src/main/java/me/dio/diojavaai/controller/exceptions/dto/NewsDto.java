package me.dio.diojavaai.controller.exceptions.dto;

import me.dio.diojavaai.model.News;

public record NewsDto(
    Long id,
    String icon,
    String description
) {
    
    public NewsDto(News model) {
        this(model.getId(), model.getIcon(), model.getDescription());
    }

    public News toModel(NewsDto dto) {
        News news = new News();
        news.setId(dto.id);
        news.setIcon(dto.icon);
        news.setDescription(dto.description);
        return news;
    }
}
