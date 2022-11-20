package kotlinx.dbc

/**
 * Interface of Kotlin DBC driver
 *
 * Each driver should supply a class that implements the Driver interface.
 *
 * The DriverManager will try to load as many drivers as it can find and then for any given connection request,
 * it will ask each driver in turn to try to connect to the target URL.
 */
interface Driver {
    /**
     * Name of driver
     */
    val name: String

    /**
     *  Semver version of a driver. Format like: [1, 0, 0]
     *
     *  More information: https://semver.org/
     */
    val version: IntArray

    /**
     * Create connection with database
     * @param params List of arbitrary string tag/value pairs as connection arguments; normally at least a "user" and "password" property should be included
     */
    fun connect(params: Map<String, Any?>): Connection
}