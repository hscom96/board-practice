import commentsApi from './api/comments'

export default async (articleId) => {
  const commentInfo = await commentsApi.getComments(articleId).then(result => result.data.data.comments.comments)

  // 댓글 계층구조 데이터 생성
  const commentList = [...commentInfo]
  const comments = []
  for(const comment of commentList) {
    const { parentId } = comment
    if(parentId === -1) {
      comments.push({ 
        value: comment,
        subComments: []
      })
    }
    else {
      const idx = comments.findIndex(d => d.value.commentId === parentId)
      comments[idx].subComments.push({ value: comment })
    }
  }
  
  const result = [...comments]

  return result
}
