package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeData;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.screenshot.ScreenshotProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.tribee.consume.generated.resources.Drawable0_commonMainKt;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeSteamHasBound.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a=\u0010\f\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"TribeeSteamInfoPage", "", "state", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;", "modifier", "Landroidx/compose/ui/Modifier;", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "onStateAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "(Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeSteamDataContent", "(Lkotlin/jvm/functions/Function1;Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamHasBoundKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamDataContent$lambda$5(Function1 function1, TribeeSteamState.SteamInfoState steamInfoState, Function1 function12, int i, Composer composer, int i2) {
        TribeeSteamDataContent(function1, steamInfoState, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamInfoPage$lambda$3(TribeeSteamState.SteamInfoState steamInfoState, Modifier modifier, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamInfoPage(steamInfoState, modifier, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamInfoPage$lambda$0$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamInfoPage$lambda$1$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r6v16 */
    public static final void TribeeSteamInfoPage(final TribeeSteamState.SteamInfoState state, Modifier modifier, Function1<? super TribeeSteamUIAction, Unit> function1, Function1<? super TribeeSteamStateAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function13;
        Function1 onStateAction;
        Composer $composer2;
        Modifier modifier3;
        Function1 onUIAction;
        Modifier modifier4;
        Function1 onUIAction2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer4 = $composer.startRestartGroup(-563263437);
        ComposerKt.sourceInformation($composer4, "C(TribeeSteamInfoPage)N(state,modifier,onUIAction,onStateAction)34@1465L2,35@1523L2,40@1645L656:TribeeSteamHasBound.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function13 = function1;
        } else if (($changed & 384) == 0) {
            function13 = function1;
            $dirty |= $composer4.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onStateAction = function12;
        } else if (($changed & 3072) == 0) {
            onStateAction = function12;
            $dirty |= $composer4.changedInstance(onStateAction) ? 2048 : 1024;
        } else {
            onStateAction = function12;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onUIAction = function13;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -130278795, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamInfoPage$lambda$0$0;
                            TribeeSteamInfoPage$lambda$0$0 = TribeeSteamHasBoundKt.TribeeSteamInfoPage$lambda$0$0((TribeeSteamUIAction) obj);
                            return TribeeSteamInfoPage$lambda$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onUIAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                onUIAction2 = function13;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -130276939, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
                Object it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamInfoPage$lambda$1$0;
                            TribeeSteamInfoPage$lambda$1$0 = TribeeSteamHasBoundKt.TribeeSteamInfoPage$lambda$1$0((TribeeSteamStateAction) obj);
                            return TribeeSteamInfoPage$lambda$1$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onStateAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onStateAction = onStateAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-563263437, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamInfoPage (TribeeSteamHasBound.kt:36)");
            }
            KTribeeSteamHomeData accountInfo = state.getSteamData();
            KTribeeSteamHomeUserInfo userInfo = state.getUserInfo();
            KThreeDot threeDotInfo = state.getThreeDot();
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int $changed2 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$TribeeSteamInfoPage_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 916147427, "C55@2140L155:TribeeSteamHasBound.kt#k3l5ii");
            if (accountInfo == null) {
                $composer4.startReplaceGroup(916173745);
                ComposerKt.sourceInformation($composer4, "42@1719L216");
                $composer$iv = $composer4;
                $composer$iv$iv = $composer4;
                TribeeSteamEmptyDataContentKt.TribeeSteamEmptyDataContent(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, userInfo, threeDotInfo, null, null, onUIAction2, $composer4, (($dirty2 << 12) & 3670016) | 6, 50);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            } else {
                $composer$iv = $composer4;
                $composer$iv$iv = $composer4;
                $composer3 = $composer4;
                $composer3.startReplaceGroup(916402773);
                ComposerKt.sourceInformation($composer3, "49@1965L156");
                TribeeSteamDataContent(onUIAction2, state, onStateAction, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 3) & 896));
                $composer3.endReplaceGroup();
            }
            TipsFootCardKt.showKTipsFootCard($this$TribeeSteamInfoPage_u24lambda_u242, state.getTipsFootCard(), onStateAction, null, onUIAction2, $composer3, ($changed2 & 14) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 57344), 4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onUIAction = onUIAction2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function14 = onUIAction;
            final Function1 function15 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamInfoPage$lambda$3;
                    TribeeSteamInfoPage$lambda$3 = TribeeSteamHasBoundKt.TribeeSteamInfoPage$lambda$3(TribeeSteamState.SteamInfoState.this, modifier5, function14, function15, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamInfoPage$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x029b, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TribeeSteamDataContent(final Function1<? super TribeeSteamUIAction, Unit> function1, final TribeeSteamState.SteamInfoState state, final Function1<? super TribeeSteamStateAction, Unit> function12, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(2047994880);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamDataContent)N(onUIAction,state,onStateAction)69@2527L35,69@2505L57,75@2704L23,77@2761L53,81@2842L288,93@3216L151,91@3136L231,102@3495L6,98@3373L1568:TribeeSteamHasBound.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2047994880, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamDataContent (TribeeSteamHasBound.kt:68)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1028064611, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeSteamHasBoundKt$TribeeSteamDataContent$1$1(null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(state, (Function2) it$iv, $composer3, ($dirty2 >> 3) & 14);
            KTribeeSteamHomeGame games = state.getAchievementState().getGames();
            KTribeeSteamHomeData accountInfo = state.getSteamData();
            KTribeeSteamHomeUserInfo userInfo = state.getUserInfo();
            final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1028072117, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableIntState userInfoHeight = (MutableIntState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1028074944, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        float TribeeSteamDataContent$lambda$2$0;
                        TribeeSteamDataContent$lambda$2$0 = TribeeSteamHasBoundKt.TribeeSteamDataContent$lambda$2$0(lazyListState, userInfoHeight);
                        return Float.valueOf(TribeeSteamDataContent$lambda$2$0);
                    }
                });
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            State progress = (State) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ScreenshotProvider screenshotProvider = state.getScreenshotProvider();
            ComposerKt.sourceInformationMarkerStart($composer3, 1028086775, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TribeeSteamDataContent$lambda$3$0;
                        TribeeSteamDataContent$lambda$3$0 = TribeeSteamHasBoundKt.TribeeSteamDataContent$lambda$3$0(function12);
                        return TribeeSteamDataContent$lambda$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ObserveScreenShot_androidKt.ObserveScreenshot(screenshotProvider, (Function0) it$iv4, $composer3, 0);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1959390682, "C105@3553L49,111@3816L133,104@3524L436,116@3970L965:TribeeSteamHasBound.kt#k3l5ii");
            Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getTribee_steam_bg_dot(Res.drawable.INSTANCE), $composer3, 0);
            Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0901163f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -2014995765, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(lazyListState);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv5 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit TribeeSteamDataContent$lambda$4$0$0;
                    TribeeSteamDataContent$lambda$4$0$0 = TribeeSteamHasBoundKt.TribeeSteamDataContent$lambda$4$0$0(lazyListState, (GraphicsLayerScope) obj);
                    return TribeeSteamDataContent$lambda$4$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ImageKt.Image(painterResource, "background", GraphicsLayerModifierKt.graphicsLayer(aspectRatio$default, (Function1) it$iv5), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 16287963, "C119@4049L351,138@4842L68,128@4413L512:TribeeSteamHasBound.kt#k3l5ii");
            TribeeSteamNavigationKt.TribeeSteamNavigation(null, ((Number) progress.getValue()).floatValue(), true, ((Number) progress.getValue()).floatValue() > 0.75f, userInfo, state.getThreeDot(), function1, function12, $composer3, (($dirty2 << 18) & 3670016) | 384 | (($dirty2 << 15) & 29360128), 1);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            boolean isMaster = state.isMaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2078759968, "CC(remember):TribeeSteamHasBound.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit TribeeSteamDataContent$lambda$4$1$0$0;
                        TribeeSteamDataContent$lambda$4$1$0$0 = TribeeSteamHasBoundKt.TribeeSteamDataContent$lambda$4$1$0$0(userInfoHeight, ((Integer) obj).intValue());
                        return TribeeSteamDataContent$lambda$4$1$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            TribeeSteamListKt.TribeeSteamList(state, lazyListState, accountInfo, userInfo, games, fillMaxSize$default, isMaster, false, function1, function12, (Function1) it$iv6, $composer3, (($dirty2 >> 3) & 14) | 196608 | (($dirty2 << 24) & 234881024) | (($dirty2 << 21) & 1879048192), 6, 128);
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
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamHasBoundKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamDataContent$lambda$5;
                    TribeeSteamDataContent$lambda$5 = TribeeSteamHasBoundKt.TribeeSteamDataContent$lambda$5(function1, state, function12, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamDataContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float TribeeSteamDataContent$lambda$2$0(LazyListState $lazyListState, MutableIntState $userInfoHeight) {
        if ($lazyListState.getFirstVisibleItemIndex() > 0) {
            return 1.0f;
        }
        return $lazyListState.getFirstVisibleItemScrollOffset() / ($userInfoHeight.getIntValue() / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamDataContent$lambda$3$0(Function1 $onStateAction) {
        KLog_androidKt.getKLog().i("TribeeSteamDataContent", "observeScreenshot");
        $onStateAction.invoke(new TribeeSteamStateAction.StartShare(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamDataContent$lambda$4$0$0(LazyListState $lazyListState, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationY(-RangesKt.coerceAtLeast($lazyListState.getFirstVisibleItemScrollOffset(), 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamDataContent$lambda$4$1$0$0(MutableIntState $userInfoHeight, int it) {
        $userInfoHeight.setIntValue(it);
        return Unit.INSTANCE;
    }
}