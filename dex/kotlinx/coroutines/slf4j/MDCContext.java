package kotlinx.coroutines.slf4j;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ThreadContextElement;
import org.slf4j.MDC;

/* compiled from: MDCContext.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u00040\u00012\u00020\u0005:\u0001\u0011B!\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u0004¢\u0006\u0002\u0010\u0007J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u0004H\u0016J\"\u0010\u000f\u001a\u00020\u000b2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u0004H\u0002J\"\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u00042\u0006\u0010\f\u001a\u00020\rH\u0016R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/slf4j/MDCContext;", "Lkotlinx/coroutines/ThreadContextElement;", "", "", "Lkotlinx/coroutines/slf4j/MDCContextMap;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "contextMap", "(Ljava/util/Map;)V", "getContextMap", "()Ljava/util/Map;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "setCurrent", "updateThreadContext", "Key", "kotlinx-coroutines-slf4j"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MDCContext extends AbstractCoroutineContextElement implements ThreadContextElement<Map<String, ? extends String>> {
    public static final Key Key = new Key(null);
    private final Map<String, String> contextMap;

    public MDCContext() {
        this(null, 1, null);
    }

    public /* synthetic */ MDCContext(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MDC.getCopyOfContextMap() : map);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public /* bridge */ /* synthetic */ void restoreThreadContext(CoroutineContext context, Map<String, ? extends String> map) {
        restoreThreadContext2(context, (Map<String, String>) map);
    }

    public final Map<String, String> getContextMap() {
        return this.contextMap;
    }

    public MDCContext(Map<String, String> map) {
        super(Key);
        this.contextMap = map;
    }

    /* compiled from: MDCContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/slf4j/MDCContext$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/slf4j/MDCContext;", "()V", "kotlinx-coroutines-slf4j"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Key implements CoroutineContext.Key<MDCContext> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Key() {
        }
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public Map<String, ? extends String> updateThreadContext(CoroutineContext context) {
        Map oldState = MDC.getCopyOfContextMap();
        setCurrent(this.contextMap);
        return oldState;
    }

    /* renamed from: restoreThreadContext  reason: avoid collision after fix types in other method */
    public void restoreThreadContext2(CoroutineContext context, Map<String, String> map) {
        setCurrent(map);
    }

    private final void setCurrent(Map<String, String> map) {
        if (map == null) {
            MDC.clear();
        } else {
            MDC.setContextMap(map);
        }
    }
}