package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchPageDataLens.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"*\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\"0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"*\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007\"*\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\",\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010.0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0007\",\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\u0007\",\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001060\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\u0007\",\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010:0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0005\u001a\u0004\b<\u0010\u0007\",\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010>0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010\u0007\"*\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020B0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0007\"*\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020F0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u0010\u0005\u001a\u0004\bH\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010K\u001a\u0004\b\u000b\u0010L\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010K\u001a\u0004\b\u000e\u0010L\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010K\u001a\u0004\b\u0011\u0010L\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010K\u001a\u0004\b\u0014\u0010L\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00160\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010K\u001a\u0004\b\u0018\u0010L\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u001a0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010K\u001a\u0004\b\u001c\u0010L\"@\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u001e0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010K\u001a\u0004\b \u0010L\"@\u0010!\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\"0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010K\u001a\u0004\b$\u0010L\"@\u0010%\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020&0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010K\u001a\u0004\b(\u0010L\"@\u0010)\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020*0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010K\u001a\u0004\b,\u0010L\"B\u0010-\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010.0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010K\u001a\u0004\b0\u0010L\"B\u00101\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u0001020\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010K\u001a\u0004\b4\u0010L\"B\u00105\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u0001060\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010K\u001a\u0004\b8\u0010L\"B\u00109\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010:0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010K\u001a\u0004\b<\u0010L\"B\u0010=\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010>0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010K\u001a\u0004\b@\u0010L\"@\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020B0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010K\u001a\u0004\bD\u0010L\"@\u0010E\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020F0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u0010K\u001a\u0004\bH\u0010L\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010K\u001a\u0004\bO\u0010P\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010K\u001a\u0004\bR\u0010P\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u0010K\u001a\u0004\bT\u0010P\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bU\u0010K\u001a\u0004\bV\u0010P\"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00160M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bW\u0010K\u001a\u0004\bX\u0010P\"B\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u001a0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bY\u0010K\u001a\u0004\bZ\u0010P\"B\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u001e0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010K\u001a\u0004\b\\\u0010P\"B\u0010!\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\"0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b]\u0010K\u001a\u0004\b^\u0010P\"B\u0010%\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020&0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010K\u001a\u0004\b`\u0010P\"B\u0010)\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020*0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010K\u001a\u0004\bb\u0010P\"D\u0010-\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010.0\u0001\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bc\u0010K\u001a\u0004\bd\u0010L\"D\u00101\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u0001020\u0001\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\be\u0010K\u001a\u0004\bf\u0010L\"D\u00105\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u0001060\u0001\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bg\u0010K\u001a\u0004\bh\u0010L\"D\u00109\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010:0\u0001\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bi\u0010K\u001a\u0004\bj\u0010L\"D\u0010=\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010>0\u0001\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bk\u0010K\u001a\u0004\bl\u0010L\"B\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020B0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bm\u0010K\u001a\u0004\bn\u0010P\"B\u0010E\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020F0M\"\b\b\u0000\u0010I*\u00020J*\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bo\u0010K\u001a\u0004\bp\u0010P\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010q\u001a\u0004\b\u000b\u0010r\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010q\u001a\u0004\b\u000e\u0010r\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010q\u001a\u0004\b\u0011\u0010r\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\t0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010q\u001a\u0004\b\u0014\u0010r\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00160M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010q\u001a\u0004\b\u0018\u0010r\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u001a0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010q\u001a\u0004\b\u001c\u0010r\"@\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u001e0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010q\u001a\u0004\b \u0010r\"@\u0010!\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\"0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010q\u001a\u0004\b$\u0010r\"@\u0010%\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020&0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010q\u001a\u0004\b(\u0010r\"@\u0010)\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020*0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010q\u001a\u0004\b,\u0010r\"B\u0010-\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010.0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010q\u001a\u0004\b0\u0010s\"B\u00101\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u0001020\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010q\u001a\u0004\b4\u0010s\"B\u00105\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u0001060\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010q\u001a\u0004\b8\u0010s\"B\u00109\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010:0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010q\u001a\u0004\b<\u0010s\"B\u0010=\u001a\u0010\u0012\u0004\u0012\u0002HI\u0012\u0006\u0012\u0004\u0018\u00010>0\u0001\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010q\u001a\u0004\b@\u0010s\"@\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020B0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010q\u001a\u0004\bD\u0010r\"@\u0010E\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020F0M\"\b\b\u0000\u0010I*\u00020J*\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020\u00020M8FX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u0010q\u001a\u0004\bH\u0010r¨\u0006t"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionId$annotations", "getSessionId", "sessionQuery", "getSessionQuery$annotations", "getSessionQuery", "sessionTitle", "getSessionTitle$annotations", "getSessionTitle", "historyCursor", "getHistoryCursor$annotations", "getHistoryCursor", "pageStatus", "Lkntr/app/deepsearch/base/model/biz/PageStatus;", "getPageStatus$annotations", "getPageStatus", "pageStyle", "Lkntr/app/deepsearch/base/model/biz/PageStyle;", "getPageStyle$annotations", "getPageStyle", "requestModel", "Lkntr/app/deepsearch/base/model/biz/RequestModel;", "getRequestModel$annotations", "getRequestModel", "textConfigModel", "Lkntr/app/deepsearch/base/model/biz/TextConfigModel;", "getTextConfigModel$annotations", "getTextConfigModel", "containerWidth", RoomRecommendViewModel.EMPTY_CURSOR, "getContainerWidth$annotations", "getContainerWidth", "pageChatState", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "getPageChatState$annotations", "getPageChatState", "thinkPopContent", "Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;", "getThinkPopContent$annotations", "getThinkPopContent", "deepSearchToast", "Lkntr/app/deepsearch/base/model/biz/DeepSearchToast;", "getDeepSearchToast$annotations", "getDeepSearchToast", "copyModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel;", "getCopyModel$annotations", "getCopyModel", "treadPopContent", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent;", "getTreadPopContent$annotations", "getTreadPopContent", "bubbleData", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", "getBubbleData$annotations", "getBubbleData", "inputState", "Lkntr/app/deepsearch/base/model/input/InputState;", "getInputState$annotations", "getInputState", "list", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;", "getList$annotations", "getList", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "sessionIdNullable$annotations", "sessionIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "sessionQueryNullable$annotations", "sessionQueryNullable", "sessionTitleNullable$annotations", "sessionTitleNullable", "historyCursorNullable$annotations", "historyCursorNullable", "pageStatusNullable$annotations", "pageStatusNullable", "pageStyleNullable$annotations", "pageStyleNullable", "requestModelNullable$annotations", "requestModelNullable", "textConfigModelNullable$annotations", "textConfigModelNullable", "containerWidthNullable$annotations", "containerWidthNullable", "pageChatStateNullable$annotations", "pageChatStateNullable", "thinkPopContentNullable$annotations", "thinkPopContentNullable", "deepSearchToastNullable$annotations", "deepSearchToastNullable", "copyModelNullable$annotations", "copyModelNullable", "treadPopContentNullable$annotations", "treadPopContentNullable", "bubbleDataNullable$annotations", "bubbleDataNullable", "inputStateNullable$annotations", "inputStateNullable", "listNullable$annotations", "listNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchPageDataLensKt {
    public static /* synthetic */ void bubbleDataNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void containerWidthNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void copyModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void deepSearchToastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBubbleData$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getBubbleData$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBubbleData$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getContainerWidth$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContainerWidth$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContainerWidth$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getCopyModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCopyModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCopyModel$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getDeepSearchToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDeepSearchToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDeepSearchToast$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getHistoryCursor$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHistoryCursor$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHistoryCursor$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getInputState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputState$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getList$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getPageChatState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageChatState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageChatState$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getPageStyle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageStyle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageStyle$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getRequestModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRequestModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRequestModel$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getSessionQuery$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionQuery$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionQuery$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getSessionTitle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionTitle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionTitle$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getTextConfigModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTextConfigModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTextConfigModel$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getThinkPopContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getThinkPopContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getThinkPopContent$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void getTreadPopContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTreadPopContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTreadPopContent$annotations(DeepSearchPageData.Companion companion) {
    }

    public static /* synthetic */ void historyCursorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void inputStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void listNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageChatStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageStatusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageStyleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void requestModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionQueryNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionTitleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void textConfigModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void thinkPopContentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void treadPopContentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchPageData, DeepSearchPageData> getLens(DeepSearchPageData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, DeepSearchPageData>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$1
            public DeepSearchPageData get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it;
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, DeepSearchPageData deepSearchPageData2) {
                DeepSearchPageData it = deepSearchPageData2;
                return it;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super DeepSearchPageData, ? extends DeepSearchPageData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                return (DeepSearchPageData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, String> getSessionId(DeepSearchPageData.Companion $this$sessionId) {
        Intrinsics.checkNotNullParameter($this$sessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$2
            public String get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getSessionId();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, String str) {
                DeepSearchPageData copy;
                String sessionId = str;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : sessionId, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super String, ? extends String> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                String sessionId = (String) function1.invoke(it.getSessionId());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : sessionId, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, String> getSessionQuery(DeepSearchPageData.Companion $this$sessionQuery) {
        Intrinsics.checkNotNullParameter($this$sessionQuery, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$3
            public String get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getSessionQuery();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, String str) {
                DeepSearchPageData copy;
                String sessionQuery = str;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : sessionQuery, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super String, ? extends String> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                String sessionQuery = (String) function1.invoke(it.getSessionQuery());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : sessionQuery, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, String> getSessionTitle(DeepSearchPageData.Companion $this$sessionTitle) {
        Intrinsics.checkNotNullParameter($this$sessionTitle, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$4
            public String get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getSessionTitle();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, String str) {
                DeepSearchPageData copy;
                String sessionTitle = str;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : sessionTitle, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super String, ? extends String> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                String sessionTitle = (String) function1.invoke(it.getSessionTitle());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : sessionTitle, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, String> getHistoryCursor(DeepSearchPageData.Companion $this$historyCursor) {
        Intrinsics.checkNotNullParameter($this$historyCursor, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$5
            public String get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getHistoryCursor();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, String str) {
                DeepSearchPageData copy;
                String historyCursor = str;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : historyCursor, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super String, ? extends String> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                String historyCursor = (String) function1.invoke(it.getHistoryCursor());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : historyCursor, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, PageStatus> getPageStatus(DeepSearchPageData.Companion $this$pageStatus) {
        Intrinsics.checkNotNullParameter($this$pageStatus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, PageStatus>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$6
            public PageStatus get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getPageStatus();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, PageStatus pageStatus) {
                DeepSearchPageData copy;
                PageStatus pageStatus2 = pageStatus;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : pageStatus2, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super PageStatus, ? extends PageStatus> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                PageStatus pageStatus = (PageStatus) function1.invoke(it.getPageStatus());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : pageStatus, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, PageStyle> getPageStyle(DeepSearchPageData.Companion $this$pageStyle) {
        Intrinsics.checkNotNullParameter($this$pageStyle, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, PageStyle>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$7
            public PageStyle get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getPageStyle();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, PageStyle pageStyle) {
                DeepSearchPageData copy;
                PageStyle pageStyle2 = pageStyle;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : pageStyle2, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super PageStyle, ? extends PageStyle> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                PageStyle pageStyle = (PageStyle) function1.invoke(it.getPageStyle());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : pageStyle, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, RequestModel> getRequestModel(DeepSearchPageData.Companion $this$requestModel) {
        Intrinsics.checkNotNullParameter($this$requestModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, RequestModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$8
            public RequestModel get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getRequestModel();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, RequestModel requestModel) {
                DeepSearchPageData copy;
                RequestModel requestModel2 = requestModel;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : requestModel2, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super RequestModel, ? extends RequestModel> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                RequestModel requestModel = (RequestModel) function1.invoke(it.getRequestModel());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : requestModel, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, TextConfigModel> getTextConfigModel(DeepSearchPageData.Companion $this$textConfigModel) {
        Intrinsics.checkNotNullParameter($this$textConfigModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, TextConfigModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$9
            public TextConfigModel get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getTextConfigModel();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, TextConfigModel textConfigModel) {
                DeepSearchPageData copy;
                TextConfigModel textConfigModel2 = textConfigModel;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : textConfigModel2, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super TextConfigModel, ? extends TextConfigModel> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                TextConfigModel textConfigModel = (TextConfigModel) function1.invoke(it.getTextConfigModel());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : textConfigModel, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, Double> getContainerWidth(DeepSearchPageData.Companion $this$containerWidth) {
        Intrinsics.checkNotNullParameter($this$containerWidth, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, Double>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$10
            public Double get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return Double.valueOf(it.getContainerWidth());
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, Double d) {
                DeepSearchPageData copy;
                double containerWidth = d.doubleValue();
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : containerWidth, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super Double, ? extends Double> function1) {
                DeepSearchPageData it;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it2 = deepSearchPageData;
                double containerWidth = ((Number) function1.invoke(Double.valueOf(it2.getContainerWidth()))).doubleValue();
                DeepSearchPageData it3 = deepSearchPageData;
                it = it3.copy((r36 & 1) != 0 ? it3.sessionId : null, (r36 & 2) != 0 ? it3.sessionQuery : null, (r36 & 4) != 0 ? it3.sessionTitle : null, (r36 & 8) != 0 ? it3.historyCursor : null, (r36 & 16) != 0 ? it3.pageStatus : null, (r36 & 32) != 0 ? it3.pageStyle : null, (r36 & 64) != 0 ? it3.requestModel : null, (r36 & 128) != 0 ? it3.textConfigModel : null, (r36 & 256) != 0 ? it3.containerWidth : containerWidth, (r36 & 512) != 0 ? it3.pageChatState : null, (r36 & 1024) != 0 ? it3.thinkPopContent : null, (r36 & 2048) != 0 ? it3.deepSearchToast : null, (r36 & 4096) != 0 ? it3.copyModel : null, (r36 & 8192) != 0 ? it3.treadPopContent : null, (r36 & 16384) != 0 ? it3.bubbleData : null, (r36 & 32768) != 0 ? it3.inputState : null, (r36 & 65536) != 0 ? it3.list : null);
                return it;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, DeepSearchPageChatState> getPageChatState(DeepSearchPageData.Companion $this$pageChatState) {
        Intrinsics.checkNotNullParameter($this$pageChatState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, DeepSearchPageChatState>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$11
            public DeepSearchPageChatState get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getPageChatState();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, DeepSearchPageChatState deepSearchPageChatState) {
                DeepSearchPageData copy;
                DeepSearchPageChatState pageChatState = deepSearchPageChatState;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : pageChatState, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super DeepSearchPageChatState, ? extends DeepSearchPageChatState> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                DeepSearchPageChatState pageChatState = (DeepSearchPageChatState) function1.invoke(it.getPageChatState());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : pageChatState, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, DeepSearchThinkPopContent> getThinkPopContent(DeepSearchPageData.Companion $this$thinkPopContent) {
        Intrinsics.checkNotNullParameter($this$thinkPopContent, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, DeepSearchThinkPopContent>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$12
            public DeepSearchThinkPopContent get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getThinkPopContent();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchPageData copy;
                DeepSearchThinkPopContent thinkPopContent = deepSearchThinkPopContent;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : thinkPopContent, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super DeepSearchThinkPopContent, ? extends DeepSearchThinkPopContent> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                DeepSearchThinkPopContent thinkPopContent = (DeepSearchThinkPopContent) function1.invoke(it.getThinkPopContent());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : thinkPopContent, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, DeepSearchToast> getDeepSearchToast(DeepSearchPageData.Companion $this$deepSearchToast) {
        Intrinsics.checkNotNullParameter($this$deepSearchToast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, DeepSearchToast>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$13
            public DeepSearchToast get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getDeepSearchToast();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, DeepSearchToast deepSearchToast) {
                DeepSearchPageData copy;
                DeepSearchToast deepSearchToast2 = deepSearchToast;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : deepSearchToast2, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super DeepSearchToast, ? extends DeepSearchToast> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                DeepSearchToast deepSearchToast = (DeepSearchToast) function1.invoke(it.getDeepSearchToast());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : deepSearchToast, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, DeepSearchCopyModel> getCopyModel(DeepSearchPageData.Companion $this$copyModel) {
        Intrinsics.checkNotNullParameter($this$copyModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, DeepSearchCopyModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$14
            public DeepSearchCopyModel get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getCopyModel();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, DeepSearchCopyModel deepSearchCopyModel) {
                DeepSearchPageData copy;
                DeepSearchCopyModel copyModel = deepSearchCopyModel;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : copyModel, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super DeepSearchCopyModel, ? extends DeepSearchCopyModel> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                DeepSearchCopyModel copyModel = (DeepSearchCopyModel) function1.invoke(it.getCopyModel());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : copyModel, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, DeepSearchTreadPopContent> getTreadPopContent(DeepSearchPageData.Companion $this$treadPopContent) {
        Intrinsics.checkNotNullParameter($this$treadPopContent, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, DeepSearchTreadPopContent>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$15
            public DeepSearchTreadPopContent get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getTreadPopContent();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, DeepSearchTreadPopContent deepSearchTreadPopContent) {
                DeepSearchPageData copy;
                DeepSearchTreadPopContent treadPopContent = deepSearchTreadPopContent;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : treadPopContent, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super DeepSearchTreadPopContent, ? extends DeepSearchTreadPopContent> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                DeepSearchTreadPopContent treadPopContent = (DeepSearchTreadPopContent) function1.invoke(it.getTreadPopContent());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : treadPopContent, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, LinkNodeData> getBubbleData(DeepSearchPageData.Companion $this$bubbleData) {
        Intrinsics.checkNotNullParameter($this$bubbleData, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, LinkNodeData>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$16
            public LinkNodeData get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getBubbleData();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, LinkNodeData linkNodeData) {
                DeepSearchPageData copy;
                LinkNodeData bubbleData = linkNodeData;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : bubbleData, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super LinkNodeData, ? extends LinkNodeData> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                LinkNodeData bubbleData = (LinkNodeData) function1.invoke(it.getBubbleData());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : bubbleData, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, InputState> getInputState(DeepSearchPageData.Companion $this$inputState) {
        Intrinsics.checkNotNullParameter($this$inputState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, InputState>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$17
            public InputState get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getInputState();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, InputState inputState) {
                DeepSearchPageData copy;
                InputState inputState2 = inputState;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : inputState2, (r36 & 65536) != 0 ? it.list : null);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super InputState, ? extends InputState> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                InputState inputState = (InputState) function1.invoke(it.getInputState());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : inputState, (r36 & 65536) != 0 ? it2.list : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchPageData, DeepSearchContentList> getList(DeepSearchPageData.Companion $this$list) {
        Intrinsics.checkNotNullParameter($this$list, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchPageData, DeepSearchContentList>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt$special$$inlined$invoke$18
            public DeepSearchContentList get(DeepSearchPageData deepSearchPageData) {
                DeepSearchPageData it = deepSearchPageData;
                return it.getList();
            }

            public DeepSearchPageData set(DeepSearchPageData deepSearchPageData, DeepSearchContentList deepSearchContentList) {
                DeepSearchPageData copy;
                DeepSearchContentList list = deepSearchContentList;
                DeepSearchPageData it = deepSearchPageData;
                copy = it.copy((r36 & 1) != 0 ? it.sessionId : null, (r36 & 2) != 0 ? it.sessionQuery : null, (r36 & 4) != 0 ? it.sessionTitle : null, (r36 & 8) != 0 ? it.historyCursor : null, (r36 & 16) != 0 ? it.pageStatus : null, (r36 & 32) != 0 ? it.pageStyle : null, (r36 & 64) != 0 ? it.requestModel : null, (r36 & 128) != 0 ? it.textConfigModel : null, (r36 & 256) != 0 ? it.containerWidth : 0.0d, (r36 & 512) != 0 ? it.pageChatState : null, (r36 & 1024) != 0 ? it.thinkPopContent : null, (r36 & 2048) != 0 ? it.deepSearchToast : null, (r36 & 4096) != 0 ? it.copyModel : null, (r36 & 8192) != 0 ? it.treadPopContent : null, (r36 & 16384) != 0 ? it.bubbleData : null, (r36 & 32768) != 0 ? it.inputState : null, (r36 & 65536) != 0 ? it.list : list);
                return copy;
            }

            public DeepSearchPageData modify(DeepSearchPageData deepSearchPageData, Function1<? super DeepSearchContentList, ? extends DeepSearchContentList> function1) {
                DeepSearchPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchPageData it = deepSearchPageData;
                DeepSearchContentList list = (DeepSearchContentList) function1.invoke(it.getList());
                DeepSearchPageData it2 = deepSearchPageData;
                copy = it2.copy((r36 & 1) != 0 ? it2.sessionId : null, (r36 & 2) != 0 ? it2.sessionQuery : null, (r36 & 4) != 0 ? it2.sessionTitle : null, (r36 & 8) != 0 ? it2.historyCursor : null, (r36 & 16) != 0 ? it2.pageStatus : null, (r36 & 32) != 0 ? it2.pageStyle : null, (r36 & 64) != 0 ? it2.requestModel : null, (r36 & 128) != 0 ? it2.textConfigModel : null, (r36 & 256) != 0 ? it2.containerWidth : 0.0d, (r36 & 512) != 0 ? it2.pageChatState : null, (r36 & 1024) != 0 ? it2.thinkPopContent : null, (r36 & 2048) != 0 ? it2.deepSearchToast : null, (r36 & 4096) != 0 ? it2.copyModel : null, (r36 & 8192) != 0 ? it2.treadPopContent : null, (r36 & 16384) != 0 ? it2.bubbleData : null, (r36 & 32768) != 0 ? it2.inputState : null, (r36 & 65536) != 0 ? it2.list : list);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getSessionId(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionId(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, String> getSessionQuery(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionQuery(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, String> getSessionTitle(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionTitle(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, String> getHistoryCursor(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getHistoryCursor(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, PageStatus> getPageStatus(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageStatus(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, PageStyle> getPageStyle(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageStyle(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, RequestModel> getRequestModel(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRequestModel(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, TextConfigModel> getTextConfigModel(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTextConfigModel(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, Double> getContainerWidth(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContainerWidth(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchPageChatState> getPageChatState(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageChatState(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchThinkPopContent> getThinkPopContent(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getThinkPopContent(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchToast> getDeepSearchToast(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getDeepSearchToast(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchCopyModel> getCopyModel(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getCopyModel(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopContent> getTreadPopContent(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getTreadPopContent(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, LinkNodeData> getBubbleData(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getBubbleData(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, InputState> getInputState(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInputState(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchContentList> getList(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getList(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionIdNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionId(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionQueryNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionQuery(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionTitleNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionTitle(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> historyCursorNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getHistoryCursor(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, PageStatus> pageStatusNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageStatus(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, PageStyle> pageStyleNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageStyle(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, RequestModel> requestModelNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRequestModel(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, TextConfigModel> textConfigModelNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTextConfigModel(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, Double> containerWidthNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContainerWidth(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchPageChatState> pageChatStateNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageChatState(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchThinkPopContent> thinkPopContentNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getThinkPopContent(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchToast> deepSearchToastNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getDeepSearchToast(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchCopyModel> copyModelNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getCopyModel(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopContent> treadPopContentNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getTreadPopContent(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, LinkNodeData> bubbleDataNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getBubbleData(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, InputState> inputStateNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInputState(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchContentList> listNullable(BSimpleLens<T, DeepSearchPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getList(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionId(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionId(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionQuery(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionQuery(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionTitle(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionTitle(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> getHistoryCursor(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getHistoryCursor(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, PageStatus> getPageStatus(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageStatus(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, PageStyle> getPageStyle(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageStyle(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, RequestModel> getRequestModel(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRequestModel(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, TextConfigModel> getTextConfigModel(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTextConfigModel(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, Double> getContainerWidth(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContainerWidth(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchPageChatState> getPageChatState(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageChatState(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchThinkPopContent> getThinkPopContent(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getThinkPopContent(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchToast> getDeepSearchToast(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getDeepSearchToast(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchCopyModel> getCopyModel(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getCopyModel(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopContent> getTreadPopContent(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getTreadPopContent(DeepSearchPageData.Companion));
    }

    public static final <T> BSimpleLens<T, LinkNodeData> getBubbleData(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getBubbleData(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, InputState> getInputState(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInputState(DeepSearchPageData.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchContentList> getList(BNullableLens<T, DeepSearchPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getList(DeepSearchPageData.Companion));
    }
}