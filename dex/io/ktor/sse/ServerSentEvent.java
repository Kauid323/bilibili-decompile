package io.ktor.sse;

import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerSentEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lio/ktor/sse/ServerSentEvent;", "", "", UtilsKt.DATA_KEY, "event", "id", "", "retry", "comments", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getData", "getEvent", "getId", "Ljava/lang/Long;", "getRetry", "()Ljava/lang/Long;", "getComments", "ktor-sse"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ServerSentEvent {
    private final String comments;
    private final String data;
    private final String event;
    private final String id;
    private final Long retry;

    public ServerSentEvent() {
        this(null, null, null, null, null, 31, null);
    }

    public ServerSentEvent(String data, String event, String id, Long retry, String comments) {
        this.data = data;
        this.event = event;
        this.id = id;
        this.retry = retry;
        this.comments = comments;
    }

    public /* synthetic */ ServerSentEvent(String str, String str2, String str3, Long l, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? null : str4);
    }

    public final String getData() {
        return this.data;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getId() {
        return this.id;
    }

    public final Long getRetry() {
        return this.retry;
    }

    public final String getComments() {
        return this.comments;
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
        ServerSentEventKt.access$appendField($this$toString_u24lambda_u240, UtilsKt.DATA_KEY, this.data);
        ServerSentEventKt.access$appendField($this$toString_u24lambda_u240, "event", this.event);
        ServerSentEventKt.access$appendField($this$toString_u24lambda_u240, "id", this.id);
        ServerSentEventKt.access$appendField($this$toString_u24lambda_u240, "retry", this.retry);
        ServerSentEventKt.access$appendField($this$toString_u24lambda_u240, "", this.comments);
        String sb = $this$toString_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}