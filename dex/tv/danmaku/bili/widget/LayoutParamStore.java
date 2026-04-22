package tv.danmaku.bili.widget;

import android.view.View;
import android.view.ViewDebug;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PriorityLinearLayout.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/widget/LayoutParamStore;", "", "<init>", "()V", "visibility", "", "getVisibility", "()I", "setVisibility", "(I)V", "saveParam", "", "view", "Landroid/view/View;", "restoreParam", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LayoutParamStore {
    @ViewDebug.ExportedProperty(category = "collapse", mapping = {@ViewDebug.IntToString(from = 0, to = "VISIBLE"), @ViewDebug.IntToString(from = 4, to = "INVISIBLE"), @ViewDebug.IntToString(from = 8, to = "GONE")})
    private int visibility;

    public final int getVisibility() {
        return this.visibility;
    }

    public final void setVisibility(int i) {
        this.visibility = i;
    }

    public final void saveParam(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.visibility = view2.getVisibility();
    }

    public final void restoreParam(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setVisibility(this.visibility);
    }
}