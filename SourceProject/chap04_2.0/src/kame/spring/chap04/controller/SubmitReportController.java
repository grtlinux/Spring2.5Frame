package kame.spring.chap04.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SubmitReportController extends SimpleFormController {

	public SubmitReportController() {
		setCommandClass(SubmitReportCommand.class);
		setCommandName("report");
	}

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		SubmitReportCommand reportCommand = (SubmitReportCommand) command;
		// reportCommand�κ��� ���� ���� ���� ���� �� �˸��� ó���� �����Ѵ�.
		System.out.println(reportCommand.getSubject());
		return super.onSubmit(command);
	}

}
