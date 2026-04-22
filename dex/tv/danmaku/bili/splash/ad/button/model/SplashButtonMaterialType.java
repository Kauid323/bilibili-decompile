package tv.danmaku.bili.splash.ad.button.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: SplashButtonMaterialType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/splash/ad/button/model/SplashButtonMaterialType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "LOTTIE", "IMAGE", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum SplashButtonMaterialType {
    LOTTIE(0),
    IMAGE(1);
    
    private final int type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<SplashButtonMaterialType> getEntries() {
        return $ENTRIES;
    }

    SplashButtonMaterialType(int type) {
        this.type = type;
    }

    public final int getType() {
        return this.type;
    }
}