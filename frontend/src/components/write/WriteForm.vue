<template>
  <div class="write-form">
    <header>
      <h1>게시글 {{ type }}</h1>
      <div class="btns">
        <button
          class="cancel"
          @click="$router.go(-1)">
          취소
        </button>
        <button
          :class="[complete ? '' : 'disabled']"
          @click="onChange">
          {{ type }}
        </button>
      </div>
    </header>
    <div class="input-box">
      <input
        type="text"
        :value="title"
        placeholder="제목"
        @input="insertTitle" />
    </div>
    <div
      v-if="type === '등록'"
      class="input-box radio">
      <div class="title">
        종류
      </div>
      <input
        id="option-sell"
        v-model="label"
        value="판매"
        type="radio" />
      <input
        id="option-buy"
        v-model="label"
        value="구매"
        type="radio" />
      <label
        for="option-sell"
        class="option sell">
        <span>판매</span>
      </label>
      <label
        for="option-buy"
        class="option buy">
        <span>구매</span>
      </label>
    </div>
    <div class="input-box">
      <textarea 
        :value="content"
        placeholder="글을 입력하세요."
        @input="insertContent"></textarea>
    </div>
    <UploadImage 
      :origin="image" 
      @upload="setImage" />
  </div>
</template>

<script>
import articleApi from '~/utils/api/article.js'
import UploadImage from './UploadImage'

export default {
  name: 'WriteForm',
  components: {
    UploadImage
  },
  data() {
    return {
      type: '등록',
      articleId: null,
      title: '',
      label: '',
      content: '',
      image: null,
      complete: false,
    }
  },
  computed: {
    articleData() {
      return {
        title: this.title,
        label: this.label,
        content: this.content,
        image: this.image
      }
    }
  },
  watch: {
    title() {
      this.checkForm()
    },
    content() {
      this.checkForm()
    },
    label() {
      this.checkForm()
    },
  },
  async created() {
    if (this.$route.name === 'Edit') {
      this.type = '수정'
      this.articleId = this.$route.params.id
      const { data } = await articleApi.getArticleDetail(this.articleId)
      this.title = data.data.title
      this.content = data.data.content
      this.label = data.data.label
      this.image = data.data.image
    }
  },
  methods: {
    onChange() {
      if (this.type === '등록') {
        this.onCreate()
      } else {
        this.onEdit()
      }
    },
    async onCreate() {
      const { data } = await articleApi.createArticle(this.articleData)
      if (data.code === 200) {
        this.$router.push({ 
          name: 'ArticleDetail', 
          params: { 
            articleId: data.data.article_id
          }
        })
      } else {
        alert(data.message)
      }
    },
    async onEdit() {
      const { data } = await articleApi.updateArticle(this.articleId, this.articleData)
      if (data.code === 200) {
        this.$router.push({ 
          name: 'ArticleDetail', 
          params: { 
            articleId: this.articleId
          }
        })
      } else {
        alert(data.message)
      }
    },
    insertTitle(event) {
      this.title = event.target.value
    },
    insertContent(event) {
      this.content = event.target.value
    },
    setImage(key) {
      this.image = key
    },
    checkForm() {
      if (
        this.title.trim().length > 0 &&
        this.content.trim().length > 0 &&
        this.label.trim().length > 0  
      ) {
        this.complete = true
      } else {
        this.complete = false
      }
    }
  }
}
</script>

<style lang="scss" scoped>
  .write-form {
    margin-top: 20px;
    width: 90%;
    max-width: $width-default;
    min-height: calc(100vh - 190px);
    box-sizing: border-box;
    margin: 0 auto;
    padding: 25px 0;
    
    * {
      box-sizing: border-box;
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 20px;

      h1 {
        font-size: 18px;
        font-weight: 700;
        color: $color-darkgrey;
      }

      button {
        padding: 5px 20px;

        font-size: 16px;
        font-weight: 700;
        color: #fff;      

        background-color: $color-primary;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        
        &.disabled {
          background-color: $color-grey;
          pointer-events: none;
        }

        &.cancel {
          background-color: $color-grey;
          margin-right: 10px;
        }
        
        &:hover {
          transform: scale(1.05);
        }
      }
    }

    .input-box {
      width: 100%;
      border-bottom: 1px solid $color-light;

      input, textarea {
        width: 100%;
        background: none;
        box-shadow: none;
        border: none;
        outline: none;
        font-family: inherit;
      }

      input {
        padding: 10px 20px;
        font-size: 18px;
        &::placeholder {
          color: $color-lightgrey;
          font-weight: 700;
        }
      }

      textarea {
        padding: 20px;
        font-size: 16px;
        height: 350px;
        resize: none;
        &::placeholder {
          color: $color-lightgrey;
          font-weight: 700;
        }
      }

      &.radio {
        display: inline-flex;
        align-items: center;
        gap: 10px;
        border-radius: 5px;
        padding: 15px 20px;

        .title {
          font-size: 17px;
          font-weight: 700;
          color: #585858;
          margin-right: 10px;
        }

        input[type="radio"]{
          display: none;
        }

        .option{
          background: #fff;
          height: 25px;
          width: 60px;
          border-radius: 13px;

          display: flex;
          align-items: center;
          justify-content: center;
          cursor: pointer;
          border: 1px solid #A4A4A4;
          transition: all 0.3s ease;

          span {
            font-size: 14px;
            font-weight: 700;
            color: #A4A4A4;
          }
        }

        #option-buy:checked ~ .buy,
        #option-sell:checked ~ .sell{
          border-color: $color-secondary;
          background: $color-secondary;
        }

        #option-buy:checked ~ .buy span,
        #option-sell:checked ~ .sell span{
          color: #fff;
        }
      }    
    }
  }
</style>
