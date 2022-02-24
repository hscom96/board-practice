<template>
  <div>
    <div
      class="comment"
      @mouseover="isHover=true"
      @mouseleave="isHover=false">
      <div
        v-if="sub"
        class="sub">
        <i class="fa-solid fa-reply icon-sub"></i>
      </div>

      <div class="comment-wrapper">
        <div class="creater">
          <div class="user-icon">
            <i class="fa-solid fa-user"></i>
          </div>
          <span>{{ comment.value.created_by }}</span>
        </div>

        <div class="content">
          {{ comment.value.content }}
        </div>

        <div class="time-info">
          <span>{{ comment.value.created_at }}</span>
          <span v-if="isModified(comment.value.created_at, comment.value.modified_at)">(수정됨)</span>
        </div>
      </div>

      <Toolbox
        v-if="isHover"
        :comment="comment.value" />
    </div>
    <div v-if="comment.subComments && comment.subComments.length">
      <Comment
        v-for="subComment in comment.subComments"
        :key="subComment.comment_id" 
        :comment="subComment"
        :sub="true"
        class="sub-comment" />
    </div>
  </div>
</template>

<script>
import Toolbox from './Toolbox'

export default {
  name: 'Comment',
  components: { Toolbox },
  props: {
    comment: Object,
    sub: Boolean
  },
  data() {
    return {
      isHover: false
    }
  },
  methods: {
    isModified(created_at, modified_at) {
      return created_at !== modified_at
    }
  }
}
</script>

<style lang="scss" scoped>
.comment {
  width: 97%;
  margin: 0 auto;
  padding: 10px 5px;
  display: flex;
  gap: 10px;
  position: relative;
  border-bottom: 1px solid $color-light;

  .sub {
    .icon-sub {
      transform: rotate(180deg);
    }
  }

  .comment-wrapper {
    width: 100%;
    display: flex;
    flex-direction: column;
    gap: 10px;
    .creater {
      display: flex;
      align-items: center;
      gap: 5px;
      font-size:11px;
      font-weight: 700;

      .user-icon {
        width: 16px;
        height: 16px;
        background-color: $color-light;
        border-radius: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
      }
    }
    .content {
      font-size: 12px;
    }

    .time-info {
      display: flex;
      align-items: center;
      gap: 5px;
      font-size: 8px;
      font-weight: 700;
      color: $color-grey;
    }
  }
}
</style>
