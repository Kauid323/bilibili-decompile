package kntr.app.live.room.lolracerscore;

import com.bilibili.ktor.CommonParamsKt;
import com.bilibili.ktor.KtorClientKt;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreEvent;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kntr.base.udf.Store;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J6\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0002\u0010!J2\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010#j\n\u0012\u0004\u0012\u00020$\u0018\u0001`%2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010&J\b\u0010'\u001a\u0004\u0018\u00010\u0010J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005J\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0.J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u00107R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0012X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0002008\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u00103¨\u00069"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreVM;", "Lkntr/base/udf/Store;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;", "roomID", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "scoreMap", "Ljava/util/HashMap;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/collections/HashMap;", "currentCid", "currentBo", "dataModel", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/live/room/lolracerscore/LiveRacerScoreDataModel;", "racerScoreMachine", "Lkntr/base/udf/StoreMachine;", "getRacerScoreMachine$annotations", "()V", "selectRacer", ReportBuildInParam.MODEL, "defaultSelectedId", "postRacerSingleScore", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.CID, "racerID", "uid", "score", "bo", "(JJJIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLplPlayers", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGradeInfo", "Ljava/util/ArrayList;", "Lkntr/app/live/room/lolracerscore/LiveGradeInfoPlayerGradeDetail;", "Lkotlin/collections/ArrayList;", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelectedRacer", "getCurrentCid", "getCurrentBo", "getPlayKey", RoomRecommendViewModel.EMPTY_CURSOR, "getScore", "getAllScore", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoomLOLRacerScoreVM implements Store<RoomLOLRacerScoreState, RoomLOLRacerScoreEvent> {
    private static final String LIVE_HOST = "https://api.live.bilibili.com/";
    private static final String RACER_HOST = "https://api.bilibili.com/";
    private static final String TAG = "LIVE_ROOM_LOL_RACER_SCORE";
    private static final long TEAM_BLUE_PLACE_ID = 1;
    private static final long TEAM_RED_PLACE_ID = 2;
    private long currentBo;
    private long currentCid;
    private final StoreMachine<RoomLOLRacerScoreState, RoomLOLRacerScoreEvent> racerScoreMachine;
    private final long roomID;
    private final Flow<RoomLOLRacerScoreState> state;
    public static final Companion Companion = new Companion(null);
    private static final List<String> locationOrder = CollectionsKt.listOf(new String[]{"TOP", "JUN", "MID", "BOT", "SUP"});
    private final HashMap<Long, Integer> scoreMap = new HashMap<>();
    private List<LiveRacerScoreDataModel> dataModel = CollectionsKt.emptyList();

    private static /* synthetic */ void getRacerScoreMachine$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public RoomLOLRacerScoreVM(long roomID) {
        this.roomID = roomID;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = RoomLOLRacerScoreState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit racerScoreMachine$lambda$0;
                racerScoreMachine$lambda$0 = RoomLOLRacerScoreVM.racerScoreMachine$lambda$0(RoomLOLRacerScoreVM.this, (FlowReduxStoreBuilder) obj);
                return racerScoreMachine$lambda$0;
            }
        };
        this.racerScoreMachine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.racerScoreMachine.getState();
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((RoomLOLRacerScoreEvent) action, (Continuation<? super Unit>) $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit racerScoreMachine$lambda$0(final RoomLOLRacerScoreVM this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit racerScoreMachine$lambda$0$0;
                racerScoreMachine$lambda$0$0 = RoomLOLRacerScoreVM.racerScoreMachine$lambda$0$0(RoomLOLRacerScoreVM.this, (InStateBuilderBlock) obj);
                return racerScoreMachine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(RoomLOLRacerScoreState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit racerScoreMachine$lambda$0$0(RoomLOLRacerScoreVM this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(RoomLOLRacerScoreEvent.GetLOLPlayers.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(RoomLOLRacerScoreEvent.DidSelectPlayer.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(RoomLOLRacerScoreEvent.ScoreToPlayer.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(RoomLOLRacerScoreEvent.ClearSelection.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$5(this$0, null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(RoomLOLRacerScoreEvent.PostRacerScore.class), executionPolicy$iv5, handler$iv5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LiveRacerScoreDataModel> selectRacer(List<LiveRacerScoreDataModel> list, long defaultSelectedId) {
        LiveRacerScoreDataModel liveRacerScoreDataModel;
        LiveRacerScoreDataModel it;
        List<LiveRacerScoreDataModel> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            LiveRacerScoreDataModel it2 = (LiveRacerScoreDataModel) element$iv;
            it2.setSelected(false);
        }
        ListIterator<LiveRacerScoreDataModel> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                liveRacerScoreDataModel = null;
                break;
            }
            liveRacerScoreDataModel = listIterator.previous();
            LiveRacerScoreDataModel it3 = liveRacerScoreDataModel;
            if (it3.getRacerID() == defaultSelectedId) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        LiveRacerScoreDataModel liveRacerScoreDataModel2 = liveRacerScoreDataModel;
        if (liveRacerScoreDataModel2 != null) {
            liveRacerScoreDataModel2.setSelected(true);
        }
        this.dataModel = list;
        return this.dataModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0214 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c6 A[Catch: Exception -> 0x02d2, TryCatch #9 {Exception -> 0x02d2, blocks: (B:71:0x029e, B:75:0x02b6, B:82:0x02c6, B:83:0x02d1), top: B:115:0x0219 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object postRacerSingleScore(final long cid, final long racerID, long uid, final int score, final long bo, Continuation<? super Boolean> continuation) {
        RoomLOLRacerScoreVM$postRacerSingleScore$1 roomLOLRacerScoreVM$postRacerSingleScore$1;
        RoomLOLRacerScoreVM$postRacerSingleScore$1 roomLOLRacerScoreVM$postRacerSingleScore$12;
        String str;
        String urlStr;
        Object obj;
        int score2;
        long bo2;
        long cid2;
        long racerID2;
        long uid2;
        String str2;
        int $i$f$body;
        KType kType;
        Object bodyNullable;
        int $i$f$body2;
        long uid3;
        ?? r13;
        String str3;
        LiveRacerApiResponse liveRacerApiResponse;
        boolean result;
        if (continuation instanceof RoomLOLRacerScoreVM$postRacerSingleScore$1) {
            roomLOLRacerScoreVM$postRacerSingleScore$1 = (RoomLOLRacerScoreVM$postRacerSingleScore$1) continuation;
            if ((roomLOLRacerScoreVM$postRacerSingleScore$1.label & Integer.MIN_VALUE) != 0) {
                roomLOLRacerScoreVM$postRacerSingleScore$1.label -= Integer.MIN_VALUE;
                roomLOLRacerScoreVM$postRacerSingleScore$12 = roomLOLRacerScoreVM$postRacerSingleScore$1;
                Object $result = roomLOLRacerScoreVM$postRacerSingleScore$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (roomLOLRacerScoreVM$postRacerSingleScore$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            HttpClient $this$post$iv = KtorClientKt.getKtorHttpClient();
                            HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, "https://api.bilibili.com/x/esports/grade/player");
                            CommonParamsKt.forceCommonParamsToQuery(httpRequestBuilder.getUrl());
                            try {
                                HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                httpRequestBuilder.url(new Function2() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj2, Object obj3) {
                                        Unit postRacerSingleScore$lambda$0$0;
                                        postRacerSingleScore$lambda$0$0 = RoomLOLRacerScoreVM.postRacerSingleScore$lambda$0$0(cid, bo, score, racerID, (URLBuilder) obj2, (URLBuilder) obj3);
                                        return postRacerSingleScore$lambda$0$0;
                                    }
                                });
                                httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                roomLOLRacerScoreVM$postRacerSingleScore$12.L$0 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/esports/grade/player");
                                roomLOLRacerScoreVM$postRacerSingleScore$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                roomLOLRacerScoreVM$postRacerSingleScore$12.L$2 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/esports/grade/player");
                                roomLOLRacerScoreVM$postRacerSingleScore$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                roomLOLRacerScoreVM$postRacerSingleScore$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                roomLOLRacerScoreVM$postRacerSingleScore$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                roomLOLRacerScoreVM$postRacerSingleScore$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                roomLOLRacerScoreVM$postRacerSingleScore$12.J$0 = cid;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.J$1 = racerID;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.J$2 = uid;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.I$0 = score;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.J$3 = bo;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.I$1 = 0;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.I$2 = 0;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.I$3 = 0;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.I$4 = 0;
                                roomLOLRacerScoreVM$postRacerSingleScore$12.label = 1;
                                Object execute = httpStatement.execute(roomLOLRacerScoreVM$postRacerSingleScore$12);
                                if (execute == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                urlStr = "https://api.bilibili.com/x/esports/grade/player";
                                obj = execute;
                                score2 = score;
                                bo2 = bo;
                                cid2 = cid;
                                racerID2 = racerID;
                                uid2 = uid;
                                try {
                                    HttpResponse httpResponse = (HttpResponse) obj;
                                    str2 = TAG;
                                } catch (Exception e) {
                                    e = e;
                                    str = TAG;
                                }
                                try {
                                    HttpClientCall call = httpResponse.getCall();
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                                    try {
                                        $i$f$body = 0;
                                        try {
                                            kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LiveRacerApiResponse.class)));
                                        } catch (Throwable th) {
                                            kType = null;
                                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$3 = null;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$4 = null;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$5 = null;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$6 = null;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$0 = cid2;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$1 = racerID2;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$2 = uid2;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.I$0 = score2;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$3 = bo2;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.I$1 = $i$f$body;
                                            roomLOLRacerScoreVM$postRacerSingleScore$12.label = 2;
                                            bodyNullable = call.bodyNullable(typeInfo, roomLOLRacerScoreVM$postRacerSingleScore$12);
                                            if (bodyNullable == coroutine_suspended) {
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        $i$f$body = 0;
                                    }
                                    TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass, kType);
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.L$3 = null;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.L$4 = null;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.L$5 = null;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.L$6 = null;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.J$0 = cid2;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.J$1 = racerID2;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.J$2 = uid2;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.I$0 = score2;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.J$3 = bo2;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.I$1 = $i$f$body;
                                    roomLOLRacerScoreVM$postRacerSingleScore$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo2, roomLOLRacerScoreVM$postRacerSingleScore$12);
                                    if (bodyNullable == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $i$f$body2 = score2;
                                    uid3 = uid2;
                                    r13 = uid2;
                                    try {
                                        if (bodyNullable != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kntr.app.live.room.lolracerscore.ApiResponse<kntr.app.live.room.lolracerscore.LiveRacerApiResponse>");
                                        }
                                        try {
                                            ApiResponse response = (ApiResponse) bodyNullable;
                                            liveRacerApiResponse = (LiveRacerApiResponse) response.getData();
                                        } catch (Exception e2) {
                                            e = e2;
                                            str3 = str2;
                                        }
                                        try {
                                            if (liveRacerApiResponse != null) {
                                                try {
                                                    Boolean isSuccess = liveRacerApiResponse.isSuccess();
                                                    if (isSuccess != null) {
                                                        result = isSuccess.booleanValue();
                                                        str3 = str2;
                                                        KLog_androidKt.getKLog().d(str3, "PostRacerScore: cid=" + cid2 + " racerID=" + racerID2 + " uid=" + uid3 + " score=" + $i$f$body2 + " bo=" + bo2 + ". result=" + (!result));
                                                        KLog_androidKt.getKLog().d(str3, "PostRacerScore: DidPostRacerScore, " + (!result));
                                                        return Boxing.boxBoolean(!result);
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    str = str2;
                                                    KLog_androidKt.getKLog().e(str, "postRacerSingleScore error=" + e.getMessage());
                                                    return Boxing.boxBoolean(false);
                                                }
                                            }
                                            KLog_androidKt.getKLog().d(str3, "PostRacerScore: cid=" + cid2 + " racerID=" + racerID2 + " uid=" + uid3 + " score=" + $i$f$body2 + " bo=" + bo2 + ". result=" + (!result));
                                            KLog_androidKt.getKLog().d(str3, "PostRacerScore: DidPostRacerScore, " + (!result));
                                            return Boxing.boxBoolean(!result);
                                        } catch (Exception e4) {
                                            e = e4;
                                            str = str3;
                                            KLog_androidKt.getKLog().e(str, "postRacerSingleScore error=" + e.getMessage());
                                            return Boxing.boxBoolean(false);
                                        }
                                        result = false;
                                        str3 = str2;
                                    } catch (Exception e5) {
                                        e = e5;
                                        str = r13;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    str = str2;
                                    KLog_androidKt.getKLog().e(str, "postRacerSingleScore error=" + e.getMessage());
                                    return Boxing.boxBoolean(false);
                                }
                            } catch (Exception e7) {
                                e = e7;
                                str = TAG;
                                KLog_androidKt.getKLog().e(str, "postRacerSingleScore error=" + e.getMessage());
                                return Boxing.boxBoolean(false);
                            }
                        } catch (Exception e8) {
                            e = e8;
                            str = TAG;
                        }
                    case 1:
                        int i = roomLOLRacerScoreVM$postRacerSingleScore$12.I$4;
                        int i2 = roomLOLRacerScoreVM$postRacerSingleScore$12.I$3;
                        int i3 = roomLOLRacerScoreVM$postRacerSingleScore$12.I$2;
                        int i4 = roomLOLRacerScoreVM$postRacerSingleScore$12.I$1;
                        long bo3 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$3;
                        score2 = roomLOLRacerScoreVM$postRacerSingleScore$12.I$0;
                        long j2 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$2;
                        long racerID3 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$1;
                        long cid3 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$0;
                        HttpClient httpClient = (HttpClient) roomLOLRacerScoreVM$postRacerSingleScore$12.L$6;
                        HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) roomLOLRacerScoreVM$postRacerSingleScore$12.L$5;
                        HttpClient httpClient2 = (HttpClient) roomLOLRacerScoreVM$postRacerSingleScore$12.L$4;
                        HttpClient httpClient3 = (HttpClient) roomLOLRacerScoreVM$postRacerSingleScore$12.L$3;
                        String str4 = (String) roomLOLRacerScoreVM$postRacerSingleScore$12.L$2;
                        HttpClient httpClient4 = (HttpClient) roomLOLRacerScoreVM$postRacerSingleScore$12.L$1;
                        String urlStr2 = (String) roomLOLRacerScoreVM$postRacerSingleScore$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            urlStr = urlStr2;
                            obj = $result;
                            cid2 = cid3;
                            bo2 = bo3;
                            racerID2 = racerID3;
                            uid2 = j2;
                            HttpResponse httpResponse2 = (HttpResponse) obj;
                            str2 = TAG;
                            HttpClientCall call2 = httpResponse2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                            $i$f$body = 0;
                            kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LiveRacerApiResponse.class)));
                            TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass2, kType);
                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$3 = null;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$4 = null;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$5 = null;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.L$6 = null;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$0 = cid2;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$1 = racerID2;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$2 = uid2;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.I$0 = score2;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.J$3 = bo2;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.I$1 = $i$f$body;
                            roomLOLRacerScoreVM$postRacerSingleScore$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo22, roomLOLRacerScoreVM$postRacerSingleScore$12);
                            if (bodyNullable == coroutine_suspended) {
                            }
                        } catch (Exception e9) {
                            e = e9;
                            str = TAG;
                            KLog_androidKt.getKLog().e(str, "postRacerSingleScore error=" + e.getMessage());
                            return Boxing.boxBoolean(false);
                        }
                        break;
                    case 2:
                        int i5 = roomLOLRacerScoreVM$postRacerSingleScore$12.I$1;
                        long bo4 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$3;
                        $i$f$body2 = roomLOLRacerScoreVM$postRacerSingleScore$12.I$0;
                        uid3 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$2;
                        long racerID4 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$1;
                        long cid4 = roomLOLRacerScoreVM$postRacerSingleScore$12.J$0;
                        HttpResponse httpResponse3 = (HttpResponse) roomLOLRacerScoreVM$postRacerSingleScore$12.L$2;
                        HttpResponse httpResponse4 = (HttpResponse) roomLOLRacerScoreVM$postRacerSingleScore$12.L$1;
                        String str5 = (String) roomLOLRacerScoreVM$postRacerSingleScore$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            bo2 = bo4;
                            str2 = TAG;
                            cid2 = cid4;
                            racerID2 = racerID4;
                            bodyNullable = $result;
                            r13 = racerID4;
                            if (bodyNullable != null) {
                            }
                        } catch (Exception e10) {
                            e = e10;
                            str = TAG;
                            KLog_androidKt.getKLog().e(str, "postRacerSingleScore error=" + e.getMessage());
                            return Boxing.boxBoolean(false);
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        roomLOLRacerScoreVM$postRacerSingleScore$1 = new RoomLOLRacerScoreVM$postRacerSingleScore$1(this, continuation);
        roomLOLRacerScoreVM$postRacerSingleScore$12 = roomLOLRacerScoreVM$postRacerSingleScore$1;
        Object $result2 = roomLOLRacerScoreVM$postRacerSingleScore$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (roomLOLRacerScoreVM$postRacerSingleScore$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postRacerSingleScore$lambda$0$0(long $cid, long $bo, int $score, long $racerID, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        $this$url.getParameters().append(AdAlarmExtraKey.CID, String.valueOf($cid));
        $this$url.getParameters().append("bo", String.valueOf($bo));
        $this$url.getParameters().append("score", String.valueOf($score));
        $this$url.getParameters().append("player_id", String.valueOf($racerID));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b3 A[Catch: Exception -> 0x0405, TRY_ENTER, TryCatch #2 {Exception -> 0x0405, blocks: (B:105:0x02a6, B:108:0x02b3, B:109:0x02bb, B:111:0x02c1, B:115:0x02e6, B:117:0x02ec, B:118:0x02f4, B:120:0x02fa, B:127:0x031a, B:129:0x031e, B:134:0x032a, B:138:0x035a, B:139:0x0362, B:141:0x0368, B:145:0x038c, B:147:0x0392, B:148:0x039a, B:150:0x03a0, B:157:0x03c0, B:159:0x03c4, B:164:0x03d0, B:41:0x0173, B:43:0x0182, B:45:0x0189, B:47:0x0190, B:48:0x0198, B:50:0x019e, B:57:0x01b7, B:59:0x01bb, B:61:0x01c8, B:63:0x01cf, B:65:0x01d6, B:66:0x01de, B:68:0x01e4, B:75:0x01fd, B:79:0x0204, B:81:0x020a, B:85:0x021d, B:87:0x0223, B:89:0x0233, B:91:0x023c, B:93:0x0242, B:95:0x024b, B:97:0x0255, B:99:0x025b, B:101:0x0262, B:168:0x03fd, B:169:0x0404, B:29:0x0118, B:36:0x0143, B:26:0x00dc), top: B:180:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x035a A[Catch: Exception -> 0x0405, TryCatch #2 {Exception -> 0x0405, blocks: (B:105:0x02a6, B:108:0x02b3, B:109:0x02bb, B:111:0x02c1, B:115:0x02e6, B:117:0x02ec, B:118:0x02f4, B:120:0x02fa, B:127:0x031a, B:129:0x031e, B:134:0x032a, B:138:0x035a, B:139:0x0362, B:141:0x0368, B:145:0x038c, B:147:0x0392, B:148:0x039a, B:150:0x03a0, B:157:0x03c0, B:159:0x03c4, B:164:0x03d0, B:41:0x0173, B:43:0x0182, B:45:0x0189, B:47:0x0190, B:48:0x0198, B:50:0x019e, B:57:0x01b7, B:59:0x01bb, B:61:0x01c8, B:63:0x01cf, B:65:0x01d6, B:66:0x01de, B:68:0x01e4, B:75:0x01fd, B:79:0x0204, B:81:0x020a, B:85:0x021d, B:87:0x0223, B:89:0x0233, B:91:0x023c, B:93:0x0242, B:95:0x024b, B:97:0x0255, B:99:0x025b, B:101:0x0262, B:168:0x03fd, B:169:0x0404, B:29:0x0118, B:36:0x0143, B:26:0x00dc), top: B:180:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03fd A[Catch: Exception -> 0x0405, TryCatch #2 {Exception -> 0x0405, blocks: (B:105:0x02a6, B:108:0x02b3, B:109:0x02bb, B:111:0x02c1, B:115:0x02e6, B:117:0x02ec, B:118:0x02f4, B:120:0x02fa, B:127:0x031a, B:129:0x031e, B:134:0x032a, B:138:0x035a, B:139:0x0362, B:141:0x0368, B:145:0x038c, B:147:0x0392, B:148:0x039a, B:150:0x03a0, B:157:0x03c0, B:159:0x03c4, B:164:0x03d0, B:41:0x0173, B:43:0x0182, B:45:0x0189, B:47:0x0190, B:48:0x0198, B:50:0x019e, B:57:0x01b7, B:59:0x01bb, B:61:0x01c8, B:63:0x01cf, B:65:0x01d6, B:66:0x01de, B:68:0x01e4, B:75:0x01fd, B:79:0x0204, B:81:0x020a, B:85:0x021d, B:87:0x0223, B:89:0x0233, B:91:0x023c, B:93:0x0242, B:95:0x024b, B:97:0x0255, B:99:0x025b, B:101:0x0262, B:168:0x03fd, B:169:0x0404, B:29:0x0118, B:36:0x0143, B:26:0x00dc), top: B:180:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0173 A[Catch: Exception -> 0x0405, TryCatch #2 {Exception -> 0x0405, blocks: (B:105:0x02a6, B:108:0x02b3, B:109:0x02bb, B:111:0x02c1, B:115:0x02e6, B:117:0x02ec, B:118:0x02f4, B:120:0x02fa, B:127:0x031a, B:129:0x031e, B:134:0x032a, B:138:0x035a, B:139:0x0362, B:141:0x0368, B:145:0x038c, B:147:0x0392, B:148:0x039a, B:150:0x03a0, B:157:0x03c0, B:159:0x03c4, B:164:0x03d0, B:41:0x0173, B:43:0x0182, B:45:0x0189, B:47:0x0190, B:48:0x0198, B:50:0x019e, B:57:0x01b7, B:59:0x01bb, B:61:0x01c8, B:63:0x01cf, B:65:0x01d6, B:66:0x01de, B:68:0x01e4, B:75:0x01fd, B:79:0x0204, B:81:0x020a, B:85:0x021d, B:87:0x0223, B:89:0x0233, B:91:0x023c, B:93:0x0242, B:95:0x024b, B:97:0x0255, B:99:0x025b, B:101:0x0262, B:168:0x03fd, B:169:0x0404, B:29:0x0118, B:36:0x0143, B:26:0x00dc), top: B:180:0x00dc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getLplPlayers(Continuation<? super List<LiveRacerScoreDataModel>> continuation) {
        RoomLOLRacerScoreVM$getLplPlayers$1 roomLOLRacerScoreVM$getLplPlayers$1;
        RoomLOLRacerScoreVM$getLplPlayers$1 roomLOLRacerScoreVM$getLplPlayers$12;
        String urlStr;
        HttpClient $this$get_u24default$iv;
        HttpRequestBuilder builder$iv$iv$iv;
        HttpStatement httpStatement;
        boolean z;
        Object execute;
        KType kType;
        PlayersTeam playersTeam;
        Object bodyNullable;
        HttpResponse httpResponse;
        PlayersTeam playersTeam2;
        PlayersTeam playersTeam3;
        Object obj;
        Object obj2;
        Object $result;
        Object gradeInfo;
        ApiResponse response;
        HttpResponse httpResponse2;
        PlayersTeam teamBlue;
        PlayersTeam teamRed;
        Object obj3;
        PlayersCurrentBo currentBo;
        PlayersStatus status;
        Iterable players;
        Iterable players2;
        PlayersCurrentBo currentBo2;
        List<PlayersTeam> teams;
        PlayersTeam playersTeam4;
        boolean z2;
        PlayersCurrentBo currentBo3;
        List<PlayersTeam> teams2;
        PlayersTeam playersTeam5;
        boolean z3;
        String str;
        Object obj4;
        String userGrade;
        boolean z4;
        String str2;
        Object obj5;
        String userGrade2;
        boolean z5;
        try {
            if (continuation instanceof RoomLOLRacerScoreVM$getLplPlayers$1) {
                roomLOLRacerScoreVM$getLplPlayers$1 = (RoomLOLRacerScoreVM$getLplPlayers$1) continuation;
                if ((roomLOLRacerScoreVM$getLplPlayers$1.label & Integer.MIN_VALUE) != 0) {
                    roomLOLRacerScoreVM$getLplPlayers$1.label -= Integer.MIN_VALUE;
                    roomLOLRacerScoreVM$getLplPlayers$12 = roomLOLRacerScoreVM$getLplPlayers$1;
                    Object $result2 = roomLOLRacerScoreVM$getLplPlayers$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (roomLOLRacerScoreVM$getLplPlayers$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            try {
                                urlStr = "https://api.live.bilibili.com/xlive/esport-realtime/lplPlayers";
                                $this$get_u24default$iv = KtorClientKt.getKtorHttpClient();
                                builder$iv$iv$iv = new HttpRequestBuilder();
                                HttpRequestKt.url(builder$iv$iv$iv, urlStr);
                                builder$iv$iv$iv.setMethod(HttpMethod.Companion.getGet());
                                httpStatement = new HttpStatement(builder$iv$iv$iv, $this$get_u24default$iv);
                            } catch (Exception e) {
                                e = e;
                            }
                            try {
                                roomLOLRacerScoreVM$getLplPlayers$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$2 = SpillingKt.nullOutSpilledVariable(urlStr);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                                roomLOLRacerScoreVM$getLplPlayers$12.I$0 = 0;
                                roomLOLRacerScoreVM$getLplPlayers$12.I$1 = 0;
                                roomLOLRacerScoreVM$getLplPlayers$12.I$2 = 0;
                                roomLOLRacerScoreVM$getLplPlayers$12.I$3 = 0;
                                z = true;
                                roomLOLRacerScoreVM$getLplPlayers$12.label = 1;
                                execute = httpStatement.execute(roomLOLRacerScoreVM$getLplPlayers$12);
                                if (execute == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                HttpResponse httpResponse3 = (HttpResponse) execute;
                                HttpClientCall call = httpResponse3.getCall();
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                                try {
                                    kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LPLPlayers.class)));
                                } catch (Throwable th) {
                                    kType = null;
                                }
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse3);
                                roomLOLRacerScoreVM$getLplPlayers$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse3);
                                playersTeam = null;
                                roomLOLRacerScoreVM$getLplPlayers$12.L$3 = null;
                                roomLOLRacerScoreVM$getLplPlayers$12.L$4 = null;
                                roomLOLRacerScoreVM$getLplPlayers$12.L$5 = null;
                                roomLOLRacerScoreVM$getLplPlayers$12.L$6 = null;
                                roomLOLRacerScoreVM$getLplPlayers$12.I$0 = 0;
                                roomLOLRacerScoreVM$getLplPlayers$12.label = 2;
                                bodyNullable = call.bodyNullable(typeInfo, roomLOLRacerScoreVM$getLplPlayers$12);
                                if (bodyNullable != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpResponse = httpResponse3;
                                if (bodyNullable == null) {
                                    ApiResponse response2 = (ApiResponse) bodyNullable;
                                    LPLPlayers lPLPlayers = (LPLPlayers) response2.getData();
                                    if (lPLPlayers == null || (currentBo3 = lPLPlayers.getCurrentBo()) == null || (teams2 = currentBo3.getTeams()) == null) {
                                        playersTeam2 = playersTeam;
                                    } else {
                                        ListIterator<PlayersTeam> listIterator = teams2.listIterator(teams2.size());
                                        while (true) {
                                            if (listIterator.hasPrevious()) {
                                                playersTeam5 = listIterator.previous();
                                                PlayersTeam it = playersTeam5;
                                                if (it.getPlaceId() == TEAM_BLUE_PLACE_ID) {
                                                    z3 = z;
                                                    continue;
                                                } else {
                                                    z3 = false;
                                                    continue;
                                                }
                                                if (z3) {
                                                }
                                            } else {
                                                playersTeam5 = playersTeam;
                                            }
                                        }
                                        playersTeam2 = playersTeam5;
                                    }
                                    PlayersTeam teamBlue2 = playersTeam2;
                                    LPLPlayers lPLPlayers2 = (LPLPlayers) response2.getData();
                                    if (lPLPlayers2 == null || (currentBo2 = lPLPlayers2.getCurrentBo()) == null || (teams = currentBo2.getTeams()) == null) {
                                        playersTeam3 = playersTeam;
                                    } else {
                                        ListIterator<PlayersTeam> listIterator2 = teams.listIterator(teams.size());
                                        while (true) {
                                            if (listIterator2.hasPrevious()) {
                                                playersTeam4 = listIterator2.previous();
                                                PlayersTeam it2 = playersTeam4;
                                                if (it2.getPlaceId() == TEAM_RED_PLACE_ID) {
                                                    z2 = z;
                                                    continue;
                                                } else {
                                                    z2 = false;
                                                    continue;
                                                }
                                                if (z2) {
                                                }
                                            } else {
                                                playersTeam4 = playersTeam;
                                            }
                                        }
                                        playersTeam3 = playersTeam4;
                                    }
                                    PlayersTeam teamRed2 = playersTeam3;
                                    if (teamBlue2 == null || (players2 = teamBlue2.getPlayers()) == null) {
                                        obj = playersTeam;
                                    } else {
                                        Iterable $this$sortedBy$iv = players2;
                                        obj = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$getLplPlayers$$inlined$sortedBy$1
                                            @Override // java.util.Comparator
                                            public final int compare(T t, T t2) {
                                                List list;
                                                List list2;
                                                LPLPlayer it3 = (LPLPlayer) t;
                                                list = RoomLOLRacerScoreVM.locationOrder;
                                                LPLPlayer it4 = (LPLPlayer) t2;
                                                list2 = RoomLOLRacerScoreVM.locationOrder;
                                                return ComparisonsKt.compareValues(Integer.valueOf(CollectionsKt.indexOf(list, it3.getPlayerLocation())), Integer.valueOf(CollectionsKt.indexOf(list2, it4.getPlayerLocation())));
                                            }
                                        });
                                    }
                                    Object obj6 = obj;
                                    if (teamRed2 == null || (players = teamRed2.getPlayers()) == null) {
                                        obj2 = playersTeam;
                                    } else {
                                        Iterable $this$sortedBy$iv2 = players;
                                        obj2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$getLplPlayers$$inlined$sortedBy$2
                                            @Override // java.util.Comparator
                                            public final int compare(T t, T t2) {
                                                List list;
                                                List list2;
                                                LPLPlayer it3 = (LPLPlayer) t;
                                                list = RoomLOLRacerScoreVM.locationOrder;
                                                LPLPlayer it4 = (LPLPlayer) t2;
                                                list2 = RoomLOLRacerScoreVM.locationOrder;
                                                return ComparisonsKt.compareValues(Integer.valueOf(CollectionsKt.indexOf(list, it3.getPlayerLocation())), Integer.valueOf(CollectionsKt.indexOf(list2, it4.getPlayerLocation())));
                                            }
                                        });
                                    }
                                    Object obj7 = obj2;
                                    LPLPlayers lPLPlayers3 = (LPLPlayers) response2.getData();
                                    this.currentCid = (lPLPlayers3 == null || (status = lPLPlayers3.getStatus()) == null) ? -1L : status.getMatchId();
                                    LPLPlayers lPLPlayers4 = (LPLPlayers) response2.getData();
                                    this.currentBo = (lPLPlayers4 == null || (currentBo = lPLPlayers4.getCurrentBo()) == null) ? -1L : currentBo.getId();
                                    long j2 = this.currentCid;
                                    long j3 = this.currentBo;
                                    roomLOLRacerScoreVM$getLplPlayers$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                                    roomLOLRacerScoreVM$getLplPlayers$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    roomLOLRacerScoreVM$getLplPlayers$12.L$2 = SpillingKt.nullOutSpilledVariable(response2);
                                    roomLOLRacerScoreVM$getLplPlayers$12.L$3 = SpillingKt.nullOutSpilledVariable(teamBlue2);
                                    roomLOLRacerScoreVM$getLplPlayers$12.L$4 = SpillingKt.nullOutSpilledVariable(teamRed2);
                                    roomLOLRacerScoreVM$getLplPlayers$12.L$5 = obj6;
                                    roomLOLRacerScoreVM$getLplPlayers$12.L$6 = obj7;
                                    roomLOLRacerScoreVM$getLplPlayers$12.label = 3;
                                    $result = obj6;
                                    gradeInfo = getGradeInfo(j2, j3, roomLOLRacerScoreVM$getLplPlayers$12);
                                    if (gradeInfo == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    response = response2;
                                    httpResponse2 = httpResponse;
                                    teamBlue = teamBlue2;
                                    teamRed = teamRed2;
                                    obj3 = obj7;
                                    ArrayList allGradeDetail = (ArrayList) gradeInfo;
                                    List dataModel = new ArrayList();
                                    if ($result == null) {
                                        Iterable $this$forEach$iv = (Iterable) $result;
                                        for (Object element$iv : $this$forEach$iv) {
                                            LPLPlayer lplPlayer = (LPLPlayer) element$iv;
                                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                                            long j4 = this.currentCid;
                                            long playerId = lplPlayer.getPlayerId();
                                            PlayersTeam teamRed3 = teamRed;
                                            PlayersTeam teamBlue3 = teamBlue;
                                            long j5 = this.currentBo;
                                            String playerNickname = lplPlayer.getPlayerNickname();
                                            String str3 = playerNickname == null ? RoomRecommendViewModel.EMPTY_CURSOR : playerNickname;
                                            String photo = lplPlayer.getPhoto();
                                            if (allGradeDetail != null) {
                                                Iterator it3 = allGradeDetail.iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        obj5 = it3.next();
                                                        LiveGradeInfoPlayerGradeDetail it4 = (LiveGradeInfoPlayerGradeDetail) obj5;
                                                        if (it4.getPlayerId() == lplPlayer.getPlayerId()) {
                                                            z5 = true;
                                                            continue;
                                                        } else {
                                                            z5 = false;
                                                            continue;
                                                        }
                                                        if (z5) {
                                                        }
                                                    } else {
                                                        obj5 = null;
                                                    }
                                                }
                                                LiveGradeInfoPlayerGradeDetail liveGradeInfoPlayerGradeDetail = (LiveGradeInfoPlayerGradeDetail) obj5;
                                                if (liveGradeInfoPlayerGradeDetail != null && (userGrade2 = liveGradeInfoPlayerGradeDetail.getUserGrade()) != null) {
                                                    str2 = userGrade2;
                                                    dataModel.add(new LiveRacerScoreDataModel(j4, playerId, j5, str3, photo, str2, false));
                                                    $this$forEach$iv = $this$forEach$iv2;
                                                    teamRed = teamRed3;
                                                    teamBlue = teamBlue3;
                                                    response = response;
                                                }
                                            }
                                            str2 = RoomRecommendViewModel.EMPTY_CURSOR;
                                            dataModel.add(new LiveRacerScoreDataModel(j4, playerId, j5, str3, photo, str2, false));
                                            $this$forEach$iv = $this$forEach$iv2;
                                            teamRed = teamRed3;
                                            teamBlue = teamBlue3;
                                            response = response;
                                        }
                                    }
                                    if (obj3 == null) {
                                        Iterable $this$forEach$iv3 = (Iterable) obj3;
                                        boolean z6 = false;
                                        Iterator it5 = $this$forEach$iv3.iterator();
                                        while (it5.hasNext()) {
                                            Object element$iv2 = it5.next();
                                            LPLPlayer lplPlayer2 = (LPLPlayer) element$iv2;
                                            Iterable $this$forEach$iv4 = $this$forEach$iv3;
                                            boolean z7 = z6;
                                            long j6 = this.currentCid;
                                            long playerId2 = lplPlayer2.getPlayerId();
                                            Iterator it6 = it5;
                                            HttpResponse httpResponse4 = httpResponse2;
                                            long j7 = this.currentBo;
                                            String playerNickname2 = lplPlayer2.getPlayerNickname();
                                            String str4 = playerNickname2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : playerNickname2;
                                            String photo2 = lplPlayer2.getPhoto();
                                            if (allGradeDetail != null) {
                                                Iterator it7 = allGradeDetail.iterator();
                                                while (true) {
                                                    if (it7.hasNext()) {
                                                        obj4 = it7.next();
                                                        LiveGradeInfoPlayerGradeDetail it8 = (LiveGradeInfoPlayerGradeDetail) obj4;
                                                        if (it8.getPlayerId() == lplPlayer2.getPlayerId()) {
                                                            z4 = true;
                                                            continue;
                                                        } else {
                                                            z4 = false;
                                                            continue;
                                                        }
                                                        if (z4) {
                                                        }
                                                    } else {
                                                        obj4 = null;
                                                    }
                                                }
                                                LiveGradeInfoPlayerGradeDetail liveGradeInfoPlayerGradeDetail2 = (LiveGradeInfoPlayerGradeDetail) obj4;
                                                if (liveGradeInfoPlayerGradeDetail2 != null && (userGrade = liveGradeInfoPlayerGradeDetail2.getUserGrade()) != null) {
                                                    str = userGrade;
                                                    dataModel.add(new LiveRacerScoreDataModel(j6, playerId2, j7, str4, photo2, str, false));
                                                    $this$forEach$iv3 = $this$forEach$iv4;
                                                    z6 = z7;
                                                    httpResponse2 = httpResponse4;
                                                    it5 = it6;
                                                    obj3 = obj3;
                                                }
                                            }
                                            str = RoomRecommendViewModel.EMPTY_CURSOR;
                                            dataModel.add(new LiveRacerScoreDataModel(j6, playerId2, j7, str4, photo2, str, false));
                                            $this$forEach$iv3 = $this$forEach$iv4;
                                            z6 = z7;
                                            httpResponse2 = httpResponse4;
                                            it5 = it6;
                                            obj3 = obj3;
                                        }
                                    }
                                    return dataModel;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kntr.app.live.room.lolracerscore.ApiResponse<kntr.app.live.room.lolracerscore.LPLPlayers>");
                            } catch (Exception e2) {
                                e = e2;
                                KLog_androidKt.getKLog().e(TAG, "getLplPlayers error=" + e.getMessage());
                                return CollectionsKt.emptyList();
                            }
                        case 1:
                            int $i$f$body = roomLOLRacerScoreVM$getLplPlayers$12.I$3;
                            int i = roomLOLRacerScoreVM$getLplPlayers$12.I$2;
                            int i2 = roomLOLRacerScoreVM$getLplPlayers$12.I$1;
                            int i3 = roomLOLRacerScoreVM$getLplPlayers$12.I$0;
                            HttpClient httpClient = (HttpClient) roomLOLRacerScoreVM$getLplPlayers$12.L$6;
                            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) roomLOLRacerScoreVM$getLplPlayers$12.L$5;
                            HttpClient httpClient2 = (HttpClient) roomLOLRacerScoreVM$getLplPlayers$12.L$4;
                            HttpClient httpClient3 = (HttpClient) roomLOLRacerScoreVM$getLplPlayers$12.L$3;
                            String str5 = (String) roomLOLRacerScoreVM$getLplPlayers$12.L$2;
                            HttpClient httpClient4 = (HttpClient) roomLOLRacerScoreVM$getLplPlayers$12.L$1;
                            urlStr = (String) roomLOLRacerScoreVM$getLplPlayers$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            execute = $result2;
                            z = true;
                            HttpResponse httpResponse32 = (HttpResponse) execute;
                            HttpClientCall call2 = httpResponse32.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                            kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LPLPlayers.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            roomLOLRacerScoreVM$getLplPlayers$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                            roomLOLRacerScoreVM$getLplPlayers$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse32);
                            roomLOLRacerScoreVM$getLplPlayers$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse32);
                            playersTeam = null;
                            roomLOLRacerScoreVM$getLplPlayers$12.L$3 = null;
                            roomLOLRacerScoreVM$getLplPlayers$12.L$4 = null;
                            roomLOLRacerScoreVM$getLplPlayers$12.L$5 = null;
                            roomLOLRacerScoreVM$getLplPlayers$12.L$6 = null;
                            roomLOLRacerScoreVM$getLplPlayers$12.I$0 = 0;
                            roomLOLRacerScoreVM$getLplPlayers$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, roomLOLRacerScoreVM$getLplPlayers$12);
                            if (bodyNullable != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            int i4 = roomLOLRacerScoreVM$getLplPlayers$12.I$0;
                            HttpResponse httpResponse5 = (HttpResponse) roomLOLRacerScoreVM$getLplPlayers$12.L$2;
                            HttpResponse httpResponse6 = (HttpResponse) roomLOLRacerScoreVM$getLplPlayers$12.L$1;
                            String urlStr2 = (String) roomLOLRacerScoreVM$getLplPlayers$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            httpResponse = httpResponse6;
                            urlStr = urlStr2;
                            playersTeam = null;
                            bodyNullable = $result2;
                            z = true;
                            if (bodyNullable == null) {
                            }
                            break;
                        case 3:
                            obj3 = (List) roomLOLRacerScoreVM$getLplPlayers$12.L$6;
                            Object teamBluePlayers = (List) roomLOLRacerScoreVM$getLplPlayers$12.L$5;
                            teamRed = (PlayersTeam) roomLOLRacerScoreVM$getLplPlayers$12.L$4;
                            teamBlue = (PlayersTeam) roomLOLRacerScoreVM$getLplPlayers$12.L$3;
                            response = (ApiResponse) roomLOLRacerScoreVM$getLplPlayers$12.L$2;
                            httpResponse2 = (HttpResponse) roomLOLRacerScoreVM$getLplPlayers$12.L$1;
                            String str6 = (String) roomLOLRacerScoreVM$getLplPlayers$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            $result = teamBluePlayers;
                            gradeInfo = $result2;
                            ArrayList allGradeDetail2 = (ArrayList) gradeInfo;
                            List dataModel2 = new ArrayList();
                            if ($result == null) {
                            }
                            if (obj3 == null) {
                            }
                            return dataModel2;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (roomLOLRacerScoreVM$getLplPlayers$12.label) {
            }
        } catch (Exception e3) {
            e = e3;
        }
        roomLOLRacerScoreVM$getLplPlayers$1 = new RoomLOLRacerScoreVM$getLplPlayers$1(this, continuation);
        roomLOLRacerScoreVM$getLplPlayers$12 = roomLOLRacerScoreVM$getLplPlayers$1;
        Object $result22 = roomLOLRacerScoreVM$getLplPlayers$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b3 A[Catch: Exception -> 0x01eb, TRY_ENTER, TryCatch #2 {Exception -> 0x01eb, blocks: (B:41:0x01b3, B:43:0x01c3, B:45:0x01c9, B:46:0x01d0, B:48:0x01d6, B:53:0x01ef, B:54:0x01f6), top: B:66:0x01b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ef A[Catch: Exception -> 0x01eb, TryCatch #2 {Exception -> 0x01eb, blocks: (B:41:0x01b3, B:43:0x01c3, B:45:0x01c9, B:46:0x01d0, B:48:0x01d6, B:53:0x01ef, B:54:0x01f6), top: B:66:0x01b1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getGradeInfo(final long cid, final long bo, Continuation<? super ArrayList<LiveGradeInfoPlayerGradeDetail>> continuation) {
        RoomLOLRacerScoreVM$getGradeInfo$1 roomLOLRacerScoreVM$getGradeInfo$1;
        RoomLOLRacerScoreVM$getGradeInfo$1 roomLOLRacerScoreVM$getGradeInfo$12;
        HttpClient $this$get$iv;
        HttpMessageBuilder httpRequestBuilder;
        String urlStr;
        Object obj;
        long bo2;
        long cid2;
        KType kType;
        Object bodyNullable;
        long cid3;
        long bo3;
        Iterable teams;
        try {
            if (continuation instanceof RoomLOLRacerScoreVM$getGradeInfo$1) {
                roomLOLRacerScoreVM$getGradeInfo$1 = (RoomLOLRacerScoreVM$getGradeInfo$1) continuation;
                if ((roomLOLRacerScoreVM$getGradeInfo$1.label & Integer.MIN_VALUE) != 0) {
                    roomLOLRacerScoreVM$getGradeInfo$1.label -= Integer.MIN_VALUE;
                    roomLOLRacerScoreVM$getGradeInfo$12 = roomLOLRacerScoreVM$getGradeInfo$1;
                    Object $result = roomLOLRacerScoreVM$getGradeInfo$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (roomLOLRacerScoreVM$getGradeInfo$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            try {
                                $this$get$iv = KtorClientKt.getKtorHttpClient();
                                httpRequestBuilder = new HttpRequestBuilder();
                                HttpRequestKt.url(httpRequestBuilder, "https://api.bilibili.com/x/esports/grade/players/detail");
                                CommonParamsKt.forceCommonParamsToQuery(httpRequestBuilder.getUrl());
                            } catch (Exception e) {
                                e = e;
                            }
                            try {
                                HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                                httpRequestBuilder.url(new Function2() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        Unit gradeInfo$lambda$0$0;
                                        gradeInfo$lambda$0$0 = RoomLOLRacerScoreVM.getGradeInfo$lambda$0$0(cid, bo, (URLBuilder) obj2, (URLBuilder) obj3);
                                        return gradeInfo$lambda$0$0;
                                    }
                                });
                                httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
                                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$get$iv);
                                roomLOLRacerScoreVM$getGradeInfo$12.L$0 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/esports/grade/players/detail");
                                roomLOLRacerScoreVM$getGradeInfo$12.L$1 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                roomLOLRacerScoreVM$getGradeInfo$12.L$2 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/esports/grade/players/detail");
                                roomLOLRacerScoreVM$getGradeInfo$12.L$3 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                roomLOLRacerScoreVM$getGradeInfo$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                roomLOLRacerScoreVM$getGradeInfo$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                roomLOLRacerScoreVM$getGradeInfo$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get$iv);
                                roomLOLRacerScoreVM$getGradeInfo$12.J$0 = cid;
                                roomLOLRacerScoreVM$getGradeInfo$12.J$1 = bo;
                                roomLOLRacerScoreVM$getGradeInfo$12.I$0 = 0;
                                roomLOLRacerScoreVM$getGradeInfo$12.I$1 = 0;
                                roomLOLRacerScoreVM$getGradeInfo$12.I$2 = 0;
                                roomLOLRacerScoreVM$getGradeInfo$12.I$3 = 0;
                                urlStr = "https://api.bilibili.com/x/esports/grade/players/detail";
                                roomLOLRacerScoreVM$getGradeInfo$12.label = 1;
                                Object execute = httpStatement.execute(roomLOLRacerScoreVM$getGradeInfo$12);
                                obj = coroutine_suspended;
                                if (execute == obj) {
                                    return obj;
                                }
                                $result = execute;
                                bo2 = bo;
                                cid2 = cid;
                                try {
                                    HttpResponse httpResponse = (HttpResponse) $result;
                                    HttpClientCall call = httpResponse.getCall();
                                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                                    try {
                                        kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LiveGradeInfo.class)));
                                    } catch (Throwable th) {
                                        kType = null;
                                    }
                                    TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                    roomLOLRacerScoreVM$getGradeInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                                    roomLOLRacerScoreVM$getGradeInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    roomLOLRacerScoreVM$getGradeInfo$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    roomLOLRacerScoreVM$getGradeInfo$12.L$3 = null;
                                    roomLOLRacerScoreVM$getGradeInfo$12.L$4 = null;
                                    roomLOLRacerScoreVM$getGradeInfo$12.L$5 = null;
                                    roomLOLRacerScoreVM$getGradeInfo$12.L$6 = null;
                                    roomLOLRacerScoreVM$getGradeInfo$12.J$0 = cid2;
                                    roomLOLRacerScoreVM$getGradeInfo$12.J$1 = bo2;
                                    roomLOLRacerScoreVM$getGradeInfo$12.I$0 = 0;
                                    roomLOLRacerScoreVM$getGradeInfo$12.label = 2;
                                    bodyNullable = call.bodyNullable(typeInfo, roomLOLRacerScoreVM$getGradeInfo$12);
                                    if (bodyNullable != obj) {
                                        return obj;
                                    }
                                    cid3 = cid2;
                                    bo3 = bo2;
                                    try {
                                        if (bodyNullable == null) {
                                            ApiResponse response = (ApiResponse) bodyNullable;
                                            ArrayList allGradeDetail = new ArrayList();
                                            LiveGradeInfo liveGradeInfo = (LiveGradeInfo) response.getData();
                                            if (liveGradeInfo != null && (teams = liveGradeInfo.getTeams()) != null) {
                                                Iterable $this$forEach$iv = teams;
                                                for (Object element$iv : $this$forEach$iv) {
                                                    LiveGradeInfoTeam it = (LiveGradeInfoTeam) element$iv;
                                                    allGradeDetail.addAll(it.getPlayerGradeDetail());
                                                }
                                            }
                                            return allGradeDetail;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kntr.app.live.room.lolracerscore.ApiResponse<kntr.app.live.room.lolracerscore.LiveGradeInfo>");
                                    } catch (Exception e2) {
                                        e = e2;
                                        KLog_androidKt.getKLog().e(TAG, "getGradeInfo error=" + e.getMessage());
                                        return null;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    KLog_androidKt.getKLog().e(TAG, "getGradeInfo error=" + e.getMessage());
                                    return null;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                KLog_androidKt.getKLog().e(TAG, "getGradeInfo error=" + e.getMessage());
                                return null;
                            }
                        case 1:
                            int $i$f$body = roomLOLRacerScoreVM$getGradeInfo$12.I$3;
                            int i = roomLOLRacerScoreVM$getGradeInfo$12.I$2;
                            int i2 = roomLOLRacerScoreVM$getGradeInfo$12.I$1;
                            int i3 = roomLOLRacerScoreVM$getGradeInfo$12.I$0;
                            long bo4 = roomLOLRacerScoreVM$getGradeInfo$12.J$1;
                            long cid4 = roomLOLRacerScoreVM$getGradeInfo$12.J$0;
                            HttpClient httpClient = (HttpClient) roomLOLRacerScoreVM$getGradeInfo$12.L$6;
                            HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) roomLOLRacerScoreVM$getGradeInfo$12.L$5;
                            HttpClient httpClient2 = (HttpClient) roomLOLRacerScoreVM$getGradeInfo$12.L$4;
                            HttpClient httpClient3 = (HttpClient) roomLOLRacerScoreVM$getGradeInfo$12.L$3;
                            String str = (String) roomLOLRacerScoreVM$getGradeInfo$12.L$2;
                            HttpClient httpClient4 = (HttpClient) roomLOLRacerScoreVM$getGradeInfo$12.L$1;
                            String urlStr2 = (String) roomLOLRacerScoreVM$getGradeInfo$12.L$0;
                            ResultKt.throwOnFailure($result);
                            urlStr = urlStr2;
                            bo2 = bo4;
                            cid2 = cid4;
                            obj = coroutine_suspended;
                            HttpResponse httpResponse2 = (HttpResponse) $result;
                            HttpClientCall call2 = httpResponse2.getCall();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ApiResponse.class);
                            kType = Reflection.typeOf(ApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LiveGradeInfo.class)));
                            TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                            roomLOLRacerScoreVM$getGradeInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(urlStr);
                            roomLOLRacerScoreVM$getGradeInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            roomLOLRacerScoreVM$getGradeInfo$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            roomLOLRacerScoreVM$getGradeInfo$12.L$3 = null;
                            roomLOLRacerScoreVM$getGradeInfo$12.L$4 = null;
                            roomLOLRacerScoreVM$getGradeInfo$12.L$5 = null;
                            roomLOLRacerScoreVM$getGradeInfo$12.L$6 = null;
                            roomLOLRacerScoreVM$getGradeInfo$12.J$0 = cid2;
                            roomLOLRacerScoreVM$getGradeInfo$12.J$1 = bo2;
                            roomLOLRacerScoreVM$getGradeInfo$12.I$0 = 0;
                            roomLOLRacerScoreVM$getGradeInfo$12.label = 2;
                            bodyNullable = call2.bodyNullable(typeInfo2, roomLOLRacerScoreVM$getGradeInfo$12);
                            if (bodyNullable != obj) {
                            }
                            break;
                        case 2:
                            int i4 = roomLOLRacerScoreVM$getGradeInfo$12.I$0;
                            bo3 = roomLOLRacerScoreVM$getGradeInfo$12.J$1;
                            cid3 = roomLOLRacerScoreVM$getGradeInfo$12.J$0;
                            HttpResponse httpResponse3 = (HttpResponse) roomLOLRacerScoreVM$getGradeInfo$12.L$2;
                            HttpResponse httpResponse4 = (HttpResponse) roomLOLRacerScoreVM$getGradeInfo$12.L$1;
                            String str2 = (String) roomLOLRacerScoreVM$getGradeInfo$12.L$0;
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
            switch (roomLOLRacerScoreVM$getGradeInfo$12.label) {
            }
        } catch (Exception e5) {
            e = e5;
        }
        roomLOLRacerScoreVM$getGradeInfo$1 = new RoomLOLRacerScoreVM$getGradeInfo$1(this, continuation);
        roomLOLRacerScoreVM$getGradeInfo$12 = roomLOLRacerScoreVM$getGradeInfo$1;
        Object $result2 = roomLOLRacerScoreVM$getGradeInfo$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGradeInfo$lambda$0$0(long $cid, long $bo, URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        $this$url.getParameters().append(AdAlarmExtraKey.CID, String.valueOf($cid));
        $this$url.getParameters().append("bo", String.valueOf($bo));
        return Unit.INSTANCE;
    }

    public final LiveRacerScoreDataModel getSelectedRacer() {
        LiveRacerScoreDataModel liveRacerScoreDataModel;
        List<LiveRacerScoreDataModel> list = this.dataModel;
        ListIterator<LiveRacerScoreDataModel> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                liveRacerScoreDataModel = null;
                break;
            }
            liveRacerScoreDataModel = listIterator.previous();
            LiveRacerScoreDataModel it = liveRacerScoreDataModel;
            if (it.isSelected()) {
                break;
            }
        }
        return liveRacerScoreDataModel;
    }

    public final long getCurrentCid() {
        return this.currentCid;
    }

    public final long getCurrentBo() {
        return this.currentBo;
    }

    public final String getPlayKey() {
        Instant currentTime = Clock.System.INSTANCE.now();
        long timeIntervalSince1970 = currentTime.toEpochMilliseconds();
        String res = timeIntervalSince1970 + "_" + this.currentCid + "_" + this.currentBo;
        return res;
    }

    public final int getScore(long racerID) {
        Integer num = this.scoreMap.get(Long.valueOf(racerID));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final Map<Long, Integer> getAllScore() {
        return this.scoreMap;
    }

    /* compiled from: RoomLOLRacerScoreVM.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreVM$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "RACER_HOST", "LIVE_HOST", "TEAM_BLUE_PLACE_ID", RoomRecommendViewModel.EMPTY_CURSOR, "TEAM_RED_PLACE_ID", "locationOrder", RoomRecommendViewModel.EMPTY_CURSOR, "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Flow<RoomLOLRacerScoreState> getState() {
        return this.state;
    }

    public Object dispatch(RoomLOLRacerScoreEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this.racerScoreMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}