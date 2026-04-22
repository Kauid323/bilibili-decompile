package kntr.common.screen.adjust;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KScreenAdjustConfig.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\f¨\u0006\u0012"}, d2 = {"ADJUST_OFF", "", "ADJUST_LARGE", "ADJUST_MEDIUM", "screenAdjustDD", "getScreenAdjustDD", "()Ljava/lang/String;", "screenAdjustDD$delegate", "Lkotlin/Lazy;", "hitScreenAdjustLarge", "", "getHitScreenAdjustLarge", "()Z", "hitScreenAdjustMedium", "getHitScreenAdjustMedium", "hitScreenAdjustForceLargeLandscape", "getHitScreenAdjustForceLargeLandscape", "hitScreenAdjustForceLargeLandscape$delegate", "screen-adjust_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KScreenAdjustConfigKt {
    private static final String ADJUST_OFF = "off";
    private static final Lazy screenAdjustDD$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.screen.adjust.KScreenAdjustConfigKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            String screenAdjustDD_delegate$lambda$0;
            screenAdjustDD_delegate$lambda$0 = KScreenAdjustConfigKt.screenAdjustDD_delegate$lambda$0();
            return screenAdjustDD_delegate$lambda$0;
        }
    });
    private static final String ADJUST_LARGE = "large";
    private static final boolean hitScreenAdjustLarge = Intrinsics.areEqual(ADJUST_LARGE, getScreenAdjustDD());
    private static final String ADJUST_MEDIUM = "medium";
    private static final boolean hitScreenAdjustMedium = Intrinsics.areEqual(ADJUST_MEDIUM, getScreenAdjustDD());
    private static final Lazy hitScreenAdjustForceLargeLandscape$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.screen.adjust.KScreenAdjustConfigKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean hitScreenAdjustForceLargeLandscape_delegate$lambda$0;
            hitScreenAdjustForceLargeLandscape_delegate$lambda$0 = KScreenAdjustConfigKt.hitScreenAdjustForceLargeLandscape_delegate$lambda$0();
            return Boolean.valueOf(hitScreenAdjustForceLargeLandscape_delegate$lambda$0);
        }
    });

    public static final String getScreenAdjustDD() {
        return (String) screenAdjustDD$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String screenAdjustDD_delegate$lambda$0() {
        return KConfig.INSTANCE.config("dd_screen_adjust_xiaomi_864", ADJUST_OFF);
    }

    public static final boolean getHitScreenAdjustLarge() {
        return hitScreenAdjustLarge;
    }

    public static final boolean getHitScreenAdjustMedium() {
        return hitScreenAdjustMedium;
    }

    public static final boolean getHitScreenAdjustForceLargeLandscape() {
        return ((Boolean) hitScreenAdjustForceLargeLandscape$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitScreenAdjustForceLargeLandscape_delegate$lambda$0() {
        return KConfig.INSTANCE.ff("dd_screen_adjust_force_large_landscape_xiaomi_864", false);
    }
}