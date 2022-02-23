<template>
  <div class="write">
    <header>
      <h1>게시글 등록</h1>
      <button>등록</button>
    </header>
    <Form />
  </div>
</template>

<script>
import Form from '~/components/write/WriteForm'

export default {
  name: 'Write',
  components: {
    Form,
  }
}
</script>

<style lang="scss" scoped>
  .write {
    max-width: $width-default;
    width: 90%;
    margin: 20px auto;

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
</style>
