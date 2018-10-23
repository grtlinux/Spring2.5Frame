package kame.spring.chap04.controller.annot;

import kame.spring.chap04.controller.SubmitReportCommand;
import kame.spring.chap04.controller.SubmitReportValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

@Controller
@RequestMapping("/annot/submitReport.do")
public class SubmitReportAnnotController {
	private Validator validator = new SubmitReportValidator();

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "submitReportFormUseAnnot";
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String onSubmit(@ModelAttribute("report")
	SubmitReportCommand command, BindingResult errors) throws Exception {
		validator.validate(command, errors);
		if (errors.hasErrors()) {
			return showForm();
		}
		System.out.println("주제: " +command.getSubject());
		System.out.println("업로드한 파일: "+ command.getReportFile().getOriginalFilename());
		System.out.println("소스 코드 크기: "+command.getSourceCode().length);
		return "submittedReport";
	}

}
