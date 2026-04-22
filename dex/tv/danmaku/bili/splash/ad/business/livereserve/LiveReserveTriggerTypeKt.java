package tv.danmaku.bili.splash.ad.business.livereserve;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;

/* compiled from: LiveReserveTriggerType.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toLiveReserveTriggerType", "Ltv/danmaku/bili/splash/ad/business/livereserve/LiveReserveTriggerType;", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "getToLiveReserveTriggerType", "(Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;)Ltv/danmaku/bili/splash/ad/business/livereserve/LiveReserveTriggerType;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LiveReserveTriggerTypeKt {

    /* compiled from: LiveReserveTriggerType.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SplashActionType.values().length];
            try {
                iArr[SplashActionType.BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SplashActionType.EGG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SplashActionType.CLICKABLE_EGG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SplashActionType.UNDEFINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SplashActionType.SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[SplashActionType.SHAKE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[SplashActionType.ROTATE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[SplashActionType.ROTATE_BALL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[SplashActionType.ROTATE_BALL_THRESHOLD.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final LiveReserveTriggerType getToLiveReserveTriggerType(SplashActionType $this$toLiveReserveTriggerType) {
        Intrinsics.checkNotNullParameter($this$toLiveReserveTriggerType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toLiveReserveTriggerType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return LiveReserveTriggerType.CLICK;
            case 5:
                return LiveReserveTriggerType.SLIDE;
            case 6:
            case 7:
            case 8:
            case 9:
                return LiveReserveTriggerType.SENSOR;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}