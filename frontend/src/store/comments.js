export default {
  namespaced: true,
  state: () => ({
    comments: []
  }),
  mutations: {
    'SET_COMMENTS': (state, comments) => {
      state.comments = [...comments]
    },
    'ADD_COMMENT': (state, comment) => {
      state.comments.push(comment)
    },
    'DELETE_COMMENT': (state, deleteComment) => {
      if(deleteComment.parent_id === - 1) {
        const newComments = state.comments.filter(comment => comment.value.comment_id !== deleteComment.comment_id)
        state.comments = [...newComments]
      }
      else {
        const newComments = state.comments.map(comment => {
          if(comment.value.comment_id === deleteComment.parent_id) {
            const newSubComments = comment.subComments.filter(sub => sub.value.comment_id !== deleteComment.comment_id)
            comment.subComments = [...newSubComments]
          }
  
          return comment
        })
        state.comments = [...newComments]
      }
    },
    'EDIT_COMMENT': (state, editComment) => {
      const newComments = state.comments.map(comment => {
        if(comment.value.comment_id !== editComment.comment_id) {
          return { ...comment, content: editComment.content }
        }

        return comment
      })
      state.comments = [...newComments]
    },
  },
  actions: {
    setComments({ commit }, comments) {
      commit('SET_COMMENTS', comments)
    },
    addComment({ commit }, comment) {
      commit('ADD_COMMENT', comment)
    },
    deleteComment({ commit }, deleteComment) {
      commit('DELETE_COMMENT', deleteComment)
    },
    editComment({ commit }, editComment) {
      commit('EDIT_COMMENT', editComment)
    },
  }
}
