package kntr.base.dd.impl.internal.decide.comparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.decide.Operator;
import kntr.base.dd.impl.internal.decide.comparator.DDComparator;
import kntr.base.dd.impl.internal.model.DDNodeOperationConfig;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DDTimeStampComparator.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/base/dd/impl/internal/decide/comparator/DDTimeStampComparator;", "Lkntr/base/dd/impl/internal/decide/comparator/DDComparator;", "lhs", "", "op", "Lkntr/base/dd/impl/internal/decide/Operator$Compare;", "rhs", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "repeatMode", "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$RepeatMode;", "<init>", "(Ljava/lang/String;Lkntr/base/dd/impl/internal/decide/Operator$Compare;Ljava/lang/String;Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$RepeatMode;)V", "compare", "", "tsRepeatFormatter", "ts", "longToLocalDateTime", "Lkotlinx/datetime/LocalDateTime;", "timeMs", "", "to2", "i", "", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDTimeStampComparator extends DDComparator {
    private final DDNodeOperationConfig.RepeatMode repeatMode;

    /* compiled from: DDTimeStampComparator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Operator.Compare.values().length];
            try {
                iArr[Operator.Compare.In.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Operator.Compare.NotIn.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DDNodeOperationConfig.RepeatMode.values().length];
            try {
                iArr2[DDNodeOperationConfig.RepeatMode.Day.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[DDNodeOperationConfig.RepeatMode.Week.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[DDNodeOperationConfig.RepeatMode.Month.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[DDNodeOperationConfig.RepeatMode.Year.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDTimeStampComparator(String lhs, Operator.Compare op, String rhs, DDNodeOperationConfig config, DDNodeOperationConfig.RepeatMode repeatMode) {
        super(lhs, op, rhs, config);
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(repeatMode, "repeatMode");
        this.repeatMode = repeatMode;
    }

    @Override // kntr.base.dd.impl.internal.decide.comparator.DDComparator
    public boolean compare() {
        String lhsFormatted;
        String rhsFormatted;
        boolean isNumericRange;
        String tsRepeatFormatter;
        DDNodeOperationConfig dDNodeOperationConfig;
        String rhs = getRhs();
        if (rhs == null || StringsKt.isBlank(rhs)) {
            throw new IllegalStateException("Timestamp comparator error: right-hand side is empty.".toString());
        }
        String lhs = getLhs();
        if ((lhs == null || StringsKt.isBlank(lhs)) || (lhsFormatted = tsRepeatFormatter(getLhs())) == null) {
            return false;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[getOp().ordinal()]) {
            case 1:
            case 2:
                DDNodeOperationConfig config = getConfig();
                String separator = (config == null || (separator = config.getSeparator()) == null) ? "," : ",";
                Iterable $this$mapNotNull$iv = StringsKt.split$default(getRhs(), new String[]{separator}, false, 0, 6, (Object) null);
                boolean z = false;
                Collection destination$iv$iv = new ArrayList();
                Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
                    String it = (String) element$iv$iv$iv;
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    List parts = StringsKt.split$default(it, new String[]{"~"}, false, 0, 6, (Object) null);
                    boolean z2 = z;
                    int $i$f$mapNotNull = parts.size();
                    Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                    if ($i$f$mapNotNull == 2) {
                        String start = tsRepeatFormatter((String) parts.get(0));
                        String end = tsRepeatFormatter((String) parts.get(1));
                        tsRepeatFormatter = (start == null || end == null) ? null : start + "~" + end;
                    } else {
                        tsRepeatFormatter = tsRepeatFormatter(it);
                    }
                    if (tsRepeatFormatter != null) {
                        destination$iv$iv.add(tsRepeatFormatter);
                    }
                    z = z2;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                }
                rhsFormatted = CollectionsKt.joinToString$default((List) destination$iv$iv, separator, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                isNumericRange = false;
                break;
            default:
                rhsFormatted = tsRepeatFormatter(getRhs());
                if (rhsFormatted != null) {
                    isNumericRange = false;
                    break;
                } else {
                    return false;
                }
        }
        DDConst.INSTANCE.logD("use ts-repeat-mode formatter, result: { " + getLhs() + " -> " + lhsFormatted + ", " + getRhs() + " -> " + rhsFormatted + " }");
        isNumericRange = (getOp() == Operator.Compare.In || getOp() == Operator.Compare.NotIn) ? true : true;
        DDComparator.Companion companion = DDComparator.Companion;
        Operator.Compare op = getOp();
        DDNodeOperationConfig config2 = getConfig();
        if (config2 == null || (dDNodeOperationConfig = DDNodeOperationConfig.copy$default(config2, null, null, Boolean.valueOf(isNumericRange), null, null, 27, null)) == null) {
            dDNodeOperationConfig = new DDNodeOperationConfig((Boolean) null, (String) null, Boolean.valueOf(isNumericRange), (String) null, (Integer) null, 27, (DefaultConstructorMarker) null);
        }
        return companion.compare(lhsFormatted, op, rhsFormatted, dDNodeOperationConfig);
    }

    private final String tsRepeatFormatter(String ts) {
        Long longOrNull;
        LocalDateTime date;
        if (ts == null || (longOrNull = StringsKt.toLongOrNull(ts)) == null) {
            return null;
        }
        long timestamp = longOrNull.longValue();
        switch (ts.length()) {
            case 10:
                date = longToLocalDateTime(((long) MediaAttrUtils.TYPE_PAY_SEASON) * timestamp);
                break;
            case 13:
                date = longToLocalDateTime(timestamp);
                break;
            default:
                return null;
        }
        int h = date.getHour();
        int m = date.getMinute();
        int s = date.getSecond();
        switch (WhenMappings.$EnumSwitchMapping$1[this.repeatMode.ordinal()]) {
            case 1:
                String str = to2(h);
                return "4" + str + to2(m) + to2(s);
            case 2:
                int day = DayOfWeekKt.getIsoDayNumber(date.getDayOfWeek());
                String str2 = to2(day);
                String str3 = to2(h);
                return WatchLaterReporterKt.CLEAN_INVALID + str2 + str3 + to2(m) + to2(s);
            case 3:
                int day2 = date.getDayOfMonth();
                String str4 = to2(day2);
                String str5 = to2(h);
                return "2" + str4 + str5 + to2(m) + to2(s);
            case 4:
                int mon = date.getMonthNumber();
                int day3 = date.getDayOfMonth();
                String str6 = to2(mon);
                String str7 = to2(day3);
                String str8 = to2(h);
                return "1" + str6 + str7 + str8 + to2(m) + to2(s);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final LocalDateTime longToLocalDateTime(long timeMs) {
        return TimeZoneKt.toLocalDateTime(Instant.Companion.fromEpochMilliseconds(timeMs), TimeZone.Companion.of("Asia/Shanghai"));
    }

    private final String to2(int i) {
        return i < 10 ? "0" + i : String.valueOf(i);
    }
}