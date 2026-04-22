package tv.danmaku.video.bilicardplayer;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bilibili.bililive.danmaku.wrapper.core.comment.CommentItem;
import com.bilibili.bililive.danmaku.wrapper.core.comment.LiveExtendItem;
import com.bilibili.bililive.infra.socketbuilder.inline.danmaku.ILiveInlineDanmakuDispatcher;
import com.bilibili.bililive.infra.socketbuilder.inline.danmaku.ILiveInlineDanmakuParser;
import com.bilibili.bililive.infra.socketbuilder.inline.danmaku.LiveInlineDanmakuParser;
import com.bilibili.bililive.infra.socketbuilder.inline.emoticon.LiveInlineEmoticonManager;
import com.bilibili.bililive.infra.socketbuilder.inline.socket.ILiveInlineSocketManager;
import com.bilibili.bililive.infra.socketbuilder.inline.socket.LiveInlineSocketManager;
import com.bilibili.bililive.infra.socketbuilder.inline.socket.callback.ILiveInlineSocketStateCallback;
import com.bilibili.bililive.videoliveplayer.net.beans.BiliLiveRoomHistoryMsg;
import com.bilibili.common.chronoscommon.ChronosPackageManager;
import com.bilibili.cron.ChronosPackage;
import com.bilibili.playerbizcommon.utils.PlayerExtensionsKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.utils.ChronosUtils;

/* compiled from: CardDanmakuManager.kt */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001 \u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u001eH\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u001eJ\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020&JK\u0010-\u001a\"\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020/\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020/\u0018\u0001`02\b\u00101\u001a\u0004\u0018\u00010\u001e2\b\u00102\u001a\u0004\u0018\u00010#2\b\u00103\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u00104R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00066"}, d2 = {"Ltv/danmaku/video/bilicardplayer/CardDanmakuManager;", "", "<init>", "()V", "mLiveInlineSocketManager", "Lcom/bilibili/bililive/infra/socketbuilder/inline/socket/LiveInlineSocketManager;", "getMLiveInlineSocketManager", "()Lcom/bilibili/bililive/infra/socketbuilder/inline/socket/LiveInlineSocketManager;", "mLiveInlineSocketManager$delegate", "Lkotlin/Lazy;", "mLiveInlineDanmakuParser", "Lcom/bilibili/bililive/infra/socketbuilder/inline/danmaku/LiveInlineDanmakuParser;", "getMLiveInlineDanmakuParser", "()Lcom/bilibili/bililive/infra/socketbuilder/inline/danmaku/LiveInlineDanmakuParser;", "mLiveInlineDanmakuParser$delegate", "mLiveInlineEmoticonManager", "Lcom/bilibili/bililive/infra/socketbuilder/inline/emoticon/LiveInlineEmoticonManager;", "getMLiveInlineEmoticonManager", "()Lcom/bilibili/bililive/infra/socketbuilder/inline/emoticon/LiveInlineEmoticonManager;", "mLiveInlineEmoticonManager$delegate", "mChronosApiResolver", "Ltv/danmaku/video/bilicardplayer/CardPlayerChronosApiResolver;", "getMChronosApiResolver", "()Ltv/danmaku/video/bilicardplayer/CardPlayerChronosApiResolver;", "mChronosApiResolver$delegate", "mCurrRoomId", "", "mCardDanmakuCallback", "Ltv/danmaku/video/bilicardplayer/CardDanmakuCallback;", "mSocketScene", "", "mChronosApiResolveCallback", "tv/danmaku/video/bilicardplayer/CardDanmakuManager$mChronosApiResolveCallback$1", "Ltv/danmaku/video/bilicardplayer/CardDanmakuManager$mChronosApiResolveCallback$1;", "getRecScore", "", "extra", "initLiveDanmaku", "", "roomId", "setSocketScene", LoginSceneProcessor.SCENE_KEY, "registerCardDanmakuCallback", "callback", "release", "getEmoticonMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "url", "width", "height", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/util/HashMap;", "Companion", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardDanmakuManager {
    public static final Companion Companion = new Companion(null);
    public static final long INVALID_ROOM_ID = -1;
    public static final String TAG = "CardDanmakuManager";
    private CardDanmakuCallback mCardDanmakuCallback;
    private long mCurrRoomId;
    private final Lazy mLiveInlineSocketManager$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.bilicardplayer.CardDanmakuManager$$ExternalSyntheticLambda0
        public final Object invoke() {
            LiveInlineSocketManager mLiveInlineSocketManager_delegate$lambda$0;
            mLiveInlineSocketManager_delegate$lambda$0 = CardDanmakuManager.mLiveInlineSocketManager_delegate$lambda$0();
            return mLiveInlineSocketManager_delegate$lambda$0;
        }
    });
    private final Lazy mLiveInlineDanmakuParser$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.bilicardplayer.CardDanmakuManager$$ExternalSyntheticLambda1
        public final Object invoke() {
            LiveInlineDanmakuParser mLiveInlineDanmakuParser_delegate$lambda$0;
            mLiveInlineDanmakuParser_delegate$lambda$0 = CardDanmakuManager.mLiveInlineDanmakuParser_delegate$lambda$0();
            return mLiveInlineDanmakuParser_delegate$lambda$0;
        }
    });
    private final Lazy mLiveInlineEmoticonManager$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.bilicardplayer.CardDanmakuManager$$ExternalSyntheticLambda2
        public final Object invoke() {
            LiveInlineEmoticonManager mLiveInlineEmoticonManager_delegate$lambda$0;
            mLiveInlineEmoticonManager_delegate$lambda$0 = CardDanmakuManager.mLiveInlineEmoticonManager_delegate$lambda$0();
            return mLiveInlineEmoticonManager_delegate$lambda$0;
        }
    });
    private final Lazy mChronosApiResolver$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.bilicardplayer.CardDanmakuManager$$ExternalSyntheticLambda3
        public final Object invoke() {
            CardPlayerChronosApiResolver mChronosApiResolver_delegate$lambda$0;
            mChronosApiResolver_delegate$lambda$0 = CardDanmakuManager.mChronosApiResolver_delegate$lambda$0();
            return mChronosApiResolver_delegate$lambda$0;
        }
    });
    private String mSocketScene = "";
    private final CardDanmakuManager$mChronosApiResolveCallback$1 mChronosApiResolveCallback = new ChronosApiResolveCallback() { // from class: tv.danmaku.video.bilicardplayer.CardDanmakuManager$mChronosApiResolveCallback$1
        @Override // tv.danmaku.video.bilicardplayer.ChronosApiResolveCallback
        public void onResolveSuccess(ChronosPackage result) {
            CardDanmakuCallback cardDanmakuCallback;
            LiveInlineSocketManager mLiveInlineSocketManager;
            long j;
            String str;
            ILiveInlineDanmakuParser mLiveInlineDanmakuParser;
            ILiveInlineSocketManager mLiveInlineSocketManager2;
            cardDanmakuCallback = CardDanmakuManager.this.mCardDanmakuCallback;
            if (cardDanmakuCallback != null) {
                cardDanmakuCallback.onResolveChronosPkgSuccess(result);
            }
            mLiveInlineSocketManager = CardDanmakuManager.this.getMLiveInlineSocketManager();
            j = CardDanmakuManager.this.mCurrRoomId;
            str = CardDanmakuManager.this.mSocketScene;
            mLiveInlineSocketManager.connect(j, str, (ILiveInlineSocketStateCallback) null);
            mLiveInlineDanmakuParser = CardDanmakuManager.this.getMLiveInlineDanmakuParser();
            ILiveInlineDanmakuParser iLiveInlineDanmakuParser = mLiveInlineDanmakuParser;
            mLiveInlineSocketManager2 = CardDanmakuManager.this.getMLiveInlineSocketManager();
            final CardDanmakuManager cardDanmakuManager = CardDanmakuManager.this;
            ILiveInlineDanmakuParser.-CC.observeOriginDanmaku$default(iLiveInlineDanmakuParser, mLiveInlineSocketManager2, new ILiveInlineDanmakuDispatcher() { // from class: tv.danmaku.video.bilicardplayer.CardDanmakuManager$mChronosApiResolveCallback$1$onResolveSuccess$1
                /* JADX WARN: Code restructure failed: missing block: B:58:0x011b, code lost:
                    r4 = (r2 = r1).mCardDanmakuCallback;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void dispatchDanmaku(LiveExtendItem item, int type) {
                    CommentItem originItem;
                    int recScore;
                    CardDanmakuCallback cardDanmakuCallback2;
                    CardDanmakuManager cardDanmakuManager2;
                    CardDanmakuCallback cardDanmakuCallback3;
                    HashMap<String, byte[]> emoticonMap;
                    HashMap<String, byte[]> emoticonMap2;
                    if (item == null) {
                        return;
                    }
                    BLog.d(CardDanmakuManager.TAG, "live danmaku dispatched, content:" + (item.getOriginItem() != null ? originItem.getText() : null));
                    AddCustomDanmaku.LiveExtra $this$dispatchDanmaku_u24lambda_u240 = new AddCustomDanmaku.LiveExtra();
                    CardDanmakuManager cardDanmakuManager3 = CardDanmakuManager.this;
                    $this$dispatchDanmaku_u24lambda_u240.setMode(Integer.valueOf(item.getMode()));
                    CommentItem originItem2 = item.getOriginItem();
                    $this$dispatchDanmaku_u24lambda_u240.setUserHash(originItem2 != null ? originItem2.mPublisherId : null);
                    CommentItem originItem3 = item.getOriginItem();
                    $this$dispatchDanmaku_u24lambda_u240.setContent(originItem3 != null ? originItem3.getText() : null);
                    CommentItem originItem4 = item.getOriginItem();
                    $this$dispatchDanmaku_u24lambda_u240.setColor(String.valueOf(originItem4 != null ? Integer.valueOf(originItem4.getViewTextColor()) : null));
                    CommentItem originItem5 = item.getOriginItem();
                    boolean z = false;
                    if (originItem5 != null && originItem5.mSentFromMe) {
                        z = true;
                    }
                    $this$dispatchDanmaku_u24lambda_u240.setSendFromMe(Boolean.valueOf(z));
                    CommentItem originItem6 = item.getOriginItem();
                    $this$dispatchDanmaku_u24lambda_u240.setPlayerMode(originItem6 != null ? Integer.valueOf(originItem6.getCommentType()) : null);
                    CommentItem originItem7 = item.getOriginItem();
                    $this$dispatchDanmaku_u24lambda_u240.setFontSize(originItem7 != null ? Integer.valueOf(originItem7.mSize) : null);
                    $this$dispatchDanmaku_u24lambda_u240.setDmType(Integer.valueOf(item.getDmType()));
                    BiliLiveRoomHistoryMsg.Msg.EmoticonInfo emoticonDMInfo = item.getEmoticonDMInfo();
                    $this$dispatchDanmaku_u24lambda_u240.setBulgeDisplay(emoticonDMInfo != null ? Integer.valueOf(emoticonDMInfo.bulgeDisplay) : null);
                    recScore = cardDanmakuManager3.getRecScore(item.getExtra());
                    $this$dispatchDanmaku_u24lambda_u240.setRecommendScore(Integer.valueOf(recScore));
                    cardDanmakuCallback2 = cardDanmakuManager3.mCardDanmakuCallback;
                    if (cardDanmakuCallback2 != null) {
                        CommentItem originItem8 = item.getOriginItem();
                        String valueOf = String.valueOf(originItem8 != null ? originItem8.mRemoteDmId : null);
                        BiliLiveRoomHistoryMsg.Msg.EmoticonInfo emoticonDMInfo2 = item.getEmoticonDMInfo();
                        String str2 = emoticonDMInfo2 != null ? emoticonDMInfo2.url : null;
                        BiliLiveRoomHistoryMsg.Msg.EmoticonInfo emoticonDMInfo3 = item.getEmoticonDMInfo();
                        Integer valueOf2 = emoticonDMInfo3 != null ? Integer.valueOf(emoticonDMInfo3.width) : null;
                        BiliLiveRoomHistoryMsg.Msg.EmoticonInfo emoticonDMInfo4 = item.getEmoticonDMInfo();
                        emoticonMap2 = cardDanmakuManager3.getEmoticonMap(str2, valueOf2, emoticonDMInfo4 != null ? Integer.valueOf(emoticonDMInfo4.height) : null);
                        cardDanmakuCallback2.onLiveDanmakuComing(valueOf, $this$dispatchDanmaku_u24lambda_u240, emoticonMap2);
                    }
                    String it = item.getNewRawDanmuMessage();
                    if (it != null && cardDanmakuCallback3 != null) {
                        CommentItem originItem9 = item.getOriginItem();
                        String valueOf3 = String.valueOf(originItem9 != null ? originItem9.mRemoteDmId : null);
                        BiliLiveRoomHistoryMsg.Msg.EmoticonInfo emoticonDMInfo5 = item.getEmoticonDMInfo();
                        String str3 = emoticonDMInfo5 != null ? emoticonDMInfo5.url : null;
                        BiliLiveRoomHistoryMsg.Msg.EmoticonInfo emoticonDMInfo6 = item.getEmoticonDMInfo();
                        Integer valueOf4 = emoticonDMInfo6 != null ? Integer.valueOf(emoticonDMInfo6.width) : null;
                        BiliLiveRoomHistoryMsg.Msg.EmoticonInfo emoticonDMInfo7 = item.getEmoticonDMInfo();
                        emoticonMap = cardDanmakuManager2.getEmoticonMap(str3, valueOf4, emoticonDMInfo7 != null ? Integer.valueOf(emoticonDMInfo7.height) : null);
                        cardDanmakuCallback3.onLiveDanmakuComingV2(valueOf3, it, emoticonMap);
                    }
                }
            }, false, false, (LruCache) null, 28, (Object) null);
        }

        @Override // tv.danmaku.video.bilicardplayer.ChronosApiResolveCallback
        public void onResolveFail() {
            BLog.d(CardDanmakuManager.TAG, "resolve chronos package failed");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveInlineSocketManager getMLiveInlineSocketManager() {
        return (LiveInlineSocketManager) this.mLiveInlineSocketManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveInlineSocketManager mLiveInlineSocketManager_delegate$lambda$0() {
        return new LiveInlineSocketManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveInlineDanmakuParser getMLiveInlineDanmakuParser() {
        return (LiveInlineDanmakuParser) this.mLiveInlineDanmakuParser$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveInlineDanmakuParser mLiveInlineDanmakuParser_delegate$lambda$0() {
        return new LiveInlineDanmakuParser();
    }

    private final LiveInlineEmoticonManager getMLiveInlineEmoticonManager() {
        return (LiveInlineEmoticonManager) this.mLiveInlineEmoticonManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveInlineEmoticonManager mLiveInlineEmoticonManager_delegate$lambda$0() {
        return new LiveInlineEmoticonManager();
    }

    private final CardPlayerChronosApiResolver getMChronosApiResolver() {
        return (CardPlayerChronosApiResolver) this.mChronosApiResolver$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardPlayerChronosApiResolver mChronosApiResolver_delegate$lambda$0() {
        return new CardPlayerChronosApiResolver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getRecScore(String extra) {
        if (extra == null) {
            return 0;
        }
        try {
            JSONObject json = new JSONObject(extra);
            return json.optInt("recommend_score");
        } catch (Throwable t) {
            BLog.d(TAG, t.getMessage());
            return 0;
        }
    }

    public final void initLiveDanmaku(long roomId) {
        BLog.d(TAG, "init live danmaku, room id= " + roomId);
        this.mCurrRoomId = roomId;
        getMChronosApiResolver().setResolveCallback(this.mChronosApiResolveCallback);
        getMChronosApiResolver().resolve(ChronosPackageManager.Service.DFM);
    }

    public final void setSocketScene(String scene) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        if (scene.length() == 0) {
            return;
        }
        this.mSocketScene = scene;
        getMLiveInlineSocketManager().setSocketScene(scene);
    }

    public final void registerCardDanmakuCallback(CardDanmakuCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCardDanmakuCallback = callback;
    }

    public final void release() {
        BLog.d(TAG, "disconnect live danmaku socket, room id= " + this.mCurrRoomId);
        getMLiveInlineDanmakuParser().release();
        if (this.mCurrRoomId != -1) {
            getMLiveInlineSocketManager().disconnect();
        }
        this.mCurrRoomId = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, byte[]> getEmoticonMap(String url, Integer width, Integer height) {
        if (PlayerExtensionsKt.anyNull(new Object[]{url, width, height})) {
            return null;
        }
        LiveInlineEmoticonManager mLiveInlineEmoticonManager = getMLiveInlineEmoticonManager();
        Intrinsics.checkNotNull(url);
        Bitmap bitmap = mLiveInlineEmoticonManager.getCacheBitmap(url);
        if (bitmap != null) {
            byte[] bytes = String.valueOf(width).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = String.valueOf(height).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("emoticon", ChronosUtils.INSTANCE.bitmapToRgba(bitmap)), TuplesKt.to("emotIconWidth", bytes), TuplesKt.to("emotIconHeight", bytes2)});
        }
        return null;
    }

    /* compiled from: CardDanmakuManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/video/bilicardplayer/CardDanmakuManager$Companion;", "", "<init>", "()V", "TAG", "", "INVALID_ROOM_ID", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}