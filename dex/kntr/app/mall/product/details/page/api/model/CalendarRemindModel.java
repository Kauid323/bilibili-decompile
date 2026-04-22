package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FooterFloor.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;", "", "calendarRemindStatus", "", "name", "", "jumpUrl", "saleStartTime", "", "saleEndTime", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCalendarRemindStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getJumpUrl", "getSaleStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSaleEndTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CalendarRemindModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Integer calendarRemindStatus;
    private final String jumpUrl;
    private final String name;
    private final Long saleEndTime;
    private final Long saleStartTime;

    public CalendarRemindModel() {
        this((Integer) null, (String) null, (String) null, (Long) null, (Long) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CalendarRemindModel copy$default(CalendarRemindModel calendarRemindModel, Integer num, String str, String str2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = calendarRemindModel.calendarRemindStatus;
        }
        if ((i & 2) != 0) {
            str = calendarRemindModel.name;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = calendarRemindModel.jumpUrl;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            l = calendarRemindModel.saleStartTime;
        }
        Long l3 = l;
        if ((i & 16) != 0) {
            l2 = calendarRemindModel.saleEndTime;
        }
        return calendarRemindModel.copy(num, str3, str4, l3, l2);
    }

    public final Integer component1() {
        return this.calendarRemindStatus;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final Long component4() {
        return this.saleStartTime;
    }

    public final Long component5() {
        return this.saleEndTime;
    }

    public final CalendarRemindModel copy(Integer num, String str, String str2, Long l, Long l2) {
        return new CalendarRemindModel(num, str, str2, l, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CalendarRemindModel) {
            CalendarRemindModel calendarRemindModel = (CalendarRemindModel) obj;
            return Intrinsics.areEqual(this.calendarRemindStatus, calendarRemindModel.calendarRemindStatus) && Intrinsics.areEqual(this.name, calendarRemindModel.name) && Intrinsics.areEqual(this.jumpUrl, calendarRemindModel.jumpUrl) && Intrinsics.areEqual(this.saleStartTime, calendarRemindModel.saleStartTime) && Intrinsics.areEqual(this.saleEndTime, calendarRemindModel.saleEndTime);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.calendarRemindStatus == null ? 0 : this.calendarRemindStatus.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.saleStartTime == null ? 0 : this.saleStartTime.hashCode())) * 31) + (this.saleEndTime != null ? this.saleEndTime.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.calendarRemindStatus;
        String str = this.name;
        String str2 = this.jumpUrl;
        Long l = this.saleStartTime;
        return "CalendarRemindModel(calendarRemindStatus=" + num + ", name=" + str + ", jumpUrl=" + str2 + ", saleStartTime=" + l + ", saleEndTime=" + this.saleEndTime + ")";
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CalendarRemindModel> serializer() {
            return CalendarRemindModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CalendarRemindModel(int seen0, Integer calendarRemindStatus, String name, String jumpUrl, Long saleStartTime, Long saleEndTime, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.calendarRemindStatus = null;
        } else {
            this.calendarRemindStatus = calendarRemindStatus;
        }
        if ((seen0 & 2) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 4) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 8) == 0) {
            this.saleStartTime = null;
        } else {
            this.saleStartTime = saleStartTime;
        }
        if ((seen0 & 16) == 0) {
            this.saleEndTime = null;
        } else {
            this.saleEndTime = saleEndTime;
        }
    }

    public CalendarRemindModel(Integer calendarRemindStatus, String name, String jumpUrl, Long saleStartTime, Long saleEndTime) {
        this.calendarRemindStatus = calendarRemindStatus;
        this.name = name;
        this.jumpUrl = jumpUrl;
        this.saleStartTime = saleStartTime;
        this.saleEndTime = saleEndTime;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CalendarRemindModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.calendarRemindStatus != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.calendarRemindStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.saleStartTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.saleStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.saleEndTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.saleEndTime);
        }
    }

    public /* synthetic */ CalendarRemindModel(Integer num, String str, String str2, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    public final Integer getCalendarRemindStatus() {
        return this.calendarRemindStatus;
    }

    public final String getName() {
        return this.name;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Long getSaleStartTime() {
        return this.saleStartTime;
    }

    public final Long getSaleEndTime() {
        return this.saleEndTime;
    }
}