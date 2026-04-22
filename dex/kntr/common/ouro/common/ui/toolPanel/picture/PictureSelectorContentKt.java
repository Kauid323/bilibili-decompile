package kntr.common.ouro.common.ui.toolPanel.picture;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AssetItemState;
import kntr.common.photonic.aphro.ui.MediaSelectFloatKt;
import kntr.common.photonic.aphro.ui.component.AlbumListKt;
import kntr.common.photonic.aphro.ui.component.MediaListKt;
import kntr.common.photonic.aphro.ui.component.MediaSelectContentKt;
import kntr.common.photonic.aphro.ui.component.OriginalImageBarKt;
import kntr.common.photonic.aphro.ui.component.SelectedListKt;
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

/* compiled from: PictureSelectorContent.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162&\b\u0002\u0010\u0018\u001a \u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0004\u0012\u00020\u00010\u00192\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0001¢\u0006\u0002\u0010\u001f¨\u0006 ²\u0006\n\u0010!\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u001aX\u008a\u008e\u0002"}, d2 = {"PictureSelectorContent", "", "albums", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "progress", "", "anchoredDraggableCurrentValue", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;", "permissionState", "Lkntr/common/photonic/permission/BPermissionState;", "albumExpanded", "", "onAlbumExpandChange", "Lkotlin/Function1;", "onAction", "Lkntr/common/photonic/aphro/core/AphroAction;", "onSelectChange", "Lkntr/common/photonic/aphro/core/AphroSelection;", "showSelectIndex", "modifier", "Landroidx/compose/ui/Modifier;", "onBackButtonClick", "Lkotlin/Function0;", "onClickSelectMore", "onAssetItemClick", "Lkotlin/Function3;", "", "Lkntr/common/photonic/aphro/core/AssetItemState;", "", "Landroidx/compose/ui/unit/IntRect;", "onShootPictureClick", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;FLkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;Lkntr/common/photonic/permission/BPermissionState;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "ui_debug", "originCheckboxAlpha", "albumListHeight"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PictureSelectorContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectorContent$lambda$17(AphroState.AphroContent aphroContent, float f, ExpandablePanelState.Style style, BPermissionState bPermissionState, boolean z, Function1 function1, Function1 function12, Function1 function13, boolean z2, Modifier modifier, Function0 function0, Function0 function02, Function3 function3, Function0 function03, int i, int i2, int i3, Composer composer, int i4) {
        PictureSelectorContent(aphroContent, f, style, bPermissionState, z, function1, function12, function13, z2, modifier, function0, function02, function3, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectorContent$lambda$2$0(int i, AssetItemState assetItemState, List list) {
        Intrinsics.checkNotNullParameter(assetItemState, "<unused var>");
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:198:0x0417, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0525, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L161;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x07ef  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x08e6  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x08f2  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x08f8  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0978  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x09a0  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0a2b  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0a37  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0a3b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0b0f  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0b11  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0b1e  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0c08  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0c0a  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0c11  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0c1e  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0d7c  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0d8a  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0dab  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0e1d  */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PictureSelectorContent(final AphroState.AphroContent albums, final float progress, final ExpandablePanelState.Style anchoredDraggableCurrentValue, final BPermissionState permissionState, final boolean albumExpanded, final Function1<? super Boolean, Unit> function1, final Function1<? super AphroAction, Unit> function12, final Function1<? super AphroSelection, Unit> function13, final boolean showSelectIndex, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Function3<? super Integer, ? super AssetItemState, ? super List<IntRect>, Unit> function3, Function0<Unit> function03, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Function0<Unit> function04;
        Function0 onClickSelectMore;
        Function3 onAssetItemClick;
        Function0 onShootPictureClick;
        Function0 onClickSelectMore2;
        AphroSelection selectState;
        boolean invalid$iv;
        Object it$iv;
        Object it$iv2;
        AphroSelection selectState2;
        boolean invalid$iv2;
        Object it$iv3;
        Object it$iv4;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Object it$iv5;
        Animatable bottomBarAnimation;
        Function0 onClickSelectMore3;
        Composer $composer$iv;
        int $dirty;
        int $dirty1;
        Animatable albumListAnimation;
        Composer $composer$iv$iv$iv;
        Modifier materialized$iv$iv;
        MutableIntState albumListHeight$delegate;
        String str;
        String str2;
        int $changed$iv;
        final Function1<? super AphroAction, Unit> function14;
        Composer $composer$iv2;
        Composer $composer3;
        Composer $composer$iv3;
        Function0 factory$iv$iv$iv;
        Modifier materialized$iv$iv2;
        MeasurePolicy measurePolicy$iv$iv;
        Function0 onClickSelectMore4;
        boolean invalid$iv5;
        Object it$iv6;
        boolean invalid$iv6;
        Object it$iv7;
        Object it$iv8;
        final MutableIntState albumListHeight$delegate2;
        boolean invalid$iv7;
        Object it$iv9;
        Intrinsics.checkNotNullParameter(albums, "albums");
        Intrinsics.checkNotNullParameter(anchoredDraggableCurrentValue, "anchoredDraggableCurrentValue");
        Intrinsics.checkNotNullParameter(permissionState, "permissionState");
        Intrinsics.checkNotNullParameter(function1, "onAlbumExpandChange");
        Intrinsics.checkNotNullParameter(function12, "onAction");
        Intrinsics.checkNotNullParameter(function13, "onSelectChange");
        Composer $composer4 = $composer.startRestartGroup(-577734299);
        ComposerKt.sourceInformation($composer4, "C(PictureSelectorContent)N(albums,progress,anchoredDraggableCurrentValue,permissionState,albumExpanded,onAlbumExpandChange,onAction,onSelectChange,showSelectIndex,modifier,onBackButtonClick,onClickSelectMore,onAssetItemClick,onShootPictureClick)64@2983L2,65@3023L2,66@3096L14,67@3150L2,69@3187L36,70@3240L24,73@3296L222,80@3552L76,80@3524L104,86@3700L213,93@3989L14,93@4004L17,94@4114L27,95@4216L815,95@4146L885,120@5131L27,121@5186L33,122@5254L169,122@5224L199,129@5452L162,129@5429L185,139@5674L195,148@5875L4328:PictureSelectorContent.kt#fednps");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(albums) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(progress) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(anchoredDraggableCurrentValue.ordinal()) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(permissionState) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changed(albumExpanded) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function12) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function13) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty2 |= $composer4.changed(showSelectIndex) ? 67108864 : 33554432;
        }
        int i2 = i & 512;
        if (i2 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer4.changed(modifier) ? 536870912 : 268435456;
        }
        int i3 = i & 1024;
        if (i3 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty12 |= $composer4.changedInstance(function0) ? 4 : 2;
        }
        int i4 = i & 2048;
        if (i4 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty12 |= $composer4.changedInstance(function02) ? 32 : 16;
        }
        int i5 = i & 4096;
        if (i5 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty12 |= $composer4.changedInstance(function3) ? 256 : 128;
        }
        if ($composer4.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty12 & 147) == 146) ? false : true, $dirty2 & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -1151865945, "CC(remember):PictureSelectorContent.kt#9igjgp");
                Object it$iv10 = $composer4.rememberedValue();
                if (it$iv10 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv10 = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                function04 = it$iv10;
            } else {
                function04 = function0;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -1151864665, "CC(remember):PictureSelectorContent.kt#9igjgp");
                Object it$iv11 = $composer4.rememberedValue();
                if (it$iv11 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv11 = value$iv2;
                }
                Function0 onClickSelectMore5 = it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onClickSelectMore2 = onClickSelectMore5;
            } else {
                onClickSelectMore2 = function02;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -1151862317, "CC(remember):PictureSelectorContent.kt#9igjgp");
                Object it$iv12 = $composer4.rememberedValue();
                if (it$iv12 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit PictureSelectorContent$lambda$2$0;
                            PictureSelectorContent$lambda$2$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$2$0(((Integer) obj).intValue(), (AssetItemState) obj2, (List) obj3);
                            return PictureSelectorContent$lambda$2$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv3);
                    it$iv12 = value$iv3;
                }
                Function3 onAssetItemClick2 = it$iv12;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onAssetItemClick = onAssetItemClick2;
            } else {
                onAssetItemClick = function3;
            }
            if ((i & 8192) != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -1151860601, "CC(remember):PictureSelectorContent.kt#9igjgp");
                Object it$iv13 = $composer4.rememberedValue();
                if (it$iv13 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv13 = value$iv4;
                }
                Function0 onShootPictureClick2 = it$iv13;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onShootPictureClick = onShootPictureClick2;
            } else {
                onShootPictureClick = function03;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-577734299, $dirty2, $dirty12, "kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContent (PictureSelectorContent.kt:68)");
            }
            State selectChangeEffect = SnapshotStateKt.rememberUpdatedState(function13, $composer4, ($dirty2 >> 21) & 14);
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer4.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            List<Asset> currentSelected = albums.getCurrentSelected();
            boolean useOriginImage = albums.getUseOriginImage();
            ComposerKt.sourceInformationMarkerStart($composer4, -1151855709, "CC(remember):PictureSelectorContent.kt#9igjgp");
            boolean invalid$iv8 = $composer4.changed(currentSelected) | $composer4.changed(useOriginImage);
            Object it$iv14 = $composer4.rememberedValue();
            if (!invalid$iv8 && it$iv14 != Composer.Companion.getEmpty()) {
                selectState = (AphroSelection) it$iv14;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, -1151847663, "CC(remember):PictureSelectorContent.kt#9igjgp");
                invalid$iv = $composer4.changed(selectChangeEffect) | $composer4.changedInstance(selectState);
                it$iv = $composer4.rememberedValue();
                Function0 onClickSelectMore6 = onClickSelectMore2;
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv5 = (Function2) new PictureSelectorContentKt$PictureSelectorContent$5$1(selectChangeEffect, selectState, null);
                    $composer4.updateRememberedValue(value$iv5);
                    it$iv = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(selectState, (Function2) it$iv, $composer4, AphroSelection.$stable);
                State originCheckboxAlpha$delegate = AnimateAsStateKt.animateFloatAsState((((progress > 0.0f ? 1 : (progress == 0.0f ? 0 : -1)) != 0) || albums.getCurrentSelected().isEmpty()) ? 0.0f : 1.0f, AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), 0.0f, "OriginCheckboxAlpha", (Function1) null, $composer4, 3120, 20);
                float navigationBarHeight = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer4, 6), $composer4, 0).calculateBottomPadding-D9Ej5fM();
                ComposerKt.sourceInformationMarkerStart($composer4, -1151829728, "CC(remember):PictureSelectorContent.kt#9igjgp");
                it$iv2 = $composer4.rememberedValue();
                if (it$iv2 != Composer.Companion.getEmpty()) {
                    selectState2 = selectState;
                    Animatable Animatable$default = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
                    $composer4.updateRememberedValue(Animatable$default);
                    it$iv2 = Animatable$default;
                } else {
                    selectState2 = selectState;
                }
                final Animatable bottomBarAnimation2 = (Animatable) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                List<Asset> currentSelected2 = albums.getCurrentSelected();
                ComposerKt.sourceInformationMarkerStart($composer4, -1151825676, "CC(remember):PictureSelectorContent.kt#9igjgp");
                invalid$iv2 = (($dirty2 & 14) != 4) | (($dirty2 & 896) != 256) | $composer4.changedInstance(bottomBarAnimation2);
                Object it$iv15 = $composer4.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv6 = (Function2) new PictureSelectorContentKt$PictureSelectorContent$6$1(albums, anchoredDraggableCurrentValue, bottomBarAnimation2, null);
                $composer4.updateRememberedValue(value$iv6);
                it$iv15 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(anchoredDraggableCurrentValue, currentSelected2, (Function2) it$iv15, $composer4, ($dirty2 >> 6) & 14);
                ComposerKt.sourceInformationMarkerStart($composer4, -1151797184, "CC(remember):PictureSelectorContent.kt#9igjgp");
                it$iv3 = $composer4.rememberedValue();
                if (it$iv3 != Composer.Companion.getEmpty()) {
                    Object value$iv7 = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
                    $composer4.updateRememberedValue(value$iv7);
                    it$iv3 = value$iv7;
                }
                final Animatable albumListAnimation2 = (Animatable) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, -1151795418, "CC(remember):PictureSelectorContent.kt#9igjgp");
                it$iv4 = $composer4.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = SnapshotIntStateKt.mutableIntStateOf(0);
                    $composer4.updateRememberedValue(value$iv8);
                    it$iv4 = value$iv8;
                }
                MutableIntState albumListHeight$delegate3 = (MutableIntState) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Boolean valueOf = Boolean.valueOf(albumExpanded);
                ComposerKt.sourceInformationMarkerStart($composer4, -1151793106, "CC(remember):PictureSelectorContent.kt#9igjgp");
                invalid$iv3 = $composer4.changedInstance(albumListAnimation2) | ((57344 & $dirty2) != 16384);
                Object it$iv16 = $composer4.rememberedValue();
                if (!invalid$iv3 && it$iv16 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv16, $composer4, ($dirty2 >> 12) & 14);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1151786777, "CC(remember):PictureSelectorContent.kt#9igjgp");
                    invalid$iv4 = $composer4.changedInstance(scope) | $composer4.changedInstance(bottomBarAnimation2) | $composer4.changedInstance(albumListAnimation2);
                    Object it$iv17 = $composer4.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv9 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            DisposableEffectResult PictureSelectorContent$lambda$14$0;
                            PictureSelectorContent$lambda$14$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$14$0(scope, bottomBarAnimation2, albumListAnimation2, (DisposableEffectScope) obj);
                            return PictureSelectorContent$lambda$14$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv9);
                    it$iv17 = value$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EffectsKt.DisposableEffect(unit, (Function1) it$iv17, $composer4, 6);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1151779640, "CC(remember):PictureSelectorContent.kt#9igjgp");
                    it$iv5 = $composer4.rememberedValue();
                    if (it$iv5 != Composer.Companion.getEmpty()) {
                        bottomBarAnimation = bottomBarAnimation2;
                        Object value$iv10 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit PictureSelectorContent$lambda$15$0;
                                PictureSelectorContent$lambda$15$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$15$0(function1, function12, (AphroAction) obj);
                                return PictureSelectorContent$lambda$15$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv10);
                        it$iv5 = value$iv10;
                    } else {
                        bottomBarAnimation = bottomBarAnimation2;
                    }
                    Function1 actionDispatcher = (Function1) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    int $changed$iv2 = ($dirty2 >> 27) & 14;
                    Modifier modifier$iv = modifier2;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
                    int $changed$iv$iv = ($changed$iv2 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.useNode();
                    } else {
                        $composer4.createNode(factory$iv$iv$iv2);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i6 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    int i7 = (($changed$iv2 >> 6) & 112) | 6;
                    ColumnScope $this$PictureSelectorContent_u24lambda_u2416 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1784722952, "C162@6348L3849:PictureSelectorContent.kt#fednps");
                    if (progress != 0.0f) {
                        $composer4.startReplaceGroup(-1784810218);
                        ComposerKt.sourceInformation($composer4, "151@5999L6,150@5947L381");
                        $dirty = $dirty2;
                        $dirty1 = $dirty12;
                        $composer$iv = $composer4;
                        $composer2 = $composer4;
                        str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        albumListHeight$delegate = albumListHeight$delegate3;
                        $composer$iv2 = $composer4;
                        albumListAnimation = albumListAnimation2;
                        $composer$iv$iv$iv = $composer4;
                        materialized$iv$iv = materialized$iv$iv3;
                        function14 = function12;
                        onClickSelectMore3 = onClickSelectMore6;
                        str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        $changed$iv = -1159599143;
                        MediaSelectFloatKt.m2241MediaFloatTopBarpzZJ40c(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), progress, albums, null, albumExpanded, function1, function04, ClipKt.clipToBounds(Modifier.Companion), $composer4, ($dirty2 & 112) | 12585984 | (($dirty2 << 6) & 896) | (57344 & $dirty2) | (458752 & $dirty2) | (($dirty12 << 18) & 3670016), 0);
                        $composer4.endReplaceGroup();
                        $composer3 = $composer4;
                    } else {
                        onClickSelectMore3 = onClickSelectMore6;
                        $composer$iv = $composer4;
                        $dirty = $dirty2;
                        $dirty1 = $dirty12;
                        albumListAnimation = albumListAnimation2;
                        $composer$iv$iv$iv = $composer4;
                        materialized$iv$iv = materialized$iv$iv3;
                        albumListHeight$delegate = albumListHeight$delegate3;
                        $composer2 = $composer4;
                        str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        $changed$iv = -1159599143;
                        function14 = function12;
                        $composer$iv2 = $composer4;
                        $composer3 = $composer4;
                        $composer3.startReplaceGroup(-1790722445);
                        $composer3.endReplaceGroup();
                    }
                    Modifier modifier$iv2 = ClipKt.clipToBounds(ColumnScope.-CC.weight$default($this$PictureSelectorContent_u24lambda_u2416, Modifier.Companion, 1.0f, false, 2, (Object) null));
                    $composer$iv3 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv2 = (0 << 3) & 112;
                    String str3 = str;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, $changed$iv, str3);
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2);
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    String str4 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str4);
                    if (!($composer$iv3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv3.startReusableNode();
                    if ($composer$iv3.getInserting()) {
                        $composer$iv3.useNode();
                    } else {
                        $composer$iv3.createNode(factory$iv$iv$iv3);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i9 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -2017075140, "C163@6413L3314,239@9886L31,240@9950L69,241@10065L6,235@9741L446:PictureSelectorContent.kt#fednps");
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Modifier modifier$iv3 = Modifier.Companion;
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer$iv3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv3 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str3);
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer$iv3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv3);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str4);
                    if (!($composer$iv3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv3.startReusableNode();
                    if ($composer$iv3.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer$iv3.useNode();
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer$iv3.createNode(factory$iv$iv$iv);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    int i11 = ((0 >> 6) & 112) | 6;
                    ColumnScope $this$PictureSelectorContent_u24lambda_u2416_u240_u240 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1819493945, "C174@6857L2856:PictureSelectorContent.kt#fednps");
                    if (permissionState.getCurrentStatus().getValue() != PermissionStatus.Limited) {
                        $composer$iv3.startReplaceGroup(-1819516731);
                        ComposerKt.sourceInformation($composer$iv3, "168@6659L162");
                        materialized$iv$iv2 = materialized$iv$iv5;
                        measurePolicy$iv$iv = measurePolicy$iv3;
                        onClickSelectMore4 = onClickSelectMore3;
                        MediaSelectContentKt.PartialSelectBar(onClickSelectMore4, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer$iv3, (($dirty1 >> 3) & 14) | 48, 0);
                    } else {
                        materialized$iv$iv2 = materialized$iv$iv5;
                        measurePolicy$iv$iv = measurePolicy$iv3;
                        onClickSelectMore4 = onClickSelectMore3;
                        $composer$iv3.startReplaceGroup(-1826107889);
                    }
                    $composer$iv3.endReplaceGroup();
                    Modifier modifier$iv4 = $this$PictureSelectorContent_u24lambda_u2416_u240_u240.weight(Modifier.Companion, 1.0f, true);
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv4 = (0 << 3) & 112;
                    Function0 onClickSelectMore7 = onClickSelectMore4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str3);
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer$iv3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv4);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str4);
                    if (!($composer$iv3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv3.startReusableNode();
                    if ($composer$iv3.getInserting()) {
                        $composer$iv3.useNode();
                    } else {
                        $composer$iv3.createNode(factory$iv$iv$iv5);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i13 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -195455289, "C181@7270L14,181@7285L17,182@7364L82,175@6928L1244,204@8345L126,201@8194L409,210@8625L567,222@9213L482:PictureSelectorContent.kt#fednps");
                    Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS) + navigationBarHeight), Dp.constructor-impl(0), ((Number) bottomBarAnimation.getValue()).floatValue()), 7, (Object) null);
                    float f = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer$iv3, 6), $composer$iv3, 0).calculateBottomPadding-D9Ej5fM();
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517726911, "CC(remember):PictureSelectorContent.kt#9igjgp");
                    invalid$iv5 = ($dirty & 3670016) != 1048576;
                    it$iv6 = $composer$iv3.rememberedValue();
                    if (!invalid$iv5 || it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj) {
                                Unit PictureSelectorContent$lambda$16$0$0$0$0$0;
                                PictureSelectorContent$lambda$16$0$0$0$0$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$0$0(function14, (AphroAction) obj);
                                return PictureSelectorContent$lambda$16$0$0$0$0$0;
                            }
                        };
                        $composer$iv3.updateRememberedValue(value$iv11);
                        it$iv6 = value$iv11;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    onClickSelectMore = onClickSelectMore7;
                    Composer $composer5 = $composer3;
                    final Function1<? super AphroAction, Unit> function15 = function14;
                    MediaListKt.m2263GridMediaListaqv2aB4(albums, (Function1) it$iv6, modifier3, null, null, false, onAssetItemClick, showSelectIndex, null, f, $composer$iv3, ($dirty & 14) | (($dirty1 << 12) & 3670016) | (($dirty >> 3) & 29360128), 312);
                    float PictureSelectorContent$lambda$6 = PictureSelectorContent$lambda$6(originCheckboxAlpha$delegate);
                    Modifier modifier4 = PaddingKt.padding-qDBjuR0$default($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(40), 3, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517758347, "CC(remember):PictureSelectorContent.kt#9igjgp");
                    invalid$iv6 = (($dirty & 3670016) != 1048576) | (($dirty & 14) == 4);
                    it$iv7 = $composer$iv3.rememberedValue();
                    if (!invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv12 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit PictureSelectorContent$lambda$16$0$0$0$1$0;
                                PictureSelectorContent$lambda$16$0$0$0$1$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$1$0(function15, albums);
                                return PictureSelectorContent$lambda$16$0$0$0$1$0;
                            }
                        };
                        $composer$iv3.updateRememberedValue(value$iv12);
                        it$iv7 = value$iv12;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    MediaSelectFloatKt.OriginCheckBox(albums, PictureSelectorContent$lambda$6, (Function0) it$iv7, modifier4, $composer$iv3, $dirty & 14, 0);
                    SelectedListKt.SelectedList(albums, function12, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(76)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight)), Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(76) + Dp.constructor-impl(44)) + navigationBarHeight), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), false, false, null, $composer$iv3, ($dirty & 14) | (($dirty >> 15) & 112), 56);
                    OriginalImageBarKt.OriginalImageBar(function12, albums, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(44)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-navigationBarHeight), Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), $composer$iv3, (($dirty >> 18) & 14) | (($dirty << 3) & 112), 0);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034790872, "CC(remember):PictureSelectorContent.kt#9igjgp");
                    it$iv8 = $composer$iv3.rememberedValue();
                    if (it$iv8 != Composer.Companion.getEmpty()) {
                        albumListHeight$delegate2 = albumListHeight$delegate;
                        Object value$iv13 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj) {
                                Unit PictureSelectorContent$lambda$16$0$1$0;
                                PictureSelectorContent$lambda$16$0$1$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$1$0(albumListHeight$delegate2, (IntSize) obj);
                                return PictureSelectorContent$lambda$16$0$1$0;
                            }
                        };
                        $composer$iv3.updateRememberedValue(value$iv13);
                        it$iv8 = value$iv13;
                    } else {
                        albumListHeight$delegate2 = albumListHeight$delegate;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(fillMaxSize$default, (Function1) it$iv8);
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034788786, "CC(remember):PictureSelectorContent.kt#9igjgp");
                    final Animatable albumListAnimation3 = albumListAnimation;
                    invalid$iv7 = $composer$iv3.changedInstance(albumListAnimation3);
                    it$iv9 = $composer$iv3.rememberedValue();
                    if (!invalid$iv7 || it$iv9 == Composer.Companion.getEmpty()) {
                        Object value$iv14 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                IntOffset PictureSelectorContent$lambda$16$0$2$0;
                                PictureSelectorContent$lambda$16$0$2$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$2$0(albumListAnimation3, albumListHeight$delegate2, (Density) obj);
                                return PictureSelectorContent$lambda$16$0$2$0;
                            }
                        };
                        $composer$iv3.updateRememberedValue(value$iv14);
                        it$iv9 = value$iv14;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    AlbumListKt.m2251AlbumListpHQ97Tc(BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getBg1_float-0d7_KjU(), albums.getAlbumList(), actionDispatcher, OffsetKt.offset(onSizeChanged, (Function1) it$iv9), 0.0f, $composer$iv3, 384, 16);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                Object value$iv15 = (Function2) new PictureSelectorContentKt$PictureSelectorContent$7$1(albumListAnimation2, albumExpanded, null);
                $composer4.updateRememberedValue(value$iv15);
                it$iv16 = value$iv15;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv16, $composer4, ($dirty2 >> 12) & 14);
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -1151786777, "CC(remember):PictureSelectorContent.kt#9igjgp");
                invalid$iv4 = $composer4.changedInstance(scope) | $composer4.changedInstance(bottomBarAnimation2) | $composer4.changedInstance(albumListAnimation2);
                Object it$iv172 = $composer4.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv92 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult PictureSelectorContent$lambda$14$0;
                        PictureSelectorContent$lambda$14$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$14$0(scope, bottomBarAnimation2, albumListAnimation2, (DisposableEffectScope) obj);
                        return PictureSelectorContent$lambda$14$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv92);
                it$iv172 = value$iv92;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.DisposableEffect(unit2, (Function1) it$iv172, $composer4, 6);
                ComposerKt.sourceInformationMarkerStart($composer4, -1151779640, "CC(remember):PictureSelectorContent.kt#9igjgp");
                it$iv5 = $composer4.rememberedValue();
                if (it$iv5 != Composer.Companion.getEmpty()) {
                }
                Function1 actionDispatcher2 = (Function1) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                int $changed$iv22 = ($dirty2 >> 27) & 14;
                Modifier modifier$iv5 = modifier2;
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer4, (($changed$iv22 >> 3) & 14) | (($changed$iv22 >> 3) & 112));
                int $changed$iv$iv5 = ($changed$iv22 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                int i62 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i72 = (($changed$iv22 >> 6) & 112) | 6;
                ColumnScope $this$PictureSelectorContent_u24lambda_u24162 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -1784722952, "C162@6348L3849:PictureSelectorContent.kt#fednps");
                if (progress != 0.0f) {
                }
                Modifier modifier$iv22 = ClipKt.clipToBounds(ColumnScope.-CC.weight$default($this$PictureSelectorContent_u24lambda_u24162, Modifier.Companion, 1.0f, false, 2, (Object) null));
                $composer$iv3 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv22 = (0 << 3) & 112;
                String str32 = str;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, $changed$iv, str32);
                int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv22 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv22);
                Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                String str42 = str2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str42);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                int i82 = ($changed$iv$iv$iv22 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i92 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -2017075140, "C163@6413L3314,239@9886L31,240@9950L69,241@10065L6,235@9741L446:PictureSelectorContent.kt#fednps");
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier$iv32 = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv32 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer$iv3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv32 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str32);
                int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv32 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv32);
                Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str42);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                int i102 = ($changed$iv$iv$iv32 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i112 = ((0 >> 6) & 112) | 6;
                ColumnScope $this$PictureSelectorContent_u24lambda_u2416_u240_u2402 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1819493945, "C174@6857L2856:PictureSelectorContent.kt#fednps");
                if (permissionState.getCurrentStatus().getValue() != PermissionStatus.Limited) {
                }
                $composer$iv3.endReplaceGroup();
                Modifier modifier$iv42 = $this$PictureSelectorContent_u24lambda_u2416_u240_u2402.weight(Modifier.Companion, 1.0f, true);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv22 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                int $changed$iv$iv42 = (0 << 3) & 112;
                Function0 onClickSelectMore72 = onClickSelectMore4;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str32);
                int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv42 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv42);
                Function0 factory$iv$iv$iv52 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str42);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
                int i122 = ($changed$iv$iv$iv42 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i132 = ((0 >> 6) & 112) | 6;
                BoxScope $this$PictureSelectorContent_u24lambda_u2416_u240_u240_u2402 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -195455289, "C181@7270L14,181@7285L17,182@7364L82,175@6928L1244,204@8345L126,201@8194L409,210@8625L567,222@9213L482:PictureSelectorContent.kt#fednps");
                Modifier modifier32 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS) + navigationBarHeight), Dp.constructor-impl(0), ((Number) bottomBarAnimation.getValue()).floatValue()), 7, (Object) null);
                float f2 = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer$iv3, 6), $composer$iv3, 0).calculateBottomPadding-D9Ej5fM();
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517726911, "CC(remember):PictureSelectorContent.kt#9igjgp");
                if (($dirty & 3670016) != 1048576) {
                }
                it$iv6 = $composer$iv3.rememberedValue();
                if (!invalid$iv5) {
                }
                Object value$iv112 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit PictureSelectorContent$lambda$16$0$0$0$0$0;
                        PictureSelectorContent$lambda$16$0$0$0$0$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$0$0(function14, (AphroAction) obj);
                        return PictureSelectorContent$lambda$16$0$0$0$0$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv112);
                it$iv6 = value$iv112;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                onClickSelectMore = onClickSelectMore72;
                Composer $composer52 = $composer3;
                final Function1 function152 = function14;
                MediaListKt.m2263GridMediaListaqv2aB4(albums, (Function1) it$iv6, modifier32, null, null, false, onAssetItemClick, showSelectIndex, null, f2, $composer$iv3, ($dirty & 14) | (($dirty1 << 12) & 3670016) | (($dirty >> 3) & 29360128), 312);
                float PictureSelectorContent$lambda$62 = PictureSelectorContent$lambda$6(originCheckboxAlpha$delegate);
                Modifier modifier42 = PaddingKt.padding-qDBjuR0$default($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u2402.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(40), 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517758347, "CC(remember):PictureSelectorContent.kt#9igjgp");
                invalid$iv6 = (($dirty & 3670016) != 1048576) | (($dirty & 14) == 4);
                it$iv7 = $composer$iv3.rememberedValue();
                if (!invalid$iv6) {
                }
                Object value$iv122 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit PictureSelectorContent$lambda$16$0$0$0$1$0;
                        PictureSelectorContent$lambda$16$0$0$0$1$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$1$0(function152, albums);
                        return PictureSelectorContent$lambda$16$0$0$0$1$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv122);
                it$iv7 = value$iv122;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                MediaSelectFloatKt.OriginCheckBox(albums, PictureSelectorContent$lambda$62, (Function0) it$iv7, modifier42, $composer$iv3, $dirty & 14, 0);
                SelectedListKt.SelectedList(albums, function12, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u2402.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(76)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight)), Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(76) + Dp.constructor-impl(44)) + navigationBarHeight), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), false, false, null, $composer$iv3, ($dirty & 14) | (($dirty >> 15) & 112), 56);
                OriginalImageBarKt.OriginalImageBar(function12, albums, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u2402.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(44)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-navigationBarHeight), Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), $composer$iv3, (($dirty >> 18) & 14) | (($dirty << 3) & 112), 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034790872, "CC(remember):PictureSelectorContent.kt#9igjgp");
                it$iv8 = $composer$iv3.rememberedValue();
                if (it$iv8 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                Modifier onSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(fillMaxSize$default2, (Function1) it$iv8);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034788786, "CC(remember):PictureSelectorContent.kt#9igjgp");
                final Animatable albumListAnimation32 = albumListAnimation;
                invalid$iv7 = $composer$iv3.changedInstance(albumListAnimation32);
                it$iv9 = $composer$iv3.rememberedValue();
                if (!invalid$iv7) {
                }
                Object value$iv142 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        IntOffset PictureSelectorContent$lambda$16$0$2$0;
                        PictureSelectorContent$lambda$16$0$2$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$2$0(albumListAnimation32, albumListHeight$delegate2, (Density) obj);
                        return PictureSelectorContent$lambda$16$0$2$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv142);
                it$iv9 = value$iv142;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                AlbumListKt.m2251AlbumListpHQ97Tc(BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getBg1_float-0d7_KjU(), albums.getAlbumList(), actionDispatcher2, OffsetKt.offset(onSizeChanged2, (Function1) it$iv9), 0.0f, $composer$iv3, 384, 16);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer52);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object value$iv16 = new AphroSelection(albums.getCurrentSelected(), albums.getUseOriginImage());
            $composer4.updateRememberedValue(value$iv16);
            it$iv14 = value$iv16;
            selectState = (AphroSelection) it$iv14;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1151847663, "CC(remember):PictureSelectorContent.kt#9igjgp");
            invalid$iv = $composer4.changed(selectChangeEffect) | $composer4.changedInstance(selectState);
            it$iv = $composer4.rememberedValue();
            Function0 onClickSelectMore62 = onClickSelectMore2;
            if (!invalid$iv) {
            }
            Object value$iv52 = (Function2) new PictureSelectorContentKt$PictureSelectorContent$5$1(selectChangeEffect, selectState, null);
            $composer4.updateRememberedValue(value$iv52);
            it$iv = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(selectState, (Function2) it$iv, $composer4, AphroSelection.$stable);
            State originCheckboxAlpha$delegate2 = AnimateAsStateKt.animateFloatAsState((((progress > 0.0f ? 1 : (progress == 0.0f ? 0 : -1)) != 0) || albums.getCurrentSelected().isEmpty()) ? 0.0f : 1.0f, AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), 0.0f, "OriginCheckboxAlpha", (Function1) null, $composer4, 3120, 20);
            float navigationBarHeight2 = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer4, 6), $composer4, 0).calculateBottomPadding-D9Ej5fM();
            ComposerKt.sourceInformationMarkerStart($composer4, -1151829728, "CC(remember):PictureSelectorContent.kt#9igjgp");
            it$iv2 = $composer4.rememberedValue();
            if (it$iv2 != Composer.Companion.getEmpty()) {
            }
            final Animatable bottomBarAnimation22 = (Animatable) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            List<Asset> currentSelected22 = albums.getCurrentSelected();
            ComposerKt.sourceInformationMarkerStart($composer4, -1151825676, "CC(remember):PictureSelectorContent.kt#9igjgp");
            invalid$iv2 = (($dirty2 & 14) != 4) | (($dirty2 & 896) != 256) | $composer4.changedInstance(bottomBarAnimation22);
            Object it$iv152 = $composer4.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv62 = (Function2) new PictureSelectorContentKt$PictureSelectorContent$6$1(albums, anchoredDraggableCurrentValue, bottomBarAnimation22, null);
            $composer4.updateRememberedValue(value$iv62);
            it$iv152 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(anchoredDraggableCurrentValue, currentSelected22, (Function2) it$iv152, $composer4, ($dirty2 >> 6) & 14);
            ComposerKt.sourceInformationMarkerStart($composer4, -1151797184, "CC(remember):PictureSelectorContent.kt#9igjgp");
            it$iv3 = $composer4.rememberedValue();
            if (it$iv3 != Composer.Companion.getEmpty()) {
            }
            final Animatable albumListAnimation22 = (Animatable) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1151795418, "CC(remember):PictureSelectorContent.kt#9igjgp");
            it$iv4 = $composer4.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
            }
            MutableIntState albumListHeight$delegate32 = (MutableIntState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Boolean valueOf2 = Boolean.valueOf(albumExpanded);
            ComposerKt.sourceInformationMarkerStart($composer4, -1151793106, "CC(remember):PictureSelectorContent.kt#9igjgp");
            invalid$iv3 = $composer4.changedInstance(albumListAnimation22) | ((57344 & $dirty2) != 16384);
            Object it$iv162 = $composer4.rememberedValue();
            if (!invalid$iv3) {
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv162, $composer4, ($dirty2 >> 12) & 14);
                Unit unit22 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -1151786777, "CC(remember):PictureSelectorContent.kt#9igjgp");
                invalid$iv4 = $composer4.changedInstance(scope) | $composer4.changedInstance(bottomBarAnimation22) | $composer4.changedInstance(albumListAnimation22);
                Object it$iv1722 = $composer4.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv922 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult PictureSelectorContent$lambda$14$0;
                        PictureSelectorContent$lambda$14$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$14$0(scope, bottomBarAnimation22, albumListAnimation22, (DisposableEffectScope) obj);
                        return PictureSelectorContent$lambda$14$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv922);
                it$iv1722 = value$iv922;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.DisposableEffect(unit22, (Function1) it$iv1722, $composer4, 6);
                ComposerKt.sourceInformationMarkerStart($composer4, -1151779640, "CC(remember):PictureSelectorContent.kt#9igjgp");
                it$iv5 = $composer4.rememberedValue();
                if (it$iv5 != Composer.Companion.getEmpty()) {
                }
                Function1 actionDispatcher22 = (Function1) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                int $changed$iv222 = ($dirty2 >> 27) & 14;
                Modifier modifier$iv52 = modifier2;
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv32 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv32 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv52 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv32, horizontalAlignment$iv32, $composer4, (($changed$iv222 >> 3) & 14) | (($changed$iv222 >> 3) & 112));
                int $changed$iv$iv52 = ($changed$iv222 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv52 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv322 = ComposedModifierKt.materializeModifier($composer4, modifier$iv52);
                Function0 factory$iv$iv$iv222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv322, ComposeUiNode.Companion.getSetModifier());
                int i622 = ($changed$iv$iv$iv52 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i722 = (($changed$iv222 >> 6) & 112) | 6;
                ColumnScope $this$PictureSelectorContent_u24lambda_u241622 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -1784722952, "C162@6348L3849:PictureSelectorContent.kt#fednps");
                if (progress != 0.0f) {
                }
                Modifier modifier$iv222 = ClipKt.clipToBounds(ColumnScope.-CC.weight$default($this$PictureSelectorContent_u24lambda_u241622, Modifier.Companion, 1.0f, false, 2, (Object) null));
                $composer$iv3 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv32 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
                int $changed$iv$iv222 = (0 << 3) & 112;
                String str322 = str;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, $changed$iv, str322);
                int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv222 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv422 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv222);
                Function0 factory$iv$iv$iv322 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | 6;
                String str422 = str2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str422);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv422, ComposeUiNode.Companion.getSetModifier());
                int i822 = ($changed$iv$iv$iv222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                int i922 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -2017075140, "C163@6413L3314,239@9886L31,240@9950L69,241@10065L6,235@9741L446:PictureSelectorContent.kt#fednps");
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier$iv322 = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv222 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv222 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv322 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv222, horizontalAlignment$iv222, $composer$iv3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv322 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str322);
                int compositeKeyHash$iv$iv322 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv322 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv522 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv322);
                Function0 factory$iv$iv$iv422 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv322 = (($changed$iv$iv322 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str422);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv322 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, measurePolicy$iv322, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, localMap$iv$iv322, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv322, Integer.valueOf(compositeKeyHash$iv$iv322), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv322, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, materialized$iv$iv522, ComposeUiNode.Companion.getSetModifier());
                int i1022 = ($changed$iv$iv$iv322 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i1122 = ((0 >> 6) & 112) | 6;
                ColumnScope $this$PictureSelectorContent_u24lambda_u2416_u240_u24022 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1819493945, "C174@6857L2856:PictureSelectorContent.kt#fednps");
                if (permissionState.getCurrentStatus().getValue() != PermissionStatus.Limited) {
                }
                $composer$iv3.endReplaceGroup();
                Modifier modifier$iv422 = $this$PictureSelectorContent_u24lambda_u2416_u240_u24022.weight(Modifier.Companion, 1.0f, true);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv222 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv422 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv222, false);
                int $changed$iv$iv422 = (0 << 3) & 112;
                Function0 onClickSelectMore722 = onClickSelectMore4;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str322);
                int compositeKeyHash$iv$iv422 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv422 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv622 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv422);
                Function0 factory$iv$iv$iv522 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv422 = (($changed$iv$iv422 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str422);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv422 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, measurePolicy$iv422, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, localMap$iv$iv422, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv422, Integer.valueOf(compositeKeyHash$iv$iv422), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv422, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv422, materialized$iv$iv622, ComposeUiNode.Companion.getSetModifier());
                int i1222 = ($changed$iv$iv$iv422 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i1322 = ((0 >> 6) & 112) | 6;
                BoxScope $this$PictureSelectorContent_u24lambda_u2416_u240_u240_u24022 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -195455289, "C181@7270L14,181@7285L17,182@7364L82,175@6928L1244,204@8345L126,201@8194L409,210@8625L567,222@9213L482:PictureSelectorContent.kt#fednps");
                Modifier modifier322 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS) + navigationBarHeight2), Dp.constructor-impl(0), ((Number) bottomBarAnimation.getValue()).floatValue()), 7, (Object) null);
                float f22 = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer$iv3, 6), $composer$iv3, 0).calculateBottomPadding-D9Ej5fM();
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517726911, "CC(remember):PictureSelectorContent.kt#9igjgp");
                if (($dirty & 3670016) != 1048576) {
                }
                it$iv6 = $composer$iv3.rememberedValue();
                if (!invalid$iv5) {
                }
                Object value$iv1122 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit PictureSelectorContent$lambda$16$0$0$0$0$0;
                        PictureSelectorContent$lambda$16$0$0$0$0$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$0$0(function14, (AphroAction) obj);
                        return PictureSelectorContent$lambda$16$0$0$0$0$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv1122);
                it$iv6 = value$iv1122;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                onClickSelectMore = onClickSelectMore722;
                Composer $composer522 = $composer3;
                final Function1 function1522 = function14;
                MediaListKt.m2263GridMediaListaqv2aB4(albums, (Function1) it$iv6, modifier322, null, null, false, onAssetItemClick, showSelectIndex, null, f22, $composer$iv3, ($dirty & 14) | (($dirty1 << 12) & 3670016) | (($dirty >> 3) & 29360128), 312);
                float PictureSelectorContent$lambda$622 = PictureSelectorContent$lambda$6(originCheckboxAlpha$delegate2);
                Modifier modifier422 = PaddingKt.padding-qDBjuR0$default($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u24022.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(40), 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517758347, "CC(remember):PictureSelectorContent.kt#9igjgp");
                invalid$iv6 = (($dirty & 3670016) != 1048576) | (($dirty & 14) == 4);
                it$iv7 = $composer$iv3.rememberedValue();
                if (!invalid$iv6) {
                }
                Object value$iv1222 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit PictureSelectorContent$lambda$16$0$0$0$1$0;
                        PictureSelectorContent$lambda$16$0$0$0$1$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$1$0(function1522, albums);
                        return PictureSelectorContent$lambda$16$0$0$0$1$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv1222);
                it$iv7 = value$iv1222;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                MediaSelectFloatKt.OriginCheckBox(albums, PictureSelectorContent$lambda$622, (Function0) it$iv7, modifier422, $composer$iv3, $dirty & 14, 0);
                SelectedListKt.SelectedList(albums, function12, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u24022.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(76)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight2)), Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(76) + Dp.constructor-impl(44)) + navigationBarHeight2), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), false, false, null, $composer$iv3, ($dirty & 14) | (($dirty >> 15) & 112), 56);
                OriginalImageBarKt.OriginalImageBar(function12, albums, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u24022.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(44)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-navigationBarHeight2), Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight2), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), $composer$iv3, (($dirty >> 18) & 14) | (($dirty << 3) & 112), 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                Modifier fillMaxSize$default22 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034790872, "CC(remember):PictureSelectorContent.kt#9igjgp");
                it$iv8 = $composer$iv3.rememberedValue();
                if (it$iv8 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                Modifier onSizeChanged22 = OnRemeasuredModifierKt.onSizeChanged(fillMaxSize$default22, (Function1) it$iv8);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034788786, "CC(remember):PictureSelectorContent.kt#9igjgp");
                final Animatable albumListAnimation322 = albumListAnimation;
                invalid$iv7 = $composer$iv3.changedInstance(albumListAnimation322);
                it$iv9 = $composer$iv3.rememberedValue();
                if (!invalid$iv7) {
                }
                Object value$iv1422 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        IntOffset PictureSelectorContent$lambda$16$0$2$0;
                        PictureSelectorContent$lambda$16$0$2$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$2$0(albumListAnimation322, albumListHeight$delegate2, (Density) obj);
                        return PictureSelectorContent$lambda$16$0$2$0;
                    }
                };
                $composer$iv3.updateRememberedValue(value$iv1422);
                it$iv9 = value$iv1422;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                AlbumListKt.m2251AlbumListpHQ97Tc(BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getBg1_float-0d7_KjU(), albums.getAlbumList(), actionDispatcher22, OffsetKt.offset(onSizeChanged22, (Function1) it$iv9), 0.0f, $composer$iv3, 384, 16);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer522);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object value$iv152 = (Function2) new PictureSelectorContentKt$PictureSelectorContent$7$1(albumListAnimation22, albumExpanded, null);
            $composer4.updateRememberedValue(value$iv152);
            it$iv162 = value$iv152;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv162, $composer4, ($dirty2 >> 12) & 14);
            Unit unit222 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1151786777, "CC(remember):PictureSelectorContent.kt#9igjgp");
            invalid$iv4 = $composer4.changedInstance(scope) | $composer4.changedInstance(bottomBarAnimation22) | $composer4.changedInstance(albumListAnimation22);
            Object it$iv17222 = $composer4.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv9222 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    DisposableEffectResult PictureSelectorContent$lambda$14$0;
                    PictureSelectorContent$lambda$14$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$14$0(scope, bottomBarAnimation22, albumListAnimation22, (DisposableEffectScope) obj);
                    return PictureSelectorContent$lambda$14$0;
                }
            };
            $composer4.updateRememberedValue(value$iv9222);
            it$iv17222 = value$iv9222;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.DisposableEffect(unit222, (Function1) it$iv17222, $composer4, 6);
            ComposerKt.sourceInformationMarkerStart($composer4, -1151779640, "CC(remember):PictureSelectorContent.kt#9igjgp");
            it$iv5 = $composer4.rememberedValue();
            if (it$iv5 != Composer.Companion.getEmpty()) {
            }
            Function1 actionDispatcher222 = (Function1) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            int $changed$iv2222 = ($dirty2 >> 27) & 14;
            Modifier modifier$iv522 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv322 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv322 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv522 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv322, horizontalAlignment$iv322, $composer4, (($changed$iv2222 >> 3) & 14) | (($changed$iv2222 >> 3) & 112));
            int $changed$iv$iv522 = ($changed$iv2222 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv522 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv522 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3222 = ComposedModifierKt.materializeModifier($composer4, modifier$iv522);
            Function0 factory$iv$iv$iv2222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv522 = (($changed$iv$iv522 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv522 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, measurePolicy$iv522, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, localMap$iv$iv522, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv522, Integer.valueOf(compositeKeyHash$iv$iv522), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv522, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, materialized$iv$iv3222, ComposeUiNode.Companion.getSetModifier());
            int i6222 = ($changed$iv$iv$iv522 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i7222 = (($changed$iv2222 >> 6) & 112) | 6;
            ColumnScope $this$PictureSelectorContent_u24lambda_u2416222 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1784722952, "C162@6348L3849:PictureSelectorContent.kt#fednps");
            if (progress != 0.0f) {
            }
            Modifier modifier$iv2222 = ClipKt.clipToBounds(ColumnScope.-CC.weight$default($this$PictureSelectorContent_u24lambda_u2416222, Modifier.Companion, 1.0f, false, 2, (Object) null));
            $composer$iv3 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv322 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv322, false);
            int $changed$iv$iv2222 = (0 << 3) & 112;
            String str3222 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, $changed$iv, str3222);
            int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv2222 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4222 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2222);
            Function0 factory$iv$iv$iv3222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | 6;
            String str4222 = str2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str4222);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv4222, ComposeUiNode.Companion.getSetModifier());
            int i8222 = ($changed$iv$iv$iv2222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope222 = BoxScopeInstance.INSTANCE;
            int i9222 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -2017075140, "C163@6413L3314,239@9886L31,240@9950L69,241@10065L6,235@9741L446:PictureSelectorContent.kt#fednps");
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv3222 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv2222 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2222 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2222, horizontalAlignment$iv2222, $composer$iv3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3222 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str3222);
            int compositeKeyHash$iv$iv3222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv3222 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5222 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv3222);
            Function0 factory$iv$iv$iv4222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3222 = (($changed$iv$iv3222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str4222);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3222 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, measurePolicy$iv3222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, localMap$iv$iv3222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3222, Integer.valueOf(compositeKeyHash$iv$iv3222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, materialized$iv$iv5222, ComposeUiNode.Companion.getSetModifier());
            int i10222 = ($changed$iv$iv$iv3222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i11222 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$PictureSelectorContent_u24lambda_u2416_u240_u240222 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1819493945, "C174@6857L2856:PictureSelectorContent.kt#fednps");
            if (permissionState.getCurrentStatus().getValue() != PermissionStatus.Limited) {
            }
            $composer$iv3.endReplaceGroup();
            Modifier modifier$iv4222 = $this$PictureSelectorContent_u24lambda_u2416_u240_u240222.weight(Modifier.Companion, 1.0f, true);
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2222 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv4222 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2222, false);
            int $changed$iv$iv4222 = (0 << 3) & 112;
            Function0 onClickSelectMore7222 = onClickSelectMore4;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str3222);
            int compositeKeyHash$iv$iv4222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv4222 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6222 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv4222);
            Function0 factory$iv$iv$iv5222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4222 = (($changed$iv$iv4222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str4222);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4222 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, measurePolicy$iv4222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, localMap$iv$iv4222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4222, Integer.valueOf(compositeKeyHash$iv$iv4222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4222, materialized$iv$iv6222, ComposeUiNode.Companion.getSetModifier());
            int i12222 = ($changed$iv$iv$iv4222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i13222 = ((0 >> 6) & 112) | 6;
            BoxScope $this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -195455289, "C181@7270L14,181@7285L17,182@7364L82,175@6928L1244,204@8345L126,201@8194L409,210@8625L567,222@9213L482:PictureSelectorContent.kt#fednps");
            Modifier modifier3222 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS) + navigationBarHeight2), Dp.constructor-impl(0), ((Number) bottomBarAnimation.getValue()).floatValue()), 7, (Object) null);
            float f222 = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer$iv3, 6), $composer$iv3, 0).calculateBottomPadding-D9Ej5fM();
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517726911, "CC(remember):PictureSelectorContent.kt#9igjgp");
            if (($dirty & 3670016) != 1048576) {
            }
            it$iv6 = $composer$iv3.rememberedValue();
            if (!invalid$iv5) {
            }
            Object value$iv11222 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit PictureSelectorContent$lambda$16$0$0$0$0$0;
                    PictureSelectorContent$lambda$16$0$0$0$0$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$0$0(function14, (AphroAction) obj);
                    return PictureSelectorContent$lambda$16$0$0$0$0$0;
                }
            };
            $composer$iv3.updateRememberedValue(value$iv11222);
            it$iv6 = value$iv11222;
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            onClickSelectMore = onClickSelectMore7222;
            Composer $composer5222 = $composer3;
            final Function1 function15222 = function14;
            MediaListKt.m2263GridMediaListaqv2aB4(albums, (Function1) it$iv6, modifier3222, null, null, false, onAssetItemClick, showSelectIndex, null, f222, $composer$iv3, ($dirty & 14) | (($dirty1 << 12) & 3670016) | (($dirty >> 3) & 29360128), 312);
            float PictureSelectorContent$lambda$6222 = PictureSelectorContent$lambda$6(originCheckboxAlpha$delegate2);
            Modifier modifier4222 = PaddingKt.padding-qDBjuR0$default($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240222.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(40), 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1517758347, "CC(remember):PictureSelectorContent.kt#9igjgp");
            invalid$iv6 = (($dirty & 3670016) != 1048576) | (($dirty & 14) == 4);
            it$iv7 = $composer$iv3.rememberedValue();
            if (!invalid$iv6) {
            }
            Object value$iv12222 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit PictureSelectorContent$lambda$16$0$0$0$1$0;
                    PictureSelectorContent$lambda$16$0$0$0$1$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$0$0$1$0(function15222, albums);
                    return PictureSelectorContent$lambda$16$0$0$0$1$0;
                }
            };
            $composer$iv3.updateRememberedValue(value$iv12222);
            it$iv7 = value$iv12222;
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            MediaSelectFloatKt.OriginCheckBox(albums, PictureSelectorContent$lambda$6222, (Function0) it$iv7, modifier4222, $composer$iv3, $dirty & 14, 0);
            SelectedListKt.SelectedList(albums, function12, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240222.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(76)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight2)), Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(76) + Dp.constructor-impl(44)) + navigationBarHeight2), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), false, false, null, $composer$iv3, ($dirty & 14) | (($dirty >> 15) & 112), 56);
            OriginalImageBarKt.OriginalImageBar(function12, albums, OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs($this$PictureSelectorContent_u24lambda_u2416_u240_u240_u240222.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), Dp.constructor-impl(44)), 0.0f, DpKt.lerp-Md-fbLM(Dp.constructor-impl(-navigationBarHeight2), Dp.constructor-impl(Dp.constructor-impl(44) + navigationBarHeight2), ((Number) bottomBarAnimation.getValue()).floatValue()), 1, (Object) null), $composer$iv3, (($dirty >> 18) & 14) | (($dirty << 3) & 112), 0);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            Modifier fillMaxSize$default222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034790872, "CC(remember):PictureSelectorContent.kt#9igjgp");
            it$iv8 = $composer$iv3.rememberedValue();
            if (it$iv8 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            Modifier onSizeChanged222 = OnRemeasuredModifierKt.onSizeChanged(fillMaxSize$default222, (Function1) it$iv8);
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1034788786, "CC(remember):PictureSelectorContent.kt#9igjgp");
            final Animatable albumListAnimation3222 = albumListAnimation;
            invalid$iv7 = $composer$iv3.changedInstance(albumListAnimation3222);
            it$iv9 = $composer$iv3.rememberedValue();
            if (!invalid$iv7) {
            }
            Object value$iv14222 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    IntOffset PictureSelectorContent$lambda$16$0$2$0;
                    PictureSelectorContent$lambda$16$0$2$0 = PictureSelectorContentKt.PictureSelectorContent$lambda$16$0$2$0(albumListAnimation3222, albumListHeight$delegate2, (Density) obj);
                    return PictureSelectorContent$lambda$16$0$2$0;
                }
            };
            $composer$iv3.updateRememberedValue(value$iv14222);
            it$iv9 = value$iv14222;
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            AlbumListKt.m2251AlbumListpHQ97Tc(BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getBg1_float-0d7_KjU(), albums.getAlbumList(), actionDispatcher222, OffsetKt.offset(onSizeChanged222, (Function1) it$iv9), 0.0f, $composer$iv3, 384, 16);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer5222);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            function04 = function0;
            onClickSelectMore = function02;
            onAssetItemClick = function3;
            onShootPictureClick = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final Function0<Unit> function05 = function04;
            final Function0 function06 = onClickSelectMore;
            final Function3 function32 = onAssetItemClick;
            final Function0 function07 = onShootPictureClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit PictureSelectorContent$lambda$17;
                    PictureSelectorContent$lambda$17 = PictureSelectorContentKt.PictureSelectorContent$lambda$17(AphroState.AphroContent.this, progress, anchoredDraggableCurrentValue, permissionState, albumExpanded, function1, function12, function13, showSelectIndex, modifier5, function05, function06, function32, function07, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PictureSelectorContent$lambda$17;
                }
            });
        }
    }

    private static final float PictureSelectorContent$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final int PictureSelectorContent$lambda$11(MutableIntState $albumListHeight$delegate) {
        IntState $this$getValue$iv = (IntState) $albumListHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PictureSelectorContent$lambda$14$0(final CoroutineScope $scope, final Animatable $bottomBarAnimation, final Animatable $albumListAnimation, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$PictureSelectorContent$lambda$14$0$$inlined$onDispose$1
            public void dispose() {
                BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new PictureSelectorContentKt$PictureSelectorContent$8$1$1$1($bottomBarAnimation, $albumListAnimation, null), 3, (Object) null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectorContent$lambda$15$0(Function1 $onAlbumExpandChange, Function1 $onAction, AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof AphroAction.SwitchAlbum) {
            $onAlbumExpandChange.invoke(false);
        }
        $onAction.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectorContent$lambda$16$0$0$0$0$0(Function1 $onAction, AphroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        $onAction.invoke(action);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectorContent$lambda$16$0$0$0$1$0(Function1 $onAction, AphroState.AphroContent $albums) {
        $onAction.invoke(new AphroAction.CheckUseOriginImage(!$albums.getUseOriginImage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PictureSelectorContent$lambda$16$0$1$0(MutableIntState $albumListHeight$delegate, IntSize it) {
        $albumListHeight$delegate.setIntValue((int) (4294967295L & it.unbox-impl()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset PictureSelectorContent$lambda$16$0$2$0(Animatable $albumListAnimation, MutableIntState $albumListHeight$delegate, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = MathHelpersKt.lerp(0, -PictureSelectorContent$lambda$11($albumListHeight$delegate), ((Number) $albumListAnimation.getValue()).floatValue());
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (y$iv & 4294967295L)));
    }
}