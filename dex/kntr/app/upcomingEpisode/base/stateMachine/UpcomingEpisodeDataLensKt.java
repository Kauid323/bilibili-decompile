package kntr.app.upcomingEpisode.base.stateMachine;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.bapis.bilibili.community.interfacess.watch.v1.KRecommend;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: UpcomingEpisodeDataLens.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"<\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"6\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"0\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"*\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007\"*\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"0\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007\"*\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00101\u001a\u0004\b\u000b\u00102\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00101\u001a\u0004\b\u000f\u00102\"R\u0010\u0010\u001a \u0012\u0004\u0012\u0002H/\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00110\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u00101\u001a\u0004\b\u0016\u00102\"L\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u0002H/\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u00110\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u00101\u001a\u0004\b\u001a\u00102\"F\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u0002H/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c0\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u00101\u001a\u0004\b\u001e\u00102\"@\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020 0\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u00101\u001a\u0004\b\"\u00102\"@\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020$0\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u00101\u001a\u0004\b&\u00102\"F\u0010'\u001a\u0014\u0012\u0004\u0012\u0002H/\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u00101\u001a\u0004\b+\u00102\"@\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u00101\u001a\u0004\b.\u00102\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\t03\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u00101\u001a\u0004\b5\u00106\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\r03\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00101\u001a\u0004\b8\u00106\"T\u0010\u0010\u001a \u0012\u0004\u0012\u0002H/\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001103\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u00101\u001a\u0004\b:\u00106\"N\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u0002H/\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u001103\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u00101\u001a\u0004\b<\u00106\"H\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u0002H/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c03\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u00101\u001a\u0004\b>\u00106\"B\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020 03\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u00101\u001a\u0004\b@\u00106\"B\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020$03\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u00101\u001a\u0004\bB\u00106\"H\u0010'\u001a\u0014\u0012\u0004\u0012\u0002H/\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(03\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u00101\u001a\u0004\bD\u00106\"B\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\t03\"\b\b\u0000\u0010/*\u000200*\u0010\u0012\u0004\u0012\u0002H/\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u00101\u001a\u0004\bF\u00106\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\t03\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010G\u001a\u0004\b\u000b\u0010H\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\r03\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010G\u001a\u0004\b\u000f\u0010H\"R\u0010\u0010\u001a \u0012\u0004\u0012\u0002H/\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001103\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010G\u001a\u0004\b\u0016\u0010H\"L\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u0002H/\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u001103\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010G\u001a\u0004\b\u001a\u0010H\"F\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u0002H/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c03\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010G\u001a\u0004\b\u001e\u0010H\"@\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020 03\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010G\u001a\u0004\b\"\u0010H\"@\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020$03\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010G\u001a\u0004\b&\u0010H\"F\u0010'\u001a\u0014\u0012\u0004\u0012\u0002H/\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(03\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010G\u001a\u0004\b+\u0010H\"@\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\t03\"\b\b\u0000\u0010/*\u000200*\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0002038FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010G\u001a\u0004\b.\u0010H¨\u0006I"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData$Companion;", "getLens$annotations", "(Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData$Companion;)V", "getLens", "(Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "hasRequestCalendarApi", "", "getHasRequestCalendarApi$annotations", "getHasRequestCalendarApi", "calendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "getCalendarType$annotations", "getCalendarType", "cardListMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Lkotlinx/datetime/LocalDate;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "getCardListMap$annotations", "getCardListMap", "pointTypeMap", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "getPointTypeMap$annotations", "getPointTypeMap", "pageSet", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getPageSet$annotations", "getPageSet", "requestModel", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel;", "getRequestModel$annotations", "getRequestModel", "pageStatus", "Lkntr/app/upcomingEpisode/base/stateMachine/PageStatus;", "getPageStatus$annotations", "getPageStatus", "recommendData", "", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KRecommend;", "getRecommendData$annotations", "getRecommendData", "feature", "getFeature$annotations", "getFeature", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "hasRequestCalendarApiNullable$annotations", "hasRequestCalendarApiNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "calendarTypeNullable$annotations", "calendarTypeNullable", "cardListMapNullable$annotations", "cardListMapNullable", "pointTypeMapNullable$annotations", "pointTypeMapNullable", "pageSetNullable$annotations", "pageSetNullable", "requestModelNullable$annotations", "requestModelNullable", "pageStatusNullable$annotations", "pageStatusNullable", "recommendDataNullable$annotations", "recommendDataNullable", "featureNullable$annotations", "featureNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeDataLensKt {
    public static /* synthetic */ void calendarTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void cardListMapNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void featureNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCalendarType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCalendarType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCalendarType$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getCardListMap$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCardListMap$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCardListMap$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getFeature$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFeature$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFeature$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getHasRequestCalendarApi$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHasRequestCalendarApi$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHasRequestCalendarApi$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getPageSet$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageSet$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageSet$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getPointTypeMap$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPointTypeMap$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPointTypeMap$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getRecommendData$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRecommendData$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRecommendData$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void getRequestModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRequestModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRequestModel$annotations(UpcomingEpisodeData.Companion companion) {
    }

    public static /* synthetic */ void hasRequestCalendarApiNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageSetNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageStatusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pointTypeMapNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void recommendDataNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void requestModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<UpcomingEpisodeData, UpcomingEpisodeData> getLens(UpcomingEpisodeData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, UpcomingEpisodeData>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$1
            public UpcomingEpisodeData get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it;
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, UpcomingEpisodeData upcomingEpisodeData2) {
                UpcomingEpisodeData it = upcomingEpisodeData2;
                return it;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super UpcomingEpisodeData, ? extends UpcomingEpisodeData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                return (UpcomingEpisodeData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, Boolean> getHasRequestCalendarApi(UpcomingEpisodeData.Companion $this$hasRequestCalendarApi) {
        Intrinsics.checkNotNullParameter($this$hasRequestCalendarApi, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, Boolean>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$2
            public Boolean get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return Boolean.valueOf(it.getHasRequestCalendarApi());
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, Boolean bool) {
                UpcomingEpisodeData copy;
                boolean hasRequestCalendarApi = bool.booleanValue();
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : hasRequestCalendarApi, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super Boolean, ? extends Boolean> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                boolean hasRequestCalendarApi = ((Boolean) function1.invoke(Boolean.valueOf(it.getHasRequestCalendarApi()))).booleanValue();
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : hasRequestCalendarApi, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, CalendarType> getCalendarType(UpcomingEpisodeData.Companion $this$calendarType) {
        Intrinsics.checkNotNullParameter($this$calendarType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, CalendarType>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$3
            public CalendarType get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it.getCalendarType();
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, CalendarType calendarType) {
                UpcomingEpisodeData copy;
                CalendarType calendarType2 = calendarType;
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : calendarType2, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super CalendarType, ? extends CalendarType> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                CalendarType calendarType = (CalendarType) function1.invoke(it.getCalendarType());
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : calendarType, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>>> getCardListMap(UpcomingEpisodeData.Companion $this$cardListMap) {
        Intrinsics.checkNotNullParameter($this$cardListMap, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>>>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$4
            public SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it.getCardListMap();
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap) {
                UpcomingEpisodeData copy;
                SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> cardListMap = snapshotStateMap;
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : cardListMap, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>>, ? extends SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>>> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                SnapshotStateMap cardListMap = (SnapshotStateMap) function1.invoke(it.getCardListMap());
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : cardListMap, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, SnapshotStateMap<LocalDate, KCalendarPointType>> getPointTypeMap(UpcomingEpisodeData.Companion $this$pointTypeMap) {
        Intrinsics.checkNotNullParameter($this$pointTypeMap, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, SnapshotStateMap<LocalDate, KCalendarPointType>>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$5
            public SnapshotStateMap<LocalDate, KCalendarPointType> get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it.getPointTypeMap();
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap) {
                UpcomingEpisodeData copy;
                SnapshotStateMap<LocalDate, KCalendarPointType> pointTypeMap = snapshotStateMap;
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : pointTypeMap, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super SnapshotStateMap<LocalDate, KCalendarPointType>, ? extends SnapshotStateMap<LocalDate, KCalendarPointType>> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                SnapshotStateMap pointTypeMap = (SnapshotStateMap) function1.invoke(it.getPointTypeMap());
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : pointTypeMap, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, SnapshotStateSet<LocalDate>> getPageSet(UpcomingEpisodeData.Companion $this$pageSet) {
        Intrinsics.checkNotNullParameter($this$pageSet, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, SnapshotStateSet<LocalDate>>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$6
            public SnapshotStateSet<LocalDate> get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it.getPageSet();
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, SnapshotStateSet<LocalDate> snapshotStateSet) {
                UpcomingEpisodeData copy;
                SnapshotStateSet<LocalDate> pageSet = snapshotStateSet;
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : pageSet, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super SnapshotStateSet<LocalDate>, ? extends SnapshotStateSet<LocalDate>> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                SnapshotStateSet pageSet = (SnapshotStateSet) function1.invoke(it.getPageSet());
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : pageSet, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, RequestModel> getRequestModel(UpcomingEpisodeData.Companion $this$requestModel) {
        Intrinsics.checkNotNullParameter($this$requestModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, RequestModel>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$7
            public RequestModel get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it.getRequestModel();
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, RequestModel requestModel) {
                UpcomingEpisodeData copy;
                RequestModel requestModel2 = requestModel;
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : requestModel2, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super RequestModel, ? extends RequestModel> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                RequestModel requestModel = (RequestModel) function1.invoke(it.getRequestModel());
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : requestModel, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, PageStatus> getPageStatus(UpcomingEpisodeData.Companion $this$pageStatus) {
        Intrinsics.checkNotNullParameter($this$pageStatus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, PageStatus>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$8
            public PageStatus get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it.getPageStatus();
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, PageStatus pageStatus) {
                UpcomingEpisodeData copy;
                PageStatus pageStatus2 = pageStatus;
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : pageStatus2, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super PageStatus, ? extends PageStatus> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                PageStatus pageStatus = (PageStatus) function1.invoke(it.getPageStatus());
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : pageStatus, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, List<KRecommend>> getRecommendData(UpcomingEpisodeData.Companion $this$recommendData) {
        Intrinsics.checkNotNullParameter($this$recommendData, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, List<? extends KRecommend>>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$9
            public List<? extends KRecommend> get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return it.getRecommendData();
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, List<? extends KRecommend> list) {
                UpcomingEpisodeData copy;
                List<? extends KRecommend> recommendData = list;
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : recommendData, (r20 & 256) != 0 ? it.feature : false);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super List<? extends KRecommend>, ? extends List<? extends KRecommend>> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                List recommendData = (List) function1.invoke(it.getRecommendData());
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : recommendData, (r20 & 256) != 0 ? it2.feature : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<UpcomingEpisodeData, Boolean> getFeature(UpcomingEpisodeData.Companion $this$feature) {
        Intrinsics.checkNotNullParameter($this$feature, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<UpcomingEpisodeData, Boolean>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeDataLensKt$special$$inlined$invoke$10
            public Boolean get(UpcomingEpisodeData upcomingEpisodeData) {
                UpcomingEpisodeData it = upcomingEpisodeData;
                return Boolean.valueOf(it.getFeature());
            }

            public UpcomingEpisodeData set(UpcomingEpisodeData upcomingEpisodeData, Boolean bool) {
                UpcomingEpisodeData copy;
                boolean feature = bool.booleanValue();
                UpcomingEpisodeData it = upcomingEpisodeData;
                copy = it.copy((r20 & 1) != 0 ? it.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it.calendarType : null, (r20 & 4) != 0 ? it.cardListMap : null, (r20 & 8) != 0 ? it.pointTypeMap : null, (r20 & 16) != 0 ? it.pageSet : null, (r20 & 32) != 0 ? it.requestModel : null, (r20 & 64) != 0 ? it.pageStatus : null, (r20 & 128) != 0 ? it.recommendData : null, (r20 & 256) != 0 ? it.feature : feature);
                return copy;
            }

            public UpcomingEpisodeData modify(UpcomingEpisodeData upcomingEpisodeData, Function1<? super Boolean, ? extends Boolean> function1) {
                UpcomingEpisodeData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                UpcomingEpisodeData it = upcomingEpisodeData;
                boolean feature = ((Boolean) function1.invoke(Boolean.valueOf(it.getFeature()))).booleanValue();
                UpcomingEpisodeData it2 = upcomingEpisodeData;
                copy = it2.copy((r20 & 1) != 0 ? it2.hasRequestCalendarApi : false, (r20 & 2) != 0 ? it2.calendarType : null, (r20 & 4) != 0 ? it2.cardListMap : null, (r20 & 8) != 0 ? it2.pointTypeMap : null, (r20 & 16) != 0 ? it2.pageSet : null, (r20 & 32) != 0 ? it2.requestModel : null, (r20 & 64) != 0 ? it2.pageStatus : null, (r20 & 128) != 0 ? it2.recommendData : null, (r20 & 256) != 0 ? it2.feature : feature);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, Boolean> getHasRequestCalendarApi(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getHasRequestCalendarApi(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, CalendarType> getCalendarType(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCalendarType(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>>> getCardListMap(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCardListMap(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, SnapshotStateMap<LocalDate, KCalendarPointType>> getPointTypeMap(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPointTypeMap(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, SnapshotStateSet<LocalDate>> getPageSet(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageSet(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, RequestModel> getRequestModel(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRequestModel(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, PageStatus> getPageStatus(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageStatus(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, List<KRecommend>> getRecommendData(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRecommendData(UpcomingEpisodeData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getFeature(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFeature(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> hasRequestCalendarApiNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getHasRequestCalendarApi(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, CalendarType> calendarTypeNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCalendarType(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>>> cardListMapNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCardListMap(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, SnapshotStateMap<LocalDate, KCalendarPointType>> pointTypeMapNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPointTypeMap(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, SnapshotStateSet<LocalDate>> pageSetNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageSet(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, RequestModel> requestModelNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRequestModel(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, PageStatus> pageStatusNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageStatus(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, List<KRecommend>> recommendDataNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRecommendData(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> featureNullable(BSimpleLens<T, UpcomingEpisodeData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFeature(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getHasRequestCalendarApi(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getHasRequestCalendarApi(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, CalendarType> getCalendarType(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCalendarType(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>>> getCardListMap(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCardListMap(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, SnapshotStateMap<LocalDate, KCalendarPointType>> getPointTypeMap(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPointTypeMap(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, SnapshotStateSet<LocalDate>> getPageSet(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageSet(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, RequestModel> getRequestModel(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRequestModel(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, PageStatus> getPageStatus(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageStatus(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, List<KRecommend>> getRecommendData(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRecommendData(UpcomingEpisodeData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getFeature(BNullableLens<T, UpcomingEpisodeData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFeature(UpcomingEpisodeData.Companion));
    }
}