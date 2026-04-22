package kntr.app.game.base.ui.page;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.CollectorHolder;
import kntr.app.game.base.ui.ExposerKt;
import kntr.app.game.base.ui.indication.NoPressIndication;
import kntr.app.game.base.ui.localproviders.GameLocalProvidersKt;
import kntr.app.game.base.ui.widget.gameaction.provider.GameActionStateProvider;
import kntr.app.game.base.ui.widget.gameaction.provider.GameActionStateProviderKt;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.base.viewmodel.RefreshState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kntr.common.compose.pulltorefresh.PullToRefreshKt;
import kntr.common.compose.pulltorefresh.PullToRefreshState;
import kntr.common.compose.pulltorefresh.PullToRefreshStateKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: LoadComposable.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a¥\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2P\u0010\r\u001aL\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"LoadComposable", RoomRecommendViewModel.EMPTY_CURSOR, "Data", "VM", "Lkntr/app/game/base/viewmodel/BaseViewModel;", "viewModel", RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "refreshEnable", RoomRecommendViewModel.EMPTY_CURSOR, "lazyLoad", "content", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "Lkntr/app/game/base/viewmodel/PageLoadMoreState;", "loadMoreState", "Landroidx/compose/runtime/Composable;", "(Lkntr/app/game/base/viewmodel/BaseViewModel;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug", "pageState", "Lkntr/app/game/base/viewmodel/PageState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LoadComposableKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadComposable$lambda$8(BaseViewModel baseViewModel, String str, Modifier modifier, boolean z, boolean z2, Function5 function5, int i, int i2, Composer composer, int i3) {
        LoadComposable(baseViewModel, str, modifier, z, z2, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final <Data, VM extends BaseViewModel<Data>> void LoadComposable(final VM vm, final String sourceFrom, Modifier modifier, boolean refreshEnable, boolean lazyLoad, final Function5<? super Data, ? super VM, ? super PageLoadMoreState, ? super Composer, ? super Integer, Unit> function5, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        boolean z2;
        Composer $composer2;
        Modifier modifier3;
        boolean refreshEnable2;
        boolean lazyLoad2;
        PullToRefreshState pullToRefreshState;
        CoroutineScope coroutineScope;
        LifecycleOwner lifecycle;
        RefreshState refreshState;
        Intrinsics.checkNotNullParameter(vm, "viewModel");
        Intrinsics.checkNotNullParameter(function5, "content");
        Composer $composer3 = $composer.startRestartGroup(87456979);
        ComposerKt.sourceInformation($composer3, "C(LoadComposable)N(viewModel,sourceFrom,modifier,refreshEnable,lazyLoad,content)53@2186L58,56@2270L24,57@2332L83,58@2445L28,60@2527L114,60@2479L162,65@2725L147,65@2646L226,70@2899L25,72@2961L82,75@3084L7,76@3122L381,76@3096L407,88@3531L180,88@3508L203,95@3727L2415,95@3717L2425:LoadComposable.kt#m4iljm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(vm) : $composer3.changedInstance(vm) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(sourceFrom) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = refreshEnable;
        } else if (($changed & 3072) == 0) {
            z = refreshEnable;
            $dirty |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = refreshEnable;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            z2 = lazyLoad;
        } else if (($changed & 24576) == 0) {
            z2 = lazyLoad;
            $dirty |= $composer3.changed(z2) ? 16384 : 8192;
        } else {
            z2 = lazyLoad;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? 131072 : 65536;
        }
        if ($composer3.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            refreshEnable2 = i3 != 0 ? false : z;
            lazyLoad2 = i4 != 0 ? false : z2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(87456979, $dirty, -1, "kntr.app.game.base.ui.page.LoadComposable (LoadComposable.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1853178419, "CC(remember):LoadComposable.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = MovableContentKt.movableContentOf(function5);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function5 movableContent = (Function5) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final int $dirty2 = $dirty;
            final State pageState$delegate = SnapshotStateKt.collectAsState(vm.getState(), lazyLoad2 ? PageState.Initialize.INSTANCE : PageState.Loading.INSTANCE, (CoroutineContext) null, $composer3, 0, 2);
            PullToRefreshState pullToRefreshState2 = PullToRefreshStateKt.rememberPullToRefreshState-djqs-MU(0.0f, 0.0f, 0.0f, false, $composer3, 0, 15);
            Boolean valueOf = Boolean.valueOf(pullToRefreshState2.isRefreshing());
            ComposerKt.sourceInformationMarkerStart($composer3, -1853167451, "CC(remember):LoadComposable.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(pullToRefreshState2) | (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer3.changedInstance(vm)));
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new LoadComposableKt$LoadComposable$1$1(pullToRefreshState2, vm, null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer3, 0);
            PageState LoadComposable$lambda$1 = LoadComposable$lambda$1(pageState$delegate);
            PageState.Content content = LoadComposable$lambda$1 instanceof PageState.Content ? (PageState.Content) LoadComposable$lambda$1 : null;
            Boolean valueOf2 = (content == null || (refreshState = content.getRefreshState()) == null) ? null : Boolean.valueOf(refreshState.getRefreshing());
            ComposerKt.sourceInformationMarkerStart($composer3, -1853161082, "CC(remember):LoadComposable.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(pageState$delegate) | $composer3.changed(pullToRefreshState2);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new LoadComposableKt$LoadComposable$2$1(pullToRefreshState2, pageState$delegate, null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv3, $composer3, 0);
            final CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -1853153595, "CC(remember):LoadComposable.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = GameActionStateProvider.Companion.createGameStateProvider();
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final GameActionStateProvider gameStateProvider = (GameActionStateProvider) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LifecycleOwner lifecycle2 = (LifecycleOwner) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, -1853148144, "CC(remember):LoadComposable.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changedInstance(lifecycle2) | (($dirty2 & 57344) == 16384) | $composer3.changed(pageState$delegate) | (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer3.changedInstance(vm)));
            Object value$iv5 = $composer3.rememberedValue();
            if (invalid$iv3 || value$iv5 == Composer.Companion.getEmpty()) {
                pullToRefreshState = pullToRefreshState2;
                coroutineScope = coroutineScope2;
                lifecycle = lifecycle2;
                value$iv5 = new LoadComposableKt$LoadComposable$3$1(lazyLoad2, lifecycle2, vm, pageState$delegate, null);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                pullToRefreshState = pullToRefreshState2;
                coroutineScope = coroutineScope2;
                lifecycle = lifecycle2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(lifecycle, (Function2) value$iv5, $composer3, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1853135257, "CC(remember):LoadComposable.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(gameStateProvider);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult LoadComposable$lambda$6$0;
                        LoadComposable$lambda$6$0 = LoadComposableKt.LoadComposable$lambda$6$0(GameActionStateProvider.this, (DisposableEffectScope) obj);
                        return LoadComposable$lambda$6$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(unit, (Function1) it$iv5, $composer3, 6);
            final PullToRefreshState pullToRefreshState3 = pullToRefreshState;
            final Modifier modifier4 = modifier3;
            final boolean z3 = refreshEnable2;
            final CoroutineScope coroutineScope3 = coroutineScope;
            $composer2 = $composer3;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1333287963, true, new Function2() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadComposable$lambda$7;
                    LoadComposable$lambda$7 = LoadComposableKt.LoadComposable$lambda$7(modifier4, coroutineScope3, vm, z3, pullToRefreshState3, pageState$delegate, collectorHolder, sourceFrom, gameStateProvider, movableContent, $dirty2, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadComposable$lambda$7;
                }
            }, $composer3, 54), $composer3, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            refreshEnable2 = z;
            lazyLoad2 = z2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z4 = refreshEnable2;
            final boolean z5 = lazyLoad2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadComposable$lambda$8;
                    LoadComposable$lambda$8 = LoadComposableKt.LoadComposable$lambda$8(BaseViewModel.this, sourceFrom, modifier5, z4, z5, function5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadComposable$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState LoadComposable$lambda$1(State<? extends PageState> state) {
        Object thisObj$iv = state.getValue();
        return (PageState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult LoadComposable$lambda$6$0(final GameActionStateProvider $gameStateProvider, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        KLog_androidKt.getKLog().d("LoadComposable", "DisposableEffect: onDispose");
        return new DisposableEffectResult() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$LoadComposable$lambda$6$0$$inlined$onDispose$1
            public void dispose() {
                GameActionStateProvider.Companion.removeGameStateProvider(GameActionStateProvider.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadComposable$lambda$7(Modifier $modifier, final CoroutineScope $coroutineScope, final BaseViewModel $viewModel, boolean $refreshEnable, PullToRefreshState $pullToRefreshState, State $pageState$delegate, final CollectorHolder $collectorHolder, final String $sourceFrom, final GameActionStateProvider $gameStateProvider, final Function5 $movableContent, final int $$dirty, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:LoadComposable.kt#m4iljm");
        boolean z = false;
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1333287963, $changed, -1, "kntr.app.game.base.ui.page.LoadComposable.<anonymous> (LoadComposable.kt:96)");
            }
            PageState LoadComposable$lambda$1 = LoadComposable$lambda$1($pageState$delegate);
            if (LoadComposable$lambda$1 instanceof PageState.Initialize) {
                $composer.startReplaceGroup(1389480449);
                ComposerKt.sourceInformation($composer, "97@3795L38");
                BoxKt.Box(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), $composer, 0);
                $composer.endReplaceGroup();
            } else if (LoadComposable$lambda$1 instanceof PageState.Loading) {
                $composer.startReplaceGroup(1389482842);
                ComposerKt.sourceInformation($composer, "98@3870L31");
                PageLoadingViewKt.Loading(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), null, $composer, 0, 2);
                $composer.endReplaceGroup();
            } else if (LoadComposable$lambda$1 instanceof PageState.Empty) {
                $composer.startReplaceGroup(1389484956);
                ComposerKt.sourceInformation($composer, "99@3936L33");
                PageLoadingViewKt.LoadEmpty(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), $composer, 0, 0);
                $composer.endReplaceGroup();
            } else if (LoadComposable$lambda$1 instanceof PageState.Error) {
                $composer.startReplaceGroup(124450764);
                ComposerKt.sourceInformation($composer, "101@4075L145,101@4020L251");
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null);
                PageState LoadComposable$lambda$12 = LoadComposable$lambda$1($pageState$delegate);
                Intrinsics.checkNotNull(LoadComposable$lambda$12, "null cannot be cast to non-null type kntr.app.game.base.viewmodel.PageState.Error");
                String message = ((PageState.Error) LoadComposable$lambda$12).getMessage();
                ComposerKt.sourceInformationMarkerStart($composer, 1389489516, "CC(remember):LoadComposable.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($coroutineScope) | $composer.changedInstance($viewModel);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit LoadComposable$lambda$7$0$0;
                            LoadComposable$lambda$7$0$0 = LoadComposableKt.LoadComposable$lambda$7$0$0($coroutineScope, $viewModel);
                            return LoadComposable$lambda$7$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                PageLoadingViewKt.LoadError((Function0) it$iv, fillMaxSize$default, message, $composer, 0, 0);
                $composer.endReplaceGroup();
            } else if (!(LoadComposable$lambda$1 instanceof PageState.Content)) {
                $composer.startReplaceGroup(1389480954);
                $composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer.startReplaceGroup(124788881);
                ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
                PageState LoadComposable$lambda$13 = LoadComposable$lambda$1($pageState$delegate);
                Intrinsics.checkNotNull(LoadComposable$lambda$13, "null cannot be cast to non-null type kntr.app.game.base.viewmodel.PageState.Content<*>");
                final Object data = ((PageState.Content) LoadComposable$lambda$13).getData();
                PageState LoadComposable$lambda$14 = LoadComposable$lambda$1($pageState$delegate);
                Intrinsics.checkNotNull(LoadComposable$lambda$14, "null cannot be cast to non-null type kntr.app.game.base.viewmodel.PageState.Content<*>");
                final PageLoadMoreState loadMoreState = ((PageState.Content) LoadComposable$lambda$14).getLoadMore();
                if ($refreshEnable) {
                    $composer.startReplaceGroup(124961675);
                    ComposerKt.sourceInformation($composer, "117@4832L650,111@4534L948");
                    PullToRefreshKt.PullToRefresh($pullToRefreshState, NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), $pullToRefreshState.getNestedScrollConnection(), (NestedScrollDispatcher) null, 2, (Object) null), (PaddingValues) null, (Function3) null, false, ComposableLambdaKt.rememberComposableLambda(448640575, true, new Function2() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit LoadComposable$lambda$7$1;
                            LoadComposable$lambda$7$1 = LoadComposableKt.LoadComposable$lambda$7$1(data, $collectorHolder, $sourceFrom, $gameStateProvider, $movableContent, $viewModel, loadMoreState, $$dirty, (Composer) obj, ((Integer) obj2).intValue());
                            return LoadComposable$lambda$7$1;
                        }
                    }, $composer, 54), $composer, 196608, 28);
                    $composer.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                } else {
                    $composer.startReplaceGroup(125962231);
                    ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
                    if (data == null) {
                        $composer.startReplaceGroup(125962230);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(125962231);
                        ComposerKt.sourceInformation($composer, "*136@5972L100,131@5564L508");
                        ProvidedValue[] providedValueArr = new ProvidedValue[4];
                        providedValueArr[0] = ExposerKt.getLocalExposeCollectorHolder().provides($collectorHolder);
                        providedValueArr[1] = IndicationKt.getLocalIndication().provides(new NoPressIndication());
                        ProvidableCompositionLocal<String> localSourceFrom = GameLocalProvidersKt.getLocalSourceFrom();
                        String str = $sourceFrom;
                        if (str == null || StringsKt.isBlank(str)) {
                            z = true;
                        }
                        providedValueArr[2] = localSourceFrom.provides(z ? GameLocalProvidersKt.DEFAULT_SOURCE_FROM : $sourceFrom);
                        providedValueArr[3] = GameActionStateProviderKt.getLocalGameStateProvider().provides($gameStateProvider);
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1755240232, true, new Function2() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LoadComposable$lambda$7$2$0;
                                LoadComposable$lambda$7$2$0 = LoadComposableKt.LoadComposable$lambda$7$2$0($movableContent, data, $viewModel, loadMoreState, $$dirty, (Composer) obj, ((Integer) obj2).intValue());
                                return LoadComposable$lambda$7$2$0;
                            }
                        }, $composer, 54), $composer, ProvidedValue.$stable | 48);
                        $composer.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    $composer.endReplaceGroup();
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadComposable$lambda$7$0$0(CoroutineScope $coroutineScope, BaseViewModel $viewModel) {
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LoadComposableKt$LoadComposable$5$1$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadComposable$lambda$7$1(final Object $data, CollectorHolder $collectorHolder, String $sourceFrom, GameActionStateProvider $gameStateProvider, final Function5 $movableContent, final BaseViewModel $viewModel, final PageLoadMoreState $loadMoreState, final int $$dirty, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:LoadComposable.kt#m4iljm");
        boolean z = false;
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(448640575, $changed, -1, "kntr.app.game.base.ui.page.LoadComposable.<anonymous>.<anonymous> (LoadComposable.kt:118)");
            }
            if ($data == null) {
                $composer.startReplaceGroup(-486805106);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-486805105);
                ComposerKt.sourceInformation($composer, "*124@5326L108,119@4898L536");
                ProvidedValue[] providedValueArr = new ProvidedValue[4];
                providedValueArr[0] = ExposerKt.getLocalExposeCollectorHolder().provides($collectorHolder);
                providedValueArr[1] = IndicationKt.getLocalIndication().provides(new NoPressIndication());
                ProvidableCompositionLocal<String> localSourceFrom = GameLocalProvidersKt.getLocalSourceFrom();
                String str = $sourceFrom;
                if (str == null || StringsKt.isBlank(str)) {
                    z = true;
                }
                providedValueArr[2] = localSourceFrom.provides(z ? GameLocalProvidersKt.DEFAULT_SOURCE_FROM : $sourceFrom);
                providedValueArr[3] = GameActionStateProviderKt.getLocalGameStateProvider().provides($gameStateProvider);
                CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1339542908, true, new Function2() { // from class: kntr.app.game.base.ui.page.LoadComposableKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit LoadComposable$lambda$7$1$0$0;
                        LoadComposable$lambda$7$1$0$0 = LoadComposableKt.LoadComposable$lambda$7$1$0$0($movableContent, $data, $viewModel, $loadMoreState, $$dirty, (Composer) obj, ((Integer) obj2).intValue());
                        return LoadComposable$lambda$7$1$0$0;
                    }
                }, $composer, 54), $composer, ProvidedValue.$stable | 48);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadComposable$lambda$7$1$0$0(Function5 $movableContent, Object $it, BaseViewModel $viewModel, PageLoadMoreState $loadMoreState, int $$dirty, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C125@5360L44:LoadComposable.kt#m4iljm");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1339542908, $changed, -1, "kntr.app.game.base.ui.page.LoadComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoadComposable.kt:125)");
            }
            $movableContent.invoke($it, $viewModel, $loadMoreState, $composer, Integer.valueOf((($$dirty & 8) << 3) | 3072 | (PageLoadMoreState.$stable << 6)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadComposable$lambda$7$2$0(Function5 $movableContent, Object $it, BaseViewModel $viewModel, PageLoadMoreState $loadMoreState, int $$dirty, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C137@6002L44:LoadComposable.kt#m4iljm");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1755240232, $changed, -1, "kntr.app.game.base.ui.page.LoadComposable.<anonymous>.<anonymous>.<anonymous> (LoadComposable.kt:137)");
            }
            $movableContent.invoke($it, $viewModel, $loadMoreState, $composer, Integer.valueOf((($$dirty & 8) << 3) | 3072 | (PageLoadMoreState.$stable << 6)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}