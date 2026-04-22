package tv.danmaku.bili.splash.ad.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: SplashInteractView.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 92\u00020\u0001:\u00039:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u00100\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0017J\b\u00101\u001a\u00020-H\u0002J\u000e\u00102\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u00103\u001a\u00020\u000bJ\b\u00104\u001a\u00020\u000bH\u0002J\u0006\u00105\u001a\u00020\u0007J\u0010\u00106\u001a\u00020-2\u0006\u00107\u001a\u000208H\u0014R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$¨\u0006<"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashInteractView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dotRadius", "", "getDotRadius", "()F", "dotRadius$delegate", "Lkotlin/Lazy;", "gestureDetector", "Landroid/view/GestureDetector;", FileChooserActivity.PATH, "Landroid/graphics/Path;", "dot", "Landroid/graphics/Point;", "listener", "Ltv/danmaku/bili/splash/ad/widget/SplashInteractView$InteractListener;", "consumed", "", "pathPaint", "Landroid/graphics/Paint;", "dotPaint", "startPoint", "Landroid/graphics/PointF;", "endPoint", "changeVisibilityWhenInteractForbidden", "getChangeVisibilityWhenInteractForbidden", "()Z", "setChangeVisibilityWhenInteractForbidden", "(Z)V", "responseClickOnly", "getResponseClickOnly", "setResponseClickOnly", "value", "interactEnable", "getInteractEnable", "setInteractEnable", "deliverySlideEvent", "", "event", "Landroid/view/MotionEvent;", "onTouchEvent", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "setOnInteractListener", "calculatePath", "getMeasuredPath", "calculateSlideAngle", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "InteractGestureDetectorListener", "InteractListener", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashInteractView extends FrameLayout {
    public static final String TAG = "SplashInteractView";
    private boolean changeVisibilityWhenInteractForbidden;
    private boolean consumed;
    private Point dot;
    private final Paint dotPaint;
    private final Lazy dotRadius$delegate;
    private final PointF endPoint;
    private GestureDetector gestureDetector;
    private boolean interactEnable;
    private InteractListener listener;
    private Path path;
    private final Paint pathPaint;
    private boolean responseClickOnly;
    private final PointF startPoint;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SplashInteractView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashInteractView$InteractListener;", "", "onScroll", "", "length", "", "angle", "", "onInteractLayerClicked", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface InteractListener {
        void onInteractLayerClicked();

        void onScroll(float f, int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashInteractView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashInteractView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashInteractView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dotRadius$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashInteractView$$ExternalSyntheticLambda0
            public final Object invoke() {
                float dotRadius_delegate$lambda$0;
                dotRadius_delegate$lambda$0 = SplashInteractView.dotRadius_delegate$lambda$0();
                return Float.valueOf(dotRadius_delegate$lambda$0);
            }
        });
        this.pathPaint = new Paint();
        this.dotPaint = new Paint();
        this.startPoint = new PointF(0.0f, 0.0f);
        this.endPoint = new PointF(0.0f, 0.0f);
        this.changeVisibilityWhenInteractForbidden = true;
        this.interactEnable = true;
        this.gestureDetector = new GestureDetector(context, new InteractGestureDetectorListener());
        Paint $this$_init__u24lambda_u240 = this.pathPaint;
        $this$_init__u24lambda_u240.setColor(ContextCompat.getColor(context, R.color.br_white_alpha60));
        $this$_init__u24lambda_u240.setAntiAlias(true);
        $this$_init__u24lambda_u240.setStrokeWidth(ListExtentionsKt.toPx(10));
        $this$_init__u24lambda_u240.setStrokeCap(Paint.Cap.ROUND);
        $this$_init__u24lambda_u240.setStyle(Paint.Style.STROKE);
        $this$_init__u24lambda_u240.setPathEffect(new CornerPathEffect(ListExtentionsKt.toPx(8)));
        Paint $this$_init__u24lambda_u241 = this.dotPaint;
        $this$_init__u24lambda_u241.setColor(ContextCompat.getColor(context, 17170443));
        $this$_init__u24lambda_u241.setAntiAlias(true);
        $this$_init__u24lambda_u241.setStyle(Paint.Style.FILL);
    }

    public /* synthetic */ SplashInteractView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* compiled from: SplashInteractView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashInteractView$Companion;", "", "<init>", "()V", "TAG", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dotRadius_delegate$lambda$0() {
        return ListExtentionsKt.toPx(6);
    }

    private final float getDotRadius() {
        return ((Number) this.dotRadius$delegate.getValue()).floatValue();
    }

    public final boolean getChangeVisibilityWhenInteractForbidden() {
        return this.changeVisibilityWhenInteractForbidden;
    }

    public final void setChangeVisibilityWhenInteractForbidden(boolean z) {
        this.changeVisibilityWhenInteractForbidden = z;
    }

    public final boolean getResponseClickOnly() {
        return this.responseClickOnly;
    }

    public final void setResponseClickOnly(boolean z) {
        this.responseClickOnly = z;
    }

    public final boolean getInteractEnable() {
        return this.interactEnable;
    }

    public final void setInteractEnable(boolean value) {
        this.interactEnable = value;
        if (this.changeVisibilityWhenInteractForbidden) {
            setVisibility(value ? 0 : 8);
        }
    }

    public final void deliverySlideEvent(MotionEvent event) {
        if (!this.interactEnable || event == null || this.responseClickOnly) {
            return;
        }
        if (this.path == null) {
            if (event.getX() > getWidth() || event.getY() > getHeight()) {
                return;
            }
            event.setAction(0);
        }
        onTouchEvent(event);
        float x = event.getX();
        BLog.i(TAG, "onTouchEventFromOther:" + x + " " + event.getY());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.interactEnable || this.responseClickOnly) {
            GestureDetector gestureDetector = this.gestureDetector;
            boolean handled = gestureDetector != null ? gestureDetector.onTouchEvent(event) : super.onTouchEvent(event);
            switch (event.getAction()) {
                case 0:
                    this.dot = new Point((int) event.getX(), (int) event.getY());
                    break;
                case 1:
                    Path $this$onTouchEvent_u24lambda_u240 = this.path;
                    if ($this$onTouchEvent_u24lambda_u240 != null) {
                        if (!this.consumed && !this.responseClickOnly) {
                            PointF $this$onTouchEvent_u24lambda_u240_u240 = this.endPoint;
                            $this$onTouchEvent_u24lambda_u240_u240.x = event.getX();
                            $this$onTouchEvent_u24lambda_u240_u240.y = event.getY();
                            InteractListener interactListener = this.listener;
                            if (interactListener != null) {
                                interactListener.onScroll(getMeasuredPath(), calculateSlideAngle());
                            }
                            handled |= true;
                        }
                        $this$onTouchEvent_u24lambda_u240.reset();
                    }
                    clear();
                    this.consumed = false;
                    break;
                case 2:
                    if (this.dot != null) {
                        Point point = this.dot;
                        Intrinsics.checkNotNull(point);
                        point.set((int) event.getX(), (int) event.getY());
                        break;
                    } else {
                        this.dot = new Point((int) event.getX(), (int) event.getY());
                        break;
                    }
                case 3:
                    clear();
                    break;
            }
            invalidate();
            return handled;
        }
        return super.onTouchEvent(event);
    }

    private final void clear() {
        this.path = null;
        this.dot = null;
        invalidate();
    }

    public final void setOnInteractListener(InteractListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final float calculatePath() {
        return getMeasuredPath();
    }

    private final float getMeasuredPath() {
        if (this.path == null) {
            return 0.0f;
        }
        PathMeasure pathMeasure = new PathMeasure(this.path, false);
        Path path = this.path;
        if (path != null) {
            path.reset();
        }
        clear();
        return pathMeasure.getLength();
    }

    public final int calculateSlideAngle() {
        float offsetX = this.endPoint.x - this.startPoint.x;
        float offsetY = this.startPoint.y - this.endPoint.y;
        return (int) Math.abs((((float) Math.atan2(offsetX, offsetY)) * ((float) BR.emoteImage)) / 3.141592653589793d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.responseClickOnly) {
            canvas.drawColor(0);
            Path it = this.path;
            if (it != null) {
                canvas.drawPath(it, this.pathPaint);
            }
            Point it2 = this.dot;
            if (it2 != null) {
                canvas.drawCircle(it2.x, it2.y, getDotRadius(), this.dotPaint);
            }
        }
        super.dispatchDraw(canvas);
    }

    /* compiled from: SplashInteractView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashInteractView$InteractGestureDetectorListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Ltv/danmaku/bili/splash/ad/widget/SplashInteractView;)V", "lastX", "", "lastY", "currentX", "currentY", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onScroll", "e1", "e2", "distanceX", "distanceY", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class InteractGestureDetectorListener extends GestureDetector.SimpleOnGestureListener {
        private float currentX;
        private float currentY;
        private float lastX;
        private float lastY;

        public InteractGestureDetectorListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Path path = SplashInteractView.this.path;
            if (path != null) {
                path.reset();
            }
            InteractListener interactListener = SplashInteractView.this.listener;
            if (interactListener != null) {
                interactListener.onInteractLayerClicked();
            }
            SplashInteractView.this.consumed = true;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Path path = SplashInteractView.this.path;
            if (path != null) {
                path.reset();
            }
            InteractListener interactListener = SplashInteractView.this.listener;
            if (interactListener != null) {
                interactListener.onInteractLayerClicked();
            }
            SplashInteractView.this.consumed = true;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (SplashInteractView.this.getResponseClickOnly()) {
                return true;
            }
            SplashInteractView.this.path = new Path();
            Path path = SplashInteractView.this.path;
            if (path != null) {
                path.moveTo(e.getX(), e.getY());
            }
            this.lastX = e.getX();
            this.lastY = e.getY();
            PointF $this$onDown_u24lambda_u241 = SplashInteractView.this.startPoint;
            $this$onDown_u24lambda_u241.x = this.lastX;
            $this$onDown_u24lambda_u241.y = this.lastY;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (SplashInteractView.this.path == null) {
                return true;
            }
            SplashInteractView splashInteractView = SplashInteractView.this;
            this.currentX = this.lastX - distanceX;
            this.currentY = this.lastY - distanceY;
            Path path = splashInteractView.path;
            if (path != null) {
                path.quadTo(this.lastX, this.lastY, this.currentX, this.currentY);
            }
            this.lastX = this.currentX;
            this.lastY = this.currentY;
            return true;
        }
    }
}