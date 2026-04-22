package de.robv.android.xposed;

import android.os.Environment;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.client.utils.CIOKt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

class DexCreator {
    public static File DALVIK_CACHE = new File(Environment.getDataDirectory(), "dalvik-cache");

    public static File getDefaultFile(String childClz) {
        return new File(DALVIK_CACHE, "xposed_" + childClz.substring(childClz.lastIndexOf(46) + 1) + ".dex");
    }

    public static File ensure(String clz, Class<?> realSuperClz, Class<?> topClz) throws IOException {
        if (!topClz.isAssignableFrom(realSuperClz)) {
            throw new ClassCastException("Cannot initialize " + clz + " because " + realSuperClz + " does not extend " + topClz);
        }
        try {
            return ensure("xposed.dummy." + clz + "SuperClass", realSuperClz);
        } catch (IOException e2) {
            throw new IOException("Failed to create a superclass for " + clz, e2);
        }
    }

    public static File ensure(String childClz, Class<?> superClz) throws IOException {
        return ensure(getDefaultFile(childClz), childClz, superClz.getName());
    }

    public static File ensure(File file, String childClz, String superClz) throws IOException {
        byte[] dex;
        try {
            dex = XposedHelpers.inputStreamToByteArray(new FileInputStream(file));
        } catch (IOException e2) {
            file.delete();
        }
        if (matches(dex, childClz, superClz)) {
            return file;
        }
        file.delete();
        byte[] dex2 = create(childClz, superClz);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(dex2);
        fos.close();
        return file;
    }

    public static boolean matches(byte[] dex, String childClz, String superClz) throws IOException {
        boolean childFirst = childClz.compareTo(superClz) < 0;
        byte[] childBytes = stringToBytes("L" + childClz.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ";");
        byte[] superBytes = stringToBytes("L" + superClz.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ";");
        int pos = 160;
        if (childBytes.length + 160 + superBytes.length >= dex.length) {
            return false;
        }
        byte[] bArr = childFirst ? childBytes : superBytes;
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            int b = bArr[i2];
            int pos2 = pos + 1;
            if (dex[pos] != b) {
                return false;
            }
            i2++;
            pos = pos2;
        }
        byte[] bArr2 = childFirst ? superBytes : childBytes;
        int length2 = bArr2.length;
        int i3 = 0;
        while (i3 < length2) {
            int b2 = bArr2[i3];
            int pos3 = pos + 1;
            if (dex[pos] != b2) {
                return false;
            }
            i3++;
            pos = pos3;
        }
        return true;
    }

    public static byte[] create(String childClz, String superClz) throws IOException {
        boolean childFirst = childClz.compareTo(superClz) < 0;
        byte[] childBytes = stringToBytes("L" + childClz.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ";");
        byte[] superBytes = stringToBytes("L" + superClz.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ";");
        int stringsSize = childBytes.length + superBytes.length;
        int padding = (-stringsSize) & 3;
        int stringsSize2 = stringsSize + padding;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write("dex\n035\u0000".getBytes());
        out.write(new byte[24]);
        writeInt(out, stringsSize2 + 252);
        writeInt(out, TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
        writeInt(out, 305419896);
        writeInt(out, 0);
        writeInt(out, 0);
        writeInt(out, stringsSize2 + 164);
        writeInt(out, 2);
        writeInt(out, TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
        writeInt(out, 2);
        writeInt(out, TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
        writeInt(out, 0);
        writeInt(out, 0);
        writeInt(out, 0);
        writeInt(out, 0);
        writeInt(out, 0);
        writeInt(out, 0);
        writeInt(out, 1);
        writeInt(out, 128);
        writeInt(out, stringsSize2 + 92);
        writeInt(out, 160);
        writeInt(out, 160);
        writeInt(out, (childFirst ? childBytes.length : superBytes.length) + 160);
        writeInt(out, 0);
        writeInt(out, 1);
        writeInt(out, childFirst ? 0 : 1);
        writeInt(out, 1);
        writeInt(out, childFirst ? 1 : 0);
        writeInt(out, 0);
        writeInt(out, -1);
        writeInt(out, 0);
        writeInt(out, 0);
        writeInt(out, 0);
        out.write(childFirst ? childBytes : superBytes);
        out.write(childFirst ? superBytes : childBytes);
        out.write(new byte[padding]);
        writeInt(out, 0);
        writeInt(out, 7);
        writeMapItem(out, 0, 1, 0);
        writeMapItem(out, 1, 2, TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
        writeMapItem(out, 2, 2, TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
        writeMapItem(out, 6, 1, 128);
        writeMapItem(out, 8194, 2, 160);
        writeMapItem(out, 4099, 1, stringsSize2 + 160);
        writeMapItem(out, CIOKt.DEFAULT_HTTP_BUFFER_SIZE, 1, stringsSize2 + 164);
        byte[] buf = out.toByteArray();
        updateSignature(buf);
        updateChecksum(buf);
        return buf;
    }

    private static void updateSignature(byte[] dex) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(dex, 32, dex.length - 32);
            md.digest(dex, 12, 20);
        } catch (DigestException | NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void updateChecksum(byte[] dex) {
        Adler32 a32 = new Adler32();
        a32.update(dex, 12, dex.length - 12);
        int chksum = (int) a32.getValue();
        dex[8] = (byte) (chksum & WebView.NORMAL_MODE_ALPHA);
        dex[9] = (byte) ((chksum >> 8) & WebView.NORMAL_MODE_ALPHA);
        dex[10] = (byte) ((chksum >> 16) & WebView.NORMAL_MODE_ALPHA);
        dex[11] = (byte) ((chksum >> 24) & WebView.NORMAL_MODE_ALPHA);
    }

    private static void writeUleb128(OutputStream out, int value) throws IOException {
        while (value > 127) {
            out.write((value & TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) | 128);
            value >>>= 7;
        }
        out.write(value);
    }

    private static void writeInt(OutputStream out, int value) throws IOException {
        out.write(value);
        out.write(value >> 8);
        out.write(value >> 16);
        out.write(value >> 24);
    }

    private static void writeMapItem(OutputStream out, int type, int count, int offset) throws IOException {
        writeInt(out, type);
        writeInt(out, count);
        writeInt(out, offset);
    }

    private static byte[] stringToBytes(String s) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        writeUleb128(bytes, s.length());
        bytes.write(s.getBytes("UTF-8"));
        bytes.write(0);
        return bytes.toByteArray();
    }

    private DexCreator() {
    }
}