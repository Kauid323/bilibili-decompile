package tv.danmaku.bili.ui.splash.brand.uiv2.setting.search;

import ComposableSingletons$CustomBottomSheetKt$;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionFragmentViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import com.bilibili.lib.ui.callback.IBackPress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSection;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.model.CustomModeState;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashSearchFragmentBinding;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSearchFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/search/BrandSplashSearchFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bilibili/lib/ui/callback/IBackPress;", "<init>", "()V", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSearchFragmentBinding;", "getBinding", "()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSearchFragmentBinding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "vm", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "getVm", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onBackPressed", "", "splash_debug", "searchTerm", ""}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSearchFragment extends androidx_fragment_app_Fragment implements IBackPress {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BrandSplashSearchFragment.class, "binding", "getBinding()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashSearchFragmentBinding;", 0))};
    public static final int $stable = 8;
    private final ViewBindingProperty binding$delegate;
    private final Lazy vm$delegate;

    public BrandSplashSearchFragment() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, BiliAppListBrandSplashSearchFragmentBinding.class, createMethod$iv, onViewDestroyed$iv);
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(BrandSplashSettingViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1590invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1591invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1592invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final BiliAppListBrandSplashSearchFragmentBinding getBinding() {
        return (BiliAppListBrandSplashSearchFragmentBinding) this.binding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrandSplashSettingViewModel getVm() {
        return (BrandSplashSettingViewModel) this.vm$delegate.getValue();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        getVm().getSearchPageViewModel().clear();
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        final LazyListState listState = new LazyListState(0, 0, 3, (DefaultConstructorMarker) null);
        getBinding().composeContainer.setContent(ComposableLambdaKt.composableLambdaInstance(573598536, true, new Function2() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit onViewCreated$lambda$0;
                onViewCreated$lambda$0 = BrandSplashSearchFragment.onViewCreated$lambda$0(BrandSplashSearchFragment.this, listState, (Composer) obj, ((Integer) obj2).intValue());
                return onViewCreated$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(final BrandSplashSearchFragment this$0, final LazyListState $listState, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C53@2316L4098,53@2306L4108:BrandSplashSearchFragment.kt#el1moh");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(573598536, $changed, -1, "tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment.onViewCreated.<anonymous> (BrandSplashSearchFragment.kt:53)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-958191984, true, new Function2() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit onViewCreated$lambda$0$0;
                    onViewCreated$lambda$0$0 = BrandSplashSearchFragment.onViewCreated$lambda$0$0(BrandSplashSearchFragment.this, $listState, (Composer) obj, ((Integer) obj2).intValue());
                    return onViewCreated$lambda$0$0;
                }
            }, $composer, 54), $composer, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0177, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01b0, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01e9, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0296, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onViewCreated$lambda$0$0(final BrandSplashSearchFragment this$0, LazyListState $listState, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        ComposerKt.sourceInformation($composer, "C54@2334L4066:BrandSplashSearchFragment.kt#el1moh");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-958191984, $changed, -1, "tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment.onViewCreated.<anonymous>.<anonymous> (BrandSplashSearchFragment.kt:54)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -814066477, "C57@2496L16,64@2831L100,67@2973L114,70@3124L87,58@2533L700,75@3333L30:BrandSplashSearchFragment.kt#el1moh");
            State searchTerm$delegate = SnapshotStateKt.collectAsState(this$0.getVm().getSearchPageViewModel().getSearchTerm(), (CoroutineContext) null, $composer, 0, 1);
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.Companion), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            String onViewCreated$lambda$0$0$0$0 = onViewCreated$lambda$0$0$0$0(searchTerm$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1082127242, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit onViewCreated$lambda$0$0$0$1$0;
                    onViewCreated$lambda$0$0$0$1$0 = BrandSplashSearchFragment.onViewCreated$lambda$0$0$0$1$0(BrandSplashSearchFragment.this, (String) obj);
                    return onViewCreated$lambda$0$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1082131800, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(this$0);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit onViewCreated$lambda$0$0$0$2$0;
                    onViewCreated$lambda$0$0$0$2$0 = BrandSplashSearchFragment.onViewCreated$lambda$0$0$0$2$0(BrandSplashSearchFragment.this);
                    return onViewCreated$lambda$0$0$0$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Function0 function0 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1082136605, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance(this$0);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit onViewCreated$lambda$0$0$0$3$0;
                    onViewCreated$lambda$0$0$0$3$0 = BrandSplashSearchFragment.onViewCreated$lambda$0$0$0$3$0(BrandSplashSearchFragment.this);
                    return onViewCreated$lambda$0$0$0$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            BrandSplashSearchBarKt.BrandSplashSearchBar(wrapContentHeight$default, onViewCreated$lambda$0$0$0$0, function1, function0, (Function0) it$iv3, $composer, 0, 0);
            final List data = (List) SnapshotStateKt.collectAsState(this$0.getVm().getSearchPageViewModel().getSearchResultData(), (Object) null, (CoroutineContext) null, $composer, 48, 2).getValue();
            List list = data;
            if (list == null || list.isEmpty()) {
                $composer2 = $composer;
                $composer$iv$iv = $composer;
                $composer$iv = $composer;
                $composer$iv2 = $composer;
                $composer2.startReplaceGroup(-816606308);
            } else {
                $composer.startReplaceGroup(-813123737);
                ComposerKt.sourceInformation($composer, "81@3685L1984,77@3443L2226,112@5757L603,112@5731L629");
                $composer$iv$iv = $composer;
                PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(30), 1, (Object) null);
                Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(30));
                ComposerKt.sourceInformationMarkerStart($composer, 1082156454, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
                boolean invalid$iv4 = $composer.changedInstance(data) | $composer.changedInstance(this$0);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit onViewCreated$lambda$0$0$0$4$0;
                        onViewCreated$lambda$0$0$0$4$0 = BrandSplashSearchFragment.onViewCreated$lambda$0$0$0$4$0(data, this$0, (LazyListScope) obj);
                        return onViewCreated$lambda$0$0$0$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer$iv = $composer;
                $composer$iv2 = $composer;
                LazyDslKt.LazyColumn((Modifier) null, $listState, paddingValues, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv4, $composer, 24960, 489);
                $composer2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer2, 1082221377, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
                boolean invalid$iv5 = $composer2.changed($listState) | $composer2.changedInstance(this$0);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = (Function2) new BrandSplashSearchFragment$onViewCreated$1$1$1$5$1($listState, this$0, null);
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect($listState, (Function2) it$iv5, $composer2, 0);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String onViewCreated$lambda$0$0$0$0(State<String> state) {
        Object thisObj$iv = state.getValue();
        return (String) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0$0$1$0(BrandSplashSearchFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getVm().getSearchPageViewModel().getSearchTerm().setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0$0$2$0(BrandSplashSearchFragment this$0) {
        this$0.getVm().getSearchPageViewModel().getSearchFragmentShowing().setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0$0$3$0(BrandSplashSearchFragment this$0) {
        this$0.getVm().getSearchPageViewModel().search();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0$0$0$4$0(final List $data, final BrandSplashSearchFragment this$0, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 contentType$iv = new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$lambda$0$0$0$4$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1589invoke((BrandSplashSection) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1589invoke(BrandSplashSection brandSplashSection) {
                return null;
            }
        };
        $this$LazyColumn.items($data.size(), (Function1) null, new Function1<Integer, Object>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$lambda$0$0$0$4$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke($data.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$lambda$0$0$0$4$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int $changed2 = $dirty & 14;
                final BrandSplashSection section = (BrandSplashSection) $data.get(it);
                $composer.startReplaceGroup(-118585485);
                ComposerKt.sourceInformation($composer, "CN(section)*83@3826L1786,83@3772L1841:BrandSplashSearchFragment.kt#el1moh");
                ComposerKt.sourceInformationMarkerStart($composer, -1804938983, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(section) | $composer.changedInstance(this$0);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final BrandSplashSearchFragment brandSplashSearchFragment = this$0;
                    Object value$iv = (Function1) new Function1<LazyListScope, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$4$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((LazyListScope) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyListScope $this$BrandSplashCardGroup) {
                            Intrinsics.checkNotNullParameter($this$BrandSplashCardGroup, "$this$BrandSplashCardGroup");
                            final List list = BrandSplashSection.this.getList();
                            List list2 = list;
                            if (!(list2 == null || list2.isEmpty())) {
                                final BrandSplashSearchFragment brandSplashSearchFragment2 = brandSplashSearchFragment;
                                final Function1 contentType$iv2 = new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$4$1$1$1$1$invoke$$inlined$items$default$1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        return m1588invoke((BrandSplash) p1);
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final Void m1588invoke(BrandSplash brandSplash) {
                                        return null;
                                    }
                                };
                                $this$BrandSplashCardGroup.items(list.size(), (Function1) null, new Function1<Integer, Object>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$4$1$1$1$1$invoke$$inlined$items$default$3
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        return invoke(((Number) p1).intValue());
                                    }

                                    public final Object invoke(int index) {
                                        return contentType$iv2.invoke(list.get(index));
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$4$1$1$1$1$invoke$$inlined$items$default$4
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                                        invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:66:0x01d0  */
                                    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final void invoke(LazyItemScope $this$items2, int it2, Composer $composer2, int $changed3) {
                                        BrandSplashSettingViewModel vm;
                                        BrandSplashSettingViewModel vm2;
                                        BrandSplashSettingViewModel vm3;
                                        boolean isSelected;
                                        ComposerKt.sourceInformation($composer2, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                                        int $dirty2 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty2 |= $composer2.changed($this$items2) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty2 |= $composer2.changed(it2) ? 32 : 16;
                                        }
                                        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(802480018, $dirty2, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                                            }
                                            int i = $dirty2 & 14;
                                            final BrandSplash splash = (BrandSplash) list.get(it2);
                                            $composer2.startReplaceGroup(-2094472978);
                                            ComposerKt.sourceInformation($composer2, "CN(splash)*87@4101L16,88@4216L31,89@4333L37,98@5104L147,101@5316L136,91@4566L932:BrandSplashSearchFragment.kt#el1moh");
                                            vm = brandSplashSearchFragment2.getVm();
                                            boolean isCustomModeOn = ((CustomModeState) SnapshotStateKt.collectAsState(vm.getCustomModeState(), (CoroutineContext) null, $composer2, 0, 1).getValue()).getCustomMode();
                                            vm2 = brandSplashSearchFragment2.getVm();
                                            boolean isDisable = ((Boolean) SnapshotStateKt.collectAsState(vm2.getDisableSelectFlow(), false, (CoroutineContext) null, $composer2, 48, 2).getValue()).booleanValue();
                                            vm3 = brandSplashSearchFragment2.getVm();
                                            Iterable $this$any$iv = (Iterable) SnapshotStateKt.collectAsState(vm3.getSelectedSplash(), CollectionsKt.emptyList(), (CoroutineContext) null, $composer2, 48, 2).getValue();
                                            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                                                Iterator it3 = $this$any$iv.iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        Object element$iv = it3.next();
                                                        if (Intrinsics.areEqual(BrandSplashKt.getUniqueId((BrandSplash) element$iv), BrandSplashKt.getUniqueId(splash))) {
                                                            isSelected = true;
                                                            break;
                                                        }
                                                    } else {
                                                        isSelected = false;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                isSelected = false;
                                            }
                                            String loadLocalImagePath = BrandSplashKt.loadLocalImagePath(splash);
                                            String image = (loadLocalImagePath == null && (loadLocalImagePath = splash.getThumb()) == null) ? "" : loadLocalImagePath;
                                            Modifier modifier = SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(104));
                                            String thumbName = splash.getThumbName();
                                            String str = thumbName == null ? "" : thumbName;
                                            ComposerKt.sourceInformationMarkerStart($composer2, 1595036427, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
                                            boolean invalid$iv2 = $composer2.changedInstance(brandSplashSearchFragment2) | $composer2.changedInstance(splash);
                                            Object value$iv2 = $composer2.rememberedValue();
                                            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                                                final BrandSplashSearchFragment brandSplashSearchFragment3 = brandSplashSearchFragment2;
                                                value$iv2 = (Function0) new Function0<Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$4$1$1$1$1$1$1$1
                                                    public /* bridge */ /* synthetic */ Object invoke() {
                                                        m1593invoke();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke  reason: collision with other method in class */
                                                    public final void m1593invoke() {
                                                        BrandSplashSettingViewModel vm4;
                                                        vm4 = BrandSplashSearchFragment.this.getVm();
                                                        BrandSplash brandSplash = splash;
                                                        FragmentManager childFragmentManager = BrandSplashSearchFragment.this.getChildFragmentManager();
                                                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                                                        vm4.selectCard(brandSplash, childFragmentManager);
                                                    }
                                                };
                                                $composer2.updateRememberedValue(value$iv2);
                                            }
                                            Function0 function0 = (Function0) value$iv2;
                                            ComposerKt.sourceInformationMarkerEnd($composer2);
                                            ComposerKt.sourceInformationMarkerStart($composer2, 1595043200, "CC(remember):BrandSplashSearchFragment.kt#9igjgp");
                                            boolean invalid$iv3 = $composer2.changedInstance(brandSplashSearchFragment2) | $composer2.changedInstance(splash);
                                            Object it$iv2 = $composer2.rememberedValue();
                                            if (!invalid$iv3 && it$iv2 != Composer.Companion.getEmpty()) {
                                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                                BrandSplashSearchCardKt.BrandSplashSearchCard(isCustomModeOn, isDisable, isSelected, image, str, function0, (Function0) it$iv2, modifier, $composer2, 12582912, 0);
                                                $composer2.endReplaceGroup();
                                                if (!ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            final BrandSplashSearchFragment brandSplashSearchFragment4 = brandSplashSearchFragment2;
                                            Object value$iv3 = (Function0) new Function0<Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$4$1$1$1$1$1$2$1
                                                public /* bridge */ /* synthetic */ Object invoke() {
                                                    m1594invoke();
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: collision with other method in class */
                                                public final void m1594invoke() {
                                                    BrandSplashSettingViewModel vm4;
                                                    vm4 = BrandSplashSearchFragment.this.getVm();
                                                    vm4.openPreviewPage(splash, true);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                            it$iv2 = value$iv3;
                                            ComposerKt.sourceInformationMarkerEnd($composer2);
                                            BrandSplashSearchCardKt.BrandSplashSearchCard(isCustomModeOn, isDisable, isSelected, image, str, function0, (Function0) it$iv2, modifier, $composer2, 12582912, 0);
                                            $composer2.endReplaceGroup();
                                            if (!ComposerKt.isTraceInProgress()) {
                                            }
                                        } else {
                                            $composer2.skipToGroupEnd();
                                        }
                                    }
                                }));
                            }
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                BrandSplashSearchCardKt.BrandSplashCardGroup(section, (Function1) it$iv, null, $composer, ($changed2 >> 3) & 14, 4);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public boolean onBackPressed() {
        getVm().getSearchPageViewModel().getSearchFragmentShowing().setValue(false);
        return true;
    }
}