package kntr.app.digital.preview.splashsetting;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* compiled from: DLCSplashCardInfo.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u000eHÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lkntr/app/digital/preview/splashsetting/DLCSplashCardInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "result", "Lkotlinx/serialization/json/JsonElement;", "<init>", "(Lkotlinx/serialization/json/JsonElement;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResult", "()Lkotlinx/serialization/json/JsonElement;", "resultJsonString", RoomRecommendViewModel.EMPTY_CURSOR, "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class DLCSplashCardInfo {
    private final JsonElement result;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ DLCSplashCardInfo copy$default(DLCSplashCardInfo dLCSplashCardInfo, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonElement = dLCSplashCardInfo.result;
        }
        return dLCSplashCardInfo.copy(jsonElement);
    }

    public final JsonElement component1() {
        return this.result;
    }

    public final DLCSplashCardInfo copy(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "result");
        return new DLCSplashCardInfo(jsonElement);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DLCSplashCardInfo) && Intrinsics.areEqual(this.result, ((DLCSplashCardInfo) obj).result);
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "DLCSplashCardInfo(result=" + this.result + ")";
    }

    /* compiled from: DLCSplashCardInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/splashsetting/DLCSplashCardInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/splashsetting/DLCSplashCardInfo;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DLCSplashCardInfo> serializer() {
            return DLCSplashCardInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DLCSplashCardInfo(int seen0, JsonElement result, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, DLCSplashCardInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.result = result;
    }

    public DLCSplashCardInfo(JsonElement result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
    }

    public final JsonElement getResult() {
        return this.result;
    }

    public final String resultJsonString() {
        return Json.Default.encodeToString(JsonElement.Companion.serializer(), this.result);
    }
}