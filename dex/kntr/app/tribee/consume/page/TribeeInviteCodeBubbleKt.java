package kntr.app.tribee.consume.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.bilibubble.BiliBubbleKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.tribee.consume.generated.resources.Drawable0_commonMainKt;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeInviteCodeBubble.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002"}, d2 = {"TribeeInviteCodeBubble", "", "bubbleText", "", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug", "currentOnDismiss"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInviteCodeBubbleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCodeBubble$lambda$7(String str, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeInviteCodeBubble(str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x02bb, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeInviteCodeBubble(final String bubbleText, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        long textBackground;
        long textColor;
        Object value$iv;
        Object it$iv;
        boolean invalid$iv;
        Function0 factory$iv$iv$iv;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(217839190);
        ComposerKt.sourceInformation($composer3, "C(TribeeInviteCodeBubble)N(bubbleText,onDismiss,modifier)42@1750L31,43@1807L47,43@1786L68,46@1877L33,48@1967L7,54@2195L7,60@2394L7,74@2767L55,74@2746L76,82@2934L39,84@3036L51,79@2828L907:TribeeInviteCodeBubble.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(bubbleText) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(217839190, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeInviteCodeBubble (TribeeInviteCodeBubble.kt:41)");
            }
            State currentOnDismiss$delegate = SnapshotStateKt.rememberUpdatedState(function0, $composer3, ($dirty2 >> 3) & 14);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1109929371, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TribeeInviteCodeBubbleKt$TribeeInviteCodeBubble$1$1(null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, -1109927145, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            final MutableIntState bubbleWidth = (MutableIntState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            DrawableResource bubbleResource = consume == ThemeDayNight.Night ? Drawable0_commonMainKt.getTribee_invite_code_bubble_dark(Res.drawable.INSTANCE) : Drawable0_commonMainKt.getTribee_invite_code_bubble_day(Res.drawable.INSTANCE);
            CompositionLocal this_$iv2 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (consume2 == ThemeDayNight.Night) {
                $composer3.startReplaceGroup(-47655367);
                ComposerKt.sourceInformation($composer3, "55@2251L6");
                long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU();
                $composer3.endReplaceGroup();
                textBackground = j;
            } else {
                $composer3.startReplaceGroup(-47598606);
                $composer3.endReplaceGroup();
                textBackground = Color.copy-wmQWz5c$default(ColorKt.Color(3093048), 0.9f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            CompositionLocal this_$iv3 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (consume3 == ThemeDayNight.Night) {
                $composer3.startReplaceGroup(-47458176);
                ComposerKt.sourceInformation($composer3, "61@2450L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU();
                $composer3.endReplaceGroup();
                textColor = j2;
            } else {
                $composer3.startReplaceGroup(-47408359);
                ComposerKt.sourceInformation($composer3, "63@2500L6");
                long j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU();
                $composer3.endReplaceGroup();
                textColor = j3;
            }
            TextStyle textStyle = new TextStyle(textColor, TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744444, (DefaultConstructorMarker) null);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1109898643, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(currentOnDismiss$delegate);
            Object it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv2 && it$iv4 != Composer.Companion.getEmpty()) {
                value$iv = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(unit2, (Function2) value$iv, $composer3, 6);
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -1109893315, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
                it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv5);
                    it$iv = value$iv5;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -1109890039, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
                invalid$iv = ($dirty2 & 112) != 32;
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv6 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeInviteCodeBubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit TribeeInviteCodeBubble$lambda$5$0;
                        TribeeInviteCodeBubble$lambda$5$0 = TribeeInviteCodeBubbleKt.TribeeInviteCodeBubble$lambda$5$0(function0);
                        return TribeeInviteCodeBubble$lambda$5$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(fillMaxSize$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv5, 28, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
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
                    $composer3.useNode();
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer3.createNode(factory$iv$iv$iv);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                $composer2 = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i4 = ((0 >> 6) & 112) | 6;
                BoxScope $this$TribeeInviteCodeBubble_u24lambda_u246 = BoxScopeInstance.INSTANCE;
                modifier3 = modifier4;
                ComposerKt.sourceInformationMarkerStart($composer3, 906200998, "C95@3361L7,96@3434L29,102@3692L26,89@3120L609:TribeeInviteCodeBubble.kt#iitu82");
                Modifier align = $this$TribeeInviteCodeBubble_u24lambda_u246.align(PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.Companion), 0.0f, Dp.constructor-impl(25), 0.0f, 0.0f, 13, (Object) null), Alignment.Companion.getTopEnd());
                CompositionLocal this_$iv4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(this_$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$TribeeInviteCodeBubble_u24lambda_u246_u240 = (Density) consume4;
                Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(align, 0.0f, 0.0f, Dp.constructor-impl($this$TribeeInviteCodeBubble_u24lambda_u246_u240.toDp-u2uoSUM(bubbleWidth.getValue().intValue()) + Dp.constructor-impl(40)), 0.0f, 11, (Object) null);
                ImageBitmap imageResource = ImageResourcesKt.imageResource(bubbleResource, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, -1217675978, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
                value$iv2 = $composer3.rememberedValue();
                if (value$iv2 != Composer.Companion.getEmpty()) {
                    value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeInviteCodeBubbleKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeInviteCodeBubble$lambda$6$1$0;
                            TribeeInviteCodeBubble$lambda$6$1$0 = TribeeInviteCodeBubbleKt.TribeeInviteCodeBubble$lambda$6$1$0(bubbleWidth, ((Integer) obj).intValue());
                            return TribeeInviteCodeBubble$lambda$6$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BiliBubbleKt.m1827BiliBubble3csKH6Y((Function1) value$iv2, imageResource, bubbleText, 0.37931034f, 0.20689656f, textStyle, textBackground, modifier5, $composer3, (($dirty2 << 6) & 896) | 27654, 0);
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
            value$iv = (Function2) new TribeeInviteCodeBubbleKt$TribeeInviteCodeBubble$2$1(currentOnDismiss$delegate, null);
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit2, (Function2) value$iv, $composer3, 6);
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1109893315, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1109890039, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
            invalid$iv = ($dirty2 & 112) != 32;
            Object it$iv52 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv62 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeInviteCodeBubbleKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit TribeeInviteCodeBubble$lambda$5$0;
                    TribeeInviteCodeBubble$lambda$5$0 = TribeeInviteCodeBubbleKt.TribeeInviteCodeBubble$lambda$5$0(function0);
                    return TribeeInviteCodeBubble$lambda$5$0;
                }
            };
            $composer3.updateRememberedValue(value$iv62);
            it$iv52 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(fillMaxSize$default2, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv52, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i42 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeInviteCodeBubble_u24lambda_u2462 = BoxScopeInstance.INSTANCE;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 906200998, "C95@3361L7,96@3434L29,102@3692L26,89@3120L609:TribeeInviteCodeBubble.kt#iitu82");
            Modifier align2 = $this$TribeeInviteCodeBubble_u24lambda_u2462.align(PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.Companion), 0.0f, Dp.constructor-impl(25), 0.0f, 0.0f, 13, (Object) null), Alignment.Companion.getTopEnd());
            CompositionLocal this_$iv42 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume42 = $composer3.consume(this_$iv42);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$TribeeInviteCodeBubble_u24lambda_u246_u2402 = (Density) consume42;
            Modifier modifier52 = PaddingKt.padding-qDBjuR0$default(align2, 0.0f, 0.0f, Dp.constructor-impl($this$TribeeInviteCodeBubble_u24lambda_u246_u2402.toDp-u2uoSUM(bubbleWidth.getValue().intValue()) + Dp.constructor-impl(40)), 0.0f, 11, (Object) null);
            ImageBitmap imageResource2 = ImageResourcesKt.imageResource(bubbleResource, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -1217675978, "CC(remember):TribeeInviteCodeBubble.kt#9igjgp");
            value$iv2 = $composer3.rememberedValue();
            if (value$iv2 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliBubbleKt.m1827BiliBubble3csKH6Y((Function1) value$iv2, imageResource2, bubbleText, 0.37931034f, 0.20689656f, textStyle, textBackground, modifier52, $composer3, (($dirty2 << 6) & 896) | 27654, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeInviteCodeBubbleKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInviteCodeBubble$lambda$7;
                    TribeeInviteCodeBubble$lambda$7 = TribeeInviteCodeBubbleKt.TribeeInviteCodeBubble$lambda$7(bubbleText, function0, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInviteCodeBubble$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> TribeeInviteCodeBubble$lambda$0(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCodeBubble$lambda$5$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInviteCodeBubble$lambda$6$1$0(MutableIntState $bubbleWidth, int it) {
        $bubbleWidth.setValue(it);
        return Unit.INSTANCE;
    }
}