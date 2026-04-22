package tv.danmaku.bili.wauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.wauth.service.RequestVerifyListener;
import tv.danmaku.bili.wauth.service.WAuthInvokeService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BiliWAuthTransferActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014JZ\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/wauth/BiliWAuthTransferActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "()V", "mTempCode", "", "mSerialNum", "mWAuthServiceHelper", "Ltv/danmaku/bili/wauth/WAuthServiceHelper;", "mWAuthRequestHelper", "Ltv/danmaku/bili/wauth/WAuthRequestHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "setResultToActivity", "code", "message", "detail", "dataCode", "bizSeq", "idCardAuthData", "certPwdData", "Companion", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliWAuthTransferActivity extends BaseAppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_TEMP_CODE = "temp_code";
    private static final String TAG = "BiliWAuthTransferActivity";
    private String mTempCode = "";
    private String mSerialNum = "";
    private final WAuthServiceHelper mWAuthServiceHelper = new WAuthServiceHelper((Activity) this);
    private final WAuthRequestHandler mWAuthRequestHelper = new WAuthRequestHandler();

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra(KEY_TEMP_CODE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mTempCode = stringExtra;
        if (!WAuthInvokeService.CC.getAuthFromIntent$default(this.mWAuthServiceHelper, null, false, 3, null)) {
            BLog.e(TAG, "App not installed!");
            setResultToActivity$default(this, WAuthErrorMsg.ERROR_CODE_UNINSTALLED, WAuthErrorMsg.ERROR_MESSAGE_CALL, "app not installed", null, null, null, null, 120, null);
        }
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("resultCode");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String resultCode = stringExtra;
        String stringExtra2 = intent.getStringExtra("resultDesc");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String resultDesc = stringExtra2;
        String stringExtra3 = intent.getStringExtra("idCardAuthData");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        final String idCardAuthData = stringExtra3;
        String stringExtra4 = intent.getStringExtra("certPwdData");
        final String certPwdData = stringExtra4 != null ? stringExtra4 : "";
        BLog.i(TAG, "onNewIntent: resultCode=" + resultCode + ", resultDesc=" + resultDesc);
        if (Intrinsics.areEqual(resultCode, WAuthErrorMsg.CODE_CALL_SUCCESS)) {
            if (this.mTempCode.length() == 0) {
                this.mSerialNum = this.mWAuthServiceHelper.getSerialNumber();
                setResultToActivity$default(this, "0", null, null, null, this.mSerialNum, idCardAuthData, certPwdData, 14, null);
                return;
            }
            this.mSerialNum = this.mWAuthServiceHelper.getSerialNumber();
            String result = this.mWAuthRequestHelper.requestVerify(this.mTempCode, this.mSerialNum, intent, new RequestVerifyListener() { // from class: tv.danmaku.bili.wauth.BiliWAuthTransferActivity$onNewIntent$result$1
                @Override // tv.danmaku.bili.wauth.service.RequestVerifyListener
                public void onSuccess(String code) {
                    BLog.i("BiliWAuthTransferActivity", "Request success: code=" + code);
                    BiliWAuthTransferActivity.setResultToActivity$default(BiliWAuthTransferActivity.this, "0", null, null, code, null, idCardAuthData, certPwdData, 22, null);
                }

                @Override // tv.danmaku.bili.wauth.service.RequestVerifyListener
                public void onError(String errorCode, String msg) {
                    BiliWAuthTransferActivity.setResultToActivity$default(BiliWAuthTransferActivity.this, errorCode, WAuthErrorMsg.ERROR_MESSAGE_REQUEST, msg, null, null, null, null, 120, null);
                }
            });
            if (result != null) {
                setResultToActivity$default(this, "-1", WAuthErrorMsg.ERROR_MESSAGE_CALL, result, null, null, null, null, 120, null);
                return;
            }
            return;
        }
        BLog.e(TAG, "Evoke app error: " + resultCode + ", " + resultDesc);
        setResultToActivity$default(this, resultCode, WAuthErrorMsg.ERROR_MESSAGE_CALL, resultDesc, null, null, null, null, 120, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void setResultToActivity$default(BiliWAuthTransferActivity biliWAuthTransferActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        biliWAuthTransferActivity.setResultToActivity(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) == 0 ? str7 : "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        if ((r11.length() > 0) == true) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setResultToActivity(String code, String message, String detail, String dataCode, String bizSeq, String idCardAuthData, String certPwdData) {
        boolean z;
        boolean z2;
        boolean z3;
        Intent intent = new Intent();
        intent.putExtra("code", code == null ? "" : code);
        intent.putExtra("message", message == null ? "" : message);
        intent.putExtra("detail", detail != null ? detail : "");
        boolean z4 = true;
        if (dataCode != null) {
            if (dataCode.length() > 0) {
                z = true;
                if (z) {
                    intent.putExtra("ticket", dataCode);
                }
                if (bizSeq != null) {
                    if (bizSeq.length() > 0) {
                        z2 = true;
                        if (z2) {
                            intent.putExtra("bizSeq", bizSeq);
                        }
                        if (idCardAuthData != null) {
                            if (idCardAuthData.length() > 0) {
                                z3 = true;
                                if (z3) {
                                    intent.putExtra("idCardAuthData", idCardAuthData);
                                }
                                if (certPwdData != null) {
                                }
                                z4 = false;
                                if (z4) {
                                    intent.putExtra("certPwdData", certPwdData);
                                }
                                setResult(-1, intent);
                                finish();
                            }
                        }
                        z3 = false;
                        if (z3) {
                        }
                        if (certPwdData != null) {
                        }
                        z4 = false;
                        if (z4) {
                        }
                        setResult(-1, intent);
                        finish();
                    }
                }
                z2 = false;
                if (z2) {
                }
                if (idCardAuthData != null) {
                }
                z3 = false;
                if (z3) {
                }
                if (certPwdData != null) {
                }
                z4 = false;
                if (z4) {
                }
                setResult(-1, intent);
                finish();
            }
        }
        z = false;
        if (z) {
        }
        if (bizSeq != null) {
        }
        z2 = false;
        if (z2) {
        }
        if (idCardAuthData != null) {
        }
        z3 = false;
        if (z3) {
        }
        if (certPwdData != null) {
        }
        z4 = false;
        if (z4) {
        }
        setResult(-1, intent);
        finish();
    }

    /* compiled from: BiliWAuthTransferActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/wauth/BiliWAuthTransferActivity$Companion;", "", "<init>", "()V", "TAG", "", "KEY_TEMP_CODE", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}