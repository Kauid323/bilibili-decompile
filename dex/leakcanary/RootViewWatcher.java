package leakcanary;

import curtains.Curtains;
import curtains.OnRootViewAddedListener;
import curtains.WindowType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RootViewWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lleakcanary/RootViewWatcher;", "Lleakcanary/InstallableWatcher;", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "(Lleakcanary/ReachabilityWatcher;)V", "listener", "Lcurtains/OnRootViewAddedListener;", "install", "", "uninstall", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class RootViewWatcher implements InstallableWatcher {
    private final OnRootViewAddedListener listener;
    private final ReachabilityWatcher reachabilityWatcher;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[WindowType.values().length];

        static {
            $EnumSwitchMapping$0[WindowType.PHONE_WINDOW.ordinal()] = 1;
            $EnumSwitchMapping$0[WindowType.POPUP_WINDOW.ordinal()] = 2;
            $EnumSwitchMapping$0[WindowType.TOOLTIP.ordinal()] = 3;
            $EnumSwitchMapping$0[WindowType.TOAST.ordinal()] = 4;
            $EnumSwitchMapping$0[WindowType.UNKNOWN.ordinal()] = 5;
        }
    }

    public RootViewWatcher(ReachabilityWatcher reachabilityWatcher) {
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        this.reachabilityWatcher = reachabilityWatcher;
        this.listener = new RootViewWatcher$listener$1(this);
    }

    @Override // leakcanary.InstallableWatcher
    public void install() {
        Curtains.getOnRootViewsChangedListeners().add(this.listener);
    }

    @Override // leakcanary.InstallableWatcher
    public void uninstall() {
        Curtains.getOnRootViewsChangedListeners().remove(this.listener);
    }
}