package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.BPermissionType;
import kntr.common.photonic.permission.PermissionState_androidKt;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: DefaultPreviewFooter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"DefaultPreviewFooter", "", "state", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultPreviewFooterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultPreviewFooter$lambda$1(ImagePreviewState imagePreviewState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DefaultPreviewFooter(imagePreviewState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DefaultPreviewFooter(final ImagePreviewState state, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        Composer $composer$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer4 = $composer.startRestartGroup(-647542331);
        ComposerKt.sourceInformation($composer4, "C(DefaultPreviewFooter)N(state,modifier)38@1626L20,42@1802L20,40@1683L150,44@1850L24,45@1906L7,46@1940L20:DefaultPreviewFooter.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-647542331, $dirty, -1, "kntr.common.photonic.aphro.ui.preview.DefaultPreviewFooter (DefaultPreviewFooter.kt:37)");
            }
            final Activity context = PlatformContext_androidKt.getPlatformContext($composer4, 0);
            final BPermissionState galleryPermission = PermissionState_androidKt.rememberBPermissionState(BPermissionType.SAVE_IMAGE_INTO_COMMON_PHOTO_ALBUM, PlatformContext_androidKt.getPlatformContext($composer4, 0), $composer4, 6);
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer4.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Toaster toaster = (Toaster) consume;
            final Activity platformContext = PlatformContext_androidKt.getPlatformContext($composer4, 0);
            ImagePreviewItemState currentItem = state.getCurrentItem();
            PreviewableAsset currentAsset = currentItem != null ? currentItem.getAsset() : null;
            if (currentAsset == null) {
                $composer4.startReplaceGroup(2060086854);
                $composer4.endReplaceGroup();
                $composer2 = $composer4;
                modifier3 = modifier4;
            } else {
                $composer4.startReplaceGroup(2060086855);
                ComposerKt.sourceInformation($composer4, "*49@2057L57,50@2142L56,51@2207L1948");
                final String failToast = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_110(CommonRes.INSTANCE.getString()), $composer4, 0);
                final String successToast = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_28(CommonRes.INSTANCE.getString()), $composer4, 0);
                modifier3 = modifier4;
                Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(modifier4), 0.0f, 0.0f, Dp.constructor-impl(16), Dp.constructor-impl(5), 3, (Object) null), 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenterEnd();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                $composer2 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer4.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1277248240, "C56@2441L28,58@2547L6,62@2714L6,64@2862L1268,55@2396L1749:DefaultPreviewFooter.kt#n54g3c");
                Painter arrow_download_down_line_500 = BiliIconfont.INSTANCE.getArrow_download_down_line_500($composer4, 6);
                long j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_white-0d7_KjU();
                Modifier modifier5 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_medium-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(5));
                ComposerKt.sourceInformationMarkerStart($composer4, -1067162670, "CC(remember):DefaultPreviewFooter.kt#9igjgp");
                boolean invalid$iv = $composer4.changedInstance(scope) | $composer4.changed(galleryPermission) | $composer4.changedInstance(context) | $composer4.changedInstance(currentAsset) | $composer4.changedInstance(platformContext) | $composer4.changedInstance(toaster) | $composer4.changed(successToast) | $composer4.changed(failToast);
                Object it$iv = $composer4.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    $composer3 = $composer4;
                    $composer$iv = $composer4;
                    final PreviewableAsset previewableAsset = currentAsset;
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.DefaultPreviewFooterKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit DefaultPreviewFooter$lambda$0$0$0$0;
                            DefaultPreviewFooter$lambda$0$0$0$0 = DefaultPreviewFooterKt.DefaultPreviewFooter$lambda$0$0$0$0(scope, galleryPermission, context, previewableAsset, platformContext, toaster, successToast, failToast);
                            return DefaultPreviewFooter$lambda$0$0$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                } else {
                    $composer3 = $composer4;
                    $composer$iv = $composer4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(arrow_download_down_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer3, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.DefaultPreviewFooterKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit DefaultPreviewFooter$lambda$1;
                    DefaultPreviewFooter$lambda$1 = DefaultPreviewFooterKt.DefaultPreviewFooter$lambda$1(ImagePreviewState.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DefaultPreviewFooter$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultPreviewFooter$lambda$0$0$0$0(CoroutineScope $scope, BPermissionState $galleryPermission, Activity $context, PreviewableAsset $currentAsset, Activity $platformContext, Toaster $toaster, String $successToast, String $failToast) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new DefaultPreviewFooterKt$DefaultPreviewFooter$1$1$1$1$1($galleryPermission, $context, $currentAsset, $platformContext, $toaster, $successToast, $failToast, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}