package tv.danmaku.biliplayerv2.router;

import com.bapis.bilibili.app.show.mixture.v1.ClarityReply;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerBootstrapUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$uniformQualitySetting$1", f = "PlayerBootstrapUtils.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PlayerBootstrapUtils$uniformQualitySetting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAutoClarity;
    final /* synthetic */ boolean $isStoryAutoClarity;
    final /* synthetic */ int $storyUserClarity;
    final /* synthetic */ int $userClarity;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerBootstrapUtils$uniformQualitySetting$1(boolean z, int i, boolean z2, int i2, Continuation<? super PlayerBootstrapUtils$uniformQualitySetting$1> continuation) {
        super(2, continuation);
        this.$isAutoClarity = z;
        this.$userClarity = i;
        this.$isStoryAutoClarity = z2;
        this.$storyUserClarity = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerBootstrapUtils$uniformQualitySetting$1(this.$isAutoClarity, this.$userClarity, this.$isStoryAutoClarity, this.$storyUserClarity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object clarity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                clarity = PlayerBootstrapUtils.INSTANCE.getClarity((Continuation) this);
                if (clarity != coroutine_suspended) {
                    $result = clarity;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ClarityReply result = (ClarityReply) $result;
        if (result == null) {
            return Unit.INSTANCE;
        }
        int lastQn = (int) result.getLastPlayQnValue();
        boolean z = false;
        if (result.getIsSetPlayQn() && lastQn >= 0) {
            if (lastQn == 0 && !this.$isAutoClarity) {
                IPlayerSettingService.Companion.putBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, true);
                BLog.i("PlayerBootstrapUtils", "last 7 day has setting quality:" + result.getLastPlayQnValue() + " userClarity:" + this.$userClarity + " isAutoClarity:" + this.$isAutoClarity + "，uniform quality setting to auto");
            } else if (lastQn > 0) {
                if (this.$isAutoClarity) {
                    IPlayerSettingService.Companion.putBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, false);
                }
                if (this.$userClarity != lastQn) {
                    IPlayerSettingService.Companion.putInt(Player.KEY_PLAY_QUALITY_USER_SETTING, lastQn);
                }
                BLog.i("PlayerBootstrapUtils", "last 7 day has setting quality:" + result.getLastPlayQnValue() + " userClarity:" + this.$userClarity + " isAutoClarity:" + this.$isAutoClarity + "，uniform quality setting to " + lastQn);
            }
            IPlayerSettingService.Companion.putBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, true);
        } else if (!result.getIsPlayStory()) {
            BLog.i("PlayerBootstrapUtils", "last 7 day not use story，uniform quality setting use detail:isAuto" + this.$isAutoClarity + " qn:" + this.$userClarity);
            IPlayerSettingService.Companion.putBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, true);
        } else {
            int qualityNum = this.$isAutoClarity ? 81 : this.$userClarity;
            int storyQualityNum = this.$isStoryAutoClarity ? 81 : this.$storyUserClarity;
            if (qualityNum > 80 && storyQualityNum > 80) {
                BLog.i("PlayerBootstrapUtils", "both more than 80 " + qualityNum + " " + storyQualityNum + "，uniform quality setting to " + (qualityNum < storyQualityNum ? storyQualityNum : qualityNum));
                if (qualityNum < storyQualityNum) {
                    IPlayerSettingService.Companion.putInt(Player.KEY_PLAY_QUALITY_USER_SETTING, storyQualityNum);
                    if (this.$isAutoClarity) {
                        IPlayerSettingService.Companion.putBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, false);
                    }
                }
                IPlayerSettingService.Companion.putBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, true);
            } else {
                if (1 <= qualityNum && qualityNum < 65) {
                    if (1 <= storyQualityNum && storyQualityNum < 65) {
                        z = true;
                    }
                    if (z) {
                        BLog.i("PlayerBootstrapUtils", "both less than 64 " + qualityNum + " " + storyQualityNum + "，uniform quality setting to:" + (qualityNum < storyQualityNum ? storyQualityNum : qualityNum));
                        if (qualityNum < storyQualityNum) {
                            IPlayerSettingService.Companion.putInt(Player.KEY_PLAY_QUALITY_USER_SETTING, storyQualityNum);
                        }
                        IPlayerSettingService.Companion.putBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, true);
                    }
                }
                BLog.i("PlayerBootstrapUtils", "quality has large diff， quality setting to auto");
                if (!this.$isAutoClarity) {
                    IPlayerSettingService.Companion.putBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, true);
                }
                IPlayerSettingService.Companion.putBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, true);
            }
        }
        return Unit.INSTANCE;
    }
}