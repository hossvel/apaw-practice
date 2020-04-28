package es.upm.miw.apaw_practice.business.shop;

import es.upm.miw.apaw_practice.data.shop.daos.ArticleRepository;
import es.upm.miw.apaw_practice.data.shop.dtos.ArticleCreationDto;
import es.upm.miw.apaw_practice.data.shop.entities.Article;
import es.upm.miw.apaw_practice.rest.exceptions.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article create(ArticleCreationDto articleCreationDto) {
        this.articleRepository.findByBarcode(articleCreationDto.getBarcode())
                .ifPresent(article -> {
                    throw new ConflictException("Barcode exist: " + articleCreationDto.getBarcode());
                });
        return this.articleRepository.save(articleCreationDto.toArticle());
    }
}