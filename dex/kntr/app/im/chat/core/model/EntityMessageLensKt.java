package kntr.app.im.chat.core.model;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.Map;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: EntityMessageLens.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\",\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b \u0010\u0007\"*\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"*\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007\"*\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\"*\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0005\u001a\u0004\b-\u0010\u0007\"*\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0005\u001a\u0004\b/\u0010\u0007\"6\u00101\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00107\u001a\u0004\b\u000b\u00108\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00107\u001a\u0004\b\u000f\u00108\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u00107\u001a\u0004\b\u0013\u00108\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u00107\u001a\u0004\b\u0017\u00108\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u00107\u001a\u0004\b\u001b\u00108\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u00107\u001a\u0004\b\u001f\u00108\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u00107\u001a\u0004\b \u00108\"@\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020$0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u00107\u001a\u0004\b&\u00108\"@\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u00107\u001a\u0004\b)\u00108\"@\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u00107\u001a\u0004\b,\u00108\"@\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u00107\u001a\u0004\b-\u00108\"@\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u00107\u001a\u0004\b/\u00108\"L\u00101\u001a\u001a\u0012\u0004\u0012\u0002H5\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d020\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u00107\u001a\u0004\b4\u00108\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\t09\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u00107\u001a\u0004\b;\u0010<\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\r09\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u00107\u001a\u0004\b>\u0010<\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001109\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u00107\u001a\u0004\b@\u0010<\"B\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001509\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u00107\u001a\u0004\bB\u0010<\"B\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001909\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u00107\u001a\u0004\bD\u0010<\"D\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u00107\u001a\u0004\bF\u00108\"B\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!09\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u00107\u001a\u0004\bH\u0010<\"B\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020$09\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bI\u00107\u001a\u0004\bJ\u0010<\"B\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001909\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bK\u00107\u001a\u0004\bL\u0010<\"B\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001909\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u00107\u001a\u0004\bN\u0010<\"B\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!09\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u00107\u001a\u0004\bP\u0010<\"B\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!09\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u00107\u001a\u0004\bR\u0010<\"N\u00101\u001a\u001a\u0012\u0004\u0012\u0002H5\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0209\"\b\b\u0000\u00105*\u000206*\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u00107\u001a\u0004\bT\u0010<\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\t09\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010U\u001a\u0004\b\u000b\u0010V\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\r09\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010U\u001a\u0004\b\u000f\u0010V\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001109\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010U\u001a\u0004\b\u0013\u0010V\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001509\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010U\u001a\u0004\b\u0017\u0010V\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001909\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010U\u001a\u0004\b\u001b\u0010V\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010U\u001a\u0004\b\u001f\u0010W\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!09\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010U\u001a\u0004\b \u0010V\"@\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020$09\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010U\u001a\u0004\b&\u0010V\"@\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001909\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010U\u001a\u0004\b)\u0010V\"@\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u001909\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010U\u001a\u0004\b,\u0010V\"@\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!09\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010U\u001a\u0004\b-\u0010V\"@\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020!09\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010U\u001a\u0004\b/\u0010V\"L\u00101\u001a\u001a\u0012\u0004\u0012\u0002H5\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0209\"\b\b\u0000\u00105*\u000206*\u000e\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u00020\u0002098FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010U\u001a\u0004\b4\u0010V¨\u0006X"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/EntityMessage;", "Lkntr/app/im/chat/core/model/EntityMessage$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/EntityMessage$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/EntityMessage$Companion;)Lcom/bilibili/blens/BSimpleLens;", "entityKey", RoomRecommendViewModel.EMPTY_CURSOR, "getEntityKey$annotations", "getEntityKey", "msgId", "Lkntr/app/im/chat/core/model/MessageId;", "getMsgId$annotations", "getMsgId", "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "getMsgType$annotations", "getMsgType", "msgFrame", "Lkntr/app/im/chat/core/model/MsgFrame;", "getMsgFrame$annotations", "getMsgFrame", "timestamp", "Lkotlinx/datetime/Instant;", "getTimestamp$annotations", "getTimestamp", "token", RoomRecommendViewModel.EMPTY_CURSOR, "getToken$annotations", "getToken", "isHidden", RoomRecommendViewModel.EMPTY_CURSOR, "isHidden$annotations", "sendStatus", "Lkntr/app/im/chat/core/model/SendStatus;", "getSendStatus$annotations", "getSendStatus", "createTime", "getCreateTime$annotations", "getCreateTime", "updateTime", "getUpdateTime$annotations", "getUpdateTime", "isRealtimeMessage", "isRealtimeMessage$annotations", "isTemporaryMsg", "isTemporaryMsg$annotations", "traceParams", RoomRecommendViewModel.EMPTY_CURSOR, "getTraceParams$annotations", "getTraceParams", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "entityKeyNullable$annotations", "entityKeyNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "msgIdNullable$annotations", "msgIdNullable", "msgTypeNullable$annotations", "msgTypeNullable", "msgFrameNullable$annotations", "msgFrameNullable", "timestampNullable$annotations", "timestampNullable", "tokenNullable$annotations", "tokenNullable", "isHiddenNullable$annotations", "isHiddenNullable", "sendStatusNullable$annotations", "sendStatusNullable", "createTimeNullable$annotations", "createTimeNullable", "updateTimeNullable$annotations", "updateTimeNullable", "isRealtimeMessageNullable$annotations", "isRealtimeMessageNullable", "isTemporaryMsgNullable$annotations", "isTemporaryMsgNullable", "traceParamsNullable$annotations", "traceParamsNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EntityMessageLensKt {
    public static /* synthetic */ void createTimeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void entityKeyNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCreateTime$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCreateTime$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCreateTime$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getEntityKey$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEntityKey$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEntityKey$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getMsgFrame$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMsgFrame$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMsgFrame$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getMsgId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMsgId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMsgId$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getMsgType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMsgType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMsgType$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getSendStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSendStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSendStatus$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getTimestamp$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTimestamp$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTimestamp$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getToken$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToken$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToken$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getTraceParams$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTraceParams$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTraceParams$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void getUpdateTime$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUpdateTime$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUpdateTime$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void isHidden$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isHidden$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isHidden$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void isHiddenNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isRealtimeMessage$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isRealtimeMessage$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isRealtimeMessage$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void isRealtimeMessageNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isTemporaryMsg$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isTemporaryMsg$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isTemporaryMsg$annotations(EntityMessage.Companion companion) {
    }

    public static /* synthetic */ void isTemporaryMsgNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void msgFrameNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void msgIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void msgTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sendStatusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void timestampNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void tokenNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void traceParamsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void updateTimeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<EntityMessage, EntityMessage> getLens(EntityMessage.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, EntityMessage>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$1
            public EntityMessage get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it;
            }

            public EntityMessage set(EntityMessage entityMessage, EntityMessage entityMessage2) {
                EntityMessage it = entityMessage2;
                return it;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super EntityMessage, ? extends EntityMessage> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                return (EntityMessage) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<EntityMessage, Long> getEntityKey(EntityMessage.Companion $this$entityKey) {
        Intrinsics.checkNotNullParameter($this$entityKey, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Long>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$2
            public Long get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return Long.valueOf(it.getEntityKey());
            }

            public EntityMessage set(EntityMessage entityMessage, Long l) {
                EntityMessage copy;
                long entityKey = l.longValue();
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : entityKey, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Long, ? extends Long> function1) {
                EntityMessage it;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it2 = entityMessage;
                long entityKey = ((Number) function1.invoke(Long.valueOf(it2.getEntityKey()))).longValue();
                EntityMessage it3 = entityMessage;
                it = it3.copy((r30 & 1) != 0 ? it3.entityKey : entityKey, (r30 & 2) != 0 ? it3.msgId : null, (r30 & 4) != 0 ? it3.msgType : null, (r30 & 8) != 0 ? it3.msgFrame : null, (r30 & 16) != 0 ? it3.timestamp : null, (r30 & 32) != 0 ? it3.token : null, (r30 & 64) != 0 ? it3.isHidden : false, (r30 & 128) != 0 ? it3.sendStatus : null, (r30 & 256) != 0 ? it3.createTime : null, (r30 & 512) != 0 ? it3.updateTime : null, (r30 & 1024) != 0 ? it3.isRealtimeMessage : false, (r30 & 2048) != 0 ? it3.isTemporaryMsg : false, (r30 & 4096) != 0 ? it3.traceParams : null);
                return it;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, MessageId> getMsgId(EntityMessage.Companion $this$msgId) {
        Intrinsics.checkNotNullParameter($this$msgId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, MessageId>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$3
            public MessageId get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getMsgId();
            }

            public EntityMessage set(EntityMessage entityMessage, MessageId messageId) {
                EntityMessage copy;
                MessageId msgId = messageId;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : msgId, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super MessageId, ? extends MessageId> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                MessageId msgId = (MessageId) function1.invoke(it.getMsgId());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : msgId, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, KEntityMsgType> getMsgType(EntityMessage.Companion $this$msgType) {
        Intrinsics.checkNotNullParameter($this$msgType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, KEntityMsgType>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$4
            public KEntityMsgType get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getMsgType();
            }

            public EntityMessage set(EntityMessage entityMessage, KEntityMsgType kEntityMsgType) {
                EntityMessage copy;
                KEntityMsgType msgType = kEntityMsgType;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : msgType, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super KEntityMsgType, ? extends KEntityMsgType> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                KEntityMsgType msgType = (KEntityMsgType) function1.invoke(it.getMsgType());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : msgType, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, MsgFrame> getMsgFrame(EntityMessage.Companion $this$msgFrame) {
        Intrinsics.checkNotNullParameter($this$msgFrame, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, MsgFrame>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$5
            public MsgFrame get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getMsgFrame();
            }

            public EntityMessage set(EntityMessage entityMessage, MsgFrame msgFrame) {
                EntityMessage copy;
                MsgFrame msgFrame2 = msgFrame;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : msgFrame2, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super MsgFrame, ? extends MsgFrame> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                MsgFrame msgFrame = (MsgFrame) function1.invoke(it.getMsgFrame());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : msgFrame, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, Instant> getTimestamp(EntityMessage.Companion $this$timestamp) {
        Intrinsics.checkNotNullParameter($this$timestamp, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Instant>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$6
            public Instant get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getTimestamp();
            }

            public EntityMessage set(EntityMessage entityMessage, Instant instant) {
                EntityMessage copy;
                Instant timestamp = instant;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : timestamp, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Instant, ? extends Instant> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                Instant timestamp = (Instant) function1.invoke(it.getTimestamp());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : timestamp, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, String> getToken(EntityMessage.Companion $this$token) {
        Intrinsics.checkNotNullParameter($this$token, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, String>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$7
            public String get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getToken();
            }

            public EntityMessage set(EntityMessage entityMessage, String str) {
                EntityMessage copy;
                String token = str;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : token, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super String, ? extends String> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                String token = (String) function1.invoke(it.getToken());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : token, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, Boolean> isHidden(EntityMessage.Companion $this$isHidden) {
        Intrinsics.checkNotNullParameter($this$isHidden, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Boolean>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$8
            public Boolean get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return Boolean.valueOf(it.isHidden());
            }

            public EntityMessage set(EntityMessage entityMessage, Boolean bool) {
                EntityMessage copy;
                boolean isHidden = bool.booleanValue();
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : isHidden, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Boolean, ? extends Boolean> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                boolean isHidden = ((Boolean) function1.invoke(Boolean.valueOf(it.isHidden()))).booleanValue();
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : isHidden, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, SendStatus> getSendStatus(EntityMessage.Companion $this$sendStatus) {
        Intrinsics.checkNotNullParameter($this$sendStatus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, SendStatus>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$9
            public SendStatus get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getSendStatus();
            }

            public EntityMessage set(EntityMessage entityMessage, SendStatus sendStatus) {
                EntityMessage copy;
                SendStatus sendStatus2 = sendStatus;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : sendStatus2, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super SendStatus, ? extends SendStatus> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                SendStatus sendStatus = (SendStatus) function1.invoke(it.getSendStatus());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : sendStatus, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, Instant> getCreateTime(EntityMessage.Companion $this$createTime) {
        Intrinsics.checkNotNullParameter($this$createTime, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Instant>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$10
            public Instant get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getCreateTime();
            }

            public EntityMessage set(EntityMessage entityMessage, Instant instant) {
                EntityMessage copy;
                Instant createTime = instant;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : createTime, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Instant, ? extends Instant> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                Instant createTime = (Instant) function1.invoke(it.getCreateTime());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : createTime, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, Instant> getUpdateTime(EntityMessage.Companion $this$updateTime) {
        Intrinsics.checkNotNullParameter($this$updateTime, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Instant>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$11
            public Instant get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getUpdateTime();
            }

            public EntityMessage set(EntityMessage entityMessage, Instant instant) {
                EntityMessage copy;
                Instant updateTime = instant;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : updateTime, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Instant, ? extends Instant> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                Instant updateTime = (Instant) function1.invoke(it.getUpdateTime());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : updateTime, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, Boolean> isRealtimeMessage(EntityMessage.Companion $this$isRealtimeMessage) {
        Intrinsics.checkNotNullParameter($this$isRealtimeMessage, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Boolean>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$12
            public Boolean get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return Boolean.valueOf(it.isRealtimeMessage());
            }

            public EntityMessage set(EntityMessage entityMessage, Boolean bool) {
                EntityMessage copy;
                boolean isRealtimeMessage = bool.booleanValue();
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : isRealtimeMessage, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Boolean, ? extends Boolean> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                boolean isRealtimeMessage = ((Boolean) function1.invoke(Boolean.valueOf(it.isRealtimeMessage()))).booleanValue();
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : isRealtimeMessage, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<EntityMessage, Boolean> isTemporaryMsg(EntityMessage.Companion $this$isTemporaryMsg) {
        Intrinsics.checkNotNullParameter($this$isTemporaryMsg, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Boolean>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$13
            public Boolean get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return Boolean.valueOf(it.isTemporaryMsg());
            }

            public EntityMessage set(EntityMessage entityMessage, Boolean bool) {
                EntityMessage copy;
                boolean isTemporaryMsg = bool.booleanValue();
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : isTemporaryMsg, (r30 & 4096) != 0 ? it.traceParams : null);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Boolean, ? extends Boolean> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                boolean isTemporaryMsg = ((Boolean) function1.invoke(Boolean.valueOf(it.isTemporaryMsg()))).booleanValue();
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : isTemporaryMsg, (r30 & 4096) != 0 ? it2.traceParams : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<EntityMessage, Map<String, String>> getTraceParams(EntityMessage.Companion $this$traceParams) {
        Intrinsics.checkNotNullParameter($this$traceParams, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<EntityMessage, Map<String, ? extends String>>() { // from class: kntr.app.im.chat.core.model.EntityMessageLensKt$special$$inlined$invoke$14
            public Map<String, ? extends String> get(EntityMessage entityMessage) {
                EntityMessage it = entityMessage;
                return it.getTraceParams();
            }

            public EntityMessage set(EntityMessage entityMessage, Map<String, ? extends String> map) {
                EntityMessage copy;
                Map<String, ? extends String> traceParams = map;
                EntityMessage it = entityMessage;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : null, (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : traceParams);
                return copy;
            }

            public EntityMessage modify(EntityMessage entityMessage, Function1<? super Map<String, ? extends String>, ? extends Map<String, ? extends String>> function1) {
                EntityMessage copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                EntityMessage it = entityMessage;
                Map traceParams = (Map) function1.invoke(it.getTraceParams());
                EntityMessage it2 = entityMessage;
                copy = it2.copy((r30 & 1) != 0 ? it2.entityKey : 0L, (r30 & 2) != 0 ? it2.msgId : null, (r30 & 4) != 0 ? it2.msgType : null, (r30 & 8) != 0 ? it2.msgFrame : null, (r30 & 16) != 0 ? it2.timestamp : null, (r30 & 32) != 0 ? it2.token : null, (r30 & 64) != 0 ? it2.isHidden : false, (r30 & 128) != 0 ? it2.sendStatus : null, (r30 & 256) != 0 ? it2.createTime : null, (r30 & 512) != 0 ? it2.updateTime : null, (r30 & 1024) != 0 ? it2.isRealtimeMessage : false, (r30 & 2048) != 0 ? it2.isTemporaryMsg : false, (r30 & 4096) != 0 ? it2.traceParams : traceParams);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, Long> getEntityKey(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEntityKey(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, MessageId> getMsgId(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMsgId(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, KEntityMsgType> getMsgType(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMsgType(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, MsgFrame> getMsgFrame(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMsgFrame(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getTimestamp(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTimestamp(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, String> getToken(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToken(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isHidden(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isHidden(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, SendStatus> getSendStatus(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSendStatus(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getCreateTime(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCreateTime(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getUpdateTime(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUpdateTime(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isRealtimeMessage(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isRealtimeMessage(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isTemporaryMsg(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isTemporaryMsg(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, Map<String, String>> getTraceParams(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTraceParams(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Long> entityKeyNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEntityKey(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, MessageId> msgIdNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMsgId(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, KEntityMsgType> msgTypeNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMsgType(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, MsgFrame> msgFrameNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMsgFrame(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Instant> timestampNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTimestamp(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, String> tokenNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToken(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isHiddenNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isHidden(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, SendStatus> sendStatusNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSendStatus(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Instant> createTimeNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCreateTime(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Instant> updateTimeNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUpdateTime(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isRealtimeMessageNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isRealtimeMessage(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isTemporaryMsgNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isTemporaryMsg(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Map<String, String>> traceParamsNullable(BSimpleLens<T, EntityMessage> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTraceParams(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Long> getEntityKey(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEntityKey(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, MessageId> getMsgId(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMsgId(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, KEntityMsgType> getMsgType(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMsgType(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, MsgFrame> getMsgFrame(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMsgFrame(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getTimestamp(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTimestamp(EntityMessage.Companion));
    }

    public static final <T> BSimpleLens<T, String> getToken(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToken(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isHidden(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isHidden(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, SendStatus> getSendStatus(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSendStatus(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getCreateTime(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCreateTime(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getUpdateTime(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUpdateTime(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isRealtimeMessage(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isRealtimeMessage(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isTemporaryMsg(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isTemporaryMsg(EntityMessage.Companion));
    }

    public static final <T> BNullableLens<T, Map<String, String>> getTraceParams(BNullableLens<T, EntityMessage> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTraceParams(EntityMessage.Companion));
    }
}