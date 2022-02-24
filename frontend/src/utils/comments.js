import commentsApi from './api/comments'

export default async (articleId) => {
  const commentInfo = commentsApi.getComments(articleId).then(result => result.data.data)

  // 댓글 계층구조 데이터 생성
  const commentList = [...commentInfo.content]
  const comments = []
  for(const comment of commentList) {
    const { parent_id } = comment
    if(parent_id === -1) {
      comments.push({ 
        value: comment,
        subComments: []
      })
    }
    else {
      const idx = comments.findIndex(d => d.value.comment_id === parent_id)
      comments[idx].subComments.push({ value: comment })
    }
  }
  
  const result = [...comments]

  return result
}
