package tv.danmaku.bili.ui.offline;

import com.bilibili.offline.OfflineInfo;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineHomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.OfflineHomeFragment$asyncGetPlayTime$1$1$1", f = "OfflineHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineHomeFragment$asyncGetPlayTime$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineInfo> $infoList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomeFragment$asyncGetPlayTime$1$1$1(List<OfflineInfo> list, Continuation<? super OfflineHomeFragment$asyncGetPlayTime$1$1$1> continuation) {
        super(2, continuation);
        this.$infoList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineHomeFragment$asyncGetPlayTime$1$1$1(this.$infoList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object $result;
        Object $result2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Object $result3 = obj;
                Collection $this$toTypedArray$iv = this.$infoList;
                int i = 0;
                Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new OfflineInfo[0]);
                int length = $this$forEach$iv.length;
                int i2 = 0;
                while (i2 < length) {
                    Object element$iv = $this$forEach$iv[i2];
                    OfflineInfo info = (OfflineInfo) element$iv;
                    if (info.getPageCount() > 0) {
                        info.playedChildCount = i;
                        Collection $this$toTypedArray$iv2 = info.pages;
                        Object[] $this$forEach$iv2 = $this$toTypedArray$iv2.toArray(new OfflineInfo[i]);
                        int length2 = $this$forEach$iv2.length;
                        int i3 = i;
                        while (i3 < length2) {
                            Object element$iv2 = $this$forEach$iv2[i3];
                            OfflineInfo page = (OfflineInfo) element$iv2;
                            if (page != null) {
                                $result2 = $result3;
                                page.playedTime = OfflineUtil.getPlayedTimeV2(page.typeInfo);
                                if (page.playedTime > 0 || page.playedTime == -1) {
                                    info.playedChildCount++;
                                }
                            } else {
                                $result2 = $result3;
                            }
                            i3++;
                            $result3 = $result2;
                        }
                        $result = $result3;
                    } else {
                        $result = $result3;
                        info.playedTime = OfflineUtil.getPlayedTimeV2(info.typeInfo);
                    }
                    i2++;
                    i = 0;
                    $result3 = $result;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}