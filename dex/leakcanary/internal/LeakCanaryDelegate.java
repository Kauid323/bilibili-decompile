package leakcanary.internal;

import android.app.Application;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import leakcanary.OnObjectRetainedListener;
import leakcanary.internal.LeakCanaryDelegate;

/* compiled from: LeakCanaryDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lleakcanary/internal/LeakCanaryDelegate;", "", "()V", "loadLeakCanary", "Lkotlin/Function1;", "Landroid/app/Application;", "", "getLoadLeakCanary$annotations", "getLoadLeakCanary", "()Lkotlin/jvm/functions/Function1;", "loadLeakCanary$delegate", "Lkotlin/Lazy;", "NoLeakCanary", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakCanaryDelegate {
    public static final LeakCanaryDelegate INSTANCE = new LeakCanaryDelegate();
    private static final Lazy loadLeakCanary$delegate = LazyKt.lazy(new Function0<Function1<? super Application, ? extends Unit>>() { // from class: leakcanary.internal.LeakCanaryDelegate$loadLeakCanary$2
        @Override // kotlin.jvm.functions.Function0
        public final Function1<? super Application, ? extends Unit> invoke() {
            try {
                Class leakCanaryListener = Class.forName("leakcanary.internal.InternalLeakCanary");
                Object obj = leakCanaryListener.getDeclaredField("INSTANCE").get(null);
                if (obj != null) {
                    return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                }
                throw new TypeCastException("null cannot be cast to non-null type (android.app.Application) -> kotlin.Unit");
            } catch (Throwable th) {
                return LeakCanaryDelegate.NoLeakCanary.INSTANCE;
            }
        }
    });

    public static /* synthetic */ void getLoadLeakCanary$annotations() {
    }

    public final Function1<Application, Unit> getLoadLeakCanary() {
        return (Function1) loadLeakCanary$delegate.getValue();
    }

    private LeakCanaryDelegate() {
    }

    /* compiled from: LeakCanaryDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lleakcanary/internal/LeakCanaryDelegate$NoLeakCanary;", "Lkotlin/Function1;", "Landroid/app/Application;", "", "Lleakcanary/OnObjectRetainedListener;", "()V", "invoke", "application", "onObjectRetained", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class NoLeakCanary implements Function1<Application, Unit>, OnObjectRetainedListener {
        public static final NoLeakCanary INSTANCE = new NoLeakCanary();

        private NoLeakCanary() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Application application) {
            invoke2(application);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(Application application) {
            Intrinsics.checkParameterIsNotNull(application, "application");
        }

        @Override // leakcanary.OnObjectRetainedListener
        public void onObjectRetained() {
        }
    }
}