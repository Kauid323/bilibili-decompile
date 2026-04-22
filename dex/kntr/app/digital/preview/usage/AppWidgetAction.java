package kntr.app.digital.preview.usage;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AppWidgetActionModule.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Lkntr/app/digital/preview/usage/AppWidgetAction;", RoomRecommendViewModel.EMPTY_CURSOR, "link", RoomRecommendViewModel.EMPTY_CURSOR, "cardTypeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLink", "()Ljava/lang/String;", "getCardTypeId$annotations", "()V", "getCardTypeId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AppWidgetAction {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String cardTypeId;
    private final String link;

    public static /* synthetic */ AppWidgetAction copy$default(AppWidgetAction appWidgetAction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appWidgetAction.link;
        }
        if ((i & 2) != 0) {
            str2 = appWidgetAction.cardTypeId;
        }
        return appWidgetAction.copy(str, str2);
    }

    @SerialName("card_type_id")
    public static /* synthetic */ void getCardTypeId$annotations() {
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.cardTypeId;
    }

    public final AppWidgetAction copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(str2, "cardTypeId");
        return new AppWidgetAction(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppWidgetAction) {
            AppWidgetAction appWidgetAction = (AppWidgetAction) obj;
            return Intrinsics.areEqual(this.link, appWidgetAction.link) && Intrinsics.areEqual(this.cardTypeId, appWidgetAction.cardTypeId);
        }
        return false;
    }

    public int hashCode() {
        return (this.link.hashCode() * 31) + this.cardTypeId.hashCode();
    }

    public String toString() {
        String str = this.link;
        return "AppWidgetAction(link=" + str + ", cardTypeId=" + this.cardTypeId + ")";
    }

    /* compiled from: AppWidgetActionModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/usage/AppWidgetAction$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/usage/AppWidgetAction;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AppWidgetAction> serializer() {
            return AppWidgetAction$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AppWidgetAction(int seen0, String link, String cardTypeId, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, AppWidgetAction$$serializer.INSTANCE.getDescriptor());
        }
        this.link = link;
        this.cardTypeId = cardTypeId;
    }

    public AppWidgetAction(String link, String cardTypeId) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(cardTypeId, "cardTypeId");
        this.link = link;
        this.cardTypeId = cardTypeId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(AppWidgetAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.link);
        output.encodeStringElement(serialDesc, 1, self.cardTypeId);
    }

    public final String getLink() {
        return this.link;
    }

    public final String getCardTypeId() {
        return this.cardTypeId;
    }
}