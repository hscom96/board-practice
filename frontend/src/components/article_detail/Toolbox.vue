<template>
  <div
    class="toolbox"
    :class="isEdit || isReply ? 'scale-up' : ''">
    <div class="icon-wrapper">
      <i
        v-if="isNotSub"
        class="fa-solid fa-reply"
        :class="isReply ? 'active' : ''"
        @click="onClickReplyButton"></i>
      <i
        class="fa-solid fa-pencil"
        :class="isEdit ? 'active' : ''"
        @click="onClickEditButton"></i>
      <i
        class="fa-solid fa-trash"
        @click="onClickDeleteButton"></i>
    </div>
    <div
      v-if="isEdit"
      class="editbox">
      <input
        v-model="editText"
        @keypress.enter="editComment" />
      <div class="button-wrapper">
        <button @click="onClickEditButton">
          취소
        </button>
        <button
          @click="editComment">
          수정
        </button>
      </div>
    </div>
    <div
      v-if="isReply"
      class="replybox">
      <input
        v-model="replyText" 
        @keypress.enter="replyNewComment" />
      <div class="button-wrapper">
        <button @click="onClickReplyButton">
          취소
        </button>
        <button
          @click="replyNewComment">
          등록
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions  } from 'vuex'
import commentsApi from '~/utils/api/comments'

export default {
  name: 'Toolbox',
  props: {
    comment: Object
  },
  data() {
    return {
      isEdit: false,
      editText: '',
      isReply: false,
      replyText: '',
    }
  },
  computed: {
    isNotSub() {
      return this.comment.parent_id === -1
    },
    ...mapState('user', [
      'userId'
    ])
  },
  methods: {
    ...mapActions('comments', [
      'replyComment',
      'deleteComment',
      'editAndSetComment',
    ]),
    onClickReplyButton() {
      this.isEdit = false
      this.isReply = !this.isReply
      this.replyText = ''
    },
    onClickEditButton() {
      this.isReply = false
      this.isEdit = !this.isEdit
      this.editText = this.comment.content
    },
    replyNewComment() {
      if(this.replyText.length <= 0) {
        alert('댓글을 입력해주세요')
        return
      }

      // Todo: [POST] article/{articleId}/comment?parentId={parentId}
      // alert(`Reply : [POST] article/${this.comment.value.article_id}/comment?parentId=${this.comment.value.comment_id}`)
      commentsApi.addComment(this.userId, this.$route.params.articleId, {
        content: this.replyText,
        parentId: this.comment.comment_id
      })

      const data = { 
        value: {
          'comment_id' : Math.floor(Math.random()*10000),
          'parent_id' : this.comment.comment_id,
          'article_id' : 0,
          'content' : this.replyText,
          'created_at': '2022-02-17 22:22:22',
          'created_by': '새 댓글 작성자',
          'created_by_id': 100, 
          'modified_at': '2022-02-22 22:22:22',
          'modified_by': '새 댓글 작성자',
          'modified_by_id': 100,
        },
        subComments: []
      }

      this.replyComment(data)
      this.onClickReplyButton()
    },
    editComment() {
      if(this.editText.length <= 0) {
        alert('댓글을 입력해주세요')
        return
      }

      // Todo: [PUT] article/{articleId}/comment/{commentId}
      // alert(`Edit : [PUT] article/${this.comment.article_id}/comment/${this.comment.comment_id}`)
      commentsApi.editComment(this.userId, this.$route.params.articleId, this.comment.comment_id, {
        content: this.editText,
      })

      this.editAndSetComment({ editComment: this.comment, text: this.editText })
      this.onClickEditButton()
    },
    onClickDeleteButton() {
      // Todo: [DELETE] article/{articleId}/comment/{commentId}
      // alert(`Delete : [DELETE] article/${this.comment.article_id}/comment/${this.comment.comment_id}`)

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
    position: absolute;
    top: 0;
    right: 0;
    transition: all ease 2s 0s;

    &.scale-up {
      width: 50%;
      height: 85%;
      display: flex;
      flex-direction: column;
      align-items: flex-end;
    }

    .icon-wrapper {
      display: flex;
      gap: 15px;
      color: #FFFFFF;

      i {
        cursor: pointer;

        &.fa-reply {
          transform: rotate(180deg);
        }

        &:hover {
          color: $color-light; 
        }

        &.active {
          color: $color-primary; 
        }
      }
    }

    .editbox,
    .replybox {
      width: 100%;
      flex-grow: 1;
      display: flex;
      flex-direction: column;
      align-items: flex-end;
      justify-content: space-around;

      input {
        width: 98%;
        outline: none;
      }

      .button-wrapper {
        display: flex;
        gap: 10px;

        button {
          border: none;
          box-sizing: border-box;
          padding: 3px 6px;
          border-radius: 8px;
          cursor: pointer;

          &:first-child {
            background-color: $color-darkgrey;
            border: 1px solid $color-light;
            color: $color-light;
          }

          &:last-child {
            background-color: $color-light;
            color: $color-darkgrey;
          }
        }
      }
    }
  }
</style>
