package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: IntegerLiteralTypeConstructor.kt */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final Companion Companion = new Companion(null);
    private final ModuleDescriptor module;
    private final Set<KotlinType> possibleTypes;
    private final Lazy supertypes$delegate;
    private final SimpleType type;
    private final long value;

    public /* synthetic */ IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, moduleDescriptor, set);
    }

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IntegerLiteralTypeConstructor.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE;
            
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
        }

        /* compiled from: IntegerLiteralTypeConstructor.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                try {
                    iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SimpleType findIntersectionType(Collection<? extends SimpleType> types) {
            Intrinsics.checkNotNullParameter(types, "types");
            return findCommonSuperTypeOrIntersectionType(types, Mode.INTERSECTION_TYPE);
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Collection<? extends SimpleType> $this$reduce$iv = collection;
            Iterator iterator$iv = $this$reduce$iv.iterator();
            if (!iterator$iv.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object accumulator$iv = iterator$iv.next();
            while (iterator$iv.hasNext()) {
                SimpleType right = (SimpleType) iterator$iv.next();
                SimpleType left = (SimpleType) accumulator$iv;
                accumulator$iv = IntegerLiteralTypeConstructor.Companion.fold(left, right, mode);
            }
            return (SimpleType) accumulator$iv;
        }

        private final SimpleType fold(SimpleType left, SimpleType right, Mode mode) {
            if (left == null || right == null) {
                return null;
            }
            TypeConstructor leftConstructor = left.getConstructor();
            TypeConstructor rightConstructor = right.getConstructor();
            if ((leftConstructor instanceof IntegerLiteralTypeConstructor) && (rightConstructor instanceof IntegerLiteralTypeConstructor)) {
                return fold((IntegerLiteralTypeConstructor) leftConstructor, (IntegerLiteralTypeConstructor) rightConstructor, mode);
            }
            if (leftConstructor instanceof IntegerLiteralTypeConstructor) {
                return fold((IntegerLiteralTypeConstructor) leftConstructor, right);
            }
            if (rightConstructor instanceof IntegerLiteralTypeConstructor) {
                return fold((IntegerLiteralTypeConstructor) rightConstructor, left);
            }
            return null;
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor left, IntegerLiteralTypeConstructor right, Mode mode) {
            Set possibleTypes;
            switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
                case 1:
                    possibleTypes = CollectionsKt.intersect(left.getPossibleTypes(), right.getPossibleTypes());
                    break;
                case 2:
                    possibleTypes = CollectionsKt.union(left.getPossibleTypes(), right.getPossibleTypes());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            IntegerLiteralTypeConstructor constructor = new IntegerLiteralTypeConstructor(left.value, left.module, possibleTypes, null);
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), constructor, false);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor left, SimpleType right) {
            if (left.getPossibleTypes().contains(right)) {
                return right;
            }
            return null;
        }
    }

    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long value, ModuleDescriptor module, Set<? extends KotlinType> set) {
        this.type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
        this.supertypes$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$$Lambda$0
            private final IntegerLiteralTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List supertypes_delegate$lambda$0;
                supertypes_delegate$lambda$0 = IntegerLiteralTypeConstructor.supertypes_delegate$lambda$0(this.arg$0);
                return supertypes_delegate$lambda$0;
            }
        });
        this.value = value;
        this.module = module;
        this.possibleTypes = set;
    }

    private final boolean isContainsOnlyUnsignedTypes() {
        Iterable $this$all$iv = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            KotlinType it = (KotlinType) element$iv;
            if (this.possibleTypes.contains(it)) {
                return false;
            }
        }
        return true;
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List supertypes_delegate$lambda$0(IntegerLiteralTypeConstructor this$0) {
        SimpleType defaultType = this$0.getBuiltIns().getComparable().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        List result = CollectionsKt.mutableListOf(TypeSubstitutionKt.replace$default(defaultType, CollectionsKt.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, this$0.type)), null, 2, null));
        if (!this$0.isContainsOnlyUnsignedTypes()) {
            result.add(this$0.getBuiltIns().getNumberType());
        }
        return result;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes  reason: collision with other method in class */
    public Collection<KotlinType> mo1172getSupertypes() {
        return getSupertypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1171getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerLiteralType" + valueToString();
    }

    private final String valueToString() {
        return AbstractJsonLexerKt.BEGIN_LIST + CollectionsKt.joinToString$default(this.possibleTypes, ",", null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence valueToString$lambda$0;
                valueToString$lambda$0 = IntegerLiteralTypeConstructor.valueToString$lambda$0((KotlinType) obj);
                return valueToString$lambda$0;
            }
        }, 30, null) + AbstractJsonLexerKt.END_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence valueToString$lambda$0(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }
}