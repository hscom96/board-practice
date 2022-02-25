<template>
  <div class="error">
    <Header />
    <div class="content">
      <div class="code">
        404
      </div>
      <div class="message">
        Page Not Found
      </div>
      <div class="descript">
        요청하신 페이지를 찾을 수 없습니다.
      </div>
      <button @click="$router.push('/')">
        홈으로 돌아가기
      </button>
    </div>
    <Footer class="fix-bottom" />
  </div>
</template>

<script>
import Header from '~/components/Header'
import Footer from '~/components/Footer'

export default {
  name: 'Error',
  components: {
    Header,
    Footer
  }
}
</script>

<style lang="scss" scoped>
  .error {
    .content {
      width: $width-default;
      margin: 0 auto;
      padding: 150px 0;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      gap: 20px;
      color: $color-darkgrey;

      .code {
        font-size: 80px;
        font-weight: 900;
      }
      .message {
        font-size: 40px;
        font-weight: 700;
      }
      .descript {
        font-size: 21px;
        font-weight: 700;
      }
      button {
        padding: 10px 20px;

        font-size: 20px;
        font-weight: 700;
        color: #fff;      

        background-color: $color-primary;
        border-radius: 10px;
        border: none;
        cursor: pointer;
        
        &:hover {
          transform: scale(1.05);
        }
      }
    }
    .fix-bottom {
      position: absolute;
      left: 0;
      bottom: 0;
      width: 100%;
    }
  }
</style>
