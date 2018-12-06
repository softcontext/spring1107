<template>
<div class="container">
  <p>Current page: {{ currentPage }}</p>
  <div class="row h-100 justify-content-center align-items-center">
    <v-pagination v-model="currentPage"
        :page-count="totalPages"
        :classes="bootstrapPaginationClasses"
        :labels="paginationAnchorTexts"></v-pagination>
  </div>
</div>
</template>

<script>
import vPagination from 'vue-plain-pagination'

export default {
  name: 'About',
  components: {
    vPagination
  },
  data() {
    return {
      msg: 'Welcome to Crypto Info',
      currentPage: 1,
      totalPages: 30,
      bootstrapPaginationClasses: {
        ul: 'pagination',
        li: 'page-item',
        liActive: 'active',
        liDisable: 'disabled',
        button: 'page-link'
      },
      paginationAnchorTexts: {
        first: 'First',
        prev: 'Previous',
        next: 'Next',
        last: 'Last'
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
