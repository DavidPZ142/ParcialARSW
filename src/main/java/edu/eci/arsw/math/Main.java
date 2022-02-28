/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) {


        System.out.println(bytsToHex(PiDigits.getDigits(1, 100,4)));
        System.out.println(bytsToHex(PiDigits.getDigits(1, 1000000,4)));

    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            //sb.append(hexChars[i]);
            sb.append(hexChars[i+1]);
        }
        return sb.toString();
    }

    public static String bytsToHex(ArrayList<byte[]> arrayList){
        StringBuilder ss=new StringBuilder();
        for (int i = 0; i < arrayList.size() ; i++ ) {
            StringBuilder sb = new StringBuilder();
            byte[] bytes = arrayList.get(i);

            char[] hexChars = new char[bytes.length * 2];
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            for (int k = 0; k< hexChars.length; k = k + 2) {
                //sb.append(hexChars[i]);
                sb.append(hexChars[k + 1]);
            }
            ss.append(sb);
        }
        return ss.toString();

    }

}
