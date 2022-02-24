<template>
  <div class="comment-list">
    <div class="inner">
      <div class="total-comment">
        댓글 {{ commentCount }}
      </div>

      <div class="comments">
        <Comment
          v-for="comment in comments"
          :key="comment.value.commentId"
          :comment="comment"
          :class="[comment.subComments.length ? 'has-sub' : '', 'parent-comment']" />
      </div>

      <div class="write-comment-wrapper">
        <textarea
          v-model="inputComment"
          class="write-comment"
          placeholder="댓글을 입력하세요"
          @keypress.enter="onClickWriteButton"></textarea>
        <button
          class="btn-add-comment"
          @click="onClickWriteButton">
          댓글 등록
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import requestComments from '~/utils/comments'
import commentsApi from '~/utils/api/comments'
import Comment from './Comment'
import { mapState, mapActions  } from 'vuex'

export default {
  components: { Comment },
  data() {
    return {
      inputComment: '',
    }
  },
  computed: {
    commentCount() {
      return this.comments.reduce((sum, curr) => sum + 1 + curr.subComments.length, 0)
    },
    ...mapState('comments', [
      'comments'
    ]),
    ...mapState('user', [
      'userId'
    ])
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      this.initComments()
    },
    ...mapActions('comments', [
      'setComments',
      'addComment'
    ]),
    async initComments() {
      try {
        const comments = await requestComments(this.$route.params.articleId)
        this.setComments(comments)
      }
      catch(error) {
        alert(error)
      }
    },
    isModified(createdAt, modifiedAt) {
      return createdAt !== modifiedAt
    },
    onClickWriteButton() {
      if(this.inputComment.length <= 0) {
        alert('댓글을 입력해주세요')
        return
      }
      
      this.addNewComment(this.inputComment)
    },
    addNewComment(text) {
      commentsApi.addComment(this.userId, this.$route.params.articleId, {
        content: text,
        parentId: -1
      }).then(result => result.data.data)

      location.reload()
      // this.addComment({ 
      //   value: data,
      //   subComments: []
      // })
      // this.inputComment = ''
    },
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

    .write-comment-wrapper {
      width: 100%;
      display: flex;
      flex-direction: column;
      transform: translateY(-1px);

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
