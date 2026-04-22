package io.ktor.http.content;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutgoingContent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "", "isEmpty", "(Lio/ktor/http/content/OutgoingContent;)Z", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OutgoingContentKt {
    @InternalAPI
    public static final boolean isEmpty(OutgoingContent $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        if ($this$isEmpty instanceof OutgoingContent.NoContent) {
            return true;
        }
        if ($this$isEmpty instanceof OutgoingContent.ContentWrapper) {
            return isEmpty(((OutgoingContent.ContentWrapper) $this$isEmpty).delegate());
        }
        return false;
    }
}