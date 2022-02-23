<template>
  <div>
    <Header />
    <ArticleDetail />
    <CommentList />
    <Footer />
  </div>
</template>

<script>
import Header from '~/components/Header'
import Footer from '~/components/Footer'
import ArticleDetail from '~/components/article_detail/ArticleDetail'
import CommentList from '~/components/article_detail/CommentList'

export default {
  name: 'ViewArticleDetail',
  components: {
    Header,
    Footer,
    ArticleDetail,
    CommentList
  }
}
</script>
