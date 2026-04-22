package kntr.app.tribee.publish.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Color;
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
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.publish.ui.generated.resources.Res;
import srcs.app.tribee.publish.ui.generated.resources.String0_commonMainKt;

/* compiled from: Header.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052&\u0010\u0006\u001a\"\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007j\u0002`\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Header", "", "contentValid", "", "onClose", "Lkotlin/Function0;", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/TribeeActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HeaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Header$lambda$1(boolean z, Function0 function0, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Header(z, function0, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0202, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Header(final boolean contentValid, final Function0<Unit> function0, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Composer $composer3;
        Composer $composer$iv;
        Composer $composer$iv2;
        boolean z;
        Intrinsics.checkNotNullParameter(function0, "onClose");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Composer $composer4 = $composer.startRestartGroup(1428507019);
        ComposerKt.sourceInformation($composer4, "C(Header)N(contentValid,onClose,onAction,modifier)35@1462L2170:Header.kt#1zy72f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(contentValid) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1428507019, $dirty2, -1, "kntr.app.tribee.publish.internal.Header (Header.kt:34)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(modifier4, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(16), 0.0f, 10, (Object) null), 0.0f, Dp.constructor-impl(8), 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1685207285, "C41@1738L20,42@1824L13,43@1868L6,40@1697L240,47@1959L24,48@2015L54,49@2103L56,51@2193L48,55@2376L6,57@2517L593,70@3187L9,72@3248L6,50@2168L1458:Header.kt#1zy72f");
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer4, 6);
            Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer4, 1469661276, "CC(remember):Header.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.tribee.publish.internal.HeaderKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit Header$lambda$0$0$0;
                    Header$lambda$0$0$0 = HeaderKt.Header$lambda$0$0$0(function0);
                    return Header$lambda$0$0$0;
                }
            };
            $composer4.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_medium-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer4.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final String titleToastString = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_title_overflow_toast(Res.string.INSTANCE), $composer4, 0);
            final String contentToastString = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_content_overflow_toast(Res.string.INSTANCE), $composer4, 0);
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_publish_button(Res.string.INSTANCE), $composer4, 0);
            Modifier modifier6 = BackgroundKt.background-bw27NRU(Modifier.Companion, Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), contentValid ? 1.0f : 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart($composer4, 1469684032, "CC(remember):Header.kt#9igjgp");
            $composer2 = $composer4;
            boolean invalid$iv2 = $composer2.changedInstance(scope) | (($dirty2 & 14) == 4) | $composer2.changedInstance(function2) | $composer2.changed(titleToastString) | $composer2.changed(contentToastString);
            Object value$iv2 = $composer4.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                $composer3 = $composer4;
                $composer$iv = $composer4;
                $composer$iv2 = $composer4;
                z = false;
                value$iv2 = new Function0() { // from class: kntr.app.tribee.publish.internal.HeaderKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit Header$lambda$0$1$0;
                        Header$lambda$0$1$0 = HeaderKt.Header$lambda$0$1$0(scope, contentValid, function2, titleToastString, contentToastString);
                        return Header$lambda$0$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
            } else {
                $composer3 = $composer4;
                $composer$iv2 = $composer4;
                $composer$iv = $composer4;
                z = false;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier7 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null), Dp.constructor-impl(10), Dp.constructor-impl(4));
            Composer $composer5 = $composer3;
            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT14();
            long j = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText_white-0d7_KjU();
            if (contentValid) {
                $composer5.startReplaceGroup(-1683618764);
                $composer5.endReplaceGroup();
                z = true;
            } else {
                $composer5.startReplaceGroup(1469711771);
                ComposerKt.sourceInformation($composer5, "76@3411L13");
                if (BiliTheme.INSTANCE.getDayNightTheme($composer5, BiliTheme.$stable) == ThemeDayNight.Day) {
                    z = true;
                }
                $composer5.endReplaceGroup();
            }
            TextKt.Text-Nvy7gAk(stringResource, modifier7, Color.copy-wmQWz5c$default(j, z ? 1.0f : 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14, $composer5, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.internal.HeaderKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Header$lambda$1;
                    Header$lambda$1 = HeaderKt.Header$lambda$1(contentValid, function0, function2, modifier8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Header$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Header$lambda$0$0$0(Function0 $onClose) {
        $onClose.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Header$lambda$0$1$0(CoroutineScope $scope, boolean $contentValid, Function2 $onAction, String $titleToastString, String $contentToastString) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new HeaderKt$Header$1$2$1$1($contentValid, $onAction, $titleToastString, $contentToastString, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}