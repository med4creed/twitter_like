twitter_like
============

US :

·	En tant que utilisateur je peux aller à la page d’accueille
o	GET 	/login 
·	En tant que utilisateur je peux me connecter à mon compte
o	POST 	/login 
·	En tant que utilisateur je peux me déconnecter
o	GET 	/logout


·	En tant que utilisateur je peux créer un compte
o	POST	/utilisateurs/create
·	En tant que utilisateur je peux consulter mon compte
o	GET	/utilisateurs/:idUser
·	En tant que utilisateur je peux mettre à jour mon compte
o	PUT	/utilisateurs/:idUser 
·	En tant que utilisateur je peux supprimer mon compte
o	POST	/utilisateurs/:idUser/delete


·	En tant que utilisateur je peux créer un message
o	POST	/messages/create
·	En tant que utilisateur je peux consulter mes messages
o	GET	/messages/utilisateur/:idUser
·	En tant que utilisateur je peux consulter un message
o	GET     /messages/:idMsg
·	En tant que utilisateur je peux supprimer mon message
o	POST	/messages/:idMsg/delete


·	En tant que utilisateur je peux créer un groupe
o	POST	/groupes/create
·	En tant que utilisateur je peux consulter mes groupes
o	GET	/groupes/utilisateur/:idUser
·	En tant que utilisateur je peux consulter mon groupe
o	GET 	/groupes/:idGrp
·	En tant que utilisateur je peux mettre à jour mon groupe
o	PUT	/groupes/:idGrp
·	En tant que utilisateur je peux supprimer mon groupe
o	POST	/groupes/:idGrp/delete


·	En tant que utilisateur je peux consulter les profiles des autres utilisateurs
o	GET     /utilisateurs
·	En tant que utilisateur je peux consulter un profile d’un autre utilisateur
o	GET     /utilisateurs/:idUser


·	En tant que utilisateur je peux consulter les messages des autres utilisateurs
o	GET	/messages
·	En tant que utilisateur je peux consulter les messages d’un autre utilisateur
o	GET	/messages/utilisateur/:idUser


·	En tant que utilisateur je peux consulter les autres groupes
o	GET	/groupes
·	En tant que utilisateur je peux consulter les groupes dont je fais partie
o	GET	/groupes/utilisateur/:idUser
·	En tant que utilisateur je peux rejoindre un groupe d’un autre utilisateur
o	POST	/groupe/:idGrp/rejoindre


·	En tant que admin je peux supprimer un compte
o	POST	/utilisateurs/:idUser/delete
·	En tant que admin je peux supprimer un message
o	POST	/messages/:idMsg/delete
·	En tant que admin je peux supprimer un groupe
o	POST	/groupes/:idGrp/delete
