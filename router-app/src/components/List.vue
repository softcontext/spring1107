<template>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-10">
      <div class="card">
        <div class="card-header">Users</div>
        <div class="card-body">
          <board v-for="board in boards" :board="board" :key="board.id" />
          <pagination :paths="paths" v-on:next="fetchUsers" />
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import axios from 'axios'
import Board from './Board'
import Pagination from './Pagination'

export default {
  name: 'List',
  components: {
    Board,
    Pagination
  },
  data() {
    return {
      boards: [],
      paths: []
    }
  },
  mounted() {
    this.fetchUsers({
      page: 1,
      size: 3,
      bsize: 2
    });
  },
  methods: {
    fetchUsers({
      page,
      size,
      bsize
    }) {
      axios.get('http://localhost:8081/boards', {
        params: {
          page,
          size,
          bsize
        }
      }).then((res) => {
        this.boards = res.data.boards;
        this.paths = res.data.pager.paths;
      });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
