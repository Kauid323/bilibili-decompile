package proxy;

import com.bilibili.bililive.videoliveplayer.net.beans.gift.LiveGiftPanelMicUserInfo;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IGiftParentBizContext.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lproxy/IGiftParentBizContext;", "Lproxy/IGiftCommonDataProxy;", "Lproxy/IGiftCommonAbilityProxy;", "getBizSource", "", "isLiveStream", "", "getMicAreaMicUserList", "", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/LiveGiftPanelMicUserInfo;", "addSocketDuplicate", "", "duplicate", "removeSocketDuplicate", "socketContainDuplicate", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IGiftParentBizContext extends IGiftCommonDataProxy, IGiftCommonAbilityProxy {
    void addSocketDuplicate(String str);

    String getBizSource();

    List<LiveGiftPanelMicUserInfo> getMicAreaMicUserList();

    boolean isLiveStream();

    void removeSocketDuplicate(String str);

    boolean socketContainDuplicate(String str);
}