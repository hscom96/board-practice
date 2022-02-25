<template>
  <div>
    <Header />
    <ArticleList />
    <Footer />
  </div>
</template>

<script>
import Header from '~/components/Header'
import Footer from '~/components/Footer'
import ArticleList from '~/components/article_list/ArticleList'

export default {
  name: 'ViewArticleList',
  components: {
    Header,
    Footer,
    ArticleList
  }
}
</script>
