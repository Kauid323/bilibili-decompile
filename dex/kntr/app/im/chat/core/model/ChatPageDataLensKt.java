package kntr.app.im.chat.core.model;

import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.base.IMRouteHolder;
import im.base.IMToast;
import im.base.model.SessionId;
import java.util.List;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.track.ChatPageTechTrack;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.aphro.ui.preview.model.PreviewImageData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPageDataLens.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\",\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"0\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\",\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\",\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"*\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0005\u001a\u0004\b%\u0010\u0007\"*\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007\"*\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007\"0\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007\"*\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002050\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0005\u001a\u0004\b7\u0010\u0007\",\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001090\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0005\u001a\u0004\b;\u0010\u0007\",\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010=0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0005\u001a\u0004\b?\u0010\u0007\",\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010A0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0005\u001a\u0004\bC\u0010\u0007\"*\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020E0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0005\u001a\u0004\bG\u0010\u0007\"*\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020I0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0005\u001a\u0004\bK\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010N\u001a\u0004\b\u000b\u0010O\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010N\u001a\u0004\b\u000f\u0010O\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010N\u001a\u0004\b\u0013\u0010O\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010N\u001a\u0004\b\u0017\u0010O\"F\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002HL\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010N\u001a\u0004\b\u001c\u0010O\"B\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010N\u001a\u0004\b \u0010O\"B\u0010!\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010N\u001a\u0004\b$\u0010O\"@\u0010%\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020&0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010N\u001a\u0004\b%\u0010O\"@\u0010(\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020)0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010N\u001a\u0004\b+\u0010O\"@\u0010,\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020-0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010N\u001a\u0004\b/\u0010O\"F\u00100\u001a\u0014\u0012\u0004\u0012\u0002HL\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00190\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010N\u001a\u0004\b3\u0010O\"@\u00104\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u0002050\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010N\u001a\u0004\b7\u0010O\"B\u00108\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u0001090\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010N\u001a\u0004\b;\u0010O\"B\u0010<\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010=0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010N\u001a\u0004\b?\u0010O\"B\u0010@\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010A0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010N\u001a\u0004\bC\u0010O\"@\u0010D\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020E0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010N\u001a\u0004\bG\u0010O\"@\u0010H\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020I0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010N\u001a\u0004\bK\u0010O\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\t0P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010N\u001a\u0004\bR\u0010S\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\r0P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bT\u0010N\u001a\u0004\bU\u0010S\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00110P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bV\u0010N\u001a\u0004\bW\u0010S\"D\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010N\u001a\u0004\bY\u0010O\"H\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002HL\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010N\u001a\u0004\b[\u0010S\"D\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\\\u0010N\u001a\u0004\b]\u0010O\"D\u0010!\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b^\u0010N\u001a\u0004\b_\u0010O\"B\u0010%\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020&0P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b`\u0010N\u001a\u0004\ba\u0010S\"B\u0010(\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020)0P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bb\u0010N\u001a\u0004\bc\u0010S\"B\u0010,\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020-0P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010N\u001a\u0004\be\u0010S\"H\u00100\u001a\u0014\u0012\u0004\u0012\u0002HL\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00190P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bf\u0010N\u001a\u0004\bg\u0010S\"B\u00104\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u0002050P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bh\u0010N\u001a\u0004\bi\u0010S\"D\u00108\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u0001090\u0001\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bj\u0010N\u001a\u0004\bk\u0010O\"D\u0010<\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010=0\u0001\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bl\u0010N\u001a\u0004\bm\u0010O\"D\u0010@\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010A0\u0001\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bn\u0010N\u001a\u0004\bo\u0010O\"B\u0010D\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020E0P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bp\u0010N\u001a\u0004\bq\u0010S\"B\u0010H\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020I0P\"\b\b\u0000\u0010L*\u00020M*\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\br\u0010N\u001a\u0004\bs\u0010S\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\t0P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010t\u001a\u0004\b\u000b\u0010u\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\r0P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010t\u001a\u0004\b\u000f\u0010u\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00110P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010t\u001a\u0004\b\u0013\u0010u\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010t\u001a\u0004\b\u0017\u0010v\"F\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002HL\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010t\u001a\u0004\b\u001c\u0010u\"B\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010t\u001a\u0004\b \u0010v\"B\u0010!\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010t\u001a\u0004\b$\u0010v\"@\u0010%\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020&0P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010t\u001a\u0004\b%\u0010u\"@\u0010(\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020)0P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010t\u001a\u0004\b+\u0010u\"@\u0010,\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020-0P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010t\u001a\u0004\b/\u0010u\"F\u00100\u001a\u0014\u0012\u0004\u0012\u0002HL\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00190P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010t\u001a\u0004\b3\u0010u\"@\u00104\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u0002050P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010t\u001a\u0004\b7\u0010u\"B\u00108\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u0001090\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010t\u001a\u0004\b;\u0010v\"B\u0010<\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010=0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010t\u001a\u0004\b?\u0010v\"B\u0010@\u001a\u0010\u0012\u0004\u0012\u0002HL\u0012\u0006\u0012\u0004\u0018\u00010A0\u0001\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010t\u001a\u0004\bC\u0010v\"@\u0010D\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020E0P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010t\u001a\u0004\bG\u0010u\"@\u0010H\u001a\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020I0P\"\b\b\u0000\u0010L*\u00020M*\u000e\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u00020\u00020P8FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010t\u001a\u0004\bK\u0010u¨\u0006w"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatPageData$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/ChatPageData$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/ChatPageData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionId", "Lim/base/model/SessionId;", "getSessionId$annotations", "getSessionId", "hostMid", RoomRecommendViewModel.EMPTY_CURSOR, "getHostMid$annotations", "getHostMid", "pageStatus", "Lkntr/app/im/chat/core/model/PageStatus;", "getPageStatus$annotations", "getPageStatus", "chatInfo", "Lkntr/app/im/chat/core/model/ChatInfo;", "getChatInfo$annotations", "getChatInfo", "messageGroups", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageGroup;", "getMessageGroups$annotations", "getMessageGroups", "toast", "Lim/base/IMToast;", "getToast$annotations", "getToast", "previewImageData", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewImageData;", "getPreviewImageData$annotations", "getPreviewImageData", "isShowStickerEditPage", RoomRecommendViewModel.EMPTY_CURSOR, "isShowStickerEditPage$annotations", "route", "Lim/base/IMRouteHolder;", "getRoute$annotations", "getRoute", "upgradeAnswerDialogStatus", "Lkntr/app/im/chat/core/model/ChatUpgradeAnswerDialogStatus;", "getUpgradeAnswerDialogStatus$annotations", "getUpgradeAnswerDialogStatus", "pendingMsgForUpdate", "Lkntr/app/im/chat/core/model/MessageId;", "getPendingMsgForUpdate$annotations", "getPendingMsgForUpdate", "inputBoxSelectState", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "getInputBoxSelectState$annotations", "getInputBoxSelectState", "deletingMsg", "Lkntr/app/im/chat/core/model/EntityMessage;", "getDeletingMsg$annotations", "getDeletingMsg", "displayingBehaviorAlert", "Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;", "getDisplayingBehaviorAlert$annotations", "getDisplayingBehaviorAlert", "currentFetchResult", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "getCurrentFetchResult$annotations", "getCurrentFetchResult", "inputContent", "Lkntr/app/im/chat/core/model/InputContent;", "getInputContent$annotations", "getInputContent", "track", "Lkntr/app/im/chat/core/model/track/ChatPageTechTrack;", "getTrack$annotations", "getTrack", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "sessionIdNullable$annotations", "sessionIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "hostMidNullable$annotations", "hostMidNullable", "pageStatusNullable$annotations", "pageStatusNullable", "chatInfoNullable$annotations", "chatInfoNullable", "messageGroupsNullable$annotations", "messageGroupsNullable", "toastNullable$annotations", "toastNullable", "previewImageDataNullable$annotations", "previewImageDataNullable", "isShowStickerEditPageNullable$annotations", "isShowStickerEditPageNullable", "routeNullable$annotations", "routeNullable", "upgradeAnswerDialogStatusNullable$annotations", "upgradeAnswerDialogStatusNullable", "pendingMsgForUpdateNullable$annotations", "pendingMsgForUpdateNullable", "inputBoxSelectStateNullable$annotations", "inputBoxSelectStateNullable", "deletingMsgNullable$annotations", "deletingMsgNullable", "displayingBehaviorAlertNullable$annotations", "displayingBehaviorAlertNullable", "currentFetchResultNullable$annotations", "currentFetchResultNullable", "inputContentNullable$annotations", "inputContentNullable", "trackNullable$annotations", "trackNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatPageDataLensKt {
    public static /* synthetic */ void chatInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void currentFetchResultNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void deletingMsgNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void displayingBehaviorAlertNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfo$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getCurrentFetchResult$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCurrentFetchResult$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCurrentFetchResult$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getDeletingMsg$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDeletingMsg$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDeletingMsg$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getDisplayingBehaviorAlert$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDisplayingBehaviorAlert$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDisplayingBehaviorAlert$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getHostMid$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHostMid$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHostMid$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getInputBoxSelectState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputBoxSelectState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputBoxSelectState$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getInputContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputContent$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getMessageGroups$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMessageGroups$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMessageGroups$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getPendingMsgForUpdate$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPendingMsgForUpdate$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPendingMsgForUpdate$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getPreviewImageData$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPreviewImageData$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPreviewImageData$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getRoute$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRoute$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRoute$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getTrack$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTrack$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTrack$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void getUpgradeAnswerDialogStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUpgradeAnswerDialogStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUpgradeAnswerDialogStatus$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void hostMidNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void inputBoxSelectStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void inputContentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isShowStickerEditPage$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isShowStickerEditPage$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isShowStickerEditPage$annotations(ChatPageData.Companion companion) {
    }

    public static /* synthetic */ void isShowStickerEditPageNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void messageGroupsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageStatusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pendingMsgForUpdateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void previewImageDataNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void routeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void trackNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void upgradeAnswerDialogStatusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<ChatPageData, ChatPageData> getLens(ChatPageData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, ChatPageData>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$1
            public ChatPageData get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it;
            }

            public ChatPageData set(ChatPageData chatPageData, ChatPageData chatPageData2) {
                ChatPageData it = chatPageData2;
                return it;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super ChatPageData, ? extends ChatPageData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                return (ChatPageData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<ChatPageData, SessionId> getSessionId(ChatPageData.Companion $this$sessionId) {
        Intrinsics.checkNotNullParameter($this$sessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, SessionId>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$2
            public SessionId get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getSessionId();
            }

            public ChatPageData set(ChatPageData chatPageData, SessionId sessionId) {
                ChatPageData copy;
                SessionId sessionId2 = sessionId;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : sessionId2, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super SessionId, ? extends SessionId> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                SessionId sessionId = (SessionId) function1.invoke(it.getSessionId());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : sessionId, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, Long> getHostMid(ChatPageData.Companion $this$hostMid) {
        Intrinsics.checkNotNullParameter($this$hostMid, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, Long>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$3
            public Long get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return Long.valueOf(it.getHostMid());
            }

            public ChatPageData set(ChatPageData chatPageData, Long l) {
                ChatPageData copy;
                long hostMid = l.longValue();
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : hostMid, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super Long, ? extends Long> function1) {
                ChatPageData it;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it2 = chatPageData;
                long hostMid = ((Number) function1.invoke(Long.valueOf(it2.getHostMid()))).longValue();
                ChatPageData it3 = chatPageData;
                it = it3.copy((r36 & 1) != 0 ? it3.sessionId : null, (r36 & 2) != 0 ? it3.hostMid : hostMid, (r36 & 4) != 0 ? it3.pageStatus : null, (r36 & 8) != 0 ? it3.chatInfo : null, (r36 & 16) != 0 ? it3.messageGroups : null, (r36 & 32) != 0 ? it3.toast : null, (r36 & 64) != 0 ? it3.previewImageData : null, (r36 & 128) != 0 ? it3.isShowStickerEditPage : false, (r36 & 256) != 0 ? it3.route : null, (r36 & 512) != 0 ? it3.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it3.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it3.inputBoxSelectState : null, (r36 & 4096) != 0 ? it3.deletingMsg : null, (r36 & 8192) != 0 ? it3.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it3.currentFetchResult : null, (r36 & 32768) != 0 ? it3.inputContent : null, (r36 & 65536) != 0 ? it3.track : null);
                return it;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, PageStatus> getPageStatus(ChatPageData.Companion $this$pageStatus) {
        Intrinsics.checkNotNullParameter($this$pageStatus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, PageStatus>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$4
            public PageStatus get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getPageStatus();
            }

            public ChatPageData set(ChatPageData chatPageData, PageStatus pageStatus) {
                ChatPageData copy;
                PageStatus pageStatus2 = pageStatus;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : pageStatus2, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super PageStatus, ? extends PageStatus> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                PageStatus pageStatus = (PageStatus) function1.invoke(it.getPageStatus());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : pageStatus, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, ChatInfo> getChatInfo(ChatPageData.Companion $this$chatInfo) {
        Intrinsics.checkNotNullParameter($this$chatInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, ChatInfo>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$5
            public ChatInfo get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getChatInfo();
            }

            public ChatPageData set(ChatPageData chatPageData, ChatInfo chatInfo) {
                ChatPageData copy;
                ChatInfo chatInfo2 = chatInfo;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : chatInfo2, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super ChatInfo, ? extends ChatInfo> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                ChatInfo chatInfo = (ChatInfo) function1.invoke(it.getChatInfo());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : chatInfo, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<ChatPageData, List<MessageGroup>> getMessageGroups(ChatPageData.Companion $this$messageGroups) {
        Intrinsics.checkNotNullParameter($this$messageGroups, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, List<? extends MessageGroup>>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$6
            public List<? extends MessageGroup> get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getMessageGroups();
            }

            public ChatPageData set(ChatPageData chatPageData, List<? extends MessageGroup> list) {
                ChatPageData copy;
                List<? extends MessageGroup> messageGroups = list;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : messageGroups, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super List<? extends MessageGroup>, ? extends List<? extends MessageGroup>> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                List messageGroups = (List) function1.invoke(it.getMessageGroups());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : messageGroups, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, IMToast> getToast(ChatPageData.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, IMToast>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$7
            public IMToast get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getToast();
            }

            public ChatPageData set(ChatPageData chatPageData, IMToast iMToast) {
                ChatPageData copy;
                IMToast toast = iMToast;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : toast, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super IMToast, ? extends IMToast> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                IMToast toast = (IMToast) function1.invoke(it.getToast());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : toast, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, PreviewImageData> getPreviewImageData(ChatPageData.Companion $this$previewImageData) {
        Intrinsics.checkNotNullParameter($this$previewImageData, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, PreviewImageData>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$8
            public PreviewImageData get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getPreviewImageData();
            }

            public ChatPageData set(ChatPageData chatPageData, PreviewImageData previewImageData) {
                ChatPageData copy;
                PreviewImageData previewImageData2 = previewImageData;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : previewImageData2, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super PreviewImageData, ? extends PreviewImageData> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                PreviewImageData previewImageData = (PreviewImageData) function1.invoke(it.getPreviewImageData());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : previewImageData, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, Boolean> isShowStickerEditPage(ChatPageData.Companion $this$isShowStickerEditPage) {
        Intrinsics.checkNotNullParameter($this$isShowStickerEditPage, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, Boolean>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$9
            public Boolean get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return Boolean.valueOf(it.isShowStickerEditPage());
            }

            public ChatPageData set(ChatPageData chatPageData, Boolean bool) {
                ChatPageData copy;
                boolean isShowStickerEditPage = bool.booleanValue();
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : isShowStickerEditPage, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super Boolean, ? extends Boolean> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                boolean isShowStickerEditPage = ((Boolean) function1.invoke(Boolean.valueOf(it.isShowStickerEditPage()))).booleanValue();
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : isShowStickerEditPage, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, IMRouteHolder> getRoute(ChatPageData.Companion $this$route) {
        Intrinsics.checkNotNullParameter($this$route, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, IMRouteHolder>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$10
            public IMRouteHolder get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getRoute();
            }

            public ChatPageData set(ChatPageData chatPageData, IMRouteHolder iMRouteHolder) {
                ChatPageData copy;
                IMRouteHolder route = iMRouteHolder;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : route, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super IMRouteHolder, ? extends IMRouteHolder> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                IMRouteHolder route = (IMRouteHolder) function1.invoke(it.getRoute());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : route, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, ChatUpgradeAnswerDialogStatus> getUpgradeAnswerDialogStatus(ChatPageData.Companion $this$upgradeAnswerDialogStatus) {
        Intrinsics.checkNotNullParameter($this$upgradeAnswerDialogStatus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, ChatUpgradeAnswerDialogStatus>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$11
            public ChatUpgradeAnswerDialogStatus get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getUpgradeAnswerDialogStatus();
            }

            public ChatPageData set(ChatPageData chatPageData, ChatUpgradeAnswerDialogStatus chatUpgradeAnswerDialogStatus) {
                ChatPageData copy;
                ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus = chatUpgradeAnswerDialogStatus;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : upgradeAnswerDialogStatus, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super ChatUpgradeAnswerDialogStatus, ? extends ChatUpgradeAnswerDialogStatus> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                ChatUpgradeAnswerDialogStatus upgradeAnswerDialogStatus = (ChatUpgradeAnswerDialogStatus) function1.invoke(it.getUpgradeAnswerDialogStatus());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : upgradeAnswerDialogStatus, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<ChatPageData, List<MessageId>> getPendingMsgForUpdate(ChatPageData.Companion $this$pendingMsgForUpdate) {
        Intrinsics.checkNotNullParameter($this$pendingMsgForUpdate, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, List<? extends MessageId>>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$12
            public List<? extends MessageId> get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getPendingMsgForUpdate();
            }

            public ChatPageData set(ChatPageData chatPageData, List<? extends MessageId> list) {
                ChatPageData copy;
                List<? extends MessageId> pendingMsgForUpdate = list;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : pendingMsgForUpdate, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super List<? extends MessageId>, ? extends List<? extends MessageId>> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                List pendingMsgForUpdate = (List) function1.invoke(it.getPendingMsgForUpdate());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : pendingMsgForUpdate, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, InputBoxSelectState> getInputBoxSelectState(ChatPageData.Companion $this$inputBoxSelectState) {
        Intrinsics.checkNotNullParameter($this$inputBoxSelectState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, InputBoxSelectState>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$13
            public InputBoxSelectState get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getInputBoxSelectState();
            }

            public ChatPageData set(ChatPageData chatPageData, InputBoxSelectState inputBoxSelectState) {
                ChatPageData copy;
                InputBoxSelectState inputBoxSelectState2 = inputBoxSelectState;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : inputBoxSelectState2, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super InputBoxSelectState, ? extends InputBoxSelectState> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                InputBoxSelectState inputBoxSelectState = (InputBoxSelectState) function1.invoke(it.getInputBoxSelectState());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : inputBoxSelectState, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, EntityMessage> getDeletingMsg(ChatPageData.Companion $this$deletingMsg) {
        Intrinsics.checkNotNullParameter($this$deletingMsg, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, EntityMessage>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$14
            public EntityMessage get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getDeletingMsg();
            }

            public ChatPageData set(ChatPageData chatPageData, EntityMessage entityMessage) {
                ChatPageData copy;
                EntityMessage deletingMsg = entityMessage;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : deletingMsg, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super EntityMessage, ? extends EntityMessage> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                EntityMessage deletingMsg = (EntityMessage) function1.invoke(it.getDeletingMsg());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : deletingMsg, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, KBehaviorAlertToast> getDisplayingBehaviorAlert(ChatPageData.Companion $this$displayingBehaviorAlert) {
        Intrinsics.checkNotNullParameter($this$displayingBehaviorAlert, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, KBehaviorAlertToast>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$15
            public KBehaviorAlertToast get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getDisplayingBehaviorAlert();
            }

            public ChatPageData set(ChatPageData chatPageData, KBehaviorAlertToast kBehaviorAlertToast) {
                ChatPageData copy;
                KBehaviorAlertToast displayingBehaviorAlert = kBehaviorAlertToast;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : displayingBehaviorAlert, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super KBehaviorAlertToast, ? extends KBehaviorAlertToast> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                KBehaviorAlertToast displayingBehaviorAlert = (KBehaviorAlertToast) function1.invoke(it.getDisplayingBehaviorAlert());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : displayingBehaviorAlert, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, FetchMessagesData> getCurrentFetchResult(ChatPageData.Companion $this$currentFetchResult) {
        Intrinsics.checkNotNullParameter($this$currentFetchResult, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, FetchMessagesData>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$16
            public FetchMessagesData get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getCurrentFetchResult();
            }

            public ChatPageData set(ChatPageData chatPageData, FetchMessagesData fetchMessagesData) {
                ChatPageData copy;
                FetchMessagesData currentFetchResult = fetchMessagesData;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : currentFetchResult, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super FetchMessagesData, ? extends FetchMessagesData> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                FetchMessagesData currentFetchResult = (FetchMessagesData) function1.invoke(it.getCurrentFetchResult());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : currentFetchResult, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, InputContent> getInputContent(ChatPageData.Companion $this$inputContent) {
        Intrinsics.checkNotNullParameter($this$inputContent, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, InputContent>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$17
            public InputContent get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getInputContent();
            }

            public ChatPageData set(ChatPageData chatPageData, InputContent inputContent) {
                ChatPageData copy;
                InputContent inputContent2 = inputContent;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : inputContent2, (r36 & 65536) != 0 ? it.track : null);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super InputContent, ? extends InputContent> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                InputContent inputContent = (InputContent) function1.invoke(it.getInputContent());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : inputContent, (r36 & 65536) != 0 ? it2.track : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<ChatPageData, ChatPageTechTrack> getTrack(ChatPageData.Companion $this$track) {
        Intrinsics.checkNotNullParameter($this$track, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageData, ChatPageTechTrack>() { // from class: kntr.app.im.chat.core.model.ChatPageDataLensKt$special$$inlined$invoke$18
            public ChatPageTechTrack get(ChatPageData chatPageData) {
                ChatPageData it = chatPageData;
                return it.getTrack();
            }

            public ChatPageData set(ChatPageData chatPageData, ChatPageTechTrack chatPageTechTrack) {
                ChatPageData copy;
                ChatPageTechTrack track = chatPageTechTrack;
                ChatPageData it = chatPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.hostMid : 0L, (r36 & 4) != 0 ? it.pageStatus : null, (r36 & 8) != 0 ? it.chatInfo : null, (r36 & 16) != 0 ? it.messageGroups : null, (r36 & 32) != 0 ? it.toast : null, (r36 & 64) != 0 ? it.previewImageData : null, (r36 & 128) != 0 ? it.isShowStickerEditPage : false, (r36 & 256) != 0 ? it.route : null, (r36 & 512) != 0 ? it.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it.inputBoxSelectState : null, (r36 & 4096) != 0 ? it.deletingMsg : null, (r36 & 8192) != 0 ? it.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it.currentFetchResult : null, (r36 & 32768) != 0 ? it.inputContent : null, (r36 & 65536) != 0 ? it.track : track);
                return copy;
            }

            public ChatPageData modify(ChatPageData chatPageData, Function1<? super ChatPageTechTrack, ? extends ChatPageTechTrack> function1) {
                ChatPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageData it = chatPageData;
                ChatPageTechTrack track = (ChatPageTechTrack) function1.invoke(it.getTrack());
                ChatPageData it2 = chatPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.hostMid : 0L, (r36 & 4) != 0 ? it2.pageStatus : null, (r36 & 8) != 0 ? it2.chatInfo : null, (r36 & 16) != 0 ? it2.messageGroups : null, (r36 & 32) != 0 ? it2.toast : null, (r36 & 64) != 0 ? it2.previewImageData : null, (r36 & 128) != 0 ? it2.isShowStickerEditPage : false, (r36 & 256) != 0 ? it2.route : null, (r36 & 512) != 0 ? it2.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? it2.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? it2.inputBoxSelectState : null, (r36 & 4096) != 0 ? it2.deletingMsg : null, (r36 & 8192) != 0 ? it2.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? it2.currentFetchResult : null, (r36 & 32768) != 0 ? it2.inputContent : null, (r36 & 65536) != 0 ? it2.track : track);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, SessionId> getSessionId(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionId(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, Long> getHostMid(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getHostMid(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, PageStatus> getPageStatus(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageStatus(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, ChatInfo> getChatInfo(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getChatInfo(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<MessageGroup>> getMessageGroups(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMessageGroups(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, PreviewImageData> getPreviewImageData(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getPreviewImageData(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isShowStickerEditPage(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isShowStickerEditPage(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMRouteHolder> getRoute(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRoute(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, ChatUpgradeAnswerDialogStatus> getUpgradeAnswerDialogStatus(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUpgradeAnswerDialogStatus(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<MessageId>> getPendingMsgForUpdate(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPendingMsgForUpdate(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, InputBoxSelectState> getInputBoxSelectState(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInputBoxSelectState(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, EntityMessage> getDeletingMsg(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getDeletingMsg(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBehaviorAlertToast> getDisplayingBehaviorAlert(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getDisplayingBehaviorAlert(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, FetchMessagesData> getCurrentFetchResult(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getCurrentFetchResult(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, InputContent> getInputContent(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInputContent(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, ChatPageTechTrack> getTrack(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTrack(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, SessionId> sessionIdNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionId(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, Long> hostMidNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getHostMid(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, PageStatus> pageStatusNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageStatus(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, ChatInfo> chatInfoNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getChatInfo(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<MessageGroup>> messageGroupsNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMessageGroups(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> toastNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, PreviewImageData> previewImageDataNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getPreviewImageData(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isShowStickerEditPageNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isShowStickerEditPage(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, IMRouteHolder> routeNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRoute(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, ChatUpgradeAnswerDialogStatus> upgradeAnswerDialogStatusNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUpgradeAnswerDialogStatus(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<MessageId>> pendingMsgForUpdateNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPendingMsgForUpdate(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, InputBoxSelectState> inputBoxSelectStateNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInputBoxSelectState(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, EntityMessage> deletingMsgNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getDeletingMsg(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBehaviorAlertToast> displayingBehaviorAlertNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getDisplayingBehaviorAlert(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, FetchMessagesData> currentFetchResultNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getCurrentFetchResult(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, InputContent> inputContentNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInputContent(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, ChatPageTechTrack> trackNullable(BSimpleLens<T, ChatPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTrack(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, SessionId> getSessionId(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionId(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, Long> getHostMid(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getHostMid(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, PageStatus> getPageStatus(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageStatus(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, ChatInfo> getChatInfo(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getChatInfo(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<MessageGroup>> getMessageGroups(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMessageGroups(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, PreviewImageData> getPreviewImageData(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getPreviewImageData(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isShowStickerEditPage(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isShowStickerEditPage(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, IMRouteHolder> getRoute(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRoute(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, ChatUpgradeAnswerDialogStatus> getUpgradeAnswerDialogStatus(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUpgradeAnswerDialogStatus(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<MessageId>> getPendingMsgForUpdate(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPendingMsgForUpdate(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, InputBoxSelectState> getInputBoxSelectState(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInputBoxSelectState(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, EntityMessage> getDeletingMsg(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getDeletingMsg(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBehaviorAlertToast> getDisplayingBehaviorAlert(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getDisplayingBehaviorAlert(ChatPageData.Companion));
    }

    public static final <T> BSimpleLens<T, FetchMessagesData> getCurrentFetchResult(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getCurrentFetchResult(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, InputContent> getInputContent(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInputContent(ChatPageData.Companion));
    }

    public static final <T> BNullableLens<T, ChatPageTechTrack> getTrack(BNullableLens<T, ChatPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTrack(ChatPageData.Companion));
    }
}