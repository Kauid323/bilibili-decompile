package io.ktor.util;

import com.bilibili.playset.playlist.adapters.FavoritesConstsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HashFunction.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0018¨\u0006!"}, d2 = {"Lio/ktor/util/Sha1;", "Lio/ktor/util/HashFunction;", "<init>", "()V", "", "input", "", "offset", "length", "", "update", "([BII)V", FavoritesConstsKt.POS, "processChunk", "([BI)V", "digest", "()[B", "reset", "", "messageLength", "J", "unprocessed", "[B", "unprocessedLimit", "I", "", "words", "[I", "h0", "h1", "h2", "h3", "h4", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Sha1 implements HashFunction {
    private long messageLength;
    private int unprocessedLimit;
    private final byte[] unprocessed = new byte[64];
    private final int[] words = new int[80];
    private int h0 = 1732584193;
    private int h1 = -271733879;
    private int h2 = -1732584194;
    private int h3 = 271733878;
    private int h4 = -1009589776;

    @Override // io.ktor.util.HashFunction
    public void update(byte[] input, int offset, int length) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.messageLength += length;
        int pos = offset;
        int limit = pos + length;
        byte[] unprocessed = this.unprocessed;
        int unprocessedLimit = this.unprocessedLimit;
        if (unprocessedLimit > 0) {
            if (unprocessedLimit + length < 64) {
                ArraysKt.copyInto(input, unprocessed, unprocessedLimit, pos, limit);
                this.unprocessedLimit = unprocessedLimit + length;
                return;
            }
            int consumeByteCount = 64 - unprocessedLimit;
            ArraysKt.copyInto(input, unprocessed, unprocessedLimit, pos, pos + consumeByteCount);
            processChunk(unprocessed, 0);
            this.unprocessedLimit = 0;
            pos += consumeByteCount;
        }
        while (pos < limit) {
            int nextPos = pos + 64;
            if (nextPos > limit) {
                ArraysKt.copyInto(input, unprocessed, 0, pos, limit);
                this.unprocessedLimit = limit - pos;
                return;
            }
            processChunk(input, pos);
            pos = nextPos;
        }
    }

    private final void processChunk(byte[] input, int pos) {
        int leftRotate;
        int i;
        int i2;
        int leftRotate2;
        int leftRotate3;
        int leftRotate4;
        int leftRotate5;
        int[] words = this.words;
        int currentPosition = pos;
        int w = 0;
        while (w < 16) {
            int currentPosition2 = currentPosition + 1;
            int currentPosition3 = currentPosition2 + 1;
            int currentPosition4 = currentPosition3 + 1;
            words[w] = ((input[currentPosition] & 255) << 24) | ((input[currentPosition2] & 255) << 16) | ((input[currentPosition3] & 255) << 8) | (input[currentPosition4] & 255);
            w++;
            currentPosition = currentPosition4 + 1;
        }
        for (int w2 = 16; w2 < 80; w2++) {
            leftRotate5 = HashFunctionKt.leftRotate(((words[w2 - 3] ^ words[w2 - 8]) ^ words[w2 - 14]) ^ words[w2 - 16], 1);
            words[w2] = leftRotate5;
        }
        int a = this.h0;
        int b = this.h1;
        int c = this.h2;
        int d = this.h3;
        int e = this.h4;
        for (int i3 = 0; i3 < 80; i3++) {
            if (i3 < 20) {
                int f = ((c ^ d) & b) ^ d;
                leftRotate4 = HashFunctionKt.leftRotate(a, 5);
                i = leftRotate4 + f + e + 1518500249;
                i2 = words[i3];
            } else if (i3 < 40) {
                int f2 = (b ^ c) ^ d;
                leftRotate3 = HashFunctionKt.leftRotate(a, 5);
                i = leftRotate3 + f2 + e + 1859775393;
                i2 = words[i3];
            } else if (i3 < 60) {
                int f3 = (b & c) | (b & d) | (c & d);
                leftRotate2 = HashFunctionKt.leftRotate(a, 5);
                i = ((leftRotate2 + f3) + e) - 1894007588;
                i2 = words[i3];
            } else {
                int f4 = (b ^ c) ^ d;
                leftRotate = HashFunctionKt.leftRotate(a, 5);
                i = ((leftRotate + f4) + e) - 899497514;
                i2 = words[i3];
            }
            int a2 = i + i2;
            e = d;
            d = c;
            c = HashFunctionKt.leftRotate(b, 30);
            b = a;
            a = a2;
        }
        this.h0 += a;
        this.h1 += b;
        this.h2 += c;
        this.h3 += d;
        this.h4 += e;
    }

    @Override // io.ktor.util.HashFunction
    public byte[] digest() {
        byte[] unprocessed = this.unprocessed;
        int unprocessedLimit = this.unprocessedLimit;
        long messageLengthBits = this.messageLength * 8;
        int unprocessedLimit2 = unprocessedLimit + 1;
        unprocessed[unprocessedLimit] = Byte.MIN_VALUE;
        if (unprocessedLimit2 > 56) {
            ArraysKt.fill(unprocessed, (byte) 0, unprocessedLimit2, 64);
            processChunk(unprocessed, 0);
            ArraysKt.fill(unprocessed, (byte) 0, 0, unprocessedLimit2);
        } else {
            ArraysKt.fill(unprocessed, (byte) 0, unprocessedLimit2, 56);
        }
        unprocessed[56] = (byte) (messageLengthBits >>> 56);
        unprocessed[57] = (byte) (messageLengthBits >>> 48);
        unprocessed[58] = (byte) (messageLengthBits >>> 40);
        unprocessed[59] = (byte) (messageLengthBits >>> 32);
        unprocessed[60] = (byte) (messageLengthBits >>> 24);
        unprocessed[61] = (byte) (messageLengthBits >>> 16);
        unprocessed[62] = (byte) (messageLengthBits >>> 8);
        unprocessed[63] = (byte) messageLengthBits;
        processChunk(unprocessed, 0);
        int a = this.h0;
        int b = this.h1;
        int c = this.h2;
        int d = this.h3;
        int e = this.h4;
        reset();
        return new byte[]{(byte) (a >> 24), (byte) (a >> 16), (byte) (a >> 8), (byte) a, (byte) (b >> 24), (byte) (b >> 16), (byte) (b >> 8), (byte) b, (byte) (c >> 24), (byte) (c >> 16), (byte) (c >> 8), (byte) c, (byte) (d >> 24), (byte) (d >> 16), (byte) (d >> 8), (byte) d, (byte) (e >> 24), (byte) (e >> 16), (byte) (e >> 8), (byte) e};
    }

    private final void reset() {
        this.messageLength = 0L;
        ArraysKt.fill$default(this.unprocessed, (byte) 0, 0, 0, 6, (Object) null);
        this.unprocessedLimit = 0;
        ArraysKt.fill$default(this.words, 0, 0, 0, 6, (Object) null);
        this.h0 = 1732584193;
        this.h1 = -271733879;
        this.h2 = -1732584194;
        this.h3 = 271733878;
        this.h4 = -1009589776;
    }
}