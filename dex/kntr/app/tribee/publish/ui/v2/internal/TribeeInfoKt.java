package kntr.app.tribee.publish.ui.v2.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
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
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.publishV2.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.tribee.publishV2.ui.generated.resources.Res;
import srcs.app.tribee.publishV2.ui.generated.resources.String0_commonMainKt;

/* compiled from: TribeeInfo.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072&\u0010\t\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\nj\u0002`\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"TribeeInfo", "", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "selectedCategory", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "showSyncToFollowing", "", "syncToFollowing", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/ui/v2/TribeeActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CheckMark", "checked", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInfoKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckMark$lambda$0(boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CheckMark(z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInfo$lambda$2(TribeeInfo tribeeInfo, KTribeeCategory kTribeeCategory, boolean z, boolean z2, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeInfo(tribeeInfo, kTribeeCategory, z, z2, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0655, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeInfo(final TribeeInfo tribeeInfo, final KTribeeCategory selectedCategory, final boolean showSyncToFollowing, final boolean syncToFollowing, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        String str;
        String str2;
        Composer $composer$iv$iv$iv;
        String str3;
        Composer $composer$iv$iv2;
        Composer $composer3;
        final boolean z;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Composer $composer4 = $composer.startRestartGroup(-36758596);
        ComposerKt.sourceInformation($composer4, "C(TribeeInfo)N(tribeeInfo,selectedCategory,showSyncToFollowing,syncToFollowing,onAction,modifier)46@1948L24,138@5654L1205,48@1978L4881:TribeeInfo.kt#vjrpu9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(tribeeInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(selectedCategory) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(showSyncToFollowing) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(syncToFollowing) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-36758596, $dirty2, -1, "kntr.app.tribee.publish.ui.v2.internal.TribeeInfo (TribeeInfo.kt:45)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer4.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -965144975, "CC(remember):TribeeInfo.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (MeasurePolicy) TribeeInfoKt$TribeeInfo$1$1.INSTANCE;
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            int $changed$iv = (($dirty2 >> 12) & 112) | 384;
            Modifier modifier$iv = modifier4;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer4.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1700024026, "C54@2190L6,49@2026L2522:TribeeInfo.kt#vjrpu9");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(Modifier.Companion, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(8), Dp.constructor-impl((float) 3.5d));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((432 >> 6) & 112) | 6;
            RowScope $this$TribeeInfo_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -792635791, "C61@2506L41,64@2698L6,60@2473L253,69@2821L9,70@2870L6,67@2740L299:TribeeInfo.kt#vjrpu9");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getTribee_icon(Res.drawable.INSTANCE), $composer4, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), 0, 2, (Object) null), $composer4, Painter.$stable | 432, 56);
            TextKt.Text-Nvy7gAk(tribeeInfo.getTitle(), $this$TribeeInfo_u24lambda_u241_u240.weight(Modifier.Companion, 1.0f, false), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 24960, 110584);
            if (selectedCategory != null) {
                $composer4.startReplaceGroup(-792032718);
                ComposerKt.sourceInformation($composer4, "77@3101L1423");
                Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                $composer$iv$iv = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                int $changed$iv$iv3 = (438 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                str3 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                $composer$iv$iv$iv = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i7 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1234718844, "C82@3442L6,82@3349L114,86@3587L9,87@3644L6,84@3485L335,93@3854L24,96@3953L20,98@4069L286,105@4398L6,95@3900L606:TribeeInfo.kt#vjrpu9");
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl((float) 0.5d), Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer4, 0);
                TextKt.Text-Nvy7gAk(selectedCategory.getName(), Modifier.Companion, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 48, 24960, 110584);
                ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object value$iv$iv2 = $composer4.rememberedValue();
                if (value$iv$iv2 == Composer.Companion.getEmpty()) {
                    value$iv$iv2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                    $composer4.updateRememberedValue(value$iv$iv2);
                }
                final CoroutineScope scope2 = (CoroutineScope) value$iv$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer4, 6);
                Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12));
                ComposerKt.sourceInformationMarkerStart($composer4, -1068526848, "CC(remember):TribeeInfo.kt#9igjgp");
                boolean invalid$iv = $composer4.changedInstance(scope2) | $composer4.changedInstance(function2);
                Object it$iv2 = $composer4.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInfoKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TribeeInfo$lambda$1$0$0$0$0;
                        TribeeInfo$lambda$1$0$0$0$0 = TribeeInfoKt.TribeeInfo$lambda$1$0$0$0$0(scope2, function2);
                        return TribeeInfo$lambda$1$0$0$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                IconKt.Icon-ww6aTOc(xmark_close_line_500, "remove selected category", ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer$iv$iv = $composer4;
                $composer$iv = $composer4;
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv$iv$iv = $composer4;
                str3 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                $composer4.startReplaceGroup(-795154015);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (showSyncToFollowing) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(1702494446);
                ComposerKt.sourceInformation($composer3, "115@4693L434,113@4597L1039");
                Modifier modifier7 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 470563639, "CC(remember):TribeeInfo.kt#9igjgp");
                $dirty2 = $dirty2;
                boolean invalid$iv2 = $composer4.changedInstance(scope) | (($dirty2 & 7168) == 2048) | $composer4.changedInstance(function2);
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    z = syncToFollowing;
                    $composer$iv$iv2 = $composer4;
                    Object value$iv3 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInfoKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit TribeeInfo$lambda$1$1$0;
                            TribeeInfo$lambda$1$1$0 = TribeeInfoKt.TribeeInfo$lambda$1$1$0(z, scope, function2);
                            return TribeeInfo$lambda$1$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                } else {
                    z = syncToFollowing;
                    $composer$iv$iv2 = $composer4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, str3);
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv4 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str2);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str);
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                $composer2 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i9 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1661403500, "C128@5293L69,131@5413L51,132@5504L9,133@5557L6,130@5380L242:TribeeInfo.kt#vjrpu9");
                CheckMark(z, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, (($dirty2 >> 9) & 14) | 48, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_sync_to_following(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer2 = $composer4;
                $composer$iv$iv2 = $composer4;
                $composer3 = $composer4;
                $dirty2 = $dirty2;
                $composer3.startReplaceGroup(1697901021);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInfoKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInfo$lambda$2;
                    TribeeInfo$lambda$2 = TribeeInfoKt.TribeeInfo$lambda$2(TribeeInfo.this, selectedCategory, showSyncToFollowing, syncToFollowing, function2, modifier8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInfo$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInfo$lambda$1$0$0$0$0(CoroutineScope $scope, Function2 $onAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInfoKt$TribeeInfo$2$1$1$1$1$1($onAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInfo$lambda$1$1$0(boolean $syncToFollowing, CoroutineScope $scope, Function2 $onAction) {
        if (!$syncToFollowing) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInfoKt$TribeeInfo$2$2$1$1($onAction, null), 3, (Object) null);
        }
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeInfoKt$TribeeInfo$2$2$1$2($onAction, $syncToFollowing, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void CheckMark(final boolean checked, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(1547522976);
        ComposerKt.sourceInformation($composer2, "C(CheckMark)N(checked,modifier):TribeeInfo.kt#vjrpu9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(checked) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1547522976, $dirty2, -1, "kntr.app.tribee.publish.ui.v2.internal.CheckMark (TribeeInfo.kt:173)");
            }
            if (checked) {
                $composer2.startReplaceGroup(78136648);
                ComposerKt.sourceInformation($composer2, "176@7027L18,180@7186L6,182@7297L6,175@6986L378");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_500($composer2, 6), (String) null, PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(modifier, Dp.constructor-impl(1)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(1)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(78518475);
                ComposerKt.sourceInformation($composer2, "190@7540L6,186@7386L199");
                BoxKt.Box(BorderKt.border-xT4_qwU(PaddingKt.padding-3ABfNKs(modifier, Dp.constructor-impl(1)), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeInfoKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckMark$lambda$0;
                    CheckMark$lambda$0 = TribeeInfoKt.CheckMark$lambda$0(checked, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckMark$lambda$0;
                }
            });
        }
    }
}