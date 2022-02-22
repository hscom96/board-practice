<template>
  <div>
    this is article
  </div>
</template>

<script>
export default {
  data() {
    return {
      
    }
  },
  mounted() {
    console.log(this.$route.params.articleId)
  },
  methods: {

  },
}
</script>

<style lang="scss" scoped>
</style>
