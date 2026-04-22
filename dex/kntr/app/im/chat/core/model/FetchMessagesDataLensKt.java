package kntr.app.im.chat.core.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.datetime.Instant;

/* compiled from: FetchMessagesDataLens.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\",\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\"0\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007\"0\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0%0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\"0\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007\"*\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007\",\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001040\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\u0007\",\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010<\u001a\u0004\b\u000b\u0010=\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010<\u001a\u0004\b\u000e\u0010=\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010<\u001a\u0004\b\u0011\u0010=\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010<\u001a\u0004\b\u0014\u0010=\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010<\u001a\u0004\b\u0017\u0010=\"B\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010<\u001a\u0004\b\u001b\u0010=\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u001d0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010<\u001a\u0004\b\u001f\u0010=\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010<\u001a\u0004\b#\u0010=\"F\u0010$\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010<\u001a\u0004\b(\u0010=\"F\u0010)\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0%0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010<\u001a\u0004\b,\u0010=\"F\u0010-\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010<\u001a\u0004\b/\u0010=\"@\u00100\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010<\u001a\u0004\b2\u0010=\"B\u00103\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u0001040\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010<\u001a\u0004\b6\u0010=\"B\u00107\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010<\u001a\u0004\b9\u0010=\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010<\u001a\u0004\b@\u0010A\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010<\u001a\u0004\bC\u0010A\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010<\u001a\u0004\bE\u0010A\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010<\u001a\u0004\bG\u0010A\"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010<\u001a\u0004\bI\u0010A\"D\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010<\u001a\u0004\bK\u0010=\"B\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u001d0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010<\u001a\u0004\bM\u0010A\"B\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020!0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010<\u001a\u0004\bO\u0010A\"H\u0010$\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010<\u001a\u0004\bQ\u0010A\"H\u0010)\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0%0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010<\u001a\u0004\bS\u0010A\"H\u0010-\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bT\u0010<\u001a\u0004\bU\u0010A\"B\u00100\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bV\u0010<\u001a\u0004\bW\u0010A\"D\u00103\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u0001040\u0001\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010<\u001a\u0004\bY\u0010=\"D\u00107\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010:*\u00020;*\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010<\u001a\u0004\b[\u0010=\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\\\u001a\u0004\b\u000b\u0010]\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\\\u001a\u0004\b\u000e\u0010]\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\\\u001a\u0004\b\u0011\u0010]\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\\\u001a\u0004\b\u0014\u0010]\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\\\u001a\u0004\b\u0017\u0010]\"B\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\\\u001a\u0004\b\u001b\u0010^\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u001d0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\\\u001a\u0004\b\u001f\u0010]\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020!0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\\\u001a\u0004\b#\u0010]\"F\u0010$\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\\\u001a\u0004\b(\u0010]\"F\u0010)\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0%0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\\\u001a\u0004\b,\u0010]\"F\u0010-\u001a\u0014\u0012\u0004\u0012\u0002H:\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\\\u001a\u0004\b/\u0010]\"@\u00100\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\t0>\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\\\u001a\u0004\b2\u0010]\"B\u00103\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u0001040\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\\\u001a\u0004\b6\u0010^\"B\u00107\u001a\u0010\u0012\u0004\u0012\u0002H:\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010:*\u00020;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\\\u001a\u0004\b9\u0010^¨\u0006_"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "Lkntr/app/im/chat/core/model/FetchMessagesData$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/FetchMessagesData$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/FetchMessagesData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "databaseReady", RoomRecommendViewModel.EMPTY_CURSOR, "getDatabaseReady$annotations", "getDatabaseReady", "loadingLater", "getLoadingLater$annotations", "getLoadingLater", "pendingLoadLater", "getPendingLoadLater$annotations", "getPendingLoadLater", "loadingEarlier", "getLoadingEarlier$annotations", "getLoadingEarlier", "pendingLoadEarlier", "getPendingLoadEarlier$annotations", "getPendingLoadEarlier", "currentRange", "Lkotlin/ranges/LongRange;", "getCurrentRange$annotations", "getCurrentRange", "messages", "Lkntr/app/im/chat/core/model/Messages;", "getMessages$annotations", "getMessages", "baselineTime", "Lkotlinx/datetime/Instant;", "getBaselineTime$annotations", "getBaselineTime", "tempMessages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "getTempMessages$annotations", "getTempMessages", "updateMsgIds", "Lkntr/app/im/chat/core/model/MessageId;", "getUpdateMsgIds$annotations", "getUpdateMsgIds", "markFailedMessage", "getMarkFailedMessage$annotations", "getMarkFailedMessage", "performAck", "getPerformAck$annotations", "getPerformAck", "error", RoomRecommendViewModel.EMPTY_CURSOR, "getError$annotations", "getError", "errorTime", "getErrorTime$annotations", "getErrorTime", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "databaseReadyNullable$annotations", "databaseReadyNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "loadingLaterNullable$annotations", "loadingLaterNullable", "pendingLoadLaterNullable$annotations", "pendingLoadLaterNullable", "loadingEarlierNullable$annotations", "loadingEarlierNullable", "pendingLoadEarlierNullable$annotations", "pendingLoadEarlierNullable", "currentRangeNullable$annotations", "currentRangeNullable", "messagesNullable$annotations", "messagesNullable", "baselineTimeNullable$annotations", "baselineTimeNullable", "tempMessagesNullable$annotations", "tempMessagesNullable", "updateMsgIdsNullable$annotations", "updateMsgIdsNullable", "markFailedMessageNullable$annotations", "markFailedMessageNullable", "performAckNullable$annotations", "performAckNullable", "errorNullable$annotations", "errorNullable", "errorTimeNullable$annotations", "errorTimeNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FetchMessagesDataLensKt {
    public static /* synthetic */ void baselineTimeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void currentRangeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void databaseReadyNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void errorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void errorTimeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBaselineTime$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getBaselineTime$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBaselineTime$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getCurrentRange$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCurrentRange$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCurrentRange$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getDatabaseReady$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDatabaseReady$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDatabaseReady$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getError$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getError$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getError$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getErrorTime$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getErrorTime$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getErrorTime$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getLoadingEarlier$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLoadingEarlier$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLoadingEarlier$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getLoadingLater$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLoadingLater$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLoadingLater$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getMarkFailedMessage$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMarkFailedMessage$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMarkFailedMessage$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getMessages$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMessages$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMessages$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getPendingLoadEarlier$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPendingLoadEarlier$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPendingLoadEarlier$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getPendingLoadLater$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPendingLoadLater$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPendingLoadLater$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getPerformAck$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPerformAck$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPerformAck$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getTempMessages$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTempMessages$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTempMessages$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void getUpdateMsgIds$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUpdateMsgIds$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUpdateMsgIds$annotations(FetchMessagesData.Companion companion) {
    }

    public static /* synthetic */ void loadingEarlierNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void loadingLaterNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void markFailedMessageNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void messagesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pendingLoadEarlierNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pendingLoadLaterNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void performAckNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void tempMessagesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void updateMsgIdsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<FetchMessagesData, FetchMessagesData> getLens(FetchMessagesData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, FetchMessagesData>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$1
            public FetchMessagesData get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it;
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, FetchMessagesData fetchMessagesData2) {
                FetchMessagesData it = fetchMessagesData2;
                return it;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super FetchMessagesData, ? extends FetchMessagesData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                return (FetchMessagesData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Boolean> getDatabaseReady(FetchMessagesData.Companion $this$databaseReady) {
        Intrinsics.checkNotNullParameter($this$databaseReady, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Boolean>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$2
            public Boolean get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return Boolean.valueOf(it.getDatabaseReady());
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Boolean bool) {
                FetchMessagesData copy;
                boolean databaseReady = bool.booleanValue();
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : databaseReady, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Boolean, ? extends Boolean> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                boolean databaseReady = ((Boolean) function1.invoke(Boolean.valueOf(it.getDatabaseReady()))).booleanValue();
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : databaseReady, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Boolean> getLoadingLater(FetchMessagesData.Companion $this$loadingLater) {
        Intrinsics.checkNotNullParameter($this$loadingLater, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Boolean>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$3
            public Boolean get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return Boolean.valueOf(it.getLoadingLater());
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Boolean bool) {
                FetchMessagesData copy;
                boolean loadingLater = bool.booleanValue();
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : loadingLater, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Boolean, ? extends Boolean> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                boolean loadingLater = ((Boolean) function1.invoke(Boolean.valueOf(it.getLoadingLater()))).booleanValue();
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : loadingLater, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Boolean> getPendingLoadLater(FetchMessagesData.Companion $this$pendingLoadLater) {
        Intrinsics.checkNotNullParameter($this$pendingLoadLater, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Boolean>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$4
            public Boolean get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return Boolean.valueOf(it.getPendingLoadLater());
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Boolean bool) {
                FetchMessagesData copy;
                boolean pendingLoadLater = bool.booleanValue();
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : pendingLoadLater, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Boolean, ? extends Boolean> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                boolean pendingLoadLater = ((Boolean) function1.invoke(Boolean.valueOf(it.getPendingLoadLater()))).booleanValue();
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : pendingLoadLater, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Boolean> getLoadingEarlier(FetchMessagesData.Companion $this$loadingEarlier) {
        Intrinsics.checkNotNullParameter($this$loadingEarlier, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Boolean>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$5
            public Boolean get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return Boolean.valueOf(it.getLoadingEarlier());
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Boolean bool) {
                FetchMessagesData copy;
                boolean loadingEarlier = bool.booleanValue();
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : loadingEarlier, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Boolean, ? extends Boolean> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                boolean loadingEarlier = ((Boolean) function1.invoke(Boolean.valueOf(it.getLoadingEarlier()))).booleanValue();
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : loadingEarlier, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Boolean> getPendingLoadEarlier(FetchMessagesData.Companion $this$pendingLoadEarlier) {
        Intrinsics.checkNotNullParameter($this$pendingLoadEarlier, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Boolean>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$6
            public Boolean get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return Boolean.valueOf(it.getPendingLoadEarlier());
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Boolean bool) {
                FetchMessagesData copy;
                boolean pendingLoadEarlier = bool.booleanValue();
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : pendingLoadEarlier, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Boolean, ? extends Boolean> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                boolean pendingLoadEarlier = ((Boolean) function1.invoke(Boolean.valueOf(it.getPendingLoadEarlier()))).booleanValue();
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : pendingLoadEarlier, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, LongRange> getCurrentRange(FetchMessagesData.Companion $this$currentRange) {
        Intrinsics.checkNotNullParameter($this$currentRange, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, LongRange>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$7
            public LongRange get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getCurrentRange();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, LongRange longRange) {
                FetchMessagesData copy;
                LongRange currentRange = longRange;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : currentRange, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super LongRange, ? extends LongRange> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                LongRange currentRange = (LongRange) function1.invoke(it.getCurrentRange());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : currentRange, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Messages> getMessages(FetchMessagesData.Companion $this$messages) {
        Intrinsics.checkNotNullParameter($this$messages, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Messages>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$8
            public Messages get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getMessages();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Messages messages) {
                FetchMessagesData copy;
                Messages messages2 = messages;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : messages2, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Messages, ? extends Messages> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                Messages messages = (Messages) function1.invoke(it.getMessages());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : messages, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Instant> getBaselineTime(FetchMessagesData.Companion $this$baselineTime) {
        Intrinsics.checkNotNullParameter($this$baselineTime, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Instant>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$9
            public Instant get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getBaselineTime();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Instant instant) {
                FetchMessagesData copy;
                Instant baselineTime = instant;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : baselineTime, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Instant, ? extends Instant> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                Instant baselineTime = (Instant) function1.invoke(it.getBaselineTime());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : baselineTime, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<FetchMessagesData, List<EntityMessage>> getTempMessages(FetchMessagesData.Companion $this$tempMessages) {
        Intrinsics.checkNotNullParameter($this$tempMessages, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, List<? extends EntityMessage>>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$10
            public List<? extends EntityMessage> get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getTempMessages();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, List<? extends EntityMessage> list) {
                FetchMessagesData copy;
                List<? extends EntityMessage> tempMessages = list;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : tempMessages, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super List<? extends EntityMessage>, ? extends List<? extends EntityMessage>> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                List tempMessages = (List) function1.invoke(it.getTempMessages());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : tempMessages, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<FetchMessagesData, List<MessageId>> getUpdateMsgIds(FetchMessagesData.Companion $this$updateMsgIds) {
        Intrinsics.checkNotNullParameter($this$updateMsgIds, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, List<? extends MessageId>>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$11
            public List<? extends MessageId> get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getUpdateMsgIds();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, List<? extends MessageId> list) {
                FetchMessagesData copy;
                List<? extends MessageId> updateMsgIds = list;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : updateMsgIds, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super List<? extends MessageId>, ? extends List<? extends MessageId>> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                List updateMsgIds = (List) function1.invoke(it.getUpdateMsgIds());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : updateMsgIds, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<FetchMessagesData, List<EntityMessage>> getMarkFailedMessage(FetchMessagesData.Companion $this$markFailedMessage) {
        Intrinsics.checkNotNullParameter($this$markFailedMessage, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, List<? extends EntityMessage>>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$12
            public List<? extends EntityMessage> get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getMarkFailedMessage();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, List<? extends EntityMessage> list) {
                FetchMessagesData copy;
                List<? extends EntityMessage> markFailedMessage = list;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : markFailedMessage, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super List<? extends EntityMessage>, ? extends List<? extends EntityMessage>> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                List markFailedMessage = (List) function1.invoke(it.getMarkFailedMessage());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : markFailedMessage, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Boolean> getPerformAck(FetchMessagesData.Companion $this$performAck) {
        Intrinsics.checkNotNullParameter($this$performAck, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Boolean>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$13
            public Boolean get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return Boolean.valueOf(it.getPerformAck());
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Boolean bool) {
                FetchMessagesData copy;
                boolean performAck = bool.booleanValue();
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : performAck, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Boolean, ? extends Boolean> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                boolean performAck = ((Boolean) function1.invoke(Boolean.valueOf(it.getPerformAck()))).booleanValue();
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : performAck, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Throwable> getError(FetchMessagesData.Companion $this$error) {
        Intrinsics.checkNotNullParameter($this$error, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Throwable>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$14
            public Throwable get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getError();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Throwable th) {
                FetchMessagesData copy;
                Throwable error = th;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : error, (r30 & 8192) != 0 ? it.errorTime : null);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Throwable, ? extends Throwable> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                Throwable error = (Throwable) function1.invoke(it.getError());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : error, (r30 & 8192) != 0 ? it2.errorTime : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<FetchMessagesData, Instant> getErrorTime(FetchMessagesData.Companion $this$errorTime) {
        Intrinsics.checkNotNullParameter($this$errorTime, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<FetchMessagesData, Instant>() { // from class: kntr.app.im.chat.core.model.FetchMessagesDataLensKt$special$$inlined$invoke$15
            public Instant get(FetchMessagesData fetchMessagesData) {
                FetchMessagesData it = fetchMessagesData;
                return it.getErrorTime();
            }

            public FetchMessagesData set(FetchMessagesData fetchMessagesData, Instant instant) {
                FetchMessagesData copy;
                Instant errorTime = instant;
                FetchMessagesData it = fetchMessagesData;
                copy = it.copy((r30 & 1) != 0 ? it.databaseReady : false, (r30 & 2) != 0 ? it.loadingLater : false, (r30 & 4) != 0 ? it.pendingLoadLater : false, (r30 & 8) != 0 ? it.loadingEarlier : false, (r30 & 16) != 0 ? it.pendingLoadEarlier : false, (r30 & 32) != 0 ? it.currentRange : null, (r30 & 64) != 0 ? it.messages : null, (r30 & 128) != 0 ? it.baselineTime : null, (r30 & 256) != 0 ? it.tempMessages : null, (r30 & 512) != 0 ? it.updateMsgIds : null, (r30 & 1024) != 0 ? it.markFailedMessage : null, (r30 & 2048) != 0 ? it.performAck : false, (r30 & 4096) != 0 ? it.error : null, (r30 & 8192) != 0 ? it.errorTime : errorTime);
                return copy;
            }

            public FetchMessagesData modify(FetchMessagesData fetchMessagesData, Function1<? super Instant, ? extends Instant> function1) {
                FetchMessagesData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                FetchMessagesData it = fetchMessagesData;
                Instant errorTime = (Instant) function1.invoke(it.getErrorTime());
                FetchMessagesData it2 = fetchMessagesData;
                copy = it2.copy((r30 & 1) != 0 ? it2.databaseReady : false, (r30 & 2) != 0 ? it2.loadingLater : false, (r30 & 4) != 0 ? it2.pendingLoadLater : false, (r30 & 8) != 0 ? it2.loadingEarlier : false, (r30 & 16) != 0 ? it2.pendingLoadEarlier : false, (r30 & 32) != 0 ? it2.currentRange : null, (r30 & 64) != 0 ? it2.messages : null, (r30 & 128) != 0 ? it2.baselineTime : null, (r30 & 256) != 0 ? it2.tempMessages : null, (r30 & 512) != 0 ? it2.updateMsgIds : null, (r30 & 1024) != 0 ? it2.markFailedMessage : null, (r30 & 2048) != 0 ? it2.performAck : false, (r30 & 4096) != 0 ? it2.error : null, (r30 & 8192) != 0 ? it2.errorTime : errorTime);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, Boolean> getDatabaseReady(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getDatabaseReady(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getLoadingLater(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLoadingLater(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getPendingLoadLater(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPendingLoadLater(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getLoadingEarlier(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLoadingEarlier(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getPendingLoadEarlier(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPendingLoadEarlier(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, LongRange> getCurrentRange(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getCurrentRange(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Messages> getMessages(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMessages(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getBaselineTime(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getBaselineTime(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, List<EntityMessage>> getTempMessages(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTempMessages(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, List<MessageId>> getUpdateMsgIds(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUpdateMsgIds(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, List<EntityMessage>> getMarkFailedMessage(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMarkFailedMessage(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getPerformAck(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPerformAck(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getError(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getError(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getErrorTime(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getErrorTime(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> databaseReadyNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getDatabaseReady(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> loadingLaterNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLoadingLater(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> pendingLoadLaterNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPendingLoadLater(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> loadingEarlierNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLoadingEarlier(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> pendingLoadEarlierNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPendingLoadEarlier(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, LongRange> currentRangeNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getCurrentRange(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Messages> messagesNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMessages(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Instant> baselineTimeNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getBaselineTime(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> tempMessagesNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTempMessages(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, List<MessageId>> updateMsgIdsNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUpdateMsgIds(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> markFailedMessageNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMarkFailedMessage(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> performAckNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPerformAck(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> errorNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getError(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> errorTimeNullable(BSimpleLens<T, FetchMessagesData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getErrorTime(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getDatabaseReady(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getDatabaseReady(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getLoadingLater(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLoadingLater(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getPendingLoadLater(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPendingLoadLater(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getLoadingEarlier(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLoadingEarlier(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getPendingLoadEarlier(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPendingLoadEarlier(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, LongRange> getCurrentRange(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getCurrentRange(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Messages> getMessages(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMessages(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getBaselineTime(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getBaselineTime(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> getTempMessages(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTempMessages(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, List<MessageId>> getUpdateMsgIds(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUpdateMsgIds(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, List<EntityMessage>> getMarkFailedMessage(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMarkFailedMessage(FetchMessagesData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getPerformAck(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPerformAck(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getError(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getError(FetchMessagesData.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getErrorTime(BNullableLens<T, FetchMessagesData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getErrorTime(FetchMessagesData.Companion));
    }
}