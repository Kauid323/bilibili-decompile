package kntr.app.upcomingEpisode.base.util;

import com.bilibili.ktor.KApiResponse;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt;

/* compiled from: ReservationApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0087@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0087@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/upcomingEpisode/base/util/ReservationApi;", "", "<init>", "()V", "TAG", "", "BASE_HOST", "RESERVATION_FROM", "RESERVATION_TYP", "RESERVATION_PATH", "UNRESERVATION_PATH", "reserveCard", "", "sid", "spmid", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelReserveCard", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ReservationApi {
    public static final int $stable = 0;
    private static final String BASE_HOST = "api.bilibili.com";
    public static final ReservationApi INSTANCE = new ReservationApi();
    private static final String RESERVATION_FROM = "watch";
    private static final String RESERVATION_PATH = "/x/new-reserve/reserve/add";
    private static final String RESERVATION_TYP = "watch_calendar";
    private static final String TAG = "ReservationApi";
    private static final String UNRESERVATION_PATH = "x/new-reserve/reserve/cancel";

    private ReservationApi() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reserveCard(String sid, String spmid, Continuation<? super Unit> continuation) {
        ReservationApi$reserveCard$1 reservationApi$reserveCard$1;
        ReservationApi$reserveCard$1 reservationApi$reserveCard$12;
        String sid2;
        Url url;
        Object obj;
        String spmid2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof ReservationApi$reserveCard$1) {
            reservationApi$reserveCard$1 = (ReservationApi$reserveCard$1) continuation;
            if ((reservationApi$reserveCard$1.label & Integer.MIN_VALUE) != 0) {
                reservationApi$reserveCard$1.label -= Integer.MIN_VALUE;
                reservationApi$reserveCard$12 = reservationApi$reserveCard$1;
                Object $result = reservationApi$reserveCard$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (reservationApi$reserveCard$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$reserveCard_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$reserveCard_u24lambda_u240, RESERVATION_PATH);
                        Url url2 = $this$reserveCard_u24lambda_u240.build();
                        reservationApi$reserveCard$12.L$0 = SpillingKt.nullOutSpilledVariable(sid);
                        reservationApi$reserveCard$12.L$1 = SpillingKt.nullOutSpilledVariable(spmid);
                        reservationApi$reserveCard$12.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                        reservationApi$reserveCard$12.label = 1;
                        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new ReservationApi$reserveCard$httpResponse$1(url2, sid, spmid, null), reservationApi$reserveCard$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sid2 = sid;
                        url = url2;
                        obj = withContext;
                        spmid2 = spmid;
                        HttpResponse httpResponse = (HttpResponse) obj;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        reservationApi$reserveCard$12.L$0 = SpillingKt.nullOutSpilledVariable(sid2);
                        reservationApi$reserveCard$12.L$1 = SpillingKt.nullOutSpilledVariable(spmid2);
                        reservationApi$reserveCard$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        reservationApi$reserveCard$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        reservationApi$reserveCard$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        reservationApi$reserveCard$12.I$0 = 0;
                        reservationApi$reserveCard$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, reservationApi$reserveCard$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                success.getData();
                            } else if (!(success instanceof KApiResponse.BusinessFailure)) {
                                if (success instanceof KApiResponse.ServiceUnavailable) {
                                    throw new Throwable("KResponse.Unavailable(" + ((KApiResponse.ServiceUnavailable) success).getException().getMessage() + ")");
                                }
                                throw new NoWhenBranchMatchedException();
                            } else {
                                KLog_androidKt.getKLog().e(TAG, "reserve card exception occurred. error message: " + ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Unit>");
                    case 1:
                        spmid2 = (String) reservationApi$reserveCard$12.L$1;
                        sid2 = (String) reservationApi$reserveCard$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) reservationApi$reserveCard$12.L$2;
                        obj = $result;
                        HttpResponse httpResponse2 = (HttpResponse) obj;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        reservationApi$reserveCard$12.L$0 = SpillingKt.nullOutSpilledVariable(sid2);
                        reservationApi$reserveCard$12.L$1 = SpillingKt.nullOutSpilledVariable(spmid2);
                        reservationApi$reserveCard$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        reservationApi$reserveCard$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        reservationApi$reserveCard$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        reservationApi$reserveCard$12.I$0 = 0;
                        reservationApi$reserveCard$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, reservationApi$reserveCard$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = reservationApi$reserveCard$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) reservationApi$reserveCard$12.L$4;
                        HttpResponse httpResponse4 = (HttpResponse) reservationApi$reserveCard$12.L$3;
                        Url url3 = (Url) reservationApi$reserveCard$12.L$2;
                        String str = (String) reservationApi$reserveCard$12.L$1;
                        String str2 = (String) reservationApi$reserveCard$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        reservationApi$reserveCard$1 = new ReservationApi$reserveCard$1(this, continuation);
        reservationApi$reserveCard$12 = reservationApi$reserveCard$1;
        Object $result2 = reservationApi$reserveCard$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (reservationApi$reserveCard$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cancelReserveCard(String sid, Continuation<? super Unit> continuation) {
        ReservationApi$cancelReserveCard$1 reservationApi$cancelReserveCard$1;
        ReservationApi$cancelReserveCard$1 reservationApi$cancelReserveCard$12;
        Url url;
        Object obj;
        String sid2;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof ReservationApi$cancelReserveCard$1) {
            reservationApi$cancelReserveCard$1 = (ReservationApi$cancelReserveCard$1) continuation;
            if ((reservationApi$cancelReserveCard$1.label & Integer.MIN_VALUE) != 0) {
                reservationApi$cancelReserveCard$1.label -= Integer.MIN_VALUE;
                reservationApi$cancelReserveCard$12 = reservationApi$cancelReserveCard$1;
                Object $result = reservationApi$cancelReserveCard$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (reservationApi$cancelReserveCard$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLBuilder $this$cancelReserveCard_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "api.bilibili.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$cancelReserveCard_u24lambda_u240, UNRESERVATION_PATH);
                        Url url2 = $this$cancelReserveCard_u24lambda_u240.build();
                        reservationApi$cancelReserveCard$12.L$0 = SpillingKt.nullOutSpilledVariable(sid);
                        reservationApi$cancelReserveCard$12.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        reservationApi$cancelReserveCard$12.label = 1;
                        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new ReservationApi$cancelReserveCard$httpResponse$1(url2, sid, null), reservationApi$cancelReserveCard$12);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = url2;
                        obj = withContext;
                        sid2 = sid;
                        HttpResponse httpResponse = (HttpResponse) obj;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        reservationApi$cancelReserveCard$12.L$0 = SpillingKt.nullOutSpilledVariable(sid2);
                        reservationApi$cancelReserveCard$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        reservationApi$cancelReserveCard$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        reservationApi$cancelReserveCard$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        reservationApi$cancelReserveCard$12.I$0 = 0;
                        reservationApi$cancelReserveCard$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, reservationApi$cancelReserveCard$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                success.getData();
                            } else if (!(success instanceof KApiResponse.BusinessFailure)) {
                                if (success instanceof KApiResponse.ServiceUnavailable) {
                                    throw new Throwable("KResponse.Unavailable(" + ((KApiResponse.ServiceUnavailable) success).getException().getMessage() + ")");
                                }
                                throw new NoWhenBranchMatchedException();
                            } else {
                                KLog_androidKt.getKLog().e(TAG, "cancel reserve card exception occurred. error message: " + ((KApiResponse.BusinessFailure) success).getMessage());
                            }
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Unit>");
                    case 1:
                        sid2 = (String) reservationApi$cancelReserveCard$12.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) reservationApi$cancelReserveCard$12.L$1;
                        obj = $result;
                        HttpResponse httpResponse2 = (HttpResponse) obj;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        reservationApi$cancelReserveCard$12.L$0 = SpillingKt.nullOutSpilledVariable(sid2);
                        reservationApi$cancelReserveCard$12.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        reservationApi$cancelReserveCard$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        reservationApi$cancelReserveCard$12.L$3 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        reservationApi$cancelReserveCard$12.I$0 = 0;
                        reservationApi$cancelReserveCard$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, reservationApi$cancelReserveCard$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = reservationApi$cancelReserveCard$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) reservationApi$cancelReserveCard$12.L$3;
                        HttpResponse httpResponse4 = (HttpResponse) reservationApi$cancelReserveCard$12.L$2;
                        Url url3 = (Url) reservationApi$cancelReserveCard$12.L$1;
                        String str = (String) reservationApi$cancelReserveCard$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        reservationApi$cancelReserveCard$1 = new ReservationApi$cancelReserveCard$1(this, continuation);
        reservationApi$cancelReserveCard$12 = reservationApi$cancelReserveCard$1;
        Object $result2 = reservationApi$cancelReserveCard$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (reservationApi$cancelReserveCard$12.label) {
        }
    }
}