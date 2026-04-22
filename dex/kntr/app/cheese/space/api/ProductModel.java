package kntr.app.cheese.space.api;

import com.bilibili.ogv.operation3.module.navigable.Navigable;
import com.bilibili.ogv.operation3.module.report.Reportable;
import java.util.LinkedHashMap;
import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PageData.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u000278BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\r\u0010\u000eBi\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fHÆ\u0003J[\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00042\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0004HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0016¨\u00069"}, d2 = {"Lkntr/app/cheese/space/api/ProductModel;", "Lcom/bilibili/ogv/operation3/module/report/Reportable;", "Lcom/bilibili/ogv/operation3/module/navigable/Navigable;", "season_count", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "url", "cover", "views", "episode_count", "report", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSeason_count", "()I", "getTitle", "()Ljava/lang/String;", "getUrl", "getCover", "getViews", "getEpisode_count", "getReport", "()Ljava/util/Map;", "clickEventId", "getClickEventId", "exposureEventId", "getExposureEventId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$space_debug", "$serializer", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ProductModel implements Reportable, Navigable {
    private final String cover;
    private final int episode_count;
    private final Map<String, String> report;
    private final int season_count;
    private final String title;
    private final String url;
    private final String views;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.cheese.space.api.ProductModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ProductModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public ProductModel() {
        this(0, (String) null, (String) null, (String) null, (String) null, 0, (Map) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ProductModel copy$default(ProductModel productModel, int i, String str, String str2, String str3, String str4, int i2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = productModel.season_count;
        }
        if ((i3 & 2) != 0) {
            str = productModel.title;
        }
        String str5 = str;
        if ((i3 & 4) != 0) {
            str2 = productModel.url;
        }
        String str6 = str2;
        if ((i3 & 8) != 0) {
            str3 = productModel.cover;
        }
        String str7 = str3;
        if ((i3 & 16) != 0) {
            str4 = productModel.views;
        }
        String str8 = str4;
        if ((i3 & 32) != 0) {
            i2 = productModel.episode_count;
        }
        int i4 = i2;
        Map<String, String> map2 = map;
        if ((i3 & 64) != 0) {
            map2 = productModel.report;
        }
        return productModel.copy(i, str5, str6, str7, str8, i4, map2);
    }

    public final int component1() {
        return this.season_count;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.cover;
    }

    public final String component5() {
        return this.views;
    }

    public final int component6() {
        return this.episode_count;
    }

    public final Map<String, String> component7() {
        return this.report;
    }

    public final ProductModel copy(int i, String str, String str2, String str3, String str4, int i2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "cover");
        Intrinsics.checkNotNullParameter(str4, "views");
        Intrinsics.checkNotNullParameter(map, "report");
        return new ProductModel(i, str, str2, str3, str4, i2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductModel) {
            ProductModel productModel = (ProductModel) obj;
            return this.season_count == productModel.season_count && Intrinsics.areEqual(this.title, productModel.title) && Intrinsics.areEqual(this.url, productModel.url) && Intrinsics.areEqual(this.cover, productModel.cover) && Intrinsics.areEqual(this.views, productModel.views) && this.episode_count == productModel.episode_count && Intrinsics.areEqual(this.report, productModel.report);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.season_count * 31) + this.title.hashCode()) * 31) + this.url.hashCode()) * 31) + this.cover.hashCode()) * 31) + this.views.hashCode()) * 31) + this.episode_count) * 31) + this.report.hashCode();
    }

    public String toString() {
        int i = this.season_count;
        String str = this.title;
        String str2 = this.url;
        String str3 = this.cover;
        String str4 = this.views;
        int i2 = this.episode_count;
        return "ProductModel(season_count=" + i + ", title=" + str + ", url=" + str2 + ", cover=" + str3 + ", views=" + str4 + ", episode_count=" + i2 + ", report=" + this.report + ")";
    }

    /* compiled from: PageData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/api/ProductModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/cheese/space/api/ProductModel;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductModel> serializer() {
            return ProductModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ProductModel(int seen0, int season_count, String title, String url, String cover, String views, int episode_count, Map report, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.season_count = 0;
        } else {
            this.season_count = season_count;
        }
        if ((seen0 & 2) == 0) {
            this.title = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.title = title;
        }
        if ((seen0 & 4) == 0) {
            this.url = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.url = url;
        }
        if ((seen0 & 8) == 0) {
            this.cover = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.cover = cover;
        }
        if ((seen0 & 16) == 0) {
            this.views = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.views = views;
        }
        if ((seen0 & 32) == 0) {
            this.episode_count = 0;
        } else {
            this.episode_count = episode_count;
        }
        if ((seen0 & 64) == 0) {
            this.report = new LinkedHashMap();
        } else {
            this.report = report;
        }
    }

    public ProductModel(int season_count, String title, String url, String cover, String views, int episode_count, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(map, "report");
        this.season_count = season_count;
        this.title = title;
        this.url = url;
        this.cover = cover;
        this.views = views;
        this.episode_count = episode_count;
        this.report = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$space_debug(ProductModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.season_count != 0) {
            output.encodeIntElement(serialDesc, 0, self.season_count);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.title, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.getUrl(), RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.getUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.cover, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.views, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.views);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.episode_count != 0) {
            output.encodeIntElement(serialDesc, 5, self.episode_count);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.getReport(), new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.getReport());
        }
    }

    public /* synthetic */ ProductModel(int i, String str, String str2, String str3, String str4, int i2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i3 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i3 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i3 & 16) == 0 ? str4 : RoomRecommendViewModel.EMPTY_CURSOR, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? new LinkedHashMap() : map);
    }

    public final int getSeason_count() {
        return this.season_count;
    }

    public final String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getViews() {
        return this.views;
    }

    public final int getEpisode_count() {
        return this.episode_count;
    }

    public Map<String, String> getReport() {
        return this.report;
    }

    public String getClickEventId() {
        return "main.space-pugv.multi-class.card.click";
    }

    public String getExposureEventId() {
        return "main.space-pugv.multi-class.card.show";
    }
}