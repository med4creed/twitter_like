import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Groupe;
import models.Message;
import models.Utilisateur;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {

	public void onStart(Application app) {

		Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml
				.load("initial-data.yml");

		/*
		if (Ebean.find(Utilisateur.class).findRowCount() == 0) {
			Logger.info("OK pour les utilisateurs");
			Ebean.save(all.get("utilisateurs"));
		}
		
		if (Ebean.find(Groupe.class).findRowCount() == 0) {
			Logger.info("OK pour les groupes");
			Ebean.save(all.get("groupes"));
		}
		
		Logger.info("avant messages");
		Logger.info("count messages"+Ebean.find(Message.class).findRowCount());
		if (Ebean.find(Message.class).findRowCount() == 0) {
			Logger.info("OK pour les messages");
			Ebean.save(all.get("messages"));
		}
		*/
		
		
//		Utilisateur user = Utilisateur.findUserById(1);
//		Logger.info("avant users :"+user.getUsers().size());
//		List<Utilisateur> l = new ArrayList<Utilisateur>();
//		l.add(Utilisateur.findUserById(2));
//		l.add(Utilisateur.findUserById(3));
//		user.setUsers(l);
//		
//		Utilisateur user1 = Utilisateur.findUserById(2);
//		List<Utilisateur> ll = new ArrayList<Utilisateur>();
//		ll.add(Utilisateur.findUserById(1));
//		ll.add(Utilisateur.findUserById(4));
//		user1.setUsers(ll);
//		Logger.info("après users: "+user.getUsers().size());
//		
//		Groupe grp = Groupe.findGroupeById(1);
//		Logger.info("avant grp: "+grp.getUsers().size());
//		grp.setUsers(l);
//		Logger.info("après grp: "+grp.getId()+"||"+grp.getUsers().size());
//		Groupe grp1 = Groupe.findGroupeById(2);
//		grp1.setUsers(ll);
		

		

	}

}