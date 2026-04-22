package io.ktor.http;

import com.xiaomi.mipush.sdk.Constants;
import io.ktor.http.ContentRange;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: RangesSpecifier.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\t\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\nJ#\u0010\u000e\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u001c*\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b \u0010!J*\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010!¨\u0006-"}, d2 = {"Lio/ktor/http/RangesSpecifier;", "", "", "unit", "", "Lio/ktor/http/ContentRange;", "ranges", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lio/ktor/http/RangeUnits;", "(Lio/ktor/http/RangeUnits;Ljava/util/List;)V", "Lkotlin/Function1;", "", "rangeUnitPredicate", "isValid", "(Lkotlin/jvm/functions/Function1;)Z", "", "length", "", "maxRangeCount", "Lkotlin/ranges/LongRange;", "merge", "(JI)Ljava/util/List;", "(J)Ljava/util/List;", "mergeToSingle", "(J)Lkotlin/ranges/LongRange;", "toString", "()Ljava/lang/String;", "T", "toList", "(Ljava/lang/Object;)Ljava/util/List;", "component1", "component2", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/util/List;)Lio/ktor/http/RangesSpecifier;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getUnit", "Ljava/util/List;", "getRanges", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RangesSpecifier {
    private final List<ContentRange> ranges;
    private final String unit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RangesSpecifier copy$default(RangesSpecifier rangesSpecifier, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rangesSpecifier.unit;
        }
        if ((i2 & 2) != 0) {
            list = rangesSpecifier.ranges;
        }
        return rangesSpecifier.copy(str, list);
    }

    public final String component1() {
        return this.unit;
    }

    public final List<ContentRange> component2() {
        return this.ranges;
    }

    public final RangesSpecifier copy(String str, List<? extends ContentRange> list) {
        Intrinsics.checkNotNullParameter(str, "unit");
        Intrinsics.checkNotNullParameter(list, "ranges");
        return new RangesSpecifier(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RangesSpecifier) {
            RangesSpecifier rangesSpecifier = (RangesSpecifier) obj;
            return Intrinsics.areEqual(this.unit, rangesSpecifier.unit) && Intrinsics.areEqual(this.ranges, rangesSpecifier.ranges);
        }
        return false;
    }

    public int hashCode() {
        return (this.unit.hashCode() * 31) + this.ranges.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RangesSpecifier(String unit, List<? extends ContentRange> list) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(list, "ranges");
        this.unit = unit;
        this.ranges = list;
        if (this.ranges.isEmpty()) {
            throw new IllegalArgumentException("It should be at least one range".toString());
        }
    }

    public /* synthetic */ RangesSpecifier(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RangeUnits.Bytes.getUnitToken() : str, list);
    }

    public final List<ContentRange> getRanges() {
        return this.ranges;
    }

    public final String getUnit() {
        return this.unit;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RangesSpecifier(RangeUnits unit, List<? extends ContentRange> list) {
        this(unit.getUnitToken(), list);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(list, "ranges");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isValid$default(RangesSpecifier rangesSpecifier, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = new Function1() { // from class: io.ktor.http.RangesSpecifier$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    boolean isValid$lambda$1;
                    isValid$lambda$1 = RangesSpecifier.isValid$lambda$1((String) obj2);
                    return Boolean.valueOf(isValid$lambda$1);
                }
            };
        }
        return rangesSpecifier.isValid(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isValid$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, RangeUnits.Bytes.getUnitToken());
    }

    public final boolean isValid(Function1<? super String, Boolean> function1) {
        Iterable $this$none$iv;
        boolean z;
        Intrinsics.checkNotNullParameter(function1, "rangeUnitPredicate");
        if (((Boolean) function1.invoke(this.unit)).booleanValue()) {
            Iterable $this$none$iv2 = this.ranges;
            if (!($this$none$iv2 instanceof Collection) || !((Collection) $this$none$iv2).isEmpty()) {
                Iterator<T> it = $this$none$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        ContentRange it2 = (ContentRange) element$iv;
                        if (it2 instanceof ContentRange.Bounded) {
                            if (((ContentRange.Bounded) it2).getFrom() < 0 || ((ContentRange.Bounded) it2).getTo() < ((ContentRange.Bounded) it2).getFrom()) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                        } else if (it2 instanceof ContentRange.TailFrom) {
                            if (((ContentRange.TailFrom) it2).getFrom() < 0) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                        } else if (it2 instanceof ContentRange.Suffix) {
                            if (((ContentRange.Suffix) it2).getLastCount() < 0) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (z) {
                            $this$none$iv = null;
                            break;
                        }
                    } else {
                        $this$none$iv = 1;
                        break;
                    }
                }
            } else {
                $this$none$iv = 1;
            }
            return $this$none$iv != null;
        }
        return false;
    }

    public static /* synthetic */ List merge$default(RangesSpecifier rangesSpecifier, long j, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 50;
        }
        return rangesSpecifier.merge(j, i2);
    }

    public final List<LongRange> merge(long length, int maxRangeCount) {
        if (this.ranges.size() > maxRangeCount) {
            return toList(mergeToSingle(length));
        }
        return merge(length);
    }

    public final List<LongRange> merge(long length) {
        return RangesKt.mergeRangesKeepOrder(RangesKt.toLongRanges(this.ranges, length));
    }

    public final LongRange mergeToSingle(long length) {
        Object minElem$iv;
        List mapped = RangesKt.toLongRanges(this.ranges, length);
        Object maxElem$iv = null;
        if (mapped.isEmpty()) {
            return null;
        }
        List $this$minByOrNull$iv = mapped;
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            minElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                LongRange it = (LongRange) minElem$iv;
                long minValue$iv = it.getFirst();
                do {
                    Object e$iv = iterator$iv.next();
                    LongRange it2 = (LongRange) e$iv;
                    long v$iv = it2.getFirst();
                    if (minValue$iv > v$iv) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            minElem$iv = null;
        }
        Intrinsics.checkNotNull(minElem$iv);
        long start = ((LongRange) minElem$iv).getFirst();
        List $this$maxByOrNull$iv = mapped;
        Iterator iterator$iv2 = $this$maxByOrNull$iv.iterator();
        if (iterator$iv2.hasNext()) {
            maxElem$iv = iterator$iv2.next();
            if (iterator$iv2.hasNext()) {
                LongRange it3 = (LongRange) maxElem$iv;
                long maxValue$iv = it3.getLast();
                do {
                    Object e$iv2 = iterator$iv2.next();
                    LongRange it4 = (LongRange) e$iv2;
                    long v$iv2 = it4.getLast();
                    if (maxValue$iv < v$iv2) {
                        maxElem$iv = e$iv2;
                        maxValue$iv = v$iv2;
                    }
                } while (iterator$iv2.hasNext());
            }
        }
        Intrinsics.checkNotNull(maxElem$iv);
        long endInclusive = kotlin.ranges.RangesKt.coerceAtMost(((LongRange) maxElem$iv).getLast(), length - 1);
        return new LongRange(start, endInclusive);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.ranges, Constants.ACCEPT_TIME_SEPARATOR_SP, this.unit + '=', (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null);
    }

    private final <T> List<T> toList(T t) {
        return t == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(t);
    }
}