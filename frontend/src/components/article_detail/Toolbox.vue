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
    comment: Object,
    hasSub: Boolean
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
      return this.comment.parentId === -1
    },
    isSub() {
      return this.comment.parentId !== -1
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

      commentsApi.addComment(this.userId, this.$route.params.articleId, {
        content: this.replyText,
        parentId: this.comment.commentId
      })
      .catch((error) => console.log(`댓글 등록 실패! :${error}`))
      .then(() => alert('댓글이 등록됐습니다.'))
      .then(() => location.reload())
    },
    editComment() {
      if(this.editText.length <= 0) {
        alert('댓글을 입력해주세요')
        return
      }

      commentsApi.editComment(this.userId, this.$route.params.articleId, this.comment.commentId, {
        content: this.editText,
      })
      .catch((error) => console.log(`댓글 수정 실패! :${error}`))
      .then(() => alert('댓글이 수정됐습니다.'))
      .then(() => location.reload())
    },
    onClickDeleteButton() {
      if(this.hasSub) {
        alert('답글이 달린 댓글은 삭제할 수 없습니다.')
        return
      }
      commentsApi.deleteComment(this.userId, this.$route.params.articleId, this.comment.commentId)
      .catch((error) => console.log(`댓글 삭제 실패! :${error}`))
      .then(() => alert('댓글이 삭제됐습니다.'))
      .then(() => location.reload())
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
      animation: sizeup .2s ease-out;
    }
    @keyframes sizeup {
      0% {
        width: 15%;
        height: 85%;
      }
      100% {
        width: 50%;
        height: 85%;
      }
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
