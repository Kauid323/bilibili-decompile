package kntr.common.share.common.ui.poster;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.AnimateImage;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageState;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.StaticImage;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kntr.common.screen.adjust.KScreenAdjustUtilsKt;
import kntr.common.share.common.ui.util.ScreenKt;
import kntr.common.share.common.ui.util.ShareColorPickerUtility;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
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
import srcs.common.share.common.ui.generated.resources.Drawable0_commonMainKt;
import srcs.common.share.common.ui.generated.resources.Res;

/* compiled from: SharePosterView.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\u001a\u009d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001c\u001aq\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010#H\u0003¢\u0006\u0002\u0010%\u001a\u001f\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010)\u001a\u001f\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010-\u001a\u001f\u0010.\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010-\u001aM\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020$2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010#H\u0003¢\u0006\u0002\u00105\u001a\u001f\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00109\u001aO\u0010:\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0007¢\u0006\u0004\b;\u0010<\u001aC\u0010=\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010#H\u0003¢\u0006\u0004\b>\u0010?\u001aY\u0010@\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010#H\u0003¢\u0006\u0002\u0010A¨\u0006B²\u0006\n\u0010C\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010E\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010F\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010G\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010I\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020\rX\u008a\u008e\u0002²\u0006\u0010\u0010N\u001a\b\u0012\u0004\u0012\u00020$0OX\u008a\u008e\u0002²\u0006\u0010\u0010P\u001a\b\u0012\u0004\u0012\u00020$0OX\u008a\u008e\u0002²\u0006\n\u0010Q\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"SharePosterView", "", "params", "Lkntr/common/share/common/ui/poster/SharePosterParams;", "modifier", "Landroidx/compose/ui/Modifier;", "isDanmuVisible", "", "isLandScape", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "statusBackgroundColor", "animationDuration", "", "statusBarHeight", "Landroidx/compose/ui/unit/Dp;", "maxScrollDistance", "maxWidthSize", "onCaptureRequest", "Lkotlin/Function0;", "onCaptureComplete", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/ImageBitmap;", "SharePosterView-c6qu3yQ", "(Lkntr/common/share/common/ui/poster/SharePosterParams;Landroidx/compose/ui/Modifier;ZZJJIFIFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "DanmuSection", "danmu", "Lkntr/common/share/common/ui/poster/SharePosterDanmu;", "(Lkntr/common/share/common/ui/poster/SharePosterDanmu;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SharePosterCard", "onColorChange", "hasDominantColor", "picImageRequest", "Lkntr/base/imageloader/ImmutableImageRequest;", "onImageLoadingStateChange", "Lkotlin/Function2;", "", "(Lkntr/common/share/common/ui/poster/SharePosterParams;ZLkotlin/jvm/functions/Function1;IZLkntr/base/imageloader/ImmutableImageRequest;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "StatSection", "stat", "Lkntr/common/share/common/ui/poster/SharePosterStat;", "(Lkntr/common/share/common/ui/poster/SharePosterStat;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StatItemBigMode", "item", "Lkntr/common/share/common/ui/poster/PlacardStatItem;", "(Lkntr/common/share/common/ui/poster/PlacardStatItem;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StatItemSmallMode", "AuthorAndQrSection", "author", "Lkntr/common/share/common/ui/poster/SharePosterAuthor;", "qrcode", "Lkntr/common/share/common/ui/poster/SharePosterQrcode;", "pubtime", "(Lkntr/common/share/common/ui/poster/SharePosterAuthor;Lkntr/common/share/common/ui/poster/SharePosterQrcode;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "HonorSection", "honor", "Lkntr/common/share/common/ui/poster/SharePosterHonor;", "(Lkntr/common/share/common/ui/poster/SharePosterHonor;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SharePosterForCapture", "SharePosterForCapture-uDo3WH8", "(Lkntr/common/share/common/ui/poster/SharePosterParams;Landroidx/compose/ui/Modifier;ZJLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "CaptureContent", "CaptureContent-FNF3uiM", "(Lkntr/common/share/common/ui/poster/SharePosterParams;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SharePosterCardStatic", "(Lkntr/common/share/common/ui/poster/SharePosterParams;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "common-ui_debug", "gradientStartColor", "animatedGradientStartColor", "animatedGradientMiddleColor", "imageRequest", "shouldCapture", "animatedSpacerHeight", "animatedScaleX", "", "animatedScaleY", "contentHeight", "contentWidth", "imageLoadingStates", "", "imageLoadedStates", "hasStartedCapture"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePosterViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorAndQrSection$lambda$1(SharePosterAuthor sharePosterAuthor, SharePosterQrcode sharePosterQrcode, String str, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        AuthorAndQrSection(sharePosterAuthor, sharePosterQrcode, str, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptureContent_FNF3uiM$lambda$4(SharePosterParams sharePosterParams, boolean z, long j, Function2 function2, int i, Composer composer, int i2) {
        m2402CaptureContentFNF3uiM(sharePosterParams, z, j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DanmuSection$lambda$7(SharePosterDanmu sharePosterDanmu, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DanmuSection(sharePosterDanmu, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HonorSection$lambda$1(SharePosterHonor sharePosterHonor, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HonorSection(sharePosterHonor, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterCard$lambda$1(SharePosterParams sharePosterParams, boolean z, Function1 function1, int i, boolean z2, ImmutableImageRequest immutableImageRequest, Modifier modifier, Function2 function2, int i2, int i3, Composer composer, int i4) {
        SharePosterCard(sharePosterParams, z, function1, i, z2, immutableImageRequest, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterCardStatic$lambda$1(SharePosterParams sharePosterParams, boolean z, Function1 function1, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        SharePosterCardStatic(sharePosterParams, z, function1, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterForCapture_uDo3WH8$lambda$21(SharePosterParams sharePosterParams, Modifier modifier, boolean z, long j, Function1 function1, int i, int i2, Composer composer, int i3) {
        m2403SharePosterForCaptureuDo3WH8(sharePosterParams, modifier, z, j, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterView_c6qu3yQ$lambda$16(SharePosterParams sharePosterParams, Modifier modifier, boolean z, boolean z2, long j, long j2, int i, float f, int i2, float f2, Function0 function0, Function1 function1, int i3, int i4, int i5, Composer composer, int i6) {
        m2404SharePosterViewc6qu3yQ(sharePosterParams, modifier, z, z2, j, j2, i, f, i2, f2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatItemBigMode$lambda$1(PlacardStatItem placardStatItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StatItemBigMode(placardStatItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatItemSmallMode$lambda$1(PlacardStatItem placardStatItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StatItemSmallMode(placardStatItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatSection$lambda$2(SharePosterStat sharePosterStat, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StatSection(sharePosterStat, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:237:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x07ba  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x07c6  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0914  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0a28  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0a34  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0a3a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0ade  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0c1a  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0c31  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0c3a  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0c9f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0cb9  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0d8a  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0d96  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0d9c  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0e9d  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0ed0  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0f59  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0fdd  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x1009  */
    /* renamed from: SharePosterView-c6qu3yQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2404SharePosterViewc6qu3yQ(final SharePosterParams params, Modifier modifier, boolean isDanmuVisible, boolean isLandScape, long j, long j2, int animationDuration, float f, int maxScrollDistance, float f2, Function0<Unit> function0, Function1<? super ImageBitmap, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty1;
        Composer $composer2;
        Modifier modifier2;
        boolean isDanmuVisible2;
        boolean isLandScape2;
        long j3;
        long j4;
        int animationDuration2;
        float f3;
        int maxScrollDistance2;
        float f4;
        Function0 onCaptureRequest;
        Function1 onCaptureComplete;
        Modifier modifier3;
        boolean isDanmuVisible3;
        boolean isLandScape3;
        long j5;
        long j6;
        int animationDuration3;
        Function1 onCaptureComplete2;
        int $dirty;
        int maxScrollDistance3;
        float f5;
        Function0 onCaptureRequest2;
        float f6;
        long j7;
        long j8;
        long j9;
        Object value$iv;
        MutableState imageRequest$delegate;
        Function0 onCaptureRequest3;
        MutableState hasDominantColor$delegate;
        Object value$iv2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer$iv;
        int animationDuration4;
        String str;
        Composer $composer$iv$iv$iv;
        Object value$iv3;
        final MutableState hasDominantColor$delegate2;
        Function0 factory$iv$iv$iv5;
        Composer $composer3;
        final Function1 onCaptureComplete3;
        int $dirty2;
        Object value$iv4;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer $composer4 = $composer.startRestartGroup(263221705);
        ComposerKt.sourceInformation($composer4, "C(SharePosterView)N(params,modifier,isDanmuVisible,isLandScape,backgroundColor:c#ui.graphics.Color,statusBackgroundColor:c#ui.graphics.Color,animationDuration,statusBarHeight:c#ui.unit.Dp,maxScrollDistance,maxWidthSize:c#ui.unit.Dp,onCaptureRequest,onCaptureComplete)104@4638L44,107@4723L16,111@4854L21,114@4939L7,117@5092L214,123@5347L171,133@5731L147,142@5917L34,143@5980L34,145@6053L82,145@6020L115,151@6141L7510:SharePosterView.kt#1t42f");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer4.changedInstance(params) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer4.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer4.changed(isDanmuVisible) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer4.changed(isLandScape) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0 && $composer4.changed(j)) {
                i3 = 16384;
                $dirty3 |= i3;
            }
            i3 = 8192;
            $dirty3 |= i3;
        }
        if (($changed & 196608) == 0) {
            if ((i & 32) == 0 && $composer4.changed(j2)) {
                i2 = 131072;
                $dirty3 |= i2;
            }
            i2 = 65536;
            $dirty3 |= i2;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer4.changed(animationDuration) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer4.changed(f) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer4.changed(maxScrollDistance) ? 67108864 : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer4.changed(f2) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty12 |= $composer4.changedInstance(function0) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty12 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        if ($composer4.shouldExecute((($dirty3 & 306783379) == 306783378 && ($dirty12 & 19) == 18) ? false : true, $dirty3 & 1)) {
            $composer4.startDefaults();
            ComposerKt.sourceInformation($composer4, "95@4283L6,96@4350L6");
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
                isDanmuVisible3 = i5 != 0 ? true : isDanmuVisible;
                isLandScape3 = i6 != 0 ? false : isLandScape;
                if ((i & 16) != 0) {
                    j5 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_bg_thin-0d7_KjU();
                    $dirty3 &= -57345;
                } else {
                    j5 = j;
                }
                if ((i & 32) != 0) {
                    j6 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_bg_thin-0d7_KjU();
                    $dirty3 &= -458753;
                } else {
                    j6 = j2;
                }
                animationDuration3 = i7 != 0 ? 500 : animationDuration;
                float f7 = i8 != 0 ? Dp.constructor-impl(44) : f;
                int maxScrollDistance4 = i9 != 0 ? 88 : maxScrollDistance;
                float f8 = i10 != 0 ? Dp.constructor-impl((float) KScreenAdjustUtilsKt.CONTAINER_FUNCTION_MAX_WIDTH) : f2;
                Function0 onCaptureRequest4 = i11 != 0 ? null : function0;
                if (i12 != 0) {
                    $dirty = $dirty3;
                    f5 = f7;
                    onCaptureRequest2 = onCaptureRequest4;
                    f6 = f8;
                    onCaptureComplete2 = null;
                    j8 = j6;
                    maxScrollDistance3 = maxScrollDistance4;
                    j7 = j5;
                } else {
                    onCaptureComplete2 = function1;
                    $dirty = $dirty3;
                    maxScrollDistance3 = maxScrollDistance4;
                    f5 = f7;
                    onCaptureRequest2 = onCaptureRequest4;
                    f6 = f8;
                    j7 = j5;
                    j8 = j6;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                modifier3 = modifier;
                isDanmuVisible3 = isDanmuVisible;
                isLandScape3 = isLandScape;
                j7 = j;
                j8 = j2;
                animationDuration3 = animationDuration;
                maxScrollDistance3 = maxScrollDistance;
                f6 = f2;
                onCaptureRequest2 = function0;
                onCaptureComplete2 = function1;
                $dirty = $dirty3;
                f5 = f;
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                j9 = j8;
                ComposerKt.traceEventStart(263221705, $dirty, $dirty12, "kntr.common.share.common.ui.poster.SharePosterView (SharePosterView.kt:103)");
            } else {
                j9 = j8;
            }
            ComposerKt.sourceInformationMarkerStart($composer4, -446994283, "CC(remember):SharePosterView.kt#9igjgp");
            Object value$iv5 = $composer4.rememberedValue();
            if (value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = SnapshotStateKt.mutableStateOf$default(Color.box-impl(j7), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv5);
            }
            final MutableState gradientStartColor$delegate = (MutableState) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            float screenWidth = ScreenKt.getScreenWidth($composer4, 0);
            boolean isWideScreen = screenWidth > f6 || isLandScape3;
            f3 = f5;
            ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            float f9 = f6;
            modifier2 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density $this$SharePosterView_c6qu3yQ_u24lambda_u243 = (Density) consume;
            int $this$dp$iv = maxScrollDistance3;
            float maxDistance = $this$SharePosterView_c6qu3yQ_u24lambda_u243.toPx-0680j_4(Dp.constructor-impl($this$dp$iv));
            float scrollAlpha = RangesKt.coerceIn(scrollState.getValue() / maxDistance, 0.0f, 1.0f);
            State animatedGradientStartColor$delegate = SingleValueAnimationKt.animateColorAsState-euL9pac(isDanmuVisible3 ? SharePosterView_c6qu3yQ$lambda$1(gradientStartColor$delegate) : j7, AnimationSpecKt.tween$default(animationDuration3, 0, (Easing) null, 6, (Object) null), "gradientStartColor", (Function1) null, $composer4, 384, 8);
            maxScrollDistance2 = maxScrollDistance3;
            State animatedGradientMiddleColor$delegate = SingleValueAnimationKt.animateColorAsState-euL9pac(j7, AnimationSpecKt.tween$default(animationDuration3, 0, (Easing) null, 6, (Object) null), "gradientMiddleColor", (Function1) null, $composer4, (($dirty >> 12) & 14) | 384, 8);
            long statusBarColor = isWideScreen ? j9 : SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate);
            float statusBarAlpha = isWideScreen ? 0.0f : 1.0f - scrollAlpha;
            ComposerKt.sourceInformationMarkerStart($composer4, -446959204, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateOf$default(new ImageRequest(params.getArc().getPic()).useRaw(true).build(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState imageRequest$delegate2 = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -446953365, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                imageRequest$delegate = imageRequest$delegate2;
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv6);
                it$iv2 = value$iv6;
            } else {
                imageRequest$delegate = imageRequest$delegate2;
            }
            final MutableState shouldCapture$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -446951349, "CC(remember):SharePosterView.kt#9igjgp");
            Object value$iv7 = $composer4.rememberedValue();
            if (value$iv7 == Composer.Companion.getEmpty()) {
                isDanmuVisible2 = isDanmuVisible3;
                value$iv7 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv7);
            } else {
                isDanmuVisible2 = isDanmuVisible3;
            }
            MutableState hasDominantColor$delegate3 = (MutableState) value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -446948965, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv = ($dirty12 & 14) == 4;
            Object it$iv3 = $composer4.rememberedValue();
            if (!invalid$iv && it$iv3 != Composer.Companion.getEmpty()) {
                Function0 function02 = onCaptureRequest2;
                hasDominantColor$delegate = hasDominantColor$delegate3;
                value$iv2 = it$iv3;
                onCaptureRequest3 = function02;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(onCaptureRequest3, (Function2) value$iv2, $composer4, $dirty12 & 14);
                onCaptureRequest = onCaptureRequest3;
                Modifier modifier$iv = SizeKt.fillMaxSize$default(BackgroundKt.background-bw27NRU$default(modifier2, !isLandScape3 ? Color.Companion.getTransparent-0d7_KjU() : j7, (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getTopCenter();
                $composer2 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                $dirty1 = $dirty12;
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                isLandScape2 = isLandScape3;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv6;
                    $composer4.useNode();
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv6;
                    $composer4.createNode(factory$iv$iv$iv);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                int $dirty4 = $dirty;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i13 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i14 = ((48 >> 6) & 112) | 6;
                BoxScope $this$SharePosterView_c6qu3yQ_u24lambda_u2415 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -1196402894, "C158@6367L6292,300@12704L296:SharePosterView.kt#1t42f");
                Modifier modifier$iv2 = SizeKt.widthIn-VpY3zN4$default(ZIndexModifierKt.zIndex($this$SharePosterView_c6qu3yQ_u24lambda_u2415.align(Modifier.Companion, Alignment.Companion.getCenter()), 2.0f), 0.0f, f9, 1, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                f4 = f9;
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv7;
                    $composer4.useNode();
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv7;
                    $composer4.createNode(factory$iv$iv$iv2);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                int animationDuration5 = animationDuration3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i15 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i16 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -286915045, "C167@6654L5995:SharePosterView.kt#1t42f");
                Modifier modifier$iv3 = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), scrollState, false, (FlingBehavior) null, false, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                int $changed$iv = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, $changed$iv);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer4.useNode();
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer4.createNode(factory$iv$iv$iv3);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i17 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i18 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -724775993, "C174@6886L243,183@7184L5308:SharePosterView.kt#1t42f");
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), f3), statusBarColor, (Shape) null, 2, (Object) null), $composer4, 0);
                Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null).then(!isWideScreen ? BackgroundKt.background$default(Modifier.Companion, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.38f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$5(animatedGradientMiddleColor$delegate))), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(j7))}, 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), 0.0f, 4, (Object) null) : BackgroundKt.background$default(Modifier.Companion, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.38f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$5(animatedGradientMiddleColor$delegate))), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(j7))}, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null));
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv4 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer4.useNode();
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer4.createNode(factory$iv$iv$iv4);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                j3 = j7;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i19 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int $changed2 = ((48 >> 6) & 112) | 6;
                ColumnScope $this$SharePosterView_c6qu3yQ_u24lambda_u2415_u240_u240_u240 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -1360602644, "C216@8980L196,257@11004L244,262@11269L56,268@11529L131,265@11374L489,277@11885L41,279@11948L463,290@12433L41:SharePosterView.kt#1t42f");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8)), $composer4, 6);
                if (params.getDanmu().getItems().isEmpty()) {
                    $composer4.startReplaceGroup(-1360365154);
                    ComposerKt.sourceInformation($composer4, "232@9697L7,243@10356L7,249@10722L153,225@9304L1571");
                    animationDuration4 = animationDuration5;
                    EnterTransition fadeIn$default = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null);
                    FiniteAnimationSpec tween$default = AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null);
                    str = "CC(remember):SharePosterView.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart($composer4, -1152249608, str);
                    Object it$iv4 = $composer4.rememberedValue();
                    $composer$iv$iv$iv = $composer4;
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        value$iv4 = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda27
                            public final Object invoke(Object obj) {
                                int SharePosterView_c6qu3yQ$lambda$15$0$0$0$0$0;
                                SharePosterView_c6qu3yQ$lambda$15$0$0$0$0$0 = SharePosterViewKt.SharePosterView_c6qu3yQ$lambda$15$0$0$0$0$0(((Integer) obj).intValue());
                                return Integer.valueOf(SharePosterView_c6qu3yQ$lambda$15$0$0$0$0$0);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EnterTransition plus = fadeIn$default.plus(EnterExitTransitionKt.slideInVertically(tween$default, (Function1) value$iv4)).plus(EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null));
                    ExitTransition fadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null);
                    FiniteAnimationSpec tween$default2 = AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1152228520, str);
                    Object it$iv5 = $composer4.rememberedValue();
                    $composer$iv = $composer4;
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda28
                            public final Object invoke(Object obj) {
                                int SharePosterView_c6qu3yQ$lambda$15$0$0$0$1$0;
                                SharePosterView_c6qu3yQ$lambda$15$0$0$0$1$0 = SharePosterViewKt.SharePosterView_c6qu3yQ$lambda$15$0$0$0$1$0(((Integer) obj).intValue());
                                return Integer.valueOf(SharePosterView_c6qu3yQ$lambda$15$0$0$0$1$0);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv8);
                        it$iv5 = value$iv8;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    AnimatedVisibilityKt.AnimatedVisibility($this$SharePosterView_c6qu3yQ_u24lambda_u2415_u240_u240_u240, isDanmuVisible2, (Modifier) null, plus, fadeOut$default.plus(EnterExitTransitionKt.slideOutVertically(tween$default2, (Function1) it$iv5)).plus(EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2018399166, true, new Function3() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit SharePosterView_c6qu3yQ$lambda$15$0$0$0$2;
                            SharePosterView_c6qu3yQ$lambda$15$0$0$0$2 = SharePosterViewKt.SharePosterView_c6qu3yQ$lambda$15$0$0$0$2(SharePosterParams.this, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return SharePosterView_c6qu3yQ$lambda$15$0$0$0$2;
                        }
                    }, $composer4, 54), $composer4, ($changed2 & 14) | 1572864 | (($dirty4 >> 3) & 112), 18);
                } else {
                    $composer$iv = $composer4;
                    animationDuration4 = animationDuration5;
                    str = "CC(remember):SharePosterView.kt#9igjgp";
                    $composer$iv$iv$iv = $composer4;
                    $composer4.startReplaceGroup(-1369620111);
                }
                $composer4.endReplaceGroup();
                State animatedSpacerHeight$delegate = AnimateAsStateKt.animateDpAsState-AjpBEmI(!isDanmuVisible2 ? Dp.constructor-impl(8) : Dp.constructor-impl(4), AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null), "spacerHeight", (Function1) null, $composer4, 384, 8);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, SharePosterView_c6qu3yQ$lambda$15$0$0$0$3(animatedSpacerHeight$delegate)), $composer4, 0);
                boolean SharePosterView_c6qu3yQ$lambda$12 = SharePosterView_c6qu3yQ$lambda$12(hasDominantColor$delegate);
                ImmutableImageRequest SharePosterView_c6qu3yQ$lambda$7 = SharePosterView_c6qu3yQ$lambda$7(imageRequest$delegate);
                ComposerKt.sourceInformationMarkerStart($composer4, -1152190860, str);
                value$iv3 = $composer4.rememberedValue();
                if (value$iv3 != Composer.Companion.getEmpty()) {
                    hasDominantColor$delegate2 = hasDominantColor$delegate;
                    value$iv3 = (Function1) new Function1<Color, Unit>() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$SharePosterView$2$1$1$1$4$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            m2407invoke8_81llA(((Color) p1).unbox-impl());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-8_81llA  reason: not valid java name */
                        public final void m2407invoke8_81llA(long j10) {
                            SharePosterViewKt.SharePosterView_c6qu3yQ$lambda$13(hasDominantColor$delegate2, true);
                            SharePosterViewKt.SharePosterView_c6qu3yQ$lambda$2(gradientStartColor$delegate, j10);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv3);
                } else {
                    hasDominantColor$delegate2 = hasDominantColor$delegate;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                SharePosterCard(params, isDanmuVisible2, (Function1) value$iv3, animationDuration4, SharePosterView_c6qu3yQ$lambda$12, SharePosterView_c6qu3yQ$lambda$7, null, null, $composer4, ($dirty4 & 14) | 384 | (($dirty4 >> 3) & 112) | (($dirty4 >> 9) & 7168), 192);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer4, 6);
                Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                int animationDuration6 = animationDuration4;
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv5 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer4.useNode();
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer4.createNode(factory$iv$iv$iv5);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i20 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i21 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 941794477, "C284@12167L63,283@12122L267:SharePosterView.kt#1t42f");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShare_poster_bottom_icon_bilibili(Res.drawable.INSTANCE), $composer4, 0), (String) null, SizeKt.height-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Dp.constructor-impl(40)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer4, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer4, 6);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (isLandScape2) {
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(-731786117);
                } else {
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(-719354993);
                    ComposerKt.sourceInformation($composer3, "294@12549L68");
                    SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(21)), statusBarColor, (Shape) null, 2, (Object) null), $composer3, 0);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                BoxKt.Box($this$SharePosterView_c6qu3yQ_u24lambda_u2415.align(BackgroundKt.background-bw27NRU$default(ZIndexModifierKt.zIndex(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.5f), 1.0f), Color.copy-wmQWz5c$default(statusBarColor, statusBarAlpha, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Alignment.Companion.getTopStart()), $composer4, 0);
                if (SharePosterView_c6qu3yQ$lambda$9(shouldCapture$delegate)) {
                    onCaptureComplete3 = onCaptureComplete2;
                    $dirty2 = $dirty4;
                    $composer4.startReplaceGroup(-1202945569);
                } else {
                    $composer4.startReplaceGroup(-1189947207);
                    ComposerKt.sourceInformation($composer4, "322@13485L135,312@13085L550");
                    Modifier zIndex = ZIndexModifierKt.zIndex(AlphaKt.alpha(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f), -1.0f);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1285298998, str2);
                    boolean invalid$iv2 = ($dirty1 & 112) == 32;
                    Object it$iv6 = $composer4.rememberedValue();
                    if (invalid$iv2 || it$iv6 == Composer.Companion.getEmpty()) {
                        onCaptureComplete3 = onCaptureComplete2;
                        Object value$iv9 = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit SharePosterView_c6qu3yQ$lambda$15$1$0;
                                SharePosterView_c6qu3yQ$lambda$15$1$0 = SharePosterViewKt.SharePosterView_c6qu3yQ$lambda$15$1$0(onCaptureComplete3, shouldCapture$delegate, (ImageBitmap) obj);
                                return SharePosterView_c6qu3yQ$lambda$15$1$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv9);
                        it$iv6 = value$iv9;
                    } else {
                        onCaptureComplete3 = onCaptureComplete2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $dirty2 = $dirty4;
                    m2403SharePosterForCaptureuDo3WH8(params, zIndex, isDanmuVisible2, j3, (Function1) it$iv6, $composer4, ($dirty4 & 14) | ($dirty2 & 896) | (($dirty2 >> 3) & 7168), 0);
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j9;
                onCaptureComplete = onCaptureComplete3;
                animationDuration2 = animationDuration6;
            }
            onCaptureRequest3 = onCaptureRequest2;
            hasDominantColor$delegate = hasDominantColor$delegate3;
            value$iv2 = (Function2) new SharePosterViewKt$SharePosterView$1$1(onCaptureRequest3, shouldCapture$delegate, null);
            $composer4.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(onCaptureRequest3, (Function2) value$iv2, $composer4, $dirty12 & 14);
            onCaptureRequest = onCaptureRequest3;
            Modifier modifier$iv6 = SizeKt.fillMaxSize$default(BackgroundKt.background-bw27NRU$default(modifier2, !isLandScape3 ? Color.Companion.getTransparent-0d7_KjU() : j7, (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null);
            Alignment contentAlignment$iv4 = Alignment.Companion.getTopCenter();
            $composer2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
            int $changed$iv$iv6 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
            $dirty1 = $dirty12;
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
            Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            isLandScape2 = isLandScape3;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer4);
            int $dirty42 = $dirty;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
            int i132 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i142 = ((48 >> 6) & 112) | 6;
            BoxScope $this$SharePosterView_c6qu3yQ_u24lambda_u24152 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1196402894, "C158@6367L6292,300@12704L296:SharePosterView.kt#1t42f");
            Modifier modifier$iv22 = SizeKt.widthIn-VpY3zN4$default(ZIndexModifierKt.zIndex($this$SharePosterView_c6qu3yQ_u24lambda_u24152.align(Modifier.Companion, Alignment.Companion.getCenter()), 2.0f), 0.0f, f9, 1, (Object) null);
            Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
            f4 = f9;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
            int $changed$iv$iv22 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer4, modifier$iv22);
            Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer4);
            int animationDuration52 = animationDuration3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i152 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i162 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -286915045, "C167@6654L5995:SharePosterView.kt#1t42f");
            Modifier modifier$iv32 = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), scrollState, false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
            int $changed$iv2 = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv32 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer4, $changed$iv2);
            int $changed$iv$iv32 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv32 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer4, modifier$iv32);
            Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
            int i172 = ($changed$iv$iv$iv32 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i182 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -724775993, "C174@6886L243,183@7184L5308:SharePosterView.kt#1t42f");
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), f3), statusBarColor, (Shape) null, 2, (Object) null), $composer4, 0);
            Modifier modifier$iv42 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null).then(!isWideScreen ? BackgroundKt.background$default(Modifier.Companion, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.38f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$5(animatedGradientMiddleColor$delegate))), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(j7))}, 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), 0.0f, 4, (Object) null) : BackgroundKt.background$default(Modifier.Companion, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$4(animatedGradientStartColor$delegate))), TuplesKt.to(Float.valueOf(0.38f), Color.box-impl(SharePosterView_c6qu3yQ$lambda$5(animatedGradientMiddleColor$delegate))), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(j7))}, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null));
            Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv42 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv42 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv42 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer4, modifier$iv42);
            Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer4);
            j3 = j7;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
            int i192 = ($changed$iv$iv$iv42 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int $changed22 = ((48 >> 6) & 112) | 6;
            ColumnScope $this$SharePosterView_c6qu3yQ_u24lambda_u2415_u240_u240_u2402 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1360602644, "C216@8980L196,257@11004L244,262@11269L56,268@11529L131,265@11374L489,277@11885L41,279@11948L463,290@12433L41:SharePosterView.kt#1t42f");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8)), $composer4, 6);
            if (params.getDanmu().getItems().isEmpty()) {
            }
            $composer4.endReplaceGroup();
            State animatedSpacerHeight$delegate2 = AnimateAsStateKt.animateDpAsState-AjpBEmI(!isDanmuVisible2 ? Dp.constructor-impl(8) : Dp.constructor-impl(4), AnimationSpecKt.tween$default(animationDuration4, 0, (Easing) null, 6, (Object) null), "spacerHeight", (Function1) null, $composer4, 384, 8);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, SharePosterView_c6qu3yQ$lambda$15$0$0$0$3(animatedSpacerHeight$delegate2)), $composer4, 0);
            boolean SharePosterView_c6qu3yQ$lambda$122 = SharePosterView_c6qu3yQ$lambda$12(hasDominantColor$delegate);
            ImmutableImageRequest SharePosterView_c6qu3yQ$lambda$72 = SharePosterView_c6qu3yQ$lambda$7(imageRequest$delegate);
            ComposerKt.sourceInformationMarkerStart($composer4, -1152190860, str);
            value$iv3 = $composer4.rememberedValue();
            if (value$iv3 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            SharePosterCard(params, isDanmuVisible2, (Function1) value$iv3, animationDuration4, SharePosterView_c6qu3yQ$lambda$122, SharePosterView_c6qu3yQ$lambda$72, null, null, $composer4, ($dirty42 & 14) | 384 | (($dirty42 >> 3) & 112) | (($dirty42 >> 9) & 7168), 192);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer4, 6);
            Modifier modifier$iv52 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment contentAlignment$iv32 = Alignment.Companion.getCenter();
            int animationDuration62 = animationDuration4;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv52 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
            int $changed$iv$iv52 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv52 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer4, modifier$iv52);
            Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
            String str22 = str;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
            int i202 = ($changed$iv$iv$iv52 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
            int i212 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 941794477, "C284@12167L63,283@12122L267:SharePosterView.kt#1t42f");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShare_poster_bottom_icon_bilibili(Res.drawable.INSTANCE), $composer4, 0), (String) null, SizeKt.height-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Dp.constructor-impl(40)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer4, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer4, 6);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (isLandScape2) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            BoxKt.Box($this$SharePosterView_c6qu3yQ_u24lambda_u24152.align(BackgroundKt.background-bw27NRU$default(ZIndexModifierKt.zIndex(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.5f), 1.0f), Color.copy-wmQWz5c$default(statusBarColor, statusBarAlpha, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), Alignment.Companion.getTopStart()), $composer4, 0);
            if (SharePosterView_c6qu3yQ$lambda$9(shouldCapture$delegate)) {
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
            j4 = j9;
            onCaptureComplete = onCaptureComplete3;
            animationDuration2 = animationDuration62;
        } else {
            $dirty1 = $dirty12;
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            isDanmuVisible2 = isDanmuVisible;
            isLandScape2 = isLandScape;
            j3 = j;
            j4 = j2;
            animationDuration2 = animationDuration;
            f3 = f;
            maxScrollDistance2 = maxScrollDistance;
            f4 = f2;
            onCaptureRequest = function0;
            onCaptureComplete = function1;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z = isDanmuVisible2;
            final boolean z2 = isLandScape2;
            final long j10 = j3;
            final long j11 = j4;
            final int i22 = animationDuration2;
            final float f10 = f3;
            final int i23 = maxScrollDistance2;
            final float f11 = f4;
            final Function0 function03 = onCaptureRequest;
            final Function1 function12 = onCaptureComplete;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SharePosterView_c6qu3yQ$lambda$16;
                    SharePosterView_c6qu3yQ$lambda$16 = SharePosterViewKt.SharePosterView_c6qu3yQ$lambda$16(SharePosterParams.this, modifier4, z, z2, j10, j11, i22, f10, i23, f11, function03, function12, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SharePosterView_c6qu3yQ$lambda$16;
                }
            });
        }
    }

    private static final long SharePosterView_c6qu3yQ$lambda$1(MutableState<Color> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Color) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SharePosterView_c6qu3yQ$lambda$2(MutableState<Color> mutableState, long j) {
        Object value$iv = Color.box-impl(j);
        mutableState.setValue(value$iv);
    }

    private static final long SharePosterView_c6qu3yQ$lambda$4(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).unbox-impl();
    }

    private static final long SharePosterView_c6qu3yQ$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).unbox-impl();
    }

    private static final ImmutableImageRequest SharePosterView_c6qu3yQ$lambda$7(MutableState<ImmutableImageRequest> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ImmutableImageRequest) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SharePosterView_c6qu3yQ$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean SharePosterView_c6qu3yQ$lambda$9(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final boolean SharePosterView_c6qu3yQ$lambda$12(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SharePosterView_c6qu3yQ$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SharePosterView_c6qu3yQ$lambda$15$0$0$0$0$0(int it) {
        return -it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SharePosterView_c6qu3yQ$lambda$15$0$0$0$1$0(int it) {
        return -it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterView_c6qu3yQ$lambda$15$0$0$0$2(SharePosterParams $params, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C250@10752L97:SharePosterView.kt#1t42f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2018399166, $changed, -1, "kntr.common.share.common.ui.poster.SharePosterView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharePosterView.kt:250)");
        }
        DanmuSection($params.getDanmu(), null, $composer, 0, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final float SharePosterView_c6qu3yQ$lambda$15$0$0$0$3(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterView_c6qu3yQ$lambda$15$1$0(Function1 $onCaptureComplete, MutableState $shouldCapture$delegate, ImageBitmap imageBitmap) {
        if ($onCaptureComplete != null) {
            $onCaptureComplete.invoke(imageBitmap);
        }
        SharePosterView_c6qu3yQ$lambda$10($shouldCapture$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0381 A[LOOP:0: B:83:0x037b->B:85:0x0381, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0438  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void DanmuSection(final SharePosterDanmu danmu, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        boolean invalid$iv;
        Object value$iv;
        Function0 factory$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(58770812);
        ComposerKt.sourceInformation($composer2, "C(DanmuSection)N(danmu,modifier)336@13792L7,337@13822L60,338@13913L60,339@14005L59,340@14085L60,341@14168L59,365@14919L2030,343@14233L2716:SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(danmu) ? 4 : 2;
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
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(58770812, $dirty, -1, "kntr.common.share.common.ui.poster.DanmuSection (SharePosterView.kt:335)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 644180248, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(density);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = Integer.valueOf((int) density.toPx-0680j_4(Dp.constructor-impl(24)));
                $composer2.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            int spacerWidth = ((Number) it$iv).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 644183160, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(density);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = Integer.valueOf((int) density.toPx-0680j_4(Dp.constructor-impl(23)));
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            int firstRowStartMargin = ((Number) it$iv2).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 644186103, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(density);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = Integer.valueOf((int) density.toPx-0680j_4(Dp.constructor-impl(8)));
                $composer2.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            int secondRowStartMargin = ((Number) it$iv3).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 644188664, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changed(density);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = Integer.valueOf((int) density.toPx-0680j_4(Dp.constructor-impl(28)));
                $composer2.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            int rowHeight = ((Number) it$iv4).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 644191319, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv6 = $composer2.changed(density);
            Object it$iv5 = $composer2.rememberedValue();
            if (!invalid$iv6 && it$iv5 != Composer.Companion.getEmpty()) {
                int iconSpacing = ((Number) it$iv5).intValue();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv = ClipKt.clipToBounds(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(56)));
                ComposerKt.sourceInformationMarkerStart($composer2, 644217322, "CC(remember):SharePosterView.kt#9igjgp");
                invalid$iv = $composer2.changed(firstRowStartMargin) | $composer2.changed(iconSpacing) | $composer2.changed(spacerWidth) | $composer2.changed(density) | $composer2.changed(rowHeight) | $composer2.changed(secondRowStartMargin);
                value$iv = $composer2.rememberedValue();
                if (!invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    value$iv = new SharePosterViewKt$DanmuSection$2$1(firstRowStartMargin, iconSpacing, spacerWidth, density, rowHeight, secondRowStartMargin);
                    $composer2.updateRememberedValue(value$iv);
                }
                MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier modifier4 = modifier3;
                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv = ((0 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv = factory$iv$iv2;
                    $composer2.useNode();
                } else {
                    factory$iv$iv = factory$iv$iv2;
                    $composer2.createNode(factory$iv$iv);
                }
                Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 491761173, "C346@14293L123:SharePosterView.kt#1t42f");
                String $this$asRequest_u24default$iv = danmu.getIcon();
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), null, null, null, null, null, null, null, $composer2, 48, 508);
                $composer2.startReplaceGroup(-1646699328);
                ComposerKt.sourceInformation($composer2, "*354@14578L9,354@14615L6,352@14501L235");
                Iterable $this$forEach$iv = danmu.getItems();
                boolean z = false;
                for (Object element$iv : $this$forEach$iv) {
                    String item = (String) element$iv;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    BiliTheme biliTheme = BiliTheme.INSTANCE;
                    boolean z2 = z;
                    int $i$f$forEach = BiliTheme.$stable;
                    TextKt.Text-Nvy7gAk(item, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getClip-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(biliTheme.getTextStyle($composer2, $i$f$forEach).getT14(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer2, 0, 24960, 110590);
                    $this$forEach$iv = $this$forEach$iv2;
                    z = z2;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            Object value$iv6 = Integer.valueOf((int) density.toPx-0680j_4(Dp.constructor-impl(2)));
            $composer2.updateRememberedValue(value$iv6);
            it$iv5 = value$iv6;
            int iconSpacing2 = ((Number) it$iv5).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = ClipKt.clipToBounds(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(56)));
            ComposerKt.sourceInformationMarkerStart($composer2, 644217322, "CC(remember):SharePosterView.kt#9igjgp");
            invalid$iv = $composer2.changed(firstRowStartMargin) | $composer2.changed(iconSpacing2) | $composer2.changed(spacerWidth) | $composer2.changed(density) | $composer2.changed(rowHeight) | $composer2.changed(secondRowStartMargin);
            value$iv = $composer2.rememberedValue();
            if (!invalid$iv) {
            }
            value$iv = new SharePosterViewKt$DanmuSection$2$1(firstRowStartMargin, iconSpacing2, spacerWidth, density, rowHeight, secondRowStartMargin);
            $composer2.updateRememberedValue(value$iv);
            MeasurePolicy measurePolicy$iv2 = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier42 = modifier3;
            Modifier materialized$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv22 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv2 = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv2, localMap$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv2, Integer.valueOf(compositeKeyHash$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv2, materialized$iv2, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 491761173, "C346@14293L123:SharePosterView.kt#1t42f");
            String $this$asRequest_u24default$iv2 = danmu.getIcon();
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv2).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), null, null, null, null, null, null, null, $composer2, 48, 508);
            $composer2.startReplaceGroup(-1646699328);
            ComposerKt.sourceInformation($composer2, "*354@14578L9,354@14615L6,352@14501L235");
            Iterable $this$forEach$iv3 = danmu.getItems();
            boolean z3 = false;
            while (r6.hasNext()) {
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier42;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit DanmuSection$lambda$7;
                    DanmuSection$lambda$7 = SharePosterViewKt.DanmuSection$lambda$7(SharePosterDanmu.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DanmuSection$lambda$7;
                }
            });
        }
    }

    private static final void SharePosterCard(final SharePosterParams params, final boolean isDanmuVisible, final Function1<? super Color, Unit> function1, final int animationDuration, final boolean hasDominantColor, final ImmutableImageRequest picImageRequest, Modifier modifier, Function2<? super String, ? super Boolean, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Function2 onImageLoadingStateChange;
        Modifier modifier3;
        Composer $composer3 = $composer.startRestartGroup(-1484232837);
        ComposerKt.sourceInformation($composer3, "C(SharePosterCard)N(params,isDanmuVisible,onColorChange,animationDuration,hasDominantColor,picImageRequest,modifier,onImageLoadingStateChange)438@17513L71,441@17619L38,442@17665L4180,431@17304L4541:SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(params) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(isDanmuVisible) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(animationDuration) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(hasDominantColor) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changed(picImageRequest) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty |= 1572864;
            modifier2 = modifier;
        } else if ((1572864 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty |= 12582912;
        } else if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                onImageLoadingStateChange = function2;
            } else {
                onImageLoadingStateChange = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1484232837, $dirty, -1, "kntr.common.share.common.ui.poster.SharePosterCard (SharePosterView.kt:430)");
            }
            Modifier modifier4 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            Modifier modifier5 = modifier3;
            CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.Companion.getWhite-0d7_KjU(), 0L, 0L, 0L, $composer3, (CardDefaults.$stable << 12) | 6, 14);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float f = Dp.constructor-impl(0);
            int $i$f$getDp = CardDefaults.$stable;
            final Function2 function22 = onImageLoadingStateChange;
            $composer2 = $composer3;
            CardKt.Card(modifier4, shape, cardColors, cardDefaults.cardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, ($i$f$getDp << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-586226743, true, new Function3() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SharePosterCard$lambda$0;
                    SharePosterCard$lambda$0 = SharePosterViewKt.SharePosterCard$lambda$0(isDanmuVisible, animationDuration, picImageRequest, hasDominantColor, function1, params, function22, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SharePosterCard$lambda$0;
                }
            }, $composer3, 54), $composer3, 196608, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            onImageLoadingStateChange = function2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final Function2 function23 = onImageLoadingStateChange;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit SharePosterCard$lambda$1;
                    SharePosterCard$lambda$1 = SharePosterViewKt.SharePosterCard$lambda$1(SharePosterParams.this, isDanmuVisible, function1, animationDuration, hasDominantColor, picImageRequest, modifier6, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SharePosterCard$lambda$1;
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -121
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit SharePosterCard$lambda$0(boolean r135, int r136, kntr.base.imageloader.ImmutableImageRequest r137, boolean r138, kotlin.jvm.functions.Function1 r139, kntr.common.share.common.ui.poster.SharePosterParams r140, kotlin.jvm.functions.Function2 r141, androidx.compose.foundation.layout.ColumnScope r142, androidx.compose.runtime.Composer r143, int r144) {
        /*
            Method dump skipped, instructions count: 2058
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.common.share.common.ui.poster.SharePosterViewKt.SharePosterCard$lambda$0(boolean, int, kntr.base.imageloader.ImmutableImageRequest, boolean, kotlin.jvm.functions.Function1, kntr.common.share.common.ui.poster.SharePosterParams, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final float SharePosterCard$lambda$0$0$0(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float SharePosterCard$lambda$0$0$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterCard$lambda$0$0$2$0(State $animatedScaleX$delegate, State $animatedScaleY$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(SharePosterCard$lambda$0$0$0($animatedScaleX$delegate));
        $this$graphicsLayer.setScaleY(SharePosterCard$lambda$0$0$1($animatedScaleY$delegate));
        $this$graphicsLayer.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterCard$lambda$0$0$3$0$0(boolean $hasDominantColor, CoroutineScope $scope, Function1 $onColorChange, ImageState image) {
        ImageBitmap bitmap;
        Intrinsics.checkNotNullParameter(image, "image");
        if (!$hasDominantColor && (image instanceof ImageState.Success)) {
            Image source = ((ImageState.Success) image).getSource();
            if (source instanceof StaticImage) {
                Image source2 = ((ImageState.Success) image).getSource();
                Intrinsics.checkNotNull(source2, "null cannot be cast to non-null type kntr.base.imageloader.StaticImage");
                bitmap = ((StaticImage) source2).getBitmap();
            } else if (!(source instanceof AnimateImage)) {
                throw new NoWhenBranchMatchedException();
            } else {
                Image source3 = ((ImageState.Success) image).getSource();
                Intrinsics.checkNotNull(source3, "null cannot be cast to non-null type kntr.base.imageloader.AnimateImage");
                bitmap = ((AnimateImage) source3).getFrame(0);
            }
            ImageBitmap it = bitmap;
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SharePosterViewKt$SharePosterCard$1$1$2$1$1$1$1(it, $onColorChange, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final void StatSection(final SharePosterStat stat, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer3 = $composer.startRestartGroup(783885372);
        ComposerKt.sourceInformation($composer3, "C(StatSection)N(stat,modifier):SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(stat) ? 4 : 2;
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
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(783885372, $dirty, -1, "kntr.common.share.common.ui.poster.StatSection (SharePosterView.kt:564)");
            }
            boolean bigDisplayMode = stat.getDisplayMode() == 1;
            if (bigDisplayMode) {
                $composer3.startReplaceGroup(992096023);
                ComposerKt.sourceInformation($composer3, "567@22033L447");
                int $changed$iv = ($dirty >> 3) & 14;
                Modifier modifier$iv = modifier3;
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                modifier4 = modifier3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1094649235, "C568@22075L41,570@22130L340:SharePosterView.kt#1t42f");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), $composer3, 6);
                Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(17), 0.0f, 2, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv2 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 2028059085, "C574@22313L36,575@22366L36,576@22419L37:SharePosterView.kt#1t42f");
                StatItemBigMode(stat.getView(), Modifier.Companion, $composer3, 48, 0);
                StatItemBigMode(stat.getLike(), Modifier.Companion, $composer3, 48, 0);
                StatItemBigMode(stat.getReply(), Modifier.Companion, $composer3, 48, 0);
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
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                modifier4 = modifier3;
                $composer3.startReplaceGroup(992561116);
                ComposerKt.sourceInformation($composer3, "580@22502L442");
                int $changed$iv2 = ($dirty >> 3) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
                int $changed$iv$iv3 = ($changed$iv2 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier4);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer3.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i8 = (($changed$iv2 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -2083692965, "C581@22544L40,583@22598L336:SharePosterView.kt#1t42f");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
                Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv4 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                $composer2 = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i10 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 467035246, "C589@22801L28,590@22846L28,591@22891L29:SharePosterView.kt#1t42f");
                StatItemSmallMode(stat.getView(), null, $composer3, 0, 2);
                StatItemSmallMode(stat.getLike(), null, $composer3, 0, 2);
                StatItemSmallMode(stat.getReply(), null, $composer3, 0, 2);
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
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit StatSection$lambda$2;
                    StatSection$lambda$2 = SharePosterViewKt.StatSection$lambda$2(SharePosterStat.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StatSection$lambda$2;
                }
            });
        }
    }

    private static final void StatItemBigMode(final PlacardStatItem item, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-1986957131);
        ComposerKt.sourceInformation($composer3, "C(StatItemBigMode)N(item,modifier)603@23072L901:SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
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
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1986957131, $dirty, -1, "kntr.common.share.common.ui.poster.StatItemBigMode (SharePosterView.kt:602)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(modifier3, Dp.constructor-impl(40));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 168647009, "C611@23294L9,611@23331L6,609@23228L127,613@23364L40,614@23413L554:SharePosterView.kt#1t42f");
            TextKt.Text-Nvy7gAk(item.getText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer3, 0, 0, 131070);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$StatItemBigMode_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -420368105, "C620@23624L9,620@23661L6,617@23492L197,623@23703L39,627@23833L9,627@23870L6,625@23756L201:SharePosterView.kt#1t42f");
            TextKt.Text-Nvy7gAk(item.getNum(), $this$StatItemBigMode_u24lambda_u240_u240.alignBy(Modifier.Companion, AlignmentLineKt.getLastBaseline()), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT18(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer3, 0, 0, 131068);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            TextKt.Text-Nvy7gAk(item.getNumText(), $this$StatItemBigMode_u24lambda_u240_u240.alignBy(Modifier.Companion, AlignmentLineKt.getLastBaseline()), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT11(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer3, 0, 0, 131068);
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
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit StatItemBigMode$lambda$1;
                    StatItemBigMode$lambda$1 = SharePosterViewKt.StatItemBigMode$lambda$1(PlacardStatItem.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StatItemBigMode$lambda$1;
                }
            });
        }
    }

    private static final void StatItemSmallMode(final PlacardStatItem item, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-360035250);
        ComposerKt.sourceInformation($composer2, "C(StatItemSmallMode)N(item,modifier)640@24097L418:SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
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
                ComposerKt.traceEventStart(-360035250, $dirty, -1, "kntr.common.share.common.ui.poster.StatItemSmallMode (SharePosterView.kt:639)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            int $changed$iv = (($dirty >> 3) & 14) | 432;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1432799261, "C645@24263L110,652@24448L9,652@24485L6,650@24383L126:SharePosterView.kt#1t42f");
            String $this$asRequest_u24default$iv = item.getIcon();
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), null, null, null, null, null, null, null, $composer2, 48, 508);
            TextKt.Text-Nvy7gAk(item.getNum(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer2, 0, 0, 131070);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit StatItemSmallMode$lambda$1;
                    StatItemSmallMode$lambda$1 = SharePosterViewKt.StatItemSmallMode$lambda$1(PlacardStatItem.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StatItemSmallMode$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0668, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0228, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void AuthorAndQrSection(final SharePosterAuthor author, final SharePosterQrcode qrcode, final String pubtime, Modifier modifier, Function2<? super String, ? super Boolean, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 onImageLoadingStateChange;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        final Function2 onImageLoadingStateChange2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-618761461);
        ComposerKt.sourceInformation($composer3, "C(AuthorAndQrSection)N(author,qrcode,pubtime,modifier,onImageLoadingStateChange)665@24757L2854:SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(author) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(qrcode) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(pubtime) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            onImageLoadingStateChange = function2;
        } else if (($changed & 24576) == 0) {
            onImageLoadingStateChange = function2;
            $dirty |= $composer3.changedInstance(onImageLoadingStateChange) ? 16384 : 8192;
        } else {
            onImageLoadingStateChange = function2;
        }
        if (!$composer3.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onImageLoadingStateChange2 = onImageLoadingStateChange;
            } else {
                onImageLoadingStateChange2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-618761461, $dirty, -1, "kntr.common.share.common.ui.poster.AuthorAndQrSection (SharePosterView.kt:664)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$AuthorAndQrSection_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1086042627, "C676@25107L485,670@24892L711,693@25613L39,696@25678L717,718@26405L40,721@26470L1135:SharePosterView.kt#1t42f");
            String $this$asRequest_u24default$iv = author.getFace();
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            ImmutableImageRequest build = imageRequest.build();
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)));
            ComposerKt.sourceInformationMarkerStart($composer3, -1073340372, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv = ((57344 & $dirty) == 16384) | (($dirty & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj) {
                    Unit AuthorAndQrSection$lambda$0$0$0;
                    AuthorAndQrSection$lambda$0$0$0 = SharePosterViewKt.AuthorAndQrSection$lambda$0$0$0(onImageLoadingStateChange2, author, (ImageState) obj);
                    return AuthorAndQrSection$lambda$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build, clip, null, (Function1) it$iv, null, null, null, null, null, $composer3, 0, 500);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer3, 6);
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$AuthorAndQrSection_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1239915365, "C702@25881L9,702@25918L6,699@25754L272,707@26040L40,712@26240L9,712@26277L6,709@26094L291:SharePosterView.kt#1t42f");
            TextKt.Text-Nvy7gAk(author.getName(), SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(19)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer3, 48, 24960, 110588);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            TextKt.Text-Nvy7gAk(pubtime, PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(1), 7, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer3, (($dirty >> 6) & 14) | 48, 24960, 110588);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
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
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i9 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1381401084, "C727@26703L533,724@26566L685,744@27265L40,750@27460L6,746@27319L276:SharePosterView.kt#1t42f");
            String $this$asRequest_u24default$iv2 = qrcode.getLink();
            ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
            Unit unit2 = Unit.INSTANCE;
            ImmutableImageRequest build2 = imageRequest2.build();
            Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60));
            ComposerKt.sourceInformationMarkerStart($composer3, 371084559, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv2 = ((57344 & $dirty) == 16384) | (($dirty & 112) == 32);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj) {
                    Unit AuthorAndQrSection$lambda$0$2$0$0;
                    AuthorAndQrSection$lambda$0$2$0$0 = SharePosterViewKt.AuthorAndQrSection$lambda$0$2$0$0(onImageLoadingStateChange2, qrcode, (ImageState) obj);
                    return AuthorAndQrSection$lambda$0$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build2, modifier5, null, (Function1) it$iv2, null, null, null, null, null, $composer3, 48, 500);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            TextKt.Text-Nvy7gAk(qrcode.getExpire(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), TextUnitKt.getSp(8), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646140, (DefaultConstructorMarker) null), $composer3, 0, 0, 131070);
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
            onImageLoadingStateChange = onImageLoadingStateChange2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function2 function22 = onImageLoadingStateChange;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit AuthorAndQrSection$lambda$1;
                    AuthorAndQrSection$lambda$1 = SharePosterViewKt.AuthorAndQrSection$lambda$1(SharePosterAuthor.this, qrcode, pubtime, modifier6, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AuthorAndQrSection$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorAndQrSection$lambda$0$0$0(Function2 $onImageLoadingStateChange, SharePosterAuthor $author, ImageState image) {
        Intrinsics.checkNotNullParameter(image, "image");
        if (image instanceof ImageState.Loading) {
            if ($onImageLoadingStateChange != null) {
                $onImageLoadingStateChange.invoke($author.getFace(), true);
            }
        } else if (((image instanceof ImageState.Success) || (image instanceof ImageState.Error)) && $onImageLoadingStateChange != null) {
            $onImageLoadingStateChange.invoke($author.getFace(), false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorAndQrSection$lambda$0$2$0$0(Function2 $onImageLoadingStateChange, SharePosterQrcode $qrcode, ImageState image) {
        Intrinsics.checkNotNullParameter(image, "image");
        if (image instanceof ImageState.Loading) {
            if ($onImageLoadingStateChange != null) {
                $onImageLoadingStateChange.invoke($qrcode.getLink(), true);
            }
        } else if (((image instanceof ImageState.Success) || (image instanceof ImageState.Error)) && $onImageLoadingStateChange != null) {
            $onImageLoadingStateChange.invoke($qrcode.getLink(), false);
        }
        return Unit.INSTANCE;
    }

    private static final void HonorSection(final SharePosterHonor honor, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-586727206);
        ComposerKt.sourceInformation($composer2, "C(HonorSection)N(honor,modifier)764@27725L756:SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(honor) ? 4 : 2;
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
                ComposerKt.traceEventStart(-586727206, $dirty, -1, "kntr.common.share.common.ui.poster.HonorSection (SharePosterView.kt:763)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(modifier3, Dp.constructor-impl(22)), ComposeColorParserKt.parseColor(honor.getBackgroundColor()), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(8), Dp.constructor-impl(2));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 95700033, "C775@28143L111,781@28333L9,779@28263L212:SharePosterView.kt#1t42f");
            String $this$asRequest_u24default$iv = honor.getIcon();
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), null, null, null, null, null, null, null, $composer2, 48, 508);
            TextKt.Text-Nvy7gAk(honor.getContent(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), ComposeColorParserKt.parseColor(honor.getContentColor()), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer2, 0, 24960, 110590);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit HonorSection$lambda$1;
                    HonorSection$lambda$1 = SharePosterViewKt.HonorSection$lambda$1(SharePosterHonor.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HonorSection$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0300, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02af A[SYNTHETIC] */
    /* renamed from: SharePosterForCapture-uDo3WH8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2403SharePosterForCaptureuDo3WH8(final SharePosterParams params, Modifier modifier, boolean isDanmuVisible, long j, Function1<? super ImageBitmap, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean isDanmuVisible2;
        long j2;
        Function1 function12;
        final boolean isDanmuVisible3;
        Function1 onCaptureComplete;
        Modifier modifier3;
        Modifier modifier4;
        int $dirty;
        long j3;
        boolean isDanmuVisible4;
        Iterable $this$all$iv;
        Iterator it;
        boolean z;
        Iterable $this$all$iv2;
        boolean invalid$iv;
        Object it$iv;
        boolean invalid$iv2;
        Object it$iv2;
        boolean invalid$iv3;
        Object value$iv;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer $composer2 = $composer.startRestartGroup(90925778);
        ComposerKt.sourceInformation($composer2, "C(SharePosterForCapture)N(params,modifier,isDanmuVisible,backgroundColor:c#ui.graphics.Color,onCaptureComplete)797@28785L33,798@28843L33,799@28901L23,802@28972L44,803@29046L44,804@29120L34,808@29208L165,823@29604L478,823@29543L539,839@30121L68,839@30100L89,849@30359L177,855@30544L1259,845@30231L1572:SharePosterView.kt#1t42f");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(params) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            isDanmuVisible2 = isDanmuVisible;
        } else if (($changed & 384) == 0) {
            isDanmuVisible2 = isDanmuVisible;
            $dirty2 |= $composer2.changed(isDanmuVisible2) ? 256 : 128;
        } else {
            isDanmuVisible2 = isDanmuVisible;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j2 = j;
                if ($composer2.changed(j2)) {
                    i3 = 2048;
                    $dirty2 |= i3;
                }
            } else {
                j2 = j;
            }
            i3 = 1024;
            $dirty2 |= i3;
        } else {
            j2 = j;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            function12 = function1;
        } else if (($changed & 24576) == 0) {
            function12 = function1;
            $dirty2 |= $composer2.changedInstance(function12) ? 16384 : 8192;
        } else {
            function12 = function1;
        }
        boolean z2 = true;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "793@28665L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                onCaptureComplete = function12;
                j3 = j2;
                modifier3 = modifier2;
                isDanmuVisible4 = isDanmuVisible2;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    isDanmuVisible2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thin-0d7_KjU();
                }
                if (i6 == 0) {
                    $dirty = $dirty2;
                    onCaptureComplete = function12;
                    j3 = j2;
                    modifier3 = modifier4;
                    isDanmuVisible4 = isDanmuVisible2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    onCaptureComplete = null;
                    j3 = j2;
                    isDanmuVisible4 = isDanmuVisible2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90925778, $dirty, -1, "kntr.common.share.common.ui.poster.SharePosterForCapture (SharePosterView.kt:795)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1480335987, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            final MutableIntState contentHeight$delegate = (MutableIntState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1480337843, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            final MutableIntState contentWidth$delegate = (MutableIntState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final GraphicsLayer graphicsLayer = GraphicsLayerScopeKt.rememberGraphicsLayer($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1480341982, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(SetsKt.emptySet(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv5 = value$iv4;
            }
            final MutableState imageLoadingStates$delegate = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1480344350, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(SetsKt.emptySet(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv6 = value$iv5;
            }
            final MutableState imageLoadedStates$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1480346708, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv7 = value$iv6;
            }
            MutableState hasStartedCapture$delegate = (MutableState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1480349655, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(params);
            Object it$iv8 = $composer2.rememberedValue();
            if (!invalid$iv4 && it$iv8 != Composer.Companion.getEmpty()) {
                Iterable requiredImages = (Set) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $this$all$iv = requiredImages;
                if (($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                    it = $this$all$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            z = true;
                            break;
                        }
                        Object element$iv = it.next();
                        String imageUrl = (String) element$iv;
                        $this$all$iv2 = $this$all$iv;
                        if (!SharePosterForCapture_uDo3WH8$lambda$10(imageLoadedStates$delegate).contains(imageUrl)) {
                            z = false;
                            break;
                        }
                        $this$all$iv = $this$all$iv2;
                    }
                } else {
                    z = true;
                }
                boolean allImagesLoaded = z;
                Boolean valueOf = Boolean.valueOf(allImagesLoaded);
                Integer valueOf2 = Integer.valueOf(SharePosterForCapture_uDo3WH8$lambda$1(contentHeight$delegate));
                Integer valueOf3 = Integer.valueOf(SharePosterForCapture_uDo3WH8$lambda$4(contentWidth$delegate));
                ComposerKt.sourceInformationMarkerStart($composer2, 1480362640, "CC(remember):SharePosterView.kt#9igjgp");
                isDanmuVisible3 = isDanmuVisible4;
                invalid$iv = $composer2.changed(allImagesLoaded) | $composer2.changedInstance(graphicsLayer) | (($dirty & 57344) != 16384);
                Object it$iv9 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv7 = (Function2) new SharePosterViewKt$SharePosterForCapture$1$1(allImagesLoaded, onCaptureComplete, contentHeight$delegate, contentWidth$delegate, hasStartedCapture$delegate, graphicsLayer, null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv9 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf, valueOf2, valueOf3, (Function2) it$iv9, $composer2, 0);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1480378774, "CC(remember):SharePosterView.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv != Composer.Companion.getEmpty()) {
                    Object value$iv8 = (Function2) new SharePosterViewKt$SharePosterForCapture$2$1(hasStartedCapture$delegate, null);
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
                Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(modifier3, (Alignment.Vertical) null, false, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1480386499, "CC(remember):SharePosterView.kt#9igjgp");
                invalid$iv2 = $composer2.changedInstance(graphicsLayer);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj) {
                            Unit SharePosterForCapture_uDo3WH8$lambda$19$0;
                            SharePosterForCapture_uDo3WH8$lambda$19$0 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$19$0(graphicsLayer, (ContentDrawScope) obj);
                            return SharePosterForCapture_uDo3WH8$lambda$19$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv9);
                    it$iv2 = value$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier drawWithContent = DrawModifierKt.drawWithContent(wrapContentHeight$default, (Function1) it$iv2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1480393501, "CC(remember):SharePosterView.kt#9igjgp");
                boolean changedInstance = $composer2.changedInstance(params) | (($dirty & 896) != 256);
                if (((($dirty & 7168) ^ 3072) > 2048 || !$composer2.changed(j3)) && ($dirty & 3072) != 2048) {
                    z2 = false;
                }
                invalid$iv3 = changedInstance | z2;
                value$iv = $composer2.rememberedValue();
                if (!invalid$iv3 || value$iv == Composer.Companion.getEmpty()) {
                    i2 = 0;
                    final long j4 = j3;
                    value$iv = new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj, Object obj2) {
                            MeasureResult SharePosterForCapture_uDo3WH8$lambda$20$0;
                            SharePosterForCapture_uDo3WH8$lambda$20$0 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$20$0(SharePosterParams.this, isDanmuVisible3, j4, imageLoadingStates$delegate, imageLoadedStates$delegate, contentHeight$delegate, contentWidth$delegate, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                            return SharePosterForCapture_uDo3WH8$lambda$20$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    i2 = 0;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SubcomposeLayoutKt.SubcomposeLayout(drawWithContent, (Function2) value$iv, $composer2, i2, i2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
            }
            Object value$iv10 = SetsKt.setOf(new String[]{params.getArc().getPic(), params.getAuthor().getFace(), params.getQrcode().getLink()});
            $composer2.updateRememberedValue(value$iv10);
            it$iv8 = value$iv10;
            Iterable requiredImages2 = (Set) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $this$all$iv = requiredImages2;
            if ($this$all$iv instanceof Collection) {
            }
            it = $this$all$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                }
                $this$all$iv = $this$all$iv2;
            }
            boolean allImagesLoaded2 = z;
            Boolean valueOf4 = Boolean.valueOf(allImagesLoaded2);
            Integer valueOf22 = Integer.valueOf(SharePosterForCapture_uDo3WH8$lambda$1(contentHeight$delegate));
            Integer valueOf32 = Integer.valueOf(SharePosterForCapture_uDo3WH8$lambda$4(contentWidth$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, 1480362640, "CC(remember):SharePosterView.kt#9igjgp");
            isDanmuVisible3 = isDanmuVisible4;
            invalid$iv = $composer2.changed(allImagesLoaded2) | $composer2.changedInstance(graphicsLayer) | (($dirty & 57344) != 16384);
            Object it$iv92 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv72 = (Function2) new SharePosterViewKt$SharePosterForCapture$1$1(allImagesLoaded2, onCaptureComplete, contentHeight$delegate, contentWidth$delegate, hasStartedCapture$delegate, graphicsLayer, null);
            $composer2.updateRememberedValue(value$iv72);
            it$iv92 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf4, valueOf22, valueOf32, (Function2) it$iv92, $composer2, 0);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1480378774, "CC(remember):SharePosterView.kt#9igjgp");
            it$iv = $composer2.rememberedValue();
            if (it$iv != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv, $composer2, 6);
            Modifier wrapContentHeight$default2 = SizeKt.wrapContentHeight$default(modifier3, (Alignment.Vertical) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1480386499, "CC(remember):SharePosterView.kt#9igjgp");
            invalid$iv2 = $composer2.changedInstance(graphicsLayer);
            it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv92 = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj) {
                    Unit SharePosterForCapture_uDo3WH8$lambda$19$0;
                    SharePosterForCapture_uDo3WH8$lambda$19$0 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$19$0(graphicsLayer, (ContentDrawScope) obj);
                    return SharePosterForCapture_uDo3WH8$lambda$19$0;
                }
            };
            $composer2.updateRememberedValue(value$iv92);
            it$iv2 = value$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier drawWithContent2 = DrawModifierKt.drawWithContent(wrapContentHeight$default2, (Function1) it$iv2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1480393501, "CC(remember):SharePosterView.kt#9igjgp");
            boolean changedInstance2 = $composer2.changedInstance(params) | (($dirty & 896) != 256);
            if ((($dirty & 7168) ^ 3072) > 2048) {
            }
            z2 = false;
            invalid$iv3 = changedInstance2 | z2;
            value$iv = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            i2 = 0;
            final long j42 = j3;
            value$iv = new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    MeasureResult SharePosterForCapture_uDo3WH8$lambda$20$0;
                    SharePosterForCapture_uDo3WH8$lambda$20$0 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$20$0(SharePosterParams.this, isDanmuVisible3, j42, imageLoadingStates$delegate, imageLoadedStates$delegate, contentHeight$delegate, contentWidth$delegate, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    return SharePosterForCapture_uDo3WH8$lambda$20$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(drawWithContent2, (Function2) value$iv, $composer2, i2, i2);
            if (ComposerKt.isTraceInProgress()) {
            }
            j2 = j3;
        } else {
            $composer2.skipToGroupEnd();
            isDanmuVisible3 = isDanmuVisible2;
            onCaptureComplete = function12;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = isDanmuVisible3;
            final long j5 = j2;
            final Function1 function13 = onCaptureComplete;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit SharePosterForCapture_uDo3WH8$lambda$21;
                    SharePosterForCapture_uDo3WH8$lambda$21 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$21(SharePosterParams.this, modifier5, z3, j5, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SharePosterForCapture_uDo3WH8$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SharePosterForCapture_uDo3WH8$lambda$1(MutableIntState $contentHeight$delegate) {
        IntState $this$getValue$iv = (IntState) $contentHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SharePosterForCapture_uDo3WH8$lambda$4(MutableIntState $contentWidth$delegate) {
        IntState $this$getValue$iv = (IntState) $contentWidth$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final Set<String> SharePosterForCapture_uDo3WH8$lambda$7(MutableState<Set<String>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Set) $this$getValue$iv.getValue();
    }

    private static final Set<String> SharePosterForCapture_uDo3WH8$lambda$10(MutableState<Set<String>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Set) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SharePosterForCapture_uDo3WH8$lambda$13(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SharePosterForCapture_uDo3WH8$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterForCapture_uDo3WH8$lambda$19$0(GraphicsLayer $graphicsLayer, final ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        DrawScope.-CC.record-JVtK1S4$default((DrawScope) $this$drawWithContent, $graphicsLayer, 0L, new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                Unit SharePosterForCapture_uDo3WH8$lambda$19$0$0;
                SharePosterForCapture_uDo3WH8$lambda$19$0$0 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$19$0$0($this$drawWithContent, (DrawScope) obj);
                return SharePosterForCapture_uDo3WH8$lambda$19$0$0;
            }
        }, 1, (Object) null);
        $this$drawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterForCapture_uDo3WH8$lambda$19$0$0(ContentDrawScope $this_drawWithContent, DrawScope $this$record) {
        Intrinsics.checkNotNullParameter($this$record, "$this$record");
        $this_drawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult SharePosterForCapture_uDo3WH8$lambda$20$0(final SharePosterParams $params, final boolean $isDanmuVisible, final long j, final MutableState $imageLoadingStates$delegate, final MutableState $imageLoadedStates$delegate, MutableIntState $contentHeight$delegate, MutableIntState $contentWidth$delegate, SubcomposeMeasureScope $this$SubcomposeLayout, Constraints constraints) {
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        long looseConstraints = Constraints.copy-Zbe2FdA$default(constraints.unbox-impl(), 0, 0, 0, (int) FlowControlConfig.RETRY_MAX_TIMES, 3, (Object) null);
        final Placeable contentPlaceable = ((Measurable) $this$SubcomposeLayout.subcompose("content", ComposableLambdaKt.composableLambdaInstance(1871738772, true, new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj, Object obj2) {
                Unit SharePosterForCapture_uDo3WH8$lambda$20$0$0;
                SharePosterForCapture_uDo3WH8$lambda$20$0$0 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$20$0$0(SharePosterParams.this, $isDanmuVisible, j, $imageLoadingStates$delegate, $imageLoadedStates$delegate, (Composer) obj, ((Integer) obj2).intValue());
                return SharePosterForCapture_uDo3WH8$lambda$20$0$0;
            }
        })).get(0)).measure-BRTryo0(looseConstraints);
        $contentHeight$delegate.setIntValue(contentPlaceable.getHeight());
        $contentWidth$delegate.setIntValue(contentPlaceable.getWidth());
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, SharePosterForCapture_uDo3WH8$lambda$4($contentWidth$delegate), SharePosterForCapture_uDo3WH8$lambda$1($contentHeight$delegate), (Map) null, new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit SharePosterForCapture_uDo3WH8$lambda$20$0$1;
                SharePosterForCapture_uDo3WH8$lambda$20$0$1 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$20$0$1(contentPlaceable, (Placeable.PlacementScope) obj);
                return SharePosterForCapture_uDo3WH8$lambda$20$0$1;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterForCapture_uDo3WH8$lambda$20$0$0(SharePosterParams $params, boolean $isDanmuVisible, long j, final MutableState $imageLoadingStates$delegate, final MutableState $imageLoadedStates$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C870@31050L458,866@30841L686:SharePosterView.kt#1t42f");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1871738772, $changed, -1, "kntr.common.share.common.ui.poster.SharePosterForCapture.<anonymous>.<anonymous>.<anonymous> (SharePosterView.kt:866)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -850329410, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda25
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SharePosterForCapture_uDo3WH8$lambda$20$0$0$0$0;
                        SharePosterForCapture_uDo3WH8$lambda$20$0$0$0$0 = SharePosterViewKt.SharePosterForCapture_uDo3WH8$lambda$20$0$0$0$0($imageLoadingStates$delegate, $imageLoadedStates$delegate, (String) obj, ((Boolean) obj2).booleanValue());
                        return SharePosterForCapture_uDo3WH8$lambda$20$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            m2402CaptureContentFNF3uiM($params, $isDanmuVisible, j, (Function2) it$iv, $composer, 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterForCapture_uDo3WH8$lambda$20$0$0$0$0(MutableState $imageLoadingStates$delegate, MutableState $imageLoadedStates$delegate, String imageUrl, boolean isLoading) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        if (isLoading) {
            $imageLoadingStates$delegate.setValue(SetsKt.plus(SharePosterForCapture_uDo3WH8$lambda$7($imageLoadingStates$delegate), imageUrl));
            $imageLoadedStates$delegate.setValue(SetsKt.minus(SharePosterForCapture_uDo3WH8$lambda$10($imageLoadedStates$delegate), imageUrl));
        } else {
            $imageLoadingStates$delegate.setValue(SetsKt.minus(SharePosterForCapture_uDo3WH8$lambda$7($imageLoadingStates$delegate), imageUrl));
            $imageLoadedStates$delegate.setValue(SetsKt.plus(SharePosterForCapture_uDo3WH8$lambda$10($imageLoadedStates$delegate), imageUrl));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterForCapture_uDo3WH8$lambda$20$0$1(Placeable $contentPlaceable, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.place$default($this$layout, $contentPlaceable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* renamed from: CaptureContent-FNF3uiM  reason: not valid java name */
    private static final void m2402CaptureContentFNF3uiM(final SharePosterParams params, final boolean isDanmuVisible, final long j, final Function2<? super String, ? super Boolean, Unit> function2, Composer $composer, final int $changed) {
        long j2;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1759239136);
        ComposerKt.sourceInformation($composer2, "C(CaptureContent)N(params,isDanmuVisible,backgroundColor:c#ui.graphics.Color,onImageLoadingStateChange)900@32030L44,903@32174L1461:SharePosterView.kt#1t42f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(params) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isDanmuVisible) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            j2 = j;
            $dirty |= $composer2.changed(j2) ? 256 : 128;
        } else {
            j2 = j;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1759239136, $dirty2, -1, "kntr.common.share.common.ui.poster.CaptureContent (SharePosterView.kt:899)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1588298388, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(Color.box-impl(j), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState gradientStartColor$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long finalGradientStartColor = isDanmuVisible ? CaptureContent_FNF3uiM$lambda$1(gradientStartColor$delegate) : j2;
            Modifier modifier$iv = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(finalGradientStartColor)), TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(finalGradientStartColor)), TuplesKt.to(Float.valueOf(0.38f), Color.box-impl(j)), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(j))}, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -2007757854, "C917@32646L40,929@33067L27,926@32942L230,933@33182L41,935@33233L345,946@33588L41:SharePosterView.kt#1t42f");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer2, 6);
            if (!params.getDanmu().getItems().isEmpty() && isDanmuVisible) {
                $composer2.startReplaceGroup(-2007680727);
                ComposerKt.sourceInformation($composer2, "920@32765L34,921@32812L40");
                $composer$iv = $composer2;
                DanmuSection(params.getDanmu(), null, $composer2, 0, 2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer2, 6);
                $composer2.endReplaceGroup();
            } else {
                $composer$iv = $composer2;
                $composer2.startReplaceGroup(-2007566120);
                ComposerKt.sourceInformation($composer2, "923@32882L40");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -618943195, "CC(remember):SharePosterView.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function1) new Function1<Color, Unit>() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$CaptureContent$1$1$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        m2405invoke8_81llA(((Color) p1).unbox-impl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-8_81llA  reason: not valid java name */
                    public final void m2405invoke8_81llA(long j3) {
                        SharePosterViewKt.CaptureContent_FNF3uiM$lambda$2(gradientStartColor$delegate, j3);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Composer $composer$iv2 = $composer$iv;
            SharePosterCardStatic(params, isDanmuVisible, (Function1) it$iv2, null, function2, $composer2, ($dirty2 & 14) | 384 | ($dirty2 & 112) | (($dirty2 << 3) & 57344), 8);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1321796562, "C940@33392L63,939@33359L209:SharePosterView.kt#1t42f");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getShare_poster_bottom_icon_bilibili(Res.drawable.INSTANCE), $composer2, 0), (String) null, SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit CaptureContent_FNF3uiM$lambda$4;
                    CaptureContent_FNF3uiM$lambda$4 = SharePosterViewKt.CaptureContent_FNF3uiM$lambda$4(SharePosterParams.this, isDanmuVisible, j, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CaptureContent_FNF3uiM$lambda$4;
                }
            });
        }
    }

    private static final long CaptureContent_FNF3uiM$lambda$1(MutableState<Color> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Color) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CaptureContent_FNF3uiM$lambda$2(MutableState<Color> mutableState, long j) {
        Object value$iv = Color.box-impl(j);
        mutableState.setValue(value$iv);
    }

    private static final void SharePosterCardStatic(final SharePosterParams params, final boolean isDanmuVisible, final Function1<? super Color, Unit> function1, Modifier modifier, Function2<? super String, ? super Boolean, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function22;
        int $dirty;
        Modifier modifier3;
        Function2 onImageLoadingStateChange;
        Modifier modifier4;
        final Function2 onImageLoadingStateChange2;
        Composer $composer2 = $composer.startRestartGroup(-349533866);
        ComposerKt.sourceInformation($composer2, "C(SharePosterCardStatic)N(params,isDanmuVisible,onColorChange,modifier,onImageLoadingStateChange)965@34102L71,968@34208L38,969@34254L4454,958@33893L4815:SharePosterView.kt#1t42f");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(params) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(isDanmuVisible) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            function22 = function2;
        } else if (($changed & 24576) == 0) {
            function22 = function2;
            $dirty2 |= $composer2.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = function2;
        }
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onImageLoadingStateChange = function22;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onImageLoadingStateChange2 = function22;
            } else {
                onImageLoadingStateChange2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-349533866, $dirty2, -1, "kntr.common.share.common.ui.poster.SharePosterCardStatic (SharePosterView.kt:957)");
            }
            $dirty = $dirty2;
            CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.Companion.getWhite-0d7_KjU(), 0L, 0L, 0L, $composer2, (CardDefaults.$stable << 12) | 6, 14);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float f = Dp.constructor-impl(0);
            int $this$dp$iv = CardDefaults.$stable;
            CardKt.Card(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), cardColors, cardDefaults.cardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, ($this$dp$iv << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1101601116, true, new Function3() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SharePosterCardStatic$lambda$0;
                    SharePosterCardStatic$lambda$0 = SharePosterViewKt.SharePosterCardStatic$lambda$0(isDanmuVisible, params, onImageLoadingStateChange2, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SharePosterCardStatic$lambda$0;
                }
            }, $composer2, 54), $composer2, 196608, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onImageLoadingStateChange = onImageLoadingStateChange2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function2 function23 = onImageLoadingStateChange;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit SharePosterCardStatic$lambda$1;
                    SharePosterCardStatic$lambda$1 = SharePosterViewKt.SharePosterCardStatic$lambda$1(SharePosterParams.this, isDanmuVisible, function1, modifier5, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SharePosterCardStatic$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x018f, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x02eb, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0352, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SharePosterCardStatic$lambda$0(boolean $isDanmuVisible, final SharePosterParams $params, final Function2 $onImageLoadingStateChange, final Function1 $onColorChange, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C970@34264L4438:SharePosterView.kt#1t42f");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1101601116, $changed, -1, "kntr.common.share.common.ui.poster.SharePosterCardStatic.<anonymous> (SharePosterView.kt:970)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2015494425, "C981@34666L217,976@34480L2789,1047@37283L1409:SharePosterView.kt#1t42f");
            final float animatedScaleX = $isDanmuVisible ? 0.94f : 1.0f;
            final float animatedScaleY = $isDanmuVisible ? 0.955f : 1.0f;
            Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.3333334f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1034853447, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv = $composer.changed(animatedScaleX) | $composer.changed(animatedScaleY);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    Unit SharePosterCardStatic$lambda$0$0$0$0;
                    SharePosterCardStatic$lambda$0$0$0$0 = SharePosterViewKt.SharePosterCardStatic$lambda$0$0$0$0(animatedScaleX, animatedScaleY, (GraphicsLayerScope) obj);
                    return SharePosterCardStatic$lambda$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv2 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(aspectRatio$default, (Function1) it$iv), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SharePosterCardStatic_u24lambda_u240_u240_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 286108536, "C988@34987L99,995@35244L1538,992@35104L1697,1034@36849L406:SharePosterView.kt#1t42f");
            String pic = $params.getArc().getPic();
            ComposerKt.sourceInformationMarkerStart($composer, -544960981, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(pic);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            String $this$asRequest_u24default$iv = $params.getArc().getPic();
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            Object value$iv2 = imageRequest.build();
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ImmutableImageRequest imageRequest2 = (ImmutableImageRequest) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -544951318, "CC(remember):SharePosterView.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($onImageLoadingStateChange) | $composer.changedInstance($params) | $composer.changed($onColorChange);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function1() { // from class: kntr.common.share.common.ui.poster.SharePosterViewKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    Unit SharePosterCardStatic$lambda$0$0$1$1$0;
                    SharePosterCardStatic$lambda$0$0$1$1$0 = SharePosterViewKt.SharePosterCardStatic$lambda$0$0$1$1$0($onImageLoadingStateChange, $params, $onColorChange, (ImageState) obj);
                    return SharePosterCardStatic$lambda$0$0$1$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliImageKt.BiliImage(imageRequest2, fillMaxSize$default, null, (Function1) it$iv3, null, null, null, null, null, $composer, 48, 500);
            Modifier modifier$iv$iv = PaddingKt.padding-qDBjuR0$default($this$SharePosterCardStatic_u24lambda_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(10), Dp.constructor-impl(10), 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
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
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1470541317, "C1040@37081L156:SharePosterView.kt#1t42f");
            String $this$asRequest_u24default$iv2 = $params.getArc().getPlayIcon();
            ImageRequest imageRequest3 = new ImageRequest($this$asRequest_u24default$iv2);
            Unit unit2 = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest3.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), null, null, null, null, null, null, null, $composer, 48, 508);
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
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv7);
            } else {
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -675562890, "C1053@37473L41,1064@37848L9,1064@37886L6,1062@37759L159,1068@37960L70,1072@38048L41,1076@38187L6,1075@38130L135,1080@38283L41,1083@38370L250,1090@38638L40:SharePosterView.kt#1t42f");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            SharePosterHonor honor = $params.getHonor();
            if (honor == null) {
                $composer.startReplaceGroup(-675492677);
                $composer.endReplaceGroup();
                $composer$iv$iv$iv = $composer;
            } else {
                $composer.startReplaceGroup(-675492676);
                ComposerKt.sourceInformation($composer, "*1057@37612L27,1058@37660L41");
                $composer$iv$iv$iv = $composer;
                HonorSection(honor, null, $composer, 0, 2);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
                Unit unit3 = Unit.INSTANCE;
                $composer.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            TextKt.Text-Nvy7gAk($params.getArc().getTitle(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT18b(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer, 0, 0, 131070);
            StatSection($params.getStat(), null, $composer, 0, 2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), $composer, 6);
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 48, 1);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
            Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
            AuthorAndQrSection($params.getAuthor(), $params.getQrcode(), $params.getArc().getPubtime(), null, $onImageLoadingStateChange, $composer, 0, 8);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterCardStatic$lambda$0$0$0$0(float $animatedScaleX, float $animatedScaleY, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX($animatedScaleX);
        $this$graphicsLayer.setScaleY($animatedScaleY);
        $this$graphicsLayer.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePosterCardStatic$lambda$0$0$1$1$0(Function2 $onImageLoadingStateChange, SharePosterParams $params, Function1 $onColorChange, ImageState image) {
        ImageBitmap bitmap;
        Intrinsics.checkNotNullParameter(image, "image");
        if (image instanceof ImageState.Loading) {
            if ($onImageLoadingStateChange != null) {
                $onImageLoadingStateChange.invoke($params.getArc().getPic(), true);
            }
        } else if (((image instanceof ImageState.Success) || (image instanceof ImageState.Error)) && $onImageLoadingStateChange != null) {
            $onImageLoadingStateChange.invoke($params.getArc().getPic(), false);
        }
        if (image instanceof ImageState.Success) {
            Image source = ((ImageState.Success) image).getSource();
            if (source instanceof StaticImage) {
                Image source2 = ((ImageState.Success) image).getSource();
                Intrinsics.checkNotNull(source2, "null cannot be cast to non-null type kntr.base.imageloader.StaticImage");
                bitmap = ((StaticImage) source2).getBitmap();
            } else if (!(source instanceof AnimateImage)) {
                throw new NoWhenBranchMatchedException();
            } else {
                Image source3 = ((ImageState.Success) image).getSource();
                Intrinsics.checkNotNull(source3, "null cannot be cast to non-null type kntr.base.imageloader.AnimateImage");
                bitmap = ((AnimateImage) source3).getFrame(0);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            ImageBitmap $this$SharePosterCardStatic_u24lambda_u240_u240_u241_u241_u240_u240 = bitmap;
            Color dominantColor = ShareColorPickerUtility.Companion.m2409getDominantColorijrfgN4($this$SharePosterCardStatic_u24lambda_u240_u240_u241_u241_u240_u240);
            if (dominantColor != null) {
                long it = dominantColor.unbox-impl();
                $onColorChange.invoke(Color.box-impl(it));
            }
        }
        return Unit.INSTANCE;
    }
}