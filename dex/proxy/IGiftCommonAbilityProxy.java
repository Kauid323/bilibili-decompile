package proxy;

import com.bilibili.bililive.videoliveplayer.ui.roomv3.panel.LiveRoomDispatchUri;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: IGiftCommonAbilityProxy.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bH&J:\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bH&J:\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&J\u0017\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lproxy/IGiftCommonAbilityProxy;", "", "reportClick", "", "eventId", "", "bizData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportShow", "reportTech", "dispatchUrl", "dispatchUri", "Lcom/bilibili/bililive/videoliveplayer/ui/roomv3/panel/LiveRoomDispatchUri;", "h5PageType", "Lproxy/H5PageType;", "openUserCard", "userUid", "", "(Ljava/lang/Long;)V", "openAnchorCard", "uid", "source", "dismissPanel", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IGiftCommonAbilityProxy {
    void dismissPanel();

    void dispatchUrl(LiveRoomDispatchUri liveRoomDispatchUri, H5PageType h5PageType);

    void openAnchorCard(long j, String str);

    void openUserCard(Long l);

    void reportClick(String str, HashMap<String, String> hashMap);

    void reportShow(String str, HashMap<String, String> hashMap);

    void reportTech(String str, HashMap<String, String> hashMap);

    /* compiled from: IGiftCommonAbilityProxy.kt */
    /* renamed from: proxy.IGiftCommonAbilityProxy$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportClick$default(IGiftCommonAbilityProxy iGiftCommonAbilityProxy, String str, HashMap hashMap, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
            }
            if ((i & 2) != 0) {
                hashMap = null;
            }
            iGiftCommonAbilityProxy.reportClick(str, hashMap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportShow$default(IGiftCommonAbilityProxy iGiftCommonAbilityProxy, String str, HashMap hashMap, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportShow");
            }
            if ((i & 2) != 0) {
                hashMap = null;
            }
            iGiftCommonAbilityProxy.reportShow(str, hashMap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportTech$default(IGiftCommonAbilityProxy iGiftCommonAbilityProxy, String str, HashMap hashMap, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportTech");
            }
            if ((i & 2) != 0) {
                hashMap = null;
            }
            iGiftCommonAbilityProxy.reportTech(str, hashMap);
        }

        public static /* synthetic */ void dispatchUrl$default(IGiftCommonAbilityProxy iGiftCommonAbilityProxy, LiveRoomDispatchUri liveRoomDispatchUri, H5PageType h5PageType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchUrl");
            }
            if ((i & 2) != 0) {
                h5PageType = H5PageType.HALF;
            }
            iGiftCommonAbilityProxy.dispatchUrl(liveRoomDispatchUri, h5PageType);
        }
    }
}