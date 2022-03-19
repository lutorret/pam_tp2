# Application TP2
Application affichant une liste de blagues.
Possibilité d'appuyer sur une blague pour la voir en entier et de retourner sur la liste.

Utilise une RecyclerView pour la liste des blagues.
utilise un ViewModel avec LiveData pour recupérer et afficher les éléments.
Possède 2 activités :
* MainActivity : contient un fragment qui contient la RecyclerView
* JokeActivity : écran de blague détaillé

API Android minimum : 30