package org.example.data_structure.arrays.exercices.medium;

public class NonEmptySubarrayLargest {

    // Brute Force : O(n^2).
    public int brutForce(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            int total = 0;
            for(int j = i; j < arr.length; j++){
                // Le seul cas ou on ne le fait pas est si  i == 0 et j == n -1;
                    if(i == 0 && j == n - 1) continue;

                    total += arr[j];
                    max = Math.max(max, total);
            }
        }
        System.out.println(max);
        return max;
    }


    public int tryKadaneAlgorithm(int[] arr){
        int max = arr[0]; // Car Non empty value.

        int total = 0;
        int partiel = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            total += arr[i];

            if(arr[i] > 0){
                partiel = partiel == Integer.MIN_VALUE ? arr[i] : partiel + arr[i];
                max = Math.max(max, total);
                max = Math.max(max, partiel);
            }
            else{
                partiel = Integer.MIN_VALUE;
            }
        }
        System.out.println(max);
        return max;
    }

    /**
     *  Raisonnement Kadane :
     *  - A chaque nouvel élément n, l'algorithme se demande :
     *    "Est il préférable de continuer la suite actuelle, ou bien de tout recommencer à partir de ce nombre"
     *
     *   Dans notre exercice : NonEmptySubArrayLargest, notre condition d'arrêt et
     *        -> Si current donc notre suite actuel est négative.
     *           En gros 10, -2, 20.
     *
     *          Si on s'arrete des qu'on trouve un positif alors on trouverai 21. Cependant la réponse est 28.
     *
     *          Explication :
     *          current : Interger.MinValue => le plus petit nombre possible
     *          La question => current est il inférieur a 0 ? oui donc on repart d'un nouveau nombre => 10.
     *
     *          On continue : -2
     *          Current est négatif ? non on donc on fait 10 - 2 => 8 et on calcul le max, 10 et 8 => 8.
     *
     *          On continue : 20
     *          Ici current est négatif ? non donc on ajoute 20 => 8 + 20 => 28 => max = 28.
     *
     *          Résumé mathématique :
     *          Si S > 0, alors S + n > n (même si n est négatif, S+n sera toujours plus grand que si tu avais commencé directement à n).
     *
     *          En gros on repart de n quand s + n est inférieur a n.
     *
     *          S = 25
     *          n = -17
     *          soit on repart de -17, soit on continue avec 25 - 17 = 8 donc on continue. car S  + n > n
     *
     *          par contre:
     *          S = -17
     *          n = 2
     *          S + n < n donc aucun intérer de garder s car n est plus grand que la s de gauche.
     *
     *         Traîner un historique négatif ne peut que réduire ton futur score.
     *         Option A (Continuer) : tu fais S+n=−5+10=5.
     *         Option B (Redémarrer) : tu ignores le passé et tu prends juste n=10.
     *
     */
    public int kadaneSolution(int[] arr){
        int max = arr[0];
        int current = Integer.MIN_VALUE;

        for(int n : arr){
            current = current > 0 ? current + n : n;
            max = Math.max(current, max);
        }
        return max;
    }

}
