<template>
  <div class="loading"></div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
  .loading,
  .loading:after {
    border-radius: 50%;
    width: 15px;
    height: 15px;
  }
  .loading {
    margin: 0px auto;
    font-size: 10px;
    position: relative;
    border-top: 3px solid rgba(211,202,202, 0.2);
    border-right: 3px solid rgba(211,202,202, 0.2);
    border-bottom: 3px solid rgba(211,202,202, 0.2);
    border-left: 3px solid #d3caca;
    animation: spinner 1.0s infinite linear;
  }
  @keyframes spinner {
    0% {
      transform: rotate(0deg);
    }
    100% {
      transform: rotate(360deg);
    }
  }
</style>
