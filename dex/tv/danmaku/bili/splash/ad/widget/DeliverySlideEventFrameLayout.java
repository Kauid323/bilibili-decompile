package tv.danmaku.bili.splash.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DeliverySlideEventFrameLayout.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0017J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/DeliverySlideEventFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Ltv/danmaku/bili/splash/ad/widget/MotionEventListener;", "interactEnable", "", "getInteractEnable", "()Z", "setInteractEnable", "(Z)V", "mStartX", "mStartY", "mTouchSlop", "isSliding", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "", "onTouchEvent", "event", "setEventListener", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DeliverySlideEventFrameLayout extends FrameLayout {
    public static final int $stable = 8;
    private boolean interactEnable;
    private boolean isSliding;
    private MotionEventListener listener;
    private int mStartX;
    private int mStartY;
    private final int mTouchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeliverySlideEventFrameLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeliverySlideEventFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeliverySlideEventFrameLayout(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStartX = -1;
        this.mStartY = -1;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public /* synthetic */ DeliverySlideEventFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final boolean getInteractEnable() {
        return this.interactEnable;
    }

    public final void setInteractEnable(boolean z) {
        this.interactEnable = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev == null || !this.interactEnable || this.listener == null) {
            return super.onInterceptTouchEvent(ev);
        }
        switch (ev.getActionMasked()) {
            case 0:
                this.mStartX = (int) (ev.getX() + 0.5f);
                this.mStartY = (int) (ev.getY() + 0.5f);
                break;
            case 1:
            case 3:
                clear();
                break;
            case 2:
                if (!this.isSliding) {
                    float dx = ev.getX() - this.mStartX;
                    float dy = ev.getY() - this.mStartY;
                    if (Math.abs(dx) >= this.mTouchSlop || Math.abs(dy) >= this.mTouchSlop) {
                        this.isSliding = true;
                        break;
                    }
                }
                break;
        }
        return this.isSliding;
    }

    private final void clear() {
        this.isSliding = false;
        this.mStartX = 0;
        this.mStartY = 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        MotionEventListener motionEventListener;
        if (!this.interactEnable || event == null || this.listener == null) {
            return super.onTouchEvent(event);
        }
        if (this.isSliding && (motionEventListener = this.listener) != null) {
            motionEventListener.onTouchEvent(event);
        }
        switch (event.getActionMasked()) {
            case 1:
            case 3:
                clear();
                break;
        }
        return this.isSliding;
    }

    public final void setEventListener(MotionEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}