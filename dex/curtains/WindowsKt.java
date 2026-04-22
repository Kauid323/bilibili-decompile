package curtains;

import android.content.res.Resources;
import android.view.FrameMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewSpyInternalKt;
import android.view.Window;
import android.view.WindowManager;
import curtains.internal.CurrentFrameMetricsListener;
import curtains.internal.HandlersKt;
import curtains.internal.NextDrawListener;
import curtains.internal.WindowCallbackWrapper;
import curtains.internal.WindowListeners;
import curtains.internal.WindowSpy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Windows.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010%\u001a\u00020&*\u00020\t2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020&0'\u001a\u0018\u0010(\u001a\u00020&*\u00020\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020&0)\u001a(\u0010*\u001a\u00020&*\u00020\t2\u0006\u0010+\u001a\u00020,2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020&0'H\u0007\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\t*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000b\"\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0019\u0010!\u001a\u0004\u0018\u00010\"*\u0004\u0018\u00010\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006."}, d2 = {"tooltipString", "", "getTooltipString", "()Ljava/lang/String;", "tooltipString$delegate", "Lkotlin/Lazy;", "keyEventInterceptors", "", "Lcurtains/KeyEventInterceptor;", "Landroid/view/Window;", "getKeyEventInterceptors", "(Landroid/view/Window;)Ljava/util/List;", "onContentChangedListeners", "Lcurtains/OnContentChangedListener;", "getOnContentChangedListeners", "onWindowFocusChangedListeners", "Lcurtains/OnWindowFocusChangedListener;", "getOnWindowFocusChangedListeners", "phoneWindow", "Landroid/view/View;", "getPhoneWindow", "(Landroid/view/View;)Landroid/view/Window;", "touchEventInterceptors", "Lcurtains/TouchEventInterceptor;", "getTouchEventInterceptors", "windowAttachCount", "", "getWindowAttachCount", "(Landroid/view/View;)I", "windowType", "Lcurtains/WindowType;", "getWindowType", "(Landroid/view/View;)Lcurtains/WindowType;", "wrappedCallback", "Landroid/view/Window$Callback;", "getWrappedCallback", "(Landroid/view/Window$Callback;)Landroid/view/Window$Callback;", "onDecorViewReady", "", "Lkotlin/Function1;", "onNextDraw", "Lkotlin/Function0;", "onNextFrameMetrics", "frameTimeNanos", "", "Landroid/view/FrameMetrics;", "curtains_release"}, k = 2, mv = {1, 4, 1})
public final class WindowsKt {
    private static final Lazy tooltipString$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<String>() { // from class: curtains.WindowsKt$tooltipString$2
        public final String invoke() {
            int tooltipStringId = Resources.getSystem().getIdentifier("tooltip_popup_title", "string", "android");
            try {
                return Resources.getSystem().getString(tooltipStringId);
            } catch (Resources.NotFoundException e2) {
                return "Tooltip";
            }
        }
    });

    private static final String getTooltipString() {
        return (String) tooltipString$delegate.getValue();
    }

    public static final Window getPhoneWindow(View $this$phoneWindow) {
        Intrinsics.checkNotNullParameter($this$phoneWindow, "$this$phoneWindow");
        WindowSpy windowSpy = WindowSpy.INSTANCE;
        View rootView = $this$phoneWindow.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return windowSpy.pullWindow(rootView);
    }

    public static final WindowType getWindowType(View $this$windowType) {
        Intrinsics.checkNotNullParameter($this$windowType, "$this$windowType");
        View rootView = $this$windowType.getRootView();
        WindowSpy windowSpy = WindowSpy.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        if (windowSpy.attachedToPhoneWindow(rootView)) {
            return WindowType.PHONE_WINDOW;
        }
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams)) {
            layoutParams = null;
        }
        WindowManager.LayoutParams windowLayoutParams = (WindowManager.LayoutParams) layoutParams;
        if (windowLayoutParams == null) {
            return WindowType.UNKNOWN;
        }
        CharSequence title = windowLayoutParams.getTitle();
        if (Intrinsics.areEqual(title, "Toast")) {
            return WindowType.TOAST;
        }
        if (!Intrinsics.areEqual(title, getTooltipString()) && !Intrinsics.areEqual(title, "TooltipPopup")) {
            Intrinsics.checkNotNullExpressionValue(title, "title");
            return StringsKt.startsWith$default(title, "PopupWindow:", false, 2, (Object) null) ? WindowType.POPUP_WINDOW : WindowType.UNKNOWN;
        }
        return WindowType.TOOLTIP;
    }

    public static final List<TouchEventInterceptor> getTouchEventInterceptors(Window $this$touchEventInterceptors) {
        Intrinsics.checkNotNullParameter($this$touchEventInterceptors, "$this$touchEventInterceptors");
        return WindowCallbackWrapper.Companion.getListeners($this$touchEventInterceptors).getTouchEventInterceptors();
    }

    public static final List<KeyEventInterceptor> getKeyEventInterceptors(Window $this$keyEventInterceptors) {
        Intrinsics.checkNotNullParameter($this$keyEventInterceptors, "$this$keyEventInterceptors");
        return WindowCallbackWrapper.Companion.getListeners($this$keyEventInterceptors).getKeyEventInterceptors();
    }

    public static final List<OnContentChangedListener> getOnContentChangedListeners(Window $this$onContentChangedListeners) {
        Intrinsics.checkNotNullParameter($this$onContentChangedListeners, "$this$onContentChangedListeners");
        return WindowCallbackWrapper.Companion.getListeners($this$onContentChangedListeners).getOnContentChangedListeners();
    }

    public static final List<OnWindowFocusChangedListener> getOnWindowFocusChangedListeners(Window $this$onWindowFocusChangedListeners) {
        Intrinsics.checkNotNullParameter($this$onWindowFocusChangedListeners, "$this$onWindowFocusChangedListeners");
        return WindowCallbackWrapper.Companion.getListeners($this$onWindowFocusChangedListeners).getOnWindowFocusChangedListeners();
    }

    public static final void onDecorViewReady(final Window $this$onDecorViewReady, final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$onDecorViewReady, "$this$onDecorViewReady");
        Intrinsics.checkNotNullParameter(function1, "onDecorViewReady");
        View decorViewOrNull = $this$onDecorViewReady.peekDecorView();
        if (decorViewOrNull != null) {
            function1.invoke(decorViewOrNull);
            return;
        }
        final WindowListeners $this$run = WindowCallbackWrapper.Companion.getListeners($this$onDecorViewReady);
        $this$run.getOnContentChangedListeners().add(new OnContentChangedListener() { // from class: curtains.WindowsKt$onDecorViewReady$$inlined$run$lambda$1
            @Override // curtains.OnContentChangedListener
            public void onContentChanged() {
                WindowListeners.this.getOnContentChangedListeners().remove(this);
                Function1 function12 = function1;
                View peekDecorView = $this$onDecorViewReady.peekDecorView();
                Intrinsics.checkNotNullExpressionValue(peekDecorView, "peekDecorView()");
                function12.invoke(peekDecorView);
            }
        });
    }

    public static final void onNextDraw(Window $this$onNextDraw, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter($this$onNextDraw, "$this$onNextDraw");
        Intrinsics.checkNotNullParameter(function0, "onNextDraw");
        onDecorViewReady($this$onNextDraw, new Function1<View, Unit>() { // from class: curtains.WindowsKt$onNextDraw$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View decorView) {
                Intrinsics.checkNotNullParameter(decorView, "decorView");
                NextDrawListener.Companion.onNextDraw(decorView, function0);
            }
        });
    }

    public static final void onNextFrameMetrics(Window $this$onNextFrameMetrics, long frameTimeNanos, Function1<? super FrameMetrics, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$onNextFrameMetrics, "$this$onNextFrameMetrics");
        Intrinsics.checkNotNullParameter(function1, "onNextFrameMetrics");
        CurrentFrameMetricsListener frameMetricsListener = new CurrentFrameMetricsListener(frameTimeNanos, function1);
        $this$onNextFrameMetrics.addOnFrameMetricsAvailableListener(frameMetricsListener, HandlersKt.getFrameMetricsHandler());
    }

    public static final int getWindowAttachCount(View $this$windowAttachCount) {
        Intrinsics.checkNotNullParameter($this$windowAttachCount, "$this$windowAttachCount");
        return ViewSpyInternalKt.windowAttachCount($this$windowAttachCount);
    }

    public static final Window.Callback getWrappedCallback(Window.Callback $this$wrappedCallback) {
        return WindowCallbackWrapper.Companion.unwrap($this$wrappedCallback);
    }
}