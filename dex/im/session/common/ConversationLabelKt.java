package im.session.common;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.bapis.bilibili.app.im.v1.KBorderedLabel;
import com.bapis.bilibili.app.im.v1.KFilledLabel;
import com.bapis.bilibili.app.im.v1.KImageLabel;
import com.bapis.bilibili.app.im.v1.KMedal;
import com.bapis.bilibili.app.im.v1.KUserLabel;
import com.bapis.bilibili.app.im.v1.KUserLabelStyle;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.Pixel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.im.session.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.im.session.ui.generated.resources.Res;

/* compiled from: ConversationLabel.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\fH\u0003¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\fH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"ConversationLabel", "", "label", "Lcom/bapis/bilibili/app/im/v1/KUserLabel;", "(Lcom/bapis/bilibili/app/im/v1/KUserLabel;Landroidx/compose/runtime/Composer;I)V", "Label", "Lcom/bapis/bilibili/app/im/v1/KBorderedLabel;", "(Lcom/bapis/bilibili/app/im/v1/KBorderedLabel;Landroidx/compose/runtime/Composer;I)V", "Lcom/bapis/bilibili/app/im/v1/KFilledLabel;", "(Lcom/bapis/bilibili/app/im/v1/KFilledLabel;Landroidx/compose/runtime/Composer;I)V", "Lcom/bapis/bilibili/app/im/v1/KImageLabel;", "(Lcom/bapis/bilibili/app/im/v1/KImageLabel;Landroidx/compose/runtime/Composer;I)V", "Lcom/bapis/bilibili/app/im/v1/KMedal;", "(Lcom/bapis/bilibili/app/im/v1/KMedal;Landroidx/compose/runtime/Composer;I)V", "getMedalPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcom/bapis/bilibili/app/im/v1/KMedal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationLabelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationLabel$lambda$0(KUserLabel kUserLabel, int i2, Composer composer, int i3) {
        ConversationLabel(kUserLabel, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$1(KBorderedLabel kBorderedLabel, int i2, Composer composer, int i3) {
        Label(kBorderedLabel, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$3(KFilledLabel kFilledLabel, int i2, Composer composer, int i3) {
        Label(kFilledLabel, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$6(KImageLabel kImageLabel, int i2, Composer composer, int i3) {
        Label(kImageLabel, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$8(KMedal kMedal, int i2, Composer composer, int i3) {
        Label(kMedal, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void ConversationLabel(final KUserLabel label, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer2 = $composer.startRestartGroup(7286415);
        ComposerKt.sourceInformation($composer2, "C(ConversationLabel)N(label):ConversationLabel.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(label) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(7286415, $dirty, -1, "im.session.common.ConversationLabel (ConversationLabel.kt:46)");
            }
            KUserLabelStyle style = label.getStyle();
            KUserLabelStyle.KBorderedLabel style2 = style != null ? style.getStyle() : null;
            if (style2 instanceof KUserLabelStyle.KBorderedLabel) {
                $composer2.startReplaceGroup(-1587685162);
                ComposerKt.sourceInformation($composer2, "48@2167L7");
                Label(style2.getValue(), $composer2, 0);
                $composer2.endReplaceGroup();
            } else if (style2 instanceof KUserLabelStyle.KFilledLabel) {
                $composer2.startReplaceGroup(-1587683146);
                ComposerKt.sourceInformation($composer2, "49@2230L7");
                Label(((KUserLabelStyle.KFilledLabel) style2).getValue(), $composer2, 0);
                $composer2.endReplaceGroup();
            } else if (style2 instanceof KUserLabelStyle.KImageLabel) {
                $composer2.startReplaceGroup(-1587681162);
                ComposerKt.sourceInformation($composer2, "50@2292L7");
                Label(style2.getValue(), $composer2, 0);
                $composer2.endReplaceGroup();
            } else if (style2 instanceof KUserLabelStyle.KMedalLabel) {
                $composer2.startReplaceGroup(-1587679178);
                ComposerKt.sourceInformation($composer2, "51@2354L7");
                Label(style2.getValue(), $composer2, 0);
                $composer2.endReplaceGroup();
            } else if (style2 != null) {
                $composer2.startReplaceGroup(-1587687957);
                $composer2.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer2.startReplaceGroup(-1973390607);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.ConversationLabelKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConversationLabel$lambda$0;
                    ConversationLabel$lambda$0 = ConversationLabelKt.ConversationLabel$lambda$0(label, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ConversationLabel$lambda$0;
                }
            });
        }
    }

    private static final void Label(final KBorderedLabel $this$Label, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-100251460);
        ComposerKt.sourceInformation($composer2, "C(Label)62@2551L6,58@2443L765:ConversationLabel.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance($this$Label) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-100251460, $dirty, -1, "im.session.common.Label (ConversationLabel.kt:57)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(BorderKt.border-xT4_qwU(Modifier.Companion, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl((float) 0.5d), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl((float) 1.5d), 5, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -447404489, "C79@3129L6,80@3178L9,77@3068L134:ConversationLabel.kt#yqxgzx");
            if (StringsKt.isBlank($this$Label.getIcon())) {
                $composer2.startReplaceGroup(-450285878);
            } else {
                $composer2.startReplaceGroup(-447386851);
                ComposerKt.sourceInformation($composer2, "71@2931L117");
                String $this$asRequest_u24default$iv = $this$Label.getIcon();
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, 48, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk($this$Label.getText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 0, 0, 131066);
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
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.ConversationLabelKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Label$lambda$1;
                    Label$lambda$1 = ConversationLabelKt.Label$lambda$1($this$Label, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Label$lambda$1;
                }
            });
        }
    }

    private static final void Label(final KFilledLabel $this$Label, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(333402309);
        ComposerKt.sourceInformation($composer2, "C(Label)91@3375L6,87@3263L493:ConversationLabel.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance($this$Label) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(333402309, $dirty, -1, "im.session.common.Label (ConversationLabel.kt:86)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl((float) 0.5d), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl((float) 1.5d), 5, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1726455650, "C99@3677L6,100@3726L9,97@3616L134:ConversationLabel.kt#yqxgzx");
            TextKt.Text-Nvy7gAk($this$Label.getText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 0, 0, 131066);
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
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.ConversationLabelKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit Label$lambda$3;
                    Label$lambda$3 = ConversationLabelKt.Label$lambda$3($this$Label, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Label$lambda$3;
                }
            });
        }
    }

    private static final void Label(final KImageLabel $this$Label, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1675797510);
        ComposerKt.sourceInformation($composer2, "C(Label)108@3847L7,111@3937L193:ConversationLabel.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance($this$Label) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1675797510, $dirty2, -1, "im.session.common.Label (ConversationLabel.kt:106)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Label_u24lambda_u244 = (Density) consume;
            long size = DpKt.DpSize-YgX7TsA($this$Label_u24lambda_u244.toDp-u2uoSUM($this$Label.getWidth()), $this$Label_u24lambda_u244.toDp-u2uoSUM($this$Label.getHeight()));
            String $this$asRequest$iv = $this$Label.getUrl();
            ImageRequest $this$Label_u24lambda_u245 = new ImageRequest($this$asRequest$iv);
            $this$Label_u24lambda_u245.requestWidth-3VbuI34(Pixel.constructor-impl($this$Label.getWidth()));
            $this$Label_u24lambda_u245.requestHeight-3VbuI34(Pixel.constructor-impl($this$Label.getHeight()));
            BiliImageKt.BiliImage($this$Label_u24lambda_u245.build(), SizeKt.size-6HolHcs(Modifier.Companion, size), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, 0, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.ConversationLabelKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Label$lambda$6;
                    Label$lambda$6 = ConversationLabelKt.Label$lambda$6($this$Label, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Label$lambda$6;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x012f, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0190, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ee, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Label(final KMedal $this$Label, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-216309302);
        ComposerKt.sourceInformation($composer3, "C(Label)122@4219L17,123@4276L17,124@4329L17,125@4387L17,126@4447L17,127@4493L17,135@4686L1837:ConversationLabel.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance($this$Label) ? 4 : 2;
        }
        if (!$composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-216309302, $dirty, -1, "im.session.common.Label (ConversationLabel.kt:121)");
            }
            String $this$rememberAsColor$iv = $this$Label.getMedalColorBorder();
            ComposerKt.sourceInformationMarkerStart($composer3, -1146072542, "CC(rememberAsColor)8@245L48:ComposeColorParser.kt");
            ComposerKt.sourceInformationMarkerStart($composer3, -1864083694, "CC(remember):ComposeColorParser.kt#9igjgp");
            boolean invalid$iv$iv = (((0 & 14) ^ 6) > 4 && $composer3.changed($this$rememberAsColor$iv)) || (false & true);
            Object it$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = Color.box-impl(ComposeColorParserKt.parseColor($this$rememberAsColor$iv));
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            long borderColor = ((Color) it$iv$iv).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String $this$rememberAsColor$iv2 = $this$Label.getMedalColorStart();
            ComposerKt.sourceInformationMarkerStart($composer3, -1146072542, "CC(rememberAsColor)8@245L48:ComposeColorParser.kt");
            ComposerKt.sourceInformationMarkerStart($composer3, -1864083694, "CC(remember):ComposeColorParser.kt#9igjgp");
            boolean invalid$iv$iv2 = (((0 & 14) ^ 6) > 4 && $composer3.changed($this$rememberAsColor$iv2)) || (false & true);
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv$iv2 = Color.box-impl(ComposeColorParserKt.parseColor($this$rememberAsColor$iv2));
                $composer3.updateRememberedValue(value$iv$iv2);
                it$iv$iv2 = value$iv$iv2;
            }
            long bgStart = ((Color) it$iv$iv2).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String $this$rememberAsColor$iv3 = $this$Label.getMedalColorEnd();
            ComposerKt.sourceInformationMarkerStart($composer3, -1146072542, "CC(rememberAsColor)8@245L48:ComposeColorParser.kt");
            ComposerKt.sourceInformationMarkerStart($composer3, -1864083694, "CC(remember):ComposeColorParser.kt#9igjgp");
            boolean invalid$iv$iv3 = (((0 & 14) ^ 6) > 4 && $composer3.changed($this$rememberAsColor$iv3)) || (false & true);
            Object it$iv$iv3 = $composer3.rememberedValue();
            if (invalid$iv$iv3) {
            }
            Object value$iv$iv3 = Color.box-impl(ComposeColorParserKt.parseColor($this$rememberAsColor$iv3));
            $composer3.updateRememberedValue(value$iv$iv3);
            it$iv$iv3 = value$iv$iv3;
            long bgEnd = ((Color) it$iv$iv3).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String $this$rememberAsColor$iv4 = $this$Label.getMedalColorName();
            ComposerKt.sourceInformationMarkerStart($composer3, -1146072542, "CC(rememberAsColor)8@245L48:ComposeColorParser.kt");
            ComposerKt.sourceInformationMarkerStart($composer3, -1864083694, "CC(remember):ComposeColorParser.kt#9igjgp");
            boolean invalid$iv$iv4 = (((0 & 14) ^ 6) > 4 && $composer3.changed($this$rememberAsColor$iv4)) || (false & true);
            Object it$iv$iv4 = $composer3.rememberedValue();
            if (invalid$iv$iv4) {
            }
            Object value$iv$iv4 = Color.box-impl(ComposeColorParserKt.parseColor($this$rememberAsColor$iv4));
            $composer3.updateRememberedValue(value$iv$iv4);
            it$iv$iv4 = value$iv$iv4;
            long textColor = ((Color) it$iv$iv4).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String $this$rememberAsColor$iv5 = $this$Label.getMedalColorLevel();
            ComposerKt.sourceInformationMarkerStart($composer3, -1146072542, "CC(rememberAsColor)8@245L48:ComposeColorParser.kt");
            ComposerKt.sourceInformationMarkerStart($composer3, -1864083694, "CC(remember):ComposeColorParser.kt#9igjgp");
            boolean invalid$iv$iv5 = (((0 & 14) ^ 6) > 4 && $composer3.changed($this$rememberAsColor$iv5)) || (false & true);
            Object it$iv$iv5 = $composer3.rememberedValue();
            if (invalid$iv$iv5) {
            }
            Object value$iv$iv5 = Color.box-impl(ComposeColorParserKt.parseColor($this$rememberAsColor$iv5));
            $composer3.updateRememberedValue(value$iv$iv5);
            it$iv$iv5 = value$iv$iv5;
            long levelColor = ((Color) it$iv$iv5).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Painter guardPainter = getMedalPainter($this$Label, $composer3, $dirty & 14);
            boolean hasGuard = guardPainter != null;
            PaddingValues textPadding = PaddingKt.PaddingValues-a9UjIt4$default(hasGuard ? Dp.constructor-impl(11) : Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 10, (Object) null);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -410052215, "C136@4735L1522:ConversationLabel.kt#yqxgzx");
            Modifier modifier$iv2 = IntrinsicKt.height(ClipKt.clip(BorderKt.border-xT4_qwU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, hasGuard ? Dp.constructor-impl((float) 8.5d) : Dp.constructor-impl(0), Dp.constructor-impl(1), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(1), 4, (Object) null), Dp.constructor-impl((float) 0.5d), borderColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(1))), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(1))), IntrinsicSize.Max);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (384 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$Label_u24lambda_u247_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -23526591, "C154@5426L9,151@5317L583,167@5914L78,172@6123L9,169@6006L241:ConversationLabel.kt#yqxgzx");
            TextKt.Text-Nvy7gAk($this$Label.getMedalName(), $this$Label_u24lambda_u247_u240.alignByBaseline(PaddingKt.padding(PaddingKt.padding-VpY3zN4$default(OffsetKt.offset-VpY3zN4$default(BackgroundKt.background$default(OffsetKt.offset-VpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(1), 1, (Object) null), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(bgStart), Color.box-impl(bgEnd)}), 0L, 0L, 0, 14, (Object) null), (Shape) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, 6, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(-1), 1, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl((float) 1.5d), 1, (Object) null), textPadding)), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), $composer3, 0, 0, 131064);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), borderColor, (Shape) null, 2, (Object) null), $composer3, 0);
            TextKt.Text-Nvy7gAk(String.valueOf($this$Label.getLevel()), $this$Label_u24lambda_u247_u240.alignByBaseline(SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), Dp.constructor-impl(14))), levelColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), $composer3, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (guardPainter != null) {
                $composer3.startReplaceGroup(-408542795);
                ComposerKt.sourceInformation($composer3, "177@6306L201");
                ImageKt.Image(guardPainter, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), (Alignment) null, ContentScale.Companion.getFit(), (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer3, Painter.$stable | 25008, 104);
            } else {
                $composer3.startReplaceGroup(-414805570);
            }
            $composer3.endReplaceGroup();
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
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.ConversationLabelKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Label$lambda$8;
                    Label$lambda$8 = ConversationLabelKt.Label$lambda$8($this$Label, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Label$lambda$8;
                }
            });
        }
    }

    private static final Painter getMedalPainter(KMedal $this$getMedalPainter, Composer $composer, int $changed) {
        Painter painter;
        ComposerKt.sourceInformationMarkerStart($composer, 196270521, "C(getMedalPainter):ConversationLabel.kt#yqxgzx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(196270521, $changed, -1, "im.session.common.getMedalPainter (ConversationLabel.kt:189)");
        }
        long guardLevel = $this$getMedalPainter.getGuardLevel();
        if (guardLevel == 1) {
            $composer.startReplaceGroup(-362587612);
            ComposerKt.sourceInformation($composer, "190@6631L43");
            painter = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_medal_high(Res.drawable.INSTANCE), $composer, 0);
            $composer.endReplaceGroup();
        } else if (guardLevel == 2) {
            $composer.startReplaceGroup(-362585754);
            ComposerKt.sourceInformation($composer, "191@6689L45");
            painter = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_medal_middle(Res.drawable.INSTANCE), $composer, 0);
            $composer.endReplaceGroup();
        } else if (guardLevel == 3) {
            $composer.startReplaceGroup(-362583837);
            ComposerKt.sourceInformation($composer, "192@6749L42");
            painter = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_medal_low(Res.drawable.INSTANCE), $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(1644860292);
            $composer.endReplaceGroup();
            painter = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return painter;
    }
}