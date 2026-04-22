package kntr.app.digital.preview.card;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.CardNumberColorUtilKt;
import kntr.app.digital.preview.CardNumberGradientColor;
import kntr.app.digital.preview.api.DescTag;
import kntr.app.digital.preview.api.TopText;
import kntr.app.digital.preview.card.video.DigitalVideoCardVolumeService;
import kntr.app.digital.preview.lock.LockUIService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.FontResources_androidKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Font0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: DigitalCardDetailInfoUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "volumeService", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "router", "Lkntr/base/router/Router;", "lockUiService", "Lkntr/app/digital/preview/lock/LockUIService;", "<init>", "(Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;Lkntr/base/router/Router;Lkntr/app/digital/preview/lock/LockUIService;)V", "BaseUI", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DescContent", "NoticeContent", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalCardDetailInfoUIService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final LockUIService lockUiService;
    private final Router router;
    private final DigitalVideoCardVolumeService volumeService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BaseUI$lambda$0(DigitalCardDetailInfoUIService digitalCardDetailInfoUIService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        digitalCardDetailInfoUIService.BaseUI(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DescContent$lambda$1(DigitalCardDetailInfoUIService digitalCardDetailInfoUIService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        digitalCardDetailInfoUIService.DescContent(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoticeContent$lambda$1(DigitalCardDetailInfoUIService digitalCardDetailInfoUIService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        digitalCardDetailInfoUIService.NoticeContent(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public DigitalCardDetailInfoUIService(DigitalCardStateService cardStateService, DigitalVideoCardVolumeService volumeService, Router router, LockUIService lockUiService) {
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(volumeService, "volumeService");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(lockUiService, "lockUiService");
        this.cardStateService = cardStateService;
        this.volumeService = volumeService;
        this.router = router;
        this.lockUiService = lockUiService;
    }

    public final void BaseUI(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(-672565208);
        ComposerKt.sourceInformation($composer2, "C(BaseUI)N(modifier):DigitalCardDetailInfoUIService.kt#v85lra");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-672565208, $dirty2, -1, "kntr.app.digital.preview.card.DigitalCardDetailInfoUIService.BaseUI (DigitalCardDetailInfoUIService.kt:49)");
            }
            CardBasic cardBasic = this.cardStateService.getCurrentCardItem().getBasic();
            if (cardBasic.getBaseShowing()) {
                $composer2.startReplaceGroup(-367503202);
                ComposerKt.sourceInformation($composer2, "53@2304L44,52@2267L188");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_bottom_base(Res.drawable.INSTANCE), $composer2, 0), (String) null, modifier3, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48 | (($dirty2 << 6) & 896), 120);
            } else {
                $composer2.startReplaceGroup(-369758886);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.DigitalCardDetailInfoUIService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit BaseUI$lambda$0;
                    BaseUI$lambda$0 = DigitalCardDetailInfoUIService.BaseUI$lambda$0(DigitalCardDetailInfoUIService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BaseUI$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x04e1, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void DescContent(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1022394481);
        ComposerKt.sourceInformation($composer2, "C(DescContent)N(modifier)63@2637L2797:DigitalCardDetailInfoUIService.kt#v85lra");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1022394481, $dirty, -1, "kntr.app.digital.preview.card.DigitalCardDetailInfoUIService.DescContent (DigitalCardDetailInfoUIService.kt:61)");
            }
            final CardBasic cardBasic = this.cardStateService.getCurrentCardItem().getBasic();
            int $changed$iv = $dirty & 14;
            Modifier modifier$iv$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            Modifier modifier4 = modifier3;
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i4 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$DescContent_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1583959642, "C81@3540L1880:DigitalCardDetailInfoUIService.kt#v85lra");
            DescTag descTag = cardBasic.getDescTag();
            if ((descTag != null ? descTag.getStyle() : null) != DescTag.Style.Top || StringsKt.isBlank(descTag.getText())) {
                $composer$iv$iv = $composer2;
                $composer$iv = $composer2;
                $composer2.startReplaceGroup(1581215149);
            } else {
                $composer2.startReplaceGroup(1584034816);
                ComposerKt.sourceInformation($composer2, "77@3407L9,66@2820L685");
                $composer$iv = $composer2;
                $composer$iv$iv = $composer2;
                TextKt.Text-Nvy7gAk(descTag.getText(), PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(PaddingKt.padding-qDBjuR0$default($this$DescContent_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, Dp.constructor-impl(34), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl((float) 0.5d), Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(3))), Dp.constructor-impl(5), Dp.constructor-impl(1)), Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 384, 0, 131064);
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = $this$DescContent_u24lambda_u240.align(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(71), 0.0f, 0.0f, 13, (Object) null), Alignment.Companion.getTopCenter());
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -735096043, "C88@3831L58:DigitalCardDetailInfoUIService.kt#v85lra");
            CardInfoUIKt.CardNameUI(cardBasic.getCardName(), Modifier.Companion, $composer2, 48, 0);
            if ((descTag != null ? descTag.getStyle() : null) != DescTag.Style.Bottom || StringsKt.isBlank(descTag.getText())) {
                if (!StringsKt.isBlank(cardBasic.getRarity().getText())) {
                    $composer2.startReplaceGroup(-734268623);
                    ComposerKt.sourceInformation($composer2, "109@5050L303,103@4718L662");
                    String text = cardBasic.getRarity().getText();
                    boolean z = !StringsKt.isBlank(cardBasic.getRarity().getJumpUrl());
                    Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(9), 0.0f, 0.0f, 13, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1777440282, "CC(remember):DigitalCardDetailInfoUIService.kt#9igjgp");
                    boolean invalid$iv = $composer2.changedInstance(cardBasic) | $composer2.changedInstance(this);
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.digital.preview.card.DigitalCardDetailInfoUIService$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit DescContent$lambda$0$0$0$0;
                            DescContent$lambda$0$0$0$0 = DigitalCardDetailInfoUIService.DescContent$lambda$0$0$0$0(CardBasic.this, this);
                            return DescContent$lambda$0$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    CardInfoUIKt.CardRarityUI(text, z, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer2, 0, 0);
                } else {
                    $composer2.startReplaceGroup(-738946089);
                }
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-734949104);
                ComposerKt.sourceInformation($composer2, "99@4519L9,100@4580L6,90@4009L615");
                TextKt.Text-Nvy7gAk(descTag.getText(), PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(14), 0.0f, 0.0f, 13, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(9), Dp.constructor-impl(3)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 0, 131064);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.DigitalCardDetailInfoUIService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit DescContent$lambda$1;
                    DescContent$lambda$1 = DigitalCardDetailInfoUIService.DescContent$lambda$1(DigitalCardDetailInfoUIService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DescContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DescContent$lambda$0$0$0$0(CardBasic $cardBasic, DigitalCardDetailInfoUIService this$0) {
        String jumpUrl = $cardBasic.getRarity().getJumpUrl();
        if (!StringsKt.isBlank(jumpUrl)) {
            this$0.router.launch(UrisKt.toUri(jumpUrl));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x03d8, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void NoticeContent(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        int $i$f$any;
        FontFamily fontFamily;
        TextStyle textStyle;
        Composer $composer2 = $composer.startRestartGroup(-1520860824);
        ComposerKt.sourceInformation($composer2, "C(NoticeContent)N(modifier)123@5537L2669:DigitalCardDetailInfoUIService.kt#v85lra");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520860824, $dirty, -1, "kntr.app.digital.preview.card.DigitalCardDetailInfoUIService.NoticeContent (DigitalCardDetailInfoUIService.kt:122)");
            }
            Modifier modifier$iv$iv = SizeKt.heightIn-VpY3zN4$default(modifier3, Dp.constructor-impl(16), 0.0f, 2, (Object) null);
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
            Modifier modifier4 = modifier3;
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
            BoxScope $this$NoticeContent_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -730172042, "C127@5718L241:DigitalCardDetailInfoUIService.kt#v85lra");
            CardBasic cardBasic = this.cardStateService.getCurrentCardItem().getBasic();
            this.lockUiService.Content($this$NoticeContent_u24lambda_u240.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(24)), Alignment.Companion.getCenterStart()), $composer2, 0, 0);
            TopText topText = cardBasic.getTopText();
            if (topText != null) {
                $composer2.startReplaceGroup(-729802337);
                ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                if (StringsKt.isBlank(topText.getText())) {
                    $composer2.startReplaceGroup(-735840300);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-729751962);
                    ComposerKt.sourceInformation($composer2, "153@7088L9,138@6192L1114");
                    CardNumberGradientColor textGradientColor = topText.getColorFormat();
                    String text = topText.getText();
                    if (topText.getStyle() == TopText.Style.Card) {
                        $composer2.startReplaceGroup(2054675799);
                        ComposerKt.sourceInformation($composer2, "140@6340L29");
                        FontFamily FontFamily = FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getDigital_id_num(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer2, 0, 14)});
                        $composer2.endReplaceGroup();
                        fontFamily = FontFamily;
                    } else {
                        $composer2.startReplaceGroup(-729514193);
                        $composer2.endReplaceGroup();
                        fontFamily = null;
                    }
                    if (textGradientColor != null) {
                        $composer2.startReplaceGroup(-729406560);
                        ComposerKt.sourceInformation($composer2, "143@6519L44");
                        TextStyle digitalNumberTextStyle = CardNumberColorUtilKt.getDigitalNumberTextStyle(textGradientColor, $composer2, 0);
                        $composer2.endReplaceGroup();
                        textStyle = digitalNumberTextStyle;
                    } else {
                        $composer2.startReplaceGroup(-729274624);
                        $composer2.endReplaceGroup();
                        textStyle = new TextStyle(cardBasic.getHasMask() ? Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : Color.Companion.getWhite-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null);
                    }
                    TextKt.Text-Nvy7gAk(text, $this$NoticeContent_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, fontFamily, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, textStyle.merge(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14()), $composer2, 0, 24960, 110460);
                    $composer2.endReplaceGroup();
                }
            } else {
                $composer2.startReplaceGroup(-735840300);
            }
            $composer2.endReplaceGroup();
            List volumeKeysShowingList = this.volumeService.getCardsVolumeShowing();
            List $this$any$iv = volumeKeysShowingList;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        $i$f$any = 0;
                        break;
                    }
                    Object element$iv = it.next();
                    List volumeKeysShowingList2 = volumeKeysShowingList;
                    String it2 = (String) element$iv;
                    Iterable $this$any$iv2 = $this$any$iv;
                    if (Intrinsics.areEqual(it2, cardBasic.getUniqueId())) {
                        $i$f$any = 1;
                        break;
                    } else {
                        $this$any$iv = $this$any$iv2;
                        volumeKeysShowingList = volumeKeysShowingList2;
                    }
                }
            } else {
                $i$f$any = 0;
            }
            int volumeKeysShowing = $i$f$any;
            if (volumeKeysShowing != 0) {
                $composer2.startReplaceGroup(-728322118);
                ComposerKt.sourceInformation($composer2, "165@7679L86,170@7987L113,164@7638L536");
                final boolean volumeOn = this.volumeService.getVolumeOn();
                Res.drawable drawableVar = Res.drawable.INSTANCE;
                Painter painterResource = ImageResourcesKt.painterResource(volumeOn ? Drawable0_commonMainKt.getIc_sound_on(drawableVar) : Drawable0_commonMainKt.getIc_sound_off(drawableVar), $composer2, 0);
                Modifier align = $this$NoticeContent_u24lambda_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), Alignment.Companion.getCenterEnd());
                ComposerKt.sourceInformationMarkerStart($composer2, 2054728927, "CC(remember):DigitalCardDetailInfoUIService.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(this) | $composer2.changed(volumeOn);
                Object value$iv = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = new Function0() { // from class: kntr.app.digital.preview.card.DigitalCardDetailInfoUIService$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit NoticeContent$lambda$0$1$0;
                        NoticeContent$lambda$0$1$0 = DigitalCardDetailInfoUIService.NoticeContent$lambda$0$1$0(DigitalCardDetailInfoUIService.this, volumeOn);
                        return NoticeContent$lambda$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(painterResource, (String) null, ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
            } else {
                $composer2.startReplaceGroup(-735840300);
            }
            $composer2.endReplaceGroup();
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
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.DigitalCardDetailInfoUIService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit NoticeContent$lambda$1;
                    NoticeContent$lambda$1 = DigitalCardDetailInfoUIService.NoticeContent$lambda$1(DigitalCardDetailInfoUIService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NoticeContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoticeContent$lambda$0$1$0(DigitalCardDetailInfoUIService this$0, boolean $volumeOn) {
        this$0.volumeService.markCardVolumeOn(!$volumeOn);
        return Unit.INSTANCE;
    }
}