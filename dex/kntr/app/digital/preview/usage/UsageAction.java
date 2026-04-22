package kntr.app.digital.preview.usage;

import BottomSheetItemData$;
import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UsageActionModule.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+B6\u0012\u0019\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB7\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u001c\u0010\u001a\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\u001b\b\u0002\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000eHÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R/\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006,"}, d2 = {"Lkntr/app/digital/preview/usage/UsageAction;", RoomRecommendViewModel.EMPTY_CURSOR, "canUse", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "badgeUrl", RoomRecommendViewModel.EMPTY_CURSOR, "toast", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCanUse$annotations", "()V", "getCanUse", "()Z", "getBadgeUrl$annotations", "getBadgeUrl", "()Ljava/lang/String;", "getToast", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class UsageAction {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String badgeUrl;
    private final boolean canUse;
    private final String toast;

    public static /* synthetic */ UsageAction copy$default(UsageAction usageAction, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = usageAction.canUse;
        }
        if ((i & 2) != 0) {
            str = usageAction.badgeUrl;
        }
        if ((i & 4) != 0) {
            str2 = usageAction.toast;
        }
        return usageAction.copy(z, str, str2);
    }

    @SerialName("badge_url")
    public static /* synthetic */ void getBadgeUrl$annotations() {
    }

    @SerialName("can_use")
    public static /* synthetic */ void getCanUse$annotations() {
    }

    public final boolean component1() {
        return this.canUse;
    }

    public final String component2() {
        return this.badgeUrl;
    }

    public final String component3() {
        return this.toast;
    }

    public final UsageAction copy(boolean z, String str, String str2) {
        return new UsageAction(z, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UsageAction) {
            UsageAction usageAction = (UsageAction) obj;
            return this.canUse == usageAction.canUse && Intrinsics.areEqual(this.badgeUrl, usageAction.badgeUrl) && Intrinsics.areEqual(this.toast, usageAction.toast);
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canUse) * 31) + (this.badgeUrl == null ? 0 : this.badgeUrl.hashCode())) * 31) + (this.toast != null ? this.toast.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.canUse;
        String str = this.badgeUrl;
        return "UsageAction(canUse=" + z + ", badgeUrl=" + str + ", toast=" + this.toast + ")";
    }

    /* compiled from: UsageActionModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/usage/UsageAction$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/usage/UsageAction;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UsageAction> serializer() {
            return UsageAction$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ UsageAction(int seen0, boolean canUse, String badgeUrl, String toast, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, UsageAction$$serializer.INSTANCE.getDescriptor());
        }
        this.canUse = canUse;
        this.badgeUrl = badgeUrl;
        this.toast = toast;
    }

    public UsageAction(boolean canUse, String badgeUrl, String toast) {
        this.canUse = canUse;
        this.badgeUrl = badgeUrl;
        this.toast = toast;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(UsageAction self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(self.canUse));
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.badgeUrl);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.toast);
    }

    public final boolean getCanUse() {
        return this.canUse;
    }

    public final String getBadgeUrl() {
        return this.badgeUrl;
    }

    public final String getToast() {
        return this.toast;
    }
}