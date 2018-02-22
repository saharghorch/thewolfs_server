package tn.esprit.thewolfs_server.services;

import javax.ejb.Local;

@Local
public interface HelloServiceLocal {
String sayHello(String msg);
}
