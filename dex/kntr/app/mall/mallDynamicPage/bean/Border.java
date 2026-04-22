package kntr.app.mall.mallDynamicPage.bean;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Style.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBQ\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003JI\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00068"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Border;", RoomRecommendViewModel.EMPTY_CURSOR, "width", RoomRecommendViewModel.EMPTY_CURSOR, "color", RoomRecommendViewModel.EMPTY_CURSOR, "shape", "shapeRadius", "Lkntr/app/mall/mallDynamicPage/bean/Corner;", "brush", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Corner;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Corner;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWidth", "()I", "setWidth", "(I)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getShape", "setShape", "getShapeRadius", "()Lkntr/app/mall/mallDynamicPage/bean/Corner;", "setShapeRadius", "(Lkntr/app/mall/mallDynamicPage/bean/Corner;)V", "getBrush", "()Ljava/util/List;", "setBrush", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Border {
    private List<String> brush;
    private String color;
    private String shape;
    private Corner shapeRadius;
    private int width;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.bean.Border$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = Border._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public Border() {
        this(0, (String) null, (String) null, (Corner) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Border copy$default(Border border, int i, String str, String str2, Corner corner, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = border.width;
        }
        if ((i2 & 2) != 0) {
            str = border.color;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = border.shape;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            corner = border.shapeRadius;
        }
        Corner corner2 = corner;
        List<String> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = border.brush;
        }
        return border.copy(i, str3, str4, corner2, list2);
    }

    public final int component1() {
        return this.width;
    }

    public final String component2() {
        return this.color;
    }

    public final String component3() {
        return this.shape;
    }

    public final Corner component4() {
        return this.shapeRadius;
    }

    public final List<String> component5() {
        return this.brush;
    }

    public final Border copy(int i, String str, String str2, Corner corner, List<String> list) {
        return new Border(i, str, str2, corner, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Border) {
            Border border = (Border) obj;
            return this.width == border.width && Intrinsics.areEqual(this.color, border.color) && Intrinsics.areEqual(this.shape, border.shape) && Intrinsics.areEqual(this.shapeRadius, border.shapeRadius) && Intrinsics.areEqual(this.brush, border.brush);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.width * 31) + (this.color == null ? 0 : this.color.hashCode())) * 31) + (this.shape == null ? 0 : this.shape.hashCode())) * 31) + (this.shapeRadius == null ? 0 : this.shapeRadius.hashCode())) * 31) + (this.brush != null ? this.brush.hashCode() : 0);
    }

    public String toString() {
        int i = this.width;
        String str = this.color;
        String str2 = this.shape;
        Corner corner = this.shapeRadius;
        return "Border(width=" + i + ", color=" + str + ", shape=" + str2 + ", shapeRadius=" + corner + ", brush=" + this.brush + ")";
    }

    /* compiled from: Style.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Border$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/bean/Border;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Border> serializer() {
            return Border$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Border(int seen0, int width, String color, String shape, Corner shapeRadius, List brush, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
        if ((seen0 & 2) == 0) {
            this.color = null;
        } else {
            this.color = color;
        }
        if ((seen0 & 4) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((seen0 & 8) == 0) {
            this.shapeRadius = null;
        } else {
            this.shapeRadius = shapeRadius;
        }
        if ((seen0 & 16) == 0) {
            this.brush = null;
        } else {
            this.brush = brush;
        }
    }

    public Border(int width, String color, String shape, Corner shapeRadius, List<String> list) {
        this.width = width;
        this.color = color;
        this.shape = shape;
        this.shapeRadius = shapeRadius;
        this.brush = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(Border self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.width != 0) {
            output.encodeIntElement(serialDesc, 0, self.width);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.color);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shape != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.shape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.shapeRadius != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Corner$$serializer.INSTANCE, self.shapeRadius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.brush != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.brush);
        }
    }

    public /* synthetic */ Border(int i, String str, String str2, Corner corner, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : corner, (i2 & 16) == 0 ? list : null);
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        this.color = str;
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

    public final List<String> getBrush() {
        return this.brush;
    }

    public final void setBrush(List<String> list) {
        this.brush = list;
    }
}