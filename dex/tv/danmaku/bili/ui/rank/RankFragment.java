package tv.danmaku.bili.ui.rank;

import ComposableSingletons$CustomBottomSheetKt$;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStateIdReliablePagerAdapter;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.app.comm.list.widget.statement.ErrorState;
import com.bilibili.app.comm.list.widget.statement.PlaceHolderState;
import com.bilibili.app.comm.list.widget.statement.StatePageKt;
import com.bilibili.app.comm.list.widget.text.MessageString;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.ui.BaseToolbarFragment;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.rank.reporter.RankingReport;
import tv.danmaku.bili.ui.rank.utils.ICurrentFragmentState;
import tv.danmaku.bili.ui.rank.utils.NeuronsEventKt;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.bili.widget.PagerSlidingTabStrip;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u000bH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/rank/RankFragment;", "Lcom/bilibili/lib/ui/BaseToolbarFragment;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/ui/rank/RankViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/rank/RankViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mCurrentPage", "", "mErrorView", "Landroidx/compose/ui/platform/ComposeView;", "mTabs", "Ltv/danmaku/bili/widget/PagerSlidingTabStrip;", "mPager", "Landroidx/viewpager/widget/ViewPager;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showErrorView", "placeState", "Lcom/bilibili/app/comm/list/widget/statement/PlaceHolderState;", "onPageSelected", "pos", "reportClickEvent", "pager", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankFragment extends BaseToolbarFragment {
    public static final int $stable = 8;
    private int mCurrentPage;
    private ComposeView mErrorView;
    private ViewPager mPager;
    private PagerSlidingTabStrip mTabs;
    private final Lazy viewModel$delegate;

    public RankFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.rank.RankFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1442invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.rank.RankFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1443invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(RankViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.rank.RankFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1444invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.rank.RankFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1445invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.rank.RankFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1446invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
        this.mCurrentPage = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RankViewModel getViewModel() {
        return (RankViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String it;
        Integer parseColor;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view2 = inflater.inflate(R.layout.bili_app_layout_fragment_pager_container, container, false);
        View appBar = view2.findViewById(R.id.appbar);
        if (appBar != null) {
            ViewCompat.setElevation(appBar, getResources().getDimensionPixelSize(com.bilibili.lib.basecomponent.R.dimen.elevation));
            if (getMShowToolbar() && (it = getMProps().getString("ct.nav.bgcolor")) != null && (parseColor = parseColor(it)) != null) {
                appBar.setBackgroundColor(parseColor.intValue());
            }
        }
        this.mTabs = (PagerSlidingTabStrip) view2.findViewById(R.id.tabs);
        this.mPager = view2.findViewById(R.id.pager);
        return view2;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        View mToolbar = getMToolbar();
        if (mToolbar != null) {
            ViewCompat.setElevation(mToolbar, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        this.mErrorView = view2.findViewById(R.id.error_view);
        setTitle(getMProps().getString("ct.nav.title", "返回"));
        PagerSlidingTabStrip pagerSlidingTabStrip = this.mTabs;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setOnPageChangeListener((ViewPager.OnPageChangeListener) new ViewPager.SimpleOnPageChangeListener() { // from class: tv.danmaku.bili.ui.rank.RankFragment$onViewCreated$2
                public void onPageSelected(int position) {
                    int i;
                    i = RankFragment.this.mCurrentPage;
                    if (i != position) {
                        RankFragment.this.mCurrentPage = position;
                        RankFragment.this.onPageSelected(position);
                    }
                }
            });
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new RankFragment$onViewCreated$3(this, null), 3, (Object) null);
    }

    static /* synthetic */ void showErrorView$default(RankFragment rankFragment, PlaceHolderState placeHolderState, int i, Object obj) {
        if ((i & 1) != 0) {
            placeHolderState = (PlaceHolderState) PlaceHolderState.ErrorHolder.INSTANCE;
        }
        rankFragment.showErrorView(placeHolderState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorView(final PlaceHolderState placeState) {
        ListExtentionsKt.gone(this.mTabs);
        View view2 = this.mErrorView;
        if (view2 != null) {
            ListExtentionsKt.visible(view2);
        }
        ComposeView composeView = this.mErrorView;
        if (composeView != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1557371943, true, new Function2() { // from class: tv.danmaku.bili.ui.rank.RankFragment$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit showErrorView$lambda$0;
                    showErrorView$lambda$0 = RankFragment.showErrorView$lambda$0(placeState, this, (Composer) obj, ((Integer) obj2).intValue());
                    return showErrorView$lambda$0;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0164, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit showErrorView$lambda$0(PlaceHolderState $placeState, final RankFragment this$0, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C110@4412L361:RankFragment.kt#o7pa2h");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1557371943, $changed, -1, "tv.danmaku.bili.ui.rank.RankFragment.showErrorView.<anonymous> (RankFragment.kt:110)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            Alignment contentAlignment$iv = new BiasAlignment((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -0.2f);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -158496497, "C117@4699L60,114@4560L199:RankFragment.kt#o7pa2h");
            ErrorState networkError = new ErrorState.NetworkError(0, (MessageString) null, (MessageString) null, (MessageString) null, false, 31, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1806223799, "CC(remember):RankFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.rank.RankFragment$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit showErrorView$lambda$0$0$0$0;
                    showErrorView$lambda$0$0$0$0 = RankFragment.showErrorView$lambda$0$0$0$0(RankFragment.this);
                    return showErrorView$lambda$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatePageKt.StatePage($placeState, networkError, (Function0) it$iv, $composer, ErrorState.NetworkError.$stable << 3);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showErrorView$lambda$0$0$0$0(RankFragment this$0) {
        this$0.getViewModel().loadData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPageSelected(int pos) {
        Fragment it;
        CharSequence pageTitle;
        String it2;
        ViewPager viewPager = this.mPager;
        PagerAdapter adapter = viewPager != null ? viewPager.getAdapter() : null;
        if (adapter != null && (pageTitle = adapter.getPageTitle(pos)) != null && (it2 = pageTitle.toString()) != null) {
            RankingReport.reportRankingTabClick(it2);
        }
        ViewPager it3 = this.mPager;
        if (it3 != null) {
            reportClickEvent(it3, pos);
        }
        FragmentStateIdReliablePagerAdapter fragmentStateIdReliablePagerAdapter = adapter instanceof FragmentStateIdReliablePagerAdapter ? (FragmentStateIdReliablePagerAdapter) adapter : null;
        if (fragmentStateIdReliablePagerAdapter != null && (it = fragmentStateIdReliablePagerAdapter.getFragment(pos)) != null) {
            ICurrentFragmentState iCurrentFragmentState = it instanceof ICurrentFragmentState ? (ICurrentFragmentState) it : null;
            if (iCurrentFragmentState != null) {
                iCurrentFragmentState.selectedPosition(pos);
            }
        }
    }

    private final void reportClickEvent(ViewPager pager, int pos) {
        CharSequence pageTitle;
        Pair[] pairArr = new Pair[2];
        PagerAdapter adapter = pager.getAdapter();
        pairArr[0] = TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, (adapter == null || (pageTitle = adapter.getPageTitle(pos)) == null) ? null : pageTitle.toString());
        pairArr[1] = TuplesKt.to("tab_order", String.valueOf(pos + 1));
        Map map = MapsKt.mutableMapOf(pairArr);
        NeuronsEventKt.reportNeuronClick(NeuronsEventKt.RANK_TAB_CLICK, map);
    }
}