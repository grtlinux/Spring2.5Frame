package kame.spring.guestbook.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kame.spring.guestbook.dao.MessageDao;
import kame.spring.guestbook.service.Message;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SimpleTemplateMessageDao implements MessageDao {

	private SimpleJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String INSERT_SQL = "insert into GUESTBOOK_MESSAGE (GUEST_NAME, CONTENT) values (?, ?)";

	@Override
	public void insert(Message message) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("guestName", message.getGuestName());
		params.put("content", message.getContent());

		jdbcTemplate.update(INSERT_SQL, new Object[] { message.getGuestName(),
				message.getContent() });
	}

	private String SELECT_COUNT_SQL = "select count(*) from GUESTBOOK_MESSAGE";

	@Override
	public int selectCount() {
		return jdbcTemplate.queryForInt(SELECT_COUNT_SQL);
	}

	private static final String SELECT_LIST_SQL = "select * from GUESTBOOK_MESSAGE order by GUESTBOOK_MESSAGE_ID desc limit ?, ?";

	@Override
	public List<Message> selectList(int page, int pageSize) {
		int startRow = (page - 1) * pageSize;
		List<Message> list = jdbcTemplate.query(SELECT_LIST_SQL,
				new ParameterizedRowMapper<Message>() {
					@Override
					public Message mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Message message = new Message();
						message.setId(rs.getInt("GUESTBOOK_MESSAGE_ID"));
						message.setGuestName(rs.getString("GUEST_NAME"));
						message.setContent(rs.getString("CONTENT"));
						return message;
					}
				}, startRow, pageSize);
		return list;
	}

}
