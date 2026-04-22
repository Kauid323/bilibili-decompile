package tv.danmaku.bili.ui.watchlater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionFragmentViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.callback.IBackPress;
import com.bilibili.moduleservice.appwidget.AutoAddAppWidgetService;
import com.bilibili.moduleservice.appwidget.GuideScene;
import com.bilibili.moduleservice.appwidget.IFunctionWidgetGuide;
import kntr.watch.later.watchlater.WatcherLaterScreenKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.databinding.BiliAppFragmentWatchLaterV3Binding;
import tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterFragmentV4.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/watchlater/WatchLaterFragmentV4;", "Lcom/bilibili/lib/ui/BaseFragment;", "Lcom/bilibili/lib/ui/callback/IBackPress;", "Lcom/bilibili/moduleservice/appwidget/IFunctionWidgetGuide;", "<init>", "()V", "binding", "Ltv/danmaku/bili/databinding/BiliAppFragmentWatchLaterV3Binding;", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppFragmentWatchLaterV3Binding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "viewModel", "Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onBackPressed", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterFragmentV4 extends BaseFragment implements IBackPress, IFunctionWidgetGuide {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(WatchLaterFragmentV4.class, "binding", "getBinding()Ltv/danmaku/bili/databinding/BiliAppFragmentWatchLaterV3Binding;", 0))};
    public static final int $stable = 8;
    private final ViewBindingProperty binding$delegate;
    private final Lazy viewModel$delegate;

    public WatchLaterFragmentV4() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, BiliAppFragmentWatchLaterV3Binding.class, createMethod$iv, onViewDestroyed$iv);
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1765invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1766invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(WatchLaterViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1767invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1768invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1769invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
    }

    public final BiliAppFragmentWatchLaterV3Binding getBinding() {
        return (BiliAppFragmentWatchLaterV3Binding) this.binding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final WatchLaterViewModel getViewModel() {
        return (WatchLaterViewModel) this.viewModel$delegate.getValue();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity it = getActivity();
        if (it != null) {
            BLRouter $this$iv = BLRouter.INSTANCE;
            AutoAddAppWidgetService autoAddAppWidgetService = (AutoAddAppWidgetService) $this$iv.get(AutoAddAppWidgetService.class, "default");
            if (autoAddAppWidgetService != null) {
                autoAddAppWidgetService.startFunctionWidgetGuide(it, new GuideScene.WatchLater(WatchLaterFragmentV3Kt.WATCH_LATER_EVENT_ID));
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        getBinding().composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1762179771, true, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit onViewCreated$lambda$0;
                onViewCreated$lambda$0 = WatchLaterFragmentV4.onViewCreated$lambda$0(WatchLaterFragmentV4.this, (Composer) obj, ((Integer) obj2).intValue());
                return onViewCreated$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(final WatchLaterFragmentV4 this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C58@2151L29,58@2120L61:WatchLaterFragmentV4.kt#sxaoi0");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1762179771, $changed, -1, "tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4.onViewCreated.<anonymous> (WatchLaterFragmentV4.kt:58)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1237643838, "CC(remember):WatchLaterFragmentV4.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV4$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit onViewCreated$lambda$0$0$0;
                        onViewCreated$lambda$0$0$0 = WatchLaterFragmentV4.onViewCreated$lambda$0$0$0(WatchLaterFragmentV4.this);
                        return onViewCreated$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            WatcherLaterScreenKt.WatchLaterScreen((Function0) it$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0$0(WatchLaterFragmentV4 this$0) {
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        return Unit.INSTANCE;
    }

    public boolean onBackPressed() {
        FragmentActivity it = getActivity();
        if (it != null) {
            BLRouter $this$iv = BLRouter.INSTANCE;
            AutoAddAppWidgetService autoAddAppWidgetService = (AutoAddAppWidgetService) $this$iv.get(AutoAddAppWidgetService.class, "default");
            Boolean valueOf = autoAddAppWidgetService != null ? Boolean.valueOf(autoAddAppWidgetService.closeFunctionWidgetGuide(it, new GuideScene.WatchLater(WatchLaterFragmentV3Kt.WATCH_LATER_EVENT_ID))) : null;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
        }
        return false;
    }
}