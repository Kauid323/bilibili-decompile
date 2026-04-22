package leakcanary.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import leakcanary.ReachabilityWatcher;
import shark.SharkLog;

/* compiled from: ViewModelClearedWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lleakcanary/internal/ViewModelClearedWatcher;", "Landroidx/lifecycle/ViewModel;", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "(Landroidx/lifecycle/ViewModelStoreOwner;Lleakcanary/ReachabilityWatcher;)V", "viewModelMap", "", "", "onCleared", "", "Companion", "leakcanary-object-watcher-android-androidx_release"}, k = 1, mv = {1, 4, 1})
public final class ViewModelClearedWatcher extends ViewModel {
    public static final Companion Companion = new Companion(null);
    private final ReachabilityWatcher reachabilityWatcher;
    private final Map<String, ViewModel> viewModelMap;

    public ViewModelClearedWatcher(ViewModelStoreOwner storeOwner, ReachabilityWatcher reachabilityWatcher) {
        Map<String, ViewModel> map;
        Field mapField;
        Object obj;
        Intrinsics.checkParameterIsNotNull(storeOwner, "storeOwner");
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        this.reachabilityWatcher = reachabilityWatcher;
        try {
            try {
                mapField = ViewModelStore.class.getDeclaredField("map");
            } catch (NoSuchFieldException e) {
                mapField = ViewModelStore.class.getDeclaredField("mMap");
            }
            Intrinsics.checkExpressionValueIsNotNull(mapField, "mapField");
            mapField.setAccessible(true);
            obj = mapField.get(storeOwner.getViewModelStore());
        } catch (Exception ignored) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d(ignored, "Could not find ViewModelStore map of view models");
            }
            map = null;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, androidx.lifecycle.ViewModel>");
        }
        map = (Map) obj;
        this.viewModelMap = map;
    }

    protected void onCleared() {
        Iterable values;
        Map<String, ViewModel> map = this.viewModelMap;
        if (map == null || (values = map.values()) == null) {
            return;
        }
        Iterable $this$forEach$iv = values;
        for (Object element$iv : $this$forEach$iv) {
            ViewModel viewModel = (ViewModel) element$iv;
            this.reachabilityWatcher.expectWeaklyReachable(viewModel, viewModel.getClass().getName() + " received ViewModel#onCleared() callback");
        }
    }

    /* compiled from: ViewModelClearedWatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lleakcanary/internal/ViewModelClearedWatcher$Companion;", "", "()V", "install", "", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "leakcanary-object-watcher-android-androidx_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final void install(final ViewModelStoreOwner storeOwner, final ReachabilityWatcher reachabilityWatcher) {
            Intrinsics.checkParameterIsNotNull(storeOwner, "storeOwner");
            Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
            ViewModelProvider provider = new ViewModelProvider(storeOwner, new ViewModelProvider.Factory() { // from class: leakcanary.internal.ViewModelClearedWatcher$Companion$install$provider$1
                public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                    return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
                }

                public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
                    return ViewModelProvider.Factory.-CC.$default$create(this, kClass, creationExtras);
                }

                public <T extends ViewModel> T create(Class<T> modelClass) {
                    Intrinsics.checkParameterIsNotNull(modelClass, "modelClass");
                    return new ViewModelClearedWatcher(storeOwner, reachabilityWatcher);
                }
            });
            provider.get(ViewModelClearedWatcher.class);
        }
    }
}