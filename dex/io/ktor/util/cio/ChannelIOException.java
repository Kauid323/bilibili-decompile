package io.ktor.util.cio;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Channels.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/cio/ChannelIOException;", "Ljava/io/IOException;", "Lkotlinx/io/IOException;", "", CrashHianalyticsData.MESSAGE, "", "exception", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ChannelIOException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelIOException(String message, Throwable exception) {
        super(message, exception);
        Intrinsics.checkNotNullParameter(message, CrashHianalyticsData.MESSAGE);
        Intrinsics.checkNotNullParameter(exception, "exception");
    }
}