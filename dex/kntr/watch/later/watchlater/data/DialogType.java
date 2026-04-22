package kntr.watch.later.watchlater.data;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: WLState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/watch/later/watchlater/data/DialogType;", "", "DeleteWatched", "DeleteInvalid", "DeleteChecked", "Lkntr/watch/later/watchlater/data/DialogType$DeleteChecked;", "Lkntr/watch/later/watchlater/data/DialogType$DeleteInvalid;", "Lkntr/watch/later/watchlater/data/DialogType$DeleteWatched;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface DialogType {

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/DialogType$DeleteWatched;", "Lkntr/watch/later/watchlater/data/DialogType;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeleteWatched implements DialogType {
        public static final int $stable = 0;
        public static final DeleteWatched INSTANCE = new DeleteWatched();

        private DeleteWatched() {
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/DialogType$DeleteInvalid;", "Lkntr/watch/later/watchlater/data/DialogType;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeleteInvalid implements DialogType {
        public static final int $stable = 0;
        public static final DeleteInvalid INSTANCE = new DeleteInvalid();

        private DeleteInvalid() {
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/DialogType$DeleteChecked;", "Lkntr/watch/later/watchlater/data/DialogType;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeleteChecked implements DialogType {
        public static final int $stable = 0;
        public static final DeleteChecked INSTANCE = new DeleteChecked();

        private DeleteChecked() {
        }
    }
}