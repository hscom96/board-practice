import axios from 'axios'

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
}
