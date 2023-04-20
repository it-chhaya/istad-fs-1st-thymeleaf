package co.istad.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf.webapp.model.FileUpload;
import co.istad.thymeleaf.webapp.repository.ArticleRepository;
import co.istad.thymeleaf.webapp.repository.StaticRepository;
import co.istad.thymeleaf.webapp.service.ArticleService;
import co.istad.thymeleaf.webapp.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final StaticRepository staticRepository;
    private final ArticleRepository articleRepository;
    private final FileUploadService fileUploadService;

    @Override
    public List<Article> findAll() {
        // TODO:
        // Your logic
        // return staticRepository.getArticles();
        List<Article> articles = articleRepository.select();
        System.out.println(articles);
        return articles;
    }

    @Override
    public Article findByUuid(String uuid) {
        Article article = articleRepository.selectByUuid(uuid);
        return article;
    }

    @Override
    public boolean save(Article article, MultipartFile file) {
        FileUpload fileUpload = fileUploadService.uploadSingle(file);
        if (fileUpload.isSucceed()) {
            article.setUuid(UUID.randomUUID().toString());
            article.setThumbnail(fileUpload.fileName());
            // staticRepository.getArticles().add(0, article);
            articleRepository.insert(article);
        }
        return true;
    }
}
