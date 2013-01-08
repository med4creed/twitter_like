package controllers;

import java.util.ArrayList;
import java.util.Date;
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
public class ApplicationMessages extends Controller {

	static Form<Message> msgForm = form(Message.class);

	public static Result index() {
		return redirect(routes.ApplicationMessages.getAllMessages());
	}

	public static Result getAllMessages() {

		Logger.info("session= " + session().toString());

		//List<Message> msgs = Message.find.orderBy("id DESC").findList();
		List<Message> msgs = Message.findAllMsgs();

		if (request().accepts("text/html")) {
			return ok(views.html.message.render(msgs, msgForm));
		}
		JsonNode resultJson = Json.newObject();
		resultJson = Json.toJson(msgs);

		return ok(resultJson);
	}

	public static Result getAllMessagesByUserId(Long idUser) {

		List<Message> msgs = Utilisateur.findUserById(idUser).getMsgs();
		String nom = Utilisateur.findUserById(idUser).getNom();
		return ok(views.html.message_util.render(msgs, nom));

	}

	public static Result getMsgUsersASuivre() {

		Logger.info("getMsgUsersASuivre");
		Utilisateur user = Utilisateur.findUserByEmail(session().get("mail"));
		Logger.info("**********************");
		Logger.info("user " + user.getMail());
		List<Utilisateur> usersFollow = user.getUsersFollow();
		Logger.info("users to follow " + usersFollow.toString());
		List<Message> msgs = new ArrayList<Message>();

		msgs.addAll(user.getMsgs());
		for (Utilisateur u : usersFollow) {
			Logger.info("u.getMsgs() " + u.getMsgs());
			msgs.addAll(u.getMsgs());
		}
		return ok(views.html.message.render(msgs, msgForm));

	}

	public static Result getMessageById(Long idMsg) {

		Message msg = Message.findMsgById(idMsg);

//		if (request().accepts("	application/x-www-form-urlencoded")) {
//			return ok(msg.toString());
//		}
		JsonNode msgJson = Json.newObject();
		msgJson = Json.toJson(msg);
		return ok(msgJson);

	}

	public static Result newMessage() {

		Form<Message> filledForm = msgForm.bindFromRequest();
			
		if (filledForm.hasErrors()) {
			flash("error", "Merci de remplir le formulaire.");
		}
		else {
			Message msg = filledForm.get();
			Utilisateur user = Utilisateur.findUserByEmail(session().get("mail"));
			msg.setUser(user);
			Message.createMsg(msg);
		}	
		return redirect(routes.ApplicationMessages.getAllMessages());
	}
	

	public static Result deleteMessageById(Long id) {
		if (Autorisation.isOwnerMessge(id) || Autorisation.isAdmin()) {
			Message.deleteMsg(id);
			return redirect(routes.ApplicationMessages.getAllMessages());
		} else {
			return badRequest("you don't have permission for that!!!");
		}
	}

}