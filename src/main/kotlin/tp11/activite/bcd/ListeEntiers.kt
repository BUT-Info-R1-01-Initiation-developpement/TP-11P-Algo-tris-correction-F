package tp11.activite.bcd

import kotlin.ranges.until

/**
 * Classe représentant des Listes d'entiers (tableaux dynamiques d'entiers)
 */
class ListeEntiers(tabEntiers: IntArray) {

    private val capaciteInitiale = 500
    private var capaciteReelle = capaciteInitiale
    private var tableauEntiers = IntArray(capaciteReelle) // Array<Int?>(capaciteReelle) { null }

    var taille = 0
        private set // tricky : seul l'accès en modification est privé !

    init {
        this.ajoute(tabEntiers)
    }

    /**
     * Constructeur secondaire permettant de créer simplement
     * une liste vide
     */
    constructor() : this(IntArray(0))


    /**
     * Retourne l'élément de la liste à l'indice spécifié.
     *
     * @param i l'indice de l'élément dans la liste
     */
    operator fun get(i: Int): Int {
        require(i in indices()) { "Indice invalide." }
        return tableauEntiers[i]
    }

    /**
     * Met à jour la valeur de la liste référencé à l'indice donné.
     *
     * @param i l'indice
     * @param nouvelleValeur la nouvelle valeur à affecter à l'indice donné.
     */
    operator fun set(i: Int, nouvelleValeur: Int) {
        require(i in indices()) { "Indice invalide." }
        this.tableauEntiers[i] = nouvelleValeur
    }

    /**
     * @return true sur les deux listes contiennent les mêmes éléments
     */
    fun egale(listeEntiers: ListeEntiers): Boolean {
        if (this === listeEntiers) {
            return true
        }
        if (this.taille != listeEntiers.taille) {
            return false
        }
        for (i in listeEntiers.indices()) {
            if (this[i] != listeEntiers[i]) {
                return false
            }
        }
        return true
    }

    /**
     * Ajoute à la liste un nouvel entier.
     *
     * @param element l'entier à ajouter à la liste
     */
    fun ajoute(element: Int) {
        this.assureCapacite()
        this.tableauEntiers[taille] = element
        this.taille++
    }

    /**
     * Ajoute à la liste les entiers contenus dans le tableau.
     *
     * @param elements le tableau contenant les entiers à ajouter à la liste.
     *
     */
    fun ajoute(elements: IntArray) {
        this.assureCapacite(elements.size)
        for (element in elements) {
            this.ajoute(element)
        }
    }

    /**
     * Fournit le IntRange des indices valides
     *
     * @return le IntRange des indices valides
     */
    fun indices(): IntRange {
        return IntRange(0, taille - 1)
    }

    /**
     * Indique si la liste est vide
     *
     * @return true si la liste est vide, false sinon
     */
    fun isEmpty(): Boolean {
        return taille == 0
    }

    /**
     * @return le contenu textuel de la liste
     */
    fun contenuAsString(): String {
        if (this.isEmpty()) {
            return "[]"
        }
        var res = "["
        for (i in 0..<taille-1) {
            res += "${this[i]}, "
        }
        res += "${this[taille-1]}]"
        return res
    }

    /**
     * Cherche un élément donné dans la liste courante.
     * Recherche linéaire : complexité en O(n)
     *
     * @param element l'élément recherché
     *
     * @return le premier indice de l'élément dans la liste ou -1
     * si l'élément n'est pas dans la liste.
     */
    fun chercheAvecApprocheLineaire(element: Int): Int {
        for (i in this.indices()) {
            if (this[i] == element) {
                return i
            }
        }
        return -1
    }

    /**
     * Cherche un élément donné dans la liste courante supposée triée.
     * Recherche dichotomique : complexité en O(log n)
     *
     * Si la liste n'est pas triée, le résultat est aléatoire
     *
     * @param element l'élément recherché
     *
     * @return un indice de l'élément dans la liste ou -1
     * si l'élément n'est pas dans la liste.
     */
    fun chercheAvecApprocheDichotomique(element: Int): Int {
        var gauche = 0
        var droite = taille - 1
        while (gauche <= droite) {
            val i = (droite + gauche) / 2
            if (this[i] == element) {
                return i
            } else if (this[i] < element) {
                gauche = i + 1
            } else {
                droite = i - 1
            }
        }
        return -1
    }

    /**
     * Calcule et retourne le nombre occurrences de l'élément donné
     * dans la liste.
     * Recherche linéaire : complexité en O(n)
     *
     * @param element l'élément dont on cherche le nombre occurrences
     * @return le nombre d'occurrences de l'élément donné
     */
    fun nombreOccurences(element: Int): Int {
        var nombreOccurences = 0
        for (i in this.indices()) {
            if (this[i] == element) {
                nombreOccurences++
            }
        }
        return nombreOccurences
    }

    /**
     * Vide la liste de tous ses éléments.
     * Complexité : O(1) ! Yippeeehh
     */
    fun vide() {
        this.tableauEntiers = IntArray(capaciteInitiale)
        this.taille = 0
    }

    /**
     * Supprime l'élément à l'indice donné
     * <ul>
     *     <li> Complexité meilleur cas : O(1) (on supprime le dernier élement => on décrémente la taille)
     *     <li> Complexité pire cas : O(n) (on supprime le premier élément => décalage de tous les éléments à droite)
     * </ul>
     *
     * @param indice l'indice de l'élément à supprimer
     *
     * @throws IllegalArgumentException si l'indice n'est pas valide
     */
    fun supprimeA(indice: Int) {
        require(indice in indices()) { "Indice invalide." }
        for (i in indice until taille - 1) {
            this.tableauEntiers[i] = this.tableauEntiers[i + 1]
        }
        this.taille--
    }

    /**
     * Supprime la première occurence trouvée de l'élément donné
     *
     * @param element l'élément à supprimer
     *
     */
    fun supprime(element: Int) {
        val i = this.chercheAvecApprocheLineaire(element)
        if (i != -1) {
            this.supprimeA(i)
        }
    }


    /**
     *  Tri la liste dans l'ordre croissant "en place".
     *  L'algorithme utilisé est l'algorithme de tri par insertion.
     *  Complexité asymptotique : O(n^2)
     */
    fun triParInsertion() {
        if (this.isEmpty()) {
            return
        }
        for (i in 1..<this.taille) {
            val eltAInserer = this[i]
            var j = i - 1
            while (j >= 0 && this[j] > eltAInserer) {
                this[j + 1] = this[j]
                j--
            }
            this[j + 1] = eltAInserer
        }
    }


    /**
     * Fusionne la liste courante triée avec la liste triée donnée
     * Complexité pire cas : O(n)
     *
     * @param listeDroite la liste donnée à fusionner avec la liste courante
     *
     * @return une nouvelle liste correspondant à la fusion
     *
     */
    fun fusionne(listeDroite: ListeEntiers): ListeEntiers {
        var i = 0   // index liste gauche
        var j = 0   // index liste droite
        val listeRes = ListeEntiers()
        // comparer et copier le plus petit élément
        while (i < this.taille && j < listeDroite.taille) {
            if (this[i] <= listeDroite[j]) {
                listeRes.ajoute(this[i])
                i++
            } else {
                listeRes.ajoute(listeDroite[j])
                j++
            }
        }
        // compléter avec la liste dans laquelle il reste des éléments
        for (l in i..<this.taille) {
            listeRes.ajoute(this[l])
        }
        for (l in j..<listeDroite.taille) {
            listeRes.ajoute(listeDroite[l])
        }
        return listeRes
    }


    private fun slice(indices: IntRange): ListeEntiers {
        require(indices.first >= 0 && indices.last < this.taille)
        val res = ListeEntiers()
        for(i in indices) {
            res.ajoute(this[i])
        }
        return res
    }


    private fun assureCapacite() {
        if (this.taille == this.capaciteReelle) {
            this.augmenteCapacite()
        }
    }

    private fun assureCapacite(nbElementsAAjouter: Int) {
        val tailleFinale = this.taille + nbElementsAAjouter
        if (tailleFinale > this.capaciteReelle) {
            this.augmenteCapacite(tailleFinale)
        }
    }


    private fun augmenteCapacite(tailleAugmentation: Int = this.capaciteInitiale) {
        this.capaciteReelle += tailleAugmentation
        val nouveauTableauElements = IntArray(this.capaciteReelle)
        for (i in 0 until this.taille) {
            nouveauTableauElements[i] = this.tableauEntiers[i]
        }
        this.tableauEntiers = nouveauTableauElements
    }


}
