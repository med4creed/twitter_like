twitter_like
============

US :
====

En tant que utilisateur je peux aller à la page d’accueille
GET 	/login
En tant que utilisateur je peux me connecter à mon compte
POST 	/login
En tant que utilisateur je peux me déconnecter
GET 	/logout


En tant que utilisateur je peux créer un compte
POST	/utilisateurs/create
En tant que utilisateur je peux consulter mon compte
GET	/utilisateurs/:idUser
En tant que utilisateur je peux mettre à jour mon compte
PUT	/utilisateurs/:idUser
En tant que utilisateur je peux supprimer mon compte
POST	/utilisateurs/:idUser/delete


En tant que utilisateur je peux créer un message
POST	/messages/create
En tant que utilisateur je peux consulter mes messages
GET	/messages/utilisateur/:idUser
En tant que utilisateur je peux consulter un message
GET     /messages/:idMsg
En tant que utilisateur je peux supprimer mon message
POST	/messages/:idMsg/delete


En tant que utilisateur je peux créer un groupe
POST	/groupes/create
En tant que utilisateur je peux consulter mes groupes
GET	/groupes/utilisateur/:idUser
En tant que utilisateur je peux consulter mon groupe
GET 	/groupes/:idGrp
En tant que utilisateur je peux mettre à jour mon groupe
PUT	/groupes/:idGrp
En tant que utilisateur je peux supprimer mon groupe
POST	/groupes/:idGrp/delete


En tant que utilisateur je peux consulter les profiles des autres utilisateurs
GET     /utilisateurs
En tant que utilisateur je peux consulter un profile d’un autre utilisateur
GET     /utilisateurs/:idUser


En tant que utilisateur je peux consulter les messages des autres utilisateurs
GET	/messages
En tant que utilisateur je peux consulter les messages d’un autre utilisateur
GET	/messages/utilisateur/:idUser


En tant que utilisateur je peux consulter les autres groupes
GET	/groupes
En tant que utilisateur je peux consulter les groupes dont je fais partie
GET	/groupes/utilisateur/:idUser
En tant que utilisateur je peux rejoindre un groupe d’un autre utilisateur
POST	/groupe/:idGrp/rejoindre


En tant que admin je peux supprimer un compte
POST	/utilisateurs/:idUser/delete
n tant que admin je peux supprimer un message
POST	/messages/:idMsg/delete
En tant que admin je peux supprimer un groupe
POST	/groupes/:idGrp/delete