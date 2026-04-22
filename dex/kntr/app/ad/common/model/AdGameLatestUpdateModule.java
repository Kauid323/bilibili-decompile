package kntr.app.ad.common.model;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\tHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lkntr/app/ad/common/model/AdGameLatestUpdateModule;", RoomRecommendViewModel.EMPTY_CURSOR, "display", RoomRecommendViewModel.EMPTY_CURSOR, "latestUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZLjava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplay", "()Z", "getLatestUpdate", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameLatestUpdateModule {
    public static final Companion Companion = new Companion(null);
    private final boolean display;
    private final String latestUpdate;

    public AdGameLatestUpdateModule() {
        this(false, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdGameLatestUpdateModule copy$default(AdGameLatestUpdateModule adGameLatestUpdateModule, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adGameLatestUpdateModule.display;
        }
        if ((i & 2) != 0) {
            str = adGameLatestUpdateModule.latestUpdate;
        }
        return adGameLatestUpdateModule.copy(z, str);
    }

    public final boolean component1() {
        return this.display;
    }

    public final String component2() {
        return this.latestUpdate;
    }

    public final AdGameLatestUpdateModule copy(boolean z, String str) {
        return new AdGameLatestUpdateModule(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameLatestUpdateModule) {
            AdGameLatestUpdateModule adGameLatestUpdateModule = (AdGameLatestUpdateModule) obj;
            return this.display == adGameLatestUpdateModule.display && Intrinsics.areEqual(this.latestUpdate, adGameLatestUpdateModule.latestUpdate);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.display) * 31) + (this.latestUpdate == null ? 0 : this.latestUpdate.hashCode());
    }

    public String toString() {
        boolean z = this.display;
        return "AdGameLatestUpdateModule(display=" + z + ", latestUpdate=" + this.latestUpdate + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameLatestUpdateModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameLatestUpdateModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameLatestUpdateModule> serializer() {
            return AdGameLatestUpdateModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGameLatestUpdateModule(int seen0, boolean display, String latestUpdate, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.display = false;
        } else {
            this.display = display;
        }
        if ((seen0 & 2) == 0) {
            this.latestUpdate = null;
        } else {
            this.latestUpdate = latestUpdate;
        }
    }

    public AdGameLatestUpdateModule(boolean display, String latestUpdate) {
        this.display = display;
        this.latestUpdate = latestUpdate;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameLatestUpdateModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.display) {
            output.encodeBooleanElement(serialDesc, 0, self.display);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.latestUpdate != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.latestUpdate);
        }
    }

    public /* synthetic */ AdGameLatestUpdateModule(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str);
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final String getLatestUpdate() {
        return this.latestUpdate;
    }
}