package im.session.model;

import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KSessionListExtraInfo;
import com.bapis.bilibili.app.im.v1.KUpdateSessionParams;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.session.model.IMSessionPageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionPageDataLens.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\",\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\",\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\",\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"0\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"0\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"0\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\",\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007\",\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007\"0\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007\"*\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0005\u001a\u0004\b/\u0010\u0007\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u00104\u001a\u0004\b\u000b\u00105\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000e\u00104\u001a\u0004\b\u000f\u00105\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u00104\u001a\u0004\b\u0013\u00105\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0016\u00104\u001a\u0004\b\u0017\u00105\"F\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u00104\u001a\u0004\b\u001c\u00105\"F\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u00104\u001a\u0004\b \u00105\"F\u0010!\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u00104\u001a\u0004\b#\u00105\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u00104\u001a\u0004\b'\u00105\"B\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u00104\u001a\u0004\b*\u00105\"F\u0010+\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00190\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u00104\u001a\u0004\b.\u00105\"@\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002000\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u00104\u001a\u0004\b/\u00105\"D\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b6\u00104\u001a\u0004\b7\u00105\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b8\u00104\u001a\u0004\b9\u00105\"D\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u00104\u001a\u0004\b;\u00105\"D\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b<\u00104\u001a\u0004\b=\u00105\"H\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190>\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u00104\u001a\u0004\b@\u0010A\"H\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190>\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u00104\u001a\u0004\bC\u0010A\"H\u0010!\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190>\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u00104\u001a\u0004\bE\u0010A\"D\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u00104\u001a\u0004\bG\u00105\"D\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u00104\u001a\u0004\bI\u00105\"H\u0010+\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00190>\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u00104\u001a\u0004\bK\u0010A\"B\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002000>\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u00104\u001a\u0004\bM\u0010A\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010N\u001a\u0004\b\u000b\u0010O\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010N\u001a\u0004\b\u000f\u0010O\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010N\u001a\u0004\b\u0013\u0010O\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010N\u001a\u0004\b\u0017\u0010O\"F\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190>\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010N\u001a\u0004\b\u001c\u0010P\"F\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190>\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010N\u001a\u0004\b \u0010P\"F\u0010!\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190>\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010N\u001a\u0004\b#\u0010P\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010N\u001a\u0004\b'\u0010O\"B\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010N\u001a\u0004\b*\u0010O\"F\u0010+\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00190>\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010N\u001a\u0004\b.\u0010P\"@\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002000>\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020>8FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010N\u001a\u0004\b/\u0010P¨\u0006Q"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/session/model/IMSessionPageData;", "Lim/session/model/IMSessionPageData$Companion;", "getLens$annotations", "(Lim/session/model/IMSessionPageData$Companion;)V", "getLens", "(Lim/session/model/IMSessionPageData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "paginationParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "getPaginationParams$annotations", "getPaginationParams", "updateSessionParams", "Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;", "getUpdateSessionParams$annotations", "getUpdateSessionParams", "quickLinks", "Lim/session/model/IMQuickLink;", "getQuickLinks$annotations", "getQuickLinks", "filterConfig", "Lim/session/model/IMSessionFilterConfig;", "getFilterConfig$annotations", "getFilterConfig", "sessions", "", "Lim/session/model/IMSessionCard;", "getSessions$annotations", "getSessions", "threeDots", "Lim/session/model/IMThreeDotItem;", "getThreeDots$annotations", "getThreeDots", "outsideActions", "getOutsideActions$annotations", "getOutsideActions", "extraInfo", "Lcom/bapis/bilibili/app/im/v1/KSessionListExtraInfo;", "getExtraInfo$annotations", "getExtraInfo", "sessionToDelete", "getSessionToDelete$annotations", "getSessionToDelete", "filters", "Lim/session/model/IMSessionFilter;", "getFilters$annotations", "getFilters", "isCache", "", "isCache$annotations", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "paginationParamsNullable$annotations", "paginationParamsNullable", "updateSessionParamsNullable$annotations", "updateSessionParamsNullable", "quickLinksNullable$annotations", "quickLinksNullable", "filterConfigNullable$annotations", "filterConfigNullable", "Lcom/bilibili/blens/BNullableLens;", "sessionsNullable$annotations", "sessionsNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "threeDotsNullable$annotations", "threeDotsNullable", "outsideActionsNullable$annotations", "outsideActionsNullable", "extraInfoNullable$annotations", "extraInfoNullable", "sessionToDeleteNullable$annotations", "sessionToDeleteNullable", "filtersNullable$annotations", "filtersNullable", "isCacheNullable$annotations", "isCacheNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageDataLensKt {
    public static /* synthetic */ void extraInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void filterConfigNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void filtersNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getExtraInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getExtraInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getExtraInfo$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getFilterConfig$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFilterConfig$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFilterConfig$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getFilters$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFilters$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFilters$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getOutsideActions$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOutsideActions$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOutsideActions$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getPaginationParams$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPaginationParams$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPaginationParams$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getQuickLinks$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQuickLinks$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQuickLinks$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getSessionToDelete$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionToDelete$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionToDelete$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getSessions$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessions$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessions$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getThreeDots$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getThreeDots$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getThreeDots$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void getUpdateSessionParams$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUpdateSessionParams$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUpdateSessionParams$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void isCache$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isCache$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isCache$annotations(IMSessionPageData.Companion companion) {
    }

    public static /* synthetic */ void isCacheNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void outsideActionsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void paginationParamsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void quickLinksNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionToDeleteNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void threeDotsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void updateSessionParamsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMSessionPageData, IMSessionPageData> getLens(IMSessionPageData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, IMSessionPageData>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$1
            public IMSessionPageData get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it;
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, IMSessionPageData iMSessionPageData2) {
                IMSessionPageData it = iMSessionPageData2;
                return it;
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super IMSessionPageData, ? extends IMSessionPageData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                return (IMSessionPageData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMSessionPageData, KPaginationParams> getPaginationParams(IMSessionPageData.Companion $this$paginationParams) {
        Intrinsics.checkNotNullParameter($this$paginationParams, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, KPaginationParams>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$2
            public KPaginationParams get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getPaginationParams$session_debug();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, KPaginationParams kPaginationParams) {
                KPaginationParams paginationParams = kPaginationParams;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, paginationParams, null, null, null, null, null, null, null, null, null, false, 2046, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super KPaginationParams, ? extends KPaginationParams> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                KPaginationParams paginationParams = (KPaginationParams) function1.invoke(it.getPaginationParams$session_debug());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, paginationParams, null, null, null, null, null, null, null, null, null, false, 2046, null);
            }
        };
    }

    public static final BSimpleLens<IMSessionPageData, KUpdateSessionParams> getUpdateSessionParams(IMSessionPageData.Companion $this$updateSessionParams) {
        Intrinsics.checkNotNullParameter($this$updateSessionParams, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, KUpdateSessionParams>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$3
            public KUpdateSessionParams get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getUpdateSessionParams$session_debug();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, KUpdateSessionParams kUpdateSessionParams) {
                KUpdateSessionParams updateSessionParams = kUpdateSessionParams;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, updateSessionParams, null, null, null, null, null, null, null, null, false, 2045, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super KUpdateSessionParams, ? extends KUpdateSessionParams> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                KUpdateSessionParams updateSessionParams = (KUpdateSessionParams) function1.invoke(it.getUpdateSessionParams$session_debug());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, updateSessionParams, null, null, null, null, null, null, null, null, false, 2045, null);
            }
        };
    }

    public static final BSimpleLens<IMSessionPageData, IMQuickLink> getQuickLinks(IMSessionPageData.Companion $this$quickLinks) {
        Intrinsics.checkNotNullParameter($this$quickLinks, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, IMQuickLink>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$4
            public IMQuickLink get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getQuickLinks();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, IMQuickLink iMQuickLink) {
                IMQuickLink quickLinks = iMQuickLink;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, quickLinks, null, null, null, null, null, null, null, false, 2043, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super IMQuickLink, ? extends IMQuickLink> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                IMQuickLink quickLinks = (IMQuickLink) function1.invoke(it.getQuickLinks());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, quickLinks, null, null, null, null, null, null, null, false, 2043, null);
            }
        };
    }

    public static final BSimpleLens<IMSessionPageData, IMSessionFilterConfig> getFilterConfig(IMSessionPageData.Companion $this$filterConfig) {
        Intrinsics.checkNotNullParameter($this$filterConfig, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, IMSessionFilterConfig>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$5
            public IMSessionFilterConfig get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getFilterConfig$session_debug();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, IMSessionFilterConfig iMSessionFilterConfig) {
                IMSessionFilterConfig filterConfig = iMSessionFilterConfig;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, filterConfig, null, null, null, null, null, null, false, 2039, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super IMSessionFilterConfig, ? extends IMSessionFilterConfig> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                IMSessionFilterConfig filterConfig = (IMSessionFilterConfig) function1.invoke(it.getFilterConfig$session_debug());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, filterConfig, null, null, null, null, null, null, false, 2039, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMSessionPageData, List<IMSessionCard>> getSessions(IMSessionPageData.Companion $this$sessions) {
        Intrinsics.checkNotNullParameter($this$sessions, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, List<? extends IMSessionCard>>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$6
            public List<? extends IMSessionCard> get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getSessions();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, List<? extends IMSessionCard> list) {
                List<? extends IMSessionCard> sessions = list;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, null, sessions, null, null, null, null, null, false, 2031, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super List<? extends IMSessionCard>, ? extends List<? extends IMSessionCard>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                List sessions = (List) function1.invoke(it.getSessions());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, null, sessions, null, null, null, null, null, false, 2031, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMSessionPageData, List<IMThreeDotItem>> getThreeDots(IMSessionPageData.Companion $this$threeDots) {
        Intrinsics.checkNotNullParameter($this$threeDots, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, List<? extends IMThreeDotItem>>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$7
            public List<? extends IMThreeDotItem> get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getThreeDots();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, List<? extends IMThreeDotItem> list) {
                List<? extends IMThreeDotItem> threeDots = list;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, null, null, threeDots, null, null, null, null, false, 2015, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super List<? extends IMThreeDotItem>, ? extends List<? extends IMThreeDotItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                List threeDots = (List) function1.invoke(it.getThreeDots());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, null, null, threeDots, null, null, null, null, false, 2015, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMSessionPageData, List<IMThreeDotItem>> getOutsideActions(IMSessionPageData.Companion $this$outsideActions) {
        Intrinsics.checkNotNullParameter($this$outsideActions, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, List<? extends IMThreeDotItem>>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$8
            public List<? extends IMThreeDotItem> get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getOutsideActions();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, List<? extends IMThreeDotItem> list) {
                List<? extends IMThreeDotItem> outsideActions = list;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, null, null, null, outsideActions, null, null, null, false, 1983, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super List<? extends IMThreeDotItem>, ? extends List<? extends IMThreeDotItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                List outsideActions = (List) function1.invoke(it.getOutsideActions());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, null, null, null, outsideActions, null, null, null, false, 1983, null);
            }
        };
    }

    public static final BSimpleLens<IMSessionPageData, KSessionListExtraInfo> getExtraInfo(IMSessionPageData.Companion $this$extraInfo) {
        Intrinsics.checkNotNullParameter($this$extraInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, KSessionListExtraInfo>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$9
            public KSessionListExtraInfo get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getExtraInfo();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, KSessionListExtraInfo kSessionListExtraInfo) {
                KSessionListExtraInfo extraInfo = kSessionListExtraInfo;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, null, null, null, null, extraInfo, null, null, false, 1919, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super KSessionListExtraInfo, ? extends KSessionListExtraInfo> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                KSessionListExtraInfo extraInfo = (KSessionListExtraInfo) function1.invoke(it.getExtraInfo());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, null, null, null, null, extraInfo, null, null, false, 1919, null);
            }
        };
    }

    public static final BSimpleLens<IMSessionPageData, IMSessionCard> getSessionToDelete(IMSessionPageData.Companion $this$sessionToDelete) {
        Intrinsics.checkNotNullParameter($this$sessionToDelete, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, IMSessionCard>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$10
            public IMSessionCard get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getSessionToDelete();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, IMSessionCard iMSessionCard) {
                IMSessionCard sessionToDelete = iMSessionCard;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, null, null, null, null, null, sessionToDelete, null, false, 1791, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super IMSessionCard, ? extends IMSessionCard> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                IMSessionCard sessionToDelete = (IMSessionCard) function1.invoke(it.getSessionToDelete());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, null, null, null, null, null, sessionToDelete, null, false, 1791, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMSessionPageData, List<IMSessionFilter>> getFilters(IMSessionPageData.Companion $this$filters) {
        Intrinsics.checkNotNullParameter($this$filters, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, List<? extends IMSessionFilter>>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$11
            public List<? extends IMSessionFilter> get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return it.getFilters();
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, List<? extends IMSessionFilter> list) {
                List<? extends IMSessionFilter> filters = list;
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, null, null, null, null, null, null, filters, false, 1535, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super List<? extends IMSessionFilter>, ? extends List<? extends IMSessionFilter>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                List filters = (List) function1.invoke(it.getFilters());
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, null, null, null, null, null, null, filters, false, 1535, null);
            }
        };
    }

    public static final BSimpleLens<IMSessionPageData, Boolean> isCache(IMSessionPageData.Companion $this$isCache) {
        Intrinsics.checkNotNullParameter($this$isCache, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSessionPageData, Boolean>() { // from class: im.session.model.IMSessionPageDataLensKt$special$$inlined$invoke$12
            public Boolean get(IMSessionPageData iMSessionPageData) {
                IMSessionPageData it = iMSessionPageData;
                return Boolean.valueOf(it.isCache());
            }

            public IMSessionPageData set(IMSessionPageData iMSessionPageData, Boolean bool) {
                boolean isCache = bool.booleanValue();
                IMSessionPageData it = iMSessionPageData;
                return IMSessionPageData.copy$default(it, null, null, null, null, null, null, null, null, null, null, isCache, 1023, null);
            }

            public IMSessionPageData modify(IMSessionPageData iMSessionPageData, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSessionPageData it = iMSessionPageData;
                boolean isCache = ((Boolean) function1.invoke(Boolean.valueOf(it.isCache()))).booleanValue();
                IMSessionPageData it2 = iMSessionPageData;
                return IMSessionPageData.copy$default(it2, null, null, null, null, null, null, null, null, null, null, isCache, 1023, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, KPaginationParams> getPaginationParams(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getPaginationParams(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KUpdateSessionParams> getUpdateSessionParams(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getUpdateSessionParams(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMQuickLink> getQuickLinks(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getQuickLinks(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionFilterConfig> getFilterConfig(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getFilterConfig(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<IMSessionCard>> getSessions(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessions(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<IMThreeDotItem>> getThreeDots(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getThreeDots(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<IMThreeDotItem>> getOutsideActions(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOutsideActions(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KSessionListExtraInfo> getExtraInfo(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getExtraInfo(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionCard> getSessionToDelete(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getSessionToDelete(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<IMSessionFilter>> getFilters(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFilters(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isCache(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isCache(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> paginationParamsNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getPaginationParams(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KUpdateSessionParams> updateSessionParamsNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getUpdateSessionParams(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMQuickLink> quickLinksNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getQuickLinks(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionFilterConfig> filterConfigNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getFilterConfig(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMSessionCard>> sessionsNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessions(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMThreeDotItem>> threeDotsNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getThreeDots(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMThreeDotItem>> outsideActionsNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOutsideActions(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KSessionListExtraInfo> extraInfoNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getExtraInfo(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionCard> sessionToDeleteNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getSessionToDelete(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMSessionFilter>> filtersNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFilters(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isCacheNullable(BSimpleLens<T, IMSessionPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isCache(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> getPaginationParams(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getPaginationParams(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KUpdateSessionParams> getUpdateSessionParams(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getUpdateSessionParams(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMQuickLink> getQuickLinks(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getQuickLinks(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionFilterConfig> getFilterConfig(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getFilterConfig(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMSessionCard>> getSessions(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessions(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMThreeDotItem>> getThreeDots(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getThreeDots(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMThreeDotItem>> getOutsideActions(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOutsideActions(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KSessionListExtraInfo> getExtraInfo(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getExtraInfo(IMSessionPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionCard> getSessionToDelete(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getSessionToDelete(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMSessionFilter>> getFilters(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFilters(IMSessionPageData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isCache(BNullableLens<T, IMSessionPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isCache(IMSessionPageData.Companion));
    }
}