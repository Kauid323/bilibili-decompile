package leakcanary.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowElementLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0014J0\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0014J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lleakcanary/internal/RowElementLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "connector", "Landroid/view/View;", "connectorWidth", "", "minHeight", "moreMarginTop", "moreSize", "rowMargins", "title", "titleMarginTop", "onFinishInflate", "", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class RowElementLayout extends ViewGroup {
    private View connector;
    private final int connectorWidth;
    private final int minHeight;
    private final int moreMarginTop;
    private final int moreSize;
    private final int rowMargins;
    private View title;
    private final int titleMarginTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RowElementLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Resources resources = getResources();
        this.connectorWidth = resources.getDimensionPixelSize(R.dimen.leak_canary_connector_width);
        this.rowMargins = resources.getDimensionPixelSize(R.dimen.leak_canary_row_margins);
        this.moreSize = resources.getDimensionPixelSize(R.dimen.leak_canary_more_size);
        this.minHeight = resources.getDimensionPixelSize(R.dimen.leak_canary_row_min);
        this.titleMarginTop = resources.getDimensionPixelSize(R.dimen.leak_canary_row_title_margin_top);
        this.moreMarginTop = resources.getDimensionPixelSize(R.dimen.leak_canary_more_margin_top);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.connector = findViewById(R.id.leak_canary_row_connector);
        this.title = findViewById(R.id.leak_canary_row_title);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int availableWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int titleWidth = ((availableWidth - this.connectorWidth) - this.moreSize) - (this.rowMargins * 4);
        int titleWidthSpec = View.MeasureSpec.makeMeasureSpec(titleWidth, IntCompanionObject.MIN_VALUE);
        int titleHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        View view = this.title;
        if (view == null) {
            Intrinsics.throwNpe();
        }
        view.measure(titleWidthSpec, titleHeightSpec);
        int i = this.titleMarginTop;
        View view2 = this.title;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int totalHeight = Math.max(i + view2.getMeasuredHeight(), this.minHeight);
        int connectorWidthSpec = View.MeasureSpec.makeMeasureSpec(this.connectorWidth, 1073741824);
        int connectorHeightSpec = View.MeasureSpec.makeMeasureSpec(totalHeight, 1073741824);
        View view3 = this.connector;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        view3.measure(connectorWidthSpec, connectorHeightSpec);
        setMeasuredDimension(availableWidth, totalHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i = this.rowMargins;
        View view = this.connector;
        if (view == null) {
            Intrinsics.throwNpe();
        }
        int connectorRight = i + view.getMeasuredWidth();
        View view2 = this.connector;
        if (view2 == null) {
            Intrinsics.throwNpe();
        }
        int i2 = this.rowMargins;
        View view3 = this.connector;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        view2.layout(i2, 0, connectorRight, view3.getMeasuredHeight());
        int titleLeft = this.rowMargins + connectorRight;
        int i3 = this.titleMarginTop;
        View view4 = this.title;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        int titleBottom = i3 + view4.getMeasuredHeight();
        View view5 = this.title;
        if (view5 == null) {
            Intrinsics.throwNpe();
        }
        int i4 = this.titleMarginTop;
        View view6 = this.title;
        if (view6 == null) {
            Intrinsics.throwNpe();
        }
        view5.layout(titleLeft, i4, view6.getMeasuredWidth() + titleLeft, titleBottom);
    }
}