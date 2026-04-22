package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import com.antlr4.runtime.TokenStreamRewriter;

/* compiled from: TML */
public class e5 {
    public static final Location a;
    public static boolean b;

    /* renamed from: c  reason: collision with root package name */
    public static String f27c;
    public static boolean d;
    public static boolean e;
    public static final double[][] f;

    static {
        new Bundle();
        a = new Location("EMPTY");
        b = false;
        f27c = TokenStreamRewriter.DEFAULT_PROGRAM_NAME;
        d = false;
        e = false;
        f = new double[][]{new double[]{30.890409d, 121.813668d, 30.89308d, 121.816182d}, new double[]{22.503353d, 113.889982d, 22.505612d, 113.892468d}, new double[]{23.188278d, 113.591922d, 23.192032d, 113.596199d}, new double[]{23.095616d, 113.364039d, 23.098685d, 113.367262d}, new double[]{23.097196d, 113.323394d, 23.101358d, 113.32596d}, new double[]{30.565073d, 103.950759d, 30.582678d, 103.960536d}, new double[]{31.392822d, 121.480144d, 31.397422d, 121.484457d}, new double[]{39.505013d, 116.409053d, 39.515989d, 116.424635d}, new double[]{22.552332d, 114.112813d, 22.554253d, 114.114907d}, new double[]{22.526604d, 113.94933d, 22.533302d, 113.955572d}, new double[]{39.908683d, 116.4557d, 39.915022d, 116.461519d}, new double[]{22.528561d, 114.115866d, 22.534115d, 114.120471d}, new double[]{39.92453d, 116.349056d, 39.927075d, 116.35133d}, new double[]{23.186906d, 113.327496d, 23.188706d, 113.329776d}, new double[]{22.529696d, 114.044635d, 22.544723d, 114.063018d}, new double[]{39.912541d, 116.143179d, 39.926842d, 116.162169d}, new double[]{22.554269d, 113.963161d, 22.558611d, 113.968092d}, new double[]{39.913699d, 116.438645d, 39.916597d, 116.441918d}, new double[]{22.524148d, 113.987094d, 22.52698d, 113.991796d}, new double[]{22.603263d, 114.024504d, 22.614657d, 114.033948d}, new double[]{22.54115d, 114.081066d, 22.544249d, 114.084836d}, new double[]{22.540393d, 113.953626d, 22.543511d, 113.95835d}, new double[]{22.600728d, 114.118237d, 22.60362d, 114.121364d}, new double[]{39.983141d, 116.306366d, 39.985032d, 116.308786d}, new double[]{22.53958d, 113.933567d, 22.541236d, 113.935579d}, new double[]{22.520297d, 113.931086d, 22.530897d, 113.941242d}, new double[]{28.196225d, 112.859495d, 28.201042d, 112.862572d}, new double[]{23.099276d, 113.323694d, 23.100971d, 113.325478d}, new double[]{40.036693d, 116.269755d, 40.043758d, 116.277448d}, new double[]{22.488015d, 113.878459d, 22.571666d, 113.969056d}, new double[]{39.554398d, 116.709114d, 39.57554d, 116.731348d}};
    }

    public static String a(int i, int i2, int i3) {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = com.alipay.sdk.m.h.a.q + (Boolean.parseBoolean(f7.a().get(com.alipay.sdk.m.h.b.a)) ? "s" : "");
        if (d && e) {
            str = str2 + "://lbs.map.iot.wechatpay.cn/loc";
        } else {
            str = str2 + "://lbs.map.qq.com/loc";
        }
        a7.c("NATIVE_TEST", "getUrl fun_d url: " + str);
        sb.append(str);
        sb.append("?");
        sb.append("c=").append(i);
        sb.append(com.alipay.sdk.m.o.a.l).append("mars=").append(i2);
        sb.append(com.alipay.sdk.m.o.a.l).append("obs=").append(i3);
        return sb.toString();
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        Boolean.parseBoolean(f7.a().get(com.alipay.sdk.m.h.b.a));
        String str = g3.g;
        f6.a = str;
        a7.c("getRsaUrl", "url: " + str);
        sb.append(str);
        sb.append("?");
        sb.append("rsa=1");
        sb.append(com.alipay.sdk.m.o.a.l).append("c=1");
        sb.append(com.alipay.sdk.m.o.a.l).append("mars=").append(i);
        a7.c("geoUrl", sb.toString());
        return sb.toString();
    }
}