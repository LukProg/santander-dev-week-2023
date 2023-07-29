package me.dio.controller.dto;

import me.dio.domain.model.Feature;

public record FeatureDto(Long id, String icon, String Description) {
    public static FeatureDto fromModel(Feature model) {
        return new FeatureDto(model.getId(), model.getIcon(), model.getDescription());
    }

    public Feature toModel() {
        Feature model = new Feature();
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.Description);
        return model;
    }
}
