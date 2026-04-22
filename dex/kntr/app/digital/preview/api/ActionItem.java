package kntr.app.digital.preview.api;

import java.lang.annotation.Annotation;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* compiled from: CardPreviewModel.kt */
@JsonClassDiscriminator(discriminator = "action_type")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/api/ActionItem;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "Companion", "Lkntr/app/digital/preview/api/ReshapingModel;", "Lkntr/app/digital/preview/api/RewardEnd;", "Lkntr/app/digital/preview/api/RewardNotReceived;", "Lkntr/app/digital/preview/api/RewardReceived;", "Lkntr/app/digital/preview/api/Using;", "Lkntr/app/digital/preview/api/ViewActivity;", "Lkntr/app/digital/preview/api/ViewingHolding;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public interface ActionItem {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: CardPreviewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @SerialName("title")
        public static /* synthetic */ void getTitle$annotations() {
        }
    }

    String getTitle();

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/ActionItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/ActionItem;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final KSerializer<ActionItem> serializer() {
            return new SealedClassSerializer<>("kntr.app.digital.preview.api.ActionItem", Reflection.getOrCreateKotlinClass(ActionItem.class), new KClass[]{Reflection.getOrCreateKotlinClass(ReshapingModel.class), Reflection.getOrCreateKotlinClass(RewardEnd.class), Reflection.getOrCreateKotlinClass(RewardNotReceived.class), Reflection.getOrCreateKotlinClass(RewardReceived.class), Reflection.getOrCreateKotlinClass(Using.class), Reflection.getOrCreateKotlinClass(ViewActivity.class), Reflection.getOrCreateKotlinClass(ViewingHolding.class)}, new KSerializer[]{ReshapingModel$$serializer.INSTANCE, RewardEnd$$serializer.INSTANCE, RewardNotReceived$$serializer.INSTANCE, RewardReceived$$serializer.INSTANCE, Using$$serializer.INSTANCE, ViewActivity$$serializer.INSTANCE, ViewingHolding$$serializer.INSTANCE}, new Annotation[]{new ResultItem$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0("action_type")});
        }
    }
}