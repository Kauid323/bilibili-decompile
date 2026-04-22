package tv.danmaku.bili.ui.widget.wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.bilibili.app.auth.R;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WheelView.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0082\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0082\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010@\u001a\u00020A2\u0006\u0010\f\u001a\u00020\rJ\b\u0010B\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020AH\u0002J\b\u0010D\u001a\u00020AH\u0002J\u000e\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020GJ\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001c0I2\u0006\u0010J\u001a\u00020\bH\u0002J\u000e\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\u001cJ\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001c0I2\u0006\u0010N\u001a\u00020\u001cH\u0002J\u0006\u0010O\u001a\u00020AJ\u000e\u0010P\u001a\u00020A2\u0006\u0010&\u001a\u00020'J\u000e\u0010Q\u001a\u00020A2\u0006\u0010R\u001a\u00020\"J\u000e\u0010S\u001a\u00020A2\u0006\u0010T\u001a\u00020\u001cJ\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\u001cH\u0002J\u000e\u0010W\u001a\u00020A2\u0006\u0010X\u001a\u00020\bJ\u0010\u0010Y\u001a\u00020A2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J \u0010Z\u001a\u00020A2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a2\b\b\u0002\u0010X\u001a\u00020\bJ\u000e\u0010[\u001a\u00020A2\u0006\u0010\\\u001a\u00020\bJ\u000e\u0010]\u001a\u00020A2\u0006\u0010^\u001a\u00020'J\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aJ\u0006\u0010`\u001a\u00020\bJ\u0006\u0010a\u001a\u00020AJ\u0010\u0010b\u001a\u00020A2\u0006\u0010c\u001a\u00020dH\u0014J\u0018\u0010e\u001a\u00020A2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020\u001cH\u0002J\u0010\u0010h\u001a\u00020A2\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0002J\u0010\u0010m\u001a\u00020A2\u0006\u0010n\u001a\u00020jH\u0003J\u0010\u0010o\u001a\u00020A2\u0006\u0010n\u001a\u00020jH\u0003J\u0018\u0010p\u001a\u00020A2\u0006\u0010:\u001a\u00020\b2\u0006\u0010q\u001a\u00020\bH\u0014J\u0010\u0010r\u001a\u00020'2\u0006\u0010s\u001a\u00020tH\u0016J\u0006\u0010u\u001a\u00020\bJ\u000e\u0010v\u001a\u00020A2\u0006\u0010w\u001a\u00020\bJ\u001a\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u00020\u00172\b\u0010z\u001a\u0004\u0018\u00010jH\u0002J\u000e\u0010{\u001a\u00020A2\u0006\u0010#\u001a\u00020\bJ\u000e\u0010|\u001a\u00020A2\u0006\u0010$\u001a\u00020\bJ\u000e\u0010}\u001a\u00020A2\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010~\u001a\u00020A2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u007f\u001a\u00020A2\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020'J\u0007\u0010\u0080\u0001\u001a\u00020\u001cJ\u0007\u0010\u0081\u0001\u001a\u00020\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0083\u0001"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/WheelView;", "T", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mJob", "Lkotlinx/coroutines/Job;", "divider", "Ltv/danmaku/bili/ui/widget/wheel/DividerDrawer;", "gestureDetector", "Landroid/view/GestureDetector;", "onItemSelectedListener", "Ltv/danmaku/bili/ui/widget/wheel/OnItemSelectedListener;", "paintOuterText", "Landroid/graphics/Paint;", "paintCenterText", "adapter", "Ltv/danmaku/bili/ui/widget/wheel/WheelAdapter;", "textSize", "", "maxTextWidth", "maxTextHeight", "textXOffset", "itemHeight", "typeface", "Landroid/graphics/Typeface;", "textColorOut", "textColorCenter", "lineSpacingMultiplier", "isLoop", "", "firstLineY", "secondLineY", "centerY", "totalScrollY", "initPosition", "selectedItem", "preCurrentIndex", "itemsVisible", "measuredHeight", "measuredWidth", "radius", "mOffset", "previousY", "startTime", "", "touchSlop", "downY", "disallowParentIntercept", "widthMeasureSpec", "mGravity", "drawCenterContentStart", "drawOutContentStart", "centerContentOffset", "isAlphaGradient", "bindLifecycleScope", "", "judgeLineSpace", "reMeasure", "measureTextWidthHeight", "smoothScroll", "action", "Ltv/danmaku/bili/ui/widget/wheel/TouchAction;", "smoothScrollTimerFlow", "Lkotlinx/coroutines/flow/Flow;", "offset", "scrollBy", "velocityY", "inertiaTimerFlow", "mFirstVelocityY", "cancelJob", "setLoop", "setTypeface", "font", "setTextSize", "size", "sp2px", "sp", "setCurrentItem", "currentItem", "setOnItemSelectedListener", "setAdapter", "setItemsVisibleCount", "count", "setAlphaGradient", "alphaGradient", "getAdapter", "getCurrentItem", "onItemSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setOutPaintStyle", "offsetCoefficient", "angle", "reMeasureTextSize", "contentText", "", "getLoopMappingIndex", "index", "measuredCenterContentStart", "content", "measuredOutContentStart", "onMeasure", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "itemsCount", "setGravity", "gravity", "getTextWidth", "paint", "str", "setTextColorOut", "setTextColorCenter", "setTextXOffset", "setDivider", "setLineSpacingMultiplier", "getItemHeight", "getInitPosition", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WheelView<T> extends View {
    public static final Companion Companion = new Companion(null);
    private static final float DEFAULT_TEXT_TARGET_SKEW_X = 0.5f;
    private static final float FADING_EDGE_RATIO = 0.0f;
    private static final float SCALE_CONTENT = 0.8f;
    private static final long VELOCITY_FLING = 5;
    private WheelAdapter<T> adapter;
    private float centerContentOffset;
    private float centerY;
    private boolean disallowParentIntercept;
    private DividerDrawer divider;
    private float downY;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private final GestureDetector gestureDetector;
    private int initPosition;
    private boolean isAlphaGradient;
    private boolean isLoop;
    private float itemHeight;
    private int itemsVisible;
    private float lineSpacingMultiplier;
    private int mGravity;
    private Job mJob;
    private int mOffset;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    private OnItemSelectedListener onItemSelectedListener;
    private final Paint paintCenterText;
    private final Paint paintOuterText;
    private int preCurrentIndex;
    private float previousY;
    private int radius;
    private CoroutineScope scope;
    private float secondLineY;
    private int selectedItem;
    private long startTime;
    private int textColorCenter;
    private int textColorOut;
    private float textSize;
    private int textXOffset;
    private float totalScrollY;
    private final int touchSlop;
    private Typeface typeface;
    private int widthMeasureSpec;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WheelView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WheelView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paintOuterText = new Paint();
        this.paintCenterText = new Paint();
        Typeface typeface = Typeface.MONOSPACE;
        Intrinsics.checkNotNullExpressionValue(typeface, "MONOSPACE");
        this.typeface = typeface;
        this.lineSpacingMultiplier = 1.6f;
        this.initPosition = -1;
        this.itemsVisible = 11;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mGravity = 17;
        this.isAlphaGradient = true;
        this.textSize = sp2px(18.0f);
        this.paintOuterText.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.textSize);
        this.paintCenterText.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.textSize);
        setLayerType(1, null);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        if (density < 1.0f) {
            this.centerContentOffset = 2.4f;
        } else if (1.0f <= density && density < 2.0f) {
            this.centerContentOffset = 4.0f;
        } else if (2.0f <= density && density < 3.0f) {
            this.centerContentOffset = 6.0f;
        } else if (density >= 3.0f) {
            this.centerContentOffset = 2.5f * density;
        }
        if (attrs != null) {
            int[] attrs$iv = R.styleable.AuthWheelView;
            Intrinsics.checkNotNullExpressionValue(attrs$iv, "AuthWheelView");
            TypedArray $this$_init__u24lambda_u240 = context.obtainStyledAttributes(attrs, attrs$iv, defStyleAttr, defStyleRes);
            this.mGravity = $this$_init__u24lambda_u240.getInt(R.styleable.AuthWheelView_authItemGravity, 17);
            this.textColorOut = $this$_init__u24lambda_u240.getColor(R.styleable.AuthWheelView_authTextColorOut, $this$_init__u24lambda_u240.getResources().getColor(com.bilibili.lib.theme.R.color.Text3));
            this.textColorCenter = $this$_init__u24lambda_u240.getColor(R.styleable.AuthWheelView_authTextColorCenter, $this$_init__u24lambda_u240.getResources().getColor(com.bilibili.lib.theme.R.color.Text1));
            this.textSize = $this$_init__u24lambda_u240.getDimensionPixelSize(R.styleable.AuthWheelView_authItemTextSize, (int) this.textSize);
            $this$_init__u24lambda_u240.recycle();
        }
        judgeLineSpace();
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(this) { // from class: tv.danmaku.bili.ui.widget.wheel.WheelView.2
            final /* synthetic */ WheelView<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Intrinsics.checkNotNullParameter(e2, "e2");
                this.this$0.scrollBy(velocityY);
                return true;
            }
        });
        this.gestureDetector.setIsLongpressEnabled(false);
    }

    public /* synthetic */ WheelView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final void bindLifecycleScope(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
    }

    private final void judgeLineSpace() {
        if (this.lineSpacingMultiplier < 1.0f) {
            this.lineSpacingMultiplier = 1.0f;
        } else if (this.lineSpacingMultiplier > 4.0f) {
            this.lineSpacingMultiplier = 4.0f;
        }
    }

    private final void reMeasure() {
        WheelAdapter adapter = this.adapter;
        if (adapter == null) {
            return;
        }
        measureTextWidthHeight();
        int halfCircumference = (int) (this.itemHeight * (this.itemsVisible - 1));
        this.measuredHeight = (int) ((halfCircumference * 2) / 3.141592653589793d);
        this.radius = (int) (halfCircumference / 3.141592653589793d);
        this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        this.firstLineY = (this.measuredHeight - this.itemHeight) / 2.0f;
        this.secondLineY = (this.measuredHeight + this.itemHeight) / 2.0f;
        this.centerY = (this.secondLineY - ((this.itemHeight - this.maxTextHeight) / 2.0f)) - this.centerContentOffset;
        int itemsCount = adapter.getItemsCount();
        int i = this.initPosition;
        if (!(i >= 0 && i < itemsCount)) {
            this.initPosition = this.isLoop ? (adapter.getItemsCount() + 1) / 2 : 0;
        }
        this.preCurrentIndex = this.initPosition;
    }

    private final void measureTextWidthHeight() {
        WheelAdapter adapter = this.adapter;
        if (adapter == null) {
            return;
        }
        Rect rect = new Rect();
        int itemsCount = adapter.getItemsCount();
        for (int i = 0; i < itemsCount; i++) {
            String s1 = adapter.getItemContent(i);
            this.paintCenterText.getTextBounds(s1, 0, s1.length(), rect);
            int textWidth = rect.width();
            if (textWidth > this.maxTextWidth) {
                this.maxTextWidth = textWidth;
            }
        }
        this.paintCenterText.getTextBounds("星期", 0, 2, rect);
        this.maxTextHeight = rect.height() + 2;
        this.itemHeight = this.lineSpacingMultiplier * this.maxTextHeight;
    }

    public final void smoothScroll(TouchAction action) {
        int i;
        Intrinsics.checkNotNullParameter(action, "action");
        cancelJob();
        if (action == TouchAction.FLING || action == TouchAction.DRAG) {
            this.mOffset = (int) (((this.totalScrollY % this.itemHeight) + this.itemHeight) % this.itemHeight);
            if (this.mOffset > this.itemHeight / 2.0f) {
                i = (int) (this.itemHeight - this.mOffset);
            } else {
                i = -this.mOffset;
            }
            this.mOffset = i;
        }
        CoroutineScope coroutineScope = this.scope;
        this.mJob = coroutineScope != null ? BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new WheelView$smoothScroll$1(this, null), 3, (Object) null) : null;
    }

    public final Flow<Float> smoothScrollTimerFlow(int offset) {
        return FlowKt.flowOn(FlowKt.onCompletion(FlowKt.onEach(FlowKt.flow(new WheelView$smoothScrollTimerFlow$1(offset, this, null)), new WheelView$smoothScrollTimerFlow$2(null)), new WheelView$smoothScrollTimerFlow$3(this, null)), Dispatchers.getMain());
    }

    public final void scrollBy(float velocityY) {
        cancelJob();
        CoroutineScope coroutineScope = this.scope;
        this.mJob = coroutineScope != null ? BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new WheelView$scrollBy$1(this, velocityY, null), 3, (Object) null) : null;
    }

    public final Flow<Float> inertiaTimerFlow(float mFirstVelocityY) {
        return FlowKt.flowOn(FlowKt.onCompletion(FlowKt.onEach(FlowKt.flow(new WheelView$inertiaTimerFlow$1(mFirstVelocityY, this, null)), new WheelView$inertiaTimerFlow$2(null)), new WheelView$inertiaTimerFlow$3(this, null)), Dispatchers.getMain());
    }

    public final void cancelJob() {
        Job job = this.mJob;
        boolean z = false;
        if (job != null && !job.isCancelled()) {
            z = true;
        }
        if (z) {
            Job job2 = this.mJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.mJob = null;
        }
    }

    public final void setLoop(boolean isLoop) {
        this.isLoop = isLoop;
    }

    public final void setTypeface(Typeface font) {
        Intrinsics.checkNotNullParameter(font, "font");
        this.typeface = font;
        this.paintOuterText.setTypeface(this.typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public final void setTextSize(float size) {
        if (size > 0.0f) {
            this.textSize = sp2px(size);
            this.paintOuterText.setTextSize(this.textSize);
            this.paintCenterText.setTextSize(this.textSize);
        }
    }

    private final float sp2px(float sp) {
        return TypedValue.applyDimension(2, sp, getResources().getDisplayMetrics());
    }

    public final void setCurrentItem(int currentItem) {
        WheelAdapter<T> wheelAdapter = this.adapter;
        int position = RangesKt.coerceIn(currentItem, 0, (wheelAdapter != null ? wheelAdapter.getItemsCount() : 0) - 1);
        this.selectedItem = position;
        this.initPosition = position;
        this.totalScrollY = 0.0f;
        invalidate();
        OnItemSelectedListener onItemSelectedListener = this.onItemSelectedListener;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(currentItem);
        }
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public static /* synthetic */ void setAdapter$default(WheelView wheelView, WheelAdapter wheelAdapter, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        wheelView.setAdapter(wheelAdapter, i);
    }

    public final void setAdapter(WheelAdapter<T> wheelAdapter, int currentItem) {
        if (Intrinsics.areEqual(this.adapter, wheelAdapter)) {
            return;
        }
        this.adapter = wheelAdapter;
        setCurrentItem(currentItem);
        reMeasure();
        invalidate();
    }

    public final void setItemsVisibleCount(int count) {
        int visibleCount = count;
        if (visibleCount % 2 == 0) {
            visibleCount++;
        }
        this.itemsVisible = visibleCount + 2;
    }

    public final void setAlphaGradient(boolean alphaGradient) {
        this.isAlphaGradient = alphaGradient;
    }

    public final WheelAdapter<T> getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        WheelAdapter adapter = this.adapter;
        if (adapter == null) {
            return 0;
        }
        if (this.isLoop && (this.selectedItem < 0 || this.selectedItem >= adapter.getItemsCount())) {
            return RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(Math.abs(Math.abs(this.selectedItem) - adapter.getItemsCount()), adapter.getItemsCount() - 1));
        }
        return RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(this.selectedItem, adapter.getItemsCount() - 1));
    }

    public final void onItemSelected() {
        final OnItemSelectedListener onItemSelectedListener = this.onItemSelectedListener;
        if (onItemSelectedListener == null) {
            return;
        }
        postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.widget.wheel.WheelView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WheelView.onItemSelected$lambda$0(OnItemSelectedListener.this, this);
            }
        }, 200L);
    }

    public static final void onItemSelected$lambda$0(OnItemSelectedListener $onItemSelectedListener, WheelView this$0) {
        $onItemSelectedListener.onItemSelected(this$0.getCurrentItem());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String contentText;
        int counter;
        Canvas canvas2;
        boolean z;
        int change;
        Canvas canvas3 = canvas;
        Intrinsics.checkNotNullParameter(canvas3, "canvas");
        WheelAdapter adapter = this.adapter;
        if (adapter == null) {
            return;
        }
        boolean z2 = false;
        this.initPosition = RangesKt.coerceIn(this.initPosition, 0, adapter.getItemsCount() - 1);
        int change2 = (int) (this.totalScrollY / this.itemHeight);
        try {
            this.preCurrentIndex = this.initPosition + (change2 % adapter.getItemsCount());
        } catch (ArithmeticException e) {
            Log.e("WheelView", "出错了！adapter.itemsCount == 0，联动数据不匹配");
        }
        if (!this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > adapter.getItemsCount() - 1) {
                this.preCurrentIndex = adapter.getItemsCount() - 1;
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex += adapter.getItemsCount();
            }
            if (this.preCurrentIndex > adapter.getItemsCount() - 1) {
                this.preCurrentIndex -= adapter.getItemsCount();
            }
        }
        float itemHeightOffset = this.totalScrollY % this.itemHeight;
        DividerDrawer dividerDrawer = this.divider;
        if (dividerDrawer != null) {
            dividerDrawer.draw(canvas, 0.0f, this.measuredWidth, this.firstLineY, this.secondLineY);
        }
        int counter2 = 0;
        while (counter2 < this.itemsVisible) {
            int index = this.preCurrentIndex - ((this.itemsVisible / 2) - counter2);
            if (this.isLoop) {
                index = getLoopMappingIndex(index);
                contentText = adapter.getItemContent(index);
            } else {
                contentText = "";
                if (index >= 0 && index <= adapter.getItemsCount() - 1) {
                    contentText = adapter.getItemContent(index);
                }
            }
            canvas.save();
            double radian = ((this.itemHeight * counter2) - itemHeightOffset) / this.radius;
            double angle = 90.0d - ((radian / 3.141592653589793d) * 180.0d);
            if (angle > 90.0d) {
                counter = counter2;
                canvas2 = canvas3;
                z = z2;
                change = change2;
            } else if (angle < -90.0d) {
                counter = counter2;
                canvas2 = canvas3;
                z = z2;
                change = change2;
            } else {
                change = change2;
                float offsetCoefficient = (float) Math.pow(Math.abs(angle) / 90.0d, 2.2d);
                reMeasureTextSize(contentText);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                counter = counter2;
                float translateY = (float) ((this.radius - (Math.cos(radian) * this.radius)) - ((Math.sin(radian) * this.maxTextHeight) / 2.0d));
                canvas2 = canvas;
                canvas2.translate(0.0f, translateY);
                if (translateY > this.firstLineY || this.maxTextHeight + translateY < this.firstLineY) {
                    String contentText2 = contentText;
                    if (translateY <= this.secondLineY && this.maxTextHeight + translateY >= this.secondLineY) {
                        canvas.save();
                        canvas2.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - translateY);
                        canvas2.scale(1.0f, (float) Math.sin(radian));
                        canvas2.drawText(contentText2, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas2.clipRect(0.0f, this.secondLineY - translateY, this.measuredWidth, this.itemHeight);
                        canvas2.scale(1.0f, ((float) Math.sin(radian)) * 0.8f);
                        setOutPaintStyle(offsetCoefficient, (float) angle);
                        canvas2.drawText(contentText2, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        z = false;
                    } else if (translateY >= this.firstLineY && this.maxTextHeight + translateY <= this.secondLineY) {
                        canvas2.drawText(contentText2, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        this.selectedItem = this.preCurrentIndex - ((this.itemsVisible / 2) - counter);
                        z = false;
                    } else {
                        canvas.save();
                        z = false;
                        canvas2.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas2.scale(1.0f, ((float) Math.sin(radian)) * 0.8f);
                        setOutPaintStyle(offsetCoefficient, (float) angle);
                        canvas2.drawText(contentText2, this.drawOutContentStart + (this.textXOffset * offsetCoefficient), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas2.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - translateY);
                    String contentText3 = contentText;
                    canvas2.scale(1.0f, ((float) Math.sin(radian)) * 0.8f);
                    setOutPaintStyle(offsetCoefficient, (float) angle);
                    canvas2.drawText(contentText3, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas2.clipRect(0.0f, this.firstLineY - translateY, this.measuredWidth, this.itemHeight);
                    canvas2.scale(1.0f, (float) Math.sin(radian));
                    canvas2.drawText(contentText3, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                    canvas.restore();
                    z = false;
                }
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
                counter2 = counter + 1;
                canvas3 = canvas2;
                z2 = z;
                change2 = change;
            }
            canvas.restore();
            counter2 = counter + 1;
            canvas3 = canvas2;
            z2 = z;
            change2 = change;
        }
    }

    private final void setOutPaintStyle(float offsetCoefficient, float angle) {
        int multiplier = 0;
        if (this.textXOffset > 0) {
            multiplier = 1;
        } else if (this.textXOffset < 0) {
            multiplier = -1;
        }
        this.paintOuterText.setTextSkewX((angle > 0.0f ? -1 : 1) * multiplier * 0.5f * offsetCoefficient);
        int alpha = this.isAlphaGradient ? (int) (((90.0f - Math.abs(angle)) / 90.0f) * 255) : 255;
        this.paintOuterText.setAlpha(alpha);
    }

    private final void reMeasureTextSize(String contentText) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
        float size = this.textSize;
        for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
            size -= 1.0f;
            this.paintCenterText.setTextSize(size);
            this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
        }
        this.paintOuterText.setTextSize(size);
    }

    private final int getLoopMappingIndex(int index) {
        WheelAdapter adapter = this.adapter;
        if (adapter == null) {
            return 0;
        }
        if (index < 0) {
            return getLoopMappingIndex(adapter.getItemsCount() + index);
        }
        if (index > adapter.getItemsCount() - 1) {
            return getLoopMappingIndex(index - adapter.getItemsCount());
        }
        return index;
    }

    private final void measuredCenterContentStart(String content) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(content, 0, content.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.drawCenterContentStart = 0;
                return;
            case 5:
                this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
                return;
            case 17:
                this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
                return;
            default:
                return;
        }
    }

    private final void measuredOutContentStart(String content) {
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(content, 0, content.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.drawOutContentStart = 0;
                return;
            case 5:
                this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
                return;
            case 17:
                this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.widthMeasureSpec = widthMeasureSpec;
        reMeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(event, "event");
        WheelAdapter adapter = this.adapter;
        if (adapter == null) {
            return false;
        }
        boolean eventConsumed = this.gestureDetector.onTouchEvent(event);
        boolean isIgnore = false;
        float top = (-this.initPosition) * this.itemHeight;
        float bottom = ((adapter.getItemsCount() - 1.0f) - this.initPosition) * this.itemHeight;
        switch (event.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                cancelJob();
                this.previousY = event.getRawY();
                this.downY = event.getRawY();
                this.disallowParentIntercept = false;
                break;
            case 1:
                if (!eventConsumed) {
                    float y = event.getY();
                    double l = Math.acos((this.radius - y) / this.radius) * this.radius;
                    int circlePosition = (int) (((this.itemHeight / 2) + l) / this.itemHeight);
                    float extraOffset = ((this.totalScrollY % this.itemHeight) + this.itemHeight) % this.itemHeight;
                    this.mOffset = (int) (((circlePosition - (this.itemsVisible / 2)) * this.itemHeight) - extraOffset);
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        smoothScroll(TouchAction.DRAG);
                    } else {
                        smoothScroll(TouchAction.CLICK);
                    }
                    if (this.disallowParentIntercept) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            z = false;
                            parent.requestDisallowInterceptTouchEvent(false);
                        } else {
                            z = false;
                        }
                        this.disallowParentIntercept = z;
                        break;
                    }
                } else {
                    break;
                }
                break;
            case 2:
                float y2 = this.previousY;
                float dy = y2 - event.getRawY();
                this.previousY = event.getRawY();
                this.totalScrollY += dy;
                if (!this.disallowParentIntercept && Math.abs(event.getRawY() - this.downY) > this.touchSlop) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    this.disallowParentIntercept = true;
                }
                if (!this.isLoop) {
                    if ((this.totalScrollY - (this.itemHeight * 0.0f) < top && dy < 0.0f) || (this.totalScrollY + (this.itemHeight * 0.0f) > bottom && dy > 0.0f)) {
                        this.totalScrollY -= dy;
                        isIgnore = true;
                        break;
                    } else {
                        isIgnore = false;
                        break;
                    }
                } else {
                    break;
                }
                break;
            default:
                if (!eventConsumed) {
                    float y3 = event.getY();
                    double l2 = Math.acos((this.radius - y3) / this.radius) * this.radius;
                    int circlePosition2 = (int) (((this.itemHeight / 2) + l2) / this.itemHeight);
                    float extraOffset2 = ((this.totalScrollY % this.itemHeight) + this.itemHeight) % this.itemHeight;
                    this.mOffset = (int) (((circlePosition2 - (this.itemsVisible / 2)) * this.itemHeight) - extraOffset2);
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        smoothScroll(TouchAction.DRAG);
                    } else {
                        smoothScroll(TouchAction.CLICK);
                    }
                    if (this.disallowParentIntercept) {
                        ViewParent parent3 = getParent();
                        if (parent3 != null) {
                            z2 = false;
                            parent3.requestDisallowInterceptTouchEvent(false);
                        } else {
                            z2 = false;
                        }
                        this.disallowParentIntercept = z2;
                        break;
                    }
                }
                break;
        }
        if (!isIgnore && event.getAction() != 0) {
            invalidate();
            return true;
        }
        return true;
    }

    public final int itemsCount() {
        WheelAdapter<T> wheelAdapter = this.adapter;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public final void setGravity(int gravity) {
        this.mGravity = gravity;
    }

    private final int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    public final void setTextColorOut(int textColorOut) {
        this.textColorOut = textColorOut;
        this.paintOuterText.setColor(this.textColorOut);
    }

    public final void setTextColorCenter(int textColorCenter) {
        this.textColorCenter = textColorCenter;
        this.paintCenterText.setColor(this.textColorCenter);
    }

    public final void setTextXOffset(int textXOffset) {
        this.textXOffset = textXOffset;
        if (textXOffset != 0) {
            this.paintCenterText.setTextScaleX(1.0f);
        }
    }

    public final void setDivider(DividerDrawer divider) {
        this.divider = divider;
    }

    public final void setLineSpacingMultiplier(float lineSpacingMultiplier) {
        if (!(lineSpacingMultiplier == 0.0f)) {
            this.lineSpacingMultiplier = lineSpacingMultiplier;
            judgeLineSpace();
        }
    }

    public final boolean isLoop() {
        return this.isLoop;
    }

    public final float getItemHeight() {
        return this.itemHeight;
    }

    public final int getInitPosition() {
        return this.initPosition;
    }

    /* compiled from: WheelView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/WheelView$Companion;", "", "<init>", "()V", "VELOCITY_FLING", "", "SCALE_CONTENT", "", "FADING_EDGE_RATIO", "DEFAULT_TEXT_TARGET_SKEW_X", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}