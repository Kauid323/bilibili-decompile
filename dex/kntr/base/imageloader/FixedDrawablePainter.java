package kntr.base.imageloader;

import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: FixedDrawablePainter.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200H\u0014J\u0012\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0010\u00104\u001a\u00020\n2\u0006\u00105\u001a\u000206H\u0014J\f\u00109\u001a\u00020+*\u00020:H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0014\u00107\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001b¨\u0006;"}, d2 = {"Lkntr/base/imageloader/FixedDrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "drawable", "Landroid/graphics/drawable/Drawable;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "autoPlay", "", "<init>", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;Z)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "<set-?>", "", "drawInvalidateTick", "getDrawInvalidateTick", "()I", "setDrawInvalidateTick", "(I)V", "drawInvalidateTick$delegate", "Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/ui/geometry/Size;", "drawableIntrinsicSize", "getDrawableIntrinsicSize-NH-jbRc", "()J", "setDrawableIntrinsicSize-uvyYCjk", "(J)V", "drawableIntrinsicSize$delegate", "Landroidx/compose/runtime/MutableState;", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "Lkotlin/Lazy;", "onRemembered", "", "onAbandoned", "onForgotten", "applyAlpha", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FixedDrawablePainter extends Painter implements RememberObserver {
    public static final int $stable = 8;
    private final Alignment alignment;
    private final boolean autoPlay;
    private final Lazy callback$delegate;
    private final ContentScale contentScale;
    private final MutableIntState drawInvalidateTick$delegate;
    private final Drawable drawable;
    private final MutableState drawableIntrinsicSize$delegate;
    private final Matrix matrix;

    /* compiled from: FixedDrawablePainter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FixedDrawablePainter(Drawable drawable, ContentScale contentScale, Alignment alignment, boolean autoPlay) {
        long intrinsicSize;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.drawable = drawable;
        this.contentScale = contentScale;
        this.alignment = alignment;
        this.autoPlay = autoPlay;
        this.drawInvalidateTick$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        intrinsicSize = FixedDrawablePainterKt.getIntrinsicSize(this.drawable);
        this.drawableIntrinsicSize$delegate = SnapshotStateKt.mutableStateOf$default(androidx.compose.ui.geometry.Size.box-impl(intrinsicSize), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.matrix = new Matrix();
        this.callback$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.imageloader.FixedDrawablePainter$$ExternalSyntheticLambda0
            public final Object invoke() {
                FixedDrawablePainter$callback$2$1 callback_delegate$lambda$0;
                callback_delegate$lambda$0 = FixedDrawablePainter.callback_delegate$lambda$0(FixedDrawablePainter.this);
                return callback_delegate$lambda$0;
            }
        });
        if (this.drawable.getIntrinsicWidth() < 0 || this.drawable.getIntrinsicHeight() < 0) {
            return;
        }
        this.drawable.setBounds(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDrawInvalidateTick() {
        IntState $this$getValue$iv = this.drawInvalidateTick$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDrawInvalidateTick(int i) {
        MutableIntState $this$setValue$iv = this.drawInvalidateTick$delegate;
        $this$setValue$iv.setIntValue(i);
    }

    /* renamed from: getDrawableIntrinsicSize-NH-jbRc  reason: not valid java name */
    private final long m1449getDrawableIntrinsicSizeNHjbRc() {
        State $this$getValue$iv = this.drawableIntrinsicSize$delegate;
        return ((androidx.compose.ui.geometry.Size) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDrawableIntrinsicSize-uvyYCjk  reason: not valid java name */
    public final void m1450setDrawableIntrinsicSizeuvyYCjk(long j) {
        MutableState $this$setValue$iv = this.drawableIntrinsicSize$delegate;
        Object value$iv = androidx.compose.ui.geometry.Size.box-impl(j);
        $this$setValue$iv.setValue(value$iv);
    }

    public final Matrix getMatrix() {
        return this.matrix;
    }

    private final Drawable.Callback getCallback() {
        return (Drawable.Callback) this.callback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [kntr.base.imageloader.FixedDrawablePainter$callback$2$1] */
    public static final FixedDrawablePainter$callback$2$1 callback_delegate$lambda$0(final FixedDrawablePainter this$0) {
        return new Drawable.Callback() { // from class: kntr.base.imageloader.FixedDrawablePainter$callback$2$1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable d) {
                int drawInvalidateTick;
                long intrinsicSize;
                Intrinsics.checkNotNullParameter(d, "d");
                drawInvalidateTick = FixedDrawablePainter.this.getDrawInvalidateTick();
                FixedDrawablePainter.this.setDrawInvalidateTick(drawInvalidateTick + 1);
                FixedDrawablePainter fixedDrawablePainter = FixedDrawablePainter.this;
                intrinsicSize = FixedDrawablePainterKt.getIntrinsicSize(d);
                fixedDrawablePainter.m1450setDrawableIntrinsicSizeuvyYCjk(intrinsicSize);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable d, Runnable what, long time) {
                Handler main_handler;
                Intrinsics.checkNotNullParameter(d, "d");
                Intrinsics.checkNotNullParameter(what, "what");
                main_handler = FixedDrawablePainterKt.getMAIN_HANDLER();
                main_handler.postAtTime(what, time);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable d, Runnable what) {
                Handler main_handler;
                Intrinsics.checkNotNullParameter(d, "d");
                Intrinsics.checkNotNullParameter(what, "what");
                main_handler = FixedDrawablePainterKt.getMAIN_HANDLER();
                main_handler.removeCallbacks(what);
            }
        };
    }

    public void onRemembered() {
        this.drawable.setCallback(getCallback());
        this.drawable.setVisible(true, true);
        if (this.autoPlay && (this.drawable instanceof Animatable)) {
            ((Animatable) this.drawable).start();
        }
    }

    public void onAbandoned() {
        onForgotten();
    }

    public void onForgotten() {
        if (this.drawable instanceof Animatable) {
            ((Animatable) this.drawable).stop();
        }
        this.drawable.setVisible(false, false);
        this.drawable.setCallback(null);
    }

    protected boolean applyAlpha(float alpha) {
        this.drawable.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(((float) KotlinVersion.MAX_COMPONENT_VALUE) * alpha), 0, (int) KotlinVersion.MAX_COMPONENT_VALUE));
        return true;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.drawable.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
        return true;
    }

    protected boolean applyLayoutDirection(LayoutDirection layoutDirection) {
        int i;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Drawable drawable = this.drawable;
        switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return drawable.setLayoutDirection(i);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m1451getIntrinsicSizeNHjbRc() {
        return m1449getDrawableIntrinsicSizeNHjbRc();
    }

    protected void onDraw(DrawScope $this$onDraw) {
        long m1454timesUQTWf7w;
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        Canvas canvas = $this$onDraw.getDrawContext().getCanvas();
        getDrawInvalidateTick();
        if (this.drawable.getIntrinsicWidth() >= 0 && this.drawable.getIntrinsicHeight() >= 0) {
            float width$iv = this.drawable.getIntrinsicWidth();
            float height$iv = this.drawable.getIntrinsicHeight();
            long v1$iv$iv = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv = Float.floatToRawIntBits(height$iv);
            long drawableSize = androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            int bits$iv$iv$iv = (int) ($this$onDraw.getSize-NH-jbRc() >> 32);
            int width$iv2 = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv));
            int bits$iv$iv$iv2 = (int) ($this$onDraw.getSize-NH-jbRc() & 4294967295L);
            int height$iv2 = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv2));
            long containerSize = IntSize.constructor-impl((width$iv2 << 32) | (height$iv2 & 4294967295L));
            long scale = this.contentScale.computeScaleFactor-H7hwNQA(drawableSize, $this$onDraw.getSize-NH-jbRc());
            Alignment alignment = this.alignment;
            m1454timesUQTWf7w = FixedDrawablePainterKt.m1454timesUQTWf7w(drawableSize, scale);
            long translation = alignment.align-KFBX0sM(m1454timesUQTWf7w, containerSize, $this$onDraw.getLayoutDirection());
            this.matrix.reset();
            this.matrix.preTranslate(IntOffset.getX-impl(translation), IntOffset.getY-impl(translation));
            int bits$iv$iv$iv3 = (int) (scale >> 32);
            int bits$iv$iv$iv4 = (int) (scale & 4294967295L);
            this.matrix.preScale(Float.intBitsToFloat(bits$iv$iv$iv3), Float.intBitsToFloat(bits$iv$iv$iv4));
            try {
                canvas.save();
                AndroidCanvas_androidKt.getNativeCanvas(canvas).concat(this.matrix);
                this.drawable.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
                return;
            } finally {
            }
        }
        Drawable drawable = this.drawable;
        int bits$iv$iv$iv5 = (int) ($this$onDraw.getSize-NH-jbRc() >> 32);
        int roundToInt = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv5));
        int bits$iv$iv$iv6 = (int) (4294967295L & $this$onDraw.getSize-NH-jbRc());
        drawable.setBounds(0, 0, roundToInt, MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv6)));
        try {
            canvas.save();
            this.drawable.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        } finally {
        }
    }
}