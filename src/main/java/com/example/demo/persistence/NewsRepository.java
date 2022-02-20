package com.example.demo.persistence;

import java.util.List;

import com.example.demo.model.NewsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, String>{
    List<NewsEntity> findByTitle(String title);
}