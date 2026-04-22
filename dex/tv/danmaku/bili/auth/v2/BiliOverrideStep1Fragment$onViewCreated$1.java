package tv.danmaku.bili.auth.v2;

import bili.resource.account.R;
import com.bilibili.droid.ToastHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.bean.OverrideSummary;

/* compiled from: BiliOverrideStep1Fragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliOverrideStep1Fragment$onViewCreated$1", f = "BiliOverrideStep1Fragment.kt", i = {}, l = {BR.buttonVisible, BR.canFavor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliOverrideStep1Fragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $overrideMid;
    int label;
    final /* synthetic */ BiliOverrideStep1Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliOverrideStep1Fragment$onViewCreated$1(BiliOverrideStep1Fragment biliOverrideStep1Fragment, String str, String str2, Continuation<? super BiliOverrideStep1Fragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = biliOverrideStep1Fragment;
        this.$overrideMid = str;
        this.$name = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliOverrideStep1Fragment$onViewCreated$1(this.this$0, this.$overrideMid, this.$name, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #1 {Exception -> 0x0069, blocks: (B:19:0x003e, B:21:0x0042), top: B:32:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String str;
        Object requestData;
        Object $result2;
        OverrideSummary data;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            e = e;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BiliOverrideStep1Fragment biliOverrideStep1Fragment = this.this$0;
                str = this.this$0.requestId;
                if (str == null) {
                    str = "";
                }
                this.label = 1;
                requestData = biliOverrideStep1Fragment.requestData(str, this.$overrideMid, (Continuation) this);
                if (requestData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = requestData;
                try {
                    data = (OverrideSummary) $result;
                    if (data != null) {
                        this.this$0.summary = data;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, this.$name, data, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = $result2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    $result = $result2;
                    BLog.e(BiliOverrideStep1Fragment.TAG, "getOverrideSummary error: " + e.getMessage());
                    ToastHelper.showToastShort(this.this$0.getContext(), this.this$0.getString(R.string.account_global_string_465));
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                data = (OverrideSummary) $result;
                if (data != null) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BiliOverrideStep1Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliOverrideStep1Fragment$onViewCreated$1$1", f = "BiliOverrideStep1Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.auth.v2.BiliOverrideStep1Fragment$onViewCreated$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OverrideSummary $data;
        final /* synthetic */ String $name;
        int label;
        final /* synthetic */ BiliOverrideStep1Fragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BiliOverrideStep1Fragment biliOverrideStep1Fragment, String str, OverrideSummary overrideSummary, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = biliOverrideStep1Fragment;
            this.$name = str;
            this.$data = overrideSummary;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$name, this.$data, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.this$0.refreshUI(this.$name, this.$data);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}