<template>
  <div class="comment-list">
    <div class="inner">
      <div class="total-comment">
        댓글 {{ commentCount }}
      </div>

      <div class="comments">
        <Comment
          v-for="comment in comments"
          :key="comment.value.comment_id"
          :comment="comment"
          :class="[comment.subComments.length ? 'has-sub' : '', 'parent-comment']" />
      </div>

      <div class="write-comment-wrapper">
        <textarea class="write-comment"></textarea>
        <button class="btn-add-comment">
          댓글 등록
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import requestComments from '~/utils/comments'
import Comment from './Comment'

export default {
  components: { Comment },
  data() {
    return {
      comments: [],
    }
  },
  computed: {
    commentCount() {
      return this.comments.reduce((sum, curr) => sum + 1 + curr.subComments.length, 0)
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
        this.comments = [ ...comments ]
      }
      catch(error) {
        alert(error)
      }
    },
    isModified(created_at, modified_at) {
      return created_at !== modified_at
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

    .total-comment {
      font-size: 14px;
      font-weight: 700;
      padding-left: 5px;
      margin-bottom: 10px;
    }

    .comments {
      .parent-comment {
        border-bottom: 1px solid $color-light;

        &.has-sub,
        &:last-of-type {
          border: none;
        }
      }
    }

    .write-comment-wrapper {
      width: 100%;
      display: flex;
      flex-direction: column;

      .write-comment {
        width: 100%;
        height: 120px;
        padding: 10px;
        border: 1px solid $color-light;
        border-radius: 8px;
        outline: none;
        resize: none;
        box-sizing: border-box;
      }

      .btn-add-comment {
        background-color: $color-primary;
        margin-top: 10px;
        padding: 8px 4px;
        color: #FFFFFF;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 12px;
        font-weight: 700;
        align-self: flex-end;
      }
    }
  }
}
</style>
