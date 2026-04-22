package kntr.app.im.chat.sticker;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import bili.resource.common.Res;
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import bili.resource.im.String1_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.sticker.widget.PermissionDialogKt;
import kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt;
import kntr.app.im.chat.sticker.widget.PopupBubbleStickerState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.BPermissionType;
import kntr.common.photonic.permission.PermissionState_androidKt;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kntr.common.photonic.shower.AssetShower;
import kntr.common.photonic.shower.AssetShowerHolder;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: Sticker.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001a#\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\r\u001a)\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0012X\u008a\u008e\u0002"}, d2 = {"StickerPanel", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkntr/app/im/chat/sticker/StickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/sticker/StickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StickerPanelTopBar", "stickerState", "AddStickerButton", "dashedColor", "Landroidx/compose/ui/graphics/Color;", "AddStickerButton-iJQMabo", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "StickerItem", "stickerAsset", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "animated", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/sticker/model/StickerAsset;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "sticker_debug", "isDoubleConfirm"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddStickerButton_iJQMabo$lambda$2(Modifier modifier, long j2, int i, int i2, Composer composer, int i3) {
        m1638AddStickerButtoniJQMabo(modifier, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerItem$lambda$1(StickerAsset stickerAsset, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        StickerItem(stickerAsset, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$4(StickerState stickerState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StickerPanel(stickerState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanelTopBar$lambda$1(StickerState stickerState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StickerPanelTopBar(stickerState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x02ed, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x04ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StickerPanel(final StickerState state, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        Object value$iv;
        Composer $composer$iv$iv;
        Composer $composer2;
        Composer $composer$iv2;
        final MutableState showPermissionDialog;
        String str;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer3 = $composer.startRestartGroup(-1234173710);
        ComposerKt.sourceInformation($composer3, "C(StickerPanel)N(state,modifier)115@4910L23,117@5013L24,118@5066L7,119@5099L28,119@5078L49,123@5167L54,131@5342L6,127@5227L8345:Sticker.kt#wzdu6v");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1234173710, $dirty2, -1, "kntr.app.im.chat.sticker.StickerPanel (Sticker.kt:114)");
            }
            LazyGridState gridState = LazyGridStateKt.rememberLazyGridState(0, 0, $composer3, 0, 3);
            final Modifier itemModifier = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router route = (Router) consume;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -629952274, "CC(remember):Sticker.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new StickerKt$StickerPanel$1$1(state, null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, -629950072, "CC(remember):Sticker.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            MutableState showPermissionDialog2 = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(modifier3, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1246557514, "C134@5411L20,136@5476L130,141@5655L113,144@5811L151,144@5777L185,149@5971L155,160@6492L7074,153@6135L7431:Sticker.kt#wzdu6v");
            Activity platformContext = PlatformContext_androidKt.getPlatformContext($composer3, 0);
            final BPermissionState galleryPermission = PermissionState_androidKt.rememberBPermissionState(BPermissionType.GALLERY, platformContext, $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, 1899451565, "CC(remember):Sticker.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changed(galleryPermission);
            Object value$iv4 = $composer3.rememberedValue();
            if (invalid$iv4) {
                localMap$iv$iv = localMap$iv$iv2;
            } else {
                localMap$iv$iv = localMap$iv$iv2;
                if (value$iv4 != Composer.Companion.getEmpty()) {
                    $composer$iv = $composer3;
                    final MutableState savedPermissionStatus = (MutableState) value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1899456595, "CC(remember):Sticker.kt#9igjgp");
                    invalid$iv = $composer3.changed(galleryPermission) | $composer3.changed(savedPermissionStatus);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv5 = (Function2) new StickerKt$StickerPanel$2$1$1(galleryPermission, savedPermissionStatus, null);
                    $composer3.updateRememberedValue(value$iv5);
                    it$iv3 = value$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(galleryPermission, (Function2) it$iv3, $composer3, 0);
                    StickerPanelTopBar(state, PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(8)), $composer3, $dirty2 & 14, 0);
                    GridCells fixed = new GridCells.Fixed(5);
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    PaddingValues paddingValues = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(6));
                    Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                    Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(6), Alignment.Companion.getTop());
                    GridCells gridCells = fixed;
                    Arrangement.Horizontal horizontal2 = horizontal;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1899485310, "CC(remember):Sticker.kt#9igjgp");
                    invalid$iv2 = $composer3.changedInstance(scope) | $composer3.changed(savedPermissionStatus) | $composer3.changedInstance(route) | $composer3.changed(galleryPermission) | (($dirty2 & 14) != 4);
                    value$iv = $composer3.rememberedValue();
                    if (!invalid$iv2 || value$iv == Composer.Companion.getEmpty()) {
                        $composer$iv$iv = $composer3;
                        $composer2 = $composer3;
                        $composer$iv2 = $composer$iv;
                        showPermissionDialog = showPermissionDialog2;
                        str = "CC(remember):Sticker.kt#9igjgp";
                        value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                Unit StickerPanel$lambda$2$2$0;
                                StickerPanel$lambda$2$2$0 = StickerKt.StickerPanel$lambda$2$2$0(StickerState.this, itemModifier, scope, savedPermissionStatus, route, galleryPermission, showPermissionDialog, (LazyGridScope) obj);
                                return StickerPanel$lambda$2$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        $composer2 = $composer3;
                        $composer$iv2 = $composer$iv;
                        $composer$iv$iv = $composer3;
                        showPermissionDialog = showPermissionDialog2;
                        str = "CC(remember):Sticker.kt#9igjgp";
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LazyGridDslKt.LazyVerticalGrid(gridCells, fillMaxSize$default, gridState, paddingValues, false, vertical, horizontal2, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer2, 1772592, 0, 912);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (((Boolean) showPermissionDialog.getValue()).booleanValue()) {
                        $composer3.startReplaceGroup(1941255920);
                    } else {
                        $composer3.startReplaceGroup(1954760233);
                        ComposerKt.sourceInformation($composer3, "314@13637L38,314@13620L55");
                        ComposerKt.sourceInformationMarkerStart($composer3, -629679048, str);
                        Object it$iv4 = $composer3.rememberedValue();
                        if (it$iv4 == Composer.Companion.getEmpty()) {
                            final MutableState showPermissionDialog3 = showPermissionDialog;
                            Object value$iv6 = new Function0() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda3
                                public final Object invoke() {
                                    Unit StickerPanel$lambda$3$0;
                                    StickerPanel$lambda$3$0 = StickerKt.StickerPanel$lambda$3$0(showPermissionDialog3);
                                    return StickerPanel$lambda$3$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv6);
                            it$iv4 = value$iv6;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        PermissionDialogKt.PermissionDialog((Function0) it$iv4, $composer3, 6);
                    }
                    $composer3.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                }
            }
            $composer$iv = $composer3;
            value$iv4 = SnapshotStateKt.mutableStateOf$default(galleryPermission.getCurrentStatus().getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer3.updateRememberedValue(value$iv4);
            final MutableState savedPermissionStatus2 = (MutableState) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1899456595, "CC(remember):Sticker.kt#9igjgp");
            invalid$iv = $composer3.changed(galleryPermission) | $composer3.changed(savedPermissionStatus2);
            Object it$iv32 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv52 = (Function2) new StickerKt$StickerPanel$2$1$1(galleryPermission, savedPermissionStatus2, null);
            $composer3.updateRememberedValue(value$iv52);
            it$iv32 = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(galleryPermission, (Function2) it$iv32, $composer3, 0);
            StickerPanelTopBar(state, PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(8)), $composer3, $dirty2 & 14, 0);
            GridCells fixed2 = new GridCells.Fixed(5);
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            PaddingValues paddingValues2 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(6));
            Arrangement.Horizontal horizontal3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            Arrangement.Vertical vertical2 = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(6), Alignment.Companion.getTop());
            GridCells gridCells2 = fixed2;
            Arrangement.Horizontal horizontal22 = horizontal3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1899485310, "CC(remember):Sticker.kt#9igjgp");
            invalid$iv2 = $composer3.changedInstance(scope) | $composer3.changed(savedPermissionStatus2) | $composer3.changedInstance(route) | $composer3.changed(galleryPermission) | (($dirty2 & 14) != 4);
            value$iv = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            $composer$iv$iv = $composer3;
            $composer2 = $composer3;
            $composer$iv2 = $composer$iv;
            showPermissionDialog = showPermissionDialog2;
            str = "CC(remember):Sticker.kt#9igjgp";
            value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit StickerPanel$lambda$2$2$0;
                    StickerPanel$lambda$2$2$0 = StickerKt.StickerPanel$lambda$2$2$0(StickerState.this, itemModifier, scope, savedPermissionStatus2, route, galleryPermission, showPermissionDialog, (LazyGridScope) obj);
                    return StickerPanel$lambda$2$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyGridDslKt.LazyVerticalGrid(gridCells2, fillMaxSize$default2, gridState, paddingValues2, false, vertical2, horizontal22, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer2, 1772592, 0, 912);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (((Boolean) showPermissionDialog.getValue()).booleanValue()) {
            }
            $composer3.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
        } else {
            $composer3.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerPanel$lambda$4;
                    StickerPanel$lambda$4 = StickerKt.StickerPanel$lambda$4(StickerState.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerPanel$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$2$2$0(final StickerState $state, final Modifier $itemModifier, final CoroutineScope $scope, final MutableState $savedPermissionStatus, final Router $route, final BPermissionState $galleryPermission, final MutableState $showPermissionDialog, LazyGridScope $this$LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
        LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, (Function1) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1505694864, true, new Function3() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StickerPanel$lambda$2$2$0$0;
                StickerPanel$lambda$2$2$0$0 = StickerKt.StickerPanel$lambda$2$2$0$0($itemModifier, $scope, $savedPermissionStatus, $route, $galleryPermission, $showPermissionDialog, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StickerPanel$lambda$2$2$0$0;
            }
        }), 7, (Object) null);
        final List list = (List) $state.getStickerHolder().getValue();
        final Function1 key$iv = new Function1() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Object StickerPanel$lambda$2$2$0$1;
                StickerPanel$lambda$2$2$0$1 = StickerKt.StickerPanel$lambda$2$2$0$1((StickerAsset) obj);
                return StickerPanel$lambda$2$2$0$1;
            }
        };
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$lambda$2$2$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1639invoke((StickerAsset) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1639invoke(StickerAsset stickerAsset) {
                return null;
            }
        };
        $this$LazyVerticalGrid.items(list.size(), new Function1<Integer, Object>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$lambda$2$2$0$$inlined$items$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(list.get(index));
            }
        }, (Function2) null, new Function1<Integer, Object>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$lambda$2$2$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(list.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$lambda$2$2$0$$inlined$items$default$5
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyGridItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Alignment.Horizontal horizontalAlignment$iv;
                MeasurePolicy measurePolicy$iv$iv;
                boolean StickerPanel$lambda$2$2$0$2$0$3;
                final long buttonColor;
                boolean StickerPanel$lambda$2$2$0$2$0$32;
                Arrangement.Vertical verticalArrangement$iv;
                final long buttonTextColor;
                boolean StickerPanel$lambda$2$2$0$2$0$33;
                final String buttonText;
                ComposerKt.sourceInformation($composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1117249557, $dirty, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                int $changed2 = $dirty & 14;
                final StickerAsset sticker = (StickerAsset) list.get(it);
                $composer.startReplaceGroup(-225390515);
                ComposerKt.sourceInformation($composer, "CN(sticker)*197@8367L5175:Sticker.kt#wzdu6v");
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 182277106, "C198@8426L38,200@8510L39,202@8594L34,227@9578L149,236@10029L2684,225@9458L3255,301@13236L120,296@12970L214,291@12735L789:Sticker.kt#wzdu6v");
                ComposerKt.sourceInformationMarkerStart($composer, -1656692209, "CC(remember):Sticker.kt#9igjgp");
                Object value$iv = $composer.rememberedValue();
                if (value$iv == Composer.Companion.getEmpty()) {
                    horizontalAlignment$iv = horizontalAlignment$iv2;
                    value$iv = new PopupBubbleStickerState(false, 1, null);
                    $composer.updateRememberedValue(value$iv);
                } else {
                    horizontalAlignment$iv = horizontalAlignment$iv2;
                }
                final PopupBubbleStickerState popupBubbleStickerState = (PopupBubbleStickerState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1656689520, "CC(remember):Sticker.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                    $composer.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                }
                final MutableInteractionSource interactionSource = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1656686837, "CC(remember):Sticker.kt#9igjgp");
                Object value$iv3 = $composer.rememberedValue();
                if (value$iv3 == Composer.Companion.getEmpty()) {
                    measurePolicy$iv$iv = measurePolicy$iv;
                    value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer.updateRememberedValue(value$iv3);
                } else {
                    measurePolicy$iv$iv = measurePolicy$iv;
                }
                final MutableState isDoubleConfirm$delegate = (MutableState) value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                StickerPanel$lambda$2$2$0$2$0$3 = StickerKt.StickerPanel$lambda$2$2$0$2$0$3(isDoubleConfirm$delegate);
                if (StickerPanel$lambda$2$2$0$2$0$3) {
                    $composer.startReplaceGroup(182435174);
                    ComposerKt.sourceInformation($composer, "206@8753L6");
                    long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getStress_red-0d7_KjU();
                    $composer.endReplaceGroup();
                    buttonColor = j2;
                } else {
                    $composer.startReplaceGroup(182523431);
                    ComposerKt.sourceInformation($composer, "208@8842L6");
                    long j3 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU();
                    $composer.endReplaceGroup();
                    buttonColor = j3;
                }
                StickerPanel$lambda$2$2$0$2$0$32 = StickerKt.StickerPanel$lambda$2$2$0$2$0$3(isDoubleConfirm$delegate);
                if (StickerPanel$lambda$2$2$0$2$0$32) {
                    $composer.startReplaceGroup(182693094);
                    ComposerKt.sourceInformation($composer, "213@9013L6");
                    verticalArrangement$iv = verticalArrangement$iv2;
                    long j4 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU();
                    $composer.endReplaceGroup();
                    buttonTextColor = j4;
                } else {
                    verticalArrangement$iv = verticalArrangement$iv2;
                    $composer.startReplaceGroup(182781227);
                    ComposerKt.sourceInformation($composer, "215@9102L6");
                    long j5 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
                    $composer.endReplaceGroup();
                    buttonTextColor = j5;
                }
                StickerPanel$lambda$2$2$0$2$0$33 = StickerKt.StickerPanel$lambda$2$2$0$2$0$3(isDoubleConfirm$delegate);
                if (StickerPanel$lambda$2$2$0$2$0$33) {
                    $composer.startReplaceGroup(182942706);
                    ComposerKt.sourceInformation($composer, "220@9254L47");
                    String stringResource = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_900(Res.string.INSTANCE), $composer, 0);
                    $composer.endReplaceGroup();
                    buttonText = stringResource;
                } else {
                    $composer.startReplaceGroup(183050834);
                    ComposerKt.sourceInformation($composer, "222@9363L47");
                    String stringResource2 = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_901(Res.string.INSTANCE), $composer, 0);
                    $composer.endReplaceGroup();
                    buttonText = stringResource2;
                }
                float f = Dp.constructor-impl(4);
                PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default(0.0f, Dp.constructor-impl(6), 1, (Object) null);
                Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(122)), Dp.constructor-impl(161));
                ComposerKt.sourceInformationMarkerStart($composer, -1656655234, "CC(remember):Sticker.kt#9igjgp");
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = (Function0) new Function0<Unit>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1642invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1642invoke() {
                            PopupBubbleStickerState.this.setVisible(false);
                            StickerKt.StickerPanel$lambda$2$2$0$2$0$4(isDoubleConfirm$delegate, false);
                        }
                    };
                    $composer.updateRememberedValue(value$iv4);
                    it$iv2 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                final CoroutineScope coroutineScope = $scope;
                final StickerState stickerState = $state;
                PopupBubbleStickerKt.m1709PopupBubbleStickero_661Y4(popupBubbleStickerState, (Function0) it$iv2, modifier, paddingValues, f, null, buttonColor, ComposableLambdaKt.rememberComposableLambda(-176516560, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed3) {
                        Function0 factory$iv$iv$iv3;
                        Function0 factory$iv$iv$iv4;
                        ComposerKt.sourceInformation($composer2, "C241@10260L6,237@10055L2636:Sticker.kt#wzdu6v");
                        if (!$composer2.shouldExecute(($changed3 & 3) != 2, $changed3 & 1)) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-176516560, $changed3, -1, "kntr.app.im.chat.sticker.StickerPanel.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Sticker.kt:237)");
                        }
                        Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
                        long j6 = buttonColor;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        final StickerState stickerState2 = stickerState;
                        final StickerAsset stickerAsset = sticker;
                        MutableInteractionSource mutableInteractionSource = interactionSource;
                        final MutableState<Boolean> mutableState = isDoubleConfirm$delegate;
                        final PopupBubbleStickerState popupBubbleStickerState2 = popupBubbleStickerState;
                        final String str = buttonText;
                        final long j7 = buttonTextColor;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer2.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        int i4 = ((0 >> 6) & 112) | 6;
                        ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1543940945, "C243@10335L546,255@10910L19,277@12133L121,260@11161L741,280@12286L379,257@10959L1706:Sticker.kt#wzdu6v");
                        Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(ColumnScope.-CC.weight$default($this$invoke_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv4 = factory$iv$iv$iv6;
                            $composer2.createNode(factory$iv$iv$iv4);
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv6;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i6 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 122276164, "C247@10552L299:Sticker.kt#wzdu6v");
                        StickerKt.StickerItem(stickerAsset, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(102)), true, $composer2, 432, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer2, 0, 7);
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(33)), 0.0f, 1, (Object) null);
                        PaddingValues paddingValues2 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
                        Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(0));
                        ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(j6, 0L, 0L, 0L, $composer2, ButtonDefaults.$stable << 12, 14);
                        ComposerKt.sourceInformationMarkerStart($composer2, -1435253025, "CC(remember):Sticker.kt#9igjgp");
                        boolean invalid$iv = $composer2.changedInstance(coroutineScope2) | $composer2.changed(stickerState2) | $composer2.changedInstance(stickerAsset);
                        Object value$iv5 = $composer2.rememberedValue();
                        if (invalid$iv || value$iv5 == Composer.Companion.getEmpty()) {
                            value$iv5 = new Function0<Unit>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$2$1$2$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1643invoke();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: Sticker.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$2$1$2$1$1", f = "Sticker.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                /* renamed from: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$2$1$2$1$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ PopupBubbleStickerState $popupBubbleStickerState;
                                    final /* synthetic */ StickerState $state;
                                    final /* synthetic */ StickerAsset $sticker;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(StickerState stickerState, StickerAsset stickerAsset, PopupBubbleStickerState popupBubbleStickerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$state = stickerState;
                                        this.$sticker = stickerAsset;
                                        this.$popupBubbleStickerState = popupBubbleStickerState;
                                    }

                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$state, this.$sticker, this.$popupBubbleStickerState, continuation);
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                    }

                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$state.getStickerActionFlow().emit(new StickerAction.DeleteStickers(CollectionsKt.listOf(this.$sticker)), (Continuation) this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 1:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        this.$popupBubbleStickerState.setVisible(false);
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1643invoke() {
                                    boolean StickerPanel$lambda$2$2$0$2$0$34;
                                    StickerPanel$lambda$2$2$0$2$0$34 = StickerKt.StickerPanel$lambda$2$2$0$2$0$3(mutableState);
                                    if (!StickerPanel$lambda$2$2$0$2$0$34) {
                                        StickerKt.StickerPanel$lambda$2$2$0$2$0$4(mutableState, true);
                                    } else {
                                        BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(stickerState2, stickerAsset, popupBubbleStickerState2, null), 3, (Object) null);
                                    }
                                }
                            };
                            $composer2.updateRememberedValue(value$iv5);
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ButtonKt.Button((Function0) value$iv5, fillMaxWidth$default, false, shape, buttonColors, (ButtonElevation) null, (BorderStroke) null, paddingValues2, mutableInteractionSource, ComposableLambdaKt.rememberComposableLambda(1898683786, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$2$1$3
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                                invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope $this$Button, Composer $composer3, int $changed4) {
                                Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
                                ComposerKt.sourceInformation($composer3, "C284@12526L9,281@12320L315:Sticker.kt#wzdu6v");
                                int $dirty2 = $changed4;
                                if (($changed4 & 6) == 0) {
                                    $dirty2 |= $composer3.changed($this$Button) ? 4 : 2;
                                }
                                int $dirty3 = $dirty2;
                                if ($composer3.shouldExecute(($dirty3 & 19) != 18, $dirty3 & 1)) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1898683786, $dirty3, -1, "kntr.app.im.chat.sticker.StickerPanel.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Sticker.kt:281)");
                                    }
                                    TextKt.Text-Nvy7gAk(str, $this$Button.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), j7, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 0, 131064);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }, $composer2, 54), $composer2, 918552624, 100);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), $composer, 12610998, 32);
                Modifier modifier2 = $itemModifier;
                ComposerKt.sourceInformationMarkerStart($composer, -1656538207, "CC(remember):Sticker.kt#9igjgp");
                Object it$iv3 = $composer.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = (Function0) new Function0<Unit>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$3$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1644invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1644invoke() {
                            PopupBubbleStickerState.this.setVisible(true);
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                    it$iv3 = value$iv5;
                }
                Function0 function0 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1656546625, "CC(remember):Sticker.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($state) | $composer.changedInstance(sticker);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                    final CoroutineScope coroutineScope2 = $scope;
                    final StickerState stickerState2 = $state;
                    Object value$iv6 = (Function0) new Function0<Unit>() { // from class: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$4$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: Sticker.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$4$1$1", f = "Sticker.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$3$1$4$1$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ StickerState $state;
                            final /* synthetic */ StickerAsset $sticker;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(StickerState stickerState, StickerAsset stickerAsset, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$state = stickerState;
                                this.$sticker = stickerAsset;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$state, this.$sticker, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        this.label = 1;
                                        if (this.$state.getSelectedEvent().emit(this.$sticker, (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        break;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1645invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1645invoke() {
                            BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(stickerState2, sticker, null), 3, (Object) null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                    it$iv4 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                StickerKt.StickerItem(sticker, ClipKt.clip(ClickableKt.combinedClickable-hoGz1lA$default(modifier2, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (MutableInteractionSource) null, (Function0) it$iv4, 239, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), false, $composer, ($changed2 >> 3) & 14, 4);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$2$2$0$0(Modifier $itemModifier, final CoroutineScope $scope, final MutableState $savedPermissionStatus, final Router $route, final BPermissionState $galleryPermission, final MutableState $showPermissionDialog, LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C168@6789L1367,163@6562L1613:Sticker.kt#wzdu6v");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1505694864, $changed, -1, "kntr.app.im.chat.sticker.StickerPanel.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Sticker.kt:163)");
            }
            Modifier clip = ClipKt.clip($itemModifier, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)));
            ComposerKt.sourceInformationMarkerStart($composer, 431223655, "CC(remember):Sticker.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($savedPermissionStatus) | $composer.changedInstance($route) | $composer.changed($galleryPermission);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function0() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit StickerPanel$lambda$2$2$0$0$0$0;
                        StickerPanel$lambda$2$2$0$0$0$0 = StickerKt.StickerPanel$lambda$2$2$0$0$0$0($scope, $savedPermissionStatus, $route, $showPermissionDialog, $galleryPermission);
                        return StickerPanel$lambda$2$2$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            m1638AddStickerButtoniJQMabo(ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null), 0L, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$2$2$0$0$0$0(CoroutineScope $scope, MutableState $savedPermissionStatus, Router $route, MutableState $showPermissionDialog, BPermissionState $galleryPermission) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new StickerKt$StickerPanel$2$2$1$1$1$1$1($savedPermissionStatus, $route, $showPermissionDialog, $galleryPermission, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StickerPanel$lambda$2$2$0$1(StickerAsset it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getEntity$sticker_debug().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StickerPanel$lambda$2$2$0$2$0$3(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StickerPanel$lambda$2$2$0$2$0$4(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanel$lambda$3$0(MutableState $showPermissionDialog) {
        $showPermissionDialog.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0300, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void StickerPanelTopBar(final StickerState stickerState, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(885299664);
        ComposerKt.sourceInformation($composer2, "C(StickerPanelTopBar)N(stickerState,modifier)323@13829L7,324@13841L1995:Sticker.kt#wzdu6v");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(stickerState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(885299664, $dirty, -1, "kntr.app.im.chat.sticker.StickerPanelTopBar (Sticker.kt:322)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default(modifier3, Dp.constructor-impl(6), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$StickerPanelTopBar_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1043709975, "C330@14048L9,331@14090L9,351@14754L6,351@14778L6,354@14835L47,353@14810L333,364@15153L38,367@15264L102,370@15387L72,371@15491L9,372@15544L6,365@15200L367,374@15576L39,376@15665L28,379@15807L6,375@15624L206:Sticker.kt#wzdu6v");
            float progress = ((Number) stickerState.getProgress().getValue()).floatValue();
            TextStyle start = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
            TextStyle end = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14b();
            FontWeight fontWeight = start.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            int weight = fontWeight.getWeight();
            FontWeight fontWeight2 = end.getFontWeight();
            if (fontWeight2 == null) {
                fontWeight2 = FontWeight.Companion.getBold();
            }
            int fontWeight3 = MathHelpersKt.lerp(weight, fontWeight2.getWeight(), progress);
            float fontSize = MathHelpersKt.lerp(TextUnit.getValue-impl(start.getFontSize-XSAIIZE()), TextUnit.getValue-impl(end.getFontSize-XSAIIZE()), progress);
            float lineHeight = MathHelpersKt.lerp(TextUnit.getValue-impl(start.getLineHeight-XSAIIZE()), TextUnit.getValue-impl(end.getLineHeight-XSAIIZE()), progress);
            long color = ColorKt.lerp-jxsXWHM(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU(), progress);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_189(Res.string.INSTANCE), $composer2, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(color, TextUnitKt.getSp(fontSize), new FontWeight(fontWeight3), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(lineHeight), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646136, (DefaultConstructorMarker) null), $composer2, 0, 0, 131070);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$StickerPanelTopBar_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            Modifier modifier5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 449349586, "CC(remember):Sticker.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(router);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit StickerPanelTopBar$lambda$0$0$0;
                    StickerPanelTopBar$lambda$0$0$0 = StickerKt.StickerPanelTopBar$lambda$0$0$0(router);
                    return StickerPanelTopBar$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_233(Res.string.INSTANCE), $composer2, 0), ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getDescription(), $composer2, 0, 0, 131064);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer2, 6);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerPanelTopBar$lambda$1;
                    StickerPanelTopBar$lambda$1 = StickerKt.StickerPanelTopBar$lambda$1(StickerState.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerPanelTopBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StickerPanelTopBar$lambda$0$0$0(Router $router) {
        $router.launch(Uri.Companion.parse("bilibili://im/chat/sticker/manager"));
        return Unit.INSTANCE;
    }

    /* renamed from: AddStickerButton-iJQMabo  reason: not valid java name */
    public static final void m1638AddStickerButtoniJQMabo(Modifier modifier, long j2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final long j3;
        Modifier modifier3;
        long j4;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-821341616);
        ComposerKt.sourceInformation($composer2, "C(AddStickerButton)N(modifier,dashedColor:c#ui.graphics.Color)392@16048L737,389@15975L1109:Sticker.kt#wzdu6v");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j3 = j2;
                if ($composer2.changed(j3)) {
                    i2 = 32;
                    $dirty |= i2;
                }
            } else {
                j3 = j2;
            }
            i2 = 16;
            $dirty |= i2;
        } else {
            j3 = j2;
        }
        boolean z = true;
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "387@15953L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier4 = modifier2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    $dirty &= -113;
                    j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-821341616, $dirty, -1, "kntr.app.im.chat.sticker.AddStickerButton (Sticker.kt:388)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 964696209, "CC(remember):Sticker.kt#9igjgp");
            if (((($dirty & 112) ^ 48) <= 32 || !$composer2.changed(j3)) && ($dirty & 48) != 32) {
                z = false;
            }
            boolean invalid$iv = z;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit AddStickerButton_iJQMabo$lambda$0$0;
                        AddStickerButton_iJQMabo$lambda$0$0 = StickerKt.AddStickerButton_iJQMabo$lambda$0$0(j3, (DrawScope) obj);
                        return AddStickerButton_iJQMabo$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = DrawModifierKt.drawBehind(modifier4, (Function1) it$iv);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            j4 = j3;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1015359353, "C412@16890L17,415@17054L6,411@16848L230:Sticker.kt#wzdu6v");
            ImageKt.Image(BiliIconfont.INSTANCE.getPlus_add_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | 432, 56);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j4 = j3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j5 = j4;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddStickerButton_iJQMabo$lambda$2;
                    AddStickerButton_iJQMabo$lambda$2 = StickerKt.AddStickerButton_iJQMabo$lambda$2(modifier5, j5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AddStickerButton_iJQMabo$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddStickerButton_iJQMabo$lambda$0$0(long j2, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        float dashLength = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(2));
        float gapLength = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(2));
        Brush solidColor = new SolidColor(j2, (DefaultConstructorMarker) null);
        DrawStyle stroke = new Stroke($this$drawBehind.toPx-0680j_4(Dp.constructor-impl(2)), 0.0f, 0, 0, PathEffect.Companion.dashPathEffect(new float[]{dashLength, gapLength}, 0.0f), 14, (DefaultConstructorMarker) null);
        float x$iv = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(2));
        float y$iv = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(2));
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        DrawScope.-CC.drawRoundRect-ZuiqVtQ$default($this$drawBehind, solidColor, 0L, 0L, CornerRadius.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, stroke, (ColorFilter) null, 0, 214, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01aa, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StickerItem(final StickerAsset stickerAsset, Modifier modifier, boolean animated, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        boolean animated2;
        Modifier modifier4;
        boolean animated3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1680425372);
        ComposerKt.sourceInformation($composer2, "C(StickerItem)N(stickerAsset,modifier,animated)426@17231L277:Sticker.kt#wzdu6v");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(stickerAsset) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = animated;
        } else if (($changed & 384) == 0) {
            z = animated;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = animated;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            animated2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                animated3 = z;
            } else {
                animated3 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1680425372, $dirty2, -1, "kntr.app.im.chat.sticker.StickerItem (Sticker.kt:425)");
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1784747509, "C428@17291L117:Sticker.kt#wzdu6v");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(stickerAsset.getClass());
            ComposerKt.sourceInformationMarkerStart($composer2, 1997235831, "CC(remember):Sticker.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(orCreateKotlinClass);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            AssetShowerHolder this_$iv = AssetEntry.INSTANCE.getShower();
            Object value$iv = this_$iv.getShowerForAssetType(Reflection.getOrCreateKotlinClass(StickerAsset.class));
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            AssetShower shower = (AssetShower) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (shower == null) {
                $composer2.startReplaceGroup(1784900306);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1997240079);
                ComposerKt.sourceInformation($composer2, "431@17425L77");
                shower.Content(stickerAsset, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), animated3, $composer2, ($dirty2 & 14) | 48 | ($dirty2 & 896));
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            animated2 = animated3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = animated2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.StickerKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit StickerItem$lambda$1;
                    StickerItem$lambda$1 = StickerKt.StickerItem$lambda$1(StickerAsset.this, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StickerItem$lambda$1;
                }
            });
        }
    }
}