package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.reactivestreams.Publisher;

/* compiled from: Convert.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"asPublisher", "Lorg/reactivestreams/Publisher;", "T", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ConvertKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of consumeAsFlow()", replaceWith = @ReplaceWith(expression = "this.consumeAsFlow().asPublisher(context)", imports = {"kotlinx.coroutines.flow.consumeAsFlow"}))
    public static final /* synthetic */ Publisher asPublisher(ReceiveChannel $this$asPublisher, CoroutineContext context) {
        return PublishKt.publish(context, new ConvertKt$asPublisher$1($this$asPublisher, null));
    }

    public static /* synthetic */ Publisher asPublisher$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asPublisher(receiveChannel, coroutineContext);
    }
}