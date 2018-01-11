package com.collectrouter.big5.portrait;

/**
 * Created by apple on 18/1/10.
 */

public class TagDef {
    public static int TAG_BABY = 1; // 宝宝
    public static int TAG_PARENT = 2; // 父母
    public static int TAG_HOUSE = 3; // 房产
    public static int TAG_SPORTS = 4; // 体育
    public static int TAG_3C = 5; // 3C 数码
    public static int TAG_OFFICE = 6; // 办公
    public static int TAG_QUALITY_HIGH = 7; // 高品质 (米家有品，网易严选)
    public static int TAG_QUALITY_LUXURY = 8; // 奢侈品质
    public static int TAG_QUALITY_CHEAP = 9; // 低价品质 (拼多多，网易严选)
    public static int TAG_MAN = 11; // 男人
    public static int TAG_WOMAN = 12; // 女人
    public static int TAG_PET_ANIMAL = 13; // 宠物
    public static int TAG_AGE_YOUNG = 20; // 年轻
    public static int TAG_AGE_MIDDLE = 21; // 中年
    public static int TAG_AGE_OLD = 22; // 老年
    public static int TAG_DOCTOR = 30; // 医生，药物
    public static int TAG_READER = 40; // 读者，书籍
    public static int TAG_MUSIC = 41; // 音乐
    public static int TAG_VIDEO = 42; // 视频
    public static int TAG_TRAFFIC = 43; // 旅行
    public static int TAG_HOTEL = 44; // 酒店
    public static int TAG_AGRICULTURE = 45; // 农业
    public static int TAG_FINANCE = 46; // 金融
    public static int TAG_SHOP_ONLINE = 47; // 线上购物
    public static int TAG_EDUCATION = 48; // 教育
    public static int TAG_GAME = 49; // 游戏
    public static int TAG_DEVELOPER = 50; // 开发
    public static int TAG_MAKE_FRIENDS = 51; // 交友社交
    public static int TAG_COMIC = 52; // 动漫
    public static int TAG_LIVE_SHOW = 53; // 直播
    public static int TAG_APP_MARKET = 54; // 应用市场
    public static int TAG_SHORT_VIDEO = 55; // 短视频
    public static int TAG_CAMERA = 56; // 相机


    public static String id2TagStr( int id ) {
        switch (id) {
            case 1:
                return "宝宝";
            case 2:
                return "父母";
            case 3:
                return "房产";
            case 4:
                return "体育";
            case 5:
                return "数码";
            case 6:
                return "办公";
            case 7:
                return "高品质 (米家有品，网易严选)";
            case 8:
                return "奢侈品质";
            case 9:
                return "低价品质 (拼多多)";
            case 11:
                return "男人";
            case 12:
                return "女人";
            case 13:
                return "宠物";
            case 20:
                return "年轻";
            case 21:
                return "中年";
            case 22:
                return "老年";
            case 30:
                return "医生，药物";
            case 40:
                return "读者，书籍";
            case 41:
                return "音乐";
            case 42:
                return "视频";
            case 43:
                return "旅行";
            case 44:
                return "酒店";
            case 45:
                return "农业";
            case 46:
                return "金融";
            case 47:
                return "线上购物";
            case 48:
                return "教育";
            case 49:
                return "游戏";
            case 50:
                return "开发";
            case 51:
                return "交友社交";
            case 52:
                return "动漫";
            case 53:
                return "直播";
            case 54:
                return "应用市场";
            case 55:
                return "短视频";
            case 56:
                return "相机";
            default:
                return "";
        }
    }

}
