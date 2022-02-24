<template>
  <div class="write">
    <Header />
    <div class="content">
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
    .fix-bottom {
      position: absolute;
      left: 0;
      bottom: 0;
      width: 100%;
    }
  }
</style>
