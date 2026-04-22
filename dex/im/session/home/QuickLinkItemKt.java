package im.session.home;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnreadStyle;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.session.IMActionClickQuickLinkItem;
import im.session.IMActionExposureQuickLinkItem;
import im.session.common.IMSessionEventHandler;
import im.session.common.SimpleExposureEntry;
import im.session.model.IMQuickLinkItem;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: QuickLinkItem.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a/\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"QuickLinkItemLegacy", "", "item", "Lim/session/model/IMQuickLinkItem;", "state", "Lim/session/home/QuickLinkState;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lim/session/model/IMQuickLinkItem;Lim/session/home/QuickLinkState;Lim/session/common/IMSessionEventHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "QuickLinkItem", "QuickLinkUnreadBadge", "Landroidx/compose/foundation/layout/BoxScope;", "unread", "Lcom/bapis/bilibili/app/im/v1/KUnread;", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/bapis/bilibili/app/im/v1/KUnread;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class QuickLinkItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItem$lambda$5(IMQuickLinkItem iMQuickLinkItem, QuickLinkState quickLinkState, IMSessionEventHandler iMSessionEventHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        QuickLinkItem(iMQuickLinkItem, quickLinkState, iMSessionEventHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItemLegacy$lambda$5(IMQuickLinkItem iMQuickLinkItem, QuickLinkState quickLinkState, IMSessionEventHandler iMSessionEventHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        QuickLinkItemLegacy(iMQuickLinkItem, quickLinkState, iMSessionEventHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkUnreadBadge$lambda$1(BoxScope boxScope, KUnread kUnread, int i2, Composer composer, int i3) {
        QuickLinkUnreadBadge(boxScope, kUnread, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x015e, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01d4, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QuickLinkItemLegacy(final IMQuickLinkItem item, final QuickLinkState state, final IMSessionEventHandler eventHandler, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer3 = $composer.startRestartGroup(-1586302941);
        ComposerKt.sourceInformation($composer3, "C(QuickLinkItemLegacy)N(item,state,eventHandler,modifier)50@1900L24,51@1951L13,53@1991L174,63@2245L228,70@2569L81,73@2718L111,60@2170L1460:QuickLinkItem.kt#kfobb3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 256 : 128;
        }
        int i3 = i2 & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586302941, $dirty2, -1, "im.session.home.QuickLinkItemLegacy (QuickLinkItem.kt:49)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ThemeDayNight theme = BiliTheme.INSTANCE.getDayNightTheme($composer3, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer3, 276272465, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(((Enum) theme).ordinal()) | $composer3.changed(item);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = theme == ThemeDayNight.Day ? item.getIcon() : item.getIconForNight();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            String iconUrl = (String) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 276280647, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 896) == 256) | $composer3.changedInstance(item) | $composer3.changedInstance(scope);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit QuickLinkItemLegacy$lambda$1$0;
                    QuickLinkItemLegacy$lambda$1$0 = QuickLinkItemKt.QuickLinkItemLegacy$lambda$1$0(IMSessionEventHandler.this, item, scope);
                    return QuickLinkItemLegacy$lambda$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Dp.constructor-impl(108)), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(22), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(18), 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 276290868, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv3 = (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | $composer3.changedInstance(item);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function1() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit QuickLinkItemLegacy$lambda$2$0;
                    QuickLinkItemLegacy$lambda$2$0 = QuickLinkItemKt.QuickLinkItemLegacy$lambda$2$0(QuickLinkState.this, item, (LayoutCoordinates) obj);
                    return QuickLinkItemLegacy$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier onPlaced = OnPlacedModifierKt.onPlaced(modifier5, (Function1) it$iv3);
            ComposerKt.sourceInformationMarkerStart($composer3, 276295666, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(item) | (($dirty2 & 896) == 256);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit QuickLinkItemLegacy$lambda$3$0;
                        QuickLinkItemLegacy$lambda$3$0 = QuickLinkItemKt.QuickLinkItemLegacy$lambda$3$0(IMSessionEventHandler.this, item);
                        return QuickLinkItemLegacy$lambda$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(onPlaced, new SimpleExposureEntry(0L, (Function0) it$iv4, 1, null));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getBottom();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            modifier3 = modifier4;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ColumnScope $this$QuickLinkItemLegacy_u24lambda_u244 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -1284843218, "C80@2976L379,94@3431L6,95@3475L9,92@3364L260:QuickLinkItem.kt#kfobb3");
            Modifier modifier$iv2 = ColumnScope.-CC.weight$default($this$QuickLinkItemLegacy_u24lambda_u244, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 601835304, "C81@3069L276:QuickLinkItem.kt#kfobb3");
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.Companion;
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int $changed2 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            BoxScope $this$QuickLinkItemLegacy_u24lambda_u244_u240_u240 = boxScope2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1173839022, "C82@3091L132:QuickLinkItem.kt#kfobb3");
            ImageRequest imageRequest = new ImageRequest(iconUrl);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 48, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            KUnread it = item.getUnread();
            if (it == null) {
                $composer3.startReplaceGroup(-1173682381);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1173682380);
                ComposerKt.sourceInformation($composer3, "*88@3280L33");
                QuickLinkUnreadBadge($this$QuickLinkItemLegacy_u24lambda_u244_u240_u240, it, $composer3, $changed2 & 14);
                Unit unit2 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
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
            TextKt.Text-Nvy7gAk(item.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(8), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 48, 24960, 110584);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit QuickLinkItemLegacy$lambda$5;
                    QuickLinkItemLegacy$lambda$5 = QuickLinkItemKt.QuickLinkItemLegacy$lambda$5(IMQuickLinkItem.this, state, eventHandler, modifier6, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return QuickLinkItemLegacy$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItemLegacy$lambda$1$0(IMSessionEventHandler $eventHandler, IMQuickLinkItem $item, CoroutineScope $scope) {
        $eventHandler.getActionHandler().invoke(new IMActionClickQuickLinkItem($item));
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new QuickLinkItemKt$QuickLinkItemLegacy$1$1$1($eventHandler, $item, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItemLegacy$lambda$2$0(QuickLinkState $state, IMQuickLinkItem $item, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $state.put($item.getType(), LayoutCoordinatesKt.boundsInParent(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItemLegacy$lambda$3$0(IMSessionEventHandler $eventHandler, IMQuickLinkItem $item) {
        $eventHandler.getActionHandler().invoke(new IMActionExposureQuickLinkItem($item));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x015e, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cb, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QuickLinkItem(final IMQuickLinkItem item, final QuickLinkState state, final IMSessionEventHandler eventHandler, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer3 = $composer.startRestartGroup(-2145929108);
        ComposerKt.sourceInformation($composer3, "C(QuickLinkItem)N(item,state,eventHandler,modifier)113@3844L24,114@3895L13,116@3935L174,126@4189L228,132@4481L81,135@4630L111,123@4114L1289:QuickLinkItem.kt#kfobb3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 256 : 128;
        }
        int i3 = i2 & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2145929108, $dirty2, -1, "im.session.home.QuickLinkItem (QuickLinkItem.kt:112)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ThemeDayNight theme = BiliTheme.INSTANCE.getDayNightTheme($composer3, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer3, -653562214, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(((Enum) theme).ordinal()) | $composer3.changed(item);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = theme == ThemeDayNight.Day ? item.getIcon() : item.getIconForNight();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            String iconUrl = (String) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -653554032, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 896) == 256) | $composer3.changedInstance(item) | $composer3.changedInstance(scope);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit QuickLinkItem$lambda$1$0;
                    QuickLinkItem$lambda$1$0 = QuickLinkItemKt.QuickLinkItem$lambda$1$0(IMSessionEventHandler.this, item, scope);
                    return QuickLinkItem$lambda$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(20), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(12), 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -653544835, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv3 = (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | $composer3.changedInstance(item);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function1() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit QuickLinkItem$lambda$2$0;
                    QuickLinkItem$lambda$2$0 = QuickLinkItemKt.QuickLinkItem$lambda$2$0(QuickLinkState.this, item, (LayoutCoordinates) obj);
                    return QuickLinkItem$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier onPlaced = OnPlacedModifierKt.onPlaced(modifier5, (Function1) it$iv3);
            ComposerKt.sourceInformationMarkerStart($composer3, -653540037, "CC(remember):QuickLinkItem.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(item) | (($dirty2 & 896) == 256);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit QuickLinkItem$lambda$3$0;
                        QuickLinkItem$lambda$3$0 = QuickLinkItemKt.QuickLinkItem$lambda$3$0(IMSessionEventHandler.this, item);
                        return QuickLinkItem$lambda$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(onPlaced, new SimpleExposureEntry(0L, (Function0) it$iv4, 1, null));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            modifier3 = modifier4;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -417128712, "C142@4896L284,155@5257L6,156@5301L9,153@5190L207:QuickLinkItem.kt#kfobb3");
            Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int $changed2 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            BoxScope $this$QuickLinkItem_u24lambda_u244_u240 = boxScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -1095748613, "C143@4954L120:QuickLinkItem.kt#kfobb3");
            ImageRequest imageRequest = new ImageRequest(iconUrl);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 48, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            KUnread it = item.getUnread();
            if (it == null) {
                $composer3.startReplaceGroup(-1095607348);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1095607347);
                ComposerKt.sourceInformation($composer3, "*149@5123L33");
                QuickLinkUnreadBadge($this$QuickLinkItem_u24lambda_u244_u240, it, $composer3, $changed2 & 14);
                Unit unit2 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(item.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 24960, 110586);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit QuickLinkItem$lambda$5;
                    QuickLinkItem$lambda$5 = QuickLinkItemKt.QuickLinkItem$lambda$5(IMQuickLinkItem.this, state, eventHandler, modifier6, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return QuickLinkItem$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItem$lambda$1$0(IMSessionEventHandler $eventHandler, IMQuickLinkItem $item, CoroutineScope $scope) {
        $eventHandler.getActionHandler().invoke(new IMActionClickQuickLinkItem($item));
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new QuickLinkItemKt$QuickLinkItem$1$1$1($eventHandler, $item, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItem$lambda$2$0(QuickLinkState $state, IMQuickLinkItem $item, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $state.put($item.getType(), LayoutCoordinatesKt.boundsInParent(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickLinkItem$lambda$3$0(IMSessionEventHandler $eventHandler, IMQuickLinkItem $item) {
        $eventHandler.getActionHandler().invoke(new IMActionExposureQuickLinkItem($item));
        return Unit.INSTANCE;
    }

    public static final void QuickLinkUnreadBadge(final BoxScope $this$QuickLinkUnreadBadge, final KUnread unread, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$QuickLinkUnreadBadge, "<this>");
        Intrinsics.checkNotNullParameter(unread, "unread");
        Composer $composer2 = $composer.startRestartGroup(-1192557753);
        ComposerKt.sourceInformation($composer2, "C(QuickLinkUnreadBadge)N(unread):QuickLinkItem.kt#kfobb3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$QuickLinkUnreadBadge) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(unread) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1192557753, $dirty, -1, "im.session.home.QuickLinkUnreadBadge (QuickLinkItem.kt:164)");
            }
            Modifier offset = OffsetKt.offset-VpY3zN4($this$QuickLinkUnreadBadge.align(Modifier.Companion, Alignment.Companion.getTopEnd()), Dp.constructor-impl(2), Dp.constructor-impl(-8));
            if (!StringsKt.isBlank(unread.getNumberShow()) && Intrinsics.areEqual(unread.getStyle(), KUnreadStyle.UNREAD_STYLE_NUMBER.INSTANCE)) {
                $composer2.startReplaceGroup(481726776);
                ComposerKt.sourceInformation($composer2, "174@5863L6,170@5697L531");
                Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.sizeIn-qDBjuR0$default(offset, Dp.constructor-impl(16), Dp.constructor-impl(16), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i3 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 14332188, "C180@6107L6,181@6160L9,178@6025L193:QuickLinkItem.kt#kfobb3");
                TextKt.Text-Nvy7gAk(unread.getNumberShow(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT11(), $composer2, 0, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                if (Intrinsics.areEqual(unread.getStyle(), KUnreadStyle.UNREAD_STYLE_DOT.INSTANCE)) {
                    $composer2.startReplaceGroup(482315156);
                    ComposerKt.sourceInformation($composer2, "190@6434L6,186@6301L183");
                    BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(offset, Dp.constructor-impl(8)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                } else {
                    $composer2.startReplaceGroup(476067323);
                }
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.QuickLinkItemKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit QuickLinkUnreadBadge$lambda$1;
                    QuickLinkUnreadBadge$lambda$1 = QuickLinkItemKt.QuickLinkUnreadBadge$lambda$1($this$QuickLinkUnreadBadge, unread, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return QuickLinkUnreadBadge$lambda$1;
                }
            });
        }
    }
}