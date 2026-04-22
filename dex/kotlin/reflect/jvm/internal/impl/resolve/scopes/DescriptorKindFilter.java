package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemberScope.kt */
public final class DescriptorKindFilter {
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;
    public static final Companion Companion = new Companion(null);
    private static int nextMaskValue = 1;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK = Companion.nextMask();
    private static final int SINGLETON_CLASSIFIERS_MASK = Companion.nextMask();
    private static final int TYPE_ALIASES_MASK = Companion.nextMask();
    private static final int PACKAGES_MASK = Companion.nextMask();
    private static final int FUNCTIONS_MASK = Companion.nextMask();
    private static final int VARIABLES_MASK = Companion.nextMask();
    private static final int ALL_KINDS_MASK = Companion.nextMask() - 1;
    private static final int CLASSIFIERS_MASK = (NON_SINGLETON_CLASSIFIERS_MASK | SINGLETON_CLASSIFIERS_MASK) | TYPE_ALIASES_MASK;
    private static final int VALUES_MASK = (SINGLETON_CLASSIFIERS_MASK | FUNCTIONS_MASK) | VARIABLES_MASK;
    private static final int CALLABLES_MASK = FUNCTIONS_MASK | VARIABLES_MASK;
    public static final DescriptorKindFilter ALL = new DescriptorKindFilter(ALL_KINDS_MASK, null, 2, null);
    public static final DescriptorKindFilter CALLABLES = new DescriptorKindFilter(CALLABLES_MASK, null, 2, null);
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(NON_SINGLETON_CLASSIFIERS_MASK, null, 2, null);
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS = new DescriptorKindFilter(SINGLETON_CLASSIFIERS_MASK, null, 2, null);
    public static final DescriptorKindFilter TYPE_ALIASES = new DescriptorKindFilter(TYPE_ALIASES_MASK, null, 2, null);
    public static final DescriptorKindFilter CLASSIFIERS = new DescriptorKindFilter(CLASSIFIERS_MASK, null, 2, null);
    public static final DescriptorKindFilter PACKAGES = new DescriptorKindFilter(PACKAGES_MASK, null, 2, null);
    public static final DescriptorKindFilter FUNCTIONS = new DescriptorKindFilter(FUNCTIONS_MASK, null, 2, null);
    public static final DescriptorKindFilter VARIABLES = new DescriptorKindFilter(VARIABLES_MASK, null, 2, null);
    public static final DescriptorKindFilter VALUES = new DescriptorKindFilter(VALUES_MASK, null, 2, null);

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int kindMask, List<? extends DescriptorKindExclude> excludes) {
        Intrinsics.checkNotNullParameter(excludes, "excludes");
        this.excludes = excludes;
        int mask = kindMask;
        Iterable $this$forEach$iv = this.excludes;
        for (Object element$iv : $this$forEach$iv) {
            DescriptorKindExclude it = (DescriptorKindExclude) element$iv;
            mask &= ~it.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = mask;
    }

    public /* synthetic */ DescriptorKindFilter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public final boolean acceptsKinds(int kinds) {
        return (this.kindMask & kinds) != 0;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int kinds) {
        int mask = this.kindMask & kinds;
        if (mask == 0) {
            return null;
        }
        return new DescriptorKindFilter(mask, this.excludes);
    }

    public String toString() {
        Object element$iv;
        String kindString;
        boolean z;
        Iterable $this$firstOrNull$iv = DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            if (((Companion.MaskToName) element$iv).getMask() == this.kindMask) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) element$iv;
        String predefinedFilterName = maskToName != null ? maskToName.getName() : null;
        if (predefinedFilterName == null) {
            Iterable $this$mapNotNull$iv = DEBUG_MASK_BIT_NAMES;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                Companion.MaskToName it2 = (Companion.MaskToName) element$iv$iv$iv;
                String name = acceptsKinds(it2.getMask()) ? it2.getName() : null;
                if (name != null) {
                    destination$iv$iv.add(name);
                }
            }
            kindString = CollectionsKt.joinToString$default((List) destination$iv$iv, " | ", null, null, 0, null, null, 62, null);
        } else {
            kindString = predefinedFilterName;
        }
        return "DescriptorKindFilter(" + kindString + ", " + this.excludes + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
            DescriptorKindFilter descriptorKindFilter = (DescriptorKindFilter) other;
            return Intrinsics.areEqual(this.excludes, ((DescriptorKindFilter) other).excludes) && this.kindMask == ((DescriptorKindFilter) other).kindMask;
        }
        return false;
    }

    public int hashCode() {
        int result = this.excludes.hashCode();
        return (result * 31) + this.kindMask;
    }

    /* compiled from: MemberScope.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int nextMask() {
            int i = DescriptorKindFilter.nextMaskValue;
            Companion companion = DescriptorKindFilter.Companion;
            DescriptorKindFilter.nextMaskValue <<= 1;
            return i;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.TYPE_ALIASES_MASK;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.PACKAGES_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.FUNCTIONS_MASK;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.VARIABLES_MASK;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.CLASSIFIERS_MASK;
        }

        /* compiled from: MemberScope.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        private static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int mask, String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                this.mask = mask;
                this.name = name;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }
    }

    static {
        Field[] fieldArr;
        Field[] fieldArr2;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Companion.MaskToName maskToName;
        Iterable $this$mapNotNull$iv2;
        Companion.MaskToName maskToName2;
        Object obj = null;
        Companion companion = Companion;
        Field[] fields = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "getFields(...)");
        Collection destination$iv$iv$iv = new ArrayList();
        for (Field field : fields) {
            Field it$iv = field;
            if (Modifier.isStatic(it$iv.getModifiers())) {
                destination$iv$iv$iv.add(field);
            }
        }
        Iterable $this$mapNotNull$iv3 = (List) destination$iv$iv$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv3) {
            Field field2 = (Field) element$iv$iv$iv;
            Object obj2 = field2.get(obj);
            DescriptorKindFilter filter = obj2 instanceof DescriptorKindFilter ? (DescriptorKindFilter) obj2 : null;
            if (filter != null) {
                $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
                int i = filter.kindMask;
                String name = field2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                maskToName2 = new Companion.MaskToName(i, name);
            } else {
                $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                destination$iv$iv.add(maskToName2);
            }
            $this$mapNotNull$iv3 = $this$mapNotNull$iv2;
            obj = null;
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = (List) destination$iv$iv;
        Companion companion2 = Companion;
        Field[] fields2 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "getFields(...)");
        Collection destination$iv$iv$iv2 = new ArrayList();
        for (Field field3 : fields2) {
            Field it$iv2 = field3;
            if (Modifier.isStatic(it$iv2.getModifiers())) {
                destination$iv$iv$iv2.add(field3);
            }
        }
        Iterable $this$filter$iv = (List) destination$iv$iv$iv2;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Field it = (Field) element$iv$iv;
            if (Intrinsics.areEqual(it.getType(), Integer.TYPE)) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$mapNotNull$iv4 = (List) destination$iv$iv2;
        int $i$f$mapNotNull2 = 0;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv4) {
            Field field4 = (Field) element$iv$iv$iv2;
            Object obj3 = field4.get(null);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int mask = ((Integer) obj3).intValue();
            boolean isOneBitMask = mask == ((-mask) & mask);
            if (isOneBitMask) {
                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                $i$f$mapNotNull = $i$f$mapNotNull2;
                String name2 = field4.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                maskToName = new Companion.MaskToName(mask, name2);
            } else {
                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                $i$f$mapNotNull = $i$f$mapNotNull2;
                maskToName = null;
            }
            if (maskToName != null) {
                destination$iv$iv3.add(maskToName);
            }
            $this$mapNotNull$iv4 = $this$mapNotNull$iv;
            $i$f$mapNotNull2 = $i$f$mapNotNull;
        }
        DEBUG_MASK_BIT_NAMES = (List) destination$iv$iv3;
    }
}