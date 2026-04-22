package kntr.base.dd.impl.internal.decide.comparator;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.decide.Operator;
import kntr.base.dd.impl.internal.model.DDNodeOperationConfig;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DDVersionComparator.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¨\u0006\u0011"}, d2 = {"Lkntr/base/dd/impl/internal/decide/comparator/DDVersionComparator;", "Lkntr/base/dd/impl/internal/decide/comparator/DDComparator;", "lhs", "", "op", "Lkntr/base/dd/impl/internal/decide/Operator$Compare;", "rhs", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "<init>", "(Ljava/lang/String;Lkntr/base/dd/impl/internal/decide/Operator$Compare;Ljava/lang/String;Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;)V", "compare", "", "compareVersion", "", "lv", "rv", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDVersionComparator extends DDComparator {

    /* compiled from: DDVersionComparator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
            try {
                iArr[Operator.Compare.GreaterThan.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Operator.Compare.GreaterOrEqual.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Operator.Compare.LessThan.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Operator.Compare.LessOrEqual.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Operator.Compare.Equal.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Operator.Compare.NotEqual.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDVersionComparator(String lhs, Operator.Compare op, String rhs, DDNodeOperationConfig config) {
        super(lhs, op, rhs, config);
        Intrinsics.checkNotNullParameter(op, "op");
    }

    @Override // kntr.base.dd.impl.internal.decide.comparator.DDComparator
    public boolean compare() {
        Iterable $this$any$iv;
        int cmpL;
        String rhs = getRhs();
        if (rhs == null || StringsKt.isBlank(rhs)) {
            throw new IllegalStateException("Version comparator error: right-hand side is empty.".toString());
        }
        String lhs = getLhs();
        if (lhs == null || StringsKt.isBlank(lhs)) {
            return false;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[getOp().ordinal()]) {
            case 1:
            case 2:
                DDNodeOperationConfig config = getConfig();
                String separator = (config == null || (separator = config.getSeparator()) == null) ? "," : ",";
                Iterable $this$any$iv2 = StringsKt.split$default(getRhs(), new String[]{separator}, false, 0, 6, (Object) null);
                if (($this$any$iv2 instanceof Collection) && ((Collection) $this$any$iv2).isEmpty()) {
                    $this$any$iv = null;
                } else {
                    Iterator it = $this$any$iv2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            String item = (String) element$iv;
                            List parts = StringsKt.split$default(item, new String[]{"~"}, false, 0, 6, (Object) null);
                            if (parts.size() == 2) {
                                int cmpL2 = compareVersion(getLhs(), (String) parts.get(0));
                                int cmpR = compareVersion(getLhs(), (String) parts.get(1));
                                if (cmpL2 < 0 || cmpR > 0) {
                                    cmpL = 0;
                                    continue;
                                } else {
                                    cmpL = 1;
                                    continue;
                                }
                            } else if (compareVersion(getLhs(), item) == 0) {
                                cmpL = 1;
                                continue;
                            } else {
                                cmpL = 0;
                                continue;
                            }
                            if (cmpL != 0) {
                                $this$any$iv = 1;
                            }
                        } else {
                            $this$any$iv = null;
                        }
                    }
                }
                if (getOp() != Operator.Compare.In || $this$any$iv == null) {
                    return getOp() == Operator.Compare.NotIn && $this$any$iv == null;
                }
                return true;
            case 3:
                return compareVersion(getLhs(), getRhs()) > 0;
            case 4:
                return compareVersion(getLhs(), getRhs()) >= 0;
            case 5:
                return compareVersion(getLhs(), getRhs()) < 0;
            case 6:
                return compareVersion(getLhs(), getRhs()) <= 0;
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                return compareVersion(getLhs(), getRhs()) == 0;
            case 8:
                return compareVersion(getLhs(), getRhs()) != 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final int compareVersion(String lv, String rv) {
        List lParts = StringsKt.split$default(lv, new String[]{"."}, false, 0, 6, (Object) null);
        List rParts = StringsKt.split$default(rv, new String[]{"."}, false, 0, 6, (Object) null);
        int maxLen = Math.max(lParts.size(), rParts.size());
        for (int i = 0; i < maxLen; i++) {
            String lPart = (String) CollectionsKt.getOrNull(lParts, i);
            if (lPart == null) {
                lPart = "0";
            }
            String str = (String) CollectionsKt.getOrNull(rParts, i);
            String rPart = str != null ? str : "0";
            Integer lNum = StringsKt.toIntOrNull(lPart);
            Integer rNum = StringsKt.toIntOrNull(rPart);
            int cmp = (lNum == null || rNum == null) ? lPart.compareTo(rPart) : Intrinsics.compare(lNum.intValue(), rNum.intValue());
            if (cmp != 0) {
                return cmp;
            }
        }
        return 0;
    }
}