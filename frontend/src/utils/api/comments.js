import axios from 'axios'

const SERVER_URL = 'http://localhost:8282'

export default {
  getComments(articleId) {
    return axios({
      url: SERVER_URL + `/article/${articleId}/comment?page=1&size=100`,
      method: 'get'
    })
  },
  addComment(userId, articleId, commentData) {
    return axios({
      url: SERVER_URL + `/article/${articleId}/comment`,
      method: 'post',
      headers: { 
        'userId': userId, 
        'Content-Type': 'application/json'
      },
      data : JSON.stringify(commentData)
      // {
      //   "content" : String,
      //   "parentId" : Integer
      // }
    })        
  },
  editComment(userId, articleId, commentId, commentData) {
    return axios({
      url: SERVER_URL + `article/${articleId}/comment/${commentId}`,
      method: 'put',
      headers: { 
        'userId': userId,
        'Content-Type': 'application/json'
      },
      data : JSON.stringify(commentData)
      // {
      //   "content" : String,
      // }
    })        
  },
  deleteComment(userId, articleId, commentId) {
    return axios({
      url: SERVER_URL + `article/${articleId}/comment/${commentId}`,
      method: 'delete',
      headers: { 
        'userId': userId,
        'Content-Type': 'application/json'
      }
    })        
  },
}
