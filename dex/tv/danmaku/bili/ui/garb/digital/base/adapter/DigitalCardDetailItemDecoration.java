package tv.danmaku.bili.ui.garb.digital.base.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.droid.ScreenUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: DigitalCardDetailItemDecoration.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\n¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/adapter/DigitalCardDetailItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "containerHeight", "", "isHalfScreen", "", "<init>", "(Landroid/content/Context;IZ)V", "()Z", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", AuthResultCbHelper.ARGS_STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailItemDecoration extends RecyclerView.ItemDecoration {
    public static final int $stable = 8;
    private final int containerHeight;
    private final Context context;
    private final boolean isHalfScreen;

    public DigitalCardDetailItemDecoration(Context context, int containerHeight, boolean isHalfScreen) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.containerHeight = containerHeight;
        this.isHalfScreen = isHalfScreen;
    }

    public final boolean isHalfScreen() {
        return this.isHalfScreen;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int margin;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        int position = parent.getChildAdapterPosition(view);
        int parentWidth = parent.getMeasuredWidth();
        if (this.isHalfScreen) {
            int containerWidth = (this.containerHeight * 2) / 3;
            margin = RangesKt.coerceAtLeast(0, (parentWidth - containerWidth) / 2);
        } else {
            int width = ScreenUtil.dip2px(this.context, 263.0f);
            margin = RangesKt.coerceAtLeast(0, (parentWidth - width) / 2);
        }
        if (position == 0) {
            outRect.left = margin;
        } else if (position == state.getItemCount() - 1) {
            outRect.right = margin;
        }
    }
}