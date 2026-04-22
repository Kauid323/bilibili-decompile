package kntr.app.ad.ui.inspector.core.util;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SettingsManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001b"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/SettingsManager;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "_parseAdextra", "Lkotlinx/coroutines/flow/MutableStateFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "_parseAdcb", "_parseTrackId", "_showNotifications", "parseAdextra", "Lkotlinx/coroutines/flow/StateFlow;", "getParseAdextra", "()Lkotlinx/coroutines/flow/StateFlow;", "parseAdcb", "getParseAdcb", "parseTrackId", "getParseTrackId", "showNotifications", "getShowNotifications", "setParseAdextra", RoomRecommendViewModel.EMPTY_CURSOR, "value", "setParseAdcb", "setParseTrackId", "setShowNotifications", "resetToDefaults", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingsManager {
    public static final SettingsManager INSTANCE = new SettingsManager();
    private static final MutableStateFlow<Boolean> _parseAdextra = StateFlowKt.MutableStateFlow(true);
    private static final MutableStateFlow<Boolean> _parseAdcb = StateFlowKt.MutableStateFlow(true);
    private static final MutableStateFlow<Boolean> _parseTrackId = StateFlowKt.MutableStateFlow(true);
    private static final MutableStateFlow<Boolean> _showNotifications = StateFlowKt.MutableStateFlow(true);
    private static final StateFlow<Boolean> parseAdextra = FlowKt.asStateFlow(_parseAdextra);
    private static final StateFlow<Boolean> parseAdcb = FlowKt.asStateFlow(_parseAdcb);
    private static final StateFlow<Boolean> parseTrackId = FlowKt.asStateFlow(_parseTrackId);
    private static final StateFlow<Boolean> showNotifications = FlowKt.asStateFlow(_showNotifications);
    public static final int $stable = 8;

    private SettingsManager() {
    }

    public final StateFlow<Boolean> getParseAdextra() {
        return parseAdextra;
    }

    public final StateFlow<Boolean> getParseAdcb() {
        return parseAdcb;
    }

    public final StateFlow<Boolean> getParseTrackId() {
        return parseTrackId;
    }

    public final StateFlow<Boolean> getShowNotifications() {
        return showNotifications;
    }

    public final void setParseAdextra(boolean value) {
        _parseAdextra.setValue(Boolean.valueOf(value));
    }

    public final void setParseAdcb(boolean value) {
        _parseAdcb.setValue(Boolean.valueOf(value));
    }

    public final void setParseTrackId(boolean value) {
        _parseTrackId.setValue(Boolean.valueOf(value));
    }

    public final void setShowNotifications(boolean value) {
        _showNotifications.setValue(Boolean.valueOf(value));
    }

    public final void resetToDefaults() {
        setParseAdextra(true);
        setParseAdcb(true);
        setParseTrackId(true);
        setShowNotifications(true);
    }
}