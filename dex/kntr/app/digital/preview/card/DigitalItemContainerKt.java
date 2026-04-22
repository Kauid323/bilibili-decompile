package kntr.app.digital.preview.card;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalItemContainer.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"DigitalCardContainer", RoomRecommendViewModel.EMPTY_CURSOR, "frameUrl", RoomRecommendViewModel.EMPTY_CURSOR, "badgeUrl", "modifier", "Landroidx/compose/ui/Modifier;", "hasMask", RoomRecommendViewModel.EMPTY_CURSOR, "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DigitalItemContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalCardContainer$lambda$1(String str, String str2, Modifier modifier, boolean z, Function3 function3, int i, int i2, Composer composer, int i3) {
        DigitalCardContainer(str, str2, modifier, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0338  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DigitalCardContainer(final String frameUrl, final String badgeUrl, Modifier modifier, boolean hasMask, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean hasMask2;
        Modifier modifier4;
        boolean hasMask3;
        Function0 factory$iv$iv$iv;
        String badgeUrl2;
        String frameUrl2;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer3 = $composer.startRestartGroup(1587924880);
        ComposerKt.sourceInformation($composer3, "C(DigitalCardContainer)N(frameUrl,badgeUrl,modifier,hasMask,content)26@916L1411:DigitalItemContainer.kt#v85lra");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(frameUrl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(badgeUrl) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = hasMask;
        } else if (($changed & 3072) == 0) {
            z = hasMask;
            $dirty |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = hasMask;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            hasMask2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                hasMask3 = z;
            } else {
                hasMask3 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1587924880, $dirty2, -1, "kntr.app.digital.preview.card.DigitalCardContainer (DigitalItemContainer.kt:25)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(modifier4, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(14))), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope $this$DigitalCardContainer_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1053863748, "C32@1096L9:DigitalItemContainer.kt#v85lra");
            function3.invoke($this$DigitalCardContainer_u24lambda_u240, $composer3, Integer.valueOf(((((0 >> 6) & 112) | 6) & 14) | (($dirty2 >> 9) & 112)));
            if (badgeUrl != null) {
                if (badgeUrl.length() > 0) {
                    badgeUrl2 = badgeUrl;
                    if (badgeUrl2 != null) {
                        $composer3.startReplaceGroup(1053892948);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(1053892949);
                        ComposerKt.sourceInformation($composer3, "*35@1183L303");
                        BiliImageKt.BiliImage(new ImageRequest(badgeUrl2).contentScale(ContentScale.Companion.getFit()).build(), $this$DigitalCardContainer_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopStart()), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, 508);
                        $composer3.endReplaceGroup();
                    }
                    if (frameUrl != null) {
                        if (frameUrl.length() > 0) {
                            frameUrl2 = frameUrl;
                            if (frameUrl2 == null) {
                                $composer3.startReplaceGroup(1054287113);
                                $composer3.endReplaceGroup();
                            } else {
                                $composer3.startReplaceGroup(1054287114);
                                ComposerKt.sourceInformation($composer3, "*47@1574L506");
                                BiliImageKt.BiliImage(new ImageRequest(frameUrl2).useOrigin(true).build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableSingletons$DigitalItemContainerKt.INSTANCE.getLambda$592708160$preview_debug(), $composer3, 100663344, 252);
                                $composer3.endReplaceGroup();
                            }
                            if (hasMask3) {
                                $composer3.startReplaceGroup(1054840123);
                                ComposerKt.sourceInformation($composer3, "64@2126L185");
                                SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer3, 6);
                            } else {
                                $composer3.startReplaceGroup(1052737548);
                            }
                            $composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            hasMask2 = hasMask3;
                        }
                    }
                    frameUrl2 = null;
                    if (frameUrl2 == null) {
                    }
                    if (hasMask3) {
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    hasMask2 = hasMask3;
                }
            }
            badgeUrl2 = null;
            if (badgeUrl2 != null) {
            }
            if (frameUrl != null) {
            }
            frameUrl2 = null;
            if (frameUrl2 == null) {
            }
            if (hasMask3) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            hasMask2 = hasMask3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = hasMask2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.DigitalItemContainerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DigitalCardContainer$lambda$1;
                    DigitalCardContainer$lambda$1 = DigitalItemContainerKt.DigitalCardContainer$lambda$1(frameUrl, badgeUrl, modifier5, z2, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DigitalCardContainer$lambda$1;
                }
            });
        }
    }
}