package im.session.home;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.session.common.IMSessionEventHandler;
import im.session.model.IMQuickLink;
import im.session.model.IMQuickLinkItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMQuickLink.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"QuickLinkRow", "", "quickLink", "Lim/session/model/IMQuickLink;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "(Lim/session/model/IMQuickLink;Lim/session/common/IMSessionEventHandler;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMQuickLinkKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkRow$lambda$2(IMQuickLink iMQuickLink, IMSessionEventHandler iMSessionEventHandler, int i2, Composer composer, int i3) {
        QuickLinkRow(iMQuickLink, iMSessionEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void QuickLinkRow(final IMQuickLink quickLink, final IMSessionEventHandler eventHandler, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(quickLink, "quickLink");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer3 = $composer.startRestartGroup(-1021180830);
        ComposerKt.sourceInformation($composer3, "C(QuickLinkRow)N(quickLink,eventHandler)38@1241L83,41@1329L1670:IMQuickLink.kt#kfobb3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(quickLink) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1021180830, $dirty2, -1, "im.session.home.QuickLinkRow (IMQuickLink.kt:36)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -2102230379, "CC(remember):IMQuickLink.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new QuickLinkState(quickLink, eventHandler);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            QuickLinkState state = (QuickLinkState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ZIndexModifierKt.zIndex(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1626583957, "C89@2974L19:IMQuickLink.kt#kfobb3");
            if (!quickLink.isLegacyStyle()) {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(1627342898);
                ComposerKt.sourceInformation($composer2, "68@2242L712");
                Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), state.m3320getHorizonPaddingD9Ej5fM(), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv2 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                Composer $composer$iv$iv$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv.startReusableNode();
                if ($composer$iv$iv$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer$iv$iv$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer$iv$iv$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv);
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                Composer $composer$iv = $composer$iv$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i5 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                RowScope $this$QuickLinkRow_u24lambda_u241_u241 = rowScope;
                Composer $composer4 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, -1156447257, "C:IMQuickLink.kt#kfobb3");
                $composer4.startReplaceGroup(-1838419572);
                ComposerKt.sourceInformation($composer4, "");
                Iterable $this$forEach$iv = quickLink.getItems();
                for (Object element$iv : $this$forEach$iv) {
                    IMQuickLinkItem it = (IMQuickLinkItem) element$iv;
                    $composer4.startMovableGroup(397872603, it.getType());
                    ComposerKt.sourceInformation($composer4, "78@2661L239");
                    Composer $composer5 = $composer4;
                    QuickLinkItemKt.QuickLinkItem(it, state, eventHandler, RowScope.-CC.weight$default($this$QuickLinkRow_u24lambda_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer4, ($dirty2 << 3) & 896, 0);
                    $composer5.endMovableGroup();
                    $composer$iv$iv$iv = $composer$iv$iv$iv;
                    localMap$iv$iv2 = localMap$iv$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv;
                    $composer$iv = $composer$iv;
                    $composer4 = $composer5;
                }
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                Composer $composer6 = $composer4;
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1626601068);
                ComposerKt.sourceInformation($composer3, "48@1494L718");
                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), state.m3320getHorizonPaddingD9Ej5fM(), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv3 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                Composer $composer$iv$iv$iv3 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv3.startReusableNode();
                if ($composer$iv$iv$iv3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer$iv$iv$iv3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer$iv$iv$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv$iv$iv3);
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                Composer $composer$iv2 = $composer$iv$iv$iv3;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i7 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                RowScope $this$QuickLinkRow_u24lambda_u241_u240 = rowScope2;
                Composer $composer7 = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer7, 974677898, "C:IMQuickLink.kt#kfobb3");
                $composer7.startReplaceGroup(-1492578935);
                ComposerKt.sourceInformation($composer7, "");
                Iterable $this$forEach$iv2 = quickLink.getItems();
                for (Object element$iv2 : $this$forEach$iv2) {
                    IMQuickLinkItem it2 = (IMQuickLinkItem) element$iv2;
                    $composer7.startMovableGroup(100967960, it2.getType());
                    ComposerKt.sourceInformation($composer7, "58@1913L245");
                    Composer $composer8 = $composer7;
                    QuickLinkItemKt.QuickLinkItemLegacy(it2, state, eventHandler, RowScope.-CC.weight$default($this$QuickLinkRow_u24lambda_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer7, ($dirty2 << 3) & 896, 0);
                    $composer8.endMovableGroup();
                    $composer$iv$iv$iv3 = $composer$iv$iv$iv3;
                    localMap$iv$iv3 = localMap$iv$iv3;
                    measurePolicy$iv$iv2 = measurePolicy$iv$iv2;
                    $composer$iv2 = $composer$iv2;
                    $composer7 = $composer8;
                }
                Composer $composer$iv$iv$iv4 = $composer$iv$iv$iv3;
                Composer $composer9 = $composer7;
                $composer9.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer9);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            }
            QuickLinkBubbleKt.NotifyBubble(state, $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.IMQuickLinkKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit QuickLinkRow$lambda$2;
                    QuickLinkRow$lambda$2 = IMQuickLinkKt.QuickLinkRow$lambda$2(IMQuickLink.this, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return QuickLinkRow$lambda$2;
                }
            });
        }
    }
}