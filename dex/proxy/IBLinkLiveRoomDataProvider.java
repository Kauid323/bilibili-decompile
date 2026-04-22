package proxy;

import kotlin.Metadata;

/* compiled from: IBlinkLiveRoomGiftProxy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lproxy/IBLinkLiveRoomDataProvider;", "", "getRoomIdentifier", "", "()Ljava/lang/Integer;", "getRoomId", "", "()Ljava/lang/Long;", "getAnchorId", "getLoginUserId", "getParentAreaId", "getAreaId", "isLandscape", "", "getFace", "", "getMedalName", "isLogin", "getAnchorName", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IBLinkLiveRoomDataProvider {
    Long getAnchorId();

    String getAnchorName();

    Long getAreaId();

    String getFace();

    Long getLoginUserId();

    String getMedalName();

    Long getParentAreaId();

    Long getRoomId();

    Integer getRoomIdentifier();

    boolean isLandscape();

    boolean isLogin();
}