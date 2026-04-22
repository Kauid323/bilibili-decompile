package tv.danmaku.bili.ui.offline;

import android.content.Context;
import com.bilibili.offline.StorageInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StorageView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.StorageView$checkStorage$1$storageTip$1", f = "StorageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StorageView$checkStorage$1$storageTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CharSequence>, Object> {
    int label;
    final /* synthetic */ StorageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageView$checkStorage$1$storageTip$1(StorageView storageView, Continuation<? super StorageView$checkStorage$1$storageTip$1> continuation) {
        super(2, continuation);
        this.this$0 = storageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StorageView$checkStorage$1$storageTip$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CharSequence> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        CharSequence buildStorageString;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                StorageInfo[] storage = OfflineUtil.getOfflineStorage(this.this$0.getContext());
                this.this$0.mStorage = storage;
                StorageView storageView = this.this$0;
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                i = this.this$0.mCurrentStorage;
                buildStorageString = storageView.buildStorageString(context, storage, i != 2);
                return buildStorageString;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}