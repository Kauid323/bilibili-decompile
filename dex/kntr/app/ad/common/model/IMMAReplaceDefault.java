package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IMMAReplaceDefault.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001R\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/app/ad/common/model/IMMAReplaceDefault;", RoomRecommendViewModel.EMPTY_CURSOR, "macDefaults", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getMacDefaults", "()[Ljava/lang/String;", "setMacDefaults", "([Ljava/lang/String;)V", "mac1Defaults", "getMac1Defaults", "setMac1Defaults", "oaidDefaults", "getOaidDefaults", "setOaidDefaults", "androididDefaults", "getAndroididDefaults", "setAndroididDefaults", "imeiDefaults", "getImeiDefaults", "setImeiDefaults", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMMAReplaceDefault {
    String[] getAndroididDefaults();

    String[] getImeiDefaults();

    String[] getMac1Defaults();

    String[] getMacDefaults();

    String[] getOaidDefaults();

    void setAndroididDefaults(String[] strArr);

    void setImeiDefaults(String[] strArr);

    void setMac1Defaults(String[] strArr);

    void setMacDefaults(String[] strArr);

    void setOaidDefaults(String[] strArr);
}