package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketDeflateExtension;
import io.ktor.websocket.internals.DeflaterUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* compiled from: WebSocketDeflateExtension.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/.B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R.\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010%¨\u00060"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "config", "<init>", "(Lio/ktor/websocket/WebSocketDeflateExtension$Config;)V", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtensionHeader;", "negotiatedProtocols", Column.INVAL_VALUE, "clientNegotiation", "(Ljava/util/List;)Z", "requestedProtocols", "serverNegotiation", "(Ljava/util/List;)Ljava/util/List;", "Lio/ktor/websocket/Frame;", "frame", "processOutgoingFrame", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processIncomingFrame", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "factory", "Lio/ktor/websocket/WebSocketExtensionFactory;", "getFactory", "()Lio/ktor/websocket/WebSocketExtensionFactory;", "protocols", "Ljava/util/List;", "getProtocols", "()Ljava/util/List;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "outgoingNoContextTakeover", "Z", "getOutgoingNoContextTakeover$ktor_websockets", "()Z", "setOutgoingNoContextTakeover$ktor_websockets", "(Z)V", "incomingNoContextTakeover", "getIncomingNoContextTakeover$ktor_websockets", "setIncomingNoContextTakeover$ktor_websockets", "decompressIncoming", "Companion", "Config", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebSocketDeflateExtension implements WebSocketExtension<Config> {
    public static final Companion Companion = new Companion(null);
    private static final AttributeKey<WebSocketDeflateExtension> key;
    private static final boolean rsv1;
    private static final boolean rsv2 = false;
    private static final boolean rsv3 = false;
    private final Config config;
    private boolean decompressIncoming;
    private final Deflater deflater;
    private final WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> factory;
    private boolean incomingNoContextTakeover;
    private final Inflater inflater;
    private boolean outgoingNoContextTakeover;
    private final List<WebSocketExtensionHeader> protocols;

    public WebSocketDeflateExtension(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.factory = Companion;
        this.protocols = this.config.build$ktor_websockets();
        this.inflater = new Inflater(true);
        this.deflater = new Deflater(this.config.getCompressionLevel(), true);
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> getFactory() {
        return this.factory;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public List<WebSocketExtensionHeader> getProtocols() {
        return this.protocols;
    }

    public final boolean getOutgoingNoContextTakeover$ktor_websockets() {
        return this.outgoingNoContextTakeover;
    }

    public final void setOutgoingNoContextTakeover$ktor_websockets(boolean z) {
        this.outgoingNoContextTakeover = z;
    }

    public final boolean getIncomingNoContextTakeover$ktor_websockets() {
        return this.incomingNoContextTakeover;
    }

    public final void setIncomingNoContextTakeover$ktor_websockets(boolean z) {
        this.incomingNoContextTakeover = z;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public boolean clientNegotiation(List<WebSocketExtensionHeader> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "negotiatedProtocols");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            WebSocketExtensionHeader it2 = (WebSocketExtensionHeader) obj;
            if (Intrinsics.areEqual(it2.getName(), "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader protocol = (WebSocketExtensionHeader) obj;
        if (protocol == null) {
            return false;
        }
        this.incomingNoContextTakeover = this.config.getServerNoContextTakeOver();
        this.outgoingNoContextTakeover = this.config.getClientNoContextTakeOver();
        Iterator it3 = protocol.parseParameters().iterator();
        while (true) {
            if (it3.hasNext()) {
                Pair pair = (Pair) it3.next();
                String key2 = (String) pair.component1();
                String value = (String) pair.component2();
                switch (key2.hashCode()) {
                    case -708713803:
                        if (!key2.equals("client_no_context_takeover")) {
                            continue;
                        } else if (!StringsKt.isBlank(value)) {
                            throw new IllegalStateException(("WebSocket permessage-deflate extension parameter client_no_context_takeover shouldn't have a value. Current: " + value).toString());
                        } else {
                            this.outgoingNoContextTakeover = true;
                            break;
                        }
                    case 646404390:
                        if (key2.equals("client_max_window_bits") && !StringsKt.isBlank(value)) {
                            if (Integer.parseInt(value) == 15) {
                                break;
                            } else {
                                throw new IllegalStateException("Only 15 window size is supported.".toString());
                            }
                        }
                        break;
                    case 1266201133:
                        if (!key2.equals("server_no_context_takeover")) {
                            continue;
                        } else if (!StringsKt.isBlank(value)) {
                            throw new IllegalStateException(("WebSocket permessage-deflate extension parameter server_no_context_takeover shouldn't have a value. Current: " + value).toString());
                        } else {
                            this.incomingNoContextTakeover = true;
                            break;
                        }
                    case 2034279582:
                        key2.equals("server_max_window_bits");
                        break;
                }
            } else {
                return true;
            }
        }
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public List<WebSocketExtensionHeader> serverNegotiation(List<WebSocketExtensionHeader> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "requestedProtocols");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            WebSocketExtensionHeader it2 = (WebSocketExtensionHeader) obj;
            if (Intrinsics.areEqual(it2.getName(), "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader protocol = (WebSocketExtensionHeader) obj;
        if (protocol == null) {
            return CollectionsKt.emptyList();
        }
        List parameters = new ArrayList();
        Iterator it3 = protocol.parseParameters().iterator();
        while (it3.hasNext()) {
            Pair pair = (Pair) it3.next();
            String key2 = (String) pair.component1();
            String value = (String) pair.component2();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = key2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -708713803:
                    if (lowerCase.equals("client_no_context_takeover")) {
                        if (!StringsKt.isBlank(value)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        this.incomingNoContextTakeover = true;
                        parameters.add("client_no_context_takeover");
                        break;
                    } else {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + key2 + ", " + value + ')').toString());
                    }
                case 646404390:
                    if (lowerCase.equals("client_max_window_bits")) {
                        break;
                    } else {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + key2 + ", " + value + ')').toString());
                    }
                case 1266201133:
                    if (lowerCase.equals("server_no_context_takeover")) {
                        if (!StringsKt.isBlank(value)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        this.outgoingNoContextTakeover = true;
                        parameters.add("server_no_context_takeover");
                        break;
                    } else {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + key2 + ", " + value + ')').toString());
                    }
                case 2034279582:
                    if (lowerCase.equals("server_max_window_bits")) {
                        if (Integer.parseInt(value) == 15) {
                            break;
                        } else {
                            throw new IllegalStateException("Only 15 window size is supported".toString());
                        }
                    } else {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + key2 + ", " + value + ')').toString());
                    }
                default:
                    throw new IllegalStateException(("Unsupported extension parameter: (" + key2 + ", " + value + ')').toString());
            }
        }
        return CollectionsKt.listOf(new WebSocketExtensionHeader("permessage-deflate", parameters));
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public Frame processOutgoingFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if (((frame instanceof Frame.Text) || (frame instanceof Frame.Binary)) && ((Boolean) this.config.getCompressCondition$ktor_websockets().invoke(frame)).booleanValue()) {
            byte[] deflated = DeflaterUtilsKt.deflateFully(this.deflater, frame.getData());
            if (this.outgoingNoContextTakeover) {
                this.deflater.reset();
            }
            return Frame.Companion.byType(frame.getFin(), frame.getFrameType(), deflated, rsv1, frame.getRsv2(), frame.getRsv3());
        }
        return frame;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public Frame processIncomingFrame(Frame frame) {
        boolean isCompressed;
        Intrinsics.checkNotNullParameter(frame, "frame");
        isCompressed = WebSocketDeflateExtensionKt.isCompressed(frame);
        if (isCompressed || this.decompressIncoming) {
            this.decompressIncoming = true;
            byte[] inflated = DeflaterUtilsKt.inflateFully(this.inflater, frame.getData());
            if (this.incomingNoContextTakeover) {
                this.inflater.reset();
            }
            if (frame.getFin()) {
                this.decompressIncoming = false;
            }
            return Frame.Companion.byType(frame.getFin(), frame.getFrameType(), inflated, !rsv1, frame.getRsv2(), frame.getRsv3());
        }
        return frame;
    }

    /* compiled from: WebSocketDeflateExtension.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\f\u001a\u00020\n2'\u0010\u000b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0011\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0015R4\u0010(\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\n0\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\rR.\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+\"\u0004\b/\u0010\r¨\u00060"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Config;", Column.INVAL_VALUE, "<init>", "()V", "Lkotlin/Function1;", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtensionHeader;", "Lkotlin/ParameterName;", "name", "protocols", Column.INVAL_VALUE, "block", "configureProtocols", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/websocket/Frame;", "frame", Column.INVAL_VALUE, "compressIf", Column.INVAL_VALUE, "bytes", "compressIfBiggerThan", "(I)V", Column.INVAL_VALUE, "build$ktor_websockets", "()Ljava/util/List;", "build", "clientNoContextTakeOver", "Z", "getClientNoContextTakeOver", "()Z", "setClientNoContextTakeOver", "(Z)V", "serverNoContextTakeOver", "getServerNoContextTakeOver", "setServerNoContextTakeOver", "compressionLevel", "I", "getCompressionLevel", "()I", "setCompressionLevel", "manualConfig", "Lkotlin/jvm/functions/Function1;", "getManualConfig$ktor_websockets", "()Lkotlin/jvm/functions/Function1;", "setManualConfig$ktor_websockets", "compressCondition", "getCompressCondition$ktor_websockets", "setCompressCondition$ktor_websockets", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class Config {
        private boolean clientNoContextTakeOver;
        private boolean serverNoContextTakeOver;
        private int compressionLevel = -1;
        private Function1<? super List<WebSocketExtensionHeader>, Unit> manualConfig = new Function1() { // from class: io.ktor.websocket.WebSocketDeflateExtension$Config$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit manualConfig$lambda$0;
                manualConfig$lambda$0 = WebSocketDeflateExtension.Config.manualConfig$lambda$0((List) obj);
                return manualConfig$lambda$0;
            }
        };
        private Function1<? super Frame, Boolean> compressCondition = new Function1() { // from class: io.ktor.websocket.WebSocketDeflateExtension$Config$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean compressCondition$lambda$1;
                compressCondition$lambda$1 = WebSocketDeflateExtension.Config.compressCondition$lambda$1((Frame) obj);
                return Boolean.valueOf(compressCondition$lambda$1);
            }
        };

        public final boolean getClientNoContextTakeOver() {
            return this.clientNoContextTakeOver;
        }

        public final void setClientNoContextTakeOver(boolean z) {
            this.clientNoContextTakeOver = z;
        }

        public final boolean getServerNoContextTakeOver() {
            return this.serverNoContextTakeOver;
        }

        public final void setServerNoContextTakeOver(boolean z) {
            this.serverNoContextTakeOver = z;
        }

        public final int getCompressionLevel() {
            return this.compressionLevel;
        }

        public final void setCompressionLevel(int i) {
            this.compressionLevel = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit manualConfig$lambda$0(List it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        public final Function1<List<WebSocketExtensionHeader>, Unit> getManualConfig$ktor_websockets() {
            return this.manualConfig;
        }

        public final void setManualConfig$ktor_websockets(Function1<? super List<WebSocketExtensionHeader>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.manualConfig = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressCondition$lambda$1(Frame it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return true;
        }

        public final Function1<Frame, Boolean> getCompressCondition$ktor_websockets() {
            return this.compressCondition;
        }

        public final void setCompressCondition$ktor_websockets(Function1<? super Frame, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.compressCondition = function1;
        }

        public final void configureProtocols(final Function1<? super List<WebSocketExtensionHeader>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            final Function1 old = this.manualConfig;
            this.manualConfig = new Function1() { // from class: io.ktor.websocket.WebSocketDeflateExtension$Config$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit configureProtocols$lambda$2;
                    configureProtocols$lambda$2 = WebSocketDeflateExtension.Config.configureProtocols$lambda$2(old, function1, (List) obj);
                    return configureProtocols$lambda$2;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit configureProtocols$lambda$2(Function1 $old, Function1 $block, List it) {
            Intrinsics.checkNotNullParameter(it, "it");
            $old.invoke(it);
            $block.invoke(it);
            return Unit.INSTANCE;
        }

        public final void compressIf(final Function1<? super Frame, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            final Function1 old = this.compressCondition;
            this.compressCondition = new Function1() { // from class: io.ktor.websocket.WebSocketDeflateExtension$Config$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    boolean compressIf$lambda$3;
                    compressIf$lambda$3 = WebSocketDeflateExtension.Config.compressIf$lambda$3(function1, old, (Frame) obj);
                    return Boolean.valueOf(compressIf$lambda$3);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressIf$lambda$3(Function1 $block, Function1 $old, Frame it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return ((Boolean) $block.invoke(it)).booleanValue() && ((Boolean) $old.invoke(it)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressIfBiggerThan$lambda$4(int $bytes, Frame frame) {
            Intrinsics.checkNotNullParameter(frame, "frame");
            return frame.getData().length > $bytes;
        }

        public final void compressIfBiggerThan(final int bytes) {
            compressIf(new Function1() { // from class: io.ktor.websocket.WebSocketDeflateExtension$Config$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    boolean compressIfBiggerThan$lambda$4;
                    compressIfBiggerThan$lambda$4 = WebSocketDeflateExtension.Config.compressIfBiggerThan$lambda$4(bytes, (Frame) obj);
                    return Boolean.valueOf(compressIfBiggerThan$lambda$4);
                }
            });
        }

        public final List<WebSocketExtensionHeader> build$ktor_websockets() {
            List result = new ArrayList();
            List parameters = new ArrayList();
            if (this.clientNoContextTakeOver) {
                parameters.add("client_no_context_takeover");
            }
            if (this.serverNoContextTakeOver) {
                parameters.add("server_no_context_takeover");
            }
            result.add(new WebSocketExtensionHeader("permessage-deflate", parameters));
            this.manualConfig.invoke(result);
            return result;
        }
    }

    /* compiled from: WebSocketDeflateExtension.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Companion;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketDeflateExtension;", "<init>", "()V", "Lkotlin/Function1;", Column.INVAL_VALUE, "Lkotlin/ExtensionFunctionType;", "config", "install", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", Column.INVAL_VALUE, "rsv1", "Z", "getRsv1", "()Z", "rsv2", "getRsv2", "rsv3", "getRsv3", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class Companion implements WebSocketExtensionFactory<Config, WebSocketDeflateExtension> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public AttributeKey<WebSocketDeflateExtension> getKey() {
            return WebSocketDeflateExtension.key;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv1() {
            return WebSocketDeflateExtension.rsv1;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv2() {
            return WebSocketDeflateExtension.rsv2;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv3() {
            return WebSocketDeflateExtension.rsv3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public WebSocketDeflateExtension install(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "config");
            Config config = new Config();
            function1.invoke(config);
            return new WebSocketDeflateExtension(config);
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WebSocketDeflateExtension.class);
        try {
            kType = Reflection.typeOf(WebSocketDeflateExtension.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("WebsocketDeflateExtension", new TypeInfo(orCreateKotlinClass, kType));
        rsv1 = true;
    }
}