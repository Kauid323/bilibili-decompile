package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IResource.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lkntr/compose/avatar/model/common/LocalSource;", "Lkntr/compose/avatar/model/common/IResource;", "source", "Lkntr/compose/avatar/model/common/LocalSourceEnum;", "<init>", "(Lkntr/compose/avatar/model/common/LocalSourceEnum;)V", "getSource", "()Lkntr/compose/avatar/model/common/LocalSourceEnum;", "type", "Lkntr/compose/avatar/model/common/SourceType;", "getType", "()Lkntr/compose/avatar/model/common/SourceType;", "placeHolder", "getPlaceHolder", "isValidResource", "", "()Z", "descStr", "", "getDescStr", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalSource implements IResource {
    private final LocalSourceEnum source;

    public LocalSource() {
        this(null, 1, null);
    }

    public static /* synthetic */ LocalSource copy$default(LocalSource localSource, LocalSourceEnum localSourceEnum, int i, Object obj) {
        if ((i & 1) != 0) {
            localSourceEnum = localSource.source;
        }
        return localSource.copy(localSourceEnum);
    }

    public final LocalSourceEnum component1() {
        return this.source;
    }

    public final LocalSource copy(LocalSourceEnum localSourceEnum) {
        Intrinsics.checkNotNullParameter(localSourceEnum, "source");
        return new LocalSource(localSourceEnum);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalSource) && this.source == ((LocalSource) obj).source;
    }

    public int hashCode() {
        return this.source.hashCode();
    }

    public String toString() {
        return "LocalSource(source=" + this.source + ")";
    }

    public LocalSource(LocalSourceEnum source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public /* synthetic */ LocalSource(LocalSourceEnum localSourceEnum, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LocalSourceEnum.Invalid : localSourceEnum);
    }

    public final LocalSourceEnum getSource() {
        return this.source;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public SourceType getType() {
        return SourceType.LocalSource;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public LocalSourceEnum getPlaceHolder() {
        return LocalSourceEnum.Invalid;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public boolean isValidResource() {
        return this.source != LocalSourceEnum.Invalid;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public String getDescStr() {
        return "LocalSource: " + this.source.name();
    }
}