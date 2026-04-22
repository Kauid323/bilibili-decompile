package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.ColorFilter;
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
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.brouter.uri.Uri;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kntr.common.compose.res.AnimatePainter;
import kntr.common.compose.res.CommonRes;
import kntr.common.compose.res.RefreshAnimatePainterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: IMStatus.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a/\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a!\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u00020\u0003*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"IMNotLogin", "", "modifier", "Landroidx/compose/ui/Modifier;", "routeHandler", "Lkotlin/Function2;", "Lcom/bilibili/lib/brouter/uri/Uri;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IMLoading", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMError", "showRefresh", "", "onRefresh", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "IMEmpty", "text", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "dayNightTint", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMStatusKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMEmpty$lambda$1(Modifier modifier, String str, int i2, int i3, Composer composer, int i4) {
        IMEmpty(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMError$lambda$1(Modifier modifier, boolean z, Function0 function0, int i2, int i3, Composer composer, int i4) {
        IMError(modifier, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMLoading$lambda$1(Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMLoading(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMNotLogin$lambda$1(Modifier modifier, Function2 function2, int i2, int i3, Composer composer, int i4) {
        IMNotLogin(modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0334, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMNotLogin(Modifier modifier, final Function2<? super Uri, ? super Continuation<? super Unit>, ? extends Object> function2, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(function2, "routeHandler");
        Composer $composer3 = $composer.startRestartGroup(-1940879463);
        ComposerKt.sourceInformation($composer3, "C(IMNotLogin)N(modifier,routeHandler)53@2050L1623:IMStatus.kt#uu6lp7");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if ($composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1940879463, $dirty, -1, "im.base.IMNotLogin (IMStatus.kt:52)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(48), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            Modifier modifier4 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1457258725, "C59@2293L55,60@2395L14,58@2264L195,65@2494L49,66@2575L6,67@2619L9,64@2469L175,71@2679L49,72@2760L6,73@2804L9,70@2654L174,76@2850L24,83@3109L6,85@3219L160,77@2883L784:IMStatus.kt#uu6lp7");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_not_login(CommonRes.INSTANCE.getDrawable()), $composer3, 0), (String) null, dayNightTint(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), $composer3, 6), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer3, Painter.$stable | 48, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_645(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), $composer3, 0, 0, 131066);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_644(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(6), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null), Dp.constructor-impl(96), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer3, 185584995, "CC(remember):IMStatus.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(scope) | $composer3.changedInstance(function2);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: im.base.IMStatusKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit IMNotLogin$lambda$0$0$0;
                    IMNotLogin$lambda$0$0$0 = IMStatusKt.IMNotLogin$lambda$0$0$0(scope, function2);
                    return IMNotLogin$lambda$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1945763355, "C93@3483L57,94@3576L6,95@3629L9,92@3454L203:IMStatus.kt#uu6lp7");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_290(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMStatusKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMNotLogin$lambda$1;
                    IMNotLogin$lambda$1 = IMStatusKt.IMNotLogin$lambda$1(modifier2, function2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMNotLogin$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMNotLogin$lambda$0$0$0(CoroutineScope $scope, Function2 $routeHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMStatusKt$IMNotLogin$1$1$1$1($routeHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void IMLoading(Modifier modifier, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-971481508);
        ComposerKt.sourceInformation($composer2, "C(IMLoading)N(modifier)103@3740L597:IMStatus.kt#uu6lp7");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            Modifier modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-971481508, $dirty, -1, "im.base.IMLoading (IMStatus.kt:102)");
            }
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(48), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -363109244, "C108@3968L31,109@4008L131,116@4174L57,117@4263L6,118@4307L9,115@4149L182:IMStatus.kt#uu6lp7");
            ImageKt.Image(RefreshAnimatePainterKt.rememberRefreshAnimatePainter(false, $composer2, 0, 1), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer2, AnimatePainter.$stable | 432, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_249(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131066);
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
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMStatusKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMLoading$lambda$1;
                    IMLoading$lambda$1 = IMStatusKt.IMLoading$lambda$1(modifier2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMLoading$lambda$1;
                }
            });
        }
    }

    public static final void IMError(Modifier modifier, boolean showRefresh, final Function0<Unit> function0, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        boolean showRefresh2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(function0, "onRefresh");
        Composer $composer3 = $composer.startRestartGroup(800182328);
        ComposerKt.sourceInformation($composer3, "C(IMError)N(modifier,showRefresh,onRefresh)130@4525L1360:IMStatus.kt#uu6lp7");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            $dirty |= 48;
            z = showRefresh;
        } else if (($changed & 48) == 0) {
            z = showRefresh;
            $dirty |= $composer3.changed(z) ? 32 : 16;
        } else {
            z = showRefresh;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            showRefresh2 = z;
        } else {
            if (i3 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 == 0) {
                showRefresh2 = z;
            } else {
                showRefresh2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(800182328, $dirty2, -1, "im.base.IMError (IMStatus.kt:129)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(48), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1425406579, "C136@4768L51,137@4866L14,135@4739L191,142@4965L56,143@5053L6,144@5097L9,141@4940L181:IMStatus.kt#uu6lp7");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_error(CommonRes.INSTANCE.getDrawable()), $composer3, 0), (String) null, dayNightTint(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), $composer3, 6), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer3, Painter.$stable | 48, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_20(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
            if (!showRefresh2) {
                $composer$iv = $composer3;
                $composer$iv2 = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1430144000);
                $composer2.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1425013531);
                ComposerKt.sourceInformation($composer3, "154@5412L6,148@5162L707");
                $composer$iv2 = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer$iv = $composer3;
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(6), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null), Dp.constructor-impl(96), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15))), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 601094280, "C160@5670L56,161@5766L6,162@5823L9,159@5637L218:IMStatus.kt#uu6lp7");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_94(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = showRefresh2;
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMStatusKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMError$lambda$1;
                    IMError$lambda$1 = IMStatusKt.IMError$lambda$1(modifier4, z2, function0, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMError$lambda$1;
                }
            });
        }
    }

    public static final void IMEmpty(Modifier modifier, String text, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        final String text2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(-1341514432);
        ComposerKt.sourceInformation($composer2, "C(IMEmpty)N(modifier,text)174@6034L550:IMStatus.kt#uu6lp7");
        int $dirty = $changed;
        int i4 = i2 & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i2 & 2) == 0) {
                text2 = text;
                if ($composer2.changed(text2)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                text2 = text;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            text2 = text;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "172@5968L56");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    $dirty &= -113;
                    text2 = StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_66(Res.string.INSTANCE), $composer2, 0);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1341514432, $dirty, -1, "im.base.IMEmpty (IMStatus.kt:173)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(48), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 570218307, "C180@6277L51,181@6375L14,179@6248L191,187@6510L6,188@6554L9,185@6449L129:IMStatus.kt#uu6lp7");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_empty(CommonRes.INSTANCE.getDrawable()), $composer2, 0), (String) null, dayNightTint(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), $composer2, 6), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer2, Painter.$stable | 48, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            TextKt.Text-Nvy7gAk(text2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, ($dirty >> 3) & 14, 0, 131066);
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
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMStatusKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMEmpty$lambda$1;
                    IMEmpty$lambda$1 = IMStatusKt.IMEmpty$lambda$1(modifier2, text2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMEmpty$lambda$1;
                }
            });
        }
    }

    public static final Modifier dayNightTint(Modifier $this$dayNightTint, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$dayNightTint, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -824241828, "C(dayNightTint):IMStatus.kt#uu6lp7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-824241828, $changed, -1, "im.base.dayNightTint (IMStatus.kt:195)");
        }
        Modifier composed$default = ComposedModifierKt.composed$default($this$dayNightTint, (Function1) null, new Function3() { // from class: im.base.IMStatusKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier dayNightTint$lambda$0;
                dayNightTint$lambda$0 = IMStatusKt.dayNightTint$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return dayNightTint$lambda$0;
            }
        }, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return composed$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier dayNightTint$lambda$0(Modifier $this$composed, Composer $composer, int $changed) {
        Modifier alpha;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(1944997668);
        ComposerKt.sourceInformation($composer, "C196@6677L13:IMStatus.kt#uu6lp7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1944997668, $changed, -1, "im.base.dayNightTint.<anonymous> (IMStatus.kt:196)");
        }
        if (BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Day) {
            alpha = $this$composed;
        } else {
            alpha = AlphaKt.alpha($this$composed, 0.5f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return alpha;
    }
}