<template>
<div>
  <p>Name: {{ coin.name }}</p>
  <p>Symbol: {{ coin.symbol }}</p>
  <p>Price (USD): {{ coin.price_usd }}</p>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Coins',
  data() {
    return {
      coin: {}
    }
  },
  created() {
    this.fetchData()
  },
  watch: {
    '$route': 'fetchData'
    // want to rerender when the :id parameter in $route changes and then fetch new data.
    // get the parameter from the $route object params property
    // This object is auto injected by VueRouter.
  },
  methods: {
    fetchData() {
      axios.get('https://api.coinmarketcap.com/v1/ticker/' + this.$route.params.id + '/')
        .then((resp) => {
          this.coin = resp.data[0]
          console.log(resp)
        })
        .catch((err) => {
          console.log(err)
        })
    }
  }
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
