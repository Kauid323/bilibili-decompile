package kntr.compose.avatar.model.layers;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.DrawSource;
import kntr.compose.avatar.model.layers.ValidResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layer.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/compose/avatar/model/layers/NativeDrawResource;", "Lkntr/compose/avatar/model/layers/ValidResource;", "source", "Lkntr/compose/avatar/model/common/DrawSource;", "<init>", "(Lkntr/compose/avatar/model/common/DrawSource;)V", "getSource", "()Lkntr/compose/avatar/model/common/DrawSource;", "resType", "Lkntr/compose/avatar/model/layers/ResType;", "getResType", "()Lkntr/compose/avatar/model/layers/ResType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NativeDrawResource implements ValidResource {
    private final DrawSource source;

    public static /* synthetic */ NativeDrawResource copy$default(NativeDrawResource nativeDrawResource, DrawSource drawSource, int i, Object obj) {
        if ((i & 1) != 0) {
            drawSource = nativeDrawResource.source;
        }
        return nativeDrawResource.copy(drawSource);
    }

    public final DrawSource component1() {
        return this.source;
    }

    public final NativeDrawResource copy(DrawSource drawSource) {
        Intrinsics.checkNotNullParameter(drawSource, "source");
        return new NativeDrawResource(drawSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NativeDrawResource) && Intrinsics.areEqual(this.source, ((NativeDrawResource) obj).source);
    }

    public int hashCode() {
        return this.source.hashCode();
    }

    public String toString() {
        return "NativeDrawResource(source=" + this.source + ")";
    }

    public NativeDrawResource(DrawSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // kntr.compose.avatar.model.layers.ValidResource, kntr.compose.avatar.model.layers.LayerResource
    public /* bridge */ boolean getShouldDraw() {
        return ValidResource.CC.$default$getShouldDraw(this);
    }

    @Override // kntr.compose.avatar.model.layers.ValidResource, kntr.compose.avatar.model.layers.LayerResource
    public /* bridge */ String getSourceDesc() {
        return ValidResource.CC.$default$getSourceDesc(this);
    }

    @Override // kntr.compose.avatar.model.layers.ValidResource
    public DrawSource getSource() {
        return this.source;
    }

    @Override // kntr.compose.avatar.model.layers.LayerResource
    public ResType getResType() {
        return ResType.NativeDraw;
    }
}