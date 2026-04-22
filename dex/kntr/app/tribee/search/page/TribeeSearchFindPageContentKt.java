package kntr.app.tribee.search.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.search.SearchRes;
import bili.resource.search.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.search.base.TribeeSearchDialogKt;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.tribee.search.track.SearchTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeSearchFindPageContent.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0005H\u0007¢\u0006\u0002\u0010\f\u001a%\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001ai\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0005H\u0007¢\u0006\u0002\u0010\u0017\u001a/\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"TribeeSearchFindPageContent", "", "state", "Lkntr/app/tribee/search/state/TribeeSearchState$Find;", "onEvent", "Lkotlin/Function1;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "modifier", "Landroidx/compose/ui/Modifier;", "canExpose", "", "", "(Lkntr/app/tribee/search/state/TribeeSearchState$Find;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "GlobalSearchButton", "onClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SearchHistoryContent", "tribeeId", "searchHistory", "", "onHistoryItemClick", "onClearHistory", "(Ljava/lang/String;Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "HistoryTag", "text", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "search_debug", "isExpanded"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchFindPageContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalSearchButton$lambda$0(Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GlobalSearchButton(function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryTag$lambda$2(String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        HistoryTag(str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$8(String str, List list, Modifier modifier, Function1 function1, Function0 function0, Function1 function12, int i, int i2, Composer composer, int i3) {
        SearchHistoryContent(str, list, modifier, function1, function0, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchFindPageContent$lambda$6(TribeeSearchState.Find find, Function1 function1, Modifier modifier, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSearchFindPageContent(find, function1, modifier, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeSearchFindPageContent$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x038b, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017a, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02e2, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0325, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L69;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSearchFindPageContent(final TribeeSearchState.Find state, final Function1<? super TribeeSearchEvent, Unit> function1, Modifier modifier, Function1<? super String, Boolean> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 canExpose;
        Modifier modifier3;
        Modifier modifier4;
        Function1 canExpose2;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Function1 canExpose3;
        float f;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onEvent");
        Composer $composer3 = $composer.startRestartGroup(1330322806);
        ComposerKt.sourceInformation($composer3, "C(TribeeSearchFindPageContent)N(state,onEvent,modifier,canExpose)67@3118L8,69@3193L7,70@3234L3,70@3238L17,71@3321L11,71@3333L17,72@3405L7,80@3586L164,85@3821L74,74@3418L2263:TribeeSearchFindPageContent.kt#ol2sc8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
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
            canExpose = function12;
        } else if (($changed & 3072) == 0) {
            canExpose = function12;
            $dirty |= $composer3.changedInstance(canExpose) ? 2048 : 1024;
        } else {
            canExpose = function12;
        }
        if (!$composer3.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1460031810, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda28
                        public final Object invoke(Object obj) {
                            boolean TribeeSearchFindPageContent$lambda$0$0;
                            TribeeSearchFindPageContent$lambda$0$0 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$0$0((String) obj);
                            return Boolean.valueOf(TribeeSearchFindPageContent$lambda$0$0);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                canExpose2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                canExpose2 = canExpose;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1330322806, $dirty, -1, "kntr.app.tribee.search.page.TribeeSearchFindPageContent (TribeeSearchFindPageContent.kt:68)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) consume;
            float imeHeight = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer3, 6), $composer3, 0).calculateBottomPadding-D9Ej5fM();
            WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSafeContent(WindowInsets.Companion, $composer3, 6), $composer3, 0).calculateBottomPadding-D9Ej5fM();
            CompositionLocal this_$iv2 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router = (Router) consume2;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1460016678, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1460009248, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(keyboardController);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv) {
                modifier5 = modifier4;
            } else {
                modifier5 = modifier4;
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda29
                public final Object invoke() {
                    Unit TribeeSearchFindPageContent$lambda$2$0;
                    TribeeSearchFindPageContent$lambda$2$0 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$2$0(keyboardController);
                    return TribeeSearchFindPageContent$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(fillMaxSize$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeSearchFindPageContent_u24lambda_u243 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1839498916, "C111@4657L603,110@4615L1060:TribeeSearchFindPageContent.kt#ol2sc8");
            if (state.isShowHistory()) {
                $composer3.startReplaceGroup(1839489212);
                ComposerKt.sourceInformation($composer3, "94@4126L95,97@4256L267,91@3971L606");
                String tribeeId = state.getTribeeId();
                List<String> searchHistory = state.getSearchHistory();
                ComposerKt.sourceInformationMarkerStart($composer3, 474985231, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                boolean invalid$iv2 = ($dirty & 112) == 32;
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv4 = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda30
                    public final Object invoke(Object obj) {
                        Unit TribeeSearchFindPageContent$lambda$3$0$0;
                        TribeeSearchFindPageContent$lambda$3$0$0 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$3$0$0(function1, (String) obj);
                        return TribeeSearchFindPageContent$lambda$3$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                Function1 function13 = (Function1) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 474989563, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                boolean invalid$iv3 = (($dirty & 112) == 32) | $composer3.changedInstance(state);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv5 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda31
                    public final Object invoke() {
                        Unit TribeeSearchFindPageContent$lambda$3$1$0;
                        TribeeSearchFindPageContent$lambda$3$1$0 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$3$1$0(function1, state);
                        return TribeeSearchFindPageContent$lambda$3$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2 = $composer3;
                SearchHistoryContent(tribeeId, searchHistory, null, function13, (Function0) it$iv5, canExpose2, $composer2, ($dirty << 6) & 458752, 4);
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(1835543346);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer2, 475002731, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(state) | $composer3.changedInstance(router);
            Composer $this$cache$iv = $composer2;
            Object it$iv6 = $this$cache$iv.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda32
                public final Object invoke() {
                    Unit TribeeSearchFindPageContent$lambda$3$2$0;
                    TribeeSearchFindPageContent$lambda$3$2$0 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$3$2$0(TribeeSearchState.Find.this, router);
                    return TribeeSearchFindPageContent$lambda$3$2$0;
                }
            };
            $this$cache$iv.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            Function0 function0 = (Function0) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier align = $this$TribeeSearchFindPageContent_u24lambda_u243.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
            if (Dp.compareTo-0680j_4(imeHeight, Dp.constructor-impl(0)) > 0) {
                canExpose3 = canExpose2;
                f = Dp.constructor-impl(Math.max(Dp.constructor-impl(imeHeight - Dp.constructor-impl(16)), Dp.constructor-impl(0)));
            } else {
                canExpose3 = canExpose2;
                f = Dp.constructor-impl(46);
            }
            GlobalSearchButton(function0, PaddingKt.padding-qDBjuR0$default(align, 0.0f, 0.0f, 0.0f, f, 7, (Object) null), $composer2, 0, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (state.isShowClearDialog()) {
                $composer3.startReplaceGroup(1986262023);
                ComposerKt.sourceInformation($composer3, "146@5782L57,147@5864L81,150@5971L229,145@5742L469");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getSearch_global_string_149(SearchRes.INSTANCE.getString()), $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, -1459943865, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                boolean invalid$iv5 = ($dirty & 112) == 32;
                Object it$iv7 = $composer3.rememberedValue();
                if (invalid$iv5 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit TribeeSearchFindPageContent$lambda$4$0;
                            TribeeSearchFindPageContent$lambda$4$0 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$4$0(function1);
                            return TribeeSearchFindPageContent$lambda$4$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                Function0 function02 = (Function0) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -1459940293, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                boolean invalid$iv6 = $composer3.changedInstance(state) | (($dirty & 112) == 32);
                Object it$iv8 = $composer3.rememberedValue();
                if (invalid$iv6 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit TribeeSearchFindPageContent$lambda$5$0;
                            TribeeSearchFindPageContent$lambda$5$0 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$5$0(function1, state);
                            return TribeeSearchFindPageContent$lambda$5$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                TribeeSearchDialogKt.TribeeSearchDialog(stringResource, function02, (Function0) it$iv8, null, null, null, null, false, false, $composer3, 0, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            } else {
                $composer3.startReplaceGroup(1980559852);
            }
            $composer3.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            canExpose = canExpose3;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function14 = canExpose;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchFindPageContent$lambda$6;
                    TribeeSearchFindPageContent$lambda$6 = TribeeSearchFindPageContentKt.TribeeSearchFindPageContent$lambda$6(TribeeSearchState.Find.this, function1, modifier6, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchFindPageContent$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchFindPageContent$lambda$2$0(SoftwareKeyboardController $keyboardController) {
        if ($keyboardController != null) {
            $keyboardController.hide();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchFindPageContent$lambda$3$0$0(Function1 $onEvent, String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        $onEvent.invoke(new TribeeSearchEvent.DoSearch(keyword));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchFindPageContent$lambda$3$1$0(Function1 $onEvent, TribeeSearchState.Find $state) {
        $onEvent.invoke(TribeeSearchEvent.ShowClearHistoryDialog.INSTANCE);
        SearchTrackerKt.searchDiscoverHistoryClick$default($state.getTribeeId(), "", "clear_button", 0, 0, 24, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchFindPageContent$lambda$3$2$0(TribeeSearchState.Find $state, Router $router) {
        String query = $state.getSearchBarState().getQuery();
        String globalSearchUri = $state.getGlobalSearchUri();
        Uri uri = UrisKt.appendQueryDroppingNull(UrisKt.toUri(globalSearchUri).buildUpon(), "keyword", query).build();
        $router.launch(uri);
        SearchTrackerKt.searchDiscoverMainSearchClick($state.getTribeeId(), query);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchFindPageContent$lambda$4$0(Function1 $onEvent) {
        $onEvent.invoke(TribeeSearchEvent.HideClearHistoryDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchFindPageContent$lambda$5$0(Function1 $onEvent, TribeeSearchState.Find $state) {
        $onEvent.invoke(TribeeSearchEvent.ConfirmClearHistory.INSTANCE);
        SearchTrackerKt.searchDiscoverHistoryClick$default($state.getTribeeId(), "", "clear", 0, 0, 24, null);
        return Unit.INSTANCE;
    }

    public static final void GlobalSearchButton(final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(1346399060);
        ComposerKt.sourceInformation($composer3, "C(GlobalSearchButton)N(onClick,modifier)172@6498L6,167@6325L948:TribeeSearchFindPageContent.kt#ol2sc8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
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
                ComposerKt.traceEventStart(1346399060, $dirty2, -1, "kntr.app.tribee.search.page.GlobalSearchButton (TribeeSearchFindPageContent.kt:166)");
            }
            Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            SurfaceKt.Surface-o_FOJdg(function0, SizeKt.size-VpY3zN4(modifier3, Dp.constructor-impl(110), Dp.constructor-impl(30)), false, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(4), (BorderStroke) null, (MutableInteractionSource) null, ComposableSingletons$TribeeSearchFindPageContentKt.INSTANCE.getLambda$1460438761$search_debug(), $composer2, ($dirty2 & 14) | 12582912, 6, 868);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit GlobalSearchButton$lambda$0;
                    GlobalSearchButton$lambda$0 = TribeeSearchFindPageContentKt.GlobalSearchButton$lambda$0(function0, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GlobalSearchButton$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SearchHistoryContent$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c0  */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SearchHistoryContent(final String tribeeId, final List<String> list, Modifier modifier, Function1<? super String, Unit> function1, Function0<Unit> function0, Function1<? super String, Boolean> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 onHistoryItemClick;
        Function0 function02;
        Function1 function13;
        Function1 canExpose;
        Modifier modifier3;
        Function0 onClearHistory;
        Modifier modifier4;
        boolean invalid$iv;
        Object value$iv;
        int i2;
        Modifier modifier5;
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(list, "searchHistory");
        Composer $composer2 = $composer.startRestartGroup(-1019681633);
        ComposerKt.sourceInformation($composer2, "C(SearchHistoryContent)N(tribeeId,searchHistory,modifier,onHistoryItemClick,onClearHistory,canExpose)203@7485L2,204@7522L2,205@7563L8,207@7599L34,208@7658L23,209@7723L7,212@7785L187,212@7755L217,221@8036L8618,221@8019L8635:TribeeSearchFindPageContent.kt#ol2sc8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(tribeeId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onHistoryItemClick = function1;
        } else if (($changed & 3072) == 0) {
            onHistoryItemClick = function1;
            $dirty |= $composer2.changedInstance(onHistoryItemClick) ? 2048 : 1024;
        } else {
            onHistoryItemClick = function1;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            function02 = function0;
        } else if (($changed & 24576) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 16384 : 8192;
        } else {
            function02 = function0;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            function13 = function12;
        } else if (($changed & 196608) == 0) {
            function13 = function12;
            $dirty |= $composer2.changedInstance(function13) ? 131072 : 65536;
        } else {
            function13 = function12;
        }
        if ($composer2.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -661500735, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj) {
                            Unit SearchHistoryContent$lambda$0$0;
                            SearchHistoryContent$lambda$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$0$0((String) obj);
                            return SearchHistoryContent$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                }
                Function1 onHistoryItemClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onHistoryItemClick = onHistoryItemClick2;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -661499551, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                }
                Function0 onClearHistory2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClearHistory = onClearHistory2;
            } else {
                onClearHistory = function02;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -661498233, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj) {
                            boolean SearchHistoryContent$lambda$2$0;
                            SearchHistoryContent$lambda$2$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$2$0((String) obj);
                            return Boolean.valueOf(SearchHistoryContent$lambda$2$0);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv3 = value$iv4;
                }
                Function1 canExpose2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                canExpose = canExpose2;
            } else {
                canExpose = function13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1019681633, $dirty, -1, "kntr.app.tribee.search.page.SearchHistoryContent (TribeeSearchFindPageContent.kt:206)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -661497055, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            final MutableState isExpanded$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FocusManager focusManager = (FocusManager) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, -661490950, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(lazyListState) | $composer2.changedInstance(focusManager);
            Object it$iv5 = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv5 != Composer.Companion.getEmpty()) {
                modifier4 = null;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(lazyListState, (Function2) it$iv5, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -661474487, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                invalid$iv = $composer2.changedInstance(list) | (($dirty & 896) != 256) | $composer2.changed(lazyListState) | ((57344 & $dirty) != 16384) | (($dirty & 14) != 4) | ((458752 & $dirty) != 131072) | (($dirty & 7168) != 2048);
                value$iv = $composer2.rememberedValue();
                if (!invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    final Modifier modifier6 = modifier3;
                    i2 = 0;
                    final Function0 function03 = onClearHistory;
                    final Function1 function14 = canExpose;
                    final Function1 function15 = onHistoryItemClick;
                    modifier5 = null;
                    value$iv = new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj, Object obj2) {
                            MeasureResult SearchHistoryContent$lambda$7$0;
                            SearchHistoryContent$lambda$7$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0(list, modifier6, lazyListState, function03, tribeeId, function14, function15, isExpanded$delegate, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                            return SearchHistoryContent$lambda$7$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    i2 = 0;
                    modifier5 = modifier4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SubcomposeLayoutKt.SubcomposeLayout(modifier5, (Function2) value$iv, $composer2, i2, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            modifier4 = null;
            Object value$iv6 = (Function2) new TribeeSearchFindPageContentKt$SearchHistoryContent$4$1(lazyListState, focusManager, null);
            $composer2.updateRememberedValue(value$iv6);
            it$iv5 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(lazyListState, (Function2) it$iv5, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -661474487, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            invalid$iv = $composer2.changedInstance(list) | (($dirty & 896) != 256) | $composer2.changed(lazyListState) | ((57344 & $dirty) != 16384) | (($dirty & 14) != 4) | ((458752 & $dirty) != 131072) | (($dirty & 7168) != 2048);
            value$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final Modifier modifier62 = modifier3;
            i2 = 0;
            final Function0 function032 = onClearHistory;
            final Function1 function142 = canExpose;
            final Function1 function152 = onHistoryItemClick;
            modifier5 = null;
            value$iv = new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    MeasureResult SearchHistoryContent$lambda$7$0;
                    SearchHistoryContent$lambda$7$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0(list, modifier62, lazyListState, function032, tribeeId, function142, function152, isExpanded$delegate, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    return SearchHistoryContent$lambda$7$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(modifier5, (Function2) value$iv, $composer2, i2, 1);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            canExpose = function13;
            modifier3 = modifier2;
            onClearHistory = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function1 function16 = onHistoryItemClick;
            final Function0 function04 = onClearHistory;
            final Function1 function17 = canExpose;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit SearchHistoryContent$lambda$8;
                    SearchHistoryContent$lambda$8 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$8(tribeeId, list, modifier7, function16, function04, function17, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SearchHistoryContent$lambda$8;
                }
            });
        }
    }

    private static final boolean SearchHistoryContent$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void SearchHistoryContent$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult SearchHistoryContent$lambda$7$0(final List $searchHistory, final Modifier $modifier, final LazyListState $lazyListState, final Function0 $onClearHistory, final String $tribeeId, final Function1 $canExpose, final Function1 $onHistoryItemClick, final MutableState $isExpanded$delegate, SubcomposeMeasureScope $this$SubcomposeLayout, Constraints constraints) {
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        List twoLineContent = $this$SubcomposeLayout.subcompose("measure_two_line", ComposableLambdaKt.composableLambdaInstance(-1691184486, true, new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Unit SearchHistoryContent$lambda$7$0$0;
                SearchHistoryContent$lambda$7$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$0($searchHistory, (Composer) obj, ((Integer) obj2).intValue());
                return SearchHistoryContent$lambda$7$0$0;
            }
        }));
        Placeable twoLinePlaceable = ((Measurable) twoLineContent.get(0)).measure-BRTryo0(constraints.unbox-impl());
        List fullContent = $this$SubcomposeLayout.subcompose("measure_full", ComposableLambdaKt.composableLambdaInstance(-143308813, true, new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                Unit SearchHistoryContent$lambda$7$0$1;
                SearchHistoryContent$lambda$7$0$1 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$1($searchHistory, (Composer) obj, ((Integer) obj2).intValue());
                return SearchHistoryContent$lambda$7$0$1;
            }
        }));
        Placeable fullPlaceable = ((Measurable) fullContent.get(0)).measure-BRTryo0(constraints.unbox-impl());
        final boolean needsExpansion = fullPlaceable.getHeight() > twoLinePlaceable.getHeight();
        List actualContent = $this$SubcomposeLayout.subcompose("actual", ComposableLambdaKt.composableLambdaInstance(-882426668, true, new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit SearchHistoryContent$lambda$7$0$2;
                SearchHistoryContent$lambda$7$0$2 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2($modifier, $lazyListState, $onClearHistory, needsExpansion, $tribeeId, $searchHistory, $canExpose, $onHistoryItemClick, $isExpanded$delegate, (Composer) obj, ((Integer) obj2).intValue());
                return SearchHistoryContent$lambda$7$0$2;
            }
        }));
        final Placeable contentPlaceable = ((Measurable) actualContent.get(0)).measure-BRTryo0(constraints.unbox-impl());
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, contentPlaceable.getWidth(), contentPlaceable.getHeight(), (Map) null, new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit SearchHistoryContent$lambda$7$0$3;
                SearchHistoryContent$lambda$7$0$3 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$3(contentPlaceable, (Placeable.PlacementScope) obj);
                return SearchHistoryContent$lambda$7$0$3;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$0(final List $searchHistory, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C233@8564L244,225@8169L639:TribeeSearchFindPageContent.kt#ol2sc8");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1691184486, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:225)");
            }
            FlowLayoutKt.FlowRow(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 2, ComposableLambdaKt.rememberComposableLambda(264435477, true, new Function3() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SearchHistoryContent$lambda$7$0$0$0;
                    SearchHistoryContent$lambda$7$0$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$0$0($searchHistory, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SearchHistoryContent$lambda$7$0$0$0;
                }
            }, $composer, 54), $composer, 1769910, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$0$0(List $searchHistory, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*237@8739L2,235@8645L123:TribeeSearchFindPageContent.kt#ol2sc8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(264435477, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:234)");
            }
            List $this$forEach$iv = $searchHistory;
            for (Object element$iv : $this$forEach$iv) {
                String keyword = (String) element$iv;
                ComposerKt.sourceInformationMarkerStart($composer, -1133384729, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                HistoryTag(keyword, null, (Function0) it$iv, $composer, 384, 2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$1(final List $searchHistory, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C256@9410L244,248@9003L651:TribeeSearchFindPageContent.kt#ol2sc8");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-143308813, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:248)");
            }
            FlowLayoutKt.FlowRow(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, (int) FlowControlConfig.RETRY_MAX_TIMES, ComposableLambdaKt.rememberComposableLambda(-342053544, true, new Function3() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SearchHistoryContent$lambda$7$0$1$0;
                    SearchHistoryContent$lambda$7$0$1$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$1$0($searchHistory, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SearchHistoryContent$lambda$7$0$1$0;
                }
            }, $composer, 54), $composer, 1769910, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$1$0(List $searchHistory, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*260@9585L2,258@9491L123:TribeeSearchFindPageContent.kt#ol2sc8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-342053544, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:257)");
            }
            List $this$forEach$iv = $searchHistory;
            for (Object element$iv : $this$forEach$iv) {
                String keyword = (String) element$iv;
                ComposerKt.sourceInformationMarkerStart($composer, -436350966, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                HistoryTag(keyword, null, (Function0) it$iv, $composer, 384, 2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2(Modifier $modifier, LazyListState $lazyListState, final Function0 $onClearHistory, final boolean $needsExpansion, final String $tribeeId, final List $searchHistory, final Function1 $canExpose, final Function1 $onHistoryItemClick, final MutableState $isExpanded$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C279@10141L6305,274@9959L6487:TribeeSearchFindPageContent.kt#ol2sc8");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-882426668, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:274)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default($modifier, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1903457931, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onClearHistory) | $composer.changed($needsExpansion) | $composer.changed($tribeeId) | $composer.changedInstance($searchHistory) | $composer.changed($canExpose) | $composer.changed($onHistoryItemClick);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit SearchHistoryContent$lambda$7$0$2$0$0;
                        SearchHistoryContent$lambda$7$0$2$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0($onClearHistory, $needsExpansion, $tribeeId, $isExpanded$delegate, $searchHistory, $canExpose, $onHistoryItemClick, (LazyListScope) obj);
                        return SearchHistoryContent$lambda$7$0$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(fillMaxWidth$default, $lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0(final Function0 $onClearHistory, final boolean $needsExpansion, final String $tribeeId, final MutableState $isExpanded$delegate, final List $searchHistory, final Function1 $canExpose, final Function1 $onHistoryItemClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.stickyHeader$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-288595083, true, new Function4() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit SearchHistoryContent$lambda$7$0$2$0$0$0;
                SearchHistoryContent$lambda$7$0$2$0$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$0($onClearHistory, $needsExpansion, $tribeeId, $isExpanded$delegate, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return SearchHistoryContent$lambda$7$0$2$0$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(442029673, true, new Function3() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SearchHistoryContent$lambda$7$0$2$0$0$1;
                SearchHistoryContent$lambda$7$0$2$0$0$1 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$1($isExpanded$delegate, $searchHistory, $canExpose, $tribeeId, $onHistoryItemClick, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SearchHistoryContent$lambda$7$0$2$0$0$1;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$TribeeSearchFindPageContentKt.INSTANCE.m1068getLambda$1163238176$search_debug(), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0325, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0$0(final Function0 $onClearHistory, boolean $needsExpansion, final String $tribeeId, final MutableState $isExpanded$delegate, LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Painter painter;
        Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
        ComposerKt.sourceInformation($composer, "CN(it)287@10495L6,282@10249L3602:TribeeSearchFindPageContent.kt#ol2sc8");
        if ($composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288595083, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:282)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(34)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -750753680, "C293@10828L56,296@11050L6,292@10783L310,299@11123L2702:TribeeSearchFindPageContent.kt#ol2sc8");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getSearch_global_string_38(SearchRes.INSTANCE.getString()), $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 0, 262058);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv$iv = Modifier.Companion;
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -388231848, "C305@11462L21,307@11601L6,311@11830L20,304@11397L488:TribeeSearchFindPageContent.kt#ol2sc8");
            Painter trash_delete_line_500 = BiliIconfont.INSTANCE.getTrash_delete_line_500($composer, 6);
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_medium-0d7_KjU();
            Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer, -982343455, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onClearHistory);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda26
                public final Object invoke() {
                    Unit SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$0$0;
                    SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$0$0($onClearHistory);
                    return SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconKt.Icon-ww6aTOc(trash_delete_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer, Painter.$stable | 48, 0);
            if ($needsExpansion) {
                $composer.startReplaceGroup(-387659093);
                ComposerKt.sourceInformation($composer, "321@12338L6,317@12074L323,333@12992L6,337@13237L485,325@12482L1279");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl((float) 0.5d), Dp.constructor-impl(8)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
                if (SearchHistoryContent$lambda$4($isExpanded$delegate)) {
                    $composer.startReplaceGroup(-387110703);
                    ComposerKt.sourceInformation($composer, "328@12661L23");
                    Painter arrow_collapse_line_500 = BiliIconfont.INSTANCE.getArrow_collapse_line_500($composer, 6);
                    $composer.endReplaceGroup();
                    painter = arrow_collapse_line_500;
                } else {
                    $composer.startReplaceGroup(-386973869);
                    ComposerKt.sourceInformation($composer, "330@12799L21");
                    Painter arrow_expand_line_500 = BiliIconfont.INSTANCE.getArrow_expand_line_500($composer, 6);
                    $composer.endReplaceGroup();
                    painter = arrow_expand_line_500;
                }
                long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_medium-0d7_KjU();
                Modifier modifier2 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
                ComposerKt.sourceInformationMarkerStart($composer, -982297966, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed($tribeeId);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda27
                        public final Object invoke() {
                            Unit SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$1$0;
                            SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$1$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$1$0($tribeeId, $isExpanded$delegate);
                            return SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconKt.Icon-ww6aTOc(painter, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), j2, $composer, Painter.$stable | 48, 0);
            } else {
                $composer.startReplaceGroup(-399613003);
            }
            $composer.endReplaceGroup();
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
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$0$0(Function0 $onClearHistory) {
        $onClearHistory.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0$0$0$0$1$0(String $tribeeId, MutableState $isExpanded$delegate) {
        SearchTrackerKt.searchDiscoverHistoryClick$default($tribeeId, "", SearchHistoryContent$lambda$4($isExpanded$delegate) ? "retract" : "spread", 0, 0, 24, null);
        SearchHistoryContent$lambda$5($isExpanded$delegate, !SearchHistoryContent$lambda$4($isExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0$1(MutableState $isExpanded$delegate, final List $searchHistory, final Function1 $canExpose, final String $tribeeId, final Function1 $onHistoryItemClick, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C361@14443L1804,353@13958L2289:TribeeSearchFindPageContent.kt#ol2sc8");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442029673, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:353)");
            }
            FlowLayoutKt.FlowRow(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, SearchHistoryContent$lambda$4($isExpanded$delegate) ? FlowControlConfig.RETRY_MAX_TIMES : 2, ComposableLambdaKt.rememberComposableLambda(1600017870, true, new Function3() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SearchHistoryContent$lambda$7$0$2$0$0$1$0;
                    SearchHistoryContent$lambda$7$0$2$0$0$1$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$1$0($searchHistory, $canExpose, $tribeeId, $onHistoryItemClick, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SearchHistoryContent$lambda$7$0$2$0$0$1$0;
                }
            }, $composer, 54), $composer, 1573302, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0$1$0(List $searchHistory, final Function1 $canExpose, final String $tribeeId, final Function1 $onHistoryItemClick, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        List list = $searchHistory;
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*376@15304L852,366@14729L470,364@14619L1572:TribeeSearchFindPageContent.kt#ol2sc8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1600017870, $changed, -1, "kntr.app.tribee.search.page.SearchHistoryContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchFindPageContent.kt:362)");
            }
            List $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                final String keyword = (String) element$iv;
                final int index = list.indexOf(keyword) + 1;
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, 1818045202, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                boolean invalid$iv = $composer.changed($canExpose) | $composer.changed(keyword) | $composer.changed($tribeeId) | $composer.changed(index);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function3() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda23
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            MeasureResult SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0;
                            SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0($canExpose, keyword, $tribeeId, index, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            return SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier layout = LayoutModifierKt.layout(modifier, (Function3) it$iv);
                ComposerKt.sourceInformationMarkerStart($composer, 1818026420, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed($onHistoryItemClick) | $composer.changed(keyword) | $composer.changed($tribeeId) | $composer.changed(index);
                Object it$iv2 = $composer.rememberedValue();
                if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    HistoryTag(keyword, layout, (Function0) it$iv2, $composer, 0, 0);
                    list = $searchHistory;
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda24
                    public final Object invoke() {
                        Unit SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$1$0;
                        SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$1$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$1$0($onHistoryItemClick, keyword, $tribeeId, index);
                        return SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                HistoryTag(keyword, layout, (Function0) it$iv2, $composer, 0, 0);
                list = $searchHistory;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$1$0(Function1 $onHistoryItemClick, String $keyword, String $tribeeId, int $index) {
        $onHistoryItemClick.invoke($keyword);
        SearchTrackerKt.searchDiscoverHistoryClick$default($tribeeId, $keyword, "word", 0, $index, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0(final Function1 $canExpose, final String $keyword, final String $tribeeId, final int $index, MeasureScope $this$layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeable = measurable.measure-BRTryo0(constraints.unbox-impl());
        return MeasureScope.-CC.layout$default($this$layout, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0$0;
                SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0$0 = TribeeSearchFindPageContentKt.SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0$0(placeable, $canExpose, $keyword, $tribeeId, $index, (Placeable.PlacementScope) obj);
                return SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0$0;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$2$0$0$1$0$0$0$0$0(Placeable $placeable, Function1 $canExpose, String $keyword, String $tribeeId, int $index, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.place$default($this$layout, $placeable, 0, 0, 0.0f, 4, (Object) null);
        if (((Boolean) $canExpose.invoke($keyword)).booleanValue()) {
            SearchTrackerKt.searchDiscoverHistoryExposure$default($tribeeId, $keyword, 0, $index, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchHistoryContent$lambda$7$0$3(Placeable $contentPlaceable, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.place$default($this$layout, $contentPlaceable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    public static final void HistoryTag(final String text, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 onClick;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-1981702190);
        ComposerKt.sourceInformation($composer3, "C(HistoryTag)N(text,modifier,onClick)413@16765L2,421@16959L6,415@16777L603:TribeeSearchFindPageContent.kt#ol2sc8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onClick = function02;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, -1745289420, "CC(remember):TribeeSearchFindPageContent.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda19
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onClick = onClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1981702190, $dirty2, -1, "kntr.app.tribee.search.page.HistoryTag (TribeeSearchFindPageContent.kt:414)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.widthIn-VpY3zN4$default(modifier4, 0.0f, Dp.constructor-impl(117), 1, (Object) null), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_bg_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), false, (String) null, (Role) null, (MutableInteractionSource) null, onClick, 15, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1081654415, "C430@17279L6,427@17188L186:TribeeSearchFindPageContent.kt#ol2sc8");
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 24576, 24960, 241642);
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
            modifier3 = modifier2;
            onClick = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.page.TribeeSearchFindPageContentKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit HistoryTag$lambda$2;
                    HistoryTag$lambda$2 = TribeeSearchFindPageContentKt.HistoryTag$lambda$2(text, modifier5, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HistoryTag$lambda$2;
                }
            });
        }
    }
}