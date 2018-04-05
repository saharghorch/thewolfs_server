package tn.esprit.thewolfs_server.services;
import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;

import java.util.List;


@Remote
public interface OptionsRemote {
public int addOption(Options option);
public void deleteOption(int id);
public Options getOptionById(int id);
public void UpdateOptionStatus(int id,Status status);
public List<Options> findAll();


}