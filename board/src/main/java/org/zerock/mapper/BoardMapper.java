package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	//insert만 처리되고 생성된 PK 값을 알 필요가 없는 경우
	public void insert(BoardVO board);
	//insert문이 실행되고 생성된 PK 값을 알아야 하는 경우
	public void insertSelectKey(BoardVO board);
	//존재하는 게시물 정보를 가져온다.
	public BoardVO read(long bno);
	//존재하는 게시물 삭제 - return int : 정상적으로 삭제되었을 시 1 반환 없으면 0
	public int delete(long bno);
	//
	public int update(BoardVO board);
}
