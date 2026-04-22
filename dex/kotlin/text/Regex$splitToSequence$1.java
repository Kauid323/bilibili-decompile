package kotlin.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {280, 288, 292}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "$this$sequence", "matcher", "nextStart", "splitCount", "$this$sequence", "matcher", "nextStart", "splitCount"}, nl = {281, 289, 293}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 2)
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i, Continuation<? super Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, continuation);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
        return ((Regex$splitToSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007a -> B:18:0x007d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Pattern pattern;
        Matcher matcher;
        int nextStart;
        int splitCount;
        Regex$splitToSequence$1 regex$splitToSequence$1;
        SequenceScope $this$sequence = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                pattern = this.this$0.nativePattern;
                matcher = pattern.matcher(this.$input);
                if (this.$limit == 1 || !matcher.find()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                    this.label = 1;
                    return $this$sequence.yield(this.$input.toString(), this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
                nextStart = 0;
                splitCount = 0;
                regex$splitToSequence$1 = this;
                regex$splitToSequence$1.L$0 = $this$sequence;
                regex$splitToSequence$1.L$1 = matcher;
                regex$splitToSequence$1.I$0 = nextStart;
                regex$splitToSequence$1.I$1 = splitCount;
                regex$splitToSequence$1.label = 2;
                if ($this$sequence.yield(regex$splitToSequence$1.$input.subSequence(nextStart, matcher.start()).toString(), regex$splitToSequence$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nextStart = matcher.end();
                splitCount++;
                if (splitCount != regex$splitToSequence$1.$limit - 1 || !matcher.find()) {
                    regex$splitToSequence$1.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                    regex$splitToSequence$1.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                    regex$splitToSequence$1.I$0 = nextStart;
                    regex$splitToSequence$1.I$1 = splitCount;
                    regex$splitToSequence$1.label = 3;
                    return $this$sequence.yield(regex$splitToSequence$1.$input.subSequence(nextStart, regex$splitToSequence$1.$input.length()).toString(), regex$splitToSequence$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
                regex$splitToSequence$1.L$0 = $this$sequence;
                regex$splitToSequence$1.L$1 = matcher;
                regex$splitToSequence$1.I$0 = nextStart;
                regex$splitToSequence$1.I$1 = splitCount;
                regex$splitToSequence$1.label = 2;
                if ($this$sequence.yield(regex$splitToSequence$1.$input.subSequence(nextStart, matcher.start()).toString(), regex$splitToSequence$1) == coroutine_suspended) {
                }
                nextStart = matcher.end();
                splitCount++;
                if (splitCount != regex$splitToSequence$1.$limit - 1) {
                }
                regex$splitToSequence$1.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                regex$splitToSequence$1.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                regex$splitToSequence$1.I$0 = nextStart;
                regex$splitToSequence$1.I$1 = splitCount;
                regex$splitToSequence$1.label = 3;
                if ($this$sequence.yield(regex$splitToSequence$1.$input.subSequence(nextStart, regex$splitToSequence$1.$input.length()).toString(), regex$splitToSequence$1) == coroutine_suspended) {
                }
                break;
            case 1:
                Matcher matcher2 = (Matcher) this.L$1;
                ResultKt.throwOnFailure($result);
            case 2:
                int nextStart2 = this.I$1;
                int i = this.I$0;
                Matcher matcher3 = (Matcher) this.L$1;
                ResultKt.throwOnFailure($result);
                regex$splitToSequence$1 = this;
                splitCount = nextStart2;
                matcher = matcher3;
                nextStart = matcher.end();
                splitCount++;
                if (splitCount != regex$splitToSequence$1.$limit - 1) {
                }
                regex$splitToSequence$1.L$0 = SpillingKt.nullOutSpilledVariable($this$sequence);
                regex$splitToSequence$1.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                regex$splitToSequence$1.I$0 = nextStart;
                regex$splitToSequence$1.I$1 = splitCount;
                regex$splitToSequence$1.label = 3;
                if ($this$sequence.yield(regex$splitToSequence$1.$input.subSequence(nextStart, regex$splitToSequence$1.$input.length()).toString(), regex$splitToSequence$1) == coroutine_suspended) {
                }
                break;
            case 3:
                int i2 = this.I$1;
                int i3 = this.I$0;
                Matcher matcher4 = (Matcher) this.L$1;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}