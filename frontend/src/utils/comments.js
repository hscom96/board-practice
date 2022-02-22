export default async (articleId) => {
  // Todo: axios get /article/{articleId}/comment?page={num}&size={num} 추가
  const commentInfo = {
    'message': 'success',
    'code': 0,
    'value': {
      'current_page': 0,
      'total_page': 0,
      'content': [
        {
          'comment_id' : 0,
          'parent_id' : -1,
          'article_id' : articleId,
          'content' : '첫번째 댓글',
          'created_at': '2022-02-16 15:23:11',
          'created_by': '홍길동1',
          'created_by_id': 0, 
          'modified_at': '2022-02-16 15:23:11',
          'modified_by': '홍길동1',
          'modified_by_id': 0,
        },
        {
          'comment_id' : 1,
          'parent_id' : 0,
          'article_id' : articleId,
          'content' : '첫번째-1 댓글 수정되지 않음',
          'created_at': '2022-02-16 15:25:11',
          'created_by': '홍길동1-1',
          'created_by_id': 1, 
          'modified_at': '2022-02-16 15:25:11',
          'modified_by': '홍길동1-1',
          'modified_by_id': 1,
        },
        {
          'comment_id' : 2,
          'parent_id' : 0,
          'article_id' : articleId,
          'content' : '첫번째-2 댓글 수정됨',
          'created_at': '2022-02-16 15:28:11',
          'created_by': '홍길동1-2',
          'created_by_id': 2, 
          'modified_at': '2022-02-16 15:30:51',
          'modified_by': '홍길동1-2',
          'modified_by_id': 2,
        },
        {
          'comment_id' : 3,
          'parent_id' : 0,
          'article_id' : articleId,
          'content' : '첫번째-1-3 댓글 수정되지 않음',
          'created_at': '2022-02-16 15:55:11',
          'created_by': '홍길동1-3',
          'created_by_id': 3, 
          'modified_at': '2022-02-16 15:55:11',
          'modified_by': '홍길동1-3',
          'modified_by_id': 3,
        },
        {
          'comment_id' : 4,
          'parent_id' : -1,
          'article_id' : articleId,
          'content' : '두번째 댓글 수정되지 않음',
          'created_at': '2022-02-17 15:55:11',
          'created_by': '홍길동2',
          'created_by_id': 4, 
          'modified_at': '2022-02-17 15:55:11',
          'modified_by': '홍길동2',
          'modified_by_id': 4,
        },
        {
          'comment_id' : 5,
          'parent_id' : -1,
          'article_id' : articleId,
          'content' : '세번째 댓글 수정됨',
          'created_at': '2022-02-17 15:55:11',
          'created_by': '홍길동3',
          'created_by_id': 5, 
          'modified_at': '2022-02-17 18:34:12',
          'modified_by': '홍길동3',
          'modified_by_id': 5,
        },
      ]
    }
  }

  // 댓글 계층구조 데이터 생성
  const commentList = [...commentInfo.value.content]
  const comments = []
  for(const comment of commentList) {
    const { parent_id } = comment
    if(parent_id === -1) {
      comments.push({ 
        comment,
        subComments: []
      })
    }
    else {
      const idx = comments.findIndex(d => d.comment.comment_id === parent_id)
      comments[idx].subComments.push(comment)
    }
  }
  
  const result = [...comments]

  return result
}
