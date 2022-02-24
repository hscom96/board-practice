package com.example.backend.model;

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
@Builder
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
}


