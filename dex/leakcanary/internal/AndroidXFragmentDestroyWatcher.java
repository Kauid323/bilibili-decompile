package leakcanary.internal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.ReachabilityWatcher;

/* compiled from: AndroidXFragmentDestroyWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lleakcanary/internal/AndroidXFragmentDestroyWatcher;", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "(Lleakcanary/ReachabilityWatcher;)V", "fragmentLifecycleCallbacks", "leakcanary/internal/AndroidXFragmentDestroyWatcher$fragmentLifecycleCallbacks$1", "Lleakcanary/internal/AndroidXFragmentDestroyWatcher$fragmentLifecycleCallbacks$1;", "invoke", "activity", "leakcanary-object-watcher-android-androidx_release"}, k = 1, mv = {1, 4, 1})
public final class AndroidXFragmentDestroyWatcher implements Function1<Activity, Unit> {
    private final AndroidXFragmentDestroyWatcher$fragmentLifecycleCallbacks$1 fragmentLifecycleCallbacks;
    private final ReachabilityWatcher reachabilityWatcher;

    /* JADX WARN: Type inference failed for: r0v1, types: [leakcanary.internal.AndroidXFragmentDestroyWatcher$fragmentLifecycleCallbacks$1] */
    public AndroidXFragmentDestroyWatcher(ReachabilityWatcher reachabilityWatcher) {
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        this.reachabilityWatcher = reachabilityWatcher;
        this.fragmentLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() { // from class: leakcanary.internal.AndroidXFragmentDestroyWatcher$fragmentLifecycleCallbacks$1
            public void onFragmentCreated(FragmentManager fm, Fragment fragment, Bundle savedInstanceState) {
                ReachabilityWatcher reachabilityWatcher2;
                Intrinsics.checkParameterIsNotNull(fm, "fm");
                Intrinsics.checkParameterIsNotNull(fragment, "fragment");
                reachabilityWatcher2 = AndroidXFragmentDestroyWatcher.this.reachabilityWatcher;
                ViewModelClearedWatcher.Companion.install((ViewModelStoreOwner) fragment, reachabilityWatcher2);
            }

            public void onFragmentViewDestroyed(FragmentManager fm, Fragment fragment) {
                ReachabilityWatcher reachabilityWatcher2;
                Intrinsics.checkParameterIsNotNull(fm, "fm");
                Intrinsics.checkParameterIsNotNull(fragment, "fragment");
                View view = fragment.getView();
                if (view != null) {
                    reachabilityWatcher2 = AndroidXFragmentDestroyWatcher.this.reachabilityWatcher;
                    reachabilityWatcher2.expectWeaklyReachable(view, fragment.getClass().getName() + " received Fragment#onDestroyView() callback (references to its views should be cleared to prevent leaks)");
                }
            }

            public void onFragmentDestroyed(FragmentManager fm, Fragment fragment) {
                ReachabilityWatcher reachabilityWatcher2;
                Intrinsics.checkParameterIsNotNull(fm, "fm");
                Intrinsics.checkParameterIsNotNull(fragment, "fragment");
                reachabilityWatcher2 = AndroidXFragmentDestroyWatcher.this.reachabilityWatcher;
                reachabilityWatcher2.expectWeaklyReachable(fragment, fragment.getClass().getName() + " received Fragment#onDestroy() callback");
            }
        };
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Activity activity) {
        invoke2(activity);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public void invoke2(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (activity instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            supportFragmentManager.registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, true);
            ViewModelClearedWatcher.Companion.install((ViewModelStoreOwner) activity, this.reachabilityWatcher);
        }
    }
}