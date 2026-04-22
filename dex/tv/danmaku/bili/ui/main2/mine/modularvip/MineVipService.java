package tv.danmaku.bili.ui.main2.mine.modularvip;

import android.net.Uri;
import com.bapis.bilibili.app.mine.v1.DisplayPos;
import com.bapis.bilibili.app.mine.v1.DisplayReportReq;
import com.bapis.bilibili.app.mine.v1.MineMoss;
import com.bapis.bilibili.app.mine.v1.MineMossKtxKt;
import com.bilibili.bson.dsl.JsonObjectBuilder;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: MineVipService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J \u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipService;", "", "<init>", "()V", "reportFrequency", "", "model", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportRealExposureApi", "trackParams", "Ltv/danmaku/bili/ui/main2/api/AccountMine$ModularVipTrackParams;", "mid", "", "(Ltv/danmaku/bili/ui/main2/api/AccountMine$ModularVipTrackParams;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportExposureEvent", "reportLatencyExposureEvent", "reportClickEvent", "clickArea", "", "routerUrl", "getReportMap", "", "getRouterUrl", "isButton", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipService {
    public static final int $stable = 0;
    public static final MineVipService INSTANCE = new MineVipService();

    /* compiled from: MineVipService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MineVipButtonIconType.values().length];
            try {
                iArr[MineVipButtonIconType.STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[MineVipButtonIconType.DYNAMIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[MineVipButtonIconType.BIRTHDAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PositionType.values().length];
            try {
                iArr2[PositionType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[PositionType.ICON.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private MineVipService() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|8|13|14))|51|6|7|8|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        tv.danmaku.android.log.BLog.e(tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManagerKt.TAG, "report frequency has error", r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: Exception -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0031, blocks: (B:12:0x002c, B:21:0x003d, B:22:0x005a, B:24:0x0060, B:25:0x007b, B:26:0x007e, B:40:0x00aa, B:27:0x0081, B:29:0x0087, B:34:0x0099, B:35:0x009c, B:36:0x009f, B:37:0x00a2, B:38:0x00a5, B:33:0x0091, B:39:0x00a8, B:41:0x00b8), top: B:48:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reportFrequency(MineVipModel model, Continuation<? super Unit> continuation) {
        MineVipService$reportFrequency$1 mineVipService$reportFrequency$1;
        DisplayPos displayPos;
        if (continuation instanceof MineVipService$reportFrequency$1) {
            mineVipService$reportFrequency$1 = (MineVipService$reportFrequency$1) continuation;
            if ((mineVipService$reportFrequency$1.label & Integer.MIN_VALUE) != 0) {
                mineVipService$reportFrequency$1.label -= Integer.MIN_VALUE;
                Object $result = mineVipService$reportFrequency$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (mineVipService$reportFrequency$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (model == null) {
                            return Unit.INSTANCE;
                        }
                        DisplayReportReq.Builder newBuilder = DisplayReportReq.newBuilder();
                        Iterable $this$map$iv = model.getToReportPositions();
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            PositionType it = (PositionType) item$iv$iv;
                            DisplayReportReq.ReportContent.Builder times = DisplayReportReq.ReportContent.newBuilder().setTimes(1L);
                            switch (WhenMappings.$EnumSwitchMapping$1[it.ordinal()]) {
                                case 1:
                                    displayPos = DisplayPos.VIP_BACKGROUND;
                                    break;
                                case 2:
                                    MineVipButtonIconModel buttonIcon = model.getButtonIcon();
                                    MineVipButtonIconType type = buttonIcon != null ? buttonIcon.getType() : null;
                                    switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                                        case 1:
                                            displayPos = DisplayPos.VIP_BUTTON_STATIC;
                                            continue;
                                        case 2:
                                            displayPos = DisplayPos.VIP_BUTTON_DYNAMIC;
                                            continue;
                                        case 3:
                                            displayPos = DisplayPos.VIP_BUTTON_BIRTHDAY;
                                            continue;
                                        default:
                                            displayPos = DisplayPos.UNRECOGNIZED;
                                            continue;
                                    }
                                default:
                                    displayPos = DisplayPos.UNRECOGNIZED;
                                    break;
                            }
                            destination$iv$iv.add(times.setPos(displayPos).build());
                        }
                        DisplayReportReq req = newBuilder.addAllContent((List) destination$iv$iv).build();
                        MineMoss mineMoss = new MineMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                        Intrinsics.checkNotNull(req);
                        mineVipService$reportFrequency$1.label = 1;
                        if (MineMossKtxKt.suspendDisplayReport(mineMoss, req, mineVipService$reportFrequency$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        mineVipService$reportFrequency$1 = new MineVipService$reportFrequency$1(this, continuation);
        Object $result2 = mineVipService$reportFrequency$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mineVipService$reportFrequency$1.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reportRealExposureApi(AccountMine.ModularVipTrackParams trackParams, long mid, Continuation<? super Unit> continuation) {
        MineVipService$reportRealExposureApi$1 mineVipService$reportRealExposureApi$1;
        MineVipService$reportRealExposureApi$1 mineVipService$reportRealExposureApi$12;
        MediaType parse;
        JsonObject jsonObject;
        JsonElement jsonArray;
        JsonElement jsonElement;
        if (continuation instanceof MineVipService$reportRealExposureApi$1) {
            mineVipService$reportRealExposureApi$1 = (MineVipService$reportRealExposureApi$1) continuation;
            if ((mineVipService$reportRealExposureApi$1.label & Integer.MIN_VALUE) != 0) {
                mineVipService$reportRealExposureApi$1.label -= Integer.MIN_VALUE;
                mineVipService$reportRealExposureApi$12 = mineVipService$reportRealExposureApi$1;
                Object $result = mineVipService$reportRealExposureApi$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (mineVipService$reportRealExposureApi$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (trackParams == null) {
                            return Unit.INSTANCE;
                        }
                        try {
                            parse = MediaType.parse("application/json");
                            JsonObject jsonObject$iv$iv = new JsonObject();
                            jsonObject = JsonObjectBuilder.constructor-impl(jsonObject$iv$iv);
                            jsonArray = new JsonArray();
                            JsonObject jsonObject$iv$iv2 = new JsonObject();
                            jsonElement = JsonObjectBuilder.constructor-impl(jsonObject$iv$iv2);
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            JsonObjectBuilder.kv-impl(jsonElement, "mid", String.valueOf(mid));
                            JsonObjectBuilder.kv-impl(jsonElement, "event_type", ReportEvent.EVENT_TYPE_SHOW);
                            String str = trackParams.materialType;
                            String str2 = "";
                            if (str == null) {
                                str = "";
                            }
                            JsonObjectBuilder.kv-impl(jsonElement, "material_type", str);
                            String str3 = trackParams.positionId;
                            if (str3 == null) {
                                str3 = "";
                            }
                            JsonObjectBuilder.kv-impl(jsonElement, "position_id", str3);
                            String str4 = trackParams.tipsRepeatKey;
                            if (str4 == null) {
                                str4 = "";
                            }
                            JsonObjectBuilder.kv-impl(jsonElement, "tips_repeat_key", str4);
                            String str5 = trackParams.vipStatus;
                            if (str5 == null) {
                                str5 = "";
                            }
                            JsonObjectBuilder.kv-impl(jsonElement, "vip_status", str5);
                            String str6 = trackParams.tipsId;
                            if (str6 != null) {
                                str2 = str6;
                            }
                            JsonObjectBuilder.kv-impl(jsonElement, MineVipServiceKt.VIP_REPORT_PARAM_TIPS_ID, str2);
                            jsonArray.add(jsonElement);
                            Unit unit = Unit.INSTANCE;
                            JsonObjectBuilder.kv-impl(jsonObject, "private_params", jsonArray);
                            RequestBody body = RequestBody.create(parse, JsonUtilKt.toJson(jsonObject));
                            Intrinsics.checkNotNull(body);
                            BiliCall<GeneralResponse<Void>> reportExposure = ((MineVipApi) ServiceGenerator.createService(MineVipApi.class)).reportExposure(body);
                            mineVipService$reportRealExposureApi$12.label = 1;
                            if (BiliCallExtKt.getResponse(reportExposure, mineVipService$reportRealExposureApi$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            BLog.e(MineVipModuleManagerKt.TAG, "report vip exposure api has error", e);
                            return Unit.INSTANCE;
                        }
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                        } catch (Exception e3) {
                            e = e3;
                            BLog.e(MineVipModuleManagerKt.TAG, "report vip exposure api has error", e);
                            return Unit.INSTANCE;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        mineVipService$reportRealExposureApi$1 = new MineVipService$reportRealExposureApi$1(this, continuation);
        mineVipService$reportRealExposureApi$12 = mineVipService$reportRealExposureApi$1;
        Object $result2 = mineVipService$reportRealExposureApi$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mineVipService$reportRealExposureApi$12.label) {
        }
        return Unit.INSTANCE;
    }

    public final void reportExposureEvent(MineVipModel model) {
        if (model == null) {
            return;
        }
        Neurons.reportExposure$default(false, MineVipServiceKt.VIP_ENTRANCE_EVENT_NEW_SHOW, getReportMap(model, getRouterUrl(model, true)), (List) null, 8, (Object) null);
    }

    public final void reportLatencyExposureEvent(MineVipModel model) {
        if (model == null) {
            return;
        }
        Neurons.reportExposure$default(false, MineVipServiceKt.VIP_ENTRANCE_EVENT_REAL_SHOW, getReportMap(model, getRouterUrl(model, true)), (List) null, 8, (Object) null);
    }

    public final void reportClickEvent(MineVipModel model, String clickArea, String routerUrl) {
        Intrinsics.checkNotNullParameter(clickArea, "clickArea");
        Intrinsics.checkNotNullParameter(routerUrl, "routerUrl");
        Neurons.reportClick(false, MineVipServiceKt.VIP_ENTRANCE_EVENT_NEW_CLICK, MapsKt.plus(getReportMap(model, routerUrl), TuplesKt.to(MineVipServiceKt.VIP_REPORT_KEY_CLICK_AREA, clickArea)));
    }

    private final Map<String, String> getReportMap(MineVipModel model, String routerUrl) {
        String str;
        Object obj;
        String image;
        String url;
        if (model == null) {
            return MapsKt.emptyMap();
        }
        Pair[] pairArr = new Pair[9];
        AccountMine.ModularVipTrackParams trackParams = model.getTrackParams();
        String str2 = trackParams != null ? trackParams.tipsId : null;
        if (str2 == null) {
            str2 = "";
        }
        boolean z = false;
        pairArr[0] = TuplesKt.to(MineVipServiceKt.VIP_REPORT_PARAM_TIPS_ID, str2);
        AccountMine.ModularVipTrackParams trackParams2 = model.getTrackParams();
        String str3 = trackParams2 != null ? trackParams2.vipStatus : null;
        if (str3 == null) {
            str3 = "";
        }
        pairArr[1] = TuplesKt.to("vip_status", str3);
        AccountMine.ModularVipTrackParams trackParams3 = model.getTrackParams();
        String str4 = trackParams3 != null ? trackParams3.vipType : null;
        if (str4 == null) {
            str4 = "";
        }
        pairArr[2] = TuplesKt.to(MineVipServiceKt.VIP_REPORT_PARAM_VIP_TYPE, str4);
        AccountMine.ModularVipTrackParams trackParams4 = model.getTrackParams();
        String str5 = trackParams4 != null ? trackParams4.expTag : null;
        if (str5 == null) {
            str5 = "";
        }
        pairArr[3] = TuplesKt.to(MineVipServiceKt.VIP_REPORT_PARAM_EXP_TAG, str5);
        AccountMine.ModularVipTrackParams trackParams5 = model.getTrackParams();
        String str6 = trackParams5 != null ? trackParams5.expGroupTag : null;
        pairArr[4] = TuplesKt.to(MineVipServiceKt.VIP_REPORT_PARAM_EXP_GROUP_TAG, str6 != null ? str6 : "");
        MineVipButtonIconModel buttonIcon = model.getButtonIcon();
        if ((buttonIcon == null || (url = buttonIcon.getUrl()) == null || !(StringsKt.isBlank(url) ^ true)) ? false : true) {
            str = "special";
        } else {
            str = MineVipServiceKt.VIP_REPORT_VALUE_NORMAL;
        }
        pairArr[5] = TuplesKt.to(MineVipServiceKt.VIP_REPORT_PARAM_VIP_BUTTON_STYLE, str);
        MineVipBackgroundModel background = model.getBackground();
        if (background != null && (image = background.getImage()) != null && (!StringsKt.isBlank(image))) {
            z = true;
        }
        if (z) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[6] = TuplesKt.to(MineVipServiceKt.VIP_REPORT_KEY_BACKGROUND, obj);
        MineVipButtonModel button = model.getButton();
        pairArr[7] = TuplesKt.to(MineVipServiceKt.VIP_REPORT_KEY_BUTTON_COLOR, (button != null ? button.getStyle() : null) == MineVipButtonStyle.STROKE ? "0" : "1");
        pairArr[8] = TuplesKt.to("url", routerUrl);
        return MapsKt.mapOf(pairArr);
    }

    public final String getRouterUrl(MineVipModel model, boolean isButton) {
        MineVipTitleModel title;
        String it;
        String $this$toUri$iv;
        Uri parse;
        Uri appendVipSourceFromIfAbsent;
        String uri;
        MineVipButtonModel button;
        String it2;
        Uri parse2;
        Uri appendVipSourceFromIfAbsent2;
        String uri2;
        if (isButton) {
            if (model == null || (button = model.getButton()) == null || (it2 = button.getJumpLink()) == null) {
                return "https://big.bilibili.com/mobile/index";
            }
            $this$toUri$iv = StringsKt.isBlank(it2) ? null : it2;
            return ($this$toUri$iv == null || (parse2 = Uri.parse($this$toUri$iv)) == null || (appendVipSourceFromIfAbsent2 = MineVipServiceKt.appendVipSourceFromIfAbsent(parse2, MineVipServiceKt.VIP_ENTRANCE_EVENT_NEW_CLICK)) == null || (uri2 = appendVipSourceFromIfAbsent2.toString()) == null) ? "https://big.bilibili.com/mobile/index" : uri2;
        } else if (model == null || (title = model.getTitle()) == null || (it = title.getJumpLink()) == null) {
            return "https://big.bilibili.com/mobile/index";
        } else {
            $this$toUri$iv = StringsKt.isBlank(it) ? null : it;
            return ($this$toUri$iv == null || (parse = Uri.parse($this$toUri$iv)) == null || (appendVipSourceFromIfAbsent = MineVipServiceKt.appendVipSourceFromIfAbsent(parse, MineVipServiceKt.VIP_ENTRANCE_EVENT_TEXT_CLICK)) == null || (uri = appendVipSourceFromIfAbsent.toString()) == null) ? "https://big.bilibili.com/mobile/index" : uri;
        }
    }
}