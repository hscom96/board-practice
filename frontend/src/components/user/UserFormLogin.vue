<template>
  <div class="login-form">
    <div class="input-group">
      <div class="input-box">
        <div :class="[isChecked.username ? 'checked' : '', 'input']">
          <i class="fa-solid fa-user-astronaut"></i>
          <input 
            v-model="username"
            type="text"
            autocapitalize="off"
            placeholder="계정을 입력해 주세요."
            required />
        </div>
        <div
          v-if="error.username"
          class="error-text">
          {{ error.username }}
        </div>
      </div>
      <div class="input-box">
        <div :class="[isChecked.password ? 'checked' : '', 'input']">
          <i class="fa-solid fa-key"></i>
          <input 
            v-model="password"
            type="password"
            autocapitalize="off"
            placeholder="비밀번호를 입력해 주세요."
            required />
        </div>
        <div
          v-if="error.password"
          class="error-text">
          {{ error.password }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserFormLogin',
  data() {
    return {
      username: '',
      password: '',
      error: {
        username: false,
        password: false
      },
      isChecked: {
        username: false,
        password: false
      },
      complete: false
    }
  },
  watch: {
    username() {
      this.checkForm()
    },
    password() {
      this.checkForm()
    },
    complete() {
      this.$emit('activate', this.complete)
    }
  },
  methods: {
    checkForm() {
      this.checkUserName()
      this.checkPassword()

      let complete = true
      Object.values(this.error).map(val => {
        if (val) complete = false
      })
      this.complete = complete
    },
    checkUserName() {
      if (this.username.trim().length >= 2) {
        this.error.username = false
        this.isChecked.username = true
      } else {
        this.error.username = '닉네임은 2자 이상이어야 합니다.'
        this.isChecked.username = false
      }
    },
    checkPassword() {
      if (this.password.trim().length >= 8) {
        this.error.password = false
        this.isChecked.password = true
      } else {
        this.error.password = '비밀번호는 8자 이상이어야 합니다.'
        this.isChecked.password = false
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.input-group {
  margin-top: 20px;
  .input-box {
    position: relative;
    .input {
      box-sizing: border-box;
      width: 300px !important;
      height: 40px;

      margin-top: 20px;
      background-color: #f1f1f1;
      color: $color-darkgrey;
      border-bottom: 2px solid $color-grey;
      padding-left: 20px;
      padding-right: 20px;
      font-size: 1rem;
      display: flex;
      align-items: center;
      gap: 10px;

      &.checked {
        border-bottom: 2px solid $color-primary;
      }

      &:focus-within {
        border-bottom: 2px solid $color-primary;
      }

      i {
        font-size: 20px;
        color: $color-grey;
      }

      input {
        width: 100%;
        height: 20px;
        font-size: 1rem;
        background: none;
        box-shadow: none;
        border: none;
        outline: none;
        transition: none;
      }
    }
    .error-text {
      margin-top: 3px;
      padding-left: 20px;
      color: $color-grey;
      font-size: .8rem;
      font-weight: 200;
    }
  }
}
</style>
