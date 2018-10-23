package kame.spring.controller;

import org.springframework.web.multipart.MultipartFile;

public class SubmitReportCommand {

	private String subject;
	private MultipartFile reportFile;
	private byte[] sourceCode;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public MultipartFile getReportFile() {
		return reportFile;
	}

	public void setReportFile(MultipartFile reportFile) {
		this.reportFile = reportFile;
	}

	public byte[] getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(byte[] sourceCode) {
		this.sourceCode = sourceCode;
	}

}
