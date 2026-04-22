package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
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
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import bili.resource.im.Res;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.compose.res.LoadingAnimateImageKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMListStatus.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"IMPageHeadStatus", "", "state", "Lim/base/ContentStatus;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lim/base/ContentStatus;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMPageFootStatus", "onRetry", "Lkotlin/Function0;", "(Lim/base/ContentStatus;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMListStatusKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageFootStatus$lambda$2(ContentStatus contentStatus, Modifier modifier, Function0 function0, int i2, int i3, Composer composer, int i4) {
        IMPageFootStatus(contentStatus, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageHeadStatus$lambda$1(ContentStatus contentStatus, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMPageHeadStatus(contentStatus, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void IMPageHeadStatus(final ContentStatus state, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        Modifier modifier3;
        Modifier modifier$iv$iv;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(218323990);
        ComposerKt.sourceInformation($composer2, "C(IMPageHeadStatus)N(state,modifier):IMListStatus.kt#uu6lp7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i3 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(218323990, $dirty, -1, "im.base.IMPageHeadStatus (IMListStatus.kt:46)");
            }
            if (state instanceof ErrorContent) {
                $composer2.startReplaceGroup(1509644687);
                ComposerKt.sourceInformation($composer2, "53@1914L6,48@1740L877");
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(40)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getPay_yellow_thin-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10));
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                modifier$iv$iv = modifier3;
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
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i5 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1977359447, "C59@2199L30,60@2264L6,58@2154L235,66@2432L57,67@2525L6,68@2579L9,65@2403L204:IMListStatus.kt#uu6lp7");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getWarning_report_circle_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_notice-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_305(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_notice-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                modifier$iv$iv = modifier3;
                $composer2.startReplaceGroup(1507899852);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier$iv$iv;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMListStatusKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMPageHeadStatus$lambda$1;
                    IMPageHeadStatus$lambda$1 = IMListStatusKt.IMPageHeadStatus$lambda$1(ContentStatus.this, modifier2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMPageHeadStatus$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0781, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMPageFootStatus(final ContentStatus state, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 onRetry;
        Modifier modifier4;
        final Function0 onRetry2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer3 = $composer.startRestartGroup(452124564);
        ComposerKt.sourceInformation($composer3, "C(IMPageFootStatus)N(state,modifier,onRetry)79@2787L2,81@2799L2943:IMListStatus.kt#uu6lp7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(state) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onRetry = function02;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 == 0) {
                onRetry2 = function02;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, 700012598, "CC(remember):IMListStatus.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: im.base.IMListStatusKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onRetry2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(452124564, $dirty2, -1, "im.base.IMPageFootStatus (IMListStatus.kt:80)");
            }
            Modifier modifier$iv$iv = SizeKt.fillMaxSize$default(modifier4, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            modifier3 = modifier4;
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1574321024, "C:IMListStatus.kt#uu6lp7");
            if (Intrinsics.areEqual(state, IdleContent.INSTANCE)) {
                $composer3.startReplaceGroup(1574275174);
                $composer3.endReplaceGroup();
                onRetry = onRetry2;
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
            } else if (Intrinsics.areEqual(state, LoadingContent.INSTANCE)) {
                $composer3.startReplaceGroup(1574323224);
                ComposerKt.sourceInformation($composer3, "88@3004L464");
                Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(48));
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (54 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                $composer$iv = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i8 = ((54 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1747873634, "C95@3270L27,96@3318L132:IMListStatus.kt#uu6lp7");
                String image2 = LoadingAnimateImageKt.getLoadingAnimateImageUri($composer3, 0);
                ImageRequest imageRequest = new ImageRequest(image2);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 48, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                onRetry = onRetry2;
            } else {
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                if (Intrinsics.areEqual(state, EmptyContent.INSTANCE)) {
                    $composer3.startReplaceGroup(1574845946);
                    ComposerKt.sourceInformation($composer3, "104@3530L494");
                    Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(48));
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv3 = (54 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer3.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i10 = ((54 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1581529915, "C112@3821L49,113@3914L6,114@3970L9,111@3784L222:IMListStatus.kt#uu6lp7");
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.im.String0_commonMainKt.getIm_global_string_646(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                    onRetry = onRetry2;
                } else if (!(state instanceof ErrorContent)) {
                    $composer3.startReplaceGroup(2128994531);
                    $composer3.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                } else {
                    $composer3.startReplaceGroup(1575435473);
                    ComposerKt.sourceInformation($composer3, "120@4089L1623");
                    Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(48));
                    Alignment contentAlignment$iv4 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                    int $changed$iv$iv4 = (54 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv8;
                        $composer3.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv8;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                    int i12 = ((54 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -615932099, "C154@5628L66:IMListStatus.kt#uu6lp7");
                    $composer3.startReplaceGroup(-574057679);
                    ComposerKt.sourceInformation($composer3, "*130@4489L9,131@4563L6");
                    AnnotatedString.Builder $this$IMPageFootStatus_u24lambda_u241_u242_u241 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                    $composer3.startReplaceGroup(-574056124);
                    ComposerKt.sourceInformation($composer3, "*134@4705L57");
                    SpanStyle style$iv = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null).toSpanStyle();
                    int index$iv = $this$IMPageFootStatus_u24lambda_u241_u242_u241.pushStyle(style$iv);
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            $this$IMPageFootStatus_u24lambda_u241_u242_u241.append(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_204(Res.string.INSTANCE), $composer3, 0));
                            Unit unit2 = Unit.INSTANCE;
                            $this$IMPageFootStatus_u24lambda_u241_u242_u241.pop(index$iv);
                            $composer3.endReplaceGroup();
                            AnnotatedString clickString = $this$IMPageFootStatus_u24lambda_u241_u242_u241.toAnnotatedString();
                            $composer3.endReplaceGroup();
                            $composer3.startReplaceGroup(-574041639);
                            ComposerKt.sourceInformation($composer3, "*140@4981L9,141@5055L6,147@5385L81");
                            $this$IMPageFootStatus_u24lambda_u241_u242_u241 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                            $composer3.startReplaceGroup(-574040385);
                            ComposerKt.sourceInformation($composer3, "*144@5192L57");
                            SpanStyle style$iv2 = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null).toSpanStyle();
                            index$iv = $this$IMPageFootStatus_u24lambda_u241_u242_u241.pushStyle(style$iv2);
                            try {
                                try {
                                    try {
                                        $this$IMPageFootStatus_u24lambda_u241_u242_u241.append(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_364(Res.string.INSTANCE), $composer3, 0));
                                        Unit unit3 = Unit.INSTANCE;
                                        $this$IMPageFootStatus_u24lambda_u241_u242_u241.pop(index$iv);
                                        $composer3.endReplaceGroup();
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1231264393, "CC(remember):IMListStatus.kt#9igjgp");
                                        boolean invalid$iv = ($dirty2 & 896) == 256;
                                        Object it$iv2 = $composer3.rememberedValue();
                                        if (invalid$iv) {
                                        }
                                        Object value$iv2 = new LinkInteractionListener() { // from class: im.base.IMListStatusKt$$ExternalSyntheticLambda2
                                            public final void onClick(LinkAnnotation linkAnnotation) {
                                                IMListStatusKt.IMPageFootStatus$lambda$1$2$1$1$0(onRetry2, linkAnnotation);
                                            }
                                        };
                                        $composer3.updateRememberedValue(value$iv2);
                                        it$iv2 = value$iv2;
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        LinkAnnotation link$iv = new LinkAnnotation.Clickable("retry", (TextLinkStyles) null, (LinkInteractionListener) it$iv2, 2, (DefaultConstructorMarker) null);
                                        index$iv = $this$IMPageFootStatus_u24lambda_u241_u242_u241.pushLink(link$iv);
                                        onRetry = onRetry2;
                                        try {
                                            $this$IMPageFootStatus_u24lambda_u241_u242_u241.append(clickString);
                                            Unit unit4 = Unit.INSTANCE;
                                            $this$IMPageFootStatus_u24lambda_u241_u242_u241.pop(index$iv);
                                            AnnotatedString string = $this$IMPageFootStatus_u24lambda_u241_u242_u241.toAnnotatedString();
                                            $composer3.endReplaceGroup();
                                            TextKt.Text-Z58ophY(string, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, $composer3, 0, 0, 524286);
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            $composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            $composer3.endReplaceGroup();
                                        } finally {
                                            $this$IMPageFootStatus_u24lambda_u241_u242_u241.pop(index$iv);
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onRetry;
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMListStatusKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMPageFootStatus$lambda$2;
                    IMPageFootStatus$lambda$2 = IMListStatusKt.IMPageFootStatus$lambda$2(ContentStatus.this, modifier5, function03, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMPageFootStatus$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IMPageFootStatus$lambda$1$2$1$1$0(Function0 $onRetry, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onRetry.invoke();
    }
}