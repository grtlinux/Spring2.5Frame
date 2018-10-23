package kame.spring.chap05.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LocaleChangeController extends AbstractController {

	private LocaleResolver localeResolver;

	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String language = request.getParameter("language");
		if (language != null) {
			Locale locale = new Locale(language);
			localeResolver.setLocale(request, response, locale);
		}
		return new ModelAndView("redirect:/index.html");
	}

}
