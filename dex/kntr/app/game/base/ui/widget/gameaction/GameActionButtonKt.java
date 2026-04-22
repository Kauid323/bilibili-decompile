package kntr.app.game.base.ui.widget.gameaction;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.util.NumberExtKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.game.base.ui.localproviders.GameLocalProvidersKt;
import kntr.app.game.base.ui.widget.gameaction.provider.GameActionStateProvider;
import kntr.app.game.base.ui.widget.gameaction.provider.GameActionStateProviderKt;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionExt_androidKt;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionState;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.game.base.ui.generated.resources.Res;
import srcs.app.game.base.ui.generated.resources.String0_commonMainKt;

/* compiled from: GameActionButton.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a?\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0013\u001a=\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a+\u0010\u001e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0016H\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"GameActionButton", RoomRecommendViewModel.EMPTY_CURSOR, "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;", "actionListener", "Lkntr/app/game/base/ui/widget/gameaction/OnActionListener;", "style", "Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;", "(Lcom/bilibili/biligame/kntr/common/bean/KBiligame;Landroidx/compose/ui/Modifier;Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;Lkntr/app/game/base/ui/widget/gameaction/OnActionListener;Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;Landroidx/compose/runtime/Composer;II)V", "PayActionLayout", "(Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DownloadLayout", "DownloadProgressBackground", "progress", RoomRecommendViewModel.EMPTY_CURSOR, "(ILkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;Landroidx/compose/runtime/Composer;I)V", "buildMainBackgroundModifier", "border", RoomRecommendViewModel.EMPTY_CURSOR, "whiteColor", "Landroidx/compose/ui/graphics/Color;", "normalColor", "disableColor", "disable", "buildMainBackgroundModifier-aQc6oBg", "(Landroidx/compose/ui/Modifier;ZJJJZ)Landroidx/compose/ui/Modifier;", "buildDownloadBackgroundModifier", "color", "inDownload", "buildDownloadBackgroundModifier-9LQNqLg", "(Landroidx/compose/ui/Modifier;ZJZ)Landroidx/compose/ui/Modifier;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameActionButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadLayout$lambda$2(GameActionState gameActionState, GameActionButtonStyle gameActionButtonStyle, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DownloadLayout(gameActionState, gameActionButtonStyle, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadProgressBackground$lambda$1(int i, GameActionButtonStyle gameActionButtonStyle, int i2, Composer composer, int i3) {
        DownloadProgressBackground(i, gameActionButtonStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameActionButton$lambda$0(KBiligame kBiligame, Modifier modifier, GameActionState gameActionState, OnActionListener onActionListener, GameActionButtonStyle gameActionButtonStyle, int i, int i2, Composer composer, int i3) {
        GameActionButton(kBiligame, modifier, gameActionState, onActionListener, gameActionButtonStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameActionButton$lambda$2(KBiligame kBiligame, Modifier modifier, GameActionState gameActionState, OnActionListener onActionListener, GameActionButtonStyle gameActionButtonStyle, int i, int i2, Composer composer, int i3) {
        GameActionButton(kBiligame, modifier, gameActionState, onActionListener, gameActionButtonStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayActionLayout$lambda$2(GameActionState gameActionState, GameActionButtonStyle gameActionButtonStyle, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PayActionLayout(gameActionState, gameActionButtonStyle, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GameActionButton(final KBiligame game, Modifier modifier, GameActionState state, OnActionListener actionListener, GameActionButtonStyle style, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        GameActionState gameActionState;
        Composer $composer2;
        OnActionListener actionListener2;
        GameActionButtonStyle style2;
        Modifier modifier3;
        GameActionState state2;
        Modifier modifier4;
        GameActionState state3;
        OnActionListener actionListener3;
        GameActionButtonStyle style3;
        Modifier modifier5;
        int $dirty;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        long normalTextColor;
        int i2;
        int i3;
        int i4;
        DefaultActionListener actionListener4 = actionListener;
        Composer $composer3 = $composer.startRestartGroup(1810865324);
        ComposerKt.sourceInformation($composer3, "C(GameActionButton)N(game,modifier,state,actionListener,style)69@3054L7,70@3066L1279:GameActionButton.kt#dj1drh");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(game) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                gameActionState = state;
                if ($composer3.changed(gameActionState)) {
                    i4 = 256;
                    $dirty2 |= i4;
                }
            } else {
                gameActionState = state;
            }
            i4 = 128;
            $dirty2 |= i4;
        } else {
            gameActionState = state;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                if (($changed & 4096) == 0 ? $composer3.changed(actionListener4) : $composer3.changedInstance(actionListener4)) {
                    i3 = 2048;
                    $dirty2 |= i3;
                }
            }
            i3 = 1024;
            $dirty2 |= i3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                if ((32768 & $changed) == 0 ? $composer3.changed(style) : $composer3.changedInstance(style)) {
                    i2 = 16384;
                    $dirty2 |= i2;
                }
            }
            i2 = 8192;
            $dirty2 |= i2;
        }
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "62@2829L7");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                actionListener3 = actionListener4;
                modifier5 = modifier2;
                state2 = gameActionState;
                style3 = style;
                $dirty = $dirty2;
            } else {
                if (i5 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) == 0) {
                    state3 = gameActionState;
                } else {
                    CompositionLocal this_$iv = GameActionStateProviderKt.getLocalGameStateProvider();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    state3 = ((GameActionStateProvider) consume).getGameActionState(game);
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    actionListener4 = new DefaultActionListener();
                    $dirty2 &= -7169;
                }
                if ((i & 16) == 0) {
                    actionListener3 = actionListener4;
                    style3 = style;
                    modifier5 = modifier4;
                    state2 = state3;
                    $dirty = $dirty2;
                } else {
                    actionListener3 = actionListener4;
                    style3 = GameActionButtonStyle.Companion.getPink();
                    modifier5 = modifier4;
                    state2 = state3;
                    $dirty = $dirty2 & (-57345);
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1810865324, $dirty, -1, "kntr.app.game.base.ui.widget.gameaction.GameActionButton (GameActionButton.kt:65)");
            }
            if (game != null) {
                int $dirty3 = $dirty;
                GameActionButtonStyle style4 = style3;
                OnActionListener actionListener5 = actionListener3;
                CompositionLocal this_$iv2 = GameLocalProvidersKt.getLocalSourceFrom();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                String sourceFrom = (String) consume2;
                Modifier modifier$iv$iv = GameActionExt_androidKt.buildClickModifier(SizeKt.defaultMinSize-VpY3zN4(modifier5, Dp.constructor-impl(56), Dp.constructor-impl(30)), state2, game, sourceFrom, actionListener5);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                actionListener2 = actionListener5;
                modifier3 = modifier5;
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
                int i6 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1308759517, "C:GameActionButton.kt#dj1drh");
                if (GameActionStateKt.isDownloadState(state2)) {
                    $composer3.startReplaceGroup(1308756664);
                    ComposerKt.sourceInformation($composer3, "77@3294L44");
                    DownloadLayout(state2, style4, null, $composer3, (($dirty3 >> 6) & 14) | (($dirty3 >> 9) & 112), 4);
                    $composer3.endReplaceGroup();
                    $composer$iv$iv = $composer3;
                    $composer$iv = $composer3;
                    $composer2 = $composer3;
                    $composer$iv$iv$iv = $composer3;
                    style2 = style4;
                } else if (GameActionStateKt.isPayState(state2)) {
                    $composer3.startReplaceGroup(1308853911);
                    ComposerKt.sourceInformation($composer3, "79@3392L45");
                    PayActionLayout(state2, style4, null, $composer3, (($dirty3 >> 6) & 14) | (($dirty3 >> 9) & 112), 4);
                    $composer3.endReplaceGroup();
                    $composer$iv$iv = $composer3;
                    $composer$iv = $composer3;
                    $composer2 = $composer3;
                    $composer$iv$iv$iv = $composer3;
                    style2 = style4;
                } else {
                    $composer3.startReplaceGroup(1308953638);
                    ComposerKt.sourceInformation($composer3, "83@3572L6,84@3619L11,85@3668L12,87@3734L221,92@3968L361");
                    boolean disable = state2.getDisable();
                    boolean border = style4.getBorder();
                    long whiteColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU();
                    style2 = style4;
                    long normalColor = style2.getNormalColor($composer3, ($dirty3 >> 12) & 14);
                    long disableColor = style2.getDisableColor($composer3, ($dirty3 >> 12) & 14);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1289158627, "CC(remember):GameActionButton.kt#9igjgp");
                    boolean invalid$iv = ((((57344 & $dirty3) ^ 24576) > 16384 && $composer3.changed(style2)) || ($dirty3 & 24576) == 16384) | $composer3.changed(disable);
                    Object it$iv = $composer3.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        Modifier backgroundModifier = (Modifier) it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, backgroundModifier);
                        Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        $composer2 = $composer3;
                        $composer$iv = $composer3;
                        $composer$iv$iv = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if (!$composer3.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer3.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                        $composer$iv$iv$iv = $composer3;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i9 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 860214325, "C98@4185L9,96@4105L210:GameActionButton.kt#dj1drh");
                        String mainText = state2.getMainText();
                        TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12();
                        if (!state2.getDisable()) {
                            $composer3.startReplaceGroup(997584716);
                            ComposerKt.sourceInformation($composer3, "99@4253L16");
                            normalTextColor = style2.getDisableTextColor($composer3, ($dirty3 >> 12) & 14);
                        } else {
                            $composer3.startReplaceGroup(997585611);
                            ComposerKt.sourceInformation($composer3, "99@4281L15");
                            normalTextColor = style2.getNormalTextColor($composer3, ($dirty3 >> 12) & 14);
                        }
                        $composer3.endReplaceGroup();
                        TextKt.Text-Nvy7gAk(mainText, (Modifier) null, normalTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer3, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    }
                    Object value$iv = SizeKt.fillMaxSize$default(m1128buildMainBackgroundModifieraQc6oBg(Modifier.Companion, border, whiteColor, normalColor, disableColor, disable), 0.0f, 1, (Object) null);
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    Modifier backgroundModifier2 = (Modifier) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                    int $changed$iv$iv22 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, backgroundModifier2);
                    Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    $composer2 = $composer3;
                    $composer$iv = $composer3;
                    $composer$iv$iv = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
                    $composer$iv$iv$iv = $composer3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                    int i82 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                    int i92 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 860214325, "C98@4185L9,96@4105L210:GameActionButton.kt#dj1drh");
                    String mainText2 = state2.getMainText();
                    TextStyle t122 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12();
                    if (!state2.getDisable()) {
                    }
                    $composer3.endReplaceGroup();
                    TextKt.Text-Nvy7gAk(mainText2, (Modifier) null, normalTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t122, $composer3, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier5;
                    final GameActionState gameActionState2 = state2;
                    final OnActionListener onActionListener = actionListener3;
                    final GameActionButtonStyle gameActionButtonStyle = style3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit GameActionButton$lambda$0;
                            GameActionButton$lambda$0 = GameActionButtonKt.GameActionButton$lambda$0(game, modifier6, gameActionState2, onActionListener, gameActionButtonStyle, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return GameActionButton$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            actionListener2 = actionListener4;
            style2 = style;
            modifier3 = modifier2;
            state2 = gameActionState;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            final GameActionState gameActionState3 = state2;
            final OnActionListener onActionListener2 = actionListener2;
            final GameActionButtonStyle gameActionButtonStyle2 = style2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameActionButton$lambda$2;
                    GameActionButton$lambda$2 = GameActionButtonKt.GameActionButton$lambda$2(game, modifier7, gameActionState3, onActionListener2, gameActionButtonStyle2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GameActionButton$lambda$2;
                }
            });
        }
    }

    private static final void PayActionLayout(final GameActionState state, final GameActionButtonStyle style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        BoxScope $this$PayActionLayout_u24lambda_u241;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer4;
        Modifier modifier5;
        Composer $composer5 = $composer.startRestartGroup(1368520936);
        ComposerKt.sourceInformation($composer5, "C(PayActionLayout)N(state,style,modifier)112@4522L6,113@4561L11,114@4602L12,116@4652L192,122@4850L2540:GameActionButton.kt#dj1drh");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer5.changed(style) : $composer5.changedInstance(style) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer5.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer5.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1368520936, $dirty2, -1, "kntr.app.game.base.ui.widget.gameaction.PayActionLayout (GameActionButton.kt:111)");
            }
            long whiteColor = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getWh0-0d7_KjU();
            long normalColor = style.getNormalColor($composer5, ($dirty2 >> 3) & 14);
            long disableColor = style.getDisableColor($composer5, ($dirty2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer5, 888636168, "CC(remember):GameActionButton.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer5.changed(style));
            Object value$iv = $composer5.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = SizeKt.fillMaxSize$default(m1128buildMainBackgroundModifieraQc6oBg(modifier4, style.getBorder(), whiteColor, normalColor, disableColor, state.getDisable()), 0.0f, 1, (Object) null);
                $composer5.updateRememberedValue(value$iv);
            }
            Modifier modifier$iv = (Modifier) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            $composer2 = $composer5;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((48 >> 6) & 112) | 6;
            BoxScope $this$PayActionLayout_u24lambda_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, 795773517, "C:GameActionButton.kt#dj1drh");
            if (NumberExtKt.parseDouble$default(state.getDiscountPrice(), 0.0d, 1, (Object) null) == 0.0d) {
                $composer5.startReplaceGroup(795762914);
                ComposerKt.sourceInformation($composer5, "125@5021L50,126@5107L9,127@5152L15,124@4992L190");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_kntr_time_free(Res.string.INSTANCE), $composer5, 0), (Modifier) null, style.getNormalTextColor($composer5, ($dirty2 >> 3) & 14), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), $composer5, 0, 0, 131066);
                $composer5.endReplaceGroup();
                $composer$iv$iv = $composer5;
                $composer$iv2 = $composer5;
                $composer3 = $composer5;
                $composer$iv$iv$iv = $composer5;
                $this$PayActionLayout_u24lambda_u241 = $this$PayActionLayout_u24lambda_u2412;
                $composer$iv = $composer5;
            } else {
                $composer5.startReplaceGroup(796010697);
                ComposerKt.sourceInformation($composer5, "130@5212L1567");
                Modifier modifier$iv2 = $this$PayActionLayout_u24lambda_u2412.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter());
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                $composer$iv = $composer5;
                $composer$iv$iv = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                $composer$iv$iv$iv = $composer5;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer$iv2 = $composer5;
                $this$PayActionLayout_u24lambda_u241 = $this$PayActionLayout_u24lambda_u2412;
                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer5.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer5.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
                $composer3 = $composer5;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i6 = ((384 >> 6) & 112) | 6;
                RowScope $this$PayActionLayout_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer5, -1937051249, "C137@5459L422:GameActionButton.kt#dj1drh");
                Modifier modifier$iv3 = RowScope.-CC.weight$default($this$PayActionLayout_u24lambda_u241_u240, Modifier.Companion, 4.0f, false, 2, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer5.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                    $composer5.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, 492749493, "C142@5650L78,143@5772L9,144@5825L15,141@5613L250:GameActionButton.kt#dj1drh");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_kntr_pay_price_format(Res.string.INSTANCE), new Object[]{state.getDiscountPrice()}, $composer5, 0), (Modifier) null, style.getNormalTextColor($composer5, ($dirty2 >> 3) & 14), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), $composer5, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                if (state.getDiscount() != 0) {
                    $composer5.startReplaceGroup(-1936605346);
                    ComposerKt.sourceInformation($composer5, "152@6126L15,148@5945L220,154@6186L561");
                    SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(1), Dp.constructor-impl(16)), style.getNormalTextColor($composer5, ($dirty2 >> 3) & 14), (Shape) null, 2, (Object) null), $composer5, 0);
                    Modifier modifier$iv4 = RowScope.-CC.weight$default($this$PayActionLayout_u24lambda_u241_u240, Modifier.Companion, 3.0f, false, 2, (Object) null);
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv4 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv4);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer5.startReusableNode();
                    if ($composer5.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer5.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer5.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer5);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i10 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1833337799, "C159@6397L76,162@6610L15,158@6356L369:GameActionButton.kt#dj1drh");
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_kntr_pay_price_format(Res.string.INSTANCE), new Object[]{state.getOriginPrice()}, $composer5, 0), (Modifier) null, style.getNormalTextColor($composer5, ($dirty2 >> 3) & 14), (TextAutoSize) null, TextUnitKt.getSp(9), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, TextDecoration.Companion.getLineThrough(), (TextAlign) null, TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer5, 805330944, 48, 259562);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                } else {
                    $composer5.startReplaceGroup(-1942508056);
                }
                $composer5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer3.endReplaceGroup();
            }
            if (state.getDiscount() != 0) {
                $composer4 = $composer3;
                $composer4.startReplaceGroup(797603911);
                ComposerKt.sourceInformation($composer4, "174@6988L13,170@6837L537");
                String str = "-" + state.getDiscount() + "%";
                long sp = TextUnitKt.getSp(8);
                long sp2 = TextUnitKt.getSp(10);
                long discountColor = style.getDiscountColor($composer4, ($dirty2 >> 3) & 14);
                $composer4.startReplaceGroup(718476348);
                ComposerKt.sourceInformation($composer4, RoomRecommendViewModel.EMPTY_CURSOR);
                Modifier it = OffsetKt.offset-VpY3zN4$default($this$PayActionLayout_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, Dp.constructor-impl(-4), 1, (Object) null);
                Function3<Modifier, Composer, Integer, Modifier> discountModifier = style.getDiscountModifier();
                if (discountModifier == null) {
                    $composer4.startReplaceGroup(-1171165734);
                    $composer4.endReplaceGroup();
                    modifier5 = null;
                } else {
                    $composer4.startReplaceGroup(-1284705529);
                    ComposerKt.sourceInformation($composer4, "180@7236L10");
                    modifier5 = (Modifier) discountModifier.invoke(it, $composer4, 0);
                    $composer4.endReplaceGroup();
                }
                if (modifier5 == null) {
                    modifier5 = BackgroundKt.background-bw27NRU(it, ColorKt.Color(4294668953L), RoundedCornerShapeKt.RoundedCornerShape(50));
                }
                $composer4.endReplaceGroup();
                TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(modifier5, Dp.constructor-impl(2), 0.0f, 2, (Object) null), discountColor, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp2, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer4, 24576, 48, 260072);
            } else {
                $composer4 = $composer3;
                $composer4.startReplaceGroup(790803968);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit PayActionLayout$lambda$2;
                    PayActionLayout$lambda$2 = GameActionButtonKt.PayActionLayout$lambda$2(GameActionState.this, style, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PayActionLayout$lambda$2;
                }
            });
        }
    }

    private static final void DownloadLayout(final GameActionState state, final GameActionButtonStyle style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        long normalTextColor;
        Composer $composer2 = $composer.startRestartGroup(723449090);
        ComposerKt.sourceInformation($composer2, "C(DownloadLayout)N(state,style,modifier)193@7557L11,196@7642L187,201@7834L413:GameActionButton.kt#dj1drh");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(style) : $composer2.changedInstance(style) ? 32 : 16;
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
                ComposerKt.traceEventStart(723449090, $dirty2, -1, "kntr.app.game.base.ui.widget.gameaction.DownloadLayout (GameActionButton.kt:192)");
            }
            long color = style.getNormalColor($composer2, ($dirty2 >> 3) & 14);
            boolean inDownload = state.getInDownload();
            boolean border = style.getBorder();
            ComposerKt.sourceInformationMarkerStart($composer2, -550118979, "CC(remember):GameActionButton.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(border) | $composer2.changed(color) | $composer2.changed(inDownload);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                modifier3 = modifier4;
                Object value$iv = SizeKt.fillMaxSize$default(m1127buildDownloadBackgroundModifier9LQNqLg(modifier4, style.getBorder(), color, inDownload), 0.0f, 1, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                modifier3 = modifier4;
            }
            Modifier downloadModifier = (Modifier) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, downloadModifier);
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -44254709, "C210@8124L9,208@8060L181:GameActionButton.kt#dj1drh");
            if (state.getInDownload()) {
                $composer2.startReplaceGroup(-44239458);
                ComposerKt.sourceInformation($composer2, "206@7973L68");
                DownloadProgressBackground(state.getProgress(), style, $composer2, $dirty2 & 112);
            } else {
                $composer2.startReplaceGroup(-52138630);
            }
            $composer2.endReplaceGroup();
            String mainText = state.getMainText();
            TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
            if (state.getInDownload()) {
                $composer2.startReplaceGroup(-694156520);
                ComposerKt.sourceInformation($composer2, "211@8187L16");
                normalTextColor = style.getProcessTextColor($composer2, ($dirty2 >> 3) & 14);
            } else {
                $composer2.startReplaceGroup(-694155625);
                ComposerKt.sourceInformation($composer2, "211@8215L15");
                normalTextColor = style.getNormalTextColor($composer2, ($dirty2 >> 3) & 14);
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(mainText, (Modifier) null, normalTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer2, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DownloadLayout$lambda$2;
                    DownloadLayout$lambda$2 = GameActionButtonKt.DownloadLayout$lambda$2(GameActionState.this, style, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DownloadLayout$lambda$2;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x01a9, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void DownloadProgressBackground(final int progress, final GameActionButtonStyle style, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(919586574);
        ComposerKt.sourceInformation($composer2, "C(DownloadProgressBackground)N(progress,style)221@8364L301:GameActionButton.kt#dj1drh");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(style) : $composer2.changedInstance(style) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(919586574, $dirty, -1, "kntr.app.game.base.ui.widget.gameaction.DownloadProgressBackground (GameActionButton.kt:220)");
            }
            Modifier modifier$iv$iv = ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape(50));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -647428876, "C222@8454L13,223@8518L141,223@8476L183:GameActionButton.kt#dj1drh");
            final List progressColor = style.getProgressColor($composer2, ($dirty >> 3) & 14);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1641685973, "CC(remember):GameActionButton.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(progressColor) | (($dirty & 14) == 4);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = new Function1() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit DownloadProgressBackground$lambda$0$0$0;
                    DownloadProgressBackground$lambda$0$0$0 = GameActionButtonKt.DownloadProgressBackground$lambda$0$0$0(progressColor, progress, (DrawScope) obj);
                    return DownloadProgressBackground$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(fillMaxSize$default, (Function1) value$iv, $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DownloadProgressBackground$lambda$1;
                    DownloadProgressBackground$lambda$1 = GameActionButtonKt.DownloadProgressBackground$lambda$1(progress, style, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DownloadProgressBackground$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadProgressBackground$lambda$0$0$0(List $progressColor, int $progress, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        Brush brush = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, $progressColor, 0.0f, 0.0f, 0, 14, (Object) null);
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float width$iv = (Float.intBitsToFloat(bits$iv$iv$iv) * $progress) / 100;
        int bits$iv$iv$iv2 = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float height$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        DrawScope.-CC.drawRoundRect-ZuiqVtQ$default($this$Canvas, brush, 0L, Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 250, (Object) null);
        return Unit.INSTANCE;
    }

    /* renamed from: buildMainBackgroundModifier-aQc6oBg$default  reason: not valid java name */
    static /* synthetic */ Modifier m1129buildMainBackgroundModifieraQc6oBg$default(Modifier modifier, boolean z, long j2, long j3, long j4, boolean z2, int i, Object obj) {
        boolean z3;
        if ((i & 16) == 0) {
            z3 = z2;
        } else {
            z3 = false;
        }
        return m1128buildMainBackgroundModifieraQc6oBg(modifier, z, j2, j3, j4, z3);
    }

    /* renamed from: buildMainBackgroundModifier-aQc6oBg  reason: not valid java name */
    private static final Modifier m1128buildMainBackgroundModifieraQc6oBg(Modifier $this$buildMainBackgroundModifier_u2daQc6oBg, boolean border, long j2, long j3, long j4, boolean disable) {
        if (!border) {
            return BackgroundKt.background-bw27NRU($this$buildMainBackgroundModifier_u2daQc6oBg, disable ? j4 : j3, RoundedCornerShapeKt.RoundedCornerShape(50));
        }
        final long color = disable ? j4 : j3;
        return DrawModifierKt.drawBehind(BackgroundKt.background-bw27NRU($this$buildMainBackgroundModifier_u2daQc6oBg, j2, RoundedCornerShapeKt.RoundedCornerShape(50)), new Function1() { // from class: kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit buildMainBackgroundModifier_aQc6oBg$lambda$0;
                buildMainBackgroundModifier_aQc6oBg$lambda$0 = GameActionButtonKt.buildMainBackgroundModifier_aQc6oBg$lambda$0(color, (DrawScope) obj);
                return buildMainBackgroundModifier_aQc6oBg$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildMainBackgroundModifier_aQc6oBg$lambda$0(long $color, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        float borderWidth = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(1));
        float f = 2;
        float x$iv = borderWidth / f;
        float y$iv = borderWidth / f;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long v2$iv$iv2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv) / f;
        int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv2) / f;
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv3 = Float.floatToRawIntBits(y$iv2);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBehind, $color, v2$iv$iv2, 0L, CornerRadius.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv3 & 4294967295L)), new Stroke(borderWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), 0.0f, (ColorFilter) null, 0, 228, (Object) null);
        return Unit.INSTANCE;
    }

    /* renamed from: buildDownloadBackgroundModifier-9LQNqLg  reason: not valid java name */
    private static final Modifier m1127buildDownloadBackgroundModifier9LQNqLg(Modifier $this$buildDownloadBackgroundModifier_u2d9LQNqLg, boolean border, long j2, boolean inDownload) {
        if (inDownload || border) {
            return BorderKt.border-xT4_qwU($this$buildDownloadBackgroundModifier_u2d9LQNqLg, Dp.constructor-impl(1), j2, RoundedCornerShapeKt.RoundedCornerShape(50));
        }
        return BackgroundKt.background-bw27NRU($this$buildDownloadBackgroundModifier_u2d9LQNqLg, j2, RoundedCornerShapeKt.RoundedCornerShape(50));
    }
}