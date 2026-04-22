package tv.danmaku.bili.widget.dialog;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CommonDialogUtils.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u0002H\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001*\u0002H\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0002*\u00020\t*\u0002H\u00022\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"dp2px", "", "T", "context", "Landroid/content/Context;", "(ILandroid/content/Context;)I", "px2dp", "setVisibility", "", "Landroid/view/View;", "show", "", "(Landroid/view/View;Z)V", "widget_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CommonDialogUtilsKt {
    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Integer;>(TT;Landroid/content/Context;)I */
    public static final int dp2px(int $this$dp2px, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (($this$dp2px * scale) + 0.5f);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Integer;>(TT;Landroid/content/Context;)I */
    public static final int px2dp(int $this$px2dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (($this$px2dp / scale) + 0.5f);
    }

    public static final <T extends View> void setVisibility(T t, boolean show) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        t.setVisibility(show ? 0 : 8);
    }
}