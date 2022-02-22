<template>
  <div class="comment-list">
    <div class="inner">
      this is comment list
    </div>
  </div>
</template>

<script>
import requestComments from '~/utils/comments'

export default {
  data() {
    return {
      comments: {},
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      this.getComments()
    },
    async getComments() {
      try {
        const comments = await requestComments(this.$route.params.articleId)
        this.comments = { ...comments }
        console.log(comments)
      }
      catch(error) {
        alert(error)
      }
    },
    isModified(created_at, modified_at) {
      return created_at === modified_at
    }
  },
}
</script>

<style lang="scss" scoped>
.comment-list {
  background-color: #FFFFFF;
  padding-top: 10px;
  padding-bottom: 20px;
  color: #495057;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;

  .inner {
    width: 750px;
  }
}
</style>
