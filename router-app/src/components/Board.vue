<template>
<div class="media">
  <div class="media-body">
    <h4 class="media-heading">
      {{board.title}} {{board.writer}} {{board.regDate}}
    </h4>
  </div>
</div>
</template>

<script>
export default {
  props: ['board']
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
