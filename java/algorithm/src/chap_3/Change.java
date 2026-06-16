package chap_3;

import java.util.Scanner;

/**
 * 3-1. 거스름돈 문제
 * 당신은 음식점의 계산을 돕는 점원이다.
 * 500원, 100원, 50원, 10원짜리 동전이 모두 무한히 존재한다.
 * ( * 단, 거슬러주어야 하는 돈의 1의 자리는 항상 0이다. )
 */

public class Change {

    Scanner sc = new Scanner(System.in);
    int[] pennies = { 500, 100, 50, 10 };
    int[] changes = new int[4];

    private int howManyMoney() {
        return sc.nextInt();
    }

    private void calcChange(int paid) {

        int money = paid;

        for(int i = 0; i < pennies.length; i++) {

            // 더 이상 나누어 떨어지지 않을 떄까지
            if(paid / pennies[i] <= 0) {
                break;
            }

            // 큰 순서대로 반환
            changes[i] = money / pennies[i];

            // 떨군 잔돈만큼 남기기
            money %= pennies[i];

        }

    }

    private String toPrintableString() {
        return "500원: " + changes[0] + ", 100원: " + changes[1] + ", 50원: " + changes[2] + ", 10원: " + changes[3];
    }

    public static void main(String[] args) {

        Change start = new Change();

        System.out.println("얼마를 지불하시겠습니까?");
        int returned = start.howManyMoney();
        start.calcChange(returned);

        System.out.println(start.toPrintableString());

    }
}
