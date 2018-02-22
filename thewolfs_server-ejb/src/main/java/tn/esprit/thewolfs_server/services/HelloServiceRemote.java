package tn.esprit.thewolfs_server.services;

import javax.ejb.Remote;

@Remote
public interface HelloServiceRemote {
String sayHello(String msg);
}
