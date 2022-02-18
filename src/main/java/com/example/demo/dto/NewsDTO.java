package com.example.demo.dto;

import com.example.demo.model.NewsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsDTO {
    private Integer id;
    private String title;
    private String url;

    public NewsDTO(final NewsEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.url = entity.getUrl();
    }
}