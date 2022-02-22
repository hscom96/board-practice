export default async (articleId) => {
  // Todo: axios get /article/{articeId} 추가
  const articleInfo = {
    'message': 'success',
    'code': 0,
    'value': {
      'article_id': articleId,
      'label': Math.floor(Math.random()*2) ? '판매' : '구매',
      'title': `${articleId} : 아이패드 팔아요(실사용 6달, 생활 스크래치 있음)`,
      'content': `판매가 : 1,100,000원
      
      21년9월 구매후 6개월 정도 사용 후 초기화 소장
      영등포 타임스퀘어 매장에서 직접 구매 모든 물품 정품
      새것과 동일한 상태입니다
      직거래,택배 가능합니다
      새 것 사시는 것 보다 조금 더 저렴하게 사시는 걸 추천드립니다 풀박스이며 충전기 같은 기타 물품들도 다 있습니다 거주지는 고척동입니다 총 1,350,000원 정도 들었습니다 편하게 연락 주세요 ㅎ`,
      'image': 'null',
      'created_at': '2022-02-16 15:23:11',
      'created_by': '화내는 고길동',
      'created_by_id': 0,
      'modified_at': '2022-02-16 15:23:11',
      'modified_by': '화내는 고길동',
      'modified_by_id': 0,
      'view_count': Math.floor(Math.random() * 50),
      'like_cnt': Math.floor(Math.random() * 10),
      'sad_cnt': Math.floor(Math.random() * 20),
      'upset_cnt': Math.floor(Math.random() * 30),
      'comment_cnt': Math.floor(Math.random() * 50),
      'is_like' : Math.floor(Math.random()*2) ? true : false,
      'is_sad' : Math.floor(Math.random()*2) ? true : false,
      'is_upset' : Math.floor(Math.random()*2) ? true : false,
    }
  }
  const result = {...articleInfo.value}

  return result
}
