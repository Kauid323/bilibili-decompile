package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.webview2.WebSuicide;
import com.bililive.bililive.infra.hybrid.ui.WebViewActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: NftCardWebActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardWebActivity;", "Lcom/bililive/bililive/infra/hybrid/ui/WebViewActivity;", "<init>", "()V", "mWebContainer", "Ltv/danmaku/bili/ui/garb/NftWebContainer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class NftCardWebActivity extends WebViewActivity {
    @Deprecated
    public static final String TAG = "NftCardWebActivity";
    private NftWebContainer mWebContainer;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: NftCardWebActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardWebActivity$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        WebSuicide.enter(TAG);
        super.onCreate(savedInstanceState);
        NftWebContainer $this$onCreate_u24lambda_u240 = new NftWebContainer((Activity) this);
        $this$onCreate_u24lambda_u240.injectWebView(getLiveWeb());
        Map $this$forEach$iv = $this$onCreate_u24lambda_u240.allBuildInBridges();
        if ($this$forEach$iv != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                addBizBridge(element$iv.getKey(), element$iv.getValue(), true);
            }
        }
        this.mWebContainer = $this$onCreate_u24lambda_u240;
    }
}