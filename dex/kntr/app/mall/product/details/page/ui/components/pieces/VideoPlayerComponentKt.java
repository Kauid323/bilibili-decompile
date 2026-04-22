package kntr.app.mall.product.details.page.ui.components.pieces;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import com.bilibili.framework.simpleplayer.SimplePlayerState;
import kntr.app.mall.product.details.page.ui.components.VideoSeekBarKt;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: VideoPlayerComponent.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¸\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a7\u0010\u001d\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0002\u0010\u001f\u001ay\u0010 \u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"VideoPlayerComponent", "", "isInPreview", "", "muted", "pause", "pauseByOther", "updatePause", "Lkotlin/Function1;", "togglePause", "Lkotlin/Function0;", "toggleMuted", "videoPlayer", "Lcom/bilibili/framework/simpleplayer/SimplePlayer;", "movableVideoPlayerView", "Landroidx/compose/runtime/Composable;", "scale", "", "bottomVerticalGradientHeight", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "bottomVerticalGradientBrush", "Landroidx/compose/ui/graphics/Brush;", "progressBarColor", "", "progressBarIcon", "VideoPlayerComponent-Vmd5ePE", "(ZZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/bilibili/framework/simpleplayer/SimplePlayer;Lkotlin/jvm/functions/Function2;FFLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Brush;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;III)V", "NonPreviewProgressComponent", "Landroidx/compose/foundation/layout/BoxScope;", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/bilibili/framework/simpleplayer/SimplePlayer;FLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "PreviewVideoActionComponent", "(Lcom/bilibili/framework/simpleplayer/SimplePlayer;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "progress"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoPlayerComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NonPreviewProgressComponent$lambda$4(BoxScope boxScope, SimplePlayer simplePlayer, float f, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        NonPreviewProgressComponent(boxScope, simplePlayer, f, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewVideoActionComponent$lambda$9(SimplePlayer simplePlayer, boolean z, boolean z2, boolean z3, Function1 function1, Function0 function0, float f, Modifier modifier, String str, String str2, int i, int i2, Composer composer, int i3) {
        PreviewVideoActionComponent(simplePlayer, z, z2, z3, function1, function0, f, modifier, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayerComponent_Vmd5ePE$lambda$0(boolean z, boolean z2, boolean z3, boolean z4, Function1 function1, Function0 function0, Function0 function02, SimplePlayer simplePlayer, Function2 function2, float f, float f2, Modifier modifier, Brush brush, String str, String str2, int i, int i2, int i3, Composer composer, int i4) {
        m563VideoPlayerComponentVmd5ePE(z, z2, z3, z4, function1, function0, function02, simplePlayer, function2, f, f2, modifier, brush, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayerComponent_Vmd5ePE$lambda$2(boolean z, boolean z2, boolean z3, boolean z4, Function1 function1, Function0 function0, Function0 function02, SimplePlayer simplePlayer, Function2 function2, float f, float f2, Modifier modifier, Brush brush, String str, String str2, int i, int i2, int i3, Composer composer, int i4) {
        m563VideoPlayerComponentVmd5ePE(z, z2, z3, z4, function1, function0, function02, simplePlayer, function2, f, f2, modifier, brush, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* renamed from: VideoPlayerComponent-Vmd5ePE  reason: not valid java name */
    public static final void m563VideoPlayerComponentVmd5ePE(final boolean isInPreview, final boolean muted, final boolean pause, final boolean pauseByOther, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final SimplePlayer videoPlayer, final Function2<? super Composer, ? super Integer, Unit> function2, final float scale, final float f, Modifier modifier, Brush bottomVerticalGradientBrush, String progressBarColor, String progressBarIcon, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Brush bottomVerticalGradientBrush2;
        String progressBarColor2;
        String progressBarIcon2;
        Modifier modifier$iv$iv;
        Composer $composer$iv$iv;
        MeasurePolicy measurePolicy$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer3;
        Composer $composer$iv$iv2;
        Composer $composer$iv$iv$iv;
        boolean propagateMinConstraints$iv;
        Composer $composer$iv$iv$iv2;
        float f2;
        Function0 factory$iv$iv$iv;
        Painter painter;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(function1, "updatePause");
        Intrinsics.checkNotNullParameter(function0, "togglePause");
        Intrinsics.checkNotNullParameter(function02, "toggleMuted");
        Intrinsics.checkNotNullParameter(function2, "movableVideoPlayerView");
        Composer $composer4 = $composer.startRestartGroup(1680109503);
        ComposerKt.sourceInformation($composer4, "C(VideoPlayerComponent)N(isInPreview,muted,pause,pauseByOther,updatePause,togglePause,toggleMuted,videoPlayer,movableVideoPlayerView,scale,bottomVerticalGradientHeight:c#ui.unit.Dp,modifier,bottomVerticalGradientBrush,progressBarColor,progressBarIcon)81@2993L3684:VideoPlayerComponent.kt#v057zd");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(isInPreview) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(muted) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(pause) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(pauseByOther) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer4.changed(videoPlayer) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ((805306368 & $changed) == 0) {
            $dirty |= $composer4.changed(scale) ? 536870912 : 268435456;
        }
        int $dirty2 = $dirty;
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer4.changed(f) ? 4 : 2;
        }
        int i2 = i & 2048;
        if (i2 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer4.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4096;
        if (i3 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer4.changed(bottomVerticalGradientBrush) ? 256 : 128;
        }
        int i4 = i & 8192;
        if (i4 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer4.changed(progressBarColor) ? 2048 : 1024;
        }
        int i5 = i & 16384;
        if (i5 != 0) {
            $dirty1 |= 24576;
        } else if (($changed1 & 24576) == 0) {
            $dirty1 |= $composer4.changed(progressBarIcon) ? 16384 : 8192;
        }
        if ($composer4.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty1 & 9363) == 9362) ? false : true, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            bottomVerticalGradientBrush2 = i3 != 0 ? Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0.0f, 0.0f, 0, 14, (Object) null) : bottomVerticalGradientBrush;
            progressBarColor2 = i4 != 0 ? null : progressBarColor;
            progressBarIcon2 = i5 != 0 ? null : progressBarIcon;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1680109503, $dirty2, $dirty1, "kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponent (VideoPlayerComponent.kt:70)");
            }
            if (videoPlayer == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final Brush brush = bottomVerticalGradientBrush2;
                    final String str = progressBarColor2;
                    final String str2 = progressBarIcon2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj, Object obj2) {
                            Unit VideoPlayerComponent_Vmd5ePE$lambda$0;
                            VideoPlayerComponent_Vmd5ePE$lambda$0 = VideoPlayerComponentKt.VideoPlayerComponent_Vmd5ePE$lambda$0(isInPreview, muted, pause, pauseByOther, function1, function0, function02, videoPlayer, function2, scale, f, modifier4, brush, str, str2, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                            return VideoPlayerComponent_Vmd5ePE$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty12 = $dirty1;
            $composer2 = $composer4;
            Modifier modifier5 = modifier3;
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv3);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$VideoPlayerComponent_Vmd5ePE_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 818906758, "C87@3127L24:VideoPlayerComponent.kt#v057zd");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 24) & 14));
            if (f > 0.0f) {
                $composer2.startReplaceGroup(818886173);
                ComposerKt.sourceInformation($composer2, "90@3219L360");
                modifier$iv$iv = modifier$iv;
                $composer$iv$iv = $composer2;
                measurePolicy$iv$iv = measurePolicy$iv;
                BoxKt.Box(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default($this$VideoPlayerComponent_Vmd5ePE_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), f), bottomVerticalGradientBrush2, (Shape) null, 0.0f, 6, (Object) null), $composer2, 0);
            } else {
                modifier$iv$iv = modifier$iv;
                $composer$iv$iv = $composer2;
                measurePolicy$iv$iv = measurePolicy$iv;
                $composer2.startReplaceGroup(815693917);
            }
            $composer2.endReplaceGroup();
            if (isInPreview) {
                $composer$iv = $composer2;
                modifier2 = modifier5;
                $composer$iv2 = $composer2;
                $composer3 = $composer2;
                $composer3.startReplaceGroup(821905728);
                ComposerKt.sourceInformation($composer3, "167@6248L413");
                $composer$iv$iv2 = $composer$iv$iv;
                $composer$iv$iv$iv = $composer2;
                PreviewVideoActionComponent(videoPlayer, pause, pauseByOther, muted, function1, function02, scale, null, progressBarColor2, progressBarIcon2, $composer3, (($dirty2 >> 21) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 << 6) & 7168) | ($dirty2 & 57344) | (($dirty2 >> 3) & 458752) | (($dirty2 >> 9) & 3670016) | (($dirty12 << 15) & 234881024) | (($dirty12 << 15) & 1879048192), 128);
                $composer3.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(819363914);
                ComposerKt.sourceInformation($composer2, "143@5427L69,126@4548L1487,161@6049L169");
                if (pause) {
                    $composer2.startReplaceGroup(819334836);
                    ComposerKt.sourceInformation($composer2, "111@4025L77,104@3660L841");
                    $composer$iv$iv$iv2 = $composer2;
                    f2 = scale;
                    Modifier modifier6 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs($this$VideoPlayerComponent_Vmd5ePE_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenter()), ProvideUiScaleKt.dpScaled(50, f2)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(50, f2))), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, -2051768366, "CC(remember):VideoPlayerComponent.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 458752) == 131072;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit VideoPlayerComponent_Vmd5ePE$lambda$1$0$0;
                                VideoPlayerComponent_Vmd5ePE$lambda$1$0$0 = VideoPlayerComponentKt.VideoPlayerComponent_Vmd5ePE$lambda$1$0$0(function0);
                                return VideoPlayerComponent_Vmd5ePE$lambda$1$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv2 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                    $composer$iv = $composer2;
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    propagateMinConstraints$iv = false;
                    modifier2 = modifier5;
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
                    $composer$iv2 = $composer2;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i8 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1640333169, "C118@4282L13,116@4201L282:VideoPlayerComponent.kt#v057zd");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getPlay_fill_300($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, f2)), Color.Companion.getWhite-0d7_KjU(), $composer2, Painter.$stable | 3120, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    $composer$iv = $composer2;
                    propagateMinConstraints$iv = false;
                    $composer$iv$iv$iv2 = $composer2;
                    modifier2 = modifier5;
                    $composer$iv2 = $composer2;
                    f2 = scale;
                    $composer2.startReplaceGroup(815693917);
                }
                $composer2.endReplaceGroup();
                Modifier then = $this$VideoPlayerComponent_Vmd5ePE_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getBottomEnd()).then(isInPreview ? BackgroundKt.background-bw27NRU(OffsetKt.absoluteOffset-VpY3zN4(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(30, f2)), ProvideUiScaleKt.dpScaled(-16, f2), ProvideUiScaleKt.dpScaled(-16, f2)), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()) : OffsetKt.absoluteOffset-VpY3zN4(Modifier.Companion, ProvideUiScaleKt.dpScaled(-12, f2), ProvideUiScaleKt.dpScaled(-36, f2)));
                ComposerKt.sourceInformationMarkerStart($composer2, -2051723510, "CC(remember):VideoPlayerComponent.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 3670016) == 1048576;
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit VideoPlayerComponent_Vmd5ePE$lambda$1$2$0;
                            VideoPlayerComponent_Vmd5ePE$lambda$1$2$0 = VideoPlayerComponentKt.VideoPlayerComponent_Vmd5ePE$lambda$1$2$0(function02);
                            return VideoPlayerComponent_Vmd5ePE$lambda$1$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv5;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv5;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i10 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1954856336, "C148@5583L438:VideoPlayerComponent.kt#v057zd");
                if (muted) {
                    $composer2.startReplaceGroup(1954916134);
                    ComposerKt.sourceInformation($composer2, "151@5697L26");
                    Painter speaker_sound_off_line_500 = BiliIconfont.INSTANCE.getSpeaker_sound_off_line_500($composer2, 6);
                    $composer2.endReplaceGroup();
                    painter = speaker_sound_off_line_500;
                } else {
                    $composer2.startReplaceGroup(1955016295);
                    ComposerKt.sourceInformation($composer2, "153@5798L25");
                    Painter speaker_sound_on_line_500 = BiliIconfont.INSTANCE.getSpeaker_sound_on_line_500($composer2, 6);
                    $composer2.endReplaceGroup();
                    painter = speaker_sound_on_line_500;
                }
                IconKt.Icon-ww6aTOc(painter, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, f2)), Color.Companion.getWhite-0d7_KjU(), $composer2, Painter.$stable | 3120, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer3 = $composer2;
                NonPreviewProgressComponent($this$VideoPlayerComponent_Vmd5ePE_u24lambda_u241, videoPlayer, scale, null, progressBarColor2, $composer3, ($changed2 & 14) | (($dirty2 >> 18) & 112) | (($dirty2 >> 21) & 896) | (57344 & ($dirty12 << 3)), 4);
                $composer3.endReplaceGroup();
                $composer$iv$iv2 = $composer$iv$iv;
                $composer$iv$iv$iv = $composer$iv$iv$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            bottomVerticalGradientBrush2 = bottomVerticalGradientBrush;
            progressBarColor2 = progressBarColor;
            progressBarIcon2 = progressBarIcon;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier2;
            final Brush brush2 = bottomVerticalGradientBrush2;
            final String str3 = progressBarColor2;
            final String str4 = progressBarIcon2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoPlayerComponent_Vmd5ePE$lambda$2;
                    VideoPlayerComponent_Vmd5ePE$lambda$2 = VideoPlayerComponentKt.VideoPlayerComponent_Vmd5ePE$lambda$2(isInPreview, muted, pause, pauseByOther, function1, function0, function02, videoPlayer, function2, scale, f, modifier7, brush2, str3, str4, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoPlayerComponent_Vmd5ePE$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayerComponent_Vmd5ePE$lambda$1$0$0(Function0 $togglePause) {
        $togglePause.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayerComponent_Vmd5ePE$lambda$1$2$0(Function0 $toggleMuted) {
        $toggleMuted.invoke();
        return Unit.INSTANCE;
    }

    public static final void NonPreviewProgressComponent(final BoxScope $this$NonPreviewProgressComponent, final SimplePlayer videoPlayer, final float scale, Modifier modifier, String progressBarColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Modifier modifier3;
        String progressBarColor2;
        Modifier modifier4;
        String progressBarColor3;
        long activeColor;
        String progressBarColor4;
        Intrinsics.checkNotNullParameter($this$NonPreviewProgressComponent, "<this>");
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Composer $composer2 = $composer.startRestartGroup(-227729305);
        ComposerKt.sourceInformation($composer2, "C(NonPreviewProgressComponent)N(videoPlayer,scale,modifier,progressBarColor)190@6901L36,197@7122L369,208@7543L821,208@7496L868:VideoPlayerComponent.kt#v057zd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$NonPreviewProgressComponent) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(videoPlayer) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(scale) ? 256 : 128;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 24576;
            str = progressBarColor;
        } else if (($changed & 24576) == 0) {
            str = progressBarColor;
            $dirty |= $composer2.changed(str) ? 16384 : 8192;
        } else {
            str = progressBarColor;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            progressBarColor2 = str;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                progressBarColor3 = str;
            } else {
                progressBarColor3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-227729305, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.pieces.NonPreviewProgressComponent (VideoPlayerComponent.kt:188)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 195476395, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableFloatState progress$delegate = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String str2 = progressBarColor3;
            if (!(str2 == null || str2.length() == 0)) {
                $composer2.startReplaceGroup(1764906630);
                $composer2.endReplaceGroup();
                activeColor = ComposeColorParserKt.parseColor(progressBarColor3);
            } else {
                $composer2.startReplaceGroup(1764965096);
                ComposerKt.sourceInformation($composer2, "195@7090L6");
                long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer2.endReplaceGroup();
                activeColor = j;
            }
            BoxKt.Box($this$NonPreviewProgressComponent.align(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth(SizeKt.wrapContentSize$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Color.Companion.getGray-0d7_KjU(), (Shape) null, 2, (Object) null), Alignment.Companion.getCenterStart(), false, 2, (Object) null), NonPreviewProgressComponent$lambda$1(progress$delegate)), ProvideUiScaleKt.dpScaled(2, scale)), activeColor, (Shape) null, 2, (Object) null), Alignment.Companion.getBottomCenter()), $composer2, 0);
            SimplePlayerState state = videoPlayer.getState();
            ComposerKt.sourceInformationMarkerStart($composer2, 195497724, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                modifier3 = modifier4;
                progressBarColor4 = progressBarColor3;
                Object value$iv2 = (Function2) new VideoPlayerComponentKt$NonPreviewProgressComponent$1$1(videoPlayer, progress$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                modifier3 = modifier4;
                progressBarColor4 = progressBarColor3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(videoPlayer, state, (Function2) it$iv2, $composer2, ($dirty2 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            progressBarColor2 = progressBarColor4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str3 = progressBarColor2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit NonPreviewProgressComponent$lambda$4;
                    NonPreviewProgressComponent$lambda$4 = VideoPlayerComponentKt.NonPreviewProgressComponent$lambda$4($this$NonPreviewProgressComponent, videoPlayer, scale, modifier5, str3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NonPreviewProgressComponent$lambda$4;
                }
            });
        }
    }

    private static final float NonPreviewProgressComponent$lambda$1(MutableFloatState $progress$delegate) {
        FloatState $this$getValue$iv = (FloatState) $progress$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x01a6, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x028a, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02d4, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0339, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L126;
     */
    /* JADX WARN: Removed duplicated region for block: B:261:0x07dc  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x089d  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x08a9  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x08af  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0923  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x093b  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x09ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PreviewVideoActionComponent(final SimplePlayer videoPlayer, final boolean pause, final boolean pauseByOther, final boolean muted, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, final float scale, Modifier modifier, String progressBarColor, String progressBarIcon, Composer $composer, final int $changed, final int i) {
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        String progressBarColor2;
        String progressBarIcon2;
        Function0 factory$iv$iv$iv;
        BoxScope $this$PreviewVideoActionComponent_u24lambda_u248;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        String str;
        Function0 factory$iv$iv$iv2;
        String str2;
        String str3;
        Painter painter;
        boolean invalid$iv;
        Object it$iv;
        Function0 factory$iv$iv$iv3;
        Painter painter2;
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Intrinsics.checkNotNullParameter(function1, "updatePause");
        Intrinsics.checkNotNullParameter(function0, "toggleMuted");
        Composer $composer3 = $composer.startRestartGroup(-876720143);
        ComposerKt.sourceInformation($composer3, "C(PreviewVideoActionComponent)N(videoPlayer,pause,pauseByOther,muted,updatePause,toggleMuted,scale,modifier,progressBarColor,progressBarIcon)247@8744L47,248@8819L47,249@8883L24,251@8972L49,253@9074L919,253@9027L966,279@10037L171,279@9998L210,293@10411L423,287@10213L5347:VideoPlayerComponent.kt#v057zd");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(videoPlayer) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(pause) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(pauseByOther) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(muted) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changed(scale) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty2 |= 12582912;
        } else if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 8388608 : 4194304;
        }
        int i3 = i & 256;
        if (i3 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(progressBarColor) ? 67108864 : 33554432;
        }
        int i4 = i & 512;
        if (i4 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changed(progressBarIcon) ? 536870912 : 268435456;
        }
        if ($composer3.shouldExecute(($dirty2 & 306783379) != 306783378, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            String progressBarColor3 = i3 != 0 ? null : progressBarColor;
            String progressBarIcon3 = i4 != 0 ? null : progressBarIcon;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876720143, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.pieces.PreviewVideoActionComponent (VideoPlayerComponent.kt:246)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -714456000, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            final MutableState showCenterAction = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -714453600, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 14) == 4;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer3.updateRememberedValue(value$iv2);
            it$iv3 = value$iv2;
            final MutableState isChangingSlider = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            progressBarColor2 = progressBarColor3;
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            progressBarIcon2 = progressBarIcon3;
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final boolean isPlaying = (pause || pauseByOther) ? false : true;
            ComposerKt.sourceInformationMarkerStart($composer3, -714448702, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv4 = ($dirty2 & 14) == 4;
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            final MutableFloatState progress$delegate = (MutableFloatState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SimplePlayerState state = videoPlayer.getState();
            ComposerKt.sourceInformationMarkerStart($composer3, -714444568, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv5 = (($dirty2 & 14) == 4) | $composer3.changed(isChangingSlider) | $composer3.changed(progress$delegate);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv4 = (Function2) new VideoPlayerComponentKt$PreviewVideoActionComponent$1$1(videoPlayer, isChangingSlider, progress$delegate, null);
            $composer3.updateRememberedValue(value$iv4);
            it$iv5 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(videoPlayer, state, (Function2) it$iv5, $composer3, $dirty2 & 14);
            Object value = showCenterAction.getValue();
            ComposerKt.sourceInformationMarkerStart($composer3, -714414500, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv6 = $composer3.changed(showCenterAction) | $composer3.changedInstance(scope);
            Object it$iv6 = $composer3.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv5 = (Function2) new VideoPlayerComponentKt$PreviewVideoActionComponent$2$1(showCenterAction, scope, null);
            $composer3.updateRememberedValue(value$iv5);
            it$iv6 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(value, (Function2) it$iv6, $composer3, 0);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
            boolean z = videoPlayer.getState() == SimplePlayerState.READY;
            ComposerKt.sourceInformationMarkerStart($composer3, -714402280, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv7 = $composer3.changed(showCenterAction) | ((57344 & $dirty2) == 16384) | $composer3.changed(isPlaying);
            Object it$iv7 = $composer3.rememberedValue();
            if (invalid$iv7) {
                modifier2 = modifier3;
            } else {
                modifier2 = modifier3;
            }
            Object value$iv6 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit PreviewVideoActionComponent$lambda$7$0;
                    PreviewVideoActionComponent$lambda$7$0 = VideoPlayerComponentKt.PreviewVideoActionComponent$lambda$7$0(showCenterAction, function1, isPlaying);
                    return PreviewVideoActionComponent$lambda$7$0;
                }
            };
            $composer3.updateRememberedValue(value$iv6);
            it$iv7 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, z, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv7, 14, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $dirty = $dirty2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((48 >> 6) & 112) | 6;
            BoxScope $this$PreviewVideoActionComponent_u24lambda_u2482 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1263643099, "C333@11864L91,337@11984L1909,331@11794L3041,406@15059L61,401@14845L709:VideoPlayerComponent.kt#v057zd");
            if (!isPlaying || ((Boolean) showCenterAction.getValue()).booleanValue()) {
                $composer3.startReplaceGroup(1263566590);
                ComposerKt.sourceInformation($composer3, "308@10953L821");
                $this$PreviewVideoActionComponent_u24lambda_u248 = $this$PreviewVideoActionComponent_u24lambda_u2482;
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs($this$PreviewVideoActionComponent_u24lambda_u248.align(Modifier.Companion, Alignment.Companion.getCenter()), ProvideUiScaleKt.dpScaled(50, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(50, scale))), TopContainerKt.m587withOverlayAlphaDxMtmZc(Color.Companion.getBlack-0d7_KjU(), 0.5f), (Shape) null, 2, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                $composer$iv$iv$iv = $composer3;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer$iv = $composer3;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -303779672, "C317@11341L419:VideoPlayerComponent.kt#v057zd");
                if (isPlaying) {
                    $composer3.startReplaceGroup(-303627401);
                    ComposerKt.sourceInformation($composer3, "322@11548L14");
                    Painter pause_fill_300 = BiliIconfont.INSTANCE.getPause_fill_300($composer3, 6);
                    $composer3.endReplaceGroup();
                    painter = pause_fill_300;
                } else {
                    $composer3.startReplaceGroup(-303714728);
                    ComposerKt.sourceInformation($composer3, "320@11460L13");
                    Painter play_fill_300 = BiliIconfont.INSTANCE.getPlay_fill_300($composer3, 6);
                    $composer3.endReplaceGroup();
                    painter = play_fill_300;
                }
                IconKt.Icon-ww6aTOc(painter, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(24, scale)), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1252687915);
                $composer3.endReplaceGroup();
                $composer$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $this$PreviewVideoActionComponent_u24lambda_u248 = $this$PreviewVideoActionComponent_u24lambda_u2482;
            }
            float PreviewVideoActionComponent$lambda$3 = PreviewVideoActionComponent$lambda$3(progress$delegate);
            String str4 = progressBarIcon2;
            String str5 = !(str4 == null || str4.length() == 0) ? progressBarIcon2 : "http://i0.hdslb.com/bfs/kfptfe/floor/6e5c16a93b0496731572e9f48f48dcdfbcca98ac.png";
            Modifier modifier4 = OffsetKt.offset-VpY3zN4$default($this$PreviewVideoActionComponent_u24lambda_u248.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, ProvideUiScaleKt.dpScaled(-12, scale), 1, (Object) null);
            String str6 = progressBarColor2;
            long parseColor = !(str6 == null || str6.length() == 0) ? ComposeColorParserKt.parseColor(progressBarColor2) : ColorKt.Color(4294668953L);
            long j = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            float dpScaled = ProvideUiScaleKt.dpScaled(2, scale);
            String str7 = progressBarIcon2;
            float dpScaled2 = ProvideUiScaleKt.dpScaled(!(str7 == null || str7.length() == 0) ? 20 : 12, scale);
            boolean z2 = videoPlayer.getState() == SimplePlayerState.READY;
            ComposerKt.sourceInformationMarkerStart($composer3, -513400270, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            boolean invalid$iv8 = $composer3.changed(isChangingSlider) | $composer3.changed(progress$delegate);
            Object it$iv8 = $composer3.rememberedValue();
            if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit PreviewVideoActionComponent$lambda$8$1$0;
                        PreviewVideoActionComponent$lambda$8$1$0 = VideoPlayerComponentKt.PreviewVideoActionComponent$lambda$8$1$0(isChangingSlider, progress$delegate, ((Float) obj).floatValue());
                        return PreviewVideoActionComponent$lambda$8$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv7);
                it$iv8 = value$iv7;
            }
            Function1 function12 = (Function1) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -513394612, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            $composer2 = $composer3;
            boolean invalid$iv9 = $composer2.changedInstance(scope) | (($dirty & 14) == 4) | $composer2.changed(isChangingSlider) | $composer2.changed(progress$delegate);
            Object it$iv9 = $composer3.rememberedValue();
            if (!invalid$iv9 && it$iv9 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                VideoSeekBarKt.m543VideoSeekBarBE8BMqc(PreviewVideoActionComponent$lambda$3, function12, (Function0) it$iv9, str5, scale, dpScaled, dpScaled2, modifier4, parseColor, j, z2, $composer3, (($dirty >> 6) & 57344) | 805306368, 0, 0);
                Modifier modifier5 = OffsetKt.offset-VpY3zN4($this$PreviewVideoActionComponent_u24lambda_u248.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ProvideUiScaleKt.dpScaled(-16, scale), ProvideUiScaleKt.dpScaled(-36, scale));
                ComposerKt.sourceInformationMarkerStart($composer3, -513298060, "CC(remember):VideoPlayerComponent.kt#9igjgp");
                invalid$iv = ($dirty & 458752) != 131072;
                it$iv = $composer3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit PreviewVideoActionComponent$lambda$8$3$0;
                            PreviewVideoActionComponent$lambda$8$3$0 = VideoPlayerComponentKt.PreviewVideoActionComponent$lambda$8$3$0(function0);
                            return PreviewVideoActionComponent$lambda$8$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                    it$iv = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str3);
                Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str2);
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.useNode();
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv3);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -339611432, "C410@15146L398:VideoPlayerComponent.kt#v057zd");
                if (muted) {
                    $composer3.startReplaceGroup(-339466353);
                    ComposerKt.sourceInformation($composer3, "415@15341L25");
                    Painter speaker_sound_on_line_500 = BiliIconfont.INSTANCE.getSpeaker_sound_on_line_500($composer3, 6);
                    $composer3.endReplaceGroup();
                    painter2 = speaker_sound_on_line_500;
                } else {
                    $composer3.startReplaceGroup(-339558578);
                    ComposerKt.sourceInformation($composer3, "413@15248L26");
                    Painter speaker_sound_off_line_500 = BiliIconfont.INSTANCE.getSpeaker_sound_off_line_500($composer3, 6);
                    $composer3.endReplaceGroup();
                    painter2 = speaker_sound_off_line_500;
                }
                IconKt.Icon-ww6aTOc(painter2, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv9 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit PreviewVideoActionComponent$lambda$8$2$0;
                    PreviewVideoActionComponent$lambda$8$2$0 = VideoPlayerComponentKt.PreviewVideoActionComponent$lambda$8$2$0(scope, videoPlayer, isChangingSlider, progress$delegate);
                    return PreviewVideoActionComponent$lambda$8$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv9);
            it$iv9 = value$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            VideoSeekBarKt.m543VideoSeekBarBE8BMqc(PreviewVideoActionComponent$lambda$3, function12, (Function0) it$iv9, str5, scale, dpScaled, dpScaled2, modifier4, parseColor, j, z2, $composer3, (($dirty >> 6) & 57344) | 805306368, 0, 0);
            Modifier modifier52 = OffsetKt.offset-VpY3zN4($this$PreviewVideoActionComponent_u24lambda_u248.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), ProvideUiScaleKt.dpScaled(-16, scale), ProvideUiScaleKt.dpScaled(-36, scale));
            ComposerKt.sourceInformationMarkerStart($composer3, -513298060, "CC(remember):VideoPlayerComponent.kt#9igjgp");
            invalid$iv = ($dirty & 458752) != 131072;
            it$iv = $composer3.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv82 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit PreviewVideoActionComponent$lambda$8$3$0;
                    PreviewVideoActionComponent$lambda$8$3$0 = VideoPlayerComponentKt.PreviewVideoActionComponent$lambda$8$3$0(function0);
                    return PreviewVideoActionComponent$lambda$8$3$0;
                }
            };
            $composer3.updateRememberedValue(value$iv82);
            it$iv = value$iv82;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv32 = ClickableKt.clickable-oSLSa3U$default(modifier52, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str3);
            Alignment contentAlignment$iv32 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
            int $changed$iv$iv32 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str);
            int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv32 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer3, modifier$iv32);
            Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str2);
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
            int i92 = ($changed$iv$iv$iv32 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
            int i102 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -339611432, "C410@15146L398:VideoPlayerComponent.kt#v057zd");
            if (muted) {
            }
            IconKt.Icon-ww6aTOc(painter2, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(20, scale)), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            progressBarColor2 = progressBarColor;
            progressBarIcon2 = progressBarIcon;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final String str8 = progressBarColor2;
            final String str9 = progressBarIcon2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.VideoPlayerComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewVideoActionComponent$lambda$9;
                    PreviewVideoActionComponent$lambda$9 = VideoPlayerComponentKt.PreviewVideoActionComponent$lambda$9(videoPlayer, pause, pauseByOther, muted, function1, function0, scale, modifier6, str8, str9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewVideoActionComponent$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float PreviewVideoActionComponent$lambda$3(MutableFloatState $progress$delegate) {
        FloatState $this$getValue$iv = (FloatState) $progress$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewVideoActionComponent$lambda$7$0(MutableState $showCenterAction, Function1 $updatePause, boolean $isPlaying) {
        if (((Boolean) $showCenterAction.getValue()).booleanValue()) {
            $showCenterAction.setValue(false);
            $updatePause.invoke(true);
        } else if (!$isPlaying) {
            $updatePause.invoke(false);
        } else {
            $showCenterAction.setValue(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewVideoActionComponent$lambda$8$1$0(MutableState $isChangingSlider, MutableFloatState $progress$delegate, float it) {
        $isChangingSlider.setValue(true);
        $progress$delegate.setFloatValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewVideoActionComponent$lambda$8$2$0(CoroutineScope $scope, SimplePlayer $videoPlayer, MutableState $isChangingSlider, MutableFloatState $progress$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new VideoPlayerComponentKt$PreviewVideoActionComponent$4$3$1$1($videoPlayer, $isChangingSlider, $progress$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewVideoActionComponent$lambda$8$3$0(Function0 $toggleMuted) {
        $toggleMuted.invoke();
        return Unit.INSTANCE;
    }
}