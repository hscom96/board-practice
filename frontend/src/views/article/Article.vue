<template>
  <div>
    <Header />
    <ArticleDeatil />
    <Footer />
  </div>
</template>

<script>
import Header from '~/components/Header'
import Footer from '~/components/Footer'
import ArticleDeatil from '~/components/article/Article'

export default {
  name: 'Article',
  components: {
    Header,
    Footer,
    ArticleDeatil
  }
}
</script>
