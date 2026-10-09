package data_structure.map.implementation.open_adressing;

import org.example.data_structure.map.implementation.my_implementation.open_adressing.MyMapOpenAddressing;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestOpenAddressingPut {
    MyMapOpenAddressing<String, Integer> map;

    @BeforeEach
    public void setUp() {
        this.map = new MyMapOpenAddressing<>();
    }

        // ─────────────────────────── Cas de base ───────────────────────────
        @Nested
        @DisplayName("Insertion simple")
        class InsertionSimple {

            @Test
            @DisplayName("put sur une map vide retourne null et stocke la valeur")
            void putNouvelleCle() {
                Assertions.assertNull(map.put("a", 1));
                Assertions.assertEquals(1, map.getValue("a"));
                Assertions.assertEquals(1, map.size());
            }

            @Test
            @DisplayName("plusieurs clés distinctes sont toutes retrouvables")
            void putPlusieursCles() {
                map.put("a", 1);
                map.put("b", 2);
                map.put("c", 3);

                Assertions.assertEquals(1, map.getValue("a"));
                Assertions.assertEquals(2, map.getValue("b"));
                Assertions.assertEquals(3, map.getValue("c"));
                Assertions.assertEquals(3, map.size());
            }

            @Test
            @DisplayName("une clé absente retourne null")
            void getCleAbsente() {
                map.put("a", 1);
                Assertions.assertNull(map.getValue("inexistante"));
            }
        }

        // ─────────────────────────── Remplacement ──────────────────────────

        @Nested
        @DisplayName("Remplacement de valeur")
        class Remplacement {

            @Test
            @DisplayName("put sur une clé existante retourne l'ANCIENNE valeur")
            void retourneAncienneValeur() {
                map.put("a", 1);
                Assertions.assertEquals(1, map.put("a", 99));
            }

            @Test
            @DisplayName("put sur une clé existante écrit bien la NOUVELLE valeur")
            void ecritNouvelleValeur() {
                map.put("a", 1);
                map.put("a", 99);
                Assertions.assertEquals(99, map.getValue("a"));
            }

            @Test
            @DisplayName("un remplacement n'augmente pas la taille")
            void remplacementNeChangePasSize() {
                map.put("a", 1);
                map.put("a", 99);
                map.put("a", 100);
                Assertions.assertEquals(1, map.size());
            }

            @Test
            @DisplayName("remplacement d'une clé qui a subi un sondage (pas à son index d'origine)")
            void remplacementApresCollision() {
                // "Antoine" et "Anthony" entrent en collision dans ta capacité par défaut
                map.put("Antoine", 19);
                map.put("Anthony", 21);

                Assertions.assertEquals(21, map.put("Anthony", 42));
                Assertions.assertEquals(42, map.getValue("Anthony"));
                Assertions.assertEquals(19, map.getValue("Antoine"));
                Assertions.assertEquals(2, map.size());
            }
        }

        // ─────────────────────────── Collisions ────────────────────────────

        @Nested
        @DisplayName("Collisions et sondage linéaire")
        class Collisions {

            @Test
            @DisplayName("deux clés en collision sont toutes deux retrouvables")
            void deuxCollisions() {
                map.put("Antoine", 19);
                map.put("Anthony", 21);

                Assertions.assertEquals(19, map.getValue("Antoine"));
                Assertions.assertEquals(21, map.getValue("Anthony"));
                Assertions.assertEquals(2, map.size());
            }

            @Test
            @DisplayName("blocs qui se chevauchent : origines différentes, territoires mêlés")
            void blocsQuiSeChevauchent() {
                // Le cas qui t'a bloqué : "fallene" doit traverser les clés d'une autre origine
                map.put("Antoine", 19);
                map.put("Anthony", 21);
                map.put("fallen", 5);
                map.put("fallene", 6);

                Assertions.assertEquals(19, map.getValue("Antoine"));
                Assertions.assertEquals(21, map.getValue("Anthony"));
                Assertions.assertEquals(5, map.getValue("fallen"));
                Assertions.assertEquals(6, map.getValue("fallene"));
                Assertions.assertEquals(4, map.size());
            }

            @Test
            @DisplayName("aucun doublon : une clé insérée deux fois n'occupe qu'une case")
            void pasDeDoublon() {
                map.put("Antoine", 19);
                map.put("Anthony", 21);
                map.put("Antoine", 20); // doit remplacer, pas créer une 3e entrée

                Assertions.assertEquals(2, map.size());
                Assertions.assertEquals(20, map.getValue("Antoine"));
            }
        }

        // ─────────────────── Interaction avec les tombes ───────────────────

        @Nested
        @DisplayName("Tombes (DEFUNCT)")
        class Tombes {

            @Test
            @DisplayName("une tombe est réutilisée par une nouvelle clé")
            void tombeReutilisee() {
                map.put("a", 1);
                map.remove("a");
                map.put("b", 2);

                Assertions.assertEquals(2, map.getValue("b"));
                Assertions.assertEquals(1, map.size());
            }

            @Test
            @DisplayName("réinsérer une clé supprimée")
            void reinsertionApresSuppression() {
                map.put("a", 1);
                map.remove("a");

                Assertions.assertNull(map.put("a", 2)); // c'est un AJOUT, pas un remplacement
                Assertions.assertEquals(2, map.getValue("a"));
                Assertions.assertEquals(1, map.size());
            }

            @Test
            @DisplayName("une tombe ne coupe pas le chemin vers une clé plus loin")
            void tombeNeCassePasLaChaine() {
                // trois clés en collision, on supprime celle du milieu
                map.put("Antoine", 19);
                map.put("Anthony", 21);
                map.put("Antoinea", 37);

                map.remove("Anthony");

                Assertions.assertEquals(37, map.getValue("Antoinea"));
                Assertions.assertEquals(19, map.getValue("Antoine"));
            }

            @Test
            @DisplayName("PIÈGE : insérer sur une tombe alors que la clé existe plus loin")
            void pasDeDoublonViaTombe() {
                // On veut une tombe AVANT la position d'une clé existante
                map.put("Antoine", 19);
                map.put("Anthony", 21);
                map.put("Antoinea", 37);

                map.remove("Antoine");        // libère une case en amont
                map.put("Antoinea", 100);     // doit trouver la clé plus loin, PAS poser sur la tombe

                Assertions.assertEquals(100, map.getValue("Antoinea"));
                Assertions.assertEquals(2, map.size()); // et non 3
            }

            @Test
            @DisplayName("PIÈGE : maxDist ne doit pas être écrasé par une insertion plus proche")
            void maxDistNonEcrase() {
                // une clé part loin, puis une place se libère plus près de l'origine
                map.put("Antoine", 19);
                map.put("Anthony", 21);
                map.put("Antoinea", 37);

                map.remove("Antoine");   // tombe à l'origine du bloc
                map.put("Antoineb", 50); // se pose sur la tombe, distance courte

                // les clés parties plus loin doivent rester trouvables
                Assertions.assertEquals(21, map.getValue("Anthony"));
                Assertions.assertEquals(37, map.getValue("Antoinea"));
                Assertions.assertEquals(50, map.getValue("Antoineb"));
            }
        }

        // ───────────────────────── Redimensionnement ───────────────────────

        @Nested
        @DisplayName("Rehash")
        class Rehash {

            @Test
            @DisplayName("toutes les clés survivent au redimensionnement")
            void toutesLesClesSurviventAuRehash() {
                int n = 100;
                for (int i = 0; i < n; i++) {
                    map.put("cle" + i, i);
                }

                Assertions.assertEquals(n, map.size());
                for (int i = 0; i < n; i++) {
                    Assertions.assertEquals(i, map.getValue("cle" + i),
                            "cle" + i + " perdue après rehash");
                }
            }

            @Test
            @DisplayName("les tombes ne survivent pas au rehash et la taille reste juste")
            void tombesNettoyeesParLeRehash() {
                for (int i = 0; i < 50; i++) {
                    map.put("cle" + i, i);
                    map.remove("cle" + i);   // beaucoup d'insertions/suppressions
                }
                map.put("finale", 999);

                Assertions.assertEquals(1, map.size());
                Assertions.assertEquals(999, map.getValue("finale"));
            }

            @Test
            @DisplayName("un remplacement ne doit pas faire grossir la table indéfiniment")
            void remplacementsRepetes() {
                for (int i = 0; i < 1000; i++) {
                    map.put("unique", i);
                }
                Assertions.assertEquals(1, map.size());
                Assertions.assertEquals(999, map.getValue("unique"));
            }
        }

        // ──────────────────────────── Arguments ────────────────────────────

        @Nested
        @DisplayName("Arguments invalides")
        class ArgumentsInvalides {

            @Test
            @DisplayName("clé null refusée")
            void cleNull() {
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> map.put(null, 1));
            }

            @Test
            @DisplayName("valeur null refusée")
            void valeurNull() {
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> map.put("a", null));
            }

            @Test
            @DisplayName("un put refusé ne modifie pas la map")
            void putRefuseNeModifieRien() {
                map.put("a", 1);
                try { map.put(null, 2); } catch (IllegalArgumentException ignored) {}

                Assertions.assertEquals(1, map.size());
                Assertions.assertEquals(1, map.getValue("a"));
            }
        }

        // ────────────────────────── Table saturée ──────────────────────────

        @Nested
        @DisplayName("Robustesse")
        class Robustesse {

            @Test
            @DisplayName("beaucoup de clés entrant en collision")
            void nombreusesCollisions() {
                // clés choisies pour se bousculer, quelle que soit la capacité
                for (int i = 0; i < 200; i++) {
                    map.put("k" + i, i);
                }
                Assertions.assertEquals(200, map.size());
                for (int i = 0; i < 200; i++) {
                    Assertions.assertEquals(i, map.getValue("k" + i));
                }
            }

            @Test
            @DisplayName("alternance d'insertions et de suppressions")
            void alternanceInsertSupprime() {
                for (int tour = 0; tour < 20; tour++) {
                    for (int i = 0; i < 10; i++) {
                        map.put("k" + i, tour * 100 + i);
                    }
                    for (int i = 0; i < 5; i++) {
                        map.remove("k" + i);
                    }
                }

                Assertions.assertEquals(5, map.size());
                for (int i = 5; i < 10; i++) {
                    Assertions.assertEquals(1900 + i, map.getValue("k" + i));
                }
            }
        }
}
