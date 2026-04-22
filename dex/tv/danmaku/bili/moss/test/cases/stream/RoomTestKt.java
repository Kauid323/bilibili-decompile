package tv.danmaku.bili.moss.test.cases.stream;

import com.bapis.bilibili.broadcast.v1.BroadcastRoomMoss;
import com.bapis.bilibili.broadcast.v1.RoomJoinEvent;
import com.bapis.bilibili.broadcast.v1.RoomLeaveEvent;
import com.bapis.bilibili.broadcast.v1.RoomMessageEvent;
import com.bapis.bilibili.broadcast.v1.RoomOnlineEvent;
import com.bapis.bilibili.broadcast.v1.RoomReq;
import com.bapis.bilibili.broadcast.v1.RoomResp;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.lib.moss.util.any.AnyKt;
import com.bilibili.lib.moss.utils.CommonUtilsKt;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: RoomTest.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0006\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"TAG_ROOM", "", "roomReqHandler", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/broadcast/v1/RoomReq;", "roomRespHandler", "tv/danmaku/bili/moss/test/cases/stream/RoomTestKt$roomRespHandler$1", "Ltv/danmaku/bili/moss/test/cases/stream/RoomTestKt$roomRespHandler$1;", "testRoomJoinAsync", "", "roomId", "testRoomLeaveAsync", "testRoomOnlineAsync", "testMessageAsync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RoomTestKt {
    public static final String TAG_ROOM = "moss.brdcst.room";
    private static MossResponseHandler<RoomReq> roomReqHandler;
    private static final RoomTestKt$roomRespHandler$1 roomRespHandler = new MossResponseHandler<RoomResp>() { // from class: tv.danmaku.bili.moss.test.cases.stream.RoomTestKt$roomRespHandler$1
        public /* synthetic */ void onHeaders(Map map) {
            MossResponseHandler.-CC.$default$onHeaders(this, map);
        }

        public /* synthetic */ long onNextForAck(Object obj) {
            return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
        }

        public /* synthetic */ void onUpstreamAck(Long l) {
            MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
        }

        public /* synthetic */ void onValid() {
            MossResponseHandler.-CC.$default$onValid(this);
        }

        public void onNext(RoomResp value) {
            if (value != null) {
                BLog.vfmt(RoomTestKt.TAG_ROOM, "Biz onNext %s.", CommonUtilsKt.printProto((GeneratedMessageLite) value));
            }
        }

        public void onError(MossException t) {
            BLog.efmt(RoomTestKt.TAG_ROOM, "Biz onError %s.", t);
        }

        public void onCompleted() {
            BLog.v(RoomTestKt.TAG_ROOM, "onCompleted.");
        }
    };

    public static final void testRoomJoinAsync(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        roomReqHandler = new BroadcastRoomMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).enter(roomRespHandler);
        RoomReq join = RoomReq.newBuilder().setId(roomId).setJoin(RoomJoinEvent.getDefaultInstance()).build();
        MossResponseHandler<RoomReq> mossResponseHandler = roomReqHandler;
        if (mossResponseHandler != null) {
            mossResponseHandler.onNext(join);
        }
    }

    public static final void testRoomLeaveAsync(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        RoomReq leave = RoomReq.newBuilder().setId(roomId).setLeave(RoomLeaveEvent.getDefaultInstance()).build();
        MossResponseHandler<RoomReq> mossResponseHandler = roomReqHandler;
        if (mossResponseHandler != null) {
            mossResponseHandler.onNext(leave);
        }
    }

    public static final void testRoomOnlineAsync(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        RoomReq online = RoomReq.newBuilder().setId(roomId).setOnline(RoomOnlineEvent.getDefaultInstance()).build();
        MossResponseHandler<RoomReq> mossResponseHandler = roomReqHandler;
        if (mossResponseHandler != null) {
            mossResponseHandler.onNext(online);
        }
    }

    public static final void testMessageAsync(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        GeneratedMessageLite defaultInstance = Empty.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
        Any any = AnyKt.pack(defaultInstance);
        RoomMessageEvent.Builder msgEvent = RoomMessageEvent.newBuilder().setTargetPath("/biz.target.path").setBody(any);
        RoomReq msg = RoomReq.newBuilder().setId(roomId).setMsg(msgEvent).build();
        MossResponseHandler<RoomReq> mossResponseHandler = roomReqHandler;
        if (mossResponseHandler != null) {
            mossResponseHandler.onNext(msg);
        }
    }
}