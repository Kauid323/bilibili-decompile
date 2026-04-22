package kntr.app.cheese.space.api;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PageData.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lkntr/app/cheese/space/api/SortModel;", RoomRecommendViewModel.EMPTY_CURSOR, "sort_text", RoomRecommendViewModel.EMPTY_CURSOR, "sort_id", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSort_text", "()Ljava/lang/String;", "getSort_id", "()I", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$space_debug", "$serializer", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SortModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int sort_id;
    private final String sort_text;

    public SortModel() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SortModel copy$default(SortModel sortModel, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sortModel.sort_text;
        }
        if ((i2 & 2) != 0) {
            i = sortModel.sort_id;
        }
        return sortModel.copy(str, i);
    }

    public final String component1() {
        return this.sort_text;
    }

    public final int component2() {
        return this.sort_id;
    }

    public final SortModel copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "sort_text");
        return new SortModel(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SortModel) {
            SortModel sortModel = (SortModel) obj;
            return Intrinsics.areEqual(this.sort_text, sortModel.sort_text) && this.sort_id == sortModel.sort_id;
        }
        return false;
    }

    public int hashCode() {
        return (this.sort_text.hashCode() * 31) + this.sort_id;
    }

    public String toString() {
        String str = this.sort_text;
        return "SortModel(sort_text=" + str + ", sort_id=" + this.sort_id + ")";
    }

    /* compiled from: PageData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/api/SortModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/cheese/space/api/SortModel;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SortModel> serializer() {
            return SortModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SortModel(int seen0, String sort_text, int sort_id, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.sort_text = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.sort_text = sort_text;
        }
        if ((seen0 & 2) == 0) {
            this.sort_id = 0;
        } else {
            this.sort_id = sort_id;
        }
    }

    public SortModel(String sort_text, int sort_id) {
        Intrinsics.checkNotNullParameter(sort_text, "sort_text");
        this.sort_text = sort_text;
        this.sort_id = sort_id;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$space_debug(SortModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.sort_text, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.sort_text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sort_id != 0) {
            output.encodeIntElement(serialDesc, 1, self.sort_id);
        }
    }

    public /* synthetic */ SortModel(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getSort_text() {
        return this.sort_text;
    }

    public final int getSort_id() {
        return this.sort_id;
    }
}