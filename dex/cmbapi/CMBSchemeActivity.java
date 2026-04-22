package cmbapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import cmbapi.CMBApi;
import com.alipay.sdk.m.l.e;
import com.bilibili.lib.spy.generated.android_app_Activity;

public class CMBSchemeActivity extends android_app_Activity implements CMBEventHandler {
    private static String APPID = "cmbapi";
    private static CMBApi cmbApi = null;
    private static boolean bInit = false;

    /* JADX WARN: Multi-variable type inference failed */
    private void handleRequest() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        intent.getStringExtra("appid");
        if (cmbApi == null) {
            cmbApi = CMBApiFactory.createCMBAPI(this, APPID);
        }
        String stringExtra = intent.getStringExtra(e.s);
        String stringExtra2 = intent.getStringExtra("payurl");
        if (TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        CMBRequest cMBRequest = new CMBRequest();
        cMBRequest.requestData = "";
        cMBRequest.CMBJumpAppUrl = stringExtra2;
        cMBRequest.CMBH5Url = stringExtra2;
        cMBRequest.method = stringExtra;
        cmbApi.sendReq(cMBRequest, CMBApi.PaySdk.mCallback);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (cmbApi != null) {
            cmbApi.handleIntent(intent, this);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        handleRequest();
        if (cmbApi != null) {
            cmbApi.handleIntent(getIntent(), this);
        }
        finish();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (cmbApi != null) {
            cmbApi.handleIntent(intent, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cmbapi.CMBEventHandler
    public void onResp(CMBResponse cMBResponse) {
        if (cMBResponse.respCode == 0) {
            Toast.makeText((Context) this, (CharSequence) ("调用成功.str:" + cMBResponse.respMsg), 0).show();
            if (CMBApi.PaySdk.mCallback != null) {
                CMBApi.PaySdk.mCallback.onSuccess(cMBResponse.respMsg);
            }
        } else {
            Toast.makeText((Context) this, (CharSequence) "调用失败", 0).show();
            if (CMBApi.PaySdk.mCallback != null) {
                CMBApi.PaySdk.mCallback.onError(cMBResponse.respMsg);
            }
        }
        CMBApi.PaySdk.mCallback = null;
        CMBApi.PaySdk.mAppId = "";
        CMBApi.PaySdk.mContext = null;
    }
}