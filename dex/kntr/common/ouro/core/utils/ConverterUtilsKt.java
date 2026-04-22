package kntr.common.ouro.core.utils;

import java.util.Locale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* compiled from: ConverterUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\u0005*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"toHexColorString", "", "", "toArgbInt", "alpha", "Lkotlin/UInt;", "toHexColorString-WZ4Q5Ns", "(I)Ljava/lang/String;", "toArgbUInt", "toArgbUInt-Qn1smSk", "(Ljava/lang/String;I)I", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ConverterUtilsKt {
    public static final String toHexColorString(int $this$toHexColorString) {
        int rgb = 16777215 & $this$toHexColorString;
        String num = Integer.toString(rgb, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        String upperCase = num.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String hexString = StringsKt.padStart(upperCase, 6, '0');
        return "#" + hexString;
    }

    public static /* synthetic */ int toArgbInt$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = KotlinVersion.MAX_COMPONENT_VALUE;
        }
        return toArgbInt(str, i);
    }

    public static final int toArgbInt(String $this$toArgbInt, int alpha) {
        Intrinsics.checkNotNullParameter($this$toArgbInt, "<this>");
        String cleanHex = StringsKt.removePrefix($this$toArgbInt, "#").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(cleanHex, "toUpperCase(...)");
        boolean z = false;
        int validAlpha = RangesKt.coerceIn(alpha, 0, (int) KotlinVersion.MAX_COMPONENT_VALUE);
        if (cleanHex.length() == 6) {
            String $this$all$iv = cleanHex;
            int i = 0;
            while (true) {
                boolean z2 = true;
                if (i < $this$all$iv.length()) {
                    char element$iv = $this$all$iv.charAt(i);
                    if (!('0' <= element$iv && element$iv < ':')) {
                        if (!('A' <= element$iv && element$iv < 'G')) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                try {
                    int rgb = Integer.parseInt(cleanHex, CharsKt.checkRadix(16));
                    return rgb | (validAlpha << 24);
                } catch (NumberFormatException e) {
                    return (validAlpha << 24) | 8421504;
                }
            }
        }
        return (validAlpha << 24) | 8421504;
    }

    /* renamed from: toHexColorString-WZ4Q5Ns */
    public static final String m2060toHexColorStringWZ4Q5Ns(int i) {
        int rgb = UInt.m2731constructorimpl(16777215 & i);
        String upperCase = UStringsKt.toString-V7xB4Y4(rgb, 16).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String hexString = StringsKt.padStart(upperCase, 6, '0');
        return "#" + hexString;
    }

    /* renamed from: toArgbUInt-Qn1smSk$default */
    public static /* synthetic */ int m2059toArgbUIntQn1smSk$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = KotlinVersion.MAX_COMPONENT_VALUE;
        }
        return m2058toArgbUIntQn1smSk(str, i);
    }

    /* renamed from: toArgbUInt-Qn1smSk */
    public static final int m2058toArgbUIntQn1smSk(String $this$toArgbUInt_u2dQn1smSk, int i) {
        int compare;
        Intrinsics.checkNotNullParameter($this$toArgbUInt_u2dQn1smSk, "$this$toArgbUInt");
        String cleanHex = StringsKt.removePrefix($this$toArgbUInt_u2dQn1smSk, "#").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(cleanHex, "toUpperCase(...)");
        int validAlpha = KotlinVersion.MAX_COMPONENT_VALUE;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, KotlinVersion.MAX_COMPONENT_VALUE ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            validAlpha = i;
        }
        if (cleanHex.length() == 6) {
            String $this$all$iv = cleanHex;
            boolean z = false;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 < $this$all$iv.length()) {
                    char element$iv = $this$all$iv.charAt(i2);
                    if (!('0' <= element$iv && element$iv < ':')) {
                        if (!('A' <= element$iv && element$iv < 'G')) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                    i2++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                try {
                    int rgb = UStringsKt.toUInt(cleanHex, 16);
                    return UInt.m2731constructorimpl(UInt.m2731constructorimpl(validAlpha << 24) | rgb);
                } catch (NumberFormatException e) {
                    return UInt.m2731constructorimpl(UInt.m2731constructorimpl(validAlpha << 24) | 8421504);
                }
            }
        }
        return UInt.m2731constructorimpl(UInt.m2731constructorimpl(validAlpha << 24) | 8421504);
    }
}