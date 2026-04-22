package tv.danmaku.bili.videopage.common.segment;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.foundation.ParamsParser;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WindowStateManageSegment.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/WindowStateParamsParser;", "Ltv/danmaku/bili/videopage/foundation/ParamsParser;", "toolbar", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getToolbar", "()Landroid/view/View;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WindowStateParamsParser implements ParamsParser {
    private final View toolbar;

    public WindowStateParamsParser(View toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        this.toolbar = toolbar;
    }

    public final View getToolbar() {
        return this.toolbar;
    }
}