package nl.adaptivity.xmlutil.core.impl.multiplatform;

import j$.util.Map;
import j$.util.function.Function;
import java.util.Map;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlUtilInternal;

/* compiled from: multiplatform.jvmCommon.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"computeIfAbsent", "V", "K", "", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Multiplatform_jvmCommonKt {
    @XmlUtilInternal
    public static final <K, V> V computeIfAbsent(Map<K, V> map, K k, final Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        final Function1<K, V> function1 = new Function1<K, V>() { // from class: nl.adaptivity.xmlutil.core.impl.multiplatform.Multiplatform_jvmCommonKt$computeIfAbsent$1
            @Override // kotlin.jvm.functions.Function1
            public final V invoke(K k2) {
                return defaultValue.invoke();
            }
        };
        return (V) Map.-EL.computeIfAbsent(map, k, new Function(function1) { // from class: nl.adaptivity.xmlutil.core.impl.multiplatform.Multiplatform_jvmCommonKt$sam$i$java_util_function_Function$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.-CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                return this.function.invoke(obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
                return Function.-CC.$default$compose(this, function);
            }
        });
    }
}