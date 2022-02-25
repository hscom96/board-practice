import { createStore } from 'vuex'
import createPersistedState from 'vuex-persistedstate'

import user from './user'
import article from './article'
import comments from './comments'


const store = createStore({
  plugins: [createPersistedState()],
  modules: {
    user,
    article,
    comments
  }
})

export default store
