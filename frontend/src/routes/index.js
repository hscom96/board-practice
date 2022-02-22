import { createRouter, createWebHistory } from 'vue-router'
import Home from '~/views/Home'
import Login from '~/views/user/Login'
import Signup from '~/views/user/Signup'
import Article from '~/views/article/Article'

export default createRouter({
  history: createWebHistory(),
  scrollBehavior: () => ({ top: 0 }),
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/signup',
      name: 'Signup',
      component: Signup
    },
    {
      path: '/article/:articleId',
      name: 'Article',
      component: Article
    },
  ]
})
