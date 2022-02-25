<template>
  <div class="user-form">
    <Logo />
    <LoginForm
      v-if="type === 'Login'" />
    <SignupForm
      v-if="type === 'Signup'" />
    <div
      v-if="type === 'Login'"
      class="move-signup">
      계정이 아직 없으신가요?
      <span @click="$router.push({ name: 'Signup' })">회원가입</span>
    </div>
  </div>
</template>

<script>
import Logo from '../Logo'
import LoginForm from './UserFormLogin'
import SignupForm from './UserFormSignup'

export default {
  name: 'UserForm',
  components: {
    Logo,
    LoginForm,
    SignupForm,
  },
  data() {
    return {
      type: '',
    }
  },
  watch: {
    '$route'() {
      this.type = this.$route.name
    }
  },
  created() {
    this.type = this.$route.name
  },
}
</script>

<style lang="scss" scoped>
  @import "./user.scss";
</style>
