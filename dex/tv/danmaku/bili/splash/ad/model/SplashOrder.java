package tv.danmaku.bili.splash.ad.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler;

/* compiled from: SplashOrder.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bc\n\u0002\u0018\u0002\n\u0002\bL\b\u0087\b\u0018\u00002\u00020\u0001Bý\u0005\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010*\u001a\u00020&\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010,\u001a\u00020\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\u0006\u0012\b\b\u0002\u0010.\u001a\u00020/\u0012\b\b\u0002\u00100\u001a\u00020\u0003\u0012\b\b\u0002\u00101\u001a\u00020\u0003\u0012\b\b\u0002\u00102\u001a\u00020\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u00105\u001a\u00020\u0006\u0012\b\b\u0002\u00106\u001a\u00020&\u0012\b\b\u0002\u00107\u001a\u00020&\u0012\b\b\u0002\u00108\u001a\u00020\u0006\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010:\u001a\u00020\u0006\u0012\b\b\u0002\u0010;\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010=\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010G\u001a\u00020\u0006\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010K\u001a\u00020&\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010N\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010=\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010Q\u001a\u00020\u0006\u0012\b\b\u0002\u0010R\u001a\u00020&\u0012\b\b\u0002\u0010S\u001a\u00020\u0003\u0012\b\b\u0002\u0010T\u001a\u00020&¢\u0006\u0004\bU\u0010VJ\n\u0010´\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010½\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010Ì\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010Ó\u0001\u001a\u00020&HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020&HÆ\u0003J\f\u0010Õ\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\n\u0010Ö\u0001\u001a\u00020&HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Ù\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020/HÆ\u0003J\n\u0010Û\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010Ý\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010á\u0001\u001a\u00020&HÆ\u0003J\n\u0010â\u0001\u001a\u00020&HÆ\u0003J\n\u0010ã\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010å\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010æ\u0001\u001a\u00020\u0006HÆ\u0003J\u0012\u0010ç\u0001\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010@HÆ\u0003J\u0012\u0010é\u0001\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010=HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010DHÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010FHÆ\u0003J\n\u0010ì\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010í\u0001\u001a\u0004\u0018\u00010IHÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010ï\u0001\u001a\u00020&HÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010MHÆ\u0003J\n\u0010ñ\u0001\u001a\u00020\u0003HÆ\u0003J\u0012\u0010ò\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010=HÆ\u0003J\f\u0010ó\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\n\u0010ô\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010õ\u0001\u001a\u00020&HÆ\u0003J\n\u0010ö\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010÷\u0001\u001a\u00020&HÆ\u0003J\u0080\u0006\u0010ø\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020&2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u00105\u001a\u00020\u00062\b\b\u0002\u00106\u001a\u00020&2\b\b\u0002\u00107\u001a\u00020&2\b\b\u0002\u00108\u001a\u00020\u00062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010:\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020\u00062\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010=2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010G\u001a\u00020\u00062\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010K\u001a\u00020&2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010N\u001a\u00020\u00032\u0010\b\u0002\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010=2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010Q\u001a\u00020\u00062\b\b\u0002\u0010R\u001a\u00020&2\b\b\u0002\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020&HÆ\u0001J\u0015\u0010ù\u0001\u001a\u00020&2\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010û\u0001\u001a\u00020\u0006HÖ\u0001J\n\u0010ü\u0001\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010[R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010[\"\u0004\b^\u0010_R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010[R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010[R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010XR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010XR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010XR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010fR\u0016\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010[R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010[R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010fR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010fR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010fR\u0016\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010[R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010fR\u0016\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010[R\u0016\u0010 \u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010[R \u0010!\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010f\"\u0004\by\u0010zR\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010XR \u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010f\"\u0004\b}\u0010zR\u0018\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010fR\u0016\u0010%\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u007fR\u0016\u0010'\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u007fR\u001a\u0010(\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010*\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u007fR\u0019\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010fR\u0017\u0010,\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010[R\u0017\u0010-\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010[R\u0018\u0010.\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u00100\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010XR\u0017\u00101\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010XR\u0017\u00102\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010XR\u0019\u00103\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010fR\u0019\u00104\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010fR\u0017\u00105\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010[R\u0017\u00106\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u007fR\u0017\u00107\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u007fR\u0017\u00108\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010[R\u0019\u00109\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010fR\u0017\u0010:\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010[R\u0017\u0010;\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010[R \u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010?\u001a\u0004\u0018\u00010@8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R \u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0095\u0001R\u001a\u0010C\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010E\u001a\u0004\u0018\u00010F8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0017\u0010G\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0001\u0010[R\u001a\u0010H\u001a\u0004\u0018\u00010I8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010J\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010fR\u0017\u0010K\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¡\u0001\u0010\u007fR\u001a\u0010L\u001a\u0004\u0018\u00010M8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010N\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010XR \u0010O\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010\u0095\u0001R\u001e\u0010P\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010f\"\u0005\b§\u0001\u0010zR\u001c\u0010Q\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010[\"\u0005\b©\u0001\u0010_R\u001c\u0010R\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\bR\u0010\u007f\"\u0006\bª\u0001\u0010«\u0001R\u001d\u0010S\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¬\u0001\u0010X\"\u0006\b\u00ad\u0001\u0010®\u0001R\u001c\u0010T\u001a\u00020&X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\bT\u0010\u007f\"\u0006\b¯\u0001\u0010«\u0001R\u0015\u0010°\u0001\u001a\u00030±\u0001¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001¨\u0006ý\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "", "id", "", "splashCreativeId", "type", "", "splashType", "topViewType", "topViewLoc", "cardType", "duration", "beginTime", "endTime", "imageUrl", "", "imageHash", "logoUrl", "logoHash", "videoUrl", "videoHash", "videoWidth", "videoHeight", "splashEgg", "Ltv/danmaku/bili/splash/ad/model/SplashEgg;", "appLink", "appPkg", "appTip", "skip", "jumpUrl", "jumpTip", "source", "cmMark", PeakTaskDefine.AD_CB, "resourceId", "requestId", "ip", "isAd", "", "isAdLoc", InnerPushReceiverKt.KEY_EXTRA, "Lcom/google/gson/JsonObject;", "enableDoubleJump", "userCancelJumpUrl", "cancelJumpType", "markWithSkipStyle", "skipButtonHeightRatio", "", "cardIndex", "serverType", "index", "clickUrl", "showUrl", "encryption", "preLoadEnable", "backDownloadEnable", "interactType", "interactUrl", "interactDistance", "interactAngle", "splashGuideButton", "", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "elementAnimation", "Ltv/danmaku/bili/splash/ad/model/SplashElementAnimation;", "danmukus", "Ltv/danmaku/bili/splash/ad/model/SplashDanmaku;", "peakInfo", "Ltv/danmaku/bili/splash/ad/model/SplashPeakInfo;", "secondPage", "Ltv/danmaku/bili/splash/ad/model/SplashSecondPageInfo;", "secondPageShowStyle", "splashStoryInfo", "Ltv/danmaku/bili/splash/ad/model/SplashVideoInfo;", "keyword", "supportCalledUp", "middlePageInfo", "Ltv/danmaku/bili/splash/ad/model/SplashMiddlePageInfo;", "liveBookingId", "liveBookingTriggerType", "networkType", "localExposeCount", "isLocalExposed", "lastExposeTime", "isRealTimeSplash", "<init>", "(JJIIIIIJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILtv/danmaku/bili/splash/ad/model/SplashEgg;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZLcom/google/gson/JsonObject;ZLjava/lang/String;IIFJJJLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;IILjava/util/List;Ltv/danmaku/bili/splash/ad/model/SplashElementAnimation;Ljava/util/List;Ltv/danmaku/bili/splash/ad/model/SplashPeakInfo;Ltv/danmaku/bili/splash/ad/model/SplashSecondPageInfo;ILtv/danmaku/bili/splash/ad/model/SplashVideoInfo;Ljava/lang/String;ZLtv/danmaku/bili/splash/ad/model/SplashMiddlePageInfo;JLjava/util/List;Ljava/lang/String;IZJZ)V", "getId", "()J", "getSplashCreativeId", "getType", "()I", "getSplashType", "getTopViewType", "setTopViewType", "(I)V", "getTopViewLoc", "getCardType", "getDuration", "getBeginTime", "getEndTime", "getImageUrl", "()Ljava/lang/String;", "getImageHash", "getLogoUrl", "getLogoHash", "getVideoUrl", "getVideoHash", "getVideoWidth", "getVideoHeight", "getSplashEgg", "()Ltv/danmaku/bili/splash/ad/model/SplashEgg;", "getAppLink", "getAppPkg", "getAppTip", "getSkip", "getJumpUrl", "getJumpTip", "getSource", "getCmMark", "getAdCb", "setAdCb", "(Ljava/lang/String;)V", "getResourceId", "getRequestId", "setRequestId", "getIp", "()Z", NftCardJsBridgeCallHandler.GET_EXTRA, "()Lcom/google/gson/JsonObject;", "getEnableDoubleJump", "getUserCancelJumpUrl", "getCancelJumpType", "getMarkWithSkipStyle", "getSkipButtonHeightRatio", "()F", "getCardIndex", "getServerType", "getIndex", "getClickUrl", "getShowUrl", "getEncryption", "getPreLoadEnable", "getBackDownloadEnable", "getInteractType", "getInteractUrl", "getInteractDistance", "getInteractAngle", "getSplashGuideButton", "()Ljava/util/List;", "getElementAnimation", "()Ltv/danmaku/bili/splash/ad/model/SplashElementAnimation;", "getDanmukus", "getPeakInfo", "()Ltv/danmaku/bili/splash/ad/model/SplashPeakInfo;", "getSecondPage", "()Ltv/danmaku/bili/splash/ad/model/SplashSecondPageInfo;", "getSecondPageShowStyle", "getSplashStoryInfo", "()Ltv/danmaku/bili/splash/ad/model/SplashVideoInfo;", "getKeyword", "getSupportCalledUp", "getMiddlePageInfo", "()Ltv/danmaku/bili/splash/ad/model/SplashMiddlePageInfo;", "getLiveBookingId", "getLiveBookingTriggerType", "getNetworkType", "setNetworkType", "getLocalExposeCount", "setLocalExposeCount", "setLocalExposed", "(Z)V", "getLastExposeTime", "setLastExposeTime", "(J)V", "setRealTimeSplash", "runtimeExtra", "Ltv/danmaku/bili/splash/ad/model/SplashExtra;", "getRuntimeExtra", "()Ltv/danmaku/bili/splash/ad/model/SplashExtra;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "copy", "equals", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashOrder {
    public static final int $stable = 8;
    @SerializedName("ad_cb")
    private String adCb;
    @SerializedName("schema")
    private final String appLink;
    @SerializedName("schema_package_name")
    private final String appPkg;
    @SerializedName("schema_title")
    private final String appTip;
    @SerializedName("enable_background_download")
    private final boolean backDownloadEnable;
    @SerializedName("begin_time")
    private final long beginTime;
    @SerializedName("user_cancel_jump_type")
    private final int cancelJumpType;
    @SerializedName("card_index")
    private final long cardIndex;
    @SerializedName("card_type")
    private final int cardType;
    @SerializedName("click_url")
    private final String clickUrl;
    @SerializedName("cm_mark")
    private final int cmMark;
    @SerializedName("danmukus")
    private final List<SplashDanmaku> danmukus;
    @SerializedName("duration")
    private final long duration;
    @SerializedName("element_animation")
    private final SplashElementAnimation elementAnimation;
    @SerializedName("splash_enable_double_jump")
    private final boolean enableDoubleJump;
    @SerializedName("encryption")
    private final int encryption;
    @SerializedName("end_time")
    private final long endTime;
    @SerializedName(InnerPushReceiverKt.KEY_EXTRA)
    private final JsonObject extra;
    @SerializedName("id")
    private final long id;
    @SerializedName("hash")
    private final String imageHash;
    @SerializedName("thumb")
    private final String imageUrl;
    @SerializedName("index")
    private final long index;
    @SerializedName("interact_angle")
    private final int interactAngle;
    @SerializedName("interact_distance")
    private final int interactDistance;
    @SerializedName("interact_type")
    private final int interactType;
    @SerializedName("interact_url")
    private final String interactUrl;
    @SerializedName("client_ip")
    private final String ip;
    @SerializedName("is_ad")
    private final boolean isAd;
    @SerializedName("is_ad_loc")
    private final boolean isAdLoc;
    private boolean isLocalExposed;
    private boolean isRealTimeSplash;
    @SerializedName("uri_title")
    private final String jumpTip;
    @SerializedName(AudioIntentHelper.ARGS_URI)
    private final String jumpUrl;
    @SerializedName("keyword")
    private final String keyword;
    private long lastExposeTime;
    @SerializedName("live_booking_id")
    private final long liveBookingId;
    @SerializedName("live_booking_trigger_type")
    private final List<Integer> liveBookingTriggerType;
    private int localExposeCount;
    @SerializedName("logo_hash")
    private final String logoHash;
    @SerializedName("logo_url")
    private final String logoUrl;
    @SerializedName("mark_with_skip_style")
    private final int markWithSkipStyle;
    @SerializedName("middle_page_info")
    private final SplashMiddlePageInfo middlePageInfo;
    private String networkType;
    @SerializedName("peak_download")
    private final SplashPeakInfo peakInfo;
    @SerializedName("enable_pre_download")
    private final boolean preLoadEnable;
    @SerializedName("request_id")
    private String requestId;
    @SerializedName("resource_id")
    private final long resourceId;
    private final transient SplashExtra runtimeExtra;
    @SerializedName("second_page")
    private final SplashSecondPageInfo secondPage;
    @SerializedName("second_show_style")
    private final int secondPageShowStyle;
    @SerializedName("server_type")
    private final long serverType;
    @SerializedName("show_url")
    private final String showUrl;
    @SerializedName("skip")
    private final int skip;
    @SerializedName("skip_button_height")
    private final float skipButtonHeightRatio;
    @SerializedName("source")
    private final int source;
    @SerializedName("splash_creative_id")
    private final long splashCreativeId;
    @SerializedName("egg")
    private final SplashEgg splashEgg;
    @SerializedName("guide_button_list")
    private final List<SplashGuideButton> splashGuideButton;
    @SerializedName("story_info")
    private final SplashVideoInfo splashStoryInfo;
    @SerializedName("splash_type")
    private final int splashType;
    @SerializedName("support_called_up")
    private final boolean supportCalledUp;
    @SerializedName("top_view_loc")
    private final int topViewLoc;
    @SerializedName("top_view_type")
    private int topViewType;
    @SerializedName("type")
    private final int type;
    @SerializedName("user_cancel_jump_url")
    private final String userCancelJumpUrl;
    @SerializedName("video_hash")
    private final String videoHash;
    @SerializedName("video_height")
    private final int videoHeight;
    @SerializedName("video_url")
    private final String videoUrl;
    @SerializedName("video_width")
    private final int videoWidth;

    public SplashOrder() {
        this(0L, 0L, 0, 0, 0, 0, 0, 0L, 0L, 0L, null, null, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, 0, 0, null, 0L, null, null, false, false, null, false, null, 0, 0, 0.0f, 0L, 0L, 0L, null, null, 0, false, false, 0, null, 0, 0, null, null, null, null, null, 0, null, null, false, null, 0L, null, null, 0, false, 0L, false, -1, -1, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashOrder copy$default(SplashOrder splashOrder, long j, long j2, int i, int i2, int i3, int i4, int i5, long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6, int i6, int i7, SplashEgg splashEgg, String str7, String str8, String str9, int i8, String str10, String str11, int i9, int i10, String str12, long j6, String str13, String str14, boolean z, boolean z2, JsonObject jsonObject, boolean z3, String str15, int i11, int i12, float f, long j7, long j8, long j9, String str16, String str17, int i13, boolean z4, boolean z5, int i14, String str18, int i15, int i16, List list, SplashElementAnimation splashElementAnimation, List list2, SplashPeakInfo splashPeakInfo, SplashSecondPageInfo splashSecondPageInfo, int i17, SplashVideoInfo splashVideoInfo, String str19, boolean z6, SplashMiddlePageInfo splashMiddlePageInfo, long j10, List list3, String str20, int i18, boolean z7, long j11, boolean z8, int i19, int i20, int i21, Object obj) {
        long j12 = (i19 & 1) != 0 ? splashOrder.id : j;
        long j13 = (i19 & 2) != 0 ? splashOrder.splashCreativeId : j2;
        int i22 = (i19 & 4) != 0 ? splashOrder.type : i;
        int i23 = (i19 & 8) != 0 ? splashOrder.splashType : i2;
        int i24 = (i19 & 16) != 0 ? splashOrder.topViewType : i3;
        int i25 = (i19 & 32) != 0 ? splashOrder.topViewLoc : i4;
        int i26 = (i19 & 64) != 0 ? splashOrder.cardType : i5;
        long j14 = (i19 & BR.cover) != 0 ? splashOrder.duration : j3;
        long j15 = (i19 & BR.hallEnterHotText) != 0 ? splashOrder.beginTime : j4;
        long j16 = (i19 & BR.roleType) != 0 ? splashOrder.endTime : j5;
        String str21 = (i19 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? splashOrder.imageUrl : str;
        String str22 = (i19 & 2048) != 0 ? splashOrder.imageHash : str2;
        String str23 = (i19 & 4096) != 0 ? splashOrder.logoUrl : str3;
        String str24 = (i19 & 8192) != 0 ? splashOrder.logoHash : str4;
        String str25 = (i19 & RingBuffer.CONSUME_SIZE) != 0 ? splashOrder.videoUrl : str5;
        String str26 = (i19 & 32768) != 0 ? splashOrder.videoHash : str6;
        int i27 = (i19 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? splashOrder.videoWidth : i6;
        int i28 = (i19 & 131072) != 0 ? splashOrder.videoHeight : i7;
        SplashEgg splashEgg2 = (i19 & 262144) != 0 ? splashOrder.splashEgg : splashEgg;
        String str27 = (i19 & 524288) != 0 ? splashOrder.appLink : str7;
        String str28 = (i19 & 1048576) != 0 ? splashOrder.appPkg : str8;
        String str29 = (i19 & 2097152) != 0 ? splashOrder.appTip : str9;
        int i29 = (i19 & 4194304) != 0 ? splashOrder.skip : i8;
        String str30 = (i19 & 8388608) != 0 ? splashOrder.jumpUrl : str10;
        String str31 = (i19 & 16777216) != 0 ? splashOrder.jumpTip : str11;
        int i30 = (i19 & 33554432) != 0 ? splashOrder.source : i9;
        int i31 = (i19 & 67108864) != 0 ? splashOrder.cmMark : i10;
        String str32 = str21;
        String str33 = (i19 & 134217728) != 0 ? splashOrder.adCb : str12;
        long j17 = (i19 & 268435456) != 0 ? splashOrder.resourceId : j6;
        String str34 = (i19 & 536870912) != 0 ? splashOrder.requestId : str13;
        String str35 = (1073741824 & i19) != 0 ? splashOrder.ip : str14;
        boolean z9 = (i19 & Integer.MIN_VALUE) != 0 ? splashOrder.isAd : z;
        boolean z10 = (i20 & 1) != 0 ? splashOrder.isAdLoc : z2;
        JsonObject jsonObject2 = (i20 & 2) != 0 ? splashOrder.extra : jsonObject;
        boolean z11 = (i20 & 4) != 0 ? splashOrder.enableDoubleJump : z3;
        String str36 = (i20 & 8) != 0 ? splashOrder.userCancelJumpUrl : str15;
        int i32 = (i20 & 16) != 0 ? splashOrder.cancelJumpType : i11;
        int i33 = (i20 & 32) != 0 ? splashOrder.markWithSkipStyle : i12;
        float f2 = (i20 & 64) != 0 ? splashOrder.skipButtonHeightRatio : f;
        String str37 = str34;
        String str38 = str35;
        long j18 = (i20 & BR.cover) != 0 ? splashOrder.cardIndex : j7;
        long j19 = (i20 & BR.hallEnterHotText) != 0 ? splashOrder.serverType : j8;
        long j20 = (i20 & BR.roleType) != 0 ? splashOrder.index : j9;
        return splashOrder.copy(j12, j13, i22, i23, i24, i25, i26, j14, j15, j16, str32, str22, str23, str24, str25, str26, i27, i28, splashEgg2, str27, str28, str29, i29, str30, str31, i30, i31, str33, j17, str37, str38, z9, z10, jsonObject2, z11, str36, i32, i33, f2, j18, j19, j20, (i20 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? splashOrder.clickUrl : str16, (i20 & 2048) != 0 ? splashOrder.showUrl : str17, (i20 & 4096) != 0 ? splashOrder.encryption : i13, (i20 & 8192) != 0 ? splashOrder.preLoadEnable : z4, (i20 & RingBuffer.CONSUME_SIZE) != 0 ? splashOrder.backDownloadEnable : z5, (i20 & 32768) != 0 ? splashOrder.interactType : i14, (i20 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? splashOrder.interactUrl : str18, (i20 & 131072) != 0 ? splashOrder.interactDistance : i15, (i20 & 262144) != 0 ? splashOrder.interactAngle : i16, (i20 & 524288) != 0 ? splashOrder.splashGuideButton : list, (i20 & 1048576) != 0 ? splashOrder.elementAnimation : splashElementAnimation, (i20 & 2097152) != 0 ? splashOrder.danmukus : list2, (i20 & 4194304) != 0 ? splashOrder.peakInfo : splashPeakInfo, (i20 & 8388608) != 0 ? splashOrder.secondPage : splashSecondPageInfo, (i20 & 16777216) != 0 ? splashOrder.secondPageShowStyle : i17, (i20 & 33554432) != 0 ? splashOrder.splashStoryInfo : splashVideoInfo, (i20 & 67108864) != 0 ? splashOrder.keyword : str19, (i20 & 134217728) != 0 ? splashOrder.supportCalledUp : z6, (i20 & 268435456) != 0 ? splashOrder.middlePageInfo : splashMiddlePageInfo, (i20 & 536870912) != 0 ? splashOrder.liveBookingId : j10, (i20 & 1073741824) != 0 ? splashOrder.liveBookingTriggerType : list3, (i20 & Integer.MIN_VALUE) != 0 ? splashOrder.networkType : str20, (i21 & 1) != 0 ? splashOrder.localExposeCount : i18, (i21 & 2) != 0 ? splashOrder.isLocalExposed : z7, (i21 & 4) != 0 ? splashOrder.lastExposeTime : j11, (i21 & 8) != 0 ? splashOrder.isRealTimeSplash : z8);
    }

    public final long component1() {
        return this.id;
    }

    public final long component10() {
        return this.endTime;
    }

    public final String component11() {
        return this.imageUrl;
    }

    public final String component12() {
        return this.imageHash;
    }

    public final String component13() {
        return this.logoUrl;
    }

    public final String component14() {
        return this.logoHash;
    }

    public final String component15() {
        return this.videoUrl;
    }

    public final String component16() {
        return this.videoHash;
    }

    public final int component17() {
        return this.videoWidth;
    }

    public final int component18() {
        return this.videoHeight;
    }

    public final SplashEgg component19() {
        return this.splashEgg;
    }

    public final long component2() {
        return this.splashCreativeId;
    }

    public final String component20() {
        return this.appLink;
    }

    public final String component21() {
        return this.appPkg;
    }

    public final String component22() {
        return this.appTip;
    }

    public final int component23() {
        return this.skip;
    }

    public final String component24() {
        return this.jumpUrl;
    }

    public final String component25() {
        return this.jumpTip;
    }

    public final int component26() {
        return this.source;
    }

    public final int component27() {
        return this.cmMark;
    }

    public final String component28() {
        return this.adCb;
    }

    public final long component29() {
        return this.resourceId;
    }

    public final int component3() {
        return this.type;
    }

    public final String component30() {
        return this.requestId;
    }

    public final String component31() {
        return this.ip;
    }

    public final boolean component32() {
        return this.isAd;
    }

    public final boolean component33() {
        return this.isAdLoc;
    }

    public final JsonObject component34() {
        return this.extra;
    }

    public final boolean component35() {
        return this.enableDoubleJump;
    }

    public final String component36() {
        return this.userCancelJumpUrl;
    }

    public final int component37() {
        return this.cancelJumpType;
    }

    public final int component38() {
        return this.markWithSkipStyle;
    }

    public final float component39() {
        return this.skipButtonHeightRatio;
    }

    public final int component4() {
        return this.splashType;
    }

    public final long component40() {
        return this.cardIndex;
    }

    public final long component41() {
        return this.serverType;
    }

    public final long component42() {
        return this.index;
    }

    public final String component43() {
        return this.clickUrl;
    }

    public final String component44() {
        return this.showUrl;
    }

    public final int component45() {
        return this.encryption;
    }

    public final boolean component46() {
        return this.preLoadEnable;
    }

    public final boolean component47() {
        return this.backDownloadEnable;
    }

    public final int component48() {
        return this.interactType;
    }

    public final String component49() {
        return this.interactUrl;
    }

    public final int component5() {
        return this.topViewType;
    }

    public final int component50() {
        return this.interactDistance;
    }

    public final int component51() {
        return this.interactAngle;
    }

    public final List<SplashGuideButton> component52() {
        return this.splashGuideButton;
    }

    public final SplashElementAnimation component53() {
        return this.elementAnimation;
    }

    public final List<SplashDanmaku> component54() {
        return this.danmukus;
    }

    public final SplashPeakInfo component55() {
        return this.peakInfo;
    }

    public final SplashSecondPageInfo component56() {
        return this.secondPage;
    }

    public final int component57() {
        return this.secondPageShowStyle;
    }

    public final SplashVideoInfo component58() {
        return this.splashStoryInfo;
    }

    public final String component59() {
        return this.keyword;
    }

    public final int component6() {
        return this.topViewLoc;
    }

    public final boolean component60() {
        return this.supportCalledUp;
    }

    public final SplashMiddlePageInfo component61() {
        return this.middlePageInfo;
    }

    public final long component62() {
        return this.liveBookingId;
    }

    public final List<Integer> component63() {
        return this.liveBookingTriggerType;
    }

    public final String component64() {
        return this.networkType;
    }

    public final int component65() {
        return this.localExposeCount;
    }

    public final boolean component66() {
        return this.isLocalExposed;
    }

    public final long component67() {
        return this.lastExposeTime;
    }

    public final boolean component68() {
        return this.isRealTimeSplash;
    }

    public final int component7() {
        return this.cardType;
    }

    public final long component8() {
        return this.duration;
    }

    public final long component9() {
        return this.beginTime;
    }

    public final SplashOrder copy(long j, long j2, int i, int i2, int i3, int i4, int i5, long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6, int i6, int i7, SplashEgg splashEgg, String str7, String str8, String str9, int i8, String str10, String str11, int i9, int i10, String str12, long j6, String str13, String str14, boolean z, boolean z2, JsonObject jsonObject, boolean z3, String str15, int i11, int i12, float f, long j7, long j8, long j9, String str16, String str17, int i13, boolean z4, boolean z5, int i14, String str18, int i15, int i16, List<SplashGuideButton> list, SplashElementAnimation splashElementAnimation, List<SplashDanmaku> list2, SplashPeakInfo splashPeakInfo, SplashSecondPageInfo splashSecondPageInfo, int i17, SplashVideoInfo splashVideoInfo, String str19, boolean z6, SplashMiddlePageInfo splashMiddlePageInfo, long j10, List<Integer> list3, String str20, int i18, boolean z7, long j11, boolean z8) {
        return new SplashOrder(j, j2, i, i2, i3, i4, i5, j3, j4, j5, str, str2, str3, str4, str5, str6, i6, i7, splashEgg, str7, str8, str9, i8, str10, str11, i9, i10, str12, j6, str13, str14, z, z2, jsonObject, z3, str15, i11, i12, f, j7, j8, j9, str16, str17, i13, z4, z5, i14, str18, i15, i16, list, splashElementAnimation, list2, splashPeakInfo, splashSecondPageInfo, i17, splashVideoInfo, str19, z6, splashMiddlePageInfo, j10, list3, str20, i18, z7, j11, z8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashOrder) {
            SplashOrder splashOrder = (SplashOrder) obj;
            return this.id == splashOrder.id && this.splashCreativeId == splashOrder.splashCreativeId && this.type == splashOrder.type && this.splashType == splashOrder.splashType && this.topViewType == splashOrder.topViewType && this.topViewLoc == splashOrder.topViewLoc && this.cardType == splashOrder.cardType && this.duration == splashOrder.duration && this.beginTime == splashOrder.beginTime && this.endTime == splashOrder.endTime && Intrinsics.areEqual(this.imageUrl, splashOrder.imageUrl) && Intrinsics.areEqual(this.imageHash, splashOrder.imageHash) && Intrinsics.areEqual(this.logoUrl, splashOrder.logoUrl) && Intrinsics.areEqual(this.logoHash, splashOrder.logoHash) && Intrinsics.areEqual(this.videoUrl, splashOrder.videoUrl) && Intrinsics.areEqual(this.videoHash, splashOrder.videoHash) && this.videoWidth == splashOrder.videoWidth && this.videoHeight == splashOrder.videoHeight && Intrinsics.areEqual(this.splashEgg, splashOrder.splashEgg) && Intrinsics.areEqual(this.appLink, splashOrder.appLink) && Intrinsics.areEqual(this.appPkg, splashOrder.appPkg) && Intrinsics.areEqual(this.appTip, splashOrder.appTip) && this.skip == splashOrder.skip && Intrinsics.areEqual(this.jumpUrl, splashOrder.jumpUrl) && Intrinsics.areEqual(this.jumpTip, splashOrder.jumpTip) && this.source == splashOrder.source && this.cmMark == splashOrder.cmMark && Intrinsics.areEqual(this.adCb, splashOrder.adCb) && this.resourceId == splashOrder.resourceId && Intrinsics.areEqual(this.requestId, splashOrder.requestId) && Intrinsics.areEqual(this.ip, splashOrder.ip) && this.isAd == splashOrder.isAd && this.isAdLoc == splashOrder.isAdLoc && Intrinsics.areEqual(this.extra, splashOrder.extra) && this.enableDoubleJump == splashOrder.enableDoubleJump && Intrinsics.areEqual(this.userCancelJumpUrl, splashOrder.userCancelJumpUrl) && this.cancelJumpType == splashOrder.cancelJumpType && this.markWithSkipStyle == splashOrder.markWithSkipStyle && Float.compare(this.skipButtonHeightRatio, splashOrder.skipButtonHeightRatio) == 0 && this.cardIndex == splashOrder.cardIndex && this.serverType == splashOrder.serverType && this.index == splashOrder.index && Intrinsics.areEqual(this.clickUrl, splashOrder.clickUrl) && Intrinsics.areEqual(this.showUrl, splashOrder.showUrl) && this.encryption == splashOrder.encryption && this.preLoadEnable == splashOrder.preLoadEnable && this.backDownloadEnable == splashOrder.backDownloadEnable && this.interactType == splashOrder.interactType && Intrinsics.areEqual(this.interactUrl, splashOrder.interactUrl) && this.interactDistance == splashOrder.interactDistance && this.interactAngle == splashOrder.interactAngle && Intrinsics.areEqual(this.splashGuideButton, splashOrder.splashGuideButton) && Intrinsics.areEqual(this.elementAnimation, splashOrder.elementAnimation) && Intrinsics.areEqual(this.danmukus, splashOrder.danmukus) && Intrinsics.areEqual(this.peakInfo, splashOrder.peakInfo) && Intrinsics.areEqual(this.secondPage, splashOrder.secondPage) && this.secondPageShowStyle == splashOrder.secondPageShowStyle && Intrinsics.areEqual(this.splashStoryInfo, splashOrder.splashStoryInfo) && Intrinsics.areEqual(this.keyword, splashOrder.keyword) && this.supportCalledUp == splashOrder.supportCalledUp && Intrinsics.areEqual(this.middlePageInfo, splashOrder.middlePageInfo) && this.liveBookingId == splashOrder.liveBookingId && Intrinsics.areEqual(this.liveBookingTriggerType, splashOrder.liveBookingTriggerType) && Intrinsics.areEqual(this.networkType, splashOrder.networkType) && this.localExposeCount == splashOrder.localExposeCount && this.isLocalExposed == splashOrder.isLocalExposed && this.lastExposeTime == splashOrder.lastExposeTime && this.isRealTimeSplash == splashOrder.isRealTimeSplash;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.splashCreativeId)) * 31) + this.type) * 31) + this.splashType) * 31) + this.topViewType) * 31) + this.topViewLoc) * 31) + this.cardType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.beginTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.endTime)) * 31) + (this.imageUrl == null ? 0 : this.imageUrl.hashCode())) * 31) + (this.imageHash == null ? 0 : this.imageHash.hashCode())) * 31) + (this.logoUrl == null ? 0 : this.logoUrl.hashCode())) * 31) + (this.logoHash == null ? 0 : this.logoHash.hashCode())) * 31) + (this.videoUrl == null ? 0 : this.videoUrl.hashCode())) * 31) + (this.videoHash == null ? 0 : this.videoHash.hashCode())) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31) + (this.splashEgg == null ? 0 : this.splashEgg.hashCode())) * 31) + (this.appLink == null ? 0 : this.appLink.hashCode())) * 31) + (this.appPkg == null ? 0 : this.appPkg.hashCode())) * 31) + (this.appTip == null ? 0 : this.appTip.hashCode())) * 31) + this.skip) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.jumpTip == null ? 0 : this.jumpTip.hashCode())) * 31) + this.source) * 31) + this.cmMark) * 31) + (this.adCb == null ? 0 : this.adCb.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.resourceId)) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + (this.ip == null ? 0 : this.ip.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAd)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAdLoc)) * 31) + (this.extra == null ? 0 : this.extra.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableDoubleJump)) * 31) + (this.userCancelJumpUrl == null ? 0 : this.userCancelJumpUrl.hashCode())) * 31) + this.cancelJumpType) * 31) + this.markWithSkipStyle) * 31) + Float.floatToIntBits(this.skipButtonHeightRatio)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardIndex)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.serverType)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.index)) * 31) + (this.clickUrl == null ? 0 : this.clickUrl.hashCode())) * 31) + (this.showUrl == null ? 0 : this.showUrl.hashCode())) * 31) + this.encryption) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.preLoadEnable)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.backDownloadEnable)) * 31) + this.interactType) * 31) + (this.interactUrl == null ? 0 : this.interactUrl.hashCode())) * 31) + this.interactDistance) * 31) + this.interactAngle) * 31) + (this.splashGuideButton == null ? 0 : this.splashGuideButton.hashCode())) * 31) + (this.elementAnimation == null ? 0 : this.elementAnimation.hashCode())) * 31) + (this.danmukus == null ? 0 : this.danmukus.hashCode())) * 31) + (this.peakInfo == null ? 0 : this.peakInfo.hashCode())) * 31) + (this.secondPage == null ? 0 : this.secondPage.hashCode())) * 31) + this.secondPageShowStyle) * 31) + (this.splashStoryInfo == null ? 0 : this.splashStoryInfo.hashCode())) * 31) + (this.keyword == null ? 0 : this.keyword.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.supportCalledUp)) * 31) + (this.middlePageInfo == null ? 0 : this.middlePageInfo.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.liveBookingId)) * 31) + (this.liveBookingTriggerType == null ? 0 : this.liveBookingTriggerType.hashCode())) * 31) + (this.networkType != null ? this.networkType.hashCode() : 0)) * 31) + this.localExposeCount) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLocalExposed)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lastExposeTime)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRealTimeSplash);
    }

    public String toString() {
        long j = this.id;
        long j2 = this.splashCreativeId;
        int i = this.type;
        int i2 = this.splashType;
        int i3 = this.topViewType;
        int i4 = this.topViewLoc;
        int i5 = this.cardType;
        long j3 = this.duration;
        long j4 = this.beginTime;
        long j5 = this.endTime;
        String str = this.imageUrl;
        String str2 = this.imageHash;
        String str3 = this.logoUrl;
        String str4 = this.logoHash;
        String str5 = this.videoUrl;
        String str6 = this.videoHash;
        int i6 = this.videoWidth;
        int i7 = this.videoHeight;
        SplashEgg splashEgg = this.splashEgg;
        String str7 = this.appLink;
        String str8 = this.appPkg;
        String str9 = this.appTip;
        int i8 = this.skip;
        String str10 = this.jumpUrl;
        String str11 = this.jumpTip;
        int i9 = this.source;
        int i10 = this.cmMark;
        String str12 = this.adCb;
        long j6 = this.resourceId;
        String str13 = this.requestId;
        String str14 = this.ip;
        boolean z = this.isAd;
        boolean z2 = this.isAdLoc;
        JsonObject jsonObject = this.extra;
        boolean z3 = this.enableDoubleJump;
        String str15 = this.userCancelJumpUrl;
        int i11 = this.cancelJumpType;
        int i12 = this.markWithSkipStyle;
        float f = this.skipButtonHeightRatio;
        long j7 = this.cardIndex;
        long j8 = this.serverType;
        long j9 = this.index;
        String str16 = this.clickUrl;
        String str17 = this.showUrl;
        int i13 = this.encryption;
        boolean z4 = this.preLoadEnable;
        boolean z5 = this.backDownloadEnable;
        int i14 = this.interactType;
        String str18 = this.interactUrl;
        int i15 = this.interactDistance;
        int i16 = this.interactAngle;
        List<SplashGuideButton> list = this.splashGuideButton;
        SplashElementAnimation splashElementAnimation = this.elementAnimation;
        List<SplashDanmaku> list2 = this.danmukus;
        SplashPeakInfo splashPeakInfo = this.peakInfo;
        SplashSecondPageInfo splashSecondPageInfo = this.secondPage;
        int i17 = this.secondPageShowStyle;
        SplashVideoInfo splashVideoInfo = this.splashStoryInfo;
        String str19 = this.keyword;
        boolean z6 = this.supportCalledUp;
        SplashMiddlePageInfo splashMiddlePageInfo = this.middlePageInfo;
        long j10 = this.liveBookingId;
        List<Integer> list3 = this.liveBookingTriggerType;
        String str20 = this.networkType;
        int i18 = this.localExposeCount;
        boolean z7 = this.isLocalExposed;
        long j11 = this.lastExposeTime;
        return "SplashOrder(id=" + j + ", splashCreativeId=" + j2 + ", type=" + i + ", splashType=" + i2 + ", topViewType=" + i3 + ", topViewLoc=" + i4 + ", cardType=" + i5 + ", duration=" + j3 + ", beginTime=" + j4 + ", endTime=" + j5 + ", imageUrl=" + str + ", imageHash=" + str2 + ", logoUrl=" + str3 + ", logoHash=" + str4 + ", videoUrl=" + str5 + ", videoHash=" + str6 + ", videoWidth=" + i6 + ", videoHeight=" + i7 + ", splashEgg=" + splashEgg + ", appLink=" + str7 + ", appPkg=" + str8 + ", appTip=" + str9 + ", skip=" + i8 + ", jumpUrl=" + str10 + ", jumpTip=" + str11 + ", source=" + i9 + ", cmMark=" + i10 + ", adCb=" + str12 + ", resourceId=" + j6 + ", requestId=" + str13 + ", ip=" + str14 + ", isAd=" + z + ", isAdLoc=" + z2 + ", extra=" + jsonObject + ", enableDoubleJump=" + z3 + ", userCancelJumpUrl=" + str15 + ", cancelJumpType=" + i11 + ", markWithSkipStyle=" + i12 + ", skipButtonHeightRatio=" + f + ", cardIndex=" + j7 + ", serverType=" + j8 + ", index=" + j9 + ", clickUrl=" + str16 + ", showUrl=" + str17 + ", encryption=" + i13 + ", preLoadEnable=" + z4 + ", backDownloadEnable=" + z5 + ", interactType=" + i14 + ", interactUrl=" + str18 + ", interactDistance=" + i15 + ", interactAngle=" + i16 + ", splashGuideButton=" + list + ", elementAnimation=" + splashElementAnimation + ", danmukus=" + list2 + ", peakInfo=" + splashPeakInfo + ", secondPage=" + splashSecondPageInfo + ", secondPageShowStyle=" + i17 + ", splashStoryInfo=" + splashVideoInfo + ", keyword=" + str19 + ", supportCalledUp=" + z6 + ", middlePageInfo=" + splashMiddlePageInfo + ", liveBookingId=" + j10 + ", liveBookingTriggerType=" + list3 + ", networkType=" + str20 + ", localExposeCount=" + i18 + ", isLocalExposed=" + z7 + ", lastExposeTime=" + j11 + ", isRealTimeSplash=" + this.isRealTimeSplash + ")";
    }

    public SplashOrder(long id, long splashCreativeId, int type, int splashType, int topViewType, int topViewLoc, int cardType, long duration, long beginTime, long endTime, String imageUrl, String imageHash, String logoUrl, String logoHash, String videoUrl, String videoHash, int videoWidth, int videoHeight, SplashEgg splashEgg, String appLink, String appPkg, String appTip, int skip, String jumpUrl, String jumpTip, int source, int cmMark, String adCb, long resourceId, String requestId, String ip, boolean isAd, boolean isAdLoc, JsonObject extra, boolean enableDoubleJump, String userCancelJumpUrl, int cancelJumpType, int markWithSkipStyle, float skipButtonHeightRatio, long cardIndex, long serverType, long index, String clickUrl, String showUrl, int encryption, boolean preLoadEnable, boolean backDownloadEnable, int interactType, String interactUrl, int interactDistance, int interactAngle, List<SplashGuideButton> list, SplashElementAnimation elementAnimation, List<SplashDanmaku> list2, SplashPeakInfo peakInfo, SplashSecondPageInfo secondPage, int secondPageShowStyle, SplashVideoInfo splashStoryInfo, String keyword, boolean supportCalledUp, SplashMiddlePageInfo middlePageInfo, long liveBookingId, List<Integer> list3, String networkType, int localExposeCount, boolean isLocalExposed, long lastExposeTime, boolean isRealTimeSplash) {
        this.id = id;
        this.splashCreativeId = splashCreativeId;
        this.type = type;
        this.splashType = splashType;
        this.topViewType = topViewType;
        this.topViewLoc = topViewLoc;
        this.cardType = cardType;
        this.duration = duration;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.imageUrl = imageUrl;
        this.imageHash = imageHash;
        this.logoUrl = logoUrl;
        this.logoHash = logoHash;
        this.videoUrl = videoUrl;
        this.videoHash = videoHash;
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        this.splashEgg = splashEgg;
        this.appLink = appLink;
        this.appPkg = appPkg;
        this.appTip = appTip;
        this.skip = skip;
        this.jumpUrl = jumpUrl;
        this.jumpTip = jumpTip;
        this.source = source;
        this.cmMark = cmMark;
        this.adCb = adCb;
        this.resourceId = resourceId;
        this.requestId = requestId;
        this.ip = ip;
        this.isAd = isAd;
        this.isAdLoc = isAdLoc;
        this.extra = extra;
        this.enableDoubleJump = enableDoubleJump;
        this.userCancelJumpUrl = userCancelJumpUrl;
        this.cancelJumpType = cancelJumpType;
        this.markWithSkipStyle = markWithSkipStyle;
        this.skipButtonHeightRatio = skipButtonHeightRatio;
        this.cardIndex = cardIndex;
        this.serverType = serverType;
        this.index = index;
        this.clickUrl = clickUrl;
        this.showUrl = showUrl;
        this.encryption = encryption;
        this.preLoadEnable = preLoadEnable;
        this.backDownloadEnable = backDownloadEnable;
        this.interactType = interactType;
        this.interactUrl = interactUrl;
        this.interactDistance = interactDistance;
        this.interactAngle = interactAngle;
        this.splashGuideButton = list;
        this.elementAnimation = elementAnimation;
        this.danmukus = list2;
        this.peakInfo = peakInfo;
        this.secondPage = secondPage;
        this.secondPageShowStyle = secondPageShowStyle;
        this.splashStoryInfo = splashStoryInfo;
        this.keyword = keyword;
        this.supportCalledUp = supportCalledUp;
        this.middlePageInfo = middlePageInfo;
        this.liveBookingId = liveBookingId;
        this.liveBookingTriggerType = list3;
        this.networkType = networkType;
        this.localExposeCount = localExposeCount;
        this.isLocalExposed = isLocalExposed;
        this.lastExposeTime = lastExposeTime;
        this.isRealTimeSplash = isRealTimeSplash;
        this.runtimeExtra = new SplashExtra();
    }

    public /* synthetic */ SplashOrder(long j, long j2, int i, int i2, int i3, int i4, int i5, long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6, int i6, int i7, SplashEgg splashEgg, String str7, String str8, String str9, int i8, String str10, String str11, int i9, int i10, String str12, long j6, String str13, String str14, boolean z, boolean z2, JsonObject jsonObject, boolean z3, String str15, int i11, int i12, float f, long j7, long j8, long j9, String str16, String str17, int i13, boolean z4, boolean z5, int i14, String str18, int i15, int i16, List list, SplashElementAnimation splashElementAnimation, List list2, SplashPeakInfo splashPeakInfo, SplashSecondPageInfo splashSecondPageInfo, int i17, SplashVideoInfo splashVideoInfo, String str19, boolean z6, SplashMiddlePageInfo splashMiddlePageInfo, long j10, List list3, String str20, int i18, boolean z7, long j11, boolean z8, int i19, int i20, int i21, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0L : j, (i19 & 2) != 0 ? 0L : j2, (i19 & 4) != 0 ? 0 : i, (i19 & 8) != 0 ? 0 : i2, (i19 & 16) != 0 ? 0 : i3, (i19 & 32) != 0 ? 0 : i4, (i19 & 64) != 0 ? 0 : i5, (i19 & BR.cover) != 0 ? 0L : j3, (i19 & BR.hallEnterHotText) != 0 ? 0L : j4, (i19 & BR.roleType) != 0 ? 0L : j5, (i19 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? null : str, (i19 & 2048) != 0 ? null : str2, (i19 & 4096) != 0 ? null : str3, (i19 & 8192) != 0 ? null : str4, (i19 & RingBuffer.CONSUME_SIZE) != 0 ? null : str5, (i19 & 32768) != 0 ? null : str6, (i19 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? 0 : i6, (i19 & 131072) != 0 ? 0 : i7, (i19 & 262144) != 0 ? null : splashEgg, (i19 & 524288) != 0 ? null : str7, (i19 & 1048576) != 0 ? null : str8, (i19 & 2097152) != 0 ? null : str9, (i19 & 4194304) != 0 ? 0 : i8, (i19 & 8388608) != 0 ? null : str10, (i19 & 16777216) != 0 ? null : str11, (i19 & 33554432) != 0 ? 0 : i9, (i19 & 67108864) != 0 ? 0 : i10, (i19 & 134217728) != 0 ? null : str12, (i19 & 268435456) != 0 ? 0L : j6, (i19 & 536870912) != 0 ? null : str13, (i19 & 1073741824) != 0 ? null : str14, (i19 & Integer.MIN_VALUE) != 0 ? false : z, (i20 & 1) != 0 ? false : z2, (i20 & 2) != 0 ? null : jsonObject, (i20 & 4) != 0 ? false : z3, (i20 & 8) != 0 ? null : str15, (i20 & 16) != 0 ? 0 : i11, (i20 & 32) != 0 ? 0 : i12, (i20 & 64) != 0 ? 0.0f : f, (i20 & BR.cover) != 0 ? -1L : j7, (i20 & BR.hallEnterHotText) != 0 ? -1L : j8, (i20 & BR.roleType) != 0 ? 0L : j9, (i20 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? null : str16, (i20 & 2048) != 0 ? null : str17, (i20 & 4096) != 0 ? 0 : i13, (i20 & 8192) != 0 ? false : z4, (i20 & RingBuffer.CONSUME_SIZE) != 0 ? false : z5, (i20 & 32768) != 0 ? 0 : i14, (i20 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? null : str18, (i20 & 131072) != 0 ? 0 : i15, (i20 & 262144) != 0 ? 0 : i16, (i20 & 524288) != 0 ? null : list, (i20 & 1048576) != 0 ? null : splashElementAnimation, (i20 & 2097152) != 0 ? null : list2, (i20 & 4194304) != 0 ? null : splashPeakInfo, (i20 & 8388608) != 0 ? null : splashSecondPageInfo, (i20 & 16777216) != 0 ? 0 : i17, (i20 & 33554432) != 0 ? null : splashVideoInfo, (i20 & 67108864) != 0 ? null : str19, (i20 & 134217728) != 0 ? false : z6, (i20 & 268435456) != 0 ? null : splashMiddlePageInfo, (i20 & 536870912) != 0 ? 0L : j10, (i20 & 1073741824) != 0 ? null : list3, (i20 & Integer.MIN_VALUE) == 0 ? str20 : null, (i21 & 1) != 0 ? 0 : i18, (i21 & 2) != 0 ? false : z7, (i21 & 4) != 0 ? 0L : j11, (i21 & 8) != 0 ? false : z8);
    }

    public final long getId() {
        return this.id;
    }

    public final long getSplashCreativeId() {
        return this.splashCreativeId;
    }

    public final int getType() {
        return this.type;
    }

    public final int getSplashType() {
        return this.splashType;
    }

    public final int getTopViewType() {
        return this.topViewType;
    }

    public final void setTopViewType(int i) {
        this.topViewType = i;
    }

    public final int getTopViewLoc() {
        return this.topViewLoc;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getImageHash() {
        return this.imageHash;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getLogoHash() {
        return this.logoHash;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getVideoHash() {
        return this.videoHash;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final SplashEgg getSplashEgg() {
        return this.splashEgg;
    }

    public final String getAppLink() {
        return this.appLink;
    }

    public final String getAppPkg() {
        return this.appPkg;
    }

    public final String getAppTip() {
        return this.appTip;
    }

    public final int getSkip() {
        return this.skip;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getJumpTip() {
        return this.jumpTip;
    }

    public final int getSource() {
        return this.source;
    }

    public final int getCmMark() {
        return this.cmMark;
    }

    public final String getAdCb() {
        return this.adCb;
    }

    public final void setAdCb(String str) {
        this.adCb = str;
    }

    public final long getResourceId() {
        return this.resourceId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final String getIp() {
        return this.ip;
    }

    public final boolean isAd() {
        return this.isAd;
    }

    public final boolean isAdLoc() {
        return this.isAdLoc;
    }

    public final JsonObject getExtra() {
        return this.extra;
    }

    public final boolean getEnableDoubleJump() {
        return this.enableDoubleJump;
    }

    public final String getUserCancelJumpUrl() {
        return this.userCancelJumpUrl;
    }

    public final int getCancelJumpType() {
        return this.cancelJumpType;
    }

    public final int getMarkWithSkipStyle() {
        return this.markWithSkipStyle;
    }

    public final float getSkipButtonHeightRatio() {
        return this.skipButtonHeightRatio;
    }

    public final long getCardIndex() {
        return this.cardIndex;
    }

    public final long getServerType() {
        return this.serverType;
    }

    public final long getIndex() {
        return this.index;
    }

    public final String getClickUrl() {
        return this.clickUrl;
    }

    public final String getShowUrl() {
        return this.showUrl;
    }

    public final int getEncryption() {
        return this.encryption;
    }

    public final boolean getPreLoadEnable() {
        return this.preLoadEnable;
    }

    public final boolean getBackDownloadEnable() {
        return this.backDownloadEnable;
    }

    public final int getInteractType() {
        return this.interactType;
    }

    public final String getInteractUrl() {
        return this.interactUrl;
    }

    public final int getInteractDistance() {
        return this.interactDistance;
    }

    public final int getInteractAngle() {
        return this.interactAngle;
    }

    public final List<SplashGuideButton> getSplashGuideButton() {
        return this.splashGuideButton;
    }

    public final SplashElementAnimation getElementAnimation() {
        return this.elementAnimation;
    }

    public final List<SplashDanmaku> getDanmukus() {
        return this.danmukus;
    }

    public final SplashPeakInfo getPeakInfo() {
        return this.peakInfo;
    }

    public final SplashSecondPageInfo getSecondPage() {
        return this.secondPage;
    }

    public final int getSecondPageShowStyle() {
        return this.secondPageShowStyle;
    }

    public final SplashVideoInfo getSplashStoryInfo() {
        return this.splashStoryInfo;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final boolean getSupportCalledUp() {
        return this.supportCalledUp;
    }

    public final SplashMiddlePageInfo getMiddlePageInfo() {
        return this.middlePageInfo;
    }

    public final long getLiveBookingId() {
        return this.liveBookingId;
    }

    public final List<Integer> getLiveBookingTriggerType() {
        return this.liveBookingTriggerType;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final void setNetworkType(String str) {
        this.networkType = str;
    }

    public final int getLocalExposeCount() {
        return this.localExposeCount;
    }

    public final void setLocalExposeCount(int i) {
        this.localExposeCount = i;
    }

    public final boolean isLocalExposed() {
        return this.isLocalExposed;
    }

    public final void setLocalExposed(boolean z) {
        this.isLocalExposed = z;
    }

    public final long getLastExposeTime() {
        return this.lastExposeTime;
    }

    public final void setLastExposeTime(long j) {
        this.lastExposeTime = j;
    }

    public final boolean isRealTimeSplash() {
        return this.isRealTimeSplash;
    }

    public final void setRealTimeSplash(boolean z) {
        this.isRealTimeSplash = z;
    }

    public final SplashExtra getRuntimeExtra() {
        return this.runtimeExtra;
    }
}