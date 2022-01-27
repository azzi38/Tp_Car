##Liste des commandes: 

user : permet d'entrer son login a la connection
pass : permet d'entrer son mot de passe
quit : permet de deconnecter le client 
list :  se declenche apres l'execution de la commande dir, permet de d'afficher la liste des fichiers ou dossier courant 
cwd : se declenche apres l'execution de la commande cd , permet de modifier le repertoire courant 

## Comment etendre le programme pour l'implementation de nouvelles commandes:

il suffit d'ajouter un if dans la partir qui interprete les commandes dans FtpThread avec la commande qu'on souhaite ajouter,et par la suite on doit defenir le comportement de la commande dans une focntion. 
