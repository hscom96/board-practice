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
        if(comment.value.commentId === addComment.value.parentId) {
          comment.subComments = [...comment.subComments, addComment]
        }

        return comment
      })

      state.comments = [...newComments]
    },
    'ADD_COMMENT': (state, addComment) => {
      console.log(state.comments, addComment)
      state.comments = [...state.comments, addComment]
    },
    'DELETE_COMMENT': (state, deleteComment) => {
      if(deleteComment.parentId === - 1) {
        const newComments = state.comments.filter(comment => comment.value.commentId !== deleteComment.commentId)
        state.comments = [...newComments]
      }
      else {
        const newComments = state.comments.map(comment => {
          if(comment.value.commentId === deleteComment.parentId) {
            const newSubComments = comment.subComments.filter(sub => sub.value.commentId !== deleteComment.commentId)
            comment.subComments = [...newSubComments]
          }
  
          return comment
        })
        state.comments = [...newComments]
      }
    },
    'EDIT_COMMENT': (state, value) => {
      const { editComment, text } = value
      if(editComment.parentId === - 1) {
        const newComments = state.comments.map(comment => {
          if(comment.value.commentId === editComment.commentId) {
            comment.value = { ...comment.value, content: text }
          }
  
          return comment
        })
        state.comments = [...newComments]
      }
      else {
        const newComments = state.comments.map(comment => {
          if(comment.value.commentId === editComment.parentId) {
            const newSubComments = comment.subComments.map(sub => {
              if(sub.value.commentId === editComment.commentId) {
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
