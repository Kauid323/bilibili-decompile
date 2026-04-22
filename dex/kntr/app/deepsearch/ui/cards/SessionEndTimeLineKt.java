package kntr.app.deepsearch.ui.cards;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionEndTimeLine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SessionEndTimeLine", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MODEL, "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SessionEndTimeLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SessionEndTimeLine$lambda$1(DeepSearchSessionEndModel deepSearchSessionEndModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SessionEndTimeLine(deepSearchSessionEndModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x027b, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SessionEndTimeLine(final DeepSearchSessionEndModel model, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Object value$iv;
        boolean invalid$iv;
        Intrinsics.checkNotNullParameter(model, ReportBuildInParam.MODEL);
        Composer $composer2 = $composer.startRestartGroup(342477500);
        ComposerKt.sourceInformation($composer2, "C(SessionEndTimeLine)N(model,modifier)20@688L1345:SessionEndTimeLine.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(model) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(342477500, $dirty, -1, "kntr.app.deepsearch.ui.cards.SessionEndTimeLine (SessionEndTimeLine.kt:19)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty >> 3) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$SessionEndTimeLine_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -911946182, "C24@820L6,25@880L394,25@841L433,43@1357L6,44@1401L9,41@1284L300,52@1633L394,52@1594L433:SessionEndTimeLine.kt#pp6rt");
            final long lineColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU();
            Modifier weight$default = RowScope.-CC.weight$default($this$SessionEndTimeLine_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -167963038, "CC(remember):SessionEndTimeLine.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(lineColor);
            Object it$iv = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(weight$default, (Function1) value$iv, $composer2, 0);
                TextKt.Text-Nvy7gAk(model.getTimeString(), SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null), Dp.constructor-impl(17)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 0, 131064);
                Modifier weight$default2 = RowScope.-CC.weight$default($this$SessionEndTimeLine_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -167938942, "CC(remember):SessionEndTimeLine.kt#9igjgp");
                invalid$iv = $composer2.changed(lineColor);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.SessionEndTimeLineKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit SessionEndTimeLine$lambda$0$1$0;
                        SessionEndTimeLine$lambda$0$1$0 = SessionEndTimeLineKt.SessionEndTimeLine$lambda$0$1$0(lineColor, (DrawScope) obj);
                        return SessionEndTimeLine$lambda$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(weight$default2, (Function1) it$iv2, $composer2, 0);
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
            value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.cards.SessionEndTimeLineKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit SessionEndTimeLine$lambda$0$0$0;
                    SessionEndTimeLine$lambda$0$0$0 = SessionEndTimeLineKt.SessionEndTimeLine$lambda$0$0$0(lineColor, (DrawScope) obj);
                    return SessionEndTimeLine$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(weight$default, (Function1) value$iv, $composer2, 0);
            TextKt.Text-Nvy7gAk(model.getTimeString(), SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null), Dp.constructor-impl(17)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 0, 131064);
            Modifier weight$default22 = RowScope.-CC.weight$default($this$SessionEndTimeLine_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -167938942, "CC(remember):SessionEndTimeLine.kt#9igjgp");
            invalid$iv = $composer2.changed(lineColor);
            Object it$iv22 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv22 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.SessionEndTimeLineKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit SessionEndTimeLine$lambda$0$1$0;
                    SessionEndTimeLine$lambda$0$1$0 = SessionEndTimeLineKt.SessionEndTimeLine$lambda$0$1$0(lineColor, (DrawScope) obj);
                    return SessionEndTimeLine$lambda$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv22);
            it$iv22 = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(weight$default22, (Function1) it$iv22, $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.SessionEndTimeLineKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SessionEndTimeLine$lambda$1;
                    SessionEndTimeLine$lambda$1 = SessionEndTimeLineKt.SessionEndTimeLine$lambda$1(DeepSearchSessionEndModel.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SessionEndTimeLine$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SessionEndTimeLine$lambda$0$0$0(long $lineColor, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv) / 2.0f;
        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        int bits$iv$iv$iv3 = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3) / 2.0f;
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$Canvas, $lineColor, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 504, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SessionEndTimeLine$lambda$0$1$0(long $lineColor, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv) / 2.0f;
        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        int bits$iv$iv$iv3 = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3) / 2.0f;
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$Canvas, $lineColor, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 504, (Object) null);
        return Unit.INSTANCE;
    }
}