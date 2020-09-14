package com.company;

public class Encrypt {

    public String encrypted(String s){
        int y = 0, i = 0;

        char []c =  s.toCharArray();

        for (char b : c ){
            String fs;
            //Convert char into int

            y = Character.getNumericValue(b);
            //calculate encrypted number
            y = (y+7) % 10;

            //return value to char
            fs = Integer.toString(y);
            fs.getChars(0,1,c , i);
            // System.out.println(c[i]);

            i++;
        }

        //Switching the characters 0 & 2 and 1 & 3
        char temp1= '0';
        // 1 and 3
        temp1 = c[0];
        c[0] = c[2];
        c[2]= temp1;
        //2 and 4
        temp1 = c[1]  ;
        c[1] = c[3];
        c[3] = temp1;

        //Adding the Char array to the String
        s = String.valueOf(c);


        return s;
    }
}

