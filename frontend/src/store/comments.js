export default {
  namespaced: true,
  state: () => ({
    comments: []
  }),
  mutations: {
    'SET_COMMENTS': (state, value) => {
      state.comments = [...value]
    },
    'ADD_COMMENT': (state, value) => {
      state.comments.push(value)
    },
  },
  actions: {
    setComments({ commit }, value) {
      commit('SET_COMMENTS', value)
    },
    addComment({ commit }, value) {
      commit('ADD_COMMENT', value)
    }
  }
}
