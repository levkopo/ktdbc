package kotlinx.dbc

interface Statement: Closeable {
    fun execute(): ResultSet
    fun executeUpdate()
}