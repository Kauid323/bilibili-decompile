package defpackage;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.datacenter.hakase.protobuf.AndroidDeviceInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: CustomBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* renamed from: ComposableSingletons$CustomBottomSheetKt  reason: default package */
public final class ComposableSingletons$CustomBottomSheetKt {
    public static final ComposableSingletons$CustomBottomSheetKt INSTANCE = new ComposableSingletons$CustomBottomSheetKt();
    private static Function2<Composer, Integer, Unit> lambda$1248120683 = ComposableLambdaKt.composableLambdaInstance(1248120683, false, new Function2() { // from class: ComposableSingletons$CustomBottomSheetKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1248120683$lambda$0;
            lambda_1248120683$lambda$0 = ComposableSingletons$CustomBottomSheetKt.lambda_1248120683$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1248120683$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1248120683$watch_later_debug() {
        return lambda$1248120683;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1248120683$lambda$0(Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C63@2548L633:CustomBottomSheet.kt");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1248120683, $changed, -1, "ComposableSingletons$CustomBottomSheetKt.lambda$1248120683.<anonymous> (CustomBottomSheet.kt:63)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(8), 5, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & AndroidDeviceInfo.DeviceInfo.BATTERY_PRESENT_FIELD_NUMBER;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$$ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
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
            int i2 = ((54 >> 6) & AndroidDeviceInfo.DeviceInfo.BATTERY_PRESENT_FIELD_NUMBER) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -381304130, "C76@3039L6,70@2795L372:CustomBottomSheet.kt");
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Dp.constructor-impl(3)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa3-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float) 1.5d))), $composer, 0);
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