package video.biz.offline.list.logic;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.OfflineLog;
import video.biz.offline.base.infra.utils.ResourceValidateCode;
import video.biz.offline.base.infra.utils.ResourceValidateImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: OfflineResolveResult.android.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010\u0004\u001a*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f\u001a,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002\u001a \u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0017"}, d2 = {"fileTree", "", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveErrorCode", "initTree", "", "context", "Landroid/content/Context;", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "storagePath", "code", "Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "generateSubTree", "", "floor", "fileList", "", "Lvideo/biz/offline/list/logic/tree/VideoFile;", "getDownloadVideoFile", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineResolveResult_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fileTree(OfflineVideoEntity videoEntity, Continuation<? super String> continuation) {
        OfflineResolveResult_androidKt$fileTree$1 offlineResolveResult_androidKt$fileTree$1;
        String storagePath;
        Object validateLocalResource;
        Context context;
        ResourceValidateCode code;
        VideoFile rootDir;
        if (continuation instanceof OfflineResolveResult_androidKt$fileTree$1) {
            offlineResolveResult_androidKt$fileTree$1 = (OfflineResolveResult_androidKt$fileTree$1) continuation;
            if ((offlineResolveResult_androidKt$fileTree$1.label & Integer.MIN_VALUE) != 0) {
                offlineResolveResult_androidKt$fileTree$1.label -= Integer.MIN_VALUE;
                Object $result = offlineResolveResult_androidKt$fileTree$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineResolveResult_androidKt$fileTree$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        storagePath = videoEntity.getStoragePath();
                        Context context2 = FoundationAlias.getFapp().getApplicationContext();
                        if (TextUtils.isEmpty(storagePath)) {
                            return "";
                        }
                        new OfflineLog().debug("fileTree storagePath: " + storagePath);
                        offlineResolveResult_androidKt$fileTree$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        offlineResolveResult_androidKt$fileTree$1.L$1 = storagePath;
                        offlineResolveResult_androidKt$fileTree$1.L$2 = context2;
                        offlineResolveResult_androidKt$fileTree$1.label = 1;
                        validateLocalResource = ResourceValidateImpl_androidKt.validateLocalResource(videoEntity, offlineResolveResult_androidKt$fileTree$1);
                        if (validateLocalResource == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        context = context2;
                        break;
                    case 1:
                        context = (Context) offlineResolveResult_androidKt$fileTree$1.L$2;
                        storagePath = (String) offlineResolveResult_androidKt$fileTree$1.L$1;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) offlineResolveResult_androidKt$fileTree$1.L$0;
                        ResultKt.throwOnFailure($result);
                        validateLocalResource = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                code = (ResourceValidateCode) validateLocalResource;
                Intrinsics.checkNotNull(context);
                rootDir = getDownloadVideoFile(context, storagePath, code);
                if (rootDir != null || !rootDir.isDirectory()) {
                    return "该视频文件目录不存在(可能已被删除)";
                }
                StringBuilder sb = new StringBuilder();
                int floor = initTree(context, sb, storagePath, code);
                generateSubTree(floor, rootDir.listFiles(), sb);
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return sb2;
            }
        }
        offlineResolveResult_androidKt$fileTree$1 = new OfflineResolveResult_androidKt$fileTree$1(continuation);
        Object $result2 = offlineResolveResult_androidKt$fileTree$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineResolveResult_androidKt$fileTree$1.label) {
        }
        code = (ResourceValidateCode) validateLocalResource;
        Intrinsics.checkNotNull(context);
        rootDir = getDownloadVideoFile(context, storagePath, code);
        if (rootDir != null) {
            return "该视频文件目录不存在(可能已被删除)";
        }
        StringBuilder sb3 = new StringBuilder();
        int floor2 = initTree(context, sb3, storagePath, code);
        generateSubTree(floor2, rootDir.listFiles(), sb3);
        String sb22 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
        return sb22;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveErrorCode(OfflineVideoEntity videoEntity, Continuation<? super String> continuation) {
        OfflineResolveResult_androidKt$resolveErrorCode$1 offlineResolveResult_androidKt$resolveErrorCode$1;
        Object validateLocalResource;
        if (continuation instanceof OfflineResolveResult_androidKt$resolveErrorCode$1) {
            offlineResolveResult_androidKt$resolveErrorCode$1 = (OfflineResolveResult_androidKt$resolveErrorCode$1) continuation;
            if ((offlineResolveResult_androidKt$resolveErrorCode$1.label & Integer.MIN_VALUE) != 0) {
                offlineResolveResult_androidKt$resolveErrorCode$1.label -= Integer.MIN_VALUE;
                Object $result = offlineResolveResult_androidKt$resolveErrorCode$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineResolveResult_androidKt$resolveErrorCode$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        offlineResolveResult_androidKt$resolveErrorCode$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        offlineResolveResult_androidKt$resolveErrorCode$1.label = 1;
                        validateLocalResource = ResourceValidateImpl_androidKt.validateLocalResource(videoEntity, offlineResolveResult_androidKt$resolveErrorCode$1);
                        if (validateLocalResource == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) offlineResolveResult_androidKt$resolveErrorCode$1.L$0;
                        ResultKt.throwOnFailure($result);
                        validateLocalResource = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return String.valueOf(((ResourceValidateCode) validateLocalResource).getErrCode());
            }
        }
        offlineResolveResult_androidKt$resolveErrorCode$1 = new OfflineResolveResult_androidKt$resolveErrorCode$1(continuation);
        Object $result2 = offlineResolveResult_androidKt$resolveErrorCode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineResolveResult_androidKt$resolveErrorCode$1.label) {
        }
        return String.valueOf(((ResourceValidateCode) validateLocalResource).getErrCode());
    }

    public static final int initTree(Context context, StringBuilder sb, String storagePath, ResourceValidateCode code) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sb, "sb");
        Intrinsics.checkNotNullParameter(storagePath, "storagePath");
        Intrinsics.checkNotNullParameter(code, "code");
        VideoFile file = VideoFile.Companion.fromPath(context, storagePath);
        VideoFile file2 = file != null ? file.getParentFile() : null;
        List originSegments = Uri.parse(Uri.decode(storagePath)).getPathSegments();
        List rootSegments = Uri.parse(Uri.decode(file2 != null ? file2.getAbsolutePath() : null)).getPathSegments();
        new OfflineLog().debug("originSegments: " + originSegments);
        new OfflineLog().debug("rootSegments: " + rootSegments);
        int diff = (originSegments.size() - rootSegments.size()) + 1;
        if (diff == 0) {
            sb.append(VideoFile.TREE_START).append(file2 != null ? file2.getName() : null).append(VideoFile.TREE_END);
            return 1;
        }
        int rootLastIndex = rootSegments.size() - 1;
        for (int i = 0; i < diff; i++) {
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    sb.append(VideoFile.TREE_INTERVAL_VERTICAL);
                }
            }
            sb.append(VideoFile.TREE_START).append(originSegments.get(rootLastIndex + i)).append(VideoFile.TREE_END);
        }
        int i2 = diff + 1;
        return i2;
    }

    private static final void generateSubTree(int floor, List<? extends VideoFile> list, StringBuilder sb) {
        if (list != null) {
            int i = 0;
            int size = list.size();
            while (i < size) {
                if (floor > 1) {
                    int i2 = floor - 1;
                    for (int j = 0; j < i2; j++) {
                        sb.append(VideoFile.TREE_INTERVAL_VERTICAL);
                    }
                }
                VideoFile file = list.get(i);
                sb.append(i == list.size() - 1 ? VideoFile.TREE_LAST_START : VideoFile.TREE_START).append(file.getName()).append(VideoFile.TREE_END);
                if (file.isDirectory()) {
                    generateSubTree(floor + 1, file.listFiles(), sb);
                }
                i++;
            }
        }
    }

    public static final VideoFile getDownloadVideoFile(Context context, String storagePath, ResourceValidateCode code) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storagePath, "storagePath");
        Intrinsics.checkNotNullParameter(code, "code");
        VideoFile file = VideoFile.Companion.fromPath(context, storagePath);
        boolean z = false;
        if (file != null && file.isDirectory()) {
            z = true;
        }
        if (z || code == ResourceValidateCode.ERROR_MEDIA_DIR_NOT_FOUND || code == ResourceValidateCode.ERROR_STORAGE_DIR_NOT_FOUND) {
            return file;
        }
        if (file != null) {
            return file.getParentFile();
        }
        return null;
    }
}