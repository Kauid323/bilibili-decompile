package bili.resource.ogv_community;

import com.bilibili.crow.BuildConfig;
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
import org.jetbrains.compose.resources.PluralStringResource;
import org.jetbrains.compose.resources.PluralStringResourcesKt;

/* compiled from: Res.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "bili.resource.ogv_community.Ogv_communityRes$getPluralString$2", f = "Res.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class Ogv_communityRes$getPluralString$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Object[] $args;
    final /* synthetic */ int $quantity;
    final /* synthetic */ PluralStringResource $res;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ogv_communityRes$getPluralString$2(PluralStringResource pluralStringResource, int i, Object[] objArr, Continuation<? super Ogv_communityRes$getPluralString$2> continuation) {
        super(2, continuation);
        this.$res = pluralStringResource;
        this.$quantity = i;
        this.$args = objArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Ogv_communityRes$getPluralString$2(this.$res, this.$quantity, this.$args, continuation);
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
                Object pluralString = PluralStringResourcesKt.getPluralString(this.$res, this.$quantity, Arrays.copyOf(this.$args, this.$args.length), (Continuation) this);
                if (pluralString == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return pluralString;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}