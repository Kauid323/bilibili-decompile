package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.GarbInfo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import io.grpc.internal.GrpcUtil;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: IMTopBar.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032(\b\u0002\u0010\u000e\u001a\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0015\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0082\b\u001a\u001f\u0010\u0019\u001a\u00020\u00012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\u0003¢\u0006\u0002\u0010\u001a\u001a\u001f\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u001e\u001a\u0017\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"IMTopBar", "", "titleContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "titleColor", "Landroidx/compose/ui/graphics/Color;", "iconColor", "showDivider", "", "showBackButton", "onBack", "backgroundContent", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "actionContent", "IMTopBar--nWoaYo", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;JJZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "maxWidth", "", "", "Landroidx/compose/ui/layout/Placeable;", "BackIcon", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TextTitle", "title", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TopBarBackground", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$3(Function0 function0, int i2, int i3, Composer composer, int i4) {
        BackIcon(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$5(Function2 function2, Modifier modifier, long j, long j2, boolean z, boolean z2, Function0 function0, Function3 function3, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m3090IMTopBarnWoaYo(function2, modifier, j, j2, z, z2, function0, function3, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextTitle$lambda$1(String str, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        TextTitle(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarBackground$lambda$0(Modifier modifier, int i2, int i3, Composer composer, int i4) {
        TopBarBackground(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$0(Modifier $modifier, Modifier it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)52@2102L26:IMTopBar.kt#uu6lp7");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(703028484, $changed, -1, "im.base.IMTopBar.<anonymous> (IMTopBar.kt:52)");
            }
            TopBarBackground($modifier, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x02d7, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0398, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:196:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03cc  */
    /* renamed from: IMTopBar--nWoaYo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3090IMTopBarnWoaYo(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, long j, long j2, boolean showDivider, boolean showBackButton, Function0<Unit> function0, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i2) {
        long j3;
        boolean z;
        Modifier modifier2;
        long j4;
        boolean showDivider2;
        final Function0 onBack;
        final Function3 backgroundContent;
        final Function2 actionContent;
        boolean showBackButton2;
        long j5;
        final Modifier modifier3;
        long j6;
        final boolean showDivider3;
        boolean showBackButton3;
        Function0 onBack2;
        Function3 backgroundContent2;
        Function2 actionContent2;
        Function3 backgroundContent3;
        int $dirty;
        long j7;
        boolean showDivider4;
        long j8;
        boolean showDivider5;
        boolean z2;
        boolean invalid$iv;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(function2, "titleContent");
        Composer $composer2 = $composer.startRestartGroup(1143363836);
        ComposerKt.sourceInformation($composer2, "C(IMTopBar)N(titleContent,modifier,titleColor:c#ui.graphics.Color,iconColor:c#ui.graphics.Color,showDivider,showBackButton,onBack,backgroundContent,actionContent)55@2217L6,57@2287L7,60@2368L10,60@2379L17,62@2468L7,70@2703L442,82@3153L2738,65@2536L3355:IMTopBar.kt#uu6lp7");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i2 & 4) == 0 && $composer2.changed(j)) {
                i5 = 256;
                $dirty2 |= i5;
            }
            i5 = 128;
            $dirty2 |= i5;
        }
        if (($changed & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j3 = j2;
                if ($composer2.changed(j3)) {
                    i4 = 2048;
                    $dirty2 |= i4;
                }
            } else {
                j3 = j2;
            }
            i4 = 1024;
            $dirty2 |= i4;
        } else {
            j3 = j2;
        }
        int i7 = i2 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(showDivider) ? 16384 : GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE;
        }
        if (($changed & 196608) == 0) {
            if ((i2 & 32) == 0) {
                z = showBackButton;
                if ($composer2.changed(z)) {
                    i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    $dirty2 |= i3;
                }
            } else {
                z = showBackButton;
            }
            i3 = WXMediaMessage.THUMB_LENGTH_LIMIT;
            $dirty2 |= i3;
        } else {
            z = showBackButton;
        }
        int i8 = i2 & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        int i9 = i2 & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        int i10 = i2 & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ($composer2.shouldExecute(($dirty2 & 38347923) != 38347922, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "47@1829L11,48@1885L11,50@1982L10,52@2100L30");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i2 & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i2 & 32) != 0) {
                    modifier3 = modifier;
                    showDivider3 = showDivider;
                    onBack2 = function0;
                    backgroundContent3 = function3;
                    actionContent2 = function22;
                    showBackButton3 = z;
                    $dirty = (-458753) & $dirty2;
                    j7 = j;
                } else {
                    modifier3 = modifier;
                    showDivider3 = showDivider;
                    onBack2 = function0;
                    backgroundContent3 = function3;
                    actionContent2 = function22;
                    showBackButton3 = z;
                    $dirty = $dirty2;
                    j7 = j;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i2 & 4) == 0) {
                    j6 = j;
                } else {
                    j6 = BiliTheme.INSTANCE.getThemeColors($composer2, BiliTheme.$stable).getTextTitle-0d7_KjU();
                    $dirty2 &= -897;
                }
                if ((i2 & 8) != 0) {
                    j3 = BiliTheme.INSTANCE.getThemeColors($composer2, BiliTheme.$stable).getActionIcon-0d7_KjU();
                    $dirty2 &= -7169;
                }
                if (i7 == 0) {
                    showDivider3 = showDivider;
                } else {
                    showDivider3 = true;
                }
                if ((i2 & 32) == 0) {
                    showBackButton3 = z;
                } else {
                    showBackButton3 = !BiliTheme.INSTANCE.getInHomePage($composer2, BiliTheme.$stable);
                    $dirty2 &= -458753;
                }
                if (i8 == 0) {
                    onBack2 = function0;
                } else {
                    onBack2 = null;
                }
                if (i9 == 0) {
                    backgroundContent2 = function3;
                } else {
                    backgroundContent2 = (Function3) ComposableLambdaKt.rememberComposableLambda(703028484, true, new Function3() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit IMTopBar__nWoaYo$lambda$0;
                            IMTopBar__nWoaYo$lambda$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$0(modifier3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return IMTopBar__nWoaYo$lambda$0;
                        }
                    }, $composer2, 54);
                }
                if (i10 != 0) {
                    $dirty = $dirty2;
                    actionContent2 = ComposableSingletons$IMTopBarKt.INSTANCE.m3066getLambda$1949318061$base_ui_debug();
                    backgroundContent3 = backgroundContent2;
                    j7 = j6;
                } else {
                    actionContent2 = function22;
                    backgroundContent3 = backgroundContent2;
                    $dirty = $dirty2;
                    j7 = j6;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1143363836, $dirty, -1, "im.base.IMTopBar (IMTopBar.kt:54)");
            }
            final long dividerColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            backgroundContent = backgroundContent3;
            actionContent = actionContent2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$IMTopBar__nWoaYo_u24lambda_u241 = (Density) consume;
            final float dividerHeight = $this$IMTopBar__nWoaYo_u24lambda_u241.toPx-0680j_4(Dp.constructor-impl((float) 0.5d));
            float paddingTop = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6), $composer2, 0).calculateTopPadding-D9Ej5fM();
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            onBack = onBack2;
            long j9 = j7;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$IMTopBar__nWoaYo_u24lambda_u242 = (Density) consume2;
            final int paddingTopPx = MathKt.roundToInt($this$IMTopBar__nWoaYo_u24lambda_u242.toPx-0680j_4(paddingTop));
            Modifier modifier4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(Dp.constructor-impl(44) + paddingTop));
            ComposerKt.sourceInformationMarkerStart($composer2, -738948970, "CC(remember):IMTopBar.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(dividerColor) | ((57344 & $dirty) == 16384) | $composer2.changed(dividerHeight);
            modifier2 = modifier3;
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv = new Function1() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj) {
                    Unit IMTopBar__nWoaYo$lambda$3$0;
                    IMTopBar__nWoaYo$lambda$3$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$3$0(showDivider3, dividerColor, dividerHeight, (ContentDrawScope) obj);
                    return IMTopBar__nWoaYo$lambda$3$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier drawWithContent = DrawModifierKt.drawWithContent(modifier4, (Function1) value$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, -738932274, "CC(remember):IMTopBar.kt#9igjgp");
            boolean z3 = (((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(j3)) || ($dirty & 3072) == 2048) | ((((458752 & $dirty) ^ 196608) > 131072 && $composer2.changed(showBackButton3)) || ($dirty & 196608) == 131072) | ((3670016 & $dirty) == 1048576) | ((234881024 & $dirty) == 67108864);
            if ((($dirty & 896) ^ 384) > 256) {
                showDivider4 = showDivider3;
                j8 = j9;
                if ($composer2.changed(j8)) {
                    showDivider5 = showDivider4;
                    z2 = true;
                    invalid$iv = z3 | z2 | (($dirty & 14) == 4) | ((29360128 & $dirty) == 8388608) | $composer2.changed(paddingTopPx);
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    final boolean z4 = showBackButton3;
                    final long j10 = j3;
                    final long j11 = j8;
                    Object value$iv2 = new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj, Object obj2) {
                            MeasureResult IMTopBar__nWoaYo$lambda$4$0;
                            IMTopBar__nWoaYo$lambda$4$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0(paddingTopPx, z4, j10, onBack, actionContent, j11, function2, backgroundContent, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                            return IMTopBar__nWoaYo$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    SubcomposeLayoutKt.SubcomposeLayout(drawWithContent, (Function2) it$iv, $composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j8;
                    showBackButton2 = showBackButton3;
                    showDivider2 = showDivider5;
                    j5 = j3;
                }
            } else {
                showDivider4 = showDivider3;
                j8 = j9;
            }
            showDivider5 = showDivider4;
            if (($dirty & 384) != 256) {
                z2 = false;
                invalid$iv = z3 | z2 | (($dirty & 14) == 4) | ((29360128 & $dirty) == 8388608) | $composer2.changed(paddingTopPx);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                final boolean z42 = showBackButton3;
                final long j102 = j3;
                final long j112 = j8;
                Object value$iv22 = new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2) {
                        MeasureResult IMTopBar__nWoaYo$lambda$4$0;
                        IMTopBar__nWoaYo$lambda$4$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0(paddingTopPx, z42, j102, onBack, actionContent, j112, function2, backgroundContent, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        return IMTopBar__nWoaYo$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv22);
                it$iv2 = value$iv22;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SubcomposeLayoutKt.SubcomposeLayout(drawWithContent, (Function2) it$iv2, $composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j4 = j8;
                showBackButton2 = showBackButton3;
                showDivider2 = showDivider5;
                j5 = j3;
            }
            z2 = true;
            invalid$iv = z3 | z2 | (($dirty & 14) == 4) | ((29360128 & $dirty) == 8388608) | $composer2.changed(paddingTopPx);
            Object it$iv22 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final boolean z422 = showBackButton3;
            final long j1022 = j3;
            final long j1122 = j8;
            Object value$iv222 = new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    MeasureResult IMTopBar__nWoaYo$lambda$4$0;
                    IMTopBar__nWoaYo$lambda$4$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0(paddingTopPx, z422, j1022, onBack, actionContent, j1122, function2, backgroundContent, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    return IMTopBar__nWoaYo$lambda$4$0;
                }
            };
            $composer2.updateRememberedValue(value$iv222);
            it$iv22 = value$iv222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(drawWithContent, (Function2) it$iv22, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j4 = j8;
            showBackButton2 = showBackButton3;
            showDivider2 = showDivider5;
            j5 = j3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            j4 = j;
            showDivider2 = showDivider;
            onBack = function0;
            backgroundContent = function3;
            actionContent = function22;
            showBackButton2 = z;
            j5 = j3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final long j12 = j4;
            final long j13 = j5;
            final boolean z5 = showDivider2;
            final boolean z6 = showBackButton2;
            final Function0 function02 = onBack;
            final Function3 function32 = backgroundContent;
            final Function2 function23 = actionContent;
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMTopBar__nWoaYo$lambda$5;
                    IMTopBar__nWoaYo$lambda$5 = IMTopBarKt.IMTopBar__nWoaYo$lambda$5(function2, modifier5, j12, j13, z5, z6, function02, function32, function23, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMTopBar__nWoaYo$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$3$0(boolean $showDivider, long $dividerColor, float $dividerHeight, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        if ($showDivider) {
            $this$drawWithContent.drawContent();
            int bits$iv$iv$iv = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            float y$iv = Float.intBitsToFloat(bits$iv$iv$iv) - $dividerHeight;
            long v1$iv$iv = Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            long j = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            int bits$iv$iv$iv2 = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
            float width$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
            long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv2 = Float.floatToRawIntBits($dividerHeight);
            DrawScope.-CC.drawRect-n-J9OG0$default((DrawScope) $this$drawWithContent, $dividerColor, j, Size.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), (float) CropImageView.DEFAULT_ASPECT_RATIO, (DrawStyle) null, (ColorFilter) null, 0, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, (Object) null);
        } else {
            $this$drawWithContent.drawContent();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult IMTopBar__nWoaYo$lambda$4$0(final int $paddingTopPx, final boolean $showBackButton, final long j, final Function0 $onBack, final Function2 $actionContent, final long j2, final Function2 $titleContent, final Function3 $backgroundContent, SubcomposeMeasureScope $this$SubcomposeLayout, final Constraints constraints) {
        Integer valueOf;
        long contentConstraint;
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        Iterable back = $this$SubcomposeLayout.subcompose("back", ComposableLambdaKt.composableLambdaInstance(-1912139725, true, new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit IMTopBar__nWoaYo$lambda$4$0$0;
                IMTopBar__nWoaYo$lambda$4$0$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$0($showBackButton, j, $onBack, (Composer) obj, ((Integer) obj2).intValue());
                return IMTopBar__nWoaYo$lambda$4$0$0;
            }
        }));
        Iterable actions = $this$SubcomposeLayout.subcompose("actions", ComposableLambdaKt.composableLambdaInstance(-1701781323, true, new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2) {
                Unit IMTopBar__nWoaYo$lambda$4$0$1;
                IMTopBar__nWoaYo$lambda$4$0$1 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$1(j, $actionContent, (Composer) obj, ((Integer) obj2).intValue());
                return IMTopBar__nWoaYo$lambda$4$0$1;
            }
        }));
        Iterable titleMeasure = $this$SubcomposeLayout.subcompose("title", ComposableLambdaKt.composableLambdaInstance(255536724, true, new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2) {
                Unit IMTopBar__nWoaYo$lambda$4$0$2;
                IMTopBar__nWoaYo$lambda$4$0$2 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$2(j2, $titleContent, (Composer) obj, ((Integer) obj2).intValue());
                return IMTopBar__nWoaYo$lambda$4$0$2;
            }
        }));
        Iterable backGround = $this$SubcomposeLayout.subcompose("background", ComposableLambdaKt.composableLambdaInstance(-1266502420, true, new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj, Object obj2) {
                Unit IMTopBar__nWoaYo$lambda$4$0$3;
                IMTopBar__nWoaYo$lambda$4$0$3 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$3($backgroundContent, (Composer) obj, ((Integer) obj2).intValue());
                return IMTopBar__nWoaYo$lambda$4$0$3;
            }
        }));
        long contentConstraint2 = ConstraintsKt.Constraints$default(0, Constraints.getMaxWidth-impl(constraints.unbox-impl()), 0, Constraints.getMaxHeight-impl(constraints.unbox-impl()) - $paddingTopPx, 5, (Object) null);
        Iterable $this$map$iv = back;
        int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
        Collection destination$iv$iv = new ArrayList($i$f$map);
        for (Object item$iv$iv : $this$map$iv) {
            Measurable it = (Measurable) item$iv$iv;
            destination$iv$iv.add(it.measure-BRTryo0(contentConstraint2));
        }
        final List backPlace = (List) destination$iv$iv;
        Iterable $this$map$iv2 = actions;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Iterable $this$map$iv3 = $this$map$iv2;
            Measurable it2 = (Measurable) item$iv$iv2;
            destination$iv$iv2.add(it2.measure-BRTryo0(contentConstraint2));
            $this$map$iv2 = $this$map$iv3;
        }
        final List actionsPlace = (List) destination$iv$iv2;
        Iterator it3 = backPlace.iterator();
        Integer num = null;
        if (it3.hasNext()) {
            Placeable it$iv = (Placeable) it3.next();
            valueOf = Integer.valueOf(it$iv.getWidth());
            while (it3.hasNext()) {
                Placeable it$iv2 = (Placeable) it3.next();
                long contentConstraint3 = contentConstraint2;
                Integer valueOf2 = Integer.valueOf(it$iv2.getWidth());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
                contentConstraint2 = contentConstraint3;
            }
            contentConstraint = contentConstraint2;
        } else {
            contentConstraint = contentConstraint2;
            valueOf = null;
        }
        Integer num2 = valueOf;
        int intValue = num2 != null ? num2.intValue() : 0;
        Iterator it4 = actionsPlace.iterator();
        if (it4.hasNext()) {
            Placeable it$iv3 = (Placeable) it4.next();
            Integer valueOf3 = Integer.valueOf(it$iv3.getWidth());
            while (it4.hasNext()) {
                Placeable it$iv4 = (Placeable) it4.next();
                Integer valueOf4 = Integer.valueOf(it$iv4.getWidth());
                if (valueOf3.compareTo(valueOf4) < 0) {
                    valueOf3 = valueOf4;
                }
            }
            num = valueOf3;
        }
        Integer num3 = num;
        int maxWidth = RangesKt.coerceAtLeast(intValue, num3 != null ? num3.intValue() : 0);
        int titleWidth = RangesKt.coerceAtLeast(Constraints.getMaxWidth-impl(constraints.unbox-impl()) - (maxWidth * 2), 0);
        Iterable $this$map$iv4 = backGround;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
        boolean z = false;
        for (Object item$iv$iv3 : $this$map$iv4) {
            Iterable $this$map$iv5 = $this$map$iv4;
            Measurable it5 = (Measurable) item$iv$iv3;
            destination$iv$iv3.add(it5.measure-BRTryo0(constraints.unbox-impl()));
            $this$map$iv4 = $this$map$iv5;
            z = z;
        }
        final List backgroundPlace = (List) destination$iv$iv3;
        Iterable $this$map$iv6 = titleMeasure;
        boolean z2 = false;
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv6;
        boolean z3 = false;
        for (Object item$iv$iv4 : $this$mapTo$iv$iv) {
            Iterable $this$map$iv7 = $this$map$iv6;
            Measurable it6 = (Measurable) item$iv$iv4;
            boolean z4 = z2;
            int $i$f$map2 = Constraints.getMinHeight-impl(constraints.unbox-impl()) - $paddingTopPx;
            destination$iv$iv4.add(it6.measure-BRTryo0(ConstraintsKt.Constraints(0, titleWidth, $i$f$map2, Constraints.getMaxHeight-impl(constraints.unbox-impl()) - $paddingTopPx)));
            $this$map$iv6 = $this$map$iv7;
            z3 = z3;
            z2 = z4;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
        }
        final List titlePlace = (List) destination$iv$iv4;
        final Alignment.Vertical alignment = Alignment.Companion.getCenterVertically();
        final long j3 = contentConstraint;
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, Constraints.getMaxWidth-impl(constraints.unbox-impl()), Constraints.getMaxHeight-impl(constraints.unbox-impl()), (Map) null, new Function1() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit IMTopBar__nWoaYo$lambda$4$0$8;
                IMTopBar__nWoaYo$lambda$4$0$8 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$8(backgroundPlace, backPlace, actionsPlace, titlePlace, alignment, j3, $paddingTopPx, constraints, (Placeable.PlacementScope) obj);
                return IMTopBar__nWoaYo$lambda$4$0$8;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$0(boolean $showBackButton, long j, final Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:IMTopBar.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912139725, $changed, -1, "im.base.IMTopBar.<anonymous>.<anonymous>.<anonymous> (IMTopBar.kt:85)");
            }
            if ($showBackButton) {
                $composer.startReplaceGroup(-403256295);
                ComposerKt.sourceInformation($composer, "88@3390L64,86@3280L174");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ComposableLambdaKt.rememberComposableLambda(-1830771954, true, new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2) {
                        Unit IMTopBar__nWoaYo$lambda$4$0$0$0;
                        IMTopBar__nWoaYo$lambda$4$0$0$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$0$0($onBack, (Composer) obj, ((Integer) obj2).intValue());
                        return IMTopBar__nWoaYo$lambda$4$0$0$0;
                    }
                }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            } else {
                $composer.startReplaceGroup(-406495857);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$0$0(Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C89@3416L16:IMTopBar.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830771954, $changed, -1, "im.base.IMTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMTopBar.kt:89)");
            }
            BackIcon($onBack, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$1(long j, final Function2 $actionContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C98@3664L55,96@3562L157:IMTopBar.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1701781323, $changed, -1, "im.base.IMTopBar.<anonymous>.<anonymous>.<anonymous> (IMTopBar.kt:96)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ComposableLambdaKt.rememberComposableLambda(-381983755, true, new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMTopBar__nWoaYo$lambda$4$0$1$0;
                    IMTopBar__nWoaYo$lambda$4$0$1$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$1$0($actionContent, (Composer) obj, ((Integer) obj2).intValue());
                    return IMTopBar__nWoaYo$lambda$4$0$1$0;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$1$0(Function2 $actionContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C99@3686L15:IMTopBar.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-381983755, $changed, -1, "im.base.IMTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMTopBar.kt:99)");
            }
            $actionContent.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$2(long j, final Function2 $titleContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C107@3915L54,105@3812L157:IMTopBar.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(255536724, $changed, -1, "im.base.IMTopBar.<anonymous>.<anonymous>.<anonymous> (IMTopBar.kt:105)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ComposableLambdaKt.rememberComposableLambda(1390457620, true, new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMTopBar__nWoaYo$lambda$4$0$2$0;
                    IMTopBar__nWoaYo$lambda$4$0$2$0 = IMTopBarKt.IMTopBar__nWoaYo$lambda$4$0$2$0($titleContent, (Composer) obj, ((Integer) obj2).intValue());
                    return IMTopBar__nWoaYo$lambda$4$0$2$0;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$2$0(Function2 $titleContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C108@3937L14:IMTopBar.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1390457620, $changed, -1, "im.base.IMTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMTopBar.kt:108)");
            }
            $titleContent.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$3(Function3 $backgroundContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C114@4065L41:IMTopBar.kt#uu6lp7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1266502420, $changed, -1, "im.base.IMTopBar.<anonymous>.<anonymous>.<anonymous> (IMTopBar.kt:114)");
            }
            $backgroundContent.invoke(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMTopBar__nWoaYo$lambda$4$0$8(List $backgroundPlace, List $backPlace, List $actionsPlace, List $titlePlace, Alignment.Vertical $alignment, long $contentConstraint, int $paddingTopPx, Constraints $constraints, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$forEach$iv = $backgroundPlace;
        for (Object element$iv : $this$forEach$iv) {
            Placeable.PlacementScope.place$default($this$layout, (Placeable) element$iv, 0, 0, (float) CropImageView.DEFAULT_ASPECT_RATIO, 4, (Object) null);
        }
        List $this$forEach$iv2 = $backPlace;
        for (Object element$iv2 : $this$forEach$iv2) {
            Placeable it = (Placeable) element$iv2;
            int y = $alignment.align(Constraints.getMaxHeight-impl($contentConstraint), it.getHeight()) + $paddingTopPx;
            Placeable.PlacementScope.place$default($this$layout, it, 0, y, (float) CropImageView.DEFAULT_ASPECT_RATIO, 4, (Object) null);
        }
        List $this$forEach$iv3 = $actionsPlace;
        for (Object element$iv3 : $this$forEach$iv3) {
            Placeable it2 = (Placeable) element$iv3;
            int y2 = $alignment.align(Constraints.getMaxHeight-impl($contentConstraint), it2.getHeight()) + $paddingTopPx;
            Placeable.PlacementScope.place$default($this$layout, it2, Constraints.getMaxWidth-impl($constraints.unbox-impl()) - it2.getWidth(), y2, (float) CropImageView.DEFAULT_ASPECT_RATIO, 4, (Object) null);
        }
        List $this$forEach$iv4 = $titlePlace;
        for (Object element$iv4 : $this$forEach$iv4) {
            Placeable it3 = (Placeable) element$iv4;
            int x = (Constraints.getMaxWidth-impl($constraints.unbox-impl()) - it3.getWidth()) / 2;
            int y3 = $alignment.align(Constraints.getMaxHeight-impl($contentConstraint), it3.getHeight()) + $paddingTopPx;
            Placeable.PlacementScope.place$default($this$layout, it3, x, y3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final int maxWidth(List<? extends Placeable> list) {
        Integer num;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Placeable it2 = (Placeable) it.next();
            Integer valueOf = Integer.valueOf(it2.getWidth());
            while (it.hasNext()) {
                Placeable it3 = (Placeable) it.next();
                Integer valueOf2 = Integer.valueOf(it3.getWidth());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        } else {
            num = null;
        }
        Integer num2 = num;
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    private static final void BackIcon(Function0<Unit> function0, Composer $composer, final int $changed, final int i2) {
        final Function0 onBack;
        Function0 function02;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1161665945);
        ComposerKt.sourceInformation($composer2, "C(BackIcon)N(onBack)185@6446L16,182@6364L392:IMTopBar.kt#uu6lp7");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            onBack = function0;
        } else if (($changed & 6) == 0) {
            onBack = function0;
            $dirty |= $composer2.changedInstance(onBack) ? 4 : 2;
        } else {
            onBack = function0;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            Function0 onBack2 = i3 != 0 ? null : onBack;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1161665945, $dirty, -1, "im.base.BackIcon (IMTopBar.kt:170)");
            }
            if (onBack2 != null) {
                $composer2.startReplaceGroup(-1656209493);
                $composer2.endReplaceGroup();
                function02 = onBack2;
            } else {
                $composer2.startReplaceGroup(-1656168542);
                ComposerKt.sourceInformation($composer2, "175@6221L7,176@6241L108");
                final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
                ComposerKt.sourceInformationMarkerStart($composer2, -330516955, "CC(remember):IMTopBar.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit BackIcon$lambda$0$0;
                            BackIcon$lambda$0$0 = IMTopBarKt.BackIcon$lambda$0$0(backHandler);
                            return BackIcon$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                function02 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            final Function0 backAction = function02;
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, -330510487, "CC(remember):IMTopBar.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(backAction);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit BackIcon$lambda$1$0;
                        BackIcon$lambda$1$0 = IMTopBarKt.BackIcon$lambda$1$0(backAction);
                        return BackIcon$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Function0 onBack3 = onBack2;
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
            int i5 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1317405950, "C189@6585L24,190@6648L7,188@6544L206:IMTopBar.kt#uu6lp7");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ((Color) consume).unbox-impl(), $composer2, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onBack = onBack3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackIcon$lambda$3;
                    BackIcon$lambda$3 = IMTopBarKt.BackIcon$lambda$3(onBack, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return BackIcon$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$1$0(Function0 $backAction) {
        $backAction.invoke();
        return Unit.INSTANCE;
    }

    public static final void TextTitle(final String title, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(501191490);
        ComposerKt.sourceInformation($composer3, "C(TextTitle)N(title,modifier)202@6849L237:IMTopBar.kt#uu6lp7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
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
            if (i3 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(501191490, $dirty2, -1, "im.base.TextTitle (IMTopBar.kt:201)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = (($dirty2 >> 3) & 14) | 48;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1471284932, "C205@6983L9,203@6921L159:IMTopBar.kt#uu6lp7");
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT17b(), $composer3, $dirty2 & 14, 24960, 110590);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextTitle$lambda$1;
                    TextTitle$lambda$1 = IMTopBarKt.TextTitle$lambda$1(title, modifier2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return TextTitle$lambda$1;
                }
            });
        }
    }

    public static final void TopBarBackground(Modifier modifier, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(1530706432);
        ComposerKt.sourceInformation($composer2, "C(TopBarBackground)N(modifier)214@7185L5:IMTopBar.kt#uu6lp7");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        boolean z = true;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            Modifier modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1530706432, $dirty2, -1, "im.base.TopBarBackground (IMTopBar.kt:213)");
            }
            GarbInfo homeGarb = BiliTheme.INSTANCE.getTheme($composer2, BiliTheme.$stable);
            if (homeGarb.getHomePrimaryBgPath().length() == 0) {
                $composer2.startReplaceGroup(1607658598);
            } else {
                $composer2.startReplaceGroup(2130070981);
                ComposerKt.sourceInformation($composer2, "215@7249L10");
                z = true ^ BiliTheme.INSTANCE.getInHomePage($composer2, BiliTheme.$stable);
            }
            $composer2.endReplaceGroup();
            if (z) {
                $composer2.startReplaceGroup(1607700118);
                ComposerKt.sourceInformation($composer2, "216@7277L60");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(modifier3, ColorKt.Color(homeGarb.getPrimary()), (Shape) null, 2, (Object) null), $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1607783167);
                ComposerKt.sourceInformation($composer2, "218@7359L115");
                String $this$asRequest_u24default$iv = homeGarb.getHomePrimaryBgPath();
                int $i$f$asRequest = $dirty2 << 3;
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), modifier3, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, $i$f$asRequest & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.IMTopBarKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBarBackground$lambda$0;
                    TopBarBackground$lambda$0 = IMTopBarKt.TopBarBackground$lambda$0(modifier2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBarBackground$lambda$0;
                }
            });
        }
    }
}