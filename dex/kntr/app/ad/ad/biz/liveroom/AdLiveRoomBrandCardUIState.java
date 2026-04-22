package kntr.app.ad.ad.biz.liveroom;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: BaseLiveRoomUIState.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B1\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\rHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Lkntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState;", "Lkntr/app/ad/ad/biz/liveroom/BaseLiveRoomUIState;", "coverState", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardCoverState;", "buttonState", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardButtonState;", "titleState", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTitleState;", "adTagState", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTagViewState;", "<init>", "(Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardCoverState;Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardButtonState;Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTitleState;Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTagViewState;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardCoverState;Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardButtonState;Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTitleState;Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTagViewState;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCoverState", "()Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardCoverState;", "getButtonState", "()Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardButtonState;", "getTitleState", "()Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTitleState;", "getAdTagState", "()Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTagViewState;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$liveroom_debug", "$serializer", "Companion", "liveroom_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdLiveRoomBrandCardUIState implements BaseLiveRoomUIState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final AdLiveBrandCardTagViewState adTagState;
    private final AdLiveBrandCardButtonState buttonState;
    private final AdLiveBrandCardCoverState coverState;
    private final AdLiveBrandCardTitleState titleState;

    public static /* synthetic */ AdLiveRoomBrandCardUIState copy$default(AdLiveRoomBrandCardUIState adLiveRoomBrandCardUIState, AdLiveBrandCardCoverState adLiveBrandCardCoverState, AdLiveBrandCardButtonState adLiveBrandCardButtonState, AdLiveBrandCardTitleState adLiveBrandCardTitleState, AdLiveBrandCardTagViewState adLiveBrandCardTagViewState, int i, Object obj) {
        if ((i & 1) != 0) {
            adLiveBrandCardCoverState = adLiveRoomBrandCardUIState.coverState;
        }
        if ((i & 2) != 0) {
            adLiveBrandCardButtonState = adLiveRoomBrandCardUIState.buttonState;
        }
        if ((i & 4) != 0) {
            adLiveBrandCardTitleState = adLiveRoomBrandCardUIState.titleState;
        }
        if ((i & 8) != 0) {
            adLiveBrandCardTagViewState = adLiveRoomBrandCardUIState.adTagState;
        }
        return adLiveRoomBrandCardUIState.copy(adLiveBrandCardCoverState, adLiveBrandCardButtonState, adLiveBrandCardTitleState, adLiveBrandCardTagViewState);
    }

    public final AdLiveBrandCardCoverState component1() {
        return this.coverState;
    }

    public final AdLiveBrandCardButtonState component2() {
        return this.buttonState;
    }

    public final AdLiveBrandCardTitleState component3() {
        return this.titleState;
    }

    public final AdLiveBrandCardTagViewState component4() {
        return this.adTagState;
    }

    public final AdLiveRoomBrandCardUIState copy(AdLiveBrandCardCoverState adLiveBrandCardCoverState, AdLiveBrandCardButtonState adLiveBrandCardButtonState, AdLiveBrandCardTitleState adLiveBrandCardTitleState, AdLiveBrandCardTagViewState adLiveBrandCardTagViewState) {
        return new AdLiveRoomBrandCardUIState(adLiveBrandCardCoverState, adLiveBrandCardButtonState, adLiveBrandCardTitleState, adLiveBrandCardTagViewState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdLiveRoomBrandCardUIState) {
            AdLiveRoomBrandCardUIState adLiveRoomBrandCardUIState = (AdLiveRoomBrandCardUIState) obj;
            return Intrinsics.areEqual(this.coverState, adLiveRoomBrandCardUIState.coverState) && Intrinsics.areEqual(this.buttonState, adLiveRoomBrandCardUIState.buttonState) && Intrinsics.areEqual(this.titleState, adLiveRoomBrandCardUIState.titleState) && Intrinsics.areEqual(this.adTagState, adLiveRoomBrandCardUIState.adTagState);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.coverState == null ? 0 : this.coverState.hashCode()) * 31) + (this.buttonState == null ? 0 : this.buttonState.hashCode())) * 31) + (this.titleState == null ? 0 : this.titleState.hashCode())) * 31) + (this.adTagState != null ? this.adTagState.hashCode() : 0);
    }

    public String toString() {
        AdLiveBrandCardCoverState adLiveBrandCardCoverState = this.coverState;
        AdLiveBrandCardButtonState adLiveBrandCardButtonState = this.buttonState;
        AdLiveBrandCardTitleState adLiveBrandCardTitleState = this.titleState;
        return "AdLiveRoomBrandCardUIState(coverState=" + adLiveBrandCardCoverState + ", buttonState=" + adLiveBrandCardButtonState + ", titleState=" + adLiveBrandCardTitleState + ", adTagState=" + this.adTagState + ")";
    }

    /* compiled from: BaseLiveRoomUIState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState;", "liveroom_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdLiveRoomBrandCardUIState> serializer() {
            return AdLiveRoomBrandCardUIState$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdLiveRoomBrandCardUIState(int seen0, AdLiveBrandCardCoverState coverState, AdLiveBrandCardButtonState buttonState, AdLiveBrandCardTitleState titleState, AdLiveBrandCardTagViewState adTagState, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, AdLiveRoomBrandCardUIState$$serializer.INSTANCE.getDescriptor());
        }
        this.coverState = coverState;
        this.buttonState = buttonState;
        this.titleState = titleState;
        this.adTagState = adTagState;
    }

    public AdLiveRoomBrandCardUIState(AdLiveBrandCardCoverState coverState, AdLiveBrandCardButtonState buttonState, AdLiveBrandCardTitleState titleState, AdLiveBrandCardTagViewState adTagState) {
        this.coverState = coverState;
        this.buttonState = buttonState;
        this.titleState = titleState;
        this.adTagState = adTagState;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$liveroom_debug(AdLiveRoomBrandCardUIState self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, AdLiveBrandCardCoverState$$serializer.INSTANCE, self.coverState);
        output.encodeNullableSerializableElement(serialDesc, 1, AdLiveBrandCardButtonState$$serializer.INSTANCE, self.buttonState);
        output.encodeNullableSerializableElement(serialDesc, 2, AdLiveBrandCardTitleState$$serializer.INSTANCE, self.titleState);
        output.encodeNullableSerializableElement(serialDesc, 3, AdLiveBrandCardTagViewState$$serializer.INSTANCE, self.adTagState);
    }

    public final AdLiveBrandCardCoverState getCoverState() {
        return this.coverState;
    }

    public final AdLiveBrandCardButtonState getButtonState() {
        return this.buttonState;
    }

    public final AdLiveBrandCardTitleState getTitleState() {
        return this.titleState;
    }

    public final AdLiveBrandCardTagViewState getAdTagState() {
        return this.adTagState;
    }
}