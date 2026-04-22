package kntr.app.mall.product.details.page.ui.components.pieces;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpSayComponent.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a¸\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"UpSayComponent", "", "upSayModel", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;", "isInPreview", "", "muted", "pause", "pauseByOther", "updatePause", "Lkotlin/Function1;", "togglePause", "Lkotlin/Function0;", "toggleMuted", "videoPlayer", "Lcom/bilibili/framework/simpleplayer/SimplePlayer;", "movableVideoPlayerView", "Landroidx/compose/runtime/Composable;", "scale", "", "tailPadding", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "progressBarColor", "", "progressBarIcon", "UpSayComponent-Gp5xyCo", "(Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$NewUpSayModel;ZZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/bilibili/framework/simpleplayer/SimplePlayer;Lkotlin/jvm/functions/Function2;FFLandroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;III)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpSayComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpSayComponent_Gp5xyCo$lambda$0(BasicInfoFloor.NewUpSayModel newUpSayModel, boolean z, boolean z2, boolean z3, boolean z4, Function1 function1, Function0 function0, Function0 function02, SimplePlayer simplePlayer, Function2 function2, float f, float f2, Modifier modifier, String str, String str2, int i, int i2, int i3, Composer composer, int i4) {
        m559UpSayComponentGp5xyCo(newUpSayModel, z, z2, z3, z4, function1, function0, function02, simplePlayer, function2, f, f2, modifier, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpSayComponent_Gp5xyCo$lambda$2(BasicInfoFloor.NewUpSayModel newUpSayModel, boolean z, boolean z2, boolean z3, boolean z4, Function1 function1, Function0 function0, Function0 function02, SimplePlayer simplePlayer, Function2 function2, float f, float f2, Modifier modifier, String str, String str2, int i, int i2, int i3, Composer composer, int i4) {
        m559UpSayComponentGp5xyCo(newUpSayModel, z, z2, z3, z4, function1, function0, function02, simplePlayer, function2, f, f2, modifier, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -125
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* renamed from: UpSayComponent-Gp5xyCo  reason: not valid java name */
    public static final void m559UpSayComponentGp5xyCo(kntr.app.mall.product.details.page.api.model.BasicInfoFloor.NewUpSayModel r130, boolean r131, boolean r132, boolean r133, boolean r134, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r135, kotlin.jvm.functions.Function0<kotlin.Unit> r136, kotlin.jvm.functions.Function0<kotlin.Unit> r137, com.bilibili.framework.simpleplayer.SimplePlayer r138, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r139, float r140, float r141, androidx.compose.ui.Modifier r142, java.lang.String r143, java.lang.String r144, androidx.compose.runtime.Composer r145, int r146, int r147, int r148) {
        /*
            Method dump skipped, instructions count: 2517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.mall.product.details.page.ui.components.pieces.UpSayComponentKt.m559UpSayComponentGp5xyCo(kntr.app.mall.product.details.page.api.model.BasicInfoFloor$NewUpSayModel, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, com.bilibili.framework.simpleplayer.SimplePlayer, kotlin.jvm.functions.Function2, float, float, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpSayComponent_Gp5xyCo$lambda$1$0$0$2(float $scale, String it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)145@6043L838:UpSayComponent.kt#v057zd");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-957184038, $changed, -1, "kntr.app.mall.product.details.page.ui.components.pieces.UpSayComponent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UpSayComponent.kt:145)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
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
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 719284253, "C152@6531L9,149@6317L518:UpSayComponent.kt#v057zd");
            TextKt.Text-Nvy7gAk("推荐", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, $scale), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12b(), $scale), $composer, 390, 0, 131064);
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
}