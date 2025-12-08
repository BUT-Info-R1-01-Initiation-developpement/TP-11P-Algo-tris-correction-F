package tp11.activite.bcd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ListeEntiersTrisInstrumentesTest {

    // === Tests du tri par insertion

    @Test
    fun `test tri par insertion sur liste vide`() {
        // given une liste vide
        val listeVide = ListeEntiers()
        assertTrue(listeVide.isEmpty())
        // When on commande le tri par insertion
        val nbOp = listeVide.triParInsertionInstrumentee()
        // Then: la lsite est toujours vide
        assertTrue(listeVide.isEmpty())
        assertEquals(2, nbOp)
    }

    @Test
    fun `test tri par insertion sur liste non triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -150, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri par insertion
        val nbOp = liste.triParInsertionInstrumentee()
        // Then: la liste est triée
        assertTrue(liste.egale(ListeEntiers(intArrayOf(-150, -20, -10, 12, 15, 1000))))
        assertEquals(95, nbOp)
    }

    @Test
    fun `test tri par insertion sur liste non triée avec doublon`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -20, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri par insertion
        val nbOp = liste.triParInsertionInstrumentee()
        // Then: la liste est triée
        assertTrue(liste.egale(ListeEntiers(intArrayOf(-20, -20, -10, 12, 15, 1000))))
        assertEquals(95, nbOp)
    }

    @Test
    fun `test tri par insertion sur liste triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, 42, 120, 1000, 20000)
        val liste = ListeEntiers(tab)
        // When on commande le tri par insertion
        val nbOp = liste.triParInsertionInstrumentee()
        // Then: la liste est triée
        assertTrue(liste.egale(ListeEntiers(intArrayOf(-10, 15, 42, 120, 1000, 20000))))
        assertEquals(60, nbOp)
    }

    // === test de la fusion de deux listes triées

    @Test
    fun `test fusion de deux listes avec liste droite vide`() {
        // Given
        val listeG = ListeEntiers(intArrayOf(-12, -5, 18, 999, 12504))
        val listeD = ListeEntiers()
        // when
        val res = listeG.fusionneInstrumentee(listeD)
        // Then
        assertTrue(
            res.first.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 18, 999, 12504
                    )
                )
            )
        )
        assertEquals(43, res.second)
    }

    @Test
    fun `test fusion de deux listes avec liste gauche vide`() {
        // Given
        val listeG = ListeEntiers()
        val listeD = ListeEntiers(intArrayOf(-12, -5, 18, 999, 12504))
        // when
        val res = listeG.fusionneInstrumentee(listeD)
        // Then
        assertTrue(
            res.first.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 18, 999, 12504
                    )
                )
            )
        )
        assertEquals(43, res.second)
    }


    @Test
    fun `test fusion de deux listes non vide liste G plus grande`() {
        // Given
        val listeG = ListeEntiers(intArrayOf(12, 20, 55, 1000, 12500))
        val listeD = ListeEntiers(intArrayOf(-12, -5, 18, 999))
        // when
        val res = listeG.fusionneInstrumentee(listeD)
        // Then
        assertTrue(
            res.first.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 12, 18, 20, 55, 999, 1000, 12500
                    )
                )
            )
        )
        assertEquals(84, res.second)
    }

    @Test
    fun `test fusion de deux listes non vide liste D plus grande`() {
        // Given
        val listeD = ListeEntiers(intArrayOf(12, 20, 55, 1000, 12500))
        val listeG = ListeEntiers(intArrayOf(-12, -5, 18, 999))
        // when
        val res = listeG.fusionneInstrumentee(listeD)
        // Then
        assertTrue(
            res.first.egale(
                ListeEntiers(
                    intArrayOf(
                        -12, -5, 12, 18, 20, 55, 999, 1000, 12500
                    )
                )
            )
        )
        assertEquals(84, res.second)
    }

    // === test du tri fusion

    @Test
    fun `test tri fusion sur liste vide`() {
        // given une liste vide
        val listeVide = ListeEntiers()
        assertTrue(listeVide.isEmpty())
        // When on commande le tri fusion
        val res = listeVide.listeTrieeInstrumentee()
        // Then: la lsite est toujours vide
        assertTrue(res.first.isEmpty())
        assertEquals(8, res.second)
    }

    @Test
    fun `test tri fusion sur liste non triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -150, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.listeTrieeInstrumentee()
        // Then: la liste est triée
        assertTrue(res.first.egale(ListeEntiers(intArrayOf(-150, -20, -10, 12, 15, 1000))))
        assertEquals(470, res.second)
    }

    @Test
    fun `test tri fusion sur liste non triée avec doublon`() {
        // given une liste
        val tab = intArrayOf(-10, 15, -20, 12, 1000, -20)
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.listeTrieeInstrumentee()
        // Then: la liste est triée
        assertTrue(res.first.egale(ListeEntiers(intArrayOf(-20, -20, -10, 12, 15, 1000))))
        assertEquals(470, res.second)
    }

    @Test
    fun `test tri fusion sur liste triée`() {
        // given une liste
        val tab = intArrayOf(-10, 15, 42, 120, 1000, 20000)
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.listeTrieeInstrumentee()
        // Then: la liste est triée
        assertTrue(res.first.egale(ListeEntiers(intArrayOf(-10, 15, 42, 120, 1000, 20000))))
        assertEquals(458, res.second)
    }

    //=== Comparaison tri insertion / tri fusion

    @Test
    fun `test tri fusion sur liste aléatoires`() {
        // given une liste
        val tab = IntArray(1_000) { (-10000..10000).random()}
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.listeTrieeInstrumentee()
        // Then: la liste est triée
        println("Nombre operations tri fusion : ${res.second}")
        assertTrue(res.second < 160_000)
    }

    @Test
    fun `test tri insertion sur liste aléatoires`() {
        // given une liste
        val tab = IntArray(1000) { (-10000..10000).random()}
        val liste = ListeEntiers(tab)
        // When on commande le tri fusion
        val res = liste.triParInsertionInstrumentee()
        // Then: la liste est triée
        println("Nombre operations tri insertion : ${res}")
        assertTrue(res > 1_200_000)
    }



}