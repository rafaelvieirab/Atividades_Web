import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false
Vue.prototype.records = JSON.parse(localStorage.getItem('records') || '[]');

new Vue({
  render: function (h) { return h(App) },
}).$mount('#app')
