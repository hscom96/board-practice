import axios from 'axios'

const SERVER_URL = 'http://localhost:8282'

export default async (articleId) => {
  return axios({
    url: SERVER_URL + `/article/${articleId}`,
    method: 'get',
  })
}
