package tv.danmaku.bili.rating;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bilibili.droid.DimenUtilsKt;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.iconfont.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RatingView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u0007R\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/rating/RatingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "rating", "setRating", "(I)V", "starSrc", "Landroid/graphics/drawable/Drawable;", "starColorSelect", "starColorUnselect", "starWidth", "spaceWidth", "viewWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "performClick", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "getRating", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RatingView extends View {
    public static final int $stable = 8;
    private int rating;
    private final int spaceWidth;
    private final int starColorSelect;
    private final int starColorUnselect;
    private final Drawable starSrc;
    private final int starWidth;
    private final int viewWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RatingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.starSrc = KtxKt.getAppCompatDrawable(context, R.drawable.ref_star_favorite_fill_500);
        int resId$iv = com.bilibili.lib.theme.R.color.Pay_yellow;
        this.starColorSelect = ContextCompat.getColor(context, resId$iv);
        int resId$iv2 = com.bilibili.lib.theme.R.color.Graph_bg_thick;
        this.starColorUnselect = ContextCompat.getColor(context, resId$iv2);
        this.starWidth = DimenUtilsKt.dpToPx(36);
        this.spaceWidth = DimenUtilsKt.dpToPx(6);
        this.viewWidth = (this.spaceWidth * 6) + (this.starWidth * 5);
    }

    public /* synthetic */ RatingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setRating(int value) {
        this.rating = value;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.viewWidth, this.starWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i = 0;
        while (i < 5) {
            int left = ((this.starWidth + this.spaceWidth) * i) + this.spaceWidth;
            Drawable it = this.starSrc;
            if (it != null) {
                it.setTint(i < this.rating ? this.starColorSelect : this.starColorUnselect);
                it.setBounds(left, 0, this.starWidth + left, this.starWidth);
                it.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            float x = event.getX();
            setRating(((int) (x / (this.spaceWidth + this.starWidth))) + 1);
            performClick();
            return true;
        }
        return super.onTouchEvent(event);
    }

    public final int getRating() {
        return this.rating;
    }
}