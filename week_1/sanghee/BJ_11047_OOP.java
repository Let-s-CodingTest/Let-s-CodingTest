// 동전 0 - 객체지향 프로그래밍

import java.util.*;
public class Main {
    public int solution(int coinNum, int money, int[] coin){
        int answer = 0;

        for(int i = coinNum-1; i >= 0 ; i--){    // 가장 큰 화폐 단위부터 나누며 동전의 개수를 구한다
            if(coin[i] <= money){
                answer += money / coin[i];
                money = money % coin[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int coinNum = sc.nextInt();
        int money = sc.nextInt();
        int [] coin = new int[coinNum];

        for(int i = 0; i < coin.length; i++){
            coin[i] = sc.nextInt();
        }
        System.out.println(T.solution(coinNum, money, coin));
    }
}