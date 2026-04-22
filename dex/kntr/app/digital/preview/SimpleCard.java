package kntr.app.digital.preview;

import BottomSheetItemData$;
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

/* compiled from: RouterParams.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 *2\u00020\u0001:\u0002)*B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lkntr/app/digital/preview/SimpleCard;", RoomRecommendViewModel.EMPTY_CURSOR, "image", RoomRecommendViewModel.EMPTY_CURSOR, "name", "badge", "frameUrl", "hasMask", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImage", "()Ljava/lang/String;", "getName", "getBadge", "getFrameUrl", "getHasMask", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SimpleCard {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String badge;
    private final String frameUrl;
    private final boolean hasMask;
    private final String image;
    private final String name;

    public static /* synthetic */ SimpleCard copy$default(SimpleCard simpleCard, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = simpleCard.image;
        }
        if ((i & 2) != 0) {
            str2 = simpleCard.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = simpleCard.badge;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = simpleCard.frameUrl;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = simpleCard.hasMask;
        }
        return simpleCard.copy(str, str5, str6, str7, z);
    }

    public final String component1() {
        return this.image;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.badge;
    }

    public final String component4() {
        return this.frameUrl;
    }

    public final boolean component5() {
        return this.hasMask;
    }

    public final SimpleCard copy(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "image");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "badge");
        Intrinsics.checkNotNullParameter(str4, "frameUrl");
        return new SimpleCard(str, str2, str3, str4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleCard) {
            SimpleCard simpleCard = (SimpleCard) obj;
            return Intrinsics.areEqual(this.image, simpleCard.image) && Intrinsics.areEqual(this.name, simpleCard.name) && Intrinsics.areEqual(this.badge, simpleCard.badge) && Intrinsics.areEqual(this.frameUrl, simpleCard.frameUrl) && this.hasMask == simpleCard.hasMask;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.image.hashCode() * 31) + this.name.hashCode()) * 31) + this.badge.hashCode()) * 31) + this.frameUrl.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasMask);
    }

    public String toString() {
        String str = this.image;
        String str2 = this.name;
        String str3 = this.badge;
        String str4 = this.frameUrl;
        return "SimpleCard(image=" + str + ", name=" + str2 + ", badge=" + str3 + ", frameUrl=" + str4 + ", hasMask=" + this.hasMask + ")";
    }

    /* compiled from: RouterParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/SimpleCard$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/SimpleCard;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SimpleCard> serializer() {
            return SimpleCard$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SimpleCard(int seen0, String image, String name, String badge, String frameUrl, boolean hasMask, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (seen0 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 31, SimpleCard$$serializer.INSTANCE.getDescriptor());
        }
        this.image = image;
        this.name = name;
        this.badge = badge;
        this.frameUrl = frameUrl;
        this.hasMask = hasMask;
    }

    public SimpleCard(String image, String name, String badge, String frameUrl, boolean hasMask) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(frameUrl, "frameUrl");
        this.image = image;
        this.name = name;
        this.badge = badge;
        this.frameUrl = frameUrl;
        this.hasMask = hasMask;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(SimpleCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.image);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.badge);
        output.encodeStringElement(serialDesc, 3, self.frameUrl);
        output.encodeBooleanElement(serialDesc, 4, self.hasMask);
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final String getFrameUrl() {
        return this.frameUrl;
    }

    public final boolean getHasMask() {
        return this.hasMask;
    }
}