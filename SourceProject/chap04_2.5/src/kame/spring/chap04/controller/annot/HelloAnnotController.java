package kame.spring.chap04.controller.annot;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloAnnotController {

	private static final String DEFAULT_ME = "나";
	
	private String me = DEFAULT_ME;

	public void setMe(String me) {
		this.me = me;
	}

	@RequestMapping("/annot/hello.do")
	public ModelAndView handleHello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", getGreeting());
		mav.addObject("me", me);
		return mav;
	}

	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <= 10) {
			return "좋은 아침입니다.";
		} else if (hour >= 12 && hour <= 15) {
			return "점심 식사는 하셨나요?";
		} else if (hour >= 18 && hour <= 22) {
			return "좋은 밤 되세요";
		}
		return "안녕하세요";
	}
}
