package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntRect;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroComponent;
import kntr.common.photonic.aphro.core.AphroEntryPoint;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataSource;
import kntr.common.photonic.aphro.ui.preview.model.OriginImageHint;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAssetKt;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewStateKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PreviewPageContent.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"PreviewPageContent", "", "imagePreviewData", "Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewDataSource;", "onCloseRequest", "Lkotlin/Function0;", "(Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewDataSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ui_debug", "dataSourceState", "Lkntr/common/photonic/aphro/ui/preview/DataSourceState;", "animationPhase", "Lkntr/common/photonic/aphro/ui/preview/AnimationPhase;", "albumState", "Lkntr/common/photonic/aphro/core/AphroState;", "isAllDataSource", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PreviewPageContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$5(ImagePreviewDataSource imagePreviewDataSource, Function0 function0, int i, Composer composer, int i2) {
        PreviewPageContent(imagePreviewDataSource, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0561, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L93;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0360  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PreviewPageContent(final ImagePreviewDataSource imagePreviewData, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object obj;
        Function0 factory$iv$iv$iv;
        Object value$iv;
        boolean invalid$iv;
        State animationPhase$delegate;
        State animationPhase$delegate2;
        String str;
        Composer $composer2;
        int $dirty;
        CoroutineScope scope;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        MeasurePolicy measurePolicy$iv$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        Intrinsics.checkNotNullParameter(imagePreviewData, "imagePreviewData");
        Intrinsics.checkNotNullParameter(function0, "onCloseRequest");
        Composer $composer3 = $composer.startRestartGroup(1095285316);
        ComposerKt.sourceInformation($composer3, "C(PreviewPageContent)N(imagePreviewData,onCloseRequest)37@1722L36,38@1775L24,39@1827L214,49@2079L145,55@2260L200,61@2465L13708:PreviewPageContent.kt#n54g3c");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(imagePreviewData) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int $dirty3 = $dirty2;
        if ($composer3.shouldExecute(($dirty3 & 19) != 18, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1095285316, $dirty3, -1, "kntr.common.photonic.aphro.ui.preview.PreviewPageContent (PreviewPageContent.kt:36)");
            }
            State close = SnapshotStateKt.rememberUpdatedState(function0, $composer3, ($dirty3 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope2 = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 302208634, "CC(remember):PreviewPageContent.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                obj = null;
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(new DataSourceState(imagePreviewData.getDataSource(), imagePreviewData.getInitialIndex()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            } else {
                obj = null;
            }
            final MutableState dataSourceState$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final ImagePreviewState imagePreviewState = ImagePreviewStateKt.rememberImagePreviewState(PreviewPageContent$lambda$1(dataSourceState$delegate).getDataSource(), null, PreviewPageContent$lambda$1(dataSourceState$delegate).getInitialIndex(), $composer3, 0, 2);
            ComposerKt.sourceInformationMarkerStart($composer3, 302222476, "CC(remember):PreviewPageContent.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new TransitionState(scope2, ((ImagePreviewItemState) imagePreviewState.getDataSource().get(imagePreviewState.getInitialAssetIndex())).getAsset(), null, null, 12, null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            final TransitionState transitionState = (TransitionState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -833985357, "C64@2550L310,64@2529L331,72@2923L16,74@2980L819,74@2949L850,93@3809L116:PreviewPageContent.kt#n54g3c");
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1635652576, "CC(remember):PreviewPageContent.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(transitionState);
            Object it$iv3 = $composer3.rememberedValue();
            if (!invalid$iv4 && it$iv3 != Composer.Companion.getEmpty()) {
                value$iv = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer3, 6);
                State animationPhase$delegate3 = SnapshotStateKt.collectAsState(transitionState.getAnimationPhase(), (CoroutineContext) null, $composer3, 0, 1);
                MeasurePolicy it$iv4 = PreviewPageContent$lambda$4$1(animationPhase$delegate3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1635666845, "CC(remember):PreviewPageContent.kt#9igjgp");
                invalid$iv = $composer3.changed(animationPhase$delegate3) | $composer3.changedInstance(transitionState) | $composer3.changed(close) | (($dirty3 & 14) != 4);
                Object value$iv4 = $composer3.rememberedValue();
                if (invalid$iv) {
                    animationPhase$delegate = animationPhase$delegate3;
                    if (value$iv4 != Composer.Companion.getEmpty()) {
                        str = "CC(remember):PreviewPageContent.kt#9igjgp";
                        $composer2 = $composer3;
                        $dirty = $dirty3;
                        scope = scope2;
                        $composer$iv$iv = $composer3;
                        $composer$iv = $composer3;
                        measurePolicy$iv$iv = it$iv4;
                        animationPhase$delegate2 = animationPhase$delegate;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Composer $composer4 = $composer2;
                        EffectsKt.LaunchedEffect(measurePolicy$iv$iv, (Function2) value$iv4, $composer4, 0);
                        ImagePreviewLauncherKt.ImagePreviewTransition(transitionState, imagePreviewState, $composer4, 0);
                        if (PreviewPageContent$lambda$4$1(animationPhase$delegate2) == AnimationPhase.Entered) {
                            $composer4.startReplaceGroup(-832555700);
                            ComposerKt.sourceInformation($composer4, "");
                            ImagePreviewType imagePreviewType = imagePreviewData.getImagePreviewType();
                            if (Intrinsics.areEqual(imagePreviewType, ImagePreviewType.Default.INSTANCE)) {
                                $composer4.startReplaceGroup(-832813341);
                                ComposerKt.sourceInformation($composer4, "105@4234L149,109@4425L523,120@4990L118,103@4126L1005");
                                ComposerKt.sourceInformationMarkerStart($composer4, 1635706303, str);
                                boolean invalid$iv5 = $composer4.changedInstance(transitionState);
                                Object it$iv5 = $composer4.rememberedValue();
                                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                                    Object value$iv5 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda7
                                        public final Object invoke(Object obj2) {
                                            Unit PreviewPageContent$lambda$4$3$0;
                                            PreviewPageContent$lambda$4$3$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$3$0(TransitionState.this, (ExitTransitionState) obj2);
                                            return PreviewPageContent$lambda$4$3$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv5);
                                    it$iv5 = value$iv5;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ImagePreviewKt.ImagePreview(imagePreviewState, (Function1) it$iv5, ComposableLambdaKt.rememberComposableLambda(-1831297022, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda8
                                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                        Unit PreviewPageContent$lambda$4$4;
                                        PreviewPageContent$lambda$4$4 = PreviewPageContentKt.PreviewPageContent$lambda$4$4(ImagePreviewState.this, imagePreviewData, transitionState, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                        return PreviewPageContent$lambda$4$4;
                                    }
                                }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-565226237, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda9
                                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                        Unit PreviewPageContent$lambda$4$5;
                                        PreviewPageContent$lambda$4$5 = PreviewPageContentKt.PreviewPageContent$lambda$4$5(ImagePreviewState.this, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                        return PreviewPageContent$lambda$4$5;
                                    }
                                }, $composer4, 54), null, $composer4, 3456, 16);
                                $composer4.endReplaceGroup();
                            } else {
                                String str2 = str;
                                if (!(imagePreviewType instanceof ImagePreviewType.Gallery)) {
                                    $composer4.startReplaceGroup(1635711350);
                                    $composer4.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                                $composer4.startReplaceGroup(-831421193);
                                ComposerKt.sourceInformation($composer4, "128@5265L1109,147@6439L16,149@6508L796,149@6477L827,165@7352L7,166@7411L471,166@7380L502,180@8012L149,184@8203L3077,236@11322L4780,178@7904L8221");
                                ComposerKt.sourceInformationMarkerStart($composer4, 1635740255, str2);
                                Object it$iv6 = $composer4.rememberedValue();
                                if (it$iv6 == Composer.Companion.getEmpty()) {
                                    Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                                    AphroComponent.Factory aphroComponentFactory = ((AphroEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AphroEntryPoint.class))).getAphroComponentFactory();
                                    AphroSelectOption selectOption = ((ImagePreviewType.Gallery) imagePreviewData.getImagePreviewType()).getSelectOption();
                                    boolean invalid$iv6 = ((ImagePreviewType.Gallery) imagePreviewData.getImagePreviewType()).getUseOriginImage();
                                    Object value$iv6 = aphroComponentFactory.build(scope, new AphroState.Init(new AphroSelection(((ImagePreviewType.Gallery) imagePreviewData.getImagePreviewType()).getSelectedAssets(), invalid$iv6), selectOption, imagePreviewState.getDataSource().size(), imagePreviewData.getInitialAlbumId())).getViewModel();
                                    $composer4.updateRememberedValue(value$iv6);
                                    it$iv6 = value$iv6;
                                }
                                final AphroViewModel aphroViewModel = (AphroViewModel) it$iv6;
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                final State albumState$delegate = SnapshotStateKt.collectAsState(aphroViewModel.getStateFlow(), (CoroutineContext) null, $composer4, 0, 1);
                                ComposerKt.sourceInformationMarkerStart($composer4, 1635779718, str2);
                                boolean invalid$iv7 = $composer3.changedInstance(aphroViewModel) | (($dirty & 14) == 4);
                                Object it$iv7 = $composer4.rememberedValue();
                                if (!invalid$iv7 && it$iv7 != Composer.Companion.getEmpty()) {
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    EffectsKt.LaunchedEffect(aphroViewModel, (Function2) it$iv7, $composer4, AphroViewModel.$stable);
                                    CompositionLocal this_$iv = ToasterKt.getLocalToaster();
                                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume = $composer4.consume(this_$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    Toaster toaster = (Toaster) consume;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1635808289, str2);
                                    invalid$iv2 = $composer4.changedInstance(aphroViewModel) | $composer4.changedInstance(toaster);
                                    Object it$iv8 = $composer4.rememberedValue();
                                    if (!invalid$iv2 && it$iv8 != Composer.Companion.getEmpty()) {
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        EffectsKt.LaunchedEffect(aphroViewModel, (Function2) it$iv8, $composer4, AphroViewModel.$stable);
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1635827199, str2);
                                        invalid$iv3 = $composer4.changedInstance(transitionState);
                                        Object it$iv9 = $composer4.rememberedValue();
                                        if (invalid$iv3) {
                                        }
                                        Object value$iv7 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda10
                                            public final Object invoke(Object obj2) {
                                                Unit PreviewPageContent$lambda$4$10$0;
                                                PreviewPageContent$lambda$4$10$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$10$0(TransitionState.this, (ExitTransitionState) obj2);
                                                return PreviewPageContent$lambda$4$10$0;
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv7);
                                        it$iv9 = value$iv7;
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        final CoroutineScope coroutineScope = scope;
                                        final CoroutineScope coroutineScope2 = scope;
                                        ImagePreviewKt.ImagePreview(imagePreviewState, (Function1) it$iv9, ComposableLambdaKt.rememberComposableLambda(1559550251, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda11
                                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                                Unit PreviewPageContent$lambda$4$11;
                                                PreviewPageContent$lambda$4$11 = PreviewPageContentKt.PreviewPageContent$lambda$4$11(coroutineScope, imagePreviewState, aphroViewModel, transitionState, albumState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                                return PreviewPageContent$lambda$4$11;
                                            }
                                        }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1517137428, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda12
                                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                                Unit PreviewPageContent$lambda$4$12;
                                                PreviewPageContent$lambda$4$12 = PreviewPageContentKt.PreviewPageContent$lambda$4$12(ImagePreviewState.this, coroutineScope2, aphroViewModel, transitionState, albumState$delegate, dataSourceState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                                return PreviewPageContent$lambda$4$12;
                                            }
                                        }, $composer4, 54), null, $composer4, 3456, 16);
                                        $composer4.endReplaceGroup();
                                    }
                                    Object value$iv8 = (Function2) new PreviewPageContentKt$PreviewPageContent$1$7$1(aphroViewModel, toaster, null);
                                    $composer4.updateRememberedValue(value$iv8);
                                    it$iv8 = value$iv8;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    EffectsKt.LaunchedEffect(aphroViewModel, (Function2) it$iv8, $composer4, AphroViewModel.$stable);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1635827199, str2);
                                    invalid$iv3 = $composer4.changedInstance(transitionState);
                                    Object it$iv92 = $composer4.rememberedValue();
                                    if (invalid$iv3) {
                                    }
                                    Object value$iv72 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda10
                                        public final Object invoke(Object obj2) {
                                            Unit PreviewPageContent$lambda$4$10$0;
                                            PreviewPageContent$lambda$4$10$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$10$0(TransitionState.this, (ExitTransitionState) obj2);
                                            return PreviewPageContent$lambda$4$10$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv72);
                                    it$iv92 = value$iv72;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    final CoroutineScope coroutineScope3 = scope;
                                    final CoroutineScope coroutineScope22 = scope;
                                    ImagePreviewKt.ImagePreview(imagePreviewState, (Function1) it$iv92, ComposableLambdaKt.rememberComposableLambda(1559550251, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda11
                                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                            Unit PreviewPageContent$lambda$4$11;
                                            PreviewPageContent$lambda$4$11 = PreviewPageContentKt.PreviewPageContent$lambda$4$11(coroutineScope3, imagePreviewState, aphroViewModel, transitionState, albumState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                            return PreviewPageContent$lambda$4$11;
                                        }
                                    }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1517137428, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda12
                                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                            Unit PreviewPageContent$lambda$4$12;
                                            PreviewPageContent$lambda$4$12 = PreviewPageContentKt.PreviewPageContent$lambda$4$12(ImagePreviewState.this, coroutineScope22, aphroViewModel, transitionState, albumState$delegate, dataSourceState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                            return PreviewPageContent$lambda$4$12;
                                        }
                                    }, $composer4, 54), null, $composer4, 3456, 16);
                                    $composer4.endReplaceGroup();
                                }
                                Object value$iv9 = (Function2) new PreviewPageContentKt$PreviewPageContent$1$6$1(imagePreviewData, aphroViewModel, null);
                                $composer4.updateRememberedValue(value$iv9);
                                it$iv7 = value$iv9;
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                EffectsKt.LaunchedEffect(aphroViewModel, (Function2) it$iv7, $composer4, AphroViewModel.$stable);
                                CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
                                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume2 = $composer4.consume(this_$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                Toaster toaster2 = (Toaster) consume2;
                                ComposerKt.sourceInformationMarkerStart($composer4, 1635808289, str2);
                                invalid$iv2 = $composer4.changedInstance(aphroViewModel) | $composer4.changedInstance(toaster2);
                                Object it$iv82 = $composer4.rememberedValue();
                                if (!invalid$iv2) {
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    EffectsKt.LaunchedEffect(aphroViewModel, (Function2) it$iv82, $composer4, AphroViewModel.$stable);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1635827199, str2);
                                    invalid$iv3 = $composer4.changedInstance(transitionState);
                                    Object it$iv922 = $composer4.rememberedValue();
                                    if (invalid$iv3) {
                                    }
                                    Object value$iv722 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda10
                                        public final Object invoke(Object obj2) {
                                            Unit PreviewPageContent$lambda$4$10$0;
                                            PreviewPageContent$lambda$4$10$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$10$0(TransitionState.this, (ExitTransitionState) obj2);
                                            return PreviewPageContent$lambda$4$10$0;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv722);
                                    it$iv922 = value$iv722;
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    final CoroutineScope coroutineScope32 = scope;
                                    final CoroutineScope coroutineScope222 = scope;
                                    ImagePreviewKt.ImagePreview(imagePreviewState, (Function1) it$iv922, ComposableLambdaKt.rememberComposableLambda(1559550251, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda11
                                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                            Unit PreviewPageContent$lambda$4$11;
                                            PreviewPageContent$lambda$4$11 = PreviewPageContentKt.PreviewPageContent$lambda$4$11(coroutineScope32, imagePreviewState, aphroViewModel, transitionState, albumState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                            return PreviewPageContent$lambda$4$11;
                                        }
                                    }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1517137428, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda12
                                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                            Unit PreviewPageContent$lambda$4$12;
                                            PreviewPageContent$lambda$4$12 = PreviewPageContentKt.PreviewPageContent$lambda$4$12(ImagePreviewState.this, coroutineScope222, aphroViewModel, transitionState, albumState$delegate, dataSourceState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                            return PreviewPageContent$lambda$4$12;
                                        }
                                    }, $composer4, 54), null, $composer4, 3456, 16);
                                    $composer4.endReplaceGroup();
                                }
                                Object value$iv82 = (Function2) new PreviewPageContentKt$PreviewPageContent$1$7$1(aphroViewModel, toaster2, null);
                                $composer4.updateRememberedValue(value$iv82);
                                it$iv82 = value$iv82;
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                EffectsKt.LaunchedEffect(aphroViewModel, (Function2) it$iv82, $composer4, AphroViewModel.$stable);
                                ComposerKt.sourceInformationMarkerStart($composer4, 1635827199, str2);
                                invalid$iv3 = $composer4.changedInstance(transitionState);
                                Object it$iv9222 = $composer4.rememberedValue();
                                if (invalid$iv3) {
                                }
                                Object value$iv7222 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda10
                                    public final Object invoke(Object obj2) {
                                        Unit PreviewPageContent$lambda$4$10$0;
                                        PreviewPageContent$lambda$4$10$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$10$0(TransitionState.this, (ExitTransitionState) obj2);
                                        return PreviewPageContent$lambda$4$10$0;
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv7222);
                                it$iv9222 = value$iv7222;
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                final CoroutineScope coroutineScope322 = scope;
                                final CoroutineScope coroutineScope2222 = scope;
                                ImagePreviewKt.ImagePreview(imagePreviewState, (Function1) it$iv9222, ComposableLambdaKt.rememberComposableLambda(1559550251, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda11
                                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                        Unit PreviewPageContent$lambda$4$11;
                                        PreviewPageContent$lambda$4$11 = PreviewPageContentKt.PreviewPageContent$lambda$4$11(coroutineScope322, imagePreviewState, aphroViewModel, transitionState, albumState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                        return PreviewPageContent$lambda$4$11;
                                    }
                                }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1517137428, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda12
                                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                        Unit PreviewPageContent$lambda$4$12;
                                        PreviewPageContent$lambda$4$12 = PreviewPageContentKt.PreviewPageContent$lambda$4$12(ImagePreviewState.this, coroutineScope2222, aphroViewModel, transitionState, albumState$delegate, dataSourceState$delegate, (Modifier) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                        return PreviewPageContent$lambda$4$12;
                                    }
                                }, $composer4, 54), null, $composer4, 3456, 16);
                                $composer4.endReplaceGroup();
                            }
                        } else {
                            $composer4.startReplaceGroup(-836917896);
                        }
                        $composer4.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                } else {
                    animationPhase$delegate = animationPhase$delegate3;
                }
                animationPhase$delegate2 = animationPhase$delegate;
                str = "CC(remember):PreviewPageContent.kt#9igjgp";
                $composer2 = $composer3;
                $dirty = $dirty3;
                scope = scope2;
                $composer$iv$iv = $composer3;
                $composer$iv = $composer3;
                measurePolicy$iv$iv = it$iv4;
                value$iv4 = new PreviewPageContentKt$PreviewPageContent$1$2$1(transitionState, close, imagePreviewData, animationPhase$delegate2, null);
                $composer3.updateRememberedValue(value$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Composer $composer42 = $composer2;
                EffectsKt.LaunchedEffect(measurePolicy$iv$iv, (Function2) value$iv4, $composer42, 0);
                ImagePreviewLauncherKt.ImagePreviewTransition(transitionState, imagePreviewState, $composer42, 0);
                if (PreviewPageContent$lambda$4$1(animationPhase$delegate2) == AnimationPhase.Entered) {
                }
                $composer42.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer42);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv = (Function2) new PreviewPageContentKt$PreviewPageContent$1$1$1(transitionState, null);
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer3, 6);
            State animationPhase$delegate32 = SnapshotStateKt.collectAsState(transitionState.getAnimationPhase(), (CoroutineContext) null, $composer3, 0, 1);
            MeasurePolicy it$iv42 = PreviewPageContent$lambda$4$1(animationPhase$delegate32);
            ComposerKt.sourceInformationMarkerStart($composer3, 1635666845, "CC(remember):PreviewPageContent.kt#9igjgp");
            invalid$iv = $composer3.changed(animationPhase$delegate32) | $composer3.changedInstance(transitionState) | $composer3.changed(close) | (($dirty3 & 14) != 4);
            Object value$iv42 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            animationPhase$delegate2 = animationPhase$delegate;
            str = "CC(remember):PreviewPageContent.kt#9igjgp";
            $composer2 = $composer3;
            $dirty = $dirty3;
            scope = scope2;
            $composer$iv$iv = $composer3;
            $composer$iv = $composer3;
            measurePolicy$iv$iv = it$iv42;
            value$iv42 = new PreviewPageContentKt$PreviewPageContent$1$2$1(transitionState, close, imagePreviewData, animationPhase$delegate2, null);
            $composer3.updateRememberedValue(value$iv42);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Composer $composer422 = $composer2;
            EffectsKt.LaunchedEffect(measurePolicy$iv$iv, (Function2) value$iv42, $composer422, 0);
            ImagePreviewLauncherKt.ImagePreviewTransition(transitionState, imagePreviewState, $composer422, 0);
            if (PreviewPageContent$lambda$4$1(animationPhase$delegate2) == AnimationPhase.Entered) {
            }
            $composer422.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer422);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer3.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj2, Object obj3) {
                    Unit PreviewPageContent$lambda$5;
                    PreviewPageContent$lambda$5 = PreviewPageContentKt.PreviewPageContent$lambda$5(ImagePreviewDataSource.this, function0, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                    return PreviewPageContent$lambda$5;
                }
            });
        }
    }

    private static final DataSourceState PreviewPageContent$lambda$1(MutableState<DataSourceState> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (DataSourceState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationPhase PreviewPageContent$lambda$4$1(State<? extends AnimationPhase> state) {
        Object thisObj$iv = state.getValue();
        return (AnimationPhase) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$3$0(TransitionState $transitionState, ExitTransitionState it) {
        $transitionState.getAnimationPhase().setValue(AnimationPhase.Exiting);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$4(ImagePreviewState $imagePreviewState, ImagePreviewDataSource $imagePreviewData, final TransitionState $transitionState, Modifier it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)113@4671L173,110@4455L467:PreviewPageContent.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1831297022, $dirty, -1, "kntr.common.photonic.aphro.ui.preview.PreviewPageContent.<anonymous>.<anonymous> (PreviewPageContent.kt:110)");
            }
            OriginImageHint originImageHint = $imagePreviewData.getOption().getOriginImageHint();
            ComposerKt.sourceInformationMarkerStart($composer, 1060161263, "CC(remember):PreviewPageContent.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($transitionState);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit PreviewPageContent$lambda$4$4$0$0;
                        PreviewPageContent$lambda$4$4$0$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$4$0$0(TransitionState.this);
                        return PreviewPageContent$lambda$4$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            DefaultPreviewHeaderKt.DefaultPreviewHeader($imagePreviewState, originImageHint, (Function0) it$iv, it, $composer, ($dirty << 9) & 7168, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$4$0$0(TransitionState $transitionState) {
        $transitionState.getAnimationPhase().setValue(AnimationPhase.Exiting);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$5(ImagePreviewState $imagePreviewState, Modifier it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)121@5020L62:PreviewPageContent.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-565226237, $dirty, -1, "kntr.common.photonic.aphro.ui.preview.PreviewPageContent.<anonymous>.<anonymous> (PreviewPageContent.kt:121)");
            }
            DefaultPreviewFooterKt.DefaultPreviewFooter($imagePreviewState, it, $composer, ($dirty << 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final AphroState PreviewPageContent$lambda$4$7(State<? extends AphroState> state) {
        Object thisObj$iv = state.getValue();
        return (AphroState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$10$0(TransitionState $transitionState, ExitTransitionState it) {
        $transitionState.getAnimationPhase().setValue(AnimationPhase.Exiting);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0121, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit PreviewPageContent$lambda$4$11(final CoroutineScope $scope, final ImagePreviewState $imagePreviewState, final AphroViewModel $aphroViewModel, final TransitionState $transitionState, State $albumState$delegate, Modifier it, Composer $composer, int $changed) {
        int i;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it):PreviewPageContent.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1559550251, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.PreviewPageContent.<anonymous>.<anonymous> (PreviewPageContent.kt:185)");
            }
            AphroState PreviewPageContent$lambda$4$7 = PreviewPageContent$lambda$4$7($albumState$delegate);
            final AphroState.AphroContent album = PreviewPageContent$lambda$4$7 instanceof AphroState.AphroContent ? (AphroState.AphroContent) PreviewPageContent$lambda$4$7 : null;
            if (album != null) {
                $composer.startReplaceGroup(1900536044);
                ComposerKt.sourceInformation($composer, "193@8786L952,209@9789L1007,226@10848L290,187@8365L2859");
                List $this$indexOfFirst$iv = album.getSelected();
                boolean z = false;
                int index$iv = 0;
                Iterator<Asset> it2 = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    Object item$iv = it2.next();
                    String identifier = ((Asset) item$iv).getIdentifier();
                    List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                    SnapshotStateList<ImagePreviewItemState> dataSource = $imagePreviewState.getDataSource();
                    boolean z2 = z;
                    int $i$f$indexOfFirst = $imagePreviewState.getCurrentIndex();
                    if (Intrinsics.areEqual(identifier, ((ImagePreviewItemState) dataSource.get($i$f$indexOfFirst)).getAsset().getIdentifier())) {
                        i = index$iv;
                        break;
                    }
                    index$iv++;
                    $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                    z = z2;
                }
                ComposerKt.sourceInformationMarkerStart($composer, -215775485, "CC(remember):PreviewPageContent.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed(album) | $composer.changed($imagePreviewState) | $composer.changedInstance($aphroViewModel);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit PreviewPageContent$lambda$4$11$1$0;
                            PreviewPageContent$lambda$4$11$1$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$11$1$0($scope, album, $imagePreviewState, $aphroViewModel);
                            return PreviewPageContent$lambda$4$11$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 function0 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -215743334, "CC(remember):PreviewPageContent.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changed(album) | $composer.changed($imagePreviewState) | $composer.changedInstance($aphroViewModel);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit PreviewPageContent$lambda$4$11$2$0;
                        PreviewPageContent$lambda$4$11$2$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$11$2$0($scope, album, $imagePreviewState, $aphroViewModel);
                        return PreviewPageContent$lambda$4$11$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                Function0 function02 = (Function0) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -215710163, "CC(remember):PreviewPageContent.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance($transitionState);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit PreviewPageContent$lambda$4$11$3$0;
                            PreviewPageContent$lambda$4$11$3$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$11$3$0($scope, $transitionState);
                            return PreviewPageContent$lambda$4$11$3$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                GalleryPreviewHeaderKt.GalleryPreviewHeader(function0, function02, it, (Function0) it$iv3, i, $composer, ($dirty2 << 6) & 896, 0);
            } else {
                $composer.startReplaceGroup(1892148343);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$11$1$0(CoroutineScope $scope, AphroState.AphroContent $album, ImagePreviewState $imagePreviewState, AphroViewModel $aphroViewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PreviewPageContentKt$PreviewPageContent$1$9$2$1$1($album, $imagePreviewState, $aphroViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$11$2$0(CoroutineScope $scope, AphroState.AphroContent $album, ImagePreviewState $imagePreviewState, AphroViewModel $aphroViewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PreviewPageContentKt$PreviewPageContent$1$9$3$1$1($album, $imagePreviewState, $aphroViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$11$3$0(CoroutineScope $scope, TransitionState $transitionState) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PreviewPageContentKt$PreviewPageContent$1$9$4$1$1($transitionState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010b, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0151, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit PreviewPageContent$lambda$4$12(final ImagePreviewState $imagePreviewState, final CoroutineScope $scope, final AphroViewModel $aphroViewModel, final TransitionState $transitionState, State $albumState$delegate, final MutableState $dataSourceState$delegate, Modifier it, Composer $composer, int $changed) {
        AphroAssetsState.AphroContent assetsState;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)240@11585L33:PreviewPageContent.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1517137428, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.PreviewPageContent.<anonymous>.<anonymous> (PreviewPageContent.kt:237)");
            }
            AphroState PreviewPageContent$lambda$4$7 = PreviewPageContent$lambda$4$7($albumState$delegate);
            final AphroState.AphroContent album = PreviewPageContent$lambda$4$7 instanceof AphroState.AphroContent ? (AphroState.AphroContent) PreviewPageContent$lambda$4$7 : null;
            AphroAssetsState assetsState2 = album != null ? album.getAssetsState() : null;
            final AphroAssetsState.AphroContent assetsState3 = assetsState2 instanceof AphroAssetsState.AphroContent ? (AphroAssetsState.AphroContent) assetsState2 : null;
            ComposerKt.sourceInformationMarkerStart($composer, -1975146515, "CC(remember):PreviewPageContent.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState isAllDataSource$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (album == null || assetsState3 == null) {
                $composer.startReplaceGroup(-1111494154);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-1099729933);
                ComposerKt.sourceInformation($composer, "246@11957L208,268@13323L185,252@12313L951,272@13568L2392,242@11723L4323");
                ComposerKt.sourceInformationMarkerStart($composer, -1975134436, "CC(remember):PreviewPageContent.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($aphroViewModel);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit PreviewPageContent$lambda$4$12$3$0;
                            PreviewPageContent$lambda$4$12$3$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$12$3$0($scope, $aphroViewModel, (AphroAction) obj);
                            return PreviewPageContent$lambda$4$12$3$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 function1 = (Function1) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1975090747, "CC(remember):PreviewPageContent.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance($transitionState);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit PreviewPageContent$lambda$4$12$4$0;
                        PreviewPageContent$lambda$4$12$4$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$12$4$0(TransitionState.this);
                        return PreviewPageContent$lambda$4$12$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                Function0 function0 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1975122301, "CC(remember):PreviewPageContent.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changed(assetsState3) | $composer.changed($imagePreviewState) | $composer.changedInstance($aphroViewModel);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv4 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit PreviewPageContent$lambda$4$12$5$0;
                        PreviewPageContent$lambda$4$12$5$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$12$5$0($scope, assetsState3, $imagePreviewState, $aphroViewModel);
                        return PreviewPageContent$lambda$4$12$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                Function0 function02 = (Function0) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1975080700, "CC(remember):PreviewPageContent.kt#9igjgp");
                boolean invalid$iv4 = $composer.changed(album) | $composer.changed($imagePreviewState) | $composer.changedInstance($scope);
                Object value$iv5 = $composer.rememberedValue();
                if (invalid$iv4 || value$iv5 == Composer.Companion.getEmpty()) {
                    assetsState = assetsState3;
                    value$iv5 = new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PreviewPageContent$lambda$4$12$6$0;
                            PreviewPageContent$lambda$4$12$6$0 = PreviewPageContentKt.PreviewPageContent$lambda$4$12$6$0(AphroState.AphroContent.this, $scope, isAllDataSource$delegate, $imagePreviewState, $dataSourceState$delegate, ((Integer) obj).intValue(), (Asset) obj2);
                            return PreviewPageContent$lambda$4$12$6$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                } else {
                    assetsState = assetsState3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                GalleryPreviewFooterKt.GalleryPreviewFooter(album, $imagePreviewState, true, true, function1, function0, function02, (Function2) value$iv5, it, $composer, (($dirty2 << 24) & 234881024) | 3456, 0);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final boolean PreviewPageContent$lambda$4$12$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void PreviewPageContent$lambda$4$12$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$12$3$0(CoroutineScope $scope, AphroViewModel $aphroViewModel, AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PreviewPageContentKt$PreviewPageContent$1$10$1$1$1($aphroViewModel, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$12$5$0(CoroutineScope $scope, AphroAssetsState.AphroContent $assetsState, ImagePreviewState $imagePreviewState, AphroViewModel $aphroViewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PreviewPageContentKt$PreviewPageContent$1$10$3$1$1($assetsState, $imagePreviewState, $aphroViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$12$4$0(TransitionState $transitionState) {
        $transitionState.getAnimationPhase().setValue(AnimationPhase.Exiting);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPageContent$lambda$4$12$6$0(AphroState.AphroContent $album, CoroutineScope $scope, MutableState $isAllDataSource$delegate, ImagePreviewState $imagePreviewState, MutableState $dataSourceState$delegate, int currentSelectIndex, Asset asset) {
        Object obj;
        IntRect intRect;
        PreviewableAsset asset2;
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (PreviewPageContent$lambda$4$12$1($isAllDataSource$delegate)) {
            Iterable $this$map$iv = $album.getSelected();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Asset it = (Asset) item$iv$iv;
                Iterator it2 = $imagePreviewState.getDataSource().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    ImagePreviewItemState it3 = (ImagePreviewItemState) obj;
                    if (Intrinsics.areEqual(it3.getAsset().getIdentifier(), asset.getIdentifier())) {
                        break;
                    }
                }
                ImagePreviewItemState imagePreviewItemState = (ImagePreviewItemState) obj;
                if (imagePreviewItemState == null || (asset2 = imagePreviewItemState.getAsset()) == null) {
                    intRect = null;
                } else {
                    intRect = asset2.getThumbnailRect();
                }
                destination$iv$iv.add(PreviewableAssetKt.asPreviewableAsset$default(it, null, intRect, false, 5, null));
            }
            List $this$indexOfFirst$iv = (List) destination$iv$iv;
            int index$iv = 0;
            Iterator it4 = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (it4.hasNext()) {
                    Object item$iv = it4.next();
                    PreviewableAsset it5 = (PreviewableAsset) item$iv;
                    if (Intrinsics.areEqual(it5.getIdentifier(), asset.getIdentifier())) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
            int index = index$iv;
            $dataSourceState$delegate.setValue(PreviewPageContent$lambda$1($dataSourceState$delegate).copy($this$indexOfFirst$iv, index));
            PreviewPageContent$lambda$4$12$2($isAllDataSource$delegate, false);
        } else {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PreviewPageContentKt$PreviewPageContent$1$10$4$1$1($imagePreviewState, asset, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }
}