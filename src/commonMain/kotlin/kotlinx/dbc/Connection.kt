package kotlinx.dbc

/**
 * Database connection interface.
 * Can create statements and change settings of connection
 */
interface Connection: Closeable {

    /**
     * Creating statement by sql
     * @param sql SQL of statement
     */
    fun createStatement(sql: String): Statement
}