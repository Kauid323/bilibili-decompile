package kntr.app.tribee.publish;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;

/* compiled from: TribeeInputHintHelper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/TribeeInputHintHelper;", "", "<init>", "()V", "TITLE_HINT_KEY", "", "INPUT_HINT_KEY", "titleHint", "getTitleHint", "()Ljava/lang/String;", "inputHint", "getInputHint", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInputHintHelper {
    public static final int $stable = 0;
    private static final String INPUT_HINT_KEY = "tribee.tribee_input_hint_input";
    public static final TribeeInputHintHelper INSTANCE = new TribeeInputHintHelper();
    private static final String TITLE_HINT_KEY = "tribee.tribee_input_hint_title";
    private static final String inputHint;
    private static final String titleHint;

    private TribeeInputHintHelper() {
    }

    static {
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, TITLE_HINT_KEY, null, 2, null);
        if (config$default == null) {
            config$default = "";
        }
        titleHint = config$default;
        String config$default2 = IPlatformConfig.CC.config$default(KConfig.INSTANCE, INPUT_HINT_KEY, null, 2, null);
        inputHint = config$default2 != null ? config$default2 : "";
    }

    public final String getTitleHint() {
        return titleHint;
    }

    public final String getInputHint() {
        return inputHint;
    }
}