package io.ktor.http.content;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Multipart.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lio/ktor/http/content/PartData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.MultipartKt$asFlow$1", f = "Multipart.kt", i = {0, 1}, l = {TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, TbsListener.ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
final class MultipartKt$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super PartData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MultiPartData $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultipartKt$asFlow$1(MultiPartData multiPartData, Continuation<? super MultipartKt$asFlow$1> continuation) {
        super(2, continuation);
        this.$this_asFlow = multiPartData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> multipartKt$asFlow$1 = new MultipartKt$asFlow$1(this.$this_asFlow, continuation);
        multipartKt$asFlow$1.L$0 = obj;
        return multipartKt$asFlow$1;
    }

    public final Object invoke(FlowCollector<? super PartData> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005c -> B:9:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$flow;
        MultipartKt$asFlow$1 multipartKt$asFlow$1;
        MultipartKt$asFlow$1 multipartKt$asFlow$12;
        FlowCollector $this$flow2;
        Object obj;
        Object $result2;
        PartData part;
        Object readPart;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$flow = (FlowCollector) this.L$0;
                multipartKt$asFlow$1 = this;
                multipartKt$asFlow$1.L$0 = $this$flow;
                multipartKt$asFlow$1.label = 1;
                readPart = multipartKt$asFlow$1.$this_asFlow.readPart((Continuation) multipartKt$asFlow$1);
                if (readPart == $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = readPart;
                multipartKt$asFlow$12 = multipartKt$asFlow$1;
                $this$flow2 = $this$flow;
                obj = obj2;
                part = (PartData) $result;
                if (part == null) {
                    multipartKt$asFlow$12.L$0 = $this$flow2;
                    multipartKt$asFlow$12.label = 2;
                    if ($this$flow2.emit(part, (Continuation) multipartKt$asFlow$12) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    $this$flow = $this$flow2;
                    multipartKt$asFlow$1 = multipartKt$asFlow$12;
                    multipartKt$asFlow$1.L$0 = $this$flow;
                    multipartKt$asFlow$1.label = 1;
                    readPart = multipartKt$asFlow$1.$this_asFlow.readPart((Continuation) multipartKt$asFlow$1);
                    if (readPart == $result3) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                FlowCollector $this$flow3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                multipartKt$asFlow$12 = this;
                $this$flow2 = $this$flow3;
                obj = $result3;
                $result2 = $result;
                part = (PartData) $result;
                if (part == null) {
                }
                break;
            case 2:
                $this$flow = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure($result);
                multipartKt$asFlow$1 = this;
                multipartKt$asFlow$1.L$0 = $this$flow;
                multipartKt$asFlow$1.label = 1;
                readPart = multipartKt$asFlow$1.$this_asFlow.readPart((Continuation) multipartKt$asFlow$1);
                if (readPart == $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}