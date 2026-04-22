package video.biz.offline.base.infra.storage.diskfile;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDataStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage$removeDramas$2", f = "FileDataStorage.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FileDataStorage$removeDramas$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<Long, DramaGroupModel> $changedDramas;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDataStorage$removeDramas$2(Map<Long, DramaGroupModel> map, Continuation<? super FileDataStorage$removeDramas$2> continuation) {
        super(2, continuation);
        this.$changedDramas = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileDataStorage$removeDramas$2(this.$changedDramas, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map $this$filter$iv = this.$changedDramas;
                Map destination$iv$iv = new LinkedHashMap();
                for (Map.Entry element$iv$iv : $this$filter$iv.entrySet()) {
                    if (!element$iv$iv.getValue().getItems().isEmpty()) {
                        destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                    }
                }
                this.label = 1;
                if (DiskFileImpl_androidKt.writeDramaToDisk(CollectionsKt.toList(destination$iv$iv.values()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}