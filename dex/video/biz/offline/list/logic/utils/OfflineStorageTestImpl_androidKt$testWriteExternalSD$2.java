package video.biz.offline.list.logic.utils;

import com.bilibili.commons.io.FileUtils;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.infra.utils.StorageHelperKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineStorageTestImpl.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.OfflineStorageTestImpl_androidKt$testWriteExternalSD$2", f = "OfflineStorageTestImpl.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineStorageTestImpl_androidKt$testWriteExternalSD$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineStorageTestImpl_androidKt$testWriteExternalSD$2(Continuation<? super OfflineStorageTestImpl_androidKt$testWriteExternalSD$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineStorageTestImpl_androidKt$testWriteExternalSD$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                File dir = StorageHelperKt.getSecondaryDirectoryFile(FoundationAlias.getFapp());
                if (dir == null) {
                    return Boxing.boxBoolean(false);
                }
                try {
                    File testFile = new File(dir, "test.json");
                    if (!testFile.exists()) {
                        testFile.createNewFile();
                    }
                    String testJson = EntryScannerKt.getOfflineJson().encodeToString(TestModel.Companion.serializer(), new TestModel(0, (String) null, (List) null, 7, (DefaultConstructorMarker) null));
                    FileUtils.writeStringToFile(testFile, testJson, "UTF-8");
                    return Boxing.boxBoolean(true);
                } catch (Exception e) {
                    new DataLog().error("testWriteExternalSD error: " + e.getMessage());
                    return Boxing.boxBoolean(false);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}