package tn.esprit.thewolfs_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.thewolfs_server.entity.Account;
import tn.esprit.thewolfs_server.entity.Asset;
import tn.esprit.thewolfs_server.entity.Watchlist;

@Stateless
public class AssetServices implements AssetServiceRemote{
	
	@PersistenceContext(unitName="thewolfs_server-ejb")
	EntityManager em;
	

		@Override
		public Asset displayAssetById(Integer id) {
			TypedQuery<Asset> query=em.createQuery("SELECT c FROM Watchlist c WHERE c.id= :id",Asset.class);
			
			return query.setParameter("id", id).getSingleResult();
		}


		@Override
		public void addAsset(Asset asset) {
			
			em.persist(asset);
		}


		@Override
		public void updateAsset(Asset asset) {
			
			em.merge(asset);
		}


		@Override
		public void deleteAsset(int Asset_id) {
			
			Asset asset=em.find(Asset.class,Asset_id);
			em.remove(asset); 
		}


		@Override
		public List<Asset> displayAllAssets() {
			TypedQuery<Asset> query=em.createQuery("SELECT c FROM Asset c",Asset.class);
			return (query.getResultList());
		}


		/*@Override
		public List<Asset> displayAllAssets() {
			TypedQuery<Asset> query=em.createQuery("SELECT c FROM Asset c",Asset.class);
			return (query.getResultList());
		}
*/

	
		
}

