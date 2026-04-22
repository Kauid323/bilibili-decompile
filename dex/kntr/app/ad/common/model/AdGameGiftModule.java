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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eB_\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0013\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\nHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u00062"}, d2 = {"Lkntr/app/ad/common/model/AdGameGiftModule;", RoomRecommendViewModel.EMPTY_CURSOR, "display", RoomRecommendViewModel.EMPTY_CURSOR, "giftNum", RoomRecommendViewModel.EMPTY_CURSOR, "giftName", RoomRecommendViewModel.EMPTY_CURSOR, "giftIconNum", "iconUrls", RoomRecommendViewModel.EMPTY_CURSOR, "giftInfoIds", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZILjava/lang/String;ILjava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZILjava/lang/String;ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplay", "()Z", "getGiftNum", "()I", "getGiftName", "()Ljava/lang/String;", "getGiftIconNum", "getIconUrls", "()Ljava/util/List;", "getGiftInfoIds", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameGiftModule {
    private final boolean display;
    private final int giftIconNum;
    private final List<Long> giftInfoIds;
    private final String giftName;
    private final int giftNum;
    private final List<String> iconUrls;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdGameGiftModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdGameGiftModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdGameGiftModule$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = AdGameGiftModule._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public AdGameGiftModule() {
        this(false, 0, (String) null, 0, (List) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdGameGiftModule copy$default(AdGameGiftModule adGameGiftModule, boolean z, int i, String str, int i2, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = adGameGiftModule.display;
        }
        if ((i3 & 2) != 0) {
            i = adGameGiftModule.giftNum;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str = adGameGiftModule.giftName;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            i2 = adGameGiftModule.giftIconNum;
        }
        int i5 = i2;
        List<String> list3 = list;
        if ((i3 & 16) != 0) {
            list3 = adGameGiftModule.iconUrls;
        }
        List list4 = list3;
        List<Long> list5 = list2;
        if ((i3 & 32) != 0) {
            list5 = adGameGiftModule.giftInfoIds;
        }
        return adGameGiftModule.copy(z, i4, str2, i5, list4, list5);
    }

    public final boolean component1() {
        return this.display;
    }

    public final int component2() {
        return this.giftNum;
    }

    public final String component3() {
        return this.giftName;
    }

    public final int component4() {
        return this.giftIconNum;
    }

    public final List<String> component5() {
        return this.iconUrls;
    }

    public final List<Long> component6() {
        return this.giftInfoIds;
    }

    public final AdGameGiftModule copy(boolean z, int i, String str, int i2, List<String> list, List<Long> list2) {
        return new AdGameGiftModule(z, i, str, i2, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameGiftModule) {
            AdGameGiftModule adGameGiftModule = (AdGameGiftModule) obj;
            return this.display == adGameGiftModule.display && this.giftNum == adGameGiftModule.giftNum && Intrinsics.areEqual(this.giftName, adGameGiftModule.giftName) && this.giftIconNum == adGameGiftModule.giftIconNum && Intrinsics.areEqual(this.iconUrls, adGameGiftModule.iconUrls) && Intrinsics.areEqual(this.giftInfoIds, adGameGiftModule.giftInfoIds);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.display) * 31) + this.giftNum) * 31) + (this.giftName == null ? 0 : this.giftName.hashCode())) * 31) + this.giftIconNum) * 31) + (this.iconUrls == null ? 0 : this.iconUrls.hashCode())) * 31) + (this.giftInfoIds != null ? this.giftInfoIds.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.display;
        int i = this.giftNum;
        String str = this.giftName;
        int i2 = this.giftIconNum;
        List<String> list = this.iconUrls;
        return "AdGameGiftModule(display=" + z + ", giftNum=" + i + ", giftName=" + str + ", giftIconNum=" + i2 + ", iconUrls=" + list + ", giftInfoIds=" + this.giftInfoIds + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameGiftModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameGiftModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameGiftModule> serializer() {
            return AdGameGiftModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameGiftModule(int seen0, boolean display, int giftNum, String giftName, int giftIconNum, List iconUrls, List giftInfoIds, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.display = false;
        } else {
            this.display = display;
        }
        if ((seen0 & 2) == 0) {
            this.giftNum = 0;
        } else {
            this.giftNum = giftNum;
        }
        if ((seen0 & 4) == 0) {
            this.giftName = null;
        } else {
            this.giftName = giftName;
        }
        if ((seen0 & 8) == 0) {
            this.giftIconNum = 0;
        } else {
            this.giftIconNum = giftIconNum;
        }
        if ((seen0 & 16) == 0) {
            this.iconUrls = null;
        } else {
            this.iconUrls = iconUrls;
        }
        if ((seen0 & 32) == 0) {
            this.giftInfoIds = null;
        } else {
            this.giftInfoIds = giftInfoIds;
        }
    }

    public AdGameGiftModule(boolean display, int giftNum, String giftName, int giftIconNum, List<String> list, List<Long> list2) {
        this.display = display;
        this.giftNum = giftNum;
        this.giftName = giftName;
        this.giftIconNum = giftIconNum;
        this.iconUrls = list;
        this.giftInfoIds = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameGiftModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.display) {
            output.encodeBooleanElement(serialDesc, 0, self.display);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.giftNum != 0) {
            output.encodeIntElement(serialDesc, 1, self.giftNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.giftName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.giftName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.giftIconNum != 0) {
            output.encodeIntElement(serialDesc, 3, self.giftIconNum);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.iconUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.iconUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.giftInfoIds != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.giftInfoIds);
        }
    }

    public /* synthetic */ AdGameGiftModule(boolean z, int i, String str, int i2, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? null : str, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? null : list, (i3 & 32) != 0 ? null : list2);
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final int getGiftNum() {
        return this.giftNum;
    }

    public final String getGiftName() {
        return this.giftName;
    }

    public final int getGiftIconNum() {
        return this.giftIconNum;
    }

    public final List<String> getIconUrls() {
        return this.iconUrls;
    }

    public final List<Long> getGiftInfoIds() {
        return this.giftInfoIds;
    }
}