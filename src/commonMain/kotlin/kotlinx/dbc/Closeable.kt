package kotlinx.dbc

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

interface Closeable {
    /***
     * Closes current class
     */
    fun close()

    companion object {
        @OptIn(ExperimentalContracts::class)
        inline fun <T: Closeable?, R> T.use(block: (T) -> R): R {
            contract {
                callsInPlace(block, InvocationKind.EXACTLY_ONCE)
            }

            var exception: Throwable? = null
            try {
                return block(this)
            } catch (e: Throwable) {
                exception = e
                throw e
            } finally {
                when {
                    this == null -> {}
                    exception == null -> close()
                    else ->
                        try {
                            close()
                        } catch (_: Throwable) {}
                }
            }
        }
    }
}