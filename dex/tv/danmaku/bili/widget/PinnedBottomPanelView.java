package tv.danmaku.bili.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.utils.TintManager;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.PinnedBottomPanelBehavior;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PinnedBottomPanelView.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010F\u001a\u00020.H\u0014J\u0010\u0010G\u001a\u00020.2\b\b\u0001\u0010H\u001a\u00020\u000bJ\u0010\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020KH\u0014J\b\u0010L\u001a\u00020MH\u0016J\u0018\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000bH\u0014J&\u0010Q\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010R\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u001aJ\u0018\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u000bH\u0014R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R.\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0004\u0018\u0001`/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R.\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0004\u0018\u0001`5X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001c\u00108\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00101\"\u0004\b?\u00103R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006W"}, d2 = {"Ltv/danmaku/bili/widget/PinnedBottomPanelView;", "Lcom/bilibili/magicasakura/widgets/TintLinearLayout;", "Ltv/danmaku/bili/widget/PinnedBottomPanelBehavior$CanScrollListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "child", "Landroid/view/View;", "handleView", "bottomTitle", "dividerView", "offSetHeight", "behavior", "Ltv/danmaku/bili/widget/PinnedBottomPanelBehavior;", "getBehavior", "()Ltv/danmaku/bili/widget/PinnedBottomPanelBehavior;", "setBehavior", "(Ltv/danmaku/bili/widget/PinnedBottomPanelBehavior;)V", "slideOffset", "", "getSlideOffset", "()F", "setSlideOffset", "(F)V", "maxTitleHeight", "maxDividerHeight", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "backgroundView", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "scrollCallBack", "Lkotlin/Function1;", "", "Ltv/danmaku/bili/widget/ScrollCallBack;", "getScrollCallBack", "()Lkotlin/jvm/functions/Function1;", "setScrollCallBack", "(Lkotlin/jvm/functions/Function1;)V", "stateCallBack", "Ltv/danmaku/bili/widget/StateCallBack;", "getStateCallBack", "setStateCallBack", "captureView", "getCaptureView", "()Landroid/view/View;", "setCaptureView", "(Landroid/view/View;)V", "onVisibilityChangedListener", "getOnVisibilityChangedListener", "setOnVisibilityChangedListener", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "getBgDrawable", "()Landroid/graphics/drawable/Drawable;", "setBgDrawable", "(Landroid/graphics/drawable/Drawable;)V", "onAttachedToWindow", "setPaintColor", "color", "onDraw", "canvas", "Landroid/graphics/Canvas;", "preScroll", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "initChild", "dp2px", "dpValue", "onVisibilityChanged", "changedView", "visibility", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PinnedBottomPanelView extends TintLinearLayout implements PinnedBottomPanelBehavior.CanScrollListener {
    private View backgroundView;
    private PinnedBottomPanelBehavior<View> behavior;
    private Drawable bgDrawable;
    private View bottomTitle;
    private View captureView;
    private View child;
    private View dividerView;
    private View handleView;
    private int maxDividerHeight;
    private int maxTitleHeight;
    private int offSetHeight;
    private Function1<? super Integer, Unit> onVisibilityChangedListener;
    private final Lazy paint$delegate;
    private final Rect rect;
    private Function1<? super Float, Unit> scrollCallBack;
    private float slideOffset;
    private Function1<? super Integer, Unit> stateCallBack;

    public final PinnedBottomPanelBehavior<View> getBehavior() {
        return this.behavior;
    }

    public final void setBehavior(PinnedBottomPanelBehavior<View> pinnedBottomPanelBehavior) {
        this.behavior = pinnedBottomPanelBehavior;
    }

    public final float getSlideOffset() {
        return this.slideOffset;
    }

    public final void setSlideOffset(float f) {
        this.slideOffset = f;
    }

    public final Rect getRect() {
        return this.rect;
    }

    private final Paint getPaint() {
        return (Paint) this.paint$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint paint_delegate$lambda$0() {
        return new Paint();
    }

    public final Function1<Float, Unit> getScrollCallBack() {
        return this.scrollCallBack;
    }

    public final void setScrollCallBack(Function1<? super Float, Unit> function1) {
        this.scrollCallBack = function1;
    }

    public final Function1<Integer, Unit> getStateCallBack() {
        return this.stateCallBack;
    }

    public final void setStateCallBack(Function1<? super Integer, Unit> function1) {
        this.stateCallBack = function1;
    }

    public final View getCaptureView() {
        return this.captureView;
    }

    public final void setCaptureView(View view2) {
        this.captureView = view2;
    }

    public final Function1<Integer, Unit> getOnVisibilityChangedListener() {
        return this.onVisibilityChangedListener;
    }

    public final void setOnVisibilityChangedListener(Function1<? super Integer, Unit> function1) {
        this.onVisibilityChangedListener = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinnedBottomPanelView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinnedBottomPanelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Drawable getBgDrawable() {
        return this.bgDrawable;
    }

    public final void setBgDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.bgDrawable = drawable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinnedBottomPanelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rect = new Rect();
        this.paint$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.PinnedBottomPanelView$$ExternalSyntheticLambda0
            public final Object invoke() {
                Paint paint_delegate$lambda$0;
                paint_delegate$lambda$0 = PinnedBottomPanelView.paint_delegate$lambda$0();
                return paint_delegate$lambda$0;
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.PinnedBottomPanelView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PinnedBottomPanelView._init_$lambda$0(view2);
            }
        });
        getPaint().setColor(ThemeUtils.getColorById(context, com.bilibili.lib.theme.R.color.Ga1));
        this.maxTitleHeight = dp2px(context, 44.0f);
        this.maxDividerHeight = dp2px(context, 0.5f);
        setWillNotDraw(false);
        Drawable drawable = TintManager.get(context).getDrawable(com.bilibili.lib.widget.R.drawable.shape_roundrect_comment_emoticon_panel_bg);
        Intrinsics.checkNotNull(drawable);
        this.bgDrawable = drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View it) {
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.behavior == null) {
            this.behavior = PinnedBottomPanelBehavior.from((View) this);
            PinnedBottomPanelBehavior<View> pinnedBottomPanelBehavior = this.behavior;
            if (pinnedBottomPanelBehavior != null) {
                pinnedBottomPanelBehavior.setBottomSheetCallback(new PinnedBottomPanelBehavior.BottomSheetCallback() { // from class: tv.danmaku.bili.widget.PinnedBottomPanelView$onAttachedToWindow$1
                    @Override // tv.danmaku.bili.widget.PinnedBottomPanelBehavior.BottomSheetCallback
                    public void onSlide(View bottomSheet, float slideOffset) {
                        Function1<Float, Unit> scrollCallBack;
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        PinnedBottomPanelView.this.setSlideOffset(slideOffset);
                        PinnedBottomPanelView.this.requestLayout();
                        if (slideOffset < DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN || (scrollCallBack = PinnedBottomPanelView.this.getScrollCallBack()) == null) {
                            return;
                        }
                        scrollCallBack.invoke(Float.valueOf(slideOffset));
                    }

                    @Override // tv.danmaku.bili.widget.PinnedBottomPanelBehavior.BottomSheetCallback
                    public void onStateChanged(View bottomSheet, int newState) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        Function1<Integer, Unit> stateCallBack = PinnedBottomPanelView.this.getStateCallBack();
                        if (stateCallBack != null) {
                            stateCallBack.invoke(Integer.valueOf(newState));
                        }
                    }
                });
            }
        }
    }

    public final void setPaintColor(int color) {
        getPaint().setColor(color);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        View $this$onDraw_u24lambda_u240;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.slideOffset <= 0.1d && ($this$onDraw_u24lambda_u240 = this.handleView) != null) {
            Rect rect = this.rect;
            int top = $this$onDraw_u24lambda_u240.getTop();
            ViewGroup.LayoutParams layoutParams = $this$onDraw_u24lambda_u240.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            rect.set(0, top - ((LinearLayout.LayoutParams) layoutParams).topMargin, getRight(), $this$onDraw_u24lambda_u240.getBottom());
            canvas.drawRect(this.rect, getPaint());
        }
        this.bgDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.bgDrawable.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // tv.danmaku.bili.widget.PinnedBottomPanelBehavior.CanScrollListener
    public boolean preScroll() {
        return this.captureView == null;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        PinnedBottomPanelBehavior $this$onMeasure_u24lambda_u240 = this.behavior;
        if ($this$onMeasure_u24lambda_u240 != null) {
            this.offSetHeight = getMeasuredHeight() - $this$onMeasure_u24lambda_u240.getPeekHeight();
            View view2 = this.handleView;
            ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) layoutParams;
            View view3 = this.dividerView;
            if (view3 != null) {
                view3.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.maxDividerHeight, 1073741824));
            }
            if (this.slideOffset <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                View view4 = this.bottomTitle;
                if (view4 != null) {
                    view4.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
                }
                int peekHeight = $this$onMeasure_u24lambda_u240.getPeekHeight();
                View view5 = this.bottomTitle;
                int measuredHeight = peekHeight - (view5 != null ? view5.getMeasuredHeight() : 0);
                View view6 = this.handleView;
                int measuredHeight2 = measuredHeight - (view6 != null ? view6.getMeasuredHeight() : 0);
                View view7 = this.dividerView;
                int containerHeight = ((measuredHeight2 - (view7 != null ? view7.getMeasuredHeight() : 0)) - param.topMargin) - param.bottomMargin;
                measureChild(this.child, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(containerHeight, 1073741824));
                return;
            }
            View view8 = this.bottomTitle;
            if (view8 != null) {
                view8.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (this.maxTitleHeight * this.slideOffset), 1073741824));
            }
            int peekHeight2 = $this$onMeasure_u24lambda_u240.getPeekHeight();
            View view9 = this.bottomTitle;
            int measuredHeight3 = peekHeight2 - (view9 != null ? view9.getMeasuredHeight() : 0);
            View view10 = this.handleView;
            int measuredHeight4 = measuredHeight3 - (view10 != null ? view10.getMeasuredHeight() : 0);
            View view11 = this.dividerView;
            int containerHeight2 = ((measuredHeight4 - (view11 != null ? view11.getMeasuredHeight() : 0)) - param.topMargin) - param.bottomMargin;
            measureChild(this.child, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(((int) (this.offSetHeight * this.slideOffset)) + containerHeight2, 1073741824));
        }
    }

    public final void initChild(View handleView, View bottomTitle, View dividerView, View child) {
        Intrinsics.checkNotNullParameter(handleView, "handleView");
        Intrinsics.checkNotNullParameter(bottomTitle, "bottomTitle");
        Intrinsics.checkNotNullParameter(dividerView, "dividerView");
        Intrinsics.checkNotNullParameter(child, "child");
        this.handleView = handleView;
        this.bottomTitle = bottomTitle;
        this.dividerView = dividerView;
        this.child = child;
    }

    public final int dp2px(Context context, float dpValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dpValue * scale) + 0.5f);
    }

    protected void onVisibilityChanged(View changedView, int visibility) {
        Function1<? super Integer, Unit> function1;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (!Intrinsics.areEqual(changedView, this) || (function1 = this.onVisibilityChangedListener) == null) {
            return;
        }
        function1.invoke(Integer.valueOf(visibility));
    }
}