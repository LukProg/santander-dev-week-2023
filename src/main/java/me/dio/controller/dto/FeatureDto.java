package me.dio.controller.dto;

import me.dio.domain.model.Feature;

public record FeatureDto(String icon, String Description) {
    public static FeatureDto fromModel(Feature model) {
        return new FeatureDto(model.getIcon(), model.getDescription());
    }

    public Feature toModel() {
        Feature model = new Feature();
        model.setIcon(this.icon);
        model.setDescription(this.Description);
        return model;
    }
}
