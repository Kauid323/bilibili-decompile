package kntr.app.tribee.publish;

import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.tribee.publish.TribeePublishContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextContent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishContentLens.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"0\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\",\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\"0\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007\"*\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007\"*\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007\"*\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0007\"*\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007\",\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00109\u001a\u0004\b\u000b\u0010:\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00109\u001a\u0004\b\u000f\u0010:\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u00109\u001a\u0004\b\u0013\u0010:\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u00109\u001a\u0004\b\u0017\u0010:\"F\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u00109\u001a\u0004\b\u001c\u0010:\"B\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u00109\u001a\u0004\b\u001f\u0010:\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u00109\u001a\u0004\b#\u0010:\"F\u0010$\u001a\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00190\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u00109\u001a\u0004\b'\u0010:\"@\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u00109\u001a\u0004\b*\u0010:\"@\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u00109\u001a\u0004\b-\u0010:\"@\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u00109\u001a\u0004\b0\u0010:\"@\u00101\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u00109\u001a\u0004\b3\u0010:\"B\u00104\u001a\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u00109\u001a\u0004\b6\u0010:\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\t0;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b<\u00109\u001a\u0004\b=\u0010>\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\r0;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u00109\u001a\u0004\b@\u0010>\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00110;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u00109\u001a\u0004\bB\u0010>\"B\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00150;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u00109\u001a\u0004\bD\u0010>\"H\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u00109\u001a\u0004\bF\u0010>\"D\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u00109\u001a\u0004\bH\u0010:\"B\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bI\u00109\u001a\u0004\bJ\u0010>\"H\u0010$\u001a\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00190;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bK\u00109\u001a\u0004\bL\u0010>\"B\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u00109\u001a\u0004\bN\u0010>\"B\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u00109\u001a\u0004\bP\u0010>\"B\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u00109\u001a\u0004\bR\u0010>\"B\u00101\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u00109\u001a\u0004\bT\u0010>\"D\u00104\u001a\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u00107*\u000208*\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bU\u00109\u001a\u0004\bV\u0010:\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\t0;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010W\u001a\u0004\b\u000b\u0010X\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\r0;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010W\u001a\u0004\b\u000f\u0010X\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00110;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010W\u001a\u0004\b\u0013\u0010X\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00150;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010W\u001a\u0004\b\u0017\u0010X\"F\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010W\u001a\u0004\b\u001c\u0010X\"B\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010W\u001a\u0004\b\u001f\u0010Y\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010W\u001a\u0004\b#\u0010X\"F\u0010$\u001a\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00190;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010W\u001a\u0004\b'\u0010X\"@\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010W\u001a\u0004\b*\u0010X\"@\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010W\u001a\u0004\b-\u0010X\"@\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010W\u001a\u0004\b0\u0010X\"@\u00101\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020!0;\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010W\u001a\u0004\b3\u0010X\"B\u00104\u001a\u0010\u0012\u0004\u0012\u0002H7\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u00107*\u000208*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010W\u001a\u0004\b6\u0010Y¨\u0006Z"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/tribee/publish/TribeePublishContent;", "Lkntr/app/tribee/publish/TribeePublishContent$Companion;", "getLens$annotations", "(Lkntr/app/tribee/publish/TribeePublishContent$Companion;)V", "getLens", "(Lkntr/app/tribee/publish/TribeePublishContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "title", "", "getTitle$annotations", "getTitle", "content", "Lkntr/common/paragraph/input/RichTextContent;", "getContent$annotations", "getContent", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "getTribeeInfo$annotations", "getTribeeInfo", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "getLimitInfo$annotations", "getLimitInfo", "categories", "", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "getCategories$annotations", "getCategories", "selectedCategory", "getSelectedCategory$annotations", "getSelectedCategory", "validLimitInfo", "", "getValidLimitInfo$annotations", "getValidLimitInfo", "settingItems", "Lkntr/app/tribee/publish/TribeePublishSettingItem;", "getSettingItems$annotations", "getSettingItems", "sendToFollowing", "getSendToFollowing$annotations", "getSendToFollowing", "fromDraft", "getFromDraft$annotations", "getFromDraft", "fromEdit", "getFromEdit$annotations", "getFromEdit", "showPublishConfirmDialog", "getShowPublishConfirmDialog$annotations", "getShowPublishConfirmDialog", "toast", "getToast$annotations", "getToast", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "titleNullable$annotations", "titleNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "contentNullable$annotations", "contentNullable", "tribeeInfoNullable$annotations", "tribeeInfoNullable", "limitInfoNullable$annotations", "limitInfoNullable", "categoriesNullable$annotations", "categoriesNullable", "selectedCategoryNullable$annotations", "selectedCategoryNullable", "validLimitInfoNullable$annotations", "validLimitInfoNullable", "settingItemsNullable$annotations", "settingItemsNullable", "sendToFollowingNullable$annotations", "sendToFollowingNullable", "fromDraftNullable$annotations", "fromDraftNullable", "fromEditNullable$annotations", "fromEditNullable", "showPublishConfirmDialogNullable$annotations", "showPublishConfirmDialogNullable", "toastNullable$annotations", "toastNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishContentLensKt {
    public static /* synthetic */ void categoriesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void fromDraftNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void fromEditNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCategories$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCategories$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCategories$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getFromDraft$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFromDraft$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFromDraft$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getFromEdit$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFromEdit$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFromEdit$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getLimitInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLimitInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLimitInfo$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getSelectedCategory$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSelectedCategory$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSelectedCategory$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getSendToFollowing$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSendToFollowing$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSendToFollowing$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getSettingItems$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSettingItems$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSettingItems$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getShowPublishConfirmDialog$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getShowPublishConfirmDialog$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getShowPublishConfirmDialog$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getTitle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTitle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTitle$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getTribeeInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTribeeInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTribeeInfo$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void getValidLimitInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getValidLimitInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getValidLimitInfo$annotations(TribeePublishContent.Companion companion) {
    }

    public static /* synthetic */ void limitInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void selectedCategoryNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sendToFollowingNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void settingItemsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void showPublishConfirmDialogNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void titleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void tribeeInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void validLimitInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<TribeePublishContent, TribeePublishContent> getLens(TribeePublishContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, TribeePublishContent>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$1
            public TribeePublishContent get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it;
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, TribeePublishContent tribeePublishContent2) {
                TribeePublishContent it = tribeePublishContent2;
                return it;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super TribeePublishContent, ? extends TribeePublishContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                return (TribeePublishContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, String> getTitle(TribeePublishContent.Companion $this$title) {
        Intrinsics.checkNotNullParameter($this$title, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, String>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$2
            public String get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getTitle();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, String str) {
                TribeePublishContent copy;
                String title = str;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : title, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super String, ? extends String> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                String title = (String) function1.invoke(it.getTitle());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : title, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, RichTextContent> getContent(TribeePublishContent.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, RichTextContent>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$3
            public RichTextContent get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getContent();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, RichTextContent richTextContent) {
                TribeePublishContent copy;
                RichTextContent content = richTextContent;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : content, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super RichTextContent, ? extends RichTextContent> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                RichTextContent content = (RichTextContent) function1.invoke(it.getContent());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : content, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, TribeeInfo> getTribeeInfo(TribeePublishContent.Companion $this$tribeeInfo) {
        Intrinsics.checkNotNullParameter($this$tribeeInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, TribeeInfo>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$4
            public TribeeInfo get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getTribeeInfo();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, TribeeInfo tribeeInfo) {
                TribeePublishContent copy;
                TribeeInfo tribeeInfo2 = tribeeInfo;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : tribeeInfo2, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super TribeeInfo, ? extends TribeeInfo> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                TribeeInfo tribeeInfo = (TribeeInfo) function1.invoke(it.getTribeeInfo());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : tribeeInfo, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, KTribeePublishConfig> getLimitInfo(TribeePublishContent.Companion $this$limitInfo) {
        Intrinsics.checkNotNullParameter($this$limitInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, KTribeePublishConfig>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$5
            public KTribeePublishConfig get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getLimitInfo();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, KTribeePublishConfig kTribeePublishConfig) {
                TribeePublishContent copy;
                KTribeePublishConfig limitInfo = kTribeePublishConfig;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : limitInfo, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super KTribeePublishConfig, ? extends KTribeePublishConfig> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                KTribeePublishConfig limitInfo = (KTribeePublishConfig) function1.invoke(it.getLimitInfo());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : limitInfo, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, List<KTribeeCategory>> getCategories(TribeePublishContent.Companion $this$categories) {
        Intrinsics.checkNotNullParameter($this$categories, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, List<? extends KTribeeCategory>>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$6
            public List<? extends KTribeeCategory> get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getCategories();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, List<? extends KTribeeCategory> list) {
                TribeePublishContent copy;
                List<? extends KTribeeCategory> categories = list;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : categories, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super List<? extends KTribeeCategory>, ? extends List<? extends KTribeeCategory>> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                List categories = (List) function1.invoke(it.getCategories());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : categories, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, KTribeeCategory> getSelectedCategory(TribeePublishContent.Companion $this$selectedCategory) {
        Intrinsics.checkNotNullParameter($this$selectedCategory, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, KTribeeCategory>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$7
            public KTribeeCategory get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getSelectedCategory();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, KTribeeCategory kTribeeCategory) {
                TribeePublishContent copy;
                KTribeeCategory selectedCategory = kTribeeCategory;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : selectedCategory, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super KTribeeCategory, ? extends KTribeeCategory> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                KTribeeCategory selectedCategory = (KTribeeCategory) function1.invoke(it.getSelectedCategory());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : selectedCategory, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, Boolean> getValidLimitInfo(TribeePublishContent.Companion $this$validLimitInfo) {
        Intrinsics.checkNotNullParameter($this$validLimitInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, Boolean>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$8
            public Boolean get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return Boolean.valueOf(it.getValidLimitInfo());
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, Boolean bool) {
                TribeePublishContent copy;
                boolean validLimitInfo = bool.booleanValue();
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : validLimitInfo, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super Boolean, ? extends Boolean> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                boolean validLimitInfo = ((Boolean) function1.invoke(Boolean.valueOf(it.getValidLimitInfo()))).booleanValue();
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : validLimitInfo, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<TribeePublishContent, List<TribeePublishSettingItem>> getSettingItems(TribeePublishContent.Companion $this$settingItems) {
        Intrinsics.checkNotNullParameter($this$settingItems, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, List<? extends TribeePublishSettingItem>>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$9
            public List<? extends TribeePublishSettingItem> get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getSettingItems();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, List<? extends TribeePublishSettingItem> list) {
                TribeePublishContent copy;
                List<? extends TribeePublishSettingItem> settingItems = list;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : settingItems, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super List<? extends TribeePublishSettingItem>, ? extends List<? extends TribeePublishSettingItem>> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                List settingItems = (List) function1.invoke(it.getSettingItems());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : settingItems, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, Boolean> getSendToFollowing(TribeePublishContent.Companion $this$sendToFollowing) {
        Intrinsics.checkNotNullParameter($this$sendToFollowing, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, Boolean>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$10
            public Boolean get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return Boolean.valueOf(it.getSendToFollowing());
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, Boolean bool) {
                TribeePublishContent copy;
                boolean sendToFollowing = bool.booleanValue();
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : sendToFollowing, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super Boolean, ? extends Boolean> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                boolean sendToFollowing = ((Boolean) function1.invoke(Boolean.valueOf(it.getSendToFollowing()))).booleanValue();
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : sendToFollowing, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, Boolean> getFromDraft(TribeePublishContent.Companion $this$fromDraft) {
        Intrinsics.checkNotNullParameter($this$fromDraft, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, Boolean>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$11
            public Boolean get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return Boolean.valueOf(it.getFromDraft());
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, Boolean bool) {
                TribeePublishContent copy;
                boolean fromDraft = bool.booleanValue();
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : fromDraft, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super Boolean, ? extends Boolean> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                boolean fromDraft = ((Boolean) function1.invoke(Boolean.valueOf(it.getFromDraft()))).booleanValue();
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : fromDraft, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, Boolean> getFromEdit(TribeePublishContent.Companion $this$fromEdit) {
        Intrinsics.checkNotNullParameter($this$fromEdit, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, Boolean>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$12
            public Boolean get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return Boolean.valueOf(it.getFromEdit());
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, Boolean bool) {
                TribeePublishContent copy;
                boolean fromEdit = bool.booleanValue();
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : fromEdit, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super Boolean, ? extends Boolean> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                boolean fromEdit = ((Boolean) function1.invoke(Boolean.valueOf(it.getFromEdit()))).booleanValue();
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : fromEdit, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, Boolean> getShowPublishConfirmDialog(TribeePublishContent.Companion $this$showPublishConfirmDialog) {
        Intrinsics.checkNotNullParameter($this$showPublishConfirmDialog, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, Boolean>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$13
            public Boolean get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return Boolean.valueOf(it.getShowPublishConfirmDialog());
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, Boolean bool) {
                TribeePublishContent copy;
                boolean showPublishConfirmDialog = bool.booleanValue();
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : showPublishConfirmDialog, (r28 & 4096) != 0 ? it.toast : null);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super Boolean, ? extends Boolean> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                boolean showPublishConfirmDialog = ((Boolean) function1.invoke(Boolean.valueOf(it.getShowPublishConfirmDialog()))).booleanValue();
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : showPublishConfirmDialog, (r28 & 4096) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<TribeePublishContent, String> getToast(TribeePublishContent.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishContent, String>() { // from class: kntr.app.tribee.publish.TribeePublishContentLensKt$special$$inlined$invoke$14
            public String get(TribeePublishContent tribeePublishContent) {
                TribeePublishContent it = tribeePublishContent;
                return it.getToast();
            }

            public TribeePublishContent set(TribeePublishContent tribeePublishContent, String str) {
                TribeePublishContent copy;
                String toast = str;
                TribeePublishContent it = tribeePublishContent;
                copy = it.copy((r28 & 1) != 0 ? it.title : null, (r28 & 2) != 0 ? it.content : null, (r28 & 4) != 0 ? it.tribeeInfo : null, (r28 & 8) != 0 ? it.limitInfo : null, (r28 & 16) != 0 ? it.categories : null, (r28 & 32) != 0 ? it.selectedCategory : null, (r28 & 64) != 0 ? it.validLimitInfo : false, (r28 & 128) != 0 ? it.settingItems : null, (r28 & 256) != 0 ? it.sendToFollowing : false, (r28 & 512) != 0 ? it.fromDraft : false, (r28 & 1024) != 0 ? it.fromEdit : false, (r28 & 2048) != 0 ? it.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it.toast : toast);
                return copy;
            }

            public TribeePublishContent modify(TribeePublishContent tribeePublishContent, Function1<? super String, ? extends String> function1) {
                TribeePublishContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishContent it = tribeePublishContent;
                String toast = (String) function1.invoke(it.getToast());
                TribeePublishContent it2 = tribeePublishContent;
                copy = it2.copy((r28 & 1) != 0 ? it2.title : null, (r28 & 2) != 0 ? it2.content : null, (r28 & 4) != 0 ? it2.tribeeInfo : null, (r28 & 8) != 0 ? it2.limitInfo : null, (r28 & 16) != 0 ? it2.categories : null, (r28 & 32) != 0 ? it2.selectedCategory : null, (r28 & 64) != 0 ? it2.validLimitInfo : false, (r28 & 128) != 0 ? it2.settingItems : null, (r28 & 256) != 0 ? it2.sendToFollowing : false, (r28 & 512) != 0 ? it2.fromDraft : false, (r28 & 1024) != 0 ? it2.fromEdit : false, (r28 & 2048) != 0 ? it2.showPublishConfirmDialog : false, (r28 & 4096) != 0 ? it2.toast : toast);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getTitle(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTitle(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, RichTextContent> getContent(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, TribeeInfo> getTribeeInfo(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTribeeInfo(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, KTribeePublishConfig> getLimitInfo(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLimitInfo(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, List<KTribeeCategory>> getCategories(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCategories(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, KTribeeCategory> getSelectedCategory(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getSelectedCategory(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getValidLimitInfo(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getValidLimitInfo(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, List<TribeePublishSettingItem>> getSettingItems(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSettingItems(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getSendToFollowing(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSendToFollowing(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getFromDraft(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFromDraft(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getFromEdit(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFromEdit(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getShowPublishConfirmDialog(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getShowPublishConfirmDialog(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getToast(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, String> titleNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTitle(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, RichTextContent> contentNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, TribeeInfo> tribeeInfoNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTribeeInfo(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, KTribeePublishConfig> limitInfoNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLimitInfo(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, List<KTribeeCategory>> categoriesNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCategories(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, KTribeeCategory> selectedCategoryNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getSelectedCategory(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> validLimitInfoNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getValidLimitInfo(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, List<TribeePublishSettingItem>> settingItemsNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSettingItems(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> sendToFollowingNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSendToFollowing(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> fromDraftNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFromDraft(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> fromEditNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFromEdit(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> showPublishConfirmDialogNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getShowPublishConfirmDialog(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> toastNullable(BSimpleLens<T, TribeePublishContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getTitle(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTitle(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, RichTextContent> getContent(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, TribeeInfo> getTribeeInfo(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTribeeInfo(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, KTribeePublishConfig> getLimitInfo(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLimitInfo(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, List<KTribeeCategory>> getCategories(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCategories(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, KTribeeCategory> getSelectedCategory(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getSelectedCategory(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getValidLimitInfo(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getValidLimitInfo(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, List<TribeePublishSettingItem>> getSettingItems(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSettingItems(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getSendToFollowing(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSendToFollowing(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getFromDraft(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFromDraft(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getFromEdit(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFromEdit(TribeePublishContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getShowPublishConfirmDialog(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getShowPublishConfirmDialog(TribeePublishContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getToast(BNullableLens<T, TribeePublishContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(TribeePublishContent.Companion));
    }
}