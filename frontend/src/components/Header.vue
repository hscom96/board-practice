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
          {{ userInfo.name }}
        </h3>&nbsp;님
      </div>
    </div>
  </header>
</template>

<script>
import Logo from './Logo'
export default {
  components: {
    Logo
  },
  data() {
    return {
      userInfo: {
        name: '홍길동',
      },
    }
  },
  computed: {
  },
  mounted() {
    this.init()
  },
  methods: {
    async init() {
      console.log('Todo: 유저 정보 로드')
    },
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
    }
  }
}
</style>
