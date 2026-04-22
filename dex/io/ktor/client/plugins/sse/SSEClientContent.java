package io.ktor.client.plugins.sse;

import io.ktor.client.utils.CacheControl;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.StringValuesBuilder;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SSEClientContent.kt */
@InternalAPI
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/client/plugins/sse/SSEClientContent;", "Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lkotlin/time/Duration;", "reconnectionTime", "", "showCommentEvents", "showRetryEvents", "Lio/ktor/http/content/OutgoingContent;", "requestBody", "<init>", "(JZZLio/ktor/http/content/OutgoingContent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "toString", "()Ljava/lang/String;", "delegate", "copy", "(Lio/ktor/http/content/OutgoingContent;)Lio/ktor/client/plugins/sse/SSEClientContent;", "J", "getReconnectionTime-UwyO8pc", "()J", "Z", "getShowCommentEvents", "()Z", "getShowRetryEvents", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SSEClientContent extends OutgoingContent.ContentWrapper {
    private final Headers headers;
    private final long reconnectionTime;
    private final boolean showCommentEvents;
    private final boolean showRetryEvents;

    public /* synthetic */ SSEClientContent(long j, boolean z, boolean z2, OutgoingContent outgoingContent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, z2, outgoingContent);
    }

    /* renamed from: getReconnectionTime-UwyO8pc  reason: not valid java name */
    public final long m3498getReconnectionTimeUwyO8pc() {
        return this.reconnectionTime;
    }

    public final boolean getShowCommentEvents() {
        return this.showCommentEvents;
    }

    public final boolean getShowRetryEvents() {
        return this.showRetryEvents;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private SSEClientContent(long reconnectionTime, boolean showCommentEvents, boolean showRetryEvents, OutgoingContent requestBody) {
        super(requestBody);
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        this.reconnectionTime = reconnectionTime;
        this.showCommentEvents = showCommentEvents;
        this.showRetryEvents = showRetryEvents;
        StringValuesBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.appendAll(requestBody.getHeaders());
        HeaderValueWithParametersKt.append(headersBuilder, HttpHeaders.INSTANCE.getAccept(), ContentType.Text.INSTANCE.getEventStream());
        headersBuilder.append(HttpHeaders.INSTANCE.getCacheControl(), CacheControl.NO_STORE);
        this.headers = headersBuilder.m3526build();
    }

    @Override // io.ktor.http.content.OutgoingContent.ContentWrapper, io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return this.headers;
    }

    public String toString() {
        return "SSEClientContent";
    }

    @Override // io.ktor.http.content.OutgoingContent.ContentWrapper
    public SSEClientContent copy(OutgoingContent delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new SSEClientContent(this.reconnectionTime, this.showCommentEvents, this.showRetryEvents, delegate, null);
    }
}