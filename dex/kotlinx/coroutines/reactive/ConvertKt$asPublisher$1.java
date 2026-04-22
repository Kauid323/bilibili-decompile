package kotlinx.coroutines.reactive;

import com.bapis.bilibili.app.dynamic.v2.AdditionalType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Convert.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.ConvertKt$asPublisher$1", f = "Convert.kt", i = {0, 1}, l = {AdditionalType.additional_type_content_opus_VALUE, AdditionalType.additional_type_content_video_VALUE}, m = "invokeSuspend", n = {"$this$publish", "$this$publish"}, s = {"L$0", "L$0"})
public final class ConvertKt$asPublisher$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<T> $this_asPublisher;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConvertKt$asPublisher$1(ReceiveChannel<? extends T> receiveChannel, Continuation<? super ConvertKt$asPublisher$1> continuation) {
        super(2, continuation);
        this.$this_asPublisher = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConvertKt$asPublisher$1 convertKt$asPublisher$1 = new ConvertKt$asPublisher$1(this.$this_asPublisher, continuation);
        convertKt$asPublisher$1.L$0 = obj;
        return convertKt$asPublisher$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((ConvertKt$asPublisher$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0076 -> B:9:0x0042). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ConvertKt$asPublisher$1 convertKt$asPublisher$1;
        ProducerScope $this$publish;
        ChannelIterator<T> it;
        ProducerScope $this$publish2;
        ConvertKt$asPublisher$1 convertKt$asPublisher$12;
        Object obj;
        Object $result2;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                convertKt$asPublisher$1 = this;
                $this$publish = (ProducerScope) convertKt$asPublisher$1.L$0;
                it = convertKt$asPublisher$1.$this_asPublisher.iterator();
                convertKt$asPublisher$1.L$0 = $this$publish;
                convertKt$asPublisher$1.L$1 = it;
                convertKt$asPublisher$1.label = 1;
                hasNext = it.hasNext(convertKt$asPublisher$1);
                if (hasNext == $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                $this$publish2 = $this$publish;
                convertKt$asPublisher$12 = convertKt$asPublisher$1;
                obj = obj2;
                if (!((Boolean) $result).booleanValue()) {
                    convertKt$asPublisher$12.L$0 = $this$publish2;
                    convertKt$asPublisher$12.L$1 = it;
                    convertKt$asPublisher$12.label = 2;
                    Object t = $this$publish2.send(it.next(), convertKt$asPublisher$12);
                    if (t == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    convertKt$asPublisher$1 = convertKt$asPublisher$12;
                    $this$publish = $this$publish2;
                    convertKt$asPublisher$1.L$0 = $this$publish;
                    convertKt$asPublisher$1.L$1 = it;
                    convertKt$asPublisher$1.label = 1;
                    hasNext = it.hasNext(convertKt$asPublisher$1);
                    if (hasNext == $result3) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                ProducerScope $this$publish3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$publish2 = $this$publish3;
                it = (ChannelIterator) this.L$1;
                convertKt$asPublisher$12 = this;
                obj = $result3;
                $result2 = $result;
                if (!((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                convertKt$asPublisher$1 = this;
                ProducerScope $this$publish4 = (ProducerScope) convertKt$asPublisher$1.L$0;
                ResultKt.throwOnFailure($result);
                it = (ChannelIterator) convertKt$asPublisher$1.L$1;
                $this$publish = $this$publish4;
                convertKt$asPublisher$1.L$0 = $this$publish;
                convertKt$asPublisher$1.L$1 = it;
                convertKt$asPublisher$1.label = 1;
                hasNext = it.hasNext(convertKt$asPublisher$1);
                if (hasNext == $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}