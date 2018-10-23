package kame.spring.chap05.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DownloadController implements Controller, ApplicationContextAware {

	private WebApplicationContext context = null;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File downloadFile = getFile(request);
		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	private File getFile(HttpServletRequest request) {
		String path = context.getServletContext().getRealPath(
				"/WEB-INF/files/tlemock-1.0.1-bin.zip");
		return new File(path);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

}
