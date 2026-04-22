package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdLotteryCard.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBG\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\rHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lkntr/app/ad/common/model/AdLotteryCard;", RoomRecommendViewModel.EMPTY_CURSOR, "startTime", RoomRecommendViewModel.EMPTY_CURSOR, "endTime", "images", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdLotteryImage;", "resultPage", "Lkntr/app/ad/common/model/AdResultPage;", "<init>", "(JJLjava/util/List;Lkntr/app/ad/common/model/AdResultPage;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/util/List;Lkntr/app/ad/common/model/AdResultPage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStartTime", "()J", "getEndTime", "getImages", "()Ljava/util/List;", "getResultPage", "()Lkntr/app/ad/common/model/AdResultPage;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdLotteryCard {
    private final long endTime;
    private final List<AdLotteryImage> images;
    private final AdResultPage resultPage;
    private final long startTime;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdLotteryCard$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdLotteryCard._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public AdLotteryCard() {
        this(0L, 0L, (List) null, (AdResultPage) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdLotteryCard copy$default(AdLotteryCard adLotteryCard, long j2, long j3, List list, AdResultPage adResultPage, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = adLotteryCard.startTime;
        }
        long j4 = j2;
        if ((i & 2) != 0) {
            j3 = adLotteryCard.endTime;
        }
        long j5 = j3;
        List<AdLotteryImage> list2 = list;
        if ((i & 4) != 0) {
            list2 = adLotteryCard.images;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            adResultPage = adLotteryCard.resultPage;
        }
        return adLotteryCard.copy(j4, j5, list3, adResultPage);
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTime;
    }

    public final List<AdLotteryImage> component3() {
        return this.images;
    }

    public final AdResultPage component4() {
        return this.resultPage;
    }

    public final AdLotteryCard copy(long j2, long j3, List<AdLotteryImage> list, AdResultPage adResultPage) {
        return new AdLotteryCard(j2, j3, list, adResultPage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdLotteryCard) {
            AdLotteryCard adLotteryCard = (AdLotteryCard) obj;
            return this.startTime == adLotteryCard.startTime && this.endTime == adLotteryCard.endTime && Intrinsics.areEqual(this.images, adLotteryCard.images) && Intrinsics.areEqual(this.resultPage, adLotteryCard.resultPage);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.startTime) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.endTime)) * 31) + (this.images == null ? 0 : this.images.hashCode())) * 31) + (this.resultPage != null ? this.resultPage.hashCode() : 0);
    }

    public String toString() {
        long j2 = this.startTime;
        long j3 = this.endTime;
        List<AdLotteryImage> list = this.images;
        return "AdLotteryCard(startTime=" + j2 + ", endTime=" + j3 + ", images=" + list + ", resultPage=" + this.resultPage + ")";
    }

    /* compiled from: AdLotteryCard.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdLotteryCard$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdLotteryCard;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdLotteryCard> serializer() {
            return AdLotteryCard$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdLotteryCard(int seen0, long startTime, long endTime, List images, AdResultPage resultPage, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.startTime = 0L;
        } else {
            this.startTime = startTime;
        }
        if ((seen0 & 2) == 0) {
            this.endTime = 0L;
        } else {
            this.endTime = endTime;
        }
        if ((seen0 & 4) == 0) {
            this.images = null;
        } else {
            this.images = images;
        }
        if ((seen0 & 8) == 0) {
            this.resultPage = null;
        } else {
            this.resultPage = resultPage;
        }
    }

    public AdLotteryCard(long startTime, long endTime, List<AdLotteryImage> list, AdResultPage resultPage) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.images = list;
        this.resultPage = resultPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdLotteryImage$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdLotteryCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.startTime != 0) {
            output.encodeLongElement(serialDesc, 0, self.startTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.endTime != 0) {
            output.encodeLongElement(serialDesc, 1, self.endTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.images != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.images);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.resultPage != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, AdResultPage$$serializer.INSTANCE, self.resultPage);
        }
    }

    public /* synthetic */ AdLotteryCard(long j2, long j3, List list, AdResultPage adResultPage, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) == 0 ? j3 : 0L, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : adResultPage);
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final List<AdLotteryImage> getImages() {
        return this.images;
    }

    public final AdResultPage getResultPage() {
        return this.resultPage;
    }
}