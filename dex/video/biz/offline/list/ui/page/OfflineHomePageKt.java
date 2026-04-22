package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.navigationevent.NavigationEventInfo;
import androidx.navigationevent.compose.NavigationEventHandlerKt;
import androidx.navigationevent.compose.NavigationEventState;
import androidx.navigationevent.compose.RememberNavigationEventStateKt;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.common.swipe.SwipeActionKt;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import java.util.Set;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.base.model.model.ReserveInfo;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflineDownloadingCardModel;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;
import video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine;
import video.biz.offline.list.ui.widget.ContentWithCheckMarkKt;
import video.biz.offline.list.ui.widget.ContentWithStateKt;
import video.biz.offline.list.ui.widget.OfflineCompletedCardKt;
import video.biz.offline.list.ui.widget.OfflineDownloadingSectionKt;
import video.biz.offline.list.ui.widget.OfflineEmptyPlaceholderKt;
import video.biz.offline.list.ui.widget.OfflineListItem_androidKt;
import video.biz.offline.list.ui.widget.OfflineOperationComponentKt;
import video.biz.offline.list.ui.widget.OfflinePageFooterKt;
import video.biz.offline.list.ui.widget.OfflinePageHeaderKt;
import video.biz.offline.list.ui.widget.OfflinePopupKt;
import video.biz.offline.list.ui.widget.OfflineSwipeActionExtKt;

/* compiled from: OfflineHomePage.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aÍ\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00192\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a\u001d\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002"}, d2 = {"OfflineCacheHome", "", "(Landroidx/compose/runtime/Composer;I)V", "OfflineCacheHomeList", "isEdit", "", "addHeader", "downloading", "", "Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;", "completed", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "supportOperations", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "modifier", "Landroidx/compose/ui/Modifier;", "selected", "", "", "emptyTip", "onClickDownloading", "Lkotlin/Function0;", "onItemClick", "Lkotlin/Function1;", "onItemLongClick", "operationHandler", "Lkotlin/Function2;", "(ZZLjava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "PrepareBackHandler", "machine", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "(Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;ZLandroidx/compose/runtime/Composer;I)V", "ui_debug", "state", "Lvideo/biz/offline/list/logic/model/OfflinePageState;"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineHomePageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$6(int i, Composer composer, int i2) {
        OfflineCacheHome(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$3(boolean z, boolean z2, List list, List list2, List list3, LazyListState lazyListState, Modifier modifier, Set set, String str, Function0 function0, Function1 function1, Function1 function12, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        OfflineCacheHomeList(z, z2, list, list2, list3, lazyListState, modifier, set, str, function0, function1, function12, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$5(boolean z, boolean z2, List list, List list2, List list3, LazyListState lazyListState, Modifier modifier, Set set, String str, Function0 function0, Function1 function1, Function1 function12, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        OfflineCacheHomeList(z, z2, list, list2, list3, lazyListState, modifier, set, str, function0, function1, function12, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrepareBackHandler$lambda$1(OfflineBaseListStateMachine offlineBaseListStateMachine, boolean z, int i, Composer composer, int i2) {
        PrepareBackHandler(offlineBaseListStateMachine, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OfflineCacheHome(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-2073319879);
        ComposerKt.sourceInformation($composer2, "C(OfflineCacheHome)80@4200L7,81@4239L7,82@4263L24,84@4314L169,91@4515L45,93@4602L7,94@4635L331,94@4614L352,106@4992L137,106@4971L158,111@5157L67,111@5134L90,118@5262L35,121@5364L23,123@5403L5860,123@5393L5870:OfflineHomePage.kt#rawcr6");
        if ($composer2.shouldExecute($changed != 0, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2073319879, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHome (OfflineHomePage.kt:79)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Router router = (Router) consume;
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 404427170, "CC(remember):OfflineHomePage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new OfflineHomePageStateMachine(OfflinePageStateKt.offlineHomePageInitialState(), router, scope, null, null, 24, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final OfflineHomePageStateMachine machine = (OfflineHomePageStateMachine) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State state$delegate = SnapshotStateKt.collectAsState(machine.getState(), OfflinePageStateKt.offlineHomePageInitialState(), (CoroutineContext) null, $composer2, OfflinePageState.$stable << 3, 2);
            CompositionLocal this_$iv3 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle = (LifecycleOwner) consume3;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 404437604, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(lifecycle);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new OfflineHomePageKt$OfflineCacheHome$1$1(lifecycle, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 404448834, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(machine);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new OfflineHomePageKt$OfflineCacheHome$2$1(lifecycle, machine, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv3, $composer2, 6);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 404454044, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(machine);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        DisposableEffectResult OfflineCacheHome$lambda$4$0;
                        OfflineCacheHome$lambda$4$0 = OfflineHomePageKt.OfflineCacheHome$lambda$4$0(OfflineHomePageStateMachine.this, (DisposableEffectScope) obj);
                        return OfflineCacheHome$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit3, (Function1) it$iv4, $composer2, 6);
            final boolean isEdit = OfflineCacheHome$lambda$1(state$delegate).isEdit();
            PrepareBackHandler(machine, isEdit, $composer2, OfflineHomePageStateMachine.$stable);
            final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1762328591, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHome$lambda$5;
                    OfflineCacheHome$lambda$5 = OfflineHomePageKt.OfflineCacheHome$lambda$5(OfflineHomePageStateMachine.this, isEdit, scope, state$delegate, lazyListState, toaster, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHome$lambda$5;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHome$lambda$6;
                    OfflineCacheHome$lambda$6 = OfflineHomePageKt.OfflineCacheHome$lambda$6($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHome$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState OfflineCacheHome$lambda$1(State<OfflinePageState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflinePageState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult OfflineCacheHome$lambda$4$0(final OfflineHomePageStateMachine $machine, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$OfflineCacheHome$lambda$4$0$$inlined$onDispose$1
            public void dispose() {
                OfflineHomePageStateMachine.this.dispose();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5(final OfflineHomePageStateMachine $machine, final boolean $isEdit, final CoroutineScope $scope, final State $state$delegate, final LazyListState $lazyListState, final Toaster $toaster, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C124@5430L28,125@5478L20,128@5539L675,144@6240L2308,193@8560L2633,127@5508L5685,254@11218L39:OfflineHomePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1762328591, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHome.<anonymous> (OfflineHomePage.kt:124)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(176882349, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHome$lambda$5$0;
                    OfflineCacheHome$lambda$5$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$0($isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHome$lambda$5$0;
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(346026124, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHome$lambda$5$1;
                    OfflineCacheHome$lambda$5$1 = OfflineHomePageKt.OfflineCacheHome$lambda$5$1($isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHome$lambda$5$1;
                }
            }, $composer, 54), (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1760321918, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineCacheHome$lambda$5$2;
                    OfflineCacheHome$lambda$5$2 = OfflineHomePageKt.OfflineCacheHome$lambda$5$2($state$delegate, $isEdit, $lazyListState, $scope, $machine, $toaster, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineCacheHome$lambda$5$2;
                }
            }, $composer, 54), $composer, 805306800, 505);
            OfflinePopupKt.OfflinePopup(OfflineCacheHome$lambda$1($state$delegate).getDialogType(), $machine, $composer, OfflineHomePageStateMachine.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$0(final boolean $isEdit, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C134@5849L351,129@5557L643:OfflineHomePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(176882349, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHome.<anonymous>.<anonymous> (OfflineHomePage.kt:129)");
            }
            OfflinePageHeaderKt.m2949OfflinePageHeaderGmEhDVc(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_60(PlayerbaseresRes.INSTANCE.getString())), SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), !$isEdit, false, false, Dp.constructor-impl(120), null, null, ComposableLambdaKt.rememberComposableLambda(604539337, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineCacheHome$lambda$5$0$0;
                    OfflineCacheHome$lambda$5$0$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$0$0($isEdit, $scope, $machine, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineCacheHome$lambda$5$0$0;
                }
            }, $composer, 54), $composer, 100859952, 216);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$0$0(boolean $isEdit, CoroutineScope $scope, OfflineHomePageStateMachine $machine, State $state$delegate, RowScope $this$OfflinePageHeader, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageHeader, "$this$OfflinePageHeader");
        ComposerKt.sourceInformation($composer, "C:OfflineHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(604539337, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHome.<anonymous>.<anonymous>.<anonymous> (OfflineHomePage.kt:135)");
            }
            if ($isEdit) {
                $composer.startReplaceGroup(1033553021);
                ComposerKt.sourceInformation($composer, "136@5909L44");
                OfflinePageHeaderKt.OfflineHeaderCancelOperation($scope, $machine, $composer, OfflineHomePageStateMachine.$stable << 3);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1033653616);
                ComposerKt.sourceInformation($composer, "*139@6098L36");
                Iterable $this$forEach$iv = OfflineCacheHome$lambda$1($state$delegate).getConfig().getHeaderOperations();
                for (Object element$iv : $this$forEach$iv) {
                    OfflinePageOperation operation = (OfflinePageOperation) element$iv;
                    OfflineOperationComponentKt.mapToHeaderComponent(operation, $scope, $machine, $composer, OfflineHomePageStateMachine.$stable << 6);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x01c3, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineCacheHome$lambda$5$1(boolean $isEdit, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        boolean z;
        ComposerKt.sourceInformation($composer, "C182@8141L167,187@8328L206,178@7913L621:OfflineHomePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(346026124, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHome.<anonymous>.<anonymous> (OfflineHomePage.kt:145)");
            }
            StorageInfoModel storageInfo = OfflineCacheHome$lambda$1($state$delegate).getStorageInfo();
            final ReserveInfo reserveInfo = OfflineCacheHome$lambda$1($state$delegate).getReserveInfo();
            if (!$isEdit) {
                $composer.startReplaceGroup(542930757);
                ComposerKt.sourceInformation($composer, "152@6578L12,154@6704L17,148@6397L1445");
                Modifier modifier$iv = SizeKt.wrapContentSize$default(PaddingKt.padding(Modifier.Companion, WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0)), (Alignment) null, false, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
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
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -477639772, "C:OfflineHomePage.kt#rawcr6");
                if (reserveInfo == null || !reserveInfo.getHasReserve()) {
                    z = false;
                    $composer.startReplaceGroup(-484441049);
                } else {
                    $composer.startReplaceGroup(-477606727);
                    ComposerKt.sourceInformation($composer, "160@7031L217,158@6905L374");
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1785713428, "CC(remember):OfflineHomePage.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine) | $composer.changedInstance(reserveInfo);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda18
                        public final Object invoke() {
                            Unit OfflineCacheHome$lambda$5$1$0$0$0;
                            OfflineCacheHome$lambda$5$1$0$0$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$1$0$0$0($scope, $machine, reserveInfo);
                            return OfflineCacheHome$lambda$5$1$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    z = false;
                    OfflinePageFooterKt.OfflineReserve(fillMaxWidth$default, (Function0) it$iv, $composer, 6, 0);
                }
                $composer.endReplaceGroup();
                boolean listEmpty = (OfflineCacheHome$lambda$1($state$delegate).getCompleted().isEmpty() && OfflineCacheHome$lambda$1($state$delegate).getDownloading().isEmpty()) ? true : z;
                if (storageInfo != null && storageInfo.getShowStorageUsage()) {
                    z = true;
                }
                if (!z || listEmpty) {
                    $composer.startReplaceGroup(-484441049);
                } else {
                    $composer.startReplaceGroup(-477005513);
                    ComposerKt.sourceInformation($composer, "169@7514L280");
                    OfflinePageFooterKt.OfflineStorageUsage(storageInfo.getUsedSpaceDesc(), storageInfo.getAvailableSpaceDesc(), SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(5), 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), $composer, 384, 0);
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            $composer.startReplaceGroup(536558614);
            $composer.endReplaceGroup();
            int size = OfflineCacheHome$lambda$1($state$delegate).selected().size();
            int size2 = OfflineCacheHome$lambda$1($state$delegate).getCompleted().size();
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1818684371, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit OfflineCacheHome$lambda$5$1$1$0;
                        OfflineCacheHome$lambda$5$1$1$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$1$1$0($scope, $machine);
                        return OfflineCacheHome$lambda$5$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflinePageFooterKt.OfflinePageFooter(size, size2, fillMaxWidth$default2, (Function0) it$iv2, ComposableLambdaKt.rememberComposableLambda(257210582, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineCacheHome$lambda$5$1$2;
                    OfflineCacheHome$lambda$5$1$2 = OfflineHomePageKt.OfflineCacheHome$lambda$5$1$2($state$delegate, $scope, $machine, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineCacheHome$lambda$5$1$2;
                }
            }, $composer, 54), $composer, 24960, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$1$0$0$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, ReserveInfo $reserveInfo) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageKt$OfflineCacheHome$4$2$1$1$1$1($machine, $reserveInfo, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$1$1$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageKt$OfflineCacheHome$4$2$2$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$1$2(State $state$delegate, CoroutineScope $scope, OfflineHomePageStateMachine $machine, RowScope $this$OfflinePageFooter, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageFooter, "$this$OfflinePageFooter");
        ComposerKt.sourceInformation($composer, "C*189@8437L57:OfflineHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(257210582, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHome.<anonymous>.<anonymous>.<anonymous> (OfflineHomePage.kt:188)");
            }
            Iterable $this$forEach$iv = OfflineCacheHome$lambda$1($state$delegate).getConfig().getFooterOperations();
            for (Object element$iv : $this$forEach$iv) {
                OfflinePageOperation operation = (OfflinePageOperation) element$iv;
                OfflineOperationComponentKt.mapToFooterComponent(operation, $scope, $machine, OfflineCacheHome$lambda$1($state$delegate).getSelectedCount(), $composer, OfflineHomePageStateMachine.$stable << 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$2(final State $state$delegate, final boolean $isEdit, final LazyListState $lazyListState, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, final Toaster $toaster, PaddingValues innerPadding, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding)200@8849L6,201@8876L2307,194@8590L2593:OfflineHomePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1760321918, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineCacheHome.<anonymous>.<anonymous> (OfflineHomePage.kt:194)");
            }
            ContentWithStateKt.ContentWithState(OfflineCacheHome$lambda$1($state$delegate).getDataState(), BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, innerPadding), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(350813315, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHome$lambda$5$2$0;
                    OfflineCacheHome$lambda$5$2$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$2$0($isEdit, $lazyListState, $scope, $machine, $state$delegate, $toaster, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHome$lambda$5$2$0;
                }
            }, $composer, 54), $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008c, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c9, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0108, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x014f, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineCacheHome$lambda$5$2$0(boolean $isEdit, LazyListState $lazyListState, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, final State $state$delegate, final Toaster $toaster, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C211@9356L151,216@9543L166,221@9749L170,226@9960L1190,202@8894L2275:OfflineHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(350813315, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHome.<anonymous>.<anonymous>.<anonymous> (OfflineHomePage.kt:202)");
            }
            List<OfflineDownloadingCardModel> downloading = OfflineCacheHome$lambda$1($state$delegate).getDownloading();
            List<OfflineCachedCardModel> completed = OfflineCacheHome$lambda$1($state$delegate).getCompleted();
            List<OfflinePageOperation> footerOperations = OfflineCacheHome$lambda$1($state$delegate).getConfig().getFooterOperations();
            Set<String> selected = OfflineCacheHome$lambda$1($state$delegate).selected();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 2124162138, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda26
                public final Object invoke() {
                    Unit OfflineCacheHome$lambda$5$2$0$0$0;
                    OfflineCacheHome$lambda$5$2$0$0$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$2$0$0$0($scope, $machine);
                    return OfflineCacheHome$lambda$5$2$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2124168137, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj) {
                    Unit OfflineCacheHome$lambda$5$2$0$1$0;
                    OfflineCacheHome$lambda$5$2$0$1$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$2$0$1$0($scope, $machine, (String) obj);
                    return OfflineCacheHome$lambda$5$2$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Function1 function1 = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2124174733, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj) {
                    Unit OfflineCacheHome$lambda$5$2$0$2$0;
                    OfflineCacheHome$lambda$5$2$0$2$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$2$0$2$0($scope, $machine, (String) obj);
                    return OfflineCacheHome$lambda$5$2$0$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            Function1 function12 = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2124182505, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($scope) | $composer.changed($state$delegate) | $composer.changedInstance($machine) | $composer.changedInstance($toaster);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHome$lambda$5$2$0$3$0;
                    OfflineCacheHome$lambda$5$2$0$3$0 = OfflineHomePageKt.OfflineCacheHome$lambda$5$2$0$3$0($scope, $machine, $state$delegate, $toaster, (String) obj, (OfflinePageOperation) obj2);
                    return OfflineCacheHome$lambda$5$2$0$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineCacheHomeList($isEdit, true, downloading, completed, footerOperations, $lazyListState, fillMaxSize$default, selected, null, function0, function1, function12, (Function2) it$iv4, $composer, 1572912, 0, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$2$0$0$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageKt$OfflineCacheHome$4$3$1$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$2$0$1$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageKt$OfflineCacheHome$4$3$1$2$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$2$0$2$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageKt$OfflineCacheHome$4$3$1$3$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHome$lambda$5$2$0$3$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, State $state$delegate, Toaster $toaster, String key, OfflinePageOperation operations) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(operations, "operations");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageKt$OfflineCacheHome$4$3$1$4$1$1(operations, key, $machine, $state$delegate, $toaster, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r9v12 */
    public static final void OfflineCacheHomeList(final boolean isEdit, final boolean addHeader, final List<OfflineDownloadingCardModel> list, final List<OfflineCachedCardModel> list2, final List<? extends OfflinePageOperation> list3, final LazyListState listState, Modifier modifier, Set<String> set, String emptyTip, Function0<Unit> function0, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, Function2<? super String, ? super OfflinePageOperation, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        final Set selected;
        String emptyTip2;
        Function0 onClickDownloading;
        Function1 onItemClick;
        Function1 onItemLongClick;
        Function2<? super String, ? super OfflinePageOperation, Unit> function22;
        Set selected2;
        String emptyTip3;
        int $dirty;
        Function0 onClickDownloading2;
        Function0 onClickDownloading3;
        Function1 onItemClick2;
        Function1 onItemClick3;
        Function1 onItemLongClick2;
        Set selected3;
        int $dirty2;
        String emptyTip4;
        int i2;
        Intrinsics.checkNotNullParameter(list, "downloading");
        Intrinsics.checkNotNullParameter(list2, "completed");
        Intrinsics.checkNotNullParameter(list3, "supportOperations");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Composer $composer3 = $composer.startRestartGroup(-1579945684);
        ComposerKt.sourceInformation($composer3, "C(OfflineCacheHomeList)N(isEdit,addHeader,downloading,completed,supportOperations,listState,modifier,selected,emptyTip,onClickDownloading,onItemClick,onItemLongClick,operationHandler)279@12064L30,280@12120L36,281@12182L25,282@12233L24,284@12314L2300,284@12263L2351:OfflineHomePage.kt#rawcr6");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(isEdit) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(addHeader) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(list) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changedInstance(list2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty3 |= $composer3.changedInstance(list3) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty3 |= $composer3.changed(listState) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer3.changedInstance(set) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            if ((i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0 && $composer3.changed(emptyTip)) {
                i2 = 67108864;
                $dirty3 |= i2;
            }
            i2 = 33554432;
            $dirty3 |= i2;
        }
        int i5 = i & 512;
        if (i5 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 536870912 : 268435456;
        }
        int i6 = i & 1024;
        if (i6 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        int i7 = i & IjkMediaMeta.FF_PROFILE_H264_INTRA;
        if (i7 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function12) ? 32 : 16;
        }
        int i8 = i & 4096;
        if (i8 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if ($composer3.shouldExecute((($dirty3 & 306783379) == 306783378 && ($dirty1 & 147) == 146) ? false : true, $dirty3 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "269@11749L2,270@11789L2,271@11833L2");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier;
                Set selected4 = i4 != 0 ? SetsKt.emptySet() : set;
                if ((i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0) {
                    selected2 = selected4;
                    emptyTip3 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2199(PlayerbaseresRes.INSTANCE.getString()));
                    $dirty3 &= -234881025;
                } else {
                    selected2 = selected4;
                    emptyTip3 = emptyTip;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, 2090635502, "CC(remember):OfflineHomePage.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    $dirty = $dirty3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    onClickDownloading2 = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    $dirty = $dirty3;
                    onClickDownloading2 = function0;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, 2090636782, "CC(remember):OfflineHomePage.kt#9igjgp");
                    Object it$iv2 = $composer3.rememberedValue();
                    onClickDownloading3 = onClickDownloading2;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                Unit OfflineCacheHomeList$lambda$1$0;
                                OfflineCacheHomeList$lambda$1$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$1$0((String) obj);
                                return OfflineCacheHomeList$lambda$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    onItemClick2 = it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onClickDownloading3 = onClickDownloading2;
                    onItemClick2 = function1;
                }
                if (i7 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, 2090638190, "CC(remember):OfflineHomePage.kt#9igjgp");
                    Object it$iv3 = $composer3.rememberedValue();
                    onItemClick3 = onItemClick2;
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                Unit OfflineCacheHomeList$lambda$2$0;
                                OfflineCacheHomeList$lambda$2$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$2$0((String) obj);
                                return OfflineCacheHomeList$lambda$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    onItemLongClick2 = it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onItemClick3 = onItemClick2;
                    onItemLongClick2 = function12;
                }
                if (i8 != 0) {
                    selected3 = selected2;
                    onClickDownloading = onClickDownloading3;
                    $dirty2 = $dirty;
                    onItemClick = onItemClick3;
                    onItemLongClick = onItemLongClick2;
                    function22 = null;
                    emptyTip4 = emptyTip3;
                    modifier2 = modifier3;
                } else {
                    selected3 = selected2;
                    onClickDownloading = onClickDownloading3;
                    $dirty2 = $dirty;
                    onItemClick = onItemClick3;
                    function22 = function2;
                    onItemLongClick = onItemLongClick2;
                    emptyTip4 = emptyTip3;
                    modifier2 = modifier3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0) {
                    $dirty3 &= -234881025;
                }
                modifier2 = modifier;
                selected3 = set;
                emptyTip4 = emptyTip;
                onClickDownloading = function0;
                onItemClick = function1;
                onItemLongClick = function12;
                function22 = function2;
                $dirty2 = $dirty3;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1579945684, $dirty2, $dirty1, "video.biz.offline.list.ui.page.OfflineCacheHomeList (OfflineHomePage.kt:273)");
            }
            if (list.isEmpty() && list2.isEmpty()) {
                $composer3.startReplaceGroup(385409302);
                ComposerKt.sourceInformation($composer3, "275@11977L33");
                OfflineEmptyPlaceholderKt.OfflineEmptyPlaceholder(emptyTip4, $composer3, ($dirty2 >> 24) & 14, 0);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final Set set2 = selected3;
                    final String str = emptyTip4;
                    final Function0 function02 = onClickDownloading;
                    final Function1 function13 = onItemClick;
                    final Function1 function14 = onItemLongClick;
                    final Function2<? super String, ? super OfflinePageOperation, Unit> function23 = function22;
                    endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj, Object obj2) {
                            Unit OfflineCacheHomeList$lambda$3;
                            OfflineCacheHomeList$lambda$3 = OfflineHomePageKt.OfflineCacheHomeList$lambda$3(isEdit, addHeader, list, list2, list3, listState, modifier4, set2, str, function02, function13, function14, function23, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                            return OfflineCacheHomeList$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty12 = $dirty1;
            int $dirty4 = $dirty2;
            emptyTip2 = emptyTip4;
            Set selected5 = selected3;
            $composer2 = $composer3;
            $composer2.startReplaceGroup(373535062);
            $composer2.endReplaceGroup();
            final SwipeCancellingToken swipeCancellingToken = SwipeActionKt.rememberSwipeCancellingToken($composer2, 0);
            SwipeActionKt.cancelOnLazyListScrolling(swipeCancellingToken, listState, $composer2, ($dirty4 >> 12) & 112);
            SwipeActionKt.cancelOnLifecyclePaused(swipeCancellingToken, $composer2, 0);
            OfflineSwipeActionExtKt.cancelOnEditMode(swipeCancellingToken, isEdit, $composer2, ($dirty4 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart($composer2, 2090655880, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | (($dirty4 & 14) == 4) | (($dirty4 & 1879048192) == 536870912) | $composer2.changedInstance(list2) | (($dirty4 & 112) == 32) | $composer2.changedInstance(swipeCancellingToken) | $composer2.changedInstance(list3) | (($dirty12 & 14) == 4) | (($dirty12 & 112) == 32) | (($dirty12 & 896) == 256) | $composer2.changedInstance(selected5);
            Object value$iv4 = $composer2.rememberedValue();
            if (invalid$iv || value$iv4 == Composer.Companion.getEmpty()) {
                final Function0 function03 = onClickDownloading;
                selected = selected5;
                final Function1 function15 = onItemClick;
                final Function1 function16 = onItemLongClick;
                final Function2<? super String, ? super OfflinePageOperation, Unit> function24 = function22;
                value$iv4 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit OfflineCacheHomeList$lambda$4$0;
                        OfflineCacheHomeList$lambda$4$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0(list, isEdit, list2, addHeader, function03, swipeCancellingToken, list3, function15, function16, function24, selected, (LazyListScope) obj);
                        return OfflineCacheHomeList$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                selected = selected5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier2, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv4, $composer2, (($dirty4 >> 18) & 14) | (($dirty4 >> 12) & 112), 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            selected = set;
            emptyTip2 = emptyTip;
            onClickDownloading = function0;
            onItemClick = function1;
            onItemLongClick = function12;
            function22 = function2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier2;
            final Set set3 = selected;
            final String str2 = emptyTip2;
            final Function0 function04 = onClickDownloading;
            final Function1 function17 = onItemClick;
            final Function1 function18 = onItemLongClick;
            final Function2<? super String, ? super OfflinePageOperation, Unit> function25 = function22;
            endRestartGroup2.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHomeList$lambda$5;
                    OfflineCacheHomeList$lambda$5 = OfflineHomePageKt.OfflineCacheHomeList$lambda$5(isEdit, addHeader, list, list2, list3, listState, modifier5, set3, str2, function04, function17, function18, function25, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHomeList$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0(final List $downloading, final boolean $isEdit, final List $completed, boolean $addHeader, final Function0 $onClickDownloading, final SwipeCancellingToken $swipeCancellingToken, final List $supportOperations, final Function1 $onItemClick, final Function1 $onItemLongClick, final Function2 $operationHandler, final Set $selected, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        if (!$downloading.isEmpty() && !$isEdit) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1580583516, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineCacheHomeList$lambda$4$0$0;
                    OfflineCacheHomeList$lambda$4$0$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0$0($isEdit, $downloading, $onClickDownloading, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineCacheHomeList$lambda$4$0$0;
                }
            }), 3, (Object) null);
        }
        if (!$completed.isEmpty()) {
            if ($addHeader) {
                LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$OfflineHomePageKt.INSTANCE.getLambda$931481774$ui_debug(), 3, (Object) null);
            }
            LazyListScope.-CC.items$default($this$LazyColumn, $completed.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1166719388, true, new Function4() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit OfflineCacheHomeList$lambda$4$0$1;
                    OfflineCacheHomeList$lambda$4$0$1 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0$1($completed, $swipeCancellingToken, $supportOperations, $isEdit, $onItemClick, $onItemLongClick, $operationHandler, $selected, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return OfflineCacheHomeList$lambda$4$0$1;
                }
            }), 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0$0(boolean $isEdit, List $downloading, Function0 $onClickDownloading, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C287@12402L189:OfflineHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580583516, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHomeList.<anonymous>.<anonymous>.<anonymous> (OfflineHomePage.kt:287)");
            }
            OfflineDownloadingSectionKt.OfflineDownloadingSection($isEdit, $downloading, $onClickDownloading, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0$1(final List $completed, SwipeCancellingToken $swipeCancellingToken, List $supportOperations, final boolean $isEdit, final Function1 $onItemClick, final Function1 $onItemLongClick, final Function2 $operationHandler, final Set $selected, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)321@13752L68,324@13856L72,327@13969L85,330@14074L510,316@13509L1075:OfflineHomePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1166719388, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineCacheHomeList.<anonymous>.<anonymous>.<anonymous> (OfflineHomePage.kt:315)");
            }
            final OfflineCachedCardModel item = (OfflineCachedCardModel) $completed.get(index);
            String id = item.getId();
            ComposerKt.sourceInformationMarkerStart($composer, 230877728, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onItemClick) | $composer.changedInstance(item);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit OfflineCacheHomeList$lambda$4$0$1$0$0;
                        OfflineCacheHomeList$lambda$4$0$1$0$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0$1$0$0($onItemClick, item);
                        return OfflineCacheHomeList$lambda$4$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 230881060, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onItemLongClick) | $composer.changedInstance(item);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit OfflineCacheHomeList$lambda$4$0$1$1$0;
                        OfflineCacheHomeList$lambda$4$0$1$1$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0$1$1$0($onItemLongClick, item);
                        return OfflineCacheHomeList$lambda$4$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function0 function02 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 230884689, "CC(remember):OfflineHomePage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($operationHandler) | $composer.changedInstance(item);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit OfflineCacheHomeList$lambda$4$0$1$2$0;
                        OfflineCacheHomeList$lambda$4$0$1$2$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0$1$2$0($operationHandler, item, (OfflinePageOperation) obj);
                        return OfflineCacheHomeList$lambda$4$0$1$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineListItem_androidKt.OfflineListItem(id, $swipeCancellingToken, $supportOperations, $isEdit, null, function0, function02, (Function1) it$iv3, ComposableLambdaKt.rememberComposableLambda(-1440145603, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHomeList$lambda$4$0$1$3;
                    OfflineCacheHomeList$lambda$4$0$1$3 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0$1$3(index, $completed, $isEdit, $selected, item, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHomeList$lambda$4$0$1$3;
                }
            }, $composer, 54), $composer, 100663296, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0$1$0$0(Function1 $onItemClick, OfflineCachedCardModel $item) {
        $onItemClick.invoke($item.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0$1$1$0(Function1 $onItemLongClick, OfflineCachedCardModel $item) {
        $onItemLongClick.invoke($item.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0$1$2$0(Function2 $operationHandler, OfflineCachedCardModel $item, OfflinePageOperation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ($operationHandler != null) {
            $operationHandler.invoke($item.getId(), it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0$1$3(int $index, List $completed, boolean $isEdit, Set $selected, final OfflineCachedCardModel $item, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C336@14370L196,332@14185L381:OfflineHomePage.kt#rawcr6");
        boolean z = false;
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1440145603, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHomeList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfflineHomePage.kt:331)");
            }
            if ($index != CollectionsKt.getLastIndex($completed) && $completed.size() > 1) {
                z = true;
            }
            final boolean showDivider = z;
            ContentWithCheckMarkKt.m2913ContentWithCheckMarkGHTll3U($isEdit, $selected.contains($item.getId()), null, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, null, ComposableLambdaKt.rememberComposableLambda(1499383763, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHomeList$lambda$4$0$1$3$0;
                    OfflineCacheHomeList$lambda$4$0$1$3$0 = OfflineHomePageKt.OfflineCacheHomeList$lambda$4$0$1$3$0(OfflineCachedCardModel.this, showDivider, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHomeList$lambda$4$0$1$3$0;
                }
            }, $composer, 54), $composer, 12585984, 116);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHomeList$lambda$4$0$1$3$0(OfflineCachedCardModel $item, boolean $showDivider, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C337@14396L148:OfflineHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1499383763, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHomeList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfflineHomePage.kt:337)");
            }
            OfflineCompletedCardKt.OfflineCompletedCard($item, null, $showDivider, $composer, OfflineCachedCardModel.$stable, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void PrepareBackHandler(final OfflineBaseListStateMachine machine, final boolean isEdit, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(machine, "machine");
        Composer $composer2 = $composer.startRestartGroup(-1323685405);
        ComposerKt.sourceInformation($composer2, "C(PrepareBackHandler)N(machine,isEdit)356@14766L24:OfflineHomePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(machine) : $composer2.changedInstance(machine) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isEdit) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1323685405, $dirty2, -1, "video.biz.offline.list.ui.page.PrepareBackHandler (OfflineHomePage.kt:355)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (isEdit) {
                $composer2.startReplaceGroup(-1817000250);
                ComposerKt.sourceInformation($composer2, "359@14852L54,360@14938L133,358@14817L265");
                NavigationEventState rememberNavigationEventState = RememberNavigationEventStateKt.rememberNavigationEventState(NavigationEventInfo.None.INSTANCE, (List) null, (List) null, $composer2, 6, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, -751345528, "CC(remember):OfflineHomePage.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer2.changedInstance(machine)));
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit PrepareBackHandler$lambda$0$0;
                            PrepareBackHandler$lambda$0$0 = OfflineHomePageKt.PrepareBackHandler$lambda$0$0(scope, machine);
                            return PrepareBackHandler$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                NavigationEventHandlerKt.NavigationBackHandler(rememberNavigationEventState, false, (Function0) null, (Function0) it$iv, $composer2, 0, 6);
            } else {
                $composer2.startReplaceGroup(-1831698497);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHomePageKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj, Object obj2) {
                    Unit PrepareBackHandler$lambda$1;
                    PrepareBackHandler$lambda$1 = OfflineHomePageKt.PrepareBackHandler$lambda$1(OfflineBaseListStateMachine.this, isEdit, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PrepareBackHandler$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrepareBackHandler$lambda$0$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHomePageKt$PrepareBackHandler$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}