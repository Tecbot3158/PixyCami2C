/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /**
     *
     * @param i integer to convert to hexadecimal number
     * @return number in Hexadecimal format.
     */
    public static String getHexadecimalNumber(int i) {
        int binnum, rem;
        String hexdecnum = "";

        // digits in hexadecimal number system
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        binnum = i;

        // converting the number in hexadecimal format
        while (binnum > 0) {
            rem = binnum % 16;
            hexdecnum = hex[rem] + hexdecnum;
            binnum = binnum / 16;
        }

        //System.out.print("Equivalent Hexadecimal Value of " + binnum + " is :\n");
        //System.out.print(hexdecnum);
        return hexdecnum;
    }

    /**
     *
     * @param a the first byte converted to an integer
     * @param b the second byte converted to an integer
     * @return the 16-bit resulting integer
     */
    public static int getIntegerFrom16bits(int a, int b){
        return Math.abs(a) * 256 + Math.abs(b) + 125;
    }


}
