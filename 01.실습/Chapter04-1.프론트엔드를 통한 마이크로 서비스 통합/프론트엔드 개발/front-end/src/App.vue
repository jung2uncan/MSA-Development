<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>

       <shoppingOrder :order="order" v-for="(order, index) in orders" v-bind:key="index"/>
    </v-main>
  </v-app>
</template>

<script>
//import HelloWorld from './components/HelloWorld';
import ShoppingOrder from './components/ShoppingOrder'

//axios 라이브러리를 가져오기 위함. (터미널창에서 npm install axios 으로 다운 필요)
const axios = require('axios').default;

export default {
  name: 'App',

  components: {
   ShoppingOrder
  },

  data: () => ({
    //상품정보
    //products:[],

    //주문정보
    orders: []
  }),

  async created() {
      //Axios : Vue에서 권고하는 브라우저, Node.js를 위한 Promise API를 활용하는 HTTP 비동기 통신 라이브러리
      var temp = await axios.get('https://8088-labs--317592847.kuberez.io/orders')

      //console.log(temp.data._embedded.products)
      //this.products = temp.data._embedded.products;
      
      console.log(temp.data._embedded.orders)
      this.orders = temp.data._embedded.orders;


  }
};
</script>


//주문하기 : http http://localhost:8088/orders productId=3