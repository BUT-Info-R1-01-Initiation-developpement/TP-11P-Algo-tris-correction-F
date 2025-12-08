package tp11.activite.bcd

/**
 *  Tri la liste dans l'ordre croissant "en place".
 *  L'algorithme utilisé est l'algorithme de tri par insertion.
 *
 *  @return le nombre d'opérations réalisées
 */
fun ListeEntiers.triParInsertionInstrumentee(): Int {
    var nombreOperations = 0

    nombreOperations += 2  // un accès variable + une comparaison
    if (this.isEmpty()) {
        return nombreOperations
    }
    nombreOperations += 3 // 1 affectation (valeur de i) + 1 comparaison + 1 accès
    for (i in 1..<this.taille) {

        nombreOperations += 2  // un accès tableau par indice + une affectation
        val eltAInserer = this[i]
        nombreOperations += 2  // une opération élémentaire + une affectation
        var j = i - 1
        nombreOperations += 3 // 2 comparaisons + un accès tableau par indice
        while (j >= 0 && this[j] > eltAInserer) {
            nombreOperations += 3 // 2 accès tableau par indice + 1 affectation
            this[j + 1] = this[j]
            nombreOperations += 2 // une opération + une affectation
            j--
        }
        nombreOperations += 2 // un accès tableau par indice + une affectation
        this[j + 1] = eltAInserer

        nombreOperations += 2 // 1 affectation (valeur de i) + 1 comparaison
    }
    return nombreOperations
}

/**
 * Fusionne la liste courante triée avec la liste triée donnée
 *
 * @param listeDroite la liste donnée à fusionner avec la liste courante
 *
 * @return une instance de Pair contenant la nouvelle liste correspondant
 * à la fusion et le nombre d'opérations réalisées dans cette fusion
 *
 */
fun ListeEntiers.fusionneInstrumentee(listeDroite: ListeEntiers): Pair<ListeEntiers, Int> {
    var nombreOperations = 0

    nombreOperations += 2 // 2 affectations
    var i = 0   // index liste gauche
    var j = 0   // index liste droite

    nombreOperations += 6 // forfait création de liste vide (6) + 1 affectation
    val listeRes = ListeEntiers()
    // comparer et copier le plus petit élément
    nombreOperations += 4 // 2 accès contenu variable + 2 comparaisons
    while (i < this.taille && j < listeDroite.taille) {
        nombreOperations += 3 // 2 accès tableau + 1 comparaison
        if (this[i] <= listeDroite[j]) {
            nombreOperations += 3  // 2 accès liste + 1 comparaison + 1 affectation
            listeRes.ajoute(this[i])
            nombreOperations += 2 // 1 opération + 1 affectation
            i++
        } else {
            nombreOperations += 3  // 2 accès liste + 1 comparaison + 1 affectation
            listeRes.ajoute(listeDroite[j])
            nombreOperations += 2 // 1 opération + 1 affectation
            j++
        }
    }
    // compléter avec la liste dans laquelle il reste des éléments
    nombreOperations += 3 // 1 affectation (valeur de i) + 1 comparaison + 1 accès
    for (l in i..<this.taille) {
        nombreOperations +=3 // 2 accès tableau + 1 affectation
        listeRes.ajoute(this[l])

        nombreOperations += 2 // 1 affectation (valeur de i) + 1 comparaison
    }
    nombreOperations += 3 // 1 affectation (valeur de i) + 1 comparaison + 1 accès
    for (l in j..<listeDroite.taille) {
        nombreOperations +=3 // 2 accès tableau + 1 affectation
        listeRes.ajoute(listeDroite[l])

        nombreOperations += 2 // 1 affectation (valeur de i) + 1 comparaison
    }

    return Pair(listeRes,nombreOperations)
}

/**
 * @return une instance de Pair contenant la nouvelle liste triée
 * et le nombre d'opérations réalisées dans ce tri fusion
 */
fun ListeEntiers.listeTrieeInstrumentee(): Pair<ListeEntiers, Int> {
    var nombreOperations = 0

    nombreOperations += 2 // 1 accès variable + 1 affectation
    if (this.taille <= 1) {
        nombreOperations += 6 // forfait création de liste vide (6) + 1 affectation
        val res = ListeEntiers()
        if (this.taille == 1) {
            nombreOperations += 2 // 1 accès variable + 1 affectation
            res.ajoute(this[0])
        }
        return Pair(res, nombreOperations)
    }
    // Diviser la liste en deux moitiés
    nombreOperations += 3 // 1 accès variable + 1 op + 1 affectation
    val milieu = this.taille / 2

    val listeGInstrumentee = this.sliceInstrumentee(0 until milieu)
    val listeG = listeGInstrumentee.first
    nombreOperations += listeGInstrumentee.second + 1 // cout slice + 1 affectation

    val listeDInstrumentee = this.sliceInstrumentee(milieu..<this.taille)
    val listeD = listeDInstrumentee.first
    nombreOperations += listeDInstrumentee.second + 1 // cout slice + 1 affectation

    // trier de maniere recursive
    val listeGTriee = listeG.listeTrieeInstrumentee()
    nombreOperations++ // une affectation
    nombreOperations += listeGTriee.second // cour tri listeG
    val listeDTriee = listeD.listeTrieeInstrumentee()
    nombreOperations++ // une affectation
    nombreOperations += listeDTriee.second // cout tri listeD

    val listeFusinnee = listeGTriee.first.fusionneInstrumentee(listeDTriee.first)
    nombreOperations += listeFusinnee.second // cout fusion

    return Pair(listeFusinnee.first, nombreOperations)
}

fun ListeEntiers.sliceInstrumentee(indices: IntRange): Pair<ListeEntiers, Int> {
    var nombreOperations = 0
    nombreOperations += 4 // 2 accès + 2 comparaisons
    require(indices.first >= 0 && indices.last < this.taille)

    nombreOperations += 6 // forfait création de liste vide (5) + 1 affectation
    val res = ListeEntiers()

    nombreOperations += 3 // 1 affectation (valeur de i) + 1 comparaison + 1 accès
    for(i in indices) {
        nombreOperations += 2 // 1 accès variable + 1 affectation
        res.ajoute(this[i])
    }
    return Pair(res, nombreOperations)
}