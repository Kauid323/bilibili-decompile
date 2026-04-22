package kntr.common.ouro.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroFontSizeMark;
import kntr.common.ouro.core.model.mark.OuroFontWeightMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroRegularMark;
import kntr.common.ouro.core.model.mark.OuroScriptMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroTextSpacingMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkConflictResolver.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\rJ\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012R(\u0010\u0004\u001a\u001c\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/core/utils/MarkConflictResolver;", "", "<init>", "()V", "rules", "", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "Lkntr/common/ouro/core/utils/MarkConflictRule;", "resolveConflict", "T", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "marks", "", "markMissing", "", "(Ljava/util/List;Z)Lkntr/common/ouro/core/model/mark/OuroTextMark;", "resolveMarksConflict", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "marksList", "applyDefaults", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MarkConflictResolver {
    public static final MarkConflictResolver INSTANCE = new MarkConflictResolver();
    private static final Map<? extends OuroMark.Key<? extends OuroMark>, MarkConflictRule<?>> rules = MapsKt.mapOf(new Pair[]{TuplesKt.to(OuroFontWeightMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, OuroRegularMark.INSTANCE, OuroRegularMark.INSTANCE)), TuplesKt.to(OuroItalicMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, null, null)), TuplesKt.to(OuroUnderlineMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, null, null)), TuplesKt.to(OuroStrikethroughMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, null, null)), TuplesKt.to(OuroScriptMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, null, null)), TuplesKt.to(OuroTextSpacingMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, null, null)), TuplesKt.to(OuroFontSizeMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, null, null)), TuplesKt.to(OuroBackgroundColorMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, null, null)), TuplesKt.to(OuroForegroundColorMark.Key.INSTANCE, new MarkConflictRule(ConflictResolutionStrategy.NONE, new OuroForegroundColorMark(MarkConflictResolverKt.getDefaultForegroundColor()), new OuroForegroundColorMark(MarkConflictResolverKt.getDefaultForegroundColor())))});

    /* compiled from: MarkConflictResolver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConflictResolutionStrategy.values().length];
            try {
                iArr[ConflictResolutionStrategy.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ConflictResolutionStrategy.LAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ConflictResolutionStrategy.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MarkConflictResolver() {
    }

    private final <T extends OuroTextMark> T resolveConflict(List<? extends T> list, boolean markMissing) {
        if (list.isEmpty()) {
            return null;
        }
        OuroMark.Key key = ((OuroMark) CollectionsKt.first(list)).getKey();
        MarkConflictRule rule = rules.get(key);
        if (rule == null) {
            return (T) CollectionsKt.last(list);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[rule.getDisplayStrategy().ordinal()]) {
            case 1:
                return (T) CollectionsKt.first(list);
            case 2:
                return (T) CollectionsKt.last(list);
            case 3:
                if (markMissing) {
                    return null;
                }
                List<? extends T> $this$all$iv = list;
                boolean z = true;
                if (!($this$all$iv instanceof Collection) || !$this$all$iv.isEmpty()) {
                    Iterator<T> it = $this$all$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            OuroTextMark it2 = (OuroTextMark) element$iv;
                            if (!Intrinsics.areEqual(it2, CollectionsKt.first(list))) {
                                z = false;
                            }
                        }
                    }
                }
                if (z) {
                    return (T) CollectionsKt.first(list);
                }
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final OuroMarks<OuroTextMark> resolveMarksConflict(List<OuroMarks<OuroTextMark>> list) {
        Collection destination$iv$iv;
        Iterable iterable = list;
        Intrinsics.checkNotNullParameter(iterable, "marksList");
        if (list.isEmpty()) {
            return OuroMarks.Empty.INSTANCE.getTextMarks();
        }
        if (list.size() == 1) {
            return (OuroMarks) CollectionsKt.first(list);
        }
        Iterable $this$flatMap$iv = iterable;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            OuroMarks it = (OuroMarks) element$iv$iv;
            Iterable list$iv$iv = it.getKeys();
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
        }
        Set allKeys = CollectionsKt.toSet((List) destination$iv$iv2);
        Set $this$mapNotNull$iv = allKeys;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            OuroMark.Key key = (OuroMark.Key) element$iv$iv$iv;
            Iterable $this$mapNotNull$iv2 = iterable;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                OuroMarks marks = (OuroMarks) element$iv$iv$iv2;
                OuroTextMark ouroTextMark = (OuroTextMark) marks.get(key);
                if (ouroTextMark != null) {
                    destination$iv$iv = destination$iv$iv4;
                    destination$iv$iv.add(ouroTextMark);
                } else {
                    destination$iv$iv = destination$iv$iv4;
                }
                destination$iv$iv4 = destination$iv$iv;
            }
            ArrayList arrayList = (List) destination$iv$iv4;
            Set allKeys2 = allKeys;
            boolean markMissing = arrayList.size() != list.size();
            OuroTextMark resolveConflict = INSTANCE.resolveConflict(arrayList, markMissing);
            if (resolveConflict != null) {
                destination$iv$iv3.add(resolveConflict);
            }
            iterable = list;
            allKeys = allKeys2;
        }
        List resolvedMarks = (List) destination$iv$iv3;
        return new OuroMarks<>(resolvedMarks);
    }

    public final OuroMarks<OuroTextMark> applyDefaults(OuroMarks<OuroTextMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Iterable $this$mapNotNull$iv = rules.values();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            MarkConflictRule it = (MarkConflictRule) element$iv$iv$iv;
            OuroTextMark defaultInsertValue = it.getDefaultInsertValue();
            if (defaultInsertValue != null) {
                destination$iv$iv.add(defaultInsertValue);
            }
        }
        Iterable defaultMarks = (List) destination$iv$iv;
        Set currentKeys = ouroMarks.getKeys();
        Iterable $this$filter$iv = defaultMarks;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            OuroTextMark defaultMark = (OuroTextMark) element$iv$iv;
            if (!CollectionsKt.contains(currentKeys, defaultMark.getKey())) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        List missingDefaults = (List) destination$iv$iv2;
        return !missingDefaults.isEmpty() ? ouroMarks.plus(missingDefaults) : ouroMarks;
    }
}