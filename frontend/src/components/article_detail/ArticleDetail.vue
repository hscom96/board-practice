<template>
  <div class="article-detail">
    <div class="inner">
      <div class="article-wrapper">
        <header>
          <span class="title">{{ articleInfo.title }}</span>
          <div :class="[articleInfo.label === '구매' ? 'label-buy' : 'label-sell', 'label']">
            {{ articleInfo.label === '구매' ? '구매' : '판매' }}
          </div>
          <div
            v-if="isSameId"
            class="icon-wrapper">
            <i
              class="fa-solid fa-pencil"
              @click="onClickEditArticleButton"></i>
            <i
              class="fa-solid fa-trash"
              @click="onClickDeteleArticleButton"></i>
          </div>
        </header>

        <main>
          <div class="create-info">
            <div class="creater">
              <div class="user-icon">
                <i class="fa-solid fa-user"></i>
              </div>
              <span>{{ articleInfo.created_by }}</span>
            </div>
            <div class="time-info">
              <span>{{ convertTime(articleInfo.created_at) }}</span>
              <span v-if="isModified(articleInfo.created_at, articleInfo.modified_at)">(수정됨)</span>
              ·
              <span>조회 {{ articleInfo.view_cnt }}</span>
            </div>
          </div>

          <div class="content-wrapper">
            <div class="img-wrapper">
              <!-- <img
                src="https://picsum.photos/300/200"
                alt="article image" /> -->
            </div>
            <pre>
              {{ articleInfo.content }}
            </pre>
          </div>
        </main>

        <footer>
          <div class="reaction-wrapper">
            <span
              class="reaction btn-reaction"
              :class="articleInfo.is_like ? 'clicked' : ''">
              👍 {{ articleInfo.like_cnt }}
            </span>
            <span
              class="reaction btn-reaction"
              :class="articleInfo.is_sad ? 'clicked' : ''">
              😭 {{ articleInfo.sad_cnt }}
            </span>
            <span
              class="reaction btn-reaction"
              :class="articleInfo.is_upset ? 'clicked' : ''">
              😡 {{ articleInfo.upset_cnt }}
            </span>
          </div>

          <button
            class="btn-list"
            @click="onClickArticleListButton">
            목록
          </button>
        </footer>
      </div>
    </div>
  </div>
</template>

<script>
import requestArticleDetail from '~/utils/api/article_detail'
import makeTimeString from '~/utils/convert_time'
import { mapState } from 'vuex'
import articleApi from '~/utils/api/article'

export default {
  data() {
    return {
      articleInfo: {},
    }
  },
  computed: {
    ...mapState('user', [
      'userId'
    ]),
    isSameId() {
      return this.articleInfo.created_by_id === this.userId
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      this.getArticleDetail()
    },
    async getArticleDetail() {
      try {
        const result = await requestArticleDetail(this.$route.params.articleId)
                              .then(result => result.data.data)
        this.articleInfo = { ...result }
      }
      catch(error) {
        alert(error)
      }
    },
    isModified(created_at, modified_at) {
      return created_at !== modified_at
    },
    onClickArticleListButton() {
      this.$router.push('/article')
    },
    convertTime(timestamp) {
      return makeTimeString(timestamp)
    },
    onClickDeteleArticleButton() {
      articleApi.deleteArticle(this.userId, this.articleInfo.article_id)
      .catch((error) => console.log(`게시글 삭제 실패! :${error}`))
      .then(() => alert('게시글이 삭제됐습니다.'))
      .then(() => document.location.href = '/article')
    },
    onClickEditArticleButton() {
      document.location.href = `/edit/${this.articleInfo.article_id}`
    }
  },
}
</script>

<style lang="scss" scoped>
.article-detail {
  background-color: #FFFFFF;
  padding-top: 50px;
  color: #495057;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;

  .inner {
    width: 750px;

    .article-wrapper {
      header {
        padding: 5px;
        border-bottom: 1px solid $color-light;
        display: flex;
        align-items: center;
        gap: 10px;
        position: relative;

        .title {
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

        .icon-wrapper {
          position: absolute;
          right: 5px;
          display: flex;
          align-items: center;
          gap: 10px;

          i {
            cursor: pointer;
          }
        }
      }

      main {
        padding: 5px;
        .create-info {
          display: flex;
          align-items: center;
          justify-content: space-between;

          .creater {
            display: flex;
            align-items: center;
            gap: 5px;
            font-size:11px;
            font-weight: 700;

            .user-icon {
              width: 16px;
              height: 16px;
              background-color: $color-light;
              border-radius: 50%;
              display: flex;
              justify-content: center;
              align-items: center;
            }
          }

          .time-info {
            display: flex;
            align-items: center;
            gap: 5px;
            font-size: 8px;
            font-weight: 700;
            color: $color-grey
          }
        }

        .content-wrapper {
          margin: 20px auto;
          width: 95%;
          color: black;

          .img-wrapper {
            padding: 10px 0;
            img {
              display: block;
              margin: 0 auto;
            }
          }

          pre {
            font-size: 12px;
            white-space: pre-line;
            line-height: normal;
          }
        }
      }

      footer {
        padding-bottom: 10px;
        border-bottom: 1px solid $color-light;
        display: flex;
        justify-content: flex-end;
        gap: 20px;

        .reaction-wrapper {
          display: flex;
          align-items: center;
          gap: 10px;
          font-size: 12px;
          font-weight: 700;

          .btn-reaction {
            cursor: pointer;
          }

          .reaction {
            padding: 4px 6px;
            border-radius: 16px;
            background-color: $color-darkgrey;
            color: #FFFFFF;
            
            &.clicked {
              background-color: #4696EC;
            }

            &:hover {
              background-color: #4696EC;
            }
          }
        }

        .btn-list {
          background-color: $color-primary;
          color: #FFFFFF;
          border: none;
          border-radius: 4px;
          padding: 3px 10px;
          cursor: pointer;
          font-size: 12px;
          font-weight: 700;
        }
      }
    }
  }
}
</style>
