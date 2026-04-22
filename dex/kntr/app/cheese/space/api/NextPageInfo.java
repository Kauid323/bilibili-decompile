package kntr.app.cheese.space.api;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PageData.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lkntr/app/cheese/space/api/NextPageInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "next", RoomRecommendViewModel.EMPTY_CURSOR, "num", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNext", "()Z", "getNum", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$space_debug", "$serializer", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class NextPageInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final boolean next;
    private final int num;

    public NextPageInfo() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NextPageInfo copy$default(NextPageInfo nextPageInfo, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = nextPageInfo.next;
        }
        if ((i2 & 2) != 0) {
            i = nextPageInfo.num;
        }
        return nextPageInfo.copy(z, i);
    }

    public final boolean component1() {
        return this.next;
    }

    public final int component2() {
        return this.num;
    }

    public final NextPageInfo copy(boolean z, int i) {
        return new NextPageInfo(z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NextPageInfo) {
            NextPageInfo nextPageInfo = (NextPageInfo) obj;
            return this.next == nextPageInfo.next && this.num == nextPageInfo.num;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.next) * 31) + this.num;
    }

    public String toString() {
        boolean z = this.next;
        return "NextPageInfo(next=" + z + ", num=" + this.num + ")";
    }

    /* compiled from: PageData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/api/NextPageInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/cheese/space/api/NextPageInfo;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<NextPageInfo> serializer() {
            return NextPageInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NextPageInfo(int seen0, boolean next, int num, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.next = false;
        } else {
            this.next = next;
        }
        if ((seen0 & 2) == 0) {
            this.num = 0;
        } else {
            this.num = num;
        }
    }

    public NextPageInfo(boolean next, int num) {
        this.next = next;
        this.num = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$space_debug(NextPageInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.next) {
            output.encodeBooleanElement(serialDesc, 0, self.next);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.num != 0) {
            output.encodeIntElement(serialDesc, 1, self.num);
        }
    }

    public /* synthetic */ NextPageInfo(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }

    public final boolean getNext() {
        return this.next;
    }

    public final int getNum() {
        return this.num;
    }
}