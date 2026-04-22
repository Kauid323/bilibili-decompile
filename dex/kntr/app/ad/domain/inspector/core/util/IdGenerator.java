package kntr.app.ad.domain.inspector.core.util;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.datetime.Clock;

/* compiled from: IdGenerator.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/inspector/core/util/IdGenerator;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "counter", "Lkotlinx/atomicfu/AtomicInt;", "generateId", RoomRecommendViewModel.EMPTY_CURSOR, "prefix", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IdGenerator {
    public static final IdGenerator INSTANCE = new IdGenerator();
    private static final AtomicInt counter = AtomicFU.atomic(0);
    public static final int $stable = 8;

    private IdGenerator() {
    }

    public static /* synthetic */ String generateId$default(IdGenerator idGenerator, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return idGenerator.generateId(str);
    }

    public final String generateId(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        long timestamp = Clock.System.INSTANCE.now().toEpochMilliseconds();
        return prefix + timestamp + "-" + counter.incrementAndGet();
    }
}