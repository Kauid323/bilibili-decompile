package tv.danmaku.bili.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bilibili.lib.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: BiliAuthWebCompatFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ,\u0010\t\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthWebCompatFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", ChannelRoutes.CHANNEL_NAME, "", "cardNo", "bizType", "sourceEvent", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/auth/BiliAuthWebCompatCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "setCallback", "result", AuthResultCbHelper.ARGS_MSG, "errorCode", "requestId", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthWebCompatFragment extends BaseFragment {
    public static final String BUNDLE_ERROR_CODE = "auth_error_code";
    public static final String BUNDLE_KEY = "auth_result";
    public static final String BUNDLE_MSG = "auth_msg";
    public static final Companion Companion = new Companion(null);
    private static final String KEY_BIZ_TYPE = "key_biz_type";
    private static final String KEY_CARD = "key_card";
    private static final String KEY_NAME = "key_name";
    private static final String KEY_SOURCE_EVENT = "key_source_event";
    private static final int REQUEST_CODE_WEB_COMPAT = 10001;
    public static final String TAG = "BiliAuthWebCompatFragment";
    private String bizType;
    private BiliAuthWebCompatCallback callback;
    private String cardNo;
    private String name;
    private String sourceEvent;

    /* compiled from: BiliAuthWebCompatFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthWebCompatFragment$Companion;", "", "<init>", "()V", "TAG", "", "KEY_NAME", "KEY_CARD", "KEY_BIZ_TYPE", "KEY_SOURCE_EVENT", "BUNDLE_KEY", "BUNDLE_ERROR_CODE", "BUNDLE_MSG", "REQUEST_CODE_WEB_COMPAT", "", "getInstance", "Ltv/danmaku/bili/auth/BiliAuthWebCompatFragment;", ChannelRoutes.CHANNEL_NAME, "cardNo", "bizType", "sourceEvent", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BiliAuthWebCompatFragment getInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ChannelRoutes.CHANNEL_NAME);
            Intrinsics.checkNotNullParameter(str2, "cardNo");
            return getInstance$default(this, str, str2, null, null, 12, null);
        }

        public final BiliAuthWebCompatFragment getInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, ChannelRoutes.CHANNEL_NAME);
            Intrinsics.checkNotNullParameter(str2, "cardNo");
            return getInstance$default(this, str, str2, str3, null, 8, null);
        }

        private Companion() {
        }

        public static /* synthetic */ BiliAuthWebCompatFragment getInstance$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = "";
            }
            return companion.getInstance(str, str2, str3, str4);
        }

        public final BiliAuthWebCompatFragment getInstance(String name, String cardNo, String bizType, String sourceEvent) {
            Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
            Intrinsics.checkNotNullParameter(cardNo, "cardNo");
            BiliAuthWebCompatFragment fragment = new BiliAuthWebCompatFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BiliAuthWebCompatFragment.KEY_NAME, name);
            bundle.putString("key_card", cardNo);
            bundle.putString(BiliAuthWebCompatFragment.KEY_BIZ_TYPE, bizType);
            bundle.putString(BiliAuthWebCompatFragment.KEY_SOURCE_EVENT, sourceEvent);
            fragment.setArguments(bundle);
            return fragment;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle it = getArguments();
        if (it != null) {
            this.name = it.getString(KEY_NAME, "");
            this.cardNo = it.getString("key_card", "");
            this.bizType = it.getString(KEY_BIZ_TYPE, "");
            this.sourceEvent = it.getString(KEY_SOURCE_EVENT, "");
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        String str = this.name;
        BLog.d(TAG, "onCreate -> name = " + str + ", cardNo = " + this.cardNo + ", bizType = " + this.bizType);
        Intent intent = new Intent(context, BiliAuthWebCompatActivity.class);
        String str2 = this.name;
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra(KEY_NAME, str2);
        String str3 = this.cardNo;
        intent.putExtra("key_card", str3 != null ? str3 : "");
        intent.putExtra(KEY_BIZ_TYPE, this.bizType);
        intent.putExtra(KEY_SOURCE_EVENT, this.sourceEvent);
        startActivityForResult(intent, REQUEST_CODE_WEB_COMPAT);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BLog.d(TAG, "onActivityResult");
        if (requestCode == REQUEST_CODE_WEB_COMPAT && resultCode == -1 && data != null) {
            int result = data.getIntExtra("auth_result", 0);
            String msg = data.getStringExtra("auth_msg");
            int errorCode = data.getIntExtra("auth_error_code", 0);
            String requestId = data.getStringExtra(BiliAuthTransferActivity.BUNDLE_REQUEST_ID);
            if (requestId == null) {
                requestId = "";
            }
            callback(result, msg, errorCode, requestId);
        }
    }

    public final void setCallback(BiliAuthWebCompatCallback callback) {
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        this.callback = callback;
    }

    private final void callback(int result, String msg, int errorCode, String requestId) {
        BLog.d(TAG, AuthResultCbHelper.ARGS_CALLBACK);
        if (result == 1) {
            BiliAuthWebCompatCallback biliAuthWebCompatCallback = this.callback;
            if (biliAuthWebCompatCallback != null) {
                biliAuthWebCompatCallback.onSuccess(requestId);
                return;
            }
            return;
        }
        BiliAuthWebCompatCallback biliAuthWebCompatCallback2 = this.callback;
        if (biliAuthWebCompatCallback2 != null) {
            biliAuthWebCompatCallback2.onFailure(errorCode, msg);
        }
    }
}