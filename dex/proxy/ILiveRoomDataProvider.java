package proxy;

import com.bilibili.bililive.infra.arch.jetpack.liveData.SafeMutableLiveData;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.roominfo.BiliLiveRoomInfo;
import com.bilibili.bililive.videoliveplayer.net.beans.gateway.userinfo.BiliLiveRoomUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: ILiveRoomGiftProxy.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\u000fH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0018\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0018j\b\u0012\u0004\u0012\u00020\u0003`\u0019H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001bH&J$\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001dj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u001eH&J\b\u0010\u001f\u001a\u00020\rH&J\b\u0010 \u001a\u00020\rH&J\b\u0010!\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Lproxy/ILiveRoomDataProvider;", "", "getRoomIdentifier", "", "()Ljava/lang/Integer;", "getRoomId", "", "()Ljava/lang/Long;", "getAnchorId", "getLoginUserId", "getParentAreaId", "getAreaId", "isLandscape", "", "getUserFace", "", "getAnchorFace", "isLogin", "getAnchorName", "getRoomUserInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/userinfo/BiliLiveRoomUserInfo;", "getRoomInfo", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gateway/roominfo/BiliLiveRoomInfo;", "getSpecialTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "observeScreenMode", "Lcom/bilibili/bililive/infra/arch/jetpack/liveData/SafeMutableLiveData;", "getRoomReportInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isOfficialRoom", "isOfficialShowing", "isLiving", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ILiveRoomDataProvider {
    String getAnchorFace();

    Long getAnchorId();

    String getAnchorName();

    Long getAreaId();

    Long getLoginUserId();

    Long getParentAreaId();

    Long getRoomId();

    Integer getRoomIdentifier();

    BiliLiveRoomInfo getRoomInfo();

    HashMap<String, String> getRoomReportInfo();

    BiliLiveRoomUserInfo getRoomUserInfo();

    ArrayList<Integer> getSpecialTypeList();

    String getUserFace();

    boolean isLandscape();

    boolean isLiving();

    boolean isLogin();

    boolean isOfficialRoom();

    boolean isOfficialShowing();

    SafeMutableLiveData<Boolean> observeScreenMode();
}