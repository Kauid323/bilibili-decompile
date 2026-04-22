package io.ktor.client.request.forms;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: formDsl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class FormDslKt$append$1 implements Function0<Source> {
    final /* synthetic */ Function1<Sink, Unit> $bodyBuilder;

    public FormDslKt$append$1(Function1<? super Sink, Unit> function1) {
        this.$bodyBuilder = function1;
    }

    public final Source invoke() {
        Function1<Sink, Unit> function1 = this.$bodyBuilder;
        Source buffer = new Buffer();
        Sink $this$invoke_u24lambda_u240 = (Sink) buffer;
        function1.invoke($this$invoke_u24lambda_u240);
        return buffer;
    }
}