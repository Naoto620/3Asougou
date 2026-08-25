/*----------------------------------------------------------
 * 演習番号    ：仕様書演習
 * クラス名    ：SampleSystemException
 * 作成日      ：2026/06/17
 * 作成者      ：tarou/SYS
 *----------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *----------------------------------------------------------
 */

package sample.exception;

/**
 * システム例外クラス
 * @author tarou/SYS 2026/06/17
 */
public class SampleSystemException extends Exception {

    /**
     * 指定された詳細メッセージおよび原因を使用して新規例外を構築する。
     * @param message 詳細メッセージ(あとでThrowable.getMessage()メソッドで取得できるように保存される)。
     * @param cause 原因(あとでThrowable.getCause()メソッドで取得できるように保存される)。
     * (null値が許可されており、原因が存在しないか不明であることを示す。)
     */
    public SampleSystemException(String message, Throwable cause) {
        super();
    }

}
