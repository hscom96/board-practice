<template>
  <div>
    <Header />
    <ArticleDeatil />
    <CommentList />
    <Footer />
  </div>
</template>

<script>
import Header from '~/components/Header'
import Footer from '~/components/Footer'
import ArticleDeatil from '~/components/article_detail/ArticleDetail'
import CommentList from '~/components/article_detail/CommentList'

export default {
  name: 'ArticleDetail',
  components: {
    Header,
    Footer,
    ArticleDeatil,
    CommentList
  }
}
</script>
