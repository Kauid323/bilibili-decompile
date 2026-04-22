package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    private TypeIntersector() {
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> types) {
        Intrinsics.checkNotNullParameter(types, "types");
        if (types.size() > 1) {
            ArrayList inputTypes = new ArrayList();
            for (SimpleType type : types) {
                if (type.getConstructor() instanceof IntersectionTypeConstructor) {
                    Iterable mo1172getSupertypes = type.getConstructor().mo1172getSupertypes();
                    Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
                    Iterable $this$map$iv = mo1172getSupertypes;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        KotlinType it = (KotlinType) item$iv$iv;
                        Intrinsics.checkNotNull(it);
                        SimpleType it2 = FlexibleTypesKt.upperIfFlexible(it);
                        if (type.isMarkedNullable()) {
                            it2 = it2.makeNullableAsSpecified(true);
                        }
                        destination$iv$iv.add(it2);
                    }
                    inputTypes.addAll((List) destination$iv$iv);
                } else {
                    inputTypes.add(type);
                }
            }
            ArrayList $this$fold$iv = inputTypes;
            ResultNullability resultNullability = ResultNullability.START;
            for (Object element$iv : $this$fold$iv) {
                UnwrappedType p1 = (UnwrappedType) element$iv;
                ResultNullability p0 = resultNullability;
                resultNullability = p0.combine(p1);
            }
            ResultNullability resultNullability2 = resultNullability;
            ArrayList $this$mapTo$iv = inputTypes;
            Collection destination$iv = new LinkedHashSet();
            for (Object item$iv : $this$mapTo$iv) {
                SimpleType it3 = (SimpleType) item$iv;
                if (resultNullability2 == ResultNullability.NOT_NULL) {
                    it3 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(it3 instanceof NewCapturedType ? SpecialTypesKt.withNotNullProjection((NewCapturedType) it3) : it3, false, 1, null);
                }
                destination$iv.add(it3);
            }
            LinkedHashSet correctNullability = (LinkedHashSet) destination$iv;
            List<? extends SimpleType> $this$map$iv2 = types;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                destination$iv$iv2.add(((SimpleType) item$iv$iv2).getAttributes());
            }
            Iterable $this$reduce$iv = (List) destination$iv$iv2;
            Iterator iterator$iv = $this$reduce$iv.iterator();
            if (iterator$iv.hasNext()) {
                Object accumulator$iv = iterator$iv.next();
                while (iterator$iv.hasNext()) {
                    TypeAttributes y = (TypeAttributes) iterator$iv.next();
                    TypeAttributes x = (TypeAttributes) accumulator$iv;
                    accumulator$iv = x.intersect(y);
                }
                TypeAttributes resultAttributes = (TypeAttributes) accumulator$iv;
                return intersectTypesWithoutIntersectionType(correctNullability).replaceAttributes(resultAttributes);
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        throw new AssertionError("Size should be at least 2, but it is " + types.size());
    }

    private final SimpleType intersectTypesWithoutIntersectionType(final Set<? extends SimpleType> set) {
        if (set.size() == 1) {
            return (SimpleType) CollectionsKt.single(set);
        }
        Function0 errorMessage = new Function0(set) { // from class: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$$Lambda$0
            private final Set arg$0;

            {
                this.arg$0 = set;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String intersectTypesWithoutIntersectionType$lambda$0;
                intersectTypesWithoutIntersectionType$lambda$0 = TypeIntersector.intersectTypesWithoutIntersectionType$lambda$0(this.arg$0);
                return intersectTypesWithoutIntersectionType$lambda$0;
            }
        };
        Collection filteredEqualTypes = filterTypes(set, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        if (filteredEqualTypes.isEmpty()) {
            throw new AssertionError(errorMessage.invoke());
        }
        SimpleType it = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filteredEqualTypes);
        if (it != null) {
            return it;
        }
        Collection filteredSuperAndEqualTypes = filterTypes(filteredEqualTypes, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
        if (filteredSuperAndEqualTypes.isEmpty()) {
            throw new AssertionError(errorMessage.invoke());
        }
        return filteredSuperAndEqualTypes.size() < 2 ? (SimpleType) CollectionsKt.single(filteredSuperAndEqualTypes) : new IntersectionTypeConstructor(set).createType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String intersectTypesWithoutIntersectionType$lambda$0(Set $inputTypes) {
        return "This collections cannot be empty! input types: " + CollectionsKt.joinToString$default($inputTypes, null, null, null, 0, null, null, 63, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> collection, Function2<? super SimpleType, ? super SimpleType, Boolean> function2) {
        SimpleType lower;
        ArrayList filteredTypes = new ArrayList(collection);
        Iterator iterator = filteredTypes.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, "iterator(...)");
        while (iterator.hasNext()) {
            SimpleType upper = (SimpleType) iterator.next();
            ArrayList $this$any$iv = filteredTypes;
            Iterable $this$any$iv2 = null;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    SimpleType lower2 = (SimpleType) element$iv;
                    if (lower2 != upper) {
                        Intrinsics.checkNotNull(lower2);
                        Intrinsics.checkNotNull(upper);
                        if (function2.invoke(lower2, upper).booleanValue()) {
                            lower = 1;
                            continue;
                            if (lower != null) {
                                $this$any$iv2 = 1;
                                break;
                            }
                        }
                    }
                    lower = null;
                    continue;
                    if (lower != null) {
                    }
                }
            }
            if ($this$any$iv2 != null) {
                iterator.remove();
            }
        }
        return filteredTypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStrictSupertype(KotlinType subtype, KotlinType supertype) {
        NewKotlinTypeCheckerImpl $this$isStrictSupertype_u24lambda_u240 = NewKotlinTypeChecker.Companion.getDefault();
        return $this$isStrictSupertype_u24lambda_u240.isSubtypeOf(subtype, supertype) && !$this$isStrictSupertype_u24lambda_u240.isSubtypeOf(supertype, subtype);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: IntersectionType.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ResultNullability {
        public static final ResultNullability START = new START("START", 0);
        public static final ResultNullability ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
        public static final ResultNullability UNKNOWN = new UNKNOWN("UNKNOWN", 2);
        public static final ResultNullability NOT_NULL = new NOT_NULL("NOT_NULL", 3);
        private static final /* synthetic */ ResultNullability[] $VALUES = $values();
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        private static final /* synthetic */ ResultNullability[] $values() {
            return new ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        public /* synthetic */ ResultNullability(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static ResultNullability valueOf(String str) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(UnwrappedType unwrappedType);

        /* compiled from: IntersectionType.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class START extends ResultNullability {
            START(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType nextType) {
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        private ResultNullability(String $enum$name, int $enum$ordinal) {
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType nextType) {
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType nextType) {
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                ResultNullability it = getResultNullability(nextType);
                return it == ResultNullability.ACCEPT_NULL ? this : it;
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class NOT_NULL extends ResultNullability {
            NOT_NULL(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public NOT_NULL combine(UnwrappedType nextType) {
                Intrinsics.checkNotNullParameter(nextType, "nextType");
                return this;
            }
        }

        protected final ResultNullability getResultNullability(UnwrappedType $this$resultNullability) {
            Intrinsics.checkNotNullParameter($this$resultNullability, "<this>");
            return $this$resultNullability.isMarkedNullable() ? ACCEPT_NULL : (($this$resultNullability instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) $this$resultNullability).getOriginal() instanceof StubTypeForBuilderInference)) ? NOT_NULL : $this$resultNullability instanceof StubTypeForBuilderInference ? UNKNOWN : NullabilityChecker.INSTANCE.isSubtypeOfAny($this$resultNullability) ? NOT_NULL : UNKNOWN;
        }
    }
}