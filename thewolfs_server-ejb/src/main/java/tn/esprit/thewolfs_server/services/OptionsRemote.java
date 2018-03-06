package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewolfs_server.entity.Options;
import tn.esprit.thewolfs_server.entity.Status;

@Remote
public interface OptionsRemote {
public int addOption(Options option);
public void deleteOption(int id);
public Options getOptionById(int id);
public void UpdateOptionStatus(int id,Status status);
public List<Options> findAll();

}
