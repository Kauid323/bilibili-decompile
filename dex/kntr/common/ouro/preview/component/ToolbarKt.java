package kntr.common.ouro.preview.component;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.editControls.OuroHistoryAction;
import kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin;
import kntr.common.ouro.core.plugin.editControls.OuroHistoryState;
import kntr.common.ouro.core.utils.OuroStateToolbarExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.common.ouroboros.editor.common.ui.generated.resources.Drawable0_commonMainKt;
import srcs.common.ouroboros.editor.common.ui.generated.resources.Res;

/* compiled from: Toolbar.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\f\u001aO\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001aA\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0003¢\u0006\u0002\u0010\u001a\u001aI\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\n\u0010\u001c\u001a\u00020\"X\u008a\u0084\u0002"}, d2 = {"Toolbar", "", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "activeItem", "Lkntr/common/ouro/preview/component/ToolbarItem;", "onClickItem", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "onTrackClick", "Lkntr/common/ouro/preview/component/ToolbarTrackEvent;", "(Lkntr/common/ouro/core/OuroStore;Lkntr/common/ouro/preview/component/ToolbarItem;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ToolPanelButton", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "isSelected", "", "isDisable", "contentDescription", "", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Modifier;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ToolButton", "isEnable", "(Landroidx/compose/ui/graphics/painter/Painter;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "EditControl", "state", "Lkntr/common/ouro/core/plugin/editControls/OuroHistoryState;", "onAction", "Lkntr/common/ouro/core/action/OuroAction;", "(Lkntr/common/ouro/core/plugin/editControls/OuroHistoryState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "Lkntr/common/ouro/core/OuroState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ToolbarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditControl$lambda$2(OuroHistoryState ouroHistoryState, Function1 function1, Modifier modifier, Function1 function12, int i, int i2, Composer composer, int i3) {
        EditControl(ouroHistoryState, function1, modifier, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToolButton$lambda$1(Painter painter, boolean z, Function0 function0, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        ToolButton(painter, z, function0, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToolPanelButton$lambda$2(Painter painter, boolean z, Modifier modifier, boolean z2, String str, Function0 function0, int i, int i2, Composer composer, int i3) {
        ToolPanelButton(painter, z, modifier, z2, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toolbar$lambda$4(OuroStore ouroStore, ToolbarItem toolbarItem, Function1 function1, Modifier modifier, Function1 function12, int i, int i2, Composer composer, int i3) {
        Toolbar(ouroStore, toolbarItem, function1, modifier, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toolbar$lambda$0$0(ToolbarTrackEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02d5, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0343, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x03ad, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0424, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x046b, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L124;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Toolbar(final OuroStore ouroStore, final ToolbarItem activeItem, final Function1<? super ToolbarItem, Unit> function1, Modifier modifier, Function1<? super ToolbarTrackEvent, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function1 onTrackClick;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Intrinsics.checkNotNullParameter(function1, "onClickItem");
        Composer $composer2 = $composer.startRestartGroup(1473119361);
        ComposerKt.sourceInformation($composer2, "C(Toolbar)N(ouroStore,activeItem,onClickItem,modifier,onTrackClick)59@2141L2,61@2186L16,63@2234L121,66@2360L1770:Toolbar.kt#35gue6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(ouroStore) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(activeItem == null ? -1 : activeItem.ordinal()) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            onTrackClick = function12;
        } else if (($changed & 24576) == 0) {
            onTrackClick = function12;
            $dirty |= $composer2.changedInstance(onTrackClick) ? 16384 : 8192;
        } else {
            onTrackClick = function12;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1671495613, "CC(remember):Toolbar.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Unit Toolbar$lambda$0$0;
                            Toolbar$lambda$0$0 = ToolbarKt.Toolbar$lambda$0$0((ToolbarTrackEvent) obj);
                            return Toolbar$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onTrackClick2 = (Function1) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onTrackClick = onTrackClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1473119361, $dirty2, -1, "kntr.common.ouro.preview.component.Toolbar (Toolbar.kt:60)");
            }
            State state$delegate = SnapshotStateKt.collectAsState(ouroStore.getStateFlow(), (CoroutineContext) null, $composer2, 0, 1);
            OuroState this_$iv = Toolbar$lambda$1(state$delegate);
            KClass key$iv = Reflection.getOrCreateKotlinClass(OuroHistoryPlugin.class);
            OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
            if (!(ouroPluginState instanceof OuroHistoryState)) {
                ouroPluginState = null;
            }
            OuroHistoryState ouroHistoryState = (OuroHistoryState) ouroPluginState;
            if (ouroHistoryState == null) {
                throw new NoSuchElementException("No plugin state for " + key$iv);
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1671492518, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(ouroHistoryState);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                OuroState this_$iv2 = Toolbar$lambda$1(state$delegate);
                KClass key$iv2 = Reflection.getOrCreateKotlinClass(OuroHistoryPlugin.class);
                Object obj = this_$iv2.getPluginStates().get(key$iv2);
                if (!(obj instanceof OuroHistoryState)) {
                    obj = null;
                }
                Object obj2 = (OuroPluginState) ((OuroHistoryState) obj);
                if (obj2 == null) {
                    throw new NoSuchElementException("No plugin state for " + key$iv2);
                }
                Object value$iv2 = (OuroHistoryState) obj2;
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            OuroHistoryState historyState = (OuroHistoryState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            int $changed$iv = (($dirty2 >> 9) & 14) | 432;
            Modifier modifier$iv$iv = modifier4;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 906211014, "C72@2563L48,74@2697L125,71@2524L309,80@2881L53,82@3025L135,79@2842L329,88@3232L21,90@3337L120,87@3180L288,96@3529L14,99@3672L116,95@3477L322,109@4075L19,109@4030L94:Toolbar.kt#35gue6");
            Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_text_style(Res.drawable.INSTANCE), $composer2, 0);
            boolean z = activeItem == ToolbarItem.TextStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, -247857990, "CC(remember):Toolbar.kt#9igjgp");
            int $changed$iv$iv$iv2 = $dirty2 & 57344;
            boolean invalid$iv2 = (($dirty2 & 896) == 256) | ($changed$iv$iv$iv2 == 16384);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit Toolbar$lambda$3$0$0;
                    Toolbar$lambda$3$0$0 = ToolbarKt.Toolbar$lambda$3$0$0(function1, onTrackClick);
                    return Toolbar$lambda$3$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ToolPanelButton(painterResource, z, null, false, null, (Function0) it$iv3, $composer2, Painter.$stable, 28);
            Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getToolbar_paragraph_style(Res.drawable.INSTANCE), $composer2, 0);
            boolean z2 = activeItem == ToolbarItem.ParagraphStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, -247847484, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv3 = (($dirty2 & 896) == 256) | (($dirty2 & 57344) == 16384);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv4 = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit Toolbar$lambda$3$1$0;
                    Toolbar$lambda$3$1$0 = ToolbarKt.Toolbar$lambda$3$1$0(function1, onTrackClick);
                    return Toolbar$lambda$3$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ToolPanelButton(painterResource2, z2, null, false, null, (Function0) it$iv4, $composer2, Painter.$stable, 28);
            Painter emoji_circle_line_500 = BiliIconfont.INSTANCE.getEmoji_circle_line_500($composer2, 6);
            boolean z3 = activeItem == ToolbarItem.Sticker;
            ComposerKt.sourceInformationMarkerStart($composer2, -247837515, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv4 = (($dirty2 & 896) == 256) | (($dirty2 & 57344) == 16384);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv5 = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit Toolbar$lambda$3$2$0;
                    Toolbar$lambda$3$2$0 = ToolbarKt.Toolbar$lambda$3$2$0(function1, onTrackClick);
                    return Toolbar$lambda$3$2$0;
                }
            };
            $composer2.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ToolPanelButton(emoji_circle_line_500, z3, null, false, null, (Function0) it$iv5, $composer2, Painter.$stable, 28);
            Painter image_line_500 = BiliIconfont.INSTANCE.getImage_line_500($composer2, 6);
            boolean z4 = activeItem == ToolbarItem.Album;
            boolean z5 = !OuroStateToolbarExtKt.canInsertPic(Toolbar$lambda$1(state$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, -247826799, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv5 = (($dirty2 & 896) == 256) | ((57344 & $dirty2) == 16384);
            Object value$iv6 = $composer2.rememberedValue();
            if (invalid$iv5) {
            }
            value$iv6 = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit Toolbar$lambda$3$3$0;
                    Toolbar$lambda$3$3$0 = ToolbarKt.Toolbar$lambda$3$3$0(function1, onTrackClick);
                    return Toolbar$lambda$3$3$0;
                }
            };
            $composer2.updateRememberedValue(value$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ToolPanelButton(image_line_500, z4, null, z5, null, value$iv6, $composer2, Painter.$stable, 20);
            ComposerKt.sourceInformationMarkerStart($composer2, -247814000, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv6 = $composer2.changedInstance(ouroStore);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv7 = (KFunction) new ToolbarKt$Toolbar$2$5$1(ouroStore);
            $composer2.updateRememberedValue(value$iv7);
            it$iv6 = value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EditControl(historyState, (KFunction) it$iv6, null, onTrackClick, $composer2, ($dirty2 >> 3) & 7168, 4);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function13 = onTrackClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj3, Object obj4) {
                    Unit Toolbar$lambda$4;
                    Toolbar$lambda$4 = ToolbarKt.Toolbar$lambda$4(OuroStore.this, activeItem, function1, modifier6, function13, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return Toolbar$lambda$4;
                }
            });
        }
    }

    private static final OuroState Toolbar$lambda$1(State<OuroState> state) {
        Object thisObj$iv = state.getValue();
        return (OuroState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toolbar$lambda$3$0$0(Function1 $onClickItem, Function1 $onTrackClick) {
        $onClickItem.invoke(ToolbarItem.TextStyle);
        $onTrackClick.invoke(ToolbarTrackEvent.TEXT_STYLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toolbar$lambda$3$1$0(Function1 $onClickItem, Function1 $onTrackClick) {
        $onClickItem.invoke(ToolbarItem.ParagraphStyle);
        $onTrackClick.invoke(ToolbarTrackEvent.PARAGRAPH_STYLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toolbar$lambda$3$2$0(Function1 $onClickItem, Function1 $onTrackClick) {
        $onClickItem.invoke(ToolbarItem.Sticker);
        $onTrackClick.invoke(ToolbarTrackEvent.STICKER);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Toolbar$lambda$3$3$0(Function1 $onClickItem, Function1 $onTrackClick) {
        $onClickItem.invoke(ToolbarItem.Album);
        $onTrackClick.invoke(ToolbarTrackEvent.ALBUM);
        return Unit.INSTANCE;
    }

    private static final void ToolPanelButton(final Painter painter, final boolean isSelected, Modifier modifier, boolean isDisable, String contentDescription, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        String str;
        final Function0 onClick;
        Modifier modifier3;
        boolean isDisable2;
        String contentDescription2;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-1082183652);
        ComposerKt.sourceInformation($composer2, "C(ToolPanelButton)N(painter,isSelected,modifier,isDisable,contentDescription,onClick):Toolbar.kt#35gue6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(painter) : $composer2.changedInstance(painter) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isSelected) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = isDisable;
        } else if (($changed & 3072) == 0) {
            z = isDisable;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = isDisable;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            str = contentDescription;
        } else if (($changed & 24576) == 0) {
            str = contentDescription;
            $dirty |= $composer2.changed(str) ? 16384 : 8192;
        } else {
            str = contentDescription;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            onClick = function0;
        } else if ((196608 & $changed) == 0) {
            onClick = function0;
            $dirty |= $composer2.changedInstance(onClick) ? 131072 : 65536;
        } else {
            onClick = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isDisable2 = z;
            contentDescription2 = str;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                isDisable2 = z;
            } else {
                isDisable2 = false;
            }
            if (i4 == 0) {
                contentDescription2 = str;
            } else {
                contentDescription2 = null;
            }
            if (i5 != 0) {
                onClick = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1082183652, $dirty2, -1, "kntr.common.ouro.preview.component.ToolPanelButton (Toolbar.kt:121)");
            }
            if (isSelected) {
                $composer2.startReplaceGroup(-1308410875);
                ComposerKt.sourceInformation($composer2, "124@4439L17,129@4623L21,130@4675L6,123@4398L305");
                Painter keyboard_line_500 = BiliIconfont.INSTANCE.getKeyboard_line_500($composer2, 6);
                Modifier modifier5 = SizeKt.size-3ABfNKs(modifier3, Dp.constructor-impl(24));
                ComposerKt.sourceInformationMarkerStart($composer2, -596388911, "CC(remember):Toolbar.kt#9igjgp");
                boolean invalid$iv = (458752 & $dirty2) == 131072;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit ToolPanelButton$lambda$0$0;
                            ToolPanelButton$lambda$0$0 = ToolbarKt.ToolPanelButton$lambda$0$0(onClick);
                            return ToolPanelButton$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                IconKt.Icon-ww6aTOc(keyboard_line_500, contentDescription2, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer2, Painter.$stable | (($dirty2 >> 9) & 112), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1308080942);
                ComposerKt.sourceInformation($composer2, "146@5181L6,133@4725L484");
                $composer2.startReplaceGroup(-596379291);
                ComposerKt.sourceInformation($composer2, "");
                Modifier it = SizeKt.size-3ABfNKs(modifier3, Dp.constructor-impl(24));
                if (isDisable2) {
                    $composer2.startReplaceGroup(1710758371);
                    $composer2.endReplaceGroup();
                    modifier4 = AlphaKt.alpha(it, 0.5f);
                } else {
                    $composer2.startReplaceGroup(1710834383);
                    ComposerKt.sourceInformation($composer2, "143@5081L21");
                    ComposerKt.sourceInformationMarkerStart($composer2, 1302115502, "CC(remember):Toolbar.kt#9igjgp");
                    boolean invalid$iv2 = (458752 & $dirty2) == 131072;
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit ToolPanelButton$lambda$1$0$0;
                                ToolPanelButton$lambda$1$0$0 = ToolbarKt.ToolPanelButton$lambda$1$0$0(onClick);
                                return ToolPanelButton$lambda$1$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier6 = ClickableKt.clickable-oSLSa3U$default(it, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                    $composer2.endReplaceGroup();
                    modifier4 = modifier6;
                }
                $composer2.endReplaceGroup();
                IconKt.Icon-ww6aTOc(painter, contentDescription2, modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bold-0d7_KjU(), $composer2, Painter.$stable | ($dirty2 & 14) | (($dirty2 >> 9) & 112), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final boolean z2 = isDisable2;
            final String str2 = contentDescription2;
            final Function0 function02 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ToolPanelButton$lambda$2;
                    ToolPanelButton$lambda$2 = ToolbarKt.ToolPanelButton$lambda$2(painter, isSelected, modifier7, z2, str2, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ToolPanelButton$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToolPanelButton$lambda$0$0(Function0 $onClick) {
        if ($onClick != null) {
            $onClick.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToolPanelButton$lambda$1$0$0(Function0 $onClick) {
        if ($onClick != null) {
            $onClick.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final void ToolButton(final Painter painter, final boolean isEnable, final Function0<Unit> function0, Modifier modifier, String contentDescription, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Modifier modifier3;
        String contentDescription2;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-1462472096);
        ComposerKt.sourceInformation($composer2, "C(ToolButton)N(painter,isEnable,onClick,modifier,contentDescription)166@5659L13,167@5699L6,159@5410L313:Toolbar.kt#35gue6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(painter) : $composer2.changedInstance(painter) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isEnable) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            str = contentDescription;
        } else if (($changed & 24576) == 0) {
            str = contentDescription;
            $dirty |= $composer2.changed(str) ? 16384 : 8192;
        } else {
            str = contentDescription;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            contentDescription2 = str;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                contentDescription2 = str;
            } else {
                contentDescription2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1462472096, $dirty2, -1, "kntr.common.ouro.preview.component.ToolButton (Toolbar.kt:158)");
            }
            Modifier alpha = AlphaKt.alpha(SizeKt.size-3ABfNKs(modifier4, Dp.constructor-impl(24)), isEnable ? 1.0f : 0.4f);
            ComposerKt.sourceInformationMarkerStart($composer2, -981365011, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        Unit ToolButton$lambda$0$0;
                        ToolButton$lambda$0$0 = ToolbarKt.ToolButton$lambda$0$0(function0);
                        return ToolButton$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            modifier3 = modifier4;
            IconKt.Icon-ww6aTOc(painter, contentDescription2, ClickableKt.clickable-oSLSa3U$default(alpha, isEnable, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bold-0d7_KjU(), $composer2, Painter.$stable | ($dirty2 & 14) | (($dirty2 >> 9) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str2 = contentDescription2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit ToolButton$lambda$1;
                    ToolButton$lambda$1 = ToolbarKt.ToolButton$lambda$1(painter, isEnable, function0, modifier5, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ToolButton$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToolButton$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditControl$lambda$0$0(ToolbarTrackEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3 */
    private static final void EditControl(final OuroHistoryState state, final Function1<? super OuroAction, Unit> function1, Modifier modifier, Function1<? super ToolbarTrackEvent, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function1 onTrackClick;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(1478177699);
        ComposerKt.sourceInformation($composer3, "C(EditControl)N(state,onAction,modifier,onTrackClick)176@5912L2,178@5924L1026:Toolbar.kt#35gue6");
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
            onTrackClick = function12;
        } else if (($changed & 3072) == 0) {
            onTrackClick = function12;
            $dirty |= $composer3.changedInstance(onTrackClick) ? 2048 : 1024;
        } else {
            onTrackClick = function12;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1105400955, "CC(remember):Toolbar.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit EditControl$lambda$0$0;
                            EditControl$lambda$0$0 = ToolbarKt.EditControl$lambda$0$0((ToolbarTrackEvent) obj);
                            return EditControl$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onTrackClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onTrackClick = onTrackClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1478177699, $dirty2, -1, "kntr.common.ouro.preview.component.EditControl (Toolbar.kt:177)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(20));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 6) & 14) | 432;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1515819175, "C188@6244L6,183@6091L255,193@6402L19,195@6485L117,192@6355L258,201@6669L19,203@6776L16,204@6816L117,200@6622L322:Toolbar.kt#35gue6");
            $composer2 = $composer3;
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_bold-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float) 0.5d))), $composer3, 0);
            Painter arrow_undo_line_500 = BiliIconfont.INSTANCE.getArrow_undo_line_500($composer3, 6);
            boolean canUndo = state.canUndo();
            ComposerKt.sourceInformationMarkerStart($composer3, -643827396, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | (($dirty2 & 7168) == 2048);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit EditControl$lambda$1$0$0;
                        EditControl$lambda$1$0$0 = ToolbarKt.EditControl$lambda$1$0$0(function1, onTrackClick);
                        return EditControl$lambda$1$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ToolButton(arrow_undo_line_500, canUndo, (Function0) it$iv2, null, null, $composer3, Painter.$stable, 24);
            Painter arrow_undo_line_5002 = BiliIconfont.INSTANCE.getArrow_undo_line_500($composer3, 6);
            boolean canRedo = state.canRedo();
            Modifier modifier5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, -643818185, "CC(remember):Toolbar.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit EditControl$lambda$1$1$0;
                        EditControl$lambda$1$1$0 = ToolbarKt.EditControl$lambda$1$1$0((GraphicsLayerScope) obj);
                        return EditControl$lambda$1$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) it$iv3);
            ComposerKt.sourceInformationMarkerStart($composer3, -643816804, "CC(remember):Toolbar.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 112) == 32) | (($dirty2 & 7168) == 2048);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit EditControl$lambda$1$2$0;
                        EditControl$lambda$1$2$0 = ToolbarKt.EditControl$lambda$1$2$0(function1, onTrackClick);
                        return EditControl$lambda$1$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ToolButton(arrow_undo_line_5002, canRedo, (Function0) it$iv4, graphicsLayer, null, $composer3, Painter.$stable | 3072, 16);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function13 = onTrackClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.component.ToolbarKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit EditControl$lambda$2;
                    EditControl$lambda$2 = ToolbarKt.EditControl$lambda$2(OuroHistoryState.this, function1, modifier6, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return EditControl$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditControl$lambda$1$0$0(Function1 $onAction, Function1 $onTrackClick) {
        $onAction.invoke(OuroHistoryAction.Undo.INSTANCE);
        $onTrackClick.invoke(ToolbarTrackEvent.UNDO);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditControl$lambda$1$1$0(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(-1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditControl$lambda$1$2$0(Function1 $onAction, Function1 $onTrackClick) {
        $onAction.invoke(OuroHistoryAction.Redo.INSTANCE);
        $onTrackClick.invoke(ToolbarTrackEvent.REDO);
        return Unit.INSTANCE;
    }
}