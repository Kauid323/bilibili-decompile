package kntr.app.ad.ad.biz.liveroom;

import java.lang.annotation.Annotation;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: BaseLiveRoomUIState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0005\u0003\u0004\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/ad/biz/liveroom/BaseLiveRoomUIState;", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardButtonState;", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardCoverState;", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTagViewState;", "Lkntr/app/ad/ad/biz/liveroom/AdLiveBrandCardTitleState;", "Lkntr/app/ad/ad/biz/liveroom/AdLiveRoomBrandCardUIState;", "liveroom_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public interface BaseLiveRoomUIState {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: BaseLiveRoomUIState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/ad/biz/liveroom/BaseLiveRoomUIState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/ad/biz/liveroom/BaseLiveRoomUIState;", "liveroom_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<BaseLiveRoomUIState> serializer() {
            return new SealedClassSerializer<>("kntr.app.ad.ad.biz.liveroom.BaseLiveRoomUIState", Reflection.getOrCreateKotlinClass(BaseLiveRoomUIState.class), new KClass[]{Reflection.getOrCreateKotlinClass(AdLiveBrandCardButtonState.class), Reflection.getOrCreateKotlinClass(AdLiveBrandCardCoverState.class), Reflection.getOrCreateKotlinClass(AdLiveBrandCardTagViewState.class), Reflection.getOrCreateKotlinClass(AdLiveBrandCardTitleState.class), Reflection.getOrCreateKotlinClass(AdLiveRoomBrandCardUIState.class)}, new KSerializer[]{AdLiveBrandCardButtonState$$serializer.INSTANCE, AdLiveBrandCardCoverState$$serializer.INSTANCE, AdLiveBrandCardTagViewState$$serializer.INSTANCE, AdLiveBrandCardTitleState$$serializer.INSTANCE, AdLiveRoomBrandCardUIState$$serializer.INSTANCE}, new Annotation[0]);
        }
    }
}