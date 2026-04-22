package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedEnhancementInfoKt {
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    private static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final JavaTypeQualifiers NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    private static final JavaTypeQualifiers NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);

    static {
        final SignatureBuildingComponents $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        final String JLObject = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaLang("Object");
        final String JFPredicate = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("Predicate");
        final String JFFunction = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("Function");
        final String JFConsumer = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("Consumer");
        final String JFBiFunction = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("BiFunction");
        final String JFBiConsumer = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("BiConsumer");
        final String JFUnaryOperator = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("UnaryOperator");
        final String JUStream = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("stream/Stream");
        final String JUOptional = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("Optional");
        SignatureEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240 = new SignatureEnhancementBuilder();
        String internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("Iterator");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u240 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u240, "forEachRemaining", null, new Function1(JFConsumer) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$0
            private final String arg$0;

            {
                this.arg$0 = JFConsumer;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$0$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$0$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$0$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$0$0;
            }
        }, 2, null);
        String internalName$iv2 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaLang("Iterable");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u241 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv2);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u241, "spliterator", null, new Function1($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$1
            private final SignatureBuildingComponents arg$0;

            {
                this.arg$0 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$1$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$1$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$1$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$1$0;
            }
        }, 2, null);
        String internalName$iv3 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("Collection");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u242 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv3);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u242, "removeIf", null, new Function1(JFPredicate) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$2
            private final String arg$0;

            {
                this.arg$0 = JFPredicate;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u242, "stream", null, new Function1(JUStream) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$3
            private final String arg$0;

            {
                this.arg$0 = JUStream;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$1;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$1 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$1;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u242, "parallelStream", null, new Function1(JUStream) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$4
            private final String arg$0;

            {
                this.arg$0 = JUStream;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$2;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$2 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$2;
            }
        }, 2, null);
        String internalName$iv4 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("List");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u243 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv4);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u243, "replaceAll", null, new Function1(JFUnaryOperator) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$5
            private final String arg$0;

            {
                this.arg$0 = JFUnaryOperator;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$0;
            }
        }, 2, null);
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u243.function("addFirst", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$6
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$1;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$1 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$1;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u243.function("addLast", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$7
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$2;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$2 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$2;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u243.function("removeFirst", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$8
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$3;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$3 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$3(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$3;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u243.function("removeLast", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$9
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$4;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$4 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$4(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$4;
            }
        });
        String internalName$iv5 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("LinkedList");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u244 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv5);
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u244.function("addFirst", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$10
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$0;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u244.function("addLast", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$11
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$1;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$1 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$1;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u244.function("removeFirst", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$12
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$2;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$2 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$2;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u244.function("removeLast", "2.1", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$13
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$3;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$3 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$3(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$3;
            }
        });
        String internalName$iv6 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("LinkedHashSet");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u245 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv6);
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u245.function("addFirst", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$14
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$0;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u245.function("addLast", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$15
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$1;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$1 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$1;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u245.function("removeFirst", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$16
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$2;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$2 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$2;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u245.function("removeLast", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$17
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$3;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$3 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$3(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$3;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u245.function("getFirst", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$18
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$4;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$4 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$4(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$4;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u245.function("getLast", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$19
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$5;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$5 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$5(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$5;
            }
        });
        String internalName$iv7 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("Map");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv7);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "forEach", null, new Function1(JFBiConsumer) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$20
            private final String arg$0;

            {
                this.arg$0 = JFBiConsumer;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "putIfAbsent", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$21
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$1;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$1 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$1;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "replace", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$22
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$2;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$2 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$2;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "replace", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$23
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$3;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$3 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$3(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$3;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "replaceAll", null, new Function1(JFBiFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$24
            private final String arg$0;

            {
                this.arg$0 = JFBiFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$4;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$4 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$4(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$4;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "compute", null, new Function1(JLObject, JFBiFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$25
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = JLObject;
                this.arg$1 = JFBiFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$5;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$5 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$5(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$5;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "computeIfAbsent", null, new Function1(JLObject, JFFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$26
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = JLObject;
                this.arg$1 = JFFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$6;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$6 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$6(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$6;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "computeIfPresent", null, new Function1(JLObject, JFBiFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$27
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = JLObject;
                this.arg$1 = JFBiFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$7;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$7 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$7(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$7;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u246, "merge", null, new Function1(JLObject, JFBiFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$28
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = JLObject;
                this.arg$1 = JFBiFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$8;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$8 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$8(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$8;
            }
        }, 2, null);
        String internalName$iv8 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaUtil("LinkedHashMap");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u247 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv8);
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u247.function("putFirst", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$29
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$0;
            }
        });
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u247.function("putLast", "2.2", new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$30
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$1;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$1 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$1;
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u248 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, JUOptional);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u248, "empty", null, new Function1(JUOptional) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$31
            private final String arg$0;

            {
                this.arg$0 = JUOptional;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u248, "of", null, new Function1(JLObject, JUOptional) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$32
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = JLObject;
                this.arg$1 = JUOptional;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$1;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$1 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$1(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$1;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u248, "ofNullable", null, new Function1(JLObject, JUOptional) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$33
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = JLObject;
                this.arg$1 = JUOptional;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$2;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$2 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$2(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$2;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u248, "get", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$34
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$3;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$3 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$3(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$3;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u248, "ifPresent", null, new Function1(JFConsumer) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$35
            private final String arg$0;

            {
                this.arg$0 = JFConsumer;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$4;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$4 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$4(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$4;
            }
        }, 2, null);
        String internalName$iv9 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaLang("ref/Reference");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u249 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv9);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u249, "get", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$36
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$9$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$9$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$9$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$9$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2410 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, JFPredicate);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2410, "test", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$37
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$10$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$10$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$10$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$10$0;
            }
        }, 2, null);
        String internalName$iv10 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("BiPredicate");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2411 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv10);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2411, "test", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$38
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$11$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$11$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$11$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$11$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2412 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, JFConsumer);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2412, "accept", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$39
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$12$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$12$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$12$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$12$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2413 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, JFBiConsumer);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2413, "accept", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$40
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$13$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$13$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$13$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$13$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2414 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, JFFunction);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2414, "apply", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$41
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$14$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$14$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$14$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$14$0;
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2415 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, JFBiFunction);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2415, "apply", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$42
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$15$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$15$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$15$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$15$0;
            }
        }, 2, null);
        String internalName$iv11 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240.javaFunction("Supplier");
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2416 = new SignatureEnhancementBuilder.ClassEnhancementBuilder($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240, internalName$iv11);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240_u2416, "get", null, new Function1(JLObject) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$43
            private final String arg$0;

            {
                this.arg$0 = JLObject;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$16$0;
                PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$16$0 = PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$16$0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
                return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$16$0;
            }
        }, 2, null);
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u240_u240.build();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$0$0(String $JFConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JFConsumer, NOT_PLATFORM, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$1$0(SignatureBuildingComponents $this_signatures, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($this_signatures.javaUtil("Spliterator"), NOT_PLATFORM, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$0(String $JFPredicate, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JFPredicate, NOT_PLATFORM, NOT_PLATFORM);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$1(String $JUStream, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JUStream, NOT_PLATFORM, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$2$2(String $JUStream, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JUStream, NOT_PLATFORM, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$0(String $JFUnaryOperator, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JFUnaryOperator, NOT_PLATFORM, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$1(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$2(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$3(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$3$4(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$1(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$2(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$4$3(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$1(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$2(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$3(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$4(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$5$5(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$0(String $JFBiConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JFBiConsumer, NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$1(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$2(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$3(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$4(String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JFBiFunction, NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$5(String $JLObject, String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JFBiFunction, NOT_PLATFORM, NOT_PLATFORM, NULLABLE, NULLABLE);
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$6(String $JLObject, String $JFFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JFFunction, NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM);
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$7(String $JLObject, String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JFBiFunction, NOT_PLATFORM, NOT_PLATFORM, NOT_NULLABLE, NULLABLE);
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$6$8(String $JLObject, String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_NULLABLE);
        function.parameter($JFBiFunction, NOT_PLATFORM, NOT_NULLABLE, NOT_NULLABLE, NULLABLE);
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$7$1(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$0(String $JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JUOptional, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$1(String $JLObject, String $JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_NULLABLE);
        function.returns($JUOptional, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$2(String $JLObject, String $JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NULLABLE);
        function.returns($JUOptional, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$3(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$8$4(String $JFConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JFConsumer, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$9$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$10$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$11$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$12$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$13$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$14$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$15$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter($JLObject, NOT_PLATFORM);
        function.parameter($JLObject, NOT_PLATFORM);
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$0$0$16$0(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns($JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }
}