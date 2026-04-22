package shark;

import kotlin.Metadata;
import okio.BufferedSource;

/* compiled from: StreamingSourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lshark/StreamingSourceProvider;", "", "openStreamingSource", "Lokio/BufferedSource;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public interface StreamingSourceProvider {
    BufferedSource openStreamingSource();
}