<template>
  <div class="toolbox">
    <i class="fa-solid fa-reply"></i>
    <i class="fa-solid fa-pencil"></i>
    <i class="fa-solid fa-trash"></i>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
  .toolbox {
    background-color: $color-darkgrey;
    padding: 6px 12px;
    border-radius: 4px;
    border: 1px solid $color-light;
    display: flex;
    gap: 15px;
    color: #FFFFFF;
    position: absolute;
    top: 0;
    right: 0;
    
    i {
      cursor: pointer;

      &.fa-reply {
        transform: rotate(180deg);
      }

      &:hover {
        color: $color-light; 
      }
    }
  }
</style>
