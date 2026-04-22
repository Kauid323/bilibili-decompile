package cmbapi;

import android.content.Context;
import android.content.Intent;
import com.alipay.sdk.m.l.e;

public interface CMBApi {

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class PaySdk {
        public static Context mContext = null;
        public static CMBPayCallback mCallback = null;
        public static String mAppId = null;

        public static void callPay(Context context, String str, String str2, String str3, CMBPayCallback cMBPayCallback) {
            if (context == null || cMBPayCallback == null) {
                return;
            }
            mContext = context;
            mCallback = cMBPayCallback;
            mAppId = str;
            Intent intent = new Intent(context, CMBSchemeActivity.class);
            intent.putExtra("appid", str);
            intent.putExtra(e.s, str2);
            intent.putExtra("payurl", str3);
            mContext.startActivity(intent);
        }
    }

    String getApiVersion();

    String getAppId();

    boolean handleIntent(Intent intent, CMBEventHandler cMBEventHandler);

    boolean isCMBAppInstalled();

    int sendReq(CMBRequest cMBRequest);

    boolean sendReq(CMBRequest cMBRequest, CMBPayCallback cMBPayCallback);
}