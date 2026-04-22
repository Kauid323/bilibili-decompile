package io.ktor.http.content;

import io.ktor.util.date.DateJvmKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VersionsJvm.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/util/Date;", "lastModified", "Lio/ktor/http/content/LastModifiedVersion;", "LastModifiedVersion", "(Ljava/util/Date;)Lio/ktor/http/content/LastModifiedVersion;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VersionsJvmKt {
    public static final LastModifiedVersion LastModifiedVersion(Date lastModified) {
        Intrinsics.checkNotNullParameter(lastModified, "lastModified");
        return new LastModifiedVersion(DateJvmKt.GMTDate(Long.valueOf(lastModified.getTime())));
    }
}