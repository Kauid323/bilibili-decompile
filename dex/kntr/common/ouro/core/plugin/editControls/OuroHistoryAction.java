package kntr.common.ouro.core.plugin.editControls;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kotlin.Metadata;

/* compiled from: OuroHistoryPlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction;", "Lkntr/common/ouro/core/action/OuroAction;", "Undo", "Redo", "Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction$Redo;", "Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction$Undo;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroHistoryAction extends OuroAction {

    /* compiled from: OuroHistoryPlugin.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction$Undo;", "Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Undo implements OuroHistoryAction {
        public static final Undo INSTANCE = new Undo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Undo) {
                Undo undo = (Undo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -862546568;
        }

        public String toString() {
            return "Undo";
        }

        private Undo() {
        }
    }

    /* compiled from: OuroHistoryPlugin.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction$Redo;", "Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Redo implements OuroHistoryAction {
        public static final Redo INSTANCE = new Redo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Redo) {
                Redo redo = (Redo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -862644590;
        }

        public String toString() {
            return "Redo";
        }

        private Redo() {
        }
    }
}