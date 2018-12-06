<template>
  <div id="app">
    <img src="./assets/logo.png">
    <ul class="navi">
      <li><router-link :to="{ name: 'HelloWorld' }">Home</router-link></li>
      <!--
        uses a named route
        { path: '/', name: 'HelloWorld', component: HelloWorld }
      -->
      <li><router-link to="/about">About</router-link></li>
      <!--
        the standard method, just specifies the path we want to link to
        { path: '/about', name: 'About', component: About }
      -->
      <li><router-link to="/coins/bitcoin">Bitcoin</router-link></li>
      <li><router-link to="/page">Page</router-link></li>
      <li><router-link to="/list">List</router-link></li>
    </ul>
    <router-view/>
    <!--
      The router uses this tag as a container for rendering the different components
      tied to the different routes. Just think of it as a placeholder.
     -->
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.navi li {
  display: inline-block;
  margin-right: 20px;
}
</style>
