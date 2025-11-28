package tp11.activite.bcd

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ListeEntiersTrisTest {
/*
    // === Tests du tri par insertion

    @Test
    fun `test tri par insertion sur liste vide`() {
        // given une liste vide
        val listeVide = ListeEntiers()
        assertTrue(listeVide.isEmpty())
        // When on commande le tri par insertion
        listeVide.triParInsertion()
        // Then: la lsite est toujours vide
        assertTrue(listeVide.isEmpty())
    }

    @Test
    fun `test tri par insertion sur liste non triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -150, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri par insertion
        liste.triParInsertion()
        // Then: la liste est triée
        assertTrue(liste.egale(ListeEntiers(intArrayOf(-150, -20, -10, 12, 15, 1000))))
    }

    @Test
    fun `test tri par insertion sur liste non triée avec doublon`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -20, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri par insertion
        liste.triParInsertion()
        // Then: la liste est triée
        assertTrue(liste.egale(ListeEntiers(intArrayOf(-20, -20, -10, 12, 15, 1000))))
    }

    @Test
    fun `test tri par insertion sur liste triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, 42, 120, 1000, 20000)
        val liste = ListeEntiers(tab)
        // When on commande le tri par insertion
        liste.triParInsertion()
        // Then: la liste est triée
        assertTrue(liste.egale(ListeEntiers(intArrayOf(-10, 15, 42, 120, 1000, 20000))))
    }

    // === test de la fusion de deux listes triées

    @Test
    fun `test fusion de deux listes avec liste droite vide`() {
        // Given
        val listeG = ListeEntiers(intArrayOf(-12, -5, 18, 999, 12504))
        val listeD = ListeEntiers()
        // when
        val res = listeG.fusionne(listeD)
        // Then
        assertTrue(
            res.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 18, 999, 12504
                    )
                )
            )
        )
    }

    @Test
    fun `test fusion de deux listes avec liste gauche vide`() {
        // Given
        val listeG = ListeEntiers()
        val listeD = ListeEntiers(intArrayOf(-12, -5, 18, 999, 12504))
        // when
        val res = listeG.fusionne(listeD)
        // Then
        assertTrue(
            res.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 18, 999, 12504
                    )
                )
            )
        )
    }


    @Test
    fun `test fusion de deux listes non vide liste G plus grande`() {
        // Given
        val listeG = ListeEntiers(intArrayOf(12, 20, 55, 1000, 12500))
        val listeD = ListeEntiers(intArrayOf(-12, -5, 18, 999))
        // when
        val res = listeG.fusionne(listeD)
        // Then
        assertTrue(
            res.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 12, 18, 20, 55, 999, 1000, 12500
                    )
                )
            )
        )
    }

    @Test
    fun `test fusion de deux listes non vide liste D plus grande`() {
        // Given
        val listeD = ListeEntiers(intArrayOf(12, 20, 55, 1000, 12500))
        val listeG = ListeEntiers(intArrayOf(-12, -5, 18, 999))
        // when
        val res = listeG.fusionne(listeD)
        // Then
        assertTrue(
            res.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 12, 18, 20, 55, 999, 1000, 12500
                    )
                )
            )
        )
    }

    // === test du tri fusion

    @Test
    fun `test tri fusion sur liste vide`() {
        // given une liste vide
        val listeVide = ListeEntiers()
        assertTrue(listeVide.isEmpty())
        // When on commande le tri fusion
        val res = listeVide.listeTriee()
        // Then: la lsite est toujours vide
        assertTrue(res.isEmpty())
    }

    @Test
    fun `test tri fusion sur liste non triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -150, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.listeTriee()
        // Then: la liste est triée
        assertTrue(res.egale(ListeEntiers(intArrayOf(-150, -20, -10, 12, 15, 1000))))
    }

    @Test
    fun `test tri fusion sur liste non triée avec doublon`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -20, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.listeTriee()
        // Then: la liste est triée
        assertTrue(res.egale(ListeEntiers(intArrayOf(-20, -20, -10, 12, 15, 1000))))
    }

    @Test
    fun `test tri fusion sur liste triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, 42, 120, 1000, 20000)
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.listeTriee()
        // Then: la liste est triée
        assertTrue(res.egale(ListeEntiers(intArrayOf(-10, 15, 42, 120, 1000, 20000))))
    }
*/
}