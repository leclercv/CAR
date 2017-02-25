Casier Sofian
Leclercq Vincent

TP3 CAR

UTILISATION :

Le .zip contient 2 programmes, le client et le serveur.
Le serveur doit être lancé avant le client pour que le programme fonctionne.

Pour lancer le programme, il suffit de se placer dans le dossier racine de chaque projet à l'aide de 2 terminaux et de taper les commandes :

java -jar dist/TP3_CAR_server.jar 
java -jar dist/TP3_CAR_Client.jar 

Il suffit ensuite de taper les commandes LIST, GET <nomdufichier> pour tester le programme.
Tapez quit pour fermer la connection avec le serveur.

Attention cependant, les PATH données pour les répertoires du dossier du serveur sont en absolu, il faut donc veiller à avoir un chemin correct dans la classe server.java.

Les tests présents dans le code sont générés par NetBeans, nous n'avons pas su un créer des originaux correspondants au sujet. 


FONCTIONNEMENT : 

La méthode start() se charge d'identifier la commande entrée par l'utilisateur à l'éxécution du programme.
Cette derniere va donc se servir de la méthode qui correspond a la commande, Get ou List.

La méthode get attend un nom de fichier en entré, ce qui lui permet d'aller chercher la ressource avec son chemin, ou de renvoyer une erreur si la ressource est introuvable.

La méthode list créée une ArrayList dans une boucle afin de renvoyer, ligne par ligne, les ressources disponibles sur le serveur.

