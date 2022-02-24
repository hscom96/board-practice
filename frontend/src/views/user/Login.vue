<template>
  <div class="login">
    <UserForm />
  </div>
</template>

<script>
import UserForm from '~/components/user/UserForm'

export default {
  name: 'Login',
  components: {
    UserForm,
  }
}
</script>

<style lang="scss" scoped>
  .login {
    position: relative;
    height: 100%;
    min-height: 100vh;
    background-color: $color-light;
  }
</style>
