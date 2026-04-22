package kntr.app.im.chat.ui.module.picture;

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
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PictureModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PictureModuleKt {
    public static final ComposableSingletons$PictureModuleKt INSTANCE = new ComposableSingletons$PictureModuleKt();

    /* renamed from: lambda$-819497398  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f41lambda$819497398 = ComposableLambdaKt.composableLambdaInstance(-819497398, false, new Function2() { // from class: kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__819497398$lambda$0;
            lambda__819497398$lambda$0 = ComposableSingletons$PictureModuleKt.lambda__819497398$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__819497398$lambda$0;
        }
    });

    /* renamed from: lambda$-397084012  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f39lambda$397084012 = ComposableLambdaKt.composableLambdaInstance(-397084012, false, new Function4() { // from class: kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__397084012$lambda$0;
            lambda__397084012$lambda$0 = ComposableSingletons$PictureModuleKt.lambda__397084012$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__397084012$lambda$0;
        }
    });

    /* renamed from: lambda$-1520417605  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f38lambda$1520417605 = ComposableLambdaKt.composableLambdaInstance(-1520417605, false, new Function2() { // from class: kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1520417605$lambda$0;
            lambda__1520417605$lambda$0 = ComposableSingletons$PictureModuleKt.lambda__1520417605$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1520417605$lambda$0;
        }
    });

    /* renamed from: lambda$-530518156  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f40lambda$530518156 = ComposableLambdaKt.composableLambdaInstance(-530518156, false, new Function4() { // from class: kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__530518156$lambda$0;
            lambda__530518156$lambda$0 = ComposableSingletons$PictureModuleKt.lambda__530518156$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__530518156$lambda$0;
        }
    });

    /* renamed from: getLambda$-1520417605$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1809getLambda$1520417605$ui_debug() {
        return f38lambda$1520417605;
    }

    /* renamed from: getLambda$-397084012$ui_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1810getLambda$397084012$ui_debug() {
        return f39lambda$397084012;
    }

    /* renamed from: getLambda$-530518156$ui_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1811getLambda$530518156$ui_debug() {
        return f40lambda$530518156;
    }

    /* renamed from: getLambda$-819497398$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1812getLambda$819497398$ui_debug() {
        return f41lambda$819497398;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__819497398$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C127@4757L6,123@4611L193:PictureModule.kt#kl58cw");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819497398, $changed, -1, "kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt.lambda$-819497398.<anonymous> (PictureModule.kt:123)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__397084012$lambda$0(ImageFailScope $this$BiliImageWithLifecycleCount, ImageException it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BiliImageWithLifecycleCount, "$this$BiliImageWithLifecycleCount");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)131@4915L6,131@4856L372:PictureModule.kt#kl58cw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-397084012, $changed, -1, "kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt.lambda$-397084012.<anonymous> (PictureModule.kt:131)");
        }
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null);
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
        int i2 = ((0 >> 6) & 112) | 6;
        BoxScope $this$lambda__397084012_u24lambda_u240_u240 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1104670072, "C133@5006L14,135@5106L6,132@4957L257:PictureModule.kt#kl58cw");
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getImage_line_500($composer, 6), (String) null, $this$lambda__397084012_u24lambda_u240_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), $composer, Painter.$stable | 48, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1520417605$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:PictureModule.kt#kl58cw");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520417605, $changed, -1, "kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt.lambda$-1520417605.<anonymous> (PictureModule.kt:173)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__530518156$lambda$0(ImageFailScope imageFailScope, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(imageFailScope, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it):PictureModule.kt#kl58cw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-530518156, $changed, -1, "kntr.app.im.chat.ui.module.picture.ComposableSingletons$PictureModuleKt.lambda$-530518156.<anonymous> (PictureModule.kt:174)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}