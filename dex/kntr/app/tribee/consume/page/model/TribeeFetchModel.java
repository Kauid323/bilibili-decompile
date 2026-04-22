package kntr.app.tribee.consume.page.model;

import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeFetchModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/consume/page/model/TribeeFetchModel;", "", "fromAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "fetchIdentity", "", "<init>", "(Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;I)V", "getFromAction", "()Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "getFetchIdentity", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeFetchModel {
    public static final int $stable = 8;
    private final int fetchIdentity;
    private final TribeeHomeStateAction fromAction;

    public TribeeFetchModel() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ TribeeFetchModel copy$default(TribeeFetchModel tribeeFetchModel, TribeeHomeStateAction tribeeHomeStateAction, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            tribeeHomeStateAction = tribeeFetchModel.fromAction;
        }
        if ((i2 & 2) != 0) {
            i = tribeeFetchModel.fetchIdentity;
        }
        return tribeeFetchModel.copy(tribeeHomeStateAction, i);
    }

    public final TribeeHomeStateAction component1() {
        return this.fromAction;
    }

    public final int component2() {
        return this.fetchIdentity;
    }

    public final TribeeFetchModel copy(TribeeHomeStateAction tribeeHomeStateAction, int i) {
        return new TribeeFetchModel(tribeeHomeStateAction, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeFetchModel) {
            TribeeFetchModel tribeeFetchModel = (TribeeFetchModel) obj;
            return Intrinsics.areEqual(this.fromAction, tribeeFetchModel.fromAction) && this.fetchIdentity == tribeeFetchModel.fetchIdentity;
        }
        return false;
    }

    public int hashCode() {
        return ((this.fromAction == null ? 0 : this.fromAction.hashCode()) * 31) + this.fetchIdentity;
    }

    public String toString() {
        TribeeHomeStateAction tribeeHomeStateAction = this.fromAction;
        return "TribeeFetchModel(fromAction=" + tribeeHomeStateAction + ", fetchIdentity=" + this.fetchIdentity + ")";
    }

    public TribeeFetchModel(TribeeHomeStateAction fromAction, int fetchIdentity) {
        this.fromAction = fromAction;
        this.fetchIdentity = fetchIdentity;
    }

    public /* synthetic */ TribeeFetchModel(TribeeHomeStateAction tribeeHomeStateAction, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : tribeeHomeStateAction, (i2 & 2) != 0 ? 0 : i);
    }

    public final TribeeHomeStateAction getFromAction() {
        return this.fromAction;
    }

    public final int getFetchIdentity() {
        return this.fetchIdentity;
    }
}