package tv.danmaku.biliplayerv2.service.interact.core.api;

import com.bilibili.api.BiliApiException;
import com.bilibili.okretro.BiliApiCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractApiCallback.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/api/InteractApiCallback;", "Lcom/bilibili/okretro/BiliApiCallback;", "Ltv/danmaku/biliplayerv2/service/interact/core/api/InteractApiResponse;", "<init>", "()V", "onResponse", "", "call", "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onSuccess", "result", "onDataSuccess", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class InteractApiCallback extends BiliApiCallback<InteractApiResponse> {
    public abstract void onDataSuccess(InteractApiResponse interactApiResponse);

    public void onResponse(Call<InteractApiResponse> call, Response<InteractApiResponse> response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (isCancel()) {
            return;
        }
        if (!response.isSuccessful() || isCancel()) {
            onFailure(call, (Throwable) new HttpException(response));
            return;
        }
        InteractApiResponse general = (InteractApiResponse) response.body();
        if (general == null) {
            onDataSuccess(null);
        } else if (general.getCode() != 0) {
            onFailure(call, (Throwable) new BiliApiException(general.getCode(), general.getMessage()));
        } else {
            onDataSuccess(general);
        }
    }

    public void onSuccess(InteractApiResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        throw new UnsupportedOperationException();
    }
}