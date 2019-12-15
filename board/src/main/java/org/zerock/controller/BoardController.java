package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
/**Task		URL				Method		Parameter		From		URL이동
 * 전체목록	/board/list		GET
 * 등록 처리	/board/register	POST		모든 항목			입력화면 필요	이동
 * 조회		/board/read		GET			bno=123
 * 삭제 처리	/board/modify	POST		bno				입력화면 필요	이동
 * 수정 처리	/board/remove	POST		모든 항목			입력화면 필요	이동* */
	private static Logger log = LoggerFactory.getLogger(BoardController.class);
//@AllArgsConstructor를 사용해서 자동 주입, 생략 시 @Setter(onMethod_={@Autowired}) 사용
	private BoardService service;
	/**목록*/
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		System.out.println("list실행");
		model.addAttribute("list", service.getList());
	}
	/**입력*/
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: " +board );
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		//redirect = response.sendRedirect()
		return "redirect:/board/list";
	}
	/**조회*/
	@GetMapping("/get")
	public void get(@RequestParam("bno") long bno, Model model ) {
	//@RequestParam 파라미터 이름과 변수 이름을 기준으로 동작하기 때문에 ("bno")생략 가능
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	/**수정*/
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr ) {
		log.info("modify:"+board);
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	/**삭제*/
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") long bno, RedirectAttributes rttr) {
		log.info("remove..."+bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
