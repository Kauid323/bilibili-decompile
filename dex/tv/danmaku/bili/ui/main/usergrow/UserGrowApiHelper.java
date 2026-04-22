package tv.danmaku.bili.ui.main.usergrow;

import android.content.Context;
import com.bapis.bilibili.account.fission.v1.EntranceReply;
import com.bapis.bilibili.account.fission.v1.EntranceReq;
import com.bapis.bilibili.account.fission.v1.FissionMoss;
import com.bapis.bilibili.account.fission.v1.WindowReply;
import com.bapis.bilibili.account.fission.v1.WindowReq;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.utils.ExBilowUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: UserGrowHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowApiHelper;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserGrowApiHelper {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final UserGrowApi api;

    /* compiled from: UserGrowHelper.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J?\u0010\u0014\u001a\u00020\u00072%\u0010\u0015\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cJ?\u0010\u001d\u001a\u00020\u00072%\u0010\u0015\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowApiHelper$Companion;", "", "<init>", "()V", ReportEvent.Tag.API, "Ltv/danmaku/bili/ui/main/usergrow/UserGrowApi;", "fetchStatus", "", "context", "Landroid/content/Context;", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/main/usergrow/UserGrowStatus;", "fetchWatchWordResult", "Ltv/danmaku/bili/ui/main/usergrow/WatchWordResult;", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", "fetchShareWordResult", "Ltv/danmaku/bili/ui/main/usergrow/ShareWordResult;", "word", "checkActivityWindow", "onSuccess", "Lkotlin/Function1;", "Lcom/bapis/bilibili/account/fission/v1/WindowReply;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "reply", "onFail", "Lkotlin/Function0;", "checkActivityEntrance", "Lcom/bapis/bilibili/account/fission/v1/EntranceReply;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void fetchStatus(Context context, BiliApiDataCallback<UserGrowStatus> biliApiDataCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(biliApiDataCallback, AuthResultCbHelper.ARGS_CALLBACK);
            try {
                UserGrowApiHelper.api.fetchStatusForLogin(BiliAccounts.get(context).getAccessKey()).enqueue((Callback) biliApiDataCallback);
            } catch (Throwable th) {
            }
        }

        public final WatchWordResult fetchWatchWordResult(String code) {
            try {
                return (WatchWordResult) ExBilowUtil.extractResponseData(UserGrowApiHelper.api.checkClipboard(code).execute());
            } catch (Throwable th) {
                return null;
            }
        }

        public final ShareWordResult fetchShareWordResult(String word) {
            try {
                return (ShareWordResult) ExBilowUtil.extractResponseData(UserGrowApiHelper.api.checkShareWordClipboard(word).execute());
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void checkActivityWindow$default(Companion companion, Function1 function1, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            companion.checkActivityWindow(function1, function0);
        }

        public final void checkActivityWindow(final Function1<? super WindowReply, Unit> function1, final Function0<Unit> function0) {
            WindowReq request = WindowReq.newBuilder().build();
            FissionMoss fissionMoss = new FissionMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNull(request);
            fissionMoss.window(request, new MossResponseHandler<WindowReply>() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowApiHelper$Companion$checkActivityWindow$1
                public /* synthetic */ void onHeaders(Map map) {
                    MossResponseHandler.-CC.$default$onHeaders(this, map);
                }

                public /* synthetic */ long onNextForAck(Object obj) {
                    return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
                }

                public /* synthetic */ void onUpstreamAck(Long l) {
                    MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
                }

                public /* synthetic */ void onValid() {
                    MossResponseHandler.-CC.$default$onValid(this);
                }

                public void onNext(WindowReply value) {
                    Function1<WindowReply, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(value);
                    }
                }

                public void onError(MossException t) {
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }

                public void onCompleted() {
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void checkActivityEntrance$default(Companion companion, Function1 function1, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            companion.checkActivityEntrance(function1, function0);
        }

        public final void checkActivityEntrance(final Function1<? super EntranceReply, Unit> function1, final Function0<Unit> function0) {
            EntranceReq request = EntranceReq.newBuilder().build();
            FissionMoss fissionMoss = new FissionMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNull(request);
            fissionMoss.entrance(request, new MossResponseHandler<EntranceReply>() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowApiHelper$Companion$checkActivityEntrance$1
                public /* synthetic */ void onHeaders(Map map) {
                    MossResponseHandler.-CC.$default$onHeaders(this, map);
                }

                public /* synthetic */ long onNextForAck(Object obj) {
                    return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
                }

                public /* synthetic */ void onUpstreamAck(Long l) {
                    MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
                }

                public /* synthetic */ void onValid() {
                    MossResponseHandler.-CC.$default$onValid(this);
                }

                public void onNext(EntranceReply value) {
                    Function1<EntranceReply, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(value);
                    }
                }

                public void onError(MossException t) {
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }

                public void onCompleted() {
                }
            });
        }
    }

    static {
        Object createService = ServiceGenerator.createService(UserGrowApi.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        api = (UserGrowApi) createService;
    }
}