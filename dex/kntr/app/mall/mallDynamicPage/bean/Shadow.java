package kntr.app.mall.mallDynamicPage.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Style.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Shadow;", RoomRecommendViewModel.EMPTY_CURSOR, "elevation", RoomRecommendViewModel.EMPTY_CURSOR, "radius", "color", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getElevation", "()Ljava/lang/Integer;", "setElevation", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRadius", "setRadius", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/mallDynamicPage/bean/Shadow;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Shadow {
    private String color;
    private Integer elevation;
    private Integer radius;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Shadow() {
        this((Integer) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Shadow copy$default(Shadow shadow, Integer num, Integer num2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = shadow.elevation;
        }
        if ((i & 2) != 0) {
            num2 = shadow.radius;
        }
        if ((i & 4) != 0) {
            str = shadow.color;
        }
        return shadow.copy(num, num2, str);
    }

    public final Integer component1() {
        return this.elevation;
    }

    public final Integer component2() {
        return this.radius;
    }

    public final String component3() {
        return this.color;
    }

    public final Shadow copy(Integer num, Integer num2, String str) {
        return new Shadow(num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Shadow) {
            Shadow shadow = (Shadow) obj;
            return Intrinsics.areEqual(this.elevation, shadow.elevation) && Intrinsics.areEqual(this.radius, shadow.radius) && Intrinsics.areEqual(this.color, shadow.color);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.elevation == null ? 0 : this.elevation.hashCode()) * 31) + (this.radius == null ? 0 : this.radius.hashCode())) * 31) + (this.color != null ? this.color.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.elevation;
        Integer num2 = this.radius;
        return "Shadow(elevation=" + num + ", radius=" + num2 + ", color=" + this.color + ")";
    }

    /* compiled from: Style.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Shadow$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/bean/Shadow;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Shadow> serializer() {
            return Shadow$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Shadow(int seen0, Integer elevation, Integer radius, String color, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.elevation = null;
        } else {
            this.elevation = elevation;
        }
        if ((seen0 & 2) == 0) {
            this.radius = null;
        } else {
            this.radius = radius;
        }
        if ((seen0 & 4) == 0) {
            this.color = null;
        } else {
            this.color = color;
        }
    }

    public Shadow(Integer elevation, Integer radius, String color) {
        this.elevation = elevation;
        this.radius = radius;
        this.color = color;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(Shadow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.elevation != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.elevation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.radius != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.radius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.color);
        }
    }

    public /* synthetic */ Shadow(Integer num, Integer num2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str);
    }

    public final Integer getElevation() {
        return this.elevation;
    }

    public final void setElevation(Integer num) {
        this.elevation = num;
    }

    public final Integer getRadius() {
        return this.radius;
    }

    public final void setRadius(Integer num) {
        this.radius = num;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        this.color = str;
    }
}