package kntr.common.ouro.core.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.imp.FreeDataImpKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListOrderUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u000b"}, d2 = {"listOrder", "", "index", "", "level", "bulletStyle", "Lkntr/common/ouro/core/utils/BulletStyle;", "prefixStyleLevel", "toRoman", "number", "toAlphabet", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ListOrderUtilsKt {
    public static final String listOrder(int index, int level) {
        switch (level % 3) {
            case 0:
                return toRoman(index + 1) + ".";
            case 1:
                return (index + 1) + ".";
            case 2:
                return toAlphabet(index) + ".";
            default:
                return (index + 1) + ".";
        }
    }

    public static final BulletStyle bulletStyle(int prefixStyleLevel) {
        switch (prefixStyleLevel % 3) {
            case 0:
                return BulletStyle.StrokedCircle;
            case 1:
                return BulletStyle.FilledCircle;
            case 2:
                return BulletStyle.RoundedRectangle;
            default:
                return BulletStyle.FilledCircle;
        }
    }

    private static final String toRoman(int number) {
        int[] values = {MediaAttrUtils.TYPE_PAY_SEASON, 900, 500, ConstantsKt.UPCOMING_EP_LIST_DIALOG_DEFAULT_MIN_HEIGHT, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"m", FreeDataImpKt.ISP_FLAG_CM, "d", "cd", "c", "xc", "l", "xl", "x", "ix", "v", "iv", "i"};
        StringBuilder result = new StringBuilder();
        int num = number;
        int length = values.length;
        for (int i = 0; i < length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        String sb = result.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    private static final String toAlphabet(int index) {
        int i = index;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) ((i % 26) + 97));
            i = (i / 26) - 1;
        } while (i >= 0);
        String sb2 = sb.reverse().toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}