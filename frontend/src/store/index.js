import { createStore } from 'vuex'
import user from './user'
import article from './article'

export default createStore({
  modules: {
    user,
    article
  }
})
