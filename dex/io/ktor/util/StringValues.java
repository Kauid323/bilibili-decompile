package io.ktor.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\f0\tH&¢\u0006\u0004\b\r\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0012J/\u0010\u0016\u001a\u00020\u00142\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH&¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/ktor/util/StringValues;", "", "", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "names", "()Ljava/util/Set;", "", "entries", "", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lkotlin/Function2;", "", "body", "forEach", "(Lkotlin/jvm/functions/Function2;)V", "isEmpty", "()Z", "getCaseInsensitiveName", "caseInsensitiveName", "Companion", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface StringValues {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean contains(String str);

    boolean contains(String str, String str2);

    Set<Map.Entry<String, List<String>>> entries();

    void forEach(Function2<? super String, ? super List<String>, Unit> function2);

    String get(String str);

    List<String> getAll(String str);

    boolean getCaseInsensitiveName();

    boolean isEmpty();

    Set<String> names();

    /* compiled from: StringValues.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lio/ktor/util/StringValues$Companion;", "", "<init>", "()V", "", "caseInsensitiveName", "Lkotlin/Function1;", "Lio/ktor/util/StringValuesBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "Lio/ktor/util/StringValues;", "build", "(ZLkotlin/jvm/functions/Function1;)Lio/ktor/util/StringValues;", "Empty", "Lio/ktor/util/StringValues;", "getEmpty", "()Lio/ktor/util/StringValues;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final StringValues Empty = new StringValuesImpl(false, null, 3, null);

        private Companion() {
        }

        public final StringValues getEmpty() {
            return Empty;
        }

        public static /* synthetic */ StringValues build$default(Companion $this, boolean caseInsensitiveName, Function1 builder, int i, Object obj) {
            if ((i & 1) != 0) {
                caseInsensitiveName = false;
            }
            Intrinsics.checkNotNullParameter(builder, "builder");
            StringValuesBuilderImpl stringValuesBuilderImpl = new StringValuesBuilderImpl(caseInsensitiveName, 0, 2, null);
            builder.invoke(stringValuesBuilderImpl);
            return stringValuesBuilderImpl.build();
        }

        public final StringValues build(boolean caseInsensitiveName, Function1<? super StringValuesBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            StringValuesBuilderImpl stringValuesBuilderImpl = new StringValuesBuilderImpl(caseInsensitiveName, 0, 2, null);
            function1.invoke(stringValuesBuilderImpl);
            return stringValuesBuilderImpl.build();
        }
    }

    /* compiled from: StringValues.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class DefaultImpls {
        public static String get(StringValues $this, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            List<String> all = $this.getAll(name);
            if (all != null) {
                return (String) kotlin.collections.CollectionsKt.firstOrNull(all);
            }
            return null;
        }

        public static boolean contains(StringValues $this, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return $this.getAll(name) != null;
        }

        public static boolean contains(StringValues $this, String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            List<String> all = $this.getAll(name);
            if (all != null) {
                return all.contains(value);
            }
            return false;
        }

        public static void forEach(StringValues $this, Function2<? super String, ? super List<String>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "body");
            Iterable $this$forEach$iv = $this.entries();
            for (Object element$iv : $this$forEach$iv) {
                Map.Entry entry = (Map.Entry) element$iv;
                String k = (String) entry.getKey();
                List v = (List) entry.getValue();
                function2.invoke(k, v);
            }
        }
    }
}