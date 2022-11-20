package kotlinx.dbc

interface Connection: Closeable {
    fun createStatement(sql: String): Statement
}