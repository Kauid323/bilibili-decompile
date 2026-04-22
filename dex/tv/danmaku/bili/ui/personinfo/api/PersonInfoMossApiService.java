package tv.danmaku.bili.ui.personinfo.api;

import com.bapis.bilibili.account.interfaces.v1.AccountInterfaceV1Moss;
import com.bapis.bilibili.account.interfaces.v1.AccountProfileReply;
import com.bapis.bilibili.account.interfaces.v1.AccountProfileReq;
import com.bapis.bilibili.account.interfaces.v1.ApiMossKtxKt;
import com.bapis.bilibili.account.interfaces.v1.UnameMessageReply;
import com.bapis.bilibili.account.interfaces.v1.UnameMessageReq;
import com.bapis.bilibili.account.interfaces.v1.UpdateNameReply;
import com.bapis.bilibili.account.interfaces.v1.UpdateNameReq;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossResponseHandler;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PersonInfoMossApiService.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0007J\u0016\u0010\u0006\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0013\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/api/PersonInfoMossApiService;", "", "<init>", "()V", "moss", "Lcom/bapis/bilibili/account/interfaces/v1/AccountInterfaceV1Moss;", "getNameMessage", "Lcom/bapis/bilibili/account/interfaces/v1/UnameMessageReply;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upDateNameV2", "Lcom/bapis/bilibili/account/interfaces/v1/UpdateNameReply;", "editName", "", "source", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountProfile", "Lcom/bapis/bilibili/account/interfaces/v1/AccountProfileReply;", "", "handler", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "toUIHandler", "T", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PersonInfoMossApiService {
    public static final PersonInfoMossApiService INSTANCE = new PersonInfoMossApiService();
    private static final AccountInterfaceV1Moss moss = new AccountInterfaceV1Moss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
    public static final int $stable = 8;

    private PersonInfoMossApiService() {
    }

    public final Object getNameMessage(Continuation<? super UnameMessageReply> continuation) {
        UnameMessageReq.Builder req = UnameMessageReq.newBuilder();
        AccountInterfaceV1Moss accountInterfaceV1Moss = moss;
        UnameMessageReq build = req.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return ApiMossKtxKt.suspendUnameMessage(accountInterfaceV1Moss, build, continuation);
    }

    public final Object upDateNameV2(String editName, String source, Continuation<? super UpdateNameReply> continuation) {
        UpdateNameReq.Builder req = UpdateNameReq.newBuilder().setUname(editName).setSource(source);
        AccountInterfaceV1Moss accountInterfaceV1Moss = moss;
        UpdateNameReq build = req.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return ApiMossKtxKt.suspendUpdateNameV2(accountInterfaceV1Moss, build, continuation);
    }

    public final Object getAccountProfile(Continuation<? super AccountProfileReply> continuation) {
        AccountProfileReq.Builder req = AccountProfileReq.newBuilder();
        AccountInterfaceV1Moss accountInterfaceV1Moss = moss;
        AccountProfileReq build = req.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return ApiMossKtxKt.suspendAccountProfile(accountInterfaceV1Moss, build, continuation);
    }

    @JvmStatic
    public static final void upDateNameV2(String editName, String source, MossResponseHandler<UpdateNameReply> mossResponseHandler) {
        Intrinsics.checkNotNullParameter(editName, "editName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mossResponseHandler, "handler");
        UpdateNameReq.Builder req = UpdateNameReq.newBuilder().setUname(editName).setSource(source);
        AccountInterfaceV1Moss accountInterfaceV1Moss = moss;
        UpdateNameReq build = req.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        accountInterfaceV1Moss.updateNameV2(build, INSTANCE.toUIHandler(mossResponseHandler));
    }

    @JvmStatic
    public static final void getNameMessage(MossResponseHandler<UnameMessageReply> mossResponseHandler) {
        Intrinsics.checkNotNullParameter(mossResponseHandler, "handler");
        AccountInterfaceV1Moss accountInterfaceV1Moss = moss;
        UnameMessageReq build = UnameMessageReq.newBuilder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        accountInterfaceV1Moss.unameMessage(build, INSTANCE.toUIHandler(mossResponseHandler));
    }

    private final <T> MossResponseHandler<T> toUIHandler(MossResponseHandler<T> mossResponseHandler) {
        return new PersonInfoMossApiService$toUIHandler$1(mossResponseHandler);
    }
}