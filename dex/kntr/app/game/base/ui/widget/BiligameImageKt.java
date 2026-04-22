package kntr.app.game.base.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.LoopCount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.game.base.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.game.base.ui.generated.resources.Res;

/* compiled from: BiligameImage.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"BiligameImage", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "size", "Landroidx/compose/ui/unit/Dp;", "corner", "modifier", "Landroidx/compose/ui/Modifier;", "placeHolder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "BiligameImage-o3XDK20", "(Ljava/lang/String;FFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BiligameImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameImage_o3XDK20$lambda$3(String str, float f, float f2, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        m1121BiligameImageo3XDK20(str, f, f2, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameImage_o3XDK20$lambda$0(float f, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C33@1074L476:BiligameImage.kt#kw4tct");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-166239679, $changed, -1, "kntr.app.game.base.ui.widget.BiligameImage.<anonymous> (BiligameImage.kt:33)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(Modifier.Companion, f), ColorKt.Color(4293125607L), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1696645365, "C40@1268L47,39@1235L305:BiligameImage.kt#kw4tct");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_tv_placeholder(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, f), (Alignment) null, ContentScale.Companion.getInside(), 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, ColorKt.Color(4292467161L), 0, 2, (Object) null), $composer, Painter.$stable | 1597488, 40);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: BiligameImage-o3XDK20  reason: not valid java name */
    public static final void m1121BiligameImageo3XDK20(final String url, final float f, final float f2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function22;
        Modifier modifier3;
        Function2 placeHolder;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(url, "url");
        Composer $composer2 = $composer.startRestartGroup(1046331450);
        ComposerKt.sourceInformation($composer2, "C(BiligameImage)N(url,size:c#ui.unit.Dp,corner:c#ui.unit.Dp,modifier,placeHolder)32@1064L492,60@1909L17,49@1566L367:BiligameImage.kt#kw4tct");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(url) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(f2) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            function22 = function2;
        } else if (($changed & 24576) == 0) {
            function22 = function2;
            $dirty |= $composer2.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = function2;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            placeHolder = function22;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            final Function2 placeHolder2 = i3 != 0 ? (Function2) ComposableLambdaKt.rememberComposableLambda(-166239679, true, new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameImageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameImage_o3XDK20$lambda$0;
                    BiligameImage_o3XDK20$lambda$0 = BiligameImageKt.BiligameImage_o3XDK20$lambda$0(f, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameImage_o3XDK20$lambda$0;
                }
            }, $composer2, 54) : function22;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1046331450, $dirty, -1, "kntr.app.game.base.ui.widget.BiligameImage (BiligameImage.kt:48)");
            }
            ImageRequest $this$BiligameImage_o3XDK20_u24lambda_u241 = new ImageRequest(url);
            $this$BiligameImage_o3XDK20_u24lambda_u241.autoPlay(true);
            $this$BiligameImage_o3XDK20_u24lambda_u241.animateLoopCount-SW3asMM(LoopCount.Companion.getINFINITE--v08q-k());
            BiliImageKt.BiliImage($this$BiligameImage_o3XDK20_u24lambda_u241.build(), ClipKt.clip(SizeKt.size-3ABfNKs(modifier4, f), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f2)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, placeHolder2, ComposableLambdaKt.rememberComposableLambda(2115501865, true, new Function4() { // from class: kntr.app.game.base.ui.widget.BiligameImageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit BiligameImage_o3XDK20$lambda$2;
                    BiligameImage_o3XDK20$lambda$2 = BiligameImageKt.BiligameImage_o3XDK20$lambda$2(placeHolder2, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return BiligameImage_o3XDK20$lambda$2;
                }
            }, $composer2, 54), $composer2, (($dirty << 9) & 29360128) | 100663296, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            placeHolder = placeHolder2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function2 function23 = placeHolder;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameImageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameImage_o3XDK20$lambda$3;
                    BiligameImage_o3XDK20$lambda$3 = BiligameImageKt.BiligameImage_o3XDK20$lambda$3(url, f, f2, modifier5, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameImage_o3XDK20$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameImage_o3XDK20$lambda$2(Function2 $placeHolder, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)60@1911L13:BiligameImage.kt#kw4tct");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2115501865, $changed, -1, "kntr.app.game.base.ui.widget.BiligameImage.<anonymous> (BiligameImage.kt:60)");
        }
        $placeHolder.invoke($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}