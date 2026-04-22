package tv.danmaku.biliplayerv2.service.interact.biz.container;

import com.bapis.bilibili.app.distribution.GetUserPreferenceReply;
import com.bapis.bilibili.app.distribution.setting.play.SpecificPlayConfig;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.google.protobuf.Any;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosInteractContainer.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"tv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer$mSegmentSwitch$2$1", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/app/distribution/GetUserPreferenceReply;", "onNext", "", "value", "onError", "t", "Lcom/bilibili/lib/moss/api/MossException;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosInteractContainer$mSegmentSwitch$2$1 implements MossResponseHandler<GetUserPreferenceReply> {
    final /* synthetic */ ChronosInteractContainer this$0;

    public /* synthetic */ void onCompleted() {
        MossResponseHandler.-CC.$default$onCompleted(this);
    }

    public /* synthetic */ void onHeaders(Map map) {
        MossResponseHandler.-CC.$default$onHeaders(this, map);
    }

    public /* synthetic */ long onNextForAck(Object obj) {
        return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
    }

    public /* synthetic */ void onUpstreamAck(Long l) {
        MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
    }

    public /* synthetic */ void onValid() {
        MossResponseHandler.-CC.$default$onValid(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChronosInteractContainer$mSegmentSwitch$2$1(ChronosInteractContainer $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r0.hasEnableSegmentedSection() == true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(GetUserPreferenceReply value) {
        boolean z;
        PlayerContainer playerContainer;
        final boolean open;
        List valueList;
        Any $this$tryUnpack$iv;
        SpecificPlayConfig config = null;
        if (value != null && (valueList = value.getValueList()) != null && ($this$tryUnpack$iv = (Any) CollectionsKt.firstOrNull(valueList)) != null) {
            try {
                MessageLite defaultInstance$iv = Internal.getDefaultInstance(SpecificPlayConfig.class);
                Intrinsics.checkNotNullExpressionValue(defaultInstance$iv, "getDefaultInstance(...)");
                Object parseFrom = defaultInstance$iv.getParserForType().parseFrom($this$tryUnpack$iv.getValue());
                if (parseFrom instanceof MessageLite) {
                    config = (MessageLite) parseFrom;
                }
            } catch (Exception e) {
            }
            config = config;
        }
        if (config != null) {
            z = true;
        }
        z = false;
        if (!z) {
            playerContainer = this.this$0.playerContainer;
            open = playerContainer.getPlayerSettingService().getCloudConfig().getDefaultSegmentProgress();
        } else {
            open = config.getEnableSegmentedSection().getValue();
        }
        final ChronosInteractContainer chronosInteractContainer = this.this$0;
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mSegmentSwitch$2$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ChronosInteractContainer.this.setSegmentSwitchValue(open);
            }
        });
    }

    public void onError(final MossException t) {
        final ChronosInteractContainer chronosInteractContainer = this.this$0;
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mSegmentSwitch$2$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ChronosInteractContainer$mSegmentSwitch$2$1.onError$lambda$1(t, chronosInteractContainer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$1(MossException $t, ChronosInteractContainer this$0) {
        PlayerContainer playerContainer;
        DanmakuLogger.INSTANCE.error("get segment progress switch error! " + ($t != null ? $t.toPrintString() : null));
        playerContainer = this$0.playerContainer;
        this$0.setSegmentSwitchValue(playerContainer.getPlayerSettingService().getCloudConfig().getDefaultSegmentProgress());
    }
}