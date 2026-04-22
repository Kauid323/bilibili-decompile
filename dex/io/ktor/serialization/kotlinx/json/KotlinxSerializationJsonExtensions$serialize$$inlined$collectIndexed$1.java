package io.ktor.serialization.kotlinx.json;

import com.tencent.smtt.sdk.TbsListener;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "index", "I", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1<T> implements FlowCollector<T> {
    final /* synthetic */ ByteWriteChannel $channel$inlined;
    final /* synthetic */ Charset $charset$inlined;
    final /* synthetic */ JsonArraySymbols $jsonArraySymbols$inlined;
    final /* synthetic */ KSerializer $serializer$inlined;
    private int index;
    final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1", f = "KotlinxSerializationJsonExtensions.kt", i = {0, 0, 1}, l = {TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, TbsListener.ErrorCode.DOWNLOAD_REDIRECT_EMPTY}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.this.emit(null, (Continuation) this);
        }
    }

    public KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(ByteWriteChannel byteWriteChannel, JsonArraySymbols jsonArraySymbols, KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, KSerializer kSerializer, Charset charset) {
        this.$channel$inlined = byteWriteChannel;
        this.$jsonArraySymbols$inlined = jsonArraySymbols;
        this.this$0 = kotlinxSerializationJsonExtensions;
        this.$serializer$inlined = kSerializer;
        this.$charset$inlined = charset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Continuation $continuation;
        KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1;
        boolean z;
        T t2;
        KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$12;
        boolean z2;
        Json json;
        ByteWriteChannel byteWriteChannel;
        byte[] byteArray;
        KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$13;
        ByteWriteChannel byteWriteChannel2;
        if (continuation instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                $continuation = anonymousClass1;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 = this;
                        int index$iv = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.index;
                        kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.index = index$iv + 1;
                        if (index$iv >= 0) {
                            z = false;
                            if (index$iv > 0) {
                                ByteWriteChannel byteWriteChannel3 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$channel$inlined;
                                byte[] objectSeparator = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$jsonArraySymbols$inlined.getObjectSeparator();
                                $continuation.L$0 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1;
                                $continuation.L$1 = t;
                                $continuation.label = 1;
                                if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel3, objectSeparator, 0, 0, $continuation, 6, (Object) null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                t2 = t;
                                kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$12 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1;
                                z2 = false;
                                z = z2;
                                t = t2;
                                kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$12;
                            }
                            json = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.this$0.format;
                            String string = json.encodeToString(kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$serializer$inlined, t);
                            byteWriteChannel = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$channel$inlined;
                            byteArray = StringsKt.toByteArray(string, kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$charset$inlined);
                            $continuation.L$0 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1;
                            $continuation.L$1 = null;
                            $continuation.label = 2;
                            if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel, byteArray, 0, 0, $continuation, 6, (Object) null) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$13 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1;
                            byteWriteChannel2 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$13.$channel$inlined;
                            $continuation.L$0 = null;
                            $continuation.label = 3;
                            if (byteWriteChannel2.flush($continuation) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        throw new ArithmeticException("Index overflow has happened");
                    case 1:
                        z2 = false;
                        Object obj = $continuation.L$1;
                        kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$12 = (KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        t2 = obj;
                        z = z2;
                        t = t2;
                        kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$12;
                        json = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.this$0.format;
                        String string2 = json.encodeToString(kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$serializer$inlined, t);
                        byteWriteChannel = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$channel$inlined;
                        byteArray = StringsKt.toByteArray(string2, kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.$charset$inlined);
                        $continuation.L$0 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1;
                        $continuation.L$1 = null;
                        $continuation.label = 2;
                        if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel, byteArray, 0, 0, $continuation, 6, (Object) null) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$13 = (KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        byteWriteChannel2 = kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$13.$channel$inlined;
                        $continuation.L$0 = null;
                        $continuation.label = 3;
                        if (byteWriteChannel2.flush($continuation) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        $continuation = new AnonymousClass1(continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
    }
}