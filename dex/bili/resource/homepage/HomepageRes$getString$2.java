package bili.resource.homepage;

import com.bilibili.upper.BR;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: Res.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "bili.resource.homepage.HomepageRes$getString$2", f = "Res.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HomepageRes$getString$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Object[] $args;
    final /* synthetic */ StringResource $res;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomepageRes$getString$2(StringResource stringResource, Object[] objArr, Continuation<? super HomepageRes$getString$2> continuation) {
        super(2, continuation);
        this.$res = stringResource;
        this.$args = objArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomepageRes$getString$2(this.$res, this.$args, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object string = StringResourcesKt.getString(this.$res, Arrays.copyOf(this.$args, this.$args.length), (Continuation) this);
                if (string == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return string;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}