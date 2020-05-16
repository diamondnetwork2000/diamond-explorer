package io.diamondnetwork.util;

import burst.kit.crypto.BurstCrypto;
import burst.kit.entity.BurstAddress;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.DecoderException;
import org.bouncycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

public final class Convert {

  private static final BurstCrypto burstCrypto = BurstCrypto.getInstance();

  private static final long[] multipliers = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

  public static final BigInteger two64 = BigInteger.valueOf(2).pow(64);

  private Convert() {} //never

  public static byte[] parseHexString(String hex) {
    if (hex == null) return null;
    try {
      if (hex.length() % 2 != 0) {
        hex = hex.substring(0, hex.length() - 1);
      }
      return Hex.decode(hex);
    } catch (DecoderException e) {
      throw new RuntimeException("Could not parse hex string " + hex, e);
    }
  }

  public static String readString(ByteBuffer buffer, int numBytes, int maxLength){
    if (numBytes > 3 * maxLength) {
      throw new IllegalArgumentException("Max parameter length exceeded");
    }
    byte[] bytes = new byte[numBytes];
    buffer.get(bytes);
    return Convert.toString(bytes);
  }

  public static String toHexString(byte[] bytes) {
    if (bytes == null) return null;
    return Hex.toHexString(bytes);
  }

  public static String toUnsignedLong(long objectId) {
    return Long.toUnsignedString(objectId);
  }

  public static long parseUnsignedLong(String number) {
    if (number == null) {
      return 0;
    }
    return Long.parseUnsignedLong(number);
  }

  public static long parseAccountId(String account) {
    if (account.startsWith("1x")) {
       String realAccount = "BURST-";
       realAccount += account.substring(2,6) + "-";
       realAccount += account.substring(6,10)+ "-";
       realAccount += account.substring(10,14)+ "-";
       realAccount += account.substring(14,account.length());
       account = realAccount;
    }

    BurstAddress address = BurstAddress.fromEither(account);
    return address == null ? 0 : address.getBurstID().getSignedLongId();
  }

  public static void main(String[] args) {

    long address1 = Convert.parseAccountId("17973494697610776110");
    long address2 = Convert.parseAccountId("BURST-C5KG-8EMR-N4SA-HGPVL");
    long address3 = Convert.parseAccountId("1xC5KG8EMRN4SAHGPVL");

    System.out.println(address1);
    System.out.println(address2);
    System.out.println(address3);
  }


  public static long fullHashToId(byte[] hash) {
    return burstCrypto.hashToId(hash).getSignedLongId();
  }

  public static long fullHashToId(String hash) {
    if (hash == null) {
      return 0;
    }
    return fullHashToId(parseHexString(hash));
  }

  public static Date fromEpochTime(int epochTime) {
    return new Date(epochTime * 1000L + Constants.EPOCH_BEGINNING - 500L);
  }

  public static String emptyToNull(String s) {
    return s == null || s.isEmpty() ? null : s;
  }

  public static String nullToEmpty(String s) {
    return s == null ? "" : s;
  }

  public static long nullToZero(Long l) {
    return l == null ? 0 : l;
  }

  public static byte[] emptyToNull(byte[] bytes) {
    if (bytes == null) {
      return null;
    }
    for (byte b : bytes) {
      if (b != 0) {
        return bytes;
      }
    }
    return null;
  }

  public static byte[] toBytes(String s) {
    return s == null ? new byte[0] : s.getBytes(StandardCharsets.UTF_8);
  }

  public static String toString(byte[] bytes) {
    return new String(bytes, StandardCharsets.UTF_8);
  }



  public static String truncate(String s, String replaceNull, int limit, boolean dots) {
    return s == null ? replaceNull : s.length() > limit ? (s.substring(0, dots ? limit - 3 : limit) + (dots ? "..." : "")) : s;
  }

  public static long parseNXT(String nxt) {
    return parseStringFraction(nxt, 8, Constants.MAX_BALANCE_BURST);
  }

  private static long parseStringFraction(String value, int decimals, long maxValue) {
    String[] s = value.trim().split("\\.");
    if (s.length == 0 || s.length > 2) {
      throw new NumberFormatException("Invalid number: " + value);
    }
    long wholePart = Long.parseLong(s[0]);
    if (wholePart > maxValue) {
      throw new IllegalArgumentException("Whole part of value exceeds maximum possible");
    }
    if (s.length == 1) {
      return wholePart * multipliers[decimals];
    }
    long fractionalPart = Long.parseLong(s[1]);
    if (fractionalPart >= multipliers[decimals] || s[1].length() > decimals) {
      throw new IllegalArgumentException("Fractional part exceeds maximum allowed divisibility");
    }
    for (int i = s[1].length(); i < decimals; i++) {
      fractionalPart *= 10;
    }
    return wholePart * multipliers[decimals] + fractionalPart;
  }

  // overflow checking based on https://www.securecoding.cert.org/confluence/display/java/NUM00-J.+Detect+or+prevent+integer+overflow
  public static long safeAdd(long left, long right)
    throws ArithmeticException {
    if (right > 0 ? left > Long.MAX_VALUE - right
        : left < Long.MIN_VALUE - right) {
      throw new ArithmeticException("Integer overflow");
    }
    return left + right;
  }

  public static long safeSubtract(long left, long right)
    throws ArithmeticException {
    if (right > 0 ? left < Long.MIN_VALUE + right
        : left > Long.MAX_VALUE + right) {
      throw new ArithmeticException("Integer overflow");
    }
    return left - right;
  }

  public static long safeMultiply(long left, long right)
    throws ArithmeticException {
    if (right > 0 ? left > Long.MAX_VALUE/right
        || left < Long.MIN_VALUE/right
        : (right < -1 ? left > Long.MIN_VALUE/right
           || left < Long.MAX_VALUE/right
           : right == -1
           && left == Long.MIN_VALUE) ) {
      throw new ArithmeticException("Integer overflow");
    }
    return left * right;
  }

  public static long safeDivide(long left, long right)
    throws ArithmeticException {
    if ((left == Long.MIN_VALUE) && (right == -1)) {
      throw new ArithmeticException("Integer overflow");
    }
    return left / right;
  }

  public static long safeNegate(long a) throws ArithmeticException {
    if (a == Long.MIN_VALUE) {
      throw new ArithmeticException("Integer overflow");
    }
    return -a;
  }

  public static long safeAbs(long a) throws ArithmeticException {
    if (a == Long.MIN_VALUE) {
      throw new ArithmeticException("Integer overflow");
    }
    return Math.abs(a);
  }

  /**
   *
   * @param s
   * @return
   */
  public static String stringToHexString(String s) {
    String str = "";
    for (int i = 0; i < s.length(); i++) {
      int ch = s.charAt(i);
      String s4 = Integer.toHexString(ch);
      str = str + s4;
    }
    return str;
  }

  /**
   *
   * @param s
   * @return
   */
  public static String hexStringToString(String s) {
    if (s == null || s.equals("")) {
      return null;
    }
    s = s.replace(" ", "");
    byte[] baKeyword = new byte[s.length() / 2];
    for (int i = 0; i < baKeyword.length; i++) {
      try {
        baKeyword[i] = (byte) (0xff & Integer.parseInt(
                s.substring(i * 2, i * 2 + 2), 16));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    try {
      s = new String(baKeyword, "gbk");
      new String();
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    return s;
  }

  public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] b = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
      b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
              .digit(s.charAt(i + 1), 16));
    }
    return b;
  }

  /**
   * @param bArray
   * @return
   */
  public static final String bytesToHexString(byte[] bArray) {
    StringBuffer sb = new StringBuffer(bArray.length);
    String sTemp;
    for (int i = 0; i < bArray.length; i++) {
      sTemp = Integer.toHexString(0xFF & bArray[i]);
      if (sTemp.length() < 2)
        sb.append(0);
      sb.append(sTemp.toUpperCase());
    }
    return sb.toString();
  }

  private static byte[] encodeRipeMD160(byte[] data) throws Exception {
    Security.addProvider(new BouncyCastleProvider());
    MessageDigest md = MessageDigest.getInstance("RipeMD160");
    return md.digest(data);
  }

  public static String encodeRipeMD160Hex(byte[] data) throws Exception {

    byte[] b = encodeRipeMD160(SHA256(data));

    return new String(Hex.encode(b));
  }

  public static byte[] SHA256(byte[] src) throws NoSuchAlgorithmException {

    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(src);
    return md.digest(); // to HexString

  }

  //refer https://github.com/bitcoinjs/bech32/blob/master/index.js
  public static byte[] convert(byte[] data, int inBits, int outBits, boolean pad) {
    int value = 0;
    int bits = 0;
    int maxV = (1 << outBits) - 1;

    byte[] result = new byte[100];
    int index = 0;
    for (int i = 0; i < data.length; ++i) {
      value = (value << inBits) | data[i];
      bits += inBits;

      while (bits >= outBits) {
        bits -= outBits;
        result[index++] = (byte) ((value >> bits) & maxV);
      }
    }

    if (pad) {
      if (bits > 0) {
        result[index++] = (byte) ((value << (outBits - bits)) & maxV);
      }
    } else {
      if (bits >= inBits) {
        return "Excess padding".getBytes();
      }
      if (((value << (outBits - bits)) & maxV) > 0) {
        return "Non-zero padding".getBytes();
      }
    }

    return result;
  }

}
