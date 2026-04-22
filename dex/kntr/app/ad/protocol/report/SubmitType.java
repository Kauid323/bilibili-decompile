package kntr.app.ad.protocol.report;

import kotlin.Metadata;

/* compiled from: SubmitType.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/ad/protocol/report/SubmitType;", "", "<init>", "()V", "MMA_KEY_SHOW", "", "MMA_KEY_CLICK", "MMA_KEY_PLAY", "MMA_KEY_DEFAULT", "mapToType", "actionFrom", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubmitType {
    public static final SubmitType INSTANCE = new SubmitType();
    public static final String MMA_KEY_CLICK = "click";
    private static final String MMA_KEY_DEFAULT = "";
    public static final String MMA_KEY_PLAY = "play";
    public static final String MMA_KEY_SHOW = "show";

    private SubmitType() {
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x007b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String mapToType(String actionFrom) {
        if (actionFrom != null) {
            switch (actionFrom.hashCode()) {
                case -1903289114:
                    if (actionFrom.equals(SubmitActionFrom.MMA_KEY_SHOW_URLS)) {
                        return "show";
                    }
                    break;
                case -1300464360:
                    if (actionFrom.equals(SubmitActionFrom.MMA_KEY_PLAY_3S_URLS)) {
                        return MMA_KEY_PLAY;
                    }
                    break;
                case -776859333:
                    if (actionFrom.equals(SubmitActionFrom.MMA_KEY_CLICK_URLS)) {
                        return "click";
                    }
                    break;
                case 117809068:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_BUTTON_CLICK_URLS)) {
                    }
                    break;
                case 285415180:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PLAY_CUSTOMS_URLS)) {
                    }
                    break;
                case 300715714:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PROCESS0_URLS)) {
                    }
                    break;
                case 329344865:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PROCESS1_URLS)) {
                    }
                    break;
                case 357974016:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PROCESS2_URLS)) {
                    }
                    break;
                case 368813242:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PLAY_10S_URLS)) {
                    }
                    break;
                case 386603167:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PROCESS3_URLS)) {
                    }
                    break;
                case 415232318:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PROCESS4_URLS)) {
                    }
                    break;
                case 474543002:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PLAY_5S_URLS)) {
                    }
                    break;
                case 511364351:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_PLAY_15S_URLS)) {
                    }
                    break;
                case 1068334431:
                    if (!actionFrom.equals(SubmitActionFrom.MMA_KEY_SHOW_1S_URLS)) {
                    }
                    break;
            }
        }
        return "";
    }
}