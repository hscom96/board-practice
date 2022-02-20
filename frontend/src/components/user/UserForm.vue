<template>
  <div class="user-form">
    <Logo />
    <LoginForm
      v-if="type === 'Login'"
      @activate="toggleButton" />
    <SignupForm
      v-if="type === 'Signup'"
      @activate="toggleButton" />
    <button :class="[btnStatus ? '' : 'disable', 'btn-submit']">
      {{ type }}
    </button>
    <div
      v-if="type === 'Login'"
      class="move-signup">
      계정이 아직 없으신가요?
      <span @click="$router.push('/')">회원가입</span>
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
      btnStatus: false,
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
  methods: {
    toggleButton(val) {
      this.btnStatus = val
    }
  }
}
</script>

<style lang="scss" scoped>
  .user-form {
    width: 450px;
    height: 700px;

    box-sizing: border-box;
    padding: 100px 20px;

    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;

    background-color: #fff;
    box-shadow: 0px 2px 8px rgba($color-dark, 0.1);
    
    .move-signup {
      font-size: 12px;
      color: $color-grey;

      span {
        text-decoration: underline;
        cursor: pointer;

        &:hover {
          color: $color-primary;
        }
      }
    }
  }
  .btn-submit {
    width: 300px;
    height: 45px;
    
    background-color: $color-primary;
    color: #f1f1f1;

    font-size: 18px;
    font-weight: 700;

    box-shadow: none;
    border: none;
    outline: none;

    &.disable {
      pointer-events: none;
      background-color: $color-darkgrey;
    }
  }
</style>
