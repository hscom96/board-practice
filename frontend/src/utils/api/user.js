import axios from 'axios'

const SERVER_URL = 'http://localhost:8282'

export default {
  login(userData) {
    return axios({
      url: SERVER_URL + '/member/login',
      method: 'post',
      data: userData
    })
  },
  signup(userData) {
    return axios({
      url: SERVER_URL + '/member/register',
      method: 'post',
      data: userData
    })
  },
}
