package com.example.demo.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewsEntity {
    @Id
    private Integer id;
    private String title;
    private String url;

    public void setTitle(String title){
        this.title = title;
    }
    public void setUrl(String url){
        this.url = url;
    }
}
