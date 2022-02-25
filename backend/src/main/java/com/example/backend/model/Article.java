package com.example.backend.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Builder
    public Article(LocalDateTime createdAt, LocalDateTime modifiedAt,
        Long createdById, Long modifiedById, Long articleId, String title, String content,
        String image, int likeCnt, int sadCnt, int upsetCnt, int viewCnt, String label,
        int commentCnt, String createdBy, String modifiedBy) {
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
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public void increaseReaction(String type) {
        if ("upset".equalsIgnoreCase(type)) {
            upsetCnt++;
        } else if ("sad".equalsIgnoreCase(type)) {
            sadCnt++;
        } else if ("like".equalsIgnoreCase(type)) {
            likeCnt++;
        }
    }

    public void decreaseReaction(String type) {
        if ("upset".equalsIgnoreCase(type)) {
            upsetCnt--;
        } else if ("sad".equalsIgnoreCase(type)) {
            sadCnt--;
        } else if ("like".equalsIgnoreCase(type)) {
            likeCnt--;
        }
    }

    public void update(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
        super.updateModifiedById(article.getModifiedById());
    }

}


