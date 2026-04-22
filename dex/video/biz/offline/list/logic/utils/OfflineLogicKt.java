package video.biz.offline.list.logic.utils;

import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.ResourceValidateCode;
import video.biz.offline.base.infra.utils.ResourceValidateImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineLogic.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"getReadableIndexTitle", "", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getLocalResourceInvalidTip", "videoEntity", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineLogicKt {

    /* compiled from: OfflineLogic.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OfflineVideoEntity.SeasonType.values().length];
            try {
                iArr[OfflineVideoEntity.SeasonType.BANGUMI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.SeasonType.CN_BANGUMI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ResourceValidateCode.values().length];
            try {
                iArr2[ResourceValidateCode.ERROR_STORAGE_DIR_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_INVALID_ENTRY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_ENTRY_NO_TYPE_TAG.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_MEDIA_DIR_NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_INVALID_INDEX.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_DASH_NOT_FOUND.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[ResourceValidateCode.SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final String getReadableIndexTitle(OfflineVideoEntity entity) {
        if (entity == null) {
            return null;
        }
        long index = entity.getPageIndex();
        if (index == 0) {
            return entity.getPageTitle();
        }
        if (entity.getPageIndex() == -1) {
            return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2244(PlayerbaseresRes.INSTANCE.getString()));
        }
        switch (WhenMappings.$EnumSwitchMapping$0[entity.getSeasonType().ordinal()]) {
            case 1:
            case 2:
                if (StringsKt.toIntOrNull(entity.getVideoTitle()) == null) {
                    return entity.getVideoTitle();
                }
                return "第" + entity.getVideoTitle() + "话";
            default:
                if (StringsKt.toIntOrNull(entity.getVideoTitle()) == null) {
                    return entity.getVideoTitle();
                }
                return "第" + entity.getVideoTitle() + "集";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getLocalResourceInvalidTip(OfflineVideoEntity videoEntity, Continuation<? super String> continuation) {
        OfflineLogicKt$getLocalResourceInvalidTip$1 offlineLogicKt$getLocalResourceInvalidTip$1;
        Object validateLocalResource;
        ResourceValidateCode code;
        if (continuation instanceof OfflineLogicKt$getLocalResourceInvalidTip$1) {
            offlineLogicKt$getLocalResourceInvalidTip$1 = (OfflineLogicKt$getLocalResourceInvalidTip$1) continuation;
            if ((offlineLogicKt$getLocalResourceInvalidTip$1.label & Integer.MIN_VALUE) != 0) {
                offlineLogicKt$getLocalResourceInvalidTip$1.label -= Integer.MIN_VALUE;
                Object $result = offlineLogicKt$getLocalResourceInvalidTip$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineLogicKt$getLocalResourceInvalidTip$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        offlineLogicKt$getLocalResourceInvalidTip$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        offlineLogicKt$getLocalResourceInvalidTip$1.label = 1;
                        validateLocalResource = ResourceValidateImpl_androidKt.validateLocalResource(videoEntity, offlineLogicKt$getLocalResourceInvalidTip$1);
                        if (validateLocalResource == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) offlineLogicKt$getLocalResourceInvalidTip$1.L$0;
                        ResultKt.throwOnFailure($result);
                        validateLocalResource = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                code = (ResourceValidateCode) validateLocalResource;
                switch (WhenMappings.$EnumSwitchMapping$1[code.ordinal()]) {
                    case 1:
                        return "原因：相关网络资源解析失败 \n建议：手动删除缓存任务后重新缓存稿件";
                    case 2:
                        return "原因：可能缓存文件被清理软件清 \n建议：使用清理软件时不要删除缓存视频相关文件";
                    case 3:
                        return "原因：可能缓存文件/目录被修改 \n建议：不要随意修改缓存目录名以及内部文件名";
                    case 4:
                        return "原因：无法找到缓存目录，可能缓存目录被修改 \n建议：不要随意修改缓存目录以及内部文件";
                    case 5:
                        return "原因：可能缓存文件被修改 \n建议：请重新下载该视频";
                    case 6:
                        return "原因：可能视频文件被清理软件清除或修改文件名 \n建议：使用清理软件时不要删除缓存视频相关文件，且不要随意修改缓存目录名以及内部文件名";
                    case 7:
                        return "若进入视频或番剧详情页无法播放，可能是因为网络原因，建议在离线页点击视频直接播放";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }
        offlineLogicKt$getLocalResourceInvalidTip$1 = new OfflineLogicKt$getLocalResourceInvalidTip$1(continuation);
        Object $result2 = offlineLogicKt$getLocalResourceInvalidTip$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineLogicKt$getLocalResourceInvalidTip$1.label) {
        }
        code = (ResourceValidateCode) validateLocalResource;
        switch (WhenMappings.$EnumSwitchMapping$1[code.ordinal()]) {
        }
    }
}