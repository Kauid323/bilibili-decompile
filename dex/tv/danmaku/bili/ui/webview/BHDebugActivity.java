package tv.danmaku.bili.ui.webview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BHDebugActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0015¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/webview/BHDebugActivity;", "Ltv/danmaku/bili/ui/webview/MWebActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "checkUriFromIntent", "getExtraBuiltinJsBridgeCallHandlers", "", "", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BHDebugActivity extends MWebActivity {
    private static final String SHEME = "bilibili://debugger";
    private static final String TAG = "BHDebugActivity";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: BHDebugActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/webview/BHDebugActivity$Companion;", "", "<init>", "()V", "SHEME", "", "TAG", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void onCreate(Bundle savedInstanceState) {
        BLog.i(TAG, "onCreate");
        checkUriFromIntent();
        super.onCreate(savedInstanceState);
    }

    private final void checkUriFromIntent() {
        Uri uri = getIntent().getData();
        if (uri != null) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
            String lowerCase = uri2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.startsWith$default(lowerCase, SHEME, false, 2, (Object) null)) {
                return;
            }
        }
        String decoded = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(decoded)) {
            getIntent().setData(Uri.parse(decoded));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public Map<String, JsBridgeCallHandlerFactoryV2> getExtraBuiltinJsBridgeCallHandlers() {
        Map map = new HashMap();
        return map;
    }
}