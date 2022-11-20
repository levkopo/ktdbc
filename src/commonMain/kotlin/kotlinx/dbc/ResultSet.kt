package kotlinx.dbc

interface ResultSet: Closeable {
    fun next(): Boolean
    fun getObject(columnIndex: Int): Any
    fun getString(columnIndex: Int): String
    fun getInt(columnIndex: Int): Int
    fun getLong(columnIndex: Int): Long
    fun findColumn(columnIndex: String): Int
}