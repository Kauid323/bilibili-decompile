package proxy;

import com.bilibili.bililive.componentbridge.BridgeInterface;
import kotlin.Metadata;

/* compiled from: ILiveRoomGiftProxy.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lproxy/ILiveRoomGiftProxy;", "Lproxy/IGiftCommonAbilityProxy;", "Lproxy/IGiftCommonDataProxy;", "Lcom/bilibili/bililive/componentbridge/BridgeInterface;", "roomAbilityProvider", "Lproxy/ILiveRoomAbilityProvider;", "getRoomAbilityProvider", "()Lproxy/ILiveRoomAbilityProvider;", "setRoomAbilityProvider", "(Lproxy/ILiveRoomAbilityProvider;)V", "roomDataProvider", "Lproxy/ILiveRoomDataProvider;", "getRoomDataProvider", "()Lproxy/ILiveRoomDataProvider;", "setRoomDataProvider", "(Lproxy/ILiveRoomDataProvider;)V", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ILiveRoomGiftProxy extends IGiftCommonAbilityProxy, IGiftCommonDataProxy, BridgeInterface {
    ILiveRoomAbilityProvider getRoomAbilityProvider();

    ILiveRoomDataProvider getRoomDataProvider();

    void setRoomAbilityProvider(ILiveRoomAbilityProvider iLiveRoomAbilityProvider);

    void setRoomDataProvider(ILiveRoomDataProvider iLiveRoomDataProvider);
}