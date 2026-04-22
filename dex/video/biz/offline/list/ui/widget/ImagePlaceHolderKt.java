package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.bilibili.compose.theme.BiliTheme;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.video.biz.offline.list.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.video.biz.offline.list.ui.generated.resources.Res;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ImagePlaceHolder.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\n¨\u0006\u000b"}, d2 = {"ImageWithPlaceHolder", "", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "Lkntr/base/imageloader/ImmutableImageRequest;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/base/imageloader/ImmutableImageRequest;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ImagePlaceHolder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "fileToUri", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ImagePlaceHolderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePlaceHolder$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        ImagePlaceHolder(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageWithPlaceHolder$lambda$0(ImmutableImageRequest immutableImageRequest, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ImageWithPlaceHolder(immutableImageRequest, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ImageWithPlaceHolder(final ImmutableImageRequest request, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(request, WAuthErrorMsg.ERROR_MESSAGE_REQUEST);
        Composer $composer2 = $composer.startRestartGroup(443035710);
        ComposerKt.sourceInformation($composer2, "C(ImageWithPlaceHolder)N(request,modifier)24@955L215:ImagePlaceHolder.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(request) ? 4 : 2;
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
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(443035710, $dirty2, -1, "video.biz.offline.list.ui.widget.ImageWithPlaceHolder (ImagePlaceHolder.kt:23)");
            }
            BiliImageKt.BiliImage(request, modifier3, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$ImagePlaceHolderKt.INSTANCE.getLambda$1802481785$ui_debug(), ComposableSingletons$ImagePlaceHolderKt.INSTANCE.getLambda$621401839$ui_debug(), $composer2, ($dirty2 & 14) | 113246208 | ($dirty2 & 112), 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.ImagePlaceHolderKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageWithPlaceHolder$lambda$0;
                    ImageWithPlaceHolder$lambda$0 = ImagePlaceHolderKt.ImageWithPlaceHolder$lambda$0(request, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageWithPlaceHolder$lambda$0;
                }
            });
        }
    }

    public static final void ImagePlaceHolder(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1212399398);
        ComposerKt.sourceInformation($composer2, "C(ImagePlaceHolder)N(modifier)39@1315L6,38@1253L361:ImagePlaceHolder.kt#uys4uf");
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
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1212399398, $dirty, -1, "video.biz.offline.list.ui.widget.ImagePlaceHolder (ImagePlaceHolder.kt:37)");
            }
            Modifier modifier$iv = AspectRatioKt.aspectRatio$default(BackgroundKt.background-bw27NRU$default(modifier3, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$ImagePlaceHolder_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1715369502, "C42@1400L46,41@1371L237:ImagePlaceHolder.kt#uys4uf");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCard_placeholder(Res.drawable.INSTANCE), $composer2, 0), "placeholder", $this$ImagePlaceHolder_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), (Alignment) null, ContentScale.Companion.getCrop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer2, Painter.$stable | 24624, 104);
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
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.ImagePlaceHolderKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImagePlaceHolder$lambda$1;
                    ImagePlaceHolder$lambda$1 = ImagePlaceHolderKt.ImagePlaceHolder$lambda$1(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImagePlaceHolder$lambda$1;
                }
            });
        }
    }

    public static final String fileToUri(String $this$fileToUri) {
        Intrinsics.checkNotNullParameter($this$fileToUri, "<this>");
        return BusinessSplashDefine.FILE_URI_PREFIX + $this$fileToUri;
    }
}