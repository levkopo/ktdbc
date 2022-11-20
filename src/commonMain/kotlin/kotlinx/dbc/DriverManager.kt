package kotlinx.dbc

import kotlinx.dbc.exceptions.SQLException

object DriverManager {
    private val drivers = HashMap<String, Driver>()

    /***
     * Register new Driver.
     *
     * If driver with same registered throws [kotlinx.dbc.exceptions.SQLException]
     */
    @Throws(SQLException::class)
    fun register(driver: Driver) {
        if(drivers.containsKey(driver.name)) {
            throw SQLException("Driver ${driver.name} already registered")
        }

        drivers[driver.name] = driver
    }

    fun connect() {

    }
}