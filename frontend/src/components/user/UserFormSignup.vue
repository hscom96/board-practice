<template>
  <div class="login-form">
    <div class="input-group">
      <div class="input-box">
        <div :class="[isChecked.name ? 'checked' : '', 'input']">
          <input 
            v-model="name"
            type="text"
            autocapitalize="off"
            placeholder="이름을 입력해 주세요."
            required />
        </div>
        <label>이름</label>
        <div
          v-if="error.name"
          class="error-text">
          {{ error.name }}
        </div>
      </div>
      <div class="input-box">
        <div :class="[isChecked.username ? 'checked' : '', 'input']">
          <input 
            v-model="username"
            type="text"
            autocapitalize="off"
            placeholder="닉네임을 입력해 주세요."
            required />
        </div>
        <label>닉네임</label>
        <div
          v-if="error.username"
          class="error-text">
          {{ error.username }}
        </div>
      </div>
      <div class="input-box">
        <div :class="[isChecked.password ? 'checked' : '', 'input']">
          <input 
            v-model="password"
            type="password"
            autocapitalize="off"
            placeholder="비밀번호를 입력해 주세요."
            required />
        </div>
        <label>비밀번호</label>
        <div
          v-if="error.password"
          class="error-text">
          {{ error.password }}
        </div>
      </div>
      <div class="input-box">
        <div :class="[isChecked.passwordConfirm ? 'checked' : '', 'input']">
          <input 
            v-model="passwordConfirm"
            type="password"
            autocapitalize="off"
            placeholder="비밀번호를 한 번 더 입력해 주세요."
            required />
        </div>
        <label>비밀번호 확인</label>
        <div
          v-if="error.passwordConfirm"
          class="error-text">
          {{ error.passwordConfirm }}
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
      name: '',
      username: '',
      password: '',
      passwordConfirm: '',
      error: {
        user: false,
        username: false,
        password: false,
        passwordConfirm: false
      },
      isChecked: {
        user: false,
        username: false,
        password: false,
        passwordConfirm: false
      },
      complete: false
    }
  },
  watch: {
    name() {
      this.checkForm()
    },
    username() {
      this.checkForm()
    },
    password() {
      this.checkForm()
    },
    passwordConfirm() {
      this.checkForm()
    },
    complete() {
      this.$emit('activate', this.complete)
    }
  },
  methods: {
    checkForm() {
      this.checkName()
      this.checkUserName()
      this.checkPassword()

      let complete = true
      Object.values(this.error).map(val => {
        if (val) complete = false
      })
      this.complete = complete
    },
    checkName() {
      if (this.name.trim().length > 0) {
        this.error.name = false
        this.isChecked.name = true
      } else {
        this.error.name = '이름은 필수 입력 값입니다.'
        this.isChecked.name = false
      }
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

      if (!this.passwordConfirm.trim().length) {
        this.error.passwordConfirm = '비밀번호 확인 절차가 필요합니다.'
        this.isChecked.passwordConfirm = false
      } else if (this.password != this.passwordConfirm) {
        this.error.passwordConfirm = '비밀번호가 일치하지 않습니다.'
        this.isChecked.passwordConfirm = false
      } else {
        this.error.passwordConfirm = false
        this.isChecked.passwordConfirm = true
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.input-group {
  display: flex;
  flex-direction: column;
  gap: 30px;
  margin-top: 40px;

  .input-box {
    position: relative;

    label {
      position: absolute;
      display: inline;
      top: -15px; 
      font-size: 12px; 
      color: $color-darkgrey;
      pointer-events:none;
    }

    .input {
      box-sizing: border-box;

      width: 300px !important;
      height: 40px;

      background-color: #f1f1f1;
      color: $color-darkgrey;
      border-bottom: 2px solid $color-grey;
      padding-left: 20px;
      padding-right: 20px;
      font-size: 1rem;
      display: flex;
      align-items: center;
      gap: 10px;

      &:focus-within,
      &.checked {
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
