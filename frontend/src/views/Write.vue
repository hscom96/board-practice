<template>
  <div class="write">
    <Header />
    <div class="content">
      <header>
        <h1>게시글 등록</h1>
        <button>등록</button>
      </header>
      <Form />
    </div>
    <Footer class="fix-bottom" />
  </div>
</template>

<script>
import Header from '~/components/Header'
import Footer from '~/components/Footer'
import Form from '~/components/write/WriteForm'

export default {
  name: 'Write',
  components: {
    Header,
    Form,
    Footer
  }
}
</script>

<style lang="scss" scoped>
  .write {
    height: fit-content;
    
    .content {
      width: 90%;
      max-width: $width-default;
      margin: 25px auto;

      header {
        display: flex;
        justify-content: space-between;
        align-items: center;

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

          &:hover {
            transform: scale(1.05);
          }
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
