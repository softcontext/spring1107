import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import About from '@/components/About'
import Coins from '@/components/Coins'
import Page from '@/components/Page'
import List from '@/components/List'
// The @ is just a nice alias for the /src directory

Vue.use(Router)
// tell Vue to use the vue-router plugin

export default new Router({
  routes: [
    { path: '/', name: 'HelloWorld', component: HelloWorld },
    { path: '/about', name: 'About', component: About },
    {
      path: '/coins/:id',
      name: 'Coins',
      component: Coins,
      props: (route) => {
        console.log(route.params.id);
      }
    },
    { path: '/page', name: 'Page', component: Page },
    { path: '/list', name: 'List', component: List },
  ]
})
