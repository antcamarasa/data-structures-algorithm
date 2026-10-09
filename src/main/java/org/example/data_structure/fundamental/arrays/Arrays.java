package org.example.data_structure.fundamental.arrays;
/**
 *   Objectif : Recoder haut niveau, la classe java.Util.Arrays.
 *
 *   Méthodes:
 *   1. Remplissage
 *   2. Copies et redimensionnement
 *   3. DeepCopy
 *   4. Trie
 *   4. Recherche
 *   5. Affichage
 *   6. Egalité & hash
 */

//TODO => Bug lié a Comparable T et  this.Array = (T[]) new Object[Length]; dans le constructor.
/**
 * Pattern n°1 (le plus utilisé)
 *
 * Stocker en Object[] et caster à la sortie
 * ArrayList
 * Stack
 * Queue
 * 90 % des implémentations maison
 * On accepte :
 * un warning unchecked
 * un cast au moment du get
 * une API sûre côté utilisateur
 * 👉 C’est le pattern officiel.
 *
 *
 * Pattern n°2 (API plus propre)
 * Le tableau est créé par l’appelant
 * l’utilisateur fournit un T[]
 * la structure l’utilise
 * zéro problème de type
 * Utilisé quand on veut une API très stricte.
 *
 * Pattern n°3 (avancé / framework)
 * Factory (IntFunction<T[]>) ou Class<T>
 * utilisé dans la JDK moderne
 * inutile pour 99 % des projets perso / juniors
 * @param <T>
 */
public class Arrays<T extends Comparable<T>>{
    // Une classe Array possède deux champs
    int Length;
    T[] Array;

    /**
     * Attention : à la compilation, Java efface les génériques (type erasure).
     * Donc {@code T} n'existe plus à l'exécution (runtime).
     *
     * <p>Deux approches possibles :<p>
     * <ol>
     *   <li>
     *     Créer un {@code Object[]} puis caster en {@code T[]}.
     *     <br>⚠️ Ce cast est non-vérifiable à l'exécution (unchecked).
     *   </li>
     *   <li>
     *     Passer un {@code Class<T>} (ou {@code IntFunction<T[]>}) afin de créer
     *     un tableau de {@code T} de façon sûre via réflexion / factory.
     *   </li>
     * </ol>
     */

    public Arrays(int length){
        this.Length = length;
        this.Array = (T[]) new Object[Length];
    }


    /**
     * <p>Binary Search :<p>
     * <ol>
     *      <li>Tableau doit être trié </li>
     *      <li>On retourne l'index de l'élément ou -1 </li>
     * </ol>
     */
    int binarySearch(T value){
            int low = 0;
            int hight = this.Length - 1;

            while(low <= hight){
                int middle = (low + hight) / 2;
                int result = value.compareTo(this.Array[middle]);

                if(result == 0){
                    return middle;
                }
                else if (result < 0) {
                    hight = middle - 1;
                }
                else{
                    low = middle + 1;
                }
        }
        return -1;
    }

    public T getValue(int index){
        return  this.Array[index];
    }

    public void setValue(int index, T value){
        if(index >= 0 && index < this.Array.length){
            this.Array[index] = value;
        }
    }

    public int size(){
        return this.Length;
    }
}
