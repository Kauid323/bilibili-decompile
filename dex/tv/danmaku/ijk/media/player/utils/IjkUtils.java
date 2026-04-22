package tv.danmaku.ijk.media.player.utils;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bilibili.lib.dd.DeviceDecision;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import tv.danmaku.ijk.media.player.IjkMediaConfigParams;

public class IjkUtils {
    private static final String HEX = "0123456789ABCDEF";
    private static final String IV_STRING = "16-Bytes--String";
    private static final String charset = "UTF-8";

    public static IjkMediaConfigParams createItemParmas() {
        IjkMediaConfigParams params = new IjkMediaConfigParams();
        params.mInitCacheTime = 1000L;
        params.mEnableHwCodec = true;
        params.mEnableH265Codec = true;
        params.mStartOnPrepared = true;
        params.mReferer = "http://www.bilibili.com";
        params.mEnableP2PDownload = true;
        params.mEnableDecodeSwitch = false;
        return params;
    }

    public static String encryptAES(String key, String content) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyBytes = key.getBytes(charset);
        byte[] byteContent = content.getBytes(charset);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        byte[] initParam = IV_STRING.getBytes(charset);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(byteContent);
        return toHex(encryptedBytes);
    }

    public static String decryptAES(String key, String content) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyBytes = key.getBytes(charset);
        byte[] encryptedBytes = toBinary(content);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        byte[] initParam = IV_STRING.getBytes(charset);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, charset);
    }

    private static String toHex(byte[] buf) {
        if (buf == null) {
            return "";
        }
        StringBuffer result = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            result.append(HEX.charAt((buf[i] >> 4) & 15)).append(HEX.charAt(buf[i] & 15));
        }
        return result.toString();
    }

    private static byte[] toBinary(String hexString) {
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            byte high = (byte) (HEX.indexOf(hexString.charAt(i * 2)) << 4);
            byte low = (byte) HEX.indexOf(hexString.charAt((i * 2) + 1));
            bytes[i] = (byte) (high | low);
        }
        return bytes;
    }

    public static long getPropetyLong(Bundle bundle, int key, long def) {
        if (bundle == null) {
            return def;
        }
        try {
            long ret = Long.valueOf(bundle.getString(String.valueOf(key))).longValue();
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
            return def;
        }
    }

    public static int getPropetyInt(Bundle bundle, int key, int def) {
        if (bundle == null) {
            return def;
        }
        try {
            int ret = Integer.valueOf(bundle.getString(String.valueOf(key))).intValue();
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
            return def;
        }
    }

    public static float getPropetyFloat(Bundle bundle, int key, float def) {
        if (bundle == null) {
            return def;
        }
        try {
            float ret = Float.valueOf(bundle.getString(String.valueOf(key))).floatValue();
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
            return def;
        }
    }

    public static boolean isContainThisPhone(String configKey, boolean defaultValue) {
        try {
            String model = Build.MODEL;
            String brand = Build.BRAND;
            if ((model != null && !model.isEmpty()) || (brand != null && !brand.isEmpty())) {
                String deviceInfo = "[" + (model != null ? model : "") + "-" + (brand != null ? brand : "") + "]";
                String rawInfo = DeviceDecision.INSTANCE.dd(configKey, (String) null);
                if (rawInfo == null) {
                    return defaultValue;
                }
                return rawInfo.toLowerCase().contains(deviceInfo.toLowerCase());
            }
            return defaultValue;
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static String getUrlHost(String url) {
        if (!TextUtils.isEmpty(url)) {
            if (url.startsWith("quic")) {
                url = url.replaceFirst("quic", "http");
            }
            Uri uri = Uri.parse(url);
            if (uri != null) {
                return uri.getHost();
            }
            return "";
        }
        return "";
    }

    public static String getUrlHostAndPort(String url) {
        if (!TextUtils.isEmpty(url)) {
            if (url.startsWith("quic")) {
                url = url.replaceFirst("quic", "http");
            }
            Uri uri = Uri.parse(url);
            if (uri != null) {
                String host = uri.getHost();
                int port = uri.getPort();
                if (port <= 0) {
                    port = "https".equals(uri.getScheme()) ? 443 : 80;
                }
                return host + ":" + port;
            }
            return "";
        }
        return "";
    }
}