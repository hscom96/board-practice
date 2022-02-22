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
import ArticleDeatil from '~/components/article_detail/ArticleDetail'

export default {
  name: 'ArticleDetail',
  components: {
    Header,
    Footer,
    ArticleDeatil
  }
}
</script>
