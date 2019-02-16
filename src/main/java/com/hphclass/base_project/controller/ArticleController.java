package com.hphclass.base_project.controller;

import com.hphclass.base_project.domain.Article;
import com.hphclass.base_project.domain.JsonData;
import com.hphclass.base_project.repository.ArticleRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("save")
    public Object save(){
        Article article = new Article(1L, "饭1", "难吃", "昨天剩下的", 123);
        articleRepository.save(article);
        return JsonData.buildSuccess();
    }

    @GetMapping("search")
    public Object search(String content){
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("content", content);
        Iterable<Article> list = articleRepository.search(queryBuilder);
        return JsonData.buildSuccess(list);
    }
}
