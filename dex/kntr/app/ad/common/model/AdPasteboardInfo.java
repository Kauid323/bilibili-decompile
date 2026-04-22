package kntr.app.ad.common.model;

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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdPasteboardInfo.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB_\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JY\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000eHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R&\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lkntr/app/ad/common/model/AdPasteboardInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "desc", "scheme", "openName", "pageId", "wechatPackages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdWechatPackage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getDesc", "getScheme", "getOpenName", "getPageId", "getWechatPackages$annotations", "()V", "getWechatPackages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdPasteboardInfo {
    private final String desc;
    private final String openName;
    private final String pageId;
    private final String scheme;
    private final String title;
    private final List<AdWechatPackage> wechatPackages;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdPasteboardInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdPasteboardInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AdPasteboardInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdPasteboardInfo copy$default(AdPasteboardInfo adPasteboardInfo, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adPasteboardInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = adPasteboardInfo.desc;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = adPasteboardInfo.scheme;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = adPasteboardInfo.openName;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = adPasteboardInfo.pageId;
        }
        String str9 = str5;
        List<AdWechatPackage> list2 = list;
        if ((i & 32) != 0) {
            list2 = adPasteboardInfo.wechatPackages;
        }
        return adPasteboardInfo.copy(str, str6, str7, str8, str9, list2);
    }

    @SerialName("wechat_package")
    public static /* synthetic */ void getWechatPackages$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.scheme;
    }

    public final String component4() {
        return this.openName;
    }

    public final String component5() {
        return this.pageId;
    }

    public final List<AdWechatPackage> component6() {
        return this.wechatPackages;
    }

    public final AdPasteboardInfo copy(String str, String str2, String str3, String str4, String str5, List<AdWechatPackage> list) {
        return new AdPasteboardInfo(str, str2, str3, str4, str5, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdPasteboardInfo) {
            AdPasteboardInfo adPasteboardInfo = (AdPasteboardInfo) obj;
            return Intrinsics.areEqual(this.title, adPasteboardInfo.title) && Intrinsics.areEqual(this.desc, adPasteboardInfo.desc) && Intrinsics.areEqual(this.scheme, adPasteboardInfo.scheme) && Intrinsics.areEqual(this.openName, adPasteboardInfo.openName) && Intrinsics.areEqual(this.pageId, adPasteboardInfo.pageId) && Intrinsics.areEqual(this.wechatPackages, adPasteboardInfo.wechatPackages);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.scheme == null ? 0 : this.scheme.hashCode())) * 31) + (this.openName == null ? 0 : this.openName.hashCode())) * 31) + (this.pageId == null ? 0 : this.pageId.hashCode())) * 31) + (this.wechatPackages != null ? this.wechatPackages.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.desc;
        String str3 = this.scheme;
        String str4 = this.openName;
        String str5 = this.pageId;
        return "AdPasteboardInfo(title=" + str + ", desc=" + str2 + ", scheme=" + str3 + ", openName=" + str4 + ", pageId=" + str5 + ", wechatPackages=" + this.wechatPackages + ")";
    }

    /* compiled from: AdPasteboardInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdPasteboardInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdPasteboardInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdPasteboardInfo> serializer() {
            return AdPasteboardInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdPasteboardInfo(int seen0, String title, String desc, String scheme, String openName, String pageId, List wechatPackages, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 2) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 4) == 0) {
            this.scheme = null;
        } else {
            this.scheme = scheme;
        }
        if ((seen0 & 8) == 0) {
            this.openName = null;
        } else {
            this.openName = openName;
        }
        if ((seen0 & 16) == 0) {
            this.pageId = null;
        } else {
            this.pageId = pageId;
        }
        if ((seen0 & 32) == 0) {
            this.wechatPackages = null;
        } else {
            this.wechatPackages = wechatPackages;
        }
    }

    public AdPasteboardInfo(String title, String desc, String scheme, String openName, String pageId, List<AdWechatPackage> list) {
        this.title = title;
        this.desc = desc;
        this.scheme = scheme;
        this.openName = openName;
        this.pageId = pageId;
        this.wechatPackages = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdWechatPackage$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdPasteboardInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.scheme != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.scheme);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.openName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.openName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.pageId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.pageId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.wechatPackages != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.wechatPackages);
        }
    }

    public /* synthetic */ AdPasteboardInfo(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getOpenName() {
        return this.openName;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final List<AdWechatPackage> getWechatPackages() {
        return this.wechatPackages;
    }
}