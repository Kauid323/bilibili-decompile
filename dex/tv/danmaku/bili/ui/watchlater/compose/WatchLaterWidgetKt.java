package tv.danmaku.bili.ui.watchlater.compose;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
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
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.app.comm.list.widget.utils.ListConstKt;
import com.bilibili.app.comm.list.widget.utils.PegasusIconRes;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.iconfont.R;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: WatchLaterWidget.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aI\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0003\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\rH\u0007¢\u0006\u0004\b \u0010!\u001a9\u0010\"\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u00122\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007¢\u0006\u0002\u0010&\u001am\u0010'\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00072\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007¢\u0006\u0002\u0010/\u001aC\u00100\u001a\u00020\u0001*\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0002\u00104\u001a\u00020\u00072\u001c\u00105\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000107\u0012\u0006\u0012\u0004\u0018\u00010306H\u0007¢\u0006\u0002\u00108¨\u00069"}, d2 = {"IconText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "", "iconType", "leftPadding", "Landroidx/compose/ui/unit/Dp;", "iconSize", "textColor", "Landroidx/compose/ui/graphics/Color;", "iconTint", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "isFlipped", "", "clickable", "alpha", "", "onClick", "Lkotlin/Function0;", "IconText-H8uBujs", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;IFFJJLandroidx/compose/ui/text/TextStyle;ZZFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "WatchLaterCheckBox", "checked", "checkedColor", "unCheckedColor", "checkedIcon", "checkedIconTint", "WatchLaterCheckBox-X34t5lA", "(ZLandroidx/compose/ui/Modifier;JJIJLandroidx/compose/runtime/Composer;II)V", "PageLoadingView", "paintResource", "showRetry", "onRetryClick", "(Ljava/lang/String;IZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FooterBatchEditView", "checkedAll", "checkedCount", "onCheckAllClick", "onCancelAllClick", "onDeleteClick", "onClickCopyTo", "onClickMoveTo", "(Landroidx/compose/ui/Modifier;ZILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OnBottomReached", "Landroidx/compose/foundation/lazy/LazyListState;", "key", "", "buffer", "loadMore", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterWidgetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FooterBatchEditView$lambda$1(Modifier modifier, boolean z, int i, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i2, int i3, Composer composer, int i4) {
        FooterBatchEditView(modifier, z, i, function0, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$4(String str, Modifier modifier, Integer num, int i, float f, float f2, long j, long j2, TextStyle textStyle, boolean z, boolean z2, float f3, Function0 function0, int i2, int i3, int i4, Composer composer, int i5) {
        m1791IconTextH8uBujs(str, modifier, num, i, f, f2, j, j2, textStyle, z, z2, f3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBottomReached$lambda$3(LazyListState lazyListState, Object obj, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        OnBottomReached(lazyListState, obj, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageLoadingView$lambda$2(String str, int i, boolean z, Function0 function0, int i2, int i3, Composer composer, int i4) {
        PageLoadingView(str, i, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCheckBox_X34t5lA$lambda$1(boolean z, Modifier modifier, long j, long j2, int i, long j3, int i2, int i3, Composer composer, int i4) {
        m1792WatchLaterCheckBoxX34t5lA(z, modifier, j, j2, i, j3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:221:0x03a7, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0410, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x05a7, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L116;
     */
    /* renamed from: IconText-H8uBujs  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1791IconTextH8uBujs(final String text, Modifier modifier, Integer icon, int iconType, float f, float f2, long j, long j2, TextStyle textStyle, boolean isFlipped, boolean clickable, float alpha, Function0<Unit> function0, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        float f3;
        Composer $composer2;
        Integer icon2;
        int iconType2;
        float f4;
        long j3;
        long j4;
        TextStyle textStyle2;
        boolean isFlipped2;
        boolean clickable2;
        float alpha2;
        Function0 onClick;
        Modifier modifier3;
        float f5;
        Modifier modifier4;
        float f6;
        float f7;
        long j5;
        TextStyle textStyle3;
        final Function0 onClick2;
        final float alpha3;
        final boolean isFlipped3;
        int iconType3;
        float f8;
        Integer num;
        Modifier modifier5;
        int $dirty1;
        Function0 factory$iv$iv$iv;
        Modifier materialized$iv$iv;
        MeasurePolicy measurePolicy$iv$iv;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-1965138631);
        ComposerKt.sourceInformation($composer3, "C(IconText)N(text,modifier,icon,iconType,leftPadding:c#ui.unit.Dp,iconSize:c#ui.unit.Dp,textColor:c#ui.graphics.Color,iconTint:c#ui.graphics.Color,textStyle,isFlipped,clickable,alpha,onClick)78@3265L42,72@2999L1049:WatchLaterWidget.kt#ooxe70");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(icon) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(iconType) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            f3 = f;
        } else if (($changed & 24576) == 0) {
            f3 = f;
            $dirty |= $composer3.changed(f3) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            f3 = f;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer3.changed(f2) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(j) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0 && $composer3.changed(j2)) {
                i3 = 8388608;
                $dirty |= i3;
            }
            i3 = 4194304;
            $dirty |= i3;
        }
        if (($changed & 100663296) == 0) {
            if ((i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0 && $composer3.changed(textStyle)) {
                i2 = 67108864;
                $dirty |= i2;
            }
            i2 = 33554432;
            $dirty |= i2;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(isFlipped) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty12 |= $composer3.changed(clickable) ? 4 : 2;
        }
        int i12 = i & IjkMediaMeta.FF_PROFILE_H264_INTRA;
        if (i12 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty12 |= $composer3.changed(alpha) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty12 |= $composer3.changedInstance(function0) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty12 & 147) == 146) ? false : true, $dirty & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "64@2690L7,64@2729L7,65@2781L7");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier6 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
                Integer icon3 = i5 != 0 ? null : icon;
                int iconType4 = i6 != 0 ? 0 : iconType;
                if (i7 != 0) {
                    f3 = Dp.constructor-impl(4);
                }
                if (i8 != 0) {
                    modifier4 = modifier6;
                    f6 = Dp.constructor-impl(16);
                } else {
                    modifier4 = modifier6;
                    f6 = f2;
                }
                long j6 = i9 != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j;
                if ((i & 128) != 0) {
                    CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
                    f7 = f6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    long j7 = ((Color) consume).unbox-impl();
                    CompositionLocal this_$iv2 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer3.consume(this_$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    j5 = Color.copy-wmQWz5c$default(j7, ((Number) consume2).floatValue(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null);
                    $dirty &= -29360129;
                } else {
                    f7 = f6;
                    j5 = j2;
                }
                if ((i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0) {
                    CompositionLocal this_$iv3 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer3.consume(this_$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle3 = (TextStyle) consume3;
                    $dirty &= -234881025;
                } else {
                    textStyle3 = textStyle;
                }
                boolean isFlipped4 = i10 != 0 ? false : isFlipped;
                boolean clickable3 = i11 != 0 ? false : clickable;
                float alpha4 = i12 != 0 ? 1.0f : alpha;
                if (i13 != 0) {
                    textStyle2 = textStyle3;
                    clickable2 = clickable3;
                    alpha3 = alpha4;
                    onClick2 = null;
                    iconType2 = iconType4;
                    f5 = f3;
                    j3 = j6;
                    j4 = j5;
                    modifier3 = modifier4;
                    isFlipped3 = isFlipped4;
                    iconType3 = $dirty;
                    icon2 = icon3;
                    f8 = f7;
                } else {
                    onClick2 = function0;
                    textStyle2 = textStyle3;
                    clickable2 = clickable3;
                    alpha3 = alpha4;
                    iconType2 = iconType4;
                    f5 = f3;
                    j3 = j6;
                    j4 = j5;
                    modifier3 = modifier4;
                    isFlipped3 = isFlipped4;
                    iconType3 = $dirty;
                    icon2 = icon3;
                    f8 = f7;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0) {
                    icon2 = icon;
                    iconType2 = iconType;
                    f8 = f2;
                    j3 = j;
                    j4 = j2;
                    textStyle2 = textStyle;
                    isFlipped3 = isFlipped;
                    clickable2 = clickable;
                    onClick2 = function0;
                    modifier3 = modifier2;
                    f5 = f3;
                    iconType3 = (-234881025) & $dirty;
                    alpha3 = alpha;
                } else {
                    icon2 = icon;
                    iconType2 = iconType;
                    f8 = f2;
                    j3 = j;
                    j4 = j2;
                    textStyle2 = textStyle;
                    isFlipped3 = isFlipped;
                    clickable2 = clickable;
                    alpha3 = alpha;
                    onClick2 = function0;
                    modifier3 = modifier2;
                    f5 = f3;
                    iconType3 = $dirty;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1965138631, iconType3, $dirty12, "tv.danmaku.bili.ui.watchlater.compose.IconText (WatchLaterWidget.kt:70)");
            }
            if (iconType2 > 0) {
                PegasusIconRes pegasusIcon = ListConstKt.getPegasusIcon(iconType2);
                num = pegasusIcon != null ? Integer.valueOf(pegasusIcon.getIconRes()) : null;
            } else {
                num = icon2;
            }
            Integer iconRes = num;
            if (clickable2) {
                $composer3.startReplaceGroup(1254915182);
                ComposerKt.sourceInformation($composer3, "76@3167L67,74@3081L21");
                ComposerKt.sourceInformationMarkerStart($composer3, 1287410812, "CC(remember):WatchLaterWidget.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1287408014, "CC(remember):WatchLaterWidget.kt#9igjgp");
                boolean invalid$iv = ($dirty12 & 896) == 256;
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit IconText_H8uBujs$lambda$1$0;
                        IconText_H8uBujs$lambda$1$0 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$1$0(onClick2);
                        return IconText_H8uBujs$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                modifier5 = ClickableKt.clickable-O2vRcR0$default(modifier3, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1287413121);
                $composer3.endReplaceGroup();
                modifier5 = modifier3;
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1287413923, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv2 = ($dirty12 & 112) == 32;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2) {
                $dirty1 = $dirty12;
            } else {
                $dirty1 = $dirty12;
            }
            Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit IconText_H8uBujs$lambda$2$0;
                    IconText_H8uBujs$lambda$2$0 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$2$0(alpha3, (GraphicsLayerScope) obj);
                    return IconText_H8uBujs$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) it$iv3);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            float alpha5 = alpha3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i14 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i15 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -489948552, "C96@3869L173:WatchLaterWidget.kt#ooxe70");
            if (iconRes != null) {
                $composer3.startReplaceGroup(-489920870);
                ComposerKt.sourceInformation($composer3, "85@3484L7,85@3447L75,91@3753L83,84@3415L435");
                CompositionLocal this_$iv4 = AndroidCompositionLocals_androidKt.getLocalContext();
                materialized$iv$iv = materialized$iv$iv2;
                measurePolicy$iv$iv = measurePolicy$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(this_$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Painter rememberDrawablePainter = DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume4, iconRes.intValue()), $composer3, 0);
                Modifier modifier7 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, f5, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 11, (Object) null), f8);
                ComposerKt.sourceInformationMarkerStart($composer3, -985624760, "CC(remember):WatchLaterWidget.kt#9igjgp");
                boolean invalid$iv3 = (1879048192 & iconType3) == 536870912;
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit IconText_H8uBujs$lambda$3$0$0;
                        IconText_H8uBujs$lambda$3$0$0 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$3$0$0(isFlipped3, (GraphicsLayerScope) obj);
                        return IconText_H8uBujs$lambda$3$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(rememberDrawablePainter, "", GraphicsLayerModifierKt.graphicsLayer(modifier7, (Function1) it$iv4), j4, $composer3, Painter.$stable | 48 | ((iconType3 >> 12) & 7168), 0);
            } else {
                materialized$iv$iv = materialized$iv$iv2;
                measurePolicy$iv$iv = measurePolicy$iv;
                $composer3.startReplaceGroup(-493323027);
            }
            $composer3.endReplaceGroup();
            onClick = onClick2;
            $composer2 = $composer3;
            alpha2 = alpha5;
            f4 = f8;
            isFlipped2 = isFlipped3;
            TextKt.Text--4IGK_g(text, (Modifier) null, j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, textStyle2, $composer3, (iconType3 & 14) | ((iconType3 >> 12) & 896), ((iconType3 >> 6) & 3670016) | 3120, 55290);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            icon2 = icon;
            iconType2 = iconType;
            f4 = f2;
            j3 = j;
            j4 = j2;
            textStyle2 = textStyle;
            isFlipped2 = isFlipped;
            clickable2 = clickable;
            alpha2 = alpha;
            onClick = function0;
            modifier3 = modifier2;
            f5 = f3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final Integer num2 = icon2;
            final int i16 = iconType2;
            final float f9 = f5;
            final float f10 = f4;
            final long j8 = j3;
            final long j9 = j4;
            final TextStyle textStyle4 = textStyle2;
            final boolean z = isFlipped2;
            final boolean z2 = clickable2;
            final float f11 = alpha2;
            final Function0 function02 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit IconText_H8uBujs$lambda$4;
                    IconText_H8uBujs$lambda$4 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$4(text, modifier8, num2, i16, f9, f10, j8, j9, textStyle4, z, z2, f11, function02, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return IconText_H8uBujs$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$1$0(Function0 $onClick) {
        if ($onClick != null) {
            $onClick.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$2$0(float $alpha, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($alpha);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$3$0$0(boolean $isFlipped, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleY($isFlipped ? -1.0f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x02ef, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L95;
     */
    /* renamed from: WatchLaterCheckBox-X34t5lA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1792WatchLaterCheckBoxX34t5lA(final boolean checked, Modifier modifier, long j, long j2, int checkedIcon, long j3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j4;
        int checkedIcon2;
        long j5;
        long j6;
        Modifier modifier3;
        int checkedIcon3;
        long j7;
        long j8;
        long j9;
        int $dirty;
        long j10;
        Function0 factory$iv$iv$iv;
        int checkedIcon4;
        int i2;
        int i3;
        int i4;
        int i5;
        Composer $composer2 = $composer.startRestartGroup(-1882534184);
        ComposerKt.sourceInformation($composer2, "C(WatchLaterCheckBox)N(checked,modifier,checkedColor:c#ui.graphics.Color,unCheckedColor:c#ui.graphics.Color,checkedIcon,checkedIconTint:c#ui.graphics.Color)115@4410L988:WatchLaterWidget.kt#ooxe70");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j4 = j;
                if ($composer2.changed(j4)) {
                    i5 = IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
                    $dirty2 |= i5;
                }
            } else {
                j4 = j;
            }
            i5 = 128;
            $dirty2 |= i5;
        } else {
            j4 = j;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0 && $composer2.changed(j2)) {
                i4 = IjkMediaMeta.FF_PROFILE_H264_INTRA;
                $dirty2 |= i4;
            }
            i4 = 1024;
            $dirty2 |= i4;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                checkedIcon2 = checkedIcon;
                if ($composer2.changed(checkedIcon2)) {
                    i3 = IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID;
                    $dirty2 |= i3;
                }
            } else {
                checkedIcon2 = checkedIcon;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            checkedIcon2 = checkedIcon;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                j5 = j3;
                if ($composer2.changed(j5)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                j5 = j3;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            j5 = j3;
        }
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "110@4181L6,111@4238L6,113@4384L6");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i & 4) != 0) {
                    j4 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    j9 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU();
                    $dirty2 &= -7169;
                } else {
                    j9 = j2;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    checkedIcon2 = R.drawable.ref_checkmark_line_500;
                }
                if ((i & 32) != 0) {
                    j5 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU();
                    $dirty = $dirty2 & (-458753);
                    j10 = j9;
                } else {
                    $dirty = $dirty2;
                    j10 = j9;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                j10 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1882534184, $dirty, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterCheckBox (WatchLaterWidget.kt:114)");
            }
            int $changed$iv = ($dirty >> 3) & 14;
            Modifier modifier$iv = modifier2;
            modifier3 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            j8 = j5;
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
            int checkedIcon5 = checkedIcon2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -341252064, "C120@4542L17,120@4561L374,118@4459L476:WatchLaterWidget.kt#ooxe70");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1950669041, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit WatchLaterCheckBox_X34t5lA$lambda$0$0$0;
                        WatchLaterCheckBox_X34t5lA$lambda$0$0$0 = WatchLaterWidgetKt.WatchLaterCheckBox_X34t5lA$lambda$0$0$0((ContentDrawScope) obj);
                        return WatchLaterCheckBox_X34t5lA$lambda$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier drawWithContent = DrawModifierKt.drawWithContent(fillMaxSize$default, (Function1) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, -1950668076, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (((($dirty & 896) ^ 384) > 256 && $composer2.changed(j4)) || ($dirty & 384) == 256) | (((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(j10)) || ($dirty & 3072) == 2048);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final long j11 = j4;
            final long j12 = j10;
            Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    Unit WatchLaterCheckBox_X34t5lA$lambda$0$1$0;
                    WatchLaterCheckBox_X34t5lA$lambda$0$1$0 = WatchLaterWidgetKt.WatchLaterCheckBox_X34t5lA$lambda$0$1$0(checked, j11, j12, (DrawScope) obj);
                    return WatchLaterCheckBox_X34t5lA$lambda$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(drawWithContent, (Function1) it$iv2, $composer2, 0);
            if (checked) {
                $composer2.startReplaceGroup(-340760343);
                ComposerKt.sourceInformation($composer2, "139@5179L7,138@5110L174,134@4971L411");
                Modifier modifier4 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(3));
                CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
                j6 = j10;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                checkedIcon4 = checkedIcon5;
                IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume, checkedIcon4), $composer2, 0), (String) null, modifier4, j8, $composer2, Painter.$stable | 432 | (($dirty >> 6) & 7168), 0);
            } else {
                j6 = j10;
                checkedIcon4 = checkedIcon5;
                $composer2.startReplaceGroup(-345705308);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkedIcon3 = checkedIcon4;
            j7 = j4;
        } else {
            $composer2.skipToGroupEnd();
            j6 = j2;
            modifier3 = modifier2;
            checkedIcon3 = checkedIcon2;
            j7 = j4;
            j8 = j5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j13 = j7;
            final long j14 = j6;
            final int i9 = checkedIcon3;
            final long j15 = j8;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterCheckBox_X34t5lA$lambda$1;
                    WatchLaterCheckBox_X34t5lA$lambda$1 = WatchLaterWidgetKt.WatchLaterCheckBox_X34t5lA$lambda$1(checked, modifier5, j13, j14, i9, j15, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterCheckBox_X34t5lA$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCheckBox_X34t5lA$lambda$0$0$0(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCheckBox_X34t5lA$lambda$0$1$0(boolean $checked, long j, long j2, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        if ($checked) {
            DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0L, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (DrawStyle) null, (ColorFilter) null, 0, (int) Player.PLAYER_QUALITY_DOLBY_VISION, (Object) null);
        } else {
            DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j2, (Size.getMinDimension-impl($this$Canvas.getSize-NH-jbRc()) - $this$Canvas.toPx-0680j_4(Dp.constructor-impl(2))) / 2, 0L, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, new Stroke($this$Canvas.toPx-0680j_4(Dp.constructor-impl(1)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, (int) AddCustomDanmaku.TYPE_LIVE_DANMU_V2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15 */
    public static final void PageLoadingView(final String text, final int paintResource, boolean showRetry, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0 function02;
        Composer $composer2;
        boolean showRetry2;
        Function0 onRetryClick;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer4 = $composer.startRestartGroup(-325417093);
        ComposerKt.sourceInformation($composer4, "C(PageLoadingView)N(text,paintResource,showRetry,onRetryClick)155@5553L2,158@5565L1074:WatchLaterWidget.kt#ooxe70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(paintResource) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            z = showRetry;
        } else if (($changed & 384) == 0) {
            z = showRetry;
            $dirty |= $composer4.changed(z) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            z = showRetry;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function02 = function0;
        } else if (($changed & 3072) == 0) {
            function02 = function0;
            $dirty |= $composer4.changedInstance(function02) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                showRetry2 = false;
            } else {
                showRetry2 = z;
            }
            if (i3 == 0) {
                onRetryClick = function02;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer4, 806790685, "CC(remember):WatchLaterWidget.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onRetryClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onRetryClick = onRetryClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-325417093, $dirty2, -1, "tv.danmaku.bili.ui.watchlater.compose.PageLoadingView (WatchLaterWidget.kt:156)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -2064626089, "C160@5663L35,159@5634L159,164@5802L40,165@5887L6,165@5919L9,165@5851L82:WatchLaterWidget.kt#ooxe70");
            ImageKt.Image(PainterResources_androidKt.painterResource(paintResource, $composer4, ($dirty2 >> 3) & 14), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer4, Painter.$stable | 432, 120);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer4, 6);
            $composer2 = $composer4;
            TextKt.Text--4IGK_g(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, $dirty2 & 14, 0, 65530);
            if (showRetry2) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-2064315687);
                ComposerKt.sourceInformation($composer3, "167@5971L41,169@6054L75,171@6211L9,172@6260L6,175@6390L6,168@6025L598");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_432, $composer3, 0), PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15))), false, (String) null, (Role) null, (MutableInteractionSource) null, onRetryClick, 15, (Object) null), Dp.constructor-impl(27), Dp.constructor-impl(5)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 65016);
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-2070246979);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            showRetry2 = z;
            onRetryClick = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = showRetry2;
            final Function0 function03 = onRetryClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit PageLoadingView$lambda$2;
                    PageLoadingView$lambda$2 = WatchLaterWidgetKt.PageLoadingView$lambda$2(text, paintResource, z2, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PageLoadingView$lambda$2;
                }
            });
        }
    }

    public static final void FooterBatchEditView(Modifier modifier, final boolean checkedAll, final int checkedCount, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Object it$iv;
        Function0 factory$iv$iv$iv3;
        boolean z;
        String str;
        long j;
        long j2;
        long j3;
        long j4;
        Intrinsics.checkNotNullParameter(function0, "onCheckAllClick");
        Intrinsics.checkNotNullParameter(function02, "onCancelAllClick");
        Intrinsics.checkNotNullParameter(function03, "onDeleteClick");
        Intrinsics.checkNotNullParameter(function04, "onClickCopyTo");
        Intrinsics.checkNotNullParameter(function05, "onClickMoveTo");
        Composer $composer3 = $composer.startRestartGroup(692580373);
        ComposerKt.sourceInformation($composer3, "C(FooterBatchEditView)N(modifier,checkedAll,checkedCount,onCheckAllClick,onCancelAllClick,onDeleteClick,onClickCopyTo,onClickMoveTo)196@6930L5051:WatchLaterWidget.kt#ooxe70");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(checkedAll) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(checkedCount) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function03) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function04) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function05) ? 8388608 : 4194304;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((4793491 & $dirty2) != 4793490, $dirty2 & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(692580373, $dirty2, -1, "tv.danmaku.bili.ui.watchlater.compose.FooterBatchEditView (WatchLaterWidget.kt:195)");
            }
            int $changed$iv = $dirty2 & 14;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 912215203, "C199@6982L403,216@7530L6,212@7394L165,225@7826L83,223@7726L3,229@7974L6,218@7568L4407:WatchLaterWidget.kt#ooxe70");
            BoxKt.Box(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(32)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.1f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null))}), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0, 14, (Object) null), (Shape) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null), $composer3, 6);
            DividerKt.Divider-oMI9zvI(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $composer3, 6, 12);
            Modifier modifier3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(48));
            ComposerKt.sourceInformationMarkerStart($composer3, -801835598, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -801838878, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClickableKt.clickable-O2vRcR0$default(modifier3, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$FooterBatchEditView_u24lambda_u240_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1137981007, "C236@8251L75,233@8102L779,252@8894L38,261@9348L9,268@9720L91,253@8945L902,273@9860L40,275@9942L75,276@10053L9,283@10422L91,274@9913L636,288@10562L40,290@10644L81,291@10761L9,298@11130L91,289@10615L642,303@11270L40,305@11352L81,306@11469L9,313@11838L91,304@11323L642:WatchLaterWidget.kt#ooxe70");
            Modifier modifier4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, -1283634074, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(MutableInteractionSource);
                it$iv = MutableInteractionSource;
            } else {
                it$iv = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            Modifier modifier$iv3 = ClickableKt.clickable-O2vRcR0$default(modifier4, (MutableInteractionSource) it$iv, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
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
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1097835617, "C240@8408L156,245@8581L39,247@8670L74,248@8784L9,249@8837L6,246@8637L230:WatchLaterWidget.kt#ooxe70");
            m1792WatchLaterCheckBoxX34t5lA(checkedAll, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), 0L, 0L, 0, 0L, $composer3, (($dirty2 >> 3) & 14) | 48, 60);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_13, $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$FooterBatchEditView_u24lambda_u240_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(-1283609923);
                ComposerKt.sourceInformation($composer3, "255@9031L81");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                z = true;
                String format = String.format(StringResources_androidKt.stringResource(bili.resource.favorites.R.string.favorites_global_string_237, $composer3, 0), Arrays.copyOf(new Object[]{Integer.valueOf(checkedCount)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                $composer3.endReplaceGroup();
                str = format;
            } else {
                z = true;
                $composer3.startReplaceGroup(-1137020566);
                ComposerKt.sourceInformation($composer3, "259@9209L81");
                String stringResource = StringResources_androidKt.stringResource(bili.resource.favorites.R.string.favorites_global_string_226, $composer3, 0);
                $composer3.endReplaceGroup();
                str = stringResource;
            }
            TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(-1283596544);
                ComposerKt.sourceInformation($composer3, "262@9419L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-1283595648);
                ComposerKt.sourceInformation($composer3, "262@9447L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j5 = j;
            Modifier modifier5 = Modifier.Companion;
            boolean z2 = checkedCount > 0 ? z : false;
            ComposerKt.sourceInformationMarkerStart($composer3, -1283587050, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv3);
                it$iv5 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(str, ClickableKt.clickable-O2vRcR0$default(modifier5, (MutableInteractionSource) it$iv5, (Indication) null, z2, (String) null, (Role) null, function02, 24, (Object) null), j5, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t13, $composer3, 0, 0, 65528);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            String stringResource2 = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_113, $composer3, 0);
            TextStyle t132 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(-1283573984);
                ComposerKt.sourceInformation($composer3, "277@10124L6");
                j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-1283573088);
                ComposerKt.sourceInformation($composer3, "277@10152L6");
                j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j6 = j2;
            Modifier modifier6 = Modifier.Companion;
            boolean z3 = checkedCount > 0;
            ComposerKt.sourceInformationMarkerStart($composer3, -1283564586, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv4);
                it$iv6 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(stringResource2, ClickableKt.clickable-O2vRcR0$default(modifier6, (MutableInteractionSource) it$iv6, (Indication) null, z3, (String) null, (Role) null, function03, 24, (Object) null), j6, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t132, $composer3, 0, 0, 65528);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            String stringResource3 = StringResources_androidKt.stringResource(bili.resource.favorites.R.string.favorites_global_string_121, $composer3, 0);
            TextStyle t133 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(-1283551328);
                ComposerKt.sourceInformation($composer3, "292@10832L6");
                j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-1283550432);
                ComposerKt.sourceInformation($composer3, "292@10860L6");
                j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j7 = j3;
            Modifier modifier7 = Modifier.Companion;
            boolean z4 = checkedCount > 0;
            ComposerKt.sourceInformationMarkerStart($composer3, -1283541930, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv5);
                it$iv7 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(stringResource3, ClickableKt.clickable-O2vRcR0$default(modifier7, (MutableInteractionSource) it$iv7, (Indication) null, z4, (String) null, (Role) null, function04, 24, (Object) null), j7, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t133, $composer3, 0, 0, 65528);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            String stringResource4 = StringResources_androidKt.stringResource(bili.resource.favorites.R.string.favorites_global_string_152, $composer3, 0);
            TextStyle t134 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(-1283528672);
                ComposerKt.sourceInformation($composer3, "307@11540L6");
                j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-1283527776);
                ComposerKt.sourceInformation($composer3, "307@11568L6");
                j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j8 = j4;
            Modifier modifier8 = Modifier.Companion;
            boolean z5 = checkedCount > 0;
            ComposerKt.sourceInformationMarkerStart($composer3, -1283519274, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv6 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv6);
                it$iv8 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text--4IGK_g(stringResource4, ClickableKt.clickable-O2vRcR0$default(modifier8, (MutableInteractionSource) it$iv8, (Indication) null, z5, (String) null, (Role) null, function05, 24, (Object) null), j8, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t134, $composer3, 0, 0, 65528);
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
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier9 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit FooterBatchEditView$lambda$1;
                    FooterBatchEditView$lambda$1 = WatchLaterWidgetKt.FooterBatchEditView$lambda$1(modifier9, checkedAll, checkedCount, function0, function02, function03, function04, function05, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FooterBatchEditView$lambda$1;
                }
            });
        }
    }

    public static final void OnBottomReached(final LazyListState $this$OnBottomReached, final Object key, int buffer, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Composer $composer, final int $changed, final int i) {
        int i2;
        int buffer2;
        Intrinsics.checkNotNullParameter($this$OnBottomReached, "<this>");
        Intrinsics.checkNotNullParameter(function1, "loadMore");
        Composer $composer2 = $composer.startRestartGroup(-1493056943);
        ComposerKt.sourceInformation($composer2, "C(OnBottomReached)N(key,buffer,loadMore)334@12347L356,344@12766L156,344@12708L215:WatchLaterWidget.kt#ooxe70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$OnBottomReached) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(key) ? 32 : 16;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 384;
            i2 = buffer;
        } else if (($changed & 384) == 0) {
            i2 = buffer;
            $dirty |= $composer2.changed(i2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            i2 = buffer;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            buffer2 = i2;
        } else {
            final int buffer3 = i3 != 0 ? 12 : i2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493056943, $dirty2, -1, "tv.danmaku.bili.ui.watchlater.compose.OnBottomReached (WatchLaterWidget.kt:329)");
            }
            if (!(buffer3 >= 0)) {
                throw new IllegalArgumentException("buffer 值必须是正整数".toString());
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -308638731, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(key);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        boolean OnBottomReached$lambda$1$0;
                        OnBottomReached$lambda$1$0 = WatchLaterWidgetKt.OnBottomReached$lambda$1$0($this$OnBottomReached, buffer3);
                        return Boolean.valueOf(OnBottomReached$lambda$1$0);
                    }
                });
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            State shouldLoadMore = (State) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -308625523, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(shouldLoadMore) | $composer2.changedInstance(function1);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new WatchLaterWidgetKt$OnBottomReached$2$1(shouldLoadMore, function1, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(shouldLoadMore, key, (Function2) it$iv2, $composer2, $dirty2 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            buffer2 = buffer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final int i4 = buffer2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnBottomReached$lambda$3;
                    OnBottomReached$lambda$3 = WatchLaterWidgetKt.OnBottomReached$lambda$3($this$OnBottomReached, key, i4, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OnBottomReached$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OnBottomReached$lambda$1$0(LazyListState $this_OnBottomReached, int $buffer) {
        LazyListItemInfo lastVisibleItem = (LazyListItemInfo) CollectionsKt.lastOrNull($this_OnBottomReached.getLayoutInfo().getVisibleItemsInfo());
        return lastVisibleItem == null || lastVisibleItem.getIndex() >= ($this_OnBottomReached.getLayoutInfo().getTotalItemsCount() - 1) - $buffer;
    }
}