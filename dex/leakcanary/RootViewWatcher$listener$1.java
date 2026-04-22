package leakcanary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.squareup.leakcanary.objectwatcher.core.R;
import curtains.OnRootViewAddedListener;
import curtains.WindowsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.RootViewWatcher;
import leakcanary.RootViewWatcher$listener$1;
import leakcanary.internal.HandlersKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RootViewWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "rootView", "Landroid/view/View;", "onRootViewAdded"}, k = 3, mv = {1, 4, 1})
public final class RootViewWatcher$listener$1 implements OnRootViewAddedListener {
    final /* synthetic */ RootViewWatcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RootViewWatcher$listener$1(RootViewWatcher rootViewWatcher) {
        this.this$0 = rootViewWatcher;
    }

    public void onRootViewsChanged(View view, boolean added) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        OnRootViewAddedListener.DefaultImpls.onRootViewsChanged(this, view, added);
    }

    public final void onRootViewAdded(View rootView) {
        Window.Callback callback;
        Intrinsics.checkParameterIsNotNull(rootView, "rootView");
        boolean z = true;
        switch (RootViewWatcher.WhenMappings.$EnumSwitchMapping$0[WindowsKt.getWindowType(rootView).ordinal()]) {
            case 1:
                Window phoneWindow = WindowsKt.getPhoneWindow(rootView);
                Window.Callback wrappedCallback = (phoneWindow == null || (callback = phoneWindow.getCallback()) == null) ? null : WindowsKt.getWrappedCallback(callback);
                if (!(wrappedCallback instanceof Activity)) {
                    if (wrappedCallback instanceof Dialog) {
                        Context context = rootView.getContext();
                        Intrinsics.checkExpressionValueIsNotNull(context, "rootView.context");
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "rootView.context.applicationContext");
                        Resources resources = applicationContext.getResources();
                        z = resources.getBoolean(R.bool.leak_canary_watcher_watch_dismissed_dialogs);
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
                break;
            case 2:
                z = false;
                break;
            case 3:
            case 4:
            case 5:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        boolean trackDetached = z;
        if (trackDetached) {
            rootView.addOnAttachStateChangeListener(new AnonymousClass1(rootView));
        }
    }

    /* compiled from: RootViewWatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"leakcanary/RootViewWatcher$listener$1$1", "Landroid/view/View$OnAttachStateChangeListener;", "watchDetachedView", "Ljava/lang/Runnable;", "getWatchDetachedView", "()Ljava/lang/Runnable;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* renamed from: leakcanary.RootViewWatcher$listener$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        final /* synthetic */ View $rootView;
        private final Runnable watchDetachedView = new Runnable() { // from class: leakcanary.RootViewWatcher$listener$1$1$watchDetachedView$1
            @Override // java.lang.Runnable
            public final void run() {
                ReachabilityWatcher reachabilityWatcher;
                reachabilityWatcher = RootViewWatcher$listener$1.this.this$0.reachabilityWatcher;
                reachabilityWatcher.expectWeaklyReachable(RootViewWatcher$listener$1.AnonymousClass1.this.$rootView, RootViewWatcher$listener$1.AnonymousClass1.this.$rootView.getClass().getName() + " received View#onDetachedFromWindow() callback");
            }
        };

        AnonymousClass1(View $captured_local_variable$1) {
            this.$rootView = $captured_local_variable$1;
        }

        public final Runnable getWatchDetachedView() {
            return this.watchDetachedView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkParameterIsNotNull(v, "v");
            HandlersKt.getMainHandler().removeCallbacks(this.watchDetachedView);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkParameterIsNotNull(v, "v");
            HandlersKt.getMainHandler().post(this.watchDetachedView);
        }
    }
}