package kame.spring.guestbook.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import kame.spring.guestbook.dao.MessageDao;
import kame.spring.guestbook.service.Message;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class JpaMessageDao extends JpaDaoSupport implements MessageDao {

	@Override
	public void insert(Message message) {
		getJpaTemplate().persist(message);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int selectCount() {
		List result = getJpaTemplate().find("select count(m) from Message m");
		return ((Number) result.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> selectList(int page, int pageSize) {
		final int startRow = (page - 1) * pageSize;
		final int maxResult = pageSize;
		Object result = getJpaTemplate().execute(new JpaCallback() {
			@Override
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query query = em.createQuery("select m from Message m order by m.id desc");
				query.setFirstResult(startRow);
				query.setMaxResults(maxResult);
				return query.getResultList();
			}
		});
		return (List<Message>) result;
	}
}
