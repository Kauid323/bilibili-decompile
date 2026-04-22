package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;

/* compiled from: FunctionTypeKindExtractor.kt */
public final class FunctionTypeKindExtractor {
    public static final Companion Companion = new Companion(null);
    private static final FunctionTypeKindExtractor Default = new FunctionTypeKindExtractor(CollectionsKt.listOf((Object[]) new FunctionTypeKind[]{FunctionTypeKind.Function.INSTANCE, FunctionTypeKind.SuspendFunction.INSTANCE, FunctionTypeKind.KFunction.INSTANCE, FunctionTypeKind.KSuspendFunction.INSTANCE}));
    private final List<FunctionTypeKind> kinds;
    private final Map<FqName, List<FunctionTypeKind>> knownKindsByPackageFqName;

    /* compiled from: FunctionTypeKindExtractor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FunctionTypeKindExtractor getDefault() {
            return FunctionTypeKindExtractor.Default;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionTypeKindExtractor(List<? extends FunctionTypeKind> kinds) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(kinds, "kinds");
        this.kinds = kinds;
        Iterable $this$groupBy$iv = this.kinds;
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            FunctionTypeKind it = (FunctionTypeKind) element$iv$iv;
            FqName packageFqName = it.getPackageFqName();
            Object value$iv$iv$iv = destination$iv$iv.get(packageFqName);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                destination$iv$iv.put(packageFqName, arrayList);
            } else {
                arrayList = value$iv$iv$iv;
            }
            Object key$iv$iv$iv = arrayList;
            List list$iv$iv = (List) key$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
        }
        this.knownKindsByPackageFqName = destination$iv$iv;
    }

    public final FunctionTypeKind getFunctionalClassKind(FqName packageFqName, String className) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(className, "className");
        KindWithArity functionalClassKindWithArity = getFunctionalClassKindWithArity(packageFqName, className);
        if (functionalClassKindWithArity != null) {
            return functionalClassKindWithArity.getKind();
        }
        return null;
    }

    public final KindWithArity getFunctionalClassKindWithArity(FqName packageFqName, String className) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(className, "className");
        List kinds = this.knownKindsByPackageFqName.get(packageFqName);
        if (kinds == null) {
            return null;
        }
        for (FunctionTypeKind kind : kinds) {
            if (StringsKt.startsWith$default(className, kind.getClassNamePrefix(), false, 2, (Object) null)) {
                String substring = className.substring(kind.getClassNamePrefix().length());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Integer num = toInt(substring);
                if (num != null) {
                    int arity = num.intValue();
                    return new KindWithArity(kind, arity);
                }
            }
        }
        return null;
    }

    /* compiled from: FunctionTypeKindExtractor.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class KindWithArity {
        private final int arity;
        private final FunctionTypeKind kind;

        public final FunctionTypeKind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KindWithArity) {
                KindWithArity kindWithArity = (KindWithArity) obj;
                return Intrinsics.areEqual(this.kind, kindWithArity.kind) && this.arity == kindWithArity.arity;
            }
            return false;
        }

        public int hashCode() {
            return (this.kind.hashCode() * 31) + this.arity;
        }

        public String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
        }

        public KindWithArity(FunctionTypeKind kind, int arity) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            this.kind = kind;
            this.arity = arity;
        }

        public final FunctionTypeKind getKind() {
            return this.kind;
        }
    }

    private final Integer toInt(String s) {
        if (s.length() == 0) {
            return null;
        }
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int d = c - '0';
            if (!(d >= 0 && d < 10)) {
                return null;
            }
            result = (result * 10) + d;
        }
        return Integer.valueOf(result);
    }
}