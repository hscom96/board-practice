<template>
  <div class="comment">
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

      <div v-if="comment.subComments && comment.subComments.length">
        <comment
          v-for="comment in comment.subComments"
          :key="comment.comment_id" 
          :comment="comment"
          :sub="true"
          class="sub-comment" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'comment',
  props: {
    comment: Object,
    sub: Boolean
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
  display: flex;
  gap: 10px;
  padding: 10px 5px;
  
  .sub-comment {
    border-bottom: 1px solid $color-light;
  }

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
