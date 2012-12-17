package controllers;

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

@Security.Authenticated(Autorisation.class)
public class ApplicationUtilisateurs extends Controller {

	static Form<Utilisateur> userForm = form(Utilisateur.class);
	static Form<Groupe> grpForm = form(Groupe.class);

	public static Result index() {
		return redirect(routes.ApplicationUtilisateurs.getAllUtilisateurs());
	}

	public static Result getAllUtilisateurs() {

		// Autorisation.isAdmin();

		List<Utilisateur> users = Utilisateur.findAllUsers();
		Long id = Long.parseLong(session().get("id"));
		if (request().accepts("text/html")) {
			return ok(views.html.utilisateur.render(users, userForm,id));

		}

		JsonNode resultJson = Json.newObject();
		resultJson = Json.toJson(users);

		return ok(resultJson);

	}

	public static Result getUtilisateurById(Long idUser) {
		Utilisateur util = Utilisateur.findUserById(idUser);

//		if (request().accepts("	text/html")) {
//			return ok(util.toString());
//		}
		JsonNode utilJson = Json.newObject();
		utilJson = Json.toJson(util);
		return ok(utilJson);

	}

	public static Result newUtilisateur() {
		Form<Utilisateur> filledForm = userForm.bindFromRequest();
		Utilisateur user = filledForm.get();
		Utilisateur.createUser(user);
		return redirect(routes.ApplicationUtilisateurs.getAllUtilisateurs());
	}

	public static Result updateUtilisateurById(Long idUser) {
		if (Autorisation.isOwnerCompte(idUser) || Autorisation.isAdmin()) {
			if (request().accepts("text/html")) {
				Form<Utilisateur> filledForm = userForm.bindFromRequest();
				Utilisateur user = Utilisateur.findUserById(idUser);

				user.setMail(filledForm.data().get("mail"));
				user.setMdp(filledForm.data().get("mdp"));
				user.setNom(filledForm.data().get("nom"));
				user.setPnom(filledForm.data().get("pnom"));
				user.setPseudo(filledForm.data().get("pseudo"));

				Utilisateur.updateUser(user);

				return redirect(routes.ApplicationUtilisateurs
						.getAllUtilisateurs());
			}
			JsonNode userJson = request().body().asJson();
			Utilisateur user = Utilisateur.findUserById(idUser);

			user.setMail(userJson.get("mail").getTextValue());
			user.setMdp(userJson.get("mdp").getTextValue());
			user.setNom(userJson.get("nom").getTextValue());
			user.setPnom(userJson.get("pnom").getTextValue());
			user.setPseudo(userJson.get("pseudo").getTextValue());

			Utilisateur.updateUser(user);

			return ok(Json.toJson(user));
		} else {
			return badRequest("you don't have permission for that!!!");
		}

	}

	public static Result deleteUtilisateurById(Long idUser) {
		if (Autorisation.isOwnerCompte(idUser) || Autorisation.isAdmin()) {
			Logger.info("jss laaaaa");
			Utilisateur.deleteUser(idUser);
			return redirect(routes.ApplicationUtilisateurs.getAllUtilisateurs());
		} else {
			return badRequest("you don't have permission for that!!!");
		}
	}

}