import axios from 'axios'

const SERVER_URL = 'http://localhost:8282'

export default {
  getReaction(userId, articleId) {
    return axios({
      url: SERVER_URL + `/reaction/article/${articleId}/isReact`,
      method: 'get',
      headers: { 
        'userId': userId, 
        'Content-Type': 'application/json'
      },
    })
  },
  addReaction(userId, articleId, type) {
    return axios({
      url: SERVER_URL + `/reaction/article/${articleId}?type=${type}`,
      method: 'post',
      headers: { 
        'userId': userId, 
        'Content-Type': 'application/json'
      },
    })        
  },
  cancelReaction(userId, articleId, type) {
    return axios({
      url: SERVER_URL + `/reaction/article/${articleId}?type=${type}`,
      method: 'delete',
      headers: { 
        'userId': userId, 
        'Content-Type': 'application/json'
      },
    })        
  }
}
