package com.ogz.magazine.service;

import com.ogz.magazine.builder.ResponseBuilder;
import com.ogz.magazine.domain.ArticleDTO;

public interface ArticleService {
    ResponseBuilder<ArticleDTO> getArticleByAuthor(String authorName);
}
