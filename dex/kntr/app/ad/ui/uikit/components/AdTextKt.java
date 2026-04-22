package kntr.app.ad.ui.uikit.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import kntr.app.ad.ui.uikit.AdUIKits_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdText.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"AdText", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "style", "Landroidx/compose/ui/text/TextStyle;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "lineHeight", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "maxLines", RoomRecommendViewModel.EMPTY_CURSOR, "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "AdText-yJ1VmHo", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontWeight;JLandroidx/compose/ui/text/style/TextDecoration;IILandroidx/compose/runtime/Composer;II)V", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdText_yJ1VmHo$lambda$0(String str, TextStyle textStyle, Modifier modifier, long j2, long j3, FontWeight fontWeight, long j4, TextDecoration textDecoration, int i, int i2, int i3, int i4, Composer composer, int i5) {
        m496AdTextyJ1VmHo(str, textStyle, modifier, j2, j3, fontWeight, j4, textDecoration, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* renamed from: AdText-yJ1VmHo  reason: not valid java name */
    public static final void m496AdTextyJ1VmHo(final String text, final TextStyle style, Modifier modifier, long j2, long j3, FontWeight fontWeight, long j4, TextDecoration textDecoration, int maxLines, int i, Composer $composer, final int $changed, final int i2) {
        long j5;
        FontWeight fontWeight2;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        long j6;
        long j7;
        TextDecoration textDecoration2;
        int maxLines2;
        int i3;
        long j8;
        FontWeight fontWeight3;
        Modifier modifier3;
        long j9;
        long j10;
        TextDecoration textDecoration3;
        int maxLines3;
        Modifier modifier4;
        int $dirty2;
        int $dirty3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Composer $composer3 = $composer.startRestartGroup(2066917900);
        ComposerKt.sourceInformation($composer3, "C(AdText)N(text,style,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontWeight,lineHeight:c#ui.unit.TextUnit,textDecoration,maxLines,overflow:c#ui.text.style.TextOverflow)28@982L456:AdText.kt#oqm2gb");
        int $dirty4 = $changed;
        if (($changed & 6) == 0) {
            $dirty4 |= $composer3.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty4 |= $composer3.changed(style) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty4 |= $composer3.changed(j2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            if ((i2 & 16) == 0) {
                j5 = j3;
                if ($composer3.changed(j5)) {
                    i6 = 16384;
                    $dirty4 |= i6;
                }
            } else {
                j5 = j3;
            }
            i6 = 8192;
            $dirty4 |= i6;
        } else {
            j5 = j3;
        }
        if ((196608 & $changed) == 0) {
            if ((i2 & 32) == 0) {
                fontWeight2 = fontWeight;
                if ($composer3.changed(fontWeight2)) {
                    i5 = 131072;
                    $dirty4 |= i5;
                }
            } else {
                fontWeight2 = fontWeight;
            }
            i5 = 65536;
            $dirty4 |= i5;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((1572864 & $changed) == 0) {
            if ((i2 & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(j4)) {
                    i4 = 1048576;
                    $dirty = $dirty3 | i4;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i4 = 524288;
            $dirty = $dirty3 | i4;
        } else {
            $dirty = $dirty4;
        }
        int i9 = i2 & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(textDecoration) ? 8388608 : 4194304;
        }
        int i10 = i2 & 256;
        if (i10 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 67108864 : 33554432;
        }
        int i11 = i2 & 512;
        if (i11 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(i) ? 536870912 : 268435456;
        }
        if ($composer3.shouldExecute(($dirty & 306783379) != 306783378, $dirty & 1)) {
            $composer3.startDefaults();
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i2 & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i2 & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i2 & 64) != 0) {
                    modifier4 = modifier;
                    j6 = j2;
                    j7 = j4;
                    textDecoration2 = textDecoration;
                    maxLines2 = maxLines;
                    i3 = i;
                    $dirty2 = $dirty & (-3670017);
                    j8 = j5;
                    fontWeight3 = fontWeight2;
                } else {
                    modifier4 = modifier;
                    j6 = j2;
                    j7 = j4;
                    textDecoration2 = textDecoration;
                    maxLines2 = maxLines;
                    i3 = i;
                    j8 = j5;
                    fontWeight3 = fontWeight2;
                    $dirty2 = $dirty;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 == 0) {
                    j9 = j2;
                } else {
                    j9 = Color.Companion.getUnspecified-0d7_KjU();
                }
                if ((i2 & 16) != 0) {
                    j5 = style.getFontSize-XSAIIZE();
                    $dirty &= -57345;
                }
                if ((i2 & 32) != 0) {
                    fontWeight2 = style.getFontWeight();
                    $dirty &= -458753;
                }
                if ((i2 & 64) == 0) {
                    j10 = j4;
                } else {
                    j10 = style.getLineHeight-XSAIIZE();
                    $dirty &= -3670017;
                }
                if (i9 == 0) {
                    textDecoration3 = textDecoration;
                } else {
                    textDecoration3 = null;
                }
                if (i10 == 0) {
                    maxLines3 = maxLines;
                } else {
                    maxLines3 = 1;
                }
                if (i11 == 0) {
                    i3 = i;
                    maxLines2 = maxLines3;
                    j6 = j9;
                    textDecoration2 = textDecoration3;
                    j8 = j5;
                    fontWeight3 = fontWeight2;
                    j7 = j10;
                    modifier4 = modifier3;
                    $dirty2 = $dirty;
                } else {
                    i3 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    maxLines2 = maxLines3;
                    j6 = j9;
                    textDecoration2 = textDecoration3;
                    j8 = j5;
                    fontWeight3 = fontWeight2;
                    j7 = j10;
                    modifier4 = modifier3;
                    $dirty2 = $dirty;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2066917900, $dirty2, -1, "kntr.app.ad.ui.uikit.components.AdText (AdText.kt:27)");
            }
            $composer2 = $composer3;
            modifier2 = modifier4;
            TextKt.Text-Nvy7gAk(text, SizeKt.wrapContentHeight(modifier4, Alignment.Companion.getCenterVertically(), true), j6, (TextAutoSize) null, j8, (FontStyle) null, fontWeight3, (FontFamily) null, 0L, textDecoration2, (TextAlign) null, j7, i3, false, maxLines2, 0, (Function1) null, AdUIKits_androidKt.addIncludeFontPadding$default(style, false, 1, null), $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 896) | ($dirty2 & 57344) | (3670016 & ($dirty2 << 3)) | (1879048192 & ($dirty2 << 6)), (($dirty2 >> 15) & 112) | (($dirty2 >> 21) & 896) | (57344 & ($dirty2 >> 12)), 107944);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            j6 = j2;
            j7 = j4;
            textDecoration2 = textDecoration;
            maxLines2 = maxLines;
            i3 = i;
            j8 = j5;
            fontWeight3 = fontWeight2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final long j11 = j6;
            final long j12 = j8;
            final FontWeight fontWeight4 = fontWeight3;
            final long j13 = j7;
            final TextDecoration textDecoration4 = textDecoration2;
            final int i12 = maxLines2;
            final int i13 = i3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTextKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdText_yJ1VmHo$lambda$0;
                    AdText_yJ1VmHo$lambda$0 = AdTextKt.AdText_yJ1VmHo$lambda$0(text, style, modifier5, j11, j12, fontWeight4, j13, textDecoration4, i12, i13, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return AdText_yJ1VmHo$lambda$0;
                }
            });
        }
    }
}