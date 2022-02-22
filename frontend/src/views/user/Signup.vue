<template>
  <div class="signup">
    <UserForm />
  </div>
</template>

<script>
import UserForm from '~/components/user/UserForm'

export default {
  name: 'Signup',
  components: {
    UserForm,
  },
}
</script>

<style lang="scss" scoped>
  .signup {
    position: relative;
    height: 100%;
    min-height: 100vh;
    background-color: $color-light;
  }
</style>
