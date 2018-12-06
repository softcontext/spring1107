<template>
  <nav>
      <ul class="pagination">
          <li class="page-item" v-for="page in paths" :key="page.text"
            :class="{ 'active':page.active === 'active' }">
            <a class="page-link" href="#"
              @click.prevent="page.active !== 'active' && next(page.params)">{{ page.text }}</a>
          </li>
      </ul>
  </nav>
</template>

<script>
export default {
  props: ['paths'],
  methods: {
      next(params) {
          this.$emit('next', params);
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
