<template>
  <div id="page" class="d-flex flex-column align-items-center justify-content-center">
    <Header></Header>
    <Form></Form>
    <Table v-bind:records="records"></Table>
  </div>
</template>

<script>
import Header from './components/Header'
import Form from './components/Form'
import Table from './components/Table'

export default {
  name: 'App',
  components: {
    Header,
    Form,
    Table
  }, data: function(){
    return {
      records: this.records
    }
  }
}
</script>

<style>
#page {
  height: 100vh;
  width: 100vw;
  margin: 0 auto;
  box-sizing: border-box;
}
</style>
