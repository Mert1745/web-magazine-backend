package com.ogz.magazine.resource;

import com.ogz.magazine.builder.ResponseBuilder;
import com.ogz.magazine.domain.ArticleDTO;
import com.ogz.magazine.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/articles")
public class ArticleResource {
    private final ArticleService articleService;

    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("{author}")
    public ResponseBuilder<ArticleDTO> getArticleByAuthor(@PathVariable(value = "author") String author) {
        return articleService.getArticleByAuthor(author);
    }
}
