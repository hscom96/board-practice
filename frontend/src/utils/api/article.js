import axios from 'axios'
import store from '~/store/index.js'

const SERVER_URL = 'http://localhost:8282'

export default {
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
}
