<template>
  <div class="signup-form">
    <div class="input-group signup">
      <div class="input-box">
        <div :class="[isChecked.username ? 'checked' : '', 'input']">
          <input 
            v-model="username"
            type="text"
            autocapitalize="off"
            placeholder="ID를 입력해 주세요."
            required />
        </div>
        <label>ID</label>
        <div
          v-if="error.username"
          class="error-text">
          {{ error.username }}
        </div>
      </div>
      <div class="input-box">
        <div :class="[isChecked.name ? 'checked' : '', 'input']">
          <input 
            v-model="name"
            type="text"
            autocapitalize="off"
            placeholder="닉네임을 입력해 주세요."
            required />
        </div>
        <label>닉네임</label>
        <div
          v-if="error.name"
          class="error-text">
          {{ error.name }}
        </div>
      </div>
      <div class="input-box">
        <div :class="[isChecked.password ? 'checked' : '', 'input']">
          <input 
            v-model="password"
            type="password"
            autocapitalize="off"
            placeholder="비밀번호를 입력해 주세요."
            maxlength="20"
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
            maxlength="20"
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
    <button 
      :class="[complete ? '' : 'disable', 'btn-submit']"
      @click="onSignup(userData)">
      회원가입
    </button>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {  
  name: 'UserFormSignup',
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
  computed: {
    userData() {
      return {
        'name': this.name,
        'userName': this.username,
        'password': this.password
      }
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
  },
  methods: {
    ...mapActions('user', ['onSignup']),
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
      const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,20}/

      if (pattern.test(this.password.trim())) {
        this.error.password = false
        this.isChecked.password = true
      } else {
        this.error.password = '비밀번호는 영문 대・소문자와 숫자, 특수기호가 각 1개 이상씩 포함된 8~20자여야 합니다.'
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
  @import "./user.scss";
</style>
