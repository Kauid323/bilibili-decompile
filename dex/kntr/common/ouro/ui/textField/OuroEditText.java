package kntr.common.ouro.ui.textField;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Layout;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bilibili.droid.InputMethodManagerHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.span.AttachableSpan;
import kntr.common.ouro.ui.span.OuroBackgroundColorSpan;
import kntr.common.ouro.ui.span.OuroDrawableSpan;
import kntr.common.ouro.ui.span.OuroTextMarksSpan;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroEditText.kt */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001:\b\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0018\"\u0004\b\u0000\u0010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018H\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0018H\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0018H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0018H\u0002J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\nH\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\u001d\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0000¢\u0006\u0002\b5J\u0010\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u000108J\u001a\u00109\u001a\u00020\u001d2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001d0;J\b\u0010<\u001a\u00020'H\u0016J\b\u0010=\u001a\u00020\u001dH\u0002J\u0018\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020'H\u0002J\b\u0010A\u001a\u00020\u001dH\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J0\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0014J(\u0010L\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0014J\u000e\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u000eJ\u0018\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020\n2\b\b\u0002\u0010U\u001a\u00020\nJ\u000e\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\u0012J\u0018\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0014J\b\u0010[\u001a\u00020'H\u0016J\u0012\u0010\\\u001a\u00020'2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0010\u0010_\u001a\u00020'2\u0006\u0010]\u001a\u00020^H\u0016J\b\u0010`\u001a\u00020\u001dH\u0016J\u0010\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020cH\u0014J\u0010\u0010d\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020cH\u0002J8\u0010e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0f0\u00182\u0006\u0010g\u001a\u00020h2\u0006\u0010D\u001a\u00020E2\u0006\u0010i\u001a\u00020CH\u0002J8\u0010j\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020c2\u0006\u0010D\u001a\u00020E2\u0006\u0010k\u001a\u00020%2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\n2\u0006\u0010i\u001a\u00020CH\u0002J(\u0010n\u001a\u00020.2\u0006\u0010D\u001a\u00020E2\u0006\u0010o\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0002J\u0010\u0010p\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020cH\u0002J\u0012\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020tH\u0016J\u001a\u0010u\u001a\u00020'2\u0006\u0010v\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010wH\u0016J\u001a\u0010x\u001a\u00020'2\u0006\u0010v\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010wH\u0016J\u0010\u0010y\u001a\u00020'2\u0006\u0010]\u001a\u00020wH\u0002J\u0010\u0010z\u001a\u00020'2\u0006\u0010]\u001a\u00020wH\u0002J\u0010\u0010{\u001a\u00020'2\u0006\u0010|\u001a\u00020\nH\u0016J\u0010\u0010}\u001a\u00020\u001d2\u0006\u0010~\u001a\u00020\u007fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020'2\u0007\u0010\u0081\u0001\u001a\u00020\u007fH\u0014J\t\u0010\u0082\u0001\u001a\u00020\u001dH\u0014J\t\u0010\u0083\u0001\u001a\u00020\u001dH\u0014J\u001e\u0010\u0084\u0001\u001a\u00020\u001d2\b\u0010g\u001a\u0004\u0018\u00010\u00122\t\u0010\u001b\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u0017\u0010\u0086\u0001\u001a\u00020'2\f\b\u0002\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020'2\u0007\u0010\u008a\u0001\u001a\u00020\nH\u0016J\u001b\u0010\u008b\u0001\u001a\u00020\u001d2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0016J\u001b\u0010\u008e\u0001\u001a\u00020\u001d2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020+0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listeners", "", "Lkntr/common/ouro/ui/textField/OuroEditTextListener;", "density", "", "snapshot", "", "touchUpEventPos", "Lkotlin/Pair;", "spansCache", "", "Ljava/lang/Class;", "", "getSpans", "T", "type", "clearSpansCache", "", "getAttachableSpans", "Lkntr/common/ouro/ui/span/AttachableSpan;", "getDrawableSpans", "Lkntr/common/ouro/ui/span/OuroDrawableSpan;", "getTextBackgroundSpans", "Lkntr/common/ouro/ui/span/OuroTextMarksSpan;", "getDrawableBackgroundSpans", "Lkntr/common/ouro/ui/span/OuroBackgroundColorSpan;", "hasAttachable", "", "getHasAttachable", "()Z", "backgroundPaintCache", "Landroid/graphics/Paint;", "backgroundRectCache", "Lkntr/common/ouro/ui/textField/OuroEditText$BackgroundRectCacheKey;", "Lkntr/common/ouro/ui/textField/OuroEditText$BackgroundRects;", "getBackgroundPaint", "color", "clearBackgroundCaches", "updateDrawableSpansVisibility", "visibleTop", "visibleBottom", "updateDrawableSpansVisibility$ui_debug", "setupFocusRequester", "focusRequester", "Lkntr/common/ouro/ui/textField/OuroFocusRequester;", "setupKeyboardCallback", "onKeyboardShow", "Lkotlin/Function1;", "moveCursorToVisibleOffset", "hideTextSelectionHandler", "freeFocusImpl", "forced", "keepSelection", "requestFocusImpl", "getVisibleArea", "Lkntr/common/ouro/ui/textField/OuroEditText$VisibleArea;", "layout", "Landroid/text/Layout;", "onLayout", "changed", "left", "top", "right", "bottom", "onScrollChanged", "horiz", "vert", "oldHoriz", "oldVert", "addOuroTextChangedListener", "watcher", "setSelectionFromOutside", "start", "stop", "setTextFromOutside", "content", "onSelectionChanged", "selStart", "selEnd", "performClick", "onTouchEventImpl", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "computeScroll", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawCustomBackgrounds", "getVisibleBackgroundSpans", "Lkotlin/Triple;", "text", "Landroid/text/Spanned;", "visibleArea", "drawBackgroundForSpan", "span", "spanStart", "spanEnd", "calculateBackgroundRects", "backgroundHeight", "clipAndTranslateCanvas", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onKeyPreIme", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "isDeleteEvent", "isEnterEvent", "onTextContextMenuItem", "id", "invalidateDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "verifyDrawable", "who", "onAttachedToWindow", "onDetachedFromWindow", "setText", "Landroid/widget/TextView$BufferType;", "isImeActive", "insets", "Landroidx/core/view/WindowInsetsCompat;", "canScrollHorizontally", "direction", "scrollTo", "x", "y", "scrollBy", "BackgroundRectCacheKey", "VisibleArea", "BackgroundRects", "BackgroundRect", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroEditText extends AppCompatEditText {
    public static final int $stable = 8;
    private final Map<Integer, Paint> backgroundPaintCache;
    private final Map<BackgroundRectCacheKey, BackgroundRects> backgroundRectCache;
    private final float density;
    private final Set<OuroEditTextListener> listeners;
    private CharSequence snapshot;
    private final Map<Class<?>, List<?>> spansCache;
    private Pair<Float, Float> touchUpEventPos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroEditText(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listeners = new LinkedHashSet();
        this.density = getContext().getResources().getDisplayMetrics().density;
        this.snapshot = "";
        this.spansCache = new LinkedHashMap();
        this.backgroundPaintCache = new LinkedHashMap();
        this.backgroundRectCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listeners = new LinkedHashSet();
        this.density = getContext().getResources().getDisplayMetrics().density;
        this.snapshot = "";
        this.spansCache = new LinkedHashMap();
        this.backgroundPaintCache = new LinkedHashMap();
        this.backgroundRectCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listeners = new LinkedHashSet();
        this.density = getContext().getResources().getDisplayMetrics().density;
        this.snapshot = "";
        this.spansCache = new LinkedHashMap();
        this.backgroundPaintCache = new LinkedHashMap();
        this.backgroundRectCache = new LinkedHashMap();
    }

    private final <T> List<T> getSpans(Class<T> cls) {
        Object obj;
        List emptyList;
        Object[] spans;
        Map $this$getOrPut$iv = this.spansCache;
        Object value$iv = $this$getOrPut$iv.get(cls);
        if (value$iv == null) {
            Editable text = getText();
            if (text == null || (spans = text.getSpans(0, length(), cls)) == null || (emptyList = ArraysKt.toList(spans)) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            List list = emptyList;
            $this$getOrPut$iv.put(cls, list);
            obj = list;
        } else {
            obj = value$iv;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<T of kntr.common.ouro.ui.textField.OuroEditText.getSpans>");
        return (List) obj;
    }

    private final void clearSpansCache() {
        this.spansCache.clear();
    }

    private final List<AttachableSpan> getAttachableSpans() {
        return getSpans(AttachableSpan.class);
    }

    private final List<OuroDrawableSpan> getDrawableSpans() {
        return getSpans(OuroDrawableSpan.class);
    }

    private final List<OuroTextMarksSpan> getTextBackgroundSpans() {
        Iterable $this$filter$iv = getSpans(OuroTextMarksSpan.class);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OuroTextMarksSpan it = (OuroTextMarksSpan) element$iv$iv;
            if (it.getHasBackgroundColor()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    private final List<OuroBackgroundColorSpan> getDrawableBackgroundSpans() {
        return getSpans(OuroBackgroundColorSpan.class);
    }

    private final boolean getHasAttachable() {
        return !getAttachableSpans().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OuroEditText.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroEditText$BackgroundRectCacheKey;", "", "spanStart", "", "spanEnd", "customHeight", "", "<init>", "(IILjava/lang/Float;)V", "getSpanStart", "()I", "getSpanEnd", "getCustomHeight", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "copy", "(IILjava/lang/Float;)Lkntr/common/ouro/ui/textField/OuroEditText$BackgroundRectCacheKey;", "equals", "", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class BackgroundRectCacheKey {
        private final Float customHeight;
        private final int spanEnd;
        private final int spanStart;

        public static /* synthetic */ BackgroundRectCacheKey copy$default(BackgroundRectCacheKey backgroundRectCacheKey, int i, int i2, Float f, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = backgroundRectCacheKey.spanStart;
            }
            if ((i3 & 2) != 0) {
                i2 = backgroundRectCacheKey.spanEnd;
            }
            if ((i3 & 4) != 0) {
                f = backgroundRectCacheKey.customHeight;
            }
            return backgroundRectCacheKey.copy(i, i2, f);
        }

        public final int component1() {
            return this.spanStart;
        }

        public final int component2() {
            return this.spanEnd;
        }

        public final Float component3() {
            return this.customHeight;
        }

        public final BackgroundRectCacheKey copy(int i, int i2, Float f) {
            return new BackgroundRectCacheKey(i, i2, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BackgroundRectCacheKey) {
                BackgroundRectCacheKey backgroundRectCacheKey = (BackgroundRectCacheKey) obj;
                return this.spanStart == backgroundRectCacheKey.spanStart && this.spanEnd == backgroundRectCacheKey.spanEnd && Intrinsics.areEqual(this.customHeight, backgroundRectCacheKey.customHeight);
            }
            return false;
        }

        public int hashCode() {
            return (((this.spanStart * 31) + this.spanEnd) * 31) + (this.customHeight == null ? 0 : this.customHeight.hashCode());
        }

        public String toString() {
            int i = this.spanStart;
            int i2 = this.spanEnd;
            return "BackgroundRectCacheKey(spanStart=" + i + ", spanEnd=" + i2 + ", customHeight=" + this.customHeight + ")";
        }

        public BackgroundRectCacheKey(int spanStart, int spanEnd, Float customHeight) {
            this.spanStart = spanStart;
            this.spanEnd = spanEnd;
            this.customHeight = customHeight;
        }

        public final int getSpanStart() {
            return this.spanStart;
        }

        public final int getSpanEnd() {
            return this.spanEnd;
        }

        public final Float getCustomHeight() {
            return this.customHeight;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OuroEditText.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroEditText$VisibleArea;", "", "top", "", "bottom", "firstVisibleLine", "", "lastVisibleLine", "<init>", "(FFII)V", "getTop", "()F", "getBottom", "getFirstVisibleLine", "()I", "getLastVisibleLine", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class VisibleArea {
        private final float bottom;
        private final int firstVisibleLine;
        private final int lastVisibleLine;
        private final float top;

        public static /* synthetic */ VisibleArea copy$default(VisibleArea visibleArea, float f, float f2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f = visibleArea.top;
            }
            if ((i3 & 2) != 0) {
                f2 = visibleArea.bottom;
            }
            if ((i3 & 4) != 0) {
                i = visibleArea.firstVisibleLine;
            }
            if ((i3 & 8) != 0) {
                i2 = visibleArea.lastVisibleLine;
            }
            return visibleArea.copy(f, f2, i, i2);
        }

        public final float component1() {
            return this.top;
        }

        public final float component2() {
            return this.bottom;
        }

        public final int component3() {
            return this.firstVisibleLine;
        }

        public final int component4() {
            return this.lastVisibleLine;
        }

        public final VisibleArea copy(float f, float f2, int i, int i2) {
            return new VisibleArea(f, f2, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VisibleArea) {
                VisibleArea visibleArea = (VisibleArea) obj;
                return Float.compare(this.top, visibleArea.top) == 0 && Float.compare(this.bottom, visibleArea.bottom) == 0 && this.firstVisibleLine == visibleArea.firstVisibleLine && this.lastVisibleLine == visibleArea.lastVisibleLine;
            }
            return false;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.top) * 31) + Float.floatToIntBits(this.bottom)) * 31) + this.firstVisibleLine) * 31) + this.lastVisibleLine;
        }

        public String toString() {
            float f = this.top;
            float f2 = this.bottom;
            int i = this.firstVisibleLine;
            return "VisibleArea(top=" + f + ", bottom=" + f2 + ", firstVisibleLine=" + i + ", lastVisibleLine=" + this.lastVisibleLine + ")";
        }

        public VisibleArea(float top, float bottom, int firstVisibleLine, int lastVisibleLine) {
            this.top = top;
            this.bottom = bottom;
            this.firstVisibleLine = firstVisibleLine;
            this.lastVisibleLine = lastVisibleLine;
        }

        public final float getTop() {
            return this.top;
        }

        public final float getBottom() {
            return this.bottom;
        }

        public final int getFirstVisibleLine() {
            return this.firstVisibleLine;
        }

        public final int getLastVisibleLine() {
            return this.lastVisibleLine;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OuroEditText.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroEditText$BackgroundRects;", "", "rects", "", "Lkntr/common/ouro/ui/textField/OuroEditText$BackgroundRect;", "<init>", "(Ljava/util/List;)V", "getRects", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class BackgroundRects {
        private final List<BackgroundRect> rects;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BackgroundRects copy$default(BackgroundRects backgroundRects, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = backgroundRects.rects;
            }
            return backgroundRects.copy(list);
        }

        public final List<BackgroundRect> component1() {
            return this.rects;
        }

        public final BackgroundRects copy(List<BackgroundRect> list) {
            Intrinsics.checkNotNullParameter(list, "rects");
            return new BackgroundRects(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BackgroundRects) && Intrinsics.areEqual(this.rects, ((BackgroundRects) obj).rects);
        }

        public int hashCode() {
            return this.rects.hashCode();
        }

        public String toString() {
            return "BackgroundRects(rects=" + this.rects + ")";
        }

        public BackgroundRects(List<BackgroundRect> list) {
            Intrinsics.checkNotNullParameter(list, "rects");
            this.rects = list;
        }

        public final List<BackgroundRect> getRects() {
            return this.rects;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OuroEditText.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroEditText$BackgroundRect;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft", "()F", "getTop", "getRight", "getBottom", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class BackgroundRect {
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public static /* synthetic */ BackgroundRect copy$default(BackgroundRect backgroundRect, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = backgroundRect.left;
            }
            if ((i & 2) != 0) {
                f2 = backgroundRect.top;
            }
            if ((i & 4) != 0) {
                f3 = backgroundRect.right;
            }
            if ((i & 8) != 0) {
                f4 = backgroundRect.bottom;
            }
            return backgroundRect.copy(f, f2, f3, f4);
        }

        public final float component1() {
            return this.left;
        }

        public final float component2() {
            return this.top;
        }

        public final float component3() {
            return this.right;
        }

        public final float component4() {
            return this.bottom;
        }

        public final BackgroundRect copy(float f, float f2, float f3, float f4) {
            return new BackgroundRect(f, f2, f3, f4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BackgroundRect) {
                BackgroundRect backgroundRect = (BackgroundRect) obj;
                return Float.compare(this.left, backgroundRect.left) == 0 && Float.compare(this.top, backgroundRect.top) == 0 && Float.compare(this.right, backgroundRect.right) == 0 && Float.compare(this.bottom, backgroundRect.bottom) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom);
        }

        public String toString() {
            float f = this.left;
            float f2 = this.top;
            float f3 = this.right;
            return "BackgroundRect(left=" + f + ", top=" + f2 + ", right=" + f3 + ", bottom=" + this.bottom + ")";
        }

        public BackgroundRect(float left, float top, float right, float bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getTop() {
            return this.top;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getBottom() {
            return this.bottom;
        }
    }

    private final Paint getBackgroundPaint(int color) {
        Paint paint;
        Map $this$getOrPut$iv = this.backgroundPaintCache;
        Integer valueOf = Integer.valueOf(color);
        Paint paint2 = $this$getOrPut$iv.get(valueOf);
        if (paint2 == null) {
            Paint $this$getBackgroundPaint_u24lambda_u240_u240 = new Paint();
            $this$getBackgroundPaint_u24lambda_u240_u240.setColor(color);
            $this$getBackgroundPaint_u24lambda_u240_u240.setStyle(Paint.Style.FILL);
            $this$getBackgroundPaint_u24lambda_u240_u240.setAntiAlias(true);
            paint = $this$getBackgroundPaint_u24lambda_u240_u240;
            $this$getOrPut$iv.put(valueOf, paint);
        } else {
            paint = paint2;
        }
        return paint;
    }

    private final void clearBackgroundCaches() {
        this.backgroundRectCache.clear();
        this.backgroundPaintCache.clear();
    }

    public final void updateDrawableSpansVisibility$ui_debug(final int visibleTop, final int visibleBottom) {
        Editable text = getText();
        if (text == null) {
            return;
        }
        List it = getDrawableSpans();
        if (it.isEmpty()) {
            it = null;
        }
        if (it == null) {
            return;
        }
        List spans = it;
        Layout layout = getLayout();
        if (layout == null) {
            View $this$doOnLayout$iv = (View) this;
            if ($this$doOnLayout$iv.isLaidOut() && !$this$doOnLayout$iv.isLayoutRequested()) {
                updateDrawableSpansVisibility$ui_debug(visibleTop, visibleBottom);
                return;
            } else {
                $this$doOnLayout$iv.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: kntr.common.ouro.ui.textField.OuroEditText$updateDrawableSpansVisibility$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        view.removeOnLayoutChangeListener(this);
                        OuroEditText.this.updateDrawableSpansVisibility$ui_debug(visibleTop, visibleBottom);
                    }
                });
                return;
            }
        }
        for (OuroDrawableSpan span : spans) {
            int spanStart = text.getSpanStart(span);
            int spanEnd = text.getSpanEnd(span);
            int startLine = layout.getLineForOffset(spanStart);
            int endLine = layout.getLineForOffset(spanEnd);
            int spanTop = getPaddingTop() + layout.getLineTop(startLine);
            int spanBottom = getPaddingTop() + layout.getLineBottom(endLine);
            int buffer = Math.abs(visibleTop - visibleBottom) / 2;
            boolean isVisible = span.checkVisibility$ui_debug(spanTop, spanBottom, visibleTop, visibleBottom, buffer);
            if (isVisible && (!span.isAttached() || span.getWillRelease())) {
                span.onAttach((View) this);
            } else if (!isVisible && span.isAttached() && !span.getWillRelease()) {
                span.onDetach();
            }
        }
    }

    public final void setupFocusRequester(OuroFocusRequester focusRequester) {
        if (focusRequester != null) {
            focusRequester.set_freeFocus$ui_debug(new OuroEditText$setupFocusRequester$1(this));
        }
        if (focusRequester != null) {
            focusRequester.set_requestFocus$ui_debug(new OuroEditText$setupFocusRequester$2(this));
        }
    }

    public final void setupKeyboardCallback(final Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onKeyboardShow");
        final View $this$doOnAttach$iv = (View) this;
        if ($this$doOnAttach$iv.isAttachedToWindow()) {
            ViewCompat.setOnApplyWindowInsetsListener(getRootView(), new OuroEditText$setupKeyboardCallback$1$1(function1, this));
            setOnFocusChangeListener(new OuroEditText$setupKeyboardCallback$1$2(function1, this));
            function1.invoke(Boolean.valueOf(isImeActive$default(this, null, 1, null)));
            return;
        }
        $this$doOnAttach$iv.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: kntr.common.ouro.ui.textField.OuroEditText$setupKeyboardCallback$$inlined$doOnAttach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                $this$doOnAttach$iv.removeOnAttachStateChangeListener(this);
                ViewCompat.setOnApplyWindowInsetsListener(this.getRootView(), new OuroEditText$setupKeyboardCallback$1$1(function1, this));
                this.setOnFocusChangeListener(new OuroEditText$setupKeyboardCallback$1$2(function1, this));
                function1.invoke(Boolean.valueOf(OuroEditText.isImeActive$default(this, null, 1, null)));
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    public boolean moveCursorToVisibleOffset() {
        return false;
    }

    private final void hideTextSelectionHandler() {
        int selStart = getSelectionStart();
        int selEnd = getSelectionEnd();
        int visibility = getVisibility();
        onVisibilityChanged((View) this, 4);
        onVisibilityChanged((View) this, visibility);
        setSelection(selStart, selEnd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void freeFocusImpl(boolean forced, boolean keepSelection) {
        if (forced) {
            if (keepSelection) {
                hideTextSelectionHandler();
            }
            InputMethodManagerHelper.hideSoftInput(getContext(), (View) this, 2);
            if (!keepSelection) {
                clearFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestFocusImpl() {
        requestFocus();
        InputMethodManagerHelper.showSoftInput(getContext(), (View) this, 1);
    }

    private final VisibleArea getVisibleArea(Layout layout) {
        int scrollY = getScrollY();
        int viewHeight = (getHeight() - getPaddingTop()) - getPaddingBottom();
        float visibleTop = scrollY;
        float visibleBottom = scrollY + viewHeight;
        int firstVisibleLine = layout.getLineForVertical(scrollY);
        int lastVisibleLine = layout.getLineForVertical(scrollY + viewHeight);
        return new VisibleArea(visibleTop, visibleBottom, firstVisibleLine, lastVisibleLine);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            clearBackgroundCaches();
        }
    }

    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
    }

    public final void addOuroTextChangedListener(OuroEditTextListener watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        if (this.listeners.add(watcher)) {
            super.addTextChangedListener(watcher);
        }
    }

    public static /* synthetic */ void setSelectionFromOutside$default(OuroEditText ouroEditText, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        ouroEditText.setSelectionFromOutside(i, i2);
    }

    public final void setSelectionFromOutside(int start, int stop) {
        if (getSelectionStart() == start && getSelectionEnd() == stop) {
            return;
        }
        Iterable $this$forEach$iv = this.listeners;
        for (Object element$iv : $this$forEach$iv) {
            OuroEditTextListener it = (OuroEditTextListener) element$iv;
            it.setManual(true);
        }
        try {
            setSelection(start, stop);
        } catch (Exception e) {
        }
        Iterable $this$forEach$iv2 = this.listeners;
        for (Object element$iv2 : $this$forEach$iv2) {
            OuroEditTextListener it2 = (OuroEditTextListener) element$iv2;
            it2.setManual(false);
        }
    }

    public final void setTextFromOutside(CharSequence content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (Intrinsics.areEqual(content, this.snapshot)) {
            return;
        }
        this.snapshot = content;
        Iterable $this$forEach$iv = this.listeners;
        for (Object element$iv : $this$forEach$iv) {
            OuroEditTextListener it = (OuroEditTextListener) element$iv;
            it.setManual(true);
        }
        try {
            clearBackgroundCaches();
            clearSpansCache();
            getEditableText().clear();
            getEditableText().replace(0, getEditableText().length(), content);
        } catch (Exception e) {
        }
        Iterable $this$forEach$iv2 = this.listeners;
        for (Object element$iv2 : $this$forEach$iv2) {
            OuroEditTextListener it2 = (OuroEditTextListener) element$iv2;
            it2.setManual(false);
        }
    }

    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        try {
            Iterable $this$forEach$iv = this.listeners;
            for (Object element$iv : $this$forEach$iv) {
                OuroEditTextListener it = (OuroEditTextListener) element$iv;
                it.onSelectionChanged(selStart, selEnd);
            }
        } catch (Exception e) {
        }
    }

    public boolean performClick() {
        Pair pos = this.touchUpEventPos;
        if (pos != null) {
            boolean z = false;
            Iterable $this$filter$iv = getDrawableSpans();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                if (((OuroDrawableSpan) element$iv$iv).isAttached()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List<OuroDrawableSpan> attachedDrawableSpans = (List) destination$iv$iv;
            for (OuroDrawableSpan span : attachedDrawableSpans) {
                Editable it = getText();
                if (it != null) {
                    int spanStart = it.getSpanStart(span);
                    int spanEnd = it.getSpanEnd(span);
                    int startLine = getLayout().getLineForOffset(spanStart);
                    int endLine = getLayout().getLineForOffset(spanEnd);
                    int spanTop = getPaddingTop() + getLayout().getLineTop(startLine);
                    int spanBottom = getPaddingTop() + getLayout().getLineBottom(endLine);
                    int totalWidth = getWidth() + getPaddingLeft() + getPaddingRight();
                    int drawableLeft = (totalWidth - span.getWidth()) / 2;
                    int drawableRight = (totalWidth + span.getWidth()) / 2;
                    boolean z2 = z;
                    boolean hotZoneClicked = ((int) pos.getFirst().floatValue()) >= drawableLeft && ((int) pos.getFirst().floatValue()) <= drawableRight && ((int) pos.getSecond().floatValue()) <= spanBottom && ((int) pos.getSecond().floatValue()) >= spanTop;
                    if (hotZoneClicked && span.handleClick()) {
                        return true;
                    }
                    z = z2;
                }
            }
        }
        return super.performClick();
    }

    private final boolean onTouchEventImpl(MotionEvent event) {
        Pair<Float, Float> pair;
        if (event == null) {
            return false;
        }
        int action = event.getAction();
        if (action == 1) {
            pair = new Pair<>(Float.valueOf(event.getX()), Float.valueOf(event.getY()));
        } else {
            pair = null;
        }
        this.touchUpEventPos = pair;
        return false;
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isEnabled() && onTouchEventImpl(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void computeScroll() {
        super.computeScroll();
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawCustomBackgrounds(canvas);
        super.onDraw(canvas);
    }

    private final void drawCustomBackgrounds(Canvas canvas) {
        Spanned text = getText();
        Spanned spanned = text instanceof Spanned ? text : null;
        if (spanned == null) {
            return;
        }
        Spanned text2 = spanned;
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        VisibleArea visibleArea = getVisibleArea(layout);
        Iterable spans = getVisibleBackgroundSpans(text2, layout, visibleArea);
        Iterable $this$forEach$iv = spans;
        for (Object element$iv : $this$forEach$iv) {
            Triple triple = (Triple) element$iv;
            OuroBackgroundColorSpan span = (OuroBackgroundColorSpan) triple.component1();
            int spanStart = ((Number) triple.component2()).intValue();
            int spanEnd = ((Number) triple.component3()).intValue();
            drawBackgroundForSpan(canvas, layout, span, spanStart, spanEnd, visibleArea);
        }
    }

    private final List<Triple<OuroBackgroundColorSpan, Integer, Integer>> getVisibleBackgroundSpans(Spanned text, Layout layout, VisibleArea visibleArea) {
        List visibleSpans = new ArrayList();
        List allDrawableBackgroundColorSpans = getDrawableBackgroundSpans();
        for (OuroBackgroundColorSpan span : allDrawableBackgroundColorSpans) {
            int spanStart = text.getSpanStart(span);
            int spanEnd = text.getSpanEnd(span);
            if (spanStart >= 0 && spanEnd > spanStart) {
                int spanStartLine = layout.getLineForOffset(spanStart);
                int spanEndLine = layout.getLineForOffset(Math.max(0, spanEnd - 1));
                if (spanEndLine >= visibleArea.getFirstVisibleLine() && spanStartLine <= visibleArea.getLastVisibleLine()) {
                    visibleSpans.add(new Triple(span, Integer.valueOf(spanStart), Integer.valueOf(spanEnd)));
                }
            }
        }
        List allTextSpans = getTextBackgroundSpans();
        for (OuroTextMarksSpan span2 : allTextSpans) {
            int spanStart2 = text.getSpanStart(span2);
            int spanEnd2 = text.getSpanEnd(span2);
            if (spanStart2 >= 0 && spanEnd2 > spanStart2) {
                int spanStartLine2 = layout.getLineForOffset(spanStart2);
                int spanEndLine2 = layout.getLineForOffset(Math.max(0, spanEnd2 - 1));
                if (spanEndLine2 >= visibleArea.getFirstVisibleLine() && spanStartLine2 <= visibleArea.getLastVisibleLine()) {
                    visibleSpans.add(new Triple(new OuroBackgroundColorSpan(span2.getBackgroundColor(), span2.getBackgroundColorHeightPx()), Integer.valueOf(spanStart2), Integer.valueOf(spanEnd2)));
                }
            }
        }
        return visibleSpans;
    }

    private final void drawBackgroundForSpan(Canvas canvas, Layout layout, OuroBackgroundColorSpan span, int spanStart, int spanEnd, VisibleArea visibleArea) {
        BackgroundRects backgroundRects;
        int checkpoint$iv;
        Canvas $this$withSave$iv;
        Integer color = span.getColor();
        if (color == null) {
            return;
        }
        int backgroundColor = color.intValue();
        Float heightDp = span.getHeightDp();
        if (heightDp == null) {
            return;
        }
        float backgroundHeight = heightDp.floatValue();
        Paint paint = getBackgroundPaint(backgroundColor);
        BackgroundRectCacheKey cacheKey = new BackgroundRectCacheKey(spanStart, spanEnd, Float.valueOf(backgroundHeight));
        Map $this$getOrPut$iv = this.backgroundRectCache;
        BackgroundRects backgroundRects2 = $this$getOrPut$iv.get(cacheKey);
        if (backgroundRects2 == null) {
            backgroundRects = calculateBackgroundRects(layout, backgroundHeight, spanStart, spanEnd);
            $this$getOrPut$iv.put(cacheKey, backgroundRects);
        } else {
            backgroundRects = backgroundRects2;
        }
        BackgroundRects cache = backgroundRects;
        Canvas $this$withSave$iv2 = canvas;
        int checkpoint$iv2 = $this$withSave$iv2.save();
        try {
            clipAndTranslateCanvas($this$withSave$iv2);
            Iterable $this$forEach$iv = cache.getRects();
            for (Object element$iv : $this$forEach$iv) {
                BackgroundRect rect = (BackgroundRect) element$iv;
                if (rect.getBottom() < visibleArea.getTop() || rect.getTop() > visibleArea.getBottom()) {
                    checkpoint$iv = checkpoint$iv2;
                    $this$withSave$iv = $this$withSave$iv2;
                } else {
                    checkpoint$iv = checkpoint$iv2;
                    $this$withSave$iv = $this$withSave$iv2;
                    try {
                        $this$withSave$iv2.drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
                    } catch (Throwable th) {
                        th = th;
                        $this$withSave$iv.restoreToCount(checkpoint$iv);
                        throw th;
                    }
                }
                checkpoint$iv2 = checkpoint$iv;
                $this$withSave$iv2 = $this$withSave$iv;
            }
            $this$withSave$iv2.restoreToCount(checkpoint$iv2);
        } catch (Throwable th2) {
            th = th2;
            checkpoint$iv = checkpoint$iv2;
            $this$withSave$iv = $this$withSave$iv2;
        }
    }

    private final BackgroundRects calculateBackgroundRects(Layout layout, float backgroundHeight, int spanStart, int spanEnd) {
        float right;
        Layout layout2 = layout;
        List rects = new ArrayList();
        int startLine = layout2.getLineForOffset(spanStart);
        int endLine = layout2.getLineForOffset(spanEnd);
        int line = startLine;
        if (line <= endLine) {
            while (true) {
                int lineSpanStart = line == startLine ? spanStart : layout2.getLineStart(line);
                int lineSpanEnd = line == endLine ? spanEnd : layout2.getLineEnd(line);
                if (lineSpanStart < lineSpanEnd) {
                    float left = layout2.getPrimaryHorizontal(lineSpanStart);
                    if (line < endLine) {
                        right = layout2.getLineRight(line);
                    } else {
                        right = layout2.getPrimaryHorizontal(lineSpanEnd);
                    }
                    float lineBaseLine = layout2.getLineBaseline(line);
                    float backgroundBottom = (6 * this.density) + lineBaseLine;
                    float backgroundTop = backgroundBottom - backgroundHeight;
                    rects.add(new BackgroundRect(left, backgroundTop, right, backgroundBottom));
                }
                if (line == endLine) {
                    break;
                }
                line++;
                layout2 = layout;
            }
        }
        return new BackgroundRects(CollectionsKt.toList(rects));
    }

    private final void clipAndTranslateCanvas(Canvas canvas) {
        int extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int vspace = ((getBottom() - getTop()) - getCompoundPaddingBottom()) - getCompoundPaddingTop();
        int maxScrollY = getLayout().getHeight() - vspace;
        float clipLeft = getCompoundPaddingLeft();
        float clipTop = getScrollY() == 0 ? 0 : getScrollY() + extendedPaddingTop;
        float clipRight = (getRight() - getLeft()) - getCompoundPaddingRight();
        float clipBottom = ((getBottom() - getTop()) + getScrollY()) - (getScrollY() != maxScrollY ? extendedPaddingBottom : 0);
        canvas.clipRect(clipLeft, clipTop, clipRight, clipBottom);
        canvas.translate(getCompoundPaddingLeft(), extendedPaddingTop);
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        final InputConnection inputConnection = super.onCreateInputConnection(outAttrs);
        return inputConnection != null ? new InputConnectionWrapper(inputConnection) { // from class: kntr.common.ouro.ui.textField.OuroEditText$onCreateInputConnection$1$1
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean sendKeyEvent(KeyEvent event) {
                boolean isEnterEvent;
                boolean isDeleteEvent;
                Iterable iterable;
                Iterable iterable2;
                Iterable $this$any$iv;
                if (event != null) {
                    isEnterEvent = this.isEnterEvent(event);
                    boolean z = false;
                    if (isEnterEvent) {
                        iterable2 = this.listeners;
                        Iterable $this$any$iv2 = iterable2;
                        if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                            Iterator it = $this$any$iv2.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv = it.next();
                                    OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                                    if (it2.handleEnterEvent()) {
                                        $this$any$iv = 1;
                                        break;
                                    }
                                } else {
                                    $this$any$iv = null;
                                    break;
                                }
                            }
                        } else {
                            $this$any$iv = null;
                        }
                        if ($this$any$iv != null) {
                            return true;
                        }
                    }
                    isDeleteEvent = this.isDeleteEvent(event);
                    if (isDeleteEvent) {
                        iterable = this.listeners;
                        Iterable $this$any$iv3 = iterable;
                        if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                            Iterator it3 = $this$any$iv3.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                Object element$iv2 = it3.next();
                                OuroEditTextListener it4 = (OuroEditTextListener) element$iv2;
                                if (it4.handleDeleteEvent()) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if (z) {
                            return true;
                        }
                    }
                    return super.sendKeyEvent(event);
                }
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean commitText(CharSequence text, int newCursorPosition) {
                boolean z;
                Iterable iterable;
                Iterable iterable2;
                Iterable $this$any$iv;
                boolean z2 = false;
                if (text != null) {
                    if (text.length() == 0) {
                        z = true;
                        if (z) {
                            iterable2 = this.listeners;
                            Iterable $this$any$iv2 = iterable2;
                            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                                Iterator it = $this$any$iv2.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv = it.next();
                                        OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                                        if (it2.handleDeleteEvent()) {
                                            $this$any$iv = 1;
                                            break;
                                        }
                                    } else {
                                        $this$any$iv = null;
                                        break;
                                    }
                                }
                            } else {
                                $this$any$iv = null;
                            }
                            if ($this$any$iv != null) {
                                return true;
                            }
                        }
                        if (text != null) {
                            iterable = this.listeners;
                            Iterable $this$any$iv3 = iterable;
                            if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                                Iterator it3 = $this$any$iv3.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        break;
                                    }
                                    Object element$iv2 = it3.next();
                                    OuroEditTextListener it4 = (OuroEditTextListener) element$iv2;
                                    if (it4.handleCommitText(text)) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            if (z2) {
                                return true;
                            }
                        }
                        return super.commitText(text, newCursorPosition);
                    }
                }
                z = false;
                if (z) {
                }
                if (text != null) {
                }
                return super.commitText(text, newCursorPosition);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean setComposingText(CharSequence text, int newCursorPosition) {
                Iterable iterable;
                if (text != null) {
                    iterable = this.listeners;
                    Iterable $this$any$iv = iterable;
                    boolean z = false;
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator it = $this$any$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object element$iv = it.next();
                            OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                            if (it2.handleSetComposingText(text)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
                return super.setComposingText(text, newCursorPosition);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean setComposingRegion(int start, int end) {
                Iterable iterable;
                iterable = this.listeners;
                Iterable $this$any$iv = iterable;
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                        if (it2.handleSetComposingRegion(start, end)) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    return true;
                }
                return super.setComposingRegion(start, end);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean finishComposingText() {
                Iterable iterable;
                iterable = this.listeners;
                Iterable $this$any$iv = iterable;
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object element$iv = it.next();
                        OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                        if (it2.handleFinishComposingText()) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    return true;
                }
                return super.finishComposingText();
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int beforeLength, int afterLength) {
                Iterable iterable;
                if (beforeLength > 0 && afterLength == 0) {
                    iterable = this.listeners;
                    Iterable $this$any$iv = iterable;
                    boolean z = false;
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator it = $this$any$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object element$iv = it.next();
                            OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                            if (it2.handleDeleteEvent()) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
                return super.deleteSurroundingText(beforeLength, afterLength);
            }
        } : null;
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event != null && isDeleteEvent(event)) {
            Iterable $this$any$iv = this.listeners;
            boolean z = false;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator<T> it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                    if (it2.handleDeleteEvent()) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                return true;
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Iterable $this$any$iv;
        if (event != null) {
            boolean z = false;
            if (isEnterEvent(event)) {
                Iterable $this$any$iv2 = this.listeners;
                if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                    Iterator<T> it = $this$any$iv2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                            if (it2.handleEnterEvent()) {
                                $this$any$iv = 1;
                                break;
                            }
                        } else {
                            $this$any$iv = null;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
                if ($this$any$iv != null) {
                    return true;
                }
            }
            if (isDeleteEvent(event)) {
                Iterable $this$any$iv3 = this.listeners;
                if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                    Iterator<T> it3 = $this$any$iv3.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Object element$iv2 = it3.next();
                        OuroEditTextListener it4 = (OuroEditTextListener) element$iv2;
                        if (it4.handleDeleteEvent()) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDeleteEvent(KeyEvent event) {
        return event.getKeyCode() == 67 && event.getAction() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEnterEvent(KeyEvent event) {
        return event.getKeyCode() == 66 && event.getAction() == 0;
    }

    public boolean onTextContextMenuItem(final int id) {
        boolean z = false;
        switch (id) {
            case 16908320:
                Iterable $this$any$iv = this.listeners;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            OuroEditTextListener it2 = (OuroEditTextListener) element$iv;
                            if (it2.handleCutEvent()) {
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    return true;
                }
                return super.onTextContextMenuItem(id);
            case 16908321:
                Iterable $this$any$iv2 = this.listeners;
                if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                    Iterator<T> it3 = $this$any$iv2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Object element$iv2 = it3.next();
                            OuroEditTextListener it4 = (OuroEditTextListener) element$iv2;
                            if (it4.handleCopyEvent(new Function0() { // from class: kntr.common.ouro.ui.textField.OuroEditText$$ExternalSyntheticLambda0
                                public final Object invoke() {
                                    Unit onTextContextMenuItem$lambda$0$0;
                                    onTextContextMenuItem$lambda$0$0 = OuroEditText.onTextContextMenuItem$lambda$0$0(OuroEditText.this, id);
                                    return onTextContextMenuItem$lambda$0$0;
                                }
                            })) {
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    return true;
                }
                return super.onTextContextMenuItem(id);
            case 16908322:
                Iterable $this$any$iv3 = this.listeners;
                if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                    Iterator<T> it5 = $this$any$iv3.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            Object element$iv3 = it5.next();
                            OuroEditTextListener it6 = (OuroEditTextListener) element$iv3;
                            if (it6.handlePasteEvent()) {
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    return true;
                }
                return super.onTextContextMenuItem(id);
            default:
                return super.onTextContextMenuItem(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTextContextMenuItem$lambda$0$0(OuroEditText this$0, int $id) {
        super.onTextContextMenuItem($id);
        return Unit.INSTANCE;
    }

    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (getHasAttachable()) {
            postInvalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected boolean verifyDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return getHasAttachable() || super.verifyDrawable(who);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterable $this$forEach$iv = getAttachableSpans();
        for (Object element$iv : $this$forEach$iv) {
            AttachableSpan it = (AttachableSpan) element$iv;
            it.onAttach((View) this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterable $this$forEach$iv = getAttachableSpans();
        for (Object element$iv : $this$forEach$iv) {
            AttachableSpan it = (AttachableSpan) element$iv;
            it.onDetach();
        }
    }

    public void setText(CharSequence text, TextView.BufferType type) {
        if (isAttachedToWindow()) {
            Iterable $this$forEach$iv = getAttachableSpans();
            for (Object element$iv : $this$forEach$iv) {
                AttachableSpan it = (AttachableSpan) element$iv;
                it.onDetach();
            }
        }
        super.setText(text, type);
        if (isAttachedToWindow()) {
            Iterable $this$filter$iv = getAttachableSpans();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                AttachableSpan it2 = (AttachableSpan) element$iv$iv;
                if (!(it2 instanceof OuroDrawableSpan)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$forEach$iv2 = (List) destination$iv$iv;
            for (Object element$iv2 : $this$forEach$iv2) {
                AttachableSpan it3 = (AttachableSpan) element$iv2;
                it3.onAttach((View) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean isImeActive$default(OuroEditText ouroEditText, WindowInsetsCompat windowInsetsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            windowInsetsCompat = ViewCompat.getRootWindowInsets((View) ouroEditText);
        }
        return ouroEditText.isImeActive(windowInsetsCompat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isImeActive(WindowInsetsCompat insets) {
        if (isFocused()) {
            if (insets == null) {
                Object systemService = getContext().getSystemService("input_method");
                InputMethodManager imm = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
                if (imm != null) {
                    return imm.isActive((View) this);
                }
                return false;
            }
            return insets.isVisible(WindowInsetsCompat.Type.ime());
        }
        return false;
    }

    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    public void scrollTo(int x, int y) {
        super.scrollTo(0, y);
    }

    public void scrollBy(int x, int y) {
        super.scrollBy(0, y);
    }
}