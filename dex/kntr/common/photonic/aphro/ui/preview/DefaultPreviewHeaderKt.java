package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.aphro.ui.preview.model.OriginImageHint;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: DefaultPreviewHeader.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\r¨\u0006\u000e"}, d2 = {"DefaultPreviewHeader", "", "state", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "originImageHint", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "roundToOneDecimalPlace", "", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultPreviewHeaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultPreviewHeader$lambda$1(ImagePreviewState imagePreviewState, OriginImageHint originImageHint, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DefaultPreviewHeader(imagePreviewState, originImageHint, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x025d, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x04ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DefaultPreviewHeader(final ImagePreviewState state, final OriginImageHint originImageHint, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier$iv$iv;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        boolean showOriginHint;
        Composer $composer$iv$iv;
        MutableState<Boolean> loadOriginImage;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(originImageHint, "originImageHint");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(1613675685);
        ComposerKt.sourceInformation($composer2, "C(DefaultPreviewHeader)N(state,originImageHint,onDismiss,modifier)35@1400L2625:DefaultPreviewHeader.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(originImageHint) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1613675685, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.DefaultPreviewHeader (DefaultPreviewHeader.kt:34)");
            }
            Modifier modifier$iv$iv2 = WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(SizeKt.height-3ABfNKs(modifier3, Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), 0.0f, 1, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv2);
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
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DefaultPreviewHeader_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -695978821, "C52@1983L20,54@2073L6,59@2272L15,51@1942L356:DefaultPreviewHeader.kt#n54g3c");
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer2, 6);
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU();
            Modifier modifier4 = SizeKt.size-3ABfNKs(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(11)), Dp.constructor-impl(22));
            ComposerKt.sourceInformationMarkerStart($composer2, 1917220218, "CC(remember):DefaultPreviewHeader.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.DefaultPreviewHeaderKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit DefaultPreviewHeader$lambda$0$0$0;
                    DefaultPreviewHeader$lambda$0$0$0 = DefaultPreviewHeaderKt.DefaultPreviewHeader$lambda$0$0$0(function0);
                    return DefaultPreviewHeader$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer2, Painter.$stable | 48, 0);
            ImagePreviewItemState currentItem = state.getCurrentItem();
            PreviewableAsset currentAsset = currentItem != null ? currentItem.getAsset() : null;
            if (Intrinsics.areEqual(originImageHint, OriginImageHint.Always.INSTANCE)) {
                showOriginHint = true;
            } else if (Intrinsics.areEqual(originImageHint, OriginImageHint.Invisible.INSTANCE)) {
                showOriginHint = false;
            } else if (!(originImageHint instanceof OriginImageHint.Threshold)) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (currentAsset != null && ContentSize.m2182compareTo4yfSoQ8(currentAsset.mo2158getContentSizeQJZHGII(), ((OriginImageHint.Threshold) originImageHint).m2311getThresholdSizeQJZHGII()) > 0) {
                    showOriginHint = true;
                }
                showOriginHint = false;
            }
            if (currentAsset == null) {
                $composer$iv$iv = $composer2;
            } else if (currentAsset.getSupportThumbnail()) {
                ImagePreviewItemState currentItem2 = state.getCurrentItem();
                if (!((currentItem2 == null || (loadOriginImage = currentItem2.getLoadOriginImage()) == null || ((Boolean) loadOriginImage.getValue()).booleanValue()) ? false : true)) {
                    $composer$iv$iv = $composer2;
                } else if (showOriginHint) {
                    $composer2.startReplaceGroup(-695113922);
                    ComposerKt.sourceInformation($composer2, "84@3295L63,90@3578L6,93@3788L104,96@3928L9,97@3977L6,83@3266L743");
                    double it = currentAsset.mo2158getContentSizeQJZHGII();
                    String size = ContentSize.m2189getMegabytesimpl(it) > 1.0d ? roundToOneDecimalPlace(ContentSize.m2189getMegabytesimpl(it)) + "M" : ContentSize.m2188getKilobytesimpl(it) > 1.0d ? MathKt.roundToInt(ContentSize.m2188getKilobytesimpl(it)) + "K" : MathKt.roundToInt(ContentSize.m2187getBytesimpl(it)) + "B";
                    String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_446(CommonRes.INSTANCE.getString()), new Object[]{size}, $composer2, 0);
                    $composer$iv$iv = $composer2;
                    Modifier modifier5 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU($this$DefaultPreviewHeader_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_medium-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(14), Dp.constructor-impl((float) 2.5d));
                    ComposerKt.sourceInformationMarkerStart($composer2, 1917268819, "CC(remember):DefaultPreviewHeader.kt#9igjgp");
                    boolean invalid$iv2 = ($dirty2 & 14) == 4;
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.DefaultPreviewHeaderKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit DefaultPreviewHeader$lambda$0$2$0;
                                DefaultPreviewHeader$lambda$0$2$0 = DefaultPreviewHeaderKt.DefaultPreviewHeader$lambda$0$2$0(ImagePreviewState.this);
                                return DefaultPreviewHeader$lambda$0$2$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextKt.Text-Nvy7gAk(stringResource, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 0, 131064);
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    $composer$iv$iv = $composer2;
                }
            } else {
                $composer$iv$iv = $composer2;
            }
            $composer2.startReplaceGroup(-697970665);
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier$iv$iv;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.DefaultPreviewHeaderKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DefaultPreviewHeader$lambda$1;
                    DefaultPreviewHeader$lambda$1 = DefaultPreviewHeaderKt.DefaultPreviewHeader$lambda$1(ImagePreviewState.this, originImageHint, function0, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DefaultPreviewHeader$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultPreviewHeader$lambda$0$0$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultPreviewHeader$lambda$0$2$0(ImagePreviewState $state) {
        MutableState<Boolean> loadOriginImage;
        ImagePreviewItemState currentItem = $state.getCurrentItem();
        if (currentItem != null && (loadOriginImage = currentItem.getLoadOriginImage()) != null) {
            loadOriginImage.setValue(true);
        }
        return Unit.INSTANCE;
    }

    public static final String roundToOneDecimalPlace(double $this$roundToOneDecimalPlace) {
        double scaled = 10 * $this$roundToOneDecimalPlace;
        int roundedScaled = MathKt.roundToInt(scaled);
        double result = roundedScaled / 10.0d;
        if (result == ((double) ((long) result))) {
            return ((long) result) + ".0";
        }
        return String.valueOf(result);
    }
}