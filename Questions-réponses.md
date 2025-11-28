# Questions réponses

### Activité B

1. Le type `Array<Int>` a été remplacé par le type `IntArray` dans la classe `ListeEntiers`. En consultant la documentation officielle de Kotlin, arriverez-vous à justifier ce choix d'implantation ? \
...

1. Un constructeur secondaire a été ajoutée à la classe.
   Même si la liste créée est vide, quelle est la capacité réelle
   de la liste ? \
    ...
2. La méthode `set()` a été implantée dans la classe.
   Qu'affiche le code suivant dans la console ?
    ```
    val liste = ListeEntiers(arrayOf(12, -4, 18)
    liste.set(1, 18)
    println(liste.contenuAsString())
    ```
    ...
3. Quelle syntaxe autorise l'utilisation du mot clé `operator` dans la signature de la méthode `set()` à la place de la notation `liste.set(1, 18)`&nbsp;? \
...
4. Quelle est la complexité de la méthode `egale()` dans le meilleur et le pire cas ? 
   - meilleur cas : ... 
   - pire cas : ...

5. La méthode `supprime()` est fournie dans une version peut-être différente de celle que vous avez produite. Quelle est la complexité de l'implantation proposée dans le pire cas ?\
...

### Activité D - 1

1. Qu'apportent les méthodes fournies dans le fichier `ListeEntiersInstrumentation.kt` par rapport aux méthodes que vous avez implantées précédemment ? \
...

2. Ces méthodes sont des méthodes de la classe `ListeEntiers` mais elles ne sont pas définies directement dans cette classe. Quelle est la _feature_ Kotlin qui permet cela ?
Donner le lien vers la documentation officielle décrivant cette possibilité offerte par le langage. \
...

3. Quelle est la stratégie mise en place sur les méthodes `fusionneInstrumentee()` et `listeTrieeInstrumentee()` pour récupérer la liste et le nombre d'opérations résultants de l'appel d'une de ces méthodes ? \
...

### Activité D - 3

À partir de quelle taille de liste, le tri fusion devient plus performant que le tri par insertion ? \
...