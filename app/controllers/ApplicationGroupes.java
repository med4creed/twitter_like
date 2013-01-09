package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Groupe;
import models.Message;
import models.Utilisateur;

import org.codehaus.jackson.JsonNode;


import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;


@Security.Authenticated(Autorisation.class)
public class ApplicationGroupes extends Controller {

	static Form<Groupe> grpForm = form(Groupe.class);
	static Form<Message> msgForm = form(Message.class);

	public static Result index() {
		return redirect(routes.ApplicationGroupes.getAllGroupes());
	}

	public static Result getAllGroupes() {
		List<Groupe> groupes = Groupe.findAllGroupes();
		return ok(views.html.groupe.render(groupes, grpForm));
	}
	

	public static Result getGroupeById(Long idGrp) {
		Groupe groupes = Groupe.findGroupeById(idGrp);
		List<Message> msgs = Groupe.findGroupeById(idGrp).getMsgs();
		return ok(views.html.groupe_msg.render(groupes, msgForm, msgs));
	}
	

	public static Result getAllGroupesByUserId(Long idUser) {
		List<Groupe> groupes = Utilisateur.findUserById(idUser).getGrps();
		//Logger.info("#############################"+groupes.get(0).toString());
		return ok(views.html.groupe.render(groupes, grpForm));

	}

	public static Result joinGroupe(Long idGroupe) {
		Utilisateur newMember = Utilisateur.findUserByEmail(session().get(
				"mail"));
		Groupe grp = Groupe.findGroupeById(idGroupe);
		if (!grp.getMembers().contains(newMember)) {
			grp.getMembers().add(newMember);
			Logger.info("list users avant :" + grp.getMembers().toString());
			grp.updateGroupe(grp);
			Logger.info("list users après: " + grp.getMembers().toString());
			return redirect(routes.ApplicationGroupes.getAllGroupes());
		} else {
			return redirect(routes.ApplicationGroupes.getAllGroupes());
		}
	}

	public static Result newGroupe() {
		Form<Groupe> filledForm = grpForm.bindFromRequest();
		Groupe grp = filledForm.get();
		Utilisateur admin = Utilisateur.findUserByEmail(session().get("mail"));
		grp.setUserAdmin(admin);
		Groupe.createGroupe(grp);
		return redirect(routes.ApplicationGroupes.getAllGroupes());
	}

	public static Result updateGroupeById(Long idGroupe) {
		if (Autorisation.isOwnerGroupe(idGroupe) || Autorisation.isAdmin()) {
				Form<Groupe> filledForm = grpForm.bindFromRequest();
				Groupe grp = Groupe.findGroupeById(idGroupe);

				grp.setNomGroupe(filledForm.data().get("nomGroupe"));

				Groupe.updateGroupe(grp);

				return redirect(routes.ApplicationGroupes.getAllGroupes());

		} else {
			return badRequest("you don't have permission for that!!!");
		}

	}
	
	
	public static Result newMessageGroupe(Long id) {

		Form<Message> filledForm = msgForm.bindFromRequest();
		
		if (filledForm.hasErrors()) {
			flash("error", "Merci de remplir le formulaire.");
		}
		else {
			Message msg = filledForm.get();
			Utilisateur user = Utilisateur.findUserByEmail(session().get("mail"));
			Groupe groupe = Groupe.findGroupeById(id);
			msg.setUser(user);
			msg.setGrp(groupe);
			Message.createMsg(msg);
		}
		return redirect(routes.ApplicationGroupes.getGroupeById(id));

	}
	

	public static Result deleteGroupeById(Long idGroupe) {
		if (Autorisation.isOwnerGroupe(idGroupe) || Autorisation.isAdmin()) {
			Groupe.deleteGroupe(idGroupe);
			return redirect(routes.ApplicationGroupes.getAllGroupes());
		} else {
			return badRequest("you don't have permission for that!!!");
		}
	}

}