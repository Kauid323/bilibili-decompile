package kntr.common.ouro.common.ui.toolPanel.picture;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntRect;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AssetItemState;
import kntr.common.photonic.aphro.core.ToastData;
import kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt;
import kntr.common.photonic.aphro.ui.component.MediaSelectContentKt;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.PermissionStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PictureSelector.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182&\b\u0002\u0010\u0019\u001a \u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0004\u0012\u00020\u00010\u001aH\u0001¢\u0006\u0002\u0010\u001f¨\u0006 ²\u0006\n\u0010!\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"PictureSelector", "", "permissionState", "Lkntr/common/photonic/permission/BPermissionState;", "state", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;", "albums", "Lkntr/common/photonic/aphro/core/AphroState;", "progress", "", "onDismissRequest", "Lkotlin/Function0;", "onSelectChange", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroSelection;", "onShootPictureClick", "onAction", "Lkntr/common/photonic/aphro/core/AphroAction;", "onClickSelectMore", "onPicturePermissionGrant", "platformContext", "Landroid/app/Activity;", "Lkntr/common/photonic/permission/PlatformContext;", "showSelectIndex", "", "onAssetItemClick", "Lkotlin/Function3;", "", "Lkntr/common/photonic/aphro/core/AssetItemState;", "", "Landroidx/compose/ui/unit/IntRect;", "(Lkntr/common/photonic/permission/BPermissionState;Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;Lkntr/common/photonic/aphro/core/AphroState;FLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroid/app/Activity;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ui_debug", "albumExpanded"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PictureSelectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelector$lambda$5(BPermissionState bPermissionState, ExpandablePanelState expandablePanelState, AphroState aphroState, float f, Function0 function0, Function1 function1, Function0 function02, Function1 function12, Function0 function03, Function0 function04, Activity activity, boolean z, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        PictureSelector(bPermissionState, expandablePanelState, aphroState, f, function0, function1, function02, function12, function03, function04, activity, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelector$lambda$0$0(int i, AssetItemState assetItemState, List list) {
        Intrinsics.checkNotNullParameter(assetItemState, "<unused var>");
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x040d, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L128;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PictureSelector(final BPermissionState permissionState, final ExpandablePanelState state, final AphroState albums, final float progress, final Function0<Unit> function0, final Function1<? super AphroSelection, Unit> function1, final Function0<Unit> function02, final Function1<? super AphroAction, Unit> function12, final Function0<Unit> function03, final Function0<Unit> function04, final Activity platformContext, boolean showSelectIndex, Function3<? super Integer, ? super AssetItemState, ? super List<IntRect>, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function3<? super Integer, ? super AssetItemState, ? super List<IntRect>, Unit> function32;
        boolean showSelectIndex2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer2;
        BPermissionState bPermissionState;
        CoroutineScope scope;
        Composer $composer3;
        State onPicturePermissionGrant;
        Intrinsics.checkNotNullParameter(permissionState, "permissionState");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(albums, "albums");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function1, "onSelectChange");
        Intrinsics.checkNotNullParameter(function02, "onShootPictureClick");
        Intrinsics.checkNotNullParameter(function12, "onAction");
        Intrinsics.checkNotNullParameter(function03, "onClickSelectMore");
        Intrinsics.checkNotNullParameter(function04, "onPicturePermissionGrant");
        Intrinsics.checkNotNullParameter(platformContext, "platformContext");
        Composer $composer4 = $composer.startRestartGroup(-1237785656);
        ComposerKt.sourceInformation($composer4, "C(PictureSelector)N(permissionState,state,albums,progress,onDismissRequest,onSelectChange,onShootPictureClick,onAction,onClickSelectMore,onPicturePermissionGrant,platformContext,showSelectIndex,onAssetItemClick)43@1916L14,45@1961L46,48@2043L46,49@2106L24,50@2135L1759:PictureSelector.kt#fednps");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(permissionState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(albums) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(progress) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer4.changedInstance(function02) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer4.changedInstance(function12) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer4.changedInstance(function03) ? 67108864 : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer4.changedInstance(function04) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer4.changedInstance(platformContext) ? 4 : 2;
        }
        int i2 = i & 2048;
        if (i2 != 0) {
            $dirty1 |= 48;
            z = showSelectIndex;
        } else if (($changed1 & 48) == 0) {
            z = showSelectIndex;
            $dirty1 |= $composer4.changed(z) ? 32 : 16;
        } else {
            z = showSelectIndex;
        }
        int $dirty12 = $dirty1;
        int i3 = i & 4096;
        if (i3 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty12 |= $composer4.changedInstance(function3) ? 256 : 128;
        }
        if ($composer4.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty12 & 147) == 146) ? false : true, $dirty & 1)) {
            showSelectIndex2 = i2 != 0 ? true : z;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 193942006, "CC(remember):PictureSelector.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit PictureSelector$lambda$0$0;
                            PictureSelector$lambda$0$0 = PictureSelectorKt.PictureSelector$lambda$0$0(((Integer) obj).intValue(), (AssetItemState) obj2, (List) obj3);
                            return PictureSelector$lambda$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                function32 = it$iv;
            } else {
                function32 = function3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1237785656, $dirty, $dirty12, "kntr.common.ouro.common.ui.toolPanel.picture.PictureSelector (PictureSelector.kt:44)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, 193943478, "CC(remember):PictureSelector.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState albumExpanded$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            State onPicturePermissionGrant2 = SnapshotStateKt.rememberUpdatedState(function04, $composer4, ($dirty >> 27) & 14);
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer4.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope2 = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1529943468, "C:PictureSelector.kt#fednps");
            if (((PermissionStatus) permissionState.getCurrentStatus().getValue()).isGranted()) {
                $composer4.startReplaceGroup(-1529916065);
                ComposerKt.sourceInformation($composer4, "");
                if (albums instanceof AphroState.AphroContent) {
                    $composer4.startReplaceGroup(-1529848578);
                    ComposerKt.sourceInformation($composer4, "66@2855L22,62@2688L66,56@2345L822");
                    AphroState.AphroContent aphroContent = (AphroState.AphroContent) albums;
                    ExpandablePanelState.Style style = (ExpandablePanelState.Style) state.getAnchoredDraggableState().getCurrentValue();
                    boolean PictureSelector$lambda$2 = PictureSelector$lambda$2(albumExpanded$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1988997084, "CC(remember):PictureSelector.kt#9igjgp");
                    Object value$iv3 = $composer4.rememberedValue();
                    if (value$iv3 == Composer.Companion.getEmpty()) {
                        value$iv3 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit PictureSelector$lambda$4$0$0;
                                PictureSelector$lambda$4$0$0 = PictureSelectorKt.PictureSelector$lambda$4$0$0(albumExpanded$delegate, ((Boolean) obj).booleanValue());
                                return PictureSelector$lambda$4$0$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                    }
                    Function1 function13 = (Function1) value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1989002384, "CC(remember):PictureSelector.kt#9igjgp");
                    boolean invalid$iv = (57344 & $dirty) == 16384;
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv4 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit PictureSelector$lambda$4$1$0;
                            PictureSelector$lambda$4$1$0 = PictureSelectorKt.PictureSelector$lambda$4$1$0(function0);
                            return PictureSelector$lambda$4$1$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv3 = value$iv4;
                    int $dirty2 = $dirty;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer$iv = $composer4;
                    onPicturePermissionGrant = onPicturePermissionGrant2;
                    scope = scope2;
                    $composer3 = $composer4;
                    PictureSelectorContentKt.PictureSelectorContent(aphroContent, progress, style, permissionState, PictureSelector$lambda$2, function13, function12, function1, showSelectIndex2, null, (Function0) it$iv3, function03, function32, function02, $composer4, (($dirty2 >> 6) & 14) | 196608 | (($dirty2 >> 6) & 112) | (($dirty2 << 9) & 7168) | (3670016 & ($dirty2 >> 3)) | (($dirty2 << 6) & 29360128) | (($dirty12 << 21) & 234881024), (($dirty2 >> 21) & 112) | ($dirty12 & 896) | (($dirty2 >> 9) & 7168), 512);
                    $composer4.endReplaceGroup();
                    $composer2 = $composer4;
                } else {
                    $composer$iv = $composer4;
                    scope = scope2;
                    $composer3 = $composer4;
                    onPicturePermissionGrant = onPicturePermissionGrant2;
                    $composer2 = $composer4;
                    $composer2.startReplaceGroup(-1532201292);
                    $composer2.endReplaceGroup();
                }
                $composer2.endReplaceGroup();
                $composer4 = $composer3;
            } else {
                $composer$iv = $composer4;
                int $dirty3 = $dirty;
                $composer2 = $composer4;
                if (permissionState.getCurrentStatus().getValue() == PermissionStatus.Undetermined) {
                    $composer2.startReplaceGroup(-1528947067);
                    ComposerKt.sourceInformation($composer2, "75@3317L215,75@3285L247");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1988982107, "CC(remember):PictureSelector.kt#9igjgp");
                    $composer4 = $composer4;
                    boolean invalid$iv2 = $composer4.changed(onPicturePermissionGrant2) | (($dirty3 & 14) == 4);
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                        bPermissionState = permissionState;
                        Object value$iv5 = (Function2) new PictureSelectorKt$PictureSelector$2$3$1(bPermissionState, onPicturePermissionGrant2, null);
                        $composer2.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                    } else {
                        bPermissionState = permissionState;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(bPermissionState, (Function2) it$iv4, $composer2, $dirty3 & 14);
                    $composer2.endReplaceGroup();
                } else {
                    $composer4 = $composer4;
                    $composer2.startReplaceGroup(-1528657000);
                    ComposerKt.sourceInformation($composer2, "86@3717L146,83@3562L316");
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1988969376, "CC(remember):PictureSelector.kt#9igjgp");
                    boolean invalid$iv3 = $composer4.changedInstance(scope2) | $composer4.changedInstance(platformContext);
                    Object it$iv5 = $composer2.rememberedValue();
                    if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit PictureSelector$lambda$4$3$0;
                                PictureSelector$lambda$4$3$0 = PictureSelectorKt.PictureSelector$lambda$4$3$0(scope2, platformContext);
                                return PictureSelector$lambda$4$3$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv5 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MediaSelectContentKt.PictureSelectNotAuthorized(fillMaxSize$default, progress, (Function0) it$iv5, $composer2, (($dirty3 >> 6) & 112) | 6, 0);
                    $composer2.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (albums instanceof AphroState.AphroContent) {
                $composer4.startReplaceGroup(1719242421);
                ComposerKt.sourceInformation($composer4, "96@3949L21");
                MediaSelectBottomSheetKt.Toaster(((AphroState.AphroContent) albums).getToast(), $composer4, ToastData.$stable);
            } else {
                $composer4.startReplaceGroup(1715332794);
            }
            $composer4.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer4.skipToGroupEnd();
            function32 = function3;
            showSelectIndex2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = showSelectIndex2;
            final Function3<? super Integer, ? super AssetItemState, ? super List<IntRect>, Unit> function33 = function32;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit PictureSelector$lambda$5;
                    PictureSelector$lambda$5 = PictureSelectorKt.PictureSelector$lambda$5(BPermissionState.this, state, albums, progress, function0, function1, function02, function12, function03, function04, platformContext, z2, function33, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PictureSelector$lambda$5;
                }
            });
        }
    }

    private static final boolean PictureSelector$lambda$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void PictureSelector$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelector$lambda$4$1$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelector$lambda$4$0$0(MutableState $albumExpanded$delegate, boolean it) {
        PictureSelector$lambda$3($albumExpanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelector$lambda$4$3$0(CoroutineScope $scope, Activity $platformContext) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PictureSelectorKt$PictureSelector$2$4$1$1($platformContext, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}