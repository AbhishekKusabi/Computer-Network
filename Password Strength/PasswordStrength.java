/*
    Write an alogrithm or flowchart to find out strength of the password.

*/

import java.util.Scanner;

public class PasswordStrength {
    public static int checkAlpha(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                return 1;
            }
        }
        return 0;
    }

    public static int checkNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                return 1;
            }
        }
        return 0;
    }

    public static int checkSpecial(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean checkLen(String str) {
        if (str.length() < 8) {
            return false;
            // System.exit(0);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the password");
        String str = sc.nextLine();

            if (!checkLen(str)){
                System.out.println("--> Invalid !!! Password length must be more than 8.\n");
                return;
            }

            int al = checkAlpha(str);

            int num = checkNum(str);

            int sp = checkSpecial(str);
            
            int sum = al + num + sp;
            if (sum == 3) {
                System.out.println("--> Excellent");
            } else if (sum == 2) {
                System.out.println("--> Moderate.");
            } else if (sum == 1) {
                System.out.println("--> Poor");
            } else {
                System.out.println("--> Please enter password...!!!!");
            }
            System.out.println();
        }
    }
