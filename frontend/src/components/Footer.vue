<template>
  <footer>
    <div class="inner">
      <div class="about">
        <p class="company-name">
          11번가(주)
        </p>
        <p class="company-info">
          대표이사 : 이상호, 주소: 서울특별시 중구 한강대로 416, Tel: 1599-0110
          <br />
          사업자등록번호 : 815-81-01244, 통신판매업신고 : 2018-서울중구-1445
        </p>
        <p class="copyright">
          Copyright © 2022 11Street Co.,Ltd. All Rights Reserved.
        </p>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  methods: {

  }
}
</script>

<style lang="scss" scoped>
@import "~/scss/_variables";

footer {
  background-color: $color-darkgrey;
  border-bottom: 1px solid $color-light;
  font-family: 'Noto Sans KR', sans-serif;
  color: white;

  .inner {
    width: 800px;
    margin: 0 auto;
    padding: 20px 0;
    position: relative;

    .about {
      .company-name {
        font-size: 14px;
        font-weight: 700;  
      }
      .company-info {
        margin: 10px auto;
        font-size: 12px;
      }
      .copyright {
        font-size: 10px;
        color: $color-light;
      }
    }
  }
}
</style>
