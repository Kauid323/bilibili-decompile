package kntr.app.digital.preview.splashsetting;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SplashSettingActionModule.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lkntr/app/digital/preview/splashsetting/SplashSettingAction;", RoomRecommendViewModel.EMPTY_CURSOR, "activityId", RoomRecommendViewModel.EMPTY_CURSOR, "cardTypeId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IJ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityId$annotations", "()V", "getActivityId", "()I", "getCardTypeId$annotations", "getCardTypeId", "()J", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SplashSettingAction {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int activityId;
    private final long cardTypeId;

    public static /* synthetic */ SplashSettingAction copy$default(SplashSettingAction splashSettingAction, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = splashSettingAction.activityId;
        }
        if ((i2 & 2) != 0) {
            j2 = splashSettingAction.cardTypeId;
        }
        return splashSettingAction.copy(i, j2);
    }

    @SerialName("activity_id")
    public static /* synthetic */ void getActivityId$annotations() {
    }

    @SerialName("card_type_id")
    public static /* synthetic */ void getCardTypeId$annotations() {
    }

    public final int component1() {
        return this.activityId;
    }

    public final long component2() {
        return this.cardTypeId;
    }

    public final SplashSettingAction copy(int i, long j2) {
        return new SplashSettingAction(i, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashSettingAction) {
            SplashSettingAction splashSettingAction = (SplashSettingAction) obj;
            return this.activityId == splashSettingAction.activityId && this.cardTypeId == splashSettingAction.cardTypeId;
        }
        return false;
    }

    public int hashCode() {
        return (this.activityId * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId);
    }

    public String toString() {
        int i = this.activityId;
        return "SplashSettingAction(activityId=" + i + ", cardTypeId=" + this.cardTypeId + ")";
    }

    /* compiled from: SplashSettingActionModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/splashsetting/SplashSettingAction$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/splashsetting/SplashSettingAction;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SplashSettingAction> serializer() {
            return SplashSettingAction$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SplashSettingAction(int seen0, int activityId, long cardTypeId, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, SplashSettingAction$$serializer.INSTANCE.getDescriptor());
        }
        this.activityId = activityId;
        this.cardTypeId = cardTypeId;
    }

    public SplashSettingAction(int activityId, long cardTypeId) {
        this.activityId = activityId;
        this.cardTypeId = cardTypeId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(SplashSettingAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.activityId);
        output.encodeLongElement(serialDesc, 1, self.cardTypeId);
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }
}