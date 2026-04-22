package leakcanary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.squareup.leakcanary.core.R;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.InternalLeakCanary;

/* compiled from: ToastEventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lleakcanary/ToastEventListener;", "Lleakcanary/EventListener;", "()V", "toastCurrentlyShown", "Landroid/widget/Toast;", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "showToastBlocking", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class ToastEventListener implements EventListener {
    public static final ToastEventListener INSTANCE = new ToastEventListener();
    private static Toast toastCurrentlyShown;

    private ToastEventListener() {
    }

    @Override // leakcanary.EventListener
    public void onEvent(EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof EventListener.Event.DumpingHeap) {
            showToastBlocking();
        } else if ((event instanceof EventListener.Event.HeapDump) || (event instanceof EventListener.Event.HeapDumpFailed)) {
            HandlersKt.getMainHandler().post(new Runnable() { // from class: leakcanary.ToastEventListener$onEvent$1
                @Override // java.lang.Runnable
                public final void run() {
                    Toast toast;
                    ToastEventListener toastEventListener = ToastEventListener.INSTANCE;
                    toast = ToastEventListener.toastCurrentlyShown;
                    if (toast != null) {
                        toast.cancel();
                    }
                    ToastEventListener toastEventListener2 = ToastEventListener.INSTANCE;
                    ToastEventListener.toastCurrentlyShown = null;
                }
            });
        }
    }

    private final void showToastBlocking() {
        final Application appContext = InternalLeakCanary.INSTANCE.getApplication();
        final CountDownLatch waitingForToast = new CountDownLatch(1);
        HandlersKt.getMainHandler().post(new Runnable() { // from class: leakcanary.ToastEventListener$showToastBlocking$1
            @Override // java.lang.Runnable
            public final void run() {
                Toast toast;
                Activity resumedActivity = InternalLeakCanary.INSTANCE.getResumedActivity();
                if (resumedActivity != null) {
                    ToastEventListener toastEventListener = ToastEventListener.INSTANCE;
                    toast = ToastEventListener.toastCurrentlyShown;
                    if (toast == null) {
                        final Toast toast2 = new Toast(resumedActivity);
                        int iconSize = appContext.getResources().getDimensionPixelSize(R.dimen.leak_canary_toast_icon_size);
                        toast2.setGravity(16, 0, -iconSize);
                        toast2.setDuration(1);
                        LayoutInflater inflater = LayoutInflater.from(resumedActivity);
                        toast2.setView(inflater.inflate(R.layout.leak_canary_heap_dump_toast, (ViewGroup) null));
                        toast2.show();
                        View view = toast2.getView();
                        if (view == null) {
                            Intrinsics.throwNpe();
                        }
                        View toastIcon = view.findViewById(R.id.leak_canary_toast_icon);
                        Intrinsics.checkExpressionValueIsNotNull(toastIcon, "toastIcon");
                        toastIcon.setTranslationY(-iconSize);
                        toastIcon.animate().translationY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: leakcanary.ToastEventListener$showToastBlocking$1.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                Intrinsics.checkParameterIsNotNull(animation, "animation");
                                ToastEventListener toastEventListener2 = ToastEventListener.INSTANCE;
                                ToastEventListener.toastCurrentlyShown = toast2;
                                waitingForToast.countDown();
                            }
                        });
                        return;
                    }
                }
                waitingForToast.countDown();
            }
        });
        waitingForToast.await(5L, TimeUnit.SECONDS);
    }
}