<template>
  <div>
    <Header />
    <div class="content">
      <ArticleDetail />
      <CommentList />
    </div>
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

<style lang="scss" scoped>
  .content {
    min-height: calc(100vh - 190px);
    box-sizing: border-box;
  }
</style>
