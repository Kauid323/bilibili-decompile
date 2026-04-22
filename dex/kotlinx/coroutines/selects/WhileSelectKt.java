package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;

/* compiled from: WhileSelect.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006H\u0087H¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class WhileSelectKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005d -> B:18:0x0062). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object whileSelect(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$1;
        WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$12;
        Function1 builder;
        Object $result;
        Object obj;
        if (continuation instanceof WhileSelectKt$whileSelect$1) {
            whileSelectKt$whileSelect$1 = (WhileSelectKt$whileSelect$1) continuation;
            if ((whileSelectKt$whileSelect$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                whileSelectKt$whileSelect$1.label -= IntCompanionObject.MIN_VALUE;
                whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
                Object $result2 = whileSelectKt$whileSelect$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (whileSelectKt$whileSelect$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        builder = function1;
                        SelectImplementation $this$select_u24lambda_u241$iv = new SelectImplementation(whileSelectKt$whileSelect$12.getContext());
                        builder.invoke($this$select_u24lambda_u241$iv);
                        whileSelectKt$whileSelect$12.L$0 = builder;
                        whileSelectKt$whileSelect$12.label = 1;
                        Object doSelect = $this$select_u24lambda_u241$iv.doSelect(whileSelectKt$whileSelect$12);
                        if (doSelect != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = doSelect;
                        obj = obj2;
                        if (((Boolean) $result2).booleanValue()) {
                            return Unit.INSTANCE;
                        }
                        $result2 = $result;
                        $result3 = obj;
                        SelectImplementation $this$select_u24lambda_u241$iv2 = new SelectImplementation(whileSelectKt$whileSelect$12.getContext());
                        builder.invoke($this$select_u24lambda_u241$iv2);
                        whileSelectKt$whileSelect$12.L$0 = builder;
                        whileSelectKt$whileSelect$12.label = 1;
                        Object doSelect2 = $this$select_u24lambda_u241$iv2.doSelect(whileSelectKt$whileSelect$12);
                        if (doSelect2 != $result3) {
                        }
                    case 1:
                        builder = (Function1) whileSelectKt$whileSelect$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        obj = $result3;
                        $result = $result2;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        whileSelectKt$whileSelect$1 = new WhileSelectKt$whileSelect$1(continuation);
        whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
        Object $result22 = whileSelectKt$whileSelect$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (whileSelectKt$whileSelect$12.label) {
        }
    }

    private static final Object whileSelect$$forInline(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }
}