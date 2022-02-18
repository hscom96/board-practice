<template>
  <div class="login-form">
    <div class="input-group">
      <div class="input-box">
        <input 
          v-model="username"
          type="text"
          class="input"
          autocapitalize="off"
          placeholder="계정을 입력해 주세요."
          required />
        <div
          v-if="error.username"
          class="error-text">
          {{ error.username }}
        </div>
      </div>
      <div class="input-box">
        <input 
          v-model="password"
          type="password"
          class="input"
          autocapitalize="off"
          placeholder="비밀번호를 입력해 주세요."
          required />
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
      width: 300px !important;
      height: 40px;
      margin-top: 20px;
      background-color: #f1f1f1;
      color: $color-darkgrey;
      box-shadow: none;
      border: none;
      border-bottom: 2px solid $color-primary;
      outline: none;
      padding-left: 20px;
      padding-right: 10px;
      font-size: 1rem;
      transition: none;
    }
    .error-text {
      margin-top: 3px;
      padding-left: 20px;
      color: $color-primary;
      font-size: 1rem;
      font-weight: 200;
    }
  }
}
</style>
