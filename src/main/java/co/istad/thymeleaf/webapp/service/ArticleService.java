package co.istad.thymeleaf.webapp.service;

import co.istad.thymeleaf.webapp.model.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    // Find all articles
    // POJO
    List<Article> findAll();

    Article findByUuid(String uuid);
    boolean save(Article article, MultipartFile file);
}
