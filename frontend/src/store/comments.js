export default {
  namespaced: true,
  state: () => ({
    comments: []
  }),
  mutations: {
    'SET_COMMENTS': (state, comments) => {
      state.comments = [...comments]
    },
    'REPLY_COMMENT': (state, addComment) => {
      const newComments = state.comments.map(comment => {
        if(comment.value.comment_id === addComment.value.parent_id) {
          comment.subComments = [...comment.subComments, addComment]
        }

        return comment
      })

      state.comments = [...newComments]
    },
    'ADD_COMMENT': (state, addComment) => {
      state.comments = [...state.comments, addComment]
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
    'EDIT_COMMENT': (state, value) => {
      const { editComment, text } = value
      if(editComment.parent_id === - 1) {
        const newComments = state.comments.map(comment => {
          if(comment.value.comment_id === editComment.comment_id) {
            comment.value = { ...comment.value, content: text }
          }
  
          return comment
        })
        state.comments = [...newComments]
      }
      else {
        const newComments = state.comments.map(comment => {
          if(comment.value.comment_id === editComment.parent_id) {
            const newSubComments = comment.subComments.map(sub => {
              if(sub.value.comment_id === editComment.comment_id) {
                sub.value.content = text
              }
      
              return sub
            })
            comment.subComments = [...newSubComments]
          }
  
          return comment
        })
        state.comments = [...newComments]
      }
    },
  },
  actions: {
    setComments({ commit }, comments) {
      commit('SET_COMMENTS', comments)
    },
    replyComment({ commit }, addComment) {
      commit('REPLY_COMMENT', addComment)
    },
    addComment({ commit }, addComment) {
      commit('ADD_COMMENT', addComment)
    },
    deleteComment({ commit }, deleteComment) {
      commit('DELETE_COMMENT', deleteComment)
    },
    editAndSetComment({ commit }, value) {
      commit('EDIT_COMMENT', value)
    },
  }
}
