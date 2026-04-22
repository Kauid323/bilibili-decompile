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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0002@ABw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fHÆ\u0003Jy\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fHÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\rHÖ\u0001J\t\u00107\u001a\u00020\u0004HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0017¨\u0006B"}, d2 = {"Lkntr/app/cheese/space/api/SeasonModel;", "Lcom/bilibili/ogv/operation3/module/report/Reportable;", "Lcom/bilibili/ogv/operation3/module/navigable/Navigable;", "dms", RoomRecommendViewModel.EMPTY_CURSOR, "cover", "url", "title", "corner_mark_url", "corner_dark_mark_url", "update_info", "views", "season_id", RoomRecommendViewModel.EMPTY_CURSOR, "report", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDms", "()Ljava/lang/String;", "getCover", "getUrl", "getTitle", "getCorner_mark_url", "getCorner_dark_mark_url", "getUpdate_info", "getViews", "getSeason_id", "()I", "getReport", "()Ljava/util/Map;", "clickEventId", "getClickEventId", "exposureEventId", "getExposureEventId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$space_debug", "$serializer", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SeasonModel implements Reportable, Navigable {
    private final String corner_dark_mark_url;
    private final String corner_mark_url;
    private final String cover;
    private final String dms;
    private final Map<String, String> report;
    private final int season_id;
    private final String title;
    private final String update_info;
    private final String url;
    private final String views;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.cheese.space.api.SeasonModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SeasonModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public SeasonModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (Map) null, 1023, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.dms;
    }

    public final Map<String, String> component10() {
        return this.report;
    }

    public final String component2() {
        return this.cover;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.corner_mark_url;
    }

    public final String component6() {
        return this.corner_dark_mark_url;
    }

    public final String component7() {
        return this.update_info;
    }

    public final String component8() {
        return this.views;
    }

    public final int component9() {
        return this.season_id;
    }

    public final SeasonModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "dms");
        Intrinsics.checkNotNullParameter(str2, "cover");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str5, "corner_mark_url");
        Intrinsics.checkNotNullParameter(str6, "corner_dark_mark_url");
        Intrinsics.checkNotNullParameter(str7, "update_info");
        Intrinsics.checkNotNullParameter(str8, "views");
        Intrinsics.checkNotNullParameter(map, "report");
        return new SeasonModel(str, str2, str3, str4, str5, str6, str7, str8, i, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SeasonModel) {
            SeasonModel seasonModel = (SeasonModel) obj;
            return Intrinsics.areEqual(this.dms, seasonModel.dms) && Intrinsics.areEqual(this.cover, seasonModel.cover) && Intrinsics.areEqual(this.url, seasonModel.url) && Intrinsics.areEqual(this.title, seasonModel.title) && Intrinsics.areEqual(this.corner_mark_url, seasonModel.corner_mark_url) && Intrinsics.areEqual(this.corner_dark_mark_url, seasonModel.corner_dark_mark_url) && Intrinsics.areEqual(this.update_info, seasonModel.update_info) && Intrinsics.areEqual(this.views, seasonModel.views) && this.season_id == seasonModel.season_id && Intrinsics.areEqual(this.report, seasonModel.report);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.dms.hashCode() * 31) + this.cover.hashCode()) * 31) + this.url.hashCode()) * 31) + this.title.hashCode()) * 31) + this.corner_mark_url.hashCode()) * 31) + this.corner_dark_mark_url.hashCode()) * 31) + this.update_info.hashCode()) * 31) + this.views.hashCode()) * 31) + this.season_id) * 31) + this.report.hashCode();
    }

    public String toString() {
        String str = this.dms;
        String str2 = this.cover;
        String str3 = this.url;
        String str4 = this.title;
        String str5 = this.corner_mark_url;
        String str6 = this.corner_dark_mark_url;
        String str7 = this.update_info;
        String str8 = this.views;
        int i = this.season_id;
        return "SeasonModel(dms=" + str + ", cover=" + str2 + ", url=" + str3 + ", title=" + str4 + ", corner_mark_url=" + str5 + ", corner_dark_mark_url=" + str6 + ", update_info=" + str7 + ", views=" + str8 + ", season_id=" + i + ", report=" + this.report + ")";
    }

    /* compiled from: PageData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/api/SeasonModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/cheese/space/api/SeasonModel;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SeasonModel> serializer() {
            return SeasonModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SeasonModel(int seen0, String dms, String cover, String url, String title, String corner_mark_url, String corner_dark_mark_url, String update_info, String views, int season_id, Map report, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.dms = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.dms = dms;
        }
        if ((seen0 & 2) == 0) {
            this.cover = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.cover = cover;
        }
        if ((seen0 & 4) == 0) {
            this.url = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.url = url;
        }
        if ((seen0 & 8) == 0) {
            this.title = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.title = title;
        }
        if ((seen0 & 16) == 0) {
            this.corner_mark_url = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.corner_mark_url = corner_mark_url;
        }
        if ((seen0 & 32) == 0) {
            this.corner_dark_mark_url = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.corner_dark_mark_url = corner_dark_mark_url;
        }
        if ((seen0 & 64) == 0) {
            this.update_info = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.update_info = update_info;
        }
        if ((seen0 & 128) == 0) {
            this.views = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.views = views;
        }
        if ((seen0 & 256) == 0) {
            this.season_id = 0;
        } else {
            this.season_id = season_id;
        }
        if ((seen0 & 512) == 0) {
            this.report = new LinkedHashMap();
        } else {
            this.report = report;
        }
    }

    public SeasonModel(String dms, String cover, String url, String title, String corner_mark_url, String corner_dark_mark_url, String update_info, String views, int season_id, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(dms, "dms");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(corner_mark_url, "corner_mark_url");
        Intrinsics.checkNotNullParameter(corner_dark_mark_url, "corner_dark_mark_url");
        Intrinsics.checkNotNullParameter(update_info, "update_info");
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(map, "report");
        this.dms = dms;
        this.cover = cover;
        this.url = url;
        this.title = title;
        this.corner_mark_url = corner_mark_url;
        this.corner_dark_mark_url = corner_dark_mark_url;
        this.update_info = update_info;
        this.views = views;
        this.season_id = season_id;
        this.report = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$space_debug(SeasonModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.dms, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.dms);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.cover, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.getUrl(), RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.getUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.title, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.corner_mark_url, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.corner_mark_url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.corner_dark_mark_url, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.corner_dark_mark_url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.update_info, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 6, self.update_info);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.views, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 7, self.views);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.season_id != 0) {
            output.encodeIntElement(serialDesc, 8, self.season_id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.getReport(), new LinkedHashMap())) {
            output.encodeSerializableElement(serialDesc, 9, (SerializationStrategy) lazyArr[9].getValue(), self.getReport());
        }
    }

    public /* synthetic */ SeasonModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i2 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i2 & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str5, (i2 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str6, (i2 & 64) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str7, (i2 & 128) == 0 ? str8 : RoomRecommendViewModel.EMPTY_CURSOR, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? new LinkedHashMap() : map);
    }

    public final String getDms() {
        return this.dms;
    }

    public final String getCover() {
        return this.cover;
    }

    public String getUrl() {
        return this.url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCorner_mark_url() {
        return this.corner_mark_url;
    }

    public final String getCorner_dark_mark_url() {
        return this.corner_dark_mark_url;
    }

    public final String getUpdate_info() {
        return this.update_info;
    }

    public final String getViews() {
        return this.views;
    }

    public final int getSeason_id() {
        return this.season_id;
    }

    public Map<String, String> getReport() {
        return this.report;
    }

    public String getClickEventId() {
        return "main.space-pugv.feeds.card.click";
    }

    public String getExposureEventId() {
        return "main.space-pugv.feeds.card.show";
    }
}