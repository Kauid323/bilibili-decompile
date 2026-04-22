package kntr.app.tribee.steam.page.share;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
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
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.Res;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeData;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.tribee.steam.page.TribeeSteamListKt;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.tribee.steam.state.TribeeSteamShareState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.compose.res.LoadingAnimateImageKt;
import kntr.common.paragraph.qrcode.QrCodeProvider;
import kntr.common.share.common.ShareImage;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.share.common.ui.ShareMenuViewKt;
import kntr.common.share.common.ui.ShareMenuViewState;
import kntr.common.trio.p000switch.SimpleSwitchKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Drawable0_commonMainKt;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeSteamShare.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aM\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a¯\u0001\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010 \u001a!\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010#\u001a[\u0010$\u001a\u00020\u0001*\u00020%2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010(\u001ay\u0010)\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00192\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0003¢\u0006\u0004\b.\u0010/\u001a+\u00100\u001a\u00020\u0001*\u0002012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00104\u001a-\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u000207H\u0003¢\u0006\u0004\b9\u0010:\u001a\u0015\u0010;\u001a\u00020-2\u0006\u0010'\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010<\"\u0016\u0010=\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?\"\u0016\u0010A\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\bB\u0010?¨\u0006C²\u0006\u0016\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007X\u008a\u0084\u0002²\u0006\n\u0010E\u001a\u00020FX\u008a\u0084\u0002²\u0006\n\u0010G\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u000207X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020KX\u008a\u008e\u0002"}, d2 = {"TribeeSteamShare", "", "steamInfoState", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;", "modifier", "Landroidx/compose/ui/Modifier;", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "onStateAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "(Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ShareContent", "shareVM", "Lkntr/common/share/common/ui/ShareMenuVM;", "state", "link", "", "accountInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;", "userInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "isShareAllGame", "", "isRefreshShareBottom", "capture", "onCaptureImage", "Lkntr/common/share/common/ShareImage;", "onDismiss", "Lkotlin/Function0;", "(Lkntr/common/share/common/ui/ShareMenuVM;Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LoadingDialog", "title", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ShareOtherAppBottomSheet", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "viewModel", "isMaster", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Lkotlin/jvm/functions/Function0;Lkntr/common/share/common/ui/ShareMenuVM;ZZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeSteamSharePage", "scale", "", "screenHeightDp", "Landroidx/compose/ui/unit/Dp;", "TribeeSteamSharePage-yBXNGS4", "(Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;FFLjava/lang/String;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ShareQrCode", "Landroidx/compose/foundation/layout/BoxScope;", "qrCodeProvider", "Lkntr/common/paragraph/qrcode/QrCodeProvider;", "(Landroidx/compose/foundation/layout/BoxScope;Ljava/lang/String;Lkntr/common/paragraph/qrcode/QrCodeProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SeeMoreTipCard", "firstArrowColor", "Landroidx/compose/ui/graphics/Color;", "secondArrowColor", "SeeMoreTipCard-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "getBottomSheetHeight", "(Z)F", "ShareOtherAppBottomSheetMasterHeight", "getShareOtherAppBottomSheetMasterHeight", "()F", "F", "ShareOtherAppBottomSheetGuestHeight", "getShareOtherAppBottomSheetGuestHeight", "consume_debug", "currentStateAction", "shareVMState", "Lkntr/common/share/common/ui/ShareMenuViewState;", "isVisible", "isShowBackground", "animatedBackgroundColor", "originalSize", "Landroidx/compose/ui/unit/IntSize;", "shareMenuViewSize"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamShareKt {
    private static final float ShareOtherAppBottomSheetMasterHeight = Dp.constructor-impl(184);
    private static final float ShareOtherAppBottomSheetGuestHeight = Dp.constructor-impl(132);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingDialog$lambda$3(Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        LoadingDialog(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeeMoreTipCard_RIQooxk$lambda$1(Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m1168SeeMoreTipCardRIQooxk(modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareContent$lambda$11(ShareMenuVM shareMenuVM, TribeeSteamState.SteamInfoState steamInfoState, String str, Modifier modifier, KTribeeSteamHomeData kTribeeSteamHomeData, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KTribeeSteamHomeGame kTribeeSteamHomeGame, boolean z, boolean z2, boolean z3, Function1 function1, Function0 function0, Function1 function12, int i, int i2, int i3, Composer composer, int i4) {
        ShareContent(shareMenuVM, steamInfoState, str, modifier, kTribeeSteamHomeData, kTribeeSteamHomeUserInfo, kTribeeSteamHomeGame, z, z2, z3, function1, function0, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareOtherAppBottomSheet$lambda$3(BoxWithConstraintsScope boxWithConstraintsScope, Function0 function0, ShareMenuVM shareMenuVM, boolean z, boolean z2, boolean z3, Function1 function1, int i, int i2, Composer composer, int i3) {
        ShareOtherAppBottomSheet(boxWithConstraintsScope, function0, shareMenuVM, z, z2, z3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareQrCode$lambda$1(BoxScope boxScope, String str, QrCodeProvider qrCodeProvider, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShareQrCode(boxScope, str, qrCodeProvider, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShare$lambda$10(TribeeSteamState.SteamInfoState steamInfoState, Modifier modifier, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamShare(steamInfoState, modifier, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShare$lambda$2(TribeeSteamState.SteamInfoState steamInfoState, Modifier modifier, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamShare(steamInfoState, modifier, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShare$lambda$4(TribeeSteamState.SteamInfoState steamInfoState, Modifier modifier, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamShare(steamInfoState, modifier, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSharePage_yBXNGS4$lambda$1(TribeeSteamState.SteamInfoState steamInfoState, float f, float f2, String str, KTribeeSteamHomeData kTribeeSteamHomeData, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KTribeeSteamHomeGame kTribeeSteamHomeGame, Modifier modifier, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        m1169TribeeSteamSharePageyBXNGS4(steamInfoState, f, f2, str, kTribeeSteamHomeData, kTribeeSteamHomeUserInfo, kTribeeSteamHomeGame, modifier, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShare$lambda$0$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShare$lambda$1$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x032a, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L113;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0386  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSteamShare(final TribeeSteamState.SteamInfoState steamInfoState, Modifier modifier, Function1<? super TribeeSteamUIAction, Unit> function1, Function1<? super TribeeSteamStateAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function13;
        Function1 onStateAction;
        Composer $composer2;
        Modifier modifier3;
        Function1 onUIAction;
        Function1 onStateAction2;
        Function1 onUIAction2;
        Function1 onStateAction3;
        TribeeSteamShareState shareState;
        Composer $composer3 = $composer.startRestartGroup(-519323685);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamShare)N(steamInfoState,modifier,onUIAction,onStateAction)121@5782L2,122@5840L2,128@5994L46,135@6287L16,136@6324L90,143@6497L357,143@6461L393,156@6966L100,156@6921L145:TribeeSteamShare.kt#m5suzp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(steamInfoState) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function13 = function1;
        } else if (($changed & 384) == 0) {
            function13 = function1;
            $dirty |= $composer3.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onStateAction = function12;
        } else if (($changed & 3072) == 0) {
            onStateAction = function12;
            $dirty |= $composer3.changedInstance(onStateAction) ? 2048 : 1024;
        } else {
            onStateAction = function12;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onUIAction = function13;
            onStateAction2 = onStateAction;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -853849859, "CC(remember):TribeeSteamShare.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamShare$lambda$0$0;
                            TribeeSteamShare$lambda$0$0 = TribeeSteamShareKt.TribeeSteamShare$lambda$0$0((TribeeSteamUIAction) obj);
                            return TribeeSteamShare$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onUIAction3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onUIAction2 = onUIAction3;
            } else {
                onUIAction2 = function13;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -853848003, "CC(remember):TribeeSteamShare.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamShare$lambda$1$0;
                            TribeeSteamShare$lambda$1$0 = TribeeSteamShareKt.TribeeSteamShare$lambda$1$0((TribeeSteamStateAction) obj);
                            return TribeeSteamShare$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onStateAction4 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-519323685, $dirty2, -1, "kntr.app.tribee.steam.page.share.TribeeSteamShare (TribeeSteamShare.kt:123)");
            }
            if (steamInfoState == null) {
                KLog_androidKt.getKLog().w("TribeeSteamShare", "steamInfoState is null");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final Function1 function14 = onUIAction2;
                    final Function1 function15 = onStateAction;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeSteamShare$lambda$2;
                            TribeeSteamShare$lambda$2 = TribeeSteamShareKt.TribeeSteamShare$lambda$2(TribeeSteamState.SteamInfoState.this, modifier4, function14, function15, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TribeeSteamShare$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            final State currentStateAction$delegate = SnapshotStateKt.rememberUpdatedState(onStateAction, $composer3, ($dirty2 >> 9) & 14);
            TribeeSteamShareState shareState2 = steamInfoState.getShareState();
            ShareMenuVM shareVM = steamInfoState.getShareMenuVM();
            if (shareVM == null) {
                KLog_androidKt.getKLog().w("TribeeSteamShare", "shareVM is null");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    final Function1 function16 = onUIAction2;
                    final Function1 function17 = onStateAction;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeSteamShare$lambda$4;
                            TribeeSteamShare$lambda$4 = TribeeSteamShareKt.TribeeSteamShare$lambda$4(TribeeSteamState.SteamInfoState.this, modifier5, function16, function17, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TribeeSteamShare$lambda$4;
                        }
                    });
                    return;
                }
                return;
            }
            State shareVMState$delegate = SnapshotStateKt.collectAsState(shareVM.getState(), (CoroutineContext) null, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, -853832427, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(currentStateAction$delegate);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit TribeeSteamShare$lambda$6$0;
                        TribeeSteamShare$lambda$6$0 = TribeeSteamShareKt.TribeeSteamShare$lambda$6$0(currentStateAction$delegate);
                        return TribeeSteamShare$lambda$6$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Function0 onDismiss = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -853826624, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changedInstance(shareVM) | (($dirty2 & 896) == 256);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Function2) new TribeeSteamShareKt$TribeeSteamShare$5$1(shareVM, onUIAction2, null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(shareVM, onUIAction2, (Function2) it$iv4, $composer3, ShareMenuVM.$stable | (($dirty2 >> 3) & 112));
            ShareTarget selectedChannel = TribeeSteamShare$lambda$5(shareVMState$delegate).getSelectedChannel();
            ComposerKt.sourceInformationMarkerStart($composer3, -853811873, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changed(shareVMState$delegate) | $composer3.changed(onDismiss);
            Object it$iv5 = $composer3.rememberedValue();
            if (!invalid$iv3 && it$iv5 != Composer.Companion.getEmpty()) {
                onStateAction3 = onStateAction;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(selectedChannel, (Function2) it$iv5, $composer3, ShareTarget.$stable);
                shareState = steamInfoState.getShareState();
                if (!(shareState instanceof TribeeSteamShareState.LoadingState)) {
                    $composer3.startReplaceGroup(-698177696);
                    ComposerKt.sourceInformation($composer3, "164@7170L15");
                    LoadingDialog(null, null, $composer3, 0, 3);
                    $composer3.endReplaceGroup();
                    onStateAction2 = onStateAction3;
                    onUIAction = onUIAction2;
                    $composer2 = $composer3;
                } else {
                    boolean z = false;
                    if ((shareState instanceof TribeeSteamShareState.MaterialRefreshState) || (shareState instanceof TribeeSteamShareState.MaterialLoadedSuccessState)) {
                        $composer3.startReplaceGroup(-697979017);
                        ComposerKt.sourceInformation($composer3, "187@8251L68,175@7678L708");
                        TribeeSteamShareState.MaterialLoadedSuccessState materialLoadedSuccessState = shareState2 instanceof TribeeSteamShareState.MaterialLoadedSuccessState ? (TribeeSteamShareState.MaterialLoadedSuccessState) shareState2 : null;
                        String link = materialLoadedSuccessState != null ? materialLoadedSuccessState.getShareLink() : null;
                        TribeeSteamShareState.MaterialLoadedSuccessState materialLoadedSuccessState2 = shareState2 instanceof TribeeSteamShareState.MaterialLoadedSuccessState ? (TribeeSteamShareState.MaterialLoadedSuccessState) shareState2 : null;
                        if (materialLoadedSuccessState2 != null && materialLoadedSuccessState2.isStartedCapture()) {
                            z = true;
                        }
                        onUIAction = onUIAction2;
                        boolean isStartedCapture = z;
                        boolean z2 = shareState2 instanceof TribeeSteamShareState.MaterialRefreshState;
                        KTribeeSteamHomeData steamData = steamInfoState.getSteamData();
                        KTribeeSteamHomeUserInfo userInfo = steamInfoState.getUserInfo();
                        KTribeeSteamHomeGame games = steamInfoState.getAchievementState().getGames();
                        String str = link == null ? "" : link;
                        boolean isShareAllGame = shareState2.isShareAllGame();
                        Function1<TribeeSteamStateAction, Unit> TribeeSteamShare$lambda$3 = TribeeSteamShare$lambda$3(currentStateAction$delegate);
                        ComposerKt.sourceInformationMarkerStart($composer3, -853770785, "CC(remember):TribeeSteamShare.kt#9igjgp");
                        boolean invalid$iv4 = $composer3.changed(currentStateAction$delegate);
                        Object it$iv6 = $composer3.rememberedValue();
                        if (invalid$iv4) {
                        }
                        Object value$iv5 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                Unit TribeeSteamShare$lambda$9$0;
                                TribeeSteamShare$lambda$9$0 = TribeeSteamShareKt.TribeeSteamShare$lambda$9$0(currentStateAction$delegate, (ShareImage) obj);
                                return TribeeSteamShare$lambda$9$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv6 = value$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        onStateAction2 = onStateAction3;
                        $composer2 = $composer3;
                        ShareContent(shareVM, steamInfoState, str, modifier3, steamData, userInfo, games, isShareAllGame, z2, isStartedCapture, (Function1) it$iv6, onDismiss, TribeeSteamShare$lambda$3, $composer2, ShareMenuVM.$stable | (($dirty2 << 3) & 112) | (($dirty2 << 6) & 7168), 0, 0);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-696930846);
                        $composer3.endReplaceGroup();
                        onStateAction2 = onStateAction3;
                        onUIAction = onUIAction2;
                        $composer2 = $composer3;
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            onStateAction3 = onStateAction;
            Object value$iv6 = (Function2) new TribeeSteamShareKt$TribeeSteamShare$6$1(onDismiss, shareVMState$delegate, null);
            $composer3.updateRememberedValue(value$iv6);
            it$iv5 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(selectedChannel, (Function2) it$iv5, $composer3, ShareTarget.$stable);
            shareState = steamInfoState.getShareState();
            if (!(shareState instanceof TribeeSteamShareState.LoadingState)) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function18 = onUIAction;
            final Function1 function19 = onStateAction2;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamShare$lambda$10;
                    TribeeSteamShare$lambda$10 = TribeeSteamShareKt.TribeeSteamShare$lambda$10(TribeeSteamState.SteamInfoState.this, modifier6, function18, function19, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamShare$lambda$10;
                }
            });
        }
    }

    private static final Function1<TribeeSteamStateAction, Unit> TribeeSteamShare$lambda$3(State<? extends Function1<? super TribeeSteamStateAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareMenuViewState TribeeSteamShare$lambda$5(State<ShareMenuViewState> state) {
        Object thisObj$iv = state.getValue();
        return (ShareMenuViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShare$lambda$6$0(State $currentStateAction$delegate) {
        TribeeSteamShare$lambda$3($currentStateAction$delegate).invoke(TribeeSteamStateAction.EndShare.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamShare$lambda$9$0(State $currentStateAction$delegate, ShareImage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TribeeSteamShare$lambda$3($currentStateAction$delegate).invoke(new TribeeSteamStateAction.CaptureScreenShot(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareContent$lambda$1$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r7v22 */
    private static final void ShareContent(final ShareMenuVM shareVM, final TribeeSteamState.SteamInfoState state, final String link, Modifier modifier, KTribeeSteamHomeData accountInfo, KTribeeSteamHomeUserInfo userInfo, KTribeeSteamHomeGame games, boolean isShareAllGame, boolean isRefreshShareBottom, boolean capture, Function1<? super ShareImage, Unit> function1, Function0<Unit> function0, Function1<? super TribeeSteamStateAction, Unit> function12, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        KTribeeSteamHomeData accountInfo2;
        KTribeeSteamHomeUserInfo userInfo2;
        KTribeeSteamHomeGame games2;
        boolean isRefreshShareBottom2;
        boolean capture2;
        boolean capture3;
        Function1 onCaptureImage;
        Function0 onDismiss;
        Function1 onStateAction;
        Composer $composer3 = $composer.startRestartGroup(2015558667);
        ComposerKt.sourceInformation($composer3, "C(ShareContent)N(shareVM,state,link,modifier,accountInfo,userInfo,games,isShareAllGame,isRefreshShareBottom,capture,onCaptureImage,onDismiss,onStateAction)209@8915L2,210@8973L2,212@9002L34,213@9065L34,215@9126L83,215@9105L104,221@9246L207,235@9712L3244,227@9459L3497:TribeeSteamShare.kt#m5suzp");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(shareVM) : $composer3.changedInstance(shareVM) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(link) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(modifier) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(accountInfo) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer3.changedInstance(userInfo) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(games) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(isShareAllGame) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(isRefreshShareBottom) ? 67108864 : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(capture) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function12) ? 256 : 128;
        }
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty1 & 147) == 146) ? false : true, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            KTribeeSteamHomeData accountInfo3 = i3 != 0 ? null : accountInfo;
            KTribeeSteamHomeUserInfo userInfo3 = i4 != 0 ? null : userInfo;
            KTribeeSteamHomeGame games3 = i5 != 0 ? null : games;
            boolean isShareAllGame2 = i6 != 0 ? false : isShareAllGame;
            boolean isRefreshShareBottom3 = i7 != 0 ? false : isRefreshShareBottom;
            boolean capture4 = i8 != 0 ? false : capture;
            Function1 onCaptureImage2 = i9 != 0 ? null : function1;
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -78356563, "CC(remember):TribeeSteamShare.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onDismiss2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onDismiss = onDismiss2;
            } else {
                onDismiss = function0;
            }
            if (i11 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -78354707, "CC(remember):TribeeSteamShare.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj) {
                            Unit ShareContent$lambda$1$0;
                            ShareContent$lambda$1$0 = TribeeSteamShareKt.ShareContent$lambda$1$0((TribeeSteamStateAction) obj);
                            return ShareContent$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onStateAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction2;
            } else {
                onStateAction = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015558667, $dirty, $dirty1, "kntr.app.tribee.steam.page.share.ShareContent (TribeeSteamShare.kt:211)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -78353747, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableState isVisible$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -78351731, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            MutableState isShowBackground$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -78349730, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = (Function2) new TribeeSteamShareKt$ShareContent$3$1(isVisible$delegate, isShowBackground$delegate, null);
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv5, $composer3, 6);
            final State animatedBackgroundColor$delegate = SingleValueAnimationKt.animateColorAsState-euL9pac(ShareContent$lambda$6(isShowBackground$delegate) ? Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : Color.Companion.getTransparent-0d7_KjU(), AnimationSpecKt.tween$default(200, 0, (Easing) null, 6, (Object) null), "background_color_animation", (Function1) null, $composer3, 432, 8);
            boolean ShareContent$lambda$3 = ShareContent$lambda$3(isVisible$delegate);
            EnterTransition plus = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.scaleIn-L8ZKh-E$default(AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), 0.8f, 0L, 4, (Object) null));
            final Modifier modifier4 = modifier3;
            final KTribeeSteamHomeData kTribeeSteamHomeData = accountInfo3;
            final KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo = userInfo3;
            final KTribeeSteamHomeGame kTribeeSteamHomeGame = games3;
            final boolean z = capture4;
            final Function1 function13 = onCaptureImage2;
            final Function0 function02 = onDismiss;
            final boolean z2 = isShareAllGame2;
            final boolean z3 = isRefreshShareBottom3;
            final Function1 function14 = onStateAction;
            Function3 function3 = new Function3() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShareContent$lambda$10;
                    ShareContent$lambda$10 = TribeeSteamShareKt.ShareContent$lambda$10(modifier4, animatedBackgroundColor$delegate, state, link, kTribeeSteamHomeData, kTribeeSteamHomeUserInfo, kTribeeSteamHomeGame, z, function13, function02, shareVM, z2, z3, function14, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShareContent$lambda$10;
                }
            };
            $composer2 = $composer3;
            AnimatedVisibilityKt.AnimatedVisibility(ShareContent$lambda$3, (Modifier) null, plus, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1610461469, true, function3, $composer2, 54), $composer2, 196608, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onCaptureImage = onCaptureImage2;
            capture3 = capture4;
            capture2 = isRefreshShareBottom3;
            isRefreshShareBottom2 = isShareAllGame2;
            games2 = games3;
            userInfo2 = userInfo3;
            accountInfo2 = accountInfo3;
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            accountInfo2 = accountInfo;
            userInfo2 = userInfo;
            games2 = games;
            isRefreshShareBottom2 = isShareAllGame;
            capture2 = isRefreshShareBottom;
            capture3 = capture;
            onCaptureImage = function1;
            onDismiss = function0;
            onStateAction = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final KTribeeSteamHomeData kTribeeSteamHomeData2 = accountInfo2;
            final KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo2 = userInfo2;
            final KTribeeSteamHomeGame kTribeeSteamHomeGame2 = games2;
            final boolean z4 = isRefreshShareBottom2;
            final boolean z5 = capture2;
            final boolean z6 = capture3;
            final Function1 function15 = onCaptureImage;
            final Function0 function03 = onDismiss;
            final Function1 function16 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareContent$lambda$11;
                    ShareContent$lambda$11 = TribeeSteamShareKt.ShareContent$lambda$11(ShareMenuVM.this, state, link, modifier5, kTribeeSteamHomeData2, kTribeeSteamHomeUserInfo2, kTribeeSteamHomeGame2, z4, z5, z6, function15, function03, function16, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareContent$lambda$11;
                }
            });
        }
    }

    private static final boolean ShareContent$lambda$3(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShareContent$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean ShareContent$lambda$6(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShareContent$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final long ShareContent$lambda$9(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareContent$lambda$10(Modifier $modifier, State $animatedBackgroundColor$delegate, final TribeeSteamState.SteamInfoState $state, final String $link, final KTribeeSteamHomeData $accountInfo, final KTribeeSteamHomeUserInfo $userInfo, final KTribeeSteamHomeGame $games, final boolean $capture, final Function1 $onCaptureImage, final Function0 $onDismiss, final ShareMenuVM $shareVM, final boolean $isShareAllGame, final boolean $isRefreshShareBottom, final Function1 $onStateAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C241@9921L2,242@9935L3015,236@9722L3228:TribeeSteamShare.kt#m5suzp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610461469, $changed, -1, "kntr.app.tribee.steam.page.share.ShareContent.<anonymous> (TribeeSteamShare.kt:236)");
        }
        Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), ShareContent$lambda$9($animatedBackgroundColor$delegate), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -1465238459, "CC(remember):TribeeSteamShare.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda29
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BoxWithConstraintsKt.BoxWithConstraints(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-1243086151, true, new Function3() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda30
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ShareContent$lambda$10$1;
                ShareContent$lambda$10$1 = TribeeSteamShareKt.ShareContent$lambda$10$1(TribeeSteamState.SteamInfoState.this, $link, $accountInfo, $userInfo, $games, $capture, $onCaptureImage, $onDismiss, $shareVM, $isShareAllGame, $isRefreshShareBottom, $onStateAction, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ShareContent$lambda$10$1;
            }
        }, $composer, 54), $composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareContent$lambda$10$1(TribeeSteamState.SteamInfoState $state, String $link, KTribeeSteamHomeData $accountInfo, KTribeeSteamHomeUserInfo $userInfo, KTribeeSteamHomeGame $games, boolean $capture, Function1 $onCaptureImage, Function0 $onDismiss, ShareMenuVM $shareVM, boolean $isShareAllGame, boolean $isRefreshShareBottom, Function1 $onStateAction, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        MutableFloatState heightScale;
        MutableFloatState widthScale;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C243@9981L7,245@10092L11,245@10104L17,248@10314L70,255@10515L308,265@10870L310,275@11221L194,281@11457L182,290@11765L278,296@12058L194,287@11653L958,312@12625L315:TribeeSteamShare.kt#m5suzp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1243086151, $dirty2, -1, "kntr.app.tribee.steam.page.share.ShareContent.<anonymous>.<anonymous> (TribeeSteamShare.kt:243)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density localDensity = (Density) consume;
            float f = Dp.constructor-impl(Dp.constructor-impl($this$BoxWithConstraints.getMaxHeight-D9Ej5fM() - Dp.constructor-impl(getBottomSheetHeight($state.isMaster()) + WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSafeContent(WindowInsets.Companion, $composer, 6), $composer, 0).calculateBottomPadding-D9Ej5fM())) - Dp.constructor-impl(16));
            float f2 = Dp.constructor-impl($this$BoxWithConstraints.getMaxWidth-D9Ej5fM() - Dp.constructor-impl(32));
            ComposerKt.sourceInformationMarkerStart($composer, -604870625, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.constructor-impl((0 << 32) | (0 & 4294967295L))), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState originalSize$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            float screenHeight = localDensity.toDp-u2uoSUM(Constraints.getMaxHeight-impl($this$BoxWithConstraints.getConstraints-msEJaDk()));
            long ShareContent$lambda$10$1$1 = ShareContent$lambda$10$1$1(originalSize$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -604863955, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv = $composer.changed(ShareContent$lambda$10$1$1);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2 / localDensity.toDp-u2uoSUM((int) (ShareContent$lambda$10$1$1(originalSize$delegate) >> 32)));
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableFloatState widthScale2 = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            long ShareContent$lambda$10$1$12 = ShareContent$lambda$10$1$1(originalSize$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -604852593, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(ShareContent$lambda$10$1$12);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(f / localDensity.toDp-u2uoSUM((int) (ShareContent$lambda$10$1$1(originalSize$delegate) & 4294967295L)));
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableFloatState heightScale2 = (MutableFloatState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -604841477, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed(widthScale2) | $composer.changed(heightScale2);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Math.min(widthScale2.getFloatValue(), heightScale2.getFloatValue()));
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableFloatState scale = (MutableFloatState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -604833937, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed(scale);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                heightScale = heightScale2;
                widthScale = widthScale2;
                Object value$iv5 = PrimitiveSnapshotStateKt.mutableFloatStateOf((((int) (ShareContent$lambda$10$1$1(originalSize$delegate) & 4294967295L)) * (1.0f - scale.getFloatValue())) / 2.0f);
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            } else {
                heightScale = heightScale2;
                widthScale = widthScale2;
            }
            final MutableFloatState offset = (MutableFloatState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -604823985, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv6 = $composer.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        Unit ShareContent$lambda$10$1$8$0;
                        ShareContent$lambda$10$1$8$0 = TribeeSteamShareKt.ShareContent$lambda$10$1$8$0(originalSize$delegate, (LayoutCoordinates) obj);
                        return ShareContent$lambda$10$1$8$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier onPlaced = OnPlacedModifierKt.onPlaced(modifier, (Function1) it$iv6);
            ComposerKt.sourceInformationMarkerStart($composer, -604814693, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv5 = $composer.changed(scale) | $composer.changed(offset);
            Object it$iv7 = $composer.rememberedValue();
            if (invalid$iv5 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        Unit ShareContent$lambda$10$1$9$0;
                        ShareContent$lambda$10$1$9$0 = TribeeSteamShareKt.ShareContent$lambda$10$1$9$0(scale, offset, (GraphicsLayerScope) obj);
                        return ShareContent$lambda$10$1$9$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            m1169TribeeSteamSharePageyBXNGS4($state, scale.getFloatValue(), screenHeight, $link, $accountInfo, $userInfo, $games, GraphicsLayerModifierKt.graphicsLayer(onPlaced, (Function1) it$iv7), $capture, $onCaptureImage, $composer, 0, 0);
            ShareOtherAppBottomSheet($this$BoxWithConstraints, $onDismiss, $shareVM, $state.isMaster(), $isShareAllGame, $isRefreshShareBottom, $onStateAction, $composer, ($dirty2 & 14) | (ShareMenuVM.$stable << 6), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final long ShareContent$lambda$10$1$1(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void ShareContent$lambda$10$1$2(MutableState<IntSize> mutableState, long j) {
        Object value$iv = IntSize.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareContent$lambda$10$1$8$0(MutableState $originalSize$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ShareContent$lambda$10$1$2($originalSize$delegate, it.getSize-YbymL2g());
        KLog_androidKt.getKLog().i("TribeeSteamShare", "TribeeSteamSharePage onPlaced: size=" + IntSize.toString-impl(it.getSize-YbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareContent$lambda$10$1$9$0(MutableFloatState $scale, MutableFloatState $offset, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX($scale.getFloatValue());
        $this$graphicsLayer.setScaleY($scale.getFloatValue());
        $this$graphicsLayer.setTranslationY(-$offset.getValue().floatValue());
        return Unit.INSTANCE;
    }

    private static final void LoadingDialog(Modifier modifier, String title, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final String title2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-662273923);
        ComposerKt.sourceInformation($composer2, "C(LoadingDialog)N(modifier,title)334@13258L39,336@13356L2,329@13114L1229:TribeeSteamShare.kt#m5suzp");
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
                title2 = title;
                if ($composer2.changed(title2)) {
                    i2 = 32;
                    $dirty |= i2;
                }
            } else {
                title2 = title;
            }
            i2 = 16;
            $dirty |= i2;
        } else {
            title2 = title;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "327@13054L50");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 2) != 0) {
                    $dirty &= -113;
                    title2 = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_24(Res.string.INSTANCE), $composer2, 0);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-662273923, $dirty, -1, "kntr.app.tribee.steam.page.share.LoadingDialog (TribeeSteamShare.kt:328)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -790071260, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -790068161, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv$iv = ClickableKt.clickable-O2vRcR0$default(fillMaxSize$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv2 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$LoadingDialog_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -536401909, "C338@13376L961:TribeeSteamShare.kt#m5suzp");
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs($this$LoadingDialog_u24lambda_u242.align(Modifier.Companion, Alignment.Companion.getCenter()), Dp.constructor-impl(88)), Color.copy-wmQWz5c$default(BiliColorsSourceKt.getDayColors().getGa9-0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), 0.0f, Dp.constructor-impl(24), 0.0f, Dp.constructor-impl(12), 5, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1567556064, "C350@13887L27,351@13927L241,360@14251L9,361@14300L6,358@14181L146:TribeeSteamShare.kt#m5suzp");
            String url = LoadingAnimateImageKt.getLoadingAnimateImageUri($composer2, 0);
            $composer2.startReplaceGroup(-327657771);
            ComposerKt.sourceInformation($composer2, "*354@14063L6");
            ImageRequest $this$LoadingDialog_u24lambda_u242_u240_u240 = new ImageRequest(url);
            $this$LoadingDialog_u24lambda_u242_u240_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$LoadingDialog_u24lambda_u242_u240_u240.build();
            $composer2.endReplaceGroup();
            BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), null, null, null, null, null, null, null, $composer2, 48, 508);
            TextKt.Text-Nvy7gAk(title2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, ($dirty >> 3) & 14, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier$iv$iv2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadingDialog$lambda$3;
                    LoadingDialog$lambda$3 = TribeeSteamShareKt.LoadingDialog$lambda$3(modifier2, title2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadingDialog$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareOtherAppBottomSheet$lambda$0$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v45 */
    private static final void ShareOtherAppBottomSheet(final BoxWithConstraintsScope $this$ShareOtherAppBottomSheet, final Function0<Unit> function0, final ShareMenuVM viewModel, boolean isMaster, boolean isShareAllGame, boolean isRefreshShareBottom, Function1<? super TribeeSteamStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean isRefreshShareBottom2;
        Function1 function12;
        Composer $composer2;
        boolean isMaster2;
        boolean isShareAllGame2;
        boolean isRefreshShareBottom3;
        Function1 onStateAction;
        Function1 onStateAction2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        int $dirty;
        String str;
        boolean z2;
        Composer $composer3;
        Composer $composer4;
        Composer $composer$iv;
        Composer $composer5;
        String str2;
        Composer $composer6;
        Function0 factory$iv$iv$iv4;
        final Function1 onStateAction3;
        Composer $composer7 = $composer.startRestartGroup(-413772090);
        ComposerKt.sourceInformation($composer7, "C(ShareOtherAppBottomSheet)N(onDismiss,viewModel,isMaster,isShareAllGame,isRefreshShareBottom,onStateAction)375@14681L2,385@14964L11,386@15009L17,390@15209L6,393@15401L2,378@14752L4769:TribeeSteamShare.kt#m5suzp");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer7.changed($this$ShareOtherAppBottomSheet) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer7.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ($changed & 512) == 0 ? $composer7.changed(viewModel) : $composer7.changedInstance(viewModel) ? 256 : 128;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer7.changed(isMaster) ? 2048 : 1024;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 24576;
            z = isShareAllGame;
        } else if (($changed & 24576) == 0) {
            z = isShareAllGame;
            $dirty2 |= $composer7.changed(z) ? 16384 : 8192;
        } else {
            z = isShareAllGame;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 196608;
            isRefreshShareBottom2 = isRefreshShareBottom;
        } else if ((196608 & $changed) == 0) {
            isRefreshShareBottom2 = isRefreshShareBottom;
            $dirty2 |= $composer7.changed(isRefreshShareBottom2) ? 131072 : 65536;
        } else {
            isRefreshShareBottom2 = isRefreshShareBottom;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 1572864;
            function12 = function1;
        } else if ((1572864 & $changed) == 0) {
            function12 = function1;
            $dirty2 |= $composer7.changedInstance(function12) ? 1048576 : 524288;
        } else {
            function12 = function1;
        }
        if ($composer7.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            boolean isMaster3 = i2 != 0 ? true : isMaster;
            isShareAllGame2 = i3 != 0 ? false : z;
            if (i4 != 0) {
                isRefreshShareBottom2 = false;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer7, 1796988776, "CC(remember):TribeeSteamShare.kt#9igjgp");
                Object it$iv = $composer7.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda24
                        public final Object invoke(Object obj) {
                            Unit ShareOtherAppBottomSheet$lambda$0$0;
                            ShareOtherAppBottomSheet$lambda$0$0 = TribeeSteamShareKt.ShareOtherAppBottomSheet$lambda$0$0((TribeeSteamStateAction) obj);
                            return ShareOtherAppBottomSheet$lambda$0$0;
                        }
                    };
                    $composer7.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction4 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer7);
                onStateAction2 = onStateAction4;
            } else {
                onStateAction2 = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-413772090, $dirty2, -1, "kntr.app.tribee.steam.page.share.ShareOtherAppBottomSheet (TribeeSteamShare.kt:376)");
            }
            float bottomSheetHeight = getBottomSheetHeight(isMaster3);
            Modifier align = $this$ShareOtherAppBottomSheet.align(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(bottomSheetHeight + WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSafeContent(WindowInsets.Companion, $composer7, 6), $composer7, 0).calculateBottomPadding-D9Ej5fM()), bottomSheetHeight))), BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(16), Dp.constructor-impl(16), 0.0f, 0.0f, 12, (Object) null)), Alignment.Companion.getBottomCenter());
            ComposerKt.sourceInformationMarkerStart($composer7, 1797011816, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv2 = $composer7.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer7.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer7);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 14, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer7, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer7, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer7, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer7.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer7);
            Function1 onStateAction5 = onStateAction2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -61238779, "C396@15481L1106,427@16622L41,428@16704L7,430@16752L239,438@17001L1034:TribeeSteamShare.kt#m5suzp");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), Dp.constructor-impl(12), Dp.constructor-impl(12));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            $composer2 = $composer7;
            ComposerKt.sourceInformationMarkerStart($composer7, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer7, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer7.getCurrentCompositionLocalMap();
            isMaster2 = isMaster3;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer7, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer7.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer7);
            int $dirty3 = $dirty2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i9 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, 997199597, "C406@15848L50,407@15934L6,408@15982L9,405@15819L225,413@16103L20,415@16209L6,421@16449L39,412@16058L519:TribeeSteamShare.kt#m5suzp");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_20(Res.string.INSTANCE), $composer7, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer7, BiliTheme.$stable).getT14(), $composer7, 24576, 0, 131050);
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer7, 6);
            long j = BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer7, 1279113159, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv3 = $composer7.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                $composer7.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer7);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, "close icon", ClickableKt.clickable-O2vRcR0$default(modifier, (MutableInteractionSource) it$iv3, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), j, $composer7, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerStart($composer7, -1525963579, "CC(remember):TribeeSteamShare.kt#9igjgp");
            Object it$iv4 = $composer7.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer7.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState shareMenuViewSize$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer7);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer7.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            Density localDensity = (Density) consume;
            long ShareOtherAppBottomSheet$lambda$2$2 = ShareOtherAppBottomSheet$lambda$2$2(shareMenuViewSize$delegate);
            ComposerKt.sourceInformationMarkerStart($composer7, -1525959221, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv = $composer7.changed(ShareOtherAppBottomSheet$lambda$2$2);
            Object it$iv5 = $composer7.rememberedValue();
            if (invalid$iv || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = Dp.box-impl(((int) (ShareOtherAppBottomSheet$lambda$2$2(shareMenuViewSize$delegate) & 4294967295L)) > 0 ? localDensity.toDp-u2uoSUM((int) (ShareOtherAppBottomSheet$lambda$2$2(shareMenuViewSize$delegate) & 4294967295L)) : Dp.constructor-impl(72));
                $composer7.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            float contentHeight = ((Dp) it$iv5).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), contentHeight);
            ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer7, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer7.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i11 = ((0 >> 6) & 112) | 6;
            BoxScope $this$ShareOtherAppBottomSheet_u24lambda_u242_u245 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer7, -1336287554, "C:TribeeSteamShare.kt#m5suzp");
            if (isRefreshShareBottom2) {
                $composer7.startReplaceGroup(-1336277015);
                ComposerKt.sourceInformation($composer7, "445@17212L27,446@17256L289");
                String url = LoadingAnimateImageKt.getLoadingAnimateImageUri($composer7, 0);
                $composer7.startReplaceGroup(-874385442);
                ComposerKt.sourceInformation($composer7, "*449@17404L6");
                ImageRequest $this$ShareOtherAppBottomSheet_u24lambda_u242_u245_u240 = new ImageRequest(url);
                $this$ShareOtherAppBottomSheet_u24lambda_u242_u245_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0, 2, (Object) null));
                ImmutableImageRequest build = $this$ShareOtherAppBottomSheet_u24lambda_u242_u245_u240.build();
                $composer7.endReplaceGroup();
                BiliImageKt.BiliImage(build, $this$ShareOtherAppBottomSheet_u24lambda_u242_u245.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Alignment.Companion.getCenter()), null, null, null, null, null, null, null, $composer7, 0, 508);
                $composer7.endReplaceGroup();
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                onStateAction = onStateAction5;
                $composer4 = $composer7;
                $composer$iv$iv$iv = $composer7;
                $composer$iv = $composer7;
                z2 = true;
                $composer3 = $composer7;
                str2 = "CC(remember):TribeeSteamShare.kt#9igjgp";
                $composer5 = $composer7;
                $composer$iv$iv = $composer7;
                $dirty = $dirty3;
            } else {
                $composer7.startReplaceGroup(-1335896428);
                ComposerKt.sourceInformation($composer7, "459@17800L192,454@17583L428");
                Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer7, -874370174, "CC(remember):TribeeSteamShare.kt#9igjgp");
                Object it$iv6 = $composer7.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda26
                        public final Object invoke(Object obj) {
                            Unit ShareOtherAppBottomSheet$lambda$2$5$1$0;
                            ShareOtherAppBottomSheet$lambda$2$5$1$0 = TribeeSteamShareKt.ShareOtherAppBottomSheet$lambda$2$5$1$0(shareMenuViewSize$delegate, (LayoutCoordinates) obj);
                            return ShareOtherAppBottomSheet$lambda$2$5$1$0;
                        }
                    };
                    $composer7.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer7);
                $composer$iv$iv = $composer7;
                $composer$iv$iv$iv = $composer7;
                $dirty = $dirty3;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                z2 = true;
                $composer3 = $composer7;
                $composer4 = $composer7;
                $composer$iv = $composer7;
                $composer5 = $composer7;
                onStateAction = onStateAction5;
                str2 = "CC(remember):TribeeSteamShare.kt#9igjgp";
                ShareMenuViewKt.ShareMenuView(viewModel, OnPlacedModifierKt.onPlaced(modifier2, (Function1) it$iv6), null, null, $composer3, ShareMenuVM.$stable | 48 | (($dirty3 >> 6) & 14), 12);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            if (isMaster2) {
                $composer6 = $composer4;
                $composer6.startReplaceGroup(-58763523);
                ComposerKt.sourceInformation($composer6, "475@18346L6,469@18073L1361");
                Modifier modifier$iv4 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(20), Dp.constructor-impl(12), Dp.constructor-impl(16)), Dp.constructor-impl(36)), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getGraph_bg_thin_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv4 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, str);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Row = $changed$iv$iv4 << 6;
                int $changed$iv$iv$iv4 = ($i$f$Row & 896) | 6;
                isRefreshShareBottom3 = isRefreshShareBottom2;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer6.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer6);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i13 = ((432 >> 6) & 112) | 6;
                RowScope $this$ShareOtherAppBottomSheet_u24lambda_u242_u246 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer6, -1463946871, "C482@18686L50,483@18776L6,484@18828L9,481@18653L355,491@19026L39,495@19181L143,493@19083L337:TribeeSteamShare.kt#m5suzp");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_39(Res.string.INSTANCE), $composer6, 0), RowScope.-CC.weight$default($this$ShareOtherAppBottomSheet_u24lambda_u242_u246, SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(17)), 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), $composer6, 0, 0, 131064);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer6, 6);
                ComposerKt.sourceInformationMarkerStart($composer6, -1432681142, str2);
                boolean invalid$iv2 = ($dirty & 3670016) == 1048576 ? z2 : false;
                Object it$iv7 = $composer6.rememberedValue();
                if (!invalid$iv2 && it$iv7 != Composer.Companion.getEmpty()) {
                    onStateAction3 = onStateAction;
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    onStateAction = onStateAction3;
                    SimpleSwitchKt.SimpleSwitch(isShareAllGame2, (Function1) it$iv7, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(32), Dp.constructor-impl(20)), false, null, null, $composer6, (($dirty >> 12) & 14) | 384, 56);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    $composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    $composer6.endReplaceGroup();
                }
                onStateAction3 = onStateAction;
                Object value$iv7 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda27
                    public final Object invoke(Object obj) {
                        Unit ShareOtherAppBottomSheet$lambda$2$6$0$0;
                        ShareOtherAppBottomSheet$lambda$2$6$0$0 = TribeeSteamShareKt.ShareOtherAppBottomSheet$lambda$2$6$0$0(onStateAction3, ((Boolean) obj).booleanValue());
                        return ShareOtherAppBottomSheet$lambda$2$6$0$0;
                    }
                };
                $composer6.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer6);
                onStateAction = onStateAction3;
                SimpleSwitchKt.SimpleSwitch(isShareAllGame2, (Function1) it$iv7, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(32), Dp.constructor-impl(20)), false, null, null, $composer6, (($dirty >> 12) & 14) | 384, 56);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endReplaceGroup();
            } else {
                isRefreshShareBottom3 = isRefreshShareBottom2;
                $composer6 = $composer4;
                $composer6.startReplaceGroup(-57424571);
                ComposerKt.sourceInformation($composer6, "502@19464L41");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer6, 6);
                $composer6.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer7;
            $composer2.skipToGroupEnd();
            isMaster2 = isMaster;
            isShareAllGame2 = z;
            isRefreshShareBottom3 = isRefreshShareBottom2;
            onStateAction = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z3 = isMaster2;
            final boolean z4 = isShareAllGame2;
            final boolean z5 = isRefreshShareBottom3;
            final Function1 function13 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareOtherAppBottomSheet$lambda$3;
                    ShareOtherAppBottomSheet$lambda$3 = TribeeSteamShareKt.ShareOtherAppBottomSheet$lambda$3($this$ShareOtherAppBottomSheet, function0, viewModel, z3, z4, z5, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareOtherAppBottomSheet$lambda$3;
                }
            });
        }
    }

    private static final long ShareOtherAppBottomSheet$lambda$2$2(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void ShareOtherAppBottomSheet$lambda$2$3(MutableState<IntSize> mutableState, long j) {
        Object value$iv = IntSize.box-impl(j);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareOtherAppBottomSheet$lambda$2$5$1$0(MutableState $shareMenuViewSize$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!IntSize.equals-impl0(it.getSize-YbymL2g(), IntSize.Companion.getZero-YbymL2g())) {
            ShareOtherAppBottomSheet$lambda$2$3($shareMenuViewSize$delegate, it.getSize-YbymL2g());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareOtherAppBottomSheet$lambda$2$6$0$0(Function1 $onStateAction, boolean isChecked) {
        $onStateAction.invoke(new TribeeSteamStateAction.ToggleShareRange(isChecked));
        return Unit.INSTANCE;
    }

    /* renamed from: TribeeSteamSharePage-yBXNGS4  reason: not valid java name */
    private static final void m1169TribeeSteamSharePageyBXNGS4(final TribeeSteamState.SteamInfoState state, final float scale, final float f, final String link, final KTribeeSteamHomeData accountInfo, final KTribeeSteamHomeUserInfo userInfo, final KTribeeSteamHomeGame games, Modifier modifier, boolean capture, Function1<? super ShareImage, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean capture2;
        Function1 onCaptureImage;
        Modifier modifier3;
        int $dirty;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-1340009452);
        ComposerKt.sourceInformation($composer2, "C(TribeeSteamSharePage)N(state,scale,screenHeightDp:c#ui.unit.Dp,link,accountInfo,userInfo,games,modifier,capture,onCaptureImage)525@20103L10,526@20127L17,528@20239L23,529@20288L24,533@20383L4776,531@20318L4841:TribeeSteamShare.kt#m5suzp");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(scale) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(f) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(link) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(accountInfo) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(userInfo) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(games) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            if ((i & 128) == 0 && $composer2.changed(modifier)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        }
        int i3 = i & 256;
        if (i3 != 0) {
            $dirty2 |= 100663296;
        } else if ((100663296 & $changed) == 0) {
            $dirty2 |= $composer2.changed(capture) ? 67108864 : 33554432;
        }
        int i4 = i & 512;
        if (i4 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 536870912 : 268435456;
        }
        if ($composer2.shouldExecute(($dirty2 & 306783379) != 306783378, $dirty2 & 1)) {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 128) != 0) {
                    modifier3 = ClipKt.clip(SizeKt.wrapContentHeight$default(Modifier.Companion, (Alignment.Vertical) null, true, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20)));
                    $dirty2 &= -29360129;
                } else {
                    modifier3 = modifier;
                }
                boolean capture3 = i3 != 0 ? false : capture;
                if (i4 != 0) {
                    $dirty = $dirty2;
                    capture2 = capture3;
                    onCaptureImage = null;
                } else {
                    onCaptureImage = function1;
                    $dirty = $dirty2;
                    capture2 = capture3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                modifier3 = modifier;
                capture2 = capture;
                onCaptureImage = function1;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1340009452, $dirty, -1, "kntr.app.tribee.steam.page.share.TribeeSteamSharePage (TribeeSteamShare.kt:522)");
            }
            float f2 = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6), $composer2, 0).calculateTopPadding-D9Ej5fM();
            float other$iv = (scale > 0.0f ? 1 : (scale == 0.0f ? 0 : -1)) == 0 ? 1.0f : scale;
            final float statusBarPadding = Dp.constructor-impl(f2 / other$iv);
            final GraphicsLayer graphicsLayer = GraphicsLayerScopeKt.rememberGraphicsLayer($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Modifier modifier4 = modifier3;
            final boolean z = capture2;
            final Function1 function12 = onCaptureImage;
            BiliThemeKt.BiliTheme(ThemeStrategy.ForceDay, false, ComposableLambdaKt.rememberComposableLambda(1975795548, true, new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamSharePage_yBXNGS4$lambda$0;
                    TribeeSteamSharePage_yBXNGS4$lambda$0 = TribeeSteamShareKt.TribeeSteamSharePage_yBXNGS4$lambda$0(modifier4, statusBarPadding, z, graphicsLayer, coroutineScope, function12, state, link, f, accountInfo, userInfo, games, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamSharePage_yBXNGS4$lambda$0;
                }
            }, $composer2, 54), $composer2, 390, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            capture2 = capture;
            onCaptureImage = function1;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final boolean z2 = capture2;
            final Function1 function13 = onCaptureImage;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamSharePage_yBXNGS4$lambda$1;
                    TribeeSteamSharePage_yBXNGS4$lambda$1 = TribeeSteamShareKt.TribeeSteamSharePage_yBXNGS4$lambda$1(TribeeSteamState.SteamInfoState.this, scale, f, link, accountInfo, userInfo, games, modifier5, z2, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamSharePage_yBXNGS4$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x03ca, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x065f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeSteamSharePage_yBXNGS4$lambda$0(Modifier $modifier, float $statusBarPadding, boolean $capture, final GraphicsLayer $graphicsLayer, final CoroutineScope $coroutineScope, final Function1 $onCaptureImage, TribeeSteamState.SteamInfoState $state, String $link, float f, KTribeeSteamHomeData $accountInfo, KTribeeSteamHomeUserInfo $userInfo, KTribeeSteamHomeGame $games, Composer $composer, int $changed) {
        Modifier modifier;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        BoxScope $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241;
        Composer $composer2;
        ComposerKt.sourceInformation($composer, "C540@20627L6,534@20393L4760:TribeeSteamShare.kt#m5suzp");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1975795548, $changed, -1, "kntr.app.tribee.steam.page.share.TribeeSteamSharePage.<anonymous> (TribeeSteamShare.kt:534)");
            }
            Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-qDBjuR0$default($modifier, 0.0f, $statusBarPadding, 0.0f, 0.0f, 13, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
            if ($capture) {
                $composer.startReplaceGroup(-1601282473);
                ComposerKt.sourceInformation($composer, "543@20755L520");
                Modifier modifier3 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, 363989220, "CC(remember):TribeeSteamShare.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($graphicsLayer) | $composer.changedInstance($coroutineScope) | $composer.changed($onCaptureImage);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda22
                        public final Object invoke(Object obj) {
                            DrawResult TribeeSteamSharePage_yBXNGS4$lambda$0$0$0;
                            TribeeSteamSharePage_yBXNGS4$lambda$0$0$0 = TribeeSteamShareKt.TribeeSteamSharePage_yBXNGS4$lambda$0$0$0($graphicsLayer, $coroutineScope, $onCaptureImage, (CacheDrawScope) obj);
                            return TribeeSteamSharePage_yBXNGS4$lambda$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                modifier = DrawModifierKt.drawWithCache(modifier3, (Function1) it$iv);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-1600706834);
                $composer.endReplaceGroup();
                modifier = Modifier.Companion;
            }
            Modifier modifier$iv = modifier2.then(modifier);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -312769229, "C561@21503L6,558@21385L2623,633@24740L403:TribeeSteamShare.kt#m5suzp");
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(20), 0.0f, Dp.constructor-impl((float) ConstantsKt.UGC_UPDATE_CALENDAR_CARD_COVER_WIDTH), 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, $i$f$Column);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i3 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 2058826680, "C566@21708L65,565@21671L384,574@22084L52,582@22501L909,575@22153L1841:TribeeSteamShare.kt#m5suzp");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getTribee_steam_page_share_header(Res.drawable.INSTANCE), $composer, 0), (String) null, $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241_u240.align(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(175)), Dp.constructor-impl(48)), Alignment.Companion.getCenterHorizontally()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            final ImageBitmap dotBg = ImageResourcesKt.imageResource(Drawable0_commonMainKt.getTribee_steam_bg_dot(Res.drawable.INSTANCE), $composer, 0);
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.heightIn-VpY3zN4$default(SizeKt.wrapContentHeight$default(Modifier.Companion, (Alignment.Vertical) null, false, 3, (Object) null), 0.0f, f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20))), Color.Companion.getWhite-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -764845083, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(dotBg);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj) {
                    Unit TribeeSteamSharePage_yBXNGS4$lambda$0$1$0$0$0;
                    TribeeSteamSharePage_yBXNGS4$lambda$0$1$0$0$0 = TribeeSteamShareKt.TribeeSteamSharePage_yBXNGS4$lambda$0$1$0$0$0(dotBg, (DrawScope) obj);
                    return TribeeSteamSharePage_yBXNGS4$lambda$0$1$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(DrawModifierKt.drawBehind(modifier4, (Function1) it$iv2), 0.0f, Dp.constructor-impl(40), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241_u240_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -2128724722, "C610@23837L23,602@23473L503:TribeeSteamShare.kt#m5suzp");
            TribeeSteamListKt.TribeeSteamList($state, LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3), $accountInfo, $userInfo, $games, $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241_u240_u241.align(Modifier.Companion, Alignment.Companion.getTopCenter()), $state.isMaster(), true, null, null, null, $composer, 12582912, 0, 1792);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeSteamGameAchievementState achievementState = $state.getAchievementState();
            if (!(achievementState instanceof TribeeSteamGameAchievementState.SuccessGameAchievementState)) {
                $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241 = $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u2412;
                $composer2 = $composer;
            } else if (((TribeeSteamGameAchievementState.SuccessGameAchievementState) achievementState).getSectionList().size() < 2) {
                $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241 = $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u2412;
                $composer2 = $composer;
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-310010633);
                ComposerKt.sourceInformation($composer2, "621@24287L425");
                $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241 = $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u2412;
                m1168SeeMoreTipCardRIQooxk(ClipKt.clip($this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl((float) ConstantsKt.UGC_UPDATE_CALENDAR_CARD_COVER_WIDTH), 7, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl((float) ConstantsKt.RESERVATION_CARD_HEIGHT)), Alignment.Companion.getBottomCenter()), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20))), 0L, 0L, $composer2, 0, 6);
                $composer2.endReplaceGroup();
                ShareQrCode($this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241, $link, $state.getQrCodeProvider(), $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(20), 7, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(74)), Alignment.Companion.getBottomCenter()), $composer2, $changed2 & 14, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $composer2.startReplaceGroup(-334100640);
            $composer2.endReplaceGroup();
            ShareQrCode($this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241, $link, $state.getQrCodeProvider(), $this$TribeeSteamSharePage_yBXNGS4_u24lambda_u240_u241.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(20), 7, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(74)), Alignment.Companion.getBottomCenter()), $composer2, $changed2 & 14, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult TribeeSteamSharePage_yBXNGS4$lambda$0$0$0(final GraphicsLayer $graphicsLayer, final CoroutineScope $coroutineScope, final Function1 $onCaptureImage, CacheDrawScope $this$drawWithCache) {
        Intrinsics.checkNotNullParameter($this$drawWithCache, "$this$drawWithCache");
        return $this$drawWithCache.onDrawWithContent(new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0;
                TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0 = TribeeSteamShareKt.TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0($graphicsLayer, $coroutineScope, $onCaptureImage, (ContentDrawScope) obj);
                return TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0(GraphicsLayer $graphicsLayer, CoroutineScope $coroutineScope, Function1 $onCaptureImage, final ContentDrawScope $this$onDrawWithContent) {
        Intrinsics.checkNotNullParameter($this$onDrawWithContent, "$this$onDrawWithContent");
        DrawScope.-CC.record-JVtK1S4$default((DrawScope) $this$onDrawWithContent, $graphicsLayer, 0L, new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0$0;
                TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0$0 = TribeeSteamShareKt.TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0$0($this$onDrawWithContent, (DrawScope) obj);
                return TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0$0;
            }
        }, 1, (Object) null);
        GraphicsLayerKt.drawLayer((DrawScope) $this$onDrawWithContent, $graphicsLayer);
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TribeeSteamShareKt$TribeeSteamSharePage$1$1$1$1$2($onCaptureImage, $graphicsLayer, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSharePage_yBXNGS4$lambda$0$0$0$0$0(ContentDrawScope $this_onDrawWithContent, DrawScope $this$record) {
        Intrinsics.checkNotNullParameter($this$record, "$this$record");
        $this_onDrawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSharePage_yBXNGS4$lambda$0$1$0$0$0(ImageBitmap $dotBg, DrawScope $this$drawBehind) {
        long dstSize;
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        if ($dotBg.getHeight() < Float.intBitsToFloat(bits$iv$iv$iv)) {
            int width$iv = $dotBg.getWidth();
            int height$iv = $dotBg.getHeight();
            dstSize = IntSize.constructor-impl((width$iv << 32) | (4294967295L & height$iv));
        } else {
            dstSize = IntSizeKt.toIntSize-uvyYCjk($this$drawBehind.getSize-NH-jbRc());
        }
        int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
        float left$iv = RangesKt.coerceAtLeast(Float.intBitsToFloat(bits$iv$iv$iv2) - $dotBg.getWidth(), 0.0f);
        $this$drawBehind.getDrawContext().getTransform().translate(left$iv, 0.0f);
        try {
            DrawScope.-CC.drawImage-AZ2fEMs$default($this$drawBehind, $dotBg, 0L, 0L, 0L, dstSize, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 0, 1006, (Object) null);
            $this$drawBehind.getDrawContext().getTransform().translate(-left$iv, -0.0f);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$drawBehind.getDrawContext().getTransform().translate(-left$iv, -0.0f);
            throw th;
        }
    }

    private static final void ShareQrCode(final BoxScope $this$ShareQrCode, final String link, final QrCodeProvider qrCodeProvider, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-1558201354);
        ComposerKt.sourceInformation($composer3, "C(ShareQrCode)N(link,qrCodeProvider,modifier)654@25306L1567:TribeeSteamShare.kt#m5suzp");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(link) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(qrCodeProvider) ? 256 : 128;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1169) != 1168, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1558201354, $dirty2, -1, "kntr.app.tribee.steam.page.share.ShareQrCode (TribeeSteamShare.kt:653)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 9) & 14) | 432;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            modifier3 = modifier4;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 813149852, "C659@25470L612,679@26092L775:TribeeSteamShare.kt#m5suzp");
            Modifier modifier$iv2 = SizeKt.wrapContentHeight$default(Modifier.Companion, (Alignment.Vertical) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 146994951, "C665@25621L50,666@25707L9,667@25757L6,664@25592L197,670@25803L40,673@25886L50,674@25972L9,675@26021L6,672@25857L215:TribeeSteamShare.kt#m5suzp");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_18(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), $composer3, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(5)), $composer3, 6);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_19(Res.string.INSTANCE), $composer3, 0), (Modifier) null, Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(102)), Dp.constructor-impl(74));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i8 = ((6 >> 6) & 112) | 6;
            BoxScope $this$ShareQrCode_u24lambda_u240_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -577784018, "C686@26273L63,685@26240L289,694@26543L314:TribeeSteamShare.kt#m5suzp");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getTribee_steam_page_share_code(Res.drawable.INSTANCE), $composer3, 0), (String) null, SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(102)), Dp.constructor-impl(74)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            TribeeSteamShareQrCode_androidKt.TribeeSteamShareQrCode(qrCodeProvider, link, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default($this$ShareQrCode_u24lambda_u240_u241.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), 0.0f, 0.0f, Dp.constructor-impl(7), 0.0f, 11, (Object) null), Dp.constructor-impl(60)), $composer3, (($dirty2 >> 6) & 14) | ($dirty2 & 112), 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareQrCode$lambda$1;
                    ShareQrCode$lambda$1 = TribeeSteamShareKt.ShareQrCode$lambda$1($this$ShareQrCode, link, qrCodeProvider, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareQrCode$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x04af, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0514  */
    /* renamed from: SeeMoreTipCard-RIQooxk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1168SeeMoreTipCardRIQooxk(Modifier modifier, long j, long j2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final long j3;
        long j4;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        CompositionLocalMap localMap$iv$iv;
        final long j5;
        boolean z;
        boolean invalid$iv;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(325678197);
        ComposerKt.sourceInformation($composer2, "C(SeeMoreTipCard)N(modifier,firstArrowColor:c#ui.graphics.Color,secondArrowColor:c#ui.graphics.Color)713@27096L2916:TribeeSteamShare.kt#m5suzp");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
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
                j3 = j;
                if ($composer2.changed(j3)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j3 = j;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j3 = j;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j4 = j2;
                if ($composer2.changed(j4)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j4 = j2;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j4 = j2;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "710@26991L6,711@27069L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    $dirty &= -113;
                    j3 = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    j4 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(325678197, $dirty, -1, "kntr.app.tribee.steam.page.share.SeeMoreTipCard (TribeeSteamShare.kt:712)");
            }
            int $changed$iv = $dirty & 14;
            Modifier modifier$iv$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            long j6 = j4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$SeeMoreTipCard_RIQooxk_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -272860536, "C716@27174L6,717@27193L512,743@28129L6,732@27715L2291:TribeeSteamShare.kt#m5suzp");
            long shadowColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU();
            SpacerKt.Spacer(BackgroundKt.background$default($this$SeeMoreTipCard_RIQooxk_u24lambda_u240.matchParentSize(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(shadowColor), Color.box-impl(Color.copy-wmQWz5c$default(shadowColor, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), Float.POSITIVE_INFINITY, 0.0f, 0, 8, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer2, 0);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.wrapContentWidth$default(PaddingKt.padding-qDBjuR0$default($this$SeeMoreTipCard_RIQooxk_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(20), 7, (Object) null), (Alignment.Horizontal) null, false, 3, (Object) null), Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 336093520, "C747@28260L40,749@28342L56,750@28434L9,751@28483L6,748@28313L202,753@28528L39,757@28652L1291,755@28581L1362,792@29956L40:TribeeSteamShare.kt#m5suzp");
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer2, 6);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_32(TribeeRes.INSTANCE.getString()), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer2, 6);
            Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, 703590486, "CC(remember):TribeeSteamShare.kt#9igjgp");
            boolean z2 = ((($dirty & 112) ^ 48) > 32 && $composer2.changed(j3)) || ($dirty & 48) == 32;
            if ((($dirty & 896) ^ 384) > 256) {
                localMap$iv$iv = localMap$iv$iv3;
                j5 = j6;
                if ($composer2.changed(j5)) {
                    z = true;
                    invalid$iv = z2 | z;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            Unit SeeMoreTipCard_RIQooxk$lambda$0$0$0$0;
                            SeeMoreTipCard_RIQooxk$lambda$0$0$0$0 = TribeeSteamShareKt.SeeMoreTipCard_RIQooxk$lambda$0$0$0$0(j3, j5, (DrawScope) obj);
                            return SeeMoreTipCard_RIQooxk$lambda$0$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    CanvasKt.Canvas(modifier6, (Function1) it$iv, $composer2, 6);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    j4 = j5;
                }
            } else {
                localMap$iv$iv = localMap$iv$iv3;
                j5 = j6;
            }
            if (($dirty & 384) != 256) {
                z = false;
                invalid$iv = z2 | z;
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit SeeMoreTipCard_RIQooxk$lambda$0$0$0$0;
                        SeeMoreTipCard_RIQooxk$lambda$0$0$0$0 = TribeeSteamShareKt.SeeMoreTipCard_RIQooxk$lambda$0$0$0$0(j3, j5, (DrawScope) obj);
                        return SeeMoreTipCard_RIQooxk$lambda$0$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifier6, (Function1) it$iv2, $composer2, 6);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier5;
                j4 = j5;
            }
            z = true;
            invalid$iv = z2 | z;
            Object it$iv22 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv22 = new Function1() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit SeeMoreTipCard_RIQooxk$lambda$0$0$0$0;
                    SeeMoreTipCard_RIQooxk$lambda$0$0$0$0 = TribeeSteamShareKt.SeeMoreTipCard_RIQooxk$lambda$0$0$0$0(j3, j5, (DrawScope) obj);
                    return SeeMoreTipCard_RIQooxk$lambda$0$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv22);
            it$iv22 = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier6, (Function1) it$iv22, $composer2, 6);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier5;
            j4 = j5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final long j7 = j3;
            final long j8 = j4;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj, Object obj2) {
                    Unit SeeMoreTipCard_RIQooxk$lambda$1;
                    SeeMoreTipCard_RIQooxk$lambda$1 = TribeeSteamShareKt.SeeMoreTipCard_RIQooxk$lambda$1(modifier7, j7, j8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SeeMoreTipCard_RIQooxk$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeeMoreTipCard_RIQooxk$lambda$0$0$0$0(long j, long j2, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        Path $this$SeeMoreTipCard_RIQooxk_u24lambda_u240_u240_u240_u240_u240 = AndroidPath_androidKt.Path();
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        int bits$iv$iv$iv2 = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        $this$SeeMoreTipCard_RIQooxk_u24lambda_u240_u240_u240_u240_u240.moveTo(Float.intBitsToFloat(bits$iv$iv$iv) / 4.0f, Float.intBitsToFloat(bits$iv$iv$iv2) * 0.22500001f);
        int bits$iv$iv$iv3 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        int bits$iv$iv$iv4 = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        $this$SeeMoreTipCard_RIQooxk_u24lambda_u240_u240_u240_u240_u240.lineTo(Float.intBitsToFloat(bits$iv$iv$iv3) / 2.0f, Float.intBitsToFloat(bits$iv$iv$iv4) * 0.475f);
        int bits$iv$iv$iv5 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        int bits$iv$iv$iv6 = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        $this$SeeMoreTipCard_RIQooxk_u24lambda_u240_u240_u240_u240_u240.lineTo(Float.intBitsToFloat(bits$iv$iv$iv5) * 0.75f, Float.intBitsToFloat(bits$iv$iv$iv6) * 0.22500001f);
        DrawScope.-CC.drawPath-LG529CI$default($this$Canvas, $this$SeeMoreTipCard_RIQooxk_u24lambda_u240_u240_u240_u240_u240, j, 0.0f, new Stroke($this$Canvas.toPx-0680j_4(Dp.constructor-impl(1)), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), StrokeJoin.Companion.getRound-LxFBmk8(), (PathEffect) null, 18, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
        int bits$iv$iv$iv7 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv7) * 0.29166666f;
        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        $this$SeeMoreTipCard_RIQooxk_u24lambda_u240_u240_u240_u240_u240.translate-k-4lQ0M(Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)));
        DrawScope.-CC.drawPath-LG529CI$default($this$Canvas, $this$SeeMoreTipCard_RIQooxk_u24lambda_u240_u240_u240_u240_u240, j2, 0.0f, new Stroke($this$Canvas.toPx-0680j_4(Dp.constructor-impl(1)), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), StrokeJoin.Companion.getRound-LxFBmk8(), (PathEffect) null, 18, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
        return Unit.INSTANCE;
    }

    private static final float getBottomSheetHeight(boolean isMaster) {
        if (isMaster) {
            return ShareOtherAppBottomSheetMasterHeight;
        }
        return ShareOtherAppBottomSheetGuestHeight;
    }

    public static final float getShareOtherAppBottomSheetMasterHeight() {
        return ShareOtherAppBottomSheetMasterHeight;
    }

    public static final float getShareOtherAppBottomSheetGuestHeight() {
        return ShareOtherAppBottomSheetGuestHeight;
    }
}