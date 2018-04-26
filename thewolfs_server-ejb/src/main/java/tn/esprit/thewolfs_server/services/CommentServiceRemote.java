package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Comment;


@Remote
public interface CommentServiceRemote {
	public int addComment(Comment comment);
	public void updateComment(Comment comment);
	public void removeComment(Integer idComment);
	public List<Comment> displayAllComment();
	public List<Comment> findAllStatusComment(Integer statusTraderId);
}
