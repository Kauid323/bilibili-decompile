package leakcanary.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.ReachabilityWatcher;

/* compiled from: AndroidOFragmentDestroyWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\b\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lleakcanary/internal/AndroidOFragmentDestroyWatcher;", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "(Lleakcanary/ReachabilityWatcher;)V", "fragmentLifecycleCallbacks", "leakcanary/internal/AndroidOFragmentDestroyWatcher$fragmentLifecycleCallbacks$1", "Lleakcanary/internal/AndroidOFragmentDestroyWatcher$fragmentLifecycleCallbacks$1;", "invoke", "activity", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class AndroidOFragmentDestroyWatcher implements Function1<Activity, Unit> {
    private final AndroidOFragmentDestroyWatcher$fragmentLifecycleCallbacks$1 fragmentLifecycleCallbacks;
    private final ReachabilityWatcher reachabilityWatcher;

    /* JADX WARN: Type inference failed for: r0v1, types: [leakcanary.internal.AndroidOFragmentDestroyWatcher$fragmentLifecycleCallbacks$1] */
    public AndroidOFragmentDestroyWatcher(ReachabilityWatcher reachabilityWatcher) {
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        this.reachabilityWatcher = reachabilityWatcher;
        this.fragmentLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() { // from class: leakcanary.internal.AndroidOFragmentDestroyWatcher$fragmentLifecycleCallbacks$1
            @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewDestroyed(FragmentManager fm, Fragment fragment) {
                ReachabilityWatcher reachabilityWatcher2;
                Intrinsics.checkParameterIsNotNull(fm, "fm");
                Intrinsics.checkParameterIsNotNull(fragment, "fragment");
                View view = fragment.getView();
                if (view != null) {
                    reachabilityWatcher2 = AndroidOFragmentDestroyWatcher.this.reachabilityWatcher;
                    reachabilityWatcher2.expectWeaklyReachable(view, fragment.getClass().getName() + " received Fragment#onDestroyView() callback (references to its views should be cleared to prevent leaks)");
                }
            }

            @Override // android.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentDestroyed(FragmentManager fm, Fragment fragment) {
                ReachabilityWatcher reachabilityWatcher2;
                Intrinsics.checkParameterIsNotNull(fm, "fm");
                Intrinsics.checkParameterIsNotNull(fragment, "fragment");
                reachabilityWatcher2 = AndroidOFragmentDestroyWatcher.this.reachabilityWatcher;
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
        FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, true);
    }
}