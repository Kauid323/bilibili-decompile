package kntr.common.photonic.gallery.entity;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: PlatformAlbumInfo.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkntr/common/photonic/Asset;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.entity.AlbumContentNonPaginationReader$read$1", f = "PlatformAlbumInfo.kt", i = {0, 1, 1}, l = {21, 22}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "result"}, s = {"L$0", "L$0", "L$1"}, v = 1)
final class AlbumContentNonPaginationReader$read$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Asset>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AlbumContentNonPaginationReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumContentNonPaginationReader$read$1(AlbumContentNonPaginationReader albumContentNonPaginationReader, Continuation<? super AlbumContentNonPaginationReader$read$1> continuation) {
        super(2, continuation);
        this.this$0 = albumContentNonPaginationReader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> albumContentNonPaginationReader$read$1 = new AlbumContentNonPaginationReader$read$1(this.this$0, continuation);
        albumContentNonPaginationReader$read$1.L$0 = obj;
        return albumContentNonPaginationReader$read$1;
    }

    public final Object invoke(FlowCollector<? super List<? extends Asset>> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object list$default;
        List result;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$flow;
                this.label = 1;
                list$default = FlowKt.toList$default(this.this$0.getReader().read(), (List) null, (Continuation) this, 1, (Object) null);
                if (list$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (List) list$default;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$flow.emit(result, (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                list$default = $result;
                result = (List) list$default;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if ($this$flow.emit(result, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                List list = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}