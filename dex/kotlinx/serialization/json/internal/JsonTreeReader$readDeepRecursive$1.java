package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonTreeReader.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ JsonTreeReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readDeepRecursive$1> continuation) {
        super(3, continuation);
        this.this$0 = jsonTreeReader;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.this$0, continuation);
        jsonTreeReader$readDeepRecursive$1.L$0 = deepRecursiveScope;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        AbstractJsonLexer abstractJsonLexer;
        AbstractJsonLexer abstractJsonLexer2;
        JsonElement readArray;
        Object readObject;
        Object $result2;
        JsonPrimitive readValue;
        JsonPrimitive readValue2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DeepRecursiveScope $this$$receiver = (DeepRecursiveScope) this.L$0;
                abstractJsonLexer = this.this$0.lexer;
                byte peekNextToken = abstractJsonLexer.peekNextToken();
                if (peekNextToken == 1) {
                    readValue2 = this.this$0.readValue(true);
                    return readValue2;
                } else if (peekNextToken == 0) {
                    readValue = this.this$0.readValue(false);
                    return readValue;
                } else if (peekNextToken == 6) {
                    this.label = 1;
                    readObject = this.this$0.readObject($this$$receiver, this);
                    if (readObject == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = readObject;
                    break;
                } else if (peekNextToken == 8) {
                    readArray = this.this$0.readArray();
                    return readArray;
                } else {
                    abstractJsonLexer2 = this.this$0.lexer;
                    AbstractJsonLexer.fail$default(abstractJsonLexer2, "Can't begin reading element, unexpected token", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (JsonElement) $result;
    }
}