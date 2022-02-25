import { createRouter, createWebHistory } from 'vue-router'
import store from '~/store/'
import Login from '~/views/user/Login'
import Signup from '~/views/user/Signup'
import Write from '~/views/Write'
import Edit from '~/views/Edit'
import ArticleDetail from '~/views/article/ArticleDetail'
import ArticleList from '~/views/article/ArticleList'


const routes = [
  {
    path: '/',
    component: ArticleList,
    meta: { 
      requireAuth: true 
    }
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
    component: Write,
    meta: { 
      requireAuth: true 
    }
  },
  {
    path: '/edit/:id',
    name: 'Edit',
    component: Edit,
    meta: { 
      requireAuth: true 
    }
  },
  {
    path: '/article/:articleId',
    name: 'ArticleDetail',
    component: ArticleDetail,
    meta: { 
      requireAuth: true 
    }
  },
]


const router = createRouter({
  history: createWebHistory(),
  scrollBehavior: () => ({ top: 0 }),
  routes
})

router.beforeEach(function (to, from, next) {
  if (to.matched.some(function(routeInfo) {
    return routeInfo.meta.requireAuth
  })) {
    if (!store.state.user.userId) {
      next('/login')
    } else {
      next()
    }
  } else {
    if (to.name === 'Login' || to.name === 'Signup') {
      if (store.state.user.userId) {
        next('/')
      } else {
        next()
      }
    } else {
      next()
    }
  }
  
})

export default router
