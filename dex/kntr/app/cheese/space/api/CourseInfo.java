package kntr.app.cheese.space.api;

import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lkntr/app/cheese/space/api/CourseInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "season_info", "Lkntr/app/cheese/space/api/SeasonInfo;", "product_info", "Lkntr/app/cheese/space/api/ProductInfo;", "<init>", "(Lkntr/app/cheese/space/api/SeasonInfo;Lkntr/app/cheese/space/api/ProductInfo;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/cheese/space/api/SeasonInfo;Lkntr/app/cheese/space/api/ProductInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSeason_info", "()Lkntr/app/cheese/space/api/SeasonInfo;", "getProduct_info", "()Lkntr/app/cheese/space/api/ProductInfo;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$space_debug", "$serializer", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class CourseInfo {
    private final ProductInfo product_info;
    private final SeasonInfo season_info;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CourseInfo() {
        this((SeasonInfo) null, (ProductInfo) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CourseInfo copy$default(CourseInfo courseInfo, SeasonInfo seasonInfo, ProductInfo productInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            seasonInfo = courseInfo.season_info;
        }
        if ((i & 2) != 0) {
            productInfo = courseInfo.product_info;
        }
        return courseInfo.copy(seasonInfo, productInfo);
    }

    public final SeasonInfo component1() {
        return this.season_info;
    }

    public final ProductInfo component2() {
        return this.product_info;
    }

    public final CourseInfo copy(SeasonInfo seasonInfo, ProductInfo productInfo) {
        Intrinsics.checkNotNullParameter(seasonInfo, "season_info");
        Intrinsics.checkNotNullParameter(productInfo, "product_info");
        return new CourseInfo(seasonInfo, productInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CourseInfo) {
            CourseInfo courseInfo = (CourseInfo) obj;
            return Intrinsics.areEqual(this.season_info, courseInfo.season_info) && Intrinsics.areEqual(this.product_info, courseInfo.product_info);
        }
        return false;
    }

    public int hashCode() {
        return (this.season_info.hashCode() * 31) + this.product_info.hashCode();
    }

    public String toString() {
        SeasonInfo seasonInfo = this.season_info;
        return "CourseInfo(season_info=" + seasonInfo + ", product_info=" + this.product_info + ")";
    }

    /* compiled from: PageData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/api/CourseInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/cheese/space/api/CourseInfo;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CourseInfo> serializer() {
            return CourseInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CourseInfo(int seen0, SeasonInfo season_info, ProductInfo product_info, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.season_info = new SeasonInfo((List) null, (List) null, (String) null, 0, (List) null, 31, (DefaultConstructorMarker) null);
        } else {
            this.season_info = season_info;
        }
        if ((seen0 & 2) == 0) {
            this.product_info = new ProductInfo((String) null, (List) null, 0, (JumpModel) null, (Map) null, 31, (DefaultConstructorMarker) null);
        } else {
            this.product_info = product_info;
        }
    }

    public CourseInfo(SeasonInfo season_info, ProductInfo product_info) {
        Intrinsics.checkNotNullParameter(season_info, "season_info");
        Intrinsics.checkNotNullParameter(product_info, "product_info");
        this.season_info = season_info;
        this.product_info = product_info;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$space_debug(CourseInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.season_info, new SeasonInfo((List) null, (List) null, (String) null, 0, (List) null, 31, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 0, SeasonInfo$$serializer.INSTANCE, self.season_info);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.product_info, new ProductInfo((String) null, (List) null, 0, (JumpModel) null, (Map) null, 31, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 1, ProductInfo$$serializer.INSTANCE, self.product_info);
        }
    }

    public /* synthetic */ CourseInfo(SeasonInfo seasonInfo, ProductInfo productInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SeasonInfo((List) null, (List) null, (String) null, 0, (List) null, 31, (DefaultConstructorMarker) null) : seasonInfo, (i & 2) != 0 ? new ProductInfo((String) null, (List) null, 0, (JumpModel) null, (Map) null, 31, (DefaultConstructorMarker) null) : productInfo);
    }

    public final SeasonInfo getSeason_info() {
        return this.season_info;
    }

    public final ProductInfo getProduct_info() {
        return this.product_info;
    }
}