package io.ktor.serialization.kotlinx.json;

import host.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExperimentalJsonConverter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.ExperimentalJsonConverter", f = "ExperimentalJsonConverter.kt", i = {0, 0}, l = {R.styleable.CameraView_cameraVideoSizeMaxWidth}, m = "deserialize", n = {"this", "serializer"}, s = {"L$0", "L$1"})
public final class ExperimentalJsonConverter$deserialize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExperimentalJsonConverter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentalJsonConverter$deserialize$1(ExperimentalJsonConverter experimentalJsonConverter, Continuation<? super ExperimentalJsonConverter$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = experimentalJsonConverter;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, null, (Continuation) this);
    }
}