// 테스트용 딜레이 함수
const delay = (duration = 500) => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve()
    }, duration)
  })
}

export default async (page, size) => {
  await delay() // 테스트용 딜레이 함수 (-> Todo: axios.get 으로 변경)

  const result = {
    'message': 'success',
    'code': 0,
    'value': {
      'current_page': page,
      'total_page': 3,
      'content': []
    }
  }

  if(page + 1 > result.value.total_page) {
    throw new Error('더 이상 페이지가 존재하지 않습니다')
  }

  for(let i = 0; i < size; i++) {
    const dummy = {
      'article_id': page*size + i,
      'label': Math.floor(Math.random()*2) ? '판매' : '구매',
      'title': `아이패드 팔아요${page*size + i} (실사용 6달, 생활 스크래치 있음)`,
      'content': '내용 없음',
      'image': '이미지 base64',
      'created_at': '2022-02-16 15:23:11',
      'created_by': `화내는 홍길동${page*size + i}`,
      'created_by_id': page*size + i,
      'modified_at': '2022-02-16 15:23:11',
      'modified_by': `화내는 홍길동${page*size + i}`,
      'modified_by_id': page*size + i,
      'view_count': Math.floor(Math.random() * 50),
      'like_cnt': Math.floor(Math.random() * 10),
      'sad_cnt': Math.floor(Math.random() * 20),
      'upset_cnt': Math.floor(Math.random() * 30),
      'comment_cnt': Math.floor(Math.random() * 50),
      'is_like' : false,
      'is_sad' : false,
      'is_upset' : false
    }
    result.value.content.push(dummy)
  }

  return result
}
