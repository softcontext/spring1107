<template>
<div>
  <header class="table-info">
    <p>
      Viewing {{ resultIndexBeg }} - {{ resultIndexEnd }} of {{ totalData }} results
    </p>
    <!--
    <pagination-control @change="test" :current-page="page" :max-pages="totalPages" />
    -->
  </header>
  <table class="table">
    <thead>
      <tr>
        <th v-for="col in userCols" :key="col">{{ col }}</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.id }}</td>
        <td>
          <img class="avatar" :src="user.avatar" alt="">
        </td>
        <td>{{ user.first_name }}</td>
        <td>{{ user.last_name }}</td>
      </tr>
    </tbody>
  </table>
</div>
</template>

<!-- https://codepen.io/sdbrannum/pen/rKadGa -->

<script>
export default {
  name: 'Page',
  data() {
    return {
      baseUrl: 'https://reqres.in/api/users',
      page: 1,
      perPage: 4,
      totalPages: 0,
      totalData: 0,
      users: [],
      userCols: ['Id', 'Avatar', 'First Name', 'Last Name']
    };
  },
  computed: {
    resultIndexBeg() {
      // return this.users[0].id || 0;
      return this.users.length > 0 ? this.users[0].id : 0;
      // return 1;
    },
    resultIndexEnd() {
      // return this.users[4].id || 0;
      return this.users.length > 0 ? this.users[this.users.length - 1].id : 0;
    },
  },
  methods: {
    getData() {
      try {
        let response = fetch(`${this.baseUrl}?page=${this.page}&per_page=${this.perPage}`)
          .then((response) => response.json())
          .then((json) => {
            this.totalPages = json.total_pages;
            this.totalData = json.total;
            this.users = json.data;
          });
      } catch (err) {

      }
    },
    test(page) {
      this.page = page;
    },
  },
  watch: {
    page: {
      immediate: true,
      handler(newVal, oldVal) {
        this.getData();
      },
    },
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
