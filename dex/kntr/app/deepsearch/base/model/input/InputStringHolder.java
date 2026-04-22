package kntr.app.deepsearch.base.model.input;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: InputState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lkntr/app/deepsearch/base/model/input/InputStringHolder;", RoomRecommendViewModel.EMPTY_CURSOR, "input", RoomRecommendViewModel.EMPTY_CURSOR, "timestamp", "Lkotlinx/datetime/Instant;", "version", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Lkotlinx/datetime/Instant;J)V", "getInput$annotations", "()V", "getInput", "()Ljava/lang/String;", "getTimestamp", "()Lkotlinx/datetime/Instant;", "getVersion", "()J", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InputStringHolder {
    private final String input;
    private final Instant timestamp;
    private final long version;

    public static /* synthetic */ InputStringHolder copy$default(InputStringHolder inputStringHolder, String str, Instant instant, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inputStringHolder.input;
        }
        if ((i & 2) != 0) {
            instant = inputStringHolder.timestamp;
        }
        if ((i & 4) != 0) {
            j2 = inputStringHolder.version;
        }
        return inputStringHolder.copy(str, instant, j2);
    }

    public static /* synthetic */ void getInput$annotations() {
    }

    public final String component1() {
        return this.input;
    }

    public final Instant component2() {
        return this.timestamp;
    }

    public final long component3() {
        return this.version;
    }

    public final InputStringHolder copy(String str, Instant instant, long j2) {
        Intrinsics.checkNotNullParameter(str, "input");
        Intrinsics.checkNotNullParameter(instant, "timestamp");
        return new InputStringHolder(str, instant, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InputStringHolder) {
            InputStringHolder inputStringHolder = (InputStringHolder) obj;
            return Intrinsics.areEqual(this.input, inputStringHolder.input) && Intrinsics.areEqual(this.timestamp, inputStringHolder.timestamp) && this.version == inputStringHolder.version;
        }
        return false;
    }

    public int hashCode() {
        return (((this.input.hashCode() * 31) + this.timestamp.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version);
    }

    public String toString() {
        String str = this.input;
        Instant instant = this.timestamp;
        return "InputStringHolder(input=" + str + ", timestamp=" + instant + ", version=" + this.version + ")";
    }

    public InputStringHolder(String input, Instant timestamp, long version) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.input = input;
        this.timestamp = timestamp;
        this.version = version;
    }

    public /* synthetic */ InputStringHolder(String str, Instant instant, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Clock.System.INSTANCE.now() : instant, (i & 4) != 0 ? 0L : j2);
    }

    public final String getInput() {
        return this.input;
    }

    public final Instant getTimestamp() {
        return this.timestamp;
    }

    public final long getVersion() {
        return this.version;
    }
}