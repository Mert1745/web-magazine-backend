package com.ogz.magazine.service;

import com.ogz.magazine.builder.ResponseBuilder;
import com.ogz.magazine.domain.ArticleDTO;
import com.ogz.magazine.entity.Article;
import com.ogz.magazine.repository.ArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ResponseBuilder<ArticleDTO> getArticleByAuthor(String author) {
        Optional<Article> articleOptional = articleRepository.findByAuthor(author);

        return articleOptional.map(article -> ResponseBuilder.<ArticleDTO>getInstance().data(articleDTO(article)).status(HttpStatus.OK.value()))
                .orElse(ResponseBuilder.<ArticleDTO>getInstance().status(HttpStatus.NOT_FOUND.value()));
    }

    private ArticleDTO articleDTO(Article article) {
        return new ArticleDTO(article.getAuthor(), article.getTitle(), article.getContent());
    }
}
