import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Users from '../views/Users.vue'
import Comments from '../views/Comments.vue'
import Photos from '../views/Photos.vue'
import Todos from '../views/Todos.vue'
import Posts from '../views/Posts.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/users',
    name: 'Users',
    component: Users
  },
  {
    path: '/comments',
    name: 'Comments',
    component: Comments
  },
  {
    path: '/photos',
    name: 'Photos',
    component: Photos
  },
  {
    path: '/posts',
    name: 'Posts',
    component: Posts
  },
  {
    path: '/todos',
    name: 'Todos',
    component: Todos
  },
  {
    path: '*',
    redirect: '/'
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
