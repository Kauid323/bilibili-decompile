package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddBiliImage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AddBiliImageKt {
    public static final ComposableSingletons$AddBiliImageKt INSTANCE = new ComposableSingletons$AddBiliImageKt();

    /* renamed from: lambda$-1287880118  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f1034lambda$1287880118 = ComposableLambdaKt.composableLambdaInstance(-1287880118, false, new Function2() { // from class: im.base.ComposableSingletons$AddBiliImageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1287880118$lambda$0;
            lambda__1287880118$lambda$0 = ComposableSingletons$AddBiliImageKt.lambda__1287880118$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1287880118$lambda$0;
        }
    });

    /* renamed from: lambda$-1690683072  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f1035lambda$1690683072 = ComposableLambdaKt.composableLambdaInstance(-1690683072, false, new Function4() { // from class: im.base.ComposableSingletons$AddBiliImageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1690683072$lambda$0;
            lambda__1690683072$lambda$0 = ComposableSingletons$AddBiliImageKt.lambda__1690683072$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1690683072$lambda$0;
        }
    });

    /* renamed from: getLambda$-1287880118$base_ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3063getLambda$1287880118$base_ui_debug() {
        return f1034lambda$1287880118;
    }

    /* renamed from: getLambda$-1690683072$base_ui_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m3064getLambda$1690683072$base_ui_debug() {
        return f1035lambda$1690683072;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1287880118$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C36@1193L6,32@1031L213:AddBiliImage.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1287880118, $changed, -1, "im.base.ComposableSingletons$AddBiliImageKt.lambda$-1287880118.<anonymous> (AddBiliImage.kt:32)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.4f, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1690683072$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)44@1470L6,40@1308L554:AddBiliImage.kt#uu6lp7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1690683072, $changed, -1, "im.base.ComposableSingletons$AddBiliImageKt.lambda$-1690683072.<anonymous> (AddBiliImage.kt:40)");
        }
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null);
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
        int i2 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i3 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1054602452, "C48@1644L14,50@1752L6,47@1591L253:AddBiliImage.kt#uu6lp7");
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getImage_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), $composer, Painter.$stable | 432, 0);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}