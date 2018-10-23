package kame.spring.guestbook.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import kame.spring.guestbook.dao.MessageDao;
import kame.spring.guestbook.service.Message;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

public class PureJdbcMessageDao implements MessageDao {

	private SQLExceptionTranslator exceptionTranslator = new SQLStateSQLExceptionTranslator();
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private static final String INSERT_SQL = "insert into GUESTBOOK_MESSAGE (GUEST_NAME, CONTENT) values (?, ?)";

	@Override
	public void insert(Message message) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DataSourceUtils.getConnection(dataSource);
			pstmt = conn.prepareStatement(INSERT_SQL);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw exceptionTranslator.translate("insert", INSERT_SQL, e);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}

	private String SELECT_COUNT_SQL = "select count(*) from GUESTBOOK_MESSAGE";

	@Override
	public int selectCount() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_COUNT_SQL);
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			throw exceptionTranslator.translate("selectCount",
					SELECT_COUNT_SQL, e);
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(stmt);
			JdbcUtils.closeConnection(conn);
		}
	}

	private static final String SELECT_LIST_SQL = "select * from GUESTBOOK_MESSAGE order by GUESTBOOK_MESSAGE_ID desc limit ?, ?";

	@Override
	public List<Message> selectList(int page, int pageSize) {
		int startRow = (page - 1) * pageSize;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataSourceUtils.getConnection(dataSource);
			pstmt = conn.prepareStatement(SELECT_LIST_SQL);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Message> messages = new ArrayList<Message>(pageSize);
				do {
					Message message = new Message();
					message.setId(rs.getInt("GUESTBOOK_MESSAGE_ID"));
					message.setGuestName(rs.getString("GUEST_NAME"));
					message.setContent(rs.getString("CONTENT"));
					messages.add(message);
				} while (rs.next());
				return messages;
			} else {
				return Collections.emptyList();
			}
		} catch (SQLException e) {
			throw exceptionTranslator.translate("selectList", SELECT_LIST_SQL,
					e);
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(pstmt);
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}

}
