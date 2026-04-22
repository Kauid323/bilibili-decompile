package kntr.app.ad.common.model;

import BottomSheetItemData$;
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

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0003%&'B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lkntr/app/ad/common/model/AdGameBookAwardModule;", RoomRecommendViewModel.EMPTY_CURSOR, "display", RoomRecommendViewModel.EMPTY_CURSOR, "rewardList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdGameBookAwardModule$BookAwardInfo;", "<init>", "(ZLjava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplay$annotations", "()V", "getDisplay", "()Z", "getRewardList$annotations", "getRewardList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "BookAwardInfo", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameBookAwardModule {
    private final boolean display;
    private final List<BookAwardInfo> rewardList;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdGameBookAwardModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdGameBookAwardModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AdGameBookAwardModule() {
        this(false, (List) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdGameBookAwardModule copy$default(AdGameBookAwardModule adGameBookAwardModule, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adGameBookAwardModule.display;
        }
        if ((i & 2) != 0) {
            list = adGameBookAwardModule.rewardList;
        }
        return adGameBookAwardModule.copy(z, list);
    }

    @SerialName("display")
    public static /* synthetic */ void getDisplay$annotations() {
    }

    @SerialName("reward_list")
    public static /* synthetic */ void getRewardList$annotations() {
    }

    public final boolean component1() {
        return this.display;
    }

    public final List<BookAwardInfo> component2() {
        return this.rewardList;
    }

    public final AdGameBookAwardModule copy(boolean z, List<BookAwardInfo> list) {
        return new AdGameBookAwardModule(z, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameBookAwardModule) {
            AdGameBookAwardModule adGameBookAwardModule = (AdGameBookAwardModule) obj;
            return this.display == adGameBookAwardModule.display && Intrinsics.areEqual(this.rewardList, adGameBookAwardModule.rewardList);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.display) * 31) + (this.rewardList == null ? 0 : this.rewardList.hashCode());
    }

    public String toString() {
        boolean z = this.display;
        return "AdGameBookAwardModule(display=" + z + ", rewardList=" + this.rewardList + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameBookAwardModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameBookAwardModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameBookAwardModule> serializer() {
            return AdGameBookAwardModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameBookAwardModule(int seen0, boolean display, List rewardList, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.display = false;
        } else {
            this.display = display;
        }
        if ((seen0 & 2) == 0) {
            this.rewardList = null;
        } else {
            this.rewardList = rewardList;
        }
    }

    public AdGameBookAwardModule(boolean display, List<BookAwardInfo> list) {
        this.display = display;
        this.rewardList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdGameBookAwardModule$BookAwardInfo$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameBookAwardModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.display) {
            output.encodeBooleanElement(serialDesc, 0, self.display);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.rewardList != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.rewardList);
        }
    }

    public /* synthetic */ AdGameBookAwardModule(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list);
    }

    public final boolean getDisplay() {
        return this.display;
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lkntr/app/ad/common/model/AdGameBookAwardModule$BookAwardInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "level", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "content", "pic", "reach", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLevel", "()I", "getTitle", "()Ljava/lang/String;", "getContent", "getPic", "getReach", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BookAwardInfo {
        public static final Companion Companion = new Companion(null);
        private final String content;
        private final int level;
        private final String pic;
        private final boolean reach;
        private final String title;

        public BookAwardInfo() {
            this(0, (String) null, (String) null, (String) null, false, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ BookAwardInfo copy$default(BookAwardInfo bookAwardInfo, int i, String str, String str2, String str3, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = bookAwardInfo.level;
            }
            if ((i2 & 2) != 0) {
                str = bookAwardInfo.title;
            }
            String str4 = str;
            if ((i2 & 4) != 0) {
                str2 = bookAwardInfo.content;
            }
            String str5 = str2;
            if ((i2 & 8) != 0) {
                str3 = bookAwardInfo.pic;
            }
            String str6 = str3;
            if ((i2 & 16) != 0) {
                z = bookAwardInfo.reach;
            }
            return bookAwardInfo.copy(i, str4, str5, str6, z);
        }

        public final int component1() {
            return this.level;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.content;
        }

        public final String component4() {
            return this.pic;
        }

        public final boolean component5() {
            return this.reach;
        }

        public final BookAwardInfo copy(int i, String str, String str2, String str3, boolean z) {
            return new BookAwardInfo(i, str, str2, str3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BookAwardInfo) {
                BookAwardInfo bookAwardInfo = (BookAwardInfo) obj;
                return this.level == bookAwardInfo.level && Intrinsics.areEqual(this.title, bookAwardInfo.title) && Intrinsics.areEqual(this.content, bookAwardInfo.content) && Intrinsics.areEqual(this.pic, bookAwardInfo.pic) && this.reach == bookAwardInfo.reach;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.level * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.content == null ? 0 : this.content.hashCode())) * 31) + (this.pic != null ? this.pic.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.reach);
        }

        public String toString() {
            int i = this.level;
            String str = this.title;
            String str2 = this.content;
            String str3 = this.pic;
            return "BookAwardInfo(level=" + i + ", title=" + str + ", content=" + str2 + ", pic=" + str3 + ", reach=" + this.reach + ")";
        }

        /* compiled from: AdAndroidGameInfo.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameBookAwardModule$BookAwardInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameBookAwardModule$BookAwardInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<BookAwardInfo> serializer() {
                return AdGameBookAwardModule$BookAwardInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ BookAwardInfo(int seen0, int level, String title, String content, String pic, boolean reach, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.level = 0;
            } else {
                this.level = level;
            }
            if ((seen0 & 2) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
            if ((seen0 & 4) == 0) {
                this.content = null;
            } else {
                this.content = content;
            }
            if ((seen0 & 8) == 0) {
                this.pic = null;
            } else {
                this.pic = pic;
            }
            if ((seen0 & 16) == 0) {
                this.reach = false;
            } else {
                this.reach = reach;
            }
        }

        public BookAwardInfo(int level, String title, String content, String pic, boolean reach) {
            this.level = level;
            this.title = title;
            this.content = content;
            this.pic = pic;
            this.reach = reach;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$dto_debug(BookAwardInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.level != 0) {
                output.encodeIntElement(serialDesc, 0, self.level);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.content != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.content);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.pic != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.pic);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.reach) {
                output.encodeBooleanElement(serialDesc, 4, self.reach);
            }
        }

        public /* synthetic */ BookAwardInfo(int i, String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) == 0 ? str3 : null, (i2 & 16) != 0 ? false : z);
        }

        public final int getLevel() {
            return this.level;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getPic() {
            return this.pic;
        }

        public final boolean getReach() {
            return this.reach;
        }
    }

    public final List<BookAwardInfo> getRewardList() {
        return this.rewardList;
    }
}