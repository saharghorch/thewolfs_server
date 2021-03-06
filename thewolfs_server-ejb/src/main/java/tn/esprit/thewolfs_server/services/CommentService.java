package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Comment;
import tn.esprit.thewolfs_server.entity.StatusTrader;

@Stateless
public class CommentService implements CommentServiceRemote{
	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
	@Override
	public int addComment(Comment comment) {
		em.persist(comment);
		return (comment.getId());
	}

	@Override
	public void updateComment(Comment comment) {
		em.merge(comment);
		
	}

	@Override
	public void removeComment(Integer idComment) {
		Comment comment=em.find(Comment.class, idComment);
		em.remove(comment);
		
	}

	@Override
	public List<Comment> displayAllComment() {
		TypedQuery<Comment> query=em.createQuery("SELECT c FROM Comment c",Comment.class);
		return (query.getResultList());
	}

	@Override
	public List<Comment> findAllStatusComment(Integer statusTraderId) {
		TypedQuery<Comment> query=em.createQuery("select DISTINCT c from Comment c join c.statusTrader s where s.id=:statusTraderId",Comment.class);
		query.setParameter("statusTraderId",statusTraderId);
		return query.getResultList();
	}

}
