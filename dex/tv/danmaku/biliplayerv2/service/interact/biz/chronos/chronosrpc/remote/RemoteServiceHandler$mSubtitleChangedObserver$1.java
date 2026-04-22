package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote;

import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import com.bilibili.lib.accounts.BiliAccounts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.ISubtitleChangedObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageSender;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RemoteServiceHandler.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mSubtitleChangedObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/ISubtitleChangedObserver;", "onSubtitleChanged", "", "mainSubtitle", "Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "viceSubtitle", "onSubtitleDrawRectChanged", "bottomFix", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RemoteServiceHandler$mSubtitleChangedObserver$1 implements ISubtitleChangedObserver {
    final /* synthetic */ RemoteServiceHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteServiceHandler$mSubtitleChangedObserver$1(RemoteServiceHandler $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.ISubtitleChangedObserver
    public void onSubtitleChanged(SubtitleItem mainSubtitle, SubtitleItem viceSubtitle) {
        PlayerContainer playerContainer;
        PlayerContainer playerContainer2;
        PlayerContainer playerContainer3;
        PlayerContainer playerContainer4;
        ChronosMessageSender chronosMessageSender;
        String lan;
        DanmakuConfigChange.Request req = new DanmakuConfigChange.Request();
        playerContainer = this.this$0.mPlayerContainer;
        PlayerContainer playerContainer5 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        boolean isLogin = BiliAccounts.get(playerContainer.getContext()).isLogin();
        playerContainer2 = this.this$0.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        boolean enableFeedbackSubtitle = playerContainer2.getPlayerSettingService().getCloudConfig().enableFeedbackSubtitle();
        DanmakuConfigChange.SubtitleConfig $this$onSubtitleChanged_u24lambda_u240 = new DanmakuConfigChange.SubtitleConfig();
        RemoteServiceHandler remoteServiceHandler = this.this$0;
        String str = "NULL";
        $this$onSubtitleChanged_u24lambda_u240.setLanguage((mainSubtitle == null || (r10 = mainSubtitle.getLan()) == null) ? "NULL" : "NULL");
        if (viceSubtitle != null && (lan = viceSubtitle.getLan()) != null) {
            str = lan;
        }
        $this$onSubtitleChanged_u24lambda_u240.setSecondaryLanguage(str);
        $this$onSubtitleChanged_u24lambda_u240.setEnableEdit(Boolean.valueOf(enableFeedbackSubtitle && isLogin));
        playerContainer3 = remoteServiceHandler.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        $this$onSubtitleChanged_u24lambda_u240.setDraggable(Boolean.valueOf(playerContainer3.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_DRAG, false)));
        playerContainer4 = remoteServiceHandler.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer5 = playerContainer4;
        }
        $this$onSubtitleChanged_u24lambda_u240.setFontMode(playerContainer5.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_LARGE, false) ? 2 : 1);
        req.setSubtitleConfig($this$onSubtitleChanged_u24lambda_u240);
        chronosMessageSender = this.this$0.mChronosRpcSender;
        chronosMessageSender.onDanmakuConfigChanged(req);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.ISubtitleChangedObserver
    public void onSubtitleDrawRectChanged(int bottomFix) {
        this.this$0.updateSubtitleLocationWithViewport(bottomFix);
    }
}