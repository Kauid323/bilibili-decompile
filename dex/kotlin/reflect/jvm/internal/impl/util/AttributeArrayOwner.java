package kotlin.reflect.jvm.internal.impl.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: AttributeArrayOwner.kt */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    private ArrayMap<T> arrayMap;

    protected AttributeArrayOwner(ArrayMap<T> arrayMap) {
        Intrinsics.checkNotNullParameter(arrayMap, "arrayMap");
        this.arrayMap = arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AttributeArrayOwner() {
        this(r0);
        EmptyArrayMap emptyArrayMap = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(emptyArrayMap, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final void registerComponent(String keyQualifiedName, T value) {
        Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        Intrinsics.checkNotNullParameter(value, "value");
        int id = getTypeRegistry().getId(keyQualifiedName);
        switch (this.arrayMap.getSize()) {
            case 0:
                ArrayMap mapSnapshot = this.arrayMap;
                if (!(mapSnapshot instanceof EmptyArrayMap)) {
                    throw new IllegalStateException(buildDiagnosticMessage(mapSnapshot, 0, "EmptyArrayMap"));
                }
                this.arrayMap = new OneElementArrayMap(value, id);
                return;
            case 1:
                ArrayMap mapSnapshot2 = this.arrayMap;
                try {
                    Intrinsics.checkNotNull(mapSnapshot2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                    OneElementArrayMap map = (OneElementArrayMap) mapSnapshot2;
                    if (map.getIndex() == id) {
                        this.arrayMap = new OneElementArrayMap(value, id);
                        return;
                    }
                    ArrayMap<T> arrayMapImpl = new ArrayMapImpl<>();
                    arrayMapImpl.set(map.getIndex(), map.getValue());
                    this.arrayMap = arrayMapImpl;
                    break;
                } catch (ClassCastException e) {
                    throw new IllegalStateException(buildDiagnosticMessage(mapSnapshot2, 1, "OneElementArrayMap"), e);
                }
        }
        this.arrayMap.set(id, value);
    }

    private final String buildDiagnosticMessage(ArrayMap<T> arrayMap, int expectedSize, String expectedImplementation) {
        T t;
        StringBuilder $this$buildDiagnosticMessage_u24lambda_u240 = new StringBuilder();
        boolean z = false;
        $this$buildDiagnosticMessage_u24lambda_u240.append("Race condition happened, the size of ArrayMap is " + expectedSize + " but it isn't an `" + expectedImplementation + '`').append('\n');
        $this$buildDiagnosticMessage_u24lambda_u240.append("Type: " + arrayMap.getClass()).append('\n');
        StringBuilder $this$buildDiagnosticMessage_u24lambda_u240_u240 = new StringBuilder();
        Map services = getTypeRegistry().allValuesThreadUnsafeForRendering();
        $this$buildDiagnosticMessage_u24lambda_u240_u240.append("[").append('\n');
        ArrayMap<T> $this$mapIndexed$iv = arrayMap;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Iterable $this$firstOrNull$iv = services.entrySet();
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    t = it.next();
                    Map.Entry it2 = (Map.Entry) t;
                    if (((Number) it2.getValue()).intValue() == index$iv$iv) {
                        break;
                    }
                } else {
                    t = null;
                    break;
                }
            }
            Map.Entry service = (Map.Entry) t;
            destination$iv$iv.add($this$buildDiagnosticMessage_u24lambda_u240_u240.append("  " + service + AbstractJsonLexerKt.BEGIN_LIST + index$iv$iv + "]: " + item$iv$iv).append('\n'));
            index$iv$iv = index$iv$iv2;
            z = z;
        }
        ArrayList arrayList = (List) destination$iv$iv;
        $this$buildDiagnosticMessage_u24lambda_u240_u240.append("]").append('\n');
        String content = $this$buildDiagnosticMessage_u24lambda_u240_u240.toString();
        $this$buildDiagnosticMessage_u24lambda_u240.append("Content: " + content).append('\n');
        return $this$buildDiagnosticMessage_u24lambda_u240.toString();
    }
}