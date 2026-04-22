package kntr.app.digital.preview.api;

import kntr.app.digital.preview.reshaping.ReshapingAction;
import kntr.app.digital.preview.reshaping.ReshapingAction$$serializer;
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

/* compiled from: CardPreviewModel.kt */
@SerialName("reshaping")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lkntr/app/digital/preview/api/ReshapingModel;", "Lkntr/app/digital/preview/api/ActionItem;", "title", RoomRecommendViewModel.EMPTY_CURSOR, "data", "Lkntr/app/digital/preview/reshaping/ReshapingAction;", "<init>", "(Ljava/lang/String;Lkntr/app/digital/preview/reshaping/ReshapingAction;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/digital/preview/reshaping/ReshapingAction;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getData", "()Lkntr/app/digital/preview/reshaping/ReshapingAction;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ReshapingModel implements ActionItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final ReshapingAction data;
    private final String title;

    public static /* synthetic */ ReshapingModel copy$default(ReshapingModel reshapingModel, String str, ReshapingAction reshapingAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reshapingModel.title;
        }
        if ((i & 2) != 0) {
            reshapingAction = reshapingModel.data;
        }
        return reshapingModel.copy(str, reshapingAction);
    }

    public final String component1() {
        return this.title;
    }

    public final ReshapingAction component2() {
        return this.data;
    }

    public final ReshapingModel copy(String str, ReshapingAction reshapingAction) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(reshapingAction, "data");
        return new ReshapingModel(str, reshapingAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReshapingModel) {
            ReshapingModel reshapingModel = (ReshapingModel) obj;
            return Intrinsics.areEqual(this.title, reshapingModel.title) && Intrinsics.areEqual(this.data, reshapingModel.data);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "ReshapingModel(title=" + str + ", data=" + this.data + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/ReshapingModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/ReshapingModel;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReshapingModel> serializer() {
            return ReshapingModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ReshapingModel(int seen0, String title, ReshapingAction data, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, ReshapingModel$$serializer.INSTANCE.getDescriptor());
        }
        this.title = title;
        this.data = data;
    }

    public ReshapingModel(String title, ReshapingAction data) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(data, "data");
        this.title = title;
        this.data = data;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(ReshapingModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getTitle());
        output.encodeSerializableElement(serialDesc, 1, ReshapingAction$$serializer.INSTANCE, self.data);
    }

    @Override // kntr.app.digital.preview.api.ActionItem
    public String getTitle() {
        return this.title;
    }

    public final ReshapingAction getData() {
        return this.data;
    }
}