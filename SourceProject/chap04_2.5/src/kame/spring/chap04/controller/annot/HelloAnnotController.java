package kame.spring.chap04.controller.annot;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloAnnotController {

	private static final String DEFAULT_ME = "��";
	
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
			return "���� ��ħ�Դϴ�.";
		} else if (hour >= 12 && hour <= 15) {
			return "���� �Ļ�� �ϼ̳���?";
		} else if (hour >= 18 && hour <= 22) {
			return "���� �� �Ǽ���";
		}
		return "�ȳ��ϼ���";
	}
}
