package algorithmization;

import java.util.Arrays;

public class EratosthenesSieve { // Решето Эратосфена,
                                // по времени O(N log(log N))
                                // по памяти O(N) требует массив флагов размером N + 1
    static void main() {
        int n = 30;
        boolean[] isPrime = new boolean[n + 1]; // все ячейки изначально false

        Arrays.fill(isPrime, true); // статик метод все ячейки true
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= n; p++){
            // если p не вычеркнуто значит оно простое
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        System.out.println("Простые числа до " + n + ":");
         for (int i = 2; i <= n; i++) {
             if (isPrime[i]) {
                 System.out.print(i + ", ");
             }
         }

    }



}
