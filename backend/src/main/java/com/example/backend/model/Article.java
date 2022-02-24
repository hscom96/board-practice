package com.example.backend.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Article extends AuditProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", nullable = false)
    private Long articleId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "image")
    private String image;

    @Column(name = "like_cnt")
    private int likeCnt;

    @Column(name = "sad_cnt")
    private int sadCnt;

    @Column(name = "upset_cnt")
    private int upsetCnt;

    @Column(name = "view_cnt")
    private int viewCnt;

    @Column(name = "label")
    private String label;

    @Column(name = "comment_cnt")
    private int commentCnt;

    @Builder
    public Article(LocalDateTime createdAt, LocalDateTime modifiedAt,
        Long createdById, Long modifiedById, Long articleId, String title, String content,
        String image, int likeCnt, int sadCnt, int upsetCnt, int viewCnt, String label,
        int commentCnt) {
        super(createdAt, modifiedAt, createdById, modifiedById);
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.image = image;
        this.likeCnt = likeCnt;
        this.sadCnt = sadCnt;
        this.upsetCnt = upsetCnt;
        this.viewCnt = viewCnt;
        this.label = label;
        this.commentCnt = commentCnt;
    }
}


