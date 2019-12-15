package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor//lombok과 생성자 자동 주입을 결합
@RequiredArgsConstructor// 여러개의 인스턴스 변수들 중에서 특정한 변수에 대해서만 생성자를 작성하고 싶을 때
public class SampleHotel {
	
	@NonNull// @RequiredArgsConstructor 을 이용해서 특정한 변수만 생성자 자동 주입, final이 붙은 변수도 생성자 생성
	private Chef chef;
	
	/*
	 * public SampleHotel(Chef chef) {//생성자 자동 주입을 이용한 방법 this.chef = chef; }
	 */
}
