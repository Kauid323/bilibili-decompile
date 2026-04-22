package kntr.common.photonic.aphro.core;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroContentLens.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"0\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007\"0\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"*\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007\"*\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007\",\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010/0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00104\u001a\u0004\b\u000b\u00105\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00104\u001a\u0004\b\u000f\u00105\"F\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u00104\u001a\u0004\b\u0013\u00105\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u00104\u001a\u0004\b\u0017\u00105\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u00104\u001a\u0004\b\u001b\u00105\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001d0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u00104\u001a\u0004\b\u001f\u00105\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001d0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u00104\u001a\u0004\b\"\u00105\"F\u0010#\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00110\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u00104\u001a\u0004\b&\u00105\"@\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020(0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b)\u00104\u001a\u0004\b*\u00105\"@\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020(0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b,\u00104\u001a\u0004\b-\u00105\"B\u0010.\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010/0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u00104\u001a\u0004\b1\u00105\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\t06\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00104\u001a\u0004\b8\u00109\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u00104\u001a\u0004\b;\u00105\"H\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001106\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b<\u00104\u001a\u0004\b=\u00109\"B\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001506\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u00104\u001a\u0004\b?\u00109\"B\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001906\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u00104\u001a\u0004\bA\u00109\"B\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001d06\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u00104\u001a\u0004\bC\u00109\"B\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001d06\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u00104\u001a\u0004\bE\u00109\"H\u0010#\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001106\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u00104\u001a\u0004\bG\u00109\"B\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020(06\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\bH\u00104\u001a\u0004\bI\u00109\"B\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020(06\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\bJ\u00104\u001a\u0004\bK\u00109\"D\u0010.\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010/0\u0001\"\b\b\u0000\u00102*\u000203*\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u00104\u001a\u0004\bM\u00105\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\t06\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010N\u001a\u0004\b\u000b\u0010O\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010N\u001a\u0004\b\u000f\u0010P\"F\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001106\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010N\u001a\u0004\b\u0013\u0010O\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001506\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010N\u001a\u0004\b\u0017\u0010O\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001906\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010N\u001a\u0004\b\u001b\u0010O\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001d06\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010N\u001a\u0004\b\u001f\u0010O\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001d06\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010N\u001a\u0004\b\"\u0010O\"F\u0010#\u001a\u0014\u0012\u0004\u0012\u0002H2\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001106\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010N\u001a\u0004\b&\u0010O\"@\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020(06\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068@X\u0081\u0004¢\u0006\f\u0012\u0004\b)\u0010N\u001a\u0004\b*\u0010O\"@\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020(06\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068@X\u0081\u0004¢\u0006\f\u0012\u0004\b,\u0010N\u001a\u0004\b-\u0010O\"B\u0010.\u001a\u0010\u0012\u0004\u0012\u0002H2\u0012\u0006\u0012\u0004\u0018\u00010/0\u0001\"\b\b\u0000\u00102*\u000203*\u000e\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u0002068FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010N\u001a\u0004\b1\u0010P¨\u0006Q"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent$Companion;", "getLens$annotations", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent$Companion;)V", "getLens", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "status", "Lkntr/common/photonic/aphro/core/AphroPageStatus;", "getStatus$annotations", "getStatus", "selectedAlbum", "Lkntr/common/photonic/AlbumInfo;", "getSelectedAlbum$annotations", "getSelectedAlbum", "albumList", "", "getAlbumList$annotations", "getAlbumList", "assetsState", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "getAssetsState$annotations", "getAssetsState", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getOption$annotations", "getOption", "useOriginImage", "", "getUseOriginImage$annotations", "getUseOriginImage", "confirmed", "getConfirmed$annotations", "getConfirmed", "selected", "Lkntr/common/photonic/Asset;", "getSelected$annotations", "getSelected", "albumRefresh", "", "getAlbumRefresh$annotations", "getAlbumRefresh", "requiredAssetCount", "getRequiredAssetCount$annotations", "getRequiredAssetCount", "toast", "Lkntr/common/photonic/aphro/core/ToastData;", "getToast$annotations", "getToast", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "statusNullable$annotations", "statusNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "selectedAlbumNullable$annotations", "selectedAlbumNullable", "albumListNullable$annotations", "albumListNullable", "assetsStateNullable$annotations", "assetsStateNullable", "optionNullable$annotations", "optionNullable", "useOriginImageNullable$annotations", "useOriginImageNullable", "confirmedNullable$annotations", "confirmedNullable", "selectedNullable$annotations", "selectedNullable", "albumRefreshNullable$annotations", "albumRefreshNullable", "requiredAssetCountNullable$annotations", "requiredAssetCountNullable", "toastNullable$annotations", "toastNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroContentLensKt {
    public static /* synthetic */ void albumListNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void albumRefreshNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void assetsStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void confirmedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlbumList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAlbumList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlbumList$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getAlbumRefresh$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAlbumRefresh$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlbumRefresh$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getAssetsState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAssetsState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAssetsState$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getConfirmed$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getConfirmed$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getConfirmed$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getOption$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOption$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOption$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getSelected$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSelected$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSelected$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getSelectedAlbum$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSelectedAlbum$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSelectedAlbum$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getUseOriginImage$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUseOriginImage$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUseOriginImage$annotations(AphroState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void optionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void requiredAssetCountNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void selectedAlbumNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void selectedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void useOriginImageNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<AphroState.AphroContent, AphroState.AphroContent> getLens(AphroState.AphroContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, AphroState.AphroContent>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$1
            public AphroState.AphroContent get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it;
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, AphroState.AphroContent aphroContent2) {
                AphroState.AphroContent it = aphroContent2;
                return it;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super AphroState.AphroContent, ? extends AphroState.AphroContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                return (AphroState.AphroContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, AphroPageStatus> getStatus(AphroState.AphroContent.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, AphroPageStatus>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$2
            public AphroPageStatus get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it.getStatus();
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, AphroPageStatus aphroPageStatus) {
                AphroState.AphroContent copy;
                AphroPageStatus status = aphroPageStatus;
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : status, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super AphroPageStatus, ? extends AphroPageStatus> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                AphroPageStatus status = (AphroPageStatus) function1.invoke(it.getStatus());
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : status, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, AlbumInfo> getSelectedAlbum(AphroState.AphroContent.Companion $this$selectedAlbum) {
        Intrinsics.checkNotNullParameter($this$selectedAlbum, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, AlbumInfo>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$3
            public AlbumInfo get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it.getSelectedAlbum();
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, AlbumInfo albumInfo) {
                AphroState.AphroContent copy;
                AlbumInfo selectedAlbum = albumInfo;
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : selectedAlbum, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super AlbumInfo, ? extends AlbumInfo> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                AlbumInfo selectedAlbum = (AlbumInfo) function1.invoke(it.getSelectedAlbum());
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : selectedAlbum, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<AphroState.AphroContent, List<AlbumInfo>> getAlbumList(AphroState.AphroContent.Companion $this$albumList) {
        Intrinsics.checkNotNullParameter($this$albumList, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, List<? extends AlbumInfo>>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$4
            public List<? extends AlbumInfo> get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it.getAlbumList();
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, List<? extends AlbumInfo> list) {
                AphroState.AphroContent copy;
                List<? extends AlbumInfo> albumList = list;
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : albumList, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super List<? extends AlbumInfo>, ? extends List<? extends AlbumInfo>> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                List albumList = (List) function1.invoke(it.getAlbumList());
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : albumList, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, AphroAssetsState> getAssetsState(AphroState.AphroContent.Companion $this$assetsState) {
        Intrinsics.checkNotNullParameter($this$assetsState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, AphroAssetsState>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$5
            public AphroAssetsState get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it.getAssetsState();
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, AphroAssetsState aphroAssetsState) {
                AphroState.AphroContent copy;
                AphroAssetsState assetsState = aphroAssetsState;
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : assetsState, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super AphroAssetsState, ? extends AphroAssetsState> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                AphroAssetsState assetsState = (AphroAssetsState) function1.invoke(it.getAssetsState());
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : assetsState, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, AphroSelectOption> getOption(AphroState.AphroContent.Companion $this$option) {
        Intrinsics.checkNotNullParameter($this$option, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, AphroSelectOption>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$6
            public AphroSelectOption get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it.getOption();
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, AphroSelectOption aphroSelectOption) {
                AphroState.AphroContent copy;
                AphroSelectOption option = aphroSelectOption;
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : option, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super AphroSelectOption, ? extends AphroSelectOption> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                AphroSelectOption option = (AphroSelectOption) function1.invoke(it.getOption());
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : option, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, Boolean> getUseOriginImage(AphroState.AphroContent.Companion $this$useOriginImage) {
        Intrinsics.checkNotNullParameter($this$useOriginImage, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, Boolean>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$7
            public Boolean get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return Boolean.valueOf(it.getUseOriginImage());
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, Boolean bool) {
                AphroState.AphroContent copy;
                boolean useOriginImage = bool.booleanValue();
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : useOriginImage, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super Boolean, ? extends Boolean> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                boolean useOriginImage = ((Boolean) function1.invoke(Boolean.valueOf(it.getUseOriginImage()))).booleanValue();
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : useOriginImage, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, Boolean> getConfirmed(AphroState.AphroContent.Companion $this$confirmed) {
        Intrinsics.checkNotNullParameter($this$confirmed, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, Boolean>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$8
            public Boolean get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return Boolean.valueOf(it.getConfirmed());
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, Boolean bool) {
                AphroState.AphroContent copy;
                boolean confirmed = bool.booleanValue();
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : confirmed, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super Boolean, ? extends Boolean> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                boolean confirmed = ((Boolean) function1.invoke(Boolean.valueOf(it.getConfirmed()))).booleanValue();
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : confirmed, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<AphroState.AphroContent, List<Asset>> getSelected(AphroState.AphroContent.Companion $this$selected) {
        Intrinsics.checkNotNullParameter($this$selected, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, List<? extends Asset>>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$9
            public List<? extends Asset> get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it.getSelected();
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, List<? extends Asset> list) {
                AphroState.AphroContent copy;
                List<? extends Asset> selected = list;
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : selected, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super List<? extends Asset>, ? extends List<? extends Asset>> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                List selected = (List) function1.invoke(it.getSelected());
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : selected, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, Integer> getAlbumRefresh(AphroState.AphroContent.Companion $this$albumRefresh) {
        Intrinsics.checkNotNullParameter($this$albumRefresh, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, Integer>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$10
            public Integer get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return Integer.valueOf(it.getAlbumRefresh$core_debug());
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, Integer num) {
                AphroState.AphroContent copy;
                int albumRefresh = num.intValue();
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : albumRefresh, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super Integer, ? extends Integer> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                int albumRefresh = ((Number) function1.invoke(Integer.valueOf(it.getAlbumRefresh$core_debug()))).intValue();
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : albumRefresh, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, Integer> getRequiredAssetCount(AphroState.AphroContent.Companion $this$requiredAssetCount) {
        Intrinsics.checkNotNullParameter($this$requiredAssetCount, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, Integer>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$11
            public Integer get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return Integer.valueOf(it.getRequiredAssetCount$core_debug());
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, Integer num) {
                AphroState.AphroContent copy;
                int requiredAssetCount = num.intValue();
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : requiredAssetCount, (r24 & 1024) != 0 ? it.toast : null);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super Integer, ? extends Integer> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                int requiredAssetCount = ((Number) function1.invoke(Integer.valueOf(it.getRequiredAssetCount$core_debug()))).intValue();
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : requiredAssetCount, (r24 & 1024) != 0 ? it2.toast : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<AphroState.AphroContent, ToastData> getToast(AphroState.AphroContent.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.AphroContent, ToastData>() { // from class: kntr.common.photonic.aphro.core.AphroContentLensKt$special$$inlined$invoke$12
            public ToastData get(AphroState.AphroContent aphroContent) {
                AphroState.AphroContent it = aphroContent;
                return it.getToast();
            }

            public AphroState.AphroContent set(AphroState.AphroContent aphroContent, ToastData toastData) {
                AphroState.AphroContent copy;
                ToastData toast = toastData;
                AphroState.AphroContent it = aphroContent;
                copy = it.copy((r24 & 1) != 0 ? it.status : null, (r24 & 2) != 0 ? it.selectedAlbum : null, (r24 & 4) != 0 ? it.albumList : null, (r24 & 8) != 0 ? it.assetsState : null, (r24 & 16) != 0 ? it.option : null, (r24 & 32) != 0 ? it.useOriginImage : false, (r24 & 64) != 0 ? it.confirmed : false, (r24 & 128) != 0 ? it.selected : null, (r24 & 256) != 0 ? it.albumRefresh : 0, (r24 & 512) != 0 ? it.requiredAssetCount : 0, (r24 & 1024) != 0 ? it.toast : toast);
                return copy;
            }

            public AphroState.AphroContent modify(AphroState.AphroContent aphroContent, Function1<? super ToastData, ? extends ToastData> function1) {
                AphroState.AphroContent copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.AphroContent it = aphroContent;
                ToastData toast = (ToastData) function1.invoke(it.getToast());
                AphroState.AphroContent it2 = aphroContent;
                copy = it2.copy((r24 & 1) != 0 ? it2.status : null, (r24 & 2) != 0 ? it2.selectedAlbum : null, (r24 & 4) != 0 ? it2.albumList : null, (r24 & 8) != 0 ? it2.assetsState : null, (r24 & 16) != 0 ? it2.option : null, (r24 & 32) != 0 ? it2.useOriginImage : false, (r24 & 64) != 0 ? it2.confirmed : false, (r24 & 128) != 0 ? it2.selected : null, (r24 & 256) != 0 ? it2.albumRefresh : 0, (r24 & 512) != 0 ? it2.requiredAssetCount : 0, (r24 & 1024) != 0 ? it2.toast : toast);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, AphroPageStatus> getStatus(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, AlbumInfo> getSelectedAlbum(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getSelectedAlbum(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, List<AlbumInfo>> getAlbumList(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAlbumList(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, AphroAssetsState> getAssetsState(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAssetsState(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, AphroSelectOption> getOption(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOption(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getUseOriginImage(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUseOriginImage(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getConfirmed(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getConfirmed(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, List<Asset>> getSelected(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSelected(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getAlbumRefresh(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAlbumRefresh(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getRequiredAssetCount(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRequiredAssetCount(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, ToastData> getToast(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, AphroPageStatus> statusNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, AlbumInfo> selectedAlbumNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getSelectedAlbum(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, List<AlbumInfo>> albumListNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAlbumList(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, AphroAssetsState> assetsStateNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAssetsState(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> optionNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOption(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> useOriginImageNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUseOriginImage(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> confirmedNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getConfirmed(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, List<Asset>> selectedNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSelected(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> albumRefreshNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAlbumRefresh(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> requiredAssetCountNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRequiredAssetCount(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, ToastData> toastNullable(BSimpleLens<T, AphroState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, AphroPageStatus> getStatus(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, AlbumInfo> getSelectedAlbum(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getSelectedAlbum(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, List<AlbumInfo>> getAlbumList(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAlbumList(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, AphroAssetsState> getAssetsState(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAssetsState(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> getOption(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOption(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getUseOriginImage(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUseOriginImage(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getConfirmed(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getConfirmed(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, List<Asset>> getSelected(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSelected(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getAlbumRefresh(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAlbumRefresh(AphroState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getRequiredAssetCount(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRequiredAssetCount(AphroState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, ToastData> getToast(BNullableLens<T, AphroState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(AphroState.AphroContent.Companion));
    }
}