import axios from 'axios'
import store from '~/store/index.js'

const SERVER_URL = 'http://localhost:8282'

export default {
  deleteArticle(userId, articleId) {
    return axios({
      url: SERVER_URL + `/article/${articleId}`,
      method: 'delete',
      headers: { 
        'userId': userId,
        'Content-Type': 'application/json'
      }
    })
  },
  createArticle(userData) {
    return axios({
      headers: {
        userId: store.state.user.userId
      },
      url: SERVER_URL + '/article',
      method: 'post',
      data: userData
    })
  },
  updateArticle(id, userData) {
    return axios({
      headers: {
        userId: store.state.user.userId
      },
      url: SERVER_URL + `/article/${id}`,
      method: 'put',
      data: userData
    })
  },
  getArticleDetail(id) {
    return axios({
      url: SERVER_URL + `/article/${id}`,
      method: 'get'
    })
  }
}
