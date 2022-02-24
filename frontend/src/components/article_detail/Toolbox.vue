<template>
  <div class="toolbox">
    <i
      class="fa-solid fa-reply"
      @click="onClickReplyButton"></i>
    <i
      class="fa-solid fa-pencil"
      @click="onClickEditButton"></i>
    <i
      class="fa-solid fa-trash"
      @click="onClickDeleteButton"></i>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'Toolbox',
  props: {
    comment: Object
  },
  data() {
    return {
      inputComment: '',
    }
  },
  methods: {
    ...mapActions('comments', [
      'addComment',
      'deleteComment',
      'editComment',
    ]),
    onClickReplyButton() {
      // Todo: [POST] article/{articleId}/comment?parentId={parentId}

      alert(`Reply : [POST] article/${this.comment.article_id}/comment?parentId=${this.comment.parent_id}`)

      // Todo: 이벤트 발생 -> 부모 요소의 comments: [] 상태 조작 
    },
    onClickEditButton() {
      // Todo: [PUT] article/{articleId}/comment/{commentId}

      alert(`Edit : [PUT] article/${this.comment.article_id}/comment/${this.comment.comment_id}`)
    },
    onClickDeleteButton() {
      // Todo: [DELETE] article/{articleId}/comment/{commentId}

      //alert(`Delete : [DELETE] article/${this.comment.article_id}/comment/${this.comment.comment_id}`)
      this.deleteComment(this.comment)
    },
  }
}
</script>

<style lang="scss" scoped>
  .toolbox {
    background-color: $color-darkgrey;
    padding: 6px 12px;
    border-radius: 4px;
    border: 1px solid $color-light;
    display: flex;
    gap: 15px;
    color: #FFFFFF;
    position: absolute;
    top: 0;
    right: 0;
    
    i {
      cursor: pointer;

      &.fa-reply {
        transform: rotate(180deg);
      }

      &:hover {
        color: $color-light; 
      }
    }
  }
</style>
