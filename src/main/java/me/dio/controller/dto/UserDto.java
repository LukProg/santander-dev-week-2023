package me.dio.controller.dto;



import me.dio.domain.model.User;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public record UserDto(String name, AccountDto account, CardDto card , List<FeatureDto> features, List<NewsDto> news) {
    public static UserDto fromModel(User model) {
        var accountDto = AccountDto.fromModel(model.getAccount());
        var cardDto = CardDto.fromModel(model.getCard());
        var featuresDto = model.getFeatures().stream().map(FeatureDto::fromModel).collect(toList());
        var newsDto = model.getNews().stream().map(NewsDto::fromModel).collect(toList());
        return new UserDto(model.getName(), accountDto, cardDto, featuresDto, newsDto);
    }

    public User toModel() {
        User model = new User();
        model.setName(this.name);
        model.setAccount(this.account.toModel());
        model.setCard(this.card.toModel());
        model.setFeatures(this.features.stream().map(FeatureDto::toModel).collect(toList()));
        model.setNews(this.news.stream().map(NewsDto::toModel).collect(toList()));
        return model;
    }
}
