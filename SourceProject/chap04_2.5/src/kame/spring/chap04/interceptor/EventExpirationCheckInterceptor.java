package kame.spring.chap04.interceptor;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class EventExpirationCheckInterceptor extends HandlerInterceptorAdapter {

	private Date eventExpirationDate;

	public EventExpirationCheckInterceptor() {
		this.eventExpirationDate = new Date(System.currentTimeMillis()+10000);
	}
	
	public void setEventExpirationDate(Date eventExpirationDate) {
		this.eventExpirationDate = eventExpirationDate;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (checkEventExpiration()) {
			displayEventExpirationPage(request, response);
			return false;
		}
		return true;
	}

	private void displayEventExpirationPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response
				.sendRedirect(request.getContextPath() + "/eventExpiration.html");
	}

	private boolean checkEventExpiration() {
		return System.currentTimeMillis() > eventExpirationDate.getTime();
	}

}
