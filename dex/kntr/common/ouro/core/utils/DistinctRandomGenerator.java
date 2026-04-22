package kntr.common.ouro.core.utils;

import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: DistinctRandomGenerator.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/utils/DistinctRandomGenerator;", "", "min", "", "max", "<init>", "(II)V", "usedNumbers", "", "generate", "", "prefix", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DistinctRandomGenerator {
    private final int max;
    private final int min;
    private final Set<Integer> usedNumbers;

    public DistinctRandomGenerator() {
        this(0, 0, 3, null);
    }

    public DistinctRandomGenerator(int min, int max) {
        this.min = min;
        this.max = max;
        this.usedNumbers = new LinkedHashSet();
    }

    public /* synthetic */ DistinctRandomGenerator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 100000 : i, (i3 & 2) != 0 ? 999999 : i2);
    }

    public static /* synthetic */ String generate$default(DistinctRandomGenerator distinctRandomGenerator, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "combine";
        }
        return distinctRandomGenerator.generate(str);
    }

    public final String generate(String prefix) {
        int number;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (this.usedNumbers.size() >= (this.max - this.min) + 1) {
            int i = this.min;
            throw new IllegalStateException("All numbers in range [" + i + ", " + this.max + "] have been used");
        }
        do {
            number = Random.Default.nextInt(this.min, this.max + 1);
        } while (this.usedNumbers.contains(Integer.valueOf(number)));
        this.usedNumbers.add(Integer.valueOf(number));
        return prefix + "_" + number;
    }
}