package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: Multipart.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/http/content/MultiPartData;", "", "Lio/ktor/http/content/PartData;", "readPart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Empty", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MultiPartData {
    Object readPart(Continuation<? super PartData> continuation);

    /* compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/content/MultiPartData$Empty;", "Lio/ktor/http/content/MultiPartData;", "<init>", "()V", "Lio/ktor/http/content/PartData;", "readPart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Empty implements MultiPartData {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // io.ktor.http.content.MultiPartData
        public Object readPart(Continuation<? super PartData> continuation) {
            return null;
        }
    }
}