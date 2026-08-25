/*----------------------------------------------------------
 * 演習番号    ：仕様書演習
 * クラス名    ：ApplicationInitializer
 * 作成日      ：2026/06/17
 * 作成者      ：tarou/SYS
 *----------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *----------------------------------------------------------
 */

package sample.web.initializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import sample.config.DBProperties;

/**
 * WEBアプリ初期化クラス
 *
 * web.xml の context-param で定義したDB接続情報プロパティファイルのパス (dbConfigPath) を用いて、
 * プロパティファイルを読み込み、sample.config.DBProperties に設定する。
 *
 * @author tarou/SYS 2026/06/17
 */
@WebListener
public class ApplicationInitializer implements ServletContextListener {

    /**
     * コンテキストパラメータ DB接続情報設定ファイルパス
     */
    private final static String CONTEXT_PARAM_DB_CONFIG = "dbConfigPath";

    /**
     * コンテキストパラメータ DB接続情報設定ファイルパス
     */
    private final static String CONTEXT_PARAM_DB_CONFIG_WIN = "dbConfigPath_win";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        String configPath = getDbConfigPath(application);

        try (InputStream is = new FileInputStream(configPath)) {

            Properties properties = new Properties();
            properties.load(is);
            DBProperties.initialize(properties);

        } catch (IOException e) {
            String message = "DB接続情報プロパティファイルの読み込みに失敗しました。"
                    + "[" + configPath + "]" ;
            application.log(message, e);
            throw new RuntimeException(message, e);
        }

    }

    private String getDbConfigPath(ServletContext application) {

        String contextParam = CONTEXT_PARAM_DB_CONFIG;

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {
            contextParam = CONTEXT_PARAM_DB_CONFIG_WIN;
        }

        return application.getInitParameter(contextParam);

    }

}
