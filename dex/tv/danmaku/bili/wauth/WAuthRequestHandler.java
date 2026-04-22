package tv.danmaku.bili.wauth;

import android.content.Intent;
import com.bilibili.api.BiliApiException;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.wauth.Bean.WAuthVerifyBean;
import tv.danmaku.bili.wauth.service.RequestVerifyListener;
import tv.danmaku.bili.wauth.service.WAuthRequest;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WAuthRequestHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthRequestHandler;", "Ltv/danmaku/bili/wauth/service/WAuthRequest;", "<init>", "()V", "requestVerify", "", "tempCode", "serialNum", "intent", "Landroid/content/Intent;", "listener", "Ltv/danmaku/bili/wauth/service/RequestVerifyListener;", "Companion", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WAuthRequestHandler implements WAuthRequest {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "WAuthRequestHandler";

    @Override // tv.danmaku.bili.wauth.service.WAuthRequest
    public String requestVerify(String tempCode, String serialNum, Intent intent, final RequestVerifyListener listener) {
        String error_message_temp_null;
        if (intent != null) {
            String str = tempCode;
            if (!(str == null || str.length() == 0)) {
                String stringExtra = intent.getStringExtra("idCardAuthData");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                String idCardAuthData = stringExtra;
                String stringExtra2 = intent.getStringExtra("certPwdData");
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                String certPwdData = stringExtra2;
                BLog.i(TAG, "requestVerify- idCardAuthData=" + idCardAuthData + ", certPwdData=" + certPwdData);
                WAuthRequestHelper.Companion.getInstance().getWAuthVerify("", tempCode, serialNum == null ? "" : serialNum, certPwdData, "", idCardAuthData, "", "", "", "", "", new BiliApiDataCallback<WAuthVerifyBean>() { // from class: tv.danmaku.bili.wauth.WAuthRequestHandler$requestVerify$1
                    public void onDataSuccess(WAuthVerifyBean data) {
                        if (data != null) {
                            String code = data.getCode();
                            if (!(code == null || code.length() == 0)) {
                                RequestVerifyListener requestVerifyListener = RequestVerifyListener.this;
                                if (requestVerifyListener != null) {
                                    requestVerifyListener.onSuccess(data.getCode());
                                    return;
                                }
                                return;
                            }
                        }
                        BLog.e(WAuthRequestHandler.TAG, "requestVerify-Error: Code is null");
                        RequestVerifyListener requestVerifyListener2 = RequestVerifyListener.this;
                        if (requestVerifyListener2 != null) {
                            requestVerifyListener2.onError("-1", WAuthErrorMsg.Companion.getERROR_MESSAGE_CODE_NULL());
                        }
                    }

                    public void onError(Throwable t) {
                        if (t instanceof BiliApiException) {
                            BLog.e(WAuthRequestHandler.TAG, "requestVerify-Error: " + ((BiliApiException) t).mCode + ", " + ((BiliApiException) t).getMessage());
                            RequestVerifyListener requestVerifyListener = RequestVerifyListener.this;
                            if (requestVerifyListener != null) {
                                requestVerifyListener.onError(String.valueOf(((BiliApiException) t).mCode), ((BiliApiException) t).getMessage());
                                return;
                            }
                            return;
                        }
                        BLog.e(WAuthRequestHandler.TAG, "requestVerify-Error: " + (t != null ? t.getMessage() : null));
                        RequestVerifyListener requestVerifyListener2 = RequestVerifyListener.this;
                        if (requestVerifyListener2 != null) {
                            requestVerifyListener2.onError("-1", (t == null || (r1 = t.getMessage()) == null) ? "" : "");
                        }
                    }
                });
                return null;
            }
        }
        return (intent == null || (error_message_temp_null = WAuthErrorMsg.Companion.getERROR_MESSAGE_TEMP_NULL()) == null) ? WAuthErrorMsg.Companion.getERROR_MESSAGE_INTENT_NULL() : error_message_temp_null;
    }

    /* compiled from: WAuthRequestHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthRequestHandler$Companion;", "", "<init>", "()V", "TAG", "", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}