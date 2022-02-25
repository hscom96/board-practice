import axios from 'axios'

const SERVER_URL = 'http://localhost:8282'

export default async (page, size) => {
  return axios({
    url: SERVER_URL + `/article?page=${page}&size=${size}`,
    method: 'get',
  })
}
