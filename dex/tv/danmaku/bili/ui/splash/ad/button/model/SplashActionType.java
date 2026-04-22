package tv.danmaku.bili.ui.splash.ad.button.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashActionType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/button/model/SplashActionType;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON", "SHAKE", "ROTATE", "ROTATE_BALL", "ROTATE_BALL_THRESHOLD", "SLIDE", "EGG", "CLICKABLE_EGG", "UNDEFINE", "toLiveReserveTriggerTypeValue", "Ltv/danmaku/bili/ui/splash/ad/button/model/LiveReserveTriggerType;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum SplashActionType {
    BUTTON,
    SHAKE,
    ROTATE,
    ROTATE_BALL,
    ROTATE_BALL_THRESHOLD,
    SLIDE,
    EGG,
    CLICKABLE_EGG,
    UNDEFINE;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* compiled from: SplashActionType.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
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

    public static EnumEntries<SplashActionType> getEntries() {
        return $ENTRIES;
    }

    public final LiveReserveTriggerType toLiveReserveTriggerTypeValue() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
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