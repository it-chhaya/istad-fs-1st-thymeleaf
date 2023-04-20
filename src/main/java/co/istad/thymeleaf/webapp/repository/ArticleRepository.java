package co.istad.thymeleaf.webapp.repository;

import co.istad.thymeleaf.webapp.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleRepository {
    @Insert("""
            INSERT INTO articles (uuid, title, thumbnail, author)
            VALUES (#{a.uuid}, #{a.title}, #{a.thumbnail}, #{a.author})
            """)
    void insert(@Param("a") Article article);
    @Select("SELECT * FROM articles ORDER BY title DESC")
    List<Article> select();

    @Select("SELECT * FROM article WHERE uuid = #{uuid}")
    Article selectByUuid(String uuid);

    @Delete("DELETE FROM articles WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);

    @Update("""
            UPDATE articles
            SET title = #{a.title},
                thumbnail = #{a.thumbnail}, 
                author = #{a.author}
            WHERE uuid = #{a.uuid}
            """)
    void updateByUuid(@Param("a") Article newArticle);
}
