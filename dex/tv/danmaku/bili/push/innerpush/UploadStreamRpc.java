package tv.danmaku.bili.push.innerpush;

import androidx.collection.LongSparseArray;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.google.protobuf.Empty;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: UploadStreamRpc.kt */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0013\b\u0007\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001aB=\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012*\u0010\u0005\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/push/innerpush/UploadStreamRpc;", "T", "", ChannelRoutes.CHANNEL_NAME, "", "build", "Lkotlin/Function1;", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/google/protobuf/Empty;", "Ltv/danmaku/bili/push/innerpush/ServiceGenerator;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "tokens", "Landroidx/collection/LongSparseArray;", AuthResultCbHelper.ARGS_CALLBACK, "tv/danmaku/bili/push/innerpush/UploadStreamRpc$callback$1", "Ltv/danmaku/bili/push/innerpush/UploadStreamRpc$callback$1;", "service", "send", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UploadStreamRpc<T> {
    private static final String TAG = "[InnerPush]PushStreamRpc";
    private final Function1<MossResponseHandler<Empty>, MossResponseHandler<T>> build;
    private final UploadStreamRpc$callback$1 callback;
    private final Mutex mutex;
    private final String name;
    private MossResponseHandler<T> service;
    private final LongSparseArray<T> tokens;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ UploadStreamRpc(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.push.innerpush.UploadStreamRpc$callback$1] */
    private UploadStreamRpc(String name, Function1<? super MossResponseHandler<Empty>, ? extends MossResponseHandler<T>> function1) {
        this.name = name;
        this.build = function1;
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.tokens = new LongSparseArray<>(0, 1, (DefaultConstructorMarker) null);
        this.callback = new MossResponseHandler<Empty>(this) { // from class: tv.danmaku.bili.push.innerpush.UploadStreamRpc$callback$1
            final /* synthetic */ UploadStreamRpc<T> this$0;

            public /* synthetic */ void onCompleted() {
                MossResponseHandler.-CC.$default$onCompleted(this);
            }

            public /* synthetic */ void onHeaders(Map map) {
                MossResponseHandler.-CC.$default$onHeaders(this, map);
            }

            public /* synthetic */ long onNextForAck(Object obj) {
                return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
            }

            public /* synthetic */ void onValid() {
                MossResponseHandler.-CC.$default$onValid(this);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            public void onError(MossException t) {
                String str;
                str = ((UploadStreamRpc) this.this$0).name;
                BLog.e("[InnerPush]PushStreamRpc", str + " onError", (Throwable) t);
            }

            public void onNext(Empty value) {
                String str;
                str = ((UploadStreamRpc) this.this$0).name;
                BLog.i("[InnerPush]PushStreamRpc", str + " onNext");
            }

            public void onUpstreamAck(Long token) {
                if (token == null) {
                    return;
                }
                token.longValue();
                BuildersKt.launch$default(AppEventUploaderKt.getUploadLoadScope(), (CoroutineContext) null, (CoroutineStart) null, new UploadStreamRpc$callback$1$onUpstreamAck$1(this.this$0, token, null), 3, (Object) null);
            }
        };
    }

    /* compiled from: UploadStreamRpc.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001a\u00020\u00052*\u0010\n\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\f0\u000bj\b\u0012\u0004\u0012\u0002H\b`\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/push/innerpush/UploadStreamRpc$Companion;", "", "<init>", "()V", "TAG", "", "create", "Ltv/danmaku/bili/push/innerpush/UploadStreamRpc;", "T", ChannelRoutes.CHANNEL_NAME, "build", "Lkotlin/Function1;", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/google/protobuf/Empty;", "Ltv/danmaku/bili/push/innerpush/ServiceGenerator;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> UploadStreamRpc<T> create(String name, Function1<? super MossResponseHandler<Empty>, ? extends MossResponseHandler<T>> function1) {
            Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
            Intrinsics.checkNotNullParameter(function1, "build");
            return new UploadStreamRpc<>(name, function1, null);
        }
    }

    public final Mutex getMutex() {
        return this.mutex;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: all -> 0x0077, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00cf, blocks: (B:17:0x005f, B:27:0x00c3, B:26:0x0093, B:20:0x0067), top: B:33:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093 A[Catch: all -> 0x00cf, TryCatch #1 {all -> 0x00cf, blocks: (B:17:0x005f, B:27:0x00c3, B:26:0x0093, B:20:0x0067), top: B:33:0x005f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object send(T t, Continuation<? super Unit> continuation) {
        UploadStreamRpc$send$1 uploadStreamRpc$send$1;
        UploadStreamRpc$send$1 uploadStreamRpc$send$12;
        UploadStreamRpc uploadStreamRpc;
        Object value;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        MossResponseHandler upload;
        try {
            if (continuation instanceof UploadStreamRpc$send$1) {
                uploadStreamRpc$send$1 = (UploadStreamRpc$send$1) continuation;
                if ((uploadStreamRpc$send$1.label & Integer.MIN_VALUE) != 0) {
                    uploadStreamRpc$send$1.label -= Integer.MIN_VALUE;
                    uploadStreamRpc$send$12 = uploadStreamRpc$send$1;
                    Object $result = uploadStreamRpc$send$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (uploadStreamRpc$send$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            uploadStreamRpc = this;
                            value = t;
                            $this$withLock_u24default$iv = uploadStreamRpc.mutex;
                            owner$iv = null;
                            uploadStreamRpc$send$12.L$0 = value;
                            uploadStreamRpc$send$12.L$1 = $this$withLock_u24default$iv;
                            uploadStreamRpc$send$12.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, uploadStreamRpc$send$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) uploadStreamRpc$send$12.L$1;
                            value = uploadStreamRpc$send$12.L$0;
                            ResultKt.throwOnFailure($result);
                            uploadStreamRpc = this;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    upload = uploadStreamRpc.service;
                    if (upload == null) {
                        uploadStreamRpc.service = (MossResponseHandler) uploadStreamRpc.build.invoke(uploadStreamRpc.callback);
                        upload = uploadStreamRpc.service;
                    }
                    if (upload == null) {
                        long token = upload.onNextForAck(value);
                        uploadStreamRpc.tokens.put(token, value);
                        BLog.i(TAG, uploadStreamRpc.name + " onNextForAck,token=" + token + ",message=" + value);
                    }
                    Unit unit = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    Object owner$iv2 = Unit.INSTANCE;
                    return owner$iv2;
                }
            }
            upload = uploadStreamRpc.service;
            if (upload == null) {
            }
            if (upload == null) {
            }
            Unit unit2 = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            Object owner$iv22 = Unit.INSTANCE;
            return owner$iv22;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
        uploadStreamRpc$send$1 = new UploadStreamRpc$send$1(this, continuation);
        uploadStreamRpc$send$12 = uploadStreamRpc$send$1;
        Object $result2 = uploadStreamRpc$send$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uploadStreamRpc$send$12.label) {
        }
    }
}