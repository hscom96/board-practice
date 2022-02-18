<template>
  <div class="user-form">
    <LoginForm />
  </div>
</template>

<script>
import LoginForm from './UserFormLogin'
export default {
  name: 'UserForm',
  components: {
    LoginForm,
  }
}
</script>

<style lang="scss" scoped>
  .user-form {
    width: 450px;
    height: 700px;

    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    background-color: #fff;
    box-shadow: 0px 2px 8px rgba($color-dark, 0.1);
  }
</style>
