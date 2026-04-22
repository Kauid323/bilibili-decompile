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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J?\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Background;", RoomRecommendViewModel.EMPTY_CURSOR, "color", RoomRecommendViewModel.EMPTY_CURSOR, "shape", "shapeRadius", "Lkntr/app/mall/mallDynamicPage/bean/Corner;", "brush", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Corner;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/mall/mallDynamicPage/bean/Corner;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getShape", "setShape", "getShapeRadius", "()Lkntr/app/mall/mallDynamicPage/bean/Corner;", "setShapeRadius", "(Lkntr/app/mall/mallDynamicPage/bean/Corner;)V", "getBrush", "()Ljava/util/List;", "setBrush", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Background {
    private List<String> brush;
    private String color;
    private String shape;
    private Corner shapeRadius;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.bean.Background$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = Background._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public Background() {
        this((String) null, (String) null, (Corner) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Background copy$default(Background background, String str, String str2, Corner corner, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = background.color;
        }
        if ((i & 2) != 0) {
            str2 = background.shape;
        }
        if ((i & 4) != 0) {
            corner = background.shapeRadius;
        }
        if ((i & 8) != 0) {
            list = background.brush;
        }
        return background.copy(str, str2, corner, list);
    }

    public final String component1() {
        return this.color;
    }

    public final String component2() {
        return this.shape;
    }

    public final Corner component3() {
        return this.shapeRadius;
    }

    public final List<String> component4() {
        return this.brush;
    }

    public final Background copy(String str, String str2, Corner corner, List<String> list) {
        return new Background(str, str2, corner, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Background) {
            Background background = (Background) obj;
            return Intrinsics.areEqual(this.color, background.color) && Intrinsics.areEqual(this.shape, background.shape) && Intrinsics.areEqual(this.shapeRadius, background.shapeRadius) && Intrinsics.areEqual(this.brush, background.brush);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.color == null ? 0 : this.color.hashCode()) * 31) + (this.shape == null ? 0 : this.shape.hashCode())) * 31) + (this.shapeRadius == null ? 0 : this.shapeRadius.hashCode())) * 31) + (this.brush != null ? this.brush.hashCode() : 0);
    }

    public String toString() {
        String str = this.color;
        String str2 = this.shape;
        Corner corner = this.shapeRadius;
        return "Background(color=" + str + ", shape=" + str2 + ", shapeRadius=" + corner + ", brush=" + this.brush + ")";
    }

    /* compiled from: Style.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/bean/Background$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/bean/Background;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Background> serializer() {
            return Background$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Background(int seen0, String color, String shape, Corner shapeRadius, List brush, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.color = null;
        } else {
            this.color = color;
        }
        if ((seen0 & 2) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((seen0 & 4) == 0) {
            this.shapeRadius = null;
        } else {
            this.shapeRadius = shapeRadius;
        }
        if ((seen0 & 8) == 0) {
            this.brush = null;
        } else {
            this.brush = brush;
        }
    }

    public Background(String color, String shape, Corner shapeRadius, List<String> list) {
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
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(Background self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.color);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shape != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.shape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shapeRadius != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, Corner$$serializer.INSTANCE, self.shapeRadius);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.brush != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.brush);
        }
    }

    public /* synthetic */ Background(String str, String str2, Corner corner, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : corner, (i & 8) != 0 ? null : list);
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