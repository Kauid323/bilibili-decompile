package kntr.app.upper.entrance.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UpperNumberFormat.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lkntr/app/upper/entrance/utils/EnFormater;", "Lkntr/app/upper/entrance/utils/Formater;", "<init>", "()V", "format", "Lkotlin/Pair;", "", WatchLaterReporterKt.KEY_NUM, "unit", "Lkntr/app/upper/entrance/utils/UnitSuffix;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class EnFormater extends Formater {
    @Override // kntr.app.upper.entrance.utils.Formater
    public Pair<String, String> format(String num, UnitSuffix unit) {
        String intStr;
        String intStr2;
        Intrinsics.checkNotNullParameter(num, WatchLaterReporterKt.KEY_NUM);
        Intrinsics.checkNotNullParameter(unit, "unit");
        String symbol = num.charAt(0) == '-' ? "-" : "";
        String number = num;
        if (num.charAt(0) == '-' && num.length() > 1) {
            String substring = num.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            number = substring;
        }
        int len = number.length();
        String unitStr = "";
        if (Intrinsics.areEqual(number, "0")) {
            intStr = "0";
            intStr2 = StringsKt.padEnd(number, 2, '0');
        } else if (len == 1) {
            intStr = "0";
            intStr2 = StringsKt.padStart(number, 2, '0');
        } else if (len == 2) {
            intStr = "0";
            intStr2 = number;
        } else if (len < 6) {
            intStr = number.substring(0, len - 2);
            Intrinsics.checkNotNullExpressionValue(intStr, "substring(...)");
            intStr2 = number.substring(len - 2, len);
            Intrinsics.checkNotNullExpressionValue(intStr2, "substring(...)");
        } else if (len < 9) {
            intStr = number.substring(0, len - 5);
            Intrinsics.checkNotNullExpressionValue(intStr, "substring(...)");
            intStr2 = number.substring(len - 5, len - 4);
            Intrinsics.checkNotNullExpressionValue(intStr2, "substring(...)");
            unitStr = unit.getThousands();
        } else if (len < 12) {
            intStr = number.substring(0, len - 8);
            Intrinsics.checkNotNullExpressionValue(intStr, "substring(...)");
            intStr2 = number.substring(len - 8, len - 7);
            Intrinsics.checkNotNullExpressionValue(intStr2, "substring(...)");
            unitStr = unit.getMillions();
        } else {
            intStr = number.substring(0, len - 11);
            Intrinsics.checkNotNullExpressionValue(intStr, "substring(...)");
            intStr2 = number.substring(len - 11, len - 10);
            Intrinsics.checkNotNullExpressionValue(intStr2, "substring(...)");
            unitStr = unit.getBillions();
        }
        return new Pair<>(symbol + intStr + "." + intStr2, unitStr);
    }
}