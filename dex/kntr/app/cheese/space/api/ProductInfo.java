package kntr.app.cheese.space.api;

import com.bilibili.ogv.operation3.module.navigable.Navigable;
import com.bilibili.ogv.operation3.module.report.Reportable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PageData.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u000289BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000e\u0010\u000fB]\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rHÆ\u0003JM\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0004HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0015¨\u0006:"}, d2 = {"Lkntr/app/cheese/space/api/ProductInfo;", "Lcom/bilibili/ogv/operation3/module/report/Reportable;", "Lcom/bilibili/ogv/operation3/module/navigable/Navigable;", "title", RoomRecommendViewModel.EMPTY_CURSOR, "product_model_list", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/cheese/space/api/ProductModel;", "product_count", RoomRecommendViewModel.EMPTY_CURSOR, "jump_model", "Lkntr/app/cheese/space/api/JumpModel;", "report", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/util/List;ILkntr/app/cheese/space/api/JumpModel;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;ILkntr/app/cheese/space/api/JumpModel;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getProduct_model_list", "()Ljava/util/List;", "getProduct_count", "()I", "getJump_model", "()Lkntr/app/cheese/space/api/JumpModel;", "getReport", "()Ljava/util/Map;", "clickEventId", "getClickEventId", "exposureEventId", "getExposureEventId", "url", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$space_debug", "$serializer", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ProductInfo implements Reportable, Navigable {
    private final JumpModel jump_model;
    private final int product_count;
    private final List<ProductModel> product_model_list;
    private final Map<String, String> report;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.cheese.space.api.ProductInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ProductInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.cheese.space.api.ProductInfo$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ProductInfo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public ProductInfo() {
        this((String) null, (List) null, 0, (JumpModel) null, (Map) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ProductInfo copy$default(ProductInfo productInfo, String str, List list, int i, JumpModel jumpModel, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = productInfo.title;
        }
        List<ProductModel> list2 = list;
        if ((i2 & 2) != 0) {
            list2 = productInfo.product_model_list;
        }
        List list3 = list2;
        if ((i2 & 4) != 0) {
            i = productInfo.product_count;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            jumpModel = productInfo.jump_model;
        }
        JumpModel jumpModel2 = jumpModel;
        Map<String, String> map2 = map;
        if ((i2 & 16) != 0) {
            map2 = productInfo.report;
        }
        return productInfo.copy(str, list3, i3, jumpModel2, map2);
    }

    public final String component1() {
        return this.title;
    }

    public final List<ProductModel> component2() {
        return this.product_model_list;
    }

    public final int component3() {
        return this.product_count;
    }

    public final JumpModel component4() {
        return this.jump_model;
    }

    public final Map<String, String> component5() {
        return this.report;
    }

    public final ProductInfo copy(String str, List<ProductModel> list, int i, JumpModel jumpModel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "product_model_list");
        Intrinsics.checkNotNullParameter(jumpModel, "jump_model");
        Intrinsics.checkNotNullParameter(map, "report");
        return new ProductInfo(str, list, i, jumpModel, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductInfo) {
            ProductInfo productInfo = (ProductInfo) obj;
            return Intrinsics.areEqual(this.title, productInfo.title) && Intrinsics.areEqual(this.product_model_list, productInfo.product_model_list) && this.product_count == productInfo.product_count && Intrinsics.areEqual(this.jump_model, productInfo.jump_model) && Intrinsics.areEqual(this.report, productInfo.report);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.product_model_list.hashCode()) * 31) + this.product_count) * 31) + this.jump_model.hashCode()) * 31) + this.report.hashCode();
    }

    public String toString() {
        String str = this.title;
        List<ProductModel> list = this.product_model_list;
        int i = this.product_count;
        JumpModel jumpModel = this.jump_model;
        return "ProductInfo(title=" + str + ", product_model_list=" + list + ", product_count=" + i + ", jump_model=" + jumpModel + ", report=" + this.report + ")";
    }

    /* compiled from: PageData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/api/ProductInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/cheese/space/api/ProductInfo;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductInfo> serializer() {
            return ProductInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ProductInfo(int seen0, String title, List product_model_list, int product_count, JumpModel jump_model, Map report, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.title = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.title = title;
        }
        if ((seen0 & 2) == 0) {
            this.product_model_list = CollectionsKt.emptyList();
        } else {
            this.product_model_list = product_model_list;
        }
        if ((seen0 & 4) == 0) {
            this.product_count = 0;
        } else {
            this.product_count = product_count;
        }
        if ((seen0 & 8) == 0) {
            this.jump_model = new JumpModel((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        } else {
            this.jump_model = jump_model;
        }
        if ((seen0 & 16) == 0) {
            this.report = new LinkedHashMap();
        } else {
            this.report = report;
        }
    }

    public ProductInfo(String title, List<ProductModel> list, int product_count, JumpModel jump_model, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "product_model_list");
        Intrinsics.checkNotNullParameter(jump_model, "jump_model");
        Intrinsics.checkNotNullParameter(map, "report");
        this.title = title;
        this.product_model_list = list;
        this.product_count = product_count;
        this.jump_model = jump_model;
        this.report = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ProductModel$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$space_debug(ProductInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.title, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.product_model_list, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.product_model_list);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.product_count != 0) {
            output.encodeIntElement(serialDesc, 2, self.product_count);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.jump_model, new JumpModel((String) null, (String) null, 3, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 3, JumpModel$$serializer.INSTANCE, self.jump_model);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.getReport(), new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.getReport());
        }
    }

    public /* synthetic */ ProductInfo(String str, List list, int i, JumpModel jumpModel, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new JumpModel((String) null, (String) null, 3, (DefaultConstructorMarker) null) : jumpModel, (i2 & 16) != 0 ? new LinkedHashMap() : map);
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<ProductModel> getProduct_model_list() {
        return this.product_model_list;
    }

    public final int getProduct_count() {
        return this.product_count;
    }

    public final JumpModel getJump_model() {
        return this.jump_model;
    }

    public Map<String, String> getReport() {
        return this.report;
    }

    public String getClickEventId() {
        return "main.space-pugv.multi-class.0.click";
    }

    public String getExposureEventId() {
        return "main.space-pugv.multi-class.0.show";
    }

    public String getUrl() {
        return this.jump_model.getJump_url();
    }
}