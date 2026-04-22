package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: Publish.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class PublisherCoroutine$onSend$2 extends FunctionReferenceImpl implements Function3<PublisherCoroutine<?>, Object, Object, Object> {
    public static final PublisherCoroutine$onSend$2 INSTANCE = new PublisherCoroutine$onSend$2();

    PublisherCoroutine$onSend$2() {
        super(3, PublisherCoroutine.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PublisherCoroutine<?> publisherCoroutine, Object p1, Object p2) {
        Object processResultSelectSend;
        processResultSelectSend = publisherCoroutine.processResultSelectSend(p1, p2);
        return processResultSelectSend;
    }
}