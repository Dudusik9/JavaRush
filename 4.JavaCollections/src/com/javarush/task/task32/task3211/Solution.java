package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception
    {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(byteArrayOutputStream.toByteArray());
        // Получение BigInteger и перевод в 16 СС с помощью toString
        BigInteger tmp = new BigInteger(1, digest);
        String hash = tmp.toString(16);
        String hashRes = hash;
        // Дополняем нулями до 32 символов
        while (hashRes.length() < 32)
            hashRes = 0 + hash;
        //
        return hashRes.equals(md5);
    }
}
