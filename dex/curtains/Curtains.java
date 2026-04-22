package curtains;

import android.view.View;
import curtains.internal.RootViewsSpy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* compiled from: Curtains.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcurtains/Curtains;", "", "()V", "onRootViewsChangedListeners", "", "Lcurtains/OnRootViewsChangedListener;", "getOnRootViewsChangedListeners$annotations", "getOnRootViewsChangedListeners", "()Ljava/util/List;", "rootViews", "", "Landroid/view/View;", "getRootViews$annotations", "getRootViews", "rootViewsSpy", "Lcurtains/internal/RootViewsSpy;", "getRootViewsSpy", "()Lcurtains/internal/RootViewsSpy;", "rootViewsSpy$delegate", "Lkotlin/Lazy;", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class Curtains {
    public static final Curtains INSTANCE = new Curtains();
    private static final Lazy rootViewsSpy$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<RootViewsSpy>() { // from class: curtains.Curtains$rootViewsSpy$2
        /* renamed from: invoke */
        public final RootViewsSpy m780invoke() {
            return RootViewsSpy.Companion.install();
        }
    });

    @JvmStatic
    public static /* synthetic */ void getOnRootViewsChangedListeners$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getRootViews$annotations() {
    }

    private final RootViewsSpy getRootViewsSpy() {
        return (RootViewsSpy) rootViewsSpy$delegate.getValue();
    }

    private Curtains() {
    }

    public static final List<View> getRootViews() {
        return INSTANCE.getRootViewsSpy().copyRootViewList();
    }

    public static final List<OnRootViewsChangedListener> getOnRootViewsChangedListeners() {
        return INSTANCE.getRootViewsSpy().getListeners();
    }
}