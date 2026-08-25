/*----------------------------------------------------------
 * 演習番号    ：仕様書演習
 * クラス名    ：DBProperties
 * 作成日      ：2026/06/17
 * 作成者      ：tarou/SYS
 *----------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *----------------------------------------------------------
 */
package sample.config;

import java.util.Properties;

/**
 * java.util.Properties からDB接続情報を取得するためのクラス
 * @author tarou/SYS 2026/06/17
 */
public class DBProperties {

    /**
     * プロパティのキー server.host
     */
    private static String HOST = "server.host";

    /**
     * プロパティのキー server.host
     */
    private static String PORT = "server.port";

    /**
     * プロパティのキー server.host
     */
    private static String DB_NAME = "db.name";

    /**
     * プロパティのキー server.host
     */
    private static String URL = "jdbc.url";

    /**
     * プロパティのキー server.host
     */
    private static String USER = "jdbc.user";

    /**
     * プロパティのキー server.host
     */
    private static String PASS = "jdbc.pass";

    /**
     * プロパティ
     */
    private static Properties properties;

    /**
     * コンストラクタ
     * 外部クラスでインスタンス化できないよう、private で宣言
     */
    private DBProperties() {}

    /**
     * 初期化
     * @param props DB接続情報を定義したプロパティ
     */
    public static void initialize(Properties props) {
        properties = props;
    }

    /**
     * 設定値取得
     * @param key キー
     * @return 設定値
     */
    private static String getProperty(String key) {
        if (properties == null) {
            throw new IllegalStateException("DBPropertiesが初期化されていません。");
        }
        return properties.getProperty(key);
    }

    /**
     * JDBC URL 取得
     * @return JDBC URL
     */
    public static String url() {
        return String.format(
                getProperty(URL),
                getProperty(HOST),
                getProperty(PORT),
                getProperty(DB_NAME));
    }

    /**
     * DB ユーザ名 取得
     * @return DB ユーザ名
     */
    public static String user() {
        return getProperty(USER);
    }

    /**
     * DB ユーザのパスワード 取得
     * @return DB ユーザのパスワード
     */
    public static String pass() {
        return getProperty(PASS);
    }

}
