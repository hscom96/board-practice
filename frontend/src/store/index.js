import { createStore } from 'vuex'
import user from './user'
import article from './article'
import comments from './comments'

export default createStore({
  modules: {
    user,
    article,
    comments
  }
})
