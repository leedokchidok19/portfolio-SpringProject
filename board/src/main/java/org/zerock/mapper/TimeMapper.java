package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	/**
	 * MyBatis-Spring의 경우 Mapper 인터페이스와 XML을 동시에 사용가능하다.
	 * XML 사용 시  XML의 파일위치, XML파일에  지정하는 namespace속성이 중요하다.
	 * Mapper 인터페이스와 XML을 같이 이용해 보기 위해서 기존의 TimeMapper 인터페이스에
	 * 추가적인 메소드 선언해야 한다.
	 * */
	
	//Mapper
	@Select("SELECT NOW() FROM dual")//Oracle - "SELECT sysdate FROM dual"
	public String getTime();
	
	//XML - 실제 SQL은 XML을 이용해서 처리
	public String getTime2();
	
}
