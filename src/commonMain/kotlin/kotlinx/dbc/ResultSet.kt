package kotlinx.dbc

/**
 * Provides set of rows
 * Can fetch row fields
 */
interface ResultSet: Closeable {
    /**
     * Selects next or first row of result.
     * @return Returns true if result have next row
     */
    fun next(): Boolean

    /**
     * Search column index by name
     *
     * @param columnName Name of column
     * @return Column index
     */
    fun findColumn(columnName: String): Int


    /**
     * Get row value by column index
     * @param columnIndex Index of column
     * @return Value
     */
    fun getObject(columnIndex: Int): Any

    /**
     * Get row value by column index
     * @param columnIndex Index of column
     * @return String value
     */
    fun getString(columnIndex: Int): String

    /**
     * Get row value by column index
     * @param columnIndex Index of column
     * @return Int value
     */
    fun getInt(columnIndex: Int): Int

    /**
     * Get row value by column index
     * @param columnIndex Index of column
     * @return Long value
     */
    fun getLong(columnIndex: Int): Long


    /**
     * Get row value by column index
     * @param columnName Name of column
     * @return Value
     */
    fun getObject(columnName: String): Any = getObject(findColumn(columnName))

    /**
     * Get row value by column index
     * @param columnName Name of column
     * @return String value
     */
    fun getString(columnName: String): String = getString(findColumn(columnName))

    /**
     * Get row value by column index
     * @param columnName Name of column
     * @return Int value
     */
    fun getInt(columnName: String): Int = getInt(findColumn(columnName))

    /**
     * Get row value by column index
     * @param columnName Name of column
     * @return Long value
     */
    fun getLong(columnName: String): Long = getLong(findColumn(columnName))
}