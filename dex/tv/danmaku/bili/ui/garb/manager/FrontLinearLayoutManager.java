package tv.danmaku.bili.ui.garb.manager;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bilibili.droid.ScreenUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FrontLinearLayoutManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/garb/manager/FrontLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "canScrollHorizontally", "", "<init>", "(Landroid/content/Context;Z)V", "mOffset", "", "scrollToPosition", "", "position", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FrontLinearLayoutManager extends LinearLayoutManager {
    public static final int $stable = 8;
    private final boolean canScrollHorizontally;
    private final float mOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrontLinearLayoutManager(Context context, boolean canScrollHorizontally) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
        this.canScrollHorizontally = canScrollHorizontally;
        this.mOffset = (ScreenUtil.getScreenWidth(context) - ScreenUtil.dip2px(context, 216.0f)) / 2.0f;
    }

    public void scrollToPosition(int position) {
        scrollToPositionWithOffset(position, (int) this.mOffset);
    }

    public boolean canScrollHorizontally() {
        return this.canScrollHorizontally;
    }
}