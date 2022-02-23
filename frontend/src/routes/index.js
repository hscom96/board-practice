import { createRouter, createWebHistory } from 'vue-router'
import Home from '~/views/Home'
import Login from '~/views/user/Login'
import Signup from '~/views/user/Signup'
import Write from '~/views/Write'
import ArticleDetail from '~/views/article/ArticleDetail'
import ArticleList from '~/views/article/ArticleList'

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
      path: '/write',
      name: 'Write',
      component: Write
    },
    {
      path: '/article',
      name: 'ArticleList',
      component: ArticleList
    },
    {
      path: '/article/:articleId',
      name: 'ArticleDetail',
      component: ArticleDetail
    },
  ]
})
