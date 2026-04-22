package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String0_commonMainKt;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.common.swipe.SwipeActionKt;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.Collection;
import java.util.Iterator;
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
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.list.logic.model.OfflineDownloadingCardModel;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine;
import video.biz.offline.list.ui.widget.ContentWithCheckMarkKt;
import video.biz.offline.list.ui.widget.ContentWithStateKt;
import video.biz.offline.list.ui.widget.OfflineDownloadingCardKt;
import video.biz.offline.list.ui.widget.OfflineEmptyPlaceholderKt;
import video.biz.offline.list.ui.widget.OfflineListItem_androidKt;
import video.biz.offline.list.ui.widget.OfflineOperationComponentKt;
import video.biz.offline.list.ui.widget.OfflinePageFooterKt;
import video.biz.offline.list.ui.widget.OfflinePageHeaderKt;
import video.biz.offline.list.ui.widget.OfflinePopupKt;
import video.biz.offline.list.ui.widget.OfflineSwipeActionExtKt;

/* compiled from: OfflineDownloadingPage.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aC\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0007¢\u0006\u0002\u0010\r\u001aÙ\u0001\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u001b2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u001b2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u001b2\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010!H\u0003¢\u0006\u0002\u0010\"¨\u0006#²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"OfflineDownloadingPage", "", "(Landroidx/compose/runtime/Composer;I)V", "OfflineDownloadingView", "modifier", "Landroidx/compose/ui/Modifier;", "fitsSystemBar", "", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "backInterceptor", "Lkotlin/Function0;", "Lvideo/biz/offline/list/logic/statemachine/OfflineBackInterceptor;", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OfflineDownloadingList", "isEdit", "downloading", "", "Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;", "supportOperations", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "maxConcurrent", "", "selected", "", "", "onClickStartOrPauseAll", "Lkotlin/Function1;", "onClickMaxConcurrent", "onItemClick", "onItemLongClick", "onItemCoverClick", "operationHandler", "Lkotlin/Function2;", "(ZLjava/util/List;Ljava/util/List;ILandroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "ui_debug", "state", "Lvideo/biz/offline/list/logic/model/OfflinePageState;"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDownloadingPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$5(boolean z, List list, List list2, int i, Modifier modifier, Set set, Function1 function1, Function0 function0, Function1 function12, Function1 function13, Function1 function14, Function2 function2, int i2, int i3, int i4, Composer composer, int i5) {
        OfflineDownloadingList(z, list, list2, i, modifier, set, function1, function0, function12, function13, function14, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$7(boolean z, List list, List list2, int i, Modifier modifier, Set set, Function1 function1, Function0 function0, Function1 function12, Function1 function13, Function1 function14, Function2 function2, int i2, int i3, int i4, Composer composer, int i5) {
        OfflineDownloadingList(z, list, list2, i, modifier, set, function1, function0, function12, function13, function14, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingPage$lambda$0(int i, Composer composer, int i2) {
        OfflineDownloadingPage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$4(Modifier modifier, boolean z, TextStyle textStyle, Function0 function0, int i, int i2, Composer composer, int i3) {
        OfflineDownloadingView(modifier, z, textStyle, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void OfflineDownloadingPage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-2122330938);
        ComposerKt.sourceInformation($composer2, "C(OfflineDownloadingPage)78@4055L24:OfflineDownloadingPage.kt#rawcr6");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2122330938, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingPage (OfflineDownloadingPage.kt:77)");
            }
            OfflineDownloadingView(null, false, null, null, $composer2, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda32
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingPage$lambda$0;
                    OfflineDownloadingPage$lambda$0 = OfflineDownloadingPageKt.OfflineDownloadingPage$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingPage$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OfflineDownloadingView(Modifier modifier, boolean fitsSystemBar, TextStyle titleTextStyle, Function0<Boolean> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        TextStyle textStyle;
        Function0 function02;
        Modifier modifier3;
        TextStyle titleTextStyle2;
        Function0 backInterceptor;
        boolean fitsSystemBar2;
        TextStyle titleTextStyle3;
        int $dirty;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-959950107);
        ComposerKt.sourceInformation($composer2, "C(OfflineDownloadingView)N(modifier,fitsSystemBar,titleTextStyle,backInterceptor)88@4337L7,89@4376L7,90@4400L24,92@4451L183,100@4667L52,101@4745L193,101@4724L214,110@4975L35,111@5025L5121,111@5015L5131:OfflineDownloadingPage.kt#rawcr6");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            z = fitsSystemBar;
        } else if (($changed & 48) == 0) {
            z = fitsSystemBar;
            $dirty2 |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = fitsSystemBar;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                textStyle = titleTextStyle;
                if ($composer2.changed(textStyle)) {
                    i2 = IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                    $dirty2 |= i2;
                }
            } else {
                textStyle = titleTextStyle;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            textStyle = titleTextStyle;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            function02 = function0;
        } else if (($changed & 3072) == 0) {
            function02 = function0;
            $dirty2 |= $composer2.changedInstance(function02) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            function02 = function0;
        }
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "85@4235L9");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
                boolean fitsSystemBar3 = i4 != 0 ? true : z;
                if ((i & 4) != 0) {
                    titleTextStyle3 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT17b();
                    $dirty2 &= -897;
                } else {
                    titleTextStyle3 = textStyle;
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    fitsSystemBar2 = fitsSystemBar3;
                    titleTextStyle2 = titleTextStyle3;
                    backInterceptor = null;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    titleTextStyle2 = titleTextStyle3;
                    backInterceptor = function02;
                    fitsSystemBar2 = fitsSystemBar3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                titleTextStyle2 = textStyle;
                backInterceptor = function02;
                fitsSystemBar2 = z;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-959950107, $dirty, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView (OfflineDownloadingPage.kt:87)");
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
            Toaster toaster = (Toaster) consume2;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 905927388, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new OfflineDownloadingPageStateMachine(OfflinePageStateKt.offlineDownloadingPageInitialState(), router, scope);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final OfflineDownloadingPageStateMachine machine = (OfflineDownloadingPageStateMachine) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State state$delegate = SnapshotStateKt.collectAsState(machine.getState(), OfflinePageStateKt.offlineDownloadingPageInitialState(), (CoroutineContext) null, $composer2, OfflinePageState.$stable << 3, 2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 905936806, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(machine) | $composer2.changedInstance(toaster);
            Object it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
                final boolean isEdit = OfflineDownloadingView$lambda$1(state$delegate).isEdit();
                OfflineHomePageKt.PrepareBackHandler(machine, isEdit, $composer2, OfflineDownloadingPageStateMachine.$stable);
                final Modifier modifier5 = modifier3;
                final boolean z2 = fitsSystemBar2;
                final TextStyle textStyle2 = titleTextStyle2;
                final Function0 function03 = backInterceptor;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-2012250067, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit OfflineDownloadingView$lambda$3;
                        OfflineDownloadingView$lambda$3 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3(modifier5, machine, isEdit, z2, textStyle2, function03, scope, state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                        return OfflineDownloadingView$lambda$3;
                    }
                }, $composer2, 54), $composer2, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv2 = (Function2) new OfflineDownloadingPageKt$OfflineDownloadingView$1$1(machine, toaster, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            final boolean isEdit2 = OfflineDownloadingView$lambda$1(state$delegate).isEdit();
            OfflineHomePageKt.PrepareBackHandler(machine, isEdit2, $composer2, OfflineDownloadingPageStateMachine.$stable);
            final Modifier modifier52 = modifier3;
            final boolean z22 = fitsSystemBar2;
            final TextStyle textStyle22 = titleTextStyle2;
            final Function0 function032 = backInterceptor;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-2012250067, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingView$lambda$3;
                    OfflineDownloadingView$lambda$3 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3(modifier52, machine, isEdit2, z22, textStyle22, function032, scope, state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingView$lambda$3;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            titleTextStyle2 = textStyle;
            backInterceptor = function02;
            fitsSystemBar2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z3 = fitsSystemBar2;
            final TextStyle textStyle3 = titleTextStyle2;
            final Function0 function04 = backInterceptor;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingView$lambda$4;
                    OfflineDownloadingView$lambda$4 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$4(modifier6, z3, textStyle3, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingView$lambda$4;
                }
            });
        }
    }

    private static final OfflinePageState OfflineDownloadingView$lambda$1(State<OfflinePageState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflinePageState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3(Modifier $modifier, final OfflineDownloadingPageStateMachine $machine, final boolean $isEdit, final boolean $fitsSystemBar, final TextStyle $titleTextStyle, final Function0 $backInterceptor, final CoroutineScope $scope, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C112@5052L28,113@5100L20,117@5194L872,138@6092L1571,172@7675L2401,115@5130L4946,232@10101L39:OfflineDownloadingPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2012250067, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView.<anonymous> (OfflineDownloadingPage.kt:112)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            ScaffoldKt.Scaffold-TvnljyQ($modifier, ComposableLambdaKt.rememberComposableLambda(-1759789839, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingView$lambda$3$0;
                    OfflineDownloadingView$lambda$3$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$0($isEdit, $fitsSystemBar, $titleTextStyle, $backInterceptor, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingView$lambda$3$0;
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(1494885618, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingView$lambda$3$1;
                    OfflineDownloadingView$lambda$3$1 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$1($isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingView$lambda$3$1;
                }
            }, $composer, 54), (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1789937220, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineDownloadingView$lambda$3$2;
                    OfflineDownloadingView$lambda$3$2 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2($state$delegate, $isEdit, $scope, $machine, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineDownloadingView$lambda$3$2;
                }
            }, $composer, 54), $composer, 805306800, 504);
            OfflinePopupKt.OfflinePopup(OfflineDownloadingView$lambda$1($state$delegate).getDialogType(), $machine, $composer, OfflineDownloadingPageStateMachine.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$0(final boolean $isEdit, boolean $fitsSystemBar, TextStyle $titleTextStyle, Function0 $backInterceptor, final CoroutineScope $scope, final OfflineDownloadingPageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C128@5701L351,118@5212L840:OfflineDownloadingPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759789839, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:118)");
            }
            OfflinePageHeaderKt.m2949OfflinePageHeaderGmEhDVc(PlayerbaseresRes.INSTANCE.getString(String0_commonMainKt.getPlayerbaseres_global_string_1454(PlayerbaseresRes.INSTANCE.getString())), SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), !$isEdit, $fitsSystemBar, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $titleTextStyle, $backInterceptor, ComposableLambdaKt.rememberComposableLambda(-1603845803, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineDownloadingView$lambda$3$0$0;
                    OfflineDownloadingView$lambda$3$0$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$0$0($isEdit, $scope, $machine, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineDownloadingView$lambda$3$0$0;
                }
            }, $composer, 54), $composer, 100663344, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$0$0(boolean $isEdit, CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine, State $state$delegate, RowScope $this$OfflinePageHeader, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageHeader, "$this$OfflinePageHeader");
        ComposerKt.sourceInformation($composer, "C:OfflineDownloadingPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1603845803, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView.<anonymous>.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:129)");
            }
            if ($isEdit) {
                $composer.startReplaceGroup(1340887409);
                ComposerKt.sourceInformation($composer, "130@5761L44");
                OfflinePageHeaderKt.OfflineHeaderCancelOperation($scope, $machine, $composer, OfflineDownloadingPageStateMachine.$stable << 3);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1340988004);
                ComposerKt.sourceInformation($composer, "*133@5950L36");
                Iterable $this$forEach$iv = OfflineDownloadingView$lambda$1($state$delegate).getConfig().getHeaderOperations();
                for (Object element$iv : $this$forEach$iv) {
                    OfflinePageOperation operation = (OfflinePageOperation) element$iv;
                    OfflineOperationComponentKt.mapToHeaderComponent(operation, $scope, $machine, $composer, OfflineDownloadingPageStateMachine.$stable << 6);
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
    public static final Unit OfflineDownloadingView$lambda$3$1(boolean $isEdit, final CoroutineScope $scope, final OfflineDownloadingPageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C161@7256L167,166@7443L206,157@7026L623:OfflineDownloadingPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1494885618, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:139)");
            }
            StorageInfoModel storageInfo = OfflineDownloadingView$lambda$1($state$delegate).getStorageInfo();
            if ($isEdit) {
                $composer.startReplaceGroup(-384490640);
                $composer.endReplaceGroup();
                int size = OfflineDownloadingView$lambda$1($state$delegate).selected().size();
                int size2 = OfflineDownloadingView$lambda$1($state$delegate).getDownloading().size();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 2066039449, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda29
                        public final Object invoke() {
                            Unit OfflineDownloadingView$lambda$3$1$0$0;
                            OfflineDownloadingView$lambda$3$1$0$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$1$0$0($scope, $machine);
                            return OfflineDownloadingView$lambda$3$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                OfflinePageFooterKt.OfflinePageFooter(size, size2, fillMaxWidth$default, (Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(-776445464, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda30
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit OfflineDownloadingView$lambda$3$1$1;
                        OfflineDownloadingView$lambda$3$1$1 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$1$1($state$delegate, $scope, $machine, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return OfflineDownloadingView$lambda$3$1$1;
                    }
                }, $composer, 54), $composer, 24960, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.startReplaceGroup(-378338194);
                ComposerKt.sourceInformation($composer, "");
                if (!(storageInfo != null && storageInfo.getShowStorageUsage()) || OfflineDownloadingView$lambda$1($state$delegate).getDownloading().isEmpty()) {
                    $composer.startReplaceGroup(-384490640);
                } else {
                    $composer.startReplaceGroup(-378244729);
                    ComposerKt.sourceInformation($composer, "148@6639L12,150@6773L17,142@6300L633");
                    OfflinePageFooterKt.OfflineStorageUsage(storageInfo.getUsedSpaceDesc(), storageInfo.getAvailableSpaceDesc(), SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(PaddingKt.padding(Modifier.Companion, WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(5), 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), $composer, 0, 0);
                }
                $composer.endReplaceGroup();
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$1$0$0(CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDownloadingPageKt$OfflineDownloadingView$2$2$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$1$1(State $state$delegate, CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine, RowScope $this$OfflinePageFooter, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageFooter, "$this$OfflinePageFooter");
        ComposerKt.sourceInformation($composer, "C*168@7552L57:OfflineDownloadingPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-776445464, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView.<anonymous>.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:167)");
            }
            Iterable $this$forEach$iv = OfflineDownloadingView$lambda$1($state$delegate).getConfig().getFooterOperations();
            for (Object element$iv : $this$forEach$iv) {
                OfflinePageOperation operation = (OfflinePageOperation) element$iv;
                OfflineOperationComponentKt.mapToFooterComponent(operation, $scope, $machine, OfflineDownloadingView$lambda$1($state$delegate).getSelectedCount(), $composer, OfflineDownloadingPageStateMachine.$stable << 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$2(final State $state$delegate, final boolean $isEdit, final CoroutineScope $scope, final OfflineDownloadingPageStateMachine $machine, PaddingValues innerPadding, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding)179@7964L6,180@7991L2075,173@7705L2361:OfflineDownloadingPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1789937220, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:173)");
            }
            ContentWithStateKt.ContentWithState(OfflineDownloadingView$lambda$1($state$delegate).getDataState(), BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, innerPadding), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(751026651, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingView$lambda$3$2$0;
                    OfflineDownloadingView$lambda$3$2$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2$0($isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingView$lambda$3$2$0;
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
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c2, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00fe, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x013c, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0179, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01b7, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineDownloadingView$lambda$3$2$0(boolean $isEdit, final CoroutineScope $scope, final OfflineDownloadingPageStateMachine $machine, State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C188@8407L340,197@8792L160,202@8988L166,207@9194L170,212@9405L153,217@9599L434,181@8009L2043:OfflineDownloadingPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(751026651, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingView.<anonymous>.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:181)");
            }
            int maxConcurrent = OfflineDownloadingView$lambda$1($state$delegate).getConfig().getMaxConcurrent();
            List<OfflineDownloadingCardModel> downloading = OfflineDownloadingView$lambda$1($state$delegate).getDownloading();
            List<OfflinePageOperation> footerOperations = OfflineDownloadingView$lambda$1($state$delegate).getConfig().getFooterOperations();
            Set<String> selected = OfflineDownloadingView$lambda$1($state$delegate).selected();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 182119535, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit OfflineDownloadingView$lambda$3$2$0$0$0;
                        OfflineDownloadingView$lambda$3$2$0$0$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2$0$0$0($scope, $machine, ((Boolean) obj).booleanValue());
                        return OfflineDownloadingView$lambda$3$2$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 182131675, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit OfflineDownloadingView$lambda$3$2$0$1$0;
                    OfflineDownloadingView$lambda$3$2$0$1$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2$0$1$0($scope, $machine);
                    return OfflineDownloadingView$lambda$3$2$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Function0 function0 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 182137953, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit OfflineDownloadingView$lambda$3$2$0$2$0;
                    OfflineDownloadingView$lambda$3$2$0$2$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2$0$2$0($scope, $machine, (String) obj);
                    return OfflineDownloadingView$lambda$3$2$0$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            Function1 function12 = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 182144549, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit OfflineDownloadingView$lambda$3$2$0$3$0;
                    OfflineDownloadingView$lambda$3$2$0$3$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2$0$3$0($scope, $machine, (String) obj);
                    return OfflineDownloadingView$lambda$3$2$0$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            Function1 function13 = (Function1) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 182151284, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv5 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv5 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj) {
                    Unit OfflineDownloadingView$lambda$3$2$0$4$0;
                    OfflineDownloadingView$lambda$3$2$0$4$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2$0$4$0($scope, $machine, (String) obj);
                    return OfflineDownloadingView$lambda$3$2$0$4$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            Function1 function14 = (Function1) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 182157773, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv6 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv6 = new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingView$lambda$3$2$0$5$0;
                    OfflineDownloadingView$lambda$3$2$0$5$0 = OfflineDownloadingPageKt.OfflineDownloadingView$lambda$3$2$0$5$0($scope, $machine, (String) obj, (OfflinePageOperation) obj2);
                    return OfflineDownloadingView$lambda$3$2$0$5$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineDownloadingList($isEdit, downloading, footerOperations, maxConcurrent, fillMaxSize$default, selected, function1, function0, function12, function13, function14, (Function2) it$iv6, $composer, 24576, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$2$0$0$0(CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine, boolean hasDownloading) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$1$1$1(hasDownloading, $machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$2$0$1$0(CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$2$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$2$0$2$0(CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$3$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$2$0$3$0(CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$4$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$2$0$4$0(CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$5$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingView$lambda$3$2$0$5$0(CoroutineScope $scope, OfflineDownloadingPageStateMachine $machine, String key, OfflinePageOperation operations) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(operations, "operations");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$6$1$1(operations, $machine, key, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$0$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$3$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$4$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v16 */
    private static final void OfflineDownloadingList(final boolean isEdit, final List<OfflineDownloadingCardModel> list, final List<? extends OfflinePageOperation> list2, final int maxConcurrent, Modifier modifier, Set<String> set, Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Function1<? super String, Unit> function12, Function1<? super String, Unit> function13, Function1<? super String, Unit> function14, Function2<? super String, ? super OfflinePageOperation, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        final Set selected;
        Function1<? super Boolean, Unit> function15;
        Function0<Unit> function02;
        Function1<? super String, Unit> function16;
        Function1<? super String, Unit> function17;
        Function1<? super String, Unit> function18;
        Function2<? super String, ? super OfflinePageOperation, Unit> function22;
        SwipeCancellingToken swipeCancellingToken;
        int $dirty;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(-2052772903);
        ComposerKt.sourceInformation($composer3, "C(OfflineDownloadingList)N(isEdit,downloading,supportOperations,maxConcurrent,modifier,selected,onClickStartOrPauseAll,onClickMaxConcurrent,onItemClick,onItemLongClick,onItemCoverClick,operationHandler)244@10469L2,245@10512L2,246@10552L2,247@10596L2,248@10641L2,257@10875L23,258@10930L30,259@10986L40,260@11052L25,261@11103L24,262@11187L4678,262@11132L4733:OfflineDownloadingPage.kt#rawcr6");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(isEdit) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changedInstance(list2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(maxConcurrent) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changedInstance(set) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 8388608 : 4194304;
        }
        int i6 = i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
        if (i6 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? 67108864 : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changedInstance(function13) ? 536870912 : 268435456;
        }
        int i8 = i & 1024;
        if (i8 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function14) ? 4 : 2;
        }
        int i9 = i & IjkMediaMeta.FF_PROFILE_H264_INTRA;
        if (i9 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if ($composer3.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty1 & 19) == 18) ? false : true, $dirty2 & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            Set selected2 = i3 != 0 ? SetsKt.emptySet() : set;
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1324761349, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj) {
                            Unit OfflineDownloadingList$lambda$0$0;
                            OfflineDownloadingList$lambda$0$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$0$0(((Boolean) obj).booleanValue());
                            return OfflineDownloadingList$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function15 = (Function1) value$iv;
            } else {
                function15 = function1;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1324759973, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda16
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function02 = (Function0) it$iv2;
            } else {
                function02 = function0;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1324758693, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj) {
                            Unit OfflineDownloadingList$lambda$2$0;
                            OfflineDownloadingList$lambda$2$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$2$0((String) obj);
                            return OfflineDownloadingList$lambda$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function16 = it$iv3;
            } else {
                function16 = function12;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1324757285, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
                Object it$iv4 = $composer3.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj) {
                            Unit OfflineDownloadingList$lambda$3$0;
                            OfflineDownloadingList$lambda$3$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$3$0((String) obj);
                            return OfflineDownloadingList$lambda$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function17 = it$iv4;
            } else {
                function17 = function13;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1324755845, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
                Object it$iv5 = $composer3.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda19
                        public final Object invoke(Object obj) {
                            Unit OfflineDownloadingList$lambda$4$0;
                            OfflineDownloadingList$lambda$4$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$4$0((String) obj);
                            return OfflineDownloadingList$lambda$4$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function18 = it$iv5;
            } else {
                function18 = function14;
            }
            function22 = i9 != 0 ? null : function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2052772903, $dirty2, $dirty1, "video.biz.offline.list.ui.page.OfflineDownloadingList (OfflineDownloadingPage.kt:250)");
            }
            if (list.isEmpty()) {
                $composer3.startReplaceGroup(1882353553);
                ComposerKt.sourceInformation($composer3, "252@10762L25");
                OfflineEmptyPlaceholderKt.OfflineEmptyPlaceholder(null, $composer3, 0, 1);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final Set<String> set2 = selected2;
                    final Function1<? super Boolean, Unit> function19 = function15;
                    final Function0<Unit> function03 = function02;
                    final Function1<? super String, Unit> function110 = function16;
                    final Function1<? super String, Unit> function111 = function17;
                    final Function1<? super String, Unit> function112 = function18;
                    final Function2<? super String, ? super OfflinePageOperation, Unit> function23 = function22;
                    endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda20
                        public final Object invoke(Object obj, Object obj2) {
                            Unit OfflineDownloadingList$lambda$5;
                            OfflineDownloadingList$lambda$5 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$5(isEdit, list, list2, maxConcurrent, modifier3, set2, function19, function03, function110, function111, function112, function23, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                            return OfflineDownloadingList$lambda$5;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty3 = $dirty2;
            int $dirty12 = $dirty1;
            Set selected3 = selected2;
            $composer2 = $composer3;
            $composer2.startReplaceGroup(1871684841);
            $composer2.endReplaceGroup();
            LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
            final SwipeCancellingToken swipeCancellingToken2 = SwipeActionKt.rememberSwipeCancellingToken($composer2, 0);
            SwipeActionKt.cancelOnLazyListScrolling(swipeCancellingToken2, lazyListState, $composer2, 0);
            SwipeActionKt.cancelOnLifecyclePaused(swipeCancellingToken2, $composer2, 0);
            OfflineSwipeActionExtKt.cancelOnEditMode(swipeCancellingToken2, isEdit, $composer2, ($dirty3 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart($composer2, -1324733697, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | (($dirty3 & 14) == 4) | ((3670016 & $dirty3) == 1048576) | ((29360128 & $dirty3) == 8388608) | (($dirty3 & 7168) == 2048) | $composer2.changedInstance(swipeCancellingToken2) | $composer2.changedInstance(list2) | ((234881024 & $dirty3) == 67108864) | ((1879048192 & $dirty3) == 536870912) | (($dirty12 & 112) == 32) | $composer2.changedInstance(selected3) | (($dirty12 & 14) == 4);
            Object value$iv6 = $composer2.rememberedValue();
            if (invalid$iv || value$iv6 == Composer.Companion.getEmpty()) {
                final Function1<? super Boolean, Unit> function113 = function15;
                final Function0<Unit> function04 = function02;
                swipeCancellingToken = swipeCancellingToken2;
                selected = selected3;
                final Function1<? super String, Unit> function114 = function16;
                final Function1<? super String, Unit> function115 = function17;
                final Function2<? super String, ? super OfflinePageOperation, Unit> function24 = function22;
                $dirty = $dirty3;
                final Function1<? super String, Unit> function116 = function18;
                value$iv6 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj) {
                        Unit OfflineDownloadingList$lambda$6$0;
                        OfflineDownloadingList$lambda$6$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0(isEdit, list, function113, function04, maxConcurrent, swipeCancellingToken2, list2, function114, function115, function24, selected, function116, (LazyListScope) obj);
                        return OfflineDownloadingList$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
            } else {
                selected = selected3;
                $dirty = $dirty3;
                swipeCancellingToken = swipeCancellingToken2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier2, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv6, $composer2, ($dirty >> 12) & 14, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            selected = set;
            function15 = function1;
            function02 = function0;
            function16 = function12;
            function17 = function13;
            function18 = function14;
            function22 = function2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier4 = modifier2;
            final Set set3 = selected;
            final Function1<? super Boolean, Unit> function117 = function15;
            final Function0<Unit> function05 = function02;
            final Function1<? super String, Unit> function118 = function16;
            final Function1<? super String, Unit> function119 = function17;
            final Function1<? super String, Unit> function120 = function18;
            final Function2<? super String, ? super OfflinePageOperation, Unit> function25 = function22;
            endRestartGroup2.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingList$lambda$7;
                    OfflineDownloadingList$lambda$7 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$7(isEdit, list, list2, maxConcurrent, modifier4, set3, function117, function05, function118, function119, function120, function25, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingList$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0(final boolean $isEdit, final List $downloading, final Function1 $onClickStartOrPauseAll, final Function0 $onClickMaxConcurrent, final int $maxConcurrent, final SwipeCancellingToken $swipeCancellingToken, final List $supportOperations, final Function1 $onItemClick, final Function1 $onItemLongClick, final Function2 $operationHandler, final Set $selected, final Function1 $onItemCoverClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        if (!$isEdit) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-703894359, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineDownloadingList$lambda$6$0$0;
                    OfflineDownloadingList$lambda$6$0$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$0($downloading, $onClickStartOrPauseAll, $onClickMaxConcurrent, $maxConcurrent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineDownloadingList$lambda$6$0$0;
                }
            }), 3, (Object) null);
        }
        LazyListScope.-CC.items$default($this$LazyColumn, $downloading.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-694480645, true, new Function4() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit OfflineDownloadingList$lambda$6$0$1;
                OfflineDownloadingList$lambda$6$0$1 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$1($downloading, $swipeCancellingToken, $supportOperations, $isEdit, $onItemClick, $onItemLongClick, $operationHandler, $selected, $onItemCoverClick, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return OfflineDownloadingList$lambda$6$0$1;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01fb, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineDownloadingList$lambda$6$0$0(List $downloading, final Function1 $onClickStartOrPauseAll, final Function0 $onClickMaxConcurrent, int $maxConcurrent, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        final boolean hasDownloading;
        Function0 factory$iv$iv$iv2;
        Painter iconRes;
        boolean z;
        String title;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C265@11247L3330:OfflineDownloadingPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-703894359, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingList.<anonymous>.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:265)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(10));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((390 >> 6) & 112) | 6;
            RowScope $this$OfflineDownloadingList_u24lambda_u246_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -780712410, "C276@11804L6,280@12030L110,270@11509L1921,309@13451L38,313@13669L86,310@13510L1049:OfflineDownloadingPage.kt#rawcr6");
            List $this$any$iv = $downloading;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        OfflineDownloadingCardModel it2 = (OfflineDownloadingCardModel) element$iv;
                        if (it2.isDownloading()) {
                            hasDownloading = true;
                            break;
                        }
                    } else {
                        hasDownloading = false;
                        break;
                    }
                }
            } else {
                hasDownloading = false;
            }
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 390473875, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onClickStartOrPauseAll) | $composer.changed(hasDownloading);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda24
                public final Object invoke() {
                    Unit OfflineDownloadingList$lambda$6$0$0$0$1$0;
                    OfflineDownloadingList$lambda$6$0$0$0$1$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$0$0$1$0($onClickStartOrPauseAll, hasDownloading);
                    return OfflineDownloadingList$lambda$6$0$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -414798144, "C292@12562L6,290@12464L253,296@12742L39,305@13309L9,306@13370L6,303@13215L193:OfflineDownloadingPage.kt#rawcr6");
            if (hasDownloading) {
                $composer.startReplaceGroup(-414771578);
                ComposerKt.sourceInformation($composer, "286@12299L14");
                Painter pause_fill_500 = BiliIconfont.INSTANCE.getPause_fill_500($composer, 6);
                $composer.endReplaceGroup();
                iconRes = pause_fill_500;
            } else {
                $composer.startReplaceGroup(-414675385);
                ComposerKt.sourceInformation($composer, "288@12396L13");
                Painter play_fill_500 = BiliIconfont.INSTANCE.getPlay_fill_500($composer, 6);
                $composer.endReplaceGroup();
                iconRes = play_fill_500;
            }
            IconKt.Icon-ww6aTOc(iconRes, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            List $this$any$iv2 = $downloading;
            if (!($this$any$iv2 instanceof Collection) || !$this$any$iv2.isEmpty()) {
                Iterator it3 = $this$any$iv2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object element$iv2 = it3.next();
                        OfflineDownloadingCardModel it4 = (OfflineDownloadingCardModel) element$iv2;
                        if (it4.isDownloading()) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                title = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2261(PlayerbaseresRes.INSTANCE.getString()));
            } else {
                title = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2269(PlayerbaseresRes.INSTANCE.getString()));
            }
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$OfflineDownloadingList_u24lambda_u246_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer, 0);
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            Modifier modifier2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 390526299, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onClickMaxConcurrent);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        Unit OfflineDownloadingList$lambda$6$0$0$0$3$0;
                        OfflineDownloadingList$lambda$6$0$0$0$3$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$0$0$3$0($onClickMaxConcurrent);
                        return OfflineDownloadingList$lambda$6$0$0$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -230339171, "C320@14026L9,321@14087L6,317@13805L363,324@14193L39,326@14314L21,327@14382L6,325@14257L280:OfflineDownloadingPage.kt#rawcr6");
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2186(PlayerbaseresRes.INSTANCE.getString())) + $maxConcurrent, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 24576, 114682);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(5)), $composer, 6);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_expand_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0$0$0$1$0(Function1 $onClickStartOrPauseAll, boolean $hasDownloading) {
        $onClickStartOrPauseAll.invoke(Boolean.valueOf($hasDownloading));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0$0$0$3$0(Function0 $onClickMaxConcurrent) {
        $onClickMaxConcurrent.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0$1(final List $downloading, SwipeCancellingToken $swipeCancellingToken, List $supportOperations, final boolean $isEdit, final Function1 $onItemClick, final Function1 $onItemLongClick, final Function2 $operationHandler, final Set $selected, final Function1 $onItemCoverClick, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)342@14923L61,345@15016L65,348@15118L78,351@15212L637,337@14699L1150:OfflineDownloadingPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-694480645, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineDownloadingList.<anonymous>.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:336)");
            }
            final OfflineDownloadingCardModel item = (OfflineDownloadingCardModel) $downloading.get(index);
            String key = item.getKey();
            ComposerKt.sourceInformationMarkerStart($composer, -1675959656, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onItemClick) | $composer.changedInstance(item);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit OfflineDownloadingList$lambda$6$0$1$0$0;
                        OfflineDownloadingList$lambda$6$0$1$0$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$1$0$0($onItemClick, item);
                        return OfflineDownloadingList$lambda$6$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1675956676, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onItemLongClick) | $composer.changedInstance(item);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        Unit OfflineDownloadingList$lambda$6$0$1$1$0;
                        OfflineDownloadingList$lambda$6$0$1$1$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$1$1$0($onItemLongClick, item);
                        return OfflineDownloadingList$lambda$6$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function0 function02 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1675953399, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($operationHandler) | $composer.changedInstance(item);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        Unit OfflineDownloadingList$lambda$6$0$1$2$0;
                        OfflineDownloadingList$lambda$6$0$1$2$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$1$2$0($operationHandler, item, (OfflinePageOperation) obj);
                        return OfflineDownloadingList$lambda$6$0$1$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineListItem_androidKt.OfflineListItem(key, $swipeCancellingToken, $supportOperations, $isEdit, null, function0, function02, (Function1) it$iv3, ComposableLambdaKt.rememberComposableLambda(-977069638, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingList$lambda$6$0$1$3;
                    OfflineDownloadingList$lambda$6$0$1$3 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$1$3($isEdit, $selected, item, index, $downloading, $onItemCoverClick, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingList$lambda$6$0$1$3;
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
    public static final Unit OfflineDownloadingList$lambda$6$0$1$0$0(Function1 $onItemClick, OfflineDownloadingCardModel $item) {
        $onItemClick.invoke($item.getKey());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0$1$1$0(Function1 $onItemLongClick, OfflineDownloadingCardModel $item) {
        $onItemLongClick.invoke($item.getKey());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0$1$2$0(Function2 $operationHandler, OfflineDownloadingCardModel $item, OfflinePageOperation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ($operationHandler != null) {
            $operationHandler.invoke($item.getKey(), it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0$1$3(final boolean $isEdit, Set $selected, final OfflineDownloadingCardModel $item, final int $index, final List $downloading, final Function1 $onItemCoverClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C356@15400L435,352@15230L605:OfflineDownloadingPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-977069638, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:352)");
            }
            ContentWithCheckMarkKt.m2913ContentWithCheckMarkGHTll3U($isEdit, $selected.contains($item.getKey()), null, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, null, ComposableLambdaKt.rememberComposableLambda(-1948699292, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingList$lambda$6$0$1$3$0;
                    OfflineDownloadingList$lambda$6$0$1$3$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$1$3$0($index, $downloading, $item, $isEdit, $onItemCoverClick, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingList$lambda$6$0$1$3$0;
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
    public static final Unit OfflineDownloadingList$lambda$6$0$1$3$0(int $index, List $downloading, final OfflineDownloadingCardModel $item, boolean $isEdit, final Function1 $onItemCoverClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C362@15712L82,358@15515L302:OfflineDownloadingPage.kt#rawcr6");
        boolean showDivider = true;
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1948699292, $changed, -1, "video.biz.offline.list.ui.page.OfflineDownloadingList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfflineDownloadingPage.kt:357)");
            }
            if ($index == CollectionsKt.getLastIndex($downloading) || $downloading.size() <= 1) {
                showDivider = false;
            }
            ComposerKt.sourceInformationMarkerStart($composer, -94268490, "CC(remember):OfflineDownloadingPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onItemCoverClick) | $composer.changedInstance($item);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$$ExternalSyntheticLambda31
                    public final Object invoke() {
                        Unit OfflineDownloadingList$lambda$6$0$1$3$0$0$0;
                        OfflineDownloadingList$lambda$6$0$1$3$0$0$0 = OfflineDownloadingPageKt.OfflineDownloadingList$lambda$6$0$1$3$0$0$0($onItemCoverClick, $item);
                        return OfflineDownloadingList$lambda$6$0$1$3$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineDownloadingCardKt.OfflineDownloadingCard($item, $isEdit, null, showDivider, (Function0) it$iv, $composer, OfflineDownloadingCardModel.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingList$lambda$6$0$1$3$0$0$0(Function1 $onItemCoverClick, OfflineDownloadingCardModel $item) {
        $onItemCoverClick.invoke($item.getKey());
        return Unit.INSTANCE;
    }
}