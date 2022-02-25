<template>
  <header>
    <div class="inner">
      <Logo @click="$router.push('/')" />
      <div class="gnb-profile">
        <a
          class="user-icon"
          href="javascript:void(0)">
          <i class="profile-icon fa-solid fa-user"></i>
        </a>
        <h3 class="profile-name">
          {{ nickname }}
        </h3>&nbsp;님
        <button @click="logout">
          로그아웃
        </button>
      </div>
    </div>
  </header>
</template>

<script>
import Logo from './Logo'
import { mapState, mapActions } from 'vuex'

export default {
  components: {
    Logo
  },
  computed: {
    ...mapState('user', [
      'nickname'
    ])
  },
  methods: {
    ...mapActions('user', ['logout'])
  }
}
</script>

<style lang="scss" scoped>
header {
  background-color: #fff;
  border-bottom: 1px solid $color-light;
  font-family: 'Noto Sans KR', sans-serif;
  color: $color-darkgrey;

  .inner {
    width: 800px;
    height: 80px;
    margin: 0 auto;
    position: relative;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .gnb-profile {
      height: 46px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      position: absolute;
      right: 0;
      top: 0;
      bottom: 0;
      margin: auto 0;
      font-size: 14px;
      
      .user-icon {
        text-decoration: none;
        width: 20px;
        height: 20px;
        margin-right: 5px;
        background-color: $color-light;
        border-radius: 50%;
        display: flex;
        justify-content: center;
        align-items: center;

        .profile-icon {
          color: $color-darkgrey;
        }
      }

      .profile-name {
        font-weight: 700;
      }

      button {
        padding: 5px 10px;
        margin-left: 10px;
        font-size: 12px;
        font-weight: 700;
        color: #fff;      

        background-color: $color-grey;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        
        &:hover {
          transform: scale(1.05);
        }
      }
    }
  }
}
</style>
