package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.thewolfs_server.entity.Level;



@ManagedBean
@ApplicationScoped
public class LevelBean {
	public Level[] getLevels()
	{
		return Level.values();
	}

}
