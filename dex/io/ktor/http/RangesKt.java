package io.ktor.http;

import com.xiaomi.mipush.sdk.Constants;
import io.ktor.http.ContentRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt;

/* compiled from: Ranges.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005*\b\u0012\u0004\u0012\u00020\t0\u0005H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "rangeSpec", "Lio/ktor/http/RangesSpecifier;", "parseRangesSpecifier", "(Ljava/lang/String;)Lio/ktor/http/RangesSpecifier;", "", "Lio/ktor/http/ContentRange;", "", "contentLength", "Lkotlin/ranges/LongRange;", "toLongRanges", "(Ljava/util/List;J)Ljava/util/List;", "mergeRangesKeepOrder", "(Ljava/util/List;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RangesKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    public static final RangesSpecifier parseRangesSpecifier(String rangeSpec) {
        Collection destination$iv$iv;
        Iterable $this$map$iv;
        Pair pair;
        String allRangesString;
        ContentRange.Suffix tailFrom;
        Intrinsics.checkNotNullParameter(rangeSpec, "rangeSpec");
        String allRangesString2 = null;
        try {
            int idx$iv = StringsKt.indexOf$default(rangeSpec, "=", 0, false, 6, (Object) null);
            if (idx$iv == -1) {
                return null;
            }
            ?? r13 = 0;
            String substring = rangeSpec.substring(0, idx$iv);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = rangeSpec.substring("=".length() + idx$iv);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            Pair pair2 = TuplesKt.to(substring, substring2);
            String unit = (String) pair2.component1();
            String allRangesString3 = (String) pair2.component2();
            Iterable $this$map$iv2 = StringsKt.split$default(allRangesString3, new char[]{','}, false, 0, 6, (Object) null);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv : $this$map$iv2) {
                String it = (String) item$iv$iv;
                if (StringsKt.startsWith$default(it, Constants.ACCEPT_TIME_SEPARATOR_SERVER, (boolean) r13, 2, allRangesString2)) {
                    tailFrom = new ContentRange.Suffix(Long.parseLong(StringsKt.removePrefix(it, Constants.ACCEPT_TIME_SEPARATOR_SERVER)));
                    destination$iv$iv = destination$iv$iv2;
                    $this$map$iv = $this$map$iv2;
                    allRangesString = allRangesString3;
                } else {
                    destination$iv$iv = destination$iv$iv2;
                    $this$map$iv = $this$map$iv2;
                    int idx$iv2 = StringsKt.indexOf$default(it, Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0, false, 6, (Object) null);
                    if (idx$iv2 == -1) {
                        pair = TuplesKt.to("", "");
                    } else {
                        String substring3 = it.substring(r13, idx$iv2);
                        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                        String substring4 = it.substring(Constants.ACCEPT_TIME_SEPARATOR_SERVER.length() + idx$iv2);
                        Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                        pair = TuplesKt.to(substring3, substring4);
                    }
                    String from = (String) pair.component1();
                    String to = (String) pair.component2();
                    if (to.length() > 0 ? true : r13) {
                        allRangesString = allRangesString3;
                        tailFrom = new ContentRange.Bounded(Long.parseLong(from), Long.parseLong(to));
                    } else {
                        allRangesString = allRangesString3;
                        tailFrom = new ContentRange.TailFrom(Long.parseLong(from));
                    }
                }
                destination$iv$iv.add(tailFrom);
                allRangesString3 = allRangesString;
                destination$iv$iv2 = destination$iv$iv;
                $this$map$iv2 = $this$map$iv;
                allRangesString2 = null;
                r13 = 0;
            }
            List allRanges = (List) destination$iv$iv2;
            if (allRanges.isEmpty()) {
                return null;
            }
            if (unit.length() == 0) {
                return null;
            }
            RangesSpecifier spec = new RangesSpecifier(unit, allRanges);
            if (RangesSpecifier.isValid$default(spec, null, 1, null)) {
                return spec;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static final List<LongRange> toLongRanges(List<? extends ContentRange> list, long contentLength) {
        Iterable $this$map$iv;
        boolean z;
        Iterable $this$mapTo$iv$iv;
        boolean z2;
        LongRange until;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends ContentRange> $this$map$iv2 = list;
        boolean z3 = false;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        Iterable $this$mapTo$iv$iv2 = $this$map$iv2;
        boolean z4 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            ContentRange it = (ContentRange) item$iv$iv;
            if (it instanceof ContentRange.Bounded) {
                $this$map$iv = $this$map$iv2;
                z = z3;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                z2 = z4;
                until = new LongRange(((ContentRange.Bounded) it).getFrom(), kotlin.ranges.RangesKt.coerceAtMost(((ContentRange.Bounded) it).getTo(), contentLength - 1));
            } else {
                $this$map$iv = $this$map$iv2;
                z = z3;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                z2 = z4;
                if (it instanceof ContentRange.TailFrom) {
                    until = kotlin.ranges.RangesKt.until(((ContentRange.TailFrom) it).getFrom(), contentLength);
                } else if (!(it instanceof ContentRange.Suffix)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    until = kotlin.ranges.RangesKt.until(kotlin.ranges.RangesKt.coerceAtLeast(contentLength - ((ContentRange.Suffix) it).getLastCount(), 0L), contentLength);
                }
            }
            destination$iv$iv.add(until);
            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
            $this$map$iv2 = $this$map$iv;
            z3 = z;
            z4 = z2;
        }
        Iterable $this$filterNot$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            if (!((LongRange) element$iv$iv).isEmpty()) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv2;
    }

    public static final List<LongRange> mergeRangesKeepOrder(List<LongRange> list) {
        Iterable $this$fold$iv;
        Object initial$iv;
        Iterator it;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<LongRange> $this$sortedBy$iv = list;
        Iterable $this$fold$iv2 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: io.ktor.http.RangesKt$mergeRangesKeepOrder$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LongRange it2 = (LongRange) t;
                LongRange it3 = (LongRange) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it2.getFirst()), Long.valueOf(it3.getFirst()));
            }
        });
        Object initial$iv2 = new ArrayList(list.size());
        Object accumulator$iv = initial$iv2;
        Iterator it2 = $this$fold$iv2.iterator();
        while (it2.hasNext()) {
            Object element$iv = it2.next();
            LongRange range = (LongRange) element$iv;
            ArrayList acc = accumulator$iv;
            if (acc.isEmpty()) {
                acc.add(range);
                $this$fold$iv = $this$fold$iv2;
                initial$iv = initial$iv2;
                it = it2;
            } else if (((LongRange) CollectionsKt.last(acc)).getLast() < range.getFirst() - 1) {
                acc.add(range);
                $this$fold$iv = $this$fold$iv2;
                initial$iv = initial$iv2;
                it = it2;
            } else {
                LongRange last = (LongRange) CollectionsKt.last(acc);
                $this$fold$iv = $this$fold$iv2;
                initial$iv = initial$iv2;
                it = it2;
                acc.set(CollectionsKt.getLastIndex(acc), new LongRange(last.getFirst(), Math.max(last.getLast(), range.getLast())));
            }
            accumulator$iv = acc;
            $this$fold$iv2 = $this$fold$iv;
            initial$iv2 = initial$iv;
            it2 = it;
        }
        ArrayList sortedMerged = accumulator$iv;
        LongRange[] result = new LongRange[list.size()];
        Iterator it3 = sortedMerged.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next = it3.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            LongRange range2 = (LongRange) next;
            int i2 = 0;
            int size = list.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (!io.ktor.util.RangesKt.contains(range2, list.get(i2))) {
                    i2++;
                } else {
                    result[i2] = range2;
                    break;
                }
            }
        }
        return ArraysKt.filterNotNull(result);
    }
}