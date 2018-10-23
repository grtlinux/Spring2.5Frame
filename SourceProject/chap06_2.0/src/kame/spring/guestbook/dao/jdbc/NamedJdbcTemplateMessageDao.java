package kame.spring.guestbook.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kame.spring.guestbook.dao.MessageDao;
import kame.spring.guestbook.service.Message;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class NamedJdbcTemplateMessageDao implements MessageDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String SELECT_COUNT_SQL = "select count(*) from GUESTBOOK_MESSAGE";

	@SuppressWarnings("unchecked")
	@Override
	public int selectCount() {
		Map paramMap = Collections.emptyMap();
		return jdbcTemplate.queryForInt(SELECT_COUNT_SQL, paramMap);
	}

	private static final String SELECT_LIST_SQL = "select * from GUESTBOOK_MESSAGE order by GUESTBOOK_MESSAGE_ID desc limit :startRow, :fetchSize";

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> selectList(int page, int pageSize) {
		int startRow = (page - 1) * pageSize;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", startRow);
		params.put("fetchSize", pageSize);
		List<Message> list = jdbcTemplate.query(SELECT_LIST_SQL, 
			params, 
			new RowMapper() {
				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Message message = new Message();
					message.setId(rs.getInt("GUESTBOOK_MESSAGE_ID"));
					message.setGuestName(rs.getString("GUEST_NAME"));
					message.setContent(rs.getString("CONTENT"));
					return message;
				}
			}
		);
		return list;
	}

	private static final String INSERT_SQL = "insert into GUESTBOOK_MESSAGE (GUEST_NAME, CONTENT) values (:guestName, :content)";

	@Override
	public void insert(Message message) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("guestName", message.getGuestName());
		params.put("content", message.getContent());

		jdbcTemplate.update(INSERT_SQL, params);
	}

}
