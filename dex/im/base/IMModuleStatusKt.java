package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMModuleStatus.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0006\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"IMModuleStatus", "", "state", "Lim/base/ContentStatus;", "emptyText", "", "onRefresh", "Lkotlin/Function0;", "(Lim/base/ContentStatus;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMModuleStatusKt {
    public static final void IMModuleStatus(ContentStatus state, String emptyText, Function0<Unit> function0, Composer $composer, int $changed, int i2) {
        String emptyText2;
        final Function0 onRefresh;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, 1569220625, "CC(IMModuleStatus)N(state,emptyText,onRefresh)23@642L50,26@746L502:IMModuleStatus.kt#uu6lp7");
        if ((i2 & 2) != 0) {
            emptyText2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_66(Res.string.INSTANCE), $composer, 0);
        } else {
            emptyText2 = emptyText;
        }
        if ((i2 & 4) == 0) {
            onRefresh = function0;
        } else {
            onRefresh = new Function0<Unit>() { // from class: im.base.IMModuleStatusKt$IMModuleStatus$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m3069invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m3069invoke() {
                }
            };
        }
        Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(40), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null);
        Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (54 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
        int i3 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i4 = ((54 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 1719516304, "C:IMModuleStatus.kt#uu6lp7");
        if (Intrinsics.areEqual(state, IdleContent.INSTANCE)) {
            $composer.startReplaceGroup(1719548233);
            $composer.endReplaceGroup();
        } else if (Intrinsics.areEqual(state, LoadingContent.INSTANCE)) {
            $composer.startReplaceGroup(1719582240);
            ComposerKt.sourceInformation($composer, "36@1019L11");
            IMStatusKt.IMLoading(null, $composer, 0, 1);
            $composer.endReplaceGroup();
        } else if (state instanceof ErrorContent) {
            $composer.startReplaceGroup(1719658407);
            ComposerKt.sourceInformation($composer, "40@1095L36");
            IMStatusKt.IMError(null, false, new Function0<Unit>() { // from class: im.base.IMModuleStatusKt$IMModuleStatus$2$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m3070invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m3070invoke() {
                    onRefresh.invoke();
                }
            }, $composer, 0, 3);
            $composer.endReplaceGroup();
        } else if (!Intrinsics.areEqual(state, EmptyContent.INSTANCE)) {
            $composer.startReplaceGroup(-775815725);
            $composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            $composer.startReplaceGroup(1719755282);
            ComposerKt.sourceInformation($composer, "44@1193L25");
            IMStatusKt.IMEmpty(null, emptyText2, $composer, $changed & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, 1);
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }
}