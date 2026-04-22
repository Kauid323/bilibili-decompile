package cmbapi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class c {
    private a a;
    private String b = null;

    /* renamed from: c  reason: collision with root package name */
    private Handler f132c = new Handler() { // from class: cmbapi.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.a == null) {
                return;
            }
            if (message.what == 256) {
                Bundle data = message.getData();
                c.this.a.a(data.getString(CMBApiUtils.CMBAPI_INTENT_CODE), data.getString("respstring"));
            } else if (message.what == 257) {
                c.this.a.a();
            } else if (message.what == 258) {
                c.this.a.b();
            } else if (message.what == 260) {
                Bundle data2 = message.getData();
                c.this.a.b(data2.getString("payrespcode"), data2.getString("payrespstring"));
            } else if (message.what == 261) {
                Bundle data3 = message.getData();
                c.this.a.c(data3.getString("payrespcode"), data3.getString("payrespstring"));
            }
        }
    };

    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public interface a {
        void a();

        void a(String str, String str2);

        void b();

        void b(String str, String str2);

        void c(String str, String str2);
    }

    public c(a aVar) {
        this.a = null;
        this.a = aVar;
    }

    public void a(String str) {
        this.b = str;
    }

    @JavascriptInterface
    public int backToApp() {
        Message message = new Message();
        message.what = 258;
        Bundle bundle = new Bundle();
        bundle.putString(CMBApiUtils.CMBAPI_INTENT_CODE, "0");
        bundle.putString("respstring", "1");
        message.setData(bundle);
        this.f132c.sendMessage(message);
        return 0;
    }

    @JavascriptInterface
    public int callback(String str, String str2) {
        Log.d(CMBConstants.TAG, "handleRespMessage respCode: callback,respcode:" + str + ",str:" + str2);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Message message = new Message();
        message.what = 256;
        Bundle bundle = new Bundle();
        bundle.putString(CMBApiUtils.CMBAPI_INTENT_CODE, str);
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("respstring", str2);
        message.setData(bundle);
        this.f132c.sendMessage(message);
        return 0;
    }

    @JavascriptInterface
    public String getErrorUrl() {
        Message message = new Message();
        message.what = 259;
        Bundle bundle = new Bundle();
        bundle.putString(CMBApiUtils.CMBAPI_INTENT_CODE, "0");
        bundle.putString("respstring", "1");
        message.setData(bundle);
        this.f132c.sendMessage(message);
        return this.b;
    }

    @JavascriptInterface
    public int payCallback(String str, String str2) {
        Log.d(CMBConstants.TAG, "handleRespMessage respCode: paycallback:respcode:" + str + ",str:" + str2);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Message message = new Message();
        message.what = 260;
        Bundle bundle = new Bundle();
        bundle.putString("payrespcode", str);
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("payrespstring", str2);
        message.setData(bundle);
        this.f132c.sendMessage(message);
        return 0;
    }

    @JavascriptInterface
    public int reload() {
        Message message = new Message();
        message.what = 257;
        Bundle bundle = new Bundle();
        bundle.putString(CMBApiUtils.CMBAPI_INTENT_CODE, "0");
        bundle.putString("respstring", "1");
        message.setData(bundle);
        this.f132c.sendMessage(message);
        return 0;
    }

    @JavascriptInterface
    public int setCallback(String str, String str2) {
        Log.d(CMBConstants.TAG, "handleRespMessage respCode: setcallback ,respcode:" + str + ",respstring:" + str2);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Message message = new Message();
        message.what = 261;
        Bundle bundle = new Bundle();
        bundle.putString("payrespcode", str);
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("payrespstring", str2);
        message.setData(bundle);
        this.f132c.sendMessage(message);
        return 0;
    }
}