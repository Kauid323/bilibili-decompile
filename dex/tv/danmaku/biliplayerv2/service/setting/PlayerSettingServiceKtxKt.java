package tv.danmaku.biliplayerv2.service.setting;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerSettingServiceKtx.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\"\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"settingChangeIntFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "key", "", "settingChangeBooleanFlow", "", "settingChangeFloatFlow", "", "settingChangeLongFlow", "", "settingChangeStringFlow", "cloudConfigFlow", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "getCloudConfigFlow", "(Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;)Lkotlinx/coroutines/flow/Flow;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerSettingServiceKtxKt {
    public static final Flow<Integer> settingChangeIntFlow(IPlayerSettingService $this$settingChangeIntFlow, String key) {
        Intrinsics.checkNotNullParameter($this$settingChangeIntFlow, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new PlayerSettingServiceKtxKt$settingChangeIntFlow$1($this$settingChangeIntFlow, key, null))));
    }

    public static final Flow<Boolean> settingChangeBooleanFlow(IPlayerSettingService $this$settingChangeBooleanFlow, String key) {
        Intrinsics.checkNotNullParameter($this$settingChangeBooleanFlow, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new PlayerSettingServiceKtxKt$settingChangeBooleanFlow$1($this$settingChangeBooleanFlow, key, null))));
    }

    public static final Flow<Float> settingChangeFloatFlow(IPlayerSettingService $this$settingChangeFloatFlow, String key) {
        Intrinsics.checkNotNullParameter($this$settingChangeFloatFlow, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new PlayerSettingServiceKtxKt$settingChangeFloatFlow$1($this$settingChangeFloatFlow, key, null))));
    }

    public static final Flow<Long> settingChangeLongFlow(IPlayerSettingService $this$settingChangeLongFlow, String key) {
        Intrinsics.checkNotNullParameter($this$settingChangeLongFlow, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new PlayerSettingServiceKtxKt$settingChangeLongFlow$1($this$settingChangeLongFlow, key, null))));
    }

    public static final Flow<String> settingChangeStringFlow(IPlayerSettingService $this$settingChangeStringFlow, String key) {
        Intrinsics.checkNotNullParameter($this$settingChangeStringFlow, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new PlayerSettingServiceKtxKt$settingChangeStringFlow$1($this$settingChangeStringFlow, key, null))));
    }

    public static final Flow<PlayerCloudConfig> getCloudConfigFlow(IPlayerSettingService $this$cloudConfigFlow) {
        Intrinsics.checkNotNullParameter($this$cloudConfigFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new PlayerSettingServiceKtxKt$cloudConfigFlow$1($this$cloudConfigFlow, null))));
    }
}