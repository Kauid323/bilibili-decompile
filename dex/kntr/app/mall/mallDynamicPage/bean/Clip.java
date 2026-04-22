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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Style.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Clip;", RoomRecommendViewModel.EMPTY_CURSOR, "shape", RoomRecommendViewModel.EMPTY_CURSOR, "shapeRadius", "Lkntr/app/mall/mallDynamicPage/bean/Corner;", "<init>", "(Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Corner;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Corner;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShape", "()Ljava/lang/String;", "setShape", "(Ljava/lang/String;)V", "getShapeRadius", "()Lkntr/app/mall/mallDynamicPage/bean/Corner;", "setShapeRadius", "(Lkntr/app/mall/mallDynamicPage/bean/Corner;)V", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Clip {
    private String shape;
    private Corner shapeRadius;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Clip() {
        this((String) null, (Corner) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Clip copy$default(Clip clip, String str, Corner corner, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clip.shape;
        }
        if ((i & 2) != 0) {
            corner = clip.shapeRadius;
        }
        return clip.copy(str, corner);
    }

    public final String component1() {
        return this.shape;
    }

    public final Corner component2() {
        return this.shapeRadius;
    }

    public final Clip copy(String str, Corner corner) {
        return new Clip(str, corner);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Clip) {
            Clip clip = (Clip) obj;
            return Intrinsics.areEqual(this.shape, clip.shape) && Intrinsics.areEqual(this.shapeRadius, clip.shapeRadius);
        }
        return false;
    }

    public int hashCode() {
        return ((this.shape == null ? 0 : this.shape.hashCode()) * 31) + (this.shapeRadius != null ? this.shapeRadius.hashCode() : 0);
    }

    public String toString() {
        String str = this.shape;
        return "Clip(shape=" + str + ", shapeRadius=" + this.shapeRadius + ")";
    }

    /* compiled from: Style.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Clip$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/bean/Clip;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Clip> serializer() {
            return Clip$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Clip(int seen0, String shape, Corner shapeRadius, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((seen0 & 2) == 0) {
            this.shapeRadius = null;
        } else {
            this.shapeRadius = shapeRadius;
        }
    }

    public Clip(String shape, Corner shapeRadius) {
        this.shape = shape;
        this.shapeRadius = shapeRadius;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(Clip self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.shape != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.shape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shapeRadius != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, Corner$$serializer.INSTANCE, self.shapeRadius);
        }
    }

    public /* synthetic */ Clip(String str, Corner corner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : corner);
    }

    public final String getShape() {
        return this.shape;
    }

    public final void setShape(String str) {
        this.shape = str;
    }

    public final Corner getShapeRadius() {
        return this.shapeRadius;
    }

    public final void setShapeRadius(Corner corner) {
        this.shapeRadius = corner;
    }
}