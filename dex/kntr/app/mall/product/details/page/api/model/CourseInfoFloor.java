package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.CourseInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CourseInfoFloor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0003()*B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "courseFloor", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getCourseFloor", "()Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CourseFloor", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CourseInfoFloor implements FloorModel {
    private final String bgImgUrl;
    private final CourseFloor courseFloor;
    private final String floorIcon;
    private final String floorKey;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CourseInfoFloor() {
        this((String) null, (String) null, (String) null, (CourseFloor) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CourseInfoFloor copy$default(CourseInfoFloor courseInfoFloor, String str, String str2, String str3, CourseFloor courseFloor, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courseInfoFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = courseInfoFloor.floorIcon;
        }
        if ((i & 4) != 0) {
            str3 = courseInfoFloor.bgImgUrl;
        }
        if ((i & 8) != 0) {
            courseFloor = courseInfoFloor.courseFloor;
        }
        return courseInfoFloor.copy(str, str2, str3, courseFloor);
    }

    public final String component1() {
        return this.floorKey;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final CourseFloor component4() {
        return this.courseFloor;
    }

    public final CourseInfoFloor copy(String str, String str2, String str3, CourseFloor courseFloor) {
        return new CourseInfoFloor(str, str2, str3, courseFloor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CourseInfoFloor) {
            CourseInfoFloor courseInfoFloor = (CourseInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, courseInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, courseInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, courseInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.courseFloor, courseInfoFloor.courseFloor);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.courseFloor != null ? this.courseFloor.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        return "CourseInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", courseFloor=" + this.courseFloor + ")";
    }

    /* compiled from: CourseInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CourseInfoFloor> serializer() {
            return CourseInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CourseInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, CourseFloor courseFloor, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.floorKey = null;
        } else {
            this.floorKey = floorKey;
        }
        if ((seen0 & 2) == 0) {
            this.floorIcon = null;
        } else {
            this.floorIcon = floorIcon;
        }
        if ((seen0 & 4) == 0) {
            this.bgImgUrl = null;
        } else {
            this.bgImgUrl = bgImgUrl;
        }
        if ((seen0 & 8) == 0) {
            this.courseFloor = null;
        } else {
            this.courseFloor = courseFloor;
        }
    }

    public CourseInfoFloor(String floorKey, String floorIcon, String bgImgUrl, CourseFloor courseFloor) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.courseFloor = courseFloor;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CourseInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.courseFloor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, CourseInfoFloor$CourseFloor$$serializer.INSTANCE, self.courseFloor);
        }
    }

    public /* synthetic */ CourseInfoFloor(String str, String str2, String str3, CourseFloor courseFloor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : courseFloor);
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorKey() {
        return this.floorKey;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorIcon() {
        return this.floorIcon;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getBgImgUrl() {
        return this.bgImgUrl;
    }

    /* compiled from: CourseInfoFloor.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0004PQRSB»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018B³\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010>\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&JÂ\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020\u000e2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u000bHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001J%\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b-\u0010&R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b1\u0010 R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b3\u0010&¨\u0006T"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;", "", "banPageDesc", "", "courseId", "", "courseList", "", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$CourseItem;", "courseName", "courseStatus", "", "customerServiceLink", "hasBought", "", "itemId", "learnedSectionCount", "lessonId", "locationInfo", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;", "mid", "previewSectionIds", "sectionCount", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBanPageDesc", "()Ljava/lang/String;", "getCourseId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCourseList", "()Ljava/util/List;", "getCourseName", "getCourseStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCustomerServiceLink", "getHasBought", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemId", "getLearnedSectionCount", "getLessonId", "getLocationInfo", "()Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;", "getMid", "getPreviewSectionIds", "getSectionCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CourseItem", "LocationInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CourseFloor {
        private final String banPageDesc;
        private final Long courseId;
        private final List<CourseItem> courseList;
        private final String courseName;
        private final Integer courseStatus;
        private final String customerServiceLink;
        private final Boolean hasBought;
        private final Long itemId;
        private final Integer learnedSectionCount;
        private final Long lessonId;
        private final LocationInfo locationInfo;
        private final Long mid;
        private final List<Long> previewSectionIds;
        private final Integer sectionCount;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CourseInfoFloor$CourseFloor$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CourseInfoFloor.CourseFloor._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CourseInfoFloor$CourseFloor$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = CourseInfoFloor.CourseFloor._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null};

        public CourseFloor() {
            this((String) null, (Long) null, (List) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Long) null, (Integer) null, (Long) null, (LocationInfo) null, (Long) null, (List) null, (Integer) null, 16383, (DefaultConstructorMarker) null);
        }

        public final String component1() {
            return this.banPageDesc;
        }

        public final Long component10() {
            return this.lessonId;
        }

        public final LocationInfo component11() {
            return this.locationInfo;
        }

        public final Long component12() {
            return this.mid;
        }

        public final List<Long> component13() {
            return this.previewSectionIds;
        }

        public final Integer component14() {
            return this.sectionCount;
        }

        public final Long component2() {
            return this.courseId;
        }

        public final List<CourseItem> component3() {
            return this.courseList;
        }

        public final String component4() {
            return this.courseName;
        }

        public final Integer component5() {
            return this.courseStatus;
        }

        public final String component6() {
            return this.customerServiceLink;
        }

        public final Boolean component7() {
            return this.hasBought;
        }

        public final Long component8() {
            return this.itemId;
        }

        public final Integer component9() {
            return this.learnedSectionCount;
        }

        public final CourseFloor copy(String str, Long l, List<CourseItem> list, String str2, Integer num, String str3, Boolean bool, Long l2, Integer num2, Long l3, LocationInfo locationInfo, Long l4, List<Long> list2, Integer num3) {
            return new CourseFloor(str, l, list, str2, num, str3, bool, l2, num2, l3, locationInfo, l4, list2, num3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CourseFloor) {
                CourseFloor courseFloor = (CourseFloor) obj;
                return Intrinsics.areEqual(this.banPageDesc, courseFloor.banPageDesc) && Intrinsics.areEqual(this.courseId, courseFloor.courseId) && Intrinsics.areEqual(this.courseList, courseFloor.courseList) && Intrinsics.areEqual(this.courseName, courseFloor.courseName) && Intrinsics.areEqual(this.courseStatus, courseFloor.courseStatus) && Intrinsics.areEqual(this.customerServiceLink, courseFloor.customerServiceLink) && Intrinsics.areEqual(this.hasBought, courseFloor.hasBought) && Intrinsics.areEqual(this.itemId, courseFloor.itemId) && Intrinsics.areEqual(this.learnedSectionCount, courseFloor.learnedSectionCount) && Intrinsics.areEqual(this.lessonId, courseFloor.lessonId) && Intrinsics.areEqual(this.locationInfo, courseFloor.locationInfo) && Intrinsics.areEqual(this.mid, courseFloor.mid) && Intrinsics.areEqual(this.previewSectionIds, courseFloor.previewSectionIds) && Intrinsics.areEqual(this.sectionCount, courseFloor.sectionCount);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((this.banPageDesc == null ? 0 : this.banPageDesc.hashCode()) * 31) + (this.courseId == null ? 0 : this.courseId.hashCode())) * 31) + (this.courseList == null ? 0 : this.courseList.hashCode())) * 31) + (this.courseName == null ? 0 : this.courseName.hashCode())) * 31) + (this.courseStatus == null ? 0 : this.courseStatus.hashCode())) * 31) + (this.customerServiceLink == null ? 0 : this.customerServiceLink.hashCode())) * 31) + (this.hasBought == null ? 0 : this.hasBought.hashCode())) * 31) + (this.itemId == null ? 0 : this.itemId.hashCode())) * 31) + (this.learnedSectionCount == null ? 0 : this.learnedSectionCount.hashCode())) * 31) + (this.lessonId == null ? 0 : this.lessonId.hashCode())) * 31) + (this.locationInfo == null ? 0 : this.locationInfo.hashCode())) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.previewSectionIds == null ? 0 : this.previewSectionIds.hashCode())) * 31) + (this.sectionCount != null ? this.sectionCount.hashCode() : 0);
        }

        public String toString() {
            String str = this.banPageDesc;
            Long l = this.courseId;
            List<CourseItem> list = this.courseList;
            String str2 = this.courseName;
            Integer num = this.courseStatus;
            String str3 = this.customerServiceLink;
            Boolean bool = this.hasBought;
            Long l2 = this.itemId;
            Integer num2 = this.learnedSectionCount;
            Long l3 = this.lessonId;
            LocationInfo locationInfo = this.locationInfo;
            Long l4 = this.mid;
            List<Long> list2 = this.previewSectionIds;
            return "CourseFloor(banPageDesc=" + str + ", courseId=" + l + ", courseList=" + list + ", courseName=" + str2 + ", courseStatus=" + num + ", customerServiceLink=" + str3 + ", hasBought=" + bool + ", itemId=" + l2 + ", learnedSectionCount=" + num2 + ", lessonId=" + l3 + ", locationInfo=" + locationInfo + ", mid=" + l4 + ", previewSectionIds=" + list2 + ", sectionCount=" + this.sectionCount + ")";
        }

        /* compiled from: CourseInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CourseFloor> serializer() {
                return CourseInfoFloor$CourseFloor$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CourseFloor(int seen0, String banPageDesc, Long courseId, List courseList, String courseName, Integer courseStatus, String customerServiceLink, Boolean hasBought, Long itemId, Integer learnedSectionCount, Long lessonId, LocationInfo locationInfo, Long mid, List previewSectionIds, Integer sectionCount, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.banPageDesc = null;
            } else {
                this.banPageDesc = banPageDesc;
            }
            if ((seen0 & 2) == 0) {
                this.courseId = null;
            } else {
                this.courseId = courseId;
            }
            if ((seen0 & 4) == 0) {
                this.courseList = null;
            } else {
                this.courseList = courseList;
            }
            if ((seen0 & 8) == 0) {
                this.courseName = null;
            } else {
                this.courseName = courseName;
            }
            if ((seen0 & 16) == 0) {
                this.courseStatus = null;
            } else {
                this.courseStatus = courseStatus;
            }
            if ((seen0 & 32) == 0) {
                this.customerServiceLink = null;
            } else {
                this.customerServiceLink = customerServiceLink;
            }
            if ((seen0 & 64) == 0) {
                this.hasBought = null;
            } else {
                this.hasBought = hasBought;
            }
            if ((seen0 & 128) == 0) {
                this.itemId = null;
            } else {
                this.itemId = itemId;
            }
            if ((seen0 & 256) == 0) {
                this.learnedSectionCount = null;
            } else {
                this.learnedSectionCount = learnedSectionCount;
            }
            if ((seen0 & 512) == 0) {
                this.lessonId = null;
            } else {
                this.lessonId = lessonId;
            }
            if ((seen0 & 1024) == 0) {
                this.locationInfo = null;
            } else {
                this.locationInfo = locationInfo;
            }
            if ((seen0 & 2048) == 0) {
                this.mid = null;
            } else {
                this.mid = mid;
            }
            if ((seen0 & 4096) == 0) {
                this.previewSectionIds = null;
            } else {
                this.previewSectionIds = previewSectionIds;
            }
            if ((seen0 & 8192) == 0) {
                this.sectionCount = null;
            } else {
                this.sectionCount = sectionCount;
            }
        }

        public CourseFloor(String banPageDesc, Long courseId, List<CourseItem> list, String courseName, Integer courseStatus, String customerServiceLink, Boolean hasBought, Long itemId, Integer learnedSectionCount, Long lessonId, LocationInfo locationInfo, Long mid, List<Long> list2, Integer sectionCount) {
            this.banPageDesc = banPageDesc;
            this.courseId = courseId;
            this.courseList = list;
            this.courseName = courseName;
            this.courseStatus = courseStatus;
            this.customerServiceLink = customerServiceLink;
            this.hasBought = hasBought;
            this.itemId = itemId;
            this.learnedSectionCount = learnedSectionCount;
            this.lessonId = lessonId;
            this.locationInfo = locationInfo;
            this.mid = mid;
            this.previewSectionIds = list2;
            this.sectionCount = sectionCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(CourseInfoFloor$CourseFloor$CourseItem$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(LongSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(CourseFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.banPageDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.banPageDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.courseId != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.courseId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.courseList != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.courseList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.courseName != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.courseName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.courseStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.courseStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.customerServiceLink != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.customerServiceLink);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.hasBought != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.hasBought);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.itemId != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.itemId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.learnedSectionCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.learnedSectionCount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.lessonId != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, LongSerializer.INSTANCE, self.lessonId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.locationInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, CourseInfoFloor$CourseFloor$LocationInfo$$serializer.INSTANCE, self.locationInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.mid != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, LongSerializer.INSTANCE, self.mid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.previewSectionIds != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, lazyArr[12].getValue(), self.previewSectionIds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.sectionCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.sectionCount);
            }
        }

        public /* synthetic */ CourseFloor(String str, Long l, List list, String str2, Integer num, String str3, Boolean bool, Long l2, Integer num2, Long l3, LocationInfo locationInfo, Long l4, List list2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : l2, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : l3, (i & 1024) != 0 ? null : locationInfo, (i & 2048) != 0 ? null : l4, (i & 4096) != 0 ? null : list2, (i & 8192) == 0 ? num3 : null);
        }

        public final String getBanPageDesc() {
            return this.banPageDesc;
        }

        public final Long getCourseId() {
            return this.courseId;
        }

        public final List<CourseItem> getCourseList() {
            return this.courseList;
        }

        public final String getCourseName() {
            return this.courseName;
        }

        public final Integer getCourseStatus() {
            return this.courseStatus;
        }

        public final String getCustomerServiceLink() {
            return this.customerServiceLink;
        }

        public final Boolean getHasBought() {
            return this.hasBought;
        }

        public final Long getItemId() {
            return this.itemId;
        }

        public final Integer getLearnedSectionCount() {
            return this.learnedSectionCount;
        }

        public final Long getLessonId() {
            return this.lessonId;
        }

        public final LocationInfo getLocationInfo() {
            return this.locationInfo;
        }

        public final Long getMid() {
            return this.mid;
        }

        public final List<Long> getPreviewSectionIds() {
            return this.previewSectionIds;
        }

        /* compiled from: CourseInfoFloor.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 R2\u00020\u0001:\u0002QRBÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017B»\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010,JÎ\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0010HÖ\u0001J\t\u0010H\u001a\u00020\bHÖ\u0001J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001¢\u0006\u0002\bPR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b%\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b*\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b/\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010-\u001a\u0004\b2\u0010,¨\u0006S"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$CourseItem;", "", "chapterId", "", "couldPreview", "", "hasWatchRight", "itemUrl", "", "lastWatchTime", "lastWatchTimeDesc", "lessonId", "needReport", "previewDesc", "sectionId", "sectionIndex", "", "sectionName", "videoTime", "videoTimeDesc", "videoUrl", "watchStatus", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getChapterId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCouldPreview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasWatchRight", "getItemUrl", "()Ljava/lang/String;", "getLastWatchTime", "getLastWatchTimeDesc", "getLessonId", "getNeedReport", "getPreviewDesc", "getSectionId", "getSectionIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSectionName", "getVideoTime", "getVideoTimeDesc", "getVideoUrl", "getWatchStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$CourseItem;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class CourseItem {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final Long chapterId;
            private final Boolean couldPreview;
            private final Boolean hasWatchRight;
            private final String itemUrl;
            private final Long lastWatchTime;
            private final String lastWatchTimeDesc;
            private final Long lessonId;
            private final Boolean needReport;
            private final String previewDesc;
            private final Long sectionId;
            private final Integer sectionIndex;
            private final String sectionName;
            private final Long videoTime;
            private final String videoTimeDesc;
            private final String videoUrl;
            private final Integer watchStatus;

            public CourseItem() {
                this((Long) null, (Boolean) null, (Boolean) null, (String) null, (Long) null, (String) null, (Long) null, (Boolean) null, (String) null, (Long) null, (Integer) null, (String) null, (Long) null, (String) null, (String) null, (Integer) null, 65535, (DefaultConstructorMarker) null);
            }

            public final Long component1() {
                return this.chapterId;
            }

            public final Long component10() {
                return this.sectionId;
            }

            public final Integer component11() {
                return this.sectionIndex;
            }

            public final String component12() {
                return this.sectionName;
            }

            public final Long component13() {
                return this.videoTime;
            }

            public final String component14() {
                return this.videoTimeDesc;
            }

            public final String component15() {
                return this.videoUrl;
            }

            public final Integer component16() {
                return this.watchStatus;
            }

            public final Boolean component2() {
                return this.couldPreview;
            }

            public final Boolean component3() {
                return this.hasWatchRight;
            }

            public final String component4() {
                return this.itemUrl;
            }

            public final Long component5() {
                return this.lastWatchTime;
            }

            public final String component6() {
                return this.lastWatchTimeDesc;
            }

            public final Long component7() {
                return this.lessonId;
            }

            public final Boolean component8() {
                return this.needReport;
            }

            public final String component9() {
                return this.previewDesc;
            }

            public final CourseItem copy(Long l, Boolean bool, Boolean bool2, String str, Long l2, String str2, Long l3, Boolean bool3, String str3, Long l4, Integer num, String str4, Long l5, String str5, String str6, Integer num2) {
                return new CourseItem(l, bool, bool2, str, l2, str2, l3, bool3, str3, l4, num, str4, l5, str5, str6, num2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CourseItem) {
                    CourseItem courseItem = (CourseItem) obj;
                    return Intrinsics.areEqual(this.chapterId, courseItem.chapterId) && Intrinsics.areEqual(this.couldPreview, courseItem.couldPreview) && Intrinsics.areEqual(this.hasWatchRight, courseItem.hasWatchRight) && Intrinsics.areEqual(this.itemUrl, courseItem.itemUrl) && Intrinsics.areEqual(this.lastWatchTime, courseItem.lastWatchTime) && Intrinsics.areEqual(this.lastWatchTimeDesc, courseItem.lastWatchTimeDesc) && Intrinsics.areEqual(this.lessonId, courseItem.lessonId) && Intrinsics.areEqual(this.needReport, courseItem.needReport) && Intrinsics.areEqual(this.previewDesc, courseItem.previewDesc) && Intrinsics.areEqual(this.sectionId, courseItem.sectionId) && Intrinsics.areEqual(this.sectionIndex, courseItem.sectionIndex) && Intrinsics.areEqual(this.sectionName, courseItem.sectionName) && Intrinsics.areEqual(this.videoTime, courseItem.videoTime) && Intrinsics.areEqual(this.videoTimeDesc, courseItem.videoTimeDesc) && Intrinsics.areEqual(this.videoUrl, courseItem.videoUrl) && Intrinsics.areEqual(this.watchStatus, courseItem.watchStatus);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((((((((((((((((((((this.chapterId == null ? 0 : this.chapterId.hashCode()) * 31) + (this.couldPreview == null ? 0 : this.couldPreview.hashCode())) * 31) + (this.hasWatchRight == null ? 0 : this.hasWatchRight.hashCode())) * 31) + (this.itemUrl == null ? 0 : this.itemUrl.hashCode())) * 31) + (this.lastWatchTime == null ? 0 : this.lastWatchTime.hashCode())) * 31) + (this.lastWatchTimeDesc == null ? 0 : this.lastWatchTimeDesc.hashCode())) * 31) + (this.lessonId == null ? 0 : this.lessonId.hashCode())) * 31) + (this.needReport == null ? 0 : this.needReport.hashCode())) * 31) + (this.previewDesc == null ? 0 : this.previewDesc.hashCode())) * 31) + (this.sectionId == null ? 0 : this.sectionId.hashCode())) * 31) + (this.sectionIndex == null ? 0 : this.sectionIndex.hashCode())) * 31) + (this.sectionName == null ? 0 : this.sectionName.hashCode())) * 31) + (this.videoTime == null ? 0 : this.videoTime.hashCode())) * 31) + (this.videoTimeDesc == null ? 0 : this.videoTimeDesc.hashCode())) * 31) + (this.videoUrl == null ? 0 : this.videoUrl.hashCode())) * 31) + (this.watchStatus != null ? this.watchStatus.hashCode() : 0);
            }

            public String toString() {
                Long l = this.chapterId;
                Boolean bool = this.couldPreview;
                Boolean bool2 = this.hasWatchRight;
                String str = this.itemUrl;
                Long l2 = this.lastWatchTime;
                String str2 = this.lastWatchTimeDesc;
                Long l3 = this.lessonId;
                Boolean bool3 = this.needReport;
                String str3 = this.previewDesc;
                Long l4 = this.sectionId;
                Integer num = this.sectionIndex;
                String str4 = this.sectionName;
                Long l5 = this.videoTime;
                String str5 = this.videoTimeDesc;
                String str6 = this.videoUrl;
                return "CourseItem(chapterId=" + l + ", couldPreview=" + bool + ", hasWatchRight=" + bool2 + ", itemUrl=" + str + ", lastWatchTime=" + l2 + ", lastWatchTimeDesc=" + str2 + ", lessonId=" + l3 + ", needReport=" + bool3 + ", previewDesc=" + str3 + ", sectionId=" + l4 + ", sectionIndex=" + num + ", sectionName=" + str4 + ", videoTime=" + l5 + ", videoTimeDesc=" + str5 + ", videoUrl=" + str6 + ", watchStatus=" + this.watchStatus + ")";
            }

            /* compiled from: CourseInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$CourseItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$CourseItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<CourseItem> serializer() {
                    return CourseInfoFloor$CourseFloor$CourseItem$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ CourseItem(int seen0, Long chapterId, Boolean couldPreview, Boolean hasWatchRight, String itemUrl, Long lastWatchTime, String lastWatchTimeDesc, Long lessonId, Boolean needReport, String previewDesc, Long sectionId, Integer sectionIndex, String sectionName, Long videoTime, String videoTimeDesc, String videoUrl, Integer watchStatus, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.chapterId = null;
                } else {
                    this.chapterId = chapterId;
                }
                if ((seen0 & 2) == 0) {
                    this.couldPreview = null;
                } else {
                    this.couldPreview = couldPreview;
                }
                if ((seen0 & 4) == 0) {
                    this.hasWatchRight = null;
                } else {
                    this.hasWatchRight = hasWatchRight;
                }
                if ((seen0 & 8) == 0) {
                    this.itemUrl = null;
                } else {
                    this.itemUrl = itemUrl;
                }
                if ((seen0 & 16) == 0) {
                    this.lastWatchTime = null;
                } else {
                    this.lastWatchTime = lastWatchTime;
                }
                if ((seen0 & 32) == 0) {
                    this.lastWatchTimeDesc = null;
                } else {
                    this.lastWatchTimeDesc = lastWatchTimeDesc;
                }
                if ((seen0 & 64) == 0) {
                    this.lessonId = null;
                } else {
                    this.lessonId = lessonId;
                }
                if ((seen0 & 128) == 0) {
                    this.needReport = null;
                } else {
                    this.needReport = needReport;
                }
                if ((seen0 & 256) == 0) {
                    this.previewDesc = null;
                } else {
                    this.previewDesc = previewDesc;
                }
                if ((seen0 & 512) == 0) {
                    this.sectionId = null;
                } else {
                    this.sectionId = sectionId;
                }
                if ((seen0 & 1024) == 0) {
                    this.sectionIndex = null;
                } else {
                    this.sectionIndex = sectionIndex;
                }
                if ((seen0 & 2048) == 0) {
                    this.sectionName = null;
                } else {
                    this.sectionName = sectionName;
                }
                if ((seen0 & 4096) == 0) {
                    this.videoTime = null;
                } else {
                    this.videoTime = videoTime;
                }
                if ((seen0 & 8192) == 0) {
                    this.videoTimeDesc = null;
                } else {
                    this.videoTimeDesc = videoTimeDesc;
                }
                if ((seen0 & 16384) == 0) {
                    this.videoUrl = null;
                } else {
                    this.videoUrl = videoUrl;
                }
                if ((seen0 & 32768) == 0) {
                    this.watchStatus = null;
                } else {
                    this.watchStatus = watchStatus;
                }
            }

            public CourseItem(Long chapterId, Boolean couldPreview, Boolean hasWatchRight, String itemUrl, Long lastWatchTime, String lastWatchTimeDesc, Long lessonId, Boolean needReport, String previewDesc, Long sectionId, Integer sectionIndex, String sectionName, Long videoTime, String videoTimeDesc, String videoUrl, Integer watchStatus) {
                this.chapterId = chapterId;
                this.couldPreview = couldPreview;
                this.hasWatchRight = hasWatchRight;
                this.itemUrl = itemUrl;
                this.lastWatchTime = lastWatchTime;
                this.lastWatchTimeDesc = lastWatchTimeDesc;
                this.lessonId = lessonId;
                this.needReport = needReport;
                this.previewDesc = previewDesc;
                this.sectionId = sectionId;
                this.sectionIndex = sectionIndex;
                this.sectionName = sectionName;
                this.videoTime = videoTime;
                this.videoTimeDesc = videoTimeDesc;
                this.videoUrl = videoUrl;
                this.watchStatus = watchStatus;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(CourseItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.chapterId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.chapterId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.couldPreview != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.couldPreview);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.hasWatchRight != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.hasWatchRight);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.itemUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.itemUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.lastWatchTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.lastWatchTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.lastWatchTimeDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.lastWatchTimeDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.lessonId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.lessonId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.needReport != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.needReport);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.previewDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.previewDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.sectionId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, LongSerializer.INSTANCE, self.sectionId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.sectionIndex != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.sectionIndex);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.sectionName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.sectionName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.videoTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, LongSerializer.INSTANCE, self.videoTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.videoTimeDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.videoTimeDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.videoUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.videoUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.watchStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.watchStatus);
                }
            }

            public /* synthetic */ CourseItem(Long l, Boolean bool, Boolean bool2, String str, Long l2, String str2, Long l3, Boolean bool3, String str3, Long l4, Integer num, String str4, Long l5, String str5, String str6, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : l3, (i & 128) != 0 ? null : bool3, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : l4, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : l5, (i & 8192) != 0 ? null : str5, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : num2);
            }

            public final Long getChapterId() {
                return this.chapterId;
            }

            public final Boolean getCouldPreview() {
                return this.couldPreview;
            }

            public final Boolean getHasWatchRight() {
                return this.hasWatchRight;
            }

            public final String getItemUrl() {
                return this.itemUrl;
            }

            public final Long getLastWatchTime() {
                return this.lastWatchTime;
            }

            public final String getLastWatchTimeDesc() {
                return this.lastWatchTimeDesc;
            }

            public final Long getLessonId() {
                return this.lessonId;
            }

            public final Boolean getNeedReport() {
                return this.needReport;
            }

            public final String getPreviewDesc() {
                return this.previewDesc;
            }

            public final Long getSectionId() {
                return this.sectionId;
            }

            public final Integer getSectionIndex() {
                return this.sectionIndex;
            }

            public final String getSectionName() {
                return this.sectionName;
            }

            public final Long getVideoTime() {
                return this.videoTime;
            }

            public final String getVideoTimeDesc() {
                return this.videoTimeDesc;
            }

            public final String getVideoUrl() {
                return this.videoUrl;
            }

            public final Integer getWatchStatus() {
                return this.watchStatus;
            }
        }

        public final Integer getSectionCount() {
            return this.sectionCount;
        }

        /* compiled from: CourseInfoFloor.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010B\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0086\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0012HÖ\u0001J\t\u00104\u001a\u00020\rHÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b \u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0017¨\u0006?"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;", "", "chapterId", "", "couldPreview", "", "courseId", "hasWatchRight", "itemId", "lastWatchTime", "lessonId", "sectionId", "videoUrl", "", "watchProcess", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getChapterId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCouldPreview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCourseId", "getHasWatchRight", "getItemId", "getLastWatchTime", "getLessonId", "getSectionId", "getVideoUrl", "()Ljava/lang/String;", "getWatchProcess", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class LocationInfo {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final Long chapterId;
            private final Boolean couldPreview;
            private final Long courseId;
            private final Boolean hasWatchRight;
            private final Long itemId;
            private final Long lastWatchTime;
            private final Long lessonId;
            private final Long sectionId;
            private final String videoUrl;
            private final Long watchProcess;

            public LocationInfo() {
                this((Long) null, (Boolean) null, (Long) null, (Boolean) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, (Long) null, 1023, (DefaultConstructorMarker) null);
            }

            public final Long component1() {
                return this.chapterId;
            }

            public final Long component10() {
                return this.watchProcess;
            }

            public final Boolean component2() {
                return this.couldPreview;
            }

            public final Long component3() {
                return this.courseId;
            }

            public final Boolean component4() {
                return this.hasWatchRight;
            }

            public final Long component5() {
                return this.itemId;
            }

            public final Long component6() {
                return this.lastWatchTime;
            }

            public final Long component7() {
                return this.lessonId;
            }

            public final Long component8() {
                return this.sectionId;
            }

            public final String component9() {
                return this.videoUrl;
            }

            public final LocationInfo copy(Long l, Boolean bool, Long l2, Boolean bool2, Long l3, Long l4, Long l5, Long l6, String str, Long l7) {
                return new LocationInfo(l, bool, l2, bool2, l3, l4, l5, l6, str, l7);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LocationInfo) {
                    LocationInfo locationInfo = (LocationInfo) obj;
                    return Intrinsics.areEqual(this.chapterId, locationInfo.chapterId) && Intrinsics.areEqual(this.couldPreview, locationInfo.couldPreview) && Intrinsics.areEqual(this.courseId, locationInfo.courseId) && Intrinsics.areEqual(this.hasWatchRight, locationInfo.hasWatchRight) && Intrinsics.areEqual(this.itemId, locationInfo.itemId) && Intrinsics.areEqual(this.lastWatchTime, locationInfo.lastWatchTime) && Intrinsics.areEqual(this.lessonId, locationInfo.lessonId) && Intrinsics.areEqual(this.sectionId, locationInfo.sectionId) && Intrinsics.areEqual(this.videoUrl, locationInfo.videoUrl) && Intrinsics.areEqual(this.watchProcess, locationInfo.watchProcess);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((((((((this.chapterId == null ? 0 : this.chapterId.hashCode()) * 31) + (this.couldPreview == null ? 0 : this.couldPreview.hashCode())) * 31) + (this.courseId == null ? 0 : this.courseId.hashCode())) * 31) + (this.hasWatchRight == null ? 0 : this.hasWatchRight.hashCode())) * 31) + (this.itemId == null ? 0 : this.itemId.hashCode())) * 31) + (this.lastWatchTime == null ? 0 : this.lastWatchTime.hashCode())) * 31) + (this.lessonId == null ? 0 : this.lessonId.hashCode())) * 31) + (this.sectionId == null ? 0 : this.sectionId.hashCode())) * 31) + (this.videoUrl == null ? 0 : this.videoUrl.hashCode())) * 31) + (this.watchProcess != null ? this.watchProcess.hashCode() : 0);
            }

            public String toString() {
                Long l = this.chapterId;
                Boolean bool = this.couldPreview;
                Long l2 = this.courseId;
                Boolean bool2 = this.hasWatchRight;
                Long l3 = this.itemId;
                Long l4 = this.lastWatchTime;
                Long l5 = this.lessonId;
                Long l6 = this.sectionId;
                String str = this.videoUrl;
                return "LocationInfo(chapterId=" + l + ", couldPreview=" + bool + ", courseId=" + l2 + ", hasWatchRight=" + bool2 + ", itemId=" + l3 + ", lastWatchTime=" + l4 + ", lessonId=" + l5 + ", sectionId=" + l6 + ", videoUrl=" + str + ", watchProcess=" + this.watchProcess + ")";
            }

            /* compiled from: CourseInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor$CourseFloor$LocationInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<LocationInfo> serializer() {
                    return CourseInfoFloor$CourseFloor$LocationInfo$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ LocationInfo(int seen0, Long chapterId, Boolean couldPreview, Long courseId, Boolean hasWatchRight, Long itemId, Long lastWatchTime, Long lessonId, Long sectionId, String videoUrl, Long watchProcess, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.chapterId = null;
                } else {
                    this.chapterId = chapterId;
                }
                if ((seen0 & 2) == 0) {
                    this.couldPreview = null;
                } else {
                    this.couldPreview = couldPreview;
                }
                if ((seen0 & 4) == 0) {
                    this.courseId = null;
                } else {
                    this.courseId = courseId;
                }
                if ((seen0 & 8) == 0) {
                    this.hasWatchRight = null;
                } else {
                    this.hasWatchRight = hasWatchRight;
                }
                if ((seen0 & 16) == 0) {
                    this.itemId = null;
                } else {
                    this.itemId = itemId;
                }
                if ((seen0 & 32) == 0) {
                    this.lastWatchTime = null;
                } else {
                    this.lastWatchTime = lastWatchTime;
                }
                if ((seen0 & 64) == 0) {
                    this.lessonId = null;
                } else {
                    this.lessonId = lessonId;
                }
                if ((seen0 & 128) == 0) {
                    this.sectionId = null;
                } else {
                    this.sectionId = sectionId;
                }
                if ((seen0 & 256) == 0) {
                    this.videoUrl = null;
                } else {
                    this.videoUrl = videoUrl;
                }
                if ((seen0 & 512) == 0) {
                    this.watchProcess = null;
                } else {
                    this.watchProcess = watchProcess;
                }
            }

            public LocationInfo(Long chapterId, Boolean couldPreview, Long courseId, Boolean hasWatchRight, Long itemId, Long lastWatchTime, Long lessonId, Long sectionId, String videoUrl, Long watchProcess) {
                this.chapterId = chapterId;
                this.couldPreview = couldPreview;
                this.courseId = courseId;
                this.hasWatchRight = hasWatchRight;
                this.itemId = itemId;
                this.lastWatchTime = lastWatchTime;
                this.lessonId = lessonId;
                this.sectionId = sectionId;
                this.videoUrl = videoUrl;
                this.watchProcess = watchProcess;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(LocationInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.chapterId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.chapterId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.couldPreview != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.couldPreview);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.courseId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.courseId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.hasWatchRight != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.hasWatchRight);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.itemId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.itemId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.lastWatchTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.lastWatchTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.lessonId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.lessonId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.sectionId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.sectionId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.videoUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.videoUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.watchProcess != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, LongSerializer.INSTANCE, self.watchProcess);
                }
            }

            public /* synthetic */ LocationInfo(Long l, Boolean bool, Long l2, Boolean bool2, Long l3, Long l4, Long l5, Long l6, String str, Long l7, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : l4, (i & 64) != 0 ? null : l5, (i & 128) != 0 ? null : l6, (i & 256) != 0 ? null : str, (i & 512) == 0 ? l7 : null);
            }

            public final Long getChapterId() {
                return this.chapterId;
            }

            public final Boolean getCouldPreview() {
                return this.couldPreview;
            }

            public final Long getCourseId() {
                return this.courseId;
            }

            public final Boolean getHasWatchRight() {
                return this.hasWatchRight;
            }

            public final Long getItemId() {
                return this.itemId;
            }

            public final Long getLastWatchTime() {
                return this.lastWatchTime;
            }

            public final Long getLessonId() {
                return this.lessonId;
            }

            public final Long getSectionId() {
                return this.sectionId;
            }

            public final String getVideoUrl() {
                return this.videoUrl;
            }

            public final Long getWatchProcess() {
                return this.watchProcess;
            }
        }
    }

    public final CourseFloor getCourseFloor() {
        return this.courseFloor;
    }
}