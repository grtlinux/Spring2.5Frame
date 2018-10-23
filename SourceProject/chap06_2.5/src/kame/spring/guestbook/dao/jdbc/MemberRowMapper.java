package kame.spring.guestbook.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import kame.spring.guestbook.service.Message;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("GUESTBOOK_MESSAGE_ID"));
		message.setGuestName(rs.getString("GUEST_NAME"));
		message.setContent(rs.getString("CONTENT"));
		return message;
	}

}
