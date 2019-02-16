package com.hphclass.base_project.repository;

import com.hphclass.base_project.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository                                                     //传入域类和id类型
public interface ArticleRepository extends ElasticsearchRepository<Article,Long> {
}
