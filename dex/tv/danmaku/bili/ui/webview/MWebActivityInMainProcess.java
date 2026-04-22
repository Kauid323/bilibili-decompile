package tv.danmaku.bili.ui.webview;

import android.content.Context;
import android.view.ViewGroup;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MWebActivityInMainProcess.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/webview/MWebActivityInMainProcess;", "Ltv/danmaku/bili/ui/webview/MWebActivity;", "<init>", "()V", "tintSystemBar", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MWebActivityInMainProcess extends MWebActivity {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void tintSystemBar() {
        super.tintSystemBar();
        ViewGroup.LayoutParams layoutParams = getWebContainer().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layoutParams;
        lp.topMargin += StatusBarCompat.getStatusBarHeight((Context) this);
        getWebContainer().requestLayout();
    }
}