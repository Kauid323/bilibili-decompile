package tv.danmaku.bili.ui.videospace;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bilibili.playerbizcommonv2.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.widget.IControlWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NormalPlayerInsetControllerWidget.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u001b\u001e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\"\u0010 \u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0014J\u0012\u0010*\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006-"}, d2 = {"Ltv/danmaku/bili/ui/videospace/NormalPlayerInsetControllerWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mTopBackground", "Landroid/graphics/drawable/Drawable;", "mBottomBackground", "mTopBackgroundHeight", "mBottomBackgroundHeight", "mContentTopPadding", "mContentBottomPadding", "mContentLeftPadding", "mContentRightPadding", "isImmersive", "", "mControlContainerVisibleObserver", "tv/danmaku/bili/ui/videospace/NormalPlayerInsetControllerWidget$mControlContainerVisibleObserver$1", "Ltv/danmaku/bili/ui/videospace/NormalPlayerInsetControllerWidget$mControlContainerVisibleObserver$1;", "mWindowInsetObserver", "tv/danmaku/bili/ui/videospace/NormalPlayerInsetControllerWidget$mWindowInsetObserver$1", "Ltv/danmaku/bili/ui/videospace/NormalPlayerInsetControllerWidget$mWindowInsetObserver$1;", "init", "", "onWidgetActive", "onWidgetInactive", "bindPlayerContainer", "playerContainer", "draw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "drawBackground", "drawDrawable", "drawable", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalPlayerInsetControllerWidget extends ConstraintLayout implements IControlWidget {
    public static final int $stable = 8;
    private boolean isImmersive;
    private Drawable mBottomBackground;
    private int mBottomBackgroundHeight;
    private int mContentBottomPadding;
    private int mContentLeftPadding;
    private int mContentRightPadding;
    private int mContentTopPadding;
    private final NormalPlayerInsetControllerWidget$mControlContainerVisibleObserver$1 mControlContainerVisibleObserver;
    private PlayerContainer mPlayerContainer;
    private Drawable mTopBackground;
    private int mTopBackgroundHeight;
    private final NormalPlayerInsetControllerWidget$mWindowInsetObserver$1 mWindowInsetObserver;

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public /* synthetic */ Object bindToView(Continuation continuation) {
        Object bindToView$suspendImpl;
        bindToView$suspendImpl = IControlWidget.CC.bindToView$suspendImpl(this, continuation);
        return bindToView$suspendImpl;
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public /* synthetic */ boolean getMembersInjector() {
        return IControlWidget.CC.$default$getMembersInjector(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NormalPlayerInsetControllerWidget(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NormalPlayerInsetControllerWidget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.ui.videospace.NormalPlayerInsetControllerWidget$mControlContainerVisibleObserver$1] */
    public NormalPlayerInsetControllerWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mControlContainerVisibleObserver = new ControlContainerVisibleObserver() { // from class: tv.danmaku.bili.ui.videospace.NormalPlayerInsetControllerWidget$mControlContainerVisibleObserver$1
            @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
            public void onControlContainerVisibleChanged(boolean visible) {
            }

            @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
            public void onControlContainerImmersiveChanged(int type, boolean immersive) {
                NormalPlayerInsetControllerWidget.this.isImmersive = immersive;
            }
        };
        this.mWindowInsetObserver = new NormalPlayerInsetControllerWidget$mWindowInsetObserver$1(this);
        init(context, attrs, defStyleAttr);
    }

    private final void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WindowInset, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
        this.mTopBackground = a.getDrawable(R.styleable.WindowInset_topBackground);
        this.mBottomBackground = a.getDrawable(R.styleable.WindowInset_bottomBackground);
        if (this.mTopBackground != null) {
            this.mTopBackgroundHeight = a.getDimensionPixelOffset(R.styleable.WindowInset_topBackgroundHeight, 0);
        }
        if (this.mBottomBackground != null) {
            this.mBottomBackgroundHeight = a.getDimensionPixelOffset(R.styleable.WindowInset_bottomBackgroundHeight, 0);
        }
        this.mContentTopPadding = a.getDimensionPixelOffset(R.styleable.WindowInset_contentTopPadding, 0);
        this.mContentBottomPadding = a.getDimensionPixelOffset(R.styleable.WindowInset_contentBottomPadding, 0);
        this.mContentLeftPadding = a.getDimensionPixelOffset(R.styleable.WindowInset_contentLeftPadding, 0);
        this.mContentRightPadding = a.getDimensionPixelOffset(R.styleable.WindowInset_contentRightPadding, 0);
        a.recycle();
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public void onWidgetActive() {
        IActivityStateService activityStateService;
        IControlContainerService controlContainerService;
        IActivityStateService activityStateService2;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (activityStateService2 = playerContainer.getActivityStateService()) != null) {
            activityStateService2.registerWindowInset(this.mWindowInsetObserver);
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 != null && (controlContainerService = playerContainer2.getControlContainerService()) != null) {
            controlContainerService.registerControlContainerVisible(this.mControlContainerVisibleObserver);
        }
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        WindowInset windowInset = (playerContainer3 == null || (activityStateService = playerContainer3.getActivityStateService()) == null) ? null : activityStateService.getWindowInset();
        if (windowInset != null) {
            this.mWindowInsetObserver.onWindowInsetChanged(windowInset);
        } else {
            this.mWindowInsetObserver.onWindowInsetChanged(new WindowInset(0, 0, 0, 0, 15, null));
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget
    public void onWidgetInactive() {
        IControlContainerService controlContainerService;
        IActivityStateService activityStateService;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (activityStateService = playerContainer.getActivityStateService()) != null) {
            activityStateService.unregisterWindowInset(this.mWindowInsetObserver);
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null || (controlContainerService = playerContainer2.getControlContainerService()) == null) {
            return;
        }
        controlContainerService.unregisterControlContainerVisible(this.mControlContainerVisibleObserver);
    }

    @Override // tv.danmaku.biliplayerv2.widget.IControlWidget, tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawBackground(canvas);
        super.draw(canvas);
    }

    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawBackground(canvas);
        super.dispatchDraw(canvas);
    }

    private final void drawBackground(Canvas canvas) {
        if (this.isImmersive || canvas == null) {
            return;
        }
        int measureWidth = getMeasuredWidth();
        int measureHeight = getMeasuredHeight();
        if (measureHeight <= 0 || measureWidth <= 0) {
            return;
        }
        if (this.mTopBackground != null && this.mTopBackgroundHeight > 0) {
            Drawable drawable = this.mTopBackground;
            if (drawable != null) {
                drawable.setBounds(0, 0, measureWidth, this.mTopBackgroundHeight);
            }
            Drawable drawable2 = this.mTopBackground;
            Intrinsics.checkNotNull(drawable2);
            drawDrawable(drawable2, canvas);
        }
        if (this.mBottomBackground != null && this.mBottomBackgroundHeight > 0) {
            Drawable drawable3 = this.mBottomBackground;
            if (drawable3 != null) {
                drawable3.setBounds(0, measureHeight - this.mBottomBackgroundHeight, measureWidth, measureHeight);
            }
            Drawable drawable4 = this.mBottomBackground;
            Intrinsics.checkNotNull(drawable4);
            drawDrawable(drawable4, canvas);
        }
    }

    private final void drawDrawable(Drawable drawable, Canvas canvas) {
        int sX = getScrollX();
        int sY = getScrollY();
        if ((sX | sY) == 0) {
            drawable.draw(canvas);
            return;
        }
        canvas.translate(sX, sY);
        drawable.draw(canvas);
        canvas.translate(-sX, -sY);
    }
}