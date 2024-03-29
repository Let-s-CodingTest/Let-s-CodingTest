package ps.stack;
// 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데,
// 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// 조건 1. 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
// 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
// 조건 2. 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
public class PG_64061 {
    public int solution(int[][] board, int[]moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        // board
        for(int pos : moves) {
            // 위에서부터 검색
            for (int i = 0; i < board.length; i++) {
                int tmp = board[i][pos-1];
                board[i][pos-1] = 0;
                // 0이 아닌 최상단 값 스택에 넣고, 0으로 교체
                if(tmp != 0) {
                    // 스택의 이전과 같은 번호이면 삭제, 그리고 answer++
                    if(!basket.isEmpty() && tmp == basket.peek()) {
                        basket.pop();
                        answer+=2;
                    }
                    // 번호가 다르면 스택에 저장
                    else basket.push(tmp);

                    break;
                }
            }
        }

        return answer;
    }
    static int [][] board;
    public static void main(String[] args) throws IOException {
        PG_64061 T = new PG_64061();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(T.solution(board, moves));
    }
}
