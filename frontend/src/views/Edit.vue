<template>
  <div class="update">
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
  name: 'Edit',
  components: {
    Header,
    Form,
    Footer
  }
}
</script>
