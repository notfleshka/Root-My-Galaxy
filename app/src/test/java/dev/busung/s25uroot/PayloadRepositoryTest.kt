package dev.busung.s25uroot

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Test

class PayloadRepositoryTest {
    @Test
    fun pinArtifactUrlAcceptsLegacyAndCurrentRawRepositories() {
        val repository = PayloadRepository(null as Context)
        val method = PayloadRepository::class.java.getDeclaredMethod(
            "pinArtifactUrl",
            String::class.java,
            String::class.java,
        )
        method.isAccessible = true

        val legacyUrl = method.invoke(
            repository,
            "https://raw.githubusercontent.com/BuSung-dev/Root-My-Galaxy-Payloads/main/artifacts/example.so",
            "deadbeef",
        ) as String
        assertEquals(
            "https://raw.githubusercontent.com/notfleshka/Root-My-Galaxy-Payloads-sm921b/deadbeef/artifacts/example.so",
            legacyUrl,
        )

        val currentUrl = method.invoke(
            repository,
            "https://raw.githubusercontent.com/notfleshka/Root-My-Galaxy-Payloads-sm921b/main/artifacts/example.so",
            "deadbeef",
        ) as String
        assertEquals(
            "https://raw.githubusercontent.com/notfleshka/Root-My-Galaxy-Payloads-sm921b/deadbeef/artifacts/example.so",
            currentUrl,
        )
    }
}
