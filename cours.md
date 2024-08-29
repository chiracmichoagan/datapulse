## Repository

 un repository est un composant de votre application qui gère les opération de persistence (CRUD) sur les entités dans un base de donnée . En gros c'est la couche qui nous permet parler à la la BDD sans se soucier des details.


 ## Annotation @Repository

 Elle ssert à marquer une classe comme étant un repository , c'est dire un endroit oû vous allez interragire avec base de donnée .

 ## Est - ce obligatoire 

 Non ! Quand on implement déja une interface comme ``JPaReppository``, Spring dectect automatiquement notre repository

## PathVariable vs @RequestBody vs @RequestParam

@PathVariable : on l'utilise pour extrait disons une partie variable dans notre chemin d'url.
@RequestBody  : on l'utilise quand on reçois des donées via post.
@RequestParam : on l'utilise quand on a des paramètres dand l'url sous la forme `?param=valeur`.