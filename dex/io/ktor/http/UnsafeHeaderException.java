package io.ktor.http;

import com.tencent.smtt.sdk.TbsVideoCacheTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpHeaders.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/UnsafeHeaderException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "<init>", "(Ljava/lang/String;)V", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsafeHeaderException extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsafeHeaderException(String header) {
        super("Header(s) " + header + " are controlled by the engine and cannot be set explicitly");
        Intrinsics.checkNotNullParameter(header, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
    }
}