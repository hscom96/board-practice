<template>
  <div class="write">
    <Header />
    <div class="content">
      <Form />
    </div>
    <Footer />
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
