package im.session.track;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.session.track.IMSessionLoadTimeTrack;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: IMSessionLoadTimeTrackLens.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\",\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\",\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010)\u001a\u0004\b\u000b\u0010*\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010)\u001a\u0004\b\u000f\u0010*\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010)\u001a\u0004\b\u0012\u0010*\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010)\u001a\u0004\b\u0015\u0010*\"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010)\u001a\u0004\b\u0018\u0010*\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010)\u001a\u0004\b\u001b\u0010*\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u001d0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010)\u001a\u0004\b\u001f\u0010*\"B\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010)\u001a\u0004\b#\u0010*\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010)\u001a\u0004\b&\u0010*\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\t0+\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010)\u001a\u0004\b-\u0010.\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010)\u001a\u0004\b0\u0010.\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010)\u001a\u0004\b2\u0010.\"B\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010)\u001a\u0004\b4\u0010.\"B\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010)\u001a\u0004\b6\u0010.\"B\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010)\u001a\u0004\b8\u0010.\"B\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u001d0+\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010)\u001a\u0004\b:\u0010.\"D\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010)\u001a\u0004\b<\u0010*\"D\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010'*\u00020(*\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010)\u001a\u0004\b>\u0010*\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\t0+\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010?\u001a\u0004\b\u000b\u0010@\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010?\u001a\u0004\b\u000f\u0010@\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010?\u001a\u0004\b\u0012\u0010@\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010?\u001a\u0004\b\u0015\u0010@\"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010?\u001a\u0004\b\u0018\u0010@\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\r0+\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010?\u001a\u0004\b\u001b\u0010@\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u001d0+\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010?\u001a\u0004\b\u001f\u0010@\"B\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010?\u001a\u0004\b#\u0010A\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H'\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010'*\u00020(*\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\u00020+8FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010?\u001a\u0004\b&\u0010A¨\u0006B"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/session/track/IMSessionLoadTimeTrack;", "Lim/session/track/IMSessionLoadTimeTrack$Companion;", "getLens$annotations", "(Lim/session/track/IMSessionLoadTimeTrack$Companion;)V", "getLens", "(Lim/session/track/IMSessionLoadTimeTrack$Companion;)Lcom/bilibili/blens/BSimpleLens;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getPageType$annotations", "getPageType", "start", "Lkotlinx/datetime/Instant;", "getStart$annotations", "getStart", "cacheLoad", "getCacheLoad$annotations", "getCacheLoad", "mossLoad", "getMossLoad$annotations", "getMossLoad", "cacheViewReady", "getCacheViewReady$annotations", "getCacheViewReady", "mossViewReady", "getMossViewReady$annotations", "getMossViewReady", "startFromNotLogin", "", "getStartFromNotLogin$annotations", "getStartFromNotLogin", "firstCacheError", "", "getFirstCacheError$annotations", "getFirstCacheError", "firstMossError", "getFirstMossError$annotations", "getFirstMossError", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "pageTypeNullable$annotations", "pageTypeNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "startNullable$annotations", "startNullable", "cacheLoadNullable$annotations", "cacheLoadNullable", "mossLoadNullable$annotations", "mossLoadNullable", "cacheViewReadyNullable$annotations", "cacheViewReadyNullable", "mossViewReadyNullable$annotations", "mossViewReadyNullable", "startFromNotLoginNullable$annotations", "startFromNotLoginNullable", "firstCacheErrorNullable$annotations", "firstCacheErrorNullable", "firstMossErrorNullable$annotations", "firstMossErrorNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionLoadTimeTrackLensKt {
    public static /* synthetic */ void cacheLoadNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void cacheViewReadyNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void firstCacheErrorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void firstMossErrorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCacheLoad$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCacheLoad$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCacheLoad$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getCacheViewReady$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCacheViewReady$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCacheViewReady$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getFirstCacheError$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFirstCacheError$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFirstCacheError$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getFirstMossError$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFirstMossError$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFirstMossError$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getMossLoad$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMossLoad$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMossLoad$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getMossViewReady$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMossViewReady$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMossViewReady$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getPageType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageType$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getStart$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStart$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStart$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void getStartFromNotLogin$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStartFromNotLogin$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStartFromNotLogin$annotations(IMSessionLoadTimeTrack.Companion companion) {
    }

    public static /* synthetic */ void mossLoadNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void mossViewReadyNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void startFromNotLoginNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void startNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, IMSessionLoadTimeTrack> getLens(IMSessionLoadTimeTrack.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, IMSessionLoadTimeTrack>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$1
            public IMSessionLoadTimeTrack get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it;
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, IMSessionLoadTimeTrack iMSessionLoadTimeTrack2) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack2;
                return it;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super IMSessionLoadTimeTrack, ? extends IMSessionLoadTimeTrack> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return (IMSessionLoadTimeTrack) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, KSessionPageType> getPageType(IMSessionLoadTimeTrack.Companion $this$pageType) {
        Intrinsics.checkNotNullParameter($this$pageType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, KSessionPageType>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$2
            public KSessionPageType get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getPageType();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, KSessionPageType kSessionPageType) {
                IMSessionLoadTimeTrack copy;
                KSessionPageType pageType = kSessionPageType;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : pageType, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super KSessionPageType, ? extends KSessionPageType> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                KSessionPageType pageType = (KSessionPageType) function1.invoke(it.getPageType());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : pageType, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Instant> getStart(IMSessionLoadTimeTrack.Companion $this$start) {
        Intrinsics.checkNotNullParameter($this$start, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Instant>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$3
            public Instant get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getStart();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Instant instant) {
                IMSessionLoadTimeTrack copy;
                Instant start = instant;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : start, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Instant, ? extends Instant> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                Instant start = (Instant) function1.invoke(it.getStart());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : start, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Instant> getCacheLoad(IMSessionLoadTimeTrack.Companion $this$cacheLoad) {
        Intrinsics.checkNotNullParameter($this$cacheLoad, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Instant>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$4
            public Instant get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getCacheLoad();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Instant instant) {
                IMSessionLoadTimeTrack copy;
                Instant cacheLoad = instant;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : cacheLoad, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Instant, ? extends Instant> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                Instant cacheLoad = (Instant) function1.invoke(it.getCacheLoad());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : cacheLoad, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Instant> getMossLoad(IMSessionLoadTimeTrack.Companion $this$mossLoad) {
        Intrinsics.checkNotNullParameter($this$mossLoad, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Instant>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$5
            public Instant get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getMossLoad();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Instant instant) {
                IMSessionLoadTimeTrack copy;
                Instant mossLoad = instant;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : mossLoad, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Instant, ? extends Instant> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                Instant mossLoad = (Instant) function1.invoke(it.getMossLoad());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : mossLoad, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Instant> getCacheViewReady(IMSessionLoadTimeTrack.Companion $this$cacheViewReady) {
        Intrinsics.checkNotNullParameter($this$cacheViewReady, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Instant>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$6
            public Instant get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getCacheViewReady();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Instant instant) {
                IMSessionLoadTimeTrack copy;
                Instant cacheViewReady = instant;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : cacheViewReady, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Instant, ? extends Instant> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                Instant cacheViewReady = (Instant) function1.invoke(it.getCacheViewReady());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : cacheViewReady, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Instant> getMossViewReady(IMSessionLoadTimeTrack.Companion $this$mossViewReady) {
        Intrinsics.checkNotNullParameter($this$mossViewReady, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Instant>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$7
            public Instant get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getMossViewReady();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Instant instant) {
                IMSessionLoadTimeTrack copy;
                Instant mossViewReady = instant;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : mossViewReady, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Instant, ? extends Instant> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                Instant mossViewReady = (Instant) function1.invoke(it.getMossViewReady());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : mossViewReady, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Boolean> getStartFromNotLogin(IMSessionLoadTimeTrack.Companion $this$startFromNotLogin) {
        Intrinsics.checkNotNullParameter($this$startFromNotLogin, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Boolean>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$8
            public Boolean get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return Boolean.valueOf(it.getStartFromNotLogin());
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Boolean bool) {
                IMSessionLoadTimeTrack copy;
                boolean startFromNotLogin = bool.booleanValue();
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : startFromNotLogin, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Boolean, ? extends Boolean> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                boolean startFromNotLogin = ((Boolean) function1.invoke(Boolean.valueOf(it.getStartFromNotLogin()))).booleanValue();
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : startFromNotLogin, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Throwable> getFirstCacheError(IMSessionLoadTimeTrack.Companion $this$firstCacheError) {
        Intrinsics.checkNotNullParameter($this$firstCacheError, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Throwable>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$9
            public Throwable get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getFirstCacheError();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Throwable th) {
                IMSessionLoadTimeTrack copy;
                Throwable firstCacheError = th;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : firstCacheError, (r20 & 256) != 0 ? it.firstMossError : null);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Throwable, ? extends Throwable> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                Throwable firstCacheError = (Throwable) function1.invoke(it.getFirstCacheError());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : firstCacheError, (r20 & 256) != 0 ? it2.firstMossError : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMSessionLoadTimeTrack, Throwable> getFirstMossError(IMSessionLoadTimeTrack.Companion $this$firstMossError) {
        Intrinsics.checkNotNullParameter($this$firstMossError, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionLoadTimeTrack, Throwable>() { // from class: im.session.track.IMSessionLoadTimeTrackLensKt$special$$inlined$invoke$10
            public Throwable get(IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                return it.getFirstMossError();
            }

            public IMSessionLoadTimeTrack set(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Throwable th) {
                IMSessionLoadTimeTrack copy;
                Throwable firstMossError = th;
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                copy = it.copy((r20 & 1) != 0 ? it.pageType : null, (r20 & 2) != 0 ? it.start : null, (r20 & 4) != 0 ? it.cacheLoad : null, (r20 & 8) != 0 ? it.mossLoad : null, (r20 & 16) != 0 ? it.cacheViewReady : null, (r20 & 32) != 0 ? it.mossViewReady : null, (r20 & 64) != 0 ? it.startFromNotLogin : false, (r20 & 128) != 0 ? it.firstCacheError : null, (r20 & 256) != 0 ? it.firstMossError : firstMossError);
                return copy;
            }

            public IMSessionLoadTimeTrack modify(IMSessionLoadTimeTrack iMSessionLoadTimeTrack, Function1<? super Throwable, ? extends Throwable> function1) {
                IMSessionLoadTimeTrack copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionLoadTimeTrack it = iMSessionLoadTimeTrack;
                Throwable firstMossError = (Throwable) function1.invoke(it.getFirstMossError());
                IMSessionLoadTimeTrack it2 = iMSessionLoadTimeTrack;
                copy = it2.copy((r20 & 1) != 0 ? it2.pageType : null, (r20 & 2) != 0 ? it2.start : null, (r20 & 4) != 0 ? it2.cacheLoad : null, (r20 & 8) != 0 ? it2.mossLoad : null, (r20 & 16) != 0 ? it2.cacheViewReady : null, (r20 & 32) != 0 ? it2.mossViewReady : null, (r20 & 64) != 0 ? it2.startFromNotLogin : false, (r20 & 128) != 0 ? it2.firstCacheError : null, (r20 & 256) != 0 ? it2.firstMossError : firstMossError);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, KSessionPageType> getPageType(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageType(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getStart(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStart(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getCacheLoad(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCacheLoad(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getMossLoad(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMossLoad(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getCacheViewReady(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCacheViewReady(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getMossViewReady(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMossViewReady(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getStartFromNotLogin(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStartFromNotLogin(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getFirstCacheError(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getFirstCacheError(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getFirstMossError(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getFirstMossError(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, KSessionPageType> pageTypeNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageType(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> startNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStart(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> cacheLoadNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCacheLoad(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> mossLoadNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMossLoad(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> cacheViewReadyNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCacheViewReady(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> mossViewReadyNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMossViewReady(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> startFromNotLoginNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStartFromNotLogin(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> firstCacheErrorNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getFirstCacheError(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> firstMossErrorNullable(BSimpleLens<T, IMSessionLoadTimeTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getFirstMossError(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, KSessionPageType> getPageType(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageType(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getStart(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStart(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getCacheLoad(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCacheLoad(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getMossLoad(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMossLoad(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getCacheViewReady(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCacheViewReady(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getMossViewReady(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMossViewReady(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getStartFromNotLogin(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStartFromNotLogin(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getFirstCacheError(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getFirstCacheError(IMSessionLoadTimeTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getFirstMossError(BNullableLens<T, IMSessionLoadTimeTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getFirstMossError(IMSessionLoadTimeTrack.Companion));
    }
}