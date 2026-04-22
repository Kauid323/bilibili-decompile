package kntr.common.ouro.core.model.mark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroMarks.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0000\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0006\u0012\u0002\b\u00030\u0005H\u0086\b\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0086\u0004\u001a1\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0086\u0004\u001a1\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0086\u0004\u001a1\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0086\u0004\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u000f*2\b\u0002\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u0002H\u00010\u00022\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u0002H\u00010\u0002¨\u0006\u0010"}, d2 = {"OuroMarkMap", "MARK", "", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "filterInstanceOf", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "T", "Lkntr/common/ouro/core/model/mark/OuroMark;", "intersect", "other", "union", "subtract", "mergeParent", "parent", "intersectAll", "", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroMarksKt {
    public static final /* synthetic */ <T extends OuroMark> OuroMarks<T> filterInstanceOf(OuroMarks<?> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "<this>");
        OuroMarks<?> $this$filterIsInstance$iv = ouroMarks;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (element$iv$iv instanceof Object) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return new OuroMarks<>((List) destination$iv$iv);
    }

    public static final <T extends OuroMark> OuroMarks<T> intersect(OuroMarks<T> ouroMarks, OuroMarks<T> ouroMarks2) {
        Intrinsics.checkNotNullParameter(ouroMarks, "<this>");
        Intrinsics.checkNotNullParameter(ouroMarks2, "other");
        return new OuroMarks<>(CollectionsKt.intersect(ouroMarks, CollectionsKt.toSet(ouroMarks2)));
    }

    public static final <T extends OuroMark> OuroMarks<T> union(OuroMarks<T> ouroMarks, OuroMarks<T> ouroMarks2) {
        Intrinsics.checkNotNullParameter(ouroMarks, "<this>");
        Intrinsics.checkNotNullParameter(ouroMarks2, "other");
        return new OuroMarks<>(CollectionsKt.union(ouroMarks, CollectionsKt.toSet(ouroMarks2)));
    }

    public static final <T extends OuroMark> OuroMarks<T> subtract(OuroMarks<T> ouroMarks, OuroMarks<T> ouroMarks2) {
        Intrinsics.checkNotNullParameter(ouroMarks, "<this>");
        Intrinsics.checkNotNullParameter(ouroMarks2, "other");
        return new OuroMarks<>(CollectionsKt.subtract(ouroMarks, CollectionsKt.toSet(ouroMarks2)));
    }

    public static final <T extends OuroMark> OuroMarks<T> mergeParent(OuroMarks<T> ouroMarks, OuroMarks<T> ouroMarks2) {
        OuroMarks<T> ouroMarks3 = ouroMarks;
        Intrinsics.checkNotNullParameter(ouroMarks3, "<this>");
        Intrinsics.checkNotNullParameter(ouroMarks2, "parent");
        Iterable $this$mapNotNull$iv = SetsKt.plus(ouroMarks.getKeys(), ouroMarks2.getKeys());
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            OuroMark.Key it = (OuroMark.Key) element$iv$iv$iv;
            OuroMark current = ouroMarks3.get(it);
            OuroMark parentMark = ouroMarks2.get(it);
            OuroMark mergeParent = current == null ? parentMark : parentMark == null ? current : OuroMarkKt.mergeParent(current, parentMark);
            if (mergeParent != null) {
                destination$iv$iv.add(mergeParent);
            }
            ouroMarks3 = ouroMarks;
        }
        return new OuroMarks<>((List) destination$iv$iv);
    }

    public static final <T extends OuroMark> OuroMarks<T> intersectAll(Collection<OuroMarks<T>> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<OuroMarks<T>> $this$reduce$iv = collection;
        Iterator iterator$iv = $this$reduce$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object accumulator$iv = iterator$iv.next();
        while (iterator$iv.hasNext()) {
            OuroMarks next = (OuroMarks) iterator$iv.next();
            OuroMarks acc = (OuroMarks) accumulator$iv;
            accumulator$iv = intersect(acc, next);
        }
        return (OuroMarks) accumulator$iv;
    }
}