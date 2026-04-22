package cmbapi;

public class b {
    private static int a = 8;
    private static int b = 10;

    /* renamed from: c  reason: collision with root package name */
    private static String f131c = "用户主动取消";

    public static int a() {
        return a;
    }

    public static void a(String str, String str2) {
        try {
            f131c = str2;
            a = Integer.parseInt(str);
        } catch (Exception e) {
            f131c = "业务处理结果未知，响应码为空或格式不正确：" + a;
            a = b;
        }
    }

    public static String b() {
        return f131c;
    }
}