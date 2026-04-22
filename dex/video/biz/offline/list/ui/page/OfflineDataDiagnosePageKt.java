package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import java.util.Map;
import kntr.base.router.Router;
import kntr.common.compose.res.AnimatePainter;
import kntr.common.compose.res.RefreshAnimatePainterKt;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;
import video.base.utils.StriingExt_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore;
import video.biz.offline.list.logic.statemachine.OfflineDiagnoseState;
import video.biz.offline.list.logic.statemachine.OfflineVideoEntityWithTag;

/* compiled from: OfflineDataDiagnosePage.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a=\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001aC\u0010\u0015\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010!\u001a\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010$\u001a\u000e\u0010%\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020&\u001a\u000e\u0010'\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020&\u001a\u000e\u0010(\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020&\u001a\u000e\u0010)\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020&\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"TAG", "", "rememberOfflineDiagnosePageStore", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageStore;", "(Landroidx/compose/runtime/Composer;I)Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageStore;", OfflineDataDiagnosePageKt.TAG, "", "(Landroidx/compose/runtime/Composer;I)V", "OfflineDataDiagnoseScreen", "uiState", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "modifier", "Landroidx/compose/ui/Modifier;", "onEvent", "Lkotlin/Function1;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;", "(Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "EmptyTip", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VideoList", "videos", "", "Lvideo/biz/offline/list/logic/statemachine/OfflineVideoEntityWithTag;", "onItemClick", "(Ljava/util/List;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "VideoItem", "videoEntity", "position", "", "onClick", "Lkotlin/Function0;", "(Lvideo/biz/offline/list/logic/statemachine/OfflineVideoEntityWithTag;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Tag", "tagContent", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "buildUGCTitle", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "buildUgcSubTitle", "buildOgvTitle", "buildOgvSubtitle", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDataDiagnosePageKt {
    private static final String TAG = "OfflineDataDiagnosePage";

    /* compiled from: OfflineDataDiagnosePage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.SeasonType.values().length];
            try {
                iArr[OfflineVideoEntity.SeasonType.BANGUMI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.SeasonType.CN_BANGUMI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyTip$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        EmptyTip(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDataDiagnosePage$lambda$0(int i, Composer composer, int i2) {
        OfflineDataDiagnosePage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDataDiagnoseScreen$lambda$2(OfflineDiagnoseState offlineDiagnoseState, LazyListState lazyListState, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        OfflineDataDiagnoseScreen(offlineDiagnoseState, lazyListState, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tag$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Tag(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoItem$lambda$7(OfflineVideoEntityWithTag offlineVideoEntityWithTag, int i, Function0 function0, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        VideoItem(offlineVideoEntityWithTag, i, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoList$lambda$2(List list, LazyListState lazyListState, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        VideoList(list, lazyListState, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final OfflineDiagnosePageStore rememberOfflineDiagnosePageStore(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1432198147, "C(rememberOfflineDiagnosePageStore)73@3564L7,74@3597L24,75@3633L125:OfflineDataDiagnosePage.kt#rawcr6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1432198147, $changed, -1, "video.biz.offline.list.ui.page.rememberOfflineDiagnosePageStore (OfflineDataDiagnosePage.kt:72)");
        }
        CompositionLocal this_$iv = RouterKt.getLocalRouter();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Router router = (Router) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1952889952, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new OfflineDiagnosePageStore(router, coroutineScope);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        OfflineDiagnosePageStore offlineDiagnosePageStore = (OfflineDiagnosePageStore) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return offlineDiagnosePageStore;
    }

    public static final void OfflineDataDiagnosePage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1369013456);
        ComposerKt.sourceInformation($composer2, "C(OfflineDataDiagnosePage)87@3921L650:OfflineDataDiagnosePage.kt#rawcr6");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1369013456, $changed, -1, "video.biz.offline.list.ui.page.OfflineDataDiagnosePage (OfflineDataDiagnosePage.kt:86)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$OfflineDataDiagnosePageKt.INSTANCE.m2838getLambda$273186184$ui_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDataDiagnosePage$lambda$0;
                    OfflineDataDiagnosePage$lambda$0 = OfflineDataDiagnosePageKt.OfflineDataDiagnosePage$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDataDiagnosePage$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDataDiagnoseScreen$lambda$0$0(OfflineDiagnosePageEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7 */
    public static final void OfflineDataDiagnoseScreen(final OfflineDiagnoseState uiState, final LazyListState lazyListState, Modifier modifier, Function1<? super OfflineDiagnosePageEvent, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Modifier modifier3;
        Function1 onEvent;
        Modifier modifier4;
        final Function1 onEvent2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Composer $composer2 = $composer.startRestartGroup(-1748480062);
        ComposerKt.sourceInformation($composer2, "C(OfflineDataDiagnoseScreen)N(uiState,lazyListState,modifier,onEvent)114@4772L2,126@5144L1845,116@4784L2205:OfflineDataDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(uiState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(lazyListState) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function12 = function1;
        } else if (($changed & 3072) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            function12 = function1;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onEvent = function12;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onEvent2 = function12;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer2, -957120924, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            Unit OfflineDataDiagnoseScreen$lambda$0$0;
                            OfflineDataDiagnoseScreen$lambda$0$0 = OfflineDataDiagnosePageKt.OfflineDataDiagnoseScreen$lambda$0$0((OfflineDiagnosePageEvent) obj);
                            return OfflineDataDiagnoseScreen$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onEvent2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1748480062, $dirty, -1, "video.biz.offline.list.ui.page.OfflineDataDiagnoseScreen (OfflineDataDiagnosePage.kt:115)");
            }
            ScaffoldKt.Scaffold-TvnljyQ(modifier4, ComposableSingletons$OfflineDataDiagnosePageKt.INSTANCE.getLambda$302151558$ui_debug(), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-572776815, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineDataDiagnoseScreen$lambda$1;
                    OfflineDataDiagnoseScreen$lambda$1 = OfflineDataDiagnosePageKt.OfflineDataDiagnoseScreen$lambda$1(OfflineDiagnoseState.this, lazyListState, onEvent2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineDataDiagnoseScreen$lambda$1;
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onEvent = onEvent2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function13 = onEvent;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDataDiagnoseScreen$lambda$2;
                    OfflineDataDiagnoseScreen$lambda$2 = OfflineDataDiagnosePageKt.OfflineDataDiagnoseScreen$lambda$2(OfflineDiagnoseState.this, lazyListState, modifier5, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDataDiagnoseScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDataDiagnoseScreen$lambda$1(OfflineDiagnoseState $uiState, LazyListState $lazyListState, final Function1 $onEvent, PaddingValues innerPadding, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding):OfflineDataDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-572776815, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineDataDiagnoseScreen.<anonymous> (OfflineDataDiagnosePage.kt:127)");
            }
            if ($uiState instanceof OfflineDiagnoseState.Idle) {
                $composer.startReplaceGroup(311070855);
                ComposerKt.sourceInformation($composer, "129@5261L10");
                EmptyTip(null, $composer, 0, 1);
                $composer.endReplaceGroup();
            } else if (!($uiState instanceof OfflineDiagnoseState.Loading)) {
                if (!($uiState instanceof OfflineDiagnoseState.Success)) {
                    if (Intrinsics.areEqual($uiState, OfflineDiagnoseState.Empty.INSTANCE)) {
                        $composer.startReplaceGroup(312657063);
                        ComposerKt.sourceInformation($composer, "170@6860L10");
                        EmptyTip(null, $composer, 0, 1);
                        $composer.endReplaceGroup();
                    } else if (!($uiState instanceof OfflineDiagnoseState.Error)) {
                        $composer.startReplaceGroup(-682702682);
                        $composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    } else {
                        $composer.startReplaceGroup(312745351);
                        ComposerKt.sourceInformation($composer, "174@6949L10");
                        EmptyTip(null, $composer, 0, 1);
                        $composer.endReplaceGroup();
                    }
                } else {
                    $composer.startReplaceGroup(311804873);
                    ComposerKt.sourceInformation($composer, "157@6343L6,158@6390L375,149@5976L808");
                    List<OfflineVideoEntityWithTag> videos = ((OfflineDiagnoseState.Success) $uiState).getVideos();
                    Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(PaddingKt.padding(Modifier.Companion, innerPadding), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, -682665080, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($onEvent);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                Unit OfflineDataDiagnoseScreen$lambda$1$1$0;
                                OfflineDataDiagnoseScreen$lambda$1$1$0 = OfflineDataDiagnosePageKt.OfflineDataDiagnoseScreen$lambda$1$1$0($onEvent, (OfflineVideoEntityWithTag) obj);
                                return OfflineDataDiagnoseScreen$lambda$1$1$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    VideoList(videos, $lazyListState, modifier, (Function1) it$iv, $composer, 0, 0);
                    $composer.endReplaceGroup();
                }
            } else {
                $composer.startReplaceGroup(311177650);
                ComposerKt.sourceInformation($composer, "133@5352L543");
                Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
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
                int i2 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -911982199, "C137@5523L31,138@5575L302:OfflineDataDiagnosePage.kt#rawcr6");
                Painter rememberRefreshAnimatePainter = RefreshAnimatePainterKt.rememberRefreshAnimatePainter(false, $composer, 0, 1);
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier$iv2 = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -793670772, "C139@5660L195:OfflineDataDiagnosePage.kt#rawcr6");
                ImageKt.Image(rememberRefreshAnimatePainter, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), (Alignment) null, (ContentScale) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer, AnimatePainter.$stable | 432, 120);
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
    public static final Unit OfflineDataDiagnoseScreen$lambda$1$1$0(Function1 $onEvent, OfflineVideoEntityWithTag video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        $onEvent.invoke(new OfflineDiagnosePageEvent.NavToDiagnoseResultBy(String.valueOf(video2.getOfflineVideoEntity().getVideoId()), String.valueOf(video2.getOfflineVideoEntity().getCid())));
        return Unit.INSTANCE;
    }

    public static final void EmptyTip(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1632322505);
        ComposerKt.sourceInformation($composer2, "C(EmptyTip)N(modifier)183@7151L6,182@7055L515:OfflineDataDiagnosePage.kt#rawcr6");
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
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1632322505, $dirty, -1, "video.biz.offline.list.ui.page.EmptyTip (OfflineDataDiagnosePage.kt:181)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(modifier3, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa0-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1315171804, "C191@7486L6,187@7290L274:OfflineDataDiagnosePage.kt#rawcr6");
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2199(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa7-0d7_KjU(), TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), $composer2, 0, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit EmptyTip$lambda$1;
                    EmptyTip$lambda$1 = OfflineDataDiagnosePageKt.EmptyTip$lambda$1(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return EmptyTip$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoList$lambda$0$0(OfflineVideoEntityWithTag it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4 */
    public static final void VideoList(final List<OfflineVideoEntityWithTag> list, final LazyListState lazyListState, Modifier modifier, Function1<? super OfflineVideoEntityWithTag, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 onItemClick;
        Modifier modifier3;
        Modifier modifier4;
        final Function1 onItemClick2;
        Intrinsics.checkNotNullParameter(list, "videos");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Composer $composer2 = $composer.startRestartGroup(-496852970);
        ComposerKt.sourceInformation($composer2, "C(VideoList)N(videos,lazyListState,modifier,onItemClick)203@7770L2,207@7896L6,208@7915L307,205@7782L440:OfflineDataDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(lazyListState) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            onItemClick = function1;
        } else if (($changed & 3072) == 0) {
            onItemClick = function1;
            $dirty |= $composer2.changedInstance(onItemClick) ? 2048 : 1024;
        } else {
            onItemClick = function1;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -734328424, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit VideoList$lambda$0$0;
                            VideoList$lambda$0$0 = OfflineDataDiagnosePageKt.VideoList$lambda$0$0((OfflineVideoEntityWithTag) obj);
                            return VideoList$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onItemClick3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onItemClick2 = onItemClick3;
            } else {
                onItemClick2 = onItemClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-496852970, $dirty, -1, "video.biz.offline.list.ui.page.VideoList (OfflineDataDiagnosePage.kt:204)");
            }
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -734323479, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | (($dirty & 7168) == 2048);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit VideoList$lambda$1$0;
                        VideoList$lambda$1$0 = OfflineDataDiagnosePageKt.VideoList$lambda$1$0(list, onItemClick2, (LazyListScope) obj);
                        return VideoList$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function1 onItemClick4 = onItemClick2;
            LazyDslKt.LazyColumn(modifier5, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer2, $dirty & 112, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onItemClick = onItemClick4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function12 = onItemClick;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoList$lambda$2;
                    VideoList$lambda$2 = OfflineDataDiagnosePageKt.VideoList$lambda$2(list, lazyListState, modifier6, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoList$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoList$lambda$1$0(final List $videos, final Function1 $onItemClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        $this$LazyColumn.items($videos.size(), (Function1) null, new Function1<Integer, Object>() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$VideoList$lambda$1$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                $videos.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$VideoList$lambda$1$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                int $dirty2 = $dirty;
                if (!$composer.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, $dirty2, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int $changed2 = ($dirty2 & 14) | ($dirty2 & 112);
                final OfflineVideoEntityWithTag videoEntity = (OfflineVideoEntityWithTag) $videos.get(it);
                $composer.startReplaceGroup(1836848796);
                ComposerKt.sourceInformation($composer, "CN(index,videoEntity)*215@8127L64,212@8013L193:OfflineDataDiagnosePage.kt#rawcr6");
                ComposerKt.sourceInformationMarkerStart($composer, 197804038, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onItemClick) | (((($changed2 & 896) ^ 384) > 256 && $composer.changedInstance(videoEntity)) || ($changed2 & 384) == 256);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final Function1 function1 = $onItemClick;
                    Object value$iv = (Function0) new Function0<Unit>() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$VideoList$2$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2866invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2866invoke() {
                            function1.invoke(videoEntity);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                OfflineDataDiagnosePageKt.VideoItem(videoEntity, it, (Function0) it$iv, null, $composer, OfflineVideoEntityWithTag.$stable | (($changed2 >> 6) & 14) | ($changed2 & 112), 8);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public static final void VideoItem(final OfflineVideoEntityWithTag videoEntity, final int position, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1742221257);
        ComposerKt.sourceInformation($composer2, "C(VideoItem)N(videoEntity,position,onClick,modifier)233@8483L6,245@8729L6,248@8794L22,251@8968L7,255@9089L117,255@9038L168,289@10308L173,303@10695L49,297@10498L1561:OfflineDataDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(videoEntity) : $composer2.changedInstance(videoEntity) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(position) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1742221257, $dirty2, -1, "video.biz.offline.list.ui.page.VideoItem (OfflineDataDiagnosePage.kt:229)");
            }
            TextStyle mainTextStyle = new TextStyle(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa9-0d7_KjU(), TextUnitKt.getSp(15), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
            TextStyle tagTextStyle = new TextStyle(Color.Companion.getWhite-0d7_KjU(), TextUnitKt.getSp(10), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
            TextStyle subTitleTextStyle = new TextStyle(Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa9-0d7_KjU(), 0.5f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null), TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer2, 0, 1);
            long tagTextSize = TextMeasurer.measure-wNUYSr0$default(textMeasurer, videoEntity.getTag().getContent(), tagTextStyle, 0, false, 0, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, (int) IjkMediaPlayerTracker.BLIJK_EV_WILL_SEEK, (Object) null).getSize-YbymL2g();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$VideoItem_u24lambda_u240 = (Density) consume;
            long tagPlaceHolderWidth = $this$VideoItem_u24lambda_u240.toSp-kPz2Gy4(((int) (tagTextSize >> 32)) + 32);
            String key = videoEntity.getOfflineVideoEntity().getKey();
            ComposerKt.sourceInformationMarkerStart($composer2, 762644812, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer2.changedInstance(videoEntity));
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new OfflineDataDiagnosePageKt$VideoItem$1$1(videoEntity, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(key, (Function2) it$iv, $composer2, 0);
            AnnotatedString.Builder $this$VideoItem_u24lambda_u242 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            InlineTextContentKt.appendInlineContent$default($this$VideoItem_u24lambda_u242, videoEntity.getTag().getId(), (String) null, 2, (Object) null);
            if (videoEntity.getOfflineVideoEntity().getBizType() == OfflineVideoEntity.BizType.UGC) {
                $this$VideoItem_u24lambda_u242.append(buildUGCTitle(videoEntity.getOfflineVideoEntity()));
            } else {
                $this$VideoItem_u24lambda_u242.append(buildOgvTitle(videoEntity.getOfflineVideoEntity()));
            }
            AnnotatedString videoTile = $this$VideoItem_u24lambda_u242.toAnnotatedString();
            AnnotatedString.Builder $this$VideoItem_u24lambda_u243 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            if (videoEntity.getOfflineVideoEntity().getBizType() == OfflineVideoEntity.BizType.UGC) {
                $this$VideoItem_u24lambda_u243.append(buildUgcSubTitle(videoEntity.getOfflineVideoEntity()));
            } else {
                $this$VideoItem_u24lambda_u243.append(buildOgvSubtitle(videoEntity.getOfflineVideoEntity()));
            }
            AnnotatedString videoSubtitle = $this$VideoItem_u24lambda_u243.toAnnotatedString();
            Map inlineContent = MapsKt.mapOf(TuplesKt.to(videoEntity.getTag().getId(), new InlineTextContent(new Placeholder(tagPlaceHolderWidth, mainTextStyle.getFontSize-XSAIIZE(), PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-110880679, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit VideoItem$lambda$4;
                    VideoItem$lambda$4 = OfflineDataDiagnosePageKt.VideoItem$lambda$4(OfflineVideoEntityWithTag.this, (String) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return VideoItem$lambda$4;
                }
            }, $composer2, 54))));
            Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifier2, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 762696136, "CC(remember):OfflineDataDiagnosePage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit VideoItem$lambda$5$0;
                        VideoItem$lambda$5$0 = OfflineDataDiagnosePageKt.VideoItem$lambda$5$0(function0);
                        return VideoItem$lambda$5$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Modifier modifier4 = modifier2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -958105353, "C314@10977L410:OfflineDataDiagnosePage.kt#rawcr6");
            if (position > 0) {
                $composer2.startReplaceGroup(-958108547);
                ComposerKt.sourceInformation($composer2, "310@10899L6,308@10794L164");
                DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa2-0d7_KjU(), $composer2, 54, 0);
            } else {
                $composer2.startReplaceGroup(-968822271);
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Z58ophY(videoTile, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(8), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(8), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 13, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, inlineContent, (Function1) null, mainTextStyle, $composer2, 48, 24960, 176124);
            if (videoEntity.getOfflineVideoEntity().getBizType() == OfflineVideoEntity.BizType.UGC) {
                $composer2.startReplaceGroup(-957409652);
                ComposerKt.sourceInformation($composer2, "329@11489L469");
                TextKt.Text-Z58ophY(videoSubtitle, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(8), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(8), 7, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, inlineContent, (Function1) null, subTitleTextStyle, $composer2, 48, 24960, 176124);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-956940622);
                ComposerKt.sourceInformation($composer2, "343@11988L55");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(8)), $composer2, 6);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoItem$lambda$7;
                    VideoItem$lambda$7 = OfflineDataDiagnosePageKt.VideoItem$lambda$7(OfflineVideoEntityWithTag.this, position, function0, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoItem$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoItem$lambda$4(OfflineVideoEntityWithTag $videoEntity, String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)290@10330L133:OfflineDataDiagnosePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-110880679, $changed, -1, "video.biz.offline.list.ui.page.VideoItem.<anonymous> (OfflineDataDiagnosePage.kt:290)");
            }
            Tag($videoEntity.getTag().getContent(), Modifier.Companion, $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoItem$lambda$5$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    public static final void Tag(final String tagContent, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(tagContent, "tagContent");
        Composer $composer3 = $composer.startRestartGroup(862242410);
        ComposerKt.sourceInformation($composer3, "C(Tag)N(tagContent,modifier)353@12178L6,356@12263L690:OfflineDataDiagnosePage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(tagContent) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(862242410, $dirty2, -1, "video.biz.offline.list.ui.page.Tag (OfflineDataDiagnosePage.kt:352)");
            }
            long tagBgColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            long tagTextColor = Color.Companion.getWhite-0d7_KjU();
            float f = Dp.constructor-impl(2);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier3, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Modifier modifier4 = modifier3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1235541721, "C360@12377L570:OfflineDataDiagnosePage.kt#rawcr6");
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU(Modifier.Companion, tagBgColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f));
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 860070400, "C368@12636L301:OfflineDataDiagnosePage.kt#rawcr6");
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(tagContent, PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(3), Dp.constructor-impl(1)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(tagTextColor, TextUnitKt.getSp(10), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), $composer3, ($dirty2 & 14) | 48, 0, 131068);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineDataDiagnosePageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit Tag$lambda$1;
                    Tag$lambda$1 = OfflineDataDiagnosePageKt.Tag$lambda$1(tagContent, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Tag$lambda$1;
                }
            });
        }
    }

    public static final String buildUGCTitle(OfflineVideoEntity videoEntity) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        StringBuilder $this$buildUGCTitle_u24lambda_u240 = new StringBuilder();
        $this$buildUGCTitle_u24lambda_u240.append(videoEntity.getVideoTitle());
        return $this$buildUGCTitle_u24lambda_u240.toString();
    }

    public static final String buildUgcSubTitle(OfflineVideoEntity videoEntity) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        StringBuilder $this$buildUgcSubTitle_u24lambda_u240 = new StringBuilder();
        String title = videoEntity.getPageTitle();
        String pTitle = "P" + videoEntity.getPageIndex();
        if (Intrinsics.areEqual(title, pTitle)) {
            $this$buildUgcSubTitle_u24lambda_u240.append(" ").append(pTitle);
        } else {
            $this$buildUgcSubTitle_u24lambda_u240.append(" ").append(pTitle).append("-").append(title);
        }
        return $this$buildUgcSubTitle_u24lambda_u240.toString();
    }

    public static final String buildOgvTitle(OfflineVideoEntity videoEntity) {
        String ogvTitle;
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        if (videoEntity.getPageIndex() == -1) {
            ogvTitle = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2244(PlayerbaseresRes.INSTANCE.getString()));
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[videoEntity.getSeasonType().ordinal()]) {
                case 1:
                case 2:
                    if (StringsKt.toIntOrNull(videoEntity.getVideoTitle()) == null) {
                        ogvTitle = videoEntity.getVideoTitle();
                        break;
                    } else {
                        ogvTitle = StriingExt_androidKt.format(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_232(PlayerbaseresRes.INSTANCE.getString())), videoEntity.getVideoTitle());
                        break;
                    }
                default:
                    if (StringsKt.toIntOrNull(videoEntity.getVideoTitle()) == null) {
                        ogvTitle = videoEntity.getVideoTitle();
                        break;
                    } else {
                        ogvTitle = StriingExt_androidKt.format(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2278(PlayerbaseresRes.INSTANCE.getString())), videoEntity.getVideoTitle());
                        break;
                    }
            }
        }
        return videoEntity.getGroupTitle() + " - " + ogvTitle;
    }

    public static final String buildOgvSubtitle(OfflineVideoEntity videoEntity) {
        String format;
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        StringBuilder $this$buildOgvSubtitle_u24lambda_u240 = new StringBuilder();
        switch (WhenMappings.$EnumSwitchMapping$0[videoEntity.getSeasonType().ordinal()]) {
            case 1:
            case 2:
                if (StringsKt.toIntOrNull(videoEntity.getVideoTitle()) == null) {
                    format = videoEntity.getVideoTitle();
                    break;
                } else {
                    format = StriingExt_androidKt.format(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_232(PlayerbaseresRes.INSTANCE.getString())), videoEntity.getVideoTitle());
                    break;
                }
            default:
                if (StringsKt.toIntOrNull(videoEntity.getVideoTitle()) == null) {
                    format = videoEntity.getVideoTitle();
                    break;
                } else {
                    format = StriingExt_androidKt.format(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2278(PlayerbaseresRes.INSTANCE.getString())), videoEntity.getVideoTitle());
                    break;
                }
        }
        $this$buildOgvSubtitle_u24lambda_u240.append(format);
        $this$buildOgvSubtitle_u24lambda_u240.append(" ");
        $this$buildOgvSubtitle_u24lambda_u240.append(videoEntity.getPageTitle());
        return $this$buildOgvSubtitle_u24lambda_u240.toString();
    }
}