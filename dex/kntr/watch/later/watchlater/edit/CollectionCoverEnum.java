package kntr.watch.later.watchlater.edit;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FavFolder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lkntr/watch/later/watchlater/edit/CollectionCoverEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CUSTOM", "VIDEO", "OGV", "AUDIO", "SEASON", "UNKNOWN", "Companion", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum CollectionCoverEnum {
    CUSTOM(0),
    VIDEO(2),
    OGV(24),
    AUDIO(12),
    SEASON(21),
    UNKNOWN(-1);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<CollectionCoverEnum> getEntries() {
        return $ENTRIES;
    }

    CollectionCoverEnum(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }

    /* compiled from: FavFolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkntr/watch/later/watchlater/edit/CollectionCoverEnum$Companion;", "", "<init>", "()V", "get", "Lkntr/watch/later/watchlater/edit/CollectionCoverEnum;", "value", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CollectionCoverEnum get(int value) {
            return value == CollectionCoverEnum.CUSTOM.getValue() ? CollectionCoverEnum.CUSTOM : value == CollectionCoverEnum.VIDEO.getValue() ? CollectionCoverEnum.VIDEO : value == CollectionCoverEnum.OGV.getValue() ? CollectionCoverEnum.OGV : value == CollectionCoverEnum.AUDIO.getValue() ? CollectionCoverEnum.AUDIO : value == CollectionCoverEnum.SEASON.getValue() ? CollectionCoverEnum.SEASON : CollectionCoverEnum.UNKNOWN;
        }
    }
}