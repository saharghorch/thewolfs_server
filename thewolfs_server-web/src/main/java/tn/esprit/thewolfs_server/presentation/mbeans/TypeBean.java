package tn.esprit.thewolfs_server.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.thewolfs_server.entity.Type;

@ManagedBean
@ApplicationScoped
public class TypeBean {
public Type[] getTypes(){
	return Type.values();
}
}
