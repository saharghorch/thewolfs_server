package tn.esprit.thewolfs_server.services;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;

@Stateless
public class OptionsManager implements OptionsRemote {
@PersistenceContext (unitName="thewolfs_server-ejb")

	EntityManager em;
	public  int addOption(Options option) {
	em.persist(option);
		return option.getId();
	}
	@Override
	public void deleteOption(int id) {
		em.remove(em.find(Options.class,id));
	}
	@Override
	public Options getOptionById(int id) {
		
		return em.find(Options.class, id);
	}
	@Override
	public void UpdateOptionStatus(int id) {
		Options option = em.find(Options.class, id);
		option.setStatus(tn.esprit.thewolfs_server.entity.Status.Valid);
		
	}
	

}
