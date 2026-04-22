package kntr.app.mall.mallDynamicPage.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Style.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006,"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Corner;", RoomRecommendViewModel.EMPTY_CURSOR, "topLeft", RoomRecommendViewModel.EMPTY_CURSOR, "topRight", "bottomLeft", "bottomRight", "<init>", "(IIII)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTopLeft", "()I", "setTopLeft", "(I)V", "getTopRight", "setTopRight", "getBottomLeft", "setBottomLeft", "getBottomRight", "setBottomRight", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Corner {
    private int bottomLeft;
    private int bottomRight;
    private int topLeft;
    private int topRight;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Corner() {
        this(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Corner copy$default(Corner corner, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = corner.topLeft;
        }
        if ((i5 & 2) != 0) {
            i2 = corner.topRight;
        }
        if ((i5 & 4) != 0) {
            i3 = corner.bottomLeft;
        }
        if ((i5 & 8) != 0) {
            i4 = corner.bottomRight;
        }
        return corner.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.topLeft;
    }

    public final int component2() {
        return this.topRight;
    }

    public final int component3() {
        return this.bottomLeft;
    }

    public final int component4() {
        return this.bottomRight;
    }

    public final Corner copy(int i, int i2, int i3, int i4) {
        return new Corner(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Corner) {
            Corner corner = (Corner) obj;
            return this.topLeft == corner.topLeft && this.topRight == corner.topRight && this.bottomLeft == corner.bottomLeft && this.bottomRight == corner.bottomRight;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.topLeft * 31) + this.topRight) * 31) + this.bottomLeft) * 31) + this.bottomRight;
    }

    public String toString() {
        int i = this.topLeft;
        int i2 = this.topRight;
        int i3 = this.bottomLeft;
        return "Corner(topLeft=" + i + ", topRight=" + i2 + ", bottomLeft=" + i3 + ", bottomRight=" + this.bottomRight + ")";
    }

    /* compiled from: Style.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Corner$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/bean/Corner;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Corner> serializer() {
            return Corner$$serializer.INSTANCE;
        }
    }

    public Corner(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public /* synthetic */ Corner(int seen0, int topLeft, int topRight, int bottomLeft, int bottomRight, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.topLeft = 0;
        } else {
            this.topLeft = topLeft;
        }
        if ((seen0 & 2) == 0) {
            this.topRight = 0;
        } else {
            this.topRight = topRight;
        }
        if ((seen0 & 4) == 0) {
            this.bottomLeft = 0;
        } else {
            this.bottomLeft = bottomLeft;
        }
        if ((seen0 & 8) == 0) {
            this.bottomRight = 0;
        } else {
            this.bottomRight = bottomRight;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(Corner self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.topLeft != 0) {
            output.encodeIntElement(serialDesc, 0, self.topLeft);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.topRight != 0) {
            output.encodeIntElement(serialDesc, 1, self.topRight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bottomLeft != 0) {
            output.encodeIntElement(serialDesc, 2, self.bottomLeft);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.bottomRight != 0) {
            output.encodeIntElement(serialDesc, 3, self.bottomRight);
        }
    }

    public /* synthetic */ Corner(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public final int getTopLeft() {
        return this.topLeft;
    }

    public final void setTopLeft(int i) {
        this.topLeft = i;
    }

    public final int getTopRight() {
        return this.topRight;
    }

    public final void setTopRight(int i) {
        this.topRight = i;
    }

    public final int getBottomLeft() {
        return this.bottomLeft;
    }

    public final void setBottomLeft(int i) {
        this.bottomLeft = i;
    }

    public final int getBottomRight() {
        return this.bottomRight;
    }

    public final void setBottomRight(int i) {
        this.bottomRight = i;
    }
}