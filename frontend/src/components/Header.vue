<template>
  <header>
    <div class="inner">
      <div class="gnb-logo">
        <a
          href="/"
          class="logo-image"></a>
        <div class="logo-split"></div>
        <h2 class="logo-text">
          중고거래
        </h2>
      </div>

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
export default {
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
    height: 70px;
    margin: 0 auto;
    position: relative;

    .gnb-logo {
      width: 230px;
      height: 46px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      position: absolute;
      left: 0;
      top: 0;
      bottom: 0;
      margin: auto 0;

      .logo-image {
        display: block;
        width: 94px;
        height: 40px;
        background-image: url(https://trusting-williams-8cacfb.netlify.app/images/globals_2x.png);
        background-position: -162px 0;
        background-size: 363px;
        cursor: pointer;
      }

      .logo-split {
        top: 10px;
        width: 2px;
        height: 44px;
        background-color: $color-darkgrey;
        content: "";
      }

      .logo-text {
        font-size: 26px;
        font-weight: 400;
      }
    }

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
