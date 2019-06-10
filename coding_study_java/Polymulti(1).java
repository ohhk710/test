package lol;

import java.util.Arrays;

public class Polymulti {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] coefx = { 2, 1, 1 };
        int[] expx = { 1, 2, 3 };
        // 2x+x^2+x^3
        int[] coefy = { 1, 3, 1 };
        int[] expy = { 2, 1, 3 };
        // x^2+3x+x^3
        
        int[] resexp = new int[9];
        int[] rescoef = new int[9];
        int respos = 0;
        
        for (int xpos = 0; xpos < expx.length; xpos++) {
            for (int ypos = 0; ypos < expy.length; ypos++) {
                resexp[respos] = expx[xpos] + expy[ypos];
                rescoef[respos] = coefx[xpos] * coefy[ypos];
                respos++;

            }
        }
        System.out.print("resexp :  ");
        for (int i = 0; i < resexp.length; i++) {

            System.out.print(resexp[i] + " ");
        }
        System.out.println();
        System.out.print("rescoef : ");
        for (int i = 0; i < resexp.length; i++) {

            System.out.print(rescoef[i] + " ");
        }

        System.out.println();

        int[] response = new int[9];
        int pos = 0;
        boolean check = false;

        for (int i = 0; i < resexp.length; i++) {
            check = false;
            for (int j = 0; j <= pos; j++) {
                if (i != j && resexp[i] == resexp[j]) {
                    check = true;
                    break;
                }
            }
            if (check)
                continue;
            else {
                response[pos] = rescoef[i];
            }
//            System.out.println(response[pos]);
            for (int j = i; j < resexp.length; j++) {
                if (i != j && resexp[i] == resexp[j]) {
                    response[pos] += rescoef[j];
                }
            }
            pos++;
        }
        
        for(int i = 0; i < pos-1; i++) {
            System.out.print(response[i] + " ");
        }
    }
}