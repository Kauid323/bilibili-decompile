package tv.danmaku.bili.ui.watchlater;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import bili.resource.favorites.R;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetDialog;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetItem;
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
import com.bilibili.pvtracker.IPvTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.databinding.BiliAppFragmentWatchLaterV3Binding;
import tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt;
import tv.danmaku.bili.ui.watchlater.consts.WatchLaterConstsKt;
import tv.danmaku.bili.ui.watchlater.data.DialogType;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterItem;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterState;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;
import tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterFragmentV3.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0002J\u001a\u0010%\u001a\u00020 *\u00020&2\u0006\u0010'\u001a\u00020(H\u0082@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020+H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006-²\u0006\n\u0010.\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u000200X\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/WatchLaterFragmentV3;", "Lcom/bilibili/lib/ui/BaseFragment;", "Lcom/bilibili/pvtracker/IPvTracker;", "Lcom/bilibili/lib/ui/callback/IBackPress;", "Lcom/bilibili/moduleservice/appwidget/IFunctionWidgetGuide;", "<init>", "()V", "binding", "Ltv/danmaku/bili/databinding/BiliAppFragmentWatchLaterV3Binding;", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppFragmentWatchLaterV3Binding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "viewModel", "Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onBackPressed", "", "showBottomSheet", "showBottomDeleteSheet", "aid", "", "showBiliCommonDialog", "Landroid/content/Context;", "dialogType", "Ltv/danmaku/bili/ui/watchlater/data/DialogType;", "(Landroid/content/Context;Ltv/danmaku/bili/ui/watchlater/data/DialogType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPvEventId", "", "getPvExtra", "core_apinkDebug", "buttonClickable", "pageState", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterState;"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterFragmentV3 extends BaseFragment implements IPvTracker, IBackPress, IFunctionWidgetGuide {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(WatchLaterFragmentV3.class, "binding", "getBinding()Ltv/danmaku/bili/databinding/BiliAppFragmentWatchLaterV3Binding;", 0))};
    public static final int $stable = 8;
    private final ViewBindingProperty binding$delegate;
    private final Lazy viewModel$delegate;

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public WatchLaterFragmentV3() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, BiliAppFragmentWatchLaterV3Binding.class, createMethod$iv, onViewDestroyed$iv);
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1758invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1759invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(WatchLaterViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1760invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1761invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1762invoke() {
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
        getBinding().composeView.setContent(ComposableLambdaKt.composableLambdaInstance(412470535, true, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Unit onViewCreated$lambda$0;
                onViewCreated$lambda$0 = WatchLaterFragmentV3.onViewCreated$lambda$0(WatchLaterFragmentV3.this, (Composer) obj, ((Integer) obj2).intValue());
                return onViewCreated$lambda$0;
            }
        }));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterFragmentV3$onViewCreated$2(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0321, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x035b, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0395, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03cd, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x011a, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0151, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018a, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c2, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01fc, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x023a, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0273, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02ad, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02e7, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onViewCreated$lambda$0(final WatchLaterFragmentV3 this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C84@3774L31,85@3861L16,91@4154L390,101@4578L29,102@4645L35,103@4712L548,117@5296L623,131@5953L180,137@6167L180,143@6378L40,144@6449L40,145@6519L37,146@6589L41,147@6668L43,148@6747L40,149@6824L41,150@6899L50,151@6987L27,86@3890L3125:WatchLaterFragmentV3.kt#sxaoi0");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(412470535, $changed, -1, "tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3.onViewCreated.<anonymous> (WatchLaterFragmentV3.kt:84)");
            }
            State buttonClickable$delegate = SnapshotStateKt.collectAsState(this$0.getViewModel().getButtonClickable(), false, (CoroutineContext) null, $composer, 48, 2);
            State pageState$delegate = SnapshotStateKt.collectAsState(this$0.getViewModel().getWatchLaterState(), (CoroutineContext) null, $composer, 0, 1);
            WatchLaterState onViewCreated$lambda$0$1 = onViewCreated$lambda$0$1(pageState$delegate);
            boolean onViewCreated$lambda$0$0 = onViewCreated$lambda$0$0(buttonClickable$delegate);
            LazyListState tabAllListState = this$0.getViewModel().getTabAllListState();
            LazyListState tabToViewListState = this$0.getViewModel().getTabToViewListState();
            ComposerKt.sourceInformationMarkerStart($composer, 1247207469, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit onViewCreated$lambda$0$2$0;
                        onViewCreated$lambda$0$2$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$2$0(WatchLaterFragmentV3.this);
                        return onViewCreated$lambda$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247220676, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(this$0);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit onViewCreated$lambda$0$3$0;
                        onViewCreated$lambda$0$3$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$3$0(WatchLaterFragmentV3.this);
                        return onViewCreated$lambda$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function0 function02 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247222826, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(this$0);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        Unit onViewCreated$lambda$0$4$0;
                        onViewCreated$lambda$0$4$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$4$0(WatchLaterFragmentV3.this);
                        return onViewCreated$lambda$0$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Function0 function03 = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247225483, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance(this$0);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function2() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit onViewCreated$lambda$0$5$0;
                    onViewCreated$lambda$0$5$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$5$0(WatchLaterFragmentV3.this, ((Boolean) obj).booleanValue(), (WatchLaterItem) obj2);
                    return onViewCreated$lambda$0$5$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            Function2 function2 = (Function2) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247244246, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv5 = $composer.changedInstance(this$0);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv5 = new Function2() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit onViewCreated$lambda$0$6$0;
                    onViewCreated$lambda$0$6$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$6$0(WatchLaterFragmentV3.this, ((Boolean) obj).booleanValue(), (WatchLaterItem) obj2);
                    return onViewCreated$lambda$0$6$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            Function2 function22 = (Function2) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247264827, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv6 = $composer.changedInstance(this$0);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv6 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit onViewCreated$lambda$0$7$0;
                    onViewCreated$lambda$0$7$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$7$0(WatchLaterFragmentV3.this);
                    return onViewCreated$lambda$0$7$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            Function0 function04 = (Function0) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247271675, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv7 = $composer.changedInstance(this$0);
            Object it$iv7 = $composer.rememberedValue();
            if (invalid$iv7) {
            }
            Object value$iv7 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit onViewCreated$lambda$0$8$0;
                    onViewCreated$lambda$0$8$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$8$0(WatchLaterFragmentV3.this);
                    return onViewCreated$lambda$0$8$0;
                }
            };
            $composer.updateRememberedValue(value$iv7);
            it$iv7 = value$iv7;
            Function0 function05 = (Function0) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247278287, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv8 = $composer.changedInstance(this$0);
            Object it$iv8 = $composer.rememberedValue();
            if (invalid$iv8) {
            }
            Object value$iv8 = (Function2) new WatchLaterFragmentV3$onViewCreated$1$8$1(this$0, null);
            $composer.updateRememberedValue(value$iv8);
            it$iv8 = value$iv8;
            Function2 function23 = (Function2) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247280559, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv9 = $composer.changedInstance(this$0);
            Object it$iv9 = $composer.rememberedValue();
            if (invalid$iv9) {
            }
            Object value$iv9 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$10$0;
                    onViewCreated$lambda$0$10$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$10$0(WatchLaterFragmentV3.this, ((Integer) obj).intValue());
                    return onViewCreated$lambda$0$10$0;
                }
            };
            $composer.updateRememberedValue(value$iv9);
            it$iv9 = value$iv9;
            Function1 function1 = (Function1) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247282796, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv10 = $composer.changedInstance(this$0);
            Object it$iv10 = $composer.rememberedValue();
            if (invalid$iv10) {
            }
            Object value$iv10 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$11$0;
                    onViewCreated$lambda$0$11$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$11$0(WatchLaterFragmentV3.this, ((Integer) obj).intValue());
                    return onViewCreated$lambda$0$11$0;
                }
            };
            $composer.updateRememberedValue(value$iv10);
            it$iv10 = value$iv10;
            Function1 function12 = (Function1) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247285040, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv11 = $composer.changedInstance(this$0);
            Object it$iv11 = $composer.rememberedValue();
            if (invalid$iv11) {
            }
            Object value$iv11 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$12$0;
                    onViewCreated$lambda$0$12$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$12$0(WatchLaterFragmentV3.this, ((Integer) obj).intValue());
                    return onViewCreated$lambda$0$12$0;
                }
            };
            $composer.updateRememberedValue(value$iv11);
            it$iv11 = value$iv11;
            Function1 function13 = (Function1) it$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247287570, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv12 = $composer.changedInstance(this$0);
            Object it$iv12 = $composer.rememberedValue();
            if (invalid$iv12) {
            }
            Object value$iv12 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$13$0;
                    onViewCreated$lambda$0$13$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$13$0(WatchLaterFragmentV3.this, ((Long) obj).longValue());
                    return onViewCreated$lambda$0$13$0;
                }
            };
            $composer.updateRememberedValue(value$iv12);
            it$iv12 = value$iv12;
            Function1 function14 = (Function1) it$iv12;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247290095, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv13 = $composer.changedInstance(this$0);
            Object it$iv13 = $composer.rememberedValue();
            if (invalid$iv13) {
            }
            Object value$iv13 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$14$0;
                    onViewCreated$lambda$0$14$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$14$0(WatchLaterFragmentV3.this, ((Integer) obj).intValue());
                    return onViewCreated$lambda$0$14$0;
                }
            };
            $composer.updateRememberedValue(value$iv13);
            it$iv13 = value$iv13;
            Function1 function15 = (Function1) it$iv13;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247292560, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv14 = $composer.changedInstance(this$0);
            Object it$iv14 = $composer.rememberedValue();
            if (invalid$iv14) {
            }
            Object value$iv14 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$15$0;
                    onViewCreated$lambda$0$15$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$15$0(WatchLaterFragmentV3.this, ((Integer) obj).intValue());
                    return onViewCreated$lambda$0$15$0;
                }
            };
            $composer.updateRememberedValue(value$iv14);
            it$iv14 = value$iv14;
            Function1 function16 = (Function1) it$iv14;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247294969, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv15 = $composer.changedInstance(this$0);
            Object it$iv15 = $composer.rememberedValue();
            if (invalid$iv15) {
            }
            Object value$iv15 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda12
                public final Object invoke() {
                    Unit onViewCreated$lambda$0$16$0;
                    onViewCreated$lambda$0$16$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$16$0(WatchLaterFragmentV3.this);
                    return onViewCreated$lambda$0$16$0;
                }
            };
            $composer.updateRememberedValue(value$iv15);
            it$iv15 = value$iv15;
            Function0 function06 = (Function0) it$iv15;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1247297762, "CC(remember):WatchLaterFragmentV3.kt#9igjgp");
            boolean invalid$iv16 = $composer.changedInstance(this$0);
            Object it$iv16 = $composer.rememberedValue();
            if (invalid$iv16) {
            }
            Object value$iv16 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda13
                public final Object invoke() {
                    Unit onViewCreated$lambda$0$17$0;
                    onViewCreated$lambda$0$17$0 = WatchLaterFragmentV3.onViewCreated$lambda$0$17$0(WatchLaterFragmentV3.this);
                    return onViewCreated$lambda$0$17$0;
                }
            };
            $composer.updateRememberedValue(value$iv16);
            it$iv16 = value$iv16;
            ComposerKt.sourceInformationMarkerEnd($composer);
            WatchLaterPageComposeKt.WatchLaterPage(onViewCreated$lambda$0$1, onViewCreated$lambda$0$0, tabAllListState, tabToViewListState, function0, function02, function03, function2, function22, function04, function05, function23, function1, function12, function13, function14, function15, function16, function06, (Function0) it$iv16, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean onViewCreated$lambda$0$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    private static final WatchLaterState onViewCreated$lambda$0$1(State<WatchLaterState> state) {
        Object thisObj$iv = state.getValue();
        return (WatchLaterState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$2$0(WatchLaterFragmentV3 this$0) {
        FragmentActivity activity;
        FragmentActivity it = this$0.getActivity();
        boolean z = false;
        if (it != null) {
            BLRouter $this$iv = BLRouter.INSTANCE;
            AutoAddAppWidgetService autoAddAppWidgetService = (AutoAddAppWidgetService) $this$iv.get(AutoAddAppWidgetService.class, "default");
            z = Intrinsics.areEqual(autoAddAppWidgetService != null ? Boolean.valueOf(autoAddAppWidgetService.closeFunctionWidgetGuide(it, new GuideScene.WatchLater(WatchLaterFragmentV3Kt.WATCH_LATER_EVENT_ID))) : null, false);
        }
        if (z && (activity = this$0.getActivity()) != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$3$0(WatchLaterFragmentV3 this$0) {
        this$0.getViewModel().onManageClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$4$0(WatchLaterFragmentV3 this$0) {
        this$0.getViewModel().jumpPlayList(this$0.getContext());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$5$0(WatchLaterFragmentV3 this$0, boolean checkMode, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (checkMode) {
            this$0.getViewModel().onCardCheckClick(item.getItemId());
        } else {
            String it = item.getUri();
            if (it != null) {
                WatchLaterRouterKt.routerTo$default(it, this$0.getContext(), null, 4, null);
            }
            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_CARD_CLICK, MapsKt.mapOf(TuplesKt.to("avid", String.valueOf(item.getAid()))));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$6$0(WatchLaterFragmentV3 this$0, boolean checkMode, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (checkMode) {
            this$0.getViewModel().onCardCheckClick(item.getItemId());
        } else {
            this$0.getViewModel().onCardCheckClick(item.getItemId());
            this$0.getViewModel().changeCheckState();
            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_MANAGE_OPTION_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to(WatchLaterReporterKt.KEY_OPTION, "1"), TuplesKt.to(WatchLaterReporterKt.KEY_CLICK_TYPE, "1")}));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$7$0(WatchLaterFragmentV3 this$0) {
        WatchLaterViewModel viewModel = this$0.getViewModel();
        FragmentActivity activity = this$0.getActivity();
        viewModel.onClickBatchOP(2, activity != null ? activity.getSupportFragmentManager() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$8$0(WatchLaterFragmentV3 this$0) {
        WatchLaterViewModel viewModel = this$0.getViewModel();
        FragmentActivity activity = this$0.getActivity();
        viewModel.onClickBatchOP(1, activity != null ? activity.getSupportFragmentManager() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$10$0(WatchLaterFragmentV3 this$0, int index) {
        this$0.getViewModel().load(index, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$11$0(WatchLaterFragmentV3 this$0, int index) {
        this$0.getViewModel().refresh(index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$12$0(WatchLaterFragmentV3 this$0, int index) {
        this$0.getViewModel().load(index, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$13$0(WatchLaterFragmentV3 this$0, long aid) {
        this$0.getViewModel().onThreePointClick(aid);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$14$0(WatchLaterFragmentV3 this$0, int index) {
        this$0.getViewModel().onCheckAll(index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$15$0(WatchLaterFragmentV3 this$0, int index) {
        this$0.getViewModel().onCancelAll(index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$16$0(WatchLaterFragmentV3 this$0) {
        this$0.getViewModel().showDialog(DialogType.DeleteChecked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$17$0(WatchLaterFragmentV3 this$0) {
        this$0.getViewModel().onSortClick();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBottomSheet() {
        Context mContext = getContext();
        if (mContext == null) {
            return;
        }
        Iterable $this$map$iv = WatchLaterConstsKt.getBottomSheetItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            int strId = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(new ListBottomSheetItem(mContext.getString(strId), (Integer) null, 0, 0, false, (String) null, 0, (int) Player.PLAYER_QUALITY_DOLBY_VISION, (DefaultConstructorMarker) null));
        }
        ArrayList itemList = new ArrayList(CollectionsKt.toMutableList((List) destination$iv$iv));
        ListBottomSheetDialog newInstance = ListBottomSheetDialog.Companion.newInstance(itemList, new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit showBottomSheet$lambda$1;
                showBottomSheet$lambda$1 = WatchLaterFragmentV3.showBottomSheet$lambda$1(WatchLaterFragmentV3.this, ((Integer) obj).intValue());
                return showBottomSheet$lambda$1;
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        newInstance.show(childFragmentManager, "WatchLater Bottom Manage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBottomSheet$lambda$1(WatchLaterFragmentV3 this$0, int pos) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterFragmentV3$showBottomSheet$1$1(pos, this$0, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBottomDeleteSheet(final long aid) {
        Context mContext = getContext();
        if (mContext == null) {
            return;
        }
        Iterable $this$map$iv = WatchLaterConstsKt.getBottomDeleteSheetItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair item = (Pair) item$iv$iv;
            destination$iv$iv.add(new ListBottomSheetItem(mContext.getString(((Number) item.getSecond()).intValue()), (Integer) item.getFirst(), 0, 0, false, (String) null, 0, 124, (DefaultConstructorMarker) null));
        }
        ArrayList itemList = new ArrayList((List) destination$iv$iv);
        ListBottomSheetDialog newInstance = ListBottomSheetDialog.Companion.newInstance(itemList, new Function1() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit showBottomDeleteSheet$lambda$1;
                showBottomDeleteSheet$lambda$1 = WatchLaterFragmentV3.showBottomDeleteSheet$lambda$1(WatchLaterFragmentV3.this, aid, ((Integer) obj).intValue());
                return showBottomDeleteSheet$lambda$1;
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        newInstance.show(childFragmentManager, "WatchLater Bottom Delete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBottomDeleteSheet$lambda$1(WatchLaterFragmentV3 this$0, long $aid, int it) {
        this$0.getViewModel().deleteItem($aid);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showBiliCommonDialog(Context $this$showBiliCommonDialog, DialogType dialogType, Continuation<? super Boolean> continuation) {
        int titleId;
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        if (Intrinsics.areEqual(dialogType, DialogType.DeleteChecked.INSTANCE)) {
            titleId = R.string.favorites_global_string_235;
        } else if (Intrinsics.areEqual(dialogType, DialogType.DeleteInvalid.INSTANCE)) {
            titleId = R.string.favorites_global_string_236;
        } else if (!Intrinsics.areEqual(dialogType, DialogType.DeleteWatched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            titleId = R.string.favorites_global_string_246;
        }
        BiliCommonDialog.Builder builder = BiliCommonDialog.Builder.setPositiveButton$default(BiliCommonDialog.Builder.setNegativeButton$default(new BiliCommonDialog.Builder($this$showBiliCommonDialog).setTitle(titleId), bili.resource.common.R.string.common_global_string_238, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$showBiliCommonDialog$2$builder$1
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                Intrinsics.checkNotNullParameter(view2, "<unused var>");
                Intrinsics.checkNotNullParameter(biliCommonDialog, "<unused var>");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(false));
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null), bili.resource.common.R.string.common_global_string_113, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$showBiliCommonDialog$2$builder$2
            @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
            public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                Intrinsics.checkNotNullParameter(view2, "<unused var>");
                Intrinsics.checkNotNullParameter(biliCommonDialog, "<unused var>");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(true));
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null).setTitleColorRes(com.bilibili.lib.theme.R.color.Text1).setButtonStyle(1).setCanceledOnTouchOutside(false);
        if (dialogType instanceof DialogType.DeleteWatched) {
            String string = $this$showBiliCommonDialog.getString(R.string.favorites_global_string_224);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            builder.setContentText(string);
        }
        BiliCommonDialog build = builder.build();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        build.show(childFragmentManager, "watch_later_v2");
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public String getPvEventId() {
        return WatchLaterFragmentV3Kt.WATCH_LATER_EVENT_ID;
    }

    public Bundle getPvExtra() {
        return null;
    }
}