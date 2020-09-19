<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link>
      <router-link to="/comments">Comments</router-link>
      <router-link to="/photos">Photos</router-link>
      <router-link to="/posts">Posts</router-link>
      <router-link to="/todos">Todos</router-link>
      <router-link to="/users">Users</router-link> 
    </div>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
  padding: 10px;
  border-radius: 8px;
  text-decoration: none;
}


#nav a:hover {
  background-color: #62D9A3;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

#nav a.router-link-exact-active:hover {
  color: #F9F9F9;
}

.results {
  margin: 0 auto;
  width: 80%;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.results > h1 {
  margin-bottom: 50px;
}

</style>
