package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridSpanKt;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
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
import kotlin.Metadata;
import kotlin.Unit;
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
import video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine;
import video.biz.offline.list.ui.widget.ContentWithStateKt;
import video.biz.offline.list.ui.widget.OfflineCompletedGridItemKt;
import video.biz.offline.list.ui.widget.OfflineDownloadingSectionKt;
import video.biz.offline.list.ui.widget.OfflineEmptyPlaceholderKt;
import video.biz.offline.list.ui.widget.OfflineOperationComponentKt;
import video.biz.offline.list.ui.widget.OfflinePageFooterKt;
import video.biz.offline.list.ui.widget.OfflinePageHeaderKt;
import video.biz.offline.list.ui.widget.OfflinePopupKt;

/* compiled from: OfflineHDHomePage.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a{\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0004\u0018\u0001`\n2(\b\u0002\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0004\u0018\u0001`\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u009d\u0001\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001d2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001d2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001dH\u0007¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002"}, d2 = {"OfflineHDHomePage", "", "(Landroidx/compose/runtime/Composer;I)V", "OfflineHDHomeView", "modifier", "Landroidx/compose/ui/Modifier;", "showBackIcon", "", "downloadingInterceptor", "Lkotlin/Function0;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDownloadingRouteInterceptor;", "downloadedInterceptor", "Lkotlin/Function3;", "", "Lvideo/biz/offline/list/logic/statemachine/OfflineDownloadedRouteInterceptor;", "backInterceptor", "Lvideo/biz/offline/list/logic/statemachine/OfflineBackInterceptor;", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OfflineCacheHDHomeList", "isEdit", "downloading", "", "Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;", "completed", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "selected", "", "onClickDownloading", "onItemClick", "Lkotlin/Function1;", "onItemLongClick", "onClickToDetail", "", "(ZLjava/util/List;Ljava/util/List;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "state", "Lvideo/biz/offline/list/logic/model/OfflinePageState;"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineHDHomePageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$4(boolean z, List list, List list2, Modifier modifier, Set set, Function0 function0, Function1 function1, Function1 function12, Function1 function13, int i, int i2, Composer composer, int i3) {
        OfflineCacheHDHomeList(z, list, list2, modifier, set, function0, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$6(boolean z, List list, List list2, Modifier modifier, Set set, Function0 function0, Function1 function1, Function1 function12, Function1 function13, int i, int i2, Composer composer, int i3) {
        OfflineCacheHDHomeList(z, list, list2, modifier, set, function0, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomePage$lambda$0(int i, Composer composer, int i2) {
        OfflineHDHomePage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$5(Modifier modifier, boolean z, Function0 function0, Function3 function3, Function0 function02, int i, int i2, Composer composer, int i3) {
        OfflineHDHomeView(modifier, z, function0, function3, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void OfflineHDHomePage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1511281654);
        ComposerKt.sourceInformation($composer2, "C(OfflineHDHomePage)70@3634L19:OfflineHDHomePage.kt#rawcr6");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1511281654, $changed, -1, "video.biz.offline.list.ui.page.OfflineHDHomePage (OfflineHDHomePage.kt:69)");
            }
            OfflineHDHomeView(null, false, null, null, null, $composer2, 0, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineHDHomePage$lambda$0;
                    OfflineHDHomePage$lambda$0 = OfflineHDHomePageKt.OfflineHDHomePage$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineHDHomePage$lambda$0;
                }
            });
        }
    }

    public static final void OfflineHDHomeView(Modifier modifier, boolean showBackIcon, Function0<Boolean> function0, Function3<? super String, ? super String, ? super String, Boolean> function3, Function0<Boolean> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Function0 function03;
        Function3<? super String, ? super String, ? super String, Boolean> function32;
        Function0 backInterceptor;
        Modifier modifier3;
        boolean showBackIcon2;
        Function0 downloadingInterceptor;
        Composer $composer2 = $composer.startRestartGroup(1770643566);
        ComposerKt.sourceInformation($composer2, "C(OfflineHDHomeView)N(modifier,showBackIcon,downloadingInterceptor,downloadedInterceptor,backInterceptor)81@3990L7,82@4014L24,84@4065L248,93@4345L45,94@4431L7,95@4464L331,95@4443L352,107@4821L137,107@4800L158,113@5005L4840,113@4995L4850:OfflineHDHomePage.kt#rawcr6");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            z = showBackIcon;
        } else if (($changed & 48) == 0) {
            z = showBackIcon;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = showBackIcon;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function03 = function0;
        } else if (($changed & 384) == 0) {
            function03 = function0;
            $dirty |= $composer2.changedInstance(function03) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            function03 = function0;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            function32 = function3;
        } else if (($changed & 3072) == 0) {
            function32 = function3;
            $dirty |= $composer2.changedInstance(function32) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            function32 = function3;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            backInterceptor = function02;
        } else if (($changed & 24576) == 0) {
            backInterceptor = function02;
            $dirty |= $composer2.changedInstance(backInterceptor) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            backInterceptor = function02;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            boolean showBackIcon3 = i3 != 0 ? false : z;
            Function0 downloadingInterceptor2 = i4 != 0 ? null : function03;
            if (i5 != 0) {
                function32 = null;
            }
            if (i6 != 0) {
                backInterceptor = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1770643566, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView (OfflineHDHomePage.kt:80)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Router router = (Router) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 781430630, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new OfflineHomePageStateMachine(OfflinePageStateKt.offlineHomePageInitialState(), router, scope, downloadingInterceptor2, function32);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final OfflineHomePageStateMachine machine = (OfflineHomePageStateMachine) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State state$delegate = SnapshotStateKt.collectAsState(machine.getState(), OfflinePageStateKt.offlineHomePageInitialState(), (CoroutineContext) null, $composer2, OfflinePageState.$stable << 3, 2);
            CompositionLocal this_$iv2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            downloadingInterceptor = downloadingInterceptor2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle = (LifecycleOwner) consume2;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 781443481, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(lifecycle);
            OfflineHDHomePageKt$OfflineHDHomeView$1$1 value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new OfflineHDHomePageKt$OfflineHDHomeView$1$1(lifecycle, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 781454711, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(machine);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new OfflineHDHomePageKt$OfflineHDHomeView$2$1(lifecycle, machine, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv2, $composer2, 6);
            final boolean isEdit = OfflineHDHomeView$lambda$1(state$delegate).isEdit();
            final Modifier modifier5 = modifier4;
            final boolean z2 = showBackIcon3;
            final Function0 function04 = backInterceptor;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(718343606, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineHDHomeView$lambda$4;
                    OfflineHDHomeView$lambda$4 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4(modifier5, machine, z2, function04, isEdit, scope, state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineHDHomeView$lambda$4;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            showBackIcon2 = showBackIcon3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            showBackIcon2 = z;
            downloadingInterceptor = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z3 = showBackIcon2;
            final Function0 function05 = downloadingInterceptor;
            final Function3<? super String, ? super String, ? super String, Boolean> function33 = function32;
            final Function0 function06 = backInterceptor;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineHDHomeView$lambda$5;
                    OfflineHDHomeView$lambda$5 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$5(modifier6, z3, function05, function33, function06, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineHDHomeView$lambda$5;
                }
            });
        }
    }

    private static final OfflinePageState OfflineHDHomeView$lambda$1(State<OfflinePageState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflinePageState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4(Modifier $modifier, final OfflineHomePageStateMachine $machine, final boolean $showBackIcon, final Function0 $backInterceptor, final boolean $isEdit, final CoroutineScope $scope, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C114@5032L28,115@5080L20,119@5174L797,137@5997L2308,186@8317L1458,117@5110L4665,225@9800L39:OfflineHDHomePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(718343606, $changed, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView.<anonymous> (OfflineHDHomePage.kt:114)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            ScaffoldKt.Scaffold-TvnljyQ($modifier, ComposableLambdaKt.rememberComposableLambda(970803834, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineHDHomeView$lambda$4$0;
                    OfflineHDHomeView$lambda$4$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$0($showBackIcon, $backInterceptor, $isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineHDHomeView$lambda$4$0;
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(-69488005, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineHDHomeView$lambda$4$1;
                    OfflineHDHomeView$lambda$4$1 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$1($isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineHDHomeView$lambda$4$1;
                }
            }, $composer, 54), (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(940656453, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineHDHomeView$lambda$4$2;
                    OfflineHDHomeView$lambda$4$2 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$2($state$delegate, $isEdit, $scope, $machine, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineHDHomeView$lambda$4$2;
                }
            }, $composer, 54), $composer, 805306800, 504);
            OfflinePopupKt.OfflinePopup(OfflineHDHomeView$lambda$1($state$delegate).getDialogType(), $machine, $composer, OfflineHomePageStateMachine.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$0(boolean $showBackIcon, Function0 $backInterceptor, final boolean $isEdit, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C125@5518L9,127@5606L351,120@5192L765:OfflineHDHomePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(970803834, $changed, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView.<anonymous>.<anonymous> (OfflineHDHomePage.kt:120)");
            }
            OfflinePageHeaderKt.m2949OfflinePageHeaderGmEhDVc(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_60(PlayerbaseresRes.INSTANCE.getString())), SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), $showBackIcon, false, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT17(), $backInterceptor, ComposableLambdaKt.rememberComposableLambda(1126747870, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineHDHomeView$lambda$4$0$0;
                    OfflineHDHomeView$lambda$4$0$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$0$0($isEdit, $scope, $machine, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineHDHomeView$lambda$4$0$0;
                }
            }, $composer, 54), $composer, 100666416, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$0$0(boolean $isEdit, CoroutineScope $scope, OfflineHomePageStateMachine $machine, State $state$delegate, RowScope $this$OfflinePageHeader, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageHeader, "$this$OfflinePageHeader");
        ComposerKt.sourceInformation($composer, "C:OfflineHDHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1126747870, $changed, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView.<anonymous>.<anonymous>.<anonymous> (OfflineHDHomePage.kt:128)");
            }
            if ($isEdit) {
                $composer.startReplaceGroup(1776413512);
                ComposerKt.sourceInformation($composer, "129@5666L44");
                OfflinePageHeaderKt.OfflineHeaderCancelOperation($scope, $machine, $composer, OfflineHomePageStateMachine.$stable << 3);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1776514107);
                ComposerKt.sourceInformation($composer, "*132@5855L36");
                Iterable $this$forEach$iv = OfflineHDHomeView$lambda$1($state$delegate).getConfig().getHeaderOperations();
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
    public static final Unit OfflineHDHomeView$lambda$4$1(boolean $isEdit, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        boolean z;
        ComposerKt.sourceInformation($composer, "C175@7898L167,180@8085L206,171@7670L621:OfflineHDHomePage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-69488005, $changed, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView.<anonymous>.<anonymous> (OfflineHDHomePage.kt:138)");
            }
            StorageInfoModel storageInfo = OfflineHDHomeView$lambda$1($state$delegate).getStorageInfo();
            final ReserveInfo reserveInfo = OfflineHDHomeView$lambda$1($state$delegate).getReserveInfo();
            if (!$isEdit) {
                $composer.startReplaceGroup(57260790);
                ComposerKt.sourceInformation($composer, "145@6335L12,147@6461L17,141@6154L1445");
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
                ComposerKt.sourceInformationMarkerStart($composer, -1171559725, "C:OfflineHDHomePage.kt#rawcr6");
                if (reserveInfo == null || !reserveInfo.getHasReserve()) {
                    z = false;
                    $composer.startReplaceGroup(-1178119946);
                } else {
                    $composer.startReplaceGroup(-1171526680);
                    ComposerKt.sourceInformation($composer, "153@6788L217,151@6662L374");
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1347686917, "CC(remember):OfflineHDHomePage.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine) | $composer.changedInstance(reserveInfo);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit OfflineHDHomeView$lambda$4$1$0$0$0;
                            OfflineHDHomeView$lambda$4$1$0$0$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$1$0$0$0($scope, $machine, reserveInfo);
                            return OfflineHDHomeView$lambda$4$1$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    z = false;
                    OfflinePageFooterKt.OfflineReserve(fillMaxWidth$default, (Function0) it$iv, $composer, 6, 0);
                }
                $composer.endReplaceGroup();
                boolean listEmpty = (OfflineHDHomeView$lambda$1($state$delegate).getCompleted().isEmpty() && OfflineHDHomeView$lambda$1($state$delegate).getDownloading().isEmpty()) ? true : z;
                if (storageInfo != null && storageInfo.getShowStorageUsage()) {
                    z = true;
                }
                if (!z || listEmpty) {
                    $composer.startReplaceGroup(-1178119946);
                } else {
                    $composer.startReplaceGroup(-1170925466);
                    ComposerKt.sourceInformation($composer, "162@7271L280");
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
            $composer.startReplaceGroup(51129703);
            $composer.endReplaceGroup();
            int size = OfflineHDHomeView$lambda$1($state$delegate).selected().size();
            int size2 = OfflineHDHomeView$lambda$1($state$delegate).getCompleted().size();
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1941564930, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit OfflineHDHomeView$lambda$4$1$1$0;
                        OfflineHDHomeView$lambda$4$1$1$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$1$1$0($scope, $machine);
                        return OfflineHDHomeView$lambda$4$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflinePageFooterKt.OfflinePageFooter(size, size2, fillMaxWidth$default2, (Function0) it$iv2, ComposableLambdaKt.rememberComposableLambda(1954148209, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineHDHomeView$lambda$4$1$2;
                    OfflineHDHomeView$lambda$4$1$2 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$1$2($state$delegate, $scope, $machine, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineHDHomeView$lambda$4$1$2;
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
    public static final Unit OfflineHDHomeView$lambda$4$1$0$0$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, ReserveInfo $reserveInfo) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHDHomePageKt$OfflineHDHomeView$3$2$1$1$1$1($machine, $reserveInfo, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$1$1$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHDHomePageKt$OfflineHDHomeView$3$2$2$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$1$2(State $state$delegate, CoroutineScope $scope, OfflineHomePageStateMachine $machine, RowScope $this$OfflinePageFooter, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageFooter, "$this$OfflinePageFooter");
        ComposerKt.sourceInformation($composer, "C*182@8194L57:OfflineHDHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1954148209, $changed, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView.<anonymous>.<anonymous>.<anonymous> (OfflineHDHomePage.kt:181)");
            }
            Iterable $this$forEach$iv = OfflineHDHomeView$lambda$1($state$delegate).getConfig().getFooterOperations();
            for (Object element$iv : $this$forEach$iv) {
                OfflinePageOperation operation = (OfflinePageOperation) element$iv;
                OfflineOperationComponentKt.mapToFooterComponent(operation, $scope, $machine, OfflineHDHomeView$lambda$1($state$delegate).getSelectedCount(), $composer, OfflineHomePageStateMachine.$stable << 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$2(final State $state$delegate, final boolean $isEdit, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, PaddingValues innerPadding, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding)193@8606L6,194@8633L1132,187@8347L1418:OfflineHDHomePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(940656453, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView.<anonymous>.<anonymous> (OfflineHDHomePage.kt:187)");
            }
            ContentWithStateKt.ContentWithState(OfflineHDHomeView$lambda$1($state$delegate).getDataState(), BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, innerPadding), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(-813346972, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineHDHomeView$lambda$4$2$0;
                    OfflineHDHomeView$lambda$4$2$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$2$0($isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineHDHomeView$lambda$4$2$0;
                }
            }, $composer, 54), $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e2, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x011d, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineHDHomeView$lambda$4$2$0(boolean $isEdit, final CoroutineScope $scope, final OfflineHomePageStateMachine $machine, State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C201@8959L151,206@9146L166,211@9352L170,216@9562L170,195@8651L1100:OfflineHDHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-813346972, $changed, -1, "video.biz.offline.list.ui.page.OfflineHDHomeView.<anonymous>.<anonymous>.<anonymous> (OfflineHDHomePage.kt:195)");
            }
            List<OfflineDownloadingCardModel> downloading = OfflineHDHomeView$lambda$1($state$delegate).getDownloading();
            List<OfflineCachedCardModel> completed = OfflineHDHomeView$lambda$1($state$delegate).getCompleted();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            Set<String> selected = OfflineHDHomeView$lambda$1($state$delegate).selected();
            ComposerKt.sourceInformationMarkerStart($composer, 57618363, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        Unit OfflineHDHomeView$lambda$4$2$0$0$0;
                        OfflineHDHomeView$lambda$4$2$0$0$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$2$0$0$0($scope, $machine);
                        return OfflineHDHomeView$lambda$4$2$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 57624362, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda26
                    public final Object invoke(Object obj) {
                        Unit OfflineHDHomeView$lambda$4$2$0$1$0;
                        OfflineHDHomeView$lambda$4$2$0$1$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$2$0$1$0($scope, $machine, (String) obj);
                        return OfflineHDHomeView$lambda$4$2$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function1 function1 = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 57630958, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj) {
                    Unit OfflineHDHomeView$lambda$4$2$0$2$0;
                    OfflineHDHomeView$lambda$4$2$0$2$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$2$0$2$0($scope, $machine, (String) obj);
                    return OfflineHDHomeView$lambda$4$2$0$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            Function1 function12 = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 57637678, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit OfflineHDHomeView$lambda$4$2$0$3$0;
                    OfflineHDHomeView$lambda$4$2$0$3$0 = OfflineHDHomePageKt.OfflineHDHomeView$lambda$4$2$0$3$0($scope, $machine, ((Long) obj).longValue());
                    return OfflineHDHomeView$lambda$4$2$0$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineCacheHDHomeList($isEdit, downloading, completed, fillMaxSize$default, selected, function0, function1, function12, (Function1) it$iv4, $composer, 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$2$0$0$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHDHomePageKt$OfflineHDHomeView$3$3$1$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$2$0$1$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHDHomePageKt$OfflineHDHomeView$3$3$1$2$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$2$0$2$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHDHomePageKt$OfflineHDHomeView$3$3$1$3$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHDHomeView$lambda$4$2$0$3$0(CoroutineScope $scope, OfflineHomePageStateMachine $machine, long it) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineHDHomePageKt$OfflineHDHomeView$3$3$1$4$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$3$0(long it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v16 */
    public static final void OfflineCacheHDHomeList(final boolean isEdit, final List<OfflineDownloadingCardModel> list, final List<OfflineCachedCardModel> list2, Modifier modifier, Set<String> set, Function0<Unit> function0, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, Function1<? super Long, Unit> function13, Composer $composer, final int $changed, final int i) {
        Function0 function02;
        Composer $composer2;
        Modifier modifier2;
        Set selected;
        Function1<? super String, Unit> function14;
        Function1<? super String, Unit> function15;
        Function1<? super Long, Unit> function16;
        Function0 onClickDownloading;
        Intrinsics.checkNotNullParameter(list, "downloading");
        Intrinsics.checkNotNullParameter(list2, "completed");
        Composer $composer3 = $composer.startRestartGroup(751533287);
        ComposerKt.sourceInformation($composer3, "C(OfflineCacheHDHomeList)N(isEdit,downloading,completed,modifier,selected,onClickDownloading,onItemClick,onItemLongClick,onClickToDetail)237@10160L2,238@10200L2,239@10244L2,240@10286L2,251@10618L1609,246@10409L1818:OfflineHDHomePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isEdit) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(list2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(modifier) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(set) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= 196608;
            function02 = function0;
        } else if ((196608 & $changed) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 131072 : 65536;
        } else {
            function02 = function0;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 8388608 : 4194304;
        }
        int i7 = i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function13) ? 67108864 : 33554432;
        }
        if ($composer3.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            Set selected2 = i3 != 0 ? SetsKt.emptySet() : set;
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 668991337, "CC(remember):OfflineHDHomePage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClickDownloading2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onClickDownloading = onClickDownloading2;
            } else {
                onClickDownloading = function02;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 668992617, "CC(remember):OfflineHDHomePage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit OfflineCacheHDHomeList$lambda$1$0;
                            OfflineCacheHDHomeList$lambda$1$0 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$1$0((String) obj);
                            return OfflineCacheHDHomeList$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function14 = it$iv2;
            } else {
                function14 = function1;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 668994025, "CC(remember):OfflineHDHomePage.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Unit OfflineCacheHDHomeList$lambda$2$0;
                            OfflineCacheHDHomeList$lambda$2$0 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$2$0((String) obj);
                            return OfflineCacheHDHomeList$lambda$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function15 = it$iv3;
            } else {
                function15 = function12;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 668995369, "CC(remember):OfflineHDHomePage.kt#9igjgp");
                Object it$iv4 = $composer3.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            Unit OfflineCacheHDHomeList$lambda$3$0;
                            OfflineCacheHDHomeList$lambda$3$0 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$3$0(((Long) obj).longValue());
                            return OfflineCacheHDHomeList$lambda$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function16 = it$iv4;
            } else {
                function16 = function13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(751533287, $dirty, -1, "video.biz.offline.list.ui.page.OfflineCacheHDHomeList (OfflineHDHomePage.kt:241)");
            }
            if (list.isEmpty() && list2.isEmpty()) {
                $composer3.startReplaceGroup(-735916861);
                ComposerKt.sourceInformation($composer3, "243@10358L25");
                OfflineEmptyPlaceholderKt.OfflineEmptyPlaceholder(null, $composer3, 0, 1);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final Set<String> set2 = selected2;
                    final Function0 function03 = onClickDownloading;
                    final Function1<? super String, Unit> function17 = function14;
                    final Function1<? super String, Unit> function18 = function15;
                    final Function1<? super Long, Unit> function19 = function16;
                    endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2) {
                            Unit OfflineCacheHDHomeList$lambda$4;
                            OfflineCacheHDHomeList$lambda$4 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$4(isEdit, list, list2, modifier3, set2, function03, function17, function18, function19, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return OfflineCacheHDHomeList$lambda$4;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty2 = $dirty;
            final Set selected3 = selected2;
            $composer3.startReplaceGroup(-746184805);
            $composer3.endReplaceGroup();
            GridCells fixed = new GridCells.Fixed(3);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer3, 669007600, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(list) | (($dirty2 & 14) == 4) | (($dirty2 & 458752) == 131072) | $composer3.changedInstance(list2) | $composer3.changedInstance(selected3) | (($dirty2 & 29360128) == 8388608) | (($dirty2 & 3670016) == 1048576) | (($dirty2 & 234881024) == 67108864);
            Object value$iv5 = $composer3.rememberedValue();
            if (invalid$iv || value$iv5 == Composer.Companion.getEmpty()) {
                final Function0 function04 = onClickDownloading;
                final Function1<? super String, Unit> function110 = function15;
                final Function1<? super String, Unit> function111 = function14;
                selected = selected3;
                final Function1<? super Long, Unit> function112 = function16;
                value$iv5 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit OfflineCacheHDHomeList$lambda$5$0;
                        OfflineCacheHDHomeList$lambda$5$0 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$5$0(list, isEdit, list2, function04, selected3, function110, function111, function112, (LazyGridScope) obj);
                        return OfflineCacheHDHomeList$lambda$5$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
            } else {
                selected = selected3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyGridDslKt.LazyVerticalGrid(fixed, modifier2, (LazyGridState) null, (PaddingValues) null, false, vertical, horizontal, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv5, $composer2, (($dirty2 >> 6) & 112) | 1769472, 0, 924);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            selected = set;
            function14 = function1;
            function15 = function12;
            function16 = function13;
            onClickDownloading = function02;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier4 = modifier2;
            final Set set3 = selected;
            final Function0 function05 = onClickDownloading;
            final Function1<? super String, Unit> function113 = function14;
            final Function1<? super String, Unit> function114 = function15;
            final Function1<? super Long, Unit> function115 = function16;
            endRestartGroup2.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCacheHDHomeList$lambda$6;
                    OfflineCacheHDHomeList$lambda$6 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$6(isEdit, list, list2, modifier4, set3, function05, function113, function114, function115, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCacheHDHomeList$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$5$0(final List $downloading, final boolean $isEdit, final List $completed, final Function0 $onClickDownloading, final Set $selected, final Function1 $onItemLongClick, final Function1 $onItemClick, final Function1 $onClickToDetail, LazyGridScope $this$LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
        if (!$downloading.isEmpty() && !$isEdit) {
            LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    GridItemSpan OfflineCacheHDHomeList$lambda$5$0$0;
                    OfflineCacheHDHomeList$lambda$5$0$0 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$5$0$0((LazyGridItemSpanScope) obj);
                    return OfflineCacheHDHomeList$lambda$5$0$0;
                }
            }, (Object) null, ComposableLambdaKt.composableLambdaInstance(559838456, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineCacheHDHomeList$lambda$5$0$1;
                    OfflineCacheHDHomeList$lambda$5$0$1 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$5$0$1($isEdit, $downloading, $onClickDownloading, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineCacheHDHomeList$lambda$5$0$1;
                }
            }), 5, (Object) null);
        }
        if (!$completed.isEmpty()) {
            LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, new Function1() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj) {
                    GridItemSpan OfflineCacheHDHomeList$lambda$5$0$2;
                    OfflineCacheHDHomeList$lambda$5$0$2 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$5$0$2((LazyGridItemSpanScope) obj);
                    return OfflineCacheHDHomeList$lambda$5$0$2;
                }
            }, (Object) null, ComposableSingletons$OfflineHDHomePageKt.INSTANCE.getLambda$1904004513$ui_debug(), 5, (Object) null);
        }
        LazyGridScope.-CC.items$default($this$LazyVerticalGrid, $completed.size(), (Function1) null, (Function2) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1534466604, true, new Function4() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit OfflineCacheHDHomeList$lambda$5$0$3;
                OfflineCacheHDHomeList$lambda$5$0$3 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$5$0$3($completed, $isEdit, $selected, $onItemLongClick, $onItemClick, $onClickToDetail, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return OfflineCacheHDHomeList$lambda$5$0$3;
            }
        }), 14, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan OfflineCacheHDHomeList$lambda$5$0$0(LazyGridItemSpanScope $this$item) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        return GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$5$0$1(boolean $isEdit, List $downloading, Function0 $onClickDownloading, LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C254@10734L189:OfflineHDHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(559838456, $changed, -1, "video.biz.offline.list.ui.page.OfflineCacheHDHomeList.<anonymous>.<anonymous>.<anonymous> (OfflineHDHomePage.kt:254)");
            }
            OfflineDownloadingSectionKt.OfflineDownloadingSection($isEdit, $downloading, $onClickDownloading, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan OfflineCacheHDHomeList$lambda$5$0$2(LazyGridItemSpanScope $this$item) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        return GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$5$0$3(List $completed, boolean $isEdit, Set $selected, final Function1 $onItemLongClick, final Function1 $onItemClick, Function1 $onClickToDetail, LazyGridItemScope $this$items, int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)288@12042L80,285@11926L76,279@11675L536:OfflineHDHomePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1534466604, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineCacheHDHomeList.<anonymous>.<anonymous>.<anonymous> (OfflineHDHomePage.kt:278)");
            }
            final OfflineCachedCardModel item = (OfflineCachedCardModel) $completed.get(index);
            boolean contains = $selected.contains(item.getId());
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 1448637756, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onItemLongClick) | $composer.changedInstance(item);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        Unit OfflineCacheHDHomeList$lambda$5$0$3$0$0;
                        OfflineCacheHDHomeList$lambda$5$0$3$0$0 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$5$0$3$0$0($onItemLongClick, item);
                        return OfflineCacheHDHomeList$lambda$5$0$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1448634040, "CC(remember):OfflineHDHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onItemClick) | $composer.changedInstance(item);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineHDHomePageKt$$ExternalSyntheticLambda24
                    public final Object invoke() {
                        Unit OfflineCacheHDHomeList$lambda$5$0$3$1$0;
                        OfflineCacheHDHomeList$lambda$5$0$3$1$0 = OfflineHDHomePageKt.OfflineCacheHDHomeList$lambda$5$0$3$1$0($onItemClick, item);
                        return OfflineCacheHDHomeList$lambda$5$0$3$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineCompletedGridItemKt.OfflineCompletedGridItem(item, $isEdit, contains, ClickableKt.combinedClickable-hoGz1lA$default(modifier, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (MutableInteractionSource) null, (Function0) it$iv2, 239, (Object) null), $onClickToDetail, $composer, OfflineCachedCardModel.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$5$0$3$1$0(Function1 $onItemClick, OfflineCachedCardModel $item) {
        $onItemClick.invoke($item.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCacheHDHomeList$lambda$5$0$3$0$0(Function1 $onItemLongClick, OfflineCachedCardModel $item) {
        $onItemLongClick.invoke($item.getId());
        return Unit.INSTANCE;
    }
}