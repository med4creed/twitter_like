package controllers;

import java.util.List;

import models.Groupe;
import models.Utilisateur;

import org.codehaus.jackson.JsonNode;

import controllers.ApplicationAuthentification.Login;

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
		List<Utilisateur> users = Utilisateur.findAllUsers();
		Long id = Long.parseLong(session().get("id"));
		return ok(views.html.utilisateur.render(users, userForm,id));
	}
	
	 public static Result getUtilisateurById(Long idUser) {
     Utilisateur util = Utilisateur.findUserById(idUser);
     return ok(views.html.profil.render(util, userForm));
	 }

	public static Result newUtilisateur() {
		Form<Utilisateur> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			flash("error", "Merci de remplir correctement le formulaire.");
			return redirect(routes.ApplicationAuthentification.index2());	
		}
		else {
			Utilisateur user = filledForm.get();
			Utilisateur.createUser(user);
			return redirect(routes.ApplicationUtilisateurs.getAllUtilisateurs());
		}
	}
	
	public static Result followUtilisateur(Long idUtilAsuivre){
		Utilisateur util = Utilisateur.findUserByEmail(session().get("mail"));
		Utilisateur utilAsuivre =  Utilisateur.findUserById(idUtilAsuivre);
		Logger.info("##################"+ util);
		Logger.info(utilAsuivre.getNom());
		util.setUsersFollow(utilAsuivre);
		Utilisateur.updateUser(util);
		return redirect(routes.ApplicationUtilisateurs.getAllUtilisateurs());
		
	}

	public static Result updateUtilisateurById(Long idUser) {
		if (Autorisation.isOwnerCompte(idUser))  {
			
				Form<Utilisateur> filledForm = userForm.bindFromRequest();
				Utilisateur user = Utilisateur.findUserById(idUser);
				
				//user.setMail(filledForm.data().get("mail"));
				//user.setMdp(filledForm.data().get("mdp"));
				user.setNom(filledForm.data().get("nom"));
				user.setPnom(filledForm.data().get("pnom"));
				user.setPseudo(filledForm.data().get("pseudo"));

				Utilisateur.updateUser(user);

				return redirect(routes.ApplicationUtilisateurs.getUtilisateurById(idUser));

		} else {
			return badRequest("you don't have permission for that!!!");
		}

	}

	public static Result deleteUtilisateurById(Long idUser) {
		
		if (Autorisation.isOwnerCompte(idUser) ) {
			Utilisateur.deleteUser(idUser);
			return redirect(routes.ApplicationAuthentification.logout());
		}
		
		else if (Autorisation.isAdmin()) {
			Utilisateur.deleteUser(idUser);
			return redirect(routes.ApplicationUtilisateurs.getAllUtilisateurs());
		} 
		
		else {
			return badRequest("you don't have permission for that!!!");
		}
		
	}
	
	
}


