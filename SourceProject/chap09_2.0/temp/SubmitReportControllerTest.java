package kame.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import junit.framework.TestCase;
import kame.spring.controller.SubmitReportCommand;
import kame.spring.controller.SubmitReportController;
import kame.spring.controller.SubmitReportValidator;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

public class SubmitReportControllerTest extends TestCase {

	private SubmitReportController reportController;
	private MockHttpServletResponse response = new MockHttpServletResponse();

	@Override
	protected void setUp() throws Exception {
		reportController = new SubmitReportController();
		reportController.setFormView("form");
		reportController.setSuccessView("success");
		reportController.setValidator(new SubmitReportValidator());
	}

	@SuppressWarnings("unchecked")
	public void testGet() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setMethod("GET");
		try {
			ModelAndView mav = reportController
					.handleRequest(request, response);
			assertEquals(reportController.getFormView(), mav.getViewName());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void testValidReportSubmit() throws IOException {
		MockMultipartHttpServletRequest multipartRequest = new MockMultipartHttpServletRequest();
		multipartRequest.setMethod("POST");
		multipartRequest.addFile(new MockMultipartFile("reportFile", "pom.xml",
				null, getBytesFromFile()));
		multipartRequest.addFile(new MockMultipartFile("sourceCode", "pom.xml",
				null, getBytesFromFile()));
		multipartRequest.addParameter("subject", "ажа╕");
		try {
			ModelAndView mav = reportController.handleRequest(multipartRequest,
					response);
			assertEquals(reportController.getSuccessView(), mav.getViewName());

			Map model = mav.getModel();
			SubmitReportCommand command = (SubmitReportCommand) model
					.get(reportController.getCommandName());
			assertNotNull(command);
			assertNotNull(command.getReportFile());
			assertEquals("pom.xml", command.getReportFile().getOriginalFilename());
			assertTrue(command.getReportFile().getSize() > 0);
			assertNotNull(command.getSourceCode());
			assertTrue(command.getSourceCode().length > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void testInvalidReportSubmit() throws IOException {
		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
		request.setMethod("POST");
		request.addFile(new MockMultipartFile("reportFile", "pom.xml", null,
				getBytesFromFile()));
		try {
			ModelAndView mav = reportController
					.handleRequest(request, response);
			assertEquals(reportController.getFormView(), mav.getViewName());

			Map model = mav.getModel();
			SubmitReportCommand command = (SubmitReportCommand) model
					.get(reportController.getCommandName());
			assertNotNull(command);
			assertTrue(command.getSourceCode() == null
					|| command.getSourceCode().length == 0);

			BindingResult result = (BindingResult) model
					.get(BindingResult.MODEL_KEY_PREFIX
							+ reportController.getCommandName());
			assertNotNull(result);

			checkFieldError(result, "subject", "required");
			checkFieldError(result, "sourceCode", "required");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void checkFieldError(BindingResult result, String fieldName,
			String errorCode) {
		assertTrue(result.hasFieldErrors(fieldName));
		assertEquals(1, result.getFieldErrors(fieldName).size());
		ObjectError fieldError = (ObjectError) result.getFieldErrors(fieldName)
				.get(0);
		for (String code : fieldError.getCodes()) {
			assertTrue(code.contains(errorCode));
		}
	}

	private byte[] getBytesFromFile() throws IOException {
		return FileCopyUtils.copyToByteArray(new File("src-test/sqlMapConfig.xml"));
	}
}
