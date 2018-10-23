package kame.spring.guestbook.dao.hibernate;

import java.util.List;

import kame.spring.guestbook.dao.MessageDao;
import kame.spring.guestbook.service.Message;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateMessageDao extends HibernateDaoSupport implements
		MessageDao {

	@Override
	public void insert(Message message) {
		getHibernateTemplate().save(message);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int selectCount() {
		List result = getHibernateTemplate().find(
				"select count(*) from Message");
		return ((Number) result.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> selectList(int page, final int pageSize) {
		int startRow = (page - 1) * pageSize;
		DetachedCriteria criteria = DetachedCriteria.forClass(Message.class);
		criteria.addOrder(Order.desc("id"));
		return getHibernateTemplate().findByCriteria(criteria, startRow,
				pageSize);

		/* execute() 메서드 사용 예
		final int startRow = (page - 1) * pageSize;
		Object result = getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Message.class);
				criteria.addOrder(Order.desc("id"));
				criteria.setFirstResult(startRow);
				criteria.setMaxResults(pageSize);
				return criteria.list();
			}
		});
		return (List<Message>) result;
		*/
	}

	
}
