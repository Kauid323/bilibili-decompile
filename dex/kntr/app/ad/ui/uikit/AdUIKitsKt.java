package kntr.app.ad.ui.uikit;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: AdUIKits.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000e\"\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"parse2Color", "Landroidx/compose/ui/graphics/Color;", RoomRecommendViewModel.EMPTY_CURSOR, "default", "isRGBAFormat", RoomRecommendViewModel.EMPTY_CURSOR, "parse2Color-bw27NRU", "(Ljava/lang/String;JZ)J", "getComposeColor", "dayColor", "nightColor", "defaultDayColor", "defaultNightColor", "getComposeColor-eaDK9VM", "(Ljava/lang/String;Ljava/lang/String;JJLandroidx/compose/runtime/Composer;II)J", "biliTextStyle", "Landroidx/compose/ui/text/TextStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "getBiliTextStyle", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdUIKitsKt {
    /* renamed from: parse2Color-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ long m480parse2Colorbw27NRU$default(String str, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = Color.Companion.getUnspecified-0d7_KjU();
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return m479parse2Colorbw27NRU(str, j2, z);
    }

    /* renamed from: parse2Color-bw27NRU  reason: not valid java name */
    public static final long m479parse2Colorbw27NRU(String $this$parse2Color_u2dbw27NRU, long j2, boolean isRGBAFormat) {
        String colorStr;
        String str = $this$parse2Color_u2dbw27NRU;
        if (str == null || StringsKt.isBlank(str)) {
            return j2;
        }
        if (StringsKt.startsWith$default($this$parse2Color_u2dbw27NRU, "#", false, 2, (Object) null)) {
            colorStr = $this$parse2Color_u2dbw27NRU.substring(1);
            Intrinsics.checkNotNullExpressionValue(colorStr, "substring(...)");
        } else if (!StringsKt.startsWith$default($this$parse2Color_u2dbw27NRU, "0x", false, 2, (Object) null)) {
            return j2;
        } else {
            colorStr = $this$parse2Color_u2dbw27NRU.substring(2);
            Intrinsics.checkNotNullExpressionValue(colorStr, "substring(...)");
        }
        switch (colorStr.length()) {
            case 3:
                char r = colorStr.charAt(0);
                char g = colorStr.charAt(1);
                char b = colorStr.charAt(2);
                return ColorKt.Color(Long.parseLong("FF" + r + r + g + g + b + b, CharsKt.checkRadix(16)));
            case 6:
                return ColorKt.Color(4278190080L | Long.parseLong(colorStr, CharsKt.checkRadix(16)));
            case 8:
                long color = Long.parseLong(colorStr, CharsKt.checkRadix(16));
                if (isRGBAFormat) {
                    long a = 255 & color;
                    long rgb = color >>> 8;
                    return ColorKt.Color((a << 24) | rgb);
                }
                return ColorKt.Color(color);
            default:
                return j2;
        }
    }

    /* renamed from: getComposeColor-eaDK9VM  reason: not valid java name */
    public static final long m478getComposeColoreaDK9VM(String dayColor, String nightColor, long j2, long j3, Composer $composer, int $changed, int i) {
        long color;
        ComposerKt.sourceInformationMarkerStart($composer, 96893213, "C(getComposeColor)N(dayColor,nightColor,defaultDayColor:c#ui.graphics.Color,defaultNightColor:c#ui.graphics.Color)59@1577L7:AdUIKits.kt#kwj2nt");
        if ((i & 4) != 0) {
            j2 = Color.Companion.getUnspecified-0d7_KjU();
        }
        if ((i & 8) != 0) {
            j3 = Color.Companion.getUnspecified-0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(96893213, $changed, -1, "kntr.app.ad.ui.uikit.getComposeColor (AdUIKits.kt:57)");
        }
        CompositionLocal this_$iv = BiliThemeKt.getLocalDayNightTheme();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (consume == ThemeDayNight.Night) {
            color = m480parse2Colorbw27NRU$default(nightColor, j3, false, 2, null);
        } else {
            color = m480parse2Colorbw27NRU$default(dayColor, j2, false, 2, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return color;
    }

    public static final TextStyle getBiliTextStyle(int $this$biliTextStyle, Composer $composer, int $changed) {
        TextStyle t10;
        ComposerKt.sourceInformationMarkerStart($composer, -714520683, "C(<get-biliTextStyle>):AdUIKits.kt#kwj2nt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-714520683, $changed, -1, "kntr.app.ad.ui.uikit.<get-biliTextStyle> (AdUIKits.kt:70)");
        }
        switch ($this$biliTextStyle) {
            case 10:
                $composer.startReplaceGroup(540393688);
                ComposerKt.sourceInformation($composer, "71@1873L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                $composer.startReplaceGroup(540395032);
                ComposerKt.sourceInformation($composer, "72@1915L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT11();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                $composer.startReplaceGroup(540396376);
                ComposerKt.sourceInformation($composer, "73@1957L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                $composer.startReplaceGroup(540397720);
                ComposerKt.sourceInformation($composer, "74@1999L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                $composer.startReplaceGroup(540399064);
                ComposerKt.sourceInformation($composer, "75@2041L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                $composer.startReplaceGroup(540400408);
                ComposerKt.sourceInformation($composer, "76@2083L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT15();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                $composer.startReplaceGroup(540401752);
                ComposerKt.sourceInformation($composer, "77@2125L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                $composer.startReplaceGroup(540403096);
                ComposerKt.sourceInformation($composer, "78@2167L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT17();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                $composer.startReplaceGroup(540404440);
                ComposerKt.sourceInformation($composer, "79@2209L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT18();
                $composer.endReplaceGroup();
                break;
            case AdditionVote2.CHOICE_CNT_FIELD_NUMBER /* 19 */:
            case AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER /* 20 */:
            case AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER /* 21 */:
            default:
                $composer.startReplaceGroup(540406876);
                $composer.endReplaceGroup();
                t10 = TextStyle.Companion.getDefault();
                break;
            case AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER /* 22 */:
                $composer.startReplaceGroup(540405784);
                ComposerKt.sourceInformation($composer, "80@2251L9");
                t10 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT22();
                $composer.endReplaceGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return t10;
    }
}