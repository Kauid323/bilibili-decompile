package kntr.app.tribee.invite.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TribeeInviteNavigationRow.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"NavigationRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "textInCenter", "", "textInRight", "urlInRight", "onClickInRightText", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInviteNavigationRowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow$lambda$4(Modifier modifier, String str, String str2, String str3, Function1 function1, int i, int i2, Composer composer, int i3) {
        NavigationRow(modifier, str, str2, str3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v21 */
    public static final void NavigationRow(Modifier modifier, String textInCenter, String textInRight, String urlInRight, Function1<? super String, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        String str2;
        final String urlInRight2;
        final Function1 onClickInRightText;
        Composer $composer2;
        Modifier modifier3;
        String textInCenter2;
        String textInRight2;
        Function0 factory$iv$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(-1740129084);
        ComposerKt.sourceInformation($composer3, "C(NavigationRow)N(modifier,textInCenter,textInRight,urlInRight,onClickInRightText)32@1237L2,34@1296L7,36@1329L92,46@1606L2,41@1426L1579:TribeeInviteNavigationRow.kt#8mvn07");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str = textInCenter;
        } else if (($changed & 48) == 0) {
            str = textInCenter;
            $dirty |= $composer3.changed(str) ? 32 : 16;
        } else {
            str = textInCenter;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            str2 = textInRight;
        } else if (($changed & 384) == 0) {
            str2 = textInRight;
            $dirty |= $composer3.changed(str2) ? 256 : 128;
        } else {
            str2 = textInRight;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            urlInRight2 = urlInRight;
        } else if (($changed & 3072) == 0) {
            urlInRight2 = urlInRight;
            $dirty |= $composer3.changed(urlInRight2) ? 2048 : 1024;
        } else {
            urlInRight2 = urlInRight;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            onClickInRightText = function1;
        } else if (($changed & 24576) == 0) {
            onClickInRightText = function1;
            $dirty |= $composer3.changedInstance(onClickInRightText) ? 16384 : 8192;
        } else {
            onClickInRightText = function1;
        }
        if ($composer3.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            String textInCenter3 = i3 != 0 ? "" : str;
            String textInRight3 = i4 != 0 ? "" : str2;
            if (i5 != 0) {
                urlInRight2 = "";
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1521765594, "CC(remember):TribeeInviteNavigationRow.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteNavigationRowKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit NavigationRow$lambda$0$0;
                            NavigationRow$lambda$0$0 = TribeeInviteNavigationRowKt.NavigationRow$lambda$0$0((String) obj);
                            return NavigationRow$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onClickInRightText2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onClickInRightText = onClickInRightText2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1740129084, $dirty, -1, "kntr.app.tribee.invite.page.NavigationRow (TribeeInviteNavigationRow.kt:33)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer3, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer3, -1521762560, "CC(remember):TribeeInviteNavigationRow.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteNavigationRowKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit NavigationRow$lambda$1$0;
                        NavigationRow$lambda$1$0 = TribeeInviteNavigationRowKt.NavigationRow$lambda$1$0(backHandler);
                        return NavigationRow$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final Function0 onBack = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer3, -1521753786, "CC(remember):TribeeInviteNavigationRow.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteNavigationRowKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier5, (MutableInteractionSource) null, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((384 >> 6) & 112) | 6;
            RowScope $this$NavigationRow_u24lambda_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1275588190, "C50@1724L24,52@1825L6,58@2032L39,60@2150L12,49@1682L514,68@2349L6,64@2206L250:TribeeInviteNavigationRow.kt#8mvn07");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer3, 6);
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier6 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer3, -1067220729, "CC(remember):TribeeInviteNavigationRow.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1067216980, "CC(remember):TribeeInviteNavigationRow.kt#9igjgp");
            Object value$iv5 = $composer3.rememberedValue();
            if (value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteNavigationRowKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit NavigationRow$lambda$3$1$0;
                        NavigationRow$lambda$3$1$0 = TribeeInviteNavigationRowKt.NavigationRow$lambda$3$1$0(onBack);
                        return NavigationRow$lambda$3$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliIconfontKt.BiliIcon-ww6aTOc(arrow_back_left_line_500, ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) value$iv5, 28, (Object) null), "back icon", j, $composer3, Painter.$stable | 384, 0);
            String str3 = textInCenter3;
            TextKt.Text-Nvy7gAk(str3, RowScope.-CC.weight$default($this$NavigationRow_u24lambda_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(17), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty >> 3) & 14) | 1597440, 0, 261032);
            if (StringsKt.isBlank(textInRight3) || StringsKt.isBlank(urlInRight2)) {
                $composer3.startReplaceGroup(1273877826);
            } else {
                $composer3.startReplaceGroup(1276409534);
                ComposerKt.sourceInformation($composer3, "78@2674L39,78@2734L86,84@2962L6,74@2537L452");
                Modifier modifier7 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12));
                ComposerKt.sourceInformationMarkerStart($composer3, -1067200185, "CC(remember):TribeeInviteNavigationRow.kt#9igjgp");
                Object it$iv5 = $composer3.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                }
                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -1067198218, "CC(remember):TribeeInviteNavigationRow.kt#9igjgp");
                boolean invalid$iv = ((57344 & $dirty) == 16384) | (($dirty & 7168) == 2048);
                Object it$iv6 = $composer3.rememberedValue();
                if (invalid$iv || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteNavigationRowKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit NavigationRow$lambda$3$3$0;
                            NavigationRow$lambda$3$3$0 = TribeeInviteNavigationRowKt.NavigationRow$lambda$3$3$0(onClickInRightText, urlInRight2);
                            return NavigationRow$lambda$3$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv7);
                    it$iv6 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                TextKt.Text-Nvy7gAk(textInRight3, ClickableKt.clickable-O2vRcR0$default(modifier7, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv6, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty >> 6) & 14) | 24576, 48, 260072);
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
            textInCenter2 = textInCenter3;
            textInRight2 = textInRight3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            textInCenter2 = str;
            textInRight2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final String str4 = textInCenter2;
            final String str5 = textInRight2;
            final String str6 = urlInRight2;
            final Function1 function12 = onClickInRightText;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteNavigationRowKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit NavigationRow$lambda$4;
                    NavigationRow$lambda$4 = TribeeInviteNavigationRowKt.NavigationRow$lambda$4(modifier8, str4, str5, str6, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NavigationRow$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow$lambda$1$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow$lambda$3$1$0(Function0 $onBack) {
        $onBack.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow$lambda$3$3$0(Function1 $onClickInRightText, String $urlInRight) {
        $onClickInRightText.invoke($urlInRight);
        return Unit.INSTANCE;
    }
}