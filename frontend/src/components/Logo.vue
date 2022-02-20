<template>
  <div class="logo">
    <Logo11st />
    <div class="text">
      중고거래
    </div>
  </div>
</template>

<script>
import Logo11st from '~/assets/11st.svg'

export default {
  name: 'Logo',
  components: {
    Logo11st
  }
}
</script>

<style lang="scss" scoped>
  .logo {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 10px;
    .text {
      font-size: 30px;
      font-weight: 700;
      color: $color-grey;
    }
  }
</style>
