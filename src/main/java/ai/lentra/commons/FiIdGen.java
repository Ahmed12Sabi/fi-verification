package ai.lentra.commons;

import org.hibernate.id.UUIDGenerator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

public class FiIdGen {


    public static String genFiId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

//
//    private static final Random RANDOM = new Random();
//    private static final MessageDigest MESSAGE_DIGEST;
//
//    static {
//        try {
//            MESSAGE_DIGEST = MessageDigest.getInstance("SHA-256");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Unable to initialize SHA-256 message digest", e);
//        }
//    }
//
//    public static String genFiId() {
//        long timestamp = System.currentTimeMillis();
//        int randomNum = RANDOM.nextInt(1000000);
//        byte[] inputBytes = toBytes(timestamp, randomNum);
//        byte[] hashBytes = MESSAGE_DIGEST.digest(inputBytes);
//        return bytesToHex(hashBytes, 10);
//    }
//
//    private static byte[] toBytes(long timestamp, int randomNum) {
//        byte[] timestampBytes = Long.toString(timestamp).getBytes(StandardCharsets.UTF_8);
//        byte[] randomNumBytes = Integer.toString(randomNum).getBytes(StandardCharsets.UTF_8);
//        byte[] inputBytes = new byte[timestampBytes.length + 1 + randomNumBytes.length];
//        System.arraycopy(timestampBytes, 0, inputBytes, 0, timestampBytes.length);
//        inputBytes[timestampBytes.length] = '-';
//        System.arraycopy(randomNumBytes, 0, inputBytes, timestampBytes.length + 1, randomNumBytes.length);
//        return inputBytes;
//    }
//
//    private static String bytesToHex(byte[] bytes, int length) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length && i < bytes.length; i++) {
//            sb.append(String.format("%02X", bytes[i]));
//        }
//        return sb.toString();
//    }
}
