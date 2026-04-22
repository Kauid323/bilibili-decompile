package proxy;

import com.bilibili.bililive.componentbridge.BridgeInterface;
import kotlin.Metadata;

/* compiled from: IBlinkLiveRoomGiftProxy.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lproxy/IBlinkLiveRoomGiftProxy;", "Lproxy/IGiftCommonDataProxy;", "Lproxy/IGiftCommonAbilityProxy;", "Lcom/bilibili/bililive/componentbridge/BridgeInterface;", "blinkRoomAbilityProvider", "Lproxy/IBLinkLiveRoomAbilityProvider;", "getBlinkRoomAbilityProvider", "()Lproxy/IBLinkLiveRoomAbilityProvider;", "setBlinkRoomAbilityProvider", "(Lproxy/IBLinkLiveRoomAbilityProvider;)V", "blinkRoomDataProvider", "Lproxy/IBLinkLiveRoomDataProvider;", "getBlinkRoomDataProvider", "()Lproxy/IBLinkLiveRoomDataProvider;", "setBlinkRoomDataProvider", "(Lproxy/IBLinkLiveRoomDataProvider;)V", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IBlinkLiveRoomGiftProxy extends IGiftCommonDataProxy, IGiftCommonAbilityProxy, BridgeInterface {
    IBLinkLiveRoomAbilityProvider getBlinkRoomAbilityProvider();

    IBLinkLiveRoomDataProvider getBlinkRoomDataProvider();

    void setBlinkRoomAbilityProvider(IBLinkLiveRoomAbilityProvider iBLinkLiveRoomAbilityProvider);

    void setBlinkRoomDataProvider(IBLinkLiveRoomDataProvider iBLinkLiveRoomDataProvider);
}