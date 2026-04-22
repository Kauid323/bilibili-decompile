package shark.internal.friendly;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapGraph;
import shark.internal.AndroidNativeSizeMapper;

/* compiled from: Friendly.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0080\b¨\u0006\u0005"}, d2 = {"mapNativeSizes", "", "", "", "Lshark/HeapGraph;", "shark-android"}, k = 2, mv = {1, 4, 1})
/* renamed from: shark.internal.friendly.shark-android_Friendly  reason: invalid class name */
public final class sharkandroid_Friendly {
    public static final Map<Long, Integer> mapNativeSizes(HeapGraph $this$mapNativeSizes) {
        Intrinsics.checkParameterIsNotNull($this$mapNativeSizes, "$this$mapNativeSizes");
        return AndroidNativeSizeMapper.Companion.mapNativeSizes($this$mapNativeSizes);
    }
}