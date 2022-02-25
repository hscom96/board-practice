<template>
  <div class="article-item">
    <div
      class="info"
      @click="onClickArticleItem">
      <div class="title">
        <div class="name">
          {{ article.title }}
        </div>
        <div :class="[article.label === '구매' ? 'label-buy' : 'label-sell', 'label']">
          {{ article.label === '구매' ? '구매' : '판매' }}
        </div>
      </div>
      <div class="upload-by">
        {{ article.created_by }}
      </div>
    </div>

    <div class="summary">
      <div class="time">
        {{ convertTime(article.created_at) }}
      </div>
      <div class="count">
        <div class="like">
          <i class="fa-brands fa-gratipay"></i>
          <span>{{ totalLikeCount(article) }}</span>
        </div>
        <div class="comment">
          <i class="fa-solid fa-message"></i>
          <span>{{ article.comment_cnt }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import makeTimeString from '~/utils/convert_time'

export default {
  name: 'ArticleItem',
  props: {
    article: Object
  },
  methods: {
    totalLikeCount(article) {
      const { like_cnt, sad_cnt, upset_cnt } = article
      return like_cnt + sad_cnt + upset_cnt
    },
    onClickArticleItem() {
      this.$router.push(`/article/${this.article.article_id}`)
    },
    convertTime(timestamp) {
      return makeTimeString(timestamp)
    }
  }
}
</script>

<style lang="scss" scoped>
.article-item {
  width: 90%;
  margin: 0 auto;
  padding: 20px 0;
  display: flex;
  gap: 20px;
  
  .info {
    flex-grow: 1;
    cursor: pointer;
    
    .title {
      display: flex;
      gap: 10px;
      align-items: center;

      .name {
        font-size: 12px;
        font-weight: 700;
      }

      .label {
        width: 40px;
        height: 20px;
        border-radius: 16px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 10px;
      }

      .label-buy {
        background-color: #FFFFFF;
        color: $color-primary;
        border: 1px solid $color-primary;
      }

      .label-sell {
        background-color: $color-primary;
        color: #FFFFFF;
        border: 1px solid #FFFFFF;
      }
    }

    .upload-by {
      font-size: 9px;
    }
  }

  .summary {
    display: flex;
    flex-direction: column;
    justify-content: space-between;

    .time {
      font-size: 9px;
    }

    .count {
      display: flex;
      gap: 10px;
      justify-content: flex-end;
      font-size: 12px;
      .like,
      .comment {
        display: flex;
        gap: 5px
      }
    }
  }
}
</style>
