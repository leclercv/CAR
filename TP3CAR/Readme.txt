Casier Sofian
Leclercq Vincent

TP3 CAR

Le .zip contient 2 programmes, le client et le serveur.
Le serveur doit être lancé avant le client pour que le programme fonctionne.

Pour lancer le programme, il suffit de se placer dans le dossier racine de chaque projet a l'aide de 2 terminaux et de taper les commandes :

java -jar dist/TP3_CAR_server.jar 
java -jar dist/TP3_CAR_Client.jar 

Il suffit ensuite de taper les commandes LIST, GET <nomdufichier> pour tester le programme.
Tapez quit pour fermer la connection avec le serveur.

Attention cependant, les PATH données pour les répertoires du dossier du serveur sont en absolu,
je n'ai pas réussi à les mettre en relatif. Il faut donc modifier le fichier server.java pour mettre
le path correct.
