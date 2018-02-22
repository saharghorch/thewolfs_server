package tn.esprit.thewolfs_server.services;

import javax.ejb.Stateless;

@Stateless
public class HelloService implements HelloServiceLocal, HelloServiceRemote{

	@Override
	public String sayHello(String msg) {
		return msg;
	}

}
