package tv.danmaku.bili.auth;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.facialrecognition.FacialBizType;
import com.bilibili.lib.facialrecognition.FacialRecognitionHelper;
import com.bilibili.lib.facialrecognition.v2.FacialErrorInfo;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: BiliAuthWebCompatActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthWebCompatActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "toSuccess", "requestId", "", "onFailed", "errorCode", "", AuthResultCbHelper.ARGS_MSG, "causeCode", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthWebCompatActivity extends FragmentActivity {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_BIZ_TYPE = "key_biz_type";
    private static final String KEY_CARD = "key_card";
    private static final String KEY_NAME = "key_name";
    private static final String KEY_SOURCE_EVENT = "key_source_event";
    private static final String TAG = "BiliAuthWebCompatActivity";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: BiliAuthWebCompatActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthWebCompatActivity$Companion;", "", "<init>", "()V", "TAG", "", "KEY_NAME", "KEY_CARD", "KEY_BIZ_TYPE", "KEY_SOURCE_EVENT", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
        if ((r9.length() == 0) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = getIntent().getStringExtra(KEY_NAME);
        if (name == null) {
            name = "";
        }
        String stringExtra = getIntent().getStringExtra("key_card");
        if (stringExtra == null) {
            stringExtra = "";
        }
        final String card = stringExtra;
        final String bizType = getIntent().getStringExtra(KEY_BIZ_TYPE);
        String stringExtra2 = getIntent().getStringExtra(KEY_SOURCE_EVENT);
        final String sourceEvent = stringExtra2 == null ? "" : stringExtra2;
        BLog.d(TAG, "name = " + name + ", card = " + card + ", bizType = " + bizType + ", isMainProcess = " + BiliContext.isMainProcess());
        if (!(name.length() == 0)) {
        }
        if (FacialBizType.INSTANCE.disallowCardNull(bizType == null ? "" : bizType)) {
            BLog.w(TAG, "参数有误, name = " + name + ", card = " + card);
            return;
        }
        Application context = Foundation.Companion.instance().getApp();
        String accessKey = BiliAccounts.get(context).getAccessKey();
        String accessKey2 = accessKey != null ? accessKey : "";
        final Ref.ObjectRef helper = new Ref.ObjectRef();
        final String str = name;
        helper.element = new FacialRecognitionHelper((Context) this, accessKey2, BuvidHelper.getBuvid(), new FacialRecognitionHelper.IFacialCallback() { // from class: tv.danmaku.bili.auth.BiliAuthWebCompatActivity$onCreate$internalCallback$1
            public /* synthetic */ void onDetectStart() {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onDetectStart(this);
            }

            public /* synthetic */ void onFailure(FacialErrorInfo facialErrorInfo) {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, facialErrorInfo);
            }

            public /* synthetic */ void onRequestEnd() {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestEnd(this);
            }

            public /* synthetic */ void onRequestStart() {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onRequestStart(this);
            }

            public /* synthetic */ void onSuccess(String str2, String str3) {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, str2, str3);
            }

            public /* synthetic */ void onSuccessForOverride(String str2, String str3) {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccessForOverride(this, str2, str3);
            }

            public void onInitSuccess() {
                Object obj = helper.element;
                Intrinsics.checkNotNull(obj);
                FacialRecognitionHelper facialRecognitionHelper = (FacialRecognitionHelper) obj;
                String str2 = str;
                String str3 = card;
                String str4 = bizType;
                if (str4 == null) {
                    str4 = "";
                }
                FacialRecognitionHelper.beginDetect$default(facialRecognitionHelper, str2, str3, str4, sourceEvent, (String) null, (String) null, 48, (Object) null);
            }

            public void onFailure(int errorCode, String msg, int causeCode) {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onFailure(this, errorCode, msg, causeCode);
                this.onFailed(errorCode, msg, causeCode);
            }

            public void onSuccess(String requestID) {
                FacialRecognitionHelper.IFacialCallback.-CC.$default$onSuccess(this, requestID);
                this.toSuccess(requestID);
            }
        });
        ((FacialRecognitionHelper) helper.element).init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toSuccess(String requestId) {
        BLog.d(TAG, "onSuccess");
        Intent intent = new Intent();
        intent.putExtra("auth_result", 1);
        intent.putExtra(BiliAuthTransferActivity.BUNDLE_REQUEST_ID, requestId);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFailed(int errorCode, String msg, int causeCode) {
        BLog.d(TAG, "onFailed, errorCode = " + errorCode + ", msg = " + msg);
        Intent intent = new Intent();
        intent.putExtra("auth_result", 0);
        intent.putExtra("auth_msg", msg == null ? "" : msg);
        intent.putExtra("auth_error_code", causeCode);
        setResult(-1, intent);
        finish();
    }
}