package kotlinx.dbc

/**
 * Provides Statement API
 * Can execute statement
 */
interface Statement: Closeable {
    /**
     * Executes all type statements
     */
    fun execute(): ResultSet

    /**
     * Executes INSERT, UPDATE, DELETE statements
     * @return Successful of update
     */
    fun executeUpdate(): Int
}