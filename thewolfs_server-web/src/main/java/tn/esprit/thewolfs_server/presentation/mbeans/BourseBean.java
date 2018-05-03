package tn.esprit.thewolfs_server.presentation.mbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Utils.Bourse;

@ManagedBean
@ViewScoped
public class BourseBean {
	private List<Bourse> listBourse;
	
	 public BourseBean() {
		listBourse=new ArrayList<>();
	}
	
	@PostConstruct
	public void initialize() 
	{
		listBourse=getBourses();
	}

public List<Bourse> getBourses(){
		
		List<Bourse>bourses =new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect("https://www.ilboursa.com/marches/aaz.aspx").timeout(10000).validateTLSCertificates(false).get();
	

		Element tabQuote = doc.getElementById("tabQuotes");
		// System.out.println(tabQuote);
 
		Element tabBody = tabQuote.getElementsByTag("tbody").get(0);
		Elements tabRows = tabBody.getElementsByTag("tr");
		for (Element row : tabRows) {
			
		
			
			Elements columns = row.select("td");
			String libelle = columns.get(0).text();
			String ouverture = columns.get(1).text();
			String haut = columns.get(2).text();
			String bas = columns.get(3).text();
			String volume_titre = columns.get(4).text();
			String volume_dt = columns.get(5).text();
			String cloture = columns.get(6).text();
			String variation = columns.get(7).text();

			
			Bourse b =new Bourse();
			b.setPrice(ouverture);
			b.setName(libelle);
	        b.setHaut(haut);
	        b.setBas(bas);
	        b.setVolumeTitre(volume_titre);
	        b.setVolumeDt(volume_dt);
	        b.setCloture(cloture);
	        b.setVariation(variation);
	        

			bourses.add(b);

		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Bourse bourse : bourses )
		{
			System.out.println(bourse.getPrice()+" "+ bourse.getName());
		}
		
		
		
		
		
		return bourses;
	}
	public List<Bourse> getListBourse() {
		return listBourse;
	}

	public void setListBourse(List<Bourse> listBourse) {
		this.listBourse = listBourse;
	}
}
