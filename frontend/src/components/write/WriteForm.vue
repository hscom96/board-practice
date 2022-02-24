<template>
  <div class="write-form">
    <div class="input-box">
      <input
        type="text"
        :value="title"
        placeholder="제목"
        @input="insertTitle" />
    </div>
    <div class="input-box radio">
      <div class="title">
        종류
      </div>
      <input
        id="option-sell"
        v-model="type"
        value="판매"
        type="radio" />
      <input
        id="option-buy"
        v-model="type"
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
    <UploadImage />
  </div>
</template>

<script>
import UploadImage from './UploadImage'

export default {
  name: 'WriteForm',
  components: {
    UploadImage
  },
  data() {
    return {
      title: '',
      type: '',
      content: ''
    }
  },
  methods: {
    insertTitle(event) {
      this.title = event.target.value
    },
    insertContent(event) {
      this.content = event.target.value
    },
  }
}
</script>

<style lang="scss" scoped>
  .write-form {
    margin-top: 20px;

    * {
      box-sizing: border-box;
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
