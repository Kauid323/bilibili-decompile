package bili.resource.profile;

import com.bilibili.crow.BuildConfig;
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
@DebugMetadata(c = "bili.resource.profile.ProfileRes$getPluralString$1", f = "Res.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ProfileRes$getPluralString$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $quantity;
    final /* synthetic */ PluralStringResource $res;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileRes$getPluralString$1(PluralStringResource pluralStringResource, int i, Continuation<? super ProfileRes$getPluralString$1> continuation) {
        super(2, continuation);
        this.$res = pluralStringResource;
        this.$quantity = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileRes$getPluralString$1(this.$res, this.$quantity, continuation);
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
                Object pluralString = PluralStringResourcesKt.getPluralString(this.$res, this.$quantity, (Continuation) this);
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