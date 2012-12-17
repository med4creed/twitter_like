package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Groupe;
import models.Utilisateur;

import org.codehaus.jackson.JsonNode;

import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.utilisateur;

@Security.Authenticated(Autorisation.class)
public class ApplicationGroupes extends Controller {

	static Form<Groupe> grpForm = form(Groupe.class);

	public static Result index() {
		return redirect(routes.ApplicationGroupes.getAllGroupes());
	}

	public static Result getAllGroupes() {

		List<Groupe> groupes = Groupe.findAllGroupes();
		if (request().accepts("text/html")) {
			return ok(views.html.groupe.render(groupes, grpForm));

		}

		JsonNode resultJson = Json.newObject();
		resultJson = Json.toJson(groupes);

		return ok(resultJson);

	}

	public static Result getGroupeById(Long idGroupe) {

		Groupe grp = Groupe.findGroupeById(idGroupe);
		Logger.info("users: " + grp.getMembers().size());

		if (request().accepts("	text/html")) {
			return ok(grp.toString());
		}
		JsonNode grpJson = Json.newObject();
		grpJson = Json.toJson(grp);
		return ok(grpJson);

	}

	public static Result getAllGroupesByUserId(Long idUser) {
		List<Groupe> adminGrps = Utilisateur.findUserById(idUser)
				.getAdminGrps();
		if (request().accepts("	text/html")) {
			return ok(adminGrps.toString());
		}
		JsonNode adminGrpsJson = Json.newObject();
		adminGrpsJson = Json.toJson(adminGrps);
		return ok(adminGrpsJson);
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
			if (request().accepts("text/html")) {
				Form<Groupe> filledForm = grpForm.bindFromRequest();
				Groupe grp = Groupe.findGroupeById(idGroupe);

				grp.setNomGroupe(filledForm.data().get("nomGroupe"));

				Groupe.updateGroupe(grp);

				return redirect(routes.ApplicationGroupes.getAllGroupes());
			}
			JsonNode grpJson = request().body().asJson();
			Groupe grp = Groupe.findGroupeById(idGroupe);

			grp.setNomGroupe(grpJson.get("nomGroupe").getTextValue());

			Groupe.updateGroupe(grp);

			return ok(Json.toJson(grp));
		} else {
			return badRequest("you don't have permission for that!!!");
		}

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