package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: predefinedEnhancementInfo.kt */
public final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures = new LinkedHashMap();

    /* compiled from: predefinedEnhancementInfo.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class ClassEnhancementBuilder {
        private final String className;
        final /* synthetic */ SignatureEnhancementBuilder this$0;

        public ClassEnhancementBuilder(SignatureEnhancementBuilder this$0, String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.this$0 = this$0;
            this.className = className;
        }

        public final String getClassName() {
            return this.className;
        }

        public static /* synthetic */ void function$default(ClassEnhancementBuilder classEnhancementBuilder, String str, String str2, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            classEnhancementBuilder.function(str, str2, function1);
        }

        public final void function(String name, String errorsSinceLanguageVersion, Function1<? super FunctionEnhancementBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(block, "block");
            Map map = this.this$0.signatures;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(this, name, errorsSinceLanguageVersion);
            block.invoke(functionEnhancementBuilder);
            Pair<String, PredefinedFunctionEnhancementInfo> build = functionEnhancementBuilder.build();
            map.put(build.getFirst(), build.getSecond());
        }

        /* compiled from: predefinedEnhancementInfo.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public final class FunctionEnhancementBuilder {
            private final String errorsSinceLanguageVersion;
            private final String functionName;
            private final List<Pair<String, TypeEnhancementInfo>> parameters;
            private Pair<String, TypeEnhancementInfo> returnType;
            final /* synthetic */ ClassEnhancementBuilder this$0;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder this$0, String functionName, String errorsSinceLanguageVersion) {
                Intrinsics.checkNotNullParameter(functionName, "functionName");
                this.this$0 = this$0;
                this.functionName = functionName;
                this.errorsSinceLanguageVersion = errorsSinceLanguageVersion;
                this.parameters = new ArrayList();
                this.returnType = TuplesKt.to("V", (Object) null);
            }

            public final void parameter(String type, JavaTypeQualifiers... qualifiers) {
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> list = this.parameters;
                if (qualifiers.length == 0) {
                    typeEnhancementInfo = null;
                } else {
                    Iterable $this$associateBy$iv = ArraysKt.withIndex(qualifiers);
                    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                    Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                    for (Object element$iv$iv : $this$associateBy$iv) {
                        IndexedValue it = (IndexedValue) element$iv$iv;
                        IndexedValue it2 = (IndexedValue) element$iv$iv;
                        destination$iv$iv.put(Integer.valueOf(it.getIndex()), (JavaTypeQualifiers) it2.getValue());
                    }
                    typeEnhancementInfo = new TypeEnhancementInfo(destination$iv$iv);
                }
                list.add(TuplesKt.to(type, typeEnhancementInfo));
            }

            public final void returns(String type, JavaTypeQualifiers... qualifiers) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
                Iterable $this$associateBy$iv = ArraysKt.withIndex(qualifiers);
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                for (Object element$iv$iv : $this$associateBy$iv) {
                    IndexedValue it = (IndexedValue) element$iv$iv;
                    IndexedValue it2 = (IndexedValue) element$iv$iv;
                    destination$iv$iv.put(Integer.valueOf(it.getIndex()), (JavaTypeQualifiers) it2.getValue());
                }
                this.returnType = TuplesKt.to(type, new TypeEnhancementInfo(destination$iv$iv));
            }

            public final void returns(JvmPrimitiveType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                String desc = type.getDesc();
                Intrinsics.checkNotNullExpressionValue(desc, "getDesc(...)");
                this.returnType = TuplesKt.to(desc, (Object) null);
            }

            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents $this$build_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
                String className = this.this$0.getClassName();
                String str = this.functionName;
                Iterable $this$map$iv = this.parameters;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Pair it = (Pair) item$iv$iv;
                    destination$iv$iv.add((String) it.getFirst());
                }
                String signature = $this$build_u24lambda_u240.signature(className, $this$build_u24lambda_u240.jvmDescriptor(str, (List) destination$iv$iv, (String) this.returnType.getFirst()));
                TypeEnhancementInfo typeEnhancementInfo = (TypeEnhancementInfo) this.returnType.getSecond();
                Iterable $this$map$iv2 = this.parameters;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    Pair it2 = (Pair) item$iv$iv2;
                    destination$iv$iv2.add((TypeEnhancementInfo) it2.getSecond());
                }
                return TuplesKt.to(signature, new PredefinedFunctionEnhancementInfo(typeEnhancementInfo, (List) destination$iv$iv2, this.errorsSinceLanguageVersion));
            }
        }
    }

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }
}