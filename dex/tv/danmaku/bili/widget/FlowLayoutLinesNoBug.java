package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.FlowLayout;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FlowLayoutLinesNoBug.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014J\u0006\u0010\u0014\u001a\u00020\n¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/widget/FlowLayoutLinesNoBug;", "Ltv/danmaku/bili/widget/FlowLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLayout", "", "changed", "", "l", "t", "r", "b", "getMaxLineLastViewIndex", "followingCard_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FlowLayoutLinesNoBug extends FlowLayout {
    public static final int $stable = 8;

    public FlowLayoutLinesNoBug(Context context) {
        super(context);
    }

    public FlowLayoutLinesNoBug(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlowLayoutLinesNoBug(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.widget.FlowLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.lines.size() != 0) {
            int maxLineLastViewIndex = getMaxLineLastViewIndex();
            if (maxLineLastViewIndex == -1) {
                super.onLayout(changed, l, t, r, b);
                return;
            }
            int i = 0;
            if (0 > maxLineLastViewIndex) {
                return;
            }
            while (true) {
                View child = getChildAt(i);
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                FlowLayout.LayoutParams lp = (FlowLayout.LayoutParams) layoutParams;
                child.layout(lp.x + lp.leftMargin, lp.y + lp.topMargin, lp.x + lp.leftMargin + child.getMeasuredWidth(), lp.y + lp.topMargin + child.getMeasuredHeight());
                if (i == maxLineLastViewIndex) {
                    return;
                }
                i++;
            }
        } else {
            super.onLayout(changed, l, t, r, b);
        }
    }

    public final int getMaxLineLastViewIndex() {
        int i = this.lines.size();
        while (true) {
            i--;
            if (-1 >= i) {
                return -1;
            }
            View[] views = this.lines.get(i).views;
            if (views != null) {
                for (int j = views.length - 1; -1 < j; j--) {
                    if (views[j] != null) {
                        return indexOfChild(views[j]);
                    }
                }
                continue;
            }
        }
    }
}