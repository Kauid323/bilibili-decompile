package kotlinx.io;

import com.google.common.util.concurrent.Striped$SmallLazyStriped$;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: SegmentPool.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\tH\u0007J\b\u0010\u0018\u001a\u00020\tH\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007¨\u0006$"}, d2 = {"Lkotlinx/io/SegmentPool;", "", "<init>", "()V", "MAX_SIZE", "", "getMAX_SIZE", "()I", "LOCK", "Lkotlinx/io/Segment;", "HASH_BUCKET_COUNT", "getHASH_BUCKET_COUNT$kotlinx_io_core", "HASH_BUCKET_COUNT_L2", "DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE", "", "SECOND_LEVEL_POOL_TOTAL_SIZE", "getSECOND_LEVEL_POOL_TOTAL_SIZE$kotlinx_io_core", "SECOND_LEVEL_POOL_BUCKET_SIZE", "hashBuckets", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "hashBucketsL2", "byteCount", "getByteCount", "take", "takeL2", "recycle", "", "segment", "recycleL2", "tracker", "Lkotlinx/io/SegmentCopyTracker;", "l1BucketId", "l2BucketId", "bucketId", "mask", "", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SegmentPool {
    private static final String DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE;
    private static final int SECOND_LEVEL_POOL_BUCKET_SIZE;
    private static final int SECOND_LEVEL_POOL_TOTAL_SIZE;
    private static final AtomicReferenceArray<Segment> hashBuckets;
    private static final AtomicReferenceArray<Segment> hashBucketsL2;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;
    private static final Segment LOCK = Segment.Companion.new$kotlinx_io_core(new byte[0], 0, 0, null, false);
    private static final int HASH_BUCKET_COUNT = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
    private static final int HASH_BUCKET_COUNT_L2 = RangesKt.coerceAtLeast(HASH_BUCKET_COUNT / 2, 1);

    private SegmentPool() {
    }

    static {
        DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE = Intrinsics.areEqual(System.getProperty("java.vm.name"), "Dalvik") ? "0" : "4194304";
        String property = System.getProperty("kotlinx.io.pool.size.bytes", DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE);
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        Integer intOrNull = StringsKt.toIntOrNull(property);
        SECOND_LEVEL_POOL_TOTAL_SIZE = intOrNull != null ? RangesKt.coerceAtLeast(intOrNull.intValue(), 0) : 0;
        SECOND_LEVEL_POOL_BUCKET_SIZE = RangesKt.coerceAtLeast(SECOND_LEVEL_POOL_TOTAL_SIZE / HASH_BUCKET_COUNT_L2, 8192);
        hashBuckets = new AtomicReferenceArray<>(HASH_BUCKET_COUNT);
        hashBucketsL2 = new AtomicReferenceArray<>(HASH_BUCKET_COUNT_L2);
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public final int getHASH_BUCKET_COUNT$kotlinx_io_core() {
        return HASH_BUCKET_COUNT;
    }

    public final int getSECOND_LEVEL_POOL_TOTAL_SIZE$kotlinx_io_core() {
        return SECOND_LEVEL_POOL_TOTAL_SIZE;
    }

    public final int getByteCount() {
        Segment first = hashBuckets.get(l1BucketId());
        if (first == null) {
            return 0;
        }
        return first.getLimit();
    }

    @JvmStatic
    public static final Segment take() {
        Segment first;
        AtomicReferenceArray buckets = hashBuckets;
        int bucketId = INSTANCE.l1BucketId();
        do {
            first = buckets.getAndSet(bucketId, LOCK);
        } while (Intrinsics.areEqual(first, LOCK));
        if (first == null) {
            buckets.set(bucketId, null);
            if (SECOND_LEVEL_POOL_TOTAL_SIZE > 0) {
                return takeL2();
            }
            return Segment.Companion.new$kotlinx_io_core();
        }
        buckets.set(bucketId, first.getNext());
        first.setNext(null);
        first.setLimit(0);
        return first;
    }

    @JvmStatic
    private static final Segment takeL2() {
        AtomicReferenceArray buckets = hashBucketsL2;
        int bucket = INSTANCE.l2BucketId();
        int attempts = 0;
        while (true) {
            Segment first = buckets.getAndSet(bucket, LOCK);
            if (!Intrinsics.areEqual(first, LOCK)) {
                if (first == null) {
                    buckets.set(bucket, null);
                    if (attempts < HASH_BUCKET_COUNT_L2) {
                        bucket = (bucket + 1) & (HASH_BUCKET_COUNT_L2 - 1);
                        attempts++;
                    } else {
                        return Segment.Companion.new$kotlinx_io_core();
                    }
                } else {
                    buckets.set(bucket, first.getNext());
                    first.setNext(null);
                    first.setLimit(0);
                    return first;
                }
            }
        }
    }

    @JvmStatic
    public static final void recycle(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (!(segment.getNext() == null && segment.getPrev() == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        SegmentCopyTracker copyTracker$kotlinx_io_core = segment.getCopyTracker$kotlinx_io_core();
        if (copyTracker$kotlinx_io_core != null && copyTracker$kotlinx_io_core.removeCopy()) {
            return;
        }
        AtomicReferenceArray buckets = hashBuckets;
        int bucketId = INSTANCE.l1BucketId();
        segment.setPos(0);
        segment.owner = true;
        while (true) {
            Segment first = buckets.get(bucketId);
            if (first != LOCK) {
                int firstLimit = first != null ? first.getLimit() : 0;
                if (firstLimit >= MAX_SIZE) {
                    if (SECOND_LEVEL_POOL_TOTAL_SIZE > 0) {
                        recycleL2(segment);
                        return;
                    }
                    return;
                }
                segment.setNext(first);
                segment.setLimit(firstLimit + 8192);
                if (Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(buckets, bucketId, first, segment)) {
                    return;
                }
            }
        }
    }

    @JvmStatic
    private static final void recycleL2(Segment segment) {
        segment.setPos(0);
        segment.owner = true;
        int bucket = INSTANCE.l2BucketId();
        AtomicReferenceArray buckets = hashBucketsL2;
        int attempts = 0;
        while (true) {
            Segment first = buckets.get(bucket);
            if (first != LOCK) {
                int firstLimit = first != null ? first.getLimit() : 0;
                if (firstLimit + 8192 > SECOND_LEVEL_POOL_BUCKET_SIZE) {
                    if (attempts < HASH_BUCKET_COUNT_L2) {
                        attempts++;
                        bucket = (bucket + 1) & (HASH_BUCKET_COUNT_L2 - 1);
                    } else {
                        return;
                    }
                } else {
                    segment.setNext(first);
                    segment.setLimit(firstLimit + 8192);
                    if (Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(buckets, bucket, first, segment)) {
                        return;
                    }
                }
            }
        }
    }

    @JvmStatic
    public static final SegmentCopyTracker tracker() {
        return new RefCountingCopyTracker();
    }

    private final int l1BucketId() {
        return bucketId(HASH_BUCKET_COUNT - 1);
    }

    private final int l2BucketId() {
        return bucketId(HASH_BUCKET_COUNT_L2 - 1);
    }

    private final int bucketId(long mask) {
        return (int) (Thread.currentThread().getId() & mask);
    }
}