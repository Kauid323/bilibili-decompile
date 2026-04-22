package cmbapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import com.ashampoo.xmp.internal.XMPRDFWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class CMBApiUtils {
    public static final String CMBAPI_INTENT_CODE = "respcode";
    public static final String CMBAPI_INTENT_MSG = "respmsg";
    private static final int MAX_FILENAME_SIZE = 128;
    public static final String SDK_VERSION = "1.1.2";
    public static final String TAG = "CMBApiUtils";

    public static Hashtable<String, String> GetUrlParms(String str) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        if (str != null) {
            String trim = str.trim();
            int indexOf = trim.indexOf("?");
            if (indexOf > 0) {
                trim = trim.substring(indexOf + 1);
            }
            if (trim.startsWith("?") || trim.startsWith(com.alipay.sdk.m.o.a.l)) {
                trim = trim.substring(1);
            }
            int indexOf2 = trim.indexOf("//");
            if (indexOf2 > 0) {
                trim = trim.substring(indexOf2 + 2);
            }
            String[] split = trim.split(com.alipay.sdk.m.o.a.l);
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
                Log.d(TAG, "strParamsList[" + i + "]:" + split[i]);
                int indexOf3 = split[i].indexOf("=");
                if (indexOf3 > 0) {
                    hashtable.put(split[i].substring(0, indexOf3), indexOf3 <= split[i].length() - 1 ? split[i].substring(indexOf3 + 1) : "");
                }
            }
        }
        return hashtable;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    public static void saveToSD(String str) {
        String str2 = Environment.getExternalStorageDirectory() + File.separator + "cmbapi";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str2, "sdkApi_Log.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                byte[] bytes = (str + XMPRDFWriter.XMP_DEFAULT_NEWLINE).getBytes();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2, true);
                try {
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.close();
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
            }
        } catch (Exception e5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}