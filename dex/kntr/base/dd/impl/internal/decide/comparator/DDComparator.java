package kntr.base.dd.impl.internal.decide.comparator;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.decide.Operator;
import kntr.base.dd.impl.internal.model.DDNodeOperationConfig;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DDComparator.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0010\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkntr/base/dd/impl/internal/decide/comparator/DDComparator;", "", "lhs", "", "op", "Lkntr/base/dd/impl/internal/decide/Operator$Compare;", "rhs", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "<init>", "(Ljava/lang/String;Lkntr/base/dd/impl/internal/decide/Operator$Compare;Ljava/lang/String;Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;)V", "getLhs", "()Ljava/lang/String;", "getOp", "()Lkntr/base/dd/impl/internal/decide/Operator$Compare;", "getRhs", "getConfig", "()Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "compare", "", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public class DDComparator {
    protected static final Companion Companion = new Companion(null);
    private final DDNodeOperationConfig config;
    private final String lhs;
    private final Operator.Compare op;
    private final String rhs;

    public DDComparator(String lhs, Operator.Compare op, String rhs, DDNodeOperationConfig config) {
        Intrinsics.checkNotNullParameter(op, "op");
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
        this.config = config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getLhs() {
        return this.lhs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Operator.Compare getOp() {
        return this.op;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getRhs() {
        return this.rhs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DDNodeOperationConfig getConfig() {
        return this.config;
    }

    public boolean compare() {
        return Companion.compare(this.lhs, this.op, this.rhs, this.config);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: DDComparator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0084\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ$\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\"\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007J$\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\u0010"}, d2 = {"Lkntr/base/dd/impl/internal/decide/comparator/DDComparator$Companion;", "", "<init>", "()V", "compare", "", "lhs", "", "op", "Lkntr/base/dd/impl/internal/decide/Operator$Compare;", "rhs", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "compareEqual", "compareNumber", "compareIn", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {

        /* compiled from: DDComparator.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Operator.Compare.values().length];
                try {
                    iArr[Operator.Compare.Equal.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Operator.Compare.NotEqual.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Operator.Compare.LessThan.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Operator.Compare.LessOrEqual.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Operator.Compare.GreaterThan.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[Operator.Compare.GreaterOrEqual.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[Operator.Compare.In.ordinal()] = 7;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[Operator.Compare.NotIn.ordinal()] = 8;
                } catch (NoSuchFieldError e8) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean compare(String lhs, Operator.Compare op, String rhs, DDNodeOperationConfig config) {
            Intrinsics.checkNotNullParameter(op, "op");
            switch (WhenMappings.$EnumSwitchMapping$0[op.ordinal()]) {
                case 1:
                    return compareEqual(lhs, rhs, config);
                case 2:
                    return !compareEqual(lhs, rhs, config);
                case 3:
                case 4:
                case 5:
                case 6:
                    return compareNumber(lhs, op, rhs);
                case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                    return compareIn(lhs, rhs, config);
                case 8:
                    return !compareIn(lhs, rhs, config);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final boolean compareEqual(String lhs, String rhs, DDNodeOperationConfig config) {
            String str;
            if (config != null ? Intrinsics.areEqual(config.getIgnoreCase(), true) : false) {
                String str2 = null;
                if (lhs != null) {
                    str = lhs.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                } else {
                    str = null;
                }
                if (rhs != null) {
                    str2 = rhs.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
                }
                return Intrinsics.areEqual(str, str2);
            }
            return Intrinsics.areEqual(lhs, rhs);
        }

        public final boolean compareNumber(String lhs, Operator.Compare op, String rhs) {
            Intrinsics.checkNotNullParameter(op, "op");
            if (lhs == null) {
                return false;
            }
            long x = Long.parseLong(lhs);
            if (rhs == null) {
                throw new IllegalStateException("configuration error, input is null".toString());
            }
            long y = Long.parseLong(rhs);
            switch (WhenMappings.$EnumSwitchMapping$0[op.ordinal()]) {
                case 3:
                    return x < y;
                case 4:
                    return x <= y;
                case 5:
                    return x > y;
                case 6:
                    return x >= y;
                default:
                    throw new IllegalStateException(("compareNumber not support operator = " + op.getRaw()).toString());
            }
        }

        public final boolean compareIn(String lhs, String rhs, DDNodeOperationConfig config) {
            String separator;
            boolean isRangeEnabled;
            Iterable $this$any$iv;
            boolean z;
            DDNodeOperationConfig dDNodeOperationConfig = config;
            boolean z2 = true;
            if (compareEqual(lhs, rhs, config)) {
                return true;
            }
            String str = lhs;
            if (str == null || StringsKt.isBlank(str)) {
                return false;
            }
            String str2 = rhs;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return false;
            }
            String separator2 = (dDNodeOperationConfig == null || (separator2 = config.getSeparator()) == null) ? "," : ",";
            boolean isRangeEnabled2 = dDNodeOperationConfig != null ? Intrinsics.areEqual(config.isNumericRange(), true) : false;
            Long value = StringsKt.toLongOrNull(lhs);
            Iterable $this$any$iv2 = StringsKt.split$default(rhs, new String[]{separator2}, false, 0, 6, (Object) null);
            boolean z3 = false;
            if (($this$any$iv2 instanceof Collection) && ((Collection) $this$any$iv2).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv2) {
                String item = (String) element$iv;
                if (DDComparator.Companion.compareEqual(lhs, item, dDNodeOperationConfig)) {
                    separator = separator2;
                    isRangeEnabled = isRangeEnabled2;
                    $this$any$iv = $this$any$iv2;
                    z = z3;
                } else if (isRangeEnabled2) {
                    List it = StringsKt.split$default(item, new String[]{"~"}, false, 0, 6, (Object) null);
                    if (!(it.size() == 2)) {
                        it = null;
                    }
                    if (it != null) {
                        String startStr = (String) it.get(0);
                        String endStr = (String) it.get(1);
                        Long start = StringsKt.toLongOrNull(startStr);
                        Long end = StringsKt.toLongOrNull(endStr);
                        if (start == null || end == null || value == null) {
                            throw new IllegalStateException(("Invalid number in range: " + item + " or lhs=" + lhs).toString());
                        }
                        isRangeEnabled = isRangeEnabled2;
                        separator = separator2;
                        long min = Math.min(start.longValue(), end.longValue());
                        $this$any$iv = $this$any$iv2;
                        z = z3;
                        long max = Math.max(start.longValue(), end.longValue());
                        long longValue = value.longValue();
                        z2 = min <= longValue ? longValue <= max : false;
                    } else {
                        throw new IllegalStateException(("Invalid range format: " + item + ", expected 'start~end'").toString());
                    }
                } else {
                    separator = separator2;
                    isRangeEnabled = isRangeEnabled2;
                    $this$any$iv = $this$any$iv2;
                    z = z3;
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
                dDNodeOperationConfig = config;
                isRangeEnabled2 = isRangeEnabled;
                separator2 = separator;
                $this$any$iv2 = $this$any$iv;
                z3 = z;
                z2 = true;
            }
            return false;
        }
    }
}