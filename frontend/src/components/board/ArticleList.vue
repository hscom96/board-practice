<template>
  <div class="article-list">
    <div class="inner">
      <header>
        <h1>중고거래</h1>
        <button class="btn-write">
          <i class="fa-solid fa-pencil"></i>
          글쓰기
        </button>
      </header>

      <main>
        <div
          v-for="article in articleList"
          :key="article.id"
          class="article">
          <div class="info">
            <div class="title">
              <div class="name">
                {{ article.text }}
              </div>
              <div :class="[article.label ? 'label-buy' : 'label-sell', 'label']">
                {{ article.label ? "구매" : "판매" }}
              </div>
            </div>
            <div class="upload-by">
              {{ article.uploadBy }}
            </div>
          </div>

          <div class="summary">
            <div class="time">
              {{ article.uploadTime }}
            </div>
            <div class="count">
              <div class="like">
                <i class="fa-brands fa-gratipay"></i>
                <span>{{ article.likeCount }}</span>
              </div>
              <div class="comment">
                <i class="fa-solid fa-message"></i>
                <span>{{ article.commentCount }}</span>
              </div>
            </div>
          </div>
        </div>
      </main>

      <footer>
        <button class="more">
          <Loading v-if="isLoading" />
          <span v-else>더보기</span>
        </button>
      </footer>
    </div>
  </div>
</template>

<script>
import Loading from './loading.vue'

export default {
  components: { Loading },
  data() {
    return {
      page: 0,
      pageSize: 10,
      articleList: []
    }
  },
  computed: {
    isLoading() {
      return true
    }
  },
  async mounted() {
    await this.init()
  },
  methods: {
    async init() {
      const dummyData = [{
          id: 0,
          text: '아이패드 팔아요 (실사용 6달, 생활 스크래치 있음)',
          label: 0,
          uploadBy: '화내는 고길동',
          uploadTime: '2022.02.16 15:22',
          likeCount: 11,
          commentCount: 12
        },
        {
          id: 1,
          text: '아이패드 팔아요2 (실사용 6달, 생활 스크래치 있음)',
          label: 1,
          uploadBy: '화내는 고길동2',
          uploadTime: '2022.02.16 15:23',
          likeCount: 21,
          commentCount: 22
        },
        {
          id: 2,
          text: '아이패드 팔아요3 (실사용 6달, 생활 스크래치 있음)',
          label: 0,
          uploadBy: '화내는 고길동3',
          uploadTime: '2022.02.16 15:33',
          likeCount: 31,
          commentCount: 32
      }]
      
      this.articleList = [...dummyData]
    }

    
  }
}
</script>

<style lang="scss" scoped>
.article-list {
  background-color: #F7F8F9;
  min-height: 90vh;
  padding-top: 50px;
  position: relative;
  color: $color-darkgrey;

  .inner {
    background-color: #FFFFFF;
    width: 750px;
    position: absolute;
    left: 0;
    right: 0;
    margin: 0 auto;
    border-radius: 8px;
    box-shadow: 1px 1px 1px rgba(180, 180, 180, 0.25);
  
    header {
      width: 90%;
      margin: 20px auto;
      display: flex;
      justify-content: space-between;
      align-items: center;

      h1 {
        font-size: 18px;
        font-weight: 700;
      }

      .btn-write {
        background-color: $color-primary;
        color: #FFFFFF;
        border: none;
        border-radius: 4px;
        padding: 6px;
        cursor: pointer;
      }
    }

    main {
      .article {
        width: 90%;
        margin: 0 auto;
        padding: 20px 0;
        border-bottom: 1px solid $color-light;
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
    }

    footer {
      .more {
        background-color: #FFFFFF;
        border: none;
        width: 100%;
        height: 40px;
        border-top: 1px solid $color-light;
        border-radius: 0 0 8px 8px;
        cursor: pointer;
        transform: translateY(-1px);


      }
    }
  }
}


</style>
