package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KCommonMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.SocialConstants;
import im.direct.notification.interactive.INMessageCard;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.GrpcUtil;
import io.ktor.client.utils.CIOKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INMessageCardLens.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\",\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\",\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\",\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\",\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\",\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007\"0\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\"*\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0005\u001a\u0004\b-\u0010\u0007\"*\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0005\u001a\u0004\b0\u0010\u0007\"*\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0005\u001a\u0004\b2\u0010\u0007\"*\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\u0007\"*\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010\u0007\"*\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010\u0007\"*\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010\u0007\"*\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0005\u001a\u0004\bA\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010E\u001a\u0004\b\u000b\u0010F\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010E\u001a\u0004\b\u000f\u0010F\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010E\u001a\u0004\b\u0013\u0010F\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010E\u001a\u0004\b\u0017\u0010F\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010E\u001a\u0004\b\u001b\u0010F\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010E\u001a\u0004\b\u001f\u0010F\"B\u0010 \u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010E\u001a\u0004\b#\u0010F\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010E\u001a\u0004\b'\u0010F\"F\u0010(\u001a\u0014\u0012\u0004\u0012\u0002HC\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010E\u001a\u0004\b,\u0010F\"@\u0010-\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010E\u001a\u0004\b-\u0010F\"@\u00100\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010E\u001a\u0004\b0\u0010F\"@\u00102\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010E\u001a\u0004\b2\u0010F\"@\u00104\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010E\u001a\u0004\b6\u0010F\"@\u00107\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010E\u001a\u0004\b9\u0010F\"@\u0010:\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020;0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b<\u0010E\u001a\u0004\b=\u0010F\"@\u0010>\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010E\u001a\u0004\b@\u0010F\"@\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010E\u001a\u0004\bA\u0010F\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\t0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010E\u001a\u0004\bI\u0010J\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bK\u0010E\u001a\u0004\bL\u0010F\"D\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010E\u001a\u0004\bN\u0010F\"D\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u0010E\u001a\u0004\bP\u0010F\"B\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00190G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010E\u001a\u0004\bR\u0010J\"D\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u0010E\u001a\u0004\bT\u0010F\"D\u0010 \u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bU\u0010E\u001a\u0004\bV\u0010F\"D\u0010$\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bW\u0010E\u001a\u0004\bX\u0010F\"H\u0010(\u001a\u0014\u0012\u0004\u0012\u0002HC\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bY\u0010E\u001a\u0004\bZ\u0010J\"B\u0010-\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010E\u001a\u0004\b\\\u0010J\"B\u00100\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b]\u0010E\u001a\u0004\b^\u0010J\"B\u00102\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010E\u001a\u0004\b`\u0010J\"B\u00104\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010E\u001a\u0004\bb\u0010J\"B\u00107\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bc\u0010E\u001a\u0004\bd\u0010J\"B\u0010:\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020;0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\be\u0010E\u001a\u0004\bf\u0010J\"B\u0010>\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00190G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bg\u0010E\u001a\u0004\bh\u0010J\"B\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bi\u0010E\u001a\u0004\bj\u0010J\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\t0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010k\u001a\u0004\b\u000b\u0010l\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010k\u001a\u0004\b\u000f\u0010m\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010k\u001a\u0004\b\u0013\u0010m\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010k\u001a\u0004\b\u0017\u0010m\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00190G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010k\u001a\u0004\b\u001b\u0010l\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010k\u001a\u0004\b\u001f\u0010m\"B\u0010 \u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010k\u001a\u0004\b#\u0010m\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002HC\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010k\u001a\u0004\b'\u0010m\"F\u0010(\u001a\u0014\u0012\u0004\u0012\u0002HC\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010k\u001a\u0004\b,\u0010l\"@\u0010-\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010k\u001a\u0004\b-\u0010l\"@\u00100\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010k\u001a\u0004\b0\u0010l\"@\u00102\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010k\u001a\u0004\b2\u0010l\"@\u00104\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010k\u001a\u0004\b6\u0010l\"@\u00107\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010k\u001a\u0004\b9\u0010l\"@\u0010:\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020;0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8@X\u0081\u0004¢\u0006\f\u0012\u0004\b<\u0010k\u001a\u0004\b=\u0010l\"@\u0010>\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00190G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010k\u001a\u0004\b@\u0010l\"@\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020.0G\"\b\b\u0000\u0010C*\u00020D*\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u00020G8FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010k\u001a\u0004\bA\u0010l¨\u0006n"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/direct/notification/interactive/INMessageCard;", "Lim/direct/notification/interactive/INMessageCard$Companion;", "getLens$annotations", "(Lim/direct/notification/interactive/INMessageCard$Companion;)V", "getLens", "(Lim/direct/notification/interactive/INMessageCard$Companion;)Lcom/bilibili/blens/BSimpleLens;", "message", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedMsgCard;", "getMessage$annotations", "getMessage", "type", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgItem$IMsgCard;", "getType$annotations", "getType", "common", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCommonMsgCard;", "getCommon$annotations", "getCommon", "richTextContentByteArray", "", "getRichTextContentByteArray$annotations", "getRichTextContentByteArray", SocialConstants.PARAM_COMMENT, "", "getDescription$annotations", "getDescription", "commentCtrl", "Lim/direct/notification/interactive/CommentCtrl;", "getCommentCtrl$annotations", "getCommentCtrl", "likeCtrl", "Lim/direct/notification/interactive/LikeCtrl;", "getLikeCtrl$annotations", "getLikeCtrl", "thankCtrl", "Lim/direct/notification/interactive/ThankCtrl;", "getThankCtrl$annotations", "getThankCtrl", "minorOperations", "", "Lim/direct/notification/interactive/INMinorOperation;", "getMinorOperations$annotations", "getMinorOperations", "isMuted", "", "isMuted$annotations", "isPinned", "isPinned$annotations", "isUnread", "isUnread$annotations", "hasTopSeparator", "getHasTopSeparator$annotations", "getHasTopSeparator", "hasUnreadMark", "getHasUnreadMark$annotations", "getHasUnreadMark", "sourceID", "", "getSourceID$annotations", "getSourceID", "messageTips", "getMessageTips$annotations", "getMessageTips", "isNeedTeach", "isNeedTeach$annotations", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "messageNullable$annotations", "messageNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "typeNullable$annotations", "typeNullable", "commonNullable$annotations", "commonNullable", "richTextContentByteArrayNullable$annotations", "richTextContentByteArrayNullable", "descriptionNullable$annotations", "descriptionNullable", "commentCtrlNullable$annotations", "commentCtrlNullable", "likeCtrlNullable$annotations", "likeCtrlNullable", "thankCtrlNullable$annotations", "thankCtrlNullable", "minorOperationsNullable$annotations", "minorOperationsNullable", "isMutedNullable$annotations", "isMutedNullable", "isPinnedNullable$annotations", "isPinnedNullable", "isUnreadNullable$annotations", "isUnreadNullable", "hasTopSeparatorNullable$annotations", "hasTopSeparatorNullable", "hasUnreadMarkNullable$annotations", "hasUnreadMarkNullable", "sourceIDNullable$annotations", "sourceIDNullable", "messageTipsNullable$annotations", "messageTipsNullable", "isNeedTeachNullable$annotations", "isNeedTeachNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "interactive_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class INMessageCardLensKt {
    public static /* synthetic */ void commentCtrlNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void commonNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void descriptionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCommentCtrl$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCommentCtrl$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCommentCtrl$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getCommon$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCommon$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCommon$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getDescription$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDescription$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDescription$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getHasTopSeparator$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHasTopSeparator$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHasTopSeparator$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getHasUnreadMark$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHasUnreadMark$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHasUnreadMark$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getLikeCtrl$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLikeCtrl$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLikeCtrl$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getMessage$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMessage$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMessage$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getMessageTips$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMessageTips$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMessageTips$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getMinorOperations$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMinorOperations$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMinorOperations$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getRichTextContentByteArray$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRichTextContentByteArray$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRichTextContentByteArray$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getSourceID$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSourceID$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSourceID$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getThankCtrl$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getThankCtrl$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getThankCtrl$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void getType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getType$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void hasTopSeparatorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void hasUnreadMarkNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isMuted$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isMuted$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isMuted$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void isMutedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isNeedTeach$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isNeedTeach$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isNeedTeach$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void isNeedTeachNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isPinned$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isPinned$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isPinned$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void isPinnedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isUnread$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isUnread$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isUnread$annotations(INMessageCard.Companion companion) {
    }

    public static /* synthetic */ void isUnreadNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void likeCtrlNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void messageNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void messageTipsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void minorOperationsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void richTextContentByteArrayNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sourceIDNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void thankCtrlNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void typeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<INMessageCard, INMessageCard> getLens(INMessageCard.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, INMessageCard>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$1
            public INMessageCard get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it;
            }

            public INMessageCard set(INMessageCard iNMessageCard, INMessageCard iNMessageCard2) {
                INMessageCard it = iNMessageCard2;
                return it;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super INMessageCard, ? extends INMessageCard> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                return (INMessageCard) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<INMessageCard, KMsgFeedMsgCard> getMessage(INMessageCard.Companion $this$message) {
        Intrinsics.checkNotNullParameter($this$message, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, KMsgFeedMsgCard>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$2
            public KMsgFeedMsgCard get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getMessage();
            }

            public INMessageCard set(INMessageCard iNMessageCard, KMsgFeedMsgCard kMsgFeedMsgCard) {
                INMessageCard copy;
                KMsgFeedMsgCard message = kMsgFeedMsgCard;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : message, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super KMsgFeedMsgCard, ? extends KMsgFeedMsgCard> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                KMsgFeedMsgCard message = (KMsgFeedMsgCard) function1.invoke(it.getMessage());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : message, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, KMsgItem.IMsgCard> getType(INMessageCard.Companion $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, KMsgItem.IMsgCard>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$3
            public KMsgItem.IMsgCard get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getType();
            }

            public INMessageCard set(INMessageCard iNMessageCard, KMsgItem.IMsgCard iMsgCard) {
                INMessageCard copy;
                KMsgItem.IMsgCard type = iMsgCard;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : type, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super KMsgItem.IMsgCard, ? extends KMsgItem.IMsgCard> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                KMsgItem.IMsgCard type = (KMsgItem.IMsgCard) function1.invoke(it.getType());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : type, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, KCommonMsgCard> getCommon(INMessageCard.Companion $this$common) {
        Intrinsics.checkNotNullParameter($this$common, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, KCommonMsgCard>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$4
            public KCommonMsgCard get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getCommon();
            }

            public INMessageCard set(INMessageCard iNMessageCard, KCommonMsgCard kCommonMsgCard) {
                INMessageCard copy;
                KCommonMsgCard common2 = kCommonMsgCard;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : common2, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super KCommonMsgCard, ? extends KCommonMsgCard> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                KCommonMsgCard common2 = (KCommonMsgCard) function1.invoke(it.getCommon());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : common2, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, byte[]> getRichTextContentByteArray(INMessageCard.Companion $this$richTextContentByteArray) {
        Intrinsics.checkNotNullParameter($this$richTextContentByteArray, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, byte[]>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$5
            public byte[] get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getRichTextContentByteArray();
            }

            public INMessageCard set(INMessageCard iNMessageCard, byte[] bArr) {
                INMessageCard copy;
                byte[] richTextContentByteArray = bArr;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : richTextContentByteArray, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super byte[], ? extends byte[]> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                byte[] richTextContentByteArray = (byte[]) function1.invoke(it.getRichTextContentByteArray());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : richTextContentByteArray, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, String> getDescription(INMessageCard.Companion $this$description) {
        Intrinsics.checkNotNullParameter($this$description, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, String>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$6
            public String get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getDescription();
            }

            public INMessageCard set(INMessageCard iNMessageCard, String str) {
                INMessageCard copy;
                String description = str;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : description, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super String, ? extends String> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                String description = (String) function1.invoke(it.getDescription());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : description, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, CommentCtrl> getCommentCtrl(INMessageCard.Companion $this$commentCtrl) {
        Intrinsics.checkNotNullParameter($this$commentCtrl, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, CommentCtrl>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$7
            public CommentCtrl get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getCommentCtrl();
            }

            public INMessageCard set(INMessageCard iNMessageCard, CommentCtrl commentCtrl) {
                INMessageCard copy;
                CommentCtrl commentCtrl2 = commentCtrl;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : commentCtrl2, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super CommentCtrl, ? extends CommentCtrl> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                CommentCtrl commentCtrl = (CommentCtrl) function1.invoke(it.getCommentCtrl());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : commentCtrl, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, LikeCtrl> getLikeCtrl(INMessageCard.Companion $this$likeCtrl) {
        Intrinsics.checkNotNullParameter($this$likeCtrl, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, LikeCtrl>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$8
            public LikeCtrl get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getLikeCtrl();
            }

            public INMessageCard set(INMessageCard iNMessageCard, LikeCtrl likeCtrl) {
                INMessageCard copy;
                LikeCtrl likeCtrl2 = likeCtrl;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : likeCtrl2, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super LikeCtrl, ? extends LikeCtrl> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                LikeCtrl likeCtrl = (LikeCtrl) function1.invoke(it.getLikeCtrl());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : likeCtrl, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, ThankCtrl> getThankCtrl(INMessageCard.Companion $this$thankCtrl) {
        Intrinsics.checkNotNullParameter($this$thankCtrl, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, ThankCtrl>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$9
            public ThankCtrl get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getThankCtrl();
            }

            public INMessageCard set(INMessageCard iNMessageCard, ThankCtrl thankCtrl) {
                INMessageCard copy;
                ThankCtrl thankCtrl2 = thankCtrl;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : thankCtrl2, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super ThankCtrl, ? extends ThankCtrl> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                ThankCtrl thankCtrl = (ThankCtrl) function1.invoke(it.getThankCtrl());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : thankCtrl, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<INMessageCard, List<INMinorOperation>> getMinorOperations(INMessageCard.Companion $this$minorOperations) {
        Intrinsics.checkNotNullParameter($this$minorOperations, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, List<? extends INMinorOperation>>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$10
            public List<? extends INMinorOperation> get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getMinorOperations();
            }

            public INMessageCard set(INMessageCard iNMessageCard, List<? extends INMinorOperation> list) {
                INMessageCard copy;
                List<? extends INMinorOperation> minorOperations = list;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : minorOperations, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super List<? extends INMinorOperation>, ? extends List<? extends INMinorOperation>> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                List minorOperations = (List) function1.invoke(it.getMinorOperations());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : minorOperations, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, Boolean> isMuted(INMessageCard.Companion $this$isMuted) {
        Intrinsics.checkNotNullParameter($this$isMuted, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, Boolean>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$11
            public Boolean get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return Boolean.valueOf(it.isMuted());
            }

            public INMessageCard set(INMessageCard iNMessageCard, Boolean bool) {
                INMessageCard copy;
                boolean isMuted = bool.booleanValue();
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : isMuted, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super Boolean, ? extends Boolean> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                boolean isMuted = ((Boolean) function1.invoke(Boolean.valueOf(it.isMuted()))).booleanValue();
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : isMuted, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, Boolean> isPinned(INMessageCard.Companion $this$isPinned) {
        Intrinsics.checkNotNullParameter($this$isPinned, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, Boolean>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$12
            public Boolean get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return Boolean.valueOf(it.isPinned());
            }

            public INMessageCard set(INMessageCard iNMessageCard, Boolean bool) {
                INMessageCard copy;
                boolean isPinned = bool.booleanValue();
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : isPinned, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super Boolean, ? extends Boolean> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                boolean isPinned = ((Boolean) function1.invoke(Boolean.valueOf(it.isPinned()))).booleanValue();
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : isPinned, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, Boolean> isUnread(INMessageCard.Companion $this$isUnread) {
        Intrinsics.checkNotNullParameter($this$isUnread, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, Boolean>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$13
            public Boolean get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return Boolean.valueOf(it.isUnread());
            }

            public INMessageCard set(INMessageCard iNMessageCard, Boolean bool) {
                INMessageCard copy;
                boolean isUnread = bool.booleanValue();
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : isUnread, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super Boolean, ? extends Boolean> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                boolean isUnread = ((Boolean) function1.invoke(Boolean.valueOf(it.isUnread()))).booleanValue();
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : isUnread, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, Boolean> getHasTopSeparator(INMessageCard.Companion $this$hasTopSeparator) {
        Intrinsics.checkNotNullParameter($this$hasTopSeparator, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, Boolean>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$14
            public Boolean get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return Boolean.valueOf(it.getHasTopSeparator());
            }

            public INMessageCard set(INMessageCard iNMessageCard, Boolean bool) {
                INMessageCard copy;
                boolean hasTopSeparator = bool.booleanValue();
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : hasTopSeparator, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super Boolean, ? extends Boolean> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                boolean hasTopSeparator = ((Boolean) function1.invoke(Boolean.valueOf(it.getHasTopSeparator()))).booleanValue();
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : hasTopSeparator, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, Boolean> getHasUnreadMark(INMessageCard.Companion $this$hasUnreadMark) {
        Intrinsics.checkNotNullParameter($this$hasUnreadMark, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, Boolean>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$15
            public Boolean get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return Boolean.valueOf(it.getHasUnreadMark());
            }

            public INMessageCard set(INMessageCard iNMessageCard, Boolean bool) {
                INMessageCard copy;
                boolean hasUnreadMark = bool.booleanValue();
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : hasUnreadMark, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super Boolean, ? extends Boolean> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                boolean hasUnreadMark = ((Boolean) function1.invoke(Boolean.valueOf(it.getHasUnreadMark()))).booleanValue();
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : hasUnreadMark, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, Long> getSourceID(INMessageCard.Companion $this$sourceID) {
        Intrinsics.checkNotNullParameter($this$sourceID, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, Long>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$16
            public Long get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return Long.valueOf(it.getSourceID$interactive_debug());
            }

            public INMessageCard set(INMessageCard iNMessageCard, Long l) {
                INMessageCard copy;
                long sourceID = l.longValue();
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : sourceID, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super Long, ? extends Long> function1) {
                INMessageCard it;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it2 = iNMessageCard;
                long sourceID = ((Number) function1.invoke(Long.valueOf(it2.getSourceID$interactive_debug()))).longValue();
                INMessageCard it3 = iNMessageCard;
                it = it3.copy((r36 & 1) != 0 ? it3.message : null, (r36 & 2) != 0 ? it3.type : null, (r36 & 4) != 0 ? it3.f1973common : null, (r36 & 8) != 0 ? it3.richTextContentByteArray : null, (r36 & 16) != 0 ? it3.description : null, (r36 & 32) != 0 ? it3.commentCtrl : null, (r36 & 64) != 0 ? it3.likeCtrl : null, (r36 & 128) != 0 ? it3.thankCtrl : null, (r36 & 256) != 0 ? it3.minorOperations : null, (r36 & 512) != 0 ? it3.isMuted : false, (r36 & 1024) != 0 ? it3.isPinned : false, (r36 & 2048) != 0 ? it3.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it3.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it3.hasUnreadMark : false, (r36 & 16384) != 0 ? it3.sourceID : sourceID, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it3.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it3.isNeedTeach : false);
                return it;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, String> getMessageTips(INMessageCard.Companion $this$messageTips) {
        Intrinsics.checkNotNullParameter($this$messageTips, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, String>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$17
            public String get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return it.getMessageTips();
            }

            public INMessageCard set(INMessageCard iNMessageCard, String str) {
                INMessageCard copy;
                String messageTips = str;
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : messageTips, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super String, ? extends String> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                String messageTips = (String) function1.invoke(it.getMessageTips());
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : messageTips, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<INMessageCard, Boolean> isNeedTeach(INMessageCard.Companion $this$isNeedTeach) {
        Intrinsics.checkNotNullParameter($this$isNeedTeach, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INMessageCard, Boolean>() { // from class: im.direct.notification.interactive.INMessageCardLensKt$special$$inlined$invoke$18
            public Boolean get(INMessageCard iNMessageCard) {
                INMessageCard it = iNMessageCard;
                return Boolean.valueOf(it.isNeedTeach());
            }

            public INMessageCard set(INMessageCard iNMessageCard, Boolean bool) {
                INMessageCard copy;
                boolean isNeedTeach = bool.booleanValue();
                INMessageCard it = iNMessageCard;
                copy = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : false, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : isNeedTeach);
                return copy;
            }

            public INMessageCard modify(INMessageCard iNMessageCard, Function1<? super Boolean, ? extends Boolean> function1) {
                INMessageCard copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                INMessageCard it = iNMessageCard;
                boolean isNeedTeach = ((Boolean) function1.invoke(Boolean.valueOf(it.isNeedTeach()))).booleanValue();
                INMessageCard it2 = iNMessageCard;
                copy = it2.copy((r36 & 1) != 0 ? it2.message : null, (r36 & 2) != 0 ? it2.type : null, (r36 & 4) != 0 ? it2.f1973common : null, (r36 & 8) != 0 ? it2.richTextContentByteArray : null, (r36 & 16) != 0 ? it2.description : null, (r36 & 32) != 0 ? it2.commentCtrl : null, (r36 & 64) != 0 ? it2.likeCtrl : null, (r36 & 128) != 0 ? it2.thankCtrl : null, (r36 & 256) != 0 ? it2.minorOperations : null, (r36 & 512) != 0 ? it2.isMuted : false, (r36 & 1024) != 0 ? it2.isPinned : false, (r36 & 2048) != 0 ? it2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it2.hasUnreadMark : false, (r36 & 16384) != 0 ? it2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it2.isNeedTeach : isNeedTeach);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, KMsgFeedMsgCard> getMessage(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMessage(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, KMsgItem.IMsgCard> getType(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getType(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, KCommonMsgCard> getCommon(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getCommon(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, byte[]> getRichTextContentByteArray(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getRichTextContentByteArray(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, String> getDescription(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getDescription(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, CommentCtrl> getCommentCtrl(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getCommentCtrl(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, LikeCtrl> getLikeCtrl(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getLikeCtrl(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, ThankCtrl> getThankCtrl(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getThankCtrl(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, List<INMinorOperation>> getMinorOperations(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMinorOperations(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isMuted(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isMuted(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isPinned(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isPinned(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isUnread(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isUnread(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getHasTopSeparator(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getHasTopSeparator(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getHasUnreadMark(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getHasUnreadMark(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, Long> getSourceID(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSourceID(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, String> getMessageTips(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMessageTips(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isNeedTeach(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isNeedTeach(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, KMsgFeedMsgCard> messageNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMessage(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, KMsgItem.IMsgCard> typeNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getType(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, KCommonMsgCard> commonNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getCommon(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, byte[]> richTextContentByteArrayNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getRichTextContentByteArray(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, String> descriptionNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getDescription(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, CommentCtrl> commentCtrlNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getCommentCtrl(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, LikeCtrl> likeCtrlNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getLikeCtrl(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, ThankCtrl> thankCtrlNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getThankCtrl(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, List<INMinorOperation>> minorOperationsNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMinorOperations(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isMutedNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isMuted(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isPinnedNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isPinned(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isUnreadNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isUnread(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> hasTopSeparatorNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getHasTopSeparator(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> hasUnreadMarkNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getHasUnreadMark(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Long> sourceIDNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSourceID(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, String> messageTipsNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMessageTips(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isNeedTeachNullable(BSimpleLens<T, INMessageCard> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isNeedTeach(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, KMsgFeedMsgCard> getMessage(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMessage(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, KMsgItem.IMsgCard> getType(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getType(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, KCommonMsgCard> getCommon(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getCommon(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, byte[]> getRichTextContentByteArray(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getRichTextContentByteArray(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, String> getDescription(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getDescription(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, CommentCtrl> getCommentCtrl(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getCommentCtrl(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, LikeCtrl> getLikeCtrl(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getLikeCtrl(INMessageCard.Companion));
    }

    public static final <T> BSimpleLens<T, ThankCtrl> getThankCtrl(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getThankCtrl(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, List<INMinorOperation>> getMinorOperations(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMinorOperations(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isMuted(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isMuted(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isPinned(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isPinned(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isUnread(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isUnread(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getHasTopSeparator(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getHasTopSeparator(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getHasUnreadMark(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getHasUnreadMark(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Long> getSourceID(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSourceID(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, String> getMessageTips(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMessageTips(INMessageCard.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isNeedTeach(BNullableLens<T, INMessageCard> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isNeedTeach(INMessageCard.Companion));
    }
}