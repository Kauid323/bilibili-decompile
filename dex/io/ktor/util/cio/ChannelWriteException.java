package io.ktor.util.cio;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Channels.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/util/cio/ChannelWriteException;", "Lio/ktor/util/cio/ChannelIOException;", "", CrashHianalyticsData.MESSAGE, "", "exception", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChannelWriteException extends ChannelIOException {
    public /* synthetic */ ChannelWriteException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Cannot write to a channel" : str, th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelWriteException(String message, Throwable exception) {
        super(message, exception);
        Intrinsics.checkNotNullParameter(message, CrashHianalyticsData.MESSAGE);
        Intrinsics.checkNotNullParameter(exception, "exception");
    }
}