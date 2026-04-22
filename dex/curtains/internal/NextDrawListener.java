package curtains.internal;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NextDrawListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcurtains/internal/NextDrawListener;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroid/view/View;", "onDrawCallback", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "invoked", "", "onDraw", "onViewAttachedToWindow", "onViewDetachedFromWindow", "safelyRegisterForNextDraw", "Companion", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class NextDrawListener implements ViewTreeObserver.OnDrawListener, View.OnAttachStateChangeListener {
    public static final Companion Companion = new Companion(null);
    private boolean invoked;
    private final Function0<Unit> onDrawCallback;
    private final View view;

    public NextDrawListener(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "onDrawCallback");
        this.view = view;
        this.onDrawCallback = function0;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        if (this.invoked) {
            return;
        }
        this.invoked = true;
        this.view.removeOnAttachStateChangeListener(this);
        HandlersKt.getMainHandler().post(new Runnable() { // from class: curtains.internal.NextDrawListener$onDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                View view;
                view = NextDrawListener.this.view;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnDrawListener(NextDrawListener.this);
                }
            }
        });
        this.onDrawCallback.invoke();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r0 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void safelyRegisterForNextDraw() {
        boolean isAttachedToWindowCompat;
        if (Build.VERSION.SDK_INT < 26) {
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "view.viewTreeObserver");
            if (viewTreeObserver.isAlive()) {
                isAttachedToWindowCompat = NextDrawListenerKt.isAttachedToWindowCompat(this.view);
            }
            this.view.addOnAttachStateChangeListener(this);
            return;
        }
        this.view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getViewTreeObserver().addOnDrawListener(this);
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getViewTreeObserver().removeOnDrawListener(this);
        view.removeOnAttachStateChangeListener(this);
    }

    /* compiled from: NextDrawListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¨\u0006\b"}, d2 = {"Lcurtains/internal/NextDrawListener$Companion;", "", "()V", "onNextDraw", "", "Landroid/view/View;", "onDrawCallback", "Lkotlin/Function0;", "curtains_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final void onNextDraw(View $this$onNextDraw, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter($this$onNextDraw, "$this$onNextDraw");
            Intrinsics.checkNotNullParameter(function0, "onDrawCallback");
            NextDrawListener nextDrawListener = new NextDrawListener($this$onNextDraw, function0);
            nextDrawListener.safelyRegisterForNextDraw();
        }
    }
}