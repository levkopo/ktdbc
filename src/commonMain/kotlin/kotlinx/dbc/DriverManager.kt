package kotlinx.dbc

import kotlinx.dbc.exceptions.SQLException

/**
 * Manager of drivers and connections.
 * Can create connection and register Drivers
 */
object DriverManager {
    /***
     * Parameter name of database host in driver params
     */
    const val PARAMS_HOST = "host"


    /***
     * Parameter name of database user in driver params
     */
    const val PARAMS_USER = "user"

    /***
     * Parameter name of database user password in driver params
     */
    const val PARAMS_PASSWORD = "password"

    /***
     * Parameter name of database name in driver params
     */
    const val PARAMS_DATABASE = "database"

    /***
     * Parameter name of database port in driver params
     */
    const val PARAMS_PORT = "port"

    /***
     * Container of drivers
     */
    private val drivers = HashMap<String, Driver>()

    /**
     * Register new Driver.
     *
     * If driver with same registered throws [kotlinx.dbc.exceptions.SQLException]
     *
     * @throws [kotlinx.dbc.exceptions.SQLException]
     * @param driver Driver for registration
     */
    fun register(driver: Driver) {
        if(drivers.containsKey(driver.name)) {
            throw SQLException("Driver ${driver.name} already registered")
        }

        drivers[driver.name] = driver
    }

    /**
     *
     * If database driver not found throws [kotlinx.dbc.exceptions.SQLException]
     *
     * @throws [kotlinx.dbc.exceptions.SQLException]
     * @param name Database driver name
     * @param params List of arbitrary string tag/value pairs as connection arguments; normally at least a "user" and "password" property should be included
     */
    fun findDriverByName(name: String): Driver = drivers[name] ?:
        throw SQLException(
            "Driver $name not registered. Please register driver for connect." +
                    "https://github.com/levkopo/ktdbc/blob/master/drivers.md"
        )


    /**
     * Creates connection with database by name and params
     *
     * If database driver not found throws [kotlinx.dbc.exceptions.SQLException]
     *
     * @throws [kotlinx.dbc.exceptions.SQLException]
     * @param name Database driver name
     * @param params List of arbitrary string tag/value pairs as connection arguments; normally at least a "user" and "password" property should be included
     */
    fun connect(name: String, params: Map<String, Any?>): Connection =
        findDriverByName(name).connect(params)

    /**
     * Creates connection with database
     *
     * If database driver not found throws [kotlinx.dbc.exceptions.SQLException]
     *
     * @throws [kotlinx.dbc.exceptions.SQLException]
     * @param name Database driver name
     * @param host Host of database
     * @param user User of database
     * @param password Password of database user
     * @param database Database name
     * @param port Port of database
     * @param params List of arbitrary string tag/value pairs as connection arguments; normally at least a "user" and "password" property should be included
     */
    fun connect(
        name: String,
        host: String,
        user: String? = null,
        password: String? = null,
        database: String? = null,
        port: Int = 3306,
        params: Map<String, Any?> = emptyMap()
    ): Connection {
        val driver = findDriverByName(name)
        val connectionParams: HashMap<String, Any?> = hashMapOf(
            PARAMS_HOST to host,
            PARAMS_USER to user,
            PARAMS_PASSWORD to password,
            PARAMS_DATABASE to database,
            PARAMS_PORT to port
        )

        connectionParams.putAll(params)
        return driver.connect(params)
    }
}