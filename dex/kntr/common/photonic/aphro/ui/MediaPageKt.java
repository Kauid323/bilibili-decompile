package kntr.common.photonic.aphro.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.ui.component.AlbumListKt;
import kntr.common.photonic.aphro.ui.component.CurrentAlbumKt;
import kntr.common.photonic.aphro.ui.component.MediaListKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaPage.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"MediaSelectPage", "", "state", "Lkntr/common/photonic/aphro/core/AphroState;", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/core/AphroState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MediaPageTopNavbar", "albumExpanded", "", "onExpandAlbum", "onBackRequest", "Lkotlin/Function0;", "(Lkntr/common/photonic/aphro/core/AphroState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "backAlpha", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaPageTopNavbar$lambda$2(AphroState aphroState, boolean z, Function1 function1, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        MediaPageTopNavbar(aphroState, z, function1, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectPage$lambda$4(AphroState aphroState, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MediaSelectPage(aphroState, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void MediaSelectPage(final AphroState state, final Function1<? super AphroAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-1042997603);
        ComposerKt.sourceInformation($composer2, "C(MediaSelectPage)N(state,onAction,modifier)46@1948L98,49@2061L1676,49@2051L1686:MediaPage.kt#3c04ha");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1042997603, $dirty2, -1, "kntr.common.photonic.aphro.ui.MediaSelectPage (MediaPage.kt:45)");
            }
            AphroState.AphroContent aphroContent = state instanceof AphroState.AphroContent ? (AphroState.AphroContent) state : null;
            AlbumInfo selectedAlbum = aphroContent != null ? aphroContent.getSelectedAlbum() : null;
            ComposerKt.sourceInformationMarkerStart($composer2, -1593311777, "CC(remember):MediaPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(selectedAlbum);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState albumExpanded$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-51673115, true, new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectPage$lambda$3;
                    MediaSelectPage$lambda$3 = MediaPageKt.MediaSelectPage$lambda$3(modifier4, state, albumExpanded$delegate, function1, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectPage$lambda$3;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectPage$lambda$4;
                    MediaSelectPage$lambda$4 = MediaPageKt.MediaSelectPage$lambda$4(AphroState.this, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectPage$lambda$4;
                }
            });
        }
    }

    private static final boolean MediaSelectPage$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void MediaSelectPage$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectPage$lambda$3(Modifier $modifier, final AphroState $state, final MutableState $albumExpanded$delegate, final Function1 $onAction, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C54@2206L6,55@2240L215,62@2467L1264,50@2071L1660:MediaPage.kt#3c04ha");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-51673115, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectPage.<anonymous> (MediaPage.kt:50)");
            }
            ScaffoldKt.Scaffold-TvnljyQ(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(-1732259159, true, new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectPage$lambda$3$0;
                    MediaSelectPage$lambda$3$0 = MediaPageKt.MediaSelectPage$lambda$3$0(AphroState.this, $albumExpanded$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectPage$lambda$3$0;
                }
            }, $composer, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1770365452, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MediaSelectPage$lambda$3$1;
                    MediaSelectPage$lambda$3$1 = MediaPageKt.MediaSelectPage$lambda$3$1(AphroState.this, $onAction, $albumExpanded$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MediaSelectPage$lambda$3$1;
                }
            }, $composer, 54), $composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectPage$lambda$3$0(AphroState $state, final MutableState $albumExpanded$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C59@2400L22,56@2258L183:MediaPage.kt#3c04ha");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1732259159, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectPage.<anonymous>.<anonymous> (MediaPage.kt:56)");
            }
            boolean MediaSelectPage$lambda$1 = MediaSelectPage$lambda$1($albumExpanded$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1746264191, "CC(remember):MediaPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($albumExpanded$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit MediaSelectPage$lambda$3$0$0$0;
                        MediaSelectPage$lambda$3$0$0$0 = MediaPageKt.MediaSelectPage$lambda$3$0$0$0($albumExpanded$delegate, ((Boolean) obj).booleanValue());
                        return MediaSelectPage$lambda$3$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            MediaPageTopNavbar($state, MediaSelectPage$lambda$1, (Function1) it$iv, null, null, $composer, 0, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectPage$lambda$3$0$0$0(MutableState $albumExpanded$delegate, boolean it) {
        MediaSelectPage$lambda$2($albumExpanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectPage$lambda$3$1(final AphroState $state, final Function1 $onAction, MutableState $albumExpanded$delegate, PaddingValues it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)65@2526L1195:MediaPage.kt#3c04ha");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1770365452, $dirty, -1, "kntr.common.photonic.aphro.ui.MediaSelectPage.<anonymous>.<anonymous> (MediaPage.kt:65)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, it.calculateTopPadding-D9Ej5fM(), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1647462690, "C:MediaPage.kt#3c04ha");
            if ($state instanceof AphroState.AphroContent) {
                $composer.startReplaceGroup(-1647426173);
                ComposerKt.sourceInformation($composer, "72@2784L280,88@3431L258,83@3127L562");
                MediaListKt.m2264MediaListau3_HiA((AphroState.AphroContent) $state, $onAction, SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 0.0f), 0.0f, 1, (Object) null), false, false, null, 0.0f, $composer, 384, BackoffConfigKt.MAX_DELAY_SECONDS);
                AnimatedVisibilityKt.AnimatedVisibility(MediaSelectPage$lambda$1($albumExpanded$delegate), ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1606112293, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit MediaSelectPage$lambda$3$1$0$0;
                        MediaSelectPage$lambda$3$1$0$0 = MediaPageKt.MediaSelectPage$lambda$3$1$0$0(AphroState.this, $onAction, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return MediaSelectPage$lambda$3$1$0$0;
                    }
                }, $composer, 54), $composer, 200112, 16);
            } else {
                $composer.startReplaceGroup(-1650196364);
            }
            $composer.endReplaceGroup();
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
    public static final Unit MediaSelectPage$lambda$3$1$0$0(AphroState $state, Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C90@3524L6,89@3457L210:MediaPage.kt#3c04ha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1606112293, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaPage.kt:89)");
        }
        AlbumListKt.m2251AlbumListpHQ97Tc(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), ((AphroState.AphroContent) $state).getAlbumList(), $onAction, null, 0.0f, $composer, 0, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0374, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MediaPageTopNavbar(final AphroState state, final boolean albumExpanded, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Modifier modifier$iv$iv;
        Function0 onBackRequest;
        Modifier modifier3;
        final Function0 onBackRequest2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer2;
        Composer $composer$iv2;
        Composer $composer$iv$iv2;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv$iv3;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onExpandAlbum");
        Composer $composer4 = $composer.startRestartGroup(1345211758);
        ComposerKt.sourceInformation($composer4, "C(MediaPageTopNavbar)N(state,albumExpanded,onExpandAlbum,modifier,onBackRequest)107@3933L3,113@4057L11,109@3946L1659:MediaPage.kt#3c04ha");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(albumExpanded) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            function02 = function0;
        } else if (($changed & 24576) == 0) {
            function02 = function0;
            $dirty |= $composer4.changedInstance(function02) ? 16384 : 8192;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer4.skipToGroupEnd();
            modifier$iv$iv = modifier2;
            onBackRequest = function02;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -36650895, "CC(remember):MediaPage.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onBackRequest3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onBackRequest2 = onBackRequest3;
            } else {
                onBackRequest2 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1345211758, $dirty2, -1, "kntr.common.photonic.aphro.ui.MediaPageTopNavbar (MediaPage.kt:108)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getAppBarStyle($composer4, BiliTheme.$stable).getAppBarHeight-D9Ej5fM());
            Alignment contentAlignment$iv = Alignment.Companion.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1123470247, "C116@4151L1372,153@5588L6,153@5532L67:MediaPage.kt#3c04ha");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i7 = ((438 >> 6) & 112) | 6;
            RowScope $this$MediaPageTopNavbar_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 849912333, "C121@4348L156,131@4734L19,125@4517L580:MediaPage.kt#3c04ha");
            State backAlpha$delegate = AnimateAsStateKt.animateFloatAsState(albumExpanded ? 0.0f : 1.0f, AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, (String) null, (Function1) null, $composer4, 48, 28);
            Modifier alpha = AlphaKt.alpha(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), MediaPageTopNavbar$lambda$1$0$0(backAlpha$delegate));
            ComposerKt.sourceInformationMarkerStart($composer4, -803855733, "CC(remember):MediaPage.kt#9igjgp");
            boolean invalid$iv = (57344 & $dirty2) == 16384;
            Object it$iv2 = $composer4.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit MediaPageTopNavbar$lambda$1$0$1$0;
                    MediaPageTopNavbar$lambda$1$0$1$0 = MediaPageKt.MediaPageTopNavbar$lambda$1$0$1$0(onBackRequest2);
                    return MediaPageTopNavbar$lambda$1$0$1$0;
                }
            };
            $composer4.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(alpha, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            onBackRequest = onBackRequest2;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i9 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 2053592722, "C135@4889L24,137@5005L6,134@4840L243:MediaPage.kt#3c04ha");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (state instanceof AphroState.AphroContent) {
                $composer4.startReplaceGroup(850697469);
                ComposerKt.sourceInformation($composer4, "142@5166L333");
                $composer$iv2 = $composer4;
                $composer$iv = $composer4;
                $composer$iv$iv$iv2 = $composer4;
                $composer$iv$iv = $composer4;
                $composer$iv$iv$iv = $composer4;
                $composer2 = $composer4;
                $composer$iv$iv2 = $composer4;
                $composer$iv$iv3 = $composer4;
                CurrentAlbumKt.CurrentAlbum((AphroState.AphroContent) state, albumExpanded, function1, PaddingKt.padding-qDBjuR0$default($this$MediaPageTopNavbar_u24lambda_u241_u240.weight(Modifier.Companion, 1.0f, true), Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(56), 0.0f, 10, (Object) null), $composer4, ($dirty2 & 896) | ($dirty2 & 14) | ($dirty2 & 112), 0);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            } else {
                $composer$iv$iv = $composer4;
                $composer$iv$iv$iv = $composer4;
                $composer$iv = $composer4;
                $composer2 = $composer4;
                $composer$iv2 = $composer4;
                $composer$iv$iv2 = $composer4;
                $composer$iv$iv$iv2 = $composer4;
                $composer$iv$iv3 = $composer4;
                $composer3 = $composer4;
                $composer3.startReplaceGroup(845578346);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa2-0d7_KjU(), $composer2, 48, 1);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier$iv$iv;
            final Function0 function03 = onBackRequest;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaPageTopNavbar$lambda$2;
                    MediaPageTopNavbar$lambda$2 = MediaPageKt.MediaPageTopNavbar$lambda$2(AphroState.this, albumExpanded, function1, modifier4, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaPageTopNavbar$lambda$2;
                }
            });
        }
    }

    private static final float MediaPageTopNavbar$lambda$1$0$0(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaPageTopNavbar$lambda$1$0$1$0(Function0 $onBackRequest) {
        $onBackRequest.invoke();
        return Unit.INSTANCE;
    }
}